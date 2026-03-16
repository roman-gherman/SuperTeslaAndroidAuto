package D2;

import a3.AbstractC0155s;
import a3.AbstractC0162z;
import a3.C;
import a3.F;
import a3.c0;
import com.android.billingclient.api.z;
import kotlin.reflect.jvm.internal.impl.types.RawType;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d8  */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static D2.c a(a3.F r19, A2.q r20, int r21, int r22, boolean r23, boolean r24) {
        /*
            Method dump skipped, instruction units count: 669
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D2.d.a(a3.F, A2.q, int, int, boolean, boolean):D2.c");
    }

    public static z b(c0 c0Var, A2.q qVar, int i, boolean z6) {
        c0 c0VarA;
        Object objK0 = null;
        if (kotlin.reflect.l.O(c0Var)) {
            return new z((Object) null, 1);
        }
        if (!(c0Var instanceof AbstractC0155s)) {
            if (!(c0Var instanceof F)) {
                throw new C0.x();
            }
            c cVarA = a((F) c0Var, qVar, i, 3, false, z6);
            boolean z7 = cVarA.c;
            AbstractC0162z abstractC0162zK0 = cVarA.f250a;
            if (z7) {
                abstractC0162zK0 = kotlin.reflect.l.k0(c0Var, abstractC0162zK0);
            }
            return new z(abstractC0162zK0, cVarA.b);
        }
        boolean z8 = c0Var instanceof RawType;
        AbstractC0155s abstractC0155s = (AbstractC0155s) c0Var;
        c cVarA2 = a(abstractC0155s.b, qVar, i, 1, z8, z6);
        c cVarA3 = a(abstractC0155s.c, qVar, i, 2, z8, z6);
        F f6 = cVarA3.f250a;
        F f7 = cVarA2.f250a;
        if (f7 != null || f6 != null) {
            if (cVarA2.c || cVarA3.c) {
                if (f6 != null) {
                    if (f7 == null) {
                        f7 = f6;
                    }
                    c0VarA = C.a(f7, f6);
                } else {
                    kotlin.jvm.internal.h.c(f7);
                    c0VarA = f7;
                }
                objK0 = kotlin.reflect.l.k0(c0Var, c0VarA);
            } else {
                F f8 = abstractC0155s.c;
                F f9 = abstractC0155s.b;
                F f10 = f7;
                if (z8) {
                    F f11 = f7;
                    if (f7 == null) {
                        f11 = f9;
                    }
                    if (f6 == null) {
                        f6 = f8;
                    }
                    objK0 = new B2.h(f11, f6);
                } else {
                    if (f7 == null) {
                        f10 = f9;
                    }
                    if (f6 == null) {
                        f6 = f8;
                    }
                    objK0 = C.a(f10, f6);
                }
            }
        }
        return new z(objK0, cVarA2.b);
    }
}
