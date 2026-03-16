package com.google.android.gms.common.api;

import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient$SignOutCallbacks;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface Api$Client extends Api$AnyClient {
    void connect(BaseGmsClient$ConnectionProgressReportCallbacks baseGmsClient$ConnectionProgressReportCallbacks);

    void disconnect();

    void disconnect(String str);

    void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    Feature[] getAvailableFeatures();

    String getEndpointPackageName();

    String getLastDisconnectMessage();

    int getMinApkVersion();

    void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set);

    Feature[] getRequiredFeatures();

    Set<Scope> getScopesForConnectionlessNonSignIn();

    IBinder getServiceBrokerBinder();

    Intent getSignInIntent();

    boolean isConnected();

    boolean isConnecting();

    void onUserSignOut(BaseGmsClient$SignOutCallbacks baseGmsClient$SignOutCallbacks);

    boolean providesSignIn();

    boolean requiresAccount();

    boolean requiresGooglePlayServices();

    boolean requiresSignIn();
}
