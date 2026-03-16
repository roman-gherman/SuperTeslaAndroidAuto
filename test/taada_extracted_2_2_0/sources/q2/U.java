package q2;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
public abstract class U extends T {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4586f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public NullableLazyValue f4587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kotlin.jvm.internal.i f4588h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U(DeclarationDescriptor declarationDescriptor, Annotations annotations, L2.f fVar, boolean z6, SourceElement sourceElement) {
        super(declarationDescriptor, annotations, fVar, null, sourceElement);
        if (declarationDescriptor == null) {
            a(0);
            throw null;
        }
        if (annotations == null) {
            a(1);
            throw null;
        }
        if (fVar == null) {
            a(2);
            throw null;
        }
        if (sourceElement == null) {
            a(3);
            throw null;
        }
        this.f4586f = z6;
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "annotations";
        } else if (i == 2) {
            objArr[0] = "name";
        } else if (i == 3) {
            objArr[0] = "source";
        } else if (i == 4 || i == 5) {
            objArr[0] = "compileTimeInitializerFactory";
        } else {
            objArr[0] = "containingDeclaration";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i == 4) {
            objArr[2] = "setCompileTimeInitializerFactory";
        } else if (i != 5) {
            objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(NullableLazyValue nullableLazyValue, Function0 function0) {
        if (function0 == 0) {
            a(5);
            throw null;
        }
        this.f4588h = (kotlin.jvm.internal.i) function0;
        if (nullableLazyValue == null) {
            nullableLazyValue = (NullableLazyValue) function0.invoke();
        }
        this.f4587g = nullableLazyValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public final P2.g getCompileTimeInitializer() {
        NullableLazyValue nullableLazyValue = this.f4587g;
        if (nullableLazyValue != null) {
            return (P2.g) nullableLazyValue.invoke();
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public final boolean isVar() {
        return this.f4586f;
    }
}
