package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: renamed from: kotlin.jvm.internal.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0599a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0599a f3810a = new C0599a();

    private Object readResolve() {
        return f3810a;
    }
}
