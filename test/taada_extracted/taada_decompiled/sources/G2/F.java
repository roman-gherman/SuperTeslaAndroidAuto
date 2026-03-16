package G2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragmentOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: classes2.dex */
public final class F extends AbstractC0612m implements ProtoBuf$PackageFragmentOrBuilder {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final F f436j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C0101a f437k = new C0101a(11);
    public final AbstractC0604e b;
    public int c;
    public O d;
    public M e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public D f438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte f440h;
    public int i;

    static {
        F f6 = new F();
        f436j = f6;
        f6.d = O.e;
        f6.e = M.e;
        f6.f438f = D.f427k;
        f6.f439g = Collections.EMPTY_LIST;
    }

    public F(E e) {
        super(e);
        this.f440h = (byte) -1;
        this.i = -1;
        this.b = e.f3869a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f436j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f437k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.i;
        if (i != -1) {
            return i;
        }
        int iD = (this.c & 1) == 1 ? C0606g.d(1, this.d) : 0;
        if ((this.c & 2) == 2) {
            iD += C0606g.d(2, this.e);
        }
        if ((this.c & 4) == 4) {
            iD += C0606g.d(3, this.f438f);
        }
        for (int i3 = 0; i3 < this.f439g.size(); i3++) {
            iD += C0606g.d(4, (MessageLite) this.f439g.get(i3));
        }
        int size = this.b.size() + c() + iD;
        this.i = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f440h;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if ((this.c & 2) == 2 && !this.e.isInitialized()) {
            this.f440h = (byte) 0;
            return false;
        }
        if ((this.c & 4) == 4 && !this.f438f.isInitialized()) {
            this.f440h = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.f439g.size(); i++) {
            if (!((C0111k) this.f439g.get(i)).isInitialized()) {
                this.f440h = (byte) 0;
                return false;
            }
        }
        if (this.f3870a.e()) {
            this.f440h = (byte) 1;
            return true;
        }
        this.f440h = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return E.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        E eD = E.d();
        eD.e(this);
        return eD;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        B.h hVar = new B.h(this);
        if ((this.c & 1) == 1) {
            c0606g.o(1, this.d);
        }
        if ((this.c & 2) == 2) {
            c0606g.o(2, this.e);
        }
        if ((this.c & 4) == 4) {
            c0606g.o(3, this.f438f);
        }
        for (int i = 0; i < this.f439g.size(); i++) {
            c0606g.o(4, (MessageLite) this.f439g.get(i));
        }
        hVar.q(200, c0606g);
        c0606g.r(this.b);
    }

    public F() {
        this.f440h = (byte) -1;
        this.i = -1;
        this.b = AbstractC0604e.f3860a;
    }

    public F(C0605f c0605f, C0608i c0608i) {
        this.f440h = (byte) -1;
        this.i = -1;
        this.d = O.e;
        this.e = M.e;
        this.f438f = D.f427k;
        this.f439g = Collections.EMPTY_LIST;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        boolean z6 = false;
        char c = 0;
        while (!z6) {
            try {
                try {
                    int iN = c0605f.n();
                    if (iN != 0) {
                        C cD = null;
                        N n6 = null;
                        I i = null;
                        if (iN == 10) {
                            if ((this.c & 1) == 1) {
                                O o6 = this.d;
                                o6.getClass();
                                n6 = new N();
                                n6.c = kotlin.reflect.jvm.internal.impl.protobuf.s.b;
                                n6.c(o6);
                            }
                            O o7 = (O) c0605f.g(O.f473f, c0608i);
                            this.d = o7;
                            if (n6 != null) {
                                n6.c(o7);
                                this.d = n6.b();
                            }
                            this.c |= 1;
                        } else if (iN == 18) {
                            if ((this.c & 2) == 2) {
                                M m6 = this.e;
                                m6.getClass();
                                i = new I();
                                i.c = Collections.EMPTY_LIST;
                                i.c(m6);
                            }
                            M m7 = (M) c0605f.g(M.f471f, c0608i);
                            this.e = m7;
                            if (i != null) {
                                i.c(m7);
                                this.e = i.b();
                            }
                            this.c |= 2;
                        } else if (iN == 26) {
                            if ((this.c & 4) == 4) {
                                D d = this.f438f;
                                d.getClass();
                                cD = C.d();
                                cD.e(d);
                            }
                            D d6 = (D) c0605f.g(D.f428l, c0608i);
                            this.f438f = d6;
                            if (cD != null) {
                                cD.e(d6);
                                this.f438f = cD.c();
                            }
                            this.c |= 4;
                        } else if (iN != 34) {
                            if (!g(c0605f, c0606gJ, c0608i, iN)) {
                            }
                        } else {
                            int i3 = (c == true ? 1 : 0) & '\b';
                            c = c;
                            if (i3 != 8) {
                                this.f439g = new ArrayList();
                                c = '\b';
                            }
                            this.f439g.add(c0605f.g(C0111k.f622K, c0608i));
                        }
                    }
                    z6 = true;
                } catch (Throwable th) {
                    if (((c == true ? 1 : 0) & '\b') == 8) {
                        this.f439g = Collections.unmodifiableList(this.f439g);
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
            } catch (kotlin.reflect.jvm.internal.impl.protobuf.r e) {
                e.f3874a = this;
                throw e;
            } catch (IOException e6) {
                kotlin.reflect.jvm.internal.impl.protobuf.r rVar = new kotlin.reflect.jvm.internal.impl.protobuf.r(e6.getMessage());
                rVar.f3874a = this;
                throw rVar;
            }
        }
        if (((c == true ? 1 : 0) & '\b') == 8) {
            this.f439g = Collections.unmodifiableList(this.f439g);
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
