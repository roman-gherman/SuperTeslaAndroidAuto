package G2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTableOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 extends kotlin.reflect.jvm.internal.impl.protobuf.p implements ProtoBuf$VersionRequirementTableOrBuilder {
    public static final j0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0101a f620f = new C0101a(23);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0604e f621a;
    public List b;
    public byte c;
    public int d;

    static {
        j0 j0Var = new j0();
        e = j0Var;
        j0Var.b = Collections.EMPTY_LIST;
    }

    public j0() {
        this.c = (byte) -1;
        this.d = -1;
        this.f621a = AbstractC0604e.f3861a;
    }

    public final i0 c() {
        i0 i0Var = new i0();
        i0Var.c = Collections.EMPTY_LIST;
        i0Var.c(this);
        return i0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f620f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iD = 0;
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            iD += C0606g.d(1, (MessageLite) this.b.get(i3));
        }
        int size = this.f621a.size() + iD;
        this.d = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        if (this.c == 1) {
            return true;
        }
        this.c = (byte) 1;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        i0 i0Var = new i0();
        i0Var.c = Collections.EMPTY_LIST;
        return i0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        i0 i0Var = new i0();
        i0Var.c = Collections.EMPTY_LIST;
        i0Var.c(this);
        return i0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        for (int i = 0; i < this.b.size(); i++) {
            c0606g.o(1, (MessageLite) this.b.get(i));
        }
        c0606g.r(this.f621a);
    }

    public j0(i0 i0Var) {
        this.c = (byte) -1;
        this.d = -1;
        this.f621a = i0Var.f3870a;
    }

    public j0(C0605f c0605f, C0608i c0608i) {
        this.c = (byte) -1;
        this.d = -1;
        this.b = Collections.EMPTY_LIST;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        boolean z6 = false;
        boolean z7 = false;
        while (!z6) {
            try {
                try {
                    int iN = c0605f.n();
                    if (iN != 0) {
                        if (iN != 10) {
                            if (!c0605f.q(iN, c0606gJ)) {
                            }
                        } else {
                            if (!z7) {
                                this.b = new ArrayList();
                                z7 = true;
                            }
                            this.b.add(c0605f.g(h0.f593l, c0608i));
                        }
                    }
                    z6 = true;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.r e6) {
                    e6.f3875a = this;
                    throw e6;
                } catch (IOException e7) {
                    kotlin.reflect.jvm.internal.impl.protobuf.r rVar = new kotlin.reflect.jvm.internal.impl.protobuf.r(e7.getMessage());
                    rVar.f3875a = this;
                    throw rVar;
                }
            } catch (Throwable th) {
                if (z7) {
                    this.b = Collections.unmodifiableList(this.b);
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
            this.b = Collections.unmodifiableList(this.b);
        }
        try {
            c0606gJ.i();
        } catch (IOException unused2) {
        } finally {
            this.f621a = c0603d.c();
        }
    }
}
