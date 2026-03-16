package B2;

import a3.F;
import f.s;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f121a;
    public final int b;
    public final boolean c;
    public final boolean d;
    public final Set e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final F f122f;

    public a(int i, int i3, boolean z6, boolean z7, Set set, F f6) {
        com.google.protobuf.a.p(i, "howThisTypeIsUsed");
        com.google.protobuf.a.p(i3, "flexibility");
        this.f121a = i;
        this.b = i3;
        this.c = z6;
        this.d = z7;
        this.e = set;
        this.f122f = f6;
    }

    public static a a(a aVar, int i, boolean z6, Set set, F f6, int i3) {
        int i4 = aVar.f121a;
        if ((i3 & 2) != 0) {
            i = aVar.b;
        }
        int i5 = i;
        if ((i3 & 4) != 0) {
            z6 = aVar.c;
        }
        boolean z7 = z6;
        boolean z8 = aVar.d;
        if ((i3 & 16) != 0) {
            set = aVar.e;
        }
        Set set2 = set;
        if ((i3 & 32) != 0) {
            f6 = aVar.f122f;
        }
        aVar.getClass();
        com.google.protobuf.a.p(i4, "howThisTypeIsUsed");
        com.google.protobuf.a.p(i5, "flexibility");
        return new a(i4, i5, z7, z8, set2, f6);
    }

    public final a b(int i) {
        com.google.protobuf.a.p(i, "flexibility");
        return a(this, i, false, null, null, 61);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (kotlin.jvm.internal.h.a(aVar.f122f, this.f122f)) {
            return aVar.f121a == this.f121a && aVar.b == this.b && aVar.c == this.c && aVar.d == this.d;
        }
        return false;
    }

    public final int hashCode() {
        F f6 = this.f122f;
        int iHashCode = f6 != null ? f6.hashCode() : 0;
        int iB = s.b(this.f121a) + (iHashCode * 31) + iHashCode;
        int iB2 = s.b(this.b) + (iB * 31) + iB;
        int i = (iB2 * 31) + (this.c ? 1 : 0) + iB2;
        return (i * 31) + (this.d ? 1 : 0) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("JavaTypeAttributes(howThisTypeIsUsed=");
        int i = this.f121a;
        sb.append(i != 1 ? i != 2 ? "null" : "COMMON" : "SUPERTYPE");
        sb.append(", flexibility=");
        int i3 = this.b;
        sb.append(i3 != 1 ? i3 != 2 ? i3 != 3 ? "null" : "FLEXIBLE_LOWER_BOUND" : "FLEXIBLE_UPPER_BOUND" : "INFLEXIBLE");
        sb.append(", isRaw=");
        sb.append(this.c);
        sb.append(", isForAnnotationParameter=");
        sb.append(this.d);
        sb.append(", visitedTypeParameters=");
        sb.append(this.e);
        sb.append(", defaultType=");
        sb.append(this.f122f);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ a(int i, boolean z6, boolean z7, Set set, int i3) {
        this(i, 1, (i3 & 4) != 0 ? false : z6, (i3 & 8) != 0 ? false : z7, (i3 & 16) != 0 ? null : set, null);
    }
}
