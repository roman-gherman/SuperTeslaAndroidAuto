package com.android.dx.stock;

import B2.b;
import androidx.constraintlayout.core.motion.a;
import com.android.dx.Code;
import com.android.dx.Comparison;
import com.android.dx.DexMaker;
import com.android.dx.Label;
import com.android.dx.Local;
import com.android.dx.MethodId;
import com.android.dx.TypeId;
import com.android.dx.rop.code.RegisterSpec;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.JavaConstant;

/* JADX INFO: loaded from: classes.dex */
public final class ProxyBuilder<T> {
    private static final String FIELD_NAME_HANDLER = "$__handler";
    private static final String FIELD_NAME_METHODS = "$__methodArray";
    private static final Map<Class<?>, Class<?>> PRIMITIVE_TO_BOXED;
    private static final Map<Class<?>, MethodId<?, ?>> PRIMITIVE_TO_UNBOX_METHOD;
    private static final Map<TypeId<?>, MethodId<?, ?>> PRIMITIVE_TYPE_TO_UNBOX_METHOD;
    public static final int VERSION = 1;
    private static final Map<ProxiedClass<?>, Class<?>> generatedProxyClasses = Collections.synchronizedMap(new HashMap());
    private final Class<T> baseClass;
    private File dexCache;
    private InvocationHandler handler;
    private boolean markTrusted;
    private Method[] methods;
    private boolean sharedClassLoader;
    private ClassLoader parentClassLoader = ProxyBuilder.class.getClassLoader();
    private Class<?>[] constructorArgTypes = new Class[0];
    private Object[] constructorArgValues = new Object[0];
    private List<Class<?>> interfaces = new ArrayList();

    public static class MethodSetEntry {
        public final String name;
        public final Method originalMethod;
        public final Class<?>[] paramTypes;
        public final Class<?> returnType;

        public MethodSetEntry(Method method) {
            this.originalMethod = method;
            this.name = method.getName();
            this.paramTypes = method.getParameterTypes();
            this.returnType = method.getReturnType();
        }

        public boolean equals(Object obj) {
            if (obj instanceof MethodSetEntry) {
                MethodSetEntry methodSetEntry = (MethodSetEntry) obj;
                if (this.name.equals(methodSetEntry.name) && this.returnType.equals(methodSetEntry.returnType) && Arrays.equals(this.paramTypes, methodSetEntry.paramTypes)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int iHashCode = this.name.hashCode() + 544;
            int iHashCode2 = this.returnType.hashCode() + (iHashCode * 31) + iHashCode;
            return (iHashCode2 * 31) + Arrays.hashCode(this.paramTypes) + iHashCode2;
        }
    }

    public static class ProxiedClass<U> {
        final Class<U> clazz;
        final List<Class<?>> interfaces;
        final ClassLoader requestedClassloader;
        final boolean sharedClassLoader;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                ProxiedClass proxiedClass = (ProxiedClass) obj;
                if (this.clazz == proxiedClass.clazz && this.interfaces.equals(proxiedClass.interfaces) && this.requestedClassloader == proxiedClass.requestedClassloader && this.sharedClassLoader == proxiedClass.sharedClassLoader) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.requestedClassloader.hashCode() + this.interfaces.hashCode() + this.clazz.hashCode() + (this.sharedClassLoader ? 1 : 0);
        }

        private ProxiedClass(Class<U> cls, List<Class<?>> list, ClassLoader classLoader, boolean z6) {
            this.clazz = cls;
            this.interfaces = new ArrayList(list);
            this.requestedClassloader = classLoader;
            this.sharedClassLoader = z6;
        }
    }

