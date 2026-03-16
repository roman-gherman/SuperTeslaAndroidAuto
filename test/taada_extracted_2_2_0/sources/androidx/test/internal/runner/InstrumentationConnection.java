package androidx.test.internal.runner;

import B2.b;
import android.app.Instrumentation;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.test.internal.util.Checks;
import androidx.test.internal.util.LogUtil;
import androidx.test.internal.util.ParcelableIBinder;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.MonitoringInstrumentation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class InstrumentationConnection {
    public static final String BROADCAST_FILTER = "androidx.test.runner.InstrumentationConnection.event";
    static final String BUNDLE_BR_NEW_BINDER = "new_instrumentation_binder";
    private static final String BUNDLE_KEY_CLIENTS = "instr_clients";
    private static final String BUNDLE_KEY_CLIENT_MESSENGER = "instr_client_msgr";
    private static final String BUNDLE_KEY_CLIENT_TYPE = "instr_client_type";
    private static final String BUNDLE_KEY_UUID = "instr_uuid";
    private static final InstrumentationConnection DEFAULT_INSTANCE = new InstrumentationConnection(InstrumentationRegistry.getInstrumentation().getTargetContext());
    static final int MSG_ADD_CLIENTS_IN_BUNDLE = 6;
    static final int MSG_ADD_INSTRUMENTATION = 4;
    private static final int MSG_HANDLE_INSTRUMENTATION_FROM_BROADCAST = 3;
    private static final int MSG_PERFORM_CLEANUP = 11;
    private static final int MSG_PERFORM_CLEANUP_FINISHED = 12;
    private static final int MSG_REG_CLIENT = 8;
    private static final int MSG_REMOTE_ADD_CLIENT = 0;
    static final int MSG_REMOTE_CLEANUP_REQUEST = 10;
    private static final int MSG_REMOTE_REMOVE_CLIENT = 1;
    private static final int MSG_REMOVE_CLIENTS_IN_BUNDLE = 7;
    private static final int MSG_REMOVE_INSTRUMENTATION = 5;
    private static final int MSG_TERMINATE = 2;
    private static final int MSG_UN_REG_CLIENT = 9;
    private static final String TAG = "InstrConnection";
    private static MonitoringInstrumentation.ActivityFinisher activityFinisher;
    private static Instrumentation instrumentation;
    IncomingHandler incomingHandler;
    final BroadcastReceiver messengerReceiver = new MessengerReceiver();
    private Context targetContext;

    public static class IncomingHandler extends Handler {
        private final Map<UUID, CountDownLatch> latches;
        Messenger messengerHandler;
        Set<Messenger> otherInstrumentations;
        Map<String, Set<Messenger>> typedClients;

        public IncomingHandler(Looper looper) {
            super(looper);
            this.messengerHandler = new Messenger(this);
            this.otherInstrumentations = new HashSet();
            this.typedClients = new HashMap();
            this.latches = new HashMap();
            if (Looper.getMainLooper() == looper || Looper.myLooper() == looper) {
                throw new IllegalStateException("This handler should not be using the main thread looper nor the instrumentation thread looper.");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void associateLatch(final UUID uuid, final CountDownLatch countDownLatch) {
            runSyncTask(new Callable<Void>() { // from class: androidx.test.internal.runner.InstrumentationConnection.IncomingHandler.1
                @Override // java.util.concurrent.Callable
                public Void call() {
                    IncomingHandler.this.latches.put(uuid, countDownLatch);
                    return null;
                }
            });
        }

        private void clientsRegistrationFromBundle(Bundle bundle, boolean z6) {
            LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "clientsRegistrationFromBundle called", new Object[0]);
            if (bundle == null) {
                Log.w(InstrumentationConnection.TAG, "The client bundle is null, ignoring...");
                return;
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(InstrumentationConnection.BUNDLE_KEY_CLIENTS);
            if (stringArrayList == null) {
                Log.w(InstrumentationConnection.TAG, "No clients found in the given bundle");
                return;
            }
            for (String str : stringArrayList) {
                Parcelable[] parcelableArray = bundle.getParcelableArray(String.valueOf(str));
                if (parcelableArray != null) {
                    for (Parcelable parcelable : parcelableArray) {
                        if (z6) {
                            registerClient(str, (Messenger) parcelable);
                        } else {
                            unregisterClient(str, (Messenger) parcelable);
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void disassociateLatch(final UUID uuid) {
            runSyncTask(new Callable<Void>() { // from class: androidx.test.internal.runner.InstrumentationConnection.IncomingHandler.2
                @Override // java.util.concurrent.Callable
                public Void call() {
                    IncomingHandler.this.latches.remove(uuid);
                    return null;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doDie() {
            sendMessageToOtherInstr(5, null);
            this.otherInstrumentations.clear();
            this.typedClients.clear();
            LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "quitting looper...", new Object[0]);
            getLooper().quit();
            LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "finishing instrumentation...", new Object[0]);
            InstrumentationConnection.instrumentation.finish(0, null);
            InstrumentationConnection.instrumentation = null;
            InstrumentationConnection.activityFinisher = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Set<Messenger> getClientsForType(final String str) {
            FutureTask futureTask = new FutureTask(new Callable<Set<Messenger>>() { // from class: androidx.test.internal.runner.InstrumentationConnection.IncomingHandler.3
                @Override // java.util.concurrent.Callable
                public Set<Messenger> call() {
                    return IncomingHandler.this.typedClients.get(str);
                }
            });
            post(futureTask);
            try {
                return (Set) futureTask.get();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            } catch (ExecutionException e6) {
                throw new IllegalStateException(e6.getCause());
            }
        }

        private void instrBinderDied(Messenger messenger) {
            Message messageObtainMessage = obtainMessage(5);
            messageObtainMessage.replyTo = messenger;
            sendMessage(messageObtainMessage);
        }

        private void notifyLatch(UUID uuid) {
            if (uuid == null || !this.latches.containsKey(uuid)) {
                Log.w(InstrumentationConnection.TAG, "Latch not found ".concat(String.valueOf(uuid)));
            } else {
                this.latches.get(uuid).countDown();
            }
        }

        private void registerClient(String str, Messenger messenger) {
            LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "registerClient called with type = [%s] client = [%s]", str, messenger);
            Checks.checkNotNull(str, "type cannot be null!");
            Checks.checkNotNull(messenger, "client cannot be null!");
            Set<Messenger> set = this.typedClients.get(str);
            if (set != null) {
                set.add(messenger);
                return;
            }
            HashSet hashSet = new HashSet();
            hashSet.add(messenger);
            this.typedClients.put(str, hashSet);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <T> T runSyncTask(Callable<T> callable) {
            FutureTask futureTask = new FutureTask(callable);
            post(futureTask);
            try {
                return (T) futureTask.get();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e.getCause());
            } catch (ExecutionException e6) {
                throw new IllegalStateException(e6.getCause());
            }
        }

        private void sendMessageToOtherInstr(int i, Bundle bundle) {
            LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "sendMessageToOtherInstr() called with: what = [%s], data = [%s]", Integer.valueOf(i), bundle);
            Iterator<Messenger> it = this.otherInstrumentations.iterator();
            while (it.hasNext()) {
                sendMessageWithReply(it.next(), i, bundle);
            }
        }

        private void sendMessageWithReply(Messenger messenger, int i, Bundle bundle) {
            LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, b.d(i, "sendMessageWithReply type: ", " called"), new Object[0]);
            Message messageObtainMessage = obtainMessage(i);
            messageObtainMessage.replyTo = this.messengerHandler;
            if (bundle != null) {
                messageObtainMessage.setData(bundle);
            }
            if (!this.typedClients.isEmpty()) {
                Bundle data = messageObtainMessage.getData();
                data.putStringArrayList(InstrumentationConnection.BUNDLE_KEY_CLIENTS, new ArrayList<>(this.typedClients.keySet()));
                for (Map.Entry<String, Set<Messenger>> entry : this.typedClients.entrySet()) {
                    data.putParcelableArray(String.valueOf(entry.getKey()), (Messenger[]) entry.getValue().toArray(new Messenger[entry.getValue().size()]));
                }
                messageObtainMessage.setData(data);
            }
            try {
                messenger.send(messageObtainMessage);
            } catch (RemoteException e) {
                Log.w(InstrumentationConnection.TAG, "The remote process is terminated unexpectedly", e);
                instrBinderDied(messenger);
            }
        }

        private void unregisterClient(String str, Messenger messenger) {
            LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "unregisterClient called with type = [%s] client = [%s]", str, messenger);
            Checks.checkNotNull(str, "type cannot be null!");
            Checks.checkNotNull(messenger, "client cannot be null!");
            if (!this.typedClients.containsKey(str)) {
                Log.w(InstrumentationConnection.TAG, "There are no registered clients for type: " + str);
                return;
            }
            Set<Messenger> set = this.typedClients.get(str);
            if (set.contains(messenger)) {
                set.remove(messenger);
                if (set.isEmpty()) {
                    this.typedClients.remove(str);
                    return;
                }
                return;
            }
            Log.w(InstrumentationConnection.TAG, "Could not unregister client for type " + str + " because it doesn't seem to be registered");
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            switch (i) {
                case 0:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_REMOTE_ADD_CLIENT)", new Object[0]);
                    registerClient(message.getData().getString(InstrumentationConnection.BUNDLE_KEY_CLIENT_TYPE), (Messenger) message.getData().getParcelable(InstrumentationConnection.BUNDLE_KEY_CLIENT_MESSENGER));
                    break;
                case 1:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_REMOTE_REMOVE_CLIENT)", new Object[0]);
                    unregisterClient(message.getData().getString(InstrumentationConnection.BUNDLE_KEY_CLIENT_TYPE), message.replyTo);
                    break;
                case 2:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_TERMINATE)", new Object[0]);
                    doDie();
                    break;
                case 3:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_HANDLE_INSTRUMENTATION_FROM_BROADCAST)", new Object[0]);
                    if (!this.otherInstrumentations.add(message.replyTo)) {
                        Log.w(InstrumentationConnection.TAG, "Broadcast with existing binder was received, ignoring it..");
                    } else {
                        sendMessageWithReply(message.replyTo, 4, null);
                    }
                    break;
                case 4:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_ADD_INSTRUMENTATION)", new Object[0]);
                    if (!this.otherInstrumentations.add(message.replyTo)) {
                        Log.w(InstrumentationConnection.TAG, "Message with existing binder was received, ignoring it..");
                    } else {
                        if (!this.typedClients.isEmpty()) {
                            sendMessageWithReply(message.replyTo, 6, null);
                        }
                        clientsRegistrationFromBundle(message.getData(), true);
                    }
                    break;
                case 5:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_REMOVE_INSTRUMENTATION)", new Object[0]);
                    if (!this.otherInstrumentations.remove(message.replyTo)) {
                        Log.w(InstrumentationConnection.TAG, "Attempting to remove a non-existent binder!");
                    }
                    break;
                case 6:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_ADD_CLIENTS_IN_BUNDLE)", new Object[0]);
                    clientsRegistrationFromBundle(message.getData(), true);
                    break;
                case 7:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_REMOVE_CLIENTS_IN_BUNDLE)", new Object[0]);
                    clientsRegistrationFromBundle(message.getData(), false);
                    break;
                case 8:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_REG_CLIENT)", new Object[0]);
                    registerClient(message.getData().getString(InstrumentationConnection.BUNDLE_KEY_CLIENT_TYPE), (Messenger) message.getData().getParcelable(InstrumentationConnection.BUNDLE_KEY_CLIENT_MESSENGER));
                    sendMessageToOtherInstr(0, message.getData());
                    break;
                case 9:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_UN_REG_CLIENT)", new Object[0]);
                    unregisterClient(message.getData().getString(InstrumentationConnection.BUNDLE_KEY_CLIENT_TYPE), (Messenger) message.getData().getParcelable(InstrumentationConnection.BUNDLE_KEY_CLIENT_MESSENGER));
                    sendMessageToOtherInstr(1, message.getData());
                    break;
                case 10:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_REMOTE_CLEANUP_REQUEST)", new Object[0]);
                    if (!this.otherInstrumentations.isEmpty()) {
                        sendMessageToOtherInstr(11, message.getData());
                    } else {
                        Message messageObtainMessage = obtainMessage(12);
                        messageObtainMessage.setData(message.getData());
                        sendMessage(messageObtainMessage);
                    }
                    break;
                case 11:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_PERFORM_CLEANUP)", new Object[0]);
                    InstrumentationConnection.instrumentation.runOnMainSync(InstrumentationConnection.activityFinisher);
                    sendMessageWithReply(message.replyTo, 12, message.getData());
                    break;
                case 12:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_PERFORM_CLEANUP_FINISHED)", new Object[0]);
                    notifyLatch((UUID) message.getData().getSerializable(InstrumentationConnection.BUNDLE_KEY_UUID));
                    break;
                default:
                    Log.w(InstrumentationConnection.TAG, "Unknown message code received: " + i);
                    super.handleMessage(message);
                    break;
            }
        }
    }

    public class MessengerReceiver extends BroadcastReceiver {
        public MessengerReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "Broadcast received", new Object[0]);
            Bundle bundleExtra = intent.getBundleExtra(InstrumentationConnection.BUNDLE_BR_NEW_BINDER);
            if (bundleExtra == null) {
                Log.w(InstrumentationConnection.TAG, "Broadcast intent doesn't contain any extras, ignoring it..");
                return;
            }
            ParcelableIBinder parcelableIBinder = (ParcelableIBinder) bundleExtra.getParcelable(InstrumentationConnection.BUNDLE_BR_NEW_BINDER);
            if (parcelableIBinder != null) {
                Messenger messenger = new Messenger(parcelableIBinder.getIBinder());
                Message messageObtainMessage = InstrumentationConnection.this.incomingHandler.obtainMessage(3);
                messageObtainMessage.replyTo = messenger;
                InstrumentationConnection.this.incomingHandler.sendMessage(messageObtainMessage);
            }
        }
    }

    public InstrumentationConnection(Context context) {
        this.targetContext = (Context) Checks.checkNotNull(context, "Context can't be null");
    }

    public static InstrumentationConnection getInstance() {
        return DEFAULT_INSTANCE;
    }

    public synchronized Set<Messenger> getClientsForType(String str) {
        return this.incomingHandler.getClientsForType(str);
    }

    public synchronized void init(Instrumentation instrumentation2, MonitoringInstrumentation.ActivityFinisher activityFinisher2) {
        LogUtil.logDebugWithProcess(TAG, "init", new Object[0]);
        if (this.incomingHandler == null) {
            instrumentation = instrumentation2;
            activityFinisher = activityFinisher2;
            HandlerThread handlerThread = new HandlerThread("InstrumentationConnectionThread");
            handlerThread.start();
            this.incomingHandler = new IncomingHandler(handlerThread.getLooper());
            Intent intent = new Intent(BROADCAST_FILTER);
            Bundle bundle = new Bundle();
            bundle.putParcelable(BUNDLE_BR_NEW_BINDER, new ParcelableIBinder(this.incomingHandler.messengerHandler.getBinder()));
            intent.putExtra(BUNDLE_BR_NEW_BINDER, bundle);
            try {
                this.targetContext.sendBroadcast(intent);
                this.targetContext.registerReceiver(this.messengerReceiver, new IntentFilter(BROADCAST_FILTER));
            } catch (SecurityException unused) {
            }
        }
    }

    public synchronized void registerClient(String str, Messenger messenger) {
        Checks.checkState(this.incomingHandler != null, "Instrumentation Connection in not yet initialized");
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY_CLIENT_TYPE, str);
        bundle.putParcelable(BUNDLE_KEY_CLIENT_MESSENGER, messenger);
        Message messageObtainMessage = this.incomingHandler.obtainMessage(8);
        messageObtainMessage.setData(bundle);
        this.incomingHandler.sendMessage(messageObtainMessage);
    }

    public synchronized void requestRemoteInstancesActivityCleanup() {
        IncomingHandler incomingHandler;
        Checks.checkState(this.incomingHandler != null, "Instrumentation Connection in not yet initialized");
        UUID uuidRandomUUID = UUID.randomUUID();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.incomingHandler.associateLatch(uuidRandomUUID, countDownLatch);
        Message messageObtainMessage = this.incomingHandler.obtainMessage(10);
        messageObtainMessage.replyTo = this.incomingHandler.messengerHandler;
        Bundle data = messageObtainMessage.getData();
        data.putSerializable(BUNDLE_KEY_UUID, uuidRandomUUID);
        messageObtainMessage.setData(data);
        this.incomingHandler.sendMessage(messageObtainMessage);
        try {
            try {
                if (!countDownLatch.await(2L, TimeUnit.SECONDS)) {
                    Log.w(TAG, "Timed out while attempting to perform activity clean up for ".concat(String.valueOf(uuidRandomUUID)));
                }
                incomingHandler = this.incomingHandler;
            } catch (Throwable th) {
                this.incomingHandler.disassociateLatch(uuidRandomUUID);
                throw th;
            }
        } catch (InterruptedException e) {
            Log.e(TAG, "Interrupted while waiting for response from message with id: ".concat(String.valueOf(uuidRandomUUID)), e);
            incomingHandler = this.incomingHandler;
        }
        incomingHandler.disassociateLatch(uuidRandomUUID);
    }

    public synchronized void terminate() {
        LogUtil.logDebugWithProcess(TAG, "Terminate is called", new Object[0]);
        IncomingHandler incomingHandler = this.incomingHandler;
        if (incomingHandler != null) {
            incomingHandler.runSyncTask(new Callable<Void>() { // from class: androidx.test.internal.runner.InstrumentationConnection.1
                @Override // java.util.concurrent.Callable
                public Void call() {
                    InstrumentationConnection.this.incomingHandler.doDie();
                    return null;
                }
            });
            this.targetContext.unregisterReceiver(this.messengerReceiver);
            this.incomingHandler = null;
        }
    }

    public synchronized void unregisterClient(String str, Messenger messenger) {
        Checks.checkState(this.incomingHandler != null, "Instrumentation Connection in not yet initialized");
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY_CLIENT_TYPE, str);
        bundle.putParcelable(BUNDLE_KEY_CLIENT_MESSENGER, messenger);
        Message messageObtainMessage = this.incomingHandler.obtainMessage(9);
        messageObtainMessage.setData(bundle);
        this.incomingHandler.sendMessage(messageObtainMessage);
    }
}
