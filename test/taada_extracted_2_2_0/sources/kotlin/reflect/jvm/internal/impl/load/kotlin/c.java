package kotlin.reflect.jvm.internal.impl.load.kotlin;

import E2.p;
import java.util.HashMap;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements KotlinJvmBinaryClass.MemberVisitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f3832a;
    public final /* synthetic */ HashMap b;
    public final /* synthetic */ KotlinJvmBinaryClass c;
    public final /* synthetic */ HashMap d;

    public c(d dVar, HashMap map, KotlinJvmBinaryClass kotlinJvmBinaryClass, HashMap map2) {
        this.f3832a = dVar;
        this.b = map;
        this.c = kotlinJvmBinaryClass;
        this.d = map2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
    public final KotlinJvmBinaryClass.AnnotationVisitor visitField(L2.f name, String desc, Object obj) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(desc, "desc");
        String strB = name.b();
        kotlin.jvm.internal.h.e(strB, "name.asString()");
        p pVar = new p(strB + '#' + desc);
        if (obj != null) {
            l lVar = (l) this.f3832a;
            lVar.getClass();
            if (kotlin.text.i.D("ZBCS", desc, false)) {
                int iIntValue = ((Integer) obj).intValue();
                int iHashCode = desc.hashCode();
                if (iHashCode == 66) {
                    if (desc.equals("B")) {
                        obj = Byte.valueOf((byte) iIntValue);
                    }
                    throw new AssertionError(desc);
                }
                if (iHashCode == 67) {
                    if (desc.equals("C")) {
                        obj = Character.valueOf((char) iIntValue);
                    }
                    throw new AssertionError(desc);
                }
                if (iHashCode == 83) {
                    if (desc.equals("S")) {
                        obj = Short.valueOf((short) iIntValue);
                    }
                    throw new AssertionError(desc);
                }
                if (iHashCode == 90 && desc.equals("Z")) {
                    obj = Boolean.valueOf(iIntValue != 0);
                }
                throw new AssertionError(desc);
            }
            P2.g gVarB = P2.h.f1218a.b(obj, lVar.c);
            if (gVarB != null) {
                this.d.put(pVar, gVarB);
            }
        }
        return new b(this, pVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
    public final KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod(L2.f name, String desc) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(desc, "desc");
        String strB = name.b();
        kotlin.jvm.internal.h.e(strB, "name.asString()");
        return new a(this, new p(strB.concat(desc)));
    }
}
