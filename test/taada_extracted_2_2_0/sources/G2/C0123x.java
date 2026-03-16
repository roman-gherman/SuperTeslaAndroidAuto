package G2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ExpressionOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: renamed from: G2.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0123x extends kotlin.reflect.jvm.internal.impl.protobuf.p implements ProtoBuf$ExpressionOrBuilder {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0123x f668l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final C0101a f669m = new C0101a(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0604e f670a;
    public int b;
    public int c;
    public int d;
    public EnumC0122w e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public U f671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f673h;
    public List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte f674j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f675k;

    static {
        C0123x c0123x = new C0123x();
        f668l = c0123x;
        c0123x.c = 0;
        c0123x.d = 0;
        c0123x.e = EnumC0122w.TRUE;
        c0123x.f671f = U.f492t;
        c0123x.f672g = 0;
        List list = Collections.EMPTY_LIST;
        c0123x.f673h = list;
        c0123x.i = list;
    }

    public C0123x() {
        this.f674j = (byte) -1;
        this.f675k = -1;
        this.f670a = AbstractC0604e.f3861a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f668l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f669m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.f675k;
        if (i != -1) {
            return i;
        }
        int iB = (this.b & 1) == 1 ? C0606g.b(1, this.c) : 0;
        if ((this.b & 2) == 2) {
            iB += C0606g.b(2, this.d);
        }
        if ((this.b & 4) == 4) {
            iB += C0606g.a(3, this.e.f667a);
        }
        if ((this.b & 8) == 8) {
            iB += C0606g.d(4, this.f671f);
        }
        if ((this.b & 16) == 16) {
            iB += C0606g.b(5, this.f672g);
        }
        for (int i3 = 0; i3 < this.f673h.size(); i3++) {
            iB += C0606g.d(6, (MessageLite) this.f673h.get(i3));
        }
        for (int i4 = 0; i4 < this.i.size(); i4++) {
            iB += C0606g.d(7, (MessageLite) this.i.get(i4));
        }
        int size = this.f670a.size() + iB;
        this.f675k = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f674j;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if ((this.b & 8) == 8 && !this.f671f.isInitialized()) {
            this.f674j = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.f673h.size(); i++) {
            if (!((C0123x) this.f673h.get(i)).isInitialized()) {
                this.f674j = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            if (!((C0123x) this.i.get(i3)).isInitialized()) {
                this.f674j = (byte) 0;
                return false;
            }
        }
        this.f674j = (byte) 1;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return C0121v.c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        C0121v c0121vC = C0121v.c();
        c0121vC.d(this);
        return c0121vC;
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
            c0606g.l(3, this.e.f667a);
        }
        if ((this.b & 8) == 8) {
            c0606g.o(4, this.f671f);
        }
        if ((this.b & 16) == 16) {
            c0606g.m(5, this.f672g);
        }
        for (int i = 0; i < this.f673h.size(); i++) {
            c0606g.o(6, (MessageLite) this.f673h.get(i));
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            c0606g.o(7, (MessageLite) this.i.get(i3));
        }
        c0606g.r(this.f670a);
    }

    public C0123x(C0121v c0121v) {
        this.f674j = (byte) -1;
        this.f675k = -1;
        this.f670a = c0121v.f3870a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C0123x(C0605f c0605f, C0608i c0608i) {
        EnumC0122w enumC0122w;
        this.f674j = (byte) -1;
        this.f675k = -1;
        boolean z6 = false;
        this.c = 0;
        this.d = 0;
        EnumC0122w enumC0122w2 = EnumC0122w.TRUE;
        this.e = enumC0122w2;
        this.f671f = U.f492t;
        this.f672g = 0;
        List list = Collections.EMPTY_LIST;
        this.f673h = list;
        this.i = list;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        int i = 0;
        while (!z6) {
            try {
                try {
                    try {
                        int iN = c0605f.n();
                        if (iN != 0) {
                            if (iN == 8) {
                                this.b |= 1;
                                this.c = c0605f.k();
                            } else if (iN != 16) {
                                Object objK = null;
                                if (iN == 24) {
                                    int iK = c0605f.k();
                                    if (iK != 0) {
                                        if (iK == 1) {
                                            objK = EnumC0122w.FALSE;
                                        } else if (iK == 2) {
                                            objK = EnumC0122w.NULL;
                                        }
                                        enumC0122w = objK;
                                    } else {
                                        enumC0122w = enumC0122w2;
                                    }
                                    if (enumC0122w == 0) {
                                        c0606gJ.v(iN);
                                        c0606gJ.v(iK);
                                    } else {
                                        this.b |= 4;
                                        this.e = enumC0122w;
                                    }
                                } else if (iN == 34) {
                                    if ((this.b & 8) == 8) {
                                        U u = this.f671f;
                                        u.getClass();
                                        objK = U.k(u);
                                    }
                                    T t6 = objK;
                                    U u2 = (U) c0605f.g(U.u, c0608i);
                                    this.f671f = u2;
                                    if (t6 != 0) {
                                        t6.e(u2);
                                        this.f671f = t6.c();
                                    }
                                    this.b |= 8;
                                } else if (iN != 40) {
                                    C0101a c0101a = f669m;
                                    if (iN == 50) {
                                        if ((i & 32) != 32) {
                                            this.f673h = new ArrayList();
                                            i |= 32;
                                        }
                                        this.f673h.add(c0605f.g(c0101a, c0608i));
                                    } else if (iN != 58) {
                                        if (!c0605f.q(iN, c0606gJ)) {
                                        }
                                    } else {
                                        if ((i & 64) != 64) {
                                            this.i = new ArrayList();
                                            i |= 64;
                                        }
                                        this.i.add(c0605f.g(c0101a, c0608i));
                                    }
                                } else {
                                    this.b |= 16;
                                    this.f672g = c0605f.k();
                                }
                            } else {
                                this.b |= 2;
                                this.d = c0605f.k();
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
                if ((i & 32) == 32) {
                    this.f673h = Collections.unmodifiableList(this.f673h);
                }
                if ((i & 64) == 64) {
                    this.i = Collections.unmodifiableList(this.i);
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
        if ((i & 32) == 32) {
            this.f673h = Collections.unmodifiableList(this.f673h);
        }
        if ((i & 64) == 64) {
            this.i = Collections.unmodifiableList(this.i);
        }
        try {
            c0606gJ.i();
        } catch (IOException unused2) {
        } finally {
            this.f670a = c0603d.c();
        }
    }
}
