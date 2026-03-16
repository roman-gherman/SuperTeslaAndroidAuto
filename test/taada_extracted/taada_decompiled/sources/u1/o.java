package u1;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return E1.k.n(Double.valueOf(((i) obj2).c), Double.valueOf(((i) obj).c));
    }
}
