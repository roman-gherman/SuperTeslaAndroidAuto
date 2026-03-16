package net.bytebuddy.utility.dispatcher;

import androidx.constraintlayout.core.motion.a;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.Map;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.utility.GraalImageCode;
import net.bytebuddy.utility.Invoker;
import net.bytebuddy.utility.MethodComparator;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public class JavaDispatcher<T> implements PrivilegedAction<T> {
    private static final boolean ACCESS_CONTROLLER;
    private static final boolean GENERATE;
    public static final String GENERATE_PROPERTY = "net.bytebuddy.generate";
    private static final Invoker INVOKER;
    private static final DynamicClassLoader.Resolver RESOLVER;

    @MaybeNull
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
    private final ClassLoader classLoader;
    private final boolean generate;
    private final Class<T> proxy;

    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Container {
    }

    @Target({ElementType.TYPE, ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Defaults {
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class DirectInvoker implements Invoker {
        private DirectInvoker() {
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass();
        }

        public int hashCode() {
            return getClass().hashCode();
        }

        @Override // net.bytebuddy.utility.Invoker
        public Object invoke(Method method, @MaybeNull Object obj, @MaybeNull Object[] objArr) {
            return method.invoke(obj, objArr);
        }

        @Override // net.bytebuddy.utility.Invoker
        public Object newInstance(Constructor<?> constructor, Object[] objArr) {
            return constructor.newInstance(objArr);
        }
    }

    public interface Dispatcher {

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForConstructor implements Dispatcher {
            private final Constructor<?> constructor;

            public ForConstructor(Constructor<?> constructor) {
                this.constructor = constructor;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Class<?>[] parameterTypes2 = this.constructor.getParameterTypes();
                methodVisitor.visitTypeInsn(187, Type.getInternalName(this.constructor.getDeclaringClass()));
                methodVisitor.visitInsn(89);
                int size = 1;
                for (int i = 0; i < parameterTypes.length; i++) {
                    Type type = Type.getType(parameterTypes[i]);
                    methodVisitor.visitVarInsn(type.getOpcode(21), size);
                    Class<?> cls = parameterTypes[i];
                    Class<?> cls2 = parameterTypes2[i];
                    if (cls != cls2) {
                        methodVisitor.visitTypeInsn(192, Type.getInternalName(cls2));
                    }
                    size += type.getSize();
                }
                methodVisitor.visitMethodInsn(183, Type.getInternalName(this.constructor.getDeclaringClass()), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getConstructorDescriptor(this.constructor), false);
                methodVisitor.visitInsn(176);
                return size + 1;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.constructor.equals(((ForConstructor) obj).constructor);
            }

            public int hashCode() {
                return this.constructor.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public Object invoke(Object[] objArr) {
                return JavaDispatcher.INVOKER.newInstance(this.constructor, objArr);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForContainerCreation implements Dispatcher {
            private final Class<?> target;

            public ForContainerCreation(Class<?> cls) {
                this.target = cls;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                methodVisitor.visitVarInsn(21, 1);
                methodVisitor.visitTypeInsn(189, Type.getInternalName(this.target));
                methodVisitor.visitInsn(176);
                return 1;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.target.equals(((ForContainerCreation) obj).target);
            }

            public int hashCode() {
                return this.target.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public Object invoke(Object[] objArr) {
                return Array.newInstance(this.target, ((Integer) objArr[0]).intValue());
            }
        }

        public enum ForDefaultValue implements Dispatcher {
            VOID(null, 0, 177, 0),
            BOOLEAN(Boolean.FALSE, 3, 172, 1),
            BOOLEAN_REVERSE(Boolean.TRUE, 4, 172, 1),
            BYTE((byte) 0, 3, 172, 1),
            SHORT((short) 0, 3, 172, 1),
            CHARACTER((char) 0, 3, 172, 1),
            INTEGER(0, 3, 172, 1),
            LONG(0L, 9, 173, 2),
            FLOAT(Float.valueOf(0.0f), 11, 174, 1),
            DOUBLE(Double.valueOf(0.0d), 14, 175, 2),
            REFERENCE(null, 1, 176, 1);

            private final int load;
            private final int returned;
            private final int size;

            @MaybeNull
            private final Object value;

            @HashCodeAndEqualsPlugin.Enhance
            public static class OfNonPrimitiveArray implements Dispatcher {
                private final Class<?> componentType;

                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
                private final Object value;

                public OfNonPrimitiveArray(Object obj, Class<?> cls) {
                    this.value = obj;
                    this.componentType = cls;
                }

                public static Dispatcher of(Class<?> cls) {
                    return new OfNonPrimitiveArray(Array.newInstance(cls, 0), cls);
                }

                @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
                public int apply(MethodVisitor methodVisitor, Method method) {
                    methodVisitor.visitInsn(3);
                    methodVisitor.visitTypeInsn(189, Type.getInternalName(this.componentType));
                    methodVisitor.visitInsn(176);
                    return 1;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.componentType.equals(((OfNonPrimitiveArray) obj).componentType);
                }

                public int hashCode() {
                    return this.componentType.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
                public Object invoke(Object[] objArr) {
                    return this.value;
                }
            }

            public enum OfPrimitiveArray implements Dispatcher {
                BOOLEAN(new boolean[0], 4),
                BYTE(new byte[0], 8),
                SHORT(new short[0], 9),
                CHARACTER(new char[0], 5),
                INTEGER(new int[0], 10),
                LONG(new long[0], 11),
                FLOAT(new float[0], 6),
                DOUBLE(new double[0], 7);

                private final int operand;
                private final Object value;

                OfPrimitiveArray(Object obj, int i) {
                    this.value = obj;
                    this.operand = i;
                }

                @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
                public int apply(MethodVisitor methodVisitor, Method method) {
                    methodVisitor.visitInsn(3);
                    methodVisitor.visitIntInsn(188, this.operand);
                    methodVisitor.visitInsn(176);
                    return 1;
                }

                @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
                public Object invoke(Object[] objArr) {
                    return this.value;
                }
            }

            ForDefaultValue(@MaybeNull Object obj, int i, int i3, int i4) {
                this.value = obj;
                this.load = i;
                this.returned = i3;
                this.size = i4;
            }

            public static Dispatcher of(Class<?> cls) {
                if (cls == Void.TYPE) {
                    return VOID;
                }
                Class<?> cls2 = Boolean.TYPE;
                if (cls == cls2) {
                    return BOOLEAN;
                }
                Class<?> cls3 = Byte.TYPE;
                if (cls == cls3) {
                    return BYTE;
                }
                Class<?> cls4 = Short.TYPE;
                if (cls == cls4) {
                    return SHORT;
                }
                Class<?> cls5 = Character.TYPE;
                if (cls == cls5) {
                    return CHARACTER;
                }
                Class<?> cls6 = Integer.TYPE;
                if (cls == cls6) {
                    return INTEGER;
                }
                Class<?> cls7 = Long.TYPE;
                if (cls == cls7) {
                    return LONG;
                }
                Class<?> cls8 = Float.TYPE;
                if (cls == cls8) {
                    return FLOAT;
                }
                Class<?> cls9 = Double.TYPE;
                return cls == cls9 ? DOUBLE : cls.isArray() ? cls.getComponentType() == cls2 ? OfPrimitiveArray.BOOLEAN : cls.getComponentType() == cls3 ? OfPrimitiveArray.BYTE : cls.getComponentType() == cls4 ? OfPrimitiveArray.SHORT : cls.getComponentType() == cls5 ? OfPrimitiveArray.CHARACTER : cls.getComponentType() == cls6 ? OfPrimitiveArray.INTEGER : cls.getComponentType() == cls7 ? OfPrimitiveArray.LONG : cls.getComponentType() == cls8 ? OfPrimitiveArray.FLOAT : cls.getComponentType() == cls9 ? OfPrimitiveArray.DOUBLE : OfNonPrimitiveArray.of(cls.getComponentType()) : REFERENCE;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                int i = this.load;
                if (i != 0) {
                    methodVisitor.visitInsn(i);
                }
                methodVisitor.visitInsn(this.returned);
                return this.size;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            @MaybeNull
            public Object invoke(Object[] objArr) {
                return this.value;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForInstanceCheck implements Dispatcher {
            private final Class<?> target;

            public ForInstanceCheck(Class<?> cls) {
                this.target = cls;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitTypeInsn(193, Type.getInternalName(this.target));
                methodVisitor.visitInsn(172);
                return 1;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.target.equals(((ForInstanceCheck) obj).target);
            }

            public int hashCode() {
                return this.target.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public Object invoke(Object[] objArr) {
                return Boolean.valueOf(this.target.isInstance(objArr[0]));
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForNonStaticMethod implements Dispatcher {
            private static final Object[] NO_ARGUMENTS = new Object[0];
            private final Method method;

            public ForNonStaticMethod(Method method) {
                this.method = method;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Class<?>[] parameterTypes2 = this.method.getParameterTypes();
                int i = 0;
                int size = 1;
                while (i < parameterTypes.length) {
                    Type type = Type.getType(parameterTypes[i]);
                    methodVisitor.visitVarInsn(type.getOpcode(21), size);
                    if (parameterTypes[i] != (i == 0 ? this.method.getDeclaringClass() : parameterTypes2[i - 1])) {
                        methodVisitor.visitTypeInsn(192, Type.getInternalName(i == 0 ? this.method.getDeclaringClass() : parameterTypes2[i - 1]));
                    }
                    size += type.getSize();
                    i++;
                }
                methodVisitor.visitMethodInsn(this.method.getDeclaringClass().isInterface() ? 185 : 182, Type.getInternalName(this.method.getDeclaringClass()), this.method.getName(), Type.getMethodDescriptor(this.method), this.method.getDeclaringClass().isInterface());
                methodVisitor.visitInsn(Type.getReturnType(this.method).getOpcode(172));
                return Math.max(size - 1, Type.getReturnType(this.method).getSize());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.method.equals(((ForNonStaticMethod) obj).method);
            }

            public int hashCode() {
                return this.method.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public Object invoke(Object[] objArr) {
                Object[] objArr2;
                if (objArr.length == 1) {
                    objArr2 = NO_ARGUMENTS;
                } else {
                    int length = objArr.length - 1;
                    Object[] objArr3 = new Object[length];
                    System.arraycopy(objArr, 1, objArr3, 0, length);
                    objArr2 = objArr3;
                }
                return JavaDispatcher.INVOKER.invoke(this.method, objArr[0], objArr2);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForStaticMethod implements Dispatcher {
            private final Method method;

            public ForStaticMethod(Method method) {
                this.method = method;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Class<?>[] parameterTypes2 = this.method.getParameterTypes();
                int size = 1;
                for (int i = 0; i < parameterTypes.length; i++) {
                    Type type = Type.getType(parameterTypes[i]);
                    methodVisitor.visitVarInsn(type.getOpcode(21), size);
                    Class<?> cls = parameterTypes[i];
                    Class<?> cls2 = parameterTypes2[i];
                    if (cls != cls2) {
                        methodVisitor.visitTypeInsn(192, Type.getInternalName(cls2));
                    }
                    size += type.getSize();
                }
                methodVisitor.visitMethodInsn(184, Type.getInternalName(this.method.getDeclaringClass()), this.method.getName(), Type.getMethodDescriptor(this.method), this.method.getDeclaringClass().isInterface());
                methodVisitor.visitInsn(Type.getReturnType(this.method).getOpcode(172));
                return Math.max(size - 1, Type.getReturnType(this.method).getSize());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.method.equals(((ForStaticMethod) obj).method);
            }

            public int hashCode() {
                return this.method.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            @MaybeNull
            public Object invoke(Object[] objArr) {
                return JavaDispatcher.INVOKER.invoke(this.method, null, objArr);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForUnresolvedMethod implements Dispatcher {
            private final String message;

            public ForUnresolvedMethod(String str) {
                this.message = str;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                methodVisitor.visitTypeInsn(187, Type.getInternalName(IllegalStateException.class));
                methodVisitor.visitInsn(89);
                methodVisitor.visitLdcInsn(this.message);
                methodVisitor.visitMethodInsn(183, Type.getInternalName(IllegalStateException.class), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType((Class<?>) String.class)), false);
                methodVisitor.visitInsn(191);
                return 3;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.message.equals(((ForUnresolvedMethod) obj).message);
            }

            public int hashCode() {
                return this.message.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public Object invoke(Object[] objArr) {
                throw new IllegalStateException("Could not invoke proxy: " + this.message);
            }
        }

        int apply(MethodVisitor methodVisitor, Method method);

        @MaybeNull
        Object invoke(Object[] objArr);
    }

    public static class DynamicClassLoader extends ClassLoader {

        @MaybeNull
        private static final String DUMP_FOLDER;
        private static final Class<?>[] NO_PARAMETER = new Class[0];
        private static final Object[] NO_ARGUMENT = new Object[0];

        public interface Resolver {

            public enum CreationAction implements PrivilegedAction<Resolver> {
                INSTANCE;

                @Override // java.security.PrivilegedAction
                @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback.", value = {"REC_CATCH_EXCEPTION"})
                public Resolver run() {
                    try {
                        Class<?> cls = Class.forName("java.lang.Module", false, null);
                        return new ForModuleSystem(Class.class.getMethod("getModule", new Class[0]), cls.getMethod("isExported", String.class), cls.getMethod("addExports", String.class, cls), ClassLoader.class.getMethod("getUnnamedModule", new Class[0]));
                    } catch (Exception unused) {
                        return NoOp.INSTANCE;
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForModuleSystem implements Resolver {
                private final Method addExports;
                private final Method getModule;
                private final Method getUnnamedModule;
                private final Method isExported;

                public ForModuleSystem(Method method, Method method2, Method method3, Method method4) {
                    this.getModule = method;
                    this.isExported = method2;
                    this.addExports = method3;
                    this.getUnnamedModule = method4;
                }

                @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.DynamicClassLoader.Resolver
                @SuppressFBWarnings(justification = "Exception should always be wrapped for clarity.", value = {"REC_CATCH_EXCEPTION"})
                public void accept(@MaybeNull ClassLoader classLoader, Class<?> cls) {
                    Package r02 = cls.getPackage();
                    if (r02 != null) {
                        try {
                            Object objInvoke = this.getModule.invoke(cls, new Object[0]);
                            if (((Boolean) this.isExported.invoke(objInvoke, r02.getName())).booleanValue()) {
                                return;
                            }
                            this.addExports.invoke(objInvoke, r02.getName(), this.getUnnamedModule.invoke(classLoader, new Object[0]));
                        } catch (Exception e) {
                            throw new IllegalStateException("Failed to adjust module graph for dispatcher", e);
                        }
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForModuleSystem forModuleSystem = (ForModuleSystem) obj;
                    return this.getModule.equals(forModuleSystem.getModule) && this.isExported.equals(forModuleSystem.isExported) && this.addExports.equals(forModuleSystem.addExports) && this.getUnnamedModule.equals(forModuleSystem.getUnnamedModule);
                }

                public int hashCode() {
                    return this.getUnnamedModule.hashCode() + ((this.addExports.hashCode() + ((this.isExported.hashCode() + ((this.getModule.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31)) * 31);
                }
            }

            public enum NoOp implements Resolver {
                INSTANCE;

                @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.DynamicClassLoader.Resolver
                public void accept(@MaybeNull ClassLoader classLoader, Class<?> cls) {
                }
            }

            void accept(@MaybeNull ClassLoader classLoader, Class<?> cls);
        }

        static {
            String str;
            try {
                str = (String) JavaDispatcher.doPrivileged(new GetSystemPropertyAction(TypeWriter.DUMP_PROPERTY));
            } catch (Throwable unused) {
                str = null;
            }
            DUMP_FOLDER = str;
        }

        public DynamicClassLoader(Class<?> cls) {
            super(cls.getClassLoader());
            JavaDispatcher.RESOLVER.accept(this, cls);
        }

        @SuppressFBWarnings(justification = "Expected internal invocation.", value = {"REC_CATCH_EXCEPTION", "DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"})
        public static Invoker invoker() {
            ClassWriter classWriter = new ClassWriter(0);
            classWriter.visit(ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).getMinorMajorVersion(), 1, Type.getInternalName(Invoker.class) + "$Dispatcher", null, Type.getInternalName(Object.class), new String[]{Type.getInternalName(Invoker.class)});
            Method[] methodArr = (Method[]) GraalImageCode.getCurrent().sorted(Invoker.class.getMethods(), MethodComparator.INSTANCE);
            int length = methodArr.length;
            int i = 0;
            while (true) {
                int size = 1;
                if (i >= length) {
                    break;
                }
                Method method = methodArr[i];
                Class<?>[] exceptionTypes = method.getExceptionTypes();
                String[] strArr = new String[exceptionTypes.length];
                for (int i3 = 0; i3 < exceptionTypes.length; i3++) {
                    strArr[i3] = Type.getInternalName(exceptionTypes[i3]);
                }
                MethodVisitor methodVisitorVisitMethod = classWriter.visitMethod(1, method.getName(), Type.getMethodDescriptor(method), null, strArr);
                methodVisitorVisitMethod.visitCode();
                Type[] typeArr = new Type[method.getParameterTypes().length - 1];
                for (int i4 = 0; i4 < method.getParameterTypes().length; i4++) {
                    Type type = Type.getType(method.getParameterTypes()[i4]);
                    if (i4 > 0) {
                        typeArr[i4 - 1] = type;
                    }
                    methodVisitorVisitMethod.visitVarInsn(type.getOpcode(21), size);
                    size += type.getSize();
                }
                methodVisitorVisitMethod.visitMethodInsn(182, Type.getInternalName(method.getParameterTypes()[0]), method.getName(), Type.getMethodDescriptor(Type.getReturnType(method), typeArr), false);
                methodVisitorVisitMethod.visitInsn(Type.getReturnType(method).getOpcode(172));
                methodVisitorVisitMethod.visitMaxs(Math.max(size - 1, Type.getReturnType(method).getSize()), size);
                methodVisitorVisitMethod.visitEnd();
                i++;
            }
            Type type2 = Type.VOID_TYPE;
            MethodVisitor methodVisitorVisitMethod2 = classWriter.visitMethod(1, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(type2, new Type[0]), null, null);
            methodVisitorVisitMethod2.visitCode();
            methodVisitorVisitMethod2.visitVarInsn(25, 0);
            methodVisitorVisitMethod2.visitMethodInsn(183, Type.getInternalName(Object.class), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(type2, new Type[0]), false);
            methodVisitorVisitMethod2.visitInsn(177);
            methodVisitorVisitMethod2.visitMaxs(1, 1);
            methodVisitorVisitMethod2.visitEnd();
            classWriter.visitEnd();
            byte[] byteArray = classWriter.toByteArray();
            try {
                String property = System.getProperty(TypeWriter.DUMP_PROPERTY);
                if (property != null) {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(property, Invoker.class.getName() + "$Dispatcher.class"));
                    try {
                        fileOutputStream.write(byteArray);
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        fileOutputStream.close();
                        throw th;
                    }
                }
            } catch (Throwable unused) {
            }
            try {
                return (Invoker) new DynamicClassLoader(Invoker.class).defineClass(Invoker.class.getName() + "$Dispatcher", byteArray, 0, byteArray.length, JavaDispatcher.class.getProtectionDomain()).getConstructor(NO_PARAMETER).newInstance(NO_ARGUMENT);
            } catch (UnsupportedOperationException unused2) {
                return new DirectInvoker();
            } catch (Exception e) {
                throw new IllegalStateException("Failed to create invoker for ".concat(Invoker.class.getName()), e);
            }
        }

        @SuppressFBWarnings(justification = "Expected internal invocation.", value = {"REC_CATCH_EXCEPTION", "DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"})
        public static Object proxy(Class<?> cls, Map<Method, Dispatcher> map) {
            Class<?> cls2;
            ClassWriter classWriter = new ClassWriter(0);
            classWriter.visit(ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).getMinorMajorVersion(), 1, Type.getInternalName(cls) + "$Proxy", null, Type.getInternalName(Object.class), new String[]{Type.getInternalName(cls)});
            Iterator<Map.Entry<Method, Dispatcher>> it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Method, Dispatcher> next = it.next();
                Class<?>[] exceptionTypes = next.getKey().getExceptionTypes();
                String[] strArr = new String[exceptionTypes.length];
                for (int i = 0; i < exceptionTypes.length; i++) {
                    strArr[i] = Type.getInternalName(exceptionTypes[i]);
                }
                MethodVisitor methodVisitorVisitMethod = classWriter.visitMethod(1, next.getKey().getName(), Type.getMethodDescriptor(next.getKey()), null, strArr);
                methodVisitorVisitMethod.visitCode();
                int size = (next.getKey().getModifiers() & 8) != 0 ? 0 : 1;
                for (Class<?> cls3 : next.getKey().getParameterTypes()) {
                    size += Type.getType(cls3).getSize();
                }
                methodVisitorVisitMethod.visitMaxs(next.getValue().apply(methodVisitorVisitMethod, next.getKey()), size);
                methodVisitorVisitMethod.visitEnd();
            }
            Type type = Type.VOID_TYPE;
            MethodVisitor methodVisitorVisitMethod2 = classWriter.visitMethod(1, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(type, new Type[0]), null, null);
            methodVisitorVisitMethod2.visitCode();
            methodVisitorVisitMethod2.visitVarInsn(25, 0);
            methodVisitorVisitMethod2.visitMethodInsn(183, Type.getInternalName(Object.class), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(type, new Type[0]), false);
            methodVisitorVisitMethod2.visitInsn(177);
            methodVisitorVisitMethod2.visitMaxs(1, 1);
            methodVisitorVisitMethod2.visitEnd();
            classWriter.visitEnd();
            byte[] byteArray = classWriter.toByteArray();
            String str = DUMP_FOLDER;
            if (str != null) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(str, cls.getName() + "$Proxy.class"));
                    try {
                        fileOutputStream.write(byteArray);
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        fileOutputStream.close();
                        throw th;
                    }
                } catch (Throwable unused) {
                }
            }
            try {
                cls2 = cls;
            } catch (Exception e) {
                e = e;
                cls2 = cls;
            }
            try {
                return new DynamicClassLoader(cls2).defineClass(cls2.getName() + "$Proxy", byteArray, 0, byteArray.length, JavaDispatcher.class.getProtectionDomain()).getConstructor(NO_PARAMETER).newInstance(NO_ARGUMENT);
            } catch (Exception e6) {
                e = e6;
                throw new IllegalStateException("Failed to create proxy for ".concat(cls2.getName()), e);
            }
        }
    }

    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Instance {
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class InvokerCreationAction implements PrivilegedAction<Invoker> {
        private InvokerCreationAction() {
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass();
        }

        public int hashCode() {
            return getClass().hashCode();
        }

        @Override // java.security.PrivilegedAction
        public Invoker run() {
            return DynamicClassLoader.invoker();
        }
    }

    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IsConstructor {
    }

    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IsStatic {
    }

    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Proxied {
        String value();
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ProxiedInvocationHandler implements InvocationHandler {
        private static final Object[] NO_ARGUMENTS = new Object[0];
        private final String name;
        private final Map<Method, Dispatcher> targets;

        public ProxiedInvocationHandler(String str, Map<Method, Dispatcher> map) {
            this.name = str;
            this.targets = map;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ProxiedInvocationHandler proxiedInvocationHandler = (ProxiedInvocationHandler) obj;
            return this.name.equals(proxiedInvocationHandler.name) && this.targets.equals(proxiedInvocationHandler.targets);
        }

        public int hashCode() {
            return this.targets.hashCode() + a.c(getClass().hashCode() * 31, 31, this.name);
        }

        @Override // java.lang.reflect.InvocationHandler
        @MaybeNull
        public Object invoke(Object obj, Method method, @MaybeNull Object[] objArr) {
            z = false;
            z = false;
            boolean z6 = false;
            if (method.getDeclaringClass() == Object.class) {
                if (method.getName().equals("hashCode")) {
                    return Integer.valueOf(hashCode());
                }
                if (method.getName().equals("equals")) {
                    Object obj2 = objArr[0];
                    if (obj2 != null && Proxy.isProxyClass(obj2.getClass()) && Proxy.getInvocationHandler(objArr[0]).equals(this)) {
                        z6 = true;
                    }
                    return Boolean.valueOf(z6);
                }
                if (method.getName().equals("toString")) {
                    return "Call proxy for " + this.name;
                }
                throw new IllegalStateException("Unexpected object method: " + method);
            }
            Dispatcher dispatcher = this.targets.get(method);
            try {
                try {
                    if (dispatcher != null) {
                        if (objArr == null) {
                            objArr = NO_ARGUMENTS;
                        }
                        return dispatcher.invoke(objArr);
                    }
                    throw new IllegalStateException("No proxy target found for " + method);
                } catch (InvocationTargetException e) {
                    throw e.getTargetException();
                }
            } catch (Error e6) {
                throw e6;
            } catch (RuntimeException e7) {
                throw e7;
            } catch (Throwable th) {
                for (Class<?> cls : method.getExceptionTypes()) {
                    if (cls.isInstance(th)) {
                        throw th;
                    }
                }
                throw new IllegalStateException("Failed to invoke proxy for " + method, th);
            }
        }
    }

    static {
        boolean z6 = false;
        try {
            Class.forName("java.security.AccessController", false, null);
            ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
        } catch (ClassNotFoundException unused) {
            ACCESS_CONTROLLER = z6;
        } catch (SecurityException unused2) {
            z6 = true;
            ACCESS_CONTROLLER = z6;
        }
        GENERATE = Boolean.parseBoolean((String) doPrivileged(new GetSystemPropertyAction(GENERATE_PROPERTY)));
        RESOLVER = (DynamicClassLoader.Resolver) doPrivileged(DynamicClassLoader.Resolver.CreationAction.INSTANCE);
        INVOKER = (Invoker) doPrivileged(new InvokerCreationAction());
    }

    public JavaDispatcher(Class<T> cls, @MaybeNull ClassLoader classLoader, boolean z6) {
        this.proxy = cls;
        this.classLoader = classLoader;
        this.generate = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AccessControllerPlugin.Enhance
    public static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static <T> PrivilegedAction<T> of(Class<T> cls) {
        return of(cls, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0039 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L4
            return r0
        L4:
            r1 = 0
            if (r5 != 0) goto L8
            return r1
        L8:
            java.lang.Class r2 = r4.getClass()
            java.lang.Class r3 = r5.getClass()
            if (r2 == r3) goto L13
            return r1
        L13:
            boolean r2 = r4.generate
            net.bytebuddy.utility.dispatcher.JavaDispatcher r5 = (net.bytebuddy.utility.dispatcher.JavaDispatcher) r5
            boolean r3 = r5.generate
            if (r2 == r3) goto L1c
            return r1
        L1c:
            java.lang.Class<T> r2 = r4.proxy
            java.lang.Class<T> r3 = r5.proxy
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L27
            return r1
        L27:
            java.lang.ClassLoader r2 = r4.classLoader
            java.lang.ClassLoader r5 = r5.classLoader
            if (r5 == 0) goto L36
            if (r2 == 0) goto L38
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L39
            return r1
        L36:
            if (r2 == 0) goto L39
        L38:
            return r1
        L39:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.dispatcher.JavaDispatcher.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int iE = com.google.protobuf.a.e(getClass().hashCode() * 31, 31, this.proxy);
        ClassLoader classLoader = this.classLoader;
        if (classLoader != null) {
            iE += classLoader.hashCode();
        }
        return (iE * 31) + (this.generate ? 1 : 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:136:0x02c8, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02cf, code lost:
    
        if (r0[r12].isArray() == false) goto L370;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02d1, code lost:
    
        r4 = r4 + 1;
        r0[r12] = r0[r12].getComponentType();
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02e4, code lost:
    
        if (r4 <= 0) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02ec, code lost:
    
        if (r0[r12].isPrimitive() != false) goto L359;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02ee, code lost:
    
        r27 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02f6, code lost:
    
        r30 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02fc, code lost:
    
        r31 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0300, code lost:
    
        r32 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x030b, code lost:
    
        if (r0[r12].isAssignableFrom(java.lang.Class.forName(((net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r3).value(), false, r33.classLoader)) == false) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x030d, code lost:
    
        r3 = new java.lang.StringBuilder();
        r4 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0314, code lost:
    
        r5 = r4 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0316, code lost:
    
        if (r4 <= 0) goto L371;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0318, code lost:
    
        r3.append(net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x031f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0322, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0325, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0328, code lost:
    
        r3.append('L');
        r3.append(((net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r3).value());
        r3.append(net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
        r0[r12] = java.lang.Class.forName(r3.toString(), false, r33.classLoader);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0378, code lost:
    
        throw new java.lang.IllegalStateException("Cannot resolve to component type: " + ((net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r3).value() + " at " + r12 + " of " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0379, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x037c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x037f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0382, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0385, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0388, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x03ad, code lost:
    
        throw new java.lang.IllegalStateException("Primitive values are not supposed to be proxied: " + r12 + " of " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x03ae, code lost:
    
        r30 = r5;
        r31 = r6;
        r32 = r7;
        r4 = java.lang.Class.forName(((net.bytebuddy.utility.dispatcher.JavaDispatcher.Proxied) r3).value(), false, r33.classLoader);
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x03c9, code lost:
    
        if (r0[r12].isAssignableFrom(r4) == false) goto L361;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x03cb, code lost:
    
        r0[r12] = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x03f5, code lost:
    
        throw new java.lang.IllegalStateException("Cannot resolve to type: " + r4.getName() + " at " + r12 + " of " + r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:267:0x05fd  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x061c  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x064a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01be  */
    @Override // java.security.PrivilegedAction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public T run() {
        /*
            Method dump skipped, instruction units count: 1961
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.dispatcher.JavaDispatcher.run():java.lang.Object");
    }

    public static <T> PrivilegedAction<T> of(Class<T> cls, @MaybeNull ClassLoader classLoader) {
        return of(cls, classLoader, GENERATE);
    }

    public static <T> PrivilegedAction<T> of(Class<T> cls, @MaybeNull ClassLoader classLoader, boolean z6) {
        if (cls.isInterface()) {
            if (!cls.isAnnotationPresent(Proxied.class)) {
                throw new IllegalArgumentException("Expected " + cls.getName() + " to be annotated with " + Proxied.class.getName());
            }
            if (!((Proxied) cls.getAnnotation(Proxied.class)).value().startsWith("java.security.")) {
                return new JavaDispatcher(cls, classLoader, z6);
            }
            throw new IllegalArgumentException("Classes related to Java security cannot be proxied: ".concat(cls.getName()));
        }
        throw new IllegalArgumentException(a.j(cls, "Expected an interface instead of "));
    }
}
