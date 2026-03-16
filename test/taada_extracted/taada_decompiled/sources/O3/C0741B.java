package o3;

import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import m3.AbstractC0686u;

/* JADX INFO: renamed from: o3.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0741B extends r implements ProducerScope {
    @Override // m3.AbstractC0665a
    public final void F(Throwable th, boolean z6) {
        if (this.d.f(th, false) || z6) {
            return;
        }
        AbstractC0686u.a(this.c, th);
    }

    @Override // m3.AbstractC0665a
    public final void G(Object obj) {
        this.d.close(null);
    }

    @Override // kotlinx.coroutines.channels.ProducerScope
    public final SendChannel getChannel() {
        return this;
    }
}
