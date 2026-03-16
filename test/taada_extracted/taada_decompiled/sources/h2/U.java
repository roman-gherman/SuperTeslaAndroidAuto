package h2;

import a3.AbstractC0162z;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public final class U implements KParameter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f3382f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0514q f3383a;
    public final int b;
    public final kotlin.reflect.b c;
    public final q0 d;
    public final q0 e;

    static {
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.w.f3817a;
        f3382f = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(U.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), xVar.f(new kotlin.jvm.internal.q(xVar.b(U.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    }

    public U(AbstractC0514q callable, int i, kotlin.reflect.b bVar, Function0 function0) {
        kotlin.jvm.internal.h.f(callable, "callable");
        this.f3383a = callable;
        this.b = i;
        this.c = bVar;
        this.d = s0.g(null, function0);
        this.e = s0.g(null, new T(this, 0));
    }

    public final ParameterDescriptor a() {
        KProperty kProperty = f3382f[0];
        Object objInvoke = this.d.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-descriptor>(...)");
        return (ParameterDescriptor) objInvoke;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof U)) {
            return false;
        }
        U u = (U) obj;
        if (kotlin.jvm.internal.h.a(this.f3383a, u.f3383a)) {
            return this.b == u.b;
        }
        return false;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public final List getAnnotations() {
        KProperty kProperty = f3382f[1];
        Object objInvoke = this.e.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-annotations>(...)");
        return (List) objInvoke;
    }

    @Override // kotlin.reflect.KParameter
    public final int getIndex() {
        return this.b;
    }

    @Override // kotlin.reflect.KParameter
    public final kotlin.reflect.b getKind() {
        return this.c;
    }

    @Override // kotlin.reflect.KParameter
    public final String getName() {
        ParameterDescriptor parameterDescriptorA = a();
        ValueParameterDescriptor valueParameterDescriptor = parameterDescriptorA instanceof ValueParameterDescriptor ? (ValueParameterDescriptor) parameterDescriptorA : null;
        if (valueParameterDescriptor != null && !valueParameterDescriptor.getContainingDeclaration().hasSynthesizedParameterNames()) {
            L2.f name = valueParameterDescriptor.getName();
            kotlin.jvm.internal.h.e(name, "valueParameter.name");
            if (!name.b) {
                return name.b();
            }
        }
        return null;
    }

    @Override // kotlin.reflect.KParameter
    public final KType getType() {
        AbstractC0162z type = a().getType();
        kotlin.jvm.internal.h.e(type, "descriptor.type");
        return new n0(type, new T(this, 1));
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.f3383a.hashCode() * 31);
    }

    @Override // kotlin.reflect.KParameter
    public final boolean isOptional() {
        ParameterDescriptor parameterDescriptorA = a();
        ValueParameterDescriptor valueParameterDescriptor = parameterDescriptorA instanceof ValueParameterDescriptor ? (ValueParameterDescriptor) parameterDescriptorA : null;
        if (valueParameterDescriptor != null) {
            return R2.e.a(valueParameterDescriptor);
        }
        return false;
    }

    @Override // kotlin.reflect.KParameter
    public final boolean isVararg() {
        ParameterDescriptor parameterDescriptorA = a();
        return (parameterDescriptorA instanceof ValueParameterDescriptor) && ((ValueParameterDescriptor) parameterDescriptorA).getVarargElementType() != null;
    }

    public final String toString() {
        String strB;
        M2.s sVar = u0.f3433a;
        StringBuilder sb = new StringBuilder();
        int iOrdinal = this.c.ordinal();
        if (iOrdinal == 0) {
            sb.append("instance parameter");
        } else if (iOrdinal == 1) {
            sb.append("extension receiver parameter");
        } else if (iOrdinal == 2) {
            sb.append("parameter #" + this.b + ' ' + getName());
        }
        sb.append(" of ");
        CallableMemberDescriptor callableMemberDescriptorE = this.f3383a.e();
        if (callableMemberDescriptorE instanceof PropertyDescriptor) {
            strB = u0.c((PropertyDescriptor) callableMemberDescriptorE);
        } else {
            if (!(callableMemberDescriptorE instanceof FunctionDescriptor)) {
                throw new IllegalStateException(("Illegal callable: " + callableMemberDescriptorE).toString());
            }
            strB = u0.b((FunctionDescriptor) callableMemberDescriptorE);
        }
        sb.append(strB);
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
