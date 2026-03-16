package androidx.core.util;

/* JADX INFO: loaded from: classes.dex */
public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f6, S s3) {
        this.first = f6;
        this.second = s3;
    }

    public static <A, B> Pair<A, B> create(A a6, B b) {
        return new Pair<>(a6, b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return ObjectsCompat.equals(pair.first, this.first) && ObjectsCompat.equals(pair.second, this.second);
    }

    public int hashCode() {
        F f6 = this.first;
        int iHashCode = f6 == null ? 0 : f6.hashCode();
        S s3 = this.second;
        return iHashCode ^ (s3 != null ? s3.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
