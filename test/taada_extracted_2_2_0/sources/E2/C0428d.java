package e2;

import E1.k;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: renamed from: e2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0428d implements Iterable, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3132a;
    public final int b;
    public final int c;

    public C0428d(int i, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f3132a = i;
        this.b = k.L(i, i3, i4);
        this.c = i4;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C0429e iterator() {
        return new C0429e(this.f3132a, this.b, this.c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0428d)) {
            return false;
        }
        if (isEmpty() && ((C0428d) obj).isEmpty()) {
            return true;
        }
        C0428d c0428d = (C0428d) obj;
        return this.f3132a == c0428d.f3132a && this.b == c0428d.b && this.c == c0428d.c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f3132a * 31) + this.b) * 31) + this.c;
    }

    public boolean isEmpty() {
        int i = this.c;
        int i3 = this.b;
        int i4 = this.f3132a;
        return i > 0 ? i4 > i3 : i4 < i3;
    }

    public String toString() {
        StringBuilder sb;
        int i = this.b;
        int i3 = this.f3132a;
        int i4 = this.c;
        if (i4 > 0) {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append("..");
            sb.append(i);
            sb.append(" step ");
            sb.append(i4);
        } else {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append(" downTo ");
            sb.append(i);
            sb.append(" step ");
            sb.append(-i4);
        }
        return sb.toString();
    }
}
