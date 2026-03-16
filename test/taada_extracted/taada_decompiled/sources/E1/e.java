package E1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.z;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    @NotNull
    private volatile /* synthetic */ Object _interceptors;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f288a;
    public int b;
    public boolean c;
    public h d;

    public e(h... hVarArr) {
        new z1.f();
        this.f288a = kotlin.collections.n.A(Arrays.copyOf(hVarArr, hVarArr.length));
        this._interceptors = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r13, java.lang.Object r14, U1.c r15) {
        /*
            r12 = this;
            kotlin.coroutines.CoroutineContext r0 = r15.getContext()
            java.lang.Object r1 = r12._interceptors
            java.util.List r1 = (java.util.List) r1
            r2 = 1
            if (r1 != 0) goto L94
            int r1 = r12.b
            r3 = 0
            r4 = 0
            if (r1 != 0) goto L1b
            kotlin.collections.u r1 = kotlin.collections.u.f3804a
            r12._interceptors = r1
            r12.c = r4
            r12.d = r3
            goto L94
        L1b:
            java.util.ArrayList r5 = r12.f288a
            if (r1 != r2) goto L4f
            int r1 = kotlin.collections.n.x(r5)
            if (r1 < 0) goto L4f
            r6 = r4
        L26:
            java.lang.Object r7 = r5.get(r6)
            boolean r8 = r7 instanceof E1.d
            if (r8 == 0) goto L31
            E1.d r7 = (E1.d) r7
            goto L32
        L31:
            r7 = r3
        L32:
            if (r7 != 0) goto L35
            goto L4a
        L35:
            java.util.ArrayList r8 = r7.c
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L4a
            java.util.ArrayList r1 = r7.c
            r7.d = r2
            r12._interceptors = r1
            r12.c = r4
            E1.h r1 = r7.f287a
            r12.d = r1
            goto L94
        L4a:
            if (r6 == r1) goto L4f
            int r6 = r6 + 1
            goto L26
        L4f:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r6 = kotlin.collections.n.x(r5)
            if (r6 < 0) goto L8e
            r7 = r4
        L5b:
            java.lang.Object r8 = r5.get(r7)
            boolean r9 = r8 instanceof E1.d
            if (r9 == 0) goto L66
            E1.d r8 = (E1.d) r8
            goto L67
        L66:
            r8 = r3
        L67:
            if (r8 != 0) goto L6a
            goto L89
        L6a:
            java.util.ArrayList r8 = r8.c
            int r9 = r1.size()
            int r10 = r8.size()
            int r10 = r10 + r9
            r1.ensureCapacity(r10)
            int r9 = r8.size()
            r10 = r4
        L7d:
            if (r10 >= r9) goto L89
            java.lang.Object r11 = r8.get(r10)
            r1.add(r11)
            int r10 = r10 + 1
            goto L7d
        L89:
            if (r7 == r6) goto L8e
            int r7 = r7 + 1
            goto L5b
        L8e:
            r12._interceptors = r1
            r12.c = r4
            r12.d = r3
        L94:
            r12.c = r2
            java.lang.Object r1 = r12._interceptors
            java.util.List r1 = (java.util.List) r1
            kotlin.jvm.internal.h.c(r1)
            boolean r2 = r12.d()
            java.lang.String r3 = "context"
            kotlin.jvm.internal.h.f(r13, r3)
            java.lang.String r3 = "subject"
            kotlin.jvm.internal.h.f(r14, r3)
            java.lang.String r3 = "coroutineContext"
            kotlin.jvm.internal.h.f(r0, r3)
            boolean r3 = E1.g.f290a
            if (r3 != 0) goto Lbd
            if (r2 == 0) goto Lb7
            goto Lbd
        Lb7:
            E1.n r0 = new E1.n
            r0.<init>(r14, r13, r1)
            goto Lc3
        Lbd:
            E1.b r2 = new E1.b
            r2.<init>(r13, r1, r14, r0)
            r0 = r2
        Lc3:
            java.lang.Object r13 = r0.a(r14, r15)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: E1.e.a(java.lang.Object, java.lang.Object, U1.c):java.lang.Object");
    }

    public final d b(h hVar) {
        ArrayList arrayList = this.f288a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Object obj = arrayList.get(i);
            if (obj == hVar) {
                d dVar = new d(hVar, j.c);
                arrayList.set(i, dVar);
                return dVar;
            }
            if (obj instanceof d) {
                d dVar2 = (d) obj;
                if (dVar2.f287a == hVar) {
                    return dVar2;
                }
            }
        }
        return null;
    }

    public final int c(h hVar) {
        ArrayList arrayList = this.f288a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Object obj = arrayList.get(i);
            if (obj == hVar || ((obj instanceof d) && ((d) obj).f287a == hVar)) {
                return i;
            }
        }
        return -1;
    }

    public abstract boolean d();

    public final boolean e(h hVar) {
        ArrayList arrayList = this.f288a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Object obj = arrayList.get(i);
            if (obj == hVar) {
                return true;
            }
            if ((obj instanceof d) && ((d) obj).f287a == hVar) {
                return true;
            }
        }
        return false;
    }

    public final void f(h phase, Function3 function3) {
        kotlin.jvm.internal.h.f(phase, "phase");
        d dVarB = b(phase);
        if (dVarB == null) {
            throw new c("Phase " + phase + " was not registered for this pipeline");
        }
        z.d(3, function3);
        List list = (List) this._interceptors;
        if (!this.f288a.isEmpty() && list != null && !this.c && (!(list instanceof KMappedMarker) || (list instanceof KMutableList))) {
            if (kotlin.jvm.internal.h.a(this.d, phase)) {
                list.add(function3);
            } else if (phase.equals(kotlin.collections.m.X(this.f288a)) || c(phase) == kotlin.collections.n.x(this.f288a)) {
                d dVarB2 = b(phase);
                kotlin.jvm.internal.h.c(dVarB2);
                dVarB2.a(function3);
                list.add(function3);
            }
            this.b++;
            return;
        }
        dVarB.a(function3);
        this.b++;
        this._interceptors = null;
        this.c = false;
        this.d = null;
    }
}
