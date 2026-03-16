package org.mockito.internal.creation.bytebuddy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bind.annotation.Argument;
import net.bytebuddy.implementation.bind.annotation.This;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.OpenedClassReader;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher;
import org.mockito.internal.debugging.LocationFactory;
import org.mockito.internal.exceptions.stacktrace.ConditionalStackTraceFilter;
import org.mockito.internal.invocation.RealMethod;
import org.mockito.internal.invocation.SerializableMethod;
import org.mockito.internal.invocation.mockref.MockReference;
import org.mockito.internal.invocation.mockref.MockWeakReference;
import org.mockito.internal.util.concurrent.DetachedThreadLocal;
import org.mockito.internal.util.concurrent.WeakConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public class MockMethodAdvice extends MockMethodDispatcher {
    private final String identifier;
    private final WeakConcurrentMap<Object, MockMethodInterceptor> interceptors;
    private final Predicate<Class<?>> isMockConstruction;
    private final DetachedThreadLocal<Map<Class<?>, MockMethodInterceptor>> mockedStatics;
    private final ConstructionCallback onConstruction;
    private final SelfCallInfo selfCallInfo = new SelfCallInfo();
    private final MethodGraph.Compiler compiler = MethodGraph.Compiler.Default.forJavaHierarchy();
    private final WeakConcurrentMap<Class<?>, SoftReference<MethodGraph>> graphs = new WeakConcurrentMap.WithInlinedExpunction();

    public static class ConstructorShortcut implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper {
        private final String identifier;

        public ConstructorShortcut(String str) {
            this.identifier = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Object[] toFrames(Object obj, List<TypeDescription> list) {
            Object[] objArr = new Object[list.size() + 1];
            int i = 0;
            objArr[0] = obj;
            for (TypeDescription typeDescription : list) {
                i++;
                objArr[i] = (typeDescription.represents(Boolean.TYPE) || typeDescription.represents(Byte.TYPE) || typeDescription.represents(Short.TYPE) || typeDescription.represents(Character.TYPE) || typeDescription.represents(Integer.TYPE)) ? Opcodes.INTEGER : typeDescription.represents(Long.TYPE) ? Opcodes.LONG : typeDescription.represents(Float.TYPE) ? Opcodes.FLOAT : typeDescription.represents(Double.TYPE) ? Opcodes.DOUBLE : typeDescription.getInternalName();
            }
            return objArr;
        }

        @Override // net.bytebuddy.asm.AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper
        public MethodVisitor wrap(final TypeDescription typeDescription, final MethodDescription methodDescription, MethodVisitor methodVisitor, final Implementation.Context context, TypePool typePool, int i, int i3) {
            final MethodDescription.InDefinedShape inDefinedShape;
            if (methodDescription.isConstructor() && !typeDescription.represents(Object.class)) {
                int size = Integer.MAX_VALUE;
                boolean zIsPackagePrivate = true;
                inDefinedShape = null;
                loop0: while (true) {
                    inDefinedShape = inDefinedShape;
                    for (MethodDescription.InDefinedShape inDefinedShape2 : typeDescription.getSuperClass().asErasure().getDeclaredMethods().filter(ElementMatchers.isConstructor().and(ElementMatchers.not(ElementMatchers.isPrivate())))) {
                        if (inDefinedShape2.getParameters().size() >= size || (!zIsPackagePrivate && inDefinedShape2.isPackagePrivate())) {
                        }
                    }
                    size = inDefinedShape2.getParameters().size();
                    zIsPackagePrivate = inDefinedShape2.isPackagePrivate();
                }
                if (inDefinedShape != null) {
                    return new MethodVisitor(OpenedClassReader.ASM_API, methodVisitor) { // from class: org.mockito.internal.creation.bytebuddy.MockMethodAdvice.ConstructorShortcut.1
                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitCode() {
                            super.visitCode();
                            Label label = new Label();
                            super.visitLdcInsn(ConstructorShortcut.this.identifier);
                            if (context.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V5)) {
                                super.visitLdcInsn(Type.getType(typeDescription.getDescriptor()));
                            } else {
                                super.visitLdcInsn(typeDescription.getName());
                                super.visitMethodInsn(184, Type.getInternalName(Class.class), "forName", Type.getMethodDescriptor(Type.getType((Class<?>) Class.class), Type.getType((Class<?>) String.class)), false);
                            }
                            super.visitMethodInsn(184, Type.getInternalName(MockMethodDispatcher.class), "isConstructorMock", Type.getMethodDescriptor(Type.BOOLEAN_TYPE, Type.getType((Class<?>) String.class), Type.getType((Class<?>) Class.class)), false);
                            super.visitInsn(3);
                            super.visitJumpInsn(159, label);
                            super.visitVarInsn(25, 0);
                            for (TypeDescription typeDescription2 : inDefinedShape.getParameters().asTypeList().asErasures()) {
                                if (typeDescription2.represents(Boolean.TYPE) || typeDescription2.represents(Byte.TYPE) || typeDescription2.represents(Short.TYPE) || typeDescription2.represents(Character.TYPE) || typeDescription2.represents(Integer.TYPE)) {
                                    super.visitInsn(3);
                                } else if (typeDescription2.represents(Long.TYPE)) {
                                    super.visitInsn(9);
                                } else if (typeDescription2.represents(Float.TYPE)) {
                                    super.visitInsn(11);
                                } else if (typeDescription2.represents(Double.TYPE)) {
                                    super.visitInsn(14);
                                } else {
                                    super.visitInsn(1);
                                }
                            }
                            super.visitMethodInsn(183, inDefinedShape.getDeclaringType().getInternalName(), inDefinedShape.getInternalName(), inDefinedShape.getDescriptor(), false);
                            super.visitLdcInsn(ConstructorShortcut.this.identifier);
                            if (context.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V5)) {
                                super.visitLdcInsn(Type.getType(typeDescription.getDescriptor()));
                            } else {
                                super.visitLdcInsn(typeDescription.getName());
                                super.visitMethodInsn(184, Type.getInternalName(Class.class), "forName", Type.getMethodDescriptor(Type.getType((Class<?>) Class.class), Type.getType((Class<?>) String.class)), false);
                            }
                            super.visitVarInsn(25, 0);
                            super.visitLdcInsn(Integer.valueOf(methodDescription.getParameters().size()));
                            super.visitTypeInsn(189, Type.getInternalName(Object.class));
                            Iterator<?> it = methodDescription.getParameters().iterator();
                            int i4 = 0;
                            while (it.hasNext()) {
                                ParameterDescription parameterDescription = (ParameterDescription) it.next();
                                super.visitInsn(89);
                                int i5 = i4 + 1;
                                super.visitLdcInsn(Integer.valueOf(i4));
                                Type type = Type.getType(parameterDescription.getType().asErasure().getDescriptor());
                                super.visitVarInsn(type.getOpcode(21), parameterDescription.getOffset());
                                if (parameterDescription.getType().isPrimitive()) {
                                    Type type2 = Type.getType(parameterDescription.getType().asErasure().asBoxed().getDescriptor());
                                    super.visitMethodInsn(184, type2.getInternalName(), "valueOf", Type.getMethodDescriptor(type2, type), false);
                                }
                                super.visitInsn(83);
                                i4 = i5;
                            }
                            super.visitLdcInsn(Integer.valueOf(methodDescription.getParameters().size()));
                            super.visitTypeInsn(189, Type.getInternalName(String.class));
                            int i6 = 0;
                            for (TypeDescription typeDescription3 : methodDescription.getParameters().asTypeList().asErasures()) {
                                super.visitInsn(89);
                                super.visitLdcInsn(Integer.valueOf(i6));
                                super.visitLdcInsn(typeDescription3.getName());
                                super.visitInsn(83);
                                i6++;
                            }
                            super.visitMethodInsn(184, Type.getInternalName(MockMethodDispatcher.class), "handleConstruction", Type.getMethodDescriptor(Type.getType((Class<?>) Object.class), Type.getType((Class<?>) String.class), Type.getType((Class<?>) Class.class), Type.getType((Class<?>) Object.class), Type.getType((Class<?>) Object[].class), Type.getType((Class<?>) String[].class)), false);
                            FieldList<FieldDescription> fieldListFilter = typeDescription.getDeclaredFields().filter(ElementMatchers.not(ElementMatchers.isStatic()));
                            super.visitTypeInsn(192, typeDescription.getInternalName());
                            super.visitInsn(89);
                            Label label2 = new Label();
                            super.visitJumpInsn(198, label2);
                            for (FieldDescription fieldDescription : fieldListFilter) {
                                super.visitInsn(89);
                                super.visitFieldInsn(180, typeDescription.getInternalName(), fieldDescription.getInternalName(), fieldDescription.getDescriptor());
                                super.visitVarInsn(25, 0);
                                super.visitInsn(fieldDescription.getType().getStackSize() == StackSize.DOUBLE ? 91 : 90);
                                super.visitInsn(87);
                                super.visitFieldInsn(181, typeDescription.getInternalName(), fieldDescription.getInternalName(), fieldDescription.getDescriptor());
                            }
                            super.visitLabel(label2);
                            ClassFileVersion classFileVersion = context.getClassFileVersion();
                            ClassFileVersion classFileVersion2 = ClassFileVersion.JAVA_V6;
                            if (classFileVersion.isAtLeast(classFileVersion2)) {
                                Object[] frames = ConstructorShortcut.toFrames(typeDescription.getInternalName(), methodDescription.getParameters().asTypeList().asErasures());
                                super.visitFrame(0, frames.length, frames, 1, new Object[]{typeDescription.getInternalName()});
                            }
                            super.visitInsn(87);
                            super.visitInsn(177);
                            super.visitLabel(label);
                            if (context.getClassFileVersion().isAtLeast(classFileVersion2)) {
                                Object[] frames2 = ConstructorShortcut.toFrames(Opcodes.UNINITIALIZED_THIS, methodDescription.getParameters().asTypeList().asErasures());
                                super.visitFrame(0, frames2.length, frames2, 0, new Object[0]);
                            }
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitMaxs(int i4, int i5) {
                            int iMax = Math.max(5, inDefinedShape.getStackSize());
                            Iterator<?> it = methodDescription.getParameters().iterator();
                            while (it.hasNext()) {
                                iMax = Math.max(Math.max(iMax, ((ParameterDescription) it.next()).getType().getStackSize().getSize() + 6), 8);
                            }
                            super.visitMaxs(Math.max(i4, iMax), i5);
                        }
                    };
                }
            }
            return methodVisitor;
        }
    }

    public static class ForEquals {
        @Advice.OnMethodExit
        private static void enter(@Advice.This Object obj, @Advice.Argument(0) Object obj2, @Advice.Return(readOnly = false) boolean z6, @Advice.Enter boolean z7) {
        }

        @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
        private static boolean enter(@Identifier String str, @Advice.This Object obj) {
            MockMethodDispatcher mockMethodDispatcher = MockMethodDispatcher.get(str, obj);
            return mockMethodDispatcher != null && mockMethodDispatcher.isMock(obj);
        }
    }

    public static class ForReadObject {
        public static void doReadObject(@Identifier String str, @This MockAccess mockAccess, @Argument(0) ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            MockMethodAdvice mockMethodAdvice = (MockMethodAdvice) MockMethodDispatcher.get(str, mockAccess);
            if (mockMethodAdvice != null) {
                mockMethodAdvice.interceptors.put(mockAccess, mockAccess.getMockitoInterceptor());
            }
        }
    }

    public static class ForStatic {
        @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
        private static Callable<?> enter(@Identifier String str, @Advice.Origin Class<?> cls, @Advice.Origin Method method, @Advice.AllArguments Object[] objArr) {
            MockMethodDispatcher mockMethodDispatcher = MockMethodDispatcher.getStatic(str, cls);
            if (mockMethodDispatcher == null || !mockMethodDispatcher.isMockedStatic(cls)) {
                return null;
            }
            return mockMethodDispatcher.handleStatic(cls, method, objArr);
        }

        @Advice.OnMethodExit
        private static void exit(@Advice.Return(readOnly = false, typing = Assigner.Typing.DYNAMIC) Object obj, @Advice.Enter Callable<?> callable) throws Exception {
            if (callable != null) {
                callable.call();
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Identifier {
    }

    public static class RealMethodCall implements RealMethod {
        private final Object[] arguments;
        private final MockWeakReference<Object> instanceRef;
        private final Method origin;
        private final SelfCallInfo selfCallInfo;

        @Override // org.mockito.internal.invocation.RealMethod
        public Object invoke() {
            this.selfCallInfo.set(this.instanceRef.get());
            return MockMethodAdvice.tryInvoke(this.origin, this.instanceRef.get(), this.arguments);
        }

        @Override // org.mockito.internal.invocation.RealMethod
        public boolean isInvokable() {
            return true;
        }

        private RealMethodCall(SelfCallInfo selfCallInfo, Method method, Object obj, Object[] objArr) {
            this.selfCallInfo = selfCallInfo;
            this.origin = method;
            this.instanceRef = new MockWeakReference<>(obj);
            this.arguments = objArr;
        }
    }

    public static class ReturnValueWrapper implements Callable<Object> {
        private final Object returned;

        @Override // java.util.concurrent.Callable
        public Object call() {
            return this.returned;
        }

        private ReturnValueWrapper(Object obj) {
            this.returned = obj;
        }
    }

    public static class SelfCallInfo extends ThreadLocal<Object> {
        private SelfCallInfo() {
        }

        public boolean checkSelfCall(Object obj) {
            if (obj != get()) {
                return true;
            }
            set(null);
            return false;
        }

        public Object replace(Object obj) {
            Object obj2 = get();
            set(obj);
            return obj2;
        }
    }

    public static class SerializableRealMethodCall implements RealMethod {
        private final Object[] arguments;
        private final String identifier;
        private final MockReference<Object> instanceRef;
        private final SerializableMethod origin;

        @Override // org.mockito.internal.invocation.RealMethod
        public Object invoke() {
            Method javaMethod = this.origin.getJavaMethod();
            MockMethodDispatcher mockMethodDispatcher = MockMethodDispatcher.get(this.identifier, this.instanceRef.get());
            if (!(mockMethodDispatcher instanceof MockMethodAdvice)) {
                throw new MockitoException("Unexpected dispatcher for advice-based super call");
            }
            MockMethodAdvice mockMethodAdvice = (MockMethodAdvice) mockMethodDispatcher;
            Object objReplace = mockMethodAdvice.selfCallInfo.replace(this.instanceRef.get());
            try {
                return MockMethodAdvice.tryInvoke(javaMethod, this.instanceRef.get(), this.arguments);
            } finally {
                mockMethodAdvice.selfCallInfo.set(objReplace);
            }
        }

        @Override // org.mockito.internal.invocation.RealMethod
        public boolean isInvokable() {
            return true;
        }

        private SerializableRealMethodCall(String str, Method method, Object obj, Object[] objArr) {
            this.origin = new SerializableMethod(method);
            this.identifier = str;
            this.instanceRef = new MockWeakReference(obj);
            this.arguments = objArr;
        }
    }

    public static class StaticMethodCall implements RealMethod {
        private final Object[] arguments;
        private final Method origin;
        private final SelfCallInfo selfCallInfo;
        private final Class<?> type;

        @Override // org.mockito.internal.invocation.RealMethod
        public Object invoke() {
            this.selfCallInfo.set(this.type);
            return MockMethodAdvice.tryInvoke(this.origin, null, this.arguments);
        }

        @Override // org.mockito.internal.invocation.RealMethod
        public boolean isInvokable() {
            return true;
        }

        private StaticMethodCall(SelfCallInfo selfCallInfo, Class<?> cls, Method method, Object[] objArr) {
            this.selfCallInfo = selfCallInfo;
            this.type = cls;
            this.origin = method;
            this.arguments = objArr;
        }
    }

    public MockMethodAdvice(WeakConcurrentMap<Object, MockMethodInterceptor> weakConcurrentMap, DetachedThreadLocal<Map<Class<?>, MockMethodInterceptor>> detachedThreadLocal, String str, Predicate<Class<?>> predicate, ConstructionCallback constructionCallback) {
        this.interceptors = weakConcurrentMap;
        this.mockedStatics = detachedThreadLocal;
        this.onConstruction = constructionCallback;
        this.identifier = str;
        this.isMockConstruction = predicate;
    }

    @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
    private static Callable<?> enter(@Identifier String str, @Advice.This Object obj, @Advice.Origin Method method, @Advice.AllArguments Object[] objArr) {
        MockMethodDispatcher mockMethodDispatcher = MockMethodDispatcher.get(str, obj);
        if (mockMethodDispatcher == null || !mockMethodDispatcher.isMocked(obj) || mockMethodDispatcher.isOverridden(obj, method)) {
            return null;
        }
        return mockMethodDispatcher.handle(obj, method, objArr);
    }

    @Advice.OnMethodExit
    private static void exit(@Advice.Return(readOnly = false, typing = Assigner.Typing.DYNAMIC) Object obj, @Advice.Enter Callable<?> callable) throws Exception {
        if (callable != null) {
            callable.call();
        }
    }

    public static Throwable removeRecursiveCalls(Throwable th, Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            String str = stackTraceElement.getClassName() + stackTraceElement.getLineNumber();
            int iLastIndexOf = arrayList.lastIndexOf(str);
            arrayList.add(str);
            if (iLastIndexOf > -1 && cls.getName().equals(stackTraceElement.getClassName())) {
                arrayList2.add(Integer.valueOf(iLastIndexOf));
            }
        }
        final ArrayList arrayList3 = new ArrayList(Arrays.asList(th.getStackTrace()));
        arrayList2.stream().sorted(Comparator.reverseOrder()).mapToInt(new h()).forEach(new IntConsumer() { // from class: org.mockito.internal.creation.bytebuddy.i
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                arrayList3.remove(i);
            }
        });
        th.setStackTrace((StackTraceElement[]) arrayList3.toArray(new StackTraceElement[0]));
        return th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object tryInvoke(Method method, Object obj, Object[] objArr) throws Throwable {
        try {
            return Plugins.getMemberAccessor().invoke(method, obj, objArr);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            new ConditionalStackTraceFilter().filter(removeRecursiveCalls(cause, method.getDeclaringClass()));
            throw cause;
        }
    }

    public Callable<?> handle(Object obj, Method method, Object[] objArr) {
        Object obj2;
        Method method2;
        Object[] objArr2;
        RealMethod realMethodCall;
        MockMethodInterceptor mockMethodInterceptor = this.interceptors.get(obj);
        if (mockMethodInterceptor == null) {
            return null;
        }
        if (obj instanceof Serializable) {
            objArr2 = objArr;
            realMethodCall = new SerializableRealMethodCall(this.identifier, method, obj, objArr2);
            method2 = method;
            obj2 = obj;
        } else {
            obj2 = obj;
            method2 = method;
            objArr2 = objArr;
            realMethodCall = new RealMethodCall(this.selfCallInfo, method2, obj2, objArr);
        }
        return new ReturnValueWrapper(mockMethodInterceptor.doIntercept(obj2, method2, objArr2, realMethodCall, LocationFactory.create(true)));
    }

    public Object handleConstruction(Class<?> cls, Object obj, Object[] objArr, String[] strArr) {
        return this.onConstruction.apply(cls, obj, objArr, strArr);
    }

    public Callable<?> handleStatic(Class<?> cls, Method method, Object[] objArr) {
        Map<Class<?>, MockMethodInterceptor> map = this.mockedStatics.get();
        if (map == null || !map.containsKey(cls)) {
            return null;
        }
        return new ReturnValueWrapper(map.get(cls).doIntercept(cls, method, objArr, new StaticMethodCall(this.selfCallInfo, cls, method, objArr), LocationFactory.create(true)));
    }

    public boolean isConstructorMock(Class<?> cls) {
        return this.isMockConstruction.test(cls);
    }

    public boolean isMock(Object obj) {
        WeakConcurrentMap<Object, MockMethodInterceptor> weakConcurrentMap = this.interceptors;
        return obj != weakConcurrentMap.target && weakConcurrentMap.containsKey(obj);
    }

    public boolean isMocked(Object obj) {
        return this.selfCallInfo.checkSelfCall(obj) && isMock(obj);
    }

    public boolean isMockedStatic(Class<?> cls) {
        Map<Class<?>, MockMethodInterceptor> map;
        return this.selfCallInfo.checkSelfCall(cls) && (map = this.mockedStatics.get()) != null && map.containsKey(cls);
    }

    public boolean isOverridden(Object obj, Method method) {
        SoftReference<MethodGraph> softReference = this.graphs.get(obj.getClass());
        MethodGraph methodGraphCompile = softReference == null ? null : softReference.get();
        if (methodGraphCompile == null) {
            methodGraphCompile = this.compiler.compile((TypeDefinition) TypeDescription.ForLoadedType.of(obj.getClass()));
            this.graphs.put(obj.getClass(), new SoftReference<>(methodGraphCompile));
        }
        MethodGraph.Node nodeLocate = methodGraphCompile.locate(new MethodDescription.ForLoadedMethod(method).asSignatureToken());
        return (nodeLocate.getSort().isResolved() && nodeLocate.getRepresentative().asDefined().getDeclaringType().represents(method.getDeclaringClass())) ? false : true;
    }

    public static class ForHashCode {
        @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
        private static boolean enter(@Identifier String str, @Advice.This Object obj) {
            MockMethodDispatcher mockMethodDispatcher = MockMethodDispatcher.get(str, obj);
            return mockMethodDispatcher != null && mockMethodDispatcher.isMock(obj);
        }

        @Advice.OnMethodExit
        private static void enter(@Advice.This Object obj, @Advice.Return(readOnly = false) int i, @Advice.Enter boolean z6) {
            if (z6) {
                System.identityHashCode(obj);
            }
        }
    }
}
