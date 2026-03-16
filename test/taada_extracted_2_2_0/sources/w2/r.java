package w2;

import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements JavaClassesTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f5020a = new r();

    public static final K a(String internalName, String str, String str2, String str3) {
        ArrayList arrayList = N.f4994a;
        L2.f fVarE = L2.f.e(str);
        String jvmDescriptor = str + '(' + str2 + ')' + str3;
        kotlin.jvm.internal.h.f(internalName, "internalName");
        kotlin.jvm.internal.h.f(jvmDescriptor, "jvmDescriptor");
        return new K(fVarE, internalName + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + jvmDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker
    public void reportClass(JavaClassDescriptor classDescriptor) {
        kotlin.jvm.internal.h.f(classDescriptor, "classDescriptor");
    }
}
