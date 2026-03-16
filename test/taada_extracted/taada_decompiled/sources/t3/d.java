package t3;

import m3.AbstractC0684s;
import r3.AbstractC0800a;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends g {
    public static final d b;

    static {
        int i = k.c;
        int i3 = k.d;
        long j6 = k.e;
        String str = k.f4835a;
        d dVar = new d();
        dVar.f4832a = new b(i, i3, j6, str);
        b = dVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // m3.AbstractC0684s
    public final AbstractC0684s limitedParallelism(int i) {
        AbstractC0800a.a(i);
        return i >= k.c ? this : super.limitedParallelism(i);
    }

    @Override // m3.AbstractC0684s
    public final String toString() {
        return "Dispatchers.Default";
    }
}
