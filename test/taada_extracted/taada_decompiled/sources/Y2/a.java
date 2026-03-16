package Y2;

import com.android.multidex.ClassPathElement;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.text.r;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends W2.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f1482m;

    static {
        C0608i c0608i = new C0608i();
        H2.b.a(c0608i);
        o packageFqName = H2.b.f740a;
        h.e(packageFqName, "packageFqName");
        o constructorAnnotation = H2.b.c;
        h.e(constructorAnnotation, "constructorAnnotation");
        o classAnnotation = H2.b.b;
        h.e(classAnnotation, "classAnnotation");
        o functionAnnotation = H2.b.d;
        h.e(functionAnnotation, "functionAnnotation");
        o propertyAnnotation = H2.b.e;
        h.e(propertyAnnotation, "propertyAnnotation");
        o propertyGetterAnnotation = H2.b.f741f;
        h.e(propertyGetterAnnotation, "propertyGetterAnnotation");
        o propertySetterAnnotation = H2.b.f742g;
        h.e(propertySetterAnnotation, "propertySetterAnnotation");
        o enumEntryAnnotation = H2.b.i;
        h.e(enumEntryAnnotation, "enumEntryAnnotation");
        o compileTimeValue = H2.b.f743h;
        h.e(compileTimeValue, "compileTimeValue");
        o parameterAnnotation = H2.b.f744j;
        h.e(parameterAnnotation, "parameterAnnotation");
        o typeAnnotation = H2.b.f745k;
        h.e(typeAnnotation, "typeAnnotation");
        o typeParameterAnnotation = H2.b.f746l;
        h.e(typeParameterAnnotation, "typeParameterAnnotation");
        f1482m = new a(c0608i, packageFqName, constructorAnnotation, classAnnotation, functionAnnotation, propertyAnnotation, propertyGetterAnnotation, propertySetterAnnotation, enumEntryAnnotation, compileTimeValue, parameterAnnotation, typeAnnotation, typeParameterAnnotation);
    }

    public static String a(L2.c fqName) {
        String strB;
        h.f(fqName, "fqName");
        StringBuilder sb = new StringBuilder();
        sb.append(r.A(fqName.b(), TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, ClassPathElement.SEPARATOR_CHAR));
        sb.append(ClassPathElement.SEPARATOR_CHAR);
        if (fqName.d()) {
            strB = "default-package";
        } else {
            strB = fqName.f().b();
            h.e(strB, "fqName.shortName().asString()");
        }
        sb.append(strB.concat(".kotlin_builtins"));
        return sb.toString();
    }
}
