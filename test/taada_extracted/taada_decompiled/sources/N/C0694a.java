package n;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: n.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0694a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f4157a;
    public final byte[] b;

    public C0694a(ArrayList arrayList, byte[] bArr) {
        this.f4157a = arrayList;
        this.b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        C0694a c0694a = (C0694a) dVar;
        if (this.f4157a.equals(c0694a.f4157a)) {
            return Arrays.equals(this.b, dVar instanceof C0694a ? ((C0694a) dVar).b : c0694a.b);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f4157a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    public final String toString() {
        return "BackendRequest{events=" + this.f4157a + ", extras=" + Arrays.toString(this.b) + "}";
    }
}
