package net.bytebuddy.implementation;

import B2.b;
import com.google.protobuf.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.TypeInitializer;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.implementation.MethodAccessorFactory;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public interface Implementation extends InstrumentedType.Prepareable {

    public interface Composable extends Implementation {
        Composable andThen(Composable composable);

        Implementation andThen(Implementation implementation);
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Compound implements Implementation {
        private final List<Implementation> implementations;

        @HashCodeAndEqualsPlugin.Enhance
        public static class Composable implements Composable {
            private final Composable composable;
            private final List<Implementation> implementations;

            public Composable(Implementation implementation, Composable composable) {
                this((List<? extends Implementation>) Collections.singletonList(implementation), composable);
            }

            @Override // net.bytebuddy.implementation.Implementation.Composable
            public Implementation andThen(Implementation implementation) {
                return new Compound((List<? extends Implementation>) CompoundList.of(this.implementations, this.composable.andThen(implementation)));
            }

            @Override // net.bytebuddy.implementation.Implementation
            public ByteCodeAppender appender(Target target) {
                ByteCodeAppender[] byteCodeAppenderArr = new ByteCodeAppender[this.implementations.size() + 1];
                Iterator<Implementation> it = this.implementations.iterator();
                int i = 0;
                while (it.hasNext()) {
                    byteCodeAppenderArr[i] = it.next().appender(target);
                    i++;
                }
                byteCodeAppenderArr[i] = this.composable.appender(target);
                return new ByteCodeAppender.Compound(byteCodeAppenderArr);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Composable composable = (Composable) obj;
                return this.composable.equals(composable.composable) && this.implementations.equals(composable.implementations);
            }

            public int hashCode() {
                return this.implementations.hashCode() + ((this.composable.hashCode() + (getClass().hashCode() * 31)) * 31);
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                Iterator<Implementation> it = this.implementations.iterator();
                while (it.hasNext()) {
                    instrumentedType = it.next().prepare(instrumentedType);
                }
                return this.composable.prepare(instrumentedType);
            }

            public Composable(List<? extends Implementation> list, Composable composable) {
                this.implementations = new ArrayList();
                for (Implementation implementation : list) {
                    if (implementation instanceof Composable) {
                        Composable composable2 = (Composable) implementation;
                        this.implementations.addAll(composable2.implementations);
                        this.implementations.add(composable2.composable);
                    } else if (implementation instanceof Compound) {
                        this.implementations.addAll(((Compound) implementation).implementations);
                    } else {
                        this.implementations.add(implementation);
                    }
                }
                if (!(composable instanceof Composable)) {
                    this.composable = composable;
                    return;
                }
                Composable composable3 = (Composable) composable;
                this.implementations.addAll(composable3.implementations);
                this.composable = composable3.composable;
            }

            @Override // net.bytebuddy.implementation.Implementation.Composable
            public Composable andThen(Composable composable) {
                return new Composable(this.implementations, this.composable.andThen(composable));
            }
        }

        public Compound(Implementation... implementationArr) {
            this((List<? extends Implementation>) Arrays.asList(implementationArr));
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Target target) {
            ByteCodeAppender[] byteCodeAppenderArr = new ByteCodeAppender[this.implementations.size()];
            Iterator<Implementation> it = this.implementations.iterator();
            int i = 0;
            while (it.hasNext()) {
                byteCodeAppenderArr[i] = it.next().appender(target);
                i++;
            }
            return new ByteCodeAppender.Compound(byteCodeAppenderArr);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.implementations.equals(((Compound) obj).implementations);
        }

        public int hashCode() {
            return this.implementations.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            Iterator<Implementation> it = this.implementations.iterator();
            while (it.hasNext()) {
                instrumentedType = it.next().prepare(instrumentedType);
            }
            return instrumentedType;
        }

        public Compound(List<? extends Implementation> list) {
            this.implementations = new ArrayList();
            for (Implementation implementation : list) {
                if (implementation instanceof Composable) {
                    Composable composable = (Composable) implementation;
                    this.implementations.addAll(composable.implementations);
                    this.implementations.add(composable.composable);
                } else if (implementation instanceof Compound) {
                    this.implementations.addAll(((Compound) implementation).implementations);
                } else {
                    this.implementations.add(implementation);
                }
            }
        }
    }

    public interface Context extends MethodAccessorFactory {

        public static class Default extends ExtractableView.AbstractBase {
            public static final String ACCESSOR_METHOD_SUFFIX = "accessor";
            public static final String FIELD_CACHE_PREFIX = "cachedValue";
            private final ClassFileVersion auxiliaryClassFileVersion;
            private final AuxiliaryType.NamingStrategy auxiliaryTypeNamingStrategy;
            private final Map<AuxiliaryType, DynamicType> auxiliaryTypes;
            private boolean fieldCacheCanAppendEntries;
            private final Map<SpecialMethodInvocation, DelegationRecord> registeredAccessorMethods;
            private final Map<FieldCacheEntry, FieldDescription.InDefinedShape> registeredFieldCacheEntries;
            private final Set<FieldDescription.InDefinedShape> registeredFieldCacheFields;
            private final Map<FieldDescription, DelegationRecord> registeredGetters;
            private final Map<FieldDescription, DelegationRecord> registeredSetters;
            private final String suffix;
            private final TypeInitializer typeInitializer;

            public static abstract class AbstractPropertyAccessorMethod extends MethodDescription.InDefinedShape.AbstractBase {
                public abstract int getBaseModifiers();

                @Override // net.bytebuddy.description.ModifierReviewable
                public int getModifiers() {
                    return getBaseModifiers() | 4096 | (getDeclaringType().isInterface() ? 1 : 16);
                }
            }

            public static class AccessorMethod extends AbstractPropertyAccessorMethod {
                private final TypeDescription instrumentedType;
                private final MethodDescription methodDescription;
                private final String name;

                public AccessorMethod(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, String str) {
                    String str2;
                    this.instrumentedType = typeDescription;
                    this.methodDescription = methodDescription;
                    StringBuilder sb = new StringBuilder();
                    sb.append(methodDescription.getInternalName());
                    sb.append("$accessor$");
                    sb.append(str);
                    if (typeDescription2.isInterface()) {
                        str2 = "$" + RandomString.hashOf(typeDescription2.hashCode());
                    } else {
                        str2 = "";
                    }
                    sb.append(str2);
                    this.name = sb.toString();
                }

                @Override // net.bytebuddy.implementation.Implementation.Context.Default.AbstractPropertyAccessorMethod
                public int getBaseModifiers() {
                    return this.methodDescription.isStatic() ? 8 : 0;
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
                    return this.methodDescription.getExceptionTypes().asRawTypes();
                }

                @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                public String getInternalName() {
                    return this.name;
                }

                @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
                public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                    return new ParameterList.Explicit.ForTypes(this, this.methodDescription.getParameters().asTypeList().asRawTypes());
                }

                @Override // net.bytebuddy.description.method.MethodDescription
                public TypeDescription.Generic getReturnType() {
                    return this.methodDescription.getReturnType().asRawType();
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

            public static class CacheValueField extends FieldDescription.InDefinedShape.AbstractBase {
                private final TypeDescription.Generic fieldType;
                private final TypeDescription instrumentedType;
                private final String name;

                public CacheValueField(TypeDescription typeDescription, TypeDescription.Generic generic, String str, int i) {
                    this.instrumentedType = typeDescription;
                    this.fieldType = generic;
                    StringBuilder sbM = b.m("cachedValue$", str, "$");
                    sbM.append(RandomString.hashOf(i));
                    this.name = sbM.toString();
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                @Override // net.bytebuddy.description.ModifierReviewable
                public int getModifiers() {
                    return (this.instrumentedType.isInterface() ? 1 : 2) | 4120;
                }

                @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                public String getName() {
                    return this.name;
                }

                @Override // net.bytebuddy.description.field.FieldDescription
                public TypeDescription.Generic getType() {
                    return this.fieldType;
                }

                @Override // net.bytebuddy.description.DeclaredByType
                @Nonnull
                public TypeDescription getDeclaringType() {
                    return this.instrumentedType;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class DelegationRecord extends TypeWriter.MethodPool.Record.ForDefinedMethod implements ByteCodeAppender {
                protected final MethodDescription.InDefinedShape methodDescription;
                protected final Visibility visibility;

                public DelegationRecord(MethodDescription.InDefinedShape inDefinedShape, Visibility visibility) {
                    this.methodDescription = inDefinedShape;
                    this.visibility = visibility;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void applyAttributes(MethodVisitor methodVisitor, AnnotationValueFilter.Factory factory) {
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public void applyBody(MethodVisitor methodVisitor, Context context, AnnotationValueFilter.Factory factory) {
                    methodVisitor.visitCode();
                    ByteCodeAppender.Size sizeApplyCode = applyCode(methodVisitor, context);
                    methodVisitor.visitMaxs(sizeApplyCode.getOperandStackSize(), sizeApplyCode.getLocalVariableSize());
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public ByteCodeAppender.Size applyCode(MethodVisitor methodVisitor, Context context) {
                    return apply(methodVisitor, context, getMethod());
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
                    DelegationRecord delegationRecord = (DelegationRecord) obj;
                    return this.visibility.equals(delegationRecord.visibility) && this.methodDescription.equals(delegationRecord.methodDescription);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public TypeWriter.MethodPool.Record.Sort getSort() {
                    return TypeWriter.MethodPool.Record.Sort.IMPLEMENTED;
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public Visibility getVisibility() {
                    return this.visibility;
                }

                public int hashCode() {
                    return this.visibility.hashCode() + ((this.methodDescription.hashCode() + (getClass().hashCode() * 31)) * 31);
                }

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public TypeWriter.MethodPool.Record prepend(ByteCodeAppender byteCodeAppender) {
                    throw new UnsupportedOperationException("Cannot prepend code to a delegation for " + this.methodDescription);
                }

                public abstract DelegationRecord with(MethodAccessorFactory.AccessType accessType);

                @Override // net.bytebuddy.dynamic.scaffold.TypeWriter.MethodPool.Record
                public MethodDescription.InDefinedShape getMethod() {
                    return this.methodDescription;
                }
            }

            public static class FieldCacheEntry implements StackManipulation {
                private final TypeDescription fieldType;
                private final StackManipulation fieldValue;

                public FieldCacheEntry(StackManipulation stackManipulation, TypeDescription typeDescription) {
                    this.fieldValue = stackManipulation;
                    this.fieldType = typeDescription;
                }

                @Override // net.bytebuddy.implementation.bytecode.StackManipulation
                public StackManipulation.Size apply(MethodVisitor methodVisitor, Context context) {
                    return this.fieldValue.apply(methodVisitor, context);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj != null && getClass() == obj.getClass()) {
                        FieldCacheEntry fieldCacheEntry = (FieldCacheEntry) obj;
                        if (this.fieldValue.equals(fieldCacheEntry.fieldValue) && this.fieldType.equals(fieldCacheEntry.fieldType)) {
                            return true;
                        }
                    }
                    return false;
                }

                public TypeDescription getFieldType() {
                    return this.fieldType;
                }

                public int hashCode() {
                    return this.fieldType.hashCode() + (this.fieldValue.hashCode() * 31);
                }

                @Override // net.bytebuddy.implementation.bytecode.StackManipulation
                public boolean isValid() {
                    return this.fieldValue.isValid();
                }

                public ByteCodeAppender storeIn(FieldDescription fieldDescription) {
                    return new ByteCodeAppender.Simple(this, FieldAccess.forField(fieldDescription).write());
                }
            }

            public static class FieldGetter extends AbstractPropertyAccessorMethod {
                private final FieldDescription fieldDescription;
                private final TypeDescription instrumentedType;
                private final String name;

                public FieldGetter(TypeDescription typeDescription, FieldDescription fieldDescription, String str) {
                    this.instrumentedType = typeDescription;
                    this.fieldDescription = fieldDescription;
                    this.name = fieldDescription.getName() + "$accessor$" + str;
                }

                @Override // net.bytebuddy.implementation.Implementation.Context.Default.AbstractPropertyAccessorMethod
                public int getBaseModifiers() {
                    return this.fieldDescription.isStatic() ? 8 : 0;
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
                    return new TypeList.Generic.Empty();
                }

                @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                public String getInternalName() {
                    return this.name;
                }

                @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
                public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                    return new ParameterList.Empty();
                }

                @Override // net.bytebuddy.description.method.MethodDescription
                public TypeDescription.Generic getReturnType() {
                    return this.fieldDescription.getType().asRawType();
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

            @HashCodeAndEqualsPlugin.Enhance
            public static class FieldGetterDelegation extends DelegationRecord {
                private final FieldDescription fieldDescription;

                public FieldGetterDelegation(TypeDescription typeDescription, String str, MethodAccessorFactory.AccessType accessType, FieldDescription fieldDescription) {
                    this(new FieldGetter(typeDescription, fieldDescription, str), accessType.getVisibility(), fieldDescription);
                }

                @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
                public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Context context, MethodDescription methodDescription) {
                    return new ByteCodeAppender.Size(new StackManipulation.Compound(this.fieldDescription.isStatic() ? StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), FieldAccess.forField(this.fieldDescription).read(), MethodReturn.of(this.fieldDescription.getType())).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                }

                @Override // net.bytebuddy.implementation.Implementation.Context.Default.DelegationRecord
                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((FieldGetterDelegation) obj).fieldDescription);
                }

                @Override // net.bytebuddy.implementation.Implementation.Context.Default.DelegationRecord
                public int hashCode() {
                    return this.fieldDescription.hashCode() + (super.hashCode() * 31);
                }

                @Override // net.bytebuddy.implementation.Implementation.Context.Default.DelegationRecord
                public DelegationRecord with(MethodAccessorFactory.AccessType accessType) {
                    return new FieldGetterDelegation(this.methodDescription, this.visibility.expandTo(accessType.getVisibility()), this.fieldDescription);
                }

                private FieldGetterDelegation(MethodDescription.InDefinedShape inDefinedShape, Visibility visibility, FieldDescription fieldDescription) {
                    super(inDefinedShape, visibility);
                    this.fieldDescription = fieldDescription;
                }
            }

            public static class FieldSetter extends AbstractPropertyAccessorMethod {
                private final FieldDescription fieldDescription;
                private final TypeDescription instrumentedType;
                private final String name;

                public FieldSetter(TypeDescription typeDescription, FieldDescription fieldDescription, String str) {
                    this.instrumentedType = typeDescription;
                    this.fieldDescription = fieldDescription;
                    this.name = fieldDescription.getName() + "$accessor$" + str;
                }

                @Override // net.bytebuddy.implementation.Implementation.Context.Default.AbstractPropertyAccessorMethod
                public int getBaseModifiers() {
                    return this.fieldDescription.isStatic() ? 8 : 0;
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
                    return new TypeList.Generic.Empty();
                }

                @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                public String getInternalName() {
                    return this.name;
                }

                @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
                public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                    return new ParameterList.Explicit.ForTypes(this, (List<? extends TypeDefinition>) Collections.singletonList(this.fieldDescription.getType().asRawType()));
                }

                @Override // net.bytebuddy.description.method.MethodDescription
                public TypeDescription.Generic getReturnType() {
                    return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Void.TYPE);
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

            @HashCodeAndEqualsPlugin.Enhance
            public static class FieldSetterDelegation extends DelegationRecord {
                private final FieldDescription fieldDescription;

                public FieldSetterDelegation(TypeDescription typeDescription, String str, MethodAccessorFactory.AccessType accessType, FieldDescription fieldDescription) {
                    this(new FieldSetter(typeDescription, fieldDescription, str), accessType.getVisibility(), fieldDescription);
                }

                @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
                public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Context context, MethodDescription methodDescription) {
                    return new ByteCodeAppender.Size(new StackManipulation.Compound(MethodVariableAccess.allArgumentsOf(methodDescription).prependThisReference(), FieldAccess.forField(this.fieldDescription).write(), MethodReturn.VOID).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                }

                @Override // net.bytebuddy.implementation.Implementation.Context.Default.DelegationRecord
                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((FieldSetterDelegation) obj).fieldDescription);
                }

                @Override // net.bytebuddy.implementation.Implementation.Context.Default.DelegationRecord
                public int hashCode() {
                    return this.fieldDescription.hashCode() + (super.hashCode() * 31);
                }

                @Override // net.bytebuddy.implementation.Implementation.Context.Default.DelegationRecord
                public DelegationRecord with(MethodAccessorFactory.AccessType accessType) {
                    return new FieldSetterDelegation(this.methodDescription, this.visibility.expandTo(accessType.getVisibility()), this.fieldDescription);
                }

                private FieldSetterDelegation(MethodDescription.InDefinedShape inDefinedShape, Visibility visibility, FieldDescription fieldDescription) {
                    super(inDefinedShape, visibility);
                    this.fieldDescription = fieldDescription;
                }
            }

            public Default(TypeDescription typeDescription, ClassFileVersion classFileVersion, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion2, FrameGeneration frameGeneration, String str) {
                super(typeDescription, classFileVersion, frameGeneration);
                this.auxiliaryTypeNamingStrategy = namingStrategy;
                this.typeInitializer = typeInitializer;
                this.auxiliaryClassFileVersion = classFileVersion2;
                this.suffix = str;
                this.registeredAccessorMethods = new HashMap();
                this.registeredGetters = new HashMap();
                this.registeredSetters = new HashMap();
                this.auxiliaryTypes = new HashMap();
                this.registeredFieldCacheEntries = new HashMap();
                this.registeredFieldCacheFields = new HashSet();
                this.fieldCacheCanAppendEntries = true;
            }

            @Override // net.bytebuddy.implementation.Implementation.Context
            public FieldDescription.InDefinedShape cache(StackManipulation stackManipulation, TypeDescription typeDescription) {
                FieldCacheEntry fieldCacheEntry = new FieldCacheEntry(stackManipulation, typeDescription);
                FieldDescription.InDefinedShape inDefinedShape = this.registeredFieldCacheEntries.get(fieldCacheEntry);
                if (inDefinedShape != null) {
                    return inDefinedShape;
                }
                if (!this.fieldCacheCanAppendEntries) {
                    throw new IllegalStateException("Cached values cannot be registered after defining the type initializer for " + this.instrumentedType);
                }
                int iHashCode = stackManipulation.hashCode();
                while (true) {
                    int i = iHashCode + 1;
                    CacheValueField cacheValueField = new CacheValueField(this.instrumentedType, typeDescription.asGenericType(), this.suffix, iHashCode);
                    if (this.registeredFieldCacheFields.add(cacheValueField)) {
                        this.registeredFieldCacheEntries.put(fieldCacheEntry, cacheValueField);
                        return cacheValueField;
                    }
                    iHashCode = i;
                }
            }

            @Override // net.bytebuddy.implementation.Implementation.Context.ExtractableView
            public void drain(TypeInitializer.Drain drain, ClassVisitor classVisitor, AnnotationValueFilter.Factory factory) {
                this.fieldCacheCanAppendEntries = false;
                TypeInitializer typeInitializerExpandWith = this.typeInitializer;
                for (Map.Entry<FieldCacheEntry, FieldDescription.InDefinedShape> entry : this.registeredFieldCacheEntries.entrySet()) {
                    ClassVisitor classVisitor2 = classVisitor;
                    FieldVisitor fieldVisitorVisitField = classVisitor2.visitField(entry.getValue().getModifiers(), entry.getValue().getInternalName(), entry.getValue().getDescriptor(), entry.getValue().getGenericSignature(), FieldDescription.NO_DEFAULT_VALUE);
                    if (fieldVisitorVisitField != null) {
                        fieldVisitorVisitField.visitEnd();
                        typeInitializerExpandWith = typeInitializerExpandWith.expandWith(entry.getKey().storeIn(entry.getValue()));
                    }
                    classVisitor = classVisitor2;
                }
                ClassVisitor classVisitor3 = classVisitor;
                drain.apply(classVisitor3, typeInitializerExpandWith, this);
                Iterator<DelegationRecord> it = this.registeredAccessorMethods.values().iterator();
                while (it.hasNext()) {
                    it.next().apply(classVisitor3, this, factory);
                }
                Iterator<DelegationRecord> it2 = this.registeredGetters.values().iterator();
                while (it2.hasNext()) {
                    it2.next().apply(classVisitor3, this, factory);
                }
                Iterator<DelegationRecord> it3 = this.registeredSetters.values().iterator();
                while (it3.hasNext()) {
                    it3.next().apply(classVisitor3, this, factory);
                }
            }

            @Override // net.bytebuddy.implementation.Implementation.Context.ExtractableView
            public List<DynamicType> getAuxiliaryTypes() {
                return new ArrayList(this.auxiliaryTypes.values());
            }

            @Override // net.bytebuddy.implementation.Implementation.Context.ExtractableView
            public boolean isEnabled() {
                return true;
            }

            @Override // net.bytebuddy.implementation.Implementation.Context
            public TypeDescription register(AuxiliaryType auxiliaryType) {
                DynamicType dynamicTypeMake = this.auxiliaryTypes.get(auxiliaryType);
                if (dynamicTypeMake == null) {
                    dynamicTypeMake = auxiliaryType.make(this.auxiliaryTypeNamingStrategy.name(this.instrumentedType, auxiliaryType), this.auxiliaryClassFileVersion, this);
                    this.auxiliaryTypes.put(auxiliaryType, dynamicTypeMake);
                }
                return dynamicTypeMake.getTypeDescription();
            }

            @Override // net.bytebuddy.implementation.MethodAccessorFactory
            public MethodDescription.InDefinedShape registerAccessorFor(SpecialMethodInvocation specialMethodInvocation, MethodAccessorFactory.AccessType accessType) {
                DelegationRecord delegationRecord = this.registeredAccessorMethods.get(specialMethodInvocation);
                DelegationRecord accessorMethodDelegation = delegationRecord == null ? new AccessorMethodDelegation(this.instrumentedType, this.suffix, accessType, specialMethodInvocation) : delegationRecord.with(accessType);
                this.registeredAccessorMethods.put(specialMethodInvocation, accessorMethodDelegation);
                return accessorMethodDelegation.getMethod();
            }

            @Override // net.bytebuddy.implementation.MethodAccessorFactory
            public MethodDescription.InDefinedShape registerGetterFor(FieldDescription fieldDescription, MethodAccessorFactory.AccessType accessType) {
                DelegationRecord delegationRecord = this.registeredGetters.get(fieldDescription);
                DelegationRecord fieldGetterDelegation = delegationRecord == null ? new FieldGetterDelegation(this.instrumentedType, this.suffix, accessType, fieldDescription) : delegationRecord.with(accessType);
                this.registeredGetters.put(fieldDescription, fieldGetterDelegation);
                return fieldGetterDelegation.getMethod();
            }

            @Override // net.bytebuddy.implementation.MethodAccessorFactory
            public MethodDescription.InDefinedShape registerSetterFor(FieldDescription fieldDescription, MethodAccessorFactory.AccessType accessType) {
                DelegationRecord delegationRecord = this.registeredSetters.get(fieldDescription);
                DelegationRecord fieldSetterDelegation = delegationRecord == null ? new FieldSetterDelegation(this.instrumentedType, this.suffix, accessType, fieldDescription) : delegationRecord.with(accessType);
                this.registeredSetters.put(fieldDescription, fieldSetterDelegation);
                return fieldSetterDelegation.getMethod();
            }

            public enum Factory implements Factory {
                INSTANCE;

                @Override // net.bytebuddy.implementation.Implementation.Context.Factory
                @Deprecated
                public ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2) {
                    return make(typeDescription, namingStrategy, typeInitializer, classFileVersion, classFileVersion2, classFileVersion.isAtLeast(ClassFileVersion.JAVA_V6) ? FrameGeneration.GENERATE : FrameGeneration.DISABLED);
                }

                @HashCodeAndEqualsPlugin.Enhance
                public static class WithFixedSuffix implements Factory {
                    private final String suffix;

                    public WithFixedSuffix(String str) {
                        this.suffix = str;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.suffix.equals(((WithFixedSuffix) obj).suffix);
                    }

                    public int hashCode() {
                        return this.suffix.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.implementation.Implementation.Context.Factory
                    @Deprecated
                    public ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2) {
                        return make(typeDescription, namingStrategy, typeInitializer, classFileVersion, classFileVersion2, classFileVersion.isAtLeast(ClassFileVersion.JAVA_V6) ? FrameGeneration.GENERATE : FrameGeneration.DISABLED);
                    }

                    @Override // net.bytebuddy.implementation.Implementation.Context.Factory
                    public ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2, FrameGeneration frameGeneration) {
                        return new Default(typeDescription, classFileVersion, namingStrategy, typeInitializer, classFileVersion2, frameGeneration, this.suffix);
                    }
                }

                @Override // net.bytebuddy.implementation.Implementation.Context.Factory
                public ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2, FrameGeneration frameGeneration) {
                    return new Default(typeDescription, classFileVersion, namingStrategy, typeInitializer, classFileVersion2, frameGeneration, RandomString.make());
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class AccessorMethodDelegation extends DelegationRecord {
                private final StackManipulation accessorMethodInvocation;

                public AccessorMethodDelegation(TypeDescription typeDescription, String str, MethodAccessorFactory.AccessType accessType, SpecialMethodInvocation specialMethodInvocation) {
                    this(new AccessorMethod(typeDescription, specialMethodInvocation.getMethodDescription(), specialMethodInvocation.getTypeDescription(), str), accessType.getVisibility(), specialMethodInvocation);
                }

                @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
                public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Context context, MethodDescription methodDescription) {
                    return new ByteCodeAppender.Size(new StackManipulation.Compound(MethodVariableAccess.allArgumentsOf(methodDescription).prependThisReference(), this.accessorMethodInvocation, MethodReturn.of(methodDescription.getReturnType())).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                }

                @Override // net.bytebuddy.implementation.Implementation.Context.Default.DelegationRecord
                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.accessorMethodInvocation.equals(((AccessorMethodDelegation) obj).accessorMethodInvocation);
                }

                @Override // net.bytebuddy.implementation.Implementation.Context.Default.DelegationRecord
                public int hashCode() {
                    return this.accessorMethodInvocation.hashCode() + (super.hashCode() * 31);
                }

                @Override // net.bytebuddy.implementation.Implementation.Context.Default.DelegationRecord
                public DelegationRecord with(MethodAccessorFactory.AccessType accessType) {
                    return new AccessorMethodDelegation(this.methodDescription, this.visibility.expandTo(accessType.getVisibility()), this.accessorMethodInvocation);
                }

                private AccessorMethodDelegation(MethodDescription.InDefinedShape inDefinedShape, Visibility visibility, StackManipulation stackManipulation) {
                    super(inDefinedShape, visibility);
                    this.accessorMethodInvocation = stackManipulation;
                }
            }
        }

        public interface ExtractableView extends Context {

            @HashCodeAndEqualsPlugin.Enhance
            public static abstract class AbstractBase implements ExtractableView {
                protected final ClassFileVersion classFileVersion;
                protected final FrameGeneration frameGeneration;
                protected final TypeDescription instrumentedType;

                public AbstractBase(TypeDescription typeDescription, ClassFileVersion classFileVersion, FrameGeneration frameGeneration) {
                    this.instrumentedType = typeDescription;
                    this.classFileVersion = classFileVersion;
                    this.frameGeneration = frameGeneration;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    AbstractBase abstractBase = (AbstractBase) obj;
                    return this.frameGeneration.equals(abstractBase.frameGeneration) && this.instrumentedType.equals(abstractBase.instrumentedType) && this.classFileVersion.equals(abstractBase.classFileVersion);
                }

                @Override // net.bytebuddy.implementation.Implementation.Context
                public ClassFileVersion getClassFileVersion() {
                    return this.classFileVersion;
                }

                @Override // net.bytebuddy.implementation.Implementation.Context
                public FrameGeneration getFrameGeneration() {
                    return this.frameGeneration;
                }

                @Override // net.bytebuddy.implementation.Implementation.Context
                public TypeDescription getInstrumentedType() {
                    return this.instrumentedType;
                }

                public int hashCode() {
                    return this.frameGeneration.hashCode() + ((this.classFileVersion.hashCode() + a.i(this.instrumentedType, getClass().hashCode() * 31, 31)) * 31);
                }
            }

            void drain(TypeInitializer.Drain drain, ClassVisitor classVisitor, AnnotationValueFilter.Factory factory);

            List<DynamicType> getAuxiliaryTypes();

            boolean isEnabled();
        }

        public interface Factory {
            @Deprecated
            ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2);

            ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2, FrameGeneration frameGeneration);
        }

        public enum FrameGeneration {
            GENERATE(true) { // from class: net.bytebuddy.implementation.Implementation.Context.FrameGeneration.1
                @Override // net.bytebuddy.implementation.Implementation.Context.FrameGeneration
                public void generate(MethodVisitor methodVisitor, int i, int i3, @MaybeNull Object[] objArr, int i4, @MaybeNull Object[] objArr2, int i5, @MaybeNull Object[] objArr3) {
                    methodVisitor.visitFrame(i, i4, objArr2, i3, objArr);
                }
            },
            EXPAND(1 == true ? 1 : 0) { // from class: net.bytebuddy.implementation.Implementation.Context.FrameGeneration.2
                @Override // net.bytebuddy.implementation.Implementation.Context.FrameGeneration
                public void generate(MethodVisitor methodVisitor, int i, int i3, @MaybeNull Object[] objArr, int i4, @MaybeNull Object[] objArr2, int i5, @MaybeNull Object[] objArr3) {
                    methodVisitor.visitFrame(-1, i5, objArr3, i3, objArr);
                }
            },
            DISABLED(0 == true ? 1 : 0) { // from class: net.bytebuddy.implementation.Implementation.Context.FrameGeneration.3
                @Override // net.bytebuddy.implementation.Implementation.Context.FrameGeneration
                public void generate(MethodVisitor methodVisitor, int i, int i3, @MaybeNull Object[] objArr, int i4, @MaybeNull Object[] objArr2, int i5, @MaybeNull Object[] objArr3) {
                }
            };

            private static final Object[] EMPTY = new Object[0];
            private final boolean active;

            private static Object toStackMapFrame(TypeDefinition typeDefinition) {
                return (typeDefinition.represents(Boolean.TYPE) || typeDefinition.represents(Byte.TYPE) || typeDefinition.represents(Short.TYPE) || typeDefinition.represents(Character.TYPE) || typeDefinition.represents(Integer.TYPE)) ? Opcodes.INTEGER : typeDefinition.represents(Long.TYPE) ? Opcodes.LONG : typeDefinition.represents(Float.TYPE) ? Opcodes.FLOAT : typeDefinition.represents(Double.TYPE) ? Opcodes.DOUBLE : typeDefinition.asErasure().getInternalName();
            }

            private static Object[] toStackMapFrames(List<? extends TypeDefinition> list) {
                Object[] objArr = list.isEmpty() ? EMPTY : new Object[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    objArr[i] = toStackMapFrame(list.get(i));
                }
                return objArr;
            }

            public void append(MethodVisitor methodVisitor, List<? extends TypeDefinition> list, List<? extends TypeDefinition> list2) {
                Object[] objArr = EMPTY;
                generate(methodVisitor, 1, objArr.length, objArr, list.size(), toStackMapFrames(list), list.size() + list2.size(), toStackMapFrames(CompoundList.of((List) list2, (List) list)));
            }

            public void chop(MethodVisitor methodVisitor, int i, List<? extends TypeDefinition> list) {
                Object[] objArr = EMPTY;
                generate(methodVisitor, 2, objArr.length, objArr, i, objArr, list.size(), toStackMapFrames(list));
            }

            public void full(MethodVisitor methodVisitor, List<? extends TypeDefinition> list, List<? extends TypeDefinition> list2) {
                generate(methodVisitor, 0, list.size(), toStackMapFrames(list), list2.size(), toStackMapFrames(list2), list2.size(), toStackMapFrames(list2));
            }

            public abstract void generate(MethodVisitor methodVisitor, int i, int i3, @MaybeNull Object[] objArr, int i4, @MaybeNull Object[] objArr2, int i5, @MaybeNull Object[] objArr3);

            public boolean isActive() {
                return this.active;
            }

            public void same(MethodVisitor methodVisitor, List<? extends TypeDefinition> list) {
                Object[] objArr = EMPTY;
                generate(methodVisitor, 3, objArr.length, objArr, objArr.length, objArr, list.size(), toStackMapFrames(list));
            }

            public void same1(MethodVisitor methodVisitor, TypeDefinition typeDefinition, List<? extends TypeDefinition> list) {
                Object[] objArr = {toStackMapFrame(typeDefinition)};
                Object[] objArr2 = EMPTY;
                generate(methodVisitor, 4, 1, objArr, objArr2.length, objArr2, list.size(), toStackMapFrames(list));
            }

            FrameGeneration(boolean z6) {
                this.active = z6;
            }
        }

        FieldDescription.InDefinedShape cache(StackManipulation stackManipulation, TypeDescription typeDescription);

        ClassFileVersion getClassFileVersion();

        FrameGeneration getFrameGeneration();

        TypeDescription getInstrumentedType();

        TypeDescription register(AuxiliaryType auxiliaryType);

        public static class Disabled extends ExtractableView.AbstractBase {
            public Disabled(TypeDescription typeDescription, ClassFileVersion classFileVersion, FrameGeneration frameGeneration) {
                super(typeDescription, classFileVersion, frameGeneration);
            }

            @Override // net.bytebuddy.implementation.Implementation.Context
            public FieldDescription.InDefinedShape cache(StackManipulation stackManipulation, TypeDescription typeDescription) {
                throw new IllegalStateException(a.m("Field values caching was disabled: ", typeDescription));
            }

            @Override // net.bytebuddy.implementation.Implementation.Context.ExtractableView
            public void drain(TypeInitializer.Drain drain, ClassVisitor classVisitor, AnnotationValueFilter.Factory factory) {
                drain.apply(classVisitor, TypeInitializer.None.INSTANCE, this);
            }

            @Override // net.bytebuddy.implementation.Implementation.Context.ExtractableView
            public List<DynamicType> getAuxiliaryTypes() {
                return Collections.EMPTY_LIST;
            }

            @Override // net.bytebuddy.implementation.Implementation.Context.ExtractableView
            public boolean isEnabled() {
                return false;
            }

            @Override // net.bytebuddy.implementation.Implementation.Context
            public TypeDescription register(AuxiliaryType auxiliaryType) {
                throw new IllegalStateException("Registration of auxiliary types was disabled: " + auxiliaryType);
            }

            @Override // net.bytebuddy.implementation.MethodAccessorFactory
            public MethodDescription.InDefinedShape registerAccessorFor(SpecialMethodInvocation specialMethodInvocation, MethodAccessorFactory.AccessType accessType) {
                throw new IllegalStateException("Registration of method accessors was disabled: " + specialMethodInvocation.getMethodDescription());
            }

            @Override // net.bytebuddy.implementation.MethodAccessorFactory
            public MethodDescription.InDefinedShape registerGetterFor(FieldDescription fieldDescription, MethodAccessorFactory.AccessType accessType) {
                throw new IllegalStateException("Registration of field accessor was disabled: " + fieldDescription);
            }

            @Override // net.bytebuddy.implementation.MethodAccessorFactory
            public MethodDescription.InDefinedShape registerSetterFor(FieldDescription fieldDescription, MethodAccessorFactory.AccessType accessType) {
                throw new IllegalStateException("Registration of field accessor was disabled: " + fieldDescription);
            }

            public enum Factory implements Factory {
                INSTANCE;

                @Override // net.bytebuddy.implementation.Implementation.Context.Factory
                @Deprecated
                public ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2) {
                    return make(typeDescription, namingStrategy, typeInitializer, classFileVersion, classFileVersion2, classFileVersion.isAtLeast(ClassFileVersion.JAVA_V6) ? FrameGeneration.GENERATE : FrameGeneration.DISABLED);
                }

                @Override // net.bytebuddy.implementation.Implementation.Context.Factory
                public ExtractableView make(TypeDescription typeDescription, AuxiliaryType.NamingStrategy namingStrategy, TypeInitializer typeInitializer, ClassFileVersion classFileVersion, ClassFileVersion classFileVersion2, FrameGeneration frameGeneration) {
                    if (!typeInitializer.isDefined()) {
                        return new Disabled(typeDescription, classFileVersion, frameGeneration);
                    }
                    throw new IllegalStateException("Cannot define type initializer which was explicitly disabled: " + typeInitializer);
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Simple implements Implementation {
        private static final int NO_ADDITIONAL_VARIABLES = 0;
        private final ByteCodeAppender byteCodeAppender;

        public interface Dispatcher {
            StackManipulation apply(Target target, MethodDescription methodDescription);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForDispatcher implements Implementation {
            private final int additionalVariableLength;
            private final Dispatcher dispatcher;
            private final InstrumentedType.Prepareable prepareable;

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            public class Appender implements ByteCodeAppender {
                private final Target implementationTarget;

                public Appender(Target target) {
                    this.implementationTarget = target;
                }

                @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
                public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Context context, MethodDescription methodDescription) {
                    return new ByteCodeAppender.Size(ForDispatcher.this.dispatcher.apply(this.implementationTarget, methodDescription).apply(methodVisitor, context).getMaximalSize(), ForDispatcher.this.additionalVariableLength + methodDescription.getStackSize());
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Appender appender = (Appender) obj;
                    return this.implementationTarget.equals(appender.implementationTarget) && ForDispatcher.this.equals(ForDispatcher.this);
                }

                public int hashCode() {
                    return ForDispatcher.this.hashCode() + ((this.implementationTarget.hashCode() + (getClass().hashCode() * 31)) * 31);
                }
            }

            public ForDispatcher(Dispatcher dispatcher, InstrumentedType.Prepareable prepareable, int i) {
                this.dispatcher = dispatcher;
                this.prepareable = prepareable;
                this.additionalVariableLength = i;
            }

            @Override // net.bytebuddy.implementation.Implementation
            public ByteCodeAppender appender(Target target) {
                return new Appender(target);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForDispatcher forDispatcher = (ForDispatcher) obj;
                return this.additionalVariableLength == forDispatcher.additionalVariableLength && this.dispatcher.equals(forDispatcher.dispatcher) && this.prepareable.equals(forDispatcher.prepareable);
            }

            public int hashCode() {
                return ((this.prepareable.hashCode() + ((this.dispatcher.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31) + this.additionalVariableLength;
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return this.prepareable.prepare(instrumentedType);
            }
        }

        public Simple(ByteCodeAppender... byteCodeAppenderArr) {
            this.byteCodeAppender = new ByteCodeAppender.Compound(byteCodeAppenderArr);
        }

        public static Implementation of(Dispatcher dispatcher) {
            return of(dispatcher, 0);
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Target target) {
            return this.byteCodeAppender;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.byteCodeAppender.equals(((Simple) obj).byteCodeAppender);
        }

        public int hashCode() {
            return this.byteCodeAppender.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        public static Implementation of(Dispatcher dispatcher, int i) {
            return of(dispatcher, InstrumentedType.Prepareable.NoOp.INSTANCE, i);
        }

        public Simple(StackManipulation... stackManipulationArr) {
            this.byteCodeAppender = new ByteCodeAppender.Simple(stackManipulationArr);
        }

        public static Implementation of(Dispatcher dispatcher, InstrumentedType.Prepareable prepareable) {
            return of(dispatcher, prepareable, 0);
        }

        public static Implementation of(Dispatcher dispatcher, InstrumentedType.Prepareable prepareable, int i) {
            if (i >= 0) {
                return new ForDispatcher(dispatcher, prepareable, i);
            }
            throw new IllegalArgumentException(b.c(i, "Additional variable length cannot be negative: "));
        }
    }

    public interface SpecialMethodInvocation extends StackManipulation {

        public static abstract class AbstractBase extends StackManipulation.AbstractBase implements SpecialMethodInvocation {
            private transient /* synthetic */ int hashCode;

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SpecialMethodInvocation)) {
                    return false;
                }
                SpecialMethodInvocation specialMethodInvocation = (SpecialMethodInvocation) obj;
                return getMethodDescription().asSignatureToken().equals(specialMethodInvocation.getMethodDescription().asSignatureToken()) && getTypeDescription().equals(specialMethodInvocation.getTypeDescription());
            }

            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int iHashCode = this.hashCode != 0 ? 0 : (getMethodDescription().asSignatureToken().hashCode() * 31) + getTypeDescription().hashCode();
                if (iHashCode == 0) {
                    return this.hashCode;
                }
                this.hashCode = iHashCode;
                return iHashCode;
            }
        }

        public enum Illegal implements SpecialMethodInvocation {
            INSTANCE;

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Context context) {
                throw new IllegalStateException("Cannot implement an undefined method");
            }

            @Override // net.bytebuddy.implementation.Implementation.SpecialMethodInvocation
            public MethodDescription getMethodDescription() {
                throw new IllegalStateException("An illegal special method invocation must not be applied");
            }

            @Override // net.bytebuddy.implementation.Implementation.SpecialMethodInvocation
            public TypeDescription getTypeDescription() {
                throw new IllegalStateException("An illegal special method invocation must not be applied");
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public boolean isValid() {
                return false;
            }

            @Override // net.bytebuddy.implementation.Implementation.SpecialMethodInvocation
            public SpecialMethodInvocation withCheckedCompatibilityTo(MethodDescription.TypeToken typeToken) {
                return this;
            }
        }

        public static class Simple extends AbstractBase {
            private final MethodDescription methodDescription;
            private final StackManipulation stackManipulation;
            private final TypeDescription typeDescription;

            public Simple(MethodDescription methodDescription, TypeDescription typeDescription, StackManipulation stackManipulation) {
                this.methodDescription = methodDescription;
                this.typeDescription = typeDescription;
                this.stackManipulation = stackManipulation;
            }

            public static SpecialMethodInvocation of(MethodDescription methodDescription, TypeDescription typeDescription) {
                StackManipulation stackManipulationSpecial = MethodInvocation.invoke(methodDescription).special(typeDescription);
                return stackManipulationSpecial.isValid() ? new Simple(methodDescription, typeDescription, stackManipulationSpecial) : Illegal.INSTANCE;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Context context) {
                return this.stackManipulation.apply(methodVisitor, context);
            }

            @Override // net.bytebuddy.implementation.Implementation.SpecialMethodInvocation
            public MethodDescription getMethodDescription() {
                return this.methodDescription;
            }

            @Override // net.bytebuddy.implementation.Implementation.SpecialMethodInvocation
            public TypeDescription getTypeDescription() {
                return this.typeDescription;
            }

            @Override // net.bytebuddy.implementation.Implementation.SpecialMethodInvocation
            public SpecialMethodInvocation withCheckedCompatibilityTo(MethodDescription.TypeToken typeToken) {
                return this.methodDescription.asTypeToken().equals(typeToken) ? this : Illegal.INSTANCE;
            }
        }

        MethodDescription getMethodDescription();

        TypeDescription getTypeDescription();

        SpecialMethodInvocation withCheckedCompatibilityTo(MethodDescription.TypeToken typeToken);
    }

    ByteCodeAppender appender(Target target);

    public interface Target {

        public interface Factory {
            Target make(TypeDescription typeDescription, MethodGraph.Linked linked, ClassFileVersion classFileVersion);
        }

        TypeDescription getInstrumentedType();

        TypeDefinition getOriginType();

        SpecialMethodInvocation invokeDefault(MethodDescription.SignatureToken signatureToken);

        SpecialMethodInvocation invokeDefault(MethodDescription.SignatureToken signatureToken, TypeDescription typeDescription);

        SpecialMethodInvocation invokeDominant(MethodDescription.SignatureToken signatureToken);

        SpecialMethodInvocation invokeSuper(MethodDescription.SignatureToken signatureToken);

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class AbstractBase implements Target {
            protected final DefaultMethodInvocation defaultMethodInvocation;
            protected final TypeDescription instrumentedType;
            protected final MethodGraph.Linked methodGraph;

            public enum DefaultMethodInvocation {
                ENABLED { // from class: net.bytebuddy.implementation.Implementation.Target.AbstractBase.DefaultMethodInvocation.1
                    @Override // net.bytebuddy.implementation.Implementation.Target.AbstractBase.DefaultMethodInvocation
                    public SpecialMethodInvocation apply(MethodGraph.Node node, TypeDescription typeDescription) {
                        return node.getSort().isUnique() ? SpecialMethodInvocation.Simple.of(node.getRepresentative(), typeDescription) : SpecialMethodInvocation.Illegal.INSTANCE;
                    }
                },
                DISABLED { // from class: net.bytebuddy.implementation.Implementation.Target.AbstractBase.DefaultMethodInvocation.2
                    @Override // net.bytebuddy.implementation.Implementation.Target.AbstractBase.DefaultMethodInvocation
                    public SpecialMethodInvocation apply(MethodGraph.Node node, TypeDescription typeDescription) {
                        return SpecialMethodInvocation.Illegal.INSTANCE;
                    }
                };

                public static DefaultMethodInvocation of(ClassFileVersion classFileVersion) {
                    return classFileVersion.isAtLeast(ClassFileVersion.JAVA_V8) ? ENABLED : DISABLED;
                }

                public abstract SpecialMethodInvocation apply(MethodGraph.Node node, TypeDescription typeDescription);
            }

            public AbstractBase(TypeDescription typeDescription, MethodGraph.Linked linked, DefaultMethodInvocation defaultMethodInvocation) {
                this.instrumentedType = typeDescription;
                this.methodGraph = linked;
                this.defaultMethodInvocation = defaultMethodInvocation;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                AbstractBase abstractBase = (AbstractBase) obj;
                return this.defaultMethodInvocation.equals(abstractBase.defaultMethodInvocation) && this.instrumentedType.equals(abstractBase.instrumentedType) && this.methodGraph.equals(abstractBase.methodGraph);
            }

            @Override // net.bytebuddy.implementation.Implementation.Target
            public TypeDescription getInstrumentedType() {
                return this.instrumentedType;
            }

            public int hashCode() {
                return this.defaultMethodInvocation.hashCode() + ((this.methodGraph.hashCode() + a.i(this.instrumentedType, getClass().hashCode() * 31, 31)) * 31);
            }

            @Override // net.bytebuddy.implementation.Implementation.Target
            public SpecialMethodInvocation invokeDefault(MethodDescription.SignatureToken signatureToken) {
                SpecialMethodInvocation specialMethodInvocation = SpecialMethodInvocation.Illegal.INSTANCE;
                Iterator<TypeDescription> it = this.instrumentedType.getInterfaces().asErasures().iterator();
                while (it.hasNext()) {
                    SpecialMethodInvocation specialMethodInvocationWithCheckedCompatibilityTo = invokeDefault(signatureToken, it.next()).withCheckedCompatibilityTo(signatureToken.asTypeToken());
                    if (specialMethodInvocationWithCheckedCompatibilityTo.isValid()) {
                        if (specialMethodInvocation.isValid()) {
                            return SpecialMethodInvocation.Illegal.INSTANCE;
                        }
                        specialMethodInvocation = specialMethodInvocationWithCheckedCompatibilityTo;
                    }
                }
                return specialMethodInvocation;
            }

            @Override // net.bytebuddy.implementation.Implementation.Target
            public SpecialMethodInvocation invokeDominant(MethodDescription.SignatureToken signatureToken) {
                SpecialMethodInvocation specialMethodInvocationInvokeSuper = invokeSuper(signatureToken);
                return specialMethodInvocationInvokeSuper.isValid() ? specialMethodInvocationInvokeSuper : invokeDefault(signatureToken);
            }

            @Override // net.bytebuddy.implementation.Implementation.Target
            public SpecialMethodInvocation invokeDefault(MethodDescription.SignatureToken signatureToken, TypeDescription typeDescription) {
                return this.defaultMethodInvocation.apply(this.methodGraph.getInterfaceGraph(typeDescription).locate(signatureToken), typeDescription);
            }
        }
    }
}
