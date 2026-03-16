package p3;

import kotlinx.coroutines.DisposableHandle;
import m3.C0672f;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements DisposableHandle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f4492a;
    public final long b;
    public final Object c;
    public final C0672f d;

    public s(u uVar, long j6, Object obj, C0672f c0672f) {
        this.f4492a = uVar;
        this.b = j6;
        this.c = obj;
        this.d = c0672f;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        u uVar = this.f4492a;
        synchronized (uVar) {
            if (this.b < uVar.k()) {
                return;
            }
            Object[] objArr = uVar.f4497g;
            kotlin.jvm.internal.h.c(objArr);
            long j6 = this.b;
            if (objArr[((int) j6) & (objArr.length - 1)] != this) {
                return;
            }
            v.b(objArr, j6, v.f4501a);
            uVar.f();
        }
    }
}
