package G2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EffectOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: renamed from: G2.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0118s extends kotlin.reflect.jvm.internal.impl.protobuf.p implements ProtoBuf$EffectOrBuilder {
    public static final C0118s i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0101a f656j = new C0101a(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0604e f657a;
    public int b;
    public EnumC0117q c;
    public List d;
    public C0123x e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r f658f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte f659g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f660h;

    static {
        C0118s c0118s = new C0118s();
        i = c0118s;
        c0118s.c = EnumC0117q.RETURNS_CONSTANT;
        c0118s.d = Collections.EMPTY_LIST;
        c0118s.e = C0123x.f668l;
        c0118s.f658f = r.AT_MOST_ONCE;
    }

    public C0118s() {
        this.f659g = (byte) -1;
        this.f660h = -1;
        this.f657a = AbstractC0604e.f3860a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f656j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i3 = this.f660h;
        if (i3 != -1) {
            return i3;
        }
        int iA = (this.b & 1) == 1 ? C0606g.a(1, this.c.f654a) : 0;
        for (int i4 = 0; i4 < this.d.size(); i4++) {
            iA += C0606g.d(2, (MessageLite) this.d.get(i4));
        }
        if ((this.b & 2) == 2) {
            iA += C0606g.d(3, this.e);
        }
        if ((this.b & 4) == 4) {
            iA += C0606g.a(4, this.f658f.f655a);
        }
        int size = this.f657a.size() + iA;
        this.f660h = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f659g;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        for (int i3 = 0; i3 < this.d.size(); i3++) {
            if (!((C0123x) this.d.get(i3)).isInitialized()) {
                this.f659g = (byte) 0;
                return false;
            }
        }
        if ((this.b & 2) != 2 || this.e.isInitialized()) {
            this.f659g = (byte) 1;
            return true;
        }
        this.f659g = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return C0116p.c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        C0116p c0116pC = C0116p.c();
        c0116pC.d(this);
        return c0116pC;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        if ((this.b & 1) == 1) {
            c0606g.l(1, this.c.f654a);
        }
        for (int i3 = 0; i3 < this.d.size(); i3++) {
            c0606g.o(2, (MessageLite) this.d.get(i3));
        }
        if ((this.b & 2) == 2) {
            c0606g.o(3, this.e);
        }
        if ((this.b & 4) == 4) {
            c0606g.l(4, this.f658f.f655a);
        }
        c0606g.r(this.f657a);
    }

    public C0118s(C0116p c0116p) {
        this.f659g = (byte) -1;
        this.f660h = -1;
        this.f657a = c0116p.f3869a;
    }

    public C0118s(C0605f c0605f, C0608i c0608i) {
        this.f659g = (byte) -1;
        this.f660h = -1;
        EnumC0117q enumC0117q = EnumC0117q.RETURNS_CONSTANT;
        this.c = enumC0117q;
        this.d = Collections.EMPTY_LIST;
        this.e = C0123x.f668l;
        r rVar = r.AT_MOST_ONCE;
        this.f658f = rVar;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        boolean z6 = false;
        char c = 0;
        while (!z6) {
            try {
                try {
                    try {
                        int iN = c0605f.n();
                        if (iN != 0) {
                            r rVar2 = null;
                            EnumC0117q enumC0117q2 = null;
                            C0121v c0121vC = null;
                            if (iN == 8) {
                                int iK = c0605f.k();
                                if (iK == 0) {
                                    enumC0117q2 = enumC0117q;
                                } else if (iK == 1) {
                                    enumC0117q2 = EnumC0117q.CALLS;
                                } else if (iK == 2) {
                                    enumC0117q2 = EnumC0117q.RETURNS_NOT_NULL;
                                }
                                if (enumC0117q2 == null) {
                                    c0606gJ.v(iN);
                                    c0606gJ.v(iK);
                                } else {
                                    this.b |= 1;
                                    this.c = enumC0117q2;
                                }
                            } else if (iN == 18) {
                                int i3 = (c == true ? 1 : 0) & 2;
                                c = c;
                                if (i3 != 2) {
                                    this.d = new ArrayList();
                                    c = 2;
                                }
                                this.d.add(c0605f.g(C0123x.f669m, c0608i));
                            } else if (iN == 26) {
                                if ((this.b & 2) == 2) {
                                    C0123x c0123x = this.e;
                                    c0123x.getClass();
                                    c0121vC = C0121v.c();
                                    c0121vC.d(c0123x);
                                }
                                C0123x c0123x2 = (C0123x) c0605f.g(C0123x.f669m, c0608i);
                                this.e = c0123x2;
                                if (c0121vC != null) {
                                    c0121vC.d(c0123x2);
                                    this.e = c0121vC.b();
                                }
                                this.b |= 2;
                            } else if (iN != 32) {
                                if (!c0605f.q(iN, c0606gJ)) {
                                }
                            } else {
                                int iK2 = c0605f.k();
                                if (iK2 == 0) {
                                    rVar2 = rVar;
                                } else if (iK2 == 1) {
                                    rVar2 = r.EXACTLY_ONCE;
                                } else if (iK2 == 2) {
                                    rVar2 = r.AT_LEAST_ONCE;
                                }
                                if (rVar2 == null) {
                                    c0606gJ.v(iN);
                                    c0606gJ.v(iK2);
                                } else {
                                    this.b |= 4;
                                    this.f658f = rVar2;
                                }
                            }
                        }
                        z6 = true;
                    } catch (IOException e) {
                        kotlin.reflect.jvm.internal.impl.protobuf.r rVar3 = new kotlin.reflect.jvm.internal.impl.protobuf.r(e.getMessage());
                        rVar3.f3874a = this;
                        throw rVar3;
                    }
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.r e6) {
                    e6.f3874a = this;
                    throw e6;
                }
            } catch (Throwable th) {
                if (((c == true ? 1 : 0) & 2) == 2) {
                    this.d = Collections.unmodifiableList(this.d);
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
        if (((c == true ? 1 : 0) & 2) == 2) {
            this.d = Collections.unmodifiableList(this.d);
        }
        try {
            c0606gJ.i();
        } catch (IOException unused2) {
        } finally {
            this.f657a = c0603d.c();
        }
    }
}
