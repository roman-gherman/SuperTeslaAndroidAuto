package f;

/* JADX INFO: loaded from: classes.dex */
public class w implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short f3169a;
    public int b = 0;
    public int c = -1;
    public int d = 0;

    public w(int i) {
        this.f3169a = (short) i;
    }

    public final boolean a() {
        return this.b > 0;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        int i = this.c;
        int i3 = ((w) obj).c;
        if (i != i3) {
            return i < i3 ? -1 : 1;
        }
        return 0;
    }

    public final String toString() {
        return String.format("Section[type=%#x,off=%#x,size=%#x]", Short.valueOf(this.f3169a), Integer.valueOf(this.c), Integer.valueOf(this.b));
    }
}
