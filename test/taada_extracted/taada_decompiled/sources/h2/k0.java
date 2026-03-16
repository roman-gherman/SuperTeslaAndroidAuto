package h2;

import a.AbstractC0132a;
import g2.AbstractC0479a;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k0 extends AbstractC0514q implements KProperty {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Object f3411l = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final D f3412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f3413g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f3414h;
    public final Object i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f3415j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final q0 f3416k;

    public k0(D d, String str, String str2, PropertyDescriptor propertyDescriptor, Object obj) {
        this.f3412f = d;
        this.f3413g = str;
        this.f3414h = str2;
        this.i = obj;
        this.f3415j = AbstractC0132a.N(2, new j0(this, 1));
        this.f3416k = s0.g(propertyDescriptor, new j0(this, 0));
    }

    @Override // h2.AbstractC0514q
    public final Caller b() {
        return k().b();
    }

    @Override // h2.AbstractC0514q
    public final D c() {
        return this.f3412f;
    }

    @Override // h2.AbstractC0514q
    public final Caller d() {
        k().getClass();
        return null;
    }

    public final boolean equals(Object obj) {
        k0 k0VarC = x0.c(obj);
        return k0VarC != null && kotlin.jvm.internal.h.a(this.f3412f, k0VarC.f3412f) && kotlin.jvm.internal.h.a(this.f3413g, k0VarC.f3413g) && kotlin.jvm.internal.h.a(this.f3414h, k0VarC.f3414h) && kotlin.jvm.internal.h.a(this.i, k0VarC.i);
    }

    @Override // h2.AbstractC0514q
    public final boolean g() {
        return !kotlin.jvm.internal.h.a(this.i, kotlin.jvm.internal.b.NO_RECEIVER);
    }

    @Override // kotlin.reflect.KCallable
    public final String getName() {
        return this.f3413g;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, kotlin.Lazy] */
    public final Member h() {
        if (!e().isDelegated()) {
            return null;
        }
        L2.b bVar = v0.f3435a;
        s0 s0VarB = v0.b(e());
        if (s0VarB instanceof C0509l) {
            C0509l c0509l = (C0509l) s0VarB;
            J2.f fVar = c0509l.d;
            if ((fVar.b & 16) == 16) {
                J2.d dVar = fVar.f845g;
                int i = dVar.b;
                if ((i & 1) != 1 || (i & 2) != 2) {
                    return null;
                }
                int i3 = dVar.c;
                NameResolver nameResolver = c0509l.e;
                return this.f3412f.b(nameResolver.getString(i3), nameResolver.getString(dVar.d));
            }
        }
        return (Field) this.f3415j.getValue();
    }

    public final int hashCode() {
        return this.f3414h.hashCode() + androidx.constraintlayout.core.motion.a.c(this.f3412f.hashCode() * 31, 31, this.f3413g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object i(Member member, Object obj, Object obj2) throws A.a {
        try {
            Object obj3 = f3411l;
            if ((obj == obj3 || obj2 == obj3) && e().getExtensionReceiverParameter() == null) {
                throw new RuntimeException("'" + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
            }
            Object objL = g() ? E1.k.l(this.i, e()) : obj;
            if (objL == obj3) {
                objL = null;
            }
            if (!g()) {
                obj = obj2;
            }
            if (obj == obj3) {
                obj = null;
            }
            AccessibleObject accessibleObject = member instanceof AccessibleObject ? (AccessibleObject) member : null;
            if (accessibleObject != null) {
                accessibleObject.setAccessible(AbstractC0479a.a(this));
            }
            if (member == 0) {
                return null;
            }
            if (member instanceof Field) {
                return ((Field) member).get(objL);
            }
            if (!(member instanceof Method)) {
                throw new AssertionError("delegate field/method " + member + " neither field nor method");
            }
            int length = ((Method) member).getParameterTypes().length;
            if (length == 0) {
                return ((Method) member).invoke(null, new Object[0]);
            }
            if (length == 1) {
                Method method = (Method) member;
                if (objL == null) {
                    Class<?> cls = ((Method) member).getParameterTypes()[0];
                    kotlin.jvm.internal.h.e(cls, "fieldOrMethod.parameterTypes[0]");
                    objL = x0.e(cls);
                }
                return method.invoke(null, objL);
            }
            if (length != 2) {
                throw new AssertionError("delegate method " + member + " should take 0, 1, or 2 parameters");
            }
            Method method2 = (Method) member;
            if (obj == null) {
                Class<?> cls2 = ((Method) member).getParameterTypes()[1];
                kotlin.jvm.internal.h.e(cls2, "fieldOrMethod.parameterTypes[1]");
                obj = x0.e(cls2);
            }
            return method2.invoke(null, objL, obj);
        } catch (IllegalAccessException e) {
            throw new A.a("Cannot obtain the delegate of a non-accessible property. Use \"isAccessible = true\" to make the property accessible", e);
        }
    }

    @Override // kotlin.reflect.KProperty
    public final boolean isConst() {
        return e().isConst();
    }

    @Override // kotlin.reflect.KProperty
    public final boolean isLateinit() {
        return e().isLateInit();
    }

    @Override // kotlin.reflect.KCallable, kotlin.reflect.KFunction
    public final boolean isSuspend() {
        return false;
    }

    @Override // h2.AbstractC0514q
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final PropertyDescriptor e() {
        Object objInvoke = this.f3416k.invoke();
        kotlin.jvm.internal.h.e(objInvoke, "_descriptor()");
        return (PropertyDescriptor) objInvoke;
    }

    public abstract g0 k();

    public final String toString() {
        M2.s sVar = u0.f3433a;
        return u0.c(e());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k0(D container, String name, String signature, Object obj) {
        this(container, name, signature, null, obj);
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(signature, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public k0(D container, PropertyDescriptor propertyDescriptor) {
        kotlin.jvm.internal.h.f(container, "container");
        String strB = propertyDescriptor.getName().b();
        kotlin.jvm.internal.h.e(strB, "descriptor.name.asString()");
        this(container, strB, v0.b(propertyDescriptor).c(), propertyDescriptor, kotlin.jvm.internal.b.NO_RECEIVER);
    }
}
