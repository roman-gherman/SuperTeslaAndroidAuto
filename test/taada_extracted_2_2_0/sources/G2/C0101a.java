package G2;

import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0602c;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;

/* JADX INFO: renamed from: G2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0101a extends AbstractC0602c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f535a;

    public /* synthetic */ C0101a(int i) {
        this.f535a = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
    public final Object parsePartialFrom(C0605f c0605f, C0608i c0608i) {
        switch (this.f535a) {
            case 0:
                return new C0108h(c0605f, c0608i);
            case 1:
                return new C0106f(c0605f, c0608i);
            case 2:
                return new C0105e(c0605f, c0608i);
            case 3:
                return new C0111k(c0605f, c0608i);
            case 4:
                return new C0113m(c0605f, c0608i);
            case 5:
                return new C0115o(c0605f, c0608i);
            case 6:
                return new C0118s(c0605f, c0608i);
            case 7:
                return new C0120u(c0605f, c0608i);
            case 8:
                return new C0123x(c0605f, c0608i);
            case 9:
                return new C0125z(c0605f, c0608i);
            case 10:
                return new D(c0605f, c0608i);
            case 11:
                return new F(c0605f, c0608i);
            case 12:
                return new H(c0605f, c0608i);
            case 13:
                return new M(c0605f, c0608i);
            case 14:
                return new L(c0605f);
            case 15:
                return new O(c0605f);
            case 16:
                return new U(c0605f, c0608i);
            case 17:
                return new S(c0605f, c0608i);
            case 18:
                return new W(c0605f, c0608i);
            case 19:
                return new Z(c0605f, c0608i);
            case 20:
                return new b0(c0605f, c0608i);
            case 21:
                return new d0(c0605f, c0608i);
            case 22:
                return new h0(c0605f);
            case 23:
                return new j0(c0605f, c0608i);
            case 24:
                return new J2.b(c0605f);
            case 25:
                return new J2.d(c0605f);
            case 26:
                return new J2.f(c0605f, c0608i);
            case 27:
                return new J2.k(c0605f, c0608i);
            default:
                return new J2.j(c0605f);
        }
    }
}
