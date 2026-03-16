package G2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTableOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends kotlin.reflect.jvm.internal.impl.protobuf.p implements ProtoBuf$TypeTableOrBuilder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b0 f536g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0101a f537h = new C0101a(20);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0604e f538a;
    public int b;
    public List c;
    public int d;
    public byte e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f539f;

    static {
        b0 b0Var = new b0();
        f536g = b0Var;
        b0Var.c = Collections.EMPTY_LIST;
        b0Var.d = -1;
    }

    public b0() {
        this.e = (byte) -1;
        this.f539f = -1;
        this.f538a = AbstractC0604e.f3861a;
    }

    public static a0 c(b0 b0Var) {
        a0 a0VarC = a0.c();
        a0VarC.d(b0Var);
        return a0VarC;
    }

    public final a0 d() {
        return c(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f536g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f537h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.f539f;
        if (i != -1) {
            return i;
        }
        int iB = 0;
        for (int i3 = 0; i3 < this.c.size(); i3++) {
            iB += C0606g.d(1, (MessageLite) this.c.get(i3));
        }
        if ((this.b & 1) == 1) {
            iB += C0606g.b(2, this.d);
        }
        int size = this.f538a.size() + iB;
        this.f539f = size;
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
        for (int i = 0; i < this.c.size(); i++) {
            if (!((U) this.c.get(i)).isInitialized()) {
                this.e = (byte) 0;
                return false;
            }
        }
        this.e = (byte) 1;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return a0.c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        return c(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        for (int i = 0; i < this.c.size(); i++) {
            c0606g.o(1, (MessageLite) this.c.get(i));
        }
        if ((this.b & 1) == 1) {
            c0606g.m(2, this.d);
        }
        c0606g.r(this.f538a);
    }

    public b0(a0 a0Var) {
        this.e = (byte) -1;
        this.f539f = -1;
        this.f538a = a0Var.f3870a;
    }

    public b0(C0605f c0605f, C0608i c0608i) {
        this.e = (byte) -1;
        this.f539f = -1;
        this.c = Collections.EMPTY_LIST;
        this.d = -1;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        boolean z6 = false;
        boolean z7 = false;
        while (!z6) {
            try {
                try {
                    int iN = c0605f.n();
                    if (iN != 0) {
                        if (iN == 10) {
                            if (!z7) {
                                this.c = new ArrayList();
                                z7 = true;
                            }
                            this.c.add(c0605f.g(U.u, c0608i));
                        } else if (iN != 16) {
                            if (!c0605f.q(iN, c0606gJ)) {
                            }
                        } else {
                            this.b |= 1;
                            this.d = c0605f.k();
                        }
                    }
                    z6 = true;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.r e) {
                    e.f3875a = this;
                    throw e;
                } catch (IOException e6) {
                    kotlin.reflect.jvm.internal.impl.protobuf.r rVar = new kotlin.reflect.jvm.internal.impl.protobuf.r(e6.getMessage());
                    rVar.f3875a = this;
                    throw rVar;
                }
            } catch (Throwable th) {
                if (z7) {
                    this.c = Collections.unmodifiableList(this.c);
                }
                try {
                    c0606gJ.i();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    throw th2;
                }
                throw th;
            }
        }
        if (z7) {
            this.c = Collections.unmodifiableList(this.c);
        }
        try {
            c0606gJ.i();
        } catch (IOException unused2) {
        } finally {
            this.f538a = c0603d.c();
        }
    }
}
