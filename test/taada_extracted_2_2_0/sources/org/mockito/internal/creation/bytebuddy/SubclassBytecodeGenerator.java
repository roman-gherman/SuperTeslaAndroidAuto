package org.mockito.internal.creation.bytebuddy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.modifier.SynchronizationState;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.Transformer;
import net.bytebuddy.dynamic.loading.MultipleParentClassLoader;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.implementation.FieldAccessor;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.GraalImageCode;
import net.bytebuddy.utility.RandomString;
import org.mockito.codegen.InjectionBase;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.creation.bytebuddy.ByteBuddyCrossClassLoaderSerializationSupport;
import org.mockito.internal.creation.bytebuddy.MockMethodInterceptor;
import org.mockito.internal.util.StringUtil;
import org.mockito.mock.SerializableMode;

/* JADX INFO: loaded from: classes.dex */
class SubclassBytecodeGenerator implements BytecodeGenerator {
    private static final String CODEGEN_PACKAGE = "org.mockito.codegen.";
    private final ByteBuddy byteBuddy;
    private final Implementation dispatcher;
    private final Implementation equals;
    private final ModuleHandler handler;
    private final Implementation hashCode;
    private final SubclassLoader loader;
    private final ElementMatcher<? super MethodDescription> matcher;
    private final Implementation readReplace;
    private final Implementation writeReplace;

    public SubclassBytecodeGenerator() {
        this(new SubclassInjectionLoader());
    }

    private static void assertVisibility(Class<?> cls) {
        if (!Modifier.isPublic(cls.getModifiers())) {
            throw new MockitoException(StringUtil.join(androidx.constraintlayout.core.motion.a.j(cls, "Cannot create mock for "), "", "The type is not public and its mock class is loaded by a different class loader.", "This can have multiple reasons:", " - You are mocking a class with additional interfaces of another class loader", " - Mockito is loaded by a different class loader than the mocked type (e.g. with OSGi)", " - The thread's context class loader is different than the mock's class loader"));
        }
    }

