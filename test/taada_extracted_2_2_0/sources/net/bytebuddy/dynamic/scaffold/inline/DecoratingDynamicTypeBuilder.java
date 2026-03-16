package net.bytebuddy.dynamic.scaffold.inline;

import androidx.constraintlayout.core.motion.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeVariableToken;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.Transformer;
import net.bytebuddy.dynamic.scaffold.ClassWriterStrategy;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.attribute.AnnotationRetention;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.TypeAttributeAppender;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.LatentMatcher;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public class DecoratingDynamicTypeBuilder<T> extends DynamicType.Builder.AbstractBase.UsingTypeWriter<T> {
    private final AnnotationRetention annotationRetention;
    private final AnnotationValueFilter.Factory annotationValueFilterFactory;
    private final AsmVisitorWrapper asmVisitorWrapper;
    private final AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy;
    private final List<DynamicType> auxiliaryTypes;
    private final ClassFileLocator classFileLocator;
    private final ClassFileVersion classFileVersion;
    private final ClassWriterStrategy classWriterStrategy;
    private final LatentMatcher<? super MethodDescription> ignoredMethods;
    private final Implementation.Context.Factory implementationContextFactory;
    private final TypeDescription instrumentedType;
    private final MethodGraph.Compiler methodGraphCompiler;
    private final TypeAttributeAppender typeAttributeAppender;
    private final TypeValidation typeValidation;

    public DecoratingDynamicTypeBuilder(TypeDescription typeDescription, ClassFileVersion classFileVersion, AuxiliaryType.NamingStrategy namingStrategy, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, Implementation.Context.Factory factory2, MethodGraph.Compiler compiler, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, LatentMatcher<? super MethodDescription> latentMatcher, ClassFileLocator classFileLocator) {
        TypeDescription typeDescription2;
        TypeAttributeAppender differentiating;
        if (annotationRetention.isEnabled()) {
            typeDescription2 = typeDescription;
            differentiating = new TypeAttributeAppender.ForInstrumentedType.Differentiating(typeDescription2);
        } else {
            typeDescription2 = typeDescription;
            differentiating = TypeAttributeAppender.ForInstrumentedType.INSTANCE;
        }
        this(typeDescription2, differentiating, AsmVisitorWrapper.NoOp.INSTANCE, classFileVersion, namingStrategy, factory, annotationRetention, factory2, compiler, typeValidation, classWriterStrategy, latentMatcher, Collections.EMPTY_LIST, classFileLocator);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder<T> annotateType(Collection<? extends AnnotationDescription> collection) {
        return attribute(new TypeAttributeAppender.Explicit(new ArrayList(collection)));
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder<T> attribute(TypeAttributeAppender typeAttributeAppender) {
        return new DecoratingDynamicTypeBuilder(this.instrumentedType, new TypeAttributeAppender.Compound(this.typeAttributeAppender, typeAttributeAppender), this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes, this.classFileLocator);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder<T> declaredTypes(Collection<? extends TypeDescription> collection) {
        throw new UnsupportedOperationException("Cannot change type declaration of decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial<T> defineConstructor(int i) {
        throw new UnsupportedOperationException("Cannot define constructor for decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder.FieldDefinition.Optional.Valuable<T> defineField(String str, TypeDefinition typeDefinition, int i) {
        throw new UnsupportedOperationException("Cannot define field for decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial<T> defineMethod(String str, TypeDefinition typeDefinition, int i) {
        throw new UnsupportedOperationException("Cannot define method for decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder.RecordComponentDefinition.Optional<T> defineRecordComponent(String str, TypeDefinition typeDefinition) {
        throw new UnsupportedOperationException("Cannot define record component for decorated type: " + this.instrumentedType);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DecoratingDynamicTypeBuilder decoratingDynamicTypeBuilder = (DecoratingDynamicTypeBuilder) obj;
        return this.annotationRetention.equals(decoratingDynamicTypeBuilder.annotationRetention) && this.typeValidation.equals(decoratingDynamicTypeBuilder.typeValidation) && this.instrumentedType.equals(decoratingDynamicTypeBuilder.instrumentedType) && this.typeAttributeAppender.equals(decoratingDynamicTypeBuilder.typeAttributeAppender) && this.asmVisitorWrapper.equals(decoratingDynamicTypeBuilder.asmVisitorWrapper) && this.classFileVersion.equals(decoratingDynamicTypeBuilder.classFileVersion) && this.auxiliaryTypeNamingStrategy.equals(decoratingDynamicTypeBuilder.auxiliaryTypeNamingStrategy) && this.annotationValueFilterFactory.equals(decoratingDynamicTypeBuilder.annotationValueFilterFactory) && this.implementationContextFactory.equals(decoratingDynamicTypeBuilder.implementationContextFactory) && this.methodGraphCompiler.equals(decoratingDynamicTypeBuilder.methodGraphCompiler) && this.classWriterStrategy.equals(decoratingDynamicTypeBuilder.classWriterStrategy) && this.ignoredMethods.equals(decoratingDynamicTypeBuilder.ignoredMethods) && this.auxiliaryTypes.equals(decoratingDynamicTypeBuilder.auxiliaryTypes) && this.classFileLocator.equals(decoratingDynamicTypeBuilder.classFileLocator);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder.FieldDefinition.Valuable<T> field(LatentMatcher<? super FieldDescription> latentMatcher) {
        throw new UnsupportedOperationException("Cannot change field for decorated type: " + this.instrumentedType);
    }

    public int hashCode() {
        return this.classFileLocator.hashCode() + a.d(this.auxiliaryTypes, (this.ignoredMethods.hashCode() + ((this.classWriterStrategy.hashCode() + ((this.typeValidation.hashCode() + ((this.methodGraphCompiler.hashCode() + ((this.implementationContextFactory.hashCode() + ((this.annotationRetention.hashCode() + ((this.annotationValueFilterFactory.hashCode() + ((this.auxiliaryTypeNamingStrategy.hashCode() + ((this.classFileVersion.hashCode() + ((this.asmVisitorWrapper.hashCode() + ((this.typeAttributeAppender.hashCode() + com.google.protobuf.a.i(this.instrumentedType, getClass().hashCode() * 31, 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31, 31);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder<T> ignoreAlso(LatentMatcher<? super MethodDescription> latentMatcher) {
        return new DecoratingDynamicTypeBuilder(this.instrumentedType, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.classWriterStrategy, new LatentMatcher.Disjunction(this.ignoredMethods, latentMatcher), this.auxiliaryTypes, this.classFileLocator);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional<T> implement(Collection<? extends TypeDefinition> collection) {
        throw new UnsupportedOperationException("Cannot implement interface for decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder<T> initializer(ByteCodeAppender byteCodeAppender) {
        throw new UnsupportedOperationException("Cannot add initializer of decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder.InnerTypeDefinition.ForType<T> innerTypeOf(TypeDescription typeDescription) {
        throw new UnsupportedOperationException("Cannot change type declaration of decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder.MethodDefinition.ImplementationDefinition<T> invokable(LatentMatcher<? super MethodDescription> latentMatcher) {
        throw new UnsupportedOperationException("Cannot intercept method for decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder<T> merge(Collection<? extends ModifierContributor.ForType> collection) {
        throw new UnsupportedOperationException("Cannot change modifiers of decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder<T> modifiers(int i) {
        throw new UnsupportedOperationException("Cannot change modifiers of decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder<T> name(String str) {
        throw new UnsupportedOperationException("Cannot change name of decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder<T> nestHost(TypeDescription typeDescription) {
        throw new UnsupportedOperationException("Cannot change type declaration of decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder<T> nestMembers(Collection<? extends TypeDescription> collection) {
        throw new UnsupportedOperationException("Cannot change type declaration of decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder<T> permittedSubclass(Collection<? extends TypeDescription> collection) {
        throw new UnsupportedOperationException("Cannot change permitted subclasses of decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder.RecordComponentDefinition<T> recordComponent(LatentMatcher<? super RecordComponentDescription> latentMatcher) {
        throw new UnsupportedOperationException("Cannot change record component for decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder<T> require(Collection<DynamicType> collection) {
        return new DecoratingDynamicTypeBuilder(this.instrumentedType, this.typeAttributeAppender, this.asmVisitorWrapper, this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.classWriterStrategy, this.ignoredMethods, CompoundList.of((List) this.auxiliaryTypes, (List) new ArrayList(collection)), this.classFileLocator);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder<T> suffix(String str) {
        throw new UnsupportedOperationException("Cannot change name of decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public TypeDescription toTypeDescription() {
        return this.instrumentedType;
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.UsingTypeWriter
    public TypeWriter<T> toTypeWriter() {
        return toTypeWriter(TypePool.Empty.INSTANCE);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder<T> topLevelType() {
        throw new UnsupportedOperationException("Cannot change type declaration of decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder<T> transform(ElementMatcher<? super TypeDescription.Generic> elementMatcher, Transformer<TypeVariableToken> transformer) {
        throw new UnsupportedOperationException("Cannot transform decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder.TypeVariableDefinition<T> typeVariable(String str, Collection<? extends TypeDefinition> collection) {
        throw new UnsupportedOperationException("Cannot add type variable to decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder<T> unsealed() {
        throw new UnsupportedOperationException("Cannot unseal decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder<T> visit(AsmVisitorWrapper asmVisitorWrapper) {
        return new DecoratingDynamicTypeBuilder(this.instrumentedType, this.typeAttributeAppender, new AsmVisitorWrapper.Compound(this.asmVisitorWrapper, asmVisitorWrapper), this.classFileVersion, this.auxiliaryTypeNamingStrategy, this.annotationValueFilterFactory, this.annotationRetention, this.implementationContextFactory, this.methodGraphCompiler, this.typeValidation, this.classWriterStrategy, this.ignoredMethods, this.auxiliaryTypes, this.classFileLocator);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder<T> initializer(LoadedTypeInitializer loadedTypeInitializer) {
        throw new UnsupportedOperationException("Cannot add initializer of decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder
    public DynamicType.Builder.InnerTypeDefinition<T> innerTypeOf(MethodDescription.InDefinedShape inDefinedShape) {
        throw new UnsupportedOperationException("Cannot change type declaration of decorated type: " + this.instrumentedType);
    }

    @Override // net.bytebuddy.dynamic.DynamicType.Builder.AbstractBase.UsingTypeWriter
    public TypeWriter<T> toTypeWriter(TypePool typePool) {
        TypeDescription typeDescription = this.instrumentedType;
        return TypeWriter.Default.forDecoration(typeDescription, this.classFileVersion, this.auxiliaryTypes, CompoundList.of((List) this.methodGraphCompiler.compile((TypeDefinition) typeDescription).listNodes().asMethodList().filter(ElementMatchers.not(this.ignoredMethods.resolve(this.instrumentedType))), (List) this.instrumentedType.getDeclaredMethods().filter(ElementMatchers.not(ElementMatchers.isVirtual()))), this.typeAttributeAppender, this.asmVisitorWrapper, this.annotationValueFilterFactory, this.annotationRetention, this.auxiliaryTypeNamingStrategy, this.implementationContextFactory, this.typeValidation, this.classWriterStrategy, typePool, this.classFileLocator);
    }

    public DecoratingDynamicTypeBuilder(TypeDescription typeDescription, TypeAttributeAppender typeAttributeAppender, AsmVisitorWrapper asmVisitorWrapper, ClassFileVersion classFileVersion, AuxiliaryType.NamingStrategy namingStrategy, AnnotationValueFilter.Factory factory, AnnotationRetention annotationRetention, Implementation.Context.Factory factory2, MethodGraph.Compiler compiler, TypeValidation typeValidation, ClassWriterStrategy classWriterStrategy, LatentMatcher<? super MethodDescription> latentMatcher, List<DynamicType> list, ClassFileLocator classFileLocator) {
        this.instrumentedType = typeDescription;
        this.typeAttributeAppender = typeAttributeAppender;
        this.asmVisitorWrapper = asmVisitorWrapper;
        this.classFileVersion = classFileVersion;
        this.auxiliaryTypeNamingStrategy = namingStrategy;
        this.annotationValueFilterFactory = factory;
        this.annotationRetention = annotationRetention;
        this.implementationContextFactory = factory2;
        this.methodGraphCompiler = compiler;
        this.typeValidation = typeValidation;
        this.classWriterStrategy = classWriterStrategy;
        this.ignoredMethods = latentMatcher;
        this.auxiliaryTypes = list;
        this.classFileLocator = classFileLocator;
    }
}
