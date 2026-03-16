package G2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAliasOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m;
import kotlin.reflect.jvm.internal.impl.protobuf.C0603d;
import kotlin.reflect.jvm.internal.impl.protobuf.C0605f;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: classes2.dex */
public final class W extends AbstractC0612m implements ProtoBuf$TypeAliasOrBuilder {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final W f512o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final C0101a f513p = new C0101a(18);
    public final AbstractC0604e b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public U f515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f516h;
    public U i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f517j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f518k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f519l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte f520m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f521n;

    static {
        W w5 = new W();
        f512o = w5;
        w5.d = 6;
        w5.e = 0;
        List list = Collections.EMPTY_LIST;
        w5.f514f = list;
        U u = U.f492t;
        w5.f515g = u;
        w5.f516h = 0;
        w5.i = u;
        w5.f517j = 0;
        w5.f518k = list;
        w5.f519l = list;
    }

    public W(V v6) {
        super(v6);
        this.f520m = (byte) -1;
        this.f521n = -1;
        this.b = v6.f3870a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return f512o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f513p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.f521n;
        if (i != -1) {
            return i;
        }
        int iB = (this.c & 1) == 1 ? C0606g.b(1, this.d) : 0;
        if ((this.c & 2) == 2) {
            iB += C0606g.b(2, this.e);
        }
        for (int i3 = 0; i3 < this.f514f.size(); i3++) {
            iB += C0606g.d(3, (MessageLite) this.f514f.get(i3));
        }
        if ((this.c & 4) == 4) {
            iB += C0606g.d(4, this.f515g);
        }
        if ((this.c & 8) == 8) {
            iB += C0606g.b(5, this.f516h);
        }
        if ((this.c & 16) == 16) {
            iB += C0606g.d(6, this.i);
        }
        if ((this.c & 32) == 32) {
            iB += C0606g.b(7, this.f517j);
        }
        for (int i4 = 0; i4 < this.f518k.size(); i4++) {
            iB += C0606g.d(8, (MessageLite) this.f518k.get(i4));
        }
        int iC = 0;
        for (int i5 = 0; i5 < this.f519l.size(); i5++) {
            iC += C0606g.c(((Integer) this.f519l.get(i5)).intValue());
        }
        int size = this.b.size() + c() + (this.f519l.size() * 2) + iB + iC;
        this.f521n = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f520m;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if ((this.c & 2) != 2) {
            this.f520m = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.f514f.size(); i++) {
            if (!((Z) this.f514f.get(i)).isInitialized()) {
                this.f520m = (byte) 0;
                return false;
            }
        }
        if ((this.c & 4) == 4 && !this.f515g.isInitialized()) {
            this.f520m = (byte) 0;
            return false;
        }
        if ((this.c & 16) == 16 && !this.i.isInitialized()) {
            this.f520m = (byte) 0;
            return false;
        }
        for (int i3 = 0; i3 < this.f518k.size(); i3++) {
            if (!((C0108h) this.f518k.get(i3)).isInitialized()) {
                this.f520m = (byte) 0;
                return false;
            }
        }
        if (this.f3871a.e()) {
            this.f520m = (byte) 1;
            return true;
        }
        this.f520m = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return V.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        V vD = V.d();
        vD.e(this);
        return vD;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        B.h hVar = new B.h(this);
        if ((this.c & 1) == 1) {
            c0606g.m(1, this.d);
        }
        if ((this.c & 2) == 2) {
            c0606g.m(2, this.e);
        }
        for (int i = 0; i < this.f514f.size(); i++) {
            c0606g.o(3, (MessageLite) this.f514f.get(i));
        }
        if ((this.c & 4) == 4) {
            c0606g.o(4, this.f515g);
        }
        if ((this.c & 8) == 8) {
            c0606g.m(5, this.f516h);
        }
        if ((this.c & 16) == 16) {
            c0606g.o(6, this.i);
        }
        if ((this.c & 32) == 32) {
            c0606g.m(7, this.f517j);
        }
        for (int i3 = 0; i3 < this.f518k.size(); i3++) {
            c0606g.o(8, (MessageLite) this.f518k.get(i3));
        }
        for (int i4 = 0; i4 < this.f519l.size(); i4++) {
            c0606g.m(31, ((Integer) this.f519l.get(i4)).intValue());
        }
        hVar.q(200, c0606g);
        c0606g.r(this.b);
    }

