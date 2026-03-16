package org.mockito.internal.util.reflection;

import D0.b;
import java.lang.instrument.Instrumentation;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.matcher.ElementMatchers;
import org.mockito.exceptions.base.MockitoInitializationException;
import org.mockito.internal.util.StringUtil;
import org.mockito.plugins.MemberAccessor;

/* JADX INFO: loaded from: classes.dex */
class InstrumentationMemberAccessor implements MemberAccessor {
    private static final Dispatcher DISPATCHER;
    private static final Throwable INITIALIZATION_ERROR;
    private static final Instrumentation INSTRUMENTATION;
    private static final Map<Class<?>, Class<?>> WRAPPERS;
    private final MethodHandle getModule;
    private final MethodHandle isOpen;
    private final MethodHandle privateLookupIn;
    private final MethodHandle redefineModule;

    public interface Dispatcher {
        MethodHandles.Lookup getLookup();

        Object getModule();

        Object invokeWithArguments(MethodHandle methodHandle, Object... objArr);

        void setAccessible(AccessibleObject accessibleObject, boolean z6);
    }

    static {
        Throwable th;
        Dispatcher dispatcher;
        HashMap map = new HashMap();
        WRAPPERS = map;
        Class cls = Boolean.TYPE;
        map.put(cls, Boolean.class);
        map.put(Byte.TYPE, Byte.class);
        map.put(Short.TYPE, Short.class);
        map.put(Character.TYPE, Character.class);
        map.put(Integer.TYPE, Integer.class);
        map.put(Long.TYPE, Long.class);
        map.put(Float.TYPE, Float.class);
        map.put(Double.TYPE, Double.class);
        Instrumentation instrumentation = null;
        try {
            Instrumentation instrumentationInstall = ByteBuddyAgent.install();
            dispatcher = (Dispatcher) new ByteBuddy().subclass(Dispatcher.class).method(ElementMatchers.named("getLookup")).intercept(MethodCall.invoke(MethodHandles.class.getMethod("lookup", new Class[0]))).method(ElementMatchers.named("getModule")).intercept(MethodCall.invoke(Class.class.getMethod("getModule", new Class[0])).onMethodCall(MethodCall.invoke(Object.class.getMethod("getClass", new Class[0])))).method(ElementMatchers.named("setAccessible")).intercept(MethodCall.invoke(AccessibleObject.class.getMethod("setAccessible", cls)).onArgument(0).withArgument(1)).method(ElementMatchers.named("invokeWithArguments")).intercept(MethodCall.invoke(MethodHandle.class.getMethod("invokeWithArguments", Object[].class)).onArgument(0).withArgument(1)).make().load(InstrumentationMemberAccessor.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER).getLoaded().getConstructor(new Class[0]).newInstance(new Object[0]);
            th = null;
            instrumentation = instrumentationInstall;
        } catch (Throwable th2) {
            th = th2;
            dispatcher = null;
        }
        INSTRUMENTATION = instrumentation;
        DISPATCHER = dispatcher;
        INITIALIZATION_ERROR = th;
    }

    public InstrumentationMemberAccessor() {
        Throwable th = INITIALIZATION_ERROR;
        if (th != null) {
            throw new MockitoInitializationException(StringUtil.join("Could not initialize the Mockito instrumentation member accessor", "", "This is unexpected on JVMs from Java 9 or later - possibly, the instrumentation API could not be resolved"), th);
        }
        try {
            Class<?> cls = Class.forName("java.lang.Module");
            this.getModule = MethodHandles.publicLookup().findVirtual(Class.class, "getModule", MethodType.methodType(cls));
            this.isOpen = MethodHandles.publicLookup().findVirtual(cls, "isOpen", MethodType.methodType((Class<?>) Boolean.TYPE, (Class<?>) String.class));
            this.redefineModule = MethodHandles.publicLookup().findVirtual(Instrumentation.class, "redefineModule", MethodType.methodType(Void.TYPE, cls, Set.class, Map.class, Map.class, Set.class, Map.class));
            this.privateLookupIn = MethodHandles.publicLookup().findStatic(MethodHandles.class, "privateLookupIn", MethodType.methodType(MethodHandles.Lookup.class, Class.class, MethodHandles.Lookup.class));
        } catch (Throwable th2) {
            throw new MockitoInitializationException("Could not resolve instrumentation invoker", th2);
        }
    }