    static {
        HashMap map = new HashMap();
        PRIMITIVE_TO_BOXED = map;
        Class cls = Boolean.TYPE;
        map.put(cls, Boolean.class);
        Class cls2 = Integer.TYPE;
        Class<Integer> cls3 = Integer.class;
        map.put(cls2, cls3);
        Class cls4 = Byte.TYPE;
        Class<Byte> cls5 = Byte.class;
        map.put(cls4, cls5);
        Class cls6 = Long.TYPE;
        map.put(cls6, Long.class);
        Class cls7 = Short.TYPE;
        map.put(cls7, Short.class);
        Class cls8 = Float.TYPE;
        map.put(cls8, Float.class);
        Class cls9 = Double.TYPE;
        map.put(cls9, Double.class);
        Class cls10 = Character.TYPE;
        Class<Character> cls11 = Character.class;
        map.put(cls10, cls11);
        PRIMITIVE_TYPE_TO_UNBOX_METHOD = new HashMap();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Iterator it2 = it;
            TypeId<?> typeId = TypeId.get((Class) entry.getKey());
            Class<Character> cls12 = cls11;
            TypeId typeId2 = TypeId.get((Class) entry.getValue());
            PRIMITIVE_TYPE_TO_UNBOX_METHOD.put(typeId, typeId2.getMethod(typeId2, "valueOf", typeId));
            cls3 = cls3;
            cls11 = cls12;
            it = it2;
            cls5 = cls5;
        }
        HashMap map2 = new HashMap();
        map2.put(cls, TypeId.get(Boolean.class).getMethod(TypeId.BOOLEAN, "booleanValue", new TypeId[0]));
        map2.put(cls2, TypeId.get(cls3).getMethod(TypeId.INT, "intValue", new TypeId[0]));
        map2.put(cls4, TypeId.get(cls5).getMethod(TypeId.BYTE, "byteValue", new TypeId[0]));
        map2.put(cls6, TypeId.get(Long.class).getMethod(TypeId.LONG, "longValue", new TypeId[0]));
        map2.put(cls7, TypeId.get(Short.class).getMethod(TypeId.SHORT, "shortValue", new TypeId[0]));
        map2.put(cls8, TypeId.get(Float.class).getMethod(TypeId.FLOAT, "floatValue", new TypeId[0]));
        map2.put(cls9, TypeId.get(Double.class).getMethod(TypeId.DOUBLE, "doubleValue", new TypeId[0]));
        map2.put(cls10, TypeId.get(cls11).getMethod(TypeId.CHAR, "charValue", new TypeId[0]));
        PRIMITIVE_TO_UNBOX_METHOD = map2;
    }

    private ProxyBuilder(Class<T> cls) {
        this.baseClass = cls;
    }

    private static Local<?> boxIfRequired(Code code, Local<?> local, Local<Object> local2) {
        MethodId<?, ?> methodId = PRIMITIVE_TYPE_TO_UNBOX_METHOD.get(local.getType());
        if (methodId == null) {
            return local;
        }
        code.invokeStatic(methodId, local2, local);
        return local2;
    }

