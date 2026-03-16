package com.google.android.gms.internal.play_billing;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class K extends L implements Serializable {
    public static final K b = new K(0);
    public static final K c = new K(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2042a;

    public /* synthetic */ K(int i) {
        this.f2042a = i;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        switch (this.f2042a) {
            case 0:
                Comparable comparable = (Comparable) obj;
                Comparable comparable2 = (Comparable) obj2;
                comparable.getClass();
                comparable2.getClass();
                return comparable.compareTo(comparable2);
            default:
                M m6 = (M) obj;
                M m7 = (M) obj2;
                return r.f2121a.b(m6.f2044a, m7.f2044a).b(m6.b, m7.b).a();
        }
    }

    public String toString() {
        switch (this.f2042a) {
            case 0:
                return "Ordering.natural()";
            default:
                return super.toString();
        }
    }
}
