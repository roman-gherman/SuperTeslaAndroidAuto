package J2;

import G2.C0101a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypesOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.protobuf.r;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends p implements JvmProtoBuf$StringTableTypesOrBuilder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k f860g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0101a f861h = new C0101a(27);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0604e f862a;
    public List b;
    public List c;
    public int d;
    public byte e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f863f;

    static {
        k kVar = new k();
        f860g = kVar;
        List list = Collections.EMPTY_LIST;
        kVar.b = list;
        kVar.c = list;
    }

    public k() {
        this.d = -1;
        this.e = (byte) -1;
        this.f863f = -1;
        this.f862a = AbstractC0604e.f3861a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f860g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f861h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.f863f;
        if (i != -1) {
            return i;
        }
        int iD = 0;
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            iD += C0606g.d(1, (MessageLite) this.b.get(i3));
        }
        int iC = 0;
        for (int i4 = 0; i4 < this.c.size(); i4++) {
            iC += C0606g.c(((Integer) this.c.get(i4)).intValue());
        }
        int iC2 = iD + iC;
        if (!this.c.isEmpty()) {
            iC2 = iC2 + 1 + C0606g.c(iC);
        }
        this.d = iC;
        int size = this.f862a.size() + iC2;
        this.f863f = size;
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
        g gVar = new g();
        List list = Collections.EMPTY_LIST;
        gVar.c = list;
        gVar.d = list;
        return gVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        g gVar = new g();
        List list = Collections.EMPTY_LIST;
        gVar.c = list;
        gVar.d = list;
        gVar.c(this);
        return gVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        for (int i = 0; i < this.b.size(); i++) {
            c0606g.o(1, (MessageLite) this.b.get(i));
        }
        if (this.c.size() > 0) {
            c0606g.v(42);
            c0606g.v(this.d);
        }
        for (int i3 = 0; i3 < this.c.size(); i3++) {
            c0606g.n(((Integer) this.c.get(i3)).intValue());
        }
        c0606g.r(this.f862a);
    }

    public k(g gVar) {
        this.d = -1;
        this.e = (byte) -1;
        this.f863f = -1;
        this.f862a = gVar.f3870a;
    }

    public k(C0605f c0605f, C0608i c0608i) {
        this.d = -1;
        this.e = (byte) -1;
        this.f863f = -1;
        List list = Collections.EMPTY_LIST;
        this.b = list;
        this.c = list;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        boolean z6 = false;
        int i = 0;
        while (!z6) {
            try {
                try {
                    int iN = c0605f.n();
                    if (iN != 0) {
                        if (iN == 10) {
                            if ((i & 1) != 1) {
                                this.b = new ArrayList();
                                i |= 1;
                            }
                            this.b.add(c0605f.g(j.f852n, c0608i));
                        } else if (iN == 40) {
                            if ((i & 2) != 2) {
                                this.c = new ArrayList();
                                i |= 2;
                            }
                            this.c.add(Integer.valueOf(c0605f.k()));
                        } else if (iN != 42) {
                            if (!c0605f.q(iN, c0606gJ)) {
                            }
                        } else {
                            int iD = c0605f.d(c0605f.k());
                            if ((i & 2) != 2 && c0605f.b() > 0) {
                                this.c = new ArrayList();
                                i |= 2;
                            }
                            while (c0605f.b() > 0) {
                                this.c.add(Integer.valueOf(c0605f.k()));
                            }
                            c0605f.c(iD);
                        }
                    }
                    z6 = true;
                } catch (r e) {
                    e.f3875a = this;
                    throw e;
                } catch (IOException e6) {
                    r rVar = new r(e6.getMessage());
                    rVar.f3875a = this;
                    throw rVar;
                }
            } catch (Throwable th) {
                if ((i & 1) == 1) {
                    this.b = Collections.unmodifiableList(this.b);
                }
                if ((i & 2) == 2) {
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
        if ((i & 1) == 1) {
            this.b = Collections.unmodifiableList(this.b);
        }
        if ((i & 2) == 2) {
            this.c = Collections.unmodifiableList(this.c);
        }
        try {
            c0606gJ.i();
        } catch (IOException unused2) {
        } finally {
            this.f862a = c0603d.c();
        }
    }
}
