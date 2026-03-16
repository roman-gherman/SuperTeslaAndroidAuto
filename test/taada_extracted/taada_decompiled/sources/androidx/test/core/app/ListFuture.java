package androidx.test.core.app;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.constraintlayout.core.motion.a;
import androidx.test.internal.util.Checks;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
class ListFuture<V> implements ListenableFuture<List<V>> {
    private final boolean mAllMustSucceed;
    List<? extends ListenableFuture<? extends V>> mFutures;
    private final AtomicInteger mRemaining;
    private final ListenableFuture<List<V>> mResult = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<List<V>>() { // from class: androidx.test.core.app.ListFuture.1
        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
        public Object attachCompleter(CallbackToFutureAdapter.Completer<List<V>> completer) {
            Checks.checkState(ListFuture.this.mResultNotifier == null, "The result can only set once!");
            ListFuture.this.mResultNotifier = completer;
            return a.q("ListFuture[", String.valueOf(this), "]");
        }
    });
    CallbackToFutureAdapter.Completer<List<V>> mResultNotifier;
    List<V> mValues;

    public ListFuture(List<? extends ListenableFuture<? extends V>> list, boolean z6, Executor executor) {
        this.mFutures = (List) Checks.checkNotNull(list);
        this.mValues = new ArrayList(list.size());
        this.mAllMustSucceed = z6;
        this.mRemaining = new AtomicInteger(list.size());
        init(executor);
    }

    private void callAllGets() throws InterruptedException {
        List<? extends ListenableFuture<? extends V>> list = this.mFutures;
        if (list == null || isDone()) {
            return;
        }
        for (ListenableFuture<? extends V> listenableFuture : list) {
            while (!listenableFuture.isDone()) {
                try {
                    listenableFuture.get();
                } catch (Error e) {
                    throw e;
                } catch (InterruptedException e6) {
                    throw e6;
                } catch (Throwable unused) {
                    if (this.mAllMustSucceed) {
                        return;
                    }
                }
            }
        }
    }

    private static Executor directExecutor() {
        return DirectExecutor.INSTANCE;
    }

    private static <V> V getUninterruptibly(Future<V> future) {
        V v6;
        boolean z6 = false;
        while (true) {
            try {
                v6 = future.get();
                break;
            } catch (InterruptedException unused) {
                z6 = true;
            } catch (Throwable th) {
                if (z6) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z6) {
            Thread.currentThread().interrupt();
        }
        return v6;
    }

    private void init(Executor executor) {
        addListener(new Runnable() { // from class: androidx.test.core.app.ListFuture.2
            @Override // java.lang.Runnable
            public void run() {
                ListFuture listFuture = ListFuture.this;
                listFuture.mValues = null;
                listFuture.mFutures = null;
            }
        }, directExecutor());
        if (this.mFutures.isEmpty()) {
            this.mResultNotifier.set(new ArrayList(this.mValues));
            return;
        }
        for (int i = 0; i < this.mFutures.size(); i++) {
            this.mValues.add(null);
        }
        List<? extends ListenableFuture<? extends V>> list = this.mFutures;
        for (final int i3 = 0; i3 < list.size(); i3++) {
            final ListenableFuture<? extends V> listenableFuture = list.get(i3);
            listenableFuture.addListener(new Runnable() { // from class: androidx.test.core.app.ListFuture.3
                @Override // java.lang.Runnable
                public void run() {
                    ListFuture.this.setOneValue(i3, listenableFuture);
                }
            }, executor);
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        this.mResult.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z6) {
        List<? extends ListenableFuture<? extends V>> list = this.mFutures;
        if (list != null) {
            Iterator<? extends ListenableFuture<? extends V>> it = list.iterator();
            while (it.hasNext()) {
                it.next().cancel(z6);
            }
        }
        return this.mResult.cancel(z6);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.mResult.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mResult.isDone();
    }

    public void setOneValue(int i, Future<? extends V> future) {
        CallbackToFutureAdapter.Completer<List<V>> completer;
        ArrayList arrayList;
        List<V> list = this.mValues;
        if (isDone() || list == null) {
            Checks.checkState(this.mAllMustSucceed, "Future was done before all dependencies completed");
            return;
        }
        try {
            try {
                try {
                    try {
                        try {
                            Checks.checkState(future.isDone(), "Tried to set value from future which is not done");
                            list.set(i, (V) getUninterruptibly(future));
                            int iDecrementAndGet = this.mRemaining.decrementAndGet();
                            Checks.checkState(iDecrementAndGet >= 0, "Less than 0 remaining futures");
                            if (iDecrementAndGet == 0) {
                                List<V> list2 = this.mValues;
                                if (list2 != null) {
                                    this.mResultNotifier.set(new ArrayList(list2));
                                } else {
                                    Checks.checkState(isDone());
                                }
                            }
                        } catch (ExecutionException e) {
                            if (this.mAllMustSucceed) {
                                this.mResultNotifier.setException(e.getCause());
                            }
                            int iDecrementAndGet2 = this.mRemaining.decrementAndGet();
                            Checks.checkState(iDecrementAndGet2 >= 0, "Less than 0 remaining futures");
                            if (iDecrementAndGet2 == 0) {
                                List<V> list3 = this.mValues;
                                if (list3 != null) {
                                    completer = this.mResultNotifier;
                                    arrayList = new ArrayList(list3);
                                    completer.set(arrayList);
                                    return;
                                }
                                Checks.checkState(isDone());
                            }
                        }
                    } catch (CancellationException unused) {
                        if (this.mAllMustSucceed) {
                            cancel(false);
                        }
                        int iDecrementAndGet3 = this.mRemaining.decrementAndGet();
                        Checks.checkState(iDecrementAndGet3 >= 0, "Less than 0 remaining futures");
                        if (iDecrementAndGet3 == 0) {
                            List<V> list4 = this.mValues;
                            if (list4 != null) {
                                completer = this.mResultNotifier;
                                arrayList = new ArrayList(list4);
                                completer.set(arrayList);
                                return;
                            }
                            Checks.checkState(isDone());
                        }
                    }
                } catch (Error e6) {
                    this.mResultNotifier.setException(e6);
                    int iDecrementAndGet4 = this.mRemaining.decrementAndGet();
                    Checks.checkState(iDecrementAndGet4 >= 0, "Less than 0 remaining futures");
                    if (iDecrementAndGet4 == 0) {
                        List<V> list5 = this.mValues;
                        if (list5 != null) {
                            completer = this.mResultNotifier;
                            arrayList = new ArrayList(list5);
                            completer.set(arrayList);
                            return;
                        }
                        Checks.checkState(isDone());
                    }
                }
            } catch (RuntimeException e7) {
                if (this.mAllMustSucceed) {
                    this.mResultNotifier.setException(e7);
                }
                int iDecrementAndGet5 = this.mRemaining.decrementAndGet();
                Checks.checkState(iDecrementAndGet5 >= 0, "Less than 0 remaining futures");
                if (iDecrementAndGet5 == 0) {
                    List<V> list6 = this.mValues;
                    if (list6 != null) {
                        completer = this.mResultNotifier;
                        arrayList = new ArrayList(list6);
                        completer.set(arrayList);
                        return;
                    }
                    Checks.checkState(isDone());
                }
            }
        } catch (Throwable th) {
            int iDecrementAndGet6 = this.mRemaining.decrementAndGet();
            Checks.checkState(iDecrementAndGet6 >= 0, "Less than 0 remaining futures");
            if (iDecrementAndGet6 == 0) {
                List<V> list7 = this.mValues;
                if (list7 != null) {
                    this.mResultNotifier.set(new ArrayList(list7));
                } else {
                    Checks.checkState(isDone());
                }
            }
            throw th;
        }
    }

    @Override // java.util.concurrent.Future
    public List<V> get() throws InterruptedException {
        callAllGets();
        return this.mResult.get();
    }

    @Override // java.util.concurrent.Future
    public List<V> get(long j6, TimeUnit timeUnit) {
        return this.mResult.get(j6, timeUnit);
    }
}
