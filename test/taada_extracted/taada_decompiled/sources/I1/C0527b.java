package i1;

import C0.x;
import io.ktor.http.Headers;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.X;
import io.ktor.utils.io.g0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.h;
import kotlin.reflect.l;
import kotlinx.coroutines.Job;
import m3.V;
import s1.AbstractC0809b;
import s1.C0810c;
import u1.C0840e;
import v1.e;
import v1.f;
import v1.g;
import v1.i;

/* JADX INFO: renamed from: i1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0527b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f3463a;
    public final Job b;
    public final Function3 c;
    public final ByteReadChannel d;

    public C0527b(g delegate, Job callContext, Function3 function3) {
        ByteReadChannel byteReadChannelD;
        h.f(delegate, "delegate");
        h.f(callContext, "callContext");
        this.f3463a = delegate;
        this.b = callContext;
        this.c = function3;
        if (delegate instanceof e) {
            byteReadChannelD = l.a(((e) delegate).d());
        } else if (delegate instanceof C0810c) {
            ByteReadChannel.Companion.getClass();
            byteReadChannelD = (ByteReadChannel) X.b.getValue();
        } else if (delegate instanceof f) {
            byteReadChannelD = ((f) delegate).d();
        } else {
            if (!(delegate instanceof i)) {
                throw new x();
            }
            byteReadChannelD = g0.b(V.f4114a, callContext, true, new C0526a(this, null)).b;
        }
        this.d = byteReadChannelD;
    }

    @Override // v1.g
    public final Long a() {
        return this.f3463a.a();
    }

    @Override // v1.g
    public final C0840e b() {
        return this.f3463a.b();
    }

    @Override // v1.g
    public final Headers c() {
        return this.f3463a.c();
    }

    @Override // v1.f
    public final ByteReadChannel d() {
        return AbstractC0809b.a(this.d, this.b, this.f3463a.a(), this.c);
    }
}
