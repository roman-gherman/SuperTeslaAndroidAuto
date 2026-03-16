package G2;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$ArgumentOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: renamed from: G2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0106f extends kotlin.reflect.jvm.internal.impl.protobuf.p implements ProtoBuf$Annotation$ArgumentOrBuilder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0106f f582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0101a f583h = new C0101a(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0604e f584a;
    public int b;
    public int c;
    public C0105e d;
    public byte e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f585f;

    static {
        C0106f c0106f = new C0106f();
        f582g = c0106f;
        c0106f.c = 0;
        c0106f.d = C0105e.f568p;
    }

    public C0106f() {
        this.e = (byte) -1;
        this.f585f = -1;
        this.f584a = AbstractC0604e.f3861a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f582g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f583h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.f585f;
        if (i != -1) {
            return i;
        }
        int iB = (this.b & 1) == 1 ? C0606g.b(1, this.c) : 0;
        if ((this.b & 2) == 2) {
            iB += C0606g.d(2, this.d);
        }
        int size = this.f584a.size() + iB;
        this.f585f = size;
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
        int i = this.b;
        if ((i & 1) != 1) {
            this.e = (byte) 0;
            return false;
        }
        if ((i & 2) != 2) {
            this.e = (byte) 0;
            return false;
        }
        if (this.d.isInitialized()) {
            this.e = (byte) 1;
            return true;
        }
        this.e = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        C0102b c0102b = new C0102b();
        c0102b.d = C0105e.f568p;
        return c0102b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        C0102b c0102b = new C0102b();
        c0102b.d = C0105e.f568p;
        c0102b.c(this);
        return c0102b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        if ((this.b & 1) == 1) {
            c0606g.m(1, this.c);
        }
        if ((this.b & 2) == 2) {
            c0606g.o(2, this.d);
        }
        c0606g.r(this.f584a);
    }

    public C0106f(C0102b c0102b) {
        this.e = (byte) -1;
        this.f585f = -1;
        this.f584a = c0102b.f3870a;
    }

    public C0106f(C0605f c0605f, C0608i c0608i) {
        C0103c c0103cC;
        this.e = (byte) -1;
        this.f585f = -1;
        boolean z6 = false;
        this.c = 0;
        this.d = C0105e.f568p;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        while (!z6) {
            try {
                try {
                    try {
                        int iN = c0605f.n();
                        if (iN != 0) {
                            if (iN == 8) {
                                this.b |= 1;
                                this.c = c0605f.k();
                            } else if (iN != 18) {
                                if (!c0605f.q(iN, c0606gJ)) {
                                }
                            } else {
                                if ((this.b & 2) == 2) {
                                    C0105e c0105e = this.d;
                                    c0105e.getClass();
                                    c0103cC = C0103c.c();
                                    c0103cC.d(c0105e);
                                } else {
                                    c0103cC = null;
                                }
                                C0105e c0105e2 = (C0105e) c0605f.g(C0105e.q, c0608i);
                                this.d = c0105e2;
                                if (c0103cC != null) {
                                    c0103cC.d(c0105e2);
                                    this.d = c0103cC.b();
                                }
                                this.b |= 2;
                            }
                        }
                        z6 = true;
                    } catch (IOException e) {
                        kotlin.reflect.jvm.internal.impl.protobuf.r rVar = new kotlin.reflect.jvm.internal.impl.protobuf.r(e.getMessage());
                        rVar.f3875a = this;
                        throw rVar;
                    }
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.r e6) {
                    e6.f3875a = this;
                    throw e6;
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
            this.f584a = c0603d.c();
        }
    }
}
