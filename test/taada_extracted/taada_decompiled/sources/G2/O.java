package G2;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTableOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: classes2.dex */
public final class O extends kotlin.reflect.jvm.internal.impl.protobuf.p implements ProtoBuf$StringTableOrBuilder {
    public static final O e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0101a f473f = new C0101a(15);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0604e f474a;
    public LazyStringList b;
    public byte c;
    public int d;

    static {
        O o6 = new O();
        e = o6;
        o6.b = kotlin.reflect.jvm.internal.impl.protobuf.s.b;
    }

    public O() {
        this.c = (byte) -1;
        this.d = -1;
        this.f474a = AbstractC0604e.f3860a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f473f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int size = 0;
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            AbstractC0604e byteString = this.b.getByteString(i3);
            size += byteString.size() + C0606g.f(byteString.size());
        }
        int size2 = this.f474a.size() + this.b.size() + size;
        this.d = size2;
        return size2;
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
        N n6 = new N();
        n6.c = kotlin.reflect.jvm.internal.impl.protobuf.s.b;
        return n6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        N n6 = new N();
        n6.c = kotlin.reflect.jvm.internal.impl.protobuf.s.b;
        n6.c(this);
        return n6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        for (int i = 0; i < this.b.size(); i++) {
            AbstractC0604e byteString = this.b.getByteString(i);
            c0606g.x(1, 2);
            c0606g.v(byteString.size());
            c0606g.r(byteString);
        }
        c0606g.r(this.f474a);
    }

    public O(N n6) {
        this.c = (byte) -1;
        this.d = -1;
        this.f474a = n6.f3869a;
    }

    public O(C0605f c0605f) {
        this.c = (byte) -1;
        this.d = -1;
        this.b = kotlin.reflect.jvm.internal.impl.protobuf.s.b;
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
                            kotlin.reflect.jvm.internal.impl.protobuf.u uVarE = c0605f.e();
                            if (!z7) {
                                this.b = new kotlin.reflect.jvm.internal.impl.protobuf.s();
                                z7 = true;
                            }
                            this.b.add((AbstractC0604e) uVarE);
                        }
                    }
                    z6 = true;
                } catch (Throwable th) {
                    if (z7) {
                        this.b = this.b.getUnmodifiableView();
                    }
                    try {
                        c0606gJ.i();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        throw th2;
                    }
                    throw th;
                }
            } catch (kotlin.reflect.jvm.internal.impl.protobuf.r e6) {
                e6.f3874a = this;
                throw e6;
            } catch (IOException e7) {
                kotlin.reflect.jvm.internal.impl.protobuf.r rVar = new kotlin.reflect.jvm.internal.impl.protobuf.r(e7.getMessage());
                rVar.f3874a = this;
                throw rVar;
            }
        }
        if (z7) {
            this.b = this.b.getUnmodifiableView();
        }
        try {
            c0606gJ.i();
        } catch (IOException unused2) {
        } finally {
            this.f474a = c0603d.c();
        }
    }
}