    private static boolean hasNonPublicTypeReference(Class<?> cls) {
        for (Method method : cls.getMethods()) {
            if (!Modifier.isPublic(method.getReturnType().getModifiers())) {
                return true;
            }
            for (Class<?> cls2 : method.getParameterTypes()) {
                if (!Modifier.isPublic(cls2.getModifiers())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isComingFromJDK(Class<?> cls) {
        return (cls.getPackage() != null && "Java Runtime Environment".equalsIgnoreCase(cls.getPackage().getImplementationTitle())) || cls.getName().startsWith("java.") || cls.getName().startsWith("javax.");
    }

    private static boolean needsSamePackageClassLoader(MockFeatures<?> mockFeatures) {
        if (!Modifier.isPublic(mockFeatures.mockedType.getModifiers()) || !mockFeatures.mockedType.isInterface() || hasNonPublicTypeReference(mockFeatures.mockedType)) {
            return true;
        }
        for (Class<?> cls : mockFeatures.interfaces) {
            if (!Modifier.isPublic(cls.getModifiers()) || hasNonPublicTypeReference(cls)) {
                return true;
            }
        }
        return false;
    }

    private static Collection<? extends Type> sortedSerializable(Collection<Class<?>> collection, Class<?> cls) {
        TreeSet treeSet = new TreeSet(Comparator.comparing(new k()));
        treeSet.addAll(collection);
        if (cls != Void.TYPE) {
            treeSet.add(cls);
        }
        treeSet.add(Serializable.class);
        return treeSet;
    }

    private static CharSequence suffix(MockFeatures<?> mockFeatures) {
        StringBuilder sb = new StringBuilder();
        TreeSet treeSet = new TreeSet();
        treeSet.add(mockFeatures.mockedType.getName());
        Iterator<Class<?>> it = mockFeatures.interfaces.iterator();
        while (it.hasNext()) {
            treeSet.add(it.next().getName());
        }
        sb.append(RandomString.hashOf(treeSet.hashCode()));
        sb.append(RandomString.hashOf(mockFeatures.serializableMode.name().hashCode()));
        sb.append(mockFeatures.stripAnnotations ? "S" : "N");
        return sb;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // org.mockito.internal.creation.bytebuddy.BytecodeGenerator
    public <T> Class<? extends T> mockClass(MockFeatures<T> mockFeatures) {
        MultipleParentClassLoader.Builder builderAppendMostSpecific = new MultipleParentClassLoader.Builder().appendMostSpecific(mockFeatures.mockedType).appendMostSpecific(mockFeatures.interfaces).appendMostSpecific(MockAccess.class, MockMethodInterceptor.DispatcherDefaultingToRealMethod.class).appendMostSpecific(MockMethodInterceptor.class, MockMethodInterceptor.ForHashCode.class, MockMethodInterceptor.ForEquals.class);
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (needsSamePackageClassLoader(mockFeatures)) {
            ClassLoader classLoaderBuild = builderAppendMostSpecific.build();
            for (ClassLoader parent = contextClassLoader; parent != null; parent = parent.getParent()) {
                if (parent == classLoaderBuild) {
                    break;
                }
            }
            builderAppendMostSpecific = builderAppendMostSpecific.appendMostSpecific(contextClassLoader);
        } else {
            builderAppendMostSpecific = builderAppendMostSpecific.appendMostSpecific(contextClassLoader);
        }
        ClassLoader classLoaderBuild2 = builderAppendMostSpecific.build();
        boolean z6 = classLoaderBuild2 == mockFeatures.mockedType.getClassLoader() && mockFeatures.serializableMode != SerializableMode.ACROSS_CLASSLOADERS && !isComingFromJDK(mockFeatures.mockedType) && (this.loader.isDisrespectingOpenness() || this.handler.isOpened(mockFeatures.mockedType, MockAccess.class)) && !GraalImageCode.getCurrent().isDefined();
        String name = (z6 || ((this.loader instanceof MultipleParentClassLoader) && !isComingFromJDK(mockFeatures.mockedType))) ? mockFeatures.mockedType.getName() : InjectionBase.class.getPackage().getName() + "." + mockFeatures.mockedType.getSimpleName();
        String str = String.format("%s$%s$%s", name, "MockitoMock", GraalImageCode.getCurrent().isDefined() ? suffix(mockFeatures) : RandomString.make());
        if (z6) {
            this.handler.adjustModuleGraph(mockFeatures.mockedType, MockAccess.class, false, true);
            for (Class<?> cls : mockFeatures.interfaces) {
                this.handler.adjustModuleGraph(cls, mockFeatures.mockedType, true, false);
                this.handler.adjustModuleGraph(mockFeatures.mockedType, cls, false, true);
            }
        } else {
            boolean zIsExported = this.handler.isExported(mockFeatures.mockedType);
            Iterator<Class<?>> it = mockFeatures.interfaces.iterator();
            while (zIsExported && it.hasNext()) {
                zIsExported = this.handler.isExported(it.next());
            }
            if (zIsExported) {
                assertVisibility(mockFeatures.mockedType);
                Iterator<Class<?>> it2 = mockFeatures.interfaces.iterator();
                while (it2.hasNext()) {
                    assertVisibility(it2.next());
                }
            } else {
                Class<?> clsInjectionBase = this.handler.injectionBase(classLoaderBuild2, name);
                assertVisibility(mockFeatures.mockedType);
                this.handler.adjustModuleGraph(mockFeatures.mockedType, clsInjectionBase, true, false);
                for (Class<?> cls2 : mockFeatures.interfaces) {
                    assertVisibility(cls2);
                    this.handler.adjustModuleGraph(cls2, clsInjectionBase, true, false);
                }
            }
        }
        DynamicType.Builder<T> builderAnnotateType = this.byteBuddy.subclass((Class) ((GraalImageCode.getCurrent().isDefined() && mockFeatures.mockedType.isInterface()) ? (Class<T>) Object.class : mockFeatures.mockedType)).name(str).ignoreAlso(BytecodeGenerator.isGroovyMethod(false)).annotateType(mockFeatures.stripAnnotations ? new Annotation[0] : (!mockFeatures.mockedType.isInterface() || mockFeatures.interfaces.isEmpty()) ? mockFeatures.mockedType.getAnnotations() : new Annotation[0]);
        boolean zIsDefined = GraalImageCode.getCurrent().isDefined();
        Class<T> cls3 = Void.TYPE;
        DynamicType.Builder.FieldDefinition.Optional<T> optionalSerialVersionUid = builderAnnotateType.implement((List<? extends Type>) new ArrayList(zIsDefined ? sortedSerializable(mockFeatures.interfaces, (GraalImageCode.getCurrent().isDefined() && mockFeatures.mockedType.isInterface()) ? mockFeatures.mockedType : cls3) : mockFeatures.interfaces)).method(this.matcher).intercept(this.dispatcher).transform(Transformer.ForMethod.withModifiers(SynchronizationState.PLAIN)).attribute(mockFeatures.stripAnnotations ? MethodAttributeAppender.NoOp.INSTANCE : MethodAttributeAppender.ForInstrumentedMethod.INCLUDING_RECEIVER).serialVersionUid(42L);
        Visibility visibility = Visibility.PRIVATE;
        DynamicType.Builder<T> builderIntercept = optionalSerialVersionUid.defineField("mockitoInterceptor", MockMethodInterceptor.class, visibility).implement(MockAccess.class).intercept(FieldAccessor.ofBeanProperty()).method(ElementMatchers.isHashCode()).intercept(this.hashCode).method(ElementMatchers.isEquals()).intercept(this.equals);
        if (mockFeatures.serializableMode == SerializableMode.ACROSS_CLASSLOADERS) {
            builderIntercept = builderIntercept.implement(ByteBuddyCrossClassLoaderSerializationSupport.CrossClassLoaderSerializableMock.class).intercept(this.writeReplace);
        }
        if (this.readReplace != null) {
            builderIntercept = builderIntercept.defineMethod("readObject", cls3, visibility).withParameters(ObjectInputStream.class).throwing(ClassNotFoundException.class, IOException.class).intercept(this.readReplace);
        }
        if (str.startsWith(CODEGEN_PACKAGE) || (classLoaderBuild2 instanceof MultipleParentClassLoader)) {
            builderIntercept = builderIntercept.ignoreAlso(ElementMatchers.isPackagePrivate().or(ElementMatchers.returns(ElementMatchers.isPackagePrivate())).or(ElementMatchers.hasParameters(ElementMatchers.whereAny(ElementMatchers.hasType(ElementMatchers.isPackagePrivate())))));
        }
        return builderIntercept.make().load(classLoaderBuild2, this.loader.resolveStrategy(mockFeatures.mockedType, classLoaderBuild2, z6)).getLoaded();
    }

    @Override // org.mockito.internal.creation.bytebuddy.BytecodeGenerator
    public void mockClassConstruction(Class<?> cls) {
        throw new MockitoException("The subclass byte code generator cannot create construction mocks");
    }

    @Override // org.mockito.internal.creation.bytebuddy.BytecodeGenerator
    public void mockClassStatic(Class<?> cls) {
        throw new MockitoException("The subclass byte code generator cannot create static mocks");
    }

    public SubclassBytecodeGenerator(SubclassLoader subclassLoader) {
        this(subclassLoader, null, ElementMatchers.any());
    }

    public SubclassBytecodeGenerator(Implementation implementation, ElementMatcher<? super MethodDescription> elementMatcher) {
        this(new SubclassInjectionLoader(), implementation, elementMatcher);
    }

    public SubclassBytecodeGenerator(SubclassLoader subclassLoader, Implementation implementation, ElementMatcher<? super MethodDescription> elementMatcher) {
        this.dispatcher = MethodDelegation.to((Class<?>) MockMethodInterceptor.DispatcherDefaultingToRealMethod.class);
        this.hashCode = MethodDelegation.to((Class<?>) MockMethodInterceptor.ForHashCode.class);
        this.equals = MethodDelegation.to((Class<?>) MockMethodInterceptor.ForEquals.class);
        this.writeReplace = MethodDelegation.to((Class<?>) MockMethodInterceptor.ForWriteReplace.class);
        this.loader = subclassLoader;
        this.readReplace = implementation;
        this.matcher = elementMatcher;
        ByteBuddy byteBuddyWith = new ByteBuddy().with(TypeValidation.DISABLED);
        this.byteBuddy = byteBuddyWith;
        this.handler = ModuleHandler.make(byteBuddyWith, subclassLoader);
    }
}
