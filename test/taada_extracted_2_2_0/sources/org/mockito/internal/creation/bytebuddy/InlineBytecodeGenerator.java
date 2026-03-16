package org.mockito.internal.creation.bytebuddy;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.RandomString;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.creation.bytebuddy.MockMethodAdvice;
import org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher;
import org.mockito.internal.util.StringUtil;
import org.mockito.internal.util.concurrent.DetachedThreadLocal;
import org.mockito.internal.util.concurrent.WeakConcurrentMap;
import org.mockito.internal.util.concurrent.WeakConcurrentSet;
import org.mockito.mock.SerializableMode;

/* JADX INFO: loaded from: classes.dex */
public class InlineBytecodeGenerator implements BytecodeGenerator, ClassFileTransformer {
    static final Set<Class<?>> EXCLUDES = new HashSet(Arrays.asList(Class.class, Boolean.class, Byte.class, Short.class, Character.class, Integer.class, Long.class, Float.class, Double.class, String.class));
    private static final String PRELOAD = "org.mockito.inline.preload";
    private final ByteBuddy byteBuddy;
    private final Method canRead;
    private final WeakConcurrentSet<Class<?>> flatMocked;
    private final Method getModule;
    private final Instrumentation instrumentation;
    private volatile Throwable lastException;
    private final AsmVisitorWrapper mockTransformer;
    private final WeakConcurrentSet<Class<?>> mocked;
    private final Method redefineModule;
    private final BytecodeGenerator subclassEngine;

    public static class ParameterWritingVisitorWrapper extends AsmVisitorWrapper.AbstractBase {
        private final Class<?> type;

        public static class MethodParameterStrippingMethodVisitor extends MethodVisitor {
            public MethodParameterStrippingMethodVisitor(MethodVisitor methodVisitor) {
                super(OpenedClassReader.ASM_API, methodVisitor);
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitParameter(String str, int i) {
            }
        }

        public static class ParameterAddingClassVisitor extends ClassVisitor {
            private final TypeDescription typeDescription;

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public MethodVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr) {
                MethodVisitor methodVisitorVisitMethod = super.visitMethod(i, str, str2, str3, strArr);
                MethodList methodListFilter = this.typeDescription.getDeclaredMethods().filter((str.equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME) ? ElementMatchers.isConstructor() : ElementMatchers.named(str)).and(ElementMatchers.hasDescriptor(str2)));
                if (methodListFilter.size() != 1 || !((MethodDescription) methodListFilter.getOnly()).getParameters().hasExplicitMetaData()) {
                    return methodVisitorVisitMethod;
                }
                Iterator<?> it = ((MethodDescription) methodListFilter.getOnly()).getParameters().iterator();
                while (it.hasNext()) {
                    ParameterDescription parameterDescription = (ParameterDescription) it.next();
                    methodVisitorVisitMethod.visitParameter(parameterDescription.getName(), parameterDescription.getModifiers());
                }
                return new MethodParameterStrippingMethodVisitor(methodVisitorVisitMethod);
            }

            private ParameterAddingClassVisitor(ClassVisitor classVisitor, TypeDescription typeDescription) {
                super(OpenedClassReader.ASM_API, classVisitor);
                this.typeDescription = typeDescription;
            }
        }