    public static Object callSuper(Object obj, Method method, Object... objArr) throws Throwable {
        try {
            return obj.getClass().getMethod(superMethodName(method), method.getParameterTypes()).invoke(obj, objArr);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    private static void check(boolean z6, String str) {
        if (!z6) {
            throw new IllegalArgumentException(str);
        }
    }

    private static TypeId<?>[] classArrayToTypeArray(Class<?>[] clsArr) {
        TypeId<?>[] typeIdArr = new TypeId[clsArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            typeIdArr[i] = TypeId.get(clsArr[i]);
        }
        return typeIdArr;
    }

    public static <T> ProxyBuilder<T> forClass(Class<T> cls) {
        return new ProxyBuilder<>(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T, G extends T> void generateCodeForAllMethods(DexMaker dexMaker, TypeId<G> typeId, Method[] methodArr, TypeId<T> typeId2) {
        TypeId<?>[] typeIdArr;
        Local localNewLocal;
        Class<?>[] clsArr;
        Local localNewLocal2;
        Local local;
        Local[] localArr;
        TypeId<T> typeId3;
        MethodId methodId;
        Method method;
        DexMaker dexMaker2 = dexMaker;
        TypeId<G> typeId4 = typeId;
        Method[] methodArr2 = methodArr;
        TypeId<V> typeId5 = TypeId.get(InvocationHandler.class);
        TypeId<V> typeId6 = TypeId.get(Method[].class);
        Object field = typeId4.getField(typeId5, FIELD_NAME_HANDLER);
        Object field2 = typeId4.getField(typeId6, FIELD_NAME_METHODS);
        TypeId typeId7 = TypeId.get(Method.class);
        TypeId typeId8 = TypeId.get(Object[].class);
        TypeId<Object> typeId9 = TypeId.OBJECT;
        MethodId method2 = typeId5.getMethod(typeId9, "invoke", typeId9, typeId7, typeId8);
        int i = 0;
        Object obj = typeId5;
        Object obj2 = typeId6;
        while (i < methodArr2.length) {
            Method method3 = methodArr2[i];
            String name = method3.getName();
            Class<?>[] parameterTypes = method3.getParameterTypes();
            int length = parameterTypes.length;
            TypeId<?>[] typeIdArr2 = new TypeId[length];
            for (int i3 = 0; i3 < length; i3++) {
                typeIdArr2[i3] = TypeId.get(parameterTypes[i3]);
            }
            Class<?> returnType = method3.getReturnType();
            int i4 = i;
            TypeId<R> typeId10 = TypeId.get(returnType);
            MethodId<G, R> method4 = typeId4.getMethod(typeId10, name, typeIdArr2);
            MethodId methodId2 = method2;
            TypeId<T> typeId11 = TypeId.get(AbstractMethodError.class);
            int i5 = length;
            Code codeDeclare = dexMaker2.declare(method4, 1);
            Local local2 = codeDeclare.getThis(typeId4);
            Local localNewLocal3 = codeDeclare.newLocal(obj);
            TypeId<Object> typeId12 = TypeId.OBJECT;
            Local localNewLocal4 = codeDeclare.newLocal(typeId12);
            TypeId<Integer> typeId13 = TypeId.INT;
            Object obj3 = field;
            Local localNewLocal5 = codeDeclare.newLocal(typeId13);
            Local localNewLocal6 = codeDeclare.newLocal(typeId8);
            TypeId typeId14 = typeId8;
            Local localNewLocal7 = codeDeclare.newLocal(typeId13);
            Local localNewLocal8 = codeDeclare.newLocal(typeId12);
            Local localNewLocal9 = codeDeclare.newLocal(typeId10);
            Local localNewLocal10 = codeDeclare.newLocal(obj2);
            Object obj4 = obj2;
            Local localNewLocal11 = codeDeclare.newLocal(typeId7);
            Local localNewLocal12 = codeDeclare.newLocal(typeId13);
            TypeId typeId15 = typeId7;
            Class<?> cls = PRIMITIVE_TO_BOXED.get(returnType);
            Local localNewLocal13 = cls != null ? codeDeclare.newLocal(TypeId.get(cls)) : null;
            Local localNewLocal14 = codeDeclare.newLocal(obj);
            Object obj5 = obj;
            if ((method3.getModifiers() & 1024) == 0) {
                Local[] localArr2 = new Local[parameterTypes.length];
                Local localNewLocal15 = codeDeclare.newLocal(typeId10);
                MethodId method5 = typeId2.getMethod(typeId10, name, typeIdArr2);
                typeIdArr = typeIdArr2;
                local = localNewLocal15;
                localNewLocal = null;
                typeId3 = typeId11;
                methodId = method5;
                localArr = localArr2;
                clsArr = parameterTypes;
                localNewLocal2 = null;
            } else {
                typeIdArr = typeIdArr2;
                localNewLocal = codeDeclare.newLocal(TypeId.STRING);
                clsArr = parameterTypes;
                localNewLocal2 = codeDeclare.newLocal(typeId11);
                local = null;
                localArr = null;
                typeId3 = typeId11;
                methodId = null;
            }
            codeDeclare.loadConstant(localNewLocal12, Integer.valueOf(i4));
            codeDeclare.sget(field2, localNewLocal10);
            codeDeclare.aget(localNewLocal11, localNewLocal10, localNewLocal12);
            codeDeclare.loadConstant(localNewLocal7, Integer.valueOf(i5));
            codeDeclare.newArray(localNewLocal6, localNewLocal7);
            Object obj6 = obj3;
            codeDeclare.iget(obj6, localNewLocal3, local2);
            codeDeclare.loadConstant(localNewLocal14, null);
            Label label = new Label();
            codeDeclare.compare(Comparison.EQ, label, localNewLocal14, localNewLocal3);
            int i6 = 0;
            while (true) {
                int i7 = i5;
                if (i6 >= i7) {
                    break;
                }
                i5 = i7;
                codeDeclare.loadConstant(localNewLocal5, Integer.valueOf(i6));
                codeDeclare.aput(localNewLocal6, localNewLocal5, boxIfRequired(codeDeclare, codeDeclare.getParameter(i6, typeIdArr[i6]), localNewLocal8));
                i6++;
                field2 = field2;
                obj6 = obj6;
            }
            Object obj7 = obj6;
            Object obj8 = field2;
            codeDeclare.invokeInterface(methodId2, localNewLocal4, localNewLocal3, local2, localNewLocal11, localNewLocal6);
            generateCodeForReturnStatement(codeDeclare, returnType, localNewLocal4, localNewLocal9, localNewLocal13);
            codeDeclare.mark(label);
            int modifiers = method3.getModifiers() & 1024;
            Class cls2 = Void.TYPE;
            if (modifiers == 0) {
                for (int i8 = 0; i8 < localArr.length; i8++) {
                    localArr[i8] = codeDeclare.getParameter(i8, typeIdArr[i8]);
                }
                if (cls2.equals(returnType)) {
                    codeDeclare.invokeSuper(methodId, null, local2, localArr);
                    codeDeclare.returnVoid();
                } else {
                    invokeSuper(methodId, codeDeclare, local2, localArr, local);
                    codeDeclare.returnValue(local);
                }
                method = method3;
            } else {
                method = method3;
                throwAbstractMethodError(codeDeclare, method, localNewLocal, localNewLocal2);
            }
            TypeId<?>[] typeIdArr3 = typeIdArr;
            Code codeDeclare2 = dexMaker.declare(typeId.getMethod(typeId10, superMethodName(method), typeIdArr3), 1);
            if ((method.getModifiers() & 1024) == 0) {
                Local<T> local3 = codeDeclare2.getThis(typeId);
                int length2 = clsArr.length;
                Local<?>[] localArr3 = new Local[length2];
                for (int i9 = 0; i9 < length2; i9++) {
                    localArr3[i9] = codeDeclare2.getParameter(i9, typeIdArr3[i9]);
                }
                if (cls2.equals(returnType)) {
                    codeDeclare2.invokeSuper(methodId, null, local3, localArr3);
                    codeDeclare2.returnVoid();
                } else {
                    Local<T> localNewLocal16 = codeDeclare2.newLocal(typeId10);
                    invokeSuper(methodId, codeDeclare2, local3, localArr3, localNewLocal16);
                    codeDeclare2.returnValue(localNewLocal16);
                }
            } else {
                throwAbstractMethodError(codeDeclare2, method, codeDeclare2.newLocal(TypeId.STRING), codeDeclare2.newLocal(typeId3));
            }
            i = i4 + 1;
            method2 = methodId2;
            typeId4 = typeId;
            dexMaker2 = dexMaker;
            field2 = obj8;
            field = obj7;
            typeId8 = typeId14;
            obj2 = obj4;
            typeId7 = typeId15;
            obj = obj5;
            methodArr2 = methodArr;
        }
    }

    private static void generateCodeForReturnStatement(Code code, Class cls, Local local, Local local2, Local local3) {
        if (PRIMITIVE_TO_UNBOX_METHOD.containsKey(cls)) {
            code.cast(local3, local);
            code.invokeVirtual(getUnboxMethodForPrimitive(cls), local2, local3, new Local[0]);
            code.returnValue(local2);
        } else if (Void.TYPE.equals(cls)) {
            code.returnVoid();
        } else {
            code.cast(local2, local);
            code.returnValue(local2);
        }
    }

    private static <T, G extends T> void generateConstructorsAndFields(DexMaker dexMaker, TypeId<G> typeId, TypeId<T> typeId2, Class<T> cls) {
        TypeId<V> typeId3 = TypeId.get(InvocationHandler.class);
        TypeId<V> typeId4 = TypeId.get(Method[].class);
        dexMaker.declare(typeId.getField(typeId3, FIELD_NAME_HANDLER), 2, null);
        dexMaker.declare(typeId.getField(typeId4, FIELD_NAME_METHODS), 10, null);
        for (Constructor constructor : getConstructorsToOverwrite(cls)) {
            if (constructor.getModifiers() != 16) {
                TypeId<?>[] typeIdArrClassArrayToTypeArray = classArrayToTypeArray(constructor.getParameterTypes());
                Code codeDeclare = dexMaker.declare(typeId.getConstructor(typeIdArrClassArrayToTypeArray), 1);
                Local<T> local = codeDeclare.getThis(typeId);
                int length = typeIdArrClassArrayToTypeArray.length;
                Local<?>[] localArr = new Local[length];
                for (int i = 0; i < length; i++) {
                    localArr[i] = codeDeclare.getParameter(i, typeIdArrClassArrayToTypeArray[i]);
                }
                codeDeclare.invokeDirect(typeId2.getConstructor(typeIdArrClassArrayToTypeArray), null, local, localArr);
                codeDeclare.returnVoid();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> Constructor<T>[] getConstructorsToOverwrite(Class<T> cls) {
        return (Constructor<T>[]) cls.getDeclaredConstructors();
    }

    private TypeId<?>[] getInterfacesAsTypeIds() {
        TypeId<?>[] typeIdArr = new TypeId[this.interfaces.size()];
        Iterator<Class<?>> it = this.interfaces.iterator();
        int i = 0;
        while (it.hasNext()) {
            typeIdArr[i] = TypeId.get(it.next());
            i++;
        }
        return typeIdArr;
    }

    public static InvocationHandler getInvocationHandler(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(FIELD_NAME_HANDLER);
            declaredField.setAccessible(true);
            return (InvocationHandler) declaredField.get(obj);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (NoSuchFieldException e6) {
            throw new IllegalArgumentException("Not a valid proxy instance", e6);
        }
    }

    private static <T> String getMethodNameForProxyOf(Class<T> cls, List<Class<?>> list) {
        String hexString = Integer.toHexString(list.hashCode());
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName().replace(".", "/"));
        sb.append(JavaConstant.Dynamic.DEFAULT_NAME);
        return b.h(sb, hexString, "_Proxy");
    }

    private void getMethodsToProxy(Set<MethodSetEntry> set, Set<MethodSetEntry> set2, Class<?> cls) {
        for (Method method : cls.getDeclaredMethods()) {
            if ((method.getModifiers() & 16) != 0) {
                MethodSetEntry methodSetEntry = new MethodSetEntry(method);
                set2.add(methodSetEntry);
                set.remove(methodSetEntry);
            } else if ((method.getModifiers() & 8) == 0 && ((Modifier.isPublic(method.getModifiers()) || Modifier.isProtected(method.getModifiers()) || (this.sharedClassLoader && !Modifier.isPrivate(method.getModifiers()))) && (!method.getName().equals("finalize") || method.getParameterTypes().length != 0))) {
                MethodSetEntry methodSetEntry2 = new MethodSetEntry(method);
                if (!set2.contains(methodSetEntry2)) {
                    set.add(methodSetEntry2);
                }
            }
        }
        if (cls.isInterface()) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                getMethodsToProxy(set, set2, cls2);
            }
        }
    }

    private Method[] getMethodsToProxyRecursive() {
        int i;
        HashSet hashSet = new HashSet();
        Set<MethodSetEntry> hashSet2 = new HashSet<>();
        for (Class<T> superclass = this.baseClass; superclass != null; superclass = superclass.getSuperclass()) {
            getMethodsToProxy(hashSet, hashSet2, superclass);
        }
        Class<T> superclass2 = this.baseClass;
        while (true) {
            i = 0;
            if (superclass2 == null) {
                break;
            }
            Class<?>[] interfaces = superclass2.getInterfaces();
            int length = interfaces.length;
            while (i < length) {
                getMethodsToProxy(hashSet, hashSet2, interfaces[i]);
                i++;
            }
            superclass2 = superclass2.getSuperclass();
        }
        Iterator<Class<?>> it = this.interfaces.iterator();
        while (it.hasNext()) {
            getMethodsToProxy(hashSet, hashSet2, it.next());
        }
        Method[] methodArr = new Method[hashSet.size()];
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            methodArr[i] = ((MethodSetEntry) it2.next()).originalMethod;
            i++;
        }
        return methodArr;
    }

    private static MethodId<?, ?> getUnboxMethodForPrimitive(Class<?> cls) {
        return PRIMITIVE_TO_UNBOX_METHOD.get(cls);
    }

    private static void invokeSuper(MethodId methodId, Code code, Local local, Local[] localArr, Local local2) {
        code.invokeSuper(methodId, local2, local, localArr);
    }

    public static boolean isProxyClass(Class<?> cls) {
        try {
            cls.getDeclaredField(FIELD_NAME_HANDLER);
            return true;
        } catch (NoSuchFieldException unused) {
            return false;
        }
    }

    private static RuntimeException launderCause(InvocationTargetException invocationTargetException) {
        Throwable cause = invocationTargetException.getCause();
        if (cause instanceof Error) {
            throw ((Error) cause);
        }
        if (cause instanceof RuntimeException) {
            throw ((RuntimeException) cause);
        }
        throw new UndeclaredThrowableException(cause);
    }

    private Class<? extends T> loadClass(ClassLoader classLoader, String str) {
        return (Class<? extends T>) classLoader.loadClass(str);
    }

    public static void setInvocationHandler(Object obj, InvocationHandler invocationHandler) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(FIELD_NAME_HANDLER);
            declaredField.setAccessible(true);
            declaredField.set(obj, invocationHandler);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (NoSuchFieldException e6) {
            throw new IllegalArgumentException("Not a valid proxy instance", e6);
        }
    }

    private static void setMethodsStaticField(Class<?> cls, Method[] methodArr) {
        try {
            Field declaredField = cls.getDeclaredField(FIELD_NAME_METHODS);
            declaredField.setAccessible(true);
            declaredField.set(null, methodArr);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (NoSuchFieldException e6) {
            throw new AssertionError(e6);
        }
    }

    private static String superMethodName(Method method) {
        return "super$" + method.getName() + "$" + method.getReturnType().getName().replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '_').replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH, '_').replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER, '_');
    }

