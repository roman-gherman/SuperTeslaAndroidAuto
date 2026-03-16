package G2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ContractOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: renamed from: G2.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0115o extends kotlin.reflect.jvm.internal.impl.protobuf.p implements ProtoBuf$ContractOrBuilder {
    public static final C0115o e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0101a f651f = new C0101a(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0604e f652a;
    public List b;
    public byte c;
    public int d;

    static {
        C0115o c0115o = new C0115o();
        e = c0115o;
        c0115o.b = Collections.EMPTY_LIST;
    }

    public C0115o() {
        this.c = (byte) -1;
        this.d = -1;
        this.f652a = AbstractC0604e.f3861a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f651f;
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
        int size = this.f652a.size() + iD;
        this.d = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.c;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        for (int i = 0; i < this.b.size(); i++) {
            if (!((C0118s) this.b.get(i)).isInitialized()) {
                this.c = (byte) 0;
                return false;
            }
        }
        this.c = (byte) 1;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        C0114n c0114n = new C0114n();
        c0114n.c = Collections.EMPTY_LIST;
        return c0114n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        C0114n c0114n = new C0114n();
        c0114n.c = Collections.EMPTY_LIST;
        c0114n.c(this);
        return c0114n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        for (int i = 0; i < this.b.size(); i++) {
            c0606g.o(1, (MessageLite) this.b.get(i));
        }
        c0606g.r(this.f652a);
    }

    public C0115o(C0114n c0114n) {
        this.c = (byte) -1;
        this.d = -1;
        this.f652a = c0114n.f3870a;
    }

    public C0115o(C0605f c0605f, C0608i c0608i) {
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
                            this.b.add(c0605f.g(C0118s.f656j, c0608i));
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
            this.f652a = c0603d.c();
        }
    }
}
