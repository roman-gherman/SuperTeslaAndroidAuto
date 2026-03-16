package o3;

import kotlinx.coroutines.Waiter;
import m3.C0672f;

/* JADX INFO: renamed from: o3.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0742C implements Waiter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0672f f4318a;

    public C0742C(C0672f c0672f) {
        this.f4318a = c0672f;
    }

    @Override // kotlinx.coroutines.Waiter
    public final void invokeOnCancellation(r3.u uVar, int i) {
        this.f4318a.invokeOnCancellation(uVar, i);
    }
}
