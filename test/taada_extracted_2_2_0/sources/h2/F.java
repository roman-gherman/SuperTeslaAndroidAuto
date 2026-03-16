package h2;

import a.AbstractC0132a;
import a3.AbstractC0162z;
import i2.C0531d;
import i2.C0532e;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.FunctionBase;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.FunctionWithAllInvokes;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import n2.AbstractC0713e;

/* JADX INFO: loaded from: classes2.dex */
public final class F extends AbstractC0514q implements FunctionBase, KFunction, FunctionWithAllInvokes {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f3366l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final D f3367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f3368g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f3369h;
    public final q0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f3370j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f3371k;

    static {
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.w.f3818a;
        f3366l = new KProperty[]{xVar.f(new kotlin.jvm.internal.q(xVar.b(F.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;"))};
    }

    public F(D d, String str, String str2, FunctionDescriptor functionDescriptor, Object obj) {
        this.f3367f = d;
        this.f3368g = str2;
        this.f3369h = obj;
        this.i = s0.g(functionDescriptor, new A2.y(5, this, str));
        this.f3370j = AbstractC0132a.N(2, new E(this, 0));
        this.f3371k = AbstractC0132a.N(2, new E(this, 1));
    }

    public static final i2.r h(F f6, Constructor constructor, FunctionDescriptor functionDescriptor, boolean z6) {
        Class cls = null;
        if (!z6) {
            f6.getClass();
            ClassConstructorDescriptor classConstructorDescriptor = functionDescriptor instanceof ClassConstructorDescriptor ? (ClassConstructorDescriptor) functionDescriptor : null;
            if (classConstructorDescriptor != null && !AbstractC0713e.e(classConstructorDescriptor.getVisibility())) {
                ClassDescriptor constructedClass = classConstructorDescriptor.getConstructedClass();
                kotlin.jvm.internal.h.e(constructedClass, "constructorDescriptor.constructedClass");
                if (!N2.i.b(constructedClass) && !N2.f.q(classConstructorDescriptor.getConstructedClass())) {
                    List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
                    kotlin.jvm.internal.h.e(valueParameters, "constructorDescriptor.valueParameters");
                    if (!valueParameters.isEmpty()) {
                        Iterator<T> it = valueParameters.iterator();
                        while (it.hasNext()) {
                            AbstractC0162z type = ((ValueParameterDescriptor) it.next()).getType();
                            kotlin.jvm.internal.h.e(type, "it.type");
                            if (AbstractC0132a.b0(type)) {
                                if (f6.g()) {
                                    return new C0531d(constructor, E1.k.l(f6.f3369h, f6.e()), 0);
                                }
                                kotlin.jvm.internal.h.f(constructor, "constructor");
                                Class declaringClass = constructor.getDeclaringClass();
                                kotlin.jvm.internal.h.e(declaringClass, "constructor.declaringClass");
                                Type[] genericParameterTypes = constructor.getGenericParameterTypes();
                                kotlin.jvm.internal.h.e(genericParameterTypes, "constructor.genericParameterTypes");
                                return new C0532e(constructor, declaringClass, cls, (Type[]) (genericParameterTypes.length <= 1 ? new Type[0] : kotlin.collections.j.x(genericParameterTypes, 0, genericParameterTypes.length - 1)), 0);
                            }
                        }
                    }
                }
            }
        }
        if (f6.g()) {
            return new C0531d(constructor, E1.k.l(f6.f3369h, f6.e()), 1);
        }
        kotlin.jvm.internal.h.f(constructor, "constructor");
        Class declaringClass2 = constructor.getDeclaringClass();
        kotlin.jvm.internal.h.e(declaringClass2, "constructor.declaringClass");
        Class declaringClass3 = constructor.getDeclaringClass();
        Class<?> declaringClass4 = declaringClass3.getDeclaringClass();
        Class<?> cls2 = (declaringClass4 == null || Modifier.isStatic(declaringClass3.getModifiers())) ? null : declaringClass4;
        Type[] genericParameterTypes2 = constructor.getGenericParameterTypes();
        kotlin.jvm.internal.h.e(genericParameterTypes2, "constructor.genericParameterTypes");
        return new C0532e(constructor, declaringClass2, cls2, genericParameterTypes2, 1);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // h2.AbstractC0514q
    public final Caller b() {
        return (Caller) this.f3370j.getValue();
    }

    @Override // h2.AbstractC0514q
    public final D c() {
        return this.f3367f;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // h2.AbstractC0514q
    public final Caller d() {
        return (Caller) this.f3371k.getValue();
    }

    public final boolean equals(Object obj) {
        F fB = x0.b(obj);
        return fB != null && kotlin.jvm.internal.h.a(this.f3367f, fB.f3367f) && getName().equals(fB.getName()) && kotlin.jvm.internal.h.a(this.f3368g, fB.f3368g) && kotlin.jvm.internal.h.a(this.f3369h, fB.f3369h);
    }

    @Override // h2.AbstractC0514q
    public final boolean g() {
        return !kotlin.jvm.internal.h.a(this.f3369h, kotlin.jvm.internal.b.NO_RECEIVER);
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public final int getArity() {
        return C5.f.C(b());
    }

    @Override // kotlin.reflect.KCallable
    public final String getName() {
        String strB = e().getName().b();
        kotlin.jvm.internal.h.e(strB, "descriptor.name.asString()");
        return strB;
    }

    public final int hashCode() {
        return this.f3368g.hashCode() + ((getName().hashCode() + (this.f3367f.hashCode() * 31)) * 31);
    }

    @Override // h2.AbstractC0514q
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final FunctionDescriptor e() {
        KProperty kProperty = f3366l[0];
        Object objInvoke = this.i.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "<get-descriptor>(...)");
        return (FunctionDescriptor) objInvoke;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return call(new Object[0]);
    }

    @Override // kotlin.reflect.KFunction
    public final boolean isExternal() {
        return e().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public final boolean isInfix() {
        return e().isInfix();
    }

    @Override // kotlin.reflect.KFunction
    public final boolean isInline() {
        return e().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public final boolean isOperator() {
        return e().isOperator();
    }

    @Override // kotlin.reflect.KCallable, kotlin.reflect.KFunction
    public final boolean isSuspend() {
        return e().isSuspend();
    }

    public final String toString() {
        M2.s sVar = u0.f3434a;
        return u0.b(e());
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return call(obj);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo5invoke(Object obj, Object obj2) {
        return call(obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return call(obj, obj2, obj3);
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return call(obj, obj2, obj3, obj4);
    }

    @Override // kotlin.jvm.functions.Function5
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return call(obj, obj2, obj3, obj4, obj5);
    }

    @Override // kotlin.jvm.functions.Function6
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return call(obj, obj2, obj3, obj4, obj5, obj6);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public F(D container, FunctionDescriptor descriptor) {
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(descriptor, "descriptor");
        String strB = descriptor.getName().b();
        kotlin.jvm.internal.h.e(strB, "descriptor.name.asString()");
        this(container, strB, v0.c(descriptor).c(), descriptor, kotlin.jvm.internal.b.NO_RECEIVER);
    }

    @Override // kotlin.jvm.functions.Function7
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // kotlin.jvm.functions.Function8
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // kotlin.jvm.functions.Function9
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // kotlin.jvm.functions.Function10
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // kotlin.jvm.functions.Function11
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // kotlin.jvm.functions.Function12
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // kotlin.jvm.functions.Function13
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // kotlin.jvm.functions.Function14
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // kotlin.jvm.functions.Function15
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // kotlin.jvm.functions.Function16
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // kotlin.jvm.functions.Function17
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // kotlin.jvm.functions.Function18
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Override // kotlin.jvm.functions.Function19
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    @Override // kotlin.jvm.functions.Function20
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Override // kotlin.jvm.functions.Function21
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }

    @Override // kotlin.jvm.functions.Function22
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21, Object obj22) {
        return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }
}
