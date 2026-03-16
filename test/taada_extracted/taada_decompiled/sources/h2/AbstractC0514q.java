package h2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KTypeParameterOwnerImpl;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import n2.AbstractC0714f;
import n2.EnumC0719k;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: renamed from: h2.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0514q implements KCallable, KTypeParameterOwnerImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q0 f3427a = s0.g(null, new C0511n(this, 1));
    public final q0 b = s0.g(null, new C0511n(this, 2));
    public final q0 c = s0.g(null, new C0511n(this, 4));
    public final q0 d = s0.g(null, new C0511n(this, 5));
    public final q0 e = s0.g(null, new C0511n(this, 0));

    public static Object a(KType kType) {
        Class clsH = E1.k.H(C5.f.G(kType));
        if (clsH.isArray()) {
            Object objNewInstance = Array.newInstance(clsH.getComponentType(), 0);
            kotlin.jvm.internal.h.e(objNewInstance, "type.jvmErasure.java.run…\"\n            )\n        }");
            return objNewInstance;
        }
        throw new N1.d("Cannot instantiate the default empty array of type " + clsH.getSimpleName() + ", because it is not an array type", 2);
    }

    public abstract Caller b();

    public abstract D c();

    @Override // kotlin.reflect.KCallable
    public final Object call(Object... args) throws A.a {
        kotlin.jvm.internal.h.f(args, "args");
        try {
            return b().call(args);
        } catch (IllegalAccessException e) {
            throw new A.a(e);
        }
    }

    @Override // kotlin.reflect.KCallable
    public final Object callBy(Map args) throws A.a {
        Object objA;
        kotlin.jvm.internal.h.f(args, "args");
        boolean z6 = false;
        if (f()) {
            List<KParameter> parameters = getParameters();
            ArrayList arrayList = new ArrayList(kotlin.collections.o.D(parameters));
            for (KParameter kParameter : parameters) {
                if (args.containsKey(kParameter)) {
                    objA = args.get(kParameter);
                    if (objA == null) {
                        throw new IllegalArgumentException("Annotation argument value cannot be null (" + kParameter + ')');
                    }
                } else if (kParameter.isOptional()) {
                    objA = null;
                } else {
                    if (!kParameter.isVararg()) {
                        throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
                    }
                    objA = a(kParameter.getType());
                }
                arrayList.add(objA);
            }
            Caller callerD = d();
            if (callerD != null) {
                try {
                    return callerD.call(arrayList.toArray(new Object[0]));
                } catch (IllegalAccessException e) {
                    throw new A.a(e);
                }
            }
            throw new N1.d("This callable does not support a default call: " + e(), 2);
        }
        List<KParameter> parameters2 = getParameters();
        if (parameters2.isEmpty()) {
            try {
                return b().call(isSuspend() ? new Continuation[]{null} : new Continuation[0]);
            } catch (IllegalAccessException e6) {
                throw new A.a(e6);
            }
        }
        int size = (isSuspend() ? 1 : 0) + parameters2.size();
        Object[] objArr = (Object[]) ((Object[]) this.e.invoke()).clone();
        if (isSuspend()) {
            objArr[parameters2.size()] = null;
        }
        int i = 0;
        for (KParameter kParameter2 : parameters2) {
            if (args.containsKey(kParameter2)) {
                objArr[kParameter2.getIndex()] = args.get(kParameter2);
            } else if (kParameter2.isOptional()) {
                int i3 = (i / 32) + size;
                Object obj = objArr[i3];
                kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type kotlin.Int");
                objArr[i3] = Integer.valueOf(((Integer) obj).intValue() | (1 << (i % 32)));
                z6 = true;
            } else if (!kParameter2.isVararg()) {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter2);
            }
            if (kParameter2.getKind() == kotlin.reflect.b.c) {
                i++;
            }
        }
        if (!z6) {
            try {
                Caller callerB = b();
                Object[] objArrCopyOf = Arrays.copyOf(objArr, size);
                kotlin.jvm.internal.h.e(objArrCopyOf, "copyOf(this, newSize)");
                return callerB.call(objArrCopyOf);
            } catch (IllegalAccessException e7) {
                throw new A.a(e7);
            }
        }
        Caller callerD2 = d();
        if (callerD2 != null) {
            try {
                return callerD2.call(objArr);
            } catch (IllegalAccessException e8) {
                throw new A.a(e8);
            }
        }
        throw new N1.d("This callable does not support a default call: " + e(), 2);
    }

    public abstract Caller d();

    public abstract CallableMemberDescriptor e();

    public final boolean f() {
        return kotlin.jvm.internal.h.a(getName(), MethodDescription.CONSTRUCTOR_INTERNAL_NAME) && c().getJClass().isAnnotation();
    }

    public abstract boolean g();

    @Override // kotlin.reflect.KAnnotatedElement
    public final List getAnnotations() {
        Object objInvoke = this.f3427a.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "_annotations()");
        return (List) objInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public final List getParameters() {
        Object objInvoke = this.b.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "_parameters()");
        return (List) objInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public final KType getReturnType() {
        Object objInvoke = this.c.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "_returnType()");
        return (KType) objInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public final List getTypeParameters() {
        Object objInvoke = this.d.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "_typeParameters()");
        return (List) objInvoke;
    }

    @Override // kotlin.reflect.KCallable
    public final kotlin.reflect.f getVisibility() {
        AbstractC0714f visibility = e().getVisibility();
        kotlin.jvm.internal.h.e(visibility, "descriptor.visibility");
        return x0.k(visibility);
    }

    @Override // kotlin.reflect.KCallable
    public final boolean isAbstract() {
        return e().getModality() == EnumC0719k.d;
    }

    @Override // kotlin.reflect.KCallable
    public final boolean isFinal() {
        return e().getModality() == EnumC0719k.f4247a;
    }

    @Override // kotlin.reflect.KCallable
    public final boolean isOpen() {
        return e().getModality() == EnumC0719k.c;
    }
}
