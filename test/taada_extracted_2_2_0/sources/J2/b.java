package J2;

import G2.C0101a;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignatureOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.protobuf.r;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends p implements JvmProtoBuf$JvmFieldSignatureOrBuilder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f831g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0101a f832h = new C0101a(24);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0604e f833a;
    public int b;
    public int c;
    public int d;
    public byte e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f834f;

    static {
        b bVar = new b();
        f831g = bVar;
        bVar.c = 0;
        bVar.d = 0;
    }

    public b() {
        this.e = (byte) -1;
        this.f834f = -1;
        this.f833a = AbstractC0604e.f3861a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f831g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f832h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.f834f;
        if (i != -1) {
            return i;
        }
        int iB = (this.b & 1) == 1 ? C0606g.b(1, this.c) : 0;
        if ((this.b & 2) == 2) {
            iB += C0606g.b(2, this.d);
        }
        int size = this.f833a.size() + iB;
        this.f834f = size;
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
        return new a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        a aVar = new a();
        aVar.c(this);
        return aVar;
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
        c0606g.r(this.f833a);
    }

    public b(a aVar) {
        this.e = (byte) -1;
        this.f834f = -1;
        this.f833a = aVar.f3870a;
    }

    public b(C0605f c0605f) {
        this.e = (byte) -1;
        this.f834f = -1;
        boolean z6 = false;
        this.c = 0;
        this.d = 0;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        while (!z6) {
            try {
                try {
                    int iN = c0605f.n();
                    if (iN != 0) {
                        if (iN == 8) {
                            this.b |= 1;
                            this.c = c0605f.k();
                        } else if (iN != 16) {
                            if (!c0605f.q(iN, c0606gJ)) {
                            }
                        } else {
                            this.b |= 2;
                            this.d = c0605f.k();
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
            this.f833a = c0603d.c();
        }
    }
}
