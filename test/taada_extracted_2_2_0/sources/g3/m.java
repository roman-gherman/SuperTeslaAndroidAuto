package g3;

import a3.AbstractC0162z;
import a3.K;
import a3.M;
import a3.b0;
import c4.AbstractC0246d;
import io.ktor.utils.io.Z;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.util.Check;
import n2.AbstractC0718j;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements Check {
    public static final m b = new m(0);
    public static final m c = new m(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3316a;

    public /* synthetic */ m(int i) {
        this.f3316a = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public final boolean check(FunctionDescriptor functionDescriptor) {
        a3.F fB;
        switch (this.f3316a) {
            case 0:
                kotlin.jvm.internal.h.f(functionDescriptor, "functionDescriptor");
                ValueParameterDescriptor secondParameter = functionDescriptor.getValueParameters().get(1);
                D.d dVar = k2.n.d;
                kotlin.jvm.internal.h.e(secondParameter, "secondParameter");
                ModuleDescriptor moduleDescriptorJ = R2.e.j(secondParameter);
                dVar.getClass();
                ClassDescriptor classDescriptorD = AbstractC0718j.d(moduleDescriptorJ, k2.o.f3736Q);
                if (classDescriptorD == null) {
                    fB = null;
                } else {
                    M.b.getClass();
                    M m6 = M.c;
                    List<TypeParameterDescriptor> parameters = classDescriptorD.getTypeConstructor().getParameters();
                    kotlin.jvm.internal.h.e(parameters, "kPropertyClass.typeConstructor.parameters");
                    Object objG0 = kotlin.collections.m.g0(parameters);
                    kotlin.jvm.internal.h.e(objG0, "kPropertyClass.typeConstructor.parameters.single()");
                    fB = a3.C.b(m6, classDescriptorD, Z.p(new K((TypeParameterDescriptor) objG0)));
                }
                if (fB == null) {
                    return false;
                }
                AbstractC0162z type = secondParameter.getType();
                kotlin.jvm.internal.h.e(type, "secondParameter.type");
                return KotlinTypeChecker.DEFAULT.isSubtypeOf(fB, b0.h(type, false));
            default:
                kotlin.jvm.internal.h.f(functionDescriptor, "functionDescriptor");
                List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
                kotlin.jvm.internal.h.e(valueParameters, "functionDescriptor.valueParameters");
                if (valueParameters.isEmpty()) {
                    return true;
                }
                for (ValueParameterDescriptor it : valueParameters) {
                    kotlin.jvm.internal.h.e(it, "it");
                    if (R2.e.a(it) || it.getVarargElementType() != null) {
                        return false;
                    }
                }
                return true;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public final String getDescription() {
        switch (this.f3316a) {
            case 0:
                return "second parameter must be of type KProperty<*> or its supertype";
            default:
                return "should not have varargs or parameters with default values";
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public final String invoke(FunctionDescriptor functionDescriptor) {
        switch (this.f3316a) {
        }
        return AbstractC0246d.X(this, functionDescriptor);
    }
}
