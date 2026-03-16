package v2;

import java.io.Serializable;

/* JADX INFO: renamed from: v2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0852c implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0852c f4937a = new C0852c();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0852c)) {
            return false;
        }
        ((C0852c) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(-1) + (Integer.hashCode(-1) * 31);
    }

    public final String toString() {
        return "Position(line=-1, column=-1)";
    }
}
