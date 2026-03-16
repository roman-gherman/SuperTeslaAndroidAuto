package p3;

import kotlin.coroutines.Continuation;
import m3.C0672f;
import q3.AbstractC0785b;
import q3.AbstractC0787d;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends AbstractC0787d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4502a;
    public C0672f b;

    @Override // q3.AbstractC0787d
    public final boolean a(AbstractC0785b abstractC0785b) {
        u uVar = (u) abstractC0785b;
        if (this.f4502a >= 0) {
            return false;
        }
        long j6 = uVar.f4498h;
        if (j6 < uVar.i) {
            uVar.i = j6;
        }
        this.f4502a = j6;
        return true;
    }

    @Override // q3.AbstractC0787d
    public final Continuation[] b(AbstractC0785b abstractC0785b) {
        long j6 = this.f4502a;
        this.f4502a = -1L;
        this.b = null;
        return ((u) abstractC0785b).q(j6);
    }
}
