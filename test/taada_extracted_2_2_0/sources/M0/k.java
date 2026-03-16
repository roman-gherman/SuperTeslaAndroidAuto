package M0;

import com.google.gson.E;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.ObjectConstructor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class k extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1003a;
    public final Object b;
    public final Object c;
    public final Object d;

    public k(c cVar, com.google.gson.m mVar, Type type, E e, Type type2, E e6, ObjectConstructor objectConstructor) {
        this.f1003a = 0;
        this.b = new k(mVar, e, type);
        this.c = new k(mVar, e6, type2);
        this.d = objectConstructor;
    }

    @Override // com.google.gson.E
    public final Object a(com.google.gson.stream.b bVar) throws IOException {
        switch (this.f1003a) {
            case 0:
                int iW = bVar.w();
                if (iW == 9) {
                    bVar.s();
                    return null;
                }
                Map map = (Map) ((ObjectConstructor) this.d).construct();
                k kVar = (k) this.c;
                k kVar2 = (k) this.b;
                E e = (E) kVar.c;
                E e6 = (E) kVar2.c;
                if (iW == 1) {
                    bVar.a();
                    while (bVar.j()) {
                        bVar.a();
                        Object objA = e6.a(bVar);
                        if (map.put(objA, e.a(bVar)) != null) {
                            throw new com.google.gson.w(androidx.constraintlayout.core.motion.a.m(objA, "duplicate key: "));
                        }
                        bVar.e();
                    }
                    bVar.e();
                } else {
                    bVar.b();
                    while (bVar.j()) {
                        com.google.gson.stream.a.f3043a.getClass();
                        com.google.gson.stream.a.a(bVar);
                        Object objA2 = e6.a(bVar);
                        if (map.put(objA2, e.a(bVar)) != null) {
                            throw new com.google.gson.w(androidx.constraintlayout.core.motion.a.m(objA2, "duplicate key: "));
                        }
                    }
                    bVar.f();
                }
                return map;
            case 1:
                return ((E) this.c).a(bVar);
            default:
                if (bVar.w() == 9) {
                    bVar.s();
                    return null;
                }
                String strU = bVar.u();
                Enum r02 = (Enum) ((HashMap) this.b).get(strU);
                return r02 == null ? (Enum) ((HashMap) this.c).get(strU) : r02;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x005b  */
    @Override // com.google.gson.E
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(com.google.gson.stream.c r5, java.lang.Object r6) throws java.io.IOException {
        /*
            r4 = this;
            int r0 = r4.f1003a
            switch(r0) {
                case 0: goto L60;
                case 1: goto L19;
                default: goto L5;
            }
        L5:
            java.lang.Enum r6 = (java.lang.Enum) r6
            if (r6 != 0) goto Lb
            r6 = 0
            goto L15
        Lb:
            java.lang.Object r0 = r4.d
            java.util.HashMap r0 = (java.util.HashMap) r0
            java.lang.Object r6 = r0.get(r6)
            java.lang.String r6 = (java.lang.String) r6
        L15:
            r5.p(r6)
            return
        L19:
            java.lang.Object r0 = r4.d
            java.lang.reflect.Type r0 = (java.lang.reflect.Type) r0
            if (r6 == 0) goto L2c
            boolean r1 = r0 instanceof java.lang.Class
            if (r1 != 0) goto L27
            boolean r1 = r0 instanceof java.lang.reflect.TypeVariable
            if (r1 == 0) goto L2c
        L27:
            java.lang.Class r1 = r6.getClass()
            goto L2d
        L2c:
            r1 = r0
        L2d:
            java.lang.Object r2 = r4.c
            com.google.gson.E r2 = (com.google.gson.E) r2
            if (r1 == r0) goto L5c
            com.google.gson.reflect.a r0 = new com.google.gson.reflect.a
            r0.<init>(r1)
            java.lang.Object r1 = r4.b
            com.google.gson.m r1 = (com.google.gson.m) r1
            com.google.gson.E r0 = r1.e(r0)
            boolean r1 = r0 instanceof M0.o
            if (r1 != 0) goto L45
            goto L5b
        L45:
            r1 = r2
        L46:
            boolean r3 = r1 instanceof M0.s
            if (r3 == 0) goto L56
            r3 = r1
            M0.s r3 = (M0.s) r3
            com.google.gson.E r3 = r3.c()
            if (r3 != r1) goto L54
            goto L56
        L54:
            r1 = r3
            goto L46
        L56:
            boolean r1 = r1 instanceof M0.o
            if (r1 != 0) goto L5b
            goto L5c
        L5b:
            r2 = r0
        L5c:
            r2.b(r5, r6)
            return
        L60:
            java.util.Map r6 = (java.util.Map) r6
            if (r6 != 0) goto L68
            r5.i()
            goto L99
        L68:
            java.lang.Object r0 = r4.c
            M0.k r0 = (M0.k) r0
            r5.c()
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L77:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L96
            java.lang.Object r1 = r6.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r5.g(r2)
            java.lang.Object r1 = r1.getValue()
            r0.b(r5, r1)
            goto L77
        L96:
            r5.f()
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M0.k.b(com.google.gson.stream.c, java.lang.Object):void");
    }

    public k(com.google.gson.m mVar, E e, Type type) {
        this.f1003a = 1;
        this.b = mVar;
        this.c = e;
        this.d = type;
    }

    public k(Class cls) {
        this.f1003a = 2;
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        try {
            for (Field field : (Field[]) AccessController.doPrivileged(new x(cls, 0))) {
                Enum r42 = (Enum) field.get(null);
                String strName = r42.name();
                String string = r42.toString();
                SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                if (serializedName != null) {
                    strName = serializedName.value();
                    for (String str : serializedName.alternate()) {
                        ((HashMap) this.b).put(str, r42);
                    }
                }
                ((HashMap) this.b).put(strName, r42);
                ((HashMap) this.c).put(string, r42);
                ((HashMap) this.d).put(r42, strName);
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
