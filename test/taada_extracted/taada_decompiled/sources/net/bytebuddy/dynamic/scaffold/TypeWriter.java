package net.bytebuddy.dynamic.scaffold;

import B2.b;
import androidx.constraintlayout.core.motion.a;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.RecordComponentList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.TypeResolutionStrategy;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import net.bytebuddy.dynamic.scaffold.TypeInitializer;
import net.bytebuddy.dynamic.scaffold.inline.MethodRebaseResolver;
import net.bytebuddy.dynamic.scaffold.inline.RebaseImplementationTarget;
import net.bytebuddy.dynamic.scaffold.subclass.SubclassImplementationTarget;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.attribute.AnnotationAppender;
import net.bytebuddy.implementation.attribute.AnnotationRetention;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.FieldAttributeAppender;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.implementation.attribute.RecordComponentAttributeAppender;
import net.bytebuddy.implementation.attribute.TypeAttributeAppender;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.jar.asm.ConstantDynamic;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.jar.asm.commons.ClassRemapper;
import net.bytebuddy.jar.asm.commons.Remapper;
import net.bytebuddy.jar.asm.commons.SimpleRemapper;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.nullability.UnknownNull;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
import net.bytebuddy.utility.visitor.ContextClassVisitor;
import net.bytebuddy.utility.visitor.MetadataAwareClassVisitor;