    public W() {
        this.f520m = (byte) -1;
        this.f521n = -1;
        this.b = AbstractC0604e.f3861a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    public W(C0605f c0605f, C0608i c0608i) {
        this.f520m = (byte) -1;
        this.f521n = -1;
        this.d = 6;
        boolean z6 = false;
        this.e = 0;
        List list = Collections.EMPTY_LIST;
        this.f514f = list;
        U u = U.f492t;
        this.f515g = u;
        this.f516h = 0;
        this.i = u;
        this.f517j = 0;
        this.f518k = list;
        this.f519l = list;
        C0603d c0603d = new C0603d();
        C0606g c0606gJ = C0606g.j(c0603d, 1);
        int i = 0;
        while (true) {
            ?? G5 = 128;
            if (!z6) {
                try {
                    try {
                        try {
                            int iN = c0605f.n();
                            T tK = null;
                            switch (iN) {
                                case 0:
                                    z6 = true;
                                    break;
                                case 8:
                                    this.c |= 1;
                                    this.d = c0605f.k();
                                    break;
                                case 16:
                                    this.c |= 2;
                                    this.e = c0605f.k();
                                    break;
                                case 26:
                                    if ((i & 4) != 4) {
                                        this.f514f = new ArrayList();
                                        i |= 4;
                                    }
                                    this.f514f.add(c0605f.g(Z.f528n, c0608i));
                                    break;
                                case 34:
                                    if ((this.c & 4) == 4) {
                                        U u2 = this.f515g;
                                        u2.getClass();
                                        tK = U.k(u2);
                                    }
                                    U u6 = (U) c0605f.g(U.u, c0608i);
                                    this.f515g = u6;
                                    if (tK != null) {
                                        tK.e(u6);
                                        this.f515g = tK.c();
                                    }
                                    this.c |= 4;
                                    break;
                                case 40:
                                    this.c |= 8;
                                    this.f516h = c0605f.k();
                                    break;
                                case 50:
                                    if ((this.c & 16) == 16) {
                                        U u7 = this.i;
                                        u7.getClass();
                                        tK = U.k(u7);
                                    }
                                    U u8 = (U) c0605f.g(U.u, c0608i);
                                    this.i = u8;
                                    if (tK != null) {
                                        tK.e(u8);
                                        this.i = tK.c();
                                    }
                                    this.c |= 16;
                                    break;
                                case 56:
                                    this.c |= 32;
                                    this.f517j = c0605f.k();
                                    break;
                                case 66:
                                    if ((i & 128) != 128) {
                                        this.f518k = new ArrayList();
                                        i |= 128;
                                    }
                                    this.f518k.add(c0605f.g(C0108h.f589h, c0608i));
                                    break;
                                case KEYCODE_TV_INPUT_COMPOSITE_2_VALUE:
                                    if ((i & 256) != 256) {
                                        this.f519l = new ArrayList();
                                        i |= 256;
                                    }
                                    this.f519l.add(Integer.valueOf(c0605f.k()));
                                    break;
                                case 250:
                                    int iD = c0605f.d(c0605f.k());
                                    if ((i & 256) != 256 && c0605f.b() > 0) {
                                        this.f519l = new ArrayList();
                                        i |= 256;
                                    }
                                    while (c0605f.b() > 0) {
                                        this.f519l.add(Integer.valueOf(c0605f.k()));
                                    }
                                    c0605f.c(iD);
                                    break;
                                default:
                                    G5 = g(c0605f, c0606gJ, c0608i, iN);
                                    if (G5 == 0) {
                                        z6 = true;
                                    }
                                    break;
                            }
                        } catch (IOException e) {
                            kotlin.reflect.jvm.internal.impl.protobuf.r rVar = new kotlin.reflect.jvm.internal.impl.protobuf.r(e.getMessage());
                            rVar.f3875a = this;
                            throw rVar;
                        }
                    } catch (kotlin.reflect.jvm.internal.impl.protobuf.r e6) {
                        e6.f3875a = this;
                        throw e6;
                    }
                } catch (Throwable th) {
                    if ((i & 4) == 4) {
                        this.f514f = Collections.unmodifiableList(this.f514f);
                    }
                    if ((i & 128) == G5) {
                        this.f518k = Collections.unmodifiableList(this.f518k);
                    }
                    if ((i & 256) == 256) {
                        this.f519l = Collections.unmodifiableList(this.f519l);
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
            } else {
                if ((i & 4) == 4) {
                    this.f514f = Collections.unmodifiableList(this.f514f);
                }
                if ((i & 128) == 128) {
                    this.f518k = Collections.unmodifiableList(this.f518k);
                }
                if ((i & 256) == 256) {
                    this.f519l = Collections.unmodifiableList(this.f519l);
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
                return;
            }
        }
    }
}
