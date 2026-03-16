package com.google.android.gms.common.api.internal;

import B.c;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public interface zaca {
    ConnectionResult zab();

    ConnectionResult zac(long j6, TimeUnit timeUnit);

    ConnectionResult zad(b bVar);

    c zae(c cVar);

    c zaf(c cVar);

    void zaq();

    void zar();

    void zas(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    void zat();

    void zau();

    boolean zaw();

    boolean zax();

    boolean zay(SignInConnectionListener signInConnectionListener);
}
