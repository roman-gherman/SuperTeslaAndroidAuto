package n2;

import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: renamed from: n2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0721m extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f4250a;
    public final Map b;

    public C0721m(ArrayList arrayList) {
        this.f4250a = arrayList;
        Map mapL = kotlin.collections.A.L(arrayList);
        if (mapL.size() != arrayList.size()) {
            throw new IllegalArgumentException("Some properties have the same names");
        }
        this.b = mapL;
    }

    public final String toString() {
        return "MultiFieldValueClassRepresentation(underlyingPropertyNamesToTypes=" + this.f4250a + ')';
    }
}
