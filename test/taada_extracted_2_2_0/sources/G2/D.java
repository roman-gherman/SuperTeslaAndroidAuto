package G2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: classes2.dex */
public final class D extends AbstractC0612m implements ProtoBuf$PackageOrBuilder {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final D f427k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0101a f428l = new C0101a(10);
    public final AbstractC0604e b;
    public int c;
    public List d;
    public List e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b0 f430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j0 f431h;
    public byte i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f432j;

    static {
        D d = new D();
        f427k = d;
        List list = Collections.EMPTY_LIST;
        d.d = list;
        d.e = list;
        d.f429f = list;
        d.f430g = b0.f536g;
        d.f431h = j0.e;
    }

    public D(C c) {
        super(c);
        this.i = (byte) -1;
        this.f432j = -1;
        this.b = c.f3870a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f427k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f428l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.f432j;
        if (i != -1) {
            return i;
        }
        int iD = 0;
        for (int i3 = 0; i3 < this.d.size(); i3++) {
            iD += C0606g.d(3, (MessageLite) this.d.get(i3));
        }
        for (int i4 = 0; i4 < this.e.size(); i4++) {
            iD += C0606g.d(4, (MessageLite) this.e.get(i4));
        }
        for (int i5 = 0; i5 < this.f429f.size(); i5++) {
            iD += C0606g.d(5, (MessageLite) this.f429f.get(i5));
        }
        if ((this.c & 1) == 1) {
            iD += C0606g.d(30, this.f430g);
        }
        if ((this.c & 2) == 2) {
            iD += C0606g.d(32, this.f431h);
        }
        int size = this.b.size() + c() + iD;
        this.f432j = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.i;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        for (int i = 0; i < this.d.size(); i++) {
            if (!((C0125z) this.d.get(i)).isInitialized()) {
                this.i = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < this.e.size(); i3++) {
            if (!((H) this.e.get(i3)).isInitialized()) {
                this.i = (byte) 0;
                return false;
            }
        }
        for (int i4 = 0; i4 < this.f429f.size(); i4++) {
            if (!((W) this.f429f.get(i4)).isInitialized()) {
                this.i = (byte) 0;
                return false;
            }
        }
        if ((this.c & 1) == 1 && !this.f430g.isInitialized()) {
            this.i = (byte) 0;
            return false;
        }
        if (this.f3871a.e()) {
            this.i = (byte) 1;
            return true;
        }
        this.i = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return C.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        C cD = C.d();
        cD.e(this);
        return cD;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        B.h hVar = new B.h(this);
        for (int i = 0; i < this.d.size(); i++) {
            c0606g.o(3, (MessageLite) this.d.get(i));
        }
        for (int i3 = 0; i3 < this.e.size(); i3++) {
            c0606g.o(4, (MessageLite) this.e.get(i3));
        }
        for (int i4 = 0; i4 < this.f429f.size(); i4++) {
            c0606g.o(5, (MessageLite) this.f429f.get(i4));
        }
        if ((this.c & 1) == 1) {
            c0606g.o(30, this.f430g);
        }
        if ((this.c & 2) == 2) {
            c0606g.o(32, this.f431h);
        }
        hVar.q(200, c0606g);
        c0606g.r(this.b);
    }

    public D() {
        this.i = (byte) -1;
        this.f432j = -1;
        this.b = AbstractC0604e.f3861a;
    }

    public D(C0605f c0605f, C0608i c0608i) {
        this.i = (byte) -1;
        this.f432j = -1;
        List list = Collections.EMPTY_LIST;
        this.d = list;
        this.e = list;
        this.f429f = list;
        this.f430g = b0.f536g;
        this.f431h = j0.e;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        boolean z6 = false;
        int i = 0;
        while (!z6) {
            try {
                try {
                    int iN = c0605f.n();
                    if (iN != 0) {
                        if (iN == 26) {
                            int i3 = (i == true ? 1 : 0) & 1;
                            i = i;
                            if (i3 != 1) {
                                this.d = new ArrayList();
                                i = (i == true ? 1 : 0) | 1;
                            }
                            this.d.add(c0605f.g(C0125z.f687v, c0608i));
                        } else if (iN == 34) {
                            int i4 = (i == true ? 1 : 0) & 2;
                            i = i;
                            if (i4 != 2) {
                                this.e = new ArrayList();
                                i = (i == true ? 1 : 0) | 2;
                            }
                            this.e.add(c0605f.g(H.f452v, c0608i));
                        } else if (iN != 42) {
                            i0 i0Var = null;
                            a0 a0VarC = null;
                            if (iN == 242) {
                                if ((this.c & 1) == 1) {
                                    b0 b0Var = this.f430g;
                                    b0Var.getClass();
                                    a0VarC = b0.c(b0Var);
                                }
                                b0 b0Var2 = (b0) c0605f.g(b0.f537h, c0608i);
                                this.f430g = b0Var2;
                                if (a0VarC != null) {
                                    a0VarC.d(b0Var2);
                                    this.f430g = a0VarC.b();
                                }
                                this.c |= 1;
                            } else if (iN != 258) {
                                if (!g(c0605f, c0606gJ, c0608i, iN)) {
                                }
                            } else {
                                if ((this.c & 2) == 2) {
                                    j0 j0Var = this.f431h;
                                    j0Var.getClass();
                                    i0Var = new i0();
                                    i0Var.c = Collections.EMPTY_LIST;
                                    i0Var.c(j0Var);
                                }
                                j0 j0Var2 = (j0) c0605f.g(j0.f620f, c0608i);
                                this.f431h = j0Var2;
                                if (i0Var != null) {
                                    i0Var.c(j0Var2);
                                    this.f431h = i0Var.b();
                                }
                                this.c |= 2;
                            }
                        } else {
                            int i5 = (i == true ? 1 : 0) & 4;
                            i = i;
                            if (i5 != 4) {
                                this.f429f = new ArrayList();
                                i = (i == true ? 1 : 0) | 4;
                            }
                            this.f429f.add(c0605f.g(W.f513p, c0608i));
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
                if (((i == true ? 1 : 0) & 1) == 1) {
                    this.d = Collections.unmodifiableList(this.d);
                }
                if (((i == true ? 1 : 0) & 2) == 2) {
                    this.e = Collections.unmodifiableList(this.e);
                }
                if (((i == true ? 1 : 0) & 4) == 4) {
                    this.f429f = Collections.unmodifiableList(this.f429f);
                }
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
        }
        if (((i == true ? 1 : 0) & 1) == 1) {
            this.d = Collections.unmodifiableList(this.d);
        }
        if (((i == true ? 1 : 0) & 2) == 2) {
            this.e = Collections.unmodifiableList(this.e);
        }
        if (((i == true ? 1 : 0) & 4) == 4) {
            this.f429f = Collections.unmodifiableList(this.f429f);
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
