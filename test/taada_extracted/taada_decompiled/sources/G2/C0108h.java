package G2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$AnnotationOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: renamed from: G2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0108h extends kotlin.reflect.jvm.internal.impl.protobuf.p implements ProtoBuf$AnnotationOrBuilder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0108h f588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0101a f589h = new C0101a(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0604e f590a;
    public int b;
    public int c;
    public List d;
    public byte e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f591f;

    static {
        C0108h c0108h = new C0108h();
        f588g = c0108h;
        c0108h.c = 0;
        c0108h.d = Collections.EMPTY_LIST;
    }

    public C0108h() {
        this.e = (byte) -1;
        this.f591f = -1;
        this.f590a = AbstractC0604e.f3860a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f588g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f589h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.f591f;
        if (i != -1) {
            return i;
        }
        int iB = (this.b & 1) == 1 ? C0606g.b(1, this.c) : 0;
        for (int i3 = 0; i3 < this.d.size(); i3++) {
            iB += C0606g.d(2, (MessageLite) this.d.get(i3));
        }
        int size = this.f590a.size() + iB;
        this.f591f = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.e;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if ((this.b & 1) != 1) {
            this.e = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.d.size(); i++) {
            if (!((C0106f) this.d.get(i)).isInitialized()) {
                this.e = (byte) 0;
                return false;
            }
        }
        this.e = (byte) 1;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        C0107g c0107g = new C0107g();
        c0107g.d = Collections.EMPTY_LIST;
        return c0107g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        C0107g c0107g = new C0107g();
        c0107g.d = Collections.EMPTY_LIST;
        c0107g.c(this);
        return c0107g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        if ((this.b & 1) == 1) {
            c0606g.m(1, this.c);
        }
        for (int i = 0; i < this.d.size(); i++) {
            c0606g.o(2, (MessageLite) this.d.get(i));
        }
        c0606g.r(this.f590a);
    }

    public C0108h(C0107g c0107g) {
        this.e = (byte) -1;
        this.f591f = -1;
        this.f590a = c0107g.f3869a;
    }

    public C0108h(C0605f c0605f, C0608i c0608i) {
        this.e = (byte) -1;
        this.f591f = -1;
        boolean z6 = false;
        this.c = 0;
        this.d = Collections.EMPTY_LIST;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        char c = 0;
        while (!z6) {
            try {
                try {
                    try {
                        int iN = c0605f.n();
                        if (iN != 0) {
                            if (iN == 8) {
                                this.b |= 1;
                                this.c = c0605f.k();
                            } else if (iN != 18) {
                                if (!c0605f.q(iN, c0606gJ)) {
                                }
                            } else {
                                if ((c & 2) != 2) {
                                    this.d = new ArrayList();
                                    c = 2;
                                }
                                this.d.add(c0605f.g(C0106f.f583h, c0608i));
                            }
                        }
                        z6 = true;
                    } catch (kotlin.reflect.jvm.internal.impl.protobuf.r e) {
                        e.f3874a = this;
                        throw e;
                    }
                } catch (IOException e6) {
                    kotlin.reflect.jvm.internal.impl.protobuf.r rVar = new kotlin.reflect.jvm.internal.impl.protobuf.r(e6.getMessage());
                    rVar.f3874a = this;
                    throw rVar;
                }
            } catch (Throwable th) {
                if ((c & 2) == 2) {
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
        if ((c & 2) == 2) {
            this.d = Collections.unmodifiableList(this.d);
        }
        try {
            c0606gJ.i();
        } catch (IOException unused2) {
        } finally {
            this.f590a = c0603d.c();
        }
    }
}
