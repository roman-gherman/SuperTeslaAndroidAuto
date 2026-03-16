package J2;

import G2.C0101a;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignatureOrBuilder;
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
public final class f extends p implements JvmProtoBuf$JvmPropertySignatureOrBuilder {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final f f841j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C0101a f842k = new C0101a(26);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0604e f843a;
    public int b;
    public b c;
    public d d;
    public d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f845g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte f846h;
    public int i;

    static {
        f fVar = new f();
        f841j = fVar;
        fVar.c = b.f831g;
        d dVar = d.f835g;
        fVar.d = dVar;
        fVar.e = dVar;
        fVar.f844f = dVar;
        fVar.f845g = dVar;
    }

    public f() {
        this.f846h = (byte) -1;
        this.i = -1;
        this.f843a = AbstractC0604e.f3860a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f841j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f842k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.i;
        if (i != -1) {
            return i;
        }
        int iD = (this.b & 1) == 1 ? C0606g.d(1, this.c) : 0;
        if ((this.b & 2) == 2) {
            iD += C0606g.d(2, this.d);
        }
        if ((this.b & 4) == 4) {
            iD += C0606g.d(3, this.e);
        }
        if ((this.b & 8) == 8) {
            iD += C0606g.d(4, this.f844f);
        }
        if ((this.b & 16) == 16) {
            iD += C0606g.d(5, this.f845g);
        }
        int size = this.f843a.size() + iD;
        this.i = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        if (this.f846h == 1) {
            return true;
        }
        this.f846h = (byte) 1;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return e.c();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        e eVarC = e.c();
        eVarC.d(this);
        return eVarC;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        if ((this.b & 1) == 1) {
            c0606g.o(1, this.c);
        }
        if ((this.b & 2) == 2) {
            c0606g.o(2, this.d);
        }
        if ((this.b & 4) == 4) {
            c0606g.o(3, this.e);
        }
        if ((this.b & 8) == 8) {
            c0606g.o(4, this.f844f);
        }
        if ((this.b & 16) == 16) {
            c0606g.o(5, this.f845g);
        }
        c0606g.r(this.f843a);
    }

    public f(e eVar) {
        this.f846h = (byte) -1;
        this.i = -1;
        this.f843a = eVar.f3869a;
    }

    public f(C0605f c0605f, C0608i c0608i) {
        this.f846h = (byte) -1;
        this.i = -1;
        this.c = b.f831g;
        d dVar = d.f835g;
        this.d = dVar;
        this.e = dVar;
        this.f844f = dVar;
        this.f845g = dVar;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        boolean z6 = false;
        while (!z6) {
            try {
                try {
                    int iN = c0605f.n();
                    if (iN != 0) {
                        c cVarC = null;
                        a aVar = null;
                        c cVarC2 = null;
                        c cVarC3 = null;
                        c cVarC4 = null;
                        if (iN == 10) {
                            if ((this.b & 1) == 1) {
                                b bVar = this.c;
                                bVar.getClass();
                                aVar = new a();
                                aVar.c(bVar);
                            }
                            b bVar2 = (b) c0605f.g(b.f832h, c0608i);
                            this.c = bVar2;
                            if (aVar != null) {
                                aVar.c(bVar2);
                                this.c = aVar.b();
                            }
                            this.b |= 1;
                        } else if (iN == 18) {
                            if ((this.b & 2) == 2) {
                                d dVar2 = this.d;
                                dVar2.getClass();
                                cVarC2 = d.c(dVar2);
                            }
                            d dVar3 = (d) c0605f.g(d.f836h, c0608i);
                            this.d = dVar3;
                            if (cVarC2 != null) {
                                cVarC2.c(dVar3);
                                this.d = cVarC2.b();
                            }
                            this.b |= 2;
                        } else if (iN == 26) {
                            if ((this.b & 4) == 4) {
                                d dVar4 = this.e;
                                dVar4.getClass();
                                cVarC3 = d.c(dVar4);
                            }
                            d dVar5 = (d) c0605f.g(d.f836h, c0608i);
                            this.e = dVar5;
                            if (cVarC3 != null) {
                                cVarC3.c(dVar5);
                                this.e = cVarC3.b();
                            }
                            this.b |= 4;
                        } else if (iN == 34) {
                            if ((this.b & 8) == 8) {
                                d dVar6 = this.f844f;
                                dVar6.getClass();
                                cVarC4 = d.c(dVar6);
                            }
                            d dVar7 = (d) c0605f.g(d.f836h, c0608i);
                            this.f844f = dVar7;
                            if (cVarC4 != null) {
                                cVarC4.c(dVar7);
                                this.f844f = cVarC4.b();
                            }
                            this.b |= 8;
                        } else if (iN != 42) {
                            if (!c0605f.q(iN, c0606gJ)) {
                            }
                        } else {
                            if ((this.b & 16) == 16) {
                                d dVar8 = this.f845g;
                                dVar8.getClass();
                                cVarC = d.c(dVar8);
                            }
                            d dVar9 = (d) c0605f.g(d.f836h, c0608i);
                            this.f845g = dVar9;
                            if (cVarC != null) {
                                cVarC.c(dVar9);
                                this.f845g = cVarC.b();
                            }
                            this.b |= 16;
                        }
                    }
                    z6 = true;
                } catch (r e) {
                    e.f3874a = this;
                    throw e;
                } catch (IOException e6) {
                    r rVar = new r(e6.getMessage());
                    rVar.f3874a = this;
                    throw rVar;
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
            this.f843a = c0603d.c();
        }
    }
}
