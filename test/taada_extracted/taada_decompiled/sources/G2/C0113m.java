package G2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ConstructorOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: renamed from: G2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0113m extends AbstractC0612m implements ProtoBuf$ConstructorOrBuilder {
    public static final C0113m i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0101a f647j = new C0101a(4);
    public final AbstractC0604e b;
    public int c;
    public int d;
    public List e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte f649g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f650h;

    static {
        C0113m c0113m = new C0113m();
        i = c0113m;
        c0113m.d = 6;
        List list = Collections.EMPTY_LIST;
        c0113m.e = list;
        c0113m.f648f = list;
    }

    public C0113m(C0112l c0112l) {
        super(c0112l);
        this.f649g = (byte) -1;
        this.f650h = -1;
        this.b = c0112l.f3869a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f647j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i3 = this.f650h;
        if (i3 != -1) {
            return i3;
        }
        int iB = (this.c & 1) == 1 ? C0606g.b(1, this.d) : 0;
        for (int i4 = 0; i4 < this.e.size(); i4++) {
            iB += C0606g.d(2, (MessageLite) this.e.get(i4));
        }
        int iC = 0;
        for (int i5 = 0; i5 < this.f648f.size(); i5++) {
            iC += C0606g.c(((Integer) this.f648f.get(i5)).intValue());
        }
        int size = this.b.size() + c() + (this.f648f.size() * 2) + iB + iC;
        this.f650h = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f649g;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        for (int i3 = 0; i3 < this.e.size(); i3++) {
            if (!((d0) this.e.get(i3)).isInitialized()) {
                this.f649g = (byte) 0;
                return false;
            }
        }
        if (this.f3870a.e()) {
            this.f649g = (byte) 1;
            return true;
        }
        this.f649g = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return C0112l.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        C0112l c0112lD = C0112l.d();
        c0112lD.e(this);
        return c0112lD;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        B.h hVar = new B.h(this);
        if ((this.c & 1) == 1) {
            c0606g.m(1, this.d);
        }
        for (int i3 = 0; i3 < this.e.size(); i3++) {
            c0606g.o(2, (MessageLite) this.e.get(i3));
        }
        for (int i4 = 0; i4 < this.f648f.size(); i4++) {
            c0606g.m(31, ((Integer) this.f648f.get(i4)).intValue());
        }
        hVar.q(19000, c0606g);
        c0606g.r(this.b);
    }

    public C0113m() {
        this.f649g = (byte) -1;
        this.f650h = -1;
        this.b = AbstractC0604e.f3860a;
    }

    public C0113m(C0605f c0605f, C0608i c0608i) {
        this.f649g = (byte) -1;
        this.f650h = -1;
        this.d = 6;
        List list = Collections.EMPTY_LIST;
        this.e = list;
        this.f648f = list;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        boolean z6 = false;
        int i3 = 0;
        while (!z6) {
            try {
                try {
                    int iN = c0605f.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.c |= 1;
                            this.d = c0605f.k();
                        } else if (iN == 18) {
                            if ((i3 & 2) != 2) {
                                this.e = new ArrayList();
                                i3 |= 2;
                            }
                            this.e.add(c0605f.g(d0.f562m, c0608i));
                        } else if (iN == 248) {
                            if ((i3 & 4) != 4) {
                                this.f648f = new ArrayList();
                                i3 |= 4;
                            }
                            this.f648f.add(Integer.valueOf(c0605f.k()));
                        } else if (iN != 250) {
                            if (!g(c0605f, c0606gJ, c0608i, iN)) {
                            }
                        } else {
                            int iD = c0605f.d(c0605f.k());
                            if ((i3 & 4) != 4 && c0605f.b() > 0) {
                                this.f648f = new ArrayList();
                                i3 |= 4;
                            }
                            while (c0605f.b() > 0) {
                                this.f648f.add(Integer.valueOf(c0605f.k()));
                            }
                            c0605f.c(iD);
                        }
                    }
                    z6 = true;
                } catch (Throwable th) {
                    if ((i3 & 2) == 2) {
                        this.e = Collections.unmodifiableList(this.e);
                    }
                    if ((i3 & 4) == 4) {
                        this.f648f = Collections.unmodifiableList(this.f648f);
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
        if ((i3 & 2) == 2) {
            this.e = Collections.unmodifiableList(this.e);
        }
        if ((i3 & 4) == 4) {
            this.f648f = Collections.unmodifiableList(this.f648f);
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
