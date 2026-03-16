package G2;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntryOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: renamed from: G2.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0120u extends AbstractC0612m implements ProtoBuf$EnumEntryOrBuilder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0120u f661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0101a f662h = new C0101a(7);
    public final AbstractC0604e b;
    public int c;
    public int d;
    public byte e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f663f;

    static {
        C0120u c0120u = new C0120u();
        f661g = c0120u;
        c0120u.d = 0;
    }

    public C0120u(C0119t c0119t) {
        super(c0119t);
        this.e = (byte) -1;
        this.f663f = -1;
        this.b = c0119t.f3869a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f661g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f662h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.f663f;
        if (i != -1) {
            return i;
        }
        int size = this.b.size() + c() + ((this.c & 1) == 1 ? C0606g.b(1, this.d) : 0);
        this.f663f = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.e;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (this.f3870a.e()) {
            this.e = (byte) 1;
            return true;
        }
        this.e = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return new C0119t();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        C0119t c0119t = new C0119t();
        c0119t.c(this);
        return c0119t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        B.h hVar = new B.h(this);
        if ((this.c & 1) == 1) {
            c0606g.m(1, this.d);
        }
        hVar.q(200, c0606g);
        c0606g.r(this.b);
    }

    public C0120u() {
        this.e = (byte) -1;
        this.f663f = -1;
        this.b = AbstractC0604e.f3860a;
    }

    public C0120u(C0605f c0605f, C0608i c0608i) {
        this.e = (byte) -1;
        this.f663f = -1;
        boolean z6 = false;
        this.d = 0;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        while (!z6) {
            try {
                try {
                    int iN = c0605f.n();
                    if (iN != 0) {
                        if (iN != 8) {
                            if (!g(c0605f, c0606gJ, c0608i, iN)) {
                            }
                        } else {
                            this.c |= 1;
                            this.d = c0605f.k();
                        }
                    }
                    z6 = true;
                } catch (Throwable th) {
                    try {
                        c0606gJ.i();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.b = c0603d.c();
                        throw th2;
                    }
                    this.b = c0603d.c();
                    f();
                    throw th;
                }
            } catch (kotlin.reflect.jvm.internal.impl.protobuf.r e) {
                e.f3874a = this;
                throw e;
            } catch (IOException e6) {
                kotlin.reflect.jvm.internal.impl.protobuf.r rVar = new kotlin.reflect.jvm.internal.impl.protobuf.r(e6.getMessage());
                rVar.f3874a = this;
                throw rVar;
            }
        }
        try {
            c0606gJ.i();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.b = c0603d.c();
            throw th3;
        }
        this.b = c0603d.c();
        f();
    }
}