/* JADX INFO: loaded from: classes2.dex */
public interface TypeWriter<T> {
    public static final String DUMP_PROPERTY = "net.bytebuddy.dump";

    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class Default<S> implements TypeWriter<S> {
        private static final boolean ACCESS_CONTROLLER;

        @MaybeNull
        protected static final String DUMP_FOLDER;

        @AlwaysNull
        private static final String NO_REFERENCE;
        protected final AnnotationRetention annotationRetention;
        protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
        protected final AsmVisitorWrapper asmVisitorWrapper;
        protected final AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy;
        protected final List<? extends DynamicType> auxiliaryTypes;
        protected final ClassFileVersion classFileVersion;
        protected final ClassWriterStrategy classWriterStrategy;
        protected final FieldPool fieldPool;
        protected final FieldList<FieldDescription.InDefinedShape> fields;
        protected final Implementation.Context.Factory implementationContextFactory;
        protected final MethodList<?> instrumentedMethods;
        protected final TypeDescription instrumentedType;
        protected final LoadedTypeInitializer loadedTypeInitializer;
        protected final MethodList<?> methods;
        protected final RecordComponentPool recordComponentPool;
        protected final RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponents;
        protected final TypeAttributeAppender typeAttributeAppender;
        protected final TypeInitializer typeInitializer;
        protected final TypePool typePool;
        protected final TypeValidation typeValidation;

        @HashCodeAndEqualsPlugin.Enhance
        public static class ClassDumpAction implements PrivilegedExceptionAction<Void> {

            @AlwaysNull
            private static final Void NOTHING = null;
            private final byte[] binaryRepresentation;
            private final TypeDescription instrumentedType;
            private final boolean original;
            private final long suffix;
            private final String target;

            public interface Dispatcher {

                public enum Disabled implements Dispatcher {
                    INSTANCE;

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ClassDumpAction.Dispatcher
                    public void dump(TypeDescription typeDescription, boolean z6, byte[] bArr) {
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class Enabled implements Dispatcher {
                    private final String folder;
                    private final long timestamp;

                    public Enabled(String str, long j6) {
                        this.folder = str;
                        this.timestamp = j6;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ClassDumpAction.Dispatcher
                    public void dump(TypeDescription typeDescription, boolean z6, byte[] bArr) {
                        try {
                            Default.doPrivileged(new ClassDumpAction(this.folder, typeDescription, z6, this.timestamp, bArr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Enabled enabled = (Enabled) obj;
                        return this.timestamp == enabled.timestamp && this.folder.equals(enabled.folder);
                    }

                    public int hashCode() {
                        int iC = a.c(getClass().hashCode() * 31, 31, this.folder);
                        long j6 = this.timestamp;
                        return iC + ((int) (j6 ^ (j6 >>> 32)));
                    }
                }

                void dump(TypeDescription typeDescription, boolean z6, byte[] bArr);
            }

            public ClassDumpAction(String str, TypeDescription typeDescription, boolean z6, long j6, byte[] bArr) {
                this.target = str;
                this.instrumentedType = typeDescription;
                this.original = z6;
                this.suffix = j6;
                this.binaryRepresentation = bArr;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ClassDumpAction classDumpAction = (ClassDumpAction) obj;
                return this.original == classDumpAction.original && this.suffix == classDumpAction.suffix && this.target.equals(classDumpAction.target) && this.instrumentedType.equals(classDumpAction.instrumentedType) && Arrays.equals(this.binaryRepresentation, classDumpAction.binaryRepresentation);
            }

            public int hashCode() {
                int i = (com.google.protobuf.a.i(this.instrumentedType, a.c(getClass().hashCode() * 31, 31, this.target), 31) + (this.original ? 1 : 0)) * 31;
                long j6 = this.suffix;
                return Arrays.hashCode(this.binaryRepresentation) + ((i + ((int) (j6 ^ (j6 >>> 32)))) * 31);
            }

            @Override // java.security.PrivilegedExceptionAction
            public Void run() throws IOException {
                String str = this.target;
                StringBuilder sb = new StringBuilder();
                sb.append(this.instrumentedType.getName());
                sb.append(this.original ? "-original." : ".");
                sb.append(this.suffix);
                sb.append(".class");
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str, sb.toString()));
                try {
                    fileOutputStream.write(this.binaryRepresentation);
                    return NOTHING;
                } finally {
                    fileOutputStream.close();
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForCreation<U> extends Default<U> {
            private final MethodPool methodPool;

            public class CreationClassVisitor extends MetadataAwareClassVisitor {
                private final Set<String> declaredTypes;
                private final Implementation.Context.ExtractableView implementationContext;
                private final Set<SignatureKey> visitedFields;
                private final Set<SignatureKey> visitedMethods;

                public CreationClassVisitor(ClassVisitor classVisitor, Implementation.Context.ExtractableView extractableView) {
                    super(OpenedClassReader.ASM_API, classVisitor);
                    this.declaredTypes = new HashSet();
                    this.visitedFields = new HashSet();
                    this.visitedMethods = new HashSet();
                    this.implementationContext = extractableView;
                }

                @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                public void onAfterAttributes() {
                    ForCreation forCreation = ForCreation.this;
                    TypeAttributeAppender typeAttributeAppender = forCreation.typeAttributeAppender;
                    ClassVisitor classVisitor = this.cv;
                    TypeDescription typeDescription = forCreation.instrumentedType;
                    typeAttributeAppender.apply(classVisitor, typeDescription, forCreation.annotationValueFilterFactory.on(typeDescription));
                }

                @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                public void onVisitEnd() {
                    for (TypeDescription typeDescription : ForCreation.this.instrumentedType.getDeclaredTypes()) {
                        if (!this.declaredTypes.contains(typeDescription.getInternalName())) {
                            this.cv.visitInnerClass(typeDescription.getInternalName(), typeDescription.isMemberType() ? ForCreation.this.instrumentedType.getInternalName() : Default.NO_REFERENCE, typeDescription.isAnonymousType() ? Default.NO_REFERENCE : typeDescription.getSimpleName(), typeDescription.getModifiers());
                        }
                    }
                    for (FieldDescription.InDefinedShape inDefinedShape : ForCreation.this.fields) {
                        if (!this.visitedFields.contains(new SignatureKey(inDefinedShape.getName(), inDefinedShape.getDescriptor()))) {
                            ForCreation.this.fieldPool.target(inDefinedShape).apply(this.cv, ForCreation.this.annotationValueFilterFactory);
                        }
                    }
                    Iterator<?> it = ForCreation.this.instrumentedMethods.iterator();
                    while (it.hasNext()) {
                        MethodDescription methodDescription = (MethodDescription) it.next();
                        if (!this.visitedMethods.contains(new SignatureKey(methodDescription.getInternalName(), methodDescription.getDescriptor()))) {
                            ForCreation.this.methodPool.target(methodDescription).apply(this.cv, this.implementationContext, ForCreation.this.annotationValueFilterFactory);
                        }
                    }
                    Implementation.Context.ExtractableView extractableView = this.implementationContext;
                    ForCreation forCreation = ForCreation.this;
                    extractableView.drain(new TypeInitializer.Drain.Default(forCreation.instrumentedType, forCreation.methodPool, ForCreation.this.annotationValueFilterFactory), this.cv, ForCreation.this.annotationValueFilterFactory);
                    super.onVisitEnd();
                }

                @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                public FieldVisitor onVisitField(int i, String str, String str2, @MaybeNull String str3, @MaybeNull Object obj) {
                    this.visitedFields.add(new SignatureKey(str, str2));
                    return super.onVisitField(i, str, str2, str3, obj);
                }

                @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                public void onVisitInnerClass(String str, @MaybeNull String str2, @MaybeNull String str3, int i) {
                    this.declaredTypes.add(str);
                    super.onVisitInnerClass(str, str2, str3, i);
                }

                @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                public MethodVisitor onVisitMethod(int i, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                    this.visitedMethods.add(new SignatureKey(str, str2));
                    return super.onVisitMethod(i, str, str2, str3, strArr);
                }
            }

            public class ImplementationContextClassVisitor extends ContextClassVisitor {
                private final Implementation.Context.ExtractableView implementationContext;

                public ImplementationContextClassVisitor(ClassVisitor classVisitor, Implementation.Context.ExtractableView extractableView) {
                    super(classVisitor);
                    this.implementationContext = extractableView;
                }

                @Override // net.bytebuddy.utility.visitor.ContextClassVisitor
                public List<DynamicType> getAuxiliaryTypes() {
                    return CompoundList.of((List) ForCreation.this.auxiliaryTypes, (List) this.implementationContext.getAuxiliaryTypes());
                }

                @Override // net.bytebuddy.utility.visitor.ContextClassVisitor
                public LoadedTypeInitializer getLoadedTypeInitializer() {
                    return ForCreation.this.loadedTypeInitializer;
                }
            }

            public ForCreation(TypeDescription typeDescription, ClassFileVersion classFileVersion, FieldPool fieldPool, MethodPool methodPool, RecordComponentPool recordComponentPool, List<? extends DynamicType> list, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, MethodList<?> methodList2, RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponentList, LoadedTypeInitializer loadedTypeInitializer, TypeInitializer typeInitializer, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool) {
                super(typeDescription, classFileVersion, fieldPool, recordComponentPool, list, fieldList, methodList, methodList2, recordComponentList, loadedTypeInitializer, typeInitializer, typeAttributeAppender, asmVisitorWrapper, factory, annotationRetention, namingStrategy, factory2, typeValidation, classWriterStrategy, typePool);
                this.methodPool = methodPool;
            }

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default
            @SuppressFBWarnings(justification = "Relying on correlated type properties.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public Default<U>.UnresolvedType create(TypeInitializer typeInitializer, ClassDumpAction.Dispatcher dispatcher) {
                int iMergeWriter = this.asmVisitorWrapper.mergeWriter(0);
                int iMergeReader = this.asmVisitorWrapper.mergeReader(0);
                ClassWriter classWriterResolve = this.classWriterStrategy.resolve(iMergeWriter, this.typePool);
                Implementation.Context.Factory factory = this.implementationContextFactory;
                TypeDescription typeDescription = this.instrumentedType;
                AuxiliaryType.NamingStrategy namingStrategy = this.auxiliaryTypeNamingStrategy;
                ClassFileVersion classFileVersion = this.classFileVersion;
                Implementation.Context.ExtractableView extractableViewMake = factory.make(typeDescription, namingStrategy, typeInitializer, classFileVersion, classFileVersion, ((iMergeWriter & 2) == 0 && classFileVersion.isAtLeast(ClassFileVersion.JAVA_V6)) ? (iMergeReader & 8) == 0 ? Implementation.Context.FrameGeneration.GENERATE : Implementation.Context.FrameGeneration.EXPAND : Implementation.Context.FrameGeneration.DISABLED);
                ClassVisitor classVisitorWrap = this.asmVisitorWrapper.wrap(this.instrumentedType, ValidatingClassVisitor.of(classWriterResolve, this.typeValidation), extractableViewMake, this.typePool, this.fields, this.methods, iMergeWriter, iMergeReader);
                classVisitorWrap.visit(this.classFileVersion.getMinorMajorVersion(), this.instrumentedType.getActualModifiers(!r2.isInterface()), this.instrumentedType.getInternalName(), this.instrumentedType.getGenericSignature(), (this.instrumentedType.getSuperClass() == null ? TypeDescription.ForLoadedType.of(Object.class) : this.instrumentedType.getSuperClass().asErasure()).getInternalName(), this.instrumentedType.getInterfaces().asErasures().toInternalNames());
                if (!this.instrumentedType.isNestHost()) {
                    classVisitorWrap.visitNestHost(this.instrumentedType.getNestHost().getInternalName());
                }
                MethodDescription.InDefinedShape enclosingMethod = this.instrumentedType.getEnclosingMethod();
                if (enclosingMethod != null) {
                    classVisitorWrap.visitOuterClass(enclosingMethod.getDeclaringType().getInternalName(), enclosingMethod.getInternalName(), enclosingMethod.getDescriptor());
                } else if (this.instrumentedType.isLocalType() || this.instrumentedType.isAnonymousType()) {
                    classVisitorWrap.visitOuterClass(this.instrumentedType.getEnclosingType().getInternalName(), Default.NO_REFERENCE, Default.NO_REFERENCE);
                }
                TypeAttributeAppender typeAttributeAppender = this.typeAttributeAppender;
                TypeDescription typeDescription2 = this.instrumentedType;
                typeAttributeAppender.apply(classVisitorWrap, typeDescription2, this.annotationValueFilterFactory.on(typeDescription2));
                if (this.instrumentedType.isNestHost()) {
                    Iterator<TypeDescription> it = this.instrumentedType.getNestMembers().filter(ElementMatchers.not(ElementMatchers.is(this.instrumentedType))).iterator();
                    while (it.hasNext()) {
                        classVisitorWrap.visitNestMember(it.next().getInternalName());
                    }
                }
                Iterator<TypeDescription> it2 = this.instrumentedType.getPermittedSubtypes().iterator();
                while (it2.hasNext()) {
                    classVisitorWrap.visitPermittedSubclass(it2.next().getInternalName());
                }
                TypeDescription declaringType = this.instrumentedType.getDeclaringType();
                if (declaringType != null) {
                    classVisitorWrap.visitInnerClass(this.instrumentedType.getInternalName(), declaringType.getInternalName(), this.instrumentedType.getSimpleName(), this.instrumentedType.getModifiers());
                } else if (this.instrumentedType.isLocalType()) {
                    classVisitorWrap.visitInnerClass(this.instrumentedType.getInternalName(), Default.NO_REFERENCE, this.instrumentedType.getSimpleName(), this.instrumentedType.getModifiers());
                } else if (this.instrumentedType.isAnonymousType()) {
                    classVisitorWrap.visitInnerClass(this.instrumentedType.getInternalName(), Default.NO_REFERENCE, Default.NO_REFERENCE, this.instrumentedType.getModifiers());
                }
                for (TypeDescription typeDescription3 : this.instrumentedType.getDeclaredTypes()) {
                    classVisitorWrap.visitInnerClass(typeDescription3.getInternalName(), typeDescription3.isMemberType() ? this.instrumentedType.getInternalName() : Default.NO_REFERENCE, typeDescription3.isAnonymousType() ? Default.NO_REFERENCE : typeDescription3.getSimpleName(), typeDescription3.getModifiers());
                }
                Iterator<RecordComponentDescription.InDefinedShape> it3 = this.recordComponents.iterator();
                while (it3.hasNext()) {
                    this.recordComponentPool.target(it3.next()).apply(classVisitorWrap, this.annotationValueFilterFactory);
                }
                Iterator<FieldDescription.InDefinedShape> it4 = this.fields.iterator();
                while (it4.hasNext()) {
                    this.fieldPool.target(it4.next()).apply(classVisitorWrap, this.annotationValueFilterFactory);
                }
                Iterator<?> it5 = this.instrumentedMethods.iterator();
                while (it5.hasNext()) {
                    this.methodPool.target((MethodDescription) it5.next()).apply(classVisitorWrap, extractableViewMake, this.annotationValueFilterFactory);
                }
                extractableViewMake.drain(new TypeInitializer.Drain.Default(this.instrumentedType, this.methodPool, this.annotationValueFilterFactory), classVisitorWrap, this.annotationValueFilterFactory);
                classVisitorWrap.visitEnd();
                return new UnresolvedType(classWriterResolve.toByteArray(), extractableViewMake.getAuxiliaryTypes());
            }

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.methodPool.equals(((ForCreation) obj).methodPool);
            }

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default
            public int hashCode() {
                return this.methodPool.hashCode() + (super.hashCode() * 31);
            }

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter
            public ContextClassVisitor wrap(ClassVisitor classVisitor, int i, int i3) {
                Implementation.Context.Factory factory = this.implementationContextFactory;
                TypeDescription typeDescription = this.instrumentedType;
                AuxiliaryType.NamingStrategy namingStrategy = this.auxiliaryTypeNamingStrategy;
                TypeInitializer typeInitializer = this.typeInitializer;
                ClassFileVersion classFileVersion = this.classFileVersion;
                Implementation.Context.ExtractableView extractableViewMake = factory.make(typeDescription, namingStrategy, typeInitializer, classFileVersion, classFileVersion, ((i & 2) == 0 && classFileVersion.isAtLeast(ClassFileVersion.JAVA_V6)) ? (i3 & 8) == 0 ? Implementation.Context.FrameGeneration.GENERATE : Implementation.Context.FrameGeneration.EXPAND : Implementation.Context.FrameGeneration.DISABLED);
                return new ImplementationContextClassVisitor(new CreationClassVisitor(this.asmVisitorWrapper.wrap(this.instrumentedType, ValidatingClassVisitor.of(classVisitor, this.typeValidation), extractableViewMake, this.typePool, this.fields, this.methods, this.asmVisitorWrapper.mergeWriter(i), this.asmVisitorWrapper.mergeReader(i3)), extractableViewMake), extractableViewMake);
            }
        }

        public static class SignatureKey {
            private final String descriptor;
            private final String internalName;

            public SignatureKey(String str, String str2) {
                this.internalName = str;
                this.descriptor = str2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj != null && getClass() == obj.getClass()) {
                    SignatureKey signatureKey = (SignatureKey) obj;
                    if (this.internalName.equals(signatureKey.internalName) && this.descriptor.equals(signatureKey.descriptor)) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                return (this.descriptor.hashCode() * 31) + this.internalName.hashCode() + 17;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class UnresolvedType {
            private final List<? extends DynamicType> auxiliaryTypes;
            private final byte[] binaryRepresentation;

            public UnresolvedType(byte[] bArr, List<? extends DynamicType> list) {
                this.binaryRepresentation = bArr;
                this.auxiliaryTypes = list;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                UnresolvedType unresolvedType = (UnresolvedType) obj;
                return Arrays.equals(this.binaryRepresentation, unresolvedType.binaryRepresentation) && this.auxiliaryTypes.equals(unresolvedType.auxiliaryTypes) && Default.this.equals(Default.this);
            }

            public byte[] getBinaryRepresentation() {
                return this.binaryRepresentation;
            }

            public int hashCode() {
                return Default.this.hashCode() + a.d(this.auxiliaryTypes, (Arrays.hashCode(this.binaryRepresentation) + (getClass().hashCode() * 31)) * 31, 31);
            }

            public DynamicType.Unloaded<S> toDynamicType(TypeResolutionStrategy.Resolved resolved) {
                Default r12 = Default.this;
                return new DynamicType.Default.Unloaded(r12.instrumentedType, this.binaryRepresentation, r12.loadedTypeInitializer, CompoundList.of((List) r12.auxiliaryTypes, (List) this.auxiliaryTypes), resolved);
            }
        }

        public static class ValidatingClassVisitor extends ClassVisitor {

            @AlwaysNull
            private static final FieldVisitor IGNORE_FIELD = null;

            @AlwaysNull
            private static final MethodVisitor IGNORE_METHOD = null;
            private static final String NO_PARAMETERS = "()";
            private static final String RETURNS_VOID = "V";
            private static final String STRING_DESCRIPTOR = "Ljava/lang/String;";

            @UnknownNull
            private Constraint constraint;

            public interface Constraint {

                @HashCodeAndEqualsPlugin.Enhance
                public static class Compound implements Constraint {
                    private final List<Constraint> constraints = new ArrayList();

                    public Compound(List<? extends Constraint> list) {
                        for (Constraint constraint : list) {
                            if (constraint instanceof Compound) {
                                this.constraints.addAll(((Compound) constraint).constraints);
                            } else {
                                this.constraints.add(constraint);
                            }
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertAnnotation() {
                        Iterator<Constraint> it = this.constraints.iterator();
                        while (it.hasNext()) {
                            it.next().assertAnnotation();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultMethodCall() {
                        Iterator<Constraint> it = this.constraints.iterator();
                        while (it.hasNext()) {
                            it.next().assertDefaultMethodCall();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultValue(String str) {
                        Iterator<Constraint> it = this.constraints.iterator();
                        while (it.hasNext()) {
                            it.next().assertDefaultValue(str);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDynamicValueInConstantPool() {
                        Iterator<Constraint> it = this.constraints.iterator();
                        while (it.hasNext()) {
                            it.next().assertDynamicValueInConstantPool();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertField(String str, boolean z6, boolean z7, boolean z8, boolean z9) {
                        Iterator<Constraint> it = this.constraints.iterator();
                        while (it.hasNext()) {
                            it.next().assertField(str, z6, z7, z8, z9);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertHandleInConstantPool() {
                        Iterator<Constraint> it = this.constraints.iterator();
                        while (it.hasNext()) {
                            it.next().assertHandleInConstantPool();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertInvokeDynamic() {
                        Iterator<Constraint> it = this.constraints.iterator();
                        while (it.hasNext()) {
                            it.next().assertInvokeDynamic();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethod(String str, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13) {
                        Iterator<Constraint> it = this.constraints.iterator();
                        while (it.hasNext()) {
                            it.next().assertMethod(str, z6, z7, z8, z9, z10, z11, z12, z13);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethodTypeInConstantPool() {
                        Iterator<Constraint> it = this.constraints.iterator();
                        while (it.hasNext()) {
                            it.next().assertMethodTypeInConstantPool();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertNestMate() {
                        Iterator<Constraint> it = this.constraints.iterator();
                        while (it.hasNext()) {
                            it.next().assertNestMate();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertPermittedSubclass() {
                        Iterator<Constraint> it = this.constraints.iterator();
                        while (it.hasNext()) {
                            it.next().assertPermittedSubclass();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertRecord() {
                        Iterator<Constraint> it = this.constraints.iterator();
                        while (it.hasNext()) {
                            it.next().assertRecord();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertSubRoutine() {
                        Iterator<Constraint> it = this.constraints.iterator();
                        while (it.hasNext()) {
                            it.next().assertSubRoutine();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertType(int i, boolean z6, boolean z7) {
                        Iterator<Constraint> it = this.constraints.iterator();
                        while (it.hasNext()) {
                            it.next().assertType(i, z6, z7);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeAnnotation() {
                        Iterator<Constraint> it = this.constraints.iterator();
                        while (it.hasNext()) {
                            it.next().assertTypeAnnotation();
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeInConstantPool() {
                        Iterator<Constraint> it = this.constraints.iterator();
                        while (it.hasNext()) {
                            it.next().assertTypeInConstantPool();
                        }
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.constraints.equals(((Compound) obj).constraints);
                    }

                    public int hashCode() {
                        return this.constraints.hashCode() + (getClass().hashCode() * 31);
                    }
                }

                public enum ForAnnotation implements Constraint {
                    CLASSIC(true),
                    JAVA_8(false);

                    private final boolean classic;

                    ForAnnotation(boolean z6) {
                        this.classic = z6;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultMethodCall() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultValue(String str) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDynamicValueInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertField(String str, boolean z6, boolean z7, boolean z8, boolean z9) {
                        if (!z7 || !z6 || !z8) {
                            throw new IllegalStateException(a.q("Cannot only define public, static, final field '", str, "' for interface type"));
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertHandleInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertInvokeDynamic() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethod(String str, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13) {
                        if (str.equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME)) {
                            return;
                        }
                        if (z11) {
                            throw new IllegalStateException("Cannot define constructor for interface type");
                        }
                        if (this.classic && !z10) {
                            throw new IllegalStateException(a.q("Cannot define non-virtual method '", str, "' for a pre-Java 8 annotation type"));
                        }
                        if (!z9 && z12) {
                            throw new IllegalStateException(a.q("Cannot define method '", str, "' with the given signature as an annotation type method"));
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethodTypeInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertNestMate() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertPermittedSubclass() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertRecord() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertSubRoutine() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertType(int i, boolean z6, boolean z7) {
                        if ((i & 512) == 0) {
                            throw new IllegalStateException("Cannot define annotation type without interface modifier");
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeInConstantPool() {
                    }
                }

                public enum ForClass implements Constraint {
                    MANIFEST(true),
                    ABSTRACT(false);

                    private final boolean manifestType;

                    ForClass(boolean z6) {
                        this.manifestType = z6;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultMethodCall() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultValue(String str) {
                        throw new IllegalStateException(a.q("Cannot define default value for '", str, "' for non-annotation type"));
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDynamicValueInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertField(String str, boolean z6, boolean z7, boolean z8, boolean z9) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertHandleInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertInvokeDynamic() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethod(String str, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13) {
                        if (z6 && this.manifestType) {
                            throw new IllegalStateException(a.q("Cannot define abstract method '", str, "' for non-abstract class"));
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethodTypeInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertNestMate() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertPermittedSubclass() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertRecord() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertSubRoutine() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertType(int i, boolean z6, boolean z7) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeInConstantPool() {
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class ForClassFileVersion implements Constraint {
                    private final ClassFileVersion classFileVersion;

                    public ForClassFileVersion(ClassFileVersion classFileVersion) {
                        this.classFileVersion = classFileVersion;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertAnnotation() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot write annotations for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultMethodCall() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V8)) {
                            throw new IllegalStateException("Cannot invoke default method for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultValue(String str) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDynamicValueInConstantPool() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V11)) {
                            throw new IllegalStateException("Cannot write dynamic constant for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertField(String str, boolean z6, boolean z7, boolean z8, boolean z9) {
                        if (!z9 || this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V4)) {
                            return;
                        }
                        StringBuilder sbM = b.m("Cannot define generic field '", str, "' for class file version ");
                        sbM.append(this.classFileVersion);
                        throw new IllegalStateException(sbM.toString());
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertHandleInConstantPool() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V7)) {
                            throw new IllegalStateException("Cannot write method handle to constant pool for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertInvokeDynamic() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V7)) {
                            throw new IllegalStateException("Cannot write invoke dynamic instruction for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethod(String str, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13) {
                        if (z13 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V4)) {
                            StringBuilder sbM = b.m("Cannot define generic method '", str, "' for class file version ");
                            sbM.append(this.classFileVersion);
                            throw new IllegalStateException(sbM.toString());
                        }
                        if (!z10 && z6) {
                            throw new IllegalStateException(a.q("Cannot define static or non-virtual method '", str, "' to be abstract"));
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethodTypeInConstantPool() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V7)) {
                            throw new IllegalStateException("Cannot write method type to constant pool for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertNestMate() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V11)) {
                            throw new IllegalStateException("Cannot define nest mate for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertPermittedSubclass() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V17)) {
                            throw new IllegalStateException("Cannot define permitted subclasses for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertRecord() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V14)) {
                            throw new IllegalStateException("Cannot define record for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertSubRoutine() {
                        if (this.classFileVersion.isGreaterThan(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot write subroutine for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertType(int i, boolean z6, boolean z7) {
                        if ((i & 8192) != 0 && !this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot define annotation type for class file version " + this.classFileVersion);
                        }
                        if (!z7 || this.classFileVersion.isAtLeast(ClassFileVersion.JAVA_V4)) {
                            return;
                        }
                        throw new IllegalStateException("Cannot define a generic type for class file version " + this.classFileVersion);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeAnnotation() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot write type annotations for class file version " + this.classFileVersion);
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeInConstantPool() {
                        if (this.classFileVersion.isLessThan(ClassFileVersion.JAVA_V5)) {
                            throw new IllegalStateException("Cannot write type to constant pool for class file version " + this.classFileVersion);
                        }
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.classFileVersion.equals(((ForClassFileVersion) obj).classFileVersion);
                    }

                    public int hashCode() {
                        return this.classFileVersion.hashCode() + (getClass().hashCode() * 31);
                    }
                }

                public enum ForInterface implements Constraint {
                    CLASSIC(true),
                    JAVA_8(false);

                    private final boolean classic;

                    ForInterface(boolean z6) {
                        this.classic = z6;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultMethodCall() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultValue(String str) {
                        throw new IllegalStateException(a.q("Cannot define default value for '", str, "' for non-annotation type"));
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDynamicValueInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertField(String str, boolean z6, boolean z7, boolean z8, boolean z9) {
                        if (!z7 || !z6 || !z8) {
                            throw new IllegalStateException(a.q("Cannot only define public, static, final field '", str, "' for interface type"));
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertHandleInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertInvokeDynamic() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethod(String str, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13) {
                        if (str.equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME)) {
                            return;
                        }
                        if (z11) {
                            throw new IllegalStateException("Cannot define constructor for interface type");
                        }
                        boolean z14 = this.classic;
                        if (z14 && !z7) {
                            throw new IllegalStateException(a.q("Cannot define non-public method '", str, "' for interface type"));
                        }
                        if (z14 && !z10) {
                            throw new IllegalStateException(a.q("Cannot define non-virtual method '", str, "' for a pre-Java 8 interface type"));
                        }
                        if (z14 && !z6) {
                            throw new IllegalStateException(a.q("Cannot define default method '", str, "' for pre-Java 8 interface type"));
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethodTypeInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertNestMate() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertPermittedSubclass() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertRecord() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertSubRoutine() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertType(int i, boolean z6, boolean z7) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeInConstantPool() {
                    }
                }

                public enum ForPackageType implements Constraint {
                    INSTANCE;

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultMethodCall() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultValue(String str) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDynamicValueInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertField(String str, boolean z6, boolean z7, boolean z8, boolean z9) {
                        throw new IllegalStateException("Cannot define a field for a package description type");
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertHandleInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertInvokeDynamic() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethod(String str, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13) {
                        throw new IllegalStateException("Cannot define a method for a package description type");
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethodTypeInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertNestMate() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertPermittedSubclass() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertRecord() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertSubRoutine() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertType(int i, boolean z6, boolean z7) {
                        if (i != 5632) {
                            throw new IllegalStateException("A package description type must define 5632 as modifier");
                        }
                        if (z6) {
                            throw new IllegalStateException("Cannot implement interface for package type");
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeInConstantPool() {
                    }
                }

                public enum ForRecord implements Constraint {
                    INSTANCE;

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultMethodCall() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDefaultValue(String str) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertDynamicValueInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertField(String str, boolean z6, boolean z7, boolean z8, boolean z9) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertHandleInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertInvokeDynamic() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethod(String str, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13) {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertMethodTypeInConstantPool() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertNestMate() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertPermittedSubclass() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertRecord() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertSubRoutine() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertType(int i, boolean z6, boolean z7) {
                        if ((i & 1024) != 0) {
                            throw new IllegalStateException("Cannot define a record class as abstract");
                        }
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeAnnotation() {
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ValidatingClassVisitor.Constraint
                    public void assertTypeInConstantPool() {
                    }
                }

                void assertAnnotation();

                void assertDefaultMethodCall();

                void assertDefaultValue(String str);

                void assertDynamicValueInConstantPool();

                void assertField(String str, boolean z6, boolean z7, boolean z8, boolean z9);

                void assertHandleInConstantPool();

                void assertInvokeDynamic();

                void assertMethod(String str, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13);

                void assertMethodTypeInConstantPool();

                void assertNestMate();

                void assertPermittedSubclass();

                void assertRecord();

                void assertSubRoutine();

                void assertType(int i, boolean z6, boolean z7);

                void assertTypeAnnotation();

                void assertTypeInConstantPool();
            }

            public class ValidatingFieldVisitor extends FieldVisitor {
                public ValidatingFieldVisitor(FieldVisitor fieldVisitor) {
                    super(OpenedClassReader.ASM_API, fieldVisitor);
                }

                @Override // net.bytebuddy.jar.asm.FieldVisitor
                public AnnotationVisitor visitAnnotation(String str, boolean z6) {
                    ValidatingClassVisitor.this.constraint.assertAnnotation();
                    return super.visitAnnotation(str, z6);
                }
            }

            public class ValidatingMethodVisitor extends MethodVisitor {
                private final String name;

                public ValidatingMethodVisitor(MethodVisitor methodVisitor, String str) {
                    super(OpenedClassReader.ASM_API, methodVisitor);
                    this.name = str;
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                @MaybeNull
                public AnnotationVisitor visitAnnotation(String str, boolean z6) {
                    ValidatingClassVisitor.this.constraint.assertAnnotation();
                    return super.visitAnnotation(str, z6);
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                @MaybeNull
                public AnnotationVisitor visitAnnotationDefault() {
                    ValidatingClassVisitor.this.constraint.assertDefaultValue(this.name);
                    return super.visitAnnotationDefault();
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
                    ValidatingClassVisitor.this.constraint.assertInvokeDynamic();
                    for (Object obj : objArr) {
                        if (obj instanceof ConstantDynamic) {
                            ValidatingClassVisitor.this.constraint.assertDynamicValueInConstantPool();
                        }
                    }
                    super.visitInvokeDynamicInsn(str, str2, handle, objArr);
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitJumpInsn(int i, Label label) {
                    if (i == 168) {
                        ValidatingClassVisitor.this.constraint.assertSubRoutine();
                    }
                    super.visitJumpInsn(i, label);
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                @SuppressFBWarnings(justification = "Fall through to default case is intentional.", value = {"SF_SWITCH_NO_DEFAULT"})
                public void visitLdcInsn(Object obj) {
                    if (obj instanceof Type) {
                        switch (((Type) obj).getSort()) {
                            case 9:
                            case 10:
                                ValidatingClassVisitor.this.constraint.assertTypeInConstantPool();
                                break;
                            case 11:
                                ValidatingClassVisitor.this.constraint.assertMethodTypeInConstantPool();
                                break;
                        }
                    } else if (obj instanceof Handle) {
                        ValidatingClassVisitor.this.constraint.assertHandleInConstantPool();
                    } else if (obj instanceof ConstantDynamic) {
                        ValidatingClassVisitor.this.constraint.assertDynamicValueInConstantPool();
                    }
                    super.visitLdcInsn(obj);
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitMethodInsn(int i, String str, String str2, String str3, boolean z6) {
                    if (z6 && i == 183) {
                        ValidatingClassVisitor.this.constraint.assertDefaultMethodCall();
                    }
                    super.visitMethodInsn(i, str, str2, str3, z6);
                }
            }

            public ValidatingClassVisitor(ClassVisitor classVisitor) {
                super(OpenedClassReader.ASM_API, classVisitor);
            }

            public static ClassVisitor of(ClassVisitor classVisitor, TypeValidation typeValidation) {
                return typeValidation.isEnabled() ? new ValidatingClassVisitor(classVisitor) : classVisitor;
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visit(int i, int i3, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                boolean z6;
                ClassFileVersion classFileVersionOfMinorMajor = ClassFileVersion.ofMinorMajor(i);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Constraint.ForClassFileVersion(classFileVersionOfMinorMajor));
                if (str.endsWith("/package-info")) {
                    arrayList.add(Constraint.ForPackageType.INSTANCE);
                } else if ((i3 & 8192) != 0) {
                    if (!classFileVersionOfMinorMajor.isAtLeast(ClassFileVersion.JAVA_V5)) {
                        throw new IllegalStateException("Cannot define an annotation type for class file version " + classFileVersionOfMinorMajor);
                    }
                    arrayList.add(classFileVersionOfMinorMajor.isAtLeast(ClassFileVersion.JAVA_V8) ? Constraint.ForAnnotation.JAVA_8 : Constraint.ForAnnotation.CLASSIC);
                } else if ((i3 & 512) != 0) {
                    arrayList.add(classFileVersionOfMinorMajor.isAtLeast(ClassFileVersion.JAVA_V8) ? Constraint.ForInterface.JAVA_8 : Constraint.ForInterface.CLASSIC);
                } else if ((i3 & 1024) != 0) {
                    arrayList.add(Constraint.ForClass.ABSTRACT);
                } else {
                    arrayList.add(Constraint.ForClass.MANIFEST);
                }
                if ((65536 & i3) != 0) {
                    arrayList.add(Constraint.ForRecord.INSTANCE);
                    z6 = true;
                } else {
                    z6 = false;
                }
                Constraint.Compound compound = new Constraint.Compound(arrayList);
                this.constraint = compound;
                compound.assertType(i3, strArr != null, str2 != null);
                if (z6) {
                    this.constraint.assertRecord();
                }
                super.visit(i, i3, str, str2, str3, strArr);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            @MaybeNull
            public AnnotationVisitor visitAnnotation(String str, boolean z6) {
                this.constraint.assertAnnotation();
                return super.visitAnnotation(str, z6);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            @MaybeNull
            public FieldVisitor visitField(int i, String str, String str2, @MaybeNull String str3, @MaybeNull Object obj) {
                boolean z6;
                boolean z7;
                boolean z8;
                Class cls;
                int i3;
                int i4;
                if (obj != null) {
                    char cCharAt = str2.charAt(0);
                    if (cCharAt == 'F') {
                        cls = Float.class;
                    } else if (cCharAt == 'S' || cCharAt == 'Z' || cCharAt == 'I') {
                        cls = Integer.class;
                    } else if (cCharAt != 'J') {
                        switch (cCharAt) {
                            case 'B':
                            case 'C':
                                cls = Integer.class;
                                break;
                            case 'D':
                                cls = Double.class;
                                break;
                            default:
                                if (!str2.equals(STRING_DESCRIPTOR)) {
                                    throw new IllegalStateException(a.p("Cannot define a default value for type of field ", str));
                                }
                                cls = String.class;
                                break;
                                break;
                        }
                    } else {
                        cls = Long.class;
                    }
                    if (!cls.isInstance(obj)) {
                        throw new IllegalStateException("Field " + str + " defines an incompatible default value " + obj);
                    }
                    if (cls == Integer.class) {
                        char cCharAt2 = str2.charAt(0);
                        if (cCharAt2 != 'B') {
                            if (cCharAt2 == 'C') {
                                i4 = 65535;
                            } else if (cCharAt2 == 'S') {
                                i3 = -32768;
                                i4 = Advice.MethodSizeHandler.UNDEFINED_SIZE;
                            } else if (cCharAt2 != 'Z') {
                                i3 = Integer.MIN_VALUE;
                                i4 = Integer.MAX_VALUE;
                            } else {
                                i4 = 1;
                            }
                            i3 = 0;
                        } else {
                            i3 = -128;
                            i4 = 127;
                        }
                        Integer num = (Integer) obj;
                        if (num.intValue() < i3 || num.intValue() > i4) {
                            throw new IllegalStateException("Field " + str + " defines an incompatible default value " + obj);
                        }
                    }
                }
                boolean z9 = true;
                Constraint constraint = this.constraint;
                if ((i & 1) != 0) {
                    z6 = true;
                } else {
                    z6 = true;
                    z9 = false;
                }
                if ((i & 8) != 0) {
                    z7 = z6;
                } else {
                    z7 = z6;
                    z6 = false;
                }
                if ((i & 16) != 0) {
                    z8 = z7;
                } else {
                    z8 = z7;
                    z7 = false;
                }
                if (str3 == null) {
                    z8 = false;
                }
                constraint.assertField(str, z9, z6, z7, z8);
                FieldVisitor fieldVisitorVisitField = super.visitField(i, str, str2, str3, obj);
                return fieldVisitorVisitField == null ? IGNORE_FIELD : new ValidatingFieldVisitor(fieldVisitorVisitField);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            @MaybeNull
            public MethodVisitor visitMethod(int i, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                boolean z6;
                boolean z7;
                boolean z8;
                boolean z9;
                boolean z10;
                boolean z11;
                Constraint constraint = this.constraint;
                boolean z12 = false;
                boolean z13 = true;
                if ((i & 1024) != 0) {
                    z6 = false;
                    z12 = true;
                } else {
                    z6 = false;
                }
                if ((i & 1) != 0) {
                    z7 = true;
                } else {
                    z7 = true;
                    z13 = z6;
                }
                if ((i & 2) != 0) {
                    z8 = z7;
                } else {
                    z8 = z7;
                    z7 = z6;
                }
                if ((i & 8) != 0) {
                    z9 = z8;
                } else {
                    z9 = z8;
                    z8 = z6;
                }
                if (str.equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME) || str.equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME) || (i & 10) != 0) {
                    z10 = z9;
                    z9 = z6;
                } else {
                    z10 = z9;
                }
                boolean zEquals = str.equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME);
                if (!str2.startsWith(NO_PARAMETERS) || str2.endsWith(RETURNS_VOID)) {
                    z11 = z10;
                } else {
                    z11 = z10;
                    z10 = z6;
                }
                if (str3 == null) {
                    z11 = z6;
                }
                constraint.assertMethod(str, z12, z13, z7, z8, z9, zEquals, z10, z11);
                MethodVisitor methodVisitorVisitMethod = super.visitMethod(i, str, str2, str3, strArr);
                return methodVisitorVisitMethod == null ? IGNORE_METHOD : new ValidatingMethodVisitor(methodVisitorVisitMethod, str);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visitNestHost(String str) {
                this.constraint.assertNestMate();
                super.visitNestHost(str);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visitNestMember(String str) {
                this.constraint.assertNestMate();
                super.visitNestMember(str);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visitPermittedSubclass(String str) {
                this.constraint.assertPermittedSubclass();
                super.visitPermittedSubclass(str);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            @MaybeNull
            public AnnotationVisitor visitTypeAnnotation(int i, @MaybeNull TypePath typePath, String str, boolean z6) {
                this.constraint.assertTypeAnnotation();
                return super.visitTypeAnnotation(i, typePath, str, z6);
            }
        }

        static {
            boolean z6 = false;
            String str = null;
            try {
                Class.forName("java.security.AccessController", false, null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = z6;
            } catch (SecurityException unused2) {
                z6 = true;
                ACCESS_CONTROLLER = z6;
            }
            NO_REFERENCE = null;
            try {
                str = (String) doPrivileged(new GetSystemPropertyAction(TypeWriter.DUMP_PROPERTY));
            } catch (RuntimeException unused3) {
            }
            DUMP_FOLDER = str;
        }

        public Default(TypeDescription typeDescription, ClassFileVersion classFileVersion, FieldPool fieldPool, RecordComponentPool recordComponentPool, List<? extends DynamicType> list, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, MethodList<?> methodList2, RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponentList, LoadedTypeInitializer loadedTypeInitializer, TypeInitializer typeInitializer, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool) {
            this.instrumentedType = typeDescription;
            this.classFileVersion = classFileVersion;
            this.fieldPool = fieldPool;
            this.recordComponentPool = recordComponentPool;
            this.auxiliaryTypes = list;
            this.fields = fieldList;
            this.methods = methodList;
            this.instrumentedMethods = methodList2;
            this.recordComponents = recordComponentList;
            this.loadedTypeInitializer = loadedTypeInitializer;
            this.typeInitializer = typeInitializer;
            this.typeAttributeAppender = typeAttributeAppender;
            this.asmVisitorWrapper = asmVisitorWrapper;
            this.auxiliaryTypeNamingStrategy = namingStrategy;
            this.annotationValueFilterFactory = factory;
            this.annotationRetention = annotationRetention;
            this.implementationContextFactory = factory2;
            this.typeValidation = typeValidation;
            this.classWriterStrategy = classWriterStrategy;
            this.typePool = typePool;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static <U> TypeWriter<U> forCreation(MethodRegistry.Compiled compiled, List<? extends DynamicType> list, FieldPool fieldPool, RecordComponentPool recordComponentPool, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool) {
            return new ForCreation(compiled.getInstrumentedType(), classFileVersion, fieldPool, compiled, recordComponentPool, list, compiled.getInstrumentedType().getDeclaredFields(), compiled.getMethods(), compiled.getInstrumentedMethods(), compiled.getInstrumentedType().getRecordComponents(), compiled.getLoadedTypeInitializer(), compiled.getTypeInitializer(), typeAttributeAppender, asmVisitorWrapper, factory, annotationRetention, namingStrategy, factory2, typeValidation, classWriterStrategy, typePool);
        }

        public static <U> TypeWriter<U> forDecoration(TypeDescription typeDescription, ClassFileVersion classFileVersion, List<? extends DynamicType> list, List<? extends MethodDescription> list2, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, ClassFileLocator classFileLocator) {
            return new ForInlining.WithDecorationOnly(typeDescription, classFileVersion, list, new MethodList.Explicit(list2), typeAttributeAppender, asmVisitorWrapper, factory, annotationRetention, namingStrategy, factory2, typeValidation, classWriterStrategy, typePool, classFileLocator);
        }

        public static <U> TypeWriter<U> forRebasing(MethodRegistry.Prepared prepared, List<? extends DynamicType> list, FieldPool fieldPool, RecordComponentPool recordComponentPool, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, TypeDescription typeDescription, ClassFileLocator classFileLocator, MethodRebaseResolver methodRebaseResolver) {
            return new ForInlining.WithFullProcessing(prepared.getInstrumentedType(), classFileVersion, fieldPool, recordComponentPool, CompoundList.of((List) list, (List) methodRebaseResolver.getAuxiliaryTypes()), prepared.getInstrumentedType().getDeclaredFields(), prepared.getMethods(), prepared.getInstrumentedMethods(), prepared.getInstrumentedType().getRecordComponents(), prepared.getLoadedTypeInitializer(), prepared.getTypeInitializer(), typeAttributeAppender, asmVisitorWrapper, factory, annotationRetention, namingStrategy, factory2, typeValidation, classWriterStrategy, typePool, typeDescription, classFileLocator, prepared, new RebaseImplementationTarget.Factory(methodRebaseResolver), methodRebaseResolver);
        }

        public static <U> TypeWriter<U> forRedefinition(MethodRegistry.Prepared prepared, List<? extends DynamicType> list, FieldPool fieldPool, RecordComponentPool recordComponentPool, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
            return new ForInlining.WithFullProcessing(prepared.getInstrumentedType(), classFileVersion, fieldPool, recordComponentPool, list, prepared.getInstrumentedType().getDeclaredFields(), prepared.getMethods(), prepared.getInstrumentedMethods(), prepared.getInstrumentedType().getRecordComponents(), prepared.getLoadedTypeInitializer(), prepared.getTypeInitializer(), typeAttributeAppender, asmVisitorWrapper, factory, annotationRetention, namingStrategy, factory2, typeValidation, classWriterStrategy, typePool, typeDescription, classFileLocator, prepared, SubclassImplementationTarget.Factory.LEVEL_TYPE, MethodRebaseResolver.Disabled.INSTANCE);
        }

        public abstract Default<S>.UnresolvedType create(TypeInitializer typeInitializer, ClassDumpAction.Dispatcher dispatcher);

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Default r52 = (Default) obj;
            return this.annotationRetention.equals(r52.annotationRetention) && this.typeValidation.equals(r52.typeValidation) && this.instrumentedType.equals(r52.instrumentedType) && this.classFileVersion.equals(r52.classFileVersion) && this.fieldPool.equals(r52.fieldPool) && this.recordComponentPool.equals(r52.recordComponentPool) && this.auxiliaryTypes.equals(r52.auxiliaryTypes) && this.fields.equals(r52.fields) && this.methods.equals(r52.methods) && this.instrumentedMethods.equals(r52.instrumentedMethods) && this.recordComponents.equals(r52.recordComponents) && this.loadedTypeInitializer.equals(r52.loadedTypeInitializer) && this.typeInitializer.equals(r52.typeInitializer) && this.typeAttributeAppender.equals(r52.typeAttributeAppender) && this.asmVisitorWrapper.equals(r52.asmVisitorWrapper) && this.annotationValueFilterFactory.equals(r52.annotationValueFilterFactory) && this.auxiliaryTypeNamingStrategy.equals(r52.auxiliaryTypeNamingStrategy) && this.implementationContextFactory.equals(r52.implementationContextFactory) && this.classWriterStrategy.equals(r52.classWriterStrategy) && this.typePool.equals(r52.typePool);
        }

        public int hashCode() {
            return this.typePool.hashCode() + ((this.classWriterStrategy.hashCode() + ((this.typeValidation.hashCode() + ((this.implementationContextFactory.hashCode() + ((this.auxiliaryTypeNamingStrategy.hashCode() + ((this.annotationRetention.hashCode() + ((this.annotationValueFilterFactory.hashCode() + ((this.asmVisitorWrapper.hashCode() + ((this.typeAttributeAppender.hashCode() + ((this.typeInitializer.hashCode() + ((this.loadedTypeInitializer.hashCode() + ((this.recordComponents.hashCode() + ((this.instrumentedMethods.hashCode() + ((this.methods.hashCode() + ((this.fields.hashCode() + a.d(this.auxiliaryTypes, (this.recordComponentPool.hashCode() + ((this.fieldPool.hashCode() + ((this.classFileVersion.hashCode() + com.google.protobuf.a.i(this.instrumentedType, getClass().hashCode() * 31, 31)) * 31)) * 31)) * 31, 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        @Override // net.bytebuddy.dynamic.scaffold.TypeWriter
        @SuppressFBWarnings(justification = "Setting a debugging property should never change the program outcome.", value = {"REC_CATCH_EXCEPTION"})
        public DynamicType.Unloaded<S> make(TypeResolutionStrategy.Resolved resolved) {
            String str = DUMP_FOLDER;
            ClassDumpAction.Dispatcher enabled = str == null ? ClassDumpAction.Dispatcher.Disabled.INSTANCE : new ClassDumpAction.Dispatcher.Enabled(str, System.currentTimeMillis());
            Default<S>.UnresolvedType unresolvedTypeCreate = create(resolved.injectedInto(this.typeInitializer), enabled);
            enabled.dump(this.instrumentedType, false, unresolvedTypeCreate.getBinaryRepresentation());
            return unresolvedTypeCreate.toDynamicType(resolved);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @AccessControllerPlugin.Enhance
        public static <T> T doPrivileged(PrivilegedExceptionAction<T> privilegedExceptionAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedExceptionAction) : privilegedExceptionAction.run();
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class ForInlining<U> extends Default<U> {

            @AlwaysNull
            private static final AnnotationVisitor IGNORE_ANNOTATION = null;

            @AlwaysNull
            private static final FieldVisitor IGNORE_FIELD = null;

            @AlwaysNull
            private static final MethodVisitor IGNORE_METHOD = null;

            @AlwaysNull
            private static final RecordComponentVisitor IGNORE_RECORD_COMPONENT = null;
            protected final ClassFileLocator classFileLocator;
            protected final TypeDescription originalType;

            public static class ContextRegistry {

                @UnknownNull
                private Implementation.Context.ExtractableView implementationContext;

                @SuppressFBWarnings(justification = "Lazy value definition is intended.", value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"})
                public List<DynamicType> getAuxiliaryTypes() {
                    return this.implementationContext.getAuxiliaryTypes();
                }

                public void setImplementationContext(Implementation.Context.ExtractableView extractableView) {
                    this.implementationContext = extractableView;
                }
            }

            public class RegistryContextClassVisitor extends ContextClassVisitor {
                private final ContextRegistry contextRegistry;

                public RegistryContextClassVisitor(ClassVisitor classVisitor, ContextRegistry contextRegistry) {
                    super(classVisitor);
                    this.contextRegistry = contextRegistry;
                }

                @Override // net.bytebuddy.utility.visitor.ContextClassVisitor
                public List<DynamicType> getAuxiliaryTypes() {
                    return CompoundList.of((List) ForInlining.this.auxiliaryTypes, (List) this.contextRegistry.getAuxiliaryTypes());
                }

                @Override // net.bytebuddy.utility.visitor.ContextClassVisitor
                public LoadedTypeInitializer getLoadedTypeInitializer() {
                    return ForInlining.this.loadedTypeInitializer;
                }
            }

            public static class WithDecorationOnly<V> extends ForInlining<V> {

                @SuppressFBWarnings(justification = "Field access order is implied by ASM.", value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"})
                public class DecorationClassVisitor extends MetadataAwareClassVisitor implements TypeInitializer.Drain {
                    private final ContextRegistry contextRegistry;

                    @UnknownNull
                    private Implementation.Context.ExtractableView implementationContext;
                    private final int readerFlags;
                    private final int writerFlags;

                    public DecorationClassVisitor(ClassVisitor classVisitor, ContextRegistry contextRegistry, int i, int i3) {
                        super(OpenedClassReader.ASM_API, classVisitor);
                        this.contextRegistry = contextRegistry;
                        this.writerFlags = i;
                        this.readerFlags = i3;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeInitializer.Drain
                    public void apply(ClassVisitor classVisitor, TypeInitializer typeInitializer, Implementation.Context context) {
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    public void onAfterAttributes() {
                        WithDecorationOnly withDecorationOnly = WithDecorationOnly.this;
                        TypeAttributeAppender typeAttributeAppender = withDecorationOnly.typeAttributeAppender;
                        ClassVisitor classVisitor = this.cv;
                        TypeDescription typeDescription = withDecorationOnly.instrumentedType;
                        typeAttributeAppender.apply(classVisitor, typeDescription, withDecorationOnly.annotationValueFilterFactory.on(typeDescription));
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    @MaybeNull
                    public AnnotationVisitor onVisitAnnotation(String str, boolean z6) {
                        return WithDecorationOnly.this.annotationRetention.isEnabled() ? this.cv.visitAnnotation(str, z6) : ForInlining.IGNORE_ANNOTATION;
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    public void onVisitEnd() {
                        this.implementationContext.drain(this, this.cv, WithDecorationOnly.this.annotationValueFilterFactory);
                        this.cv.visitEnd();
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    @MaybeNull
                    public AnnotationVisitor onVisitTypeAnnotation(int i, TypePath typePath, String str, boolean z6) {
                        return WithDecorationOnly.this.annotationRetention.isEnabled() ? this.cv.visitTypeAnnotation(i, typePath, str, z6) : ForInlining.IGNORE_ANNOTATION;
                    }

                    @Override // net.bytebuddy.jar.asm.ClassVisitor
                    public void visit(int i, int i3, String str, String str2, String str3, String[] strArr) {
                        ClassFileVersion classFileVersionOfMinorMajor = ClassFileVersion.ofMinorMajor(i);
                        WithDecorationOnly withDecorationOnly = WithDecorationOnly.this;
                        Implementation.Context.ExtractableView extractableViewMake = withDecorationOnly.implementationContextFactory.make(withDecorationOnly.instrumentedType, withDecorationOnly.auxiliaryTypeNamingStrategy, withDecorationOnly.typeInitializer, classFileVersionOfMinorMajor, withDecorationOnly.classFileVersion, ((this.writerFlags & 2) == 0 && classFileVersionOfMinorMajor.isAtLeast(ClassFileVersion.JAVA_V6)) ? (this.readerFlags & 8) == 0 ? Implementation.Context.FrameGeneration.GENERATE : Implementation.Context.FrameGeneration.EXPAND : Implementation.Context.FrameGeneration.DISABLED);
                        this.implementationContext = extractableViewMake;
                        this.contextRegistry.setImplementationContext(extractableViewMake);
                        WithDecorationOnly withDecorationOnly2 = WithDecorationOnly.this;
                        ClassVisitor classVisitorWrap = withDecorationOnly2.asmVisitorWrapper.wrap(withDecorationOnly2.instrumentedType, this.cv, this.implementationContext, withDecorationOnly2.typePool, withDecorationOnly2.fields, withDecorationOnly2.methods, this.writerFlags, this.readerFlags);
                        this.cv = classVisitorWrap;
                        classVisitorWrap.visit(i, i3, str, str2, str3, strArr);
                    }
                }

                public static class LazyFieldList extends FieldList.AbstractBase<FieldDescription.InDefinedShape> {
                    private final TypeDescription instrumentedType;

                    public LazyFieldList(TypeDescription typeDescription) {
                        this.instrumentedType = typeDescription;
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                    public int size() {
                        return this.instrumentedType.getDeclaredFields().size();
                    }

                    @Override // java.util.AbstractList, java.util.List
                    public FieldDescription.InDefinedShape get(int i) {
                        return this.instrumentedType.getDeclaredFields().get(i);
                    }
                }

                public WithDecorationOnly(TypeDescription typeDescription, ClassFileVersion classFileVersion, List<? extends DynamicType> list, MethodList<?> methodList, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, ClassFileLocator classFileLocator) {
                    super(typeDescription, classFileVersion, FieldPool.Disabled.INSTANCE, RecordComponentPool.Disabled.INSTANCE, list, new LazyFieldList(typeDescription), methodList, new MethodList.Empty(), new RecordComponentList.Empty(), LoadedTypeInitializer.NoOp.INSTANCE, TypeInitializer.None.INSTANCE, typeAttributeAppender, asmVisitorWrapper, factory, annotationRetention, namingStrategy, factory2, typeValidation, classWriterStrategy, typePool, typeDescription, classFileLocator);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining
                public ClassVisitor writeTo(ClassVisitor classVisitor, TypeInitializer typeInitializer, ContextRegistry contextRegistry, int i, int i3) {
                    if (typeInitializer.isDefined()) {
                        throw new UnsupportedOperationException("Cannot apply a type initializer for a decoration");
                    }
                    return new DecorationClassVisitor(classVisitor, contextRegistry, i, i3);
                }
            }

            public ForInlining(TypeDescription typeDescription, ClassFileVersion classFileVersion, FieldPool fieldPool, RecordComponentPool recordComponentPool, List<? extends DynamicType> list, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, MethodList<?> methodList2, RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponentList, LoadedTypeInitializer loadedTypeInitializer, TypeInitializer typeInitializer, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, TypeDescription typeDescription2, ClassFileLocator classFileLocator) {
                super(typeDescription, classFileVersion, fieldPool, recordComponentPool, list, fieldList, methodList, methodList2, recordComponentList, loadedTypeInitializer, typeInitializer, typeAttributeAppender, asmVisitorWrapper, factory, annotationRetention, namingStrategy, factory2, typeValidation, classWriterStrategy, typePool);
                this.originalType = typeDescription2;
                this.classFileLocator = classFileLocator;
            }

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default
            public Default<U>.UnresolvedType create(TypeInitializer typeInitializer, ClassDumpAction.Dispatcher dispatcher) {
                int iMergeWriter;
                int iMergeReader;
                ClassReader classReaderOf;
                ClassWriter classWriterResolve;
                ContextRegistry contextRegistry;
                try {
                    iMergeWriter = this.asmVisitorWrapper.mergeWriter(0);
                    iMergeReader = this.asmVisitorWrapper.mergeReader(0);
                    byte[] bArrResolve = this.classFileLocator.locate(this.originalType.getName()).resolve();
                    dispatcher.dump(this.instrumentedType, true, bArrResolve);
                    classReaderOf = OpenedClassReader.of(bArrResolve);
                    classWriterResolve = this.classWriterStrategy.resolve(iMergeWriter, this.typePool, classReaderOf);
                    contextRegistry = new ContextRegistry();
                } catch (IOException e) {
                    e = e;
                }
                try {
                    classReaderOf.accept(writeTo(ValidatingClassVisitor.of(classWriterResolve, this.typeValidation), typeInitializer, contextRegistry, iMergeWriter, iMergeReader), iMergeReader);
                    return new UnresolvedType(classWriterResolve.toByteArray(), contextRegistry.getAuxiliaryTypes());
                } catch (IOException e6) {
                    e = e6;
                    throw new RuntimeException("The class file could not be written", e);
                }
            }

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForInlining forInlining = (ForInlining) obj;
                return this.originalType.equals(forInlining.originalType) && this.classFileLocator.equals(forInlining.classFileLocator);
            }

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default
            public int hashCode() {
                return this.classFileLocator.hashCode() + com.google.protobuf.a.i(this.originalType, super.hashCode() * 31, 31);
            }

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter
            public ContextClassVisitor wrap(ClassVisitor classVisitor, int i, int i3) {
                ContextRegistry contextRegistry = new ContextRegistry();
                return new RegistryContextClassVisitor(writeTo(ValidatingClassVisitor.of(classVisitor, this.typeValidation), this.typeInitializer, contextRegistry, this.asmVisitorWrapper.mergeWriter(i), this.asmVisitorWrapper.mergeReader(i3)), contextRegistry);
            }

            public abstract ClassVisitor writeTo(ClassVisitor classVisitor, TypeInitializer typeInitializer, ContextRegistry contextRegistry, int i, int i3);

            @HashCodeAndEqualsPlugin.Enhance
            public static class WithFullProcessing<V> extends ForInlining<V> {
                private static final Object[] EMPTY = new Object[0];
                private final Implementation.Target.Factory implementationTargetFactory;
                private final MethodRebaseResolver methodRebaseResolver;
                private final MethodRegistry.Prepared methodRegistry;

                public interface InitializationHandler {

                    public static abstract class Appending extends MethodVisitor implements InitializationHandler, TypeInitializer.Drain {
                        protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
                        protected final FrameWriter frameWriter;
                        protected final TypeDescription instrumentedType;
                        protected int localVariableLength;
                        protected final MethodPool.Record record;
                        protected int stackSize;

                        public interface FrameWriter {
                            public static final Object[] EMPTY = new Object[0];

                            public static class Active implements FrameWriter {
                                private int currentLocalVariableLength;

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending.FrameWriter
                                public void emitFrame(MethodVisitor methodVisitor) {
                                    int i = this.currentLocalVariableLength;
                                    if (i == 0) {
                                        Object[] objArr = FrameWriter.EMPTY;
                                        methodVisitor.visitFrame(3, objArr.length, objArr, objArr.length, objArr);
                                    } else if (i > 3) {
                                        Object[] objArr2 = FrameWriter.EMPTY;
                                        methodVisitor.visitFrame(0, objArr2.length, objArr2, objArr2.length, objArr2);
                                    } else {
                                        Object[] objArr3 = FrameWriter.EMPTY;
                                        methodVisitor.visitFrame(2, i, objArr3, objArr3.length, objArr3);
                                    }
                                    methodVisitor.visitInsn(0);
                                    this.currentLocalVariableLength = 0;
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending.FrameWriter
                                public void onFrame(int i, int i3) {
                                    if (i == -1 || i == 0) {
                                        this.currentLocalVariableLength = i3;
                                        return;
                                    }
                                    if (i == 1) {
                                        this.currentLocalVariableLength += i3;
                                    } else if (i == 2) {
                                        this.currentLocalVariableLength -= i3;
                                    } else if (i != 3 && i != 4) {
                                        throw new IllegalStateException(b.c(i, "Unexpected frame type: "));
                                    }
                                }
                            }

                            public enum Expanding implements FrameWriter {
                                INSTANCE;

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending.FrameWriter
                                public void emitFrame(MethodVisitor methodVisitor) {
                                    Object[] objArr = FrameWriter.EMPTY;
                                    methodVisitor.visitFrame(-1, objArr.length, objArr, objArr.length, objArr);
                                    methodVisitor.visitInsn(0);
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending.FrameWriter
                                public void onFrame(int i, int i3) {
                                }
                            }

                            public enum NoOp implements FrameWriter {
                                INSTANCE;

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending.FrameWriter
                                public void emitFrame(MethodVisitor methodVisitor) {
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending.FrameWriter
                                public void onFrame(int i, int i3) {
                                }
                            }

                            void emitFrame(MethodVisitor methodVisitor);

                            void onFrame(int i, int i3);
                        }

                        public static abstract class WithDrain extends Appending {
                            protected final Label appended;
                            protected final Label original;

                            public static class WithActiveRecord extends WithDrain {
                                private final Label label;

                                public WithActiveRecord(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory, boolean z6, boolean z7) {
                                    super(methodVisitor, typeDescription, record, factory, z6, z7);
                                    this.label = new Label();
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending.WithDrain
                                public void onAfterComplete(Implementation.Context context) {
                                    this.mv.visitLabel(this.label);
                                    this.frameWriter.emitFrame(this.mv);
                                    ByteCodeAppender.Size sizeApplyCode = this.record.applyCode(this.mv, context);
                                    this.stackSize = Math.max(this.stackSize, sizeApplyCode.getOperandStackSize());
                                    this.localVariableLength = Math.max(this.localVariableLength, sizeApplyCode.getLocalVariableSize());
                                }

                                @Override // net.bytebuddy.jar.asm.MethodVisitor
                                public void visitInsn(int i) {
                                    if (i == 177) {
                                        this.mv.visitJumpInsn(167, this.label);
                                    } else {
                                        super.visitInsn(i);
                                    }
                                }
                            }

                            public static class WithoutActiveRecord extends WithDrain {
                                public WithoutActiveRecord(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory, boolean z6, boolean z7) {
                                    super(methodVisitor, typeDescription, record, factory, z6, z7);
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending.WithDrain
                                public void onAfterComplete(Implementation.Context context) {
                                }
                            }

                            public WithDrain(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory, boolean z6, boolean z7) {
                                super(methodVisitor, typeDescription, record, factory, z6, z7);
                                this.appended = new Label();
                                this.original = new Label();
                            }

                            public abstract void onAfterComplete(Implementation.Context context);

                            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending
                            public void onComplete(Implementation.Context context) {
                                this.mv.visitJumpInsn(167, this.original);
                                onAfterComplete(context);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending
                            public void onStart() {
                                this.mv.visitJumpInsn(167, this.appended);
                                this.mv.visitLabel(this.original);
                                this.frameWriter.emitFrame(this.mv);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending, net.bytebuddy.jar.asm.MethodVisitor
                            public void visitEnd() {
                                this.mv.visitLabel(this.appended);
                                this.frameWriter.emitFrame(this.mv);
                            }
                        }

                        public static abstract class WithoutDrain extends Appending {

                            public static class WithActiveRecord extends WithoutDrain {
                                private final Label label;

                                public WithActiveRecord(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory, boolean z6, boolean z7) {
                                    super(methodVisitor, typeDescription, record, factory, z6, z7);
                                    this.label = new Label();
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending
                                public void onComplete(Implementation.Context context) {
                                    this.mv.visitLabel(this.label);
                                    this.frameWriter.emitFrame(this.mv);
                                    ByteCodeAppender.Size sizeApplyCode = this.record.applyCode(this.mv, context);
                                    this.stackSize = Math.max(this.stackSize, sizeApplyCode.getOperandStackSize());
                                    this.localVariableLength = Math.max(this.localVariableLength, sizeApplyCode.getLocalVariableSize());
                                }

                                @Override // net.bytebuddy.jar.asm.MethodVisitor
                                public void visitInsn(int i) {
                                    if (i == 177) {
                                        this.mv.visitJumpInsn(167, this.label);
                                    } else {
                                        super.visitInsn(i);
                                    }
                                }
                            }

                            public static class WithoutActiveRecord extends WithoutDrain {
                                public WithoutActiveRecord(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory) {
                                    super(methodVisitor, typeDescription, record, factory, false, false);
                                }

                                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending
                                public void onComplete(Implementation.Context context) {
                                }
                            }

                            public WithoutDrain(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory, boolean z6, boolean z7) {
                                super(methodVisitor, typeDescription, record, factory, z6, z7);
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending
                            public void onStart() {
                            }

                            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler.Appending, net.bytebuddy.jar.asm.MethodVisitor
                            public void visitEnd() {
                            }
                        }

                        public Appending(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool.Record record, AnnotationValueFilter.Factory factory, boolean z6, boolean z7) {
                            super(OpenedClassReader.ASM_API, methodVisitor);
                            this.instrumentedType = typeDescription;
                            this.record = record;
                            this.annotationValueFilterFactory = factory;
                            if (!z6) {
                                this.frameWriter = FrameWriter.NoOp.INSTANCE;
                            } else if (z7) {
                                this.frameWriter = FrameWriter.Expanding.INSTANCE;
                            } else {
                                this.frameWriter = new FrameWriter.Active();
                            }
                        }

                        public static InitializationHandler of(boolean z6, MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool methodPool, AnnotationValueFilter.Factory factory, boolean z7, boolean z8) {
                            return z6 ? withDrain(methodVisitor, typeDescription, methodPool, factory, z7, z8) : withoutDrain(methodVisitor, typeDescription, methodPool, factory, z7, z8);
                        }

                        private static WithDrain withDrain(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool methodPool, AnnotationValueFilter.Factory factory, boolean z6, boolean z7) {
                            MethodPool.Record recordTarget = methodPool.target(new MethodDescription.Latent.TypeInitializer(typeDescription));
                            return recordTarget.getSort().isImplemented() ? new WithDrain.WithActiveRecord(methodVisitor, typeDescription, recordTarget, factory, z6, z7) : new WithDrain.WithoutActiveRecord(methodVisitor, typeDescription, recordTarget, factory, z6, z7);
                        }

                        private static WithoutDrain withoutDrain(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodPool methodPool, AnnotationValueFilter.Factory factory, boolean z6, boolean z7) {
                            MethodPool.Record recordTarget = methodPool.target(new MethodDescription.Latent.TypeInitializer(typeDescription));
                            return recordTarget.getSort().isImplemented() ? new WithoutDrain.WithActiveRecord(methodVisitor, typeDescription, recordTarget, factory, z6, z7) : new WithoutDrain.WithoutActiveRecord(methodVisitor, typeDescription, recordTarget, factory);
                        }

                        @Override // net.bytebuddy.dynamic.scaffold.TypeInitializer.Drain
                        public void apply(ClassVisitor classVisitor, TypeInitializer typeInitializer, Implementation.Context context) {
                            ByteCodeAppender.Size sizeApply = typeInitializer.apply(this.mv, context, new MethodDescription.Latent.TypeInitializer(this.instrumentedType));
                            this.stackSize = Math.max(this.stackSize, sizeApply.getOperandStackSize());
                            this.localVariableLength = Math.max(this.localVariableLength, sizeApply.getLocalVariableSize());
                            onComplete(context);
                        }

                        @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler
                        public void complete(ClassVisitor classVisitor, Implementation.Context.ExtractableView extractableView) {
                            extractableView.drain(this, classVisitor, this.annotationValueFilterFactory);
                            this.mv.visitMaxs(this.stackSize, this.localVariableLength);
                            this.mv.visitEnd();
                        }

                        public abstract void onComplete(Implementation.Context context);

                        public abstract void onStart();

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitCode() {
                            this.record.applyAttributes(this.mv, this.annotationValueFilterFactory);
                            super.visitCode();
                            onStart();
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public abstract void visitEnd();

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitFrame(int i, int i3, @MaybeNull Object[] objArr, int i4, @MaybeNull Object[] objArr2) {
                            super.visitFrame(i, i3, objArr, i4, objArr2);
                            this.frameWriter.onFrame(i, i3);
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitMaxs(int i, int i3) {
                            this.stackSize = i;
                            this.localVariableLength = i3;
                        }
                    }

                    public static class Creating extends TypeInitializer.Drain.Default implements InitializationHandler {
                        public Creating(TypeDescription typeDescription, MethodPool methodPool, AnnotationValueFilter.Factory factory) {
                            super(typeDescription, methodPool, factory);
                        }

                        @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining.WithFullProcessing.InitializationHandler
                        public void complete(ClassVisitor classVisitor, Implementation.Context.ExtractableView extractableView) {
                            extractableView.drain(this, classVisitor, this.annotationValueFilterFactory);
                        }
                    }

                    void complete(ClassVisitor classVisitor, Implementation.Context.ExtractableView extractableView);
                }

                public static class OpenedClassRemapper extends ClassRemapper {
                    public OpenedClassRemapper(ClassVisitor classVisitor, Remapper remapper) {
                        super(OpenedClassReader.ASM_API, classVisitor, remapper);
                    }
                }

                public WithFullProcessing(TypeDescription typeDescription, ClassFileVersion classFileVersion, FieldPool fieldPool, RecordComponentPool recordComponentPool, List<? extends DynamicType> list, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, MethodList<?> methodList2, RecordComponentList<RecordComponentDescription.InDefinedShape> recordComponentList, LoadedTypeInitializer loadedTypeInitializer, TypeInitializer typeInitializer, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, AuxiliaryType.NamingStrategy namingStrategy, Implementation.Context.Factory factory2, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, TypePool typePool, TypeDescription typeDescription2, ClassFileLocator classFileLocator, MethodRegistry.Prepared prepared, Implementation.Target.Factory factory3, MethodRebaseResolver methodRebaseResolver) {
                    super(typeDescription, classFileVersion, fieldPool, recordComponentPool, list, fieldList, methodList, methodList2, recordComponentList, loadedTypeInitializer, typeInitializer, typeAttributeAppender, asmVisitorWrapper, factory, annotationRetention, namingStrategy, factory2, typeValidation, classWriterStrategy, typePool, typeDescription2, classFileLocator);
                    this.methodRegistry = prepared;
                    this.implementationTargetFactory = factory3;
                    this.methodRebaseResolver = methodRebaseResolver;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining, net.bytebuddy.dynamic.scaffold.TypeWriter.Default
                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    WithFullProcessing withFullProcessing = (WithFullProcessing) obj;
                    return this.methodRegistry.equals(withFullProcessing.methodRegistry) && this.implementationTargetFactory.equals(withFullProcessing.implementationTargetFactory) && this.methodRebaseResolver.equals(withFullProcessing.methodRebaseResolver);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining, net.bytebuddy.dynamic.scaffold.TypeWriter.Default
                public int hashCode() {
                    return this.methodRebaseResolver.hashCode() + ((this.implementationTargetFactory.hashCode() + ((this.methodRegistry.hashCode() + (super.hashCode() * 31)) * 31)) * 31);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.Default.ForInlining
                public ClassVisitor writeTo(ClassVisitor classVisitor, TypeInitializer typeInitializer, ContextRegistry contextRegistry, int i, int i3) {
                    RedefinitionClassVisitor redefinitionClassVisitor = new RedefinitionClassVisitor(classVisitor, typeInitializer, contextRegistry, i, i3);
                    return this.originalType.getName().equals(this.instrumentedType.getName()) ? redefinitionClassVisitor : new OpenedClassRemapper(redefinitionClassVisitor, new SimpleRemapper(this.originalType.getInternalName(), this.instrumentedType.getInternalName()));
                }

                @SuppressFBWarnings(justification = "Field access order is implied by ASM.", value = {"UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR"})
                public class RedefinitionClassVisitor extends MetadataAwareClassVisitor {
                    private final ContextRegistry contextRegistry;
                    private final LinkedHashMap<SignatureKey, FieldDescription> declarableFields;
                    private final LinkedHashMap<SignatureKey, MethodDescription> declarableMethods;
                    private final LinkedHashMap<String, RecordComponentDescription> declarableRecordComponents;
                    private final LinkedHashMap<String, TypeDescription> declaredTypes;

                    @UnknownNull
                    private Implementation.Context.ExtractableView implementationContext;

                    @UnknownNull
                    private InitializationHandler initializationHandler;

                    @UnknownNull
                    private MethodPool methodPool;
                    private final Set<String> nestMembers;

                    @MaybeNull
                    private final Set<String> permittedSubclasses;
                    private final int readerFlags;
                    private boolean retainDeprecationModifiers;
                    private final TypeInitializer typeInitializer;
                    private final int writerFlags;

                    public class AttributeObtainingFieldVisitor extends FieldVisitor {
                        private final FieldPool.Record record;

                        public AttributeObtainingFieldVisitor(FieldVisitor fieldVisitor, FieldPool.Record record) {
                            super(OpenedClassReader.ASM_API, fieldVisitor);
                            this.record = record;
                        }

                        @Override // net.bytebuddy.jar.asm.FieldVisitor
                        @MaybeNull
                        public AnnotationVisitor visitAnnotation(String str, boolean z6) {
                            return WithFullProcessing.this.annotationRetention.isEnabled() ? super.visitAnnotation(str, z6) : ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.FieldVisitor
                        public void visitEnd() {
                            this.record.apply(this.fv, WithFullProcessing.this.annotationValueFilterFactory);
                            super.visitEnd();
                        }

                        @Override // net.bytebuddy.jar.asm.FieldVisitor
                        @MaybeNull
                        public AnnotationVisitor visitTypeAnnotation(int i, @MaybeNull TypePath typePath, String str, boolean z6) {
                            return WithFullProcessing.this.annotationRetention.isEnabled() ? super.visitTypeAnnotation(i, typePath, str, z6) : ForInlining.IGNORE_ANNOTATION;
                        }
                    }

                    public class AttributeObtainingMethodVisitor extends MethodVisitor {
                        private final MethodVisitor actualMethodVisitor;
                        private final MethodPool.Record record;

                        public AttributeObtainingMethodVisitor(MethodVisitor methodVisitor, MethodPool.Record record) {
                            super(OpenedClassReader.ASM_API, methodVisitor);
                            this.actualMethodVisitor = methodVisitor;
                            this.record = record;
                            record.applyHead(methodVisitor);
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitAnnotableParameterCount(int i, boolean z6) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                super.visitAnnotableParameterCount(i, z6);
                            }
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        @MaybeNull
                        public AnnotationVisitor visitAnnotation(String str, boolean z6) {
                            return WithFullProcessing.this.annotationRetention.isEnabled() ? super.visitAnnotation(str, z6) : ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        @MaybeNull
                        public AnnotationVisitor visitAnnotationDefault() {
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitCode() {
                            this.mv = ForInlining.IGNORE_METHOD;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitEnd() {
                            this.record.applyBody(this.actualMethodVisitor, RedefinitionClassVisitor.this.implementationContext, WithFullProcessing.this.annotationValueFilterFactory);
                            this.actualMethodVisitor.visitEnd();
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        @MaybeNull
                        public AnnotationVisitor visitParameterAnnotation(int i, String str, boolean z6) {
                            return WithFullProcessing.this.annotationRetention.isEnabled() ? super.visitParameterAnnotation(i, str, z6) : ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        @MaybeNull
                        public AnnotationVisitor visitTypeAnnotation(int i, @MaybeNull TypePath typePath, String str, boolean z6) {
                            return WithFullProcessing.this.annotationRetention.isEnabled() ? super.visitTypeAnnotation(i, typePath, str, z6) : ForInlining.IGNORE_ANNOTATION;
                        }
                    }

                    public class AttributeObtainingRecordComponentVisitor extends RecordComponentVisitor {
                        private final RecordComponentPool.Record record;

                        public AttributeObtainingRecordComponentVisitor(RecordComponentVisitor recordComponentVisitor, RecordComponentPool.Record record) {
                            super(OpenedClassReader.ASM_API, recordComponentVisitor);
                            this.record = record;
                        }

                        @Override // net.bytebuddy.jar.asm.RecordComponentVisitor
                        public AnnotationVisitor visitAnnotation(String str, boolean z6) {
                            return WithFullProcessing.this.annotationRetention.isEnabled() ? super.visitAnnotation(str, z6) : ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.RecordComponentVisitor
                        public void visitEnd() {
                            this.record.apply(getDelegate(), WithFullProcessing.this.annotationValueFilterFactory);
                            super.visitEnd();
                        }

                        @Override // net.bytebuddy.jar.asm.RecordComponentVisitor
                        public AnnotationVisitor visitTypeAnnotation(int i, TypePath typePath, String str, boolean z6) {
                            return WithFullProcessing.this.annotationRetention.isEnabled() ? super.visitTypeAnnotation(i, typePath, str, z6) : ForInlining.IGNORE_ANNOTATION;
                        }
                    }

                    public class CodePreservingMethodVisitor extends MethodVisitor {
                        private final MethodVisitor actualMethodVisitor;
                        private final MethodPool.Record record;
                        private final MethodRebaseResolver.Resolution resolution;

                        public CodePreservingMethodVisitor(MethodVisitor methodVisitor, MethodPool.Record record, MethodRebaseResolver.Resolution resolution) {
                            super(OpenedClassReader.ASM_API, methodVisitor);
                            this.actualMethodVisitor = methodVisitor;
                            this.record = record;
                            this.resolution = resolution;
                            record.applyHead(methodVisitor);
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitAnnotableParameterCount(int i, boolean z6) {
                            if (WithFullProcessing.this.annotationRetention.isEnabled()) {
                                super.visitAnnotableParameterCount(i, z6);
                            }
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        @MaybeNull
                        public AnnotationVisitor visitAnnotation(String str, boolean z6) {
                            return WithFullProcessing.this.annotationRetention.isEnabled() ? super.visitAnnotation(str, z6) : ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        @MaybeNull
                        public AnnotationVisitor visitAnnotationDefault() {
                            return ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitCode() {
                            this.record.applyBody(this.actualMethodVisitor, RedefinitionClassVisitor.this.implementationContext, WithFullProcessing.this.annotationValueFilterFactory);
                            this.actualMethodVisitor.visitEnd();
                            if (!this.resolution.isRebased()) {
                                this.mv = ForInlining.IGNORE_METHOD;
                                super.visitCode();
                                return;
                            }
                            this.mv = ((ClassVisitor) RedefinitionClassVisitor.this).cv.visitMethod(this.resolution.getResolvedMethod().getActualModifiers(), this.resolution.getResolvedMethod().getInternalName(), this.resolution.getResolvedMethod().getDescriptor(), this.resolution.getResolvedMethod().getGenericSignature(), this.resolution.getResolvedMethod().getExceptionTypes().asErasures().toInternalNames());
                            super.visitCode();
                            if (this.resolution.getAppendedParameters().isEmpty() || !RedefinitionClassVisitor.this.implementationContext.getFrameGeneration().isActive()) {
                                return;
                            }
                            if (RedefinitionClassVisitor.this.implementationContext.getFrameGeneration() != Implementation.Context.FrameGeneration.GENERATE || this.resolution.getAppendedParameters().size() >= 4) {
                                int size = (this.resolution.getResolvedMethod().getParameters().size() - this.resolution.getAppendedParameters().size()) + 1;
                                Object[] objArr = new Object[size];
                                objArr[0] = Opcodes.UNINITIALIZED_THIS;
                                for (int i = 1; i < size; i++) {
                                    TypeDescription.Generic type = this.resolution.getResolvedMethod().getParameters().get(i - 1).getType();
                                    if (type.represents(Boolean.TYPE) || type.represents(Byte.TYPE) || type.represents(Short.TYPE) || type.represents(Character.TYPE) || type.represents(Integer.TYPE)) {
                                        objArr[i] = Opcodes.INTEGER;
                                    } else if (type.represents(Long.TYPE)) {
                                        objArr[i] = Opcodes.LONG;
                                    } else if (type.represents(Float.TYPE)) {
                                        objArr[i] = Opcodes.FLOAT;
                                    } else if (type.represents(Double.TYPE)) {
                                        objArr[i] = Opcodes.DOUBLE;
                                    } else {
                                        objArr[i] = type.asErasure().getInternalName();
                                    }
                                }
                                super.visitFrame((RedefinitionClassVisitor.this.readerFlags & 8) == 0 ? 0 : -1, size, objArr, WithFullProcessing.EMPTY.length, WithFullProcessing.EMPTY);
                            } else {
                                super.visitFrame(2, this.resolution.getAppendedParameters().size(), WithFullProcessing.EMPTY, WithFullProcessing.EMPTY.length, WithFullProcessing.EMPTY);
                            }
                            super.visitInsn(0);
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        public void visitMaxs(int i, int i3) {
                            super.visitMaxs(i, Math.max(i3, this.resolution.getResolvedMethod().getStackSize()));
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        @MaybeNull
                        public AnnotationVisitor visitParameterAnnotation(int i, String str, boolean z6) {
                            return WithFullProcessing.this.annotationRetention.isEnabled() ? super.visitParameterAnnotation(i, str, z6) : ForInlining.IGNORE_ANNOTATION;
                        }

                        @Override // net.bytebuddy.jar.asm.MethodVisitor
                        @MaybeNull
                        public AnnotationVisitor visitTypeAnnotation(int i, @MaybeNull TypePath typePath, String str, boolean z6) {
                            return WithFullProcessing.this.annotationRetention.isEnabled() ? super.visitTypeAnnotation(i, typePath, str, z6) : ForInlining.IGNORE_ANNOTATION;
                        }
                    }

                    public RedefinitionClassVisitor(ClassVisitor classVisitor, TypeInitializer typeInitializer, ContextRegistry contextRegistry, int i, int i3) {
                        super(OpenedClassReader.ASM_API, classVisitor);
                        this.typeInitializer = typeInitializer;
                        this.contextRegistry = contextRegistry;
                        this.writerFlags = i;
                        this.readerFlags = i3;
                        this.declarableFields = new LinkedHashMap<>((int) Math.ceil(((double) WithFullProcessing.this.fields.size()) / 0.75d));
                        for (FieldDescription.InDefinedShape inDefinedShape : WithFullProcessing.this.fields) {
                            this.declarableFields.put(new SignatureKey(inDefinedShape.getInternalName(), inDefinedShape.getDescriptor()), inDefinedShape);
                        }
                        this.declarableMethods = new LinkedHashMap<>((int) Math.ceil(((double) WithFullProcessing.this.instrumentedMethods.size()) / 0.75d));
                        Iterator<?> it = WithFullProcessing.this.instrumentedMethods.iterator();
                        while (it.hasNext()) {
                            MethodDescription methodDescription = (MethodDescription) it.next();
                            this.declarableMethods.put(new SignatureKey(methodDescription.getInternalName(), methodDescription.getDescriptor()), methodDescription);
                        }
                        this.declarableRecordComponents = new LinkedHashMap<>((int) Math.ceil(((double) WithFullProcessing.this.recordComponents.size()) / 0.75d));
                        for (RecordComponentDescription.InDefinedShape inDefinedShape2 : WithFullProcessing.this.recordComponents) {
                            this.declarableRecordComponents.put(inDefinedShape2.getActualName(), inDefinedShape2);
                        }
                        if (WithFullProcessing.this.instrumentedType.isNestHost()) {
                            this.nestMembers = new LinkedHashSet((int) Math.ceil(((double) WithFullProcessing.this.instrumentedType.getNestMembers().size()) / 0.75d));
                            Iterator<TypeDescription> it2 = WithFullProcessing.this.instrumentedType.getNestMembers().filter(ElementMatchers.not(ElementMatchers.is(WithFullProcessing.this.instrumentedType))).iterator();
                            while (it2.hasNext()) {
                                this.nestMembers.add(it2.next().getInternalName());
                            }
                        } else {
                            this.nestMembers = Collections.EMPTY_SET;
                        }
                        this.declaredTypes = new LinkedHashMap<>((int) Math.ceil(((double) WithFullProcessing.this.instrumentedType.getDeclaredTypes().size()) / 0.75d));
                        for (TypeDescription typeDescription : WithFullProcessing.this.instrumentedType.getDeclaredTypes()) {
                            this.declaredTypes.put(typeDescription.getInternalName(), typeDescription);
                        }
                        if (!WithFullProcessing.this.instrumentedType.isSealed()) {
                            this.permittedSubclasses = null;
                            return;
                        }
                        this.permittedSubclasses = new LinkedHashSet((int) Math.ceil(((double) WithFullProcessing.this.instrumentedType.getPermittedSubtypes().size()) / 0.75d));
                        Iterator<TypeDescription> it3 = WithFullProcessing.this.instrumentedType.getPermittedSubtypes().iterator();
                        while (it3.hasNext()) {
                            this.permittedSubclasses.add(it3.next().getInternalName());
                        }
                    }

                    private int resolveDeprecationModifiers(int i) {
                        return (!this.retainDeprecationModifiers || (i & 131072) == 0) ? 0 : 131072;
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    public void onAfterAttributes() {
                        WithFullProcessing withFullProcessing = WithFullProcessing.this;
                        TypeAttributeAppender typeAttributeAppender = withFullProcessing.typeAttributeAppender;
                        ClassVisitor classVisitor = this.cv;
                        TypeDescription typeDescription = withFullProcessing.instrumentedType;
                        typeAttributeAppender.apply(classVisitor, typeDescription, withFullProcessing.annotationValueFilterFactory.on(typeDescription));
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    public void onNestHost() {
                        if (WithFullProcessing.this.instrumentedType.isNestHost()) {
                            return;
                        }
                        this.cv.visitNestHost(WithFullProcessing.this.instrumentedType.getNestHost().getInternalName());
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    @SuppressFBWarnings(justification = "Relying on correlated type properties.", value = {"NP_NULL_ON_SOME_PATH"})
                    public void onOuterType() {
                        MethodDescription.InDefinedShape enclosingMethod = WithFullProcessing.this.instrumentedType.getEnclosingMethod();
                        if (enclosingMethod != null) {
                            this.cv.visitOuterClass(enclosingMethod.getDeclaringType().getInternalName(), enclosingMethod.getInternalName(), enclosingMethod.getDescriptor());
                        } else if (WithFullProcessing.this.instrumentedType.isLocalType() || WithFullProcessing.this.instrumentedType.isAnonymousType()) {
                            this.cv.visitOuterClass(WithFullProcessing.this.instrumentedType.getEnclosingType().getInternalName(), Default.NO_REFERENCE, Default.NO_REFERENCE);
                        }
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    @MaybeNull
                    public AnnotationVisitor onVisitAnnotation(String str, boolean z6) {
                        return WithFullProcessing.this.annotationRetention.isEnabled() ? this.cv.visitAnnotation(str, z6) : ForInlining.IGNORE_ANNOTATION;
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    public void onVisitEnd() {
                        Iterator<String> it = this.nestMembers.iterator();
                        while (it.hasNext()) {
                            this.cv.visitNestMember(it.next());
                        }
                        Set<String> set = this.permittedSubclasses;
                        if (set != null) {
                            Iterator<String> it2 = set.iterator();
                            while (it2.hasNext()) {
                                this.cv.visitPermittedSubclass(it2.next());
                            }
                        }
                        TypeDescription declaringType = WithFullProcessing.this.instrumentedType.getDeclaringType();
                        if (declaringType != null) {
                            this.cv.visitInnerClass(WithFullProcessing.this.instrumentedType.getInternalName(), declaringType.getInternalName(), WithFullProcessing.this.instrumentedType.getSimpleName(), WithFullProcessing.this.instrumentedType.getModifiers());
                        } else if (WithFullProcessing.this.instrumentedType.isLocalType()) {
                            this.cv.visitInnerClass(WithFullProcessing.this.instrumentedType.getInternalName(), Default.NO_REFERENCE, WithFullProcessing.this.instrumentedType.getSimpleName(), WithFullProcessing.this.instrumentedType.getModifiers());
                        } else if (WithFullProcessing.this.instrumentedType.isAnonymousType()) {
                            this.cv.visitInnerClass(WithFullProcessing.this.instrumentedType.getInternalName(), Default.NO_REFERENCE, Default.NO_REFERENCE, WithFullProcessing.this.instrumentedType.getModifiers());
                        }
                        for (TypeDescription typeDescription : this.declaredTypes.values()) {
                            this.cv.visitInnerClass(typeDescription.getInternalName(), typeDescription.isMemberType() ? WithFullProcessing.this.instrumentedType.getInternalName() : Default.NO_REFERENCE, typeDescription.isAnonymousType() ? Default.NO_REFERENCE : typeDescription.getSimpleName(), typeDescription.getModifiers());
                        }
                        Iterator<RecordComponentDescription> it3 = this.declarableRecordComponents.values().iterator();
                        while (it3.hasNext()) {
                            WithFullProcessing.this.recordComponentPool.target(it3.next()).apply(this.cv, WithFullProcessing.this.annotationValueFilterFactory);
                        }
                        Iterator<FieldDescription> it4 = this.declarableFields.values().iterator();
                        while (it4.hasNext()) {
                            WithFullProcessing.this.fieldPool.target(it4.next()).apply(this.cv, WithFullProcessing.this.annotationValueFilterFactory);
                        }
                        Iterator<MethodDescription> it5 = this.declarableMethods.values().iterator();
                        while (it5.hasNext()) {
                            this.methodPool.target(it5.next()).apply(this.cv, this.implementationContext, WithFullProcessing.this.annotationValueFilterFactory);
                        }
                        this.initializationHandler.complete(this.cv, this.implementationContext);
                        this.cv.visitEnd();
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    @MaybeNull
                    public FieldVisitor onVisitField(int i, String str, String str2, @MaybeNull String str3, @MaybeNull Object obj) {
                        FieldDescription fieldDescriptionRemove = this.declarableFields.remove(new SignatureKey(str, str2));
                        if (fieldDescriptionRemove != null) {
                            FieldPool.Record recordTarget = WithFullProcessing.this.fieldPool.target(fieldDescriptionRemove);
                            if (!recordTarget.isImplicit()) {
                                return redefine(recordTarget, obj, i, str3);
                            }
                        }
                        return this.cv.visitField(i, str, str2, str3, obj);
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    public void onVisitInnerClass(String str, @MaybeNull String str2, @MaybeNull String str3, int i) {
                        if (str.equals(WithFullProcessing.this.instrumentedType.getInternalName())) {
                            return;
                        }
                        TypeDescription typeDescriptionRemove = this.declaredTypes.remove(str);
                        if (typeDescriptionRemove == null) {
                            this.cv.visitInnerClass(str, str2, str3, i);
                        } else {
                            this.cv.visitInnerClass(str, (typeDescriptionRemove.isMemberType() || (str2 != null && str3 == null && typeDescriptionRemove.isAnonymousType())) ? WithFullProcessing.this.instrumentedType.getInternalName() : Default.NO_REFERENCE, typeDescriptionRemove.isAnonymousType() ? Default.NO_REFERENCE : typeDescriptionRemove.getSimpleName(), typeDescriptionRemove.getModifiers());
                        }
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    @MaybeNull
                    public MethodVisitor onVisitMethod(int i, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                        if (!str.equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME)) {
                            MethodDescription methodDescriptionRemove = this.declarableMethods.remove(new SignatureKey(str, str2));
                            if (methodDescriptionRemove == null) {
                                return this.cv.visitMethod(i, str, str2, str3, strArr);
                            }
                            return redefine(methodDescriptionRemove, (i & 1024) != 0, i, str3);
                        }
                        MethodVisitor methodVisitorVisitMethod = this.cv.visitMethod(i, str, str2, str3, strArr);
                        if (methodVisitorVisitMethod == null) {
                            return ForInlining.IGNORE_METHOD;
                        }
                        boolean zIsEnabled = this.implementationContext.isEnabled();
                        WithFullProcessing withFullProcessing = WithFullProcessing.this;
                        InitializationHandler initializationHandlerOf = InitializationHandler.Appending.of(zIsEnabled, methodVisitorVisitMethod, withFullProcessing.instrumentedType, this.methodPool, withFullProcessing.annotationValueFilterFactory, (this.writerFlags & 2) == 0 && this.implementationContext.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V6), (this.readerFlags & 8) != 0);
                        this.initializationHandler = initializationHandlerOf;
                        return (MethodVisitor) initializationHandlerOf;
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    public void onVisitNestHost(String str) {
                        onNestHost();
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    public void onVisitNestMember(String str) {
                        if (WithFullProcessing.this.instrumentedType.isNestHost() && this.nestMembers.remove(str)) {
                            this.cv.visitNestMember(str);
                        }
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    public void onVisitOuterClass(String str, @MaybeNull String str2, @MaybeNull String str3) {
                        try {
                            onOuterType();
                        } catch (Throwable unused) {
                            this.cv.visitOuterClass(str, str2, str3);
                        }
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    public void onVisitPermittedSubclass(String str) {
                        Set<String> set = this.permittedSubclasses;
                        if (set == null || !set.remove(str)) {
                            return;
                        }
                        this.cv.visitPermittedSubclass(str);
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    @MaybeNull
                    public RecordComponentVisitor onVisitRecordComponent(String str, String str2, @MaybeNull String str3) {
                        RecordComponentDescription recordComponentDescriptionRemove = this.declarableRecordComponents.remove(str);
                        if (recordComponentDescriptionRemove != null) {
                            RecordComponentPool.Record recordTarget = WithFullProcessing.this.recordComponentPool.target(recordComponentDescriptionRemove);
                            if (!recordTarget.isImplicit()) {
                                return redefine(recordTarget, str3);
                            }
                        }
                        return this.cv.visitRecordComponent(str, str2, str3);
                    }

                    @Override // net.bytebuddy.utility.visitor.MetadataAwareClassVisitor
                    @MaybeNull
                    public AnnotationVisitor onVisitTypeAnnotation(int i, TypePath typePath, String str, boolean z6) {
                        return WithFullProcessing.this.annotationRetention.isEnabled() ? this.cv.visitTypeAnnotation(i, typePath, str, z6) : ForInlining.IGNORE_ANNOTATION;
                    }

                    @MaybeNull
                    public RecordComponentVisitor redefine(RecordComponentPool.Record record, @MaybeNull String str) {
                        RecordComponentDescription recordComponent = record.getRecordComponent();
                        ClassVisitor classVisitor = this.cv;
                        String actualName = recordComponent.getActualName();
                        String descriptor = recordComponent.getDescriptor();
                        if (!TypeDescription.AbstractBase.RAW_TYPES) {
                            str = recordComponent.getGenericSignature();
                        }
                        RecordComponentVisitor recordComponentVisitorVisitRecordComponent = classVisitor.visitRecordComponent(actualName, descriptor, str);
                        return recordComponentVisitorVisitRecordComponent == null ? ForInlining.IGNORE_RECORD_COMPONENT : new AttributeObtainingRecordComponentVisitor(recordComponentVisitorVisitRecordComponent, record);
                    }

                    @Override // net.bytebuddy.jar.asm.ClassVisitor
                    @SuppressFBWarnings(justification = "Relying on correlated type properties.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
                    public void visit(int i, int i3, String str, String str2, String str3, String[] strArr) {
                        ClassFileVersion classFileVersionOfMinorMajor = ClassFileVersion.ofMinorMajor(i);
                        MethodRegistry.Compiled compiledCompile = WithFullProcessing.this.methodRegistry.compile(WithFullProcessing.this.implementationTargetFactory, classFileVersionOfMinorMajor);
                        this.methodPool = compiledCompile;
                        WithFullProcessing withFullProcessing = WithFullProcessing.this;
                        this.initializationHandler = new InitializationHandler.Creating(withFullProcessing.instrumentedType, compiledCompile, withFullProcessing.annotationValueFilterFactory);
                        WithFullProcessing withFullProcessing2 = WithFullProcessing.this;
                        this.implementationContext = withFullProcessing2.implementationContextFactory.make(withFullProcessing2.instrumentedType, withFullProcessing2.auxiliaryTypeNamingStrategy, this.typeInitializer, classFileVersionOfMinorMajor, withFullProcessing2.classFileVersion, ((this.writerFlags & 2) == 0 && classFileVersionOfMinorMajor.isAtLeast(ClassFileVersion.JAVA_V6)) ? (this.readerFlags & 8) == 0 ? Implementation.Context.FrameGeneration.GENERATE : Implementation.Context.FrameGeneration.EXPAND : Implementation.Context.FrameGeneration.DISABLED);
                        this.retainDeprecationModifiers = classFileVersionOfMinorMajor.isLessThan(ClassFileVersion.JAVA_V5);
                        this.contextRegistry.setImplementationContext(this.implementationContext);
                        WithFullProcessing withFullProcessing3 = WithFullProcessing.this;
                        ClassVisitor classVisitorWrap = withFullProcessing3.asmVisitorWrapper.wrap(withFullProcessing3.instrumentedType, this.cv, this.implementationContext, withFullProcessing3.typePool, withFullProcessing3.fields, withFullProcessing3.methods, this.writerFlags, this.readerFlags);
                        this.cv = classVisitorWrap;
                        TypeDescription typeDescription = WithFullProcessing.this.instrumentedType;
                        int i4 = 0;
                        int actualModifiers = typeDescription.getActualModifiers(((i3 & 32) == 0 || typeDescription.isInterface()) ? false : true) | resolveDeprecationModifiers(i3);
                        if ((i3 & 16) != 0 && WithFullProcessing.this.instrumentedType.isAnonymousType()) {
                            i4 = 16;
                        }
                        classVisitorWrap.visit(i, actualModifiers | i4, WithFullProcessing.this.instrumentedType.getInternalName(), TypeDescription.AbstractBase.RAW_TYPES ? str2 : WithFullProcessing.this.instrumentedType.getGenericSignature(), WithFullProcessing.this.instrumentedType.getSuperClass() == null ? WithFullProcessing.this.instrumentedType.isInterface() ? TypeDescription.ForLoadedType.of(Object.class).getInternalName() : Default.NO_REFERENCE : WithFullProcessing.this.instrumentedType.getSuperClass().asErasure().getInternalName(), WithFullProcessing.this.instrumentedType.getInterfaces().asErasures().toInternalNames());
                    }

                    @MaybeNull
                    public FieldVisitor redefine(FieldPool.Record record, @MaybeNull Object obj, int i, @MaybeNull String str) {
                        FieldDescription field = record.getField();
                        ClassVisitor classVisitor = this.cv;
                        int actualModifiers = field.getActualModifiers() | resolveDeprecationModifiers(i);
                        String internalName = field.getInternalName();
                        String descriptor = field.getDescriptor();
                        if (!TypeDescription.AbstractBase.RAW_TYPES) {
                            str = field.getGenericSignature();
                        }
                        FieldVisitor fieldVisitorVisitField = classVisitor.visitField(actualModifiers, internalName, descriptor, str, record.resolveDefault(obj));
                        return fieldVisitorVisitField == null ? ForInlining.IGNORE_FIELD : new AttributeObtainingFieldVisitor(fieldVisitorVisitField, record);
                    }

                    @MaybeNull
                    public MethodVisitor redefine(MethodDescription methodDescription, boolean z6, int i, @MaybeNull String str) {
                        MethodPool.Record recordTarget = this.methodPool.target(methodDescription);
                        if (!recordTarget.getSort().isDefined()) {
                            return this.cv.visitMethod(methodDescription.getActualModifiers() | resolveDeprecationModifiers(i), methodDescription.getInternalName(), methodDescription.getDescriptor(), TypeDescription.AbstractBase.RAW_TYPES ? str : methodDescription.getGenericSignature(), methodDescription.getExceptionTypes().asErasures().toInternalNames());
                        }
                        MethodDescription method = recordTarget.getMethod();
                        ClassVisitor classVisitor = this.cv;
                        int iResolve = ModifierContributor.Resolver.of(Collections.singleton(recordTarget.getVisibility())).resolve(method.getActualModifiers(recordTarget.getSort().isImplemented())) | resolveDeprecationModifiers(i);
                        String internalName = method.getInternalName();
                        String descriptor = method.getDescriptor();
                        boolean z7 = TypeDescription.AbstractBase.RAW_TYPES;
                        MethodVisitor methodVisitorVisitMethod = classVisitor.visitMethod(iResolve, internalName, descriptor, z7 ? str : method.getGenericSignature(), method.getExceptionTypes().asErasures().toInternalNames());
                        if (methodVisitorVisitMethod == null) {
                            return ForInlining.IGNORE_METHOD;
                        }
                        if (z6) {
                            return new AttributeObtainingMethodVisitor(methodVisitorVisitMethod, recordTarget);
                        }
                        if (methodDescription.isNative()) {
                            MethodRebaseResolver.Resolution resolutionResolve = WithFullProcessing.this.methodRebaseResolver.resolve(method.asDefined());
                            if (resolutionResolve.isRebased()) {
                                MethodVisitor methodVisitorVisitMethod2 = visitMethod(resolveDeprecationModifiers(i) | resolutionResolve.getResolvedMethod().getActualModifiers(), resolutionResolve.getResolvedMethod().getInternalName(), resolutionResolve.getResolvedMethod().getDescriptor(), z7 ? str : method.getGenericSignature(), resolutionResolve.getResolvedMethod().getExceptionTypes().asErasures().toInternalNames());
                                if (methodVisitorVisitMethod2 != null) {
                                    methodVisitorVisitMethod2.visitEnd();
                                }
                            }
                            return new AttributeObtainingMethodVisitor(methodVisitorVisitMethod, recordTarget);
                        }
                        return new CodePreservingMethodVisitor(methodVisitorVisitMethod, recordTarget, WithFullProcessing.this.methodRebaseResolver.resolve(method.asDefined()));
                    }
                }
            }
        }
    }

    public interface MethodPool {

        public interface Record {

            @HashCodeAndEqualsPlugin.Enhance
            public static class AccessBridgeWrapper implements Record {
                private final MethodAttributeAppender attributeAppender;
                private final MethodDescription bridgeTarget;
                private final Set<MethodDescription.TypeToken> bridgeTypes;
                private final Record delegate;
                private final TypeDescription instrumentedType;

                public static class AccessorBridge extends MethodDescription.InDefinedShape.AbstractBase {
                    private final MethodDescription bridgeTarget;
                    private final MethodDescription.TypeToken bridgeType;
                    private final TypeDescription instrumentedType;

                    public AccessorBridge(MethodDescription methodDescription, MethodDescription.TypeToken typeToken, TypeDescription typeDescription) {
                        this.bridgeTarget = methodDescription;
                        this.bridgeType = typeToken;
                        this.instrumentedType = typeDescription;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        return new AnnotationList.Empty();
                    }

                    @Override // net.bytebuddy.description.method.MethodDescription
                    @MaybeNull
                    public AnnotationValue<?, ?> getDefaultValue() {
                        return AnnotationValue.UNDEFINED;
                    }

                    @Override // net.bytebuddy.description.method.MethodDescription
                    public TypeList.Generic getExceptionTypes() {
                        return this.bridgeTarget.getExceptionTypes().accept(TypeDescription.Generic.Visitor.TypeErasing.INSTANCE);
                    }

                    @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                    public String getInternalName() {
                        return this.bridgeTarget.getInternalName();
                    }

                    @Override // net.bytebuddy.description.ModifierReviewable
                    public int getModifiers() {
                        return (this.bridgeTarget.getModifiers() | 4160) & (-1281);
                    }

                    @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
                    public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                        return new ParameterList.Explicit.ForTypes(this, this.bridgeType.getParameterTypes());
                    }

                    @Override // net.bytebuddy.description.method.MethodDescription
                    public TypeDescription.Generic getReturnType() {
                        return this.bridgeType.getReturnType().asGenericType();
                    }

                    @Override // net.bytebuddy.description.TypeVariableSource
                    public TypeList.Generic getTypeVariables() {
                        return new TypeList.Generic.Empty();
                    }

                    @Override // net.bytebuddy.description.DeclaredByType.WithMandatoryDeclaration, net.bytebuddy.description.DeclaredByType
                    @Nonnull
                    public TypeDescription getDeclaringType() {
                        return this.instrumentedType;
                    }
                }

                public static class BridgeTarget extends MethodDescription.InDefinedShape.AbstractBase {
                    private final MethodDescription bridgeTarget;
                    private final TypeDescription instrumentedType;

                    public BridgeTarget(MethodDescription methodDescription, TypeDescription typeDescription) {
                        this.bridgeTarget = methodDescription;
                        this.instrumentedType = typeDescription;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        return this.bridgeTarget.getDeclaredAnnotations();
                    }

                    @Override // net.bytebuddy.description.method.MethodDescription
                    @MaybeNull
                    public AnnotationValue<?, ?> getDefaultValue() {
                        return this.bridgeTarget.getDefaultValue();
                    }

                    @Override // net.bytebuddy.description.method.MethodDescription
                    public TypeList.Generic getExceptionTypes() {
                        return this.bridgeTarget.getExceptionTypes();
                    }

                    @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                    public String getInternalName() {
                        return this.bridgeTarget.getInternalName();
                    }

                    @Override // net.bytebuddy.description.ModifierReviewable
                    public int getModifiers() {
                        return this.bridgeTarget.getModifiers();
                    }

                    @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
                    public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                        return new ParameterList.ForTokens(this, this.bridgeTarget.getParameters().asTokenList(ElementMatchers.is(this.instrumentedType)));
                    }

                    @Override // net.bytebuddy.description.method.MethodDescription
                    public TypeDescription.Generic getReturnType() {
                        return this.bridgeTarget.getReturnType();
                    }

                    @Override // net.bytebuddy.description.TypeVariableSource
                    public TypeList.Generic getTypeVariables() {
                        return this.bridgeTarget.getTypeVariables();
                    }

                    @Override // net.bytebuddy.description.DeclaredByType.WithMandatoryDeclaration, net.bytebuddy.description.DeclaredByType
                    @Nonnull
                    public TypeDescription getDeclaringType() {
                        return this.instrumentedType;
                    }
                }

                public AccessBridgeWrapper(Record record, TypeDescription typeDescription, MethodDescription methodDescription, Set<MethodDescription.TypeToken> set, MethodAttributeAppender methodAttributeAppender) {
                    this.delegate = record;
                    this.instrumentedType = typeDescription;
                    this.bridgeTarget = methodDescription;
                    this.bridgeTypes = set;
                    this.attributeAppender = methodAttributeAppender;
                }

                public static Record of(Record record, TypeDescription typeDescription, MethodDescription methodDescription, Set<MethodDescription.TypeToken> set, MethodAttributeAppender methodAttributeAppender) {
                    HashSet hashSet = new HashSet();
                    for (MethodDescription.TypeToken typeToken : set) {
                        if (methodDescription.isBridgeCompatible(typeToken)) {
                            hashSet.add(typeToken);
                        }
                    }
                    return (hashSet.isEmpty() || (typeDescription.isInterface() && !record.getSort().isImplemented())) ? record : new AccessBridgeWrapper(record, typeDescription, methodDescription, hashSet, methodAttributeAppender);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void apply(ClassVisitor classVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                    this.delegate.apply(classVisitor, context, factory);
                    Iterator<MethodDescription.TypeToken> it = this.bridgeTypes.iterator();
                    while (it.hasNext()) {
                        AccessorBridge accessorBridge = new AccessorBridge(this.bridgeTarget, it.next(), this.instrumentedType);
                        BridgeTarget bridgeTarget = new BridgeTarget(this.bridgeTarget, this.instrumentedType);
                        ClassVisitor classVisitor2 = classVisitor;
                        MethodVisitor methodVisitorVisitMethod = classVisitor2.visitMethod(accessorBridge.getActualModifiers(true, getVisibility()), accessorBridge.getInternalName(), accessorBridge.getDescriptor(), NamedElement.WithDescriptor.NON_GENERIC_SIGNATURE, accessorBridge.getExceptionTypes().asErasures().toInternalNames());
                        if (methodVisitorVisitMethod != null) {
                            this.attributeAppender.apply(methodVisitorVisitMethod, accessorBridge, factory.on(this.instrumentedType));
                            methodVisitorVisitMethod.visitCode();
                            ByteCodeAppender.Size sizeApply = new ByteCodeAppender.Simple(MethodVariableAccess.allArgumentsOf(accessorBridge).asBridgeOf(bridgeTarget).prependThisReference(), MethodInvocation.invoke((MethodDescription.InDefinedShape) bridgeTarget).virtual(this.instrumentedType), bridgeTarget.getReturnType().asErasure().isAssignableTo(accessorBridge.getReturnType().asErasure()) ? StackManipulation.Trivial.INSTANCE : TypeCasting.to(accessorBridge.getReturnType().asErasure()), MethodReturn.of(accessorBridge.getReturnType())).apply(methodVisitorVisitMethod, context, accessorBridge);
                            methodVisitorVisitMethod.visitMaxs(sizeApply.getOperandStackSize(), sizeApply.getLocalVariableSize());
                            methodVisitorVisitMethod.visitEnd();
                        }
                        classVisitor = classVisitor2;
                    }
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                    this.delegate.applyAttributes(methodVisitor, factory);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                    this.delegate.applyBody(methodVisitor, context, factory);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context) {
                    return this.delegate.applyCode(methodVisitor, context);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void applyHead(MethodVisitor methodVisitor) {
                    this.delegate.applyHead(methodVisitor);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    AccessBridgeWrapper accessBridgeWrapper = (AccessBridgeWrapper) obj;
                    return this.delegate.equals(accessBridgeWrapper.delegate) && this.instrumentedType.equals(accessBridgeWrapper.instrumentedType) && this.bridgeTarget.equals(accessBridgeWrapper.bridgeTarget) && this.bridgeTypes.equals(accessBridgeWrapper.bridgeTypes) && this.attributeAppender.equals(accessBridgeWrapper.attributeAppender);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public MethodDescription getMethod() {
                    return this.bridgeTarget;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public Sort getSort() {
                    return this.delegate.getSort();
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public Visibility getVisibility() {
                    return this.delegate.getVisibility();
                }

                public int hashCode() {
                    return this.attributeAppender.hashCode() + ((this.bridgeTypes.hashCode() + com.google.protobuf.a.f(this.bridgeTarget, com.google.protobuf.a.i(this.instrumentedType, (this.delegate.hashCode() + (getClass().hashCode() * 31)) * 31, 31), 31)) * 31);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public Record prepend(ByteCodeAppender byteCodeAppender) {
                    return new AccessBridgeWrapper(this.delegate.prepend(byteCodeAppender), this.instrumentedType, this.bridgeTarget, this.bridgeTypes, this.attributeAppender);
                }
            }

            public static abstract class ForDefinedMethod implements Record {

                @HashCodeAndEqualsPlugin.Enhance
                public static class OfVisibilityBridge extends ForDefinedMethod implements ByteCodeAppender {
                    private final MethodAttributeAppender attributeAppender;
                    private final MethodDescription bridgeTarget;
                    private final TypeDescription bridgeType;
                    private final MethodDescription visibilityBridge;

                    public static class VisibilityBridge extends MethodDescription.InDefinedShape.AbstractBase {
                        private final MethodDescription bridgeTarget;
                        private final TypeDescription instrumentedType;

                        public VisibilityBridge(TypeDescription typeDescription, MethodDescription methodDescription) {
                            this.instrumentedType = typeDescription;
                            this.bridgeTarget = methodDescription;
                        }

                        @Override // net.bytebuddy.description.annotation.AnnotationSource
                        public AnnotationList getDeclaredAnnotations() {
                            return this.bridgeTarget.getDeclaredAnnotations();
                        }

                        @Override // net.bytebuddy.description.method.MethodDescription
                        @MaybeNull
                        public AnnotationValue<?, ?> getDefaultValue() {
                            return AnnotationValue.UNDEFINED;
                        }

                        @Override // net.bytebuddy.description.method.MethodDescription
                        public TypeList.Generic getExceptionTypes() {
                            return this.bridgeTarget.getExceptionTypes().asRawTypes();
                        }

                        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                        public String getInternalName() {
                            return this.bridgeTarget.getName();
                        }

                        @Override // net.bytebuddy.description.ModifierReviewable
                        public int getModifiers() {
                            return (this.bridgeTarget.getModifiers() | 4160) & (-257);
                        }

                        @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
                        public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                            return new ParameterList.Explicit.ForTypes(this, this.bridgeTarget.getParameters().asTypeList().asRawTypes());
                        }

                        @Override // net.bytebuddy.description.method.MethodDescription
                        public TypeDescription.Generic getReturnType() {
                            return this.bridgeTarget.getReturnType().asRawType();
                        }

                        @Override // net.bytebuddy.description.TypeVariableSource
                        public TypeList.Generic getTypeVariables() {
                            return new TypeList.Generic.Empty();
                        }

                        @Override // net.bytebuddy.description.DeclaredByType.WithMandatoryDeclaration, net.bytebuddy.description.DeclaredByType
                        @Nonnull
                        public TypeDescription getDeclaringType() {
                            return this.instrumentedType;
                        }
                    }

                    public OfVisibilityBridge(MethodDescription methodDescription, MethodDescription methodDescription2, TypeDescription typeDescription, MethodAttributeAppender methodAttributeAppender) {
                        this.visibilityBridge = methodDescription;
                        this.bridgeTarget = methodDescription2;
                        this.bridgeType = typeDescription;
                        this.attributeAppender = methodAttributeAppender;
                    }

                    public static Record of(TypeDescription typeDescription, MethodDescription methodDescription, MethodAttributeAppender methodAttributeAppender) {
                        TypeDefinition superClass = null;
                        if (methodDescription.isDefaultMethod()) {
                            TypeDescription typeDescriptionAsErasure = methodDescription.getDeclaringType().asErasure();
                            for (TypeDescription typeDescription2 : typeDescription.getInterfaces().asErasures().filter(ElementMatchers.isSubTypeOf(typeDescriptionAsErasure))) {
                                if (superClass == null || typeDescriptionAsErasure.isAssignableTo(superClass.asErasure())) {
                                    superClass = typeDescription2;
                                }
                            }
                        }
                        if (superClass == null && (superClass = typeDescription.getSuperClass()) == null) {
                            superClass = TypeDescription.ForLoadedType.of(Object.class);
                        }
                        return new OfVisibilityBridge(new VisibilityBridge(typeDescription, methodDescription), methodDescription, superClass.asErasure(), methodAttributeAppender);
                    }

                    @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
                    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                        return new ByteCodeAppender.Simple(MethodVariableAccess.allArgumentsOf(methodDescription).prependThisReference(), MethodInvocation.invoke(this.bridgeTarget).special(this.bridgeType), MethodReturn.of(methodDescription.getReturnType())).apply(methodVisitor, context, methodDescription);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                        MethodAttributeAppender methodAttributeAppender = this.attributeAppender;
                        MethodDescription methodDescription = this.visibilityBridge;
                        methodAttributeAppender.apply(methodVisitor, methodDescription, factory.on(methodDescription));
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                        applyAttributes(methodVisitor, factory);
                        methodVisitor.visitCode();
                        ByteCodeAppender.Size sizeApplyCode = applyCode(methodVisitor, context);
                        methodVisitor.visitMaxs(sizeApplyCode.getOperandStackSize(), sizeApplyCode.getLocalVariableSize());
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context) {
                        return apply(methodVisitor, context, this.visibilityBridge);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyHead(MethodVisitor methodVisitor) {
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        OfVisibilityBridge ofVisibilityBridge = (OfVisibilityBridge) obj;
                        return this.visibilityBridge.equals(ofVisibilityBridge.visibilityBridge) && this.bridgeTarget.equals(ofVisibilityBridge.bridgeTarget) && this.bridgeType.equals(ofVisibilityBridge.bridgeType) && this.attributeAppender.equals(ofVisibilityBridge.attributeAppender);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public MethodDescription getMethod() {
                        return this.visibilityBridge;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Sort getSort() {
                        return Sort.IMPLEMENTED;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Visibility getVisibility() {
                        return this.bridgeTarget.getVisibility();
                    }

                    public int hashCode() {
                        return this.attributeAppender.hashCode() + com.google.protobuf.a.i(this.bridgeType, com.google.protobuf.a.f(this.bridgeTarget, com.google.protobuf.a.f(this.visibilityBridge, getClass().hashCode() * 31, 31), 31), 31);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Record prepend(ByteCodeAppender byteCodeAppender) {
                        return new WithBody(this.visibilityBridge, new ByteCodeAppender.Compound(this, byteCodeAppender), this.attributeAppender, this.bridgeTarget.getVisibility());
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithAnnotationDefaultValue extends ForDefinedMethod {
                    private final AnnotationValue<?, ?> annotationValue;
                    private final MethodAttributeAppender methodAttributeAppender;
                    private final MethodDescription methodDescription;

                    public WithAnnotationDefaultValue(MethodDescription methodDescription, AnnotationValue<?, ?> annotationValue, MethodAttributeAppender methodAttributeAppender) {
                        this.methodDescription = methodDescription;
                        this.annotationValue = annotationValue;
                        this.methodAttributeAppender = methodAttributeAppender;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                        throw new IllegalStateException("Cannot apply attributes for default value on " + this.methodDescription);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                        MethodAttributeAppender methodAttributeAppender = this.methodAttributeAppender;
                        MethodDescription methodDescription = this.methodDescription;
                        methodAttributeAppender.apply(methodVisitor, methodDescription, factory.on(methodDescription));
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context) {
                        throw new IllegalStateException("Cannot apply code for default value on " + this.methodDescription);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyHead(MethodVisitor methodVisitor) {
                        if (this.methodDescription.isDefaultValue(this.annotationValue)) {
                            AnnotationVisitor annotationVisitorVisitAnnotationDefault = methodVisitor.visitAnnotationDefault();
                            AnnotationAppender.Default.apply(annotationVisitorVisitAnnotationDefault, this.methodDescription.getReturnType().asErasure(), AnnotationAppender.NO_NAME, this.annotationValue.resolve());
                            annotationVisitorVisitAnnotationDefault.visitEnd();
                        } else {
                            throw new IllegalStateException("Cannot set " + this.annotationValue + " as default for " + this.methodDescription);
                        }
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        WithAnnotationDefaultValue withAnnotationDefaultValue = (WithAnnotationDefaultValue) obj;
                        return this.methodDescription.equals(withAnnotationDefaultValue.methodDescription) && this.annotationValue.equals(withAnnotationDefaultValue.annotationValue) && this.methodAttributeAppender.equals(withAnnotationDefaultValue.methodAttributeAppender);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public MethodDescription getMethod() {
                        return this.methodDescription;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Sort getSort() {
                        return Sort.DEFINED;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Visibility getVisibility() {
                        return this.methodDescription.getVisibility();
                    }

                    public int hashCode() {
                        return this.methodAttributeAppender.hashCode() + ((this.annotationValue.hashCode() + com.google.protobuf.a.f(this.methodDescription, getClass().hashCode() * 31, 31)) * 31);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Record prepend(ByteCodeAppender byteCodeAppender) {
                        throw new IllegalStateException("Cannot prepend code for default value on " + this.methodDescription);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithBody extends ForDefinedMethod {
                    private final ByteCodeAppender byteCodeAppender;
                    private final MethodAttributeAppender methodAttributeAppender;
                    private final MethodDescription methodDescription;
                    private final Visibility visibility;

                    public WithBody(MethodDescription methodDescription, ByteCodeAppender byteCodeAppender) {
                        this(methodDescription, byteCodeAppender, MethodAttributeAppender.NoOp.INSTANCE, methodDescription.getVisibility());
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                        MethodAttributeAppender methodAttributeAppender = this.methodAttributeAppender;
                        MethodDescription methodDescription = this.methodDescription;
                        methodAttributeAppender.apply(methodVisitor, methodDescription, factory.on(methodDescription));
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                        applyAttributes(methodVisitor, factory);
                        methodVisitor.visitCode();
                        ByteCodeAppender.Size sizeApplyCode = applyCode(methodVisitor, context);
                        methodVisitor.visitMaxs(sizeApplyCode.getOperandStackSize(), sizeApplyCode.getLocalVariableSize());
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context) {
                        return this.byteCodeAppender.apply(methodVisitor, context, this.methodDescription);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyHead(MethodVisitor methodVisitor) {
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        WithBody withBody = (WithBody) obj;
                        return this.visibility.equals(withBody.visibility) && this.methodDescription.equals(withBody.methodDescription) && this.byteCodeAppender.equals(withBody.byteCodeAppender) && this.methodAttributeAppender.equals(withBody.methodAttributeAppender);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public MethodDescription getMethod() {
                        return this.methodDescription;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Sort getSort() {
                        return Sort.IMPLEMENTED;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Visibility getVisibility() {
                        return this.visibility;
                    }

                    public int hashCode() {
                        return this.visibility.hashCode() + ((this.methodAttributeAppender.hashCode() + ((this.byteCodeAppender.hashCode() + com.google.protobuf.a.f(this.methodDescription, getClass().hashCode() * 31, 31)) * 31)) * 31);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Record prepend(ByteCodeAppender byteCodeAppender) {
                        return new WithBody(this.methodDescription, new ByteCodeAppender.Compound(byteCodeAppender, this.byteCodeAppender), this.methodAttributeAppender, this.visibility);
                    }

                    public WithBody(MethodDescription methodDescription, ByteCodeAppender byteCodeAppender, MethodAttributeAppender methodAttributeAppender, Visibility visibility) {
                        this.methodDescription = methodDescription;
                        this.byteCodeAppender = byteCodeAppender;
                        this.methodAttributeAppender = methodAttributeAppender;
                        this.visibility = visibility;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithoutBody extends ForDefinedMethod {
                    private final MethodAttributeAppender methodAttributeAppender;
                    private final MethodDescription methodDescription;
                    private final Visibility visibility;

                    public WithoutBody(MethodDescription methodDescription, MethodAttributeAppender methodAttributeAppender, Visibility visibility) {
                        this.methodDescription = methodDescription;
                        this.methodAttributeAppender = methodAttributeAppender;
                        this.visibility = visibility;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                        MethodAttributeAppender methodAttributeAppender = this.methodAttributeAppender;
                        MethodDescription methodDescription = this.methodDescription;
                        methodAttributeAppender.apply(methodVisitor, methodDescription, factory.on(methodDescription));
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                        applyAttributes(methodVisitor, factory);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context) {
                        throw new IllegalStateException("Cannot apply code for abstract method on " + this.methodDescription);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public void applyHead(MethodVisitor methodVisitor) {
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        WithoutBody withoutBody = (WithoutBody) obj;
                        return this.visibility.equals(withoutBody.visibility) && this.methodDescription.equals(withoutBody.methodDescription) && this.methodAttributeAppender.equals(withoutBody.methodAttributeAppender);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public MethodDescription getMethod() {
                        return this.methodDescription;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Sort getSort() {
                        return Sort.DEFINED;
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Visibility getVisibility() {
                        return this.visibility;
                    }

                    public int hashCode() {
                        return this.visibility.hashCode() + ((this.methodAttributeAppender.hashCode() + com.google.protobuf.a.f(this.methodDescription, getClass().hashCode() * 31, 31)) * 31);
                    }

                    @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                    public Record prepend(ByteCodeAppender byteCodeAppender) {
                        throw new IllegalStateException("Cannot prepend code for abstract method on " + this.methodDescription);
                    }
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void apply(ClassVisitor classVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                    MethodVisitor methodVisitorVisitMethod = classVisitor.visitMethod(getMethod().getActualModifiers(getSort().isImplemented(), getVisibility()), getMethod().getInternalName(), getMethod().getDescriptor(), getMethod().getGenericSignature(), getMethod().getExceptionTypes().asErasures().toInternalNames());
                    if (methodVisitorVisitMethod != null) {
                        ParameterList<?> parameters = getMethod().getParameters();
                        if (parameters.hasExplicitMetaData()) {
                            Iterator<?> it = parameters.iterator();
                            while (it.hasNext()) {
                                ParameterDescription parameterDescription = (ParameterDescription) it.next();
                                methodVisitorVisitMethod.visitParameter(parameterDescription.getName(), parameterDescription.getModifiers());
                            }
                        }
                        applyHead(methodVisitorVisitMethod);
                        applyBody(methodVisitorVisitMethod, context, factory);
                        methodVisitorVisitMethod.visitEnd();
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForNonImplementedMethod implements Record {
                private final MethodDescription methodDescription;

                public ForNonImplementedMethod(MethodDescription methodDescription) {
                    this.methodDescription = methodDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void apply(ClassVisitor classVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory) {
                    throw new IllegalStateException("Cannot apply body for non-implemented method on " + this.methodDescription);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context) {
                    throw new IllegalStateException("Cannot apply code for non-implemented method on " + this.methodDescription);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void applyHead(MethodVisitor methodVisitor) {
                    throw new IllegalStateException("Cannot apply head for non-implemented method on " + this.methodDescription);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((ForNonImplementedMethod) obj).methodDescription);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public MethodDescription getMethod() {
                    return this.methodDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public Sort getSort() {
                    return Sort.SKIPPED;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public Visibility getVisibility() {
                    return this.methodDescription.getVisibility();
                }

                public int hashCode() {
                    return this.methodDescription.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public Record prepend(ByteCodeAppender byteCodeAppender) {
                    MethodDescription methodDescription = this.methodDescription;
                    return new ForDefinedMethod.WithBody(methodDescription, new ByteCodeAppender.Compound(byteCodeAppender, new ByteCodeAppender.Simple(DefaultValue.of(methodDescription.getReturnType()), MethodReturn.of(this.methodDescription.getReturnType()))));
                }
            }

            public enum Sort {
                SKIPPED(false, false),
                DEFINED(true, false),
                IMPLEMENTED(true, true);

                private final boolean define;
                private final boolean implement;

                Sort(boolean z6, boolean z7) {
                    this.define = z6;
                    this.implement = z7;
                }

                public boolean isDefined() {
                    return this.define;
                }

                public boolean isImplemented() {
                    return this.implement;
                }
            }

            void apply(ClassVisitor classVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory);

            void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory);

            void applyBody(MethodVisitor methodVisitor, Implementation.Context context, AnnotationValueFilter.Factory factory);

            ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Implementation.Context context);

            void applyHead(MethodVisitor methodVisitor);

            MethodDescription getMethod();

            Sort getSort();

            Visibility getVisibility();

            Record prepend(ByteCodeAppender byteCodeAppender);
        }

        Record target(MethodDescription methodDescription);
    }

    DynamicType.Unloaded<T> make(TypeResolutionStrategy.Resolved resolved);

    ContextClassVisitor wrap(ClassVisitor classVisitor, int i, int i3);

    public interface RecordComponentPool {

        public enum Disabled implements RecordComponentPool {
            INSTANCE;

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool
            public Record target(RecordComponentDescription recordComponentDescription) {
                throw new IllegalStateException("Cannot look up record component from disabled pool");
            }
        }

        Record target(RecordComponentDescription recordComponentDescription);

        public interface Record {
            void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory);

            void apply(RecordComponentVisitor recordComponentVisitor, AnnotationValueFilter.Factory factory);

            RecordComponentDescription getRecordComponent();

            RecordComponentAttributeAppender getRecordComponentAppender();

            boolean isImplicit();

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForExplicitRecordComponent implements Record {
                private final RecordComponentAttributeAppender attributeAppender;
                private final RecordComponentDescription recordComponentDescription;

                public ForExplicitRecordComponent(RecordComponentAttributeAppender recordComponentAttributeAppender, RecordComponentDescription recordComponentDescription) {
                    this.attributeAppender = recordComponentAttributeAppender;
                    this.recordComponentDescription = recordComponentDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory) {
                    RecordComponentVisitor recordComponentVisitorVisitRecordComponent = classVisitor.visitRecordComponent(this.recordComponentDescription.getActualName(), this.recordComponentDescription.getDescriptor(), this.recordComponentDescription.getGenericSignature());
                    if (recordComponentVisitorVisitRecordComponent != null) {
                        RecordComponentAttributeAppender recordComponentAttributeAppender = this.attributeAppender;
                        RecordComponentDescription recordComponentDescription = this.recordComponentDescription;
                        recordComponentAttributeAppender.apply(recordComponentVisitorVisitRecordComponent, recordComponentDescription, factory.on(recordComponentDescription));
                        recordComponentVisitorVisitRecordComponent.visitEnd();
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForExplicitRecordComponent forExplicitRecordComponent = (ForExplicitRecordComponent) obj;
                    return this.attributeAppender.equals(forExplicitRecordComponent.attributeAppender) && this.recordComponentDescription.equals(forExplicitRecordComponent.recordComponentDescription);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public RecordComponentDescription getRecordComponent() {
                    return this.recordComponentDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public RecordComponentAttributeAppender getRecordComponentAppender() {
                    return this.attributeAppender;
                }

                public int hashCode() {
                    return this.recordComponentDescription.hashCode() + ((this.attributeAppender.hashCode() + (getClass().hashCode() * 31)) * 31);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public boolean isImplicit() {
                    return false;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public void apply(RecordComponentVisitor recordComponentVisitor, AnnotationValueFilter.Factory factory) {
                    RecordComponentAttributeAppender recordComponentAttributeAppender = this.attributeAppender;
                    RecordComponentDescription recordComponentDescription = this.recordComponentDescription;
                    recordComponentAttributeAppender.apply(recordComponentVisitor, recordComponentDescription, factory.on(recordComponentDescription));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForImplicitRecordComponent implements Record {
                private final RecordComponentDescription recordComponentDescription;

                public ForImplicitRecordComponent(RecordComponentDescription recordComponentDescription) {
                    this.recordComponentDescription = recordComponentDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory) {
                    RecordComponentVisitor recordComponentVisitorVisitRecordComponent = classVisitor.visitRecordComponent(this.recordComponentDescription.getActualName(), this.recordComponentDescription.getDescriptor(), this.recordComponentDescription.getGenericSignature());
                    if (recordComponentVisitorVisitRecordComponent != null) {
                        RecordComponentAttributeAppender.ForInstrumentedRecordComponent forInstrumentedRecordComponent = RecordComponentAttributeAppender.ForInstrumentedRecordComponent.INSTANCE;
                        RecordComponentDescription recordComponentDescription = this.recordComponentDescription;
                        forInstrumentedRecordComponent.apply(recordComponentVisitorVisitRecordComponent, recordComponentDescription, factory.on(recordComponentDescription));
                        recordComponentVisitorVisitRecordComponent.visitEnd();
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.recordComponentDescription.equals(((ForImplicitRecordComponent) obj).recordComponentDescription);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public RecordComponentDescription getRecordComponent() {
                    return this.recordComponentDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public RecordComponentAttributeAppender getRecordComponentAppender() {
                    throw new IllegalStateException("An implicit field record does not expose a field appender: " + this);
                }

                public int hashCode() {
                    return this.recordComponentDescription.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public boolean isImplicit() {
                    return true;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.RecordComponentPool.Record
                public void apply(RecordComponentVisitor recordComponentVisitor, AnnotationValueFilter.Factory factory) {
                    throw new IllegalStateException("An implicit field record is not intended for partial application: " + this);
                }
            }
        }
    }

    public interface FieldPool {

        public enum Disabled implements FieldPool {
            INSTANCE;

            @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool
            public Record target(FieldDescription fieldDescription) {
                throw new IllegalStateException("Cannot look up field from disabled pool");
            }
        }

        Record target(FieldDescription fieldDescription);

        public interface Record {
            void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory);

            void apply(FieldVisitor fieldVisitor, AnnotationValueFilter.Factory factory);

            FieldDescription getField();

            FieldAttributeAppender getFieldAppender();

            boolean isImplicit();

            @MaybeNull
            Object resolveDefault(@MaybeNull Object obj);

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForExplicitField implements Record {
                private final FieldAttributeAppender attributeAppender;

                @MaybeNull
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                private final Object defaultValue;
                private final FieldDescription fieldDescription;

                public ForExplicitField(FieldAttributeAppender fieldAttributeAppender, @MaybeNull Object obj, FieldDescription fieldDescription) {
                    this.attributeAppender = fieldAttributeAppender;
                    this.defaultValue = obj;
                    this.fieldDescription = fieldDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory) {
                    FieldVisitor fieldVisitorVisitField = classVisitor.visitField(this.fieldDescription.getActualModifiers(), this.fieldDescription.getInternalName(), this.fieldDescription.getDescriptor(), this.fieldDescription.getGenericSignature(), resolveDefault(FieldDescription.NO_DEFAULT_VALUE));
                    if (fieldVisitorVisitField != null) {
                        FieldAttributeAppender fieldAttributeAppender = this.attributeAppender;
                        FieldDescription fieldDescription = this.fieldDescription;
                        fieldAttributeAppender.apply(fieldVisitorVisitField, fieldDescription, factory.on(fieldDescription));
                        fieldVisitorVisitField.visitEnd();
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
                
                    if (r2 != null) goto L21;
                 */
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
                        net.bytebuddy.implementation.attribute.FieldAttributeAppender r2 = r4.attributeAppender
                        net.bytebuddy.dynamic.scaffold.TypeWriter$FieldPool$Record$ForExplicitField r5 = (net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record.ForExplicitField) r5
                        net.bytebuddy.implementation.attribute.FieldAttributeAppender r3 = r5.attributeAppender
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L20
                        return r1
                    L20:
                        java.lang.Object r2 = r4.defaultValue
                        java.lang.Object r3 = r5.defaultValue
                        if (r3 == 0) goto L2f
                        if (r2 == 0) goto L31
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L32
                        return r1
                    L2f:
                        if (r2 == 0) goto L32
                    L31:
                        return r1
                    L32:
                        net.bytebuddy.description.field.FieldDescription r2 = r4.fieldDescription
                        net.bytebuddy.description.field.FieldDescription r5 = r5.fieldDescription
                        boolean r5 = r2.equals(r5)
                        if (r5 != 0) goto L3d
                        return r1
                    L3d:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record.ForExplicitField.equals(java.lang.Object):boolean");
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public FieldDescription getField() {
                    return this.fieldDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public FieldAttributeAppender getFieldAppender() {
                    return this.attributeAppender;
                }

                public int hashCode() {
                    int iHashCode = (this.attributeAppender.hashCode() + (getClass().hashCode() * 31)) * 31;
                    Object obj = this.defaultValue;
                    if (obj != null) {
                        iHashCode += obj.hashCode();
                    }
                    return this.fieldDescription.hashCode() + (iHashCode * 31);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public boolean isImplicit() {
                    return false;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                @MaybeNull
                public Object resolveDefault(@MaybeNull Object obj) {
                    Object obj2 = this.defaultValue;
                    return obj2 == null ? obj : obj2;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public void apply(FieldVisitor fieldVisitor, AnnotationValueFilter.Factory factory) {
                    FieldAttributeAppender fieldAttributeAppender = this.attributeAppender;
                    FieldDescription fieldDescription = this.fieldDescription;
                    fieldAttributeAppender.apply(fieldVisitor, fieldDescription, factory.on(fieldDescription));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForImplicitField implements Record {
                private final FieldDescription fieldDescription;

                public ForImplicitField(FieldDescription fieldDescription) {
                    this.fieldDescription = fieldDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public void apply(ClassVisitor classVisitor, AnnotationValueFilter.Factory factory) {
                    FieldVisitor fieldVisitorVisitField = classVisitor.visitField(this.fieldDescription.getActualModifiers(), this.fieldDescription.getInternalName(), this.fieldDescription.getDescriptor(), this.fieldDescription.getGenericSignature(), FieldDescription.NO_DEFAULT_VALUE);
                    if (fieldVisitorVisitField != null) {
                        FieldAttributeAppender.ForInstrumentedField forInstrumentedField = FieldAttributeAppender.ForInstrumentedField.INSTANCE;
                        FieldDescription fieldDescription = this.fieldDescription;
                        forInstrumentedField.apply(fieldVisitorVisitField, fieldDescription, factory.on(fieldDescription));
                        fieldVisitorVisitField.visitEnd();
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((ForImplicitField) obj).fieldDescription);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public FieldDescription getField() {
                    return this.fieldDescription;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public FieldAttributeAppender getFieldAppender() {
                    throw new IllegalStateException("An implicit field record does not expose a field appender: " + this);
                }

                public int hashCode() {
                    return this.fieldDescription.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public boolean isImplicit() {
                    return true;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public Object resolveDefault(@MaybeNull Object obj) {
                    throw new IllegalStateException("An implicit field record does not expose a default value: " + this);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.FieldPool.Record
                public void apply(FieldVisitor fieldVisitor, AnnotationValueFilter.Factory factory) {
                    throw new IllegalStateException("An implicit field record is not intended for partial application: " + this);
                }
            }
        }
    }
}