    private static void assureArguments(AccessibleObject accessibleObject, Object obj, Class<?> cls, Object[] objArr, Class<?>[] clsArr) {
        if (obj != null && !cls.isAssignableFrom(obj.getClass())) {
            throw new IllegalArgumentException("Cannot access " + accessibleObject + " on " + obj);
        }
        if (clsArr.length != objArr.length) {
            throw new IllegalArgumentException("Incorrect number of arguments for " + accessibleObject + ": expected " + clsArr.length + " but recevied " + objArr.length);
        }
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i] != null) {
                Map<Class<?>, Class<?>> map = WRAPPERS;
                Class<?> cls2 = clsArr[i];
                Class<?> orDefault = map.getOrDefault(cls2, cls2);
                if (!orDefault.isAssignableFrom(objArr[i].getClass())) {
                    throw new IllegalArgumentException("Cannot assign value of type " + objArr[i].getClass() + " to " + orDefault + " for " + i + " parameter of " + accessibleObject);
                }
            } else if (clsArr[i].isPrimitive()) {
                throw new IllegalArgumentException("Cannot assign null to primitive type " + clsArr[i].getTypeName() + " for " + i + " parameter of " + accessibleObject);
            }
        }
    }

    private void assureOpen(Object obj, String str) {
        Dispatcher dispatcher = DISPATCHER;
        if (((Boolean) dispatcher.invokeWithArguments(this.isOpen, obj, str)).booleanValue()) {
            return;
        }
        MethodHandle methodHandleBindTo = this.redefineModule.bindTo(INSTRUMENTATION);
        Set set = Collections.EMPTY_SET;
        Map map = Collections.EMPTY_MAP;
        dispatcher.invokeWithArguments(methodHandleBindTo, obj, set, map, Collections.singletonMap(str, Collections.singleton(dispatcher.getModule())), set, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$newInstance$0(MethodHandle methodHandle, Object[] objArr, AtomicBoolean atomicBoolean) {
        try {
            return DISPATCHER.invokeWithArguments(methodHandle, objArr);
        } catch (Throwable th) {
            atomicBoolean.set(true);
            return th;
        }
    }

    @Override // org.mockito.plugins.MemberAccessor
    public Object get(Field field, Object obj) {
        assureArguments(field, Modifier.isStatic(field.getModifiers()) ? null : obj, field.getDeclaringClass(), new Object[0], new Class[0]);
        try {
            Dispatcher dispatcher = DISPATCHER;
            assureOpen(dispatcher.invokeWithArguments(this.getModule.bindTo(field.getDeclaringClass()), new Object[0]), field.getDeclaringClass().getPackage().getName());
            MethodHandle methodHandleUnreflectGetter = ((MethodHandles.Lookup) dispatcher.invokeWithArguments(this.privateLookupIn, field.getDeclaringClass(), dispatcher.getLookup())).unreflectGetter(field);
            if (!Modifier.isStatic(field.getModifiers())) {
                methodHandleUnreflectGetter = methodHandleUnreflectGetter.bindTo(obj);
            }
            return dispatcher.invokeWithArguments(methodHandleUnreflectGetter, new Object[0]);
        } catch (Throwable th) {
            throw new IllegalStateException("Could not read " + field + " on " + obj, th);
        }
    }

    @Override // org.mockito.plugins.MemberAccessor
    public Object invoke(Method method, Object obj, Object... objArr) throws InvocationTargetException {
        InvocationTargetException invocationTargetException;
        assureArguments(method, Modifier.isStatic(method.getModifiers()) ? null : obj, method.getDeclaringClass(), objArr, method.getParameterTypes());
        try {
            Dispatcher dispatcher = DISPATCHER;
            assureOpen(dispatcher.invokeWithArguments(this.getModule.bindTo(method.getDeclaringClass()), new Object[0]), method.getDeclaringClass().getPackage().getName());
            MethodHandle methodHandleUnreflect = ((MethodHandles.Lookup) dispatcher.invokeWithArguments(this.privateLookupIn, method.getDeclaringClass(), dispatcher.getLookup())).unreflect(method);
            if (!Modifier.isStatic(method.getModifiers())) {
                methodHandleUnreflect = methodHandleUnreflect.bindTo(obj);
            }
            if (methodHandleUnreflect.isVarargsCollector()) {
                methodHandleUnreflect = methodHandleUnreflect.asFixedArity();
            }
            try {
                return dispatcher.invokeWithArguments(methodHandleUnreflect, objArr);
            } finally {
            }
        } catch (InvocationTargetException e) {
            throw e;
        } catch (Throwable th) {
            throw new IllegalStateException("Could not invoke " + method + " on " + obj + " with arguments " + Arrays.toString(objArr), th);
        }
    }

    @Override // org.mockito.plugins.MemberAccessor
    /* JADX INFO: renamed from: newInstance */
    public Object lambda$newInstance$0(Constructor<?> constructor, Object... objArr) {
        return newInstance(constructor, new b(24), objArr);
    }

    @Override // org.mockito.plugins.MemberAccessor
    public void set(Field field, Object obj, Object obj2) throws IllegalAccessException {
        boolean z6;
        assureArguments(field, Modifier.isStatic(field.getModifiers()) ? null : obj, field.getDeclaringClass(), new Object[]{obj2}, new Class[]{field.getType()});
        boolean z7 = false;
        try {
            Dispatcher dispatcher = DISPATCHER;
            assureOpen(dispatcher.invokeWithArguments(this.getModule.bindTo(field.getDeclaringClass()), new Object[0]), field.getDeclaringClass().getPackage().getName());
            if (Modifier.isFinal(field.getModifiers())) {
                z6 = true;
                try {
                    dispatcher.setAccessible(field, true);
                } catch (Throwable th) {
                    th = th;
                    z7 = true;
                    if (z7) {
                        throw th;
                    }
                    throw new IllegalStateException("Could not read " + field + " on " + obj, th);
                }
            } else {
                z6 = false;
            }
            try {
                MethodHandle methodHandleUnreflectSetter = ((MethodHandles.Lookup) dispatcher.invokeWithArguments(this.privateLookupIn, field.getDeclaringClass(), dispatcher.getLookup())).unreflectSetter(field);
                if (!Modifier.isStatic(field.getModifiers())) {
                    methodHandleUnreflectSetter = methodHandleUnreflectSetter.bindTo(obj);
                }
                dispatcher.invokeWithArguments(methodHandleUnreflectSetter, obj2);
                if (z6) {
                    dispatcher.setAccessible(field, false);
                }
            } catch (Throwable th2) {
                if (z6) {
                    DISPATCHER.setAccessible(field, false);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // org.mockito.plugins.MemberAccessor
    public Object newInstance(Constructor<?> constructor, MemberAccessor.OnConstruction onConstruction, final Object... objArr) throws InstantiationException, InvocationTargetException {
        if (Modifier.isAbstract(constructor.getDeclaringClass().getModifiers())) {
            throw new InstantiationException("Cannot instantiate abstract " + constructor.getDeclaringClass().getTypeName());
        }
        assureArguments(constructor, null, null, objArr, constructor.getParameterTypes());
        try {
            Dispatcher dispatcher = DISPATCHER;
            assureOpen(dispatcher.invokeWithArguments(this.getModule.bindTo(constructor.getDeclaringClass()), new Object[0]), constructor.getDeclaringClass().getPackage().getName());
            final MethodHandle methodHandleUnreflectConstructor = ((MethodHandles.Lookup) dispatcher.invokeWithArguments(this.privateLookupIn, constructor.getDeclaringClass(), dispatcher.getLookup())).unreflectConstructor(constructor);
            final AtomicBoolean atomicBoolean = new AtomicBoolean();
            Object objInvoke = onConstruction.invoke(new MemberAccessor.ConstructionDispatcher() { // from class: org.mockito.internal.util.reflection.a
                @Override // org.mockito.plugins.MemberAccessor.ConstructionDispatcher
                public final Object newInstance() {
                    return InstrumentationMemberAccessor.lambda$newInstance$0(methodHandleUnreflectConstructor, objArr, atomicBoolean);
                }
            });
            if (atomicBoolean.get()) {
                throw new InvocationTargetException((Throwable) objInvoke);
            }
            return objInvoke;
        } catch (InvocationTargetException e) {
            throw e;
        } catch (Throwable th) {
            throw new IllegalStateException("Could not construct " + constructor + " with arguments " + Arrays.toString(objArr), th);
        }
    }
}
