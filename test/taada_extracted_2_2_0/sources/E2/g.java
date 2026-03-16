package E2;

import G2.D;
import a.AbstractC0132a;
import com.android.multidex.ClassPathElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements DeserializedContainerSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S2.a f303a;
    public final S2.a b;
    public final KotlinJvmBinaryClass c;

    public g(KotlinJvmBinaryClass kotlinClass, D packageProto, K2.g nameResolver, int i) {
        kotlin.jvm.internal.h.f(kotlinClass, "kotlinClass");
        kotlin.jvm.internal.h.f(packageProto, "packageProto");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        com.google.protobuf.a.p(i, "abiStability");
        S2.a aVarB = S2.a.b(kotlinClass.getClassId());
        F2.b classHeader = kotlinClass.getClassHeader();
        classHeader.getClass();
        S2.a aVarD = null;
        String str = classHeader.f352a == F2.a.MULTIFILE_CLASS_PART ? classHeader.f353f : null;
        if (str != null && str.length() > 0) {
            aVarD = S2.a.d(str);
        }
        this.f303a = aVarB;
        this.b = aVarD;
        this.c = kotlinClass;
        kotlin.reflect.jvm.internal.impl.protobuf.o packageModuleName = J2.l.f871m;
        kotlin.jvm.internal.h.e(packageModuleName, "packageModuleName");
        Integer num = (Integer) AbstractC0132a.D(packageProto, packageModuleName);
        if (num != null) {
            nameResolver.getString(num.intValue());
        }
    }

    public final L2.b a() {
        L2.c cVar;
        S2.a aVar = this.f303a;
        String str = aVar.f1283a;
        int iLastIndexOf = str.lastIndexOf("/");
        if (iLastIndexOf == -1) {
            cVar = L2.c.c;
            if (cVar == null) {
                S2.a.a(7);
                throw null;
            }
        } else {
            cVar = new L2.c(str.substring(0, iLastIndexOf).replace(ClassPathElement.SEPARATOR_CHAR, TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH));
        }
        String strE = aVar.e();
        kotlin.jvm.internal.h.e(strE, "className.internalName");
        return new L2.b(cVar, L2.f.e(kotlin.text.i.U(strE, ClassPathElement.SEPARATOR_CHAR)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    public final SourceFile getContainingFile() {
        SourceFile NO_SOURCE_FILE = SourceFile.NO_SOURCE_FILE;
        kotlin.jvm.internal.h.e(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource
    public final String getPresentableString() {
        return "Class '" + a().b().b() + '\'';
    }

    public final String toString() {
        return g.class.getSimpleName() + ": " + this.f303a;
    }
}
