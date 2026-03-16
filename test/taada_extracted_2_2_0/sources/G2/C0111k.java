package G2;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ClassOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0604e;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: renamed from: G2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0111k extends AbstractC0612m implements ProtoBuf$ClassOrBuilder {
    public static final C0111k J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static final C0101a f622K = new C0101a(3);

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f623A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public List f624B;
    public List C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public int f625D;
    public b0 E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public List f626F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public j0 f627G;
    public byte H;
    public int I;
    public final AbstractC0604e b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f628f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f629g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f630h;
    public List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f631j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f632k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f633l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f634m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f635n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f636o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List f637p;
    public List q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List f638r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List f639s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List f640t;
    public List u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f641v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f642w;
    public U x;
    public int y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List f643z;

    static {
        C0111k c0111k = new C0111k();
        J = c0111k;
        c0111k.i();
    }

    public C0111k(C0109i c0109i) {
        super(c0109i);
        this.f631j = -1;
        this.f633l = -1;
        this.f636o = -1;
        this.f641v = -1;
        this.f623A = -1;
        this.f625D = -1;
        this.H = (byte) -1;
        this.I = -1;
        this.b = c0109i.f3870a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final MessageLite getDefaultInstanceForType() {
        return J;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final Parser getParserForType() {
        return f622K;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = this.I;
        if (i != -1) {
            return i;
        }
        int iB = (this.c & 1) == 1 ? C0606g.b(1, this.d) : 0;
        int iC = 0;
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            iC += C0606g.c(((Integer) this.i.get(i3)).intValue());
        }
        int iD = iB + iC;
        if (!this.i.isEmpty()) {
            iD = iD + 1 + C0606g.c(iC);
        }
        this.f631j = iC;
        if ((this.c & 2) == 2) {
            iD += C0606g.b(3, this.e);
        }
        if ((this.c & 4) == 4) {
            iD += C0606g.b(4, this.f628f);
        }
        for (int i4 = 0; i4 < this.f629g.size(); i4++) {
            iD += C0606g.d(5, (MessageLite) this.f629g.get(i4));
        }
        for (int i5 = 0; i5 < this.f630h.size(); i5++) {
            iD += C0606g.d(6, (MessageLite) this.f630h.get(i5));
        }
        int iC2 = 0;
        for (int i6 = 0; i6 < this.f632k.size(); i6++) {
            iC2 += C0606g.c(((Integer) this.f632k.get(i6)).intValue());
        }
        int iD2 = iD + iC2;
        if (!this.f632k.isEmpty()) {
            iD2 = iD2 + 1 + C0606g.c(iC2);
        }
        this.f633l = iC2;
        for (int i7 = 0; i7 < this.f637p.size(); i7++) {
            iD2 += C0606g.d(8, (MessageLite) this.f637p.get(i7));
        }
        for (int i8 = 0; i8 < this.q.size(); i8++) {
            iD2 += C0606g.d(9, (MessageLite) this.q.get(i8));
        }
        for (int i9 = 0; i9 < this.f638r.size(); i9++) {
            iD2 += C0606g.d(10, (MessageLite) this.f638r.get(i9));
        }
        for (int i10 = 0; i10 < this.f639s.size(); i10++) {
            iD2 += C0606g.d(11, (MessageLite) this.f639s.get(i10));
        }
        for (int i11 = 0; i11 < this.f640t.size(); i11++) {
            iD2 += C0606g.d(13, (MessageLite) this.f640t.get(i11));
        }
        int iC3 = 0;
        for (int i12 = 0; i12 < this.u.size(); i12++) {
            iC3 += C0606g.c(((Integer) this.u.get(i12)).intValue());
        }
        int iD3 = iD2 + iC3;
        if (!this.u.isEmpty()) {
            iD3 = iD3 + 2 + C0606g.c(iC3);
        }
        this.f641v = iC3;
        if ((this.c & 8) == 8) {
            iD3 += C0606g.b(17, this.f642w);
        }
        if ((this.c & 16) == 16) {
            iD3 += C0606g.d(18, this.x);
        }
        if ((this.c & 32) == 32) {
            iD3 += C0606g.b(19, this.y);
        }
        for (int i13 = 0; i13 < this.f634m.size(); i13++) {
            iD3 += C0606g.d(20, (MessageLite) this.f634m.get(i13));
        }
        int iC4 = 0;
        for (int i14 = 0; i14 < this.f635n.size(); i14++) {
            iC4 += C0606g.c(((Integer) this.f635n.get(i14)).intValue());
        }
        int iC5 = iD3 + iC4;
        if (!this.f635n.isEmpty()) {
            iC5 = iC5 + 2 + C0606g.c(iC4);
        }
        this.f636o = iC4;
        int iC6 = 0;
        for (int i15 = 0; i15 < this.f643z.size(); i15++) {
            iC6 += C0606g.c(((Integer) this.f643z.get(i15)).intValue());
        }
        int iD4 = iC5 + iC6;
        if (!this.f643z.isEmpty()) {
            iD4 = iD4 + 2 + C0606g.c(iC6);
        }
        this.f623A = iC6;
        for (int i16 = 0; i16 < this.f624B.size(); i16++) {
            iD4 += C0606g.d(23, (MessageLite) this.f624B.get(i16));
        }
        int iC7 = 0;
        for (int i17 = 0; i17 < this.C.size(); i17++) {
            iC7 += C0606g.c(((Integer) this.C.get(i17)).intValue());
        }
        int iD5 = iD4 + iC7;
        if (!this.C.isEmpty()) {
            iD5 = iD5 + 2 + C0606g.c(iC7);
        }
        this.f625D = iC7;
        if ((this.c & 64) == 64) {
            iD5 += C0606g.d(30, this.E);
        }
        int iC8 = 0;
        for (int i18 = 0; i18 < this.f626F.size(); i18++) {
            iC8 += C0606g.c(((Integer) this.f626F.get(i18)).intValue());
        }
        int size = (this.f626F.size() * 2) + iD5 + iC8;
        if ((this.c & 128) == 128) {
            size += C0606g.d(32, this.f627G);
        }
        int size2 = this.b.size() + c() + size;
        this.I = size2;
        return size2;
    }

    public final void i() {
        this.d = 6;
        this.e = 0;
        this.f628f = 0;
        List list = Collections.EMPTY_LIST;
        this.f629g = list;
        this.f630h = list;
        this.i = list;
        this.f632k = list;
        this.f634m = list;
        this.f635n = list;
        this.f637p = list;
        this.q = list;
        this.f638r = list;
        this.f639s = list;
        this.f640t = list;
        this.u = list;
        this.f642w = 0;
        this.x = U.f492t;
        this.y = 0;
        this.f643z = list;
        this.f624B = list;
        this.C = list;
        this.E = b0.f536g;
        this.f626F = list;
        this.f627G = j0.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.H;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if ((this.c & 2) != 2) {
            this.H = (byte) 0;
            return false;
        }
        for (int i = 0; i < this.f629g.size(); i++) {
            if (!((Z) this.f629g.get(i)).isInitialized()) {
                this.H = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < this.f630h.size(); i3++) {
            if (!((U) this.f630h.get(i3)).isInitialized()) {
                this.H = (byte) 0;
                return false;
            }
        }
        for (int i4 = 0; i4 < this.f634m.size(); i4++) {
            if (!((U) this.f634m.get(i4)).isInitialized()) {
                this.H = (byte) 0;
                return false;
            }
        }
        for (int i5 = 0; i5 < this.f637p.size(); i5++) {
            if (!((C0113m) this.f637p.get(i5)).isInitialized()) {
                this.H = (byte) 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < this.q.size(); i6++) {
            if (!((C0125z) this.q.get(i6)).isInitialized()) {
                this.H = (byte) 0;
                return false;
            }
        }
        for (int i7 = 0; i7 < this.f638r.size(); i7++) {
            if (!((H) this.f638r.get(i7)).isInitialized()) {
                this.H = (byte) 0;
                return false;
            }
        }
        for (int i8 = 0; i8 < this.f639s.size(); i8++) {
            if (!((W) this.f639s.get(i8)).isInitialized()) {
                this.H = (byte) 0;
                return false;
            }
        }
        for (int i9 = 0; i9 < this.f640t.size(); i9++) {
            if (!((C0120u) this.f640t.get(i9)).isInitialized()) {
                this.H = (byte) 0;
                return false;
            }
        }
        if ((this.c & 16) == 16 && !this.x.isInitialized()) {
            this.H = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < this.f624B.size(); i10++) {
            if (!((U) this.f624B.get(i10)).isInitialized()) {
                this.H = (byte) 0;
                return false;
            }
        }
        if ((this.c & 64) == 64 && !this.E.isInitialized()) {
            this.H = (byte) 0;
            return false;
        }
        if (this.f3871a.e()) {
            this.H = (byte) 1;
            return true;
        }
        this.H = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder newBuilderForType() {
        return C0109i.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final MessageLite.Builder toBuilder() {
        C0109i c0109iD = C0109i.d();
        c0109iD.e(this);
        return c0109iD;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public final void writeTo(C0606g c0606g) {
        getSerializedSize();
        B.h hVar = new B.h(this);
        if ((this.c & 1) == 1) {
            c0606g.m(1, this.d);
        }
        if (this.i.size() > 0) {
            c0606g.v(18);
            c0606g.v(this.f631j);
        }
        for (int i = 0; i < this.i.size(); i++) {
            c0606g.n(((Integer) this.i.get(i)).intValue());
        }
        if ((this.c & 2) == 2) {
            c0606g.m(3, this.e);
        }
        if ((this.c & 4) == 4) {
            c0606g.m(4, this.f628f);
        }
        for (int i3 = 0; i3 < this.f629g.size(); i3++) {
            c0606g.o(5, (MessageLite) this.f629g.get(i3));
        }
        for (int i4 = 0; i4 < this.f630h.size(); i4++) {
            c0606g.o(6, (MessageLite) this.f630h.get(i4));
        }
        if (this.f632k.size() > 0) {
            c0606g.v(58);
            c0606g.v(this.f633l);
        }
        for (int i5 = 0; i5 < this.f632k.size(); i5++) {
            c0606g.n(((Integer) this.f632k.get(i5)).intValue());
        }
        for (int i6 = 0; i6 < this.f637p.size(); i6++) {
            c0606g.o(8, (MessageLite) this.f637p.get(i6));
        }
        for (int i7 = 0; i7 < this.q.size(); i7++) {
            c0606g.o(9, (MessageLite) this.q.get(i7));
        }
        for (int i8 = 0; i8 < this.f638r.size(); i8++) {
            c0606g.o(10, (MessageLite) this.f638r.get(i8));
        }
        for (int i9 = 0; i9 < this.f639s.size(); i9++) {
            c0606g.o(11, (MessageLite) this.f639s.get(i9));
        }
        for (int i10 = 0; i10 < this.f640t.size(); i10++) {
            c0606g.o(13, (MessageLite) this.f640t.get(i10));
        }
        if (this.u.size() > 0) {
            c0606g.v(130);
            c0606g.v(this.f641v);
        }
        for (int i11 = 0; i11 < this.u.size(); i11++) {
            c0606g.n(((Integer) this.u.get(i11)).intValue());
        }
        if ((this.c & 8) == 8) {
            c0606g.m(17, this.f642w);
        }
        if ((this.c & 16) == 16) {
            c0606g.o(18, this.x);
        }
        if ((this.c & 32) == 32) {
            c0606g.m(19, this.y);
        }
        for (int i12 = 0; i12 < this.f634m.size(); i12++) {
            c0606g.o(20, (MessageLite) this.f634m.get(i12));
        }
        if (this.f635n.size() > 0) {
            c0606g.v(170);
            c0606g.v(this.f636o);
        }
        for (int i13 = 0; i13 < this.f635n.size(); i13++) {
            c0606g.n(((Integer) this.f635n.get(i13)).intValue());
        }
        if (this.f643z.size() > 0) {
            c0606g.v(178);
            c0606g.v(this.f623A);
        }
        for (int i14 = 0; i14 < this.f643z.size(); i14++) {
            c0606g.n(((Integer) this.f643z.get(i14)).intValue());
        }
        for (int i15 = 0; i15 < this.f624B.size(); i15++) {
            c0606g.o(23, (MessageLite) this.f624B.get(i15));
        }
        if (this.C.size() > 0) {
            c0606g.v(194);
            c0606g.v(this.f625D);
        }
        for (int i16 = 0; i16 < this.C.size(); i16++) {
            c0606g.n(((Integer) this.C.get(i16)).intValue());
        }
        if ((this.c & 64) == 64) {
            c0606g.o(30, this.E);
        }
        for (int i17 = 0; i17 < this.f626F.size(); i17++) {
            c0606g.m(31, ((Integer) this.f626F.get(i17)).intValue());
        }
        if ((this.c & 128) == 128) {
            c0606g.o(32, this.f627G);
        }
        hVar.q(19000, c0606g);
        c0606g.r(this.b);
    }

    public C0111k() {
        this.f631j = -1;
        this.f633l = -1;
        this.f636o = -1;
        this.f641v = -1;
        this.f623A = -1;
        this.f625D = -1;
        this.H = (byte) -1;
        this.I = -1;
        this.b = AbstractC0604e.f3861a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0111k(kotlin.reflect.jvm.internal.impl.protobuf.C0605f r22, kotlin.reflect.jvm.internal.impl.protobuf.C0608i r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1756
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: G2.C0111k.<init>(kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.i):void");
    }
}
