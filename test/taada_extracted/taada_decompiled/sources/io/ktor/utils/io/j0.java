package io.ktor.utils.io;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3593a = a(Throwable.class, -1);
    public static final ReentrantReadWriteLock b = new ReentrantReadWriteLock();
    public static final WeakHashMap c = new WeakHashMap();

    public static final int a(Class cls, int i) {
        Object objN;
        E1.k.K(cls);
        int i3 = 0;
        do {
            try {
                Field[] declaredFields = cls.getDeclaredFields();
                kotlin.jvm.internal.h.e(declaredFields, "declaredFields");
                int i4 = 0;
                for (Field field : declaredFields) {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        i4++;
                    }
                }
                i3 += i4;
                cls = cls.getSuperclass();
            } catch (Throwable th) {
                objN = kotlin.reflect.l.n(th);
            }
        } while (cls != null);
        objN = Integer.valueOf(i3);
        Object objValueOf = Integer.valueOf(i);
        if (objN instanceof N1.g) {
            objN = objValueOf;
        }
        return ((Number) objN).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0111 A[EDGE_INSN: B:105:0x0111->B:64:0x0111 BREAK  A[LOOP:3: B:41:0x00b0->B:108:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[LOOP:3: B:41:0x00b0->B:108:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Throwable b(java.lang.Throwable r12, java.lang.Throwable r13) {
        /*
            Method dump skipped, instruction units count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.j0.b(java.lang.Throwable, java.lang.Throwable):java.lang.Throwable");
    }
}