    private static void throwAbstractMethodError(Code code, Method method, Local<String> local, Local<AbstractMethodError> local2) {
        MethodId<T, Void> constructor = TypeId.get(AbstractMethodError.class).getConstructor(TypeId.STRING);
        code.loadConstant(local, "'" + method + "' cannot be called");
        code.newInstance(local2, constructor, local);
        code.throwValue(local2);
    }

    public T build() {
        check(this.handler != null, "handler == null");
        check(this.constructorArgTypes.length == this.constructorArgValues.length, "constructorArgValues.length != constructorArgTypes.length");
        try {
            try {
                T tNewInstance = buildProxyClass().getConstructor(this.constructorArgTypes).newInstance(this.constructorArgValues);
                setInvocationHandler(tNewInstance, this.handler);
                return tNewInstance;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InstantiationException e6) {
                throw new AssertionError(e6);
            } catch (InvocationTargetException e7) {
                throw launderCause(e7);
            }
        } catch (NoSuchMethodException unused) {
            StringBuilder sb = new StringBuilder("No constructor for ");
            a.u(this.baseClass, sb, " with parameter types ");
            sb.append(Arrays.toString(this.constructorArgTypes));
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public Class<? extends T> buildProxyClass() {
        ClassLoader classLoader = this.sharedClassLoader ? this.baseClass.getClassLoader() : this.parentClassLoader;
        ProxiedClass<?> proxiedClass = new ProxiedClass<>(this.baseClass, this.interfaces, classLoader, this.sharedClassLoader);
        Map<ProxiedClass<?>, Class<?>> map = generatedProxyClasses;
        Class<? extends T> cls = (Class) map.get(proxiedClass);
        if (cls != null) {
            return cls;
        }
        DexMaker dexMaker = new DexMaker();
        String methodNameForProxyOf = getMethodNameForProxyOf(this.baseClass, this.interfaces);
        TypeId<?> typeId = TypeId.get("L" + methodNameForProxyOf + ";");
        TypeId<?> typeId2 = TypeId.get(this.baseClass);
        generateConstructorsAndFields(dexMaker, typeId, typeId2, this.baseClass);
        Method[] methodsToProxyRecursive = this.methods;
        if (methodsToProxyRecursive == null) {
            methodsToProxyRecursive = getMethodsToProxyRecursive();
        }
        Arrays.sort(methodsToProxyRecursive, new Comparator<Method>() { // from class: com.android.dx.stock.ProxyBuilder.1
            @Override // java.util.Comparator
            public int compare(Method method, Method method2) {
                return (method.getDeclaringClass() + method.getName() + Arrays.toString(method.getParameterTypes()) + method.getReturnType()).compareTo(method2.getDeclaringClass() + method2.getName() + Arrays.toString(method2.getParameterTypes()) + method2.getReturnType());
            }
        });
        generateCodeForAllMethods(dexMaker, typeId, methodsToProxyRecursive, typeId2);
        dexMaker.declare(typeId, b.e(methodNameForProxyOf, ".generated"), 1, typeId2, getInterfacesAsTypeIds());
        if (this.sharedClassLoader) {
            dexMaker.setSharedClassLoader(classLoader);
        }
        if (this.markTrusted) {
            dexMaker.markAsTrusted();
        }
        try {
            Class<? extends T> clsLoadClass = loadClass(this.sharedClassLoader ? dexMaker.generateAndLoad(null, this.dexCache) : dexMaker.generateAndLoad(this.parentClassLoader, this.dexCache), methodNameForProxyOf);
            setMethodsStaticField(clsLoadClass, methodsToProxyRecursive);
            map.put(proxiedClass, clsLoadClass);
            return clsLoadClass;
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);
        } catch (IllegalAccessError e6) {
            throw new UnsupportedOperationException("cannot proxy inaccessible class " + this.baseClass, e6);
        }
    }

    public ProxyBuilder<T> constructorArgTypes(Class<?>... clsArr) {
        this.constructorArgTypes = clsArr;
        return this;
    }

    public ProxyBuilder<T> constructorArgValues(Object... objArr) {
        this.constructorArgValues = objArr;
        return this;
    }

    public ProxyBuilder<T> dexCache(File file) {
        File file2 = new File(file, RegisterSpec.PREFIX + Integer.toString(1));
        this.dexCache = file2;
        file2.mkdir();
        return this;
    }

    public ProxyBuilder<T> handler(InvocationHandler invocationHandler) {
        this.handler = invocationHandler;
        return this;
    }

    public ProxyBuilder<T> implementing(Class<?>... clsArr) {
        List<Class<?>> list = this.interfaces;
        for (Class<?> cls : clsArr) {
            if (!cls.isInterface()) {
                throw new IllegalArgumentException("Not an interface: ".concat(cls.getName()));
            }
            if (!list.contains(cls)) {
                list.add(cls);
            }
        }
        return this;
    }

    public ProxyBuilder<T> markTrusted() {
        this.markTrusted = true;
        return this;
    }

    public ProxyBuilder<T> onlyMethods(Method[] methodArr) {
        this.methods = methodArr;
        return this;
    }

    public ProxyBuilder<T> parentClassLoader(ClassLoader classLoader) {
        this.parentClassLoader = classLoader;
        return this;
    }

    public ProxyBuilder<T> withSharedClassLoader() {
        this.sharedClassLoader = true;
        return this;
    }
}