        @Override // net.bytebuddy.asm.AsmVisitorWrapper
        public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i, int i3) {
            return context.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V8) ? new ParameterAddingClassVisitor(classVisitor, new TypeDescription.ForLoadedType(this.type)) : classVisitor;
        }

        private ParameterWritingVisitorWrapper(Class<?> cls) {
            this.type = cls;
        }
    }

    public InlineBytecodeGenerator(Instrumentation instrumentation, WeakConcurrentMap<Object, MockMethodInterceptor> weakConcurrentMap, DetachedThreadLocal<Map<Class<?>, MockMethodInterceptor>> detachedThreadLocal, Predicate<Class<?>> predicate, ConstructionCallback constructionCallback) {
        Method method;
        Method method2;
        Method method3;
        preload();
        this.instrumentation = instrumentation;
        this.byteBuddy = new ByteBuddy().with(TypeValidation.DISABLED).with(Implementation.Context.Disabled.Factory.INSTANCE).with(MethodGraph.Compiler.ForDeclaredMethods.INSTANCE).ignore(ElementMatchers.isSynthetic().and(ElementMatchers.not(ElementMatchers.isConstructor())).or(ElementMatchers.isDefaultFinalizer()));
        WeakConcurrentSet.Cleaner cleaner = WeakConcurrentSet.Cleaner.MANUAL;
        this.mocked = new WeakConcurrentSet<>(cleaner);
        this.flatMocked = new WeakConcurrentSet<>(cleaner);
        String strMake = RandomString.make();
        this.subclassEngine = new TypeCachingBytecodeGenerator(new SubclassBytecodeGenerator(MethodDelegation.withDefaultConfiguration().withBinders(TargetMethodAnnotationDrivenBinder.ParameterBinder.ForFixedValue.OfConstant.of(MockMethodAdvice.Identifier.class, strMake)).to(MockMethodAdvice.ForReadObject.class), ElementMatchers.isAbstract().or(ElementMatchers.isNative()).or(ElementMatchers.isToString())), false);
        this.mockTransformer = new AsmVisitorWrapper.ForDeclaredMethods().method(ElementMatchers.isVirtual().and(ElementMatchers.not(ElementMatchers.isBridge().or(ElementMatchers.isHashCode()).or(ElementMatchers.isEquals()).or(ElementMatchers.isDefaultFinalizer()))).and(ElementMatchers.not(ElementMatchers.isDeclaredBy(ElementMatchers.nameStartsWith("java.")).and(ElementMatchers.isPackagePrivate())).and(ElementMatchers.not(BytecodeGenerator.isGroovyMethod(true)))), Advice.withCustomMapping().bind(MockMethodAdvice.Identifier.class, strMake).to(MockMethodAdvice.class)).method(ElementMatchers.isStatic().and(ElementMatchers.not(BytecodeGenerator.isGroovyMethod(true))), Advice.withCustomMapping().bind(MockMethodAdvice.Identifier.class, strMake).to(MockMethodAdvice.ForStatic.class)).constructor(ElementMatchers.any(), new MockMethodAdvice.ConstructorShortcut(strMake)).method(ElementMatchers.isHashCode(), Advice.withCustomMapping().bind(MockMethodAdvice.Identifier.class, strMake).to(MockMethodAdvice.ForHashCode.class)).method(ElementMatchers.isEquals(), Advice.withCustomMapping().bind(MockMethodAdvice.Identifier.class, strMake).to(MockMethodAdvice.ForEquals.class));
        try {
            method = Class.class.getMethod("getModule", new Class[0]);
            method2 = method.getReturnType().getMethod("canRead", method.getReturnType());
            method3 = Instrumentation.class.getMethod("redefineModule", method.getReturnType(), Set.class, Map.class, Map.class, Set.class, Map.class);
        } catch (Exception unused) {
            method = null;
            method2 = null;
            method3 = null;
        }
        this.getModule = method;
        this.canRead = method2;
        this.redefineModule = method3;
        MockMethodDispatcher.set(strMake, new MockMethodAdvice(weakConcurrentMap, detachedThreadLocal, strMake, predicate, constructionCallback));
        instrumentation.addTransformer(this, true);
    }

    private void addInterfaces(Set<Class<?>> set, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (this.mocked.add(cls)) {
                if (!this.flatMocked.remove(cls)) {
                    assureInitialization(cls);
                    set.add(cls);
                }
                addInterfaces(set, cls.getInterfaces());
            }
        }
    }

    private void assureCanReadMockito(Set<Class<?>> set) {
        if (this.redefineModule == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        try {
            Object objInvoke = this.getModule.invoke(Class.forName("org.mockito.internal.creation.bytebuddy.inject.MockMethodDispatcher", false, null), new Object[0]);
            Iterator<Class<?>> it = set.iterator();
            while (it.hasNext()) {
                Object objInvoke2 = this.getModule.invoke(it.next(), new Object[0]);
                if (!hashSet.contains(objInvoke2) && !((Boolean) this.canRead.invoke(objInvoke2, objInvoke)).booleanValue()) {
                    hashSet.add(objInvoke2);
                }
            }
            for (Object obj : hashSet) {
                Method method = this.redefineModule;
                Instrumentation instrumentation = this.instrumentation;
                Set setSingleton = Collections.singleton(objInvoke);
                Map map = Collections.EMPTY_MAP;
                method.invoke(instrumentation, obj, setSingleton, map, map, Collections.EMPTY_SET, map);
            }
        } catch (Exception e) {
            throw new IllegalStateException(StringUtil.join("Could not adjust module graph to make the mock instance dispatcher visible to some classes", "", "At least one of those modules: " + hashSet + " is not reading the unnamed module of the bootstrap loader", "Without such a read edge, the classes that are redefined to become mocks cannot access the mock dispatcher.", "To circumvent this, Mockito attempted to add a read edge to this module what failed for an unexpected reason"), e);
        }
    }

    private static void assureInitialization(Class<?> cls) {
        try {
            Class.forName(cls.getName(), true, cls.getClassLoader());
        } catch (ExceptionInInitializerError e) {
            throw new MockitoException(androidx.constraintlayout.core.motion.a.k(cls, "Cannot instrument ", " because it or one of its supertypes could not be initialized"), e.getException());
        } catch (Throwable unused) {
        }
    }

    private <T> void checkSupportedCombination(boolean z6, MockFeatures<T> mockFeatures) {
        if (!z6 || mockFeatures.mockedType.isArray() || mockFeatures.mockedType.isPrimitive()) {
            return;
        }
        if (!Modifier.isFinal(mockFeatures.mockedType.getModifiers())) {
            final TypeSupport typeSupport = TypeSupport.INSTANCE;
            if (!typeSupport.isSealed(mockFeatures.mockedType) && !mockFeatures.interfaces.stream().anyMatch(new Predicate() { // from class: org.mockito.internal.creation.bytebuddy.b
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return typeSupport.isSealed((Class) obj);
                }
            })) {
                return;
            }
        }
        throw new MockitoException("Unsupported settings with this type '" + mockFeatures.mockedType.getName() + "'");
    }

    private static void preload() {
        String property = System.getProperty(PRELOAD);
        if (property == null) {
            property = "java.lang.WeakPairMap,java.lang.WeakPairMap$Pair,java.lang.WeakPairMap$Pair$Weak";
        }
        for (String str : property.split(",")) {
            try {
                Class.forName(str, false, null);
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    private <T> void triggerRetransformation(Set<Class<?>> set, boolean z6) {
        HashSet<Class<?>> hashSet = new HashSet();
        try {
            Iterator<Class<?>> it = set.iterator();
            while (it.hasNext()) {
                Class<?> next = it.next();
                if (!z6) {
                    do {
                        if (this.mocked.add(next)) {
                            if (!this.flatMocked.remove(next)) {
                                assureInitialization(next);
                                hashSet.add(next);
                            }
                            addInterfaces(hashSet, next.getInterfaces());
                        }
                        next = next.getSuperclass();
                    } while (next != null);
                } else if (!this.mocked.contains(next) && this.flatMocked.add(next)) {
                    assureInitialization(next);
                    hashSet.add(next);
                }
            }
            if (!hashSet.isEmpty()) {
                try {
                    try {
                        assureCanReadMockito(hashSet);
                        this.instrumentation.retransformClasses((Class[]) hashSet.toArray(new Class[hashSet.size()]));
                        Throwable th = this.lastException;
                        if (th != null) {
                            throw new IllegalStateException(StringUtil.join("Byte Buddy could not instrument all classes within the mock's type hierarchy", "", "This problem should never occur for javac-compiled classes. This problem has been observed for classes that are:", " - Compiled by older versions of scalac", " - Classes that are part of the Android distribution"), th);
                        }
                    } catch (Exception e) {
                        for (Class<?> cls : hashSet) {
                            this.mocked.remove(cls);
                            this.flatMocked.remove(cls);
                        }
                        throw new MockitoException("Could not modify all classes " + hashSet, e);
                    }
                } finally {
                    this.lastException = null;
                }
                this.lastException = null;
            }
            this.mocked.expungeStaleEntries();
            this.flatMocked.expungeStaleEntries();
        } finally {
            for (Class<?> cls2 : hashSet) {
                this.mocked.remove(cls2);
                this.flatMocked.remove(cls2);
            }
        }
    }

    @Override // org.mockito.internal.creation.bytebuddy.BytecodeGenerator
    public synchronized void clearAllCaches() {
        final HashSet hashSet = new HashSet();
        this.mocked.forEach(new Consumer() { // from class: org.mockito.internal.creation.bytebuddy.a
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                hashSet.add((Class) obj);
            }
        });
        if (hashSet.isEmpty()) {
            return;
        }
        this.mocked.clear();
        this.flatMocked.clear();
        try {
            this.instrumentation.retransformClasses((Class[]) hashSet.toArray(new Class[0]));
        } catch (UnmodifiableClassException e) {
            throw new MockitoException(StringUtil.join("Failed to reset mocks.", "", "This should not influence the working of Mockito.", "But if the reset intends to remove mocking code to improve performance, it is still impacted."), e);
        }
    }

    @Override // org.mockito.internal.creation.bytebuddy.BytecodeGenerator
    public <T> Class<? extends T> mockClass(MockFeatures<T> mockFeatures) {
        boolean z6 = (mockFeatures.interfaces.isEmpty() && mockFeatures.serializableMode == SerializableMode.NONE && !Modifier.isAbstract(mockFeatures.mockedType.getModifiers())) ? false : true;
        checkSupportedCombination(z6, mockFeatures);
        HashSet hashSet = new HashSet();
        hashSet.add(mockFeatures.mockedType);
        hashSet.addAll(mockFeatures.interfaces);
        synchronized (this) {
            triggerRetransformation(hashSet, false);
        }
        return z6 ? this.subclassEngine.mockClass(mockFeatures) : mockFeatures.mockedType;
    }

    @Override // org.mockito.internal.creation.bytebuddy.BytecodeGenerator
    public synchronized void mockClassConstruction(Class<?> cls) {
        triggerRetransformation(Collections.singleton(cls), false);
    }

    @Override // org.mockito.internal.creation.bytebuddy.BytecodeGenerator
    public synchronized void mockClassStatic(Class<?> cls) {
        triggerRetransformation(Collections.singleton(cls), true);
    }

    public byte[] transform(ClassLoader classLoader, String str, Class<?> cls, ProtectionDomain protectionDomain, byte[] bArr) {
        if (cls != null && ((this.mocked.contains(cls) || this.flatMocked.contains(cls)) && !EXCLUDES.contains(cls))) {
            try {
                return this.byteBuddy.redefine(cls, ClassFileLocator.Simple.of(cls.getName(), bArr)).visit(new ParameterWritingVisitorWrapper(cls)).visit(this.mockTransformer).make().getBytes();
            } catch (Throwable th) {
                this.lastException = th;
            }
        }
        return null;
    }
}
