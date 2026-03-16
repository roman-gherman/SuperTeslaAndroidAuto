package J2;

import G2.C0101a;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignatureOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.protobuf.r;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends p implements JvmProtoBuf$JvmMethodSignatureOrBuilder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f835g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0101a f836h = new C0101a(25);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0604e f837a;
    public int b;
    public int c;
    public int d;
    public byte e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f838f;

    static {
        d dVar = new d();
        f835g = dVar;
        dVar.c = 0;
        dVar.d = 0;
    }

    public d() {
        this.e = (byte) -1;
        this.f838f = -1;
        this.f837a = AbstractC0604e.f3860a;
    }

    public static c c(d dVar) {
        c cVar = new c();
        cVar.c(dVar);
        return cVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f835g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f836h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.f838f;
        if (i != -1) {
            return i;
        }
        int iB = (this.b & 1) == 1 ? C0606g.b(1, this.c) : 0;
        if ((this.b & 2) == 2) {
            iB += C0606g.b(2, this.d);
        }
        int size = this.f837a.size() + iB;
        this.f838f = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        if (this.e == 1) {
            return true;
        }
        this.e = (byte) 1;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return new c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        return c(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        if ((this.b & 1) == 1) {
            c0606g.m(1, this.c);
        }
        if ((this.b & 2) == 2) {
            c0606g.m(2, this.d);
        }
        c0606g.r(this.f837a);
    }

    public d(c cVar) {
        this.e = (byte) -1;
        this.f838f = -1;
        this.f837a = cVar.f3869a;
    }

    public d(C0605f c0605f) {
        this.e = (byte) -1;
        this.f838f = -1;
        boolean z6 = false;
        this.c = 0;
        this.d = 0;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        while (!z6) {
            try {
                try {
                    int iN = c0605f.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.b |= 1;
                            this.c = c0605f.k();
                        } else if (iN != 16) {
                            if (!c0605f.q(iN, c0606gJ)) {
                            }
                        } else {
                            this.b |= 2;
                            this.d = c0605f.k();
                        }
                    }
                    z6 = true;
                } catch (r e) {
                    e.f3874a = this;
                    throw e;
                } catch (IOException e6) {
                    r rVar = new r(e6.getMessage());
                    rVar.f3874a = this;
                    throw rVar;
                }
            } catch (Throwable th) {
                try {
                    c0606gJ.i();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    throw th2;
                }
                throw th;
            }
        }
        try {
            c0606gJ.i();
        } catch (IOException unused2) {
        } finally {
            this.f837a = c0603d.c();
        }
    }
}
