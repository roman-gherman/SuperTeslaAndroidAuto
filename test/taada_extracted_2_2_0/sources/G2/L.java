package G2;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedNameOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: classes2.dex */
public final class L extends kotlin.reflect.jvm.internal.impl.protobuf.p implements ProtoBuf$QualifiedNameTable$QualifiedNameOrBuilder {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final L f467h;
    public static final C0101a i = new C0101a(14);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0604e f468a;
    public int b;
    public int c;
    public int d;
    public K e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte f469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f470g;

    static {
        L l6 = new L();
        f467h = l6;
        l6.c = -1;
        l6.d = 0;
        l6.e = K.PACKAGE;
    }

    public L() {
        this.f469f = (byte) -1;
        this.f470g = -1;
        this.f468a = AbstractC0604e.f3861a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f467h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i3 = this.f470g;
        if (i3 != -1) {
            return i3;
        }
        int iB = (this.b & 1) == 1 ? C0606g.b(1, this.c) : 0;
        if ((this.b & 2) == 2) {
            iB += C0606g.b(2, this.d);
        }
        if ((this.b & 4) == 4) {
            iB += C0606g.a(3, this.e.f466a);
        }
        int size = this.f468a.size() + iB;
        this.f470g = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f469f;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if ((this.b & 2) == 2) {
            this.f469f = (byte) 1;
            return true;
        }
        this.f469f = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return J.c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        J jC = J.c();
        jC.d(this);
        return jC;
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
        if ((this.b & 4) == 4) {
            c0606g.l(3, this.e.f466a);
        }
        c0606g.r(this.f468a);
    }

    public L(J j6) {
        this.f469f = (byte) -1;
        this.f470g = -1;
        this.f468a = j6.f3870a;
    }

    public L(C0605f c0605f) {
        K k6;
        this.f469f = (byte) -1;
        this.f470g = -1;
        this.c = -1;
        boolean z6 = false;
        this.d = 0;
        K k7 = K.PACKAGE;
        this.e = k7;
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
                            } else if (iN == 16) {
                                this.b |= 2;
                                this.d = c0605f.k();
                            } else if (iN != 24) {
                                if (!c0605f.q(iN, c0606gJ)) {
                                }
                            } else {
                                int iK = c0605f.k();
                                if (iK == 0) {
                                    k6 = K.CLASS;
                                } else if (iK != 1) {
                                    k6 = iK != 2 ? null : K.LOCAL;
                                } else {
                                    k6 = k7;
                                }
                                if (k6 == null) {
                                    c0606gJ.v(iN);
                                    c0606gJ.v(iK);
                                } else {
                                    this.b |= 4;
                                    this.e = k6;
                                }
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
            this.f468a = c0603d.c();
        }
    }
}
