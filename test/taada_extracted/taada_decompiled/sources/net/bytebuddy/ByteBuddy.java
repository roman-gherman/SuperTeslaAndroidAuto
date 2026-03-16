package net.bytebuddy;

import B2.b;
import androidx.core.view.InputDeviceCompat;
import com.google.protobuf.a;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.bytebuddy.NamingStrategy;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.modifier.EnumerationState;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.TypeManifestation;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.dynamic.Transformer;
import net.bytebuddy.dynamic.VisibilityBridgeStrategy;
import net.bytebuddy.dynamic.scaffold.ClassWriterStrategy;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.inline.DecoratingDynamicTypeBuilder;
import net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer;
import net.bytebuddy.dynamic.scaffold.inline.RebaseDynamicTypeBuilder;
import net.bytebuddy.dynamic.scaffold.inline.RedefinitionDynamicTypeBuilder;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.dynamic.scaffold.subclass.SubclassDynamicTypeBuilder;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.implementation.SuperMethodCall;
import net.bytebuddy.implementation.attribute.AnnotationRetention;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.GraalImageCode;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public class ByteBuddy {
    private static final boolean ACCESS_CONTROLLER;
    private static final String BYTE_BUDDY_DEFAULT_CONTEXT_NAME = "synthetic";
    private static final String BYTE_BUDDY_DEFAULT_PREFIX = "ByteBuddy";
    private static final String BYTE_BUDDY_DEFAULT_SUFFIX = "auxiliary";

    @MaybeNull
    private static final AuxiliaryType.NamingStrategy DEFAULT_AUXILIARY_NAMING_STRATEGY;

    @MaybeNull
    private static final Implementation.Context.Factory DEFAULT_IMPLEMENTATION_CONTEXT_FACTORY;
    public static final String DEFAULT_NAMING_PROPERTY = "net.bytebuddy.naming";

    @MaybeNull
    private static final NamingStrategy DEFAULT_NAMING_STRATEGY;
    protected final AnnotationRetention annotationRetention;
    protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
    protected final AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy;
    protected final ClassFileVersion classFileVersion;
    protected final ClassWriterStrategy classWriterStrategy;
    protected final LatentMatcher<? super MethodDescription> ignoredMethods;
    protected final Implementation.Context.Factory implementationContextFactory;
    protected final InstrumentedType.Factory instrumentedTypeFactory;
    protected final MethodGraph.Compiler methodGraphCompiler;
    protected final NamingStrategy namingStrategy;
    protected final TypeValidation typeValidation;
    protected final VisibilityBridgeStrategy visibilityBridgeStrategy;

    @HashCodeAndEqualsPlugin.Enhance
    public static class EnumerationImplementation implements Implementation {
        protected static final String CLONE_METHOD_NAME = "clone";
        private static final int ENUM_FIELD_MODIFIERS = 25;
        private static final String ENUM_VALUES = "$VALUES";
        protected static final String ENUM_VALUES_METHOD_NAME = "values";
        protected static final String ENUM_VALUE_OF_METHOD_NAME = "valueOf";
        private final List<String> values;

        @HashCodeAndEqualsPlugin.Enhance
        public static class InitializationAppender implements ByteCodeAppender {
            private final List<String> values;

            public InitializationAppender(List<String> list) {
                this.values = list;
            }

            @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                TypeDescription typeDescriptionAsErasure = methodDescription.getDeclaringType().asErasure();
                MethodDescription methodDescription2 = (MethodDescription) typeDescriptionAsErasure.getDeclaredMethods().filter(ElementMatchers.isConstructor().and(ElementMatchers.takesArguments((Class<?>[]) new Class[]{String.class, Integer.TYPE}))).getOnly();
                StackManipulation stackManipulation = StackManipulation.Trivial.INSTANCE;
                ArrayList arrayList = new ArrayList(this.values.size());
                int i = 0;
                for (String str : this.values) {
                    FieldDescription fieldDescription = (FieldDescription) typeDescriptionAsErasure.getDeclaredFields().filter(ElementMatchers.named(str)).getOnly();
                    StackManipulation.Compound compound = new StackManipulation.Compound(stackManipulation, TypeCreation.of(typeDescriptionAsErasure), Duplication.SINGLE, new TextConstant(str), IntegerConstant.forValue(i), MethodInvocation.invoke(methodDescription2), FieldAccess.forField(fieldDescription).write());
                    arrayList.add(fieldDescription);
                    i++;
                    stackManipulation = compound;
                }
                ArrayList arrayList2 = new ArrayList(this.values.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(FieldAccess.forField((FieldDescription) it.next()).read());
                }
                return new ByteCodeAppender.Size(new StackManipulation.Compound(stackManipulation, ArrayFactory.forType(typeDescriptionAsErasure.asGenericType()).withValues(arrayList2), FieldAccess.forField((FieldDescription.InDefinedShape) typeDescriptionAsErasure.getDeclaredFields().filter(ElementMatchers.named(EnumerationImplementation.ENUM_VALUES)).getOnly()).write()).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.values.equals(((InitializationAppender) obj).values);
            }

            public int hashCode() {
                return this.values.hashCode() + (getClass().hashCode() * 31);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ValuesMethodAppender implements ByteCodeAppender {
            private final TypeDescription instrumentedType;

            public ValuesMethodAppender(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                FieldDescription fieldDescription = (FieldDescription) this.instrumentedType.getDeclaredFields().filter(ElementMatchers.named(EnumerationImplementation.ENUM_VALUES)).getOnly();
                return new ByteCodeAppender.Size(new StackManipulation.Compound(FieldAccess.forField(fieldDescription).read(), MethodInvocation.invoke((MethodDescription) TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class).getDeclaredMethods().filter(ElementMatchers.named(EnumerationImplementation.CLONE_METHOD_NAME)).getOnly()).virtual(fieldDescription.getType().asErasure()), TypeCasting.to(fieldDescription.getType().asErasure()), MethodReturn.REFERENCE).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((ValuesMethodAppender) obj).instrumentedType);
            }

            public int hashCode() {
                return this.instrumentedType.hashCode() + (getClass().hashCode() * 31);
            }
        }

        public EnumerationImplementation(List<String> list) {
            this.values = list;
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Implementation.Target target) {
            return new ValuesMethodAppender(target.getInstrumentedType());
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.values.equals(((EnumerationImplementation) obj).values);
        }

        public int hashCode() {
            return this.values.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            Iterator<String> it = this.values.iterator();
            while (it.hasNext()) {
                instrumentedType = instrumentedType.withField(new FieldDescription.Token(it.next(), 16409, TargetType.DESCRIPTION.asGenericType()));
            }
            return instrumentedType.withField(new FieldDescription.Token(ENUM_VALUES, 4121, TypeDescription.ArrayProjection.of(TargetType.DESCRIPTION).asGenericType())).withInitializer(new InitializationAppender(this.values));
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public enum RecordConstructorStrategy implements ConstructorStrategy, Implementation {
        INSTANCE;

        @HashCodeAndEqualsPlugin.Enhance
        public static class Appender implements ByteCodeAppender {
            private final TypeDescription instrumentedType;

            public Appender(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                int size = 1;
                if (methodDescription.isMethod()) {
                    return new ByteCodeAppender.Simple(MethodVariableAccess.loadThis(), FieldAccess.forField((FieldDescription.InDefinedShape) this.instrumentedType.getDeclaredFields().filter(ElementMatchers.named(methodDescription.getName())).getOnly()).read(), MethodReturn.of(methodDescription.getReturnType())).apply(methodVisitor, context, methodDescription);
                }
                ArrayList arrayList = new ArrayList((this.instrumentedType.getRecordComponents().size() * 3) + 2);
                arrayList.add(MethodVariableAccess.loadThis());
                arrayList.add(MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(JavaType.RECORD.getTypeStub(), new MethodDescription.Token(1))));
                for (RecordComponentDescription.InDefinedShape inDefinedShape : this.instrumentedType.getRecordComponents()) {
                    arrayList.add(MethodVariableAccess.loadThis());
                    arrayList.add(MethodVariableAccess.of(inDefinedShape.getType()).loadFrom(size));
                    arrayList.add(FieldAccess.forField((FieldDescription.InDefinedShape) this.instrumentedType.getDeclaredFields().filter(ElementMatchers.named(inDefinedShape.getActualName())).getOnly()).write());
                    size += inDefinedShape.getType().getStackSize().getSize();
                }
                arrayList.add(MethodReturn.VOID);
                return new ByteCodeAppender.Simple(arrayList).apply(methodVisitor, context, methodDescription);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((Appender) obj).instrumentedType);
            }

            public int hashCode() {
                return this.instrumentedType.hashCode() + (getClass().hashCode() * 31);
            }
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(target.getInstrumentedType());
        }

        @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy
        public List<MethodDescription.Token> extractConstructors(TypeDescription typeDescription) {
            ArrayList arrayList = new ArrayList(typeDescription.getRecordComponents().size());
            for (RecordComponentDescription.InDefinedShape inDefinedShape : typeDescription.getRecordComponents()) {
                arrayList.add(new ParameterDescription.Token(inDefinedShape.getType(), inDefinedShape.getDeclaredAnnotations().filter(ElementMatchers.targetsElement(ElementType.CONSTRUCTOR)), inDefinedShape.getActualName(), 0));
            }
            List list = Collections.EMPTY_LIST;
            return Collections.singletonList(new MethodDescription.Token(MethodDescription.CONSTRUCTOR_INTERNAL_NAME, 1, list, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Void.TYPE), arrayList, list, list, AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED));
        }

        @Override // net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy
        public MethodRegistry inject(TypeDescription typeDescription, MethodRegistry methodRegistry) {
            return methodRegistry.prepend(new LatentMatcher.Resolved(ElementMatchers.isConstructor().and(ElementMatchers.takesGenericArguments(typeDescription.getRecordComponents().asTypeList()))), new MethodRegistry.Handler.ForImplementation(this), MethodAttributeAppender.ForInstrumentedMethod.EXCLUDING_RECEIVER, Transformer.NoOp.make());
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            for (RecordComponentDescription.InDefinedShape inDefinedShape : instrumentedType.getRecordComponents()) {
                InstrumentedType instrumentedTypeWithField = instrumentedType.withField(new FieldDescription.Token(inDefinedShape.getActualName(), 18, inDefinedShape.getType(), inDefinedShape.getDeclaredAnnotations().filter(ElementMatchers.targetsElement(ElementType.FIELD))));
                String actualName = inDefinedShape.getActualName();
                List list = Collections.EMPTY_LIST;
                instrumentedType = instrumentedTypeWithField.withMethod(new MethodDescription.Token(actualName, 1, list, inDefinedShape.getType(), list, list, inDefinedShape.getDeclaredAnnotations().filter(ElementMatchers.targetsElement(ElementType.METHOD)), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED));
            }
            return instrumentedType;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'HASH_CODE' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @HashCodeAndEqualsPlugin.Enhance
    public static final class RecordObjectMethod implements Implementation {
        private static final /* synthetic */ RecordObjectMethod[] $VALUES;
        public static final RecordObjectMethod EQUALS;
        public static final RecordObjectMethod HASH_CODE;
        public static final RecordObjectMethod TO_STRING;
        private final List<? extends TypeDescription> arguments;
        private final String name;
        private final TypeDescription returnType;
        private final StackManipulation stackManipulation;

        static {
            StackManipulation.Trivial trivial = StackManipulation.Trivial.INSTANCE;
            RecordObjectMethod recordObjectMethod = new RecordObjectMethod("HASH_CODE", 0, "hashCode", trivial, Integer.TYPE, new Class[0]);
            HASH_CODE = recordObjectMethod;
            RecordObjectMethod recordObjectMethod2 = new RecordObjectMethod("EQUALS", 1, "equals", MethodVariableAccess.REFERENCE.loadFrom(1), Boolean.TYPE, Object.class);
            EQUALS = recordObjectMethod2;
            RecordObjectMethod recordObjectMethod3 = new RecordObjectMethod("TO_STRING", 2, "toString", trivial, String.class, new Class[0]);
            TO_STRING = recordObjectMethod3;
            $VALUES = new RecordObjectMethod[]{recordObjectMethod, recordObjectMethod2, recordObjectMethod3};
        }

        private RecordObjectMethod(String str, int i, String str2, StackManipulation stackManipulation, Class cls, Class... clsArr) {
            this.name = str2;
            this.stackManipulation = stackManipulation;
            this.returnType = TypeDescription.ForLoadedType.of(cls);
            this.arguments = new TypeList.ForLoadedTypes((Class<?>[]) clsArr);
        }

        public static RecordObjectMethod valueOf(String str) {
            return (RecordObjectMethod) Enum.valueOf(RecordObjectMethod.class, str);
        }

        public static RecordObjectMethod[] values() {
            return (RecordObjectMethod[]) $VALUES.clone();
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Implementation.Target target) {
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList = new ArrayList(target.getInstrumentedType().getRecordComponents().size());
            for (RecordComponentDescription.InDefinedShape inDefinedShape : target.getInstrumentedType().getRecordComponents()) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(inDefinedShape.getActualName());
                arrayList.add(JavaConstant.MethodHandle.ofGetter((FieldDescription.InDefinedShape) target.getInstrumentedType().getDeclaredFields().filter(ElementMatchers.named(inDefinedShape.getActualName())).getOnly()));
            }
            return new ByteCodeAppender.Simple(MethodVariableAccess.loadThis(), this.stackManipulation, MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(JavaType.OBJECT_METHODS.getTypeStub(), new MethodDescription.Token("bootstrap", 9, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), Arrays.asList(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().asGenericType(), TypeDescription.ForLoadedType.of(String.class).asGenericType(), JavaType.TYPE_DESCRIPTOR.getTypeStub().asGenericType(), TypeDescription.ForLoadedType.of(Class.class).asGenericType(), TypeDescription.ForLoadedType.of(String.class).asGenericType(), TypeDescription.ArrayProjection.of(JavaType.METHOD_HANDLE.getTypeStub()).asGenericType())))).dynamic(this.name, this.returnType, CompoundList.of(target.getInstrumentedType(), this.arguments), CompoundList.of(Arrays.asList(JavaConstant.Simple.of(target.getInstrumentedType()), JavaConstant.Simple.ofLoaded(sb.toString())), (List) arrayList)), MethodReturn.of(this.returnType));
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }
    }

    static {
        Implementation.Context.Default.Factory.WithFixedSuffix withFixedSuffix;
        AuxiliaryType.NamingStrategy.Suffixing suffixing;
        boolean z6 = false;
        NamingStrategy.Suffixing suffixing2 = null;
        try {
            Class.forName("java.security.AccessController", false, null);
            ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
        } catch (ClassNotFoundException unused) {
            ACCESS_CONTROLLER = z6;
        } catch (SecurityException unused2) {
            z6 = true;
            ACCESS_CONTROLLER = z6;
        }
        String str = (String) doPrivileged(new GetSystemPropertyAction(DEFAULT_NAMING_PROPERTY));
        if (str == null) {
            if (GraalImageCode.getCurrent().isDefined()) {
                suffixing2 = new NamingStrategy.Suffixing(BYTE_BUDDY_DEFAULT_PREFIX, new NamingStrategy.Suffixing.BaseNameResolver.WithCallerSuffix(NamingStrategy.Suffixing.BaseNameResolver.ForUnnamedType.INSTANCE), NamingStrategy.BYTE_BUDDY_RENAME_PACKAGE);
                suffixing = new AuxiliaryType.NamingStrategy.Suffixing(BYTE_BUDDY_DEFAULT_SUFFIX);
                withFixedSuffix = new Implementation.Context.Default.Factory.WithFixedSuffix(BYTE_BUDDY_DEFAULT_CONTEXT_NAME);
            } else {
                suffixing = null;
                withFixedSuffix = null;
            }
        } else if (str.equalsIgnoreCase("fixed")) {
            suffixing2 = new NamingStrategy.Suffixing(BYTE_BUDDY_DEFAULT_PREFIX, NamingStrategy.Suffixing.BaseNameResolver.ForUnnamedType.INSTANCE, NamingStrategy.BYTE_BUDDY_RENAME_PACKAGE);
            suffixing = new AuxiliaryType.NamingStrategy.Suffixing(BYTE_BUDDY_DEFAULT_SUFFIX);
            withFixedSuffix = new Implementation.Context.Default.Factory.WithFixedSuffix(BYTE_BUDDY_DEFAULT_CONTEXT_NAME);
        } else if (str.equalsIgnoreCase("caller")) {
            suffixing2 = new NamingStrategy.Suffixing(BYTE_BUDDY_DEFAULT_PREFIX, new NamingStrategy.Suffixing.BaseNameResolver.WithCallerSuffix(NamingStrategy.Suffixing.BaseNameResolver.ForUnnamedType.INSTANCE), NamingStrategy.BYTE_BUDDY_RENAME_PACKAGE);
            suffixing = new AuxiliaryType.NamingStrategy.Suffixing(BYTE_BUDDY_DEFAULT_SUFFIX);
            withFixedSuffix = new Implementation.Context.Default.Factory.WithFixedSuffix(BYTE_BUDDY_DEFAULT_CONTEXT_NAME);
        } else {
            try {
                NamingStrategy.SuffixingRandom suffixingRandom = new NamingStrategy.SuffixingRandom(BYTE_BUDDY_DEFAULT_PREFIX, NamingStrategy.Suffixing.BaseNameResolver.ForUnnamedType.INSTANCE, NamingStrategy.BYTE_BUDDY_RENAME_PACKAGE, new RandomString(8, new Random(Long.parseLong(str))));
                AuxiliaryType.NamingStrategy.Suffixing suffixing3 = new AuxiliaryType.NamingStrategy.Suffixing(BYTE_BUDDY_DEFAULT_SUFFIX);
                withFixedSuffix = new Implementation.Context.Default.Factory.WithFixedSuffix(BYTE_BUDDY_DEFAULT_CONTEXT_NAME);
                suffixing = suffixing3;
                suffixing2 = suffixingRandom;
            } catch (Exception unused3) {
                throw new IllegalStateException("'net.bytebuddy.naming' is set to an unknown, non-numeric value: ".concat(str));
            }
        }
        DEFAULT_NAMING_STRATEGY = suffixing2;
        DEFAULT_AUXILIARY_NAMING_STRATEGY = suffixing;
        DEFAULT_IMPLEMENTATION_CONTEXT_FACTORY = withFixedSuffix;
    }

    public ByteBuddy() {
        this(ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5));
    }

    @MaybeNull
    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public <T> DynamicType.Builder<T> decorate(Class<T> cls) {
        return decorate(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ByteBuddy byteBuddy = (ByteBuddy) obj;
        return this.annotationRetention.equals(byteBuddy.annotationRetention) && this.typeValidation.equals(byteBuddy.typeValidation) && this.classFileVersion.equals(byteBuddy.classFileVersion) && this.namingStrategy.equals(byteBuddy.namingStrategy) && this.auxiliaryTypeNamingStrategy.equals(byteBuddy.auxiliaryTypeNamingStrategy) && this.annotationValueFilterFactory.equals(byteBuddy.annotationValueFilterFactory) && this.implementationContextFactory.equals(byteBuddy.implementationContextFactory) && this.methodGraphCompiler.equals(byteBuddy.methodGraphCompiler) && this.instrumentedTypeFactory.equals(byteBuddy.instrumentedTypeFactory) && this.ignoredMethods.equals(byteBuddy.ignoredMethods) && this.visibilityBridgeStrategy.equals(byteBuddy.visibilityBridgeStrategy) && this.classWriterStrategy.equals(byteBuddy.classWriterStrategy);
    }

    public int hashCode() {
        return this.classWriterStrategy.hashCode() + ((this.visibilityBridgeStrategy.hashCode() + ((this.typeValidation.hashCode() + ((this.ignoredMethods.hashCode() + ((this.instrumentedTypeFactory.hashCode() + ((this.methodGraphCompiler.hashCode() + ((this.implementationContextFactory.hashCode() + ((this.annotationRetention.hashCode() + ((this.annotationValueFilterFactory.hashCode() + ((this.auxiliaryTypeNamingStrategy.hashCode() + ((this.namingStrategy.hashCode() + ((this.classFileVersion.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public ByteBuddy ignore(ElementMatcher<? super MethodDescription> elementMatcher) {
        return ignore(new LatentMatcher.Resolved(elementMatcher));
    }

    public DynamicType.Builder<? extends Annotation> makeAnnotation() {
        return new SubclassDynamicTypeBuilder(this.instrumentedTypeFactory.subclass(this.namingStrategy.subclass(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Annotation.class)), ModifierContributor.Resolver.of(Visibility.PUBLIC, TypeManifestation.ANNOTATION).resolve(), TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class)).withInterfaces((TypeList.Generic) new TypeList.Generic.Explicit(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Annotation.class))), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, ConstructorStrategy.Default.NO_CONSTRUCTORS);
    }

    public DynamicType.Builder<? extends Enum<?>> makeEnumeration(String... strArr) {
        return makeEnumeration(Arrays.asList(strArr));
    }

    public DynamicType.Builder<?> makeInterface() {
        return makeInterface((Collection<? extends TypeDefinition>) Collections.EMPTY_LIST);
    }

    public DynamicType.Builder<?> makePackage(String str) {
        return new SubclassDynamicTypeBuilder(this.instrumentedTypeFactory.subclass(b.e(str, ".package-info"), PackageDescription.PACKAGE_MODIFIERS, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class)), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, ConstructorStrategy.Default.NO_CONSTRUCTORS);
    }

    public DynamicType.Builder<?> makeRecord() {
        TypeDescription.Generic genericAsGenericType = InstrumentedType.Default.of(JavaType.RECORD.getTypeStub().getName(), TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), Visibility.PUBLIC).withMethod(new MethodDescription.Token(4)).withMethod(new MethodDescription.Token("hashCode", InputDeviceCompat.SOURCE_GAMEPAD, TypeDescription.ForLoadedType.of(Integer.TYPE).asGenericType())).withMethod(new MethodDescription.Token("equals", InputDeviceCompat.SOURCE_GAMEPAD, TypeDescription.ForLoadedType.of(Boolean.TYPE).asGenericType(), Collections.singletonList(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class)))).withMethod(new MethodDescription.Token("toString", InputDeviceCompat.SOURCE_GAMEPAD, TypeDescription.ForLoadedType.of(String.class).asGenericType())).asGenericType();
        return new SubclassDynamicTypeBuilder(this.instrumentedTypeFactory.subclass(this.namingStrategy.subclass(genericAsGenericType), 17, genericAsGenericType).withRecord(true), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, RecordConstructorStrategy.INSTANCE).method(ElementMatchers.isHashCode()).intercept(RecordObjectMethod.HASH_CODE).method(ElementMatchers.isEquals()).intercept(RecordObjectMethod.EQUALS).method(ElementMatchers.isToString()).intercept(RecordObjectMethod.TO_STRING);
    }

    public <T> DynamicType.Builder<T> rebase(Class<T> cls) {
        return rebase(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
    }

    public <T> DynamicType.Builder<T> redefine(Class<T> cls) {
        return redefine(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
    }

    public <T> DynamicType.Builder<T> subclass(Class<T> cls) {
        return (DynamicType.Builder<T>) subclass(TypeDescription.ForLoadedType.of(cls));
    }

    public ByteBuddy with(ClassFileVersion classFileVersion) {
        return new ByteBuddy(classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ByteBuddy(ClassFileVersion classFileVersion) {
        NamingStrategy namingStrategy = DEFAULT_NAMING_STRATEGY;
        NamingStrategy suffixingRandom = namingStrategy == null ? new NamingStrategy.SuffixingRandom(BYTE_BUDDY_DEFAULT_PREFIX) : namingStrategy;
        AuxiliaryType.NamingStrategy namingStrategy2 = DEFAULT_AUXILIARY_NAMING_STRATEGY;
        AuxiliaryType.NamingStrategy suffixingRandom2 = namingStrategy2 == null ? new AuxiliaryType.NamingStrategy.SuffixingRandom(BYTE_BUDDY_DEFAULT_SUFFIX) : namingStrategy2;
        AnnotationValueFilter.Default r6 = AnnotationValueFilter.Default.APPEND_DEFAULTS;
        AnnotationRetention annotationRetention = AnnotationRetention.ENABLED;
        Implementation.Context.Factory factory = DEFAULT_IMPLEMENTATION_CONTEXT_FACTORY;
        this(classFileVersion, suffixingRandom, suffixingRandom2, r6, annotationRetention, factory == null ? Implementation.Context.Default.Factory.INSTANCE : factory, MethodGraph.Compiler.DEFAULT, InstrumentedType.Factory.Default.MODIFIABLE, TypeValidation.ENABLED, VisibilityBridgeStrategy.Default.ALWAYS, ClassWriterStrategy.Default.CONSTANT_POOL_RETAINING, new LatentMatcher.Resolved(ElementMatchers.isSynthetic().or(ElementMatchers.isDefaultFinalizer())));
    }

    public <T> DynamicType.Builder<T> decorate(Class<T> cls, ClassFileLocator classFileLocator) {
        return decorate(TypeDescription.ForLoadedType.of(cls), classFileLocator);
    }

    public ByteBuddy ignore(LatentMatcher<? super MethodDescription> latentMatcher) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, latentMatcher);
    }

    public DynamicType.Builder<? extends Enum<?>> makeEnumeration(Collection<? extends String> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Require at least one enumeration constant");
        }
        TypeDescription.Generic genericBuild = TypeDescription.Generic.Builder.parameterizedType((Class<?>) Enum.class, TargetType.class).build();
        InstrumentedType.Factory factory = this.instrumentedTypeFactory;
        String strSubclass = this.namingStrategy.subclass(genericBuild);
        Visibility visibility = Visibility.PUBLIC;
        DynamicType.Builder builderIntercept = new SubclassDynamicTypeBuilder(factory.subclass(strSubclass, ModifierContributor.Resolver.of(visibility, TypeManifestation.FINAL, EnumerationState.ENUMERATION).resolve(), genericBuild), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, ConstructorStrategy.Default.NO_CONSTRUCTORS).defineConstructor(Visibility.PRIVATE).withParameters(String.class, Integer.TYPE).intercept(SuperMethodCall.INSTANCE);
        Ownership ownership = Ownership.STATIC;
        return builderIntercept.defineMethod("valueOf", TargetType.class, visibility, ownership).withParameters(String.class).intercept(MethodCall.invoke((MethodDescription) genericBuild.getDeclaredMethods().filter(ElementMatchers.named("valueOf").and(ElementMatchers.takesArguments((Class<?>[]) new Class[]{Class.class, String.class}))).getOnly()).withOwnType().withArgument(0).withAssigner(Assigner.DEFAULT, Assigner.Typing.DYNAMIC)).defineMethod("values", TargetType[].class, visibility, ownership).intercept(new EnumerationImplementation(new ArrayList(collection)));
    }

    public <T> DynamicType.Builder<T> makeInterface(Class<T> cls) {
        return (DynamicType.Builder<T>) makeInterface(Collections.singletonList(cls));
    }

    public <T> DynamicType.Builder<T> rebase(Class<T> cls, ClassFileLocator classFileLocator) {
        return rebase(TypeDescription.ForLoadedType.of(cls), classFileLocator);
    }

    public <T> DynamicType.Builder<T> redefine(Class<T> cls, ClassFileLocator classFileLocator) {
        return redefine(TypeDescription.ForLoadedType.of(cls), classFileLocator);
    }

    public <T> DynamicType.Builder<T> subclass(Class<T> cls, ConstructorStrategy constructorStrategy) {
        return (DynamicType.Builder<T>) subclass(TypeDescription.ForLoadedType.of(cls), constructorStrategy);
    }

    public ByteBuddy with(NamingStrategy namingStrategy) {
        return new ByteBuddy(this.classFileVersion, namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    public <T> DynamicType.Builder<T> decorate(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        if (!typeDescription.isArray() && !typeDescription.isPrimitive()) {
            return new DecoratingDynamicTypeBuilder(typeDescription, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.classWriterStrategy, this.ignoredMethods, classFileLocator);
        }
        throw new IllegalArgumentException(a.m("Cannot decorate array or primitive type: ", typeDescription));
    }

    public DynamicType.Builder<?> makeInterface(Type... typeArr) {
        return makeInterface(Arrays.asList(typeArr));
    }

    public <T> DynamicType.Builder<T> rebase(Class<T> cls, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer) {
        return rebase(TypeDescription.ForLoadedType.of(cls), classFileLocator, methodNameTransformer);
    }

    public <T> DynamicType.Builder<T> redefine(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        if (!typeDescription.isArray() && !typeDescription.isPrimitive()) {
            return new RedefinitionDynamicTypeBuilder(this.instrumentedTypeFactory.represent(typeDescription), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, typeDescription, classFileLocator);
        }
        throw new IllegalArgumentException(a.m("Cannot redefine array or primitive type: ", typeDescription));
    }

    public DynamicType.Builder<?> subclass(Type type) {
        return subclass(TypeDefinition.Sort.describe(type));
    }

    public ByteBuddy with(AuxiliaryType.NamingStrategy namingStrategy) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, namingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    public DynamicType.Builder<?> makeInterface(List<? extends Type> list) {
        return makeInterface((Collection<? extends TypeDefinition>) new TypeList.Generic.ForLoadedTypes(list));
    }

    public <T> DynamicType.Builder<T> rebase(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        return rebase(typeDescription, classFileLocator, MethodNameTransformer.Suffixing.withRandomSuffix());
    }

    public DynamicType.Builder<?> subclass(Type type, ConstructorStrategy constructorStrategy) {
        return subclass(TypeDefinition.Sort.describe(type), constructorStrategy);
    }

    public ByteBuddy with(AnnotationValueFilter.Factory factory) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, factory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    public ByteBuddy(ClassFileVersion classFileVersion, NamingStrategy namingStrategy, AuxiliaryType.NamingStrategy namingStrategy2, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, Implementation.Context.Factory factory2, MethodGraph.Compiler compiler, InstrumentedType.Factory factory3, TypeValidation typeValidation, VisibilityBridgeStrategy visibilityBridgeStrategy, ClassWriterStrategy classWriterStrategy, LatentMatcher<? super MethodDescription> latentMatcher) {
        this.classFileVersion = classFileVersion;
        this.namingStrategy = namingStrategy;
        this.auxiliaryTypeNamingStrategy = namingStrategy2;
        this.annotationValueFilterFactory = factory;
        this.annotationRetention = annotationRetention;
        this.implementationContextFactory = factory2;
        this.methodGraphCompiler = compiler;
        this.instrumentedTypeFactory = factory3;
        this.typeValidation = typeValidation;
        this.visibilityBridgeStrategy = visibilityBridgeStrategy;
        this.classWriterStrategy = classWriterStrategy;
        this.ignoredMethods = latentMatcher;
    }

    public DynamicType.Builder<?> makeInterface(TypeDefinition... typeDefinitionArr) {
        return makeInterface((Collection<? extends TypeDefinition>) Arrays.asList(typeDefinitionArr));
    }

    public <T> DynamicType.Builder<T> rebase(TypeDescription typeDescription, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer) {
        if (!typeDescription.isArray() && !typeDescription.isPrimitive()) {
            return new RebaseDynamicTypeBuilder(this.instrumentedTypeFactory.represent(typeDescription), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, typeDescription, classFileLocator, methodNameTransformer);
        }
        throw new IllegalArgumentException(a.m("Cannot rebase array or primitive type: ", typeDescription));
    }

    public DynamicType.Builder<?> subclass(TypeDefinition typeDefinition) {
        return subclass(typeDefinition, ConstructorStrategy.Default.IMITATE_SUPER_CLASS_OPENING);
    }

    public ByteBuddy with(AnnotationRetention annotationRetention) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    public DynamicType.Builder<?> makeInterface(Collection<? extends TypeDefinition> collection) {
        return subclass(Object.class, (ConstructorStrategy) ConstructorStrategy.Default.NO_CONSTRUCTORS).implement(collection).modifiers(TypeManifestation.INTERFACE, Visibility.PUBLIC);
    }

    public DynamicType.Builder<?> subclass(TypeDefinition typeDefinition, ConstructorStrategy constructorStrategy) {
        TypeDescription.Generic genericAsGenericType;
        TypeList.Generic empty;
        if (!typeDefinition.isPrimitive() && !typeDefinition.isArray() && !typeDefinition.isFinal()) {
            if (typeDefinition.isInterface()) {
                genericAsGenericType = TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class);
                empty = new TypeList.Generic.Explicit(typeDefinition);
            } else {
                genericAsGenericType = typeDefinition.asGenericType();
                empty = new TypeList.Generic.Empty();
            }
            return new SubclassDynamicTypeBuilder(this.instrumentedTypeFactory.subclass(this.namingStrategy.subclass(typeDefinition.asGenericType()), ModifierContributor.Resolver.of(Visibility.PUBLIC, TypeManifestation.PLAIN).resolve(typeDefinition.getModifiers()), genericAsGenericType).withInterfaces(empty), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods, constructorStrategy);
        }
        throw new IllegalArgumentException("Cannot subclass primitive, array or final types: " + typeDefinition);
    }

    public ByteBuddy with(Implementation.Context.Factory factory) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, factory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    public ByteBuddy with(MethodGraph.Compiler compiler) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, compiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    public ByteBuddy with(InstrumentedType.Factory factory) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, factory, this.typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    public ByteBuddy with(TypeValidation typeValidation) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, typeValidation, this.visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    public ByteBuddy with(VisibilityBridgeStrategy visibilityBridgeStrategy) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, visibilityBridgeStrategy, this.classWriterStrategy, this.ignoredMethods);
    }

    public ByteBuddy with(ClassWriterStrategy classWriterStrategy) {
        return new ByteBuddy(this.classFileVersion, this.namingStrategy, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.instrumentedTypeFactory, this.typeValidation, this.visibilityBridgeStrategy, classWriterStrategy, this.ignoredMethods);
    }

    public DynamicType.Builder<?> rebase(Package r22, ClassFileLocator classFileLocator) {
        return rebase(new PackageDescription.ForLoadedPackage(r22), classFileLocator);
    }

    public DynamicType.Builder<?> rebase(PackageDescription packageDescription, ClassFileLocator classFileLocator) {
        return rebase(new TypeDescription.ForPackageDescription(packageDescription), classFileLocator);
    }
}
