package M0;

import com.google.gson.C0407a;
import com.google.gson.E;
import com.google.gson.ExclusionStrategy;
import com.google.gson.TypeAdapterFactory;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class r implements TypeAdapterFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B.w f1015a;
    public final com.google.gson.i b;
    public final com.google.gson.internal.h c;
    public final List d;

    public r(B.w wVar, com.google.gson.i iVar, com.google.gson.internal.h hVar, c cVar, List list) {
        this.f1015a = wVar;
        this.b = iVar;
        this.c = hVar;
        this.d = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Object obj, AccessibleObject accessibleObject) {
        if (Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (!com.google.gson.internal.q.f3014a.a(obj, accessibleObject)) {
            throw new com.google.gson.q(B2.b.e(O0.c.d(accessibleObject, true), " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type."));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x0224, code lost:
    
        r19 = r3;
        r1 = new com.google.gson.reflect.a(com.google.gson.internal.d.j(r9, r19, r19.getGenericSuperclass(), new java.util.HashMap()));
        r3 = r1.f3041a;
        r0 = r28;
        r10 = r29;
        r2 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01da A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ef A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.LinkedHashMap b(com.google.gson.m r29, com.google.gson.reflect.a r30, java.lang.Class r31, boolean r32, boolean r33) {
        /*
            Method dump skipped, instruction units count: 581
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: M0.r.b(com.google.gson.m, com.google.gson.reflect.a, java.lang.Class, boolean, boolean):java.util.LinkedHashMap");
    }

    public final boolean c(Field field, boolean z6) {
        Class<?> type = field.getType();
        com.google.gson.internal.h hVar = this.c;
        hVar.getClass();
        if (com.google.gson.internal.h.b(type) || hVar.a(type, z6) || (field.getModifiers() & 136) != 0 || field.isSynthetic() || com.google.gson.internal.h.b(field.getType())) {
            return false;
        }
        List list = z6 ? hVar.f3001a : hVar.b;
        if (list.isEmpty()) {
            return true;
        }
        C0407a c0407a = new C0407a(field);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((ExclusionStrategy) it.next()).shouldSkipField(c0407a)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final E create(com.google.gson.m mVar, com.google.gson.reflect.a aVar) {
        Class cls = aVar.f3041a;
        if (!Object.class.isAssignableFrom(cls)) {
            return null;
        }
        com.google.gson.y yVarE = com.google.gson.internal.d.e(cls, this.d);
        if (yVarE == com.google.gson.y.d) {
            throw new com.google.gson.q(androidx.constraintlayout.core.motion.a.k(cls, "ReflectionAccessFilter does not permit using reflection for ", ". Register a TypeAdapter for this type or adjust the access filter."));
        }
        boolean z6 = yVarE == com.google.gson.y.c;
        return O0.c.f1177a.W(cls) ? new q(cls, b(mVar, aVar, cls, z6, true), z6) : new p(this.f1015a.b(aVar), b(mVar, aVar, cls, z6, false));
    }
}
