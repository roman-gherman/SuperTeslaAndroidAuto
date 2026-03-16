package B;

import com.google.android.gms.common.Feature;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class w implements ILoggerFactory, KotlinTypeChecker.TypeConstructorEquality {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f113a;
    public boolean b;
    public final Object c;
    public final Object d;

    public w(g gVar, Feature[] featureArr, boolean z6) {
        this.f113a = 0;
        this.d = gVar;
        this.c = featureArr;
        boolean z7 = false;
        if (featureArr != null && z6) {
            z7 = true;
        }
        this.b = z7;
    }

    public static String a(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: ".concat(cls.getName());
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.gson.internal.ObjectConstructor b(com.google.gson.reflect.a r13) {
        /*
            Method dump skipped, instruction units count: 407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B.w.b(com.google.gson.reflect.a):com.google.gson.internal.ObjectConstructor");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality
    public boolean equals(TypeConstructor c12, TypeConstructor c22) {
        CallableDescriptor a6 = (CallableDescriptor) this.c;
        kotlin.jvm.internal.h.f(a6, "$a");
        CallableDescriptor b = (CallableDescriptor) this.d;
        kotlin.jvm.internal.h.f(b, "$b");
        kotlin.jvm.internal.h.f(c12, "c1");
        kotlin.jvm.internal.h.f(c22, "c2");
        if (c12.equals(c22)) {
            return true;
        }
        ClassifierDescriptor declarationDescriptor = c12.getDeclarationDescriptor();
        ClassifierDescriptor declarationDescriptor2 = c22.getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof TypeParameterDescriptor) || !(declarationDescriptor2 instanceof TypeParameterDescriptor)) {
            return false;
        }
        return N2.d.f1134a.b((TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) declarationDescriptor2, this.b, new N2.b(0, a6, b));
    }

    @Override // org.slf4j.ILoggerFactory
    public synchronized Logger getLogger(String str) {
        C5.d dVar;
        dVar = (C5.d) ((HashMap) this.c).get(str);
        if (dVar == null) {
            dVar = new C5.d(str, (LinkedBlockingQueue) this.d, this.b);
            ((HashMap) this.c).put(str, dVar);
        }
        return dVar;
    }

    public String toString() {
        switch (this.f113a) {
            case 3:
                return ((Map) this.c).toString();
            default:
                return super.toString();
        }
    }

    public w(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z6) {
        this.f113a = 2;
        this.b = z6;
        this.c = callableDescriptor;
        this.d = callableDescriptor2;
    }

    public w() {
        this.f113a = 1;
        this.b = false;
        this.c = new HashMap();
        this.d = new LinkedBlockingQueue();
    }

    public w(Map map, boolean z6, List list) {
        this.f113a = 3;
        this.c = map;
        this.b = z6;
        this.d = list;
    }
}
