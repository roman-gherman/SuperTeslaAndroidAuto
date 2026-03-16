package M0;

import com.google.gson.D;
import com.google.gson.E;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class m extends E {
    public static final l c = new l(D.f2990a, 1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.gson.m f1005a;
    public final D b;

    public m(com.google.gson.m mVar, D d) {
        this.f1005a = mVar;
        this.b = d;
    }

    @Override // com.google.gson.E
    public final Object a(com.google.gson.stream.b bVar) throws IOException {
        Object arrayList;
        Serializable arrayList2;
        int iW = bVar.w();
        int iB = f.s.b(iW);
        if (iB == 0) {
            bVar.a();
            arrayList = new ArrayList();
        } else if (iB != 2) {
            arrayList = null;
        } else {
            bVar.b();
            arrayList = new com.google.gson.internal.n(true);
        }
        if (arrayList == null) {
            return c(bVar, iW);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (bVar.j()) {
                String strQ = arrayList instanceof Map ? bVar.q() : null;
                int iW2 = bVar.w();
                int iB2 = f.s.b(iW2);
                if (iB2 == 0) {
                    bVar.a();
                    arrayList2 = new ArrayList();
                } else if (iB2 != 2) {
                    arrayList2 = null;
                } else {
                    bVar.b();
                    arrayList2 = new com.google.gson.internal.n(true);
                }
                boolean z6 = arrayList2 != null;
                if (arrayList2 == null) {
                    arrayList2 = c(bVar, iW2);
                }
                if (arrayList instanceof List) {
                    ((List) arrayList).add(arrayList2);
                } else {
                    ((Map) arrayList).put(strQ, arrayList2);
                }
                if (z6) {
                    arrayDeque.addLast(arrayList);
                    arrayList = arrayList2;
                }
            } else {
                if (arrayList instanceof List) {
                    bVar.e();
                } else {
                    bVar.f();
                }
                if (arrayDeque.isEmpty()) {
                    return arrayList;
                }
                arrayList = arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.E
    public final void b(com.google.gson.stream.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.i();
            return;
        }
        Class<?> cls = obj.getClass();
        com.google.gson.m mVar = this.f1005a;
        mVar.getClass();
        E e = mVar.e(new com.google.gson.reflect.a(cls));
        if (!(e instanceof m)) {
            e.b(cVar, obj);
        } else {
            cVar.c();
            cVar.f();
        }
    }

    public final Serializable c(com.google.gson.stream.b bVar, int i) throws IOException {
        int iB = f.s.b(i);
        if (iB == 5) {
            return bVar.u();
        }
        if (iB == 6) {
            return this.b.readNumber(bVar);
        }
        if (iB == 7) {
            return Boolean.valueOf(bVar.m());
        }
        if (iB != 8) {
            throw new IllegalStateException("Unexpected token: ".concat(androidx.constraintlayout.core.motion.a.C(i)));
        }
        bVar.s();
        return null;
    }
}
