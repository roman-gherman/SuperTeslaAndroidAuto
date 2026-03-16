package C1;

import f.s;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f162a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f164g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f165h;
    public final long i;

    static {
        a.a(0L);
    }

    public b(int i, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j6) {
        com.google.protobuf.a.p(i5, "dayOfWeek");
        com.google.protobuf.a.p(i8, "month");
        this.f162a = i;
        this.b = i3;
        this.c = i4;
        this.d = i5;
        this.e = i6;
        this.f163f = i7;
        this.f164g = i8;
        this.f165h = i9;
        this.i = j6;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        b other = (b) obj;
        h.f(other, "other");
        long j6 = this.i;
        long j7 = other.i;
        if (j6 < j7) {
            return -1;
        }
        return j6 == j7 ? 0 : 1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f162a == bVar.f162a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f163f == bVar.f163f && this.f164g == bVar.f164g && this.f165h == bVar.f165h && this.i == bVar.i;
    }

    public final int hashCode() {
        return Long.hashCode(this.i) + ((Integer.hashCode(this.f165h) + ((s.b(this.f164g) + ((Integer.hashCode(this.f163f) + ((Integer.hashCode(this.e) + ((s.b(this.d) + ((Integer.hashCode(this.c) + ((Integer.hashCode(this.b) + (Integer.hashCode(this.f162a) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder("GMTDate(seconds=");
        sb.append(this.f162a);
        sb.append(", minutes=");
        sb.append(this.b);
        sb.append(", hours=");
        sb.append(this.c);
        sb.append(", dayOfWeek=");
        switch (this.d) {
            case 1:
                str = "MONDAY";
                break;
            case 2:
                str = "TUESDAY";
                break;
            case 3:
                str = "WEDNESDAY";
                break;
            case 4:
                str = "THURSDAY";
                break;
            case 5:
                str = "FRIDAY";
                break;
            case 6:
                str = "SATURDAY";
                break;
            case 7:
                str = "SUNDAY";
                break;
            default:
                str = "null";
                break;
        }
        sb.append(str);
        sb.append(", dayOfMonth=");
        sb.append(this.e);
        sb.append(", dayOfYear=");
        sb.append(this.f163f);
        sb.append(", month=");
        switch (this.f164g) {
            case 1:
                str2 = "JANUARY";
                break;
            case 2:
                str2 = "FEBRUARY";
                break;
            case 3:
                str2 = "MARCH";
                break;
            case 4:
                str2 = "APRIL";
                break;
            case 5:
                str2 = "MAY";
                break;
            case 6:
                str2 = "JUNE";
                break;
            case 7:
                str2 = "JULY";
                break;
            case 8:
                str2 = "AUGUST";
                break;
            case 9:
                str2 = "SEPTEMBER";
                break;
            case 10:
                str2 = "OCTOBER";
                break;
            case 11:
                str2 = "NOVEMBER";
                break;
            case 12:
                str2 = "DECEMBER";
                break;
            default:
                str2 = "null";
                break;
        }
        sb.append(str2);
        sb.append(", year=");
        sb.append(this.f165h);
        sb.append(", timestamp=");
        sb.append(this.i);
        sb.append(')');
        return sb.toString();
    }
}
