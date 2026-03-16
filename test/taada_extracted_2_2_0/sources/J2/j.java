package J2;

import G2.C0101a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$RecordOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.protobuf.r;
import kotlin.reflect.jvm.internal.impl.protobuf.u;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends p implements JvmProtoBuf$StringTableTypes$RecordOrBuilder {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final j f851m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final C0101a f852n = new C0101a(28);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0604e f853a;
    public int b;
    public int c;
    public int d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i f854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f856h;
    public List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f857j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte f858k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f859l;

    static {
        j jVar = new j();
        f851m = jVar;
        jVar.c = 1;
        jVar.d = 0;
        jVar.e = "";
        jVar.f854f = i.NONE;
        List list = Collections.EMPTY_LIST;
        jVar.f855g = list;
        jVar.i = list;
    }

    public j() {
        this.f856h = -1;
        this.f857j = -1;
        this.f858k = (byte) -1;
        this.f859l = -1;
        this.f853a = AbstractC0604e.f3861a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f851m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f852n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        AbstractC0604e uVar;
        int i = this.f859l;
        if (i != -1) {
            return i;
        }
        int iB = (this.b & 1) == 1 ? C0606g.b(1, this.c) : 0;
        if ((this.b & 2) == 2) {
            iB += C0606g.b(2, this.d);
        }
        if ((this.b & 8) == 8) {
            iB += C0606g.a(3, this.f854f.f850a);
        }
        int iC = 0;
        for (int i3 = 0; i3 < this.f855g.size(); i3++) {
            iC += C0606g.c(((Integer) this.f855g.get(i3)).intValue());
        }
        int iC2 = iB + iC;
        if (!this.f855g.isEmpty()) {
            iC2 = iC2 + 1 + C0606g.c(iC);
        }
        this.f856h = iC;
        int iC3 = 0;
        for (int i4 = 0; i4 < this.i.size(); i4++) {
            iC3 += C0606g.c(((Integer) this.i.get(i4)).intValue());
        }
        int size = iC2 + iC3;
        if (!this.i.isEmpty()) {
            size = size + 1 + C0606g.c(iC3);
        }
        this.f857j = iC3;
        if ((this.b & 4) == 4) {
            Object obj = this.e;
            if (obj instanceof String) {
                try {
                    uVar = new u(((String) obj).getBytes("UTF-8"));
                    this.e = uVar;
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException("UTF-8 not supported?", e);
                }
            } else {
                uVar = (AbstractC0604e) obj;
            }
            size += uVar.size() + C0606g.f(uVar.size()) + C0606g.h(6);
        }
        int size2 = this.f853a.size() + size;
        this.f859l = size2;
        return size2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        if (this.f858k == 1) {
            return true;
        }
        this.f858k = (byte) 1;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return h.c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        h hVarC = h.c();
        hVarC.d(this);
        return hVarC;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        AbstractC0604e uVar;
        getSerializedSize();
        if ((this.b & 1) == 1) {
            c0606g.m(1, this.c);
        }
        if ((this.b & 2) == 2) {
            c0606g.m(2, this.d);
        }
        if ((this.b & 8) == 8) {
            c0606g.l(3, this.f854f.f850a);
        }
        if (this.f855g.size() > 0) {
            c0606g.v(34);
            c0606g.v(this.f856h);
        }
        for (int i = 0; i < this.f855g.size(); i++) {
            c0606g.n(((Integer) this.f855g.get(i)).intValue());
        }
        if (this.i.size() > 0) {
            c0606g.v(42);
            c0606g.v(this.f857j);
        }
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            c0606g.n(((Integer) this.i.get(i3)).intValue());
        }
        if ((this.b & 4) == 4) {
            Object obj = this.e;
            if (obj instanceof String) {
                try {
                    uVar = new u(((String) obj).getBytes("UTF-8"));
                    this.e = uVar;
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException("UTF-8 not supported?", e);
                }
            } else {
                uVar = (AbstractC0604e) obj;
            }
            c0606g.x(6, 2);
            c0606g.v(uVar.size());
            c0606g.r(uVar);
        }
        c0606g.r(this.f853a);
    }

    public j(h hVar) {
        this.f856h = -1;
        this.f857j = -1;
        this.f858k = (byte) -1;
        this.f859l = -1;
        this.f853a = hVar.f3870a;
    }

    public j(C0605f c0605f) {
        i iVar;
        this.f856h = -1;
        this.f857j = -1;
        this.f858k = (byte) -1;
        this.f859l = -1;
        this.c = 1;
        boolean z6 = false;
        this.d = 0;
        this.e = "";
        i iVar2 = i.NONE;
        this.f854f = iVar2;
        List list = Collections.EMPTY_LIST;
        this.f855g = list;
        this.i = list;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        int i = 0;
        while (!z6) {
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
                        } else if (iN == 24) {
                            int iK = c0605f.k();
                            if (iK == 0) {
                                iVar = iVar2;
                            } else if (iK != 1) {
                                iVar = iK != 2 ? null : i.DESC_TO_CLASS_ID;
                            } else {
                                iVar = i.INTERNAL_TO_CLASS_ID;
                            }
                            if (iVar == null) {
                                c0606gJ.v(iN);
                                c0606gJ.v(iK);
                            } else {
                                this.b |= 8;
                                this.f854f = iVar;
                            }
                        } else if (iN == 32) {
                            if ((i & 16) != 16) {
                                this.f855g = new ArrayList();
                                i |= 16;
                            }
                            this.f855g.add(Integer.valueOf(c0605f.k()));
                        } else if (iN == 34) {
                            int iD = c0605f.d(c0605f.k());
                            if ((i & 16) != 16 && c0605f.b() > 0) {
                                this.f855g = new ArrayList();
                                i |= 16;
                            }
                            while (c0605f.b() > 0) {
                                this.f855g.add(Integer.valueOf(c0605f.k()));
                            }
                            c0605f.c(iD);
                        } else if (iN == 40) {
                            if ((i & 32) != 32) {
                                this.i = new ArrayList();
                                i |= 32;
                            }
                            this.i.add(Integer.valueOf(c0605f.k()));
                        } else if (iN == 42) {
                            int iD2 = c0605f.d(c0605f.k());
                            if ((i & 32) != 32 && c0605f.b() > 0) {
                                this.i = new ArrayList();
                                i |= 32;
                            }
                            while (c0605f.b() > 0) {
                                this.i.add(Integer.valueOf(c0605f.k()));
                            }
                            c0605f.c(iD2);
                        } else if (iN != 50) {
                            if (!c0605f.q(iN, c0606gJ)) {
                            }
                        } else {
                            u uVarE = c0605f.e();
                            this.b |= 4;
                            this.e = uVarE;
                        }
                    }
                    z6 = true;
                } catch (Throwable th) {
                    if ((i & 16) == 16) {
                        this.f855g = Collections.unmodifiableList(this.f855g);
                    }
                    if ((i & 32) == 32) {
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
            } catch (r e) {
                e.f3875a = this;
                throw e;
            } catch (IOException e6) {
                r rVar = new r(e6.getMessage());
                rVar.f3875a = this;
                throw rVar;
            }
        }
        if ((i & 16) == 16) {
            this.f855g = Collections.unmodifiableList(this.f855g);
        }
        if ((i & 32) == 32) {
            this.i = Collections.unmodifiableList(this.i);
        }
        try {
            c0606gJ.i();
        } catch (IOException unused2) {
        } finally {
            this.f853a = c0603d.c();
        }
    }
}
