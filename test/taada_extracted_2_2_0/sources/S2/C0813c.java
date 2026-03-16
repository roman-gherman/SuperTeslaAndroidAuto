package s2;

import E2.l;
import E2.m;
import io.ktor.utils.io.Z;
import java.io.InputStream;
import java.util.Set;
import k2.p;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.text.r;
import net.bytebuddy.pool.TypePool;
import t2.C;
import t2.s;
import w2.q;

/* JADX INFO: renamed from: s2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0813c implements JavaClassFinder, KotlinClassFinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClassLoader f4768a;

    public /* synthetic */ C0813c(ClassLoader classLoader) {
        this.f4768a = classLoader;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder
    public InputStream findBuiltInsData(L2.c packageFqName) {
        kotlin.jvm.internal.h.f(packageFqName, "packageFqName");
        if (!packageFqName.h(p.f3767j)) {
            return null;
        }
        Y2.a.f1482m.getClass();
        return Y2.d.a(Y2.a.a(packageFqName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public JavaClass findClass(q request) {
        kotlin.jvm.internal.h.f(request, "request");
        L2.b bVar = request.f5019a;
        L2.c cVarG = bVar.g();
        kotlin.jvm.internal.h.e(cVarG, "classId.packageFqName");
        String strA = r.A(bVar.h().b(), TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '$');
        if (!cVarG.d()) {
            strA = cVarG.b() + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + strA;
        }
        Class clsV = Z.v(this.f4768a, strA);
        if (clsV != null) {
            return new s(clsV);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public m findKotlinClassOrContent(JavaClass javaClass, K2.f jvmMetadataVersion) {
        e eVarA;
        kotlin.jvm.internal.h.f(javaClass, "javaClass");
        kotlin.jvm.internal.h.f(jvmMetadataVersion, "jvmMetadataVersion");
        L2.c fqName = javaClass.getFqName();
        if (fqName == null) {
            return null;
        }
        Class clsV = Z.v(this.f4768a, fqName.b());
        if (clsV == null || (eVarA = d.a(clsV)) == null) {
            return null;
        }
        return new l(eVarA);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public JavaPackage findPackage(L2.c fqName, boolean z6) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        return new C(fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    public Set knownClassNamesInPackage(L2.c packageFqName) {
        kotlin.jvm.internal.h.f(packageFqName, "packageFqName");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public m findKotlinClassOrContent(L2.b classId, K2.f jvmMetadataVersion) {
        e eVarA;
        kotlin.jvm.internal.h.f(classId, "classId");
        kotlin.jvm.internal.h.f(jvmMetadataVersion, "jvmMetadataVersion");
        String strA = r.A(classId.h().b(), TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '$');
        if (!classId.g().d()) {
            strA = classId.g() + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + strA;
        }
        Class clsV = Z.v(this.f4768a, strA);
        if (clsV == null || (eVarA = d.a(clsV)) == null) {
            return null;
        }
        return new l(eVarA);
    }
}
