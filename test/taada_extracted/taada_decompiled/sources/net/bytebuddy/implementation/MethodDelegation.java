package net.bytebuddy.implementation;

import com.google.protobuf.a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public class MethodDelegation implements Implementation.Composable {
    private final MethodDelegationBinder.AmbiguityResolver ambiguityResolver;
    private final Assigner assigner;
    private final MethodDelegationBinder.BindingResolver bindingResolver;
    private final ImplementationDelegate implementationDelegate;
    private final List<TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders;
    private final MethodDelegationBinder.TerminationHandler terminationHandler;

    @HashCodeAndEqualsPlugin.Enhance
    public static class Appender implements ByteCodeAppender {
        private final Assigner assigner;
        private final ImplementationDelegate.Compiled compiled;
        private final Implementation.Target implementationTarget;
        private final MethodDelegationBinder.Record processor;
        private final MethodDelegationBinder.TerminationHandler terminationHandler;

        public Appender(Implementation.Target target, MethodDelegationBinder.Record record, MethodDelegationBinder.TerminationHandler terminationHandler, Assigner assigner, ImplementationDelegate.Compiled compiled) {
            this.implementationTarget = target;
            this.processor = record;
            this.terminationHandler = terminationHandler;
            this.assigner = assigner;
            this.compiled = compiled;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            return new ByteCodeAppender.Size(new StackManipulation.Compound(this.compiled.prepare(methodDescription), this.processor.bind(this.implementationTarget, methodDescription, this.terminationHandler, this.compiled.invoke(), this.assigner)).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Appender appender = (Appender) obj;
            return this.implementationTarget.equals(appender.implementationTarget) && this.processor.equals(appender.processor) && this.terminationHandler.equals(appender.terminationHandler) && this.assigner.equals(appender.assigner) && this.compiled.equals(appender.compiled);
        }

        public int hashCode() {
            return this.compiled.hashCode() + ((this.assigner.hashCode() + ((this.terminationHandler.hashCode() + ((this.processor.hashCode() + ((this.implementationTarget.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
        }
    }

    public interface ImplementationDelegate extends InstrumentedType.Prepareable {
        public static final String FIELD_NAME_PREFIX = "delegate";

        public interface Compiled {

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForConstruction implements Compiled {
                private final List<MethodDelegationBinder.Record> records;
                private final TypeDescription typeDescription;

                public ForConstruction(TypeDescription typeDescription, List<MethodDelegationBinder.Record> list) {
                    this.typeDescription = typeDescription;
                    this.records = list;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForConstruction forConstruction = (ForConstruction) obj;
                    return this.typeDescription.equals(forConstruction.typeDescription) && this.records.equals(forConstruction.records);
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public List<MethodDelegationBinder.Record> getRecords() {
                    return this.records;
                }

                public int hashCode() {
                    return this.records.hashCode() + a.i(this.typeDescription, getClass().hashCode() * 31, 31);
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public MethodDelegationBinder.MethodInvoker invoke() {
                    return MethodDelegationBinder.MethodInvoker.Simple.INSTANCE;
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public StackManipulation prepare(MethodDescription methodDescription) {
                    return new StackManipulation.Compound(TypeCreation.of(this.typeDescription), Duplication.SINGLE);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForField implements Compiled {
                private final FieldDescription fieldDescription;
                private final List<MethodDelegationBinder.Record> records;

                public ForField(FieldDescription fieldDescription, List<MethodDelegationBinder.Record> list) {
                    this.fieldDescription = fieldDescription;
                    this.records = list;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForField forField = (ForField) obj;
                    return this.fieldDescription.equals(forField.fieldDescription) && this.records.equals(forField.records);
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public List<MethodDelegationBinder.Record> getRecords() {
                    return this.records;
                }

                public int hashCode() {
                    return this.records.hashCode() + ((this.fieldDescription.hashCode() + (getClass().hashCode() * 31)) * 31);
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public MethodDelegationBinder.MethodInvoker invoke() {
                    return new MethodDelegationBinder.MethodInvoker.Virtual(this.fieldDescription.getType().asErasure());
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public StackManipulation prepare(MethodDescription methodDescription) {
                    if (!methodDescription.isStatic() || this.fieldDescription.isStatic()) {
                        return new StackManipulation.Compound(this.fieldDescription.isStatic() ? StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), FieldAccess.forField(this.fieldDescription).read());
                    }
                    throw new IllegalStateException("Cannot read " + this.fieldDescription + " from " + methodDescription);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForMethodReturn implements Compiled {
                private final MethodDescription methodDescription;
                private final List<MethodDelegationBinder.Record> records;

                public ForMethodReturn(MethodDescription methodDescription, List<MethodDelegationBinder.Record> list) {
                    this.methodDescription = methodDescription;
                    this.records = list;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForMethodReturn forMethodReturn = (ForMethodReturn) obj;
                    return this.methodDescription.equals(forMethodReturn.methodDescription) && this.records.equals(forMethodReturn.records);
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public List<MethodDelegationBinder.Record> getRecords() {
                    return this.records;
                }

                public int hashCode() {
                    return this.records.hashCode() + a.f(this.methodDescription, getClass().hashCode() * 31, 31);
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public MethodDelegationBinder.MethodInvoker invoke() {
                    return new MethodDelegationBinder.MethodInvoker.Virtual(this.methodDescription.getReturnType().asErasure());
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public StackManipulation prepare(MethodDescription methodDescription) {
                    if (!methodDescription.isStatic() || this.methodDescription.isStatic()) {
                        return new StackManipulation.Compound(this.methodDescription.isStatic() ? StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), MethodInvocation.invoke(this.methodDescription));
                    }
                    throw new IllegalStateException("Cannot invoke " + this.methodDescription + " from " + methodDescription);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForStaticCall implements Compiled {
                private final List<MethodDelegationBinder.Record> records;

                public ForStaticCall(List<MethodDelegationBinder.Record> list) {
                    this.records = list;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.records.equals(((ForStaticCall) obj).records);
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public List<MethodDelegationBinder.Record> getRecords() {
                    return this.records;
                }

                public int hashCode() {
                    return this.records.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public MethodDelegationBinder.MethodInvoker invoke() {
                    return MethodDelegationBinder.MethodInvoker.Simple.INSTANCE;
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.Compiled
                public StackManipulation prepare(MethodDescription methodDescription) {
                    return StackManipulation.Trivial.INSTANCE;
                }
            }

            List<MethodDelegationBinder.Record> getRecords();

            MethodDelegationBinder.MethodInvoker invoke();

            StackManipulation prepare(MethodDescription methodDescription);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForConstruction implements ImplementationDelegate {
            private final List<MethodDelegationBinder.Record> records;
            private final TypeDescription typeDescription;

            public ForConstruction(TypeDescription typeDescription, List<MethodDelegationBinder.Record> list) {
                this.typeDescription = typeDescription;
                this.records = list;
            }

            public static ImplementationDelegate of(TypeDescription typeDescription, MethodList<?> methodList, MethodDelegationBinder methodDelegationBinder) {
                ArrayList arrayList = new ArrayList(methodList.size());
                Iterator<?> it = methodList.iterator();
                while (it.hasNext()) {
                    arrayList.add(methodDelegationBinder.compile((MethodDescription) it.next()));
                }
                return new ForConstruction(typeDescription, arrayList);
            }

            @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate
            public Compiled compile(TypeDescription typeDescription) {
                return new Compiled.ForConstruction(this.typeDescription, this.records);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForConstruction forConstruction = (ForConstruction) obj;
                return this.typeDescription.equals(forConstruction.typeDescription) && this.records.equals(forConstruction.records);
            }

            public int hashCode() {
                return this.records.hashCode() + a.i(this.typeDescription, getClass().hashCode() * 31, 31);
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class ForField implements ImplementationDelegate {
            protected final String fieldName;
            protected final ElementMatcher<? super MethodDescription> matcher;
            protected final MethodGraph.Compiler methodGraphCompiler;
            protected final List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders;

            @HashCodeAndEqualsPlugin.Enhance
            public static class WithInstance extends ForField {
                private final TypeDescription.Generic fieldType;
                private final Object target;

                public WithInstance(String str, MethodGraph.Compiler compiler, List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> list, ElementMatcher<? super MethodDescription> elementMatcher, Object obj, TypeDescription.Generic generic) {
                    super(str, compiler, list, elementMatcher);
                    this.target = obj;
                    this.fieldType = generic;
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.ForField
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
                    WithInstance withInstance = (WithInstance) obj;
                    return this.target.equals(withInstance.target) && this.fieldType.equals(withInstance.fieldType);
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.ForField
                public int hashCode() {
                    return this.fieldType.hashCode() + ((this.target.hashCode() + (super.hashCode() * 31)) * 31);
                }

                @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType.withAuxiliaryField(new FieldDescription.Token(this.fieldName, 4169, this.fieldType), this.target);
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.ForField
                public FieldDescription resolve(TypeDescription typeDescription) {
                    if (this.fieldType.asErasure().isVisibleTo(typeDescription)) {
                        return (FieldDescription) typeDescription.getDeclaredFields().filter(ElementMatchers.named(this.fieldName).and(ElementMatchers.fieldType(this.fieldType.asErasure()))).getOnly();
                    }
                    throw new IllegalStateException(this.fieldType + " is not visible to " + typeDescription);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class WithLookup extends ForField {
                private final FieldLocator.Factory fieldLocatorFactory;

                public WithLookup(String str, MethodGraph.Compiler compiler, List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> list, ElementMatcher<? super MethodDescription> elementMatcher, FieldLocator.Factory factory) {
                    super(str, compiler, list, elementMatcher);
                    this.fieldLocatorFactory = factory;
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.ForField
                public boolean equals(@MaybeNull Object obj) {
                    if (!super.equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldLocatorFactory.equals(((WithLookup) obj).fieldLocatorFactory);
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.ForField
                public int hashCode() {
                    return this.fieldLocatorFactory.hashCode() + (super.hashCode() * 31);
                }

                @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }

                @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate.ForField
                public FieldDescription resolve(TypeDescription typeDescription) {
                    FieldLocator.Resolution resolutionLocate = this.fieldLocatorFactory.make(typeDescription).locate(this.fieldName);
                    if (resolutionLocate.isResolved()) {
                        return resolutionLocate.getField();
                    }
                    throw new IllegalStateException("Could not locate " + this.fieldName + " on " + typeDescription);
                }
            }

            public ForField(String str, MethodGraph.Compiler compiler, List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> list, ElementMatcher<? super MethodDescription> elementMatcher) {
                this.fieldName = str;
                this.methodGraphCompiler = compiler;
                this.parameterBinders = list;
                this.matcher = elementMatcher;
            }

            @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate
            public Compiled compile(TypeDescription typeDescription) {
                FieldDescription fieldDescriptionResolve = resolve(typeDescription);
                if (!fieldDescriptionResolve.getType().asErasure().isVisibleTo(typeDescription)) {
                    throw new IllegalStateException(fieldDescriptionResolve + " is not visible to " + typeDescription);
                }
                MethodList methodListFilter = this.methodGraphCompiler.compile(fieldDescriptionResolve.getType(), typeDescription).listNodes().asMethodList().filter(this.matcher);
                ArrayList arrayList = new ArrayList(methodListFilter.size());
                MethodDelegationBinder methodDelegationBinderOf = TargetMethodAnnotationDrivenBinder.of(this.parameterBinders);
                Iterator<T> it = methodListFilter.iterator();
                while (it.hasNext()) {
                    arrayList.add(methodDelegationBinderOf.compile((MethodDescription) it.next()));
                }
                return new Compiled.ForField(fieldDescriptionResolve, arrayList);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForField forField = (ForField) obj;
                return this.fieldName.equals(forField.fieldName) && this.methodGraphCompiler.equals(forField.methodGraphCompiler) && this.parameterBinders.equals(forField.parameterBinders) && this.matcher.equals(forField.matcher);
            }

            public int hashCode() {
                return this.matcher.hashCode() + androidx.constraintlayout.core.motion.a.d(this.parameterBinders, (this.methodGraphCompiler.hashCode() + androidx.constraintlayout.core.motion.a.c(getClass().hashCode() * 31, 31, this.fieldName)) * 31, 31);
            }

            public abstract FieldDescription resolve(TypeDescription typeDescription);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMethodReturn implements ImplementationDelegate {
            private final ElementMatcher<? super MethodDescription> matcher;
            private final MethodGraph.Compiler methodGraphCompiler;
            private final String name;
            private final List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders;

            public ForMethodReturn(String str, MethodGraph.Compiler compiler, List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> list, ElementMatcher<? super MethodDescription> elementMatcher) {
                this.name = str;
                this.methodGraphCompiler = compiler;
                this.parameterBinders = list;
                this.matcher = elementMatcher;
            }

            @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate
            public Compiled compile(TypeDescription typeDescription) {
                MethodList methodListFilter = new MethodList.Explicit(CompoundList.of(typeDescription.getDeclaredMethods().filter(ElementMatchers.isStatic().or(ElementMatchers.isPrivate())), (List) this.methodGraphCompiler.compile((TypeDefinition) typeDescription).listNodes().asMethodList())).filter(ElementMatchers.named(this.name).and(ElementMatchers.takesArguments(0)).and(ElementMatchers.not(ElementMatchers.returns(ElementMatchers.isPrimitive().or(ElementMatchers.isArray())))));
                if (methodListFilter.size() != 1) {
                    throw new IllegalStateException(typeDescription + " does not define method without arguments with name " + this.name + ": " + methodListFilter);
                }
                if (!((MethodDescription) methodListFilter.getOnly()).getReturnType().asErasure().isVisibleTo(typeDescription)) {
                    throw new IllegalStateException(methodListFilter.getOnly() + " is not visible to " + typeDescription);
                }
                MethodList methodListFilter2 = this.methodGraphCompiler.compile(((MethodDescription) methodListFilter.getOnly()).getReturnType(), typeDescription).listNodes().asMethodList().filter(this.matcher);
                ArrayList arrayList = new ArrayList(methodListFilter2.size());
                MethodDelegationBinder methodDelegationBinderOf = TargetMethodAnnotationDrivenBinder.of(this.parameterBinders);
                Iterator<T> it = methodListFilter2.iterator();
                while (it.hasNext()) {
                    arrayList.add(methodDelegationBinderOf.compile((MethodDescription) it.next()));
                }
                return new Compiled.ForMethodReturn((MethodDescription) methodListFilter.get(0), arrayList);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForMethodReturn forMethodReturn = (ForMethodReturn) obj;
                return this.name.equals(forMethodReturn.name) && this.methodGraphCompiler.equals(forMethodReturn.methodGraphCompiler) && this.parameterBinders.equals(forMethodReturn.parameterBinders) && this.matcher.equals(forMethodReturn.matcher);
            }

            public int hashCode() {
                return this.matcher.hashCode() + androidx.constraintlayout.core.motion.a.d(this.parameterBinders, (this.methodGraphCompiler.hashCode() + androidx.constraintlayout.core.motion.a.c(getClass().hashCode() * 31, 31, this.name)) * 31, 31);
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForStaticMethod implements ImplementationDelegate {
            private final List<MethodDelegationBinder.Record> records;

            public ForStaticMethod(List<MethodDelegationBinder.Record> list) {
                this.records = list;
            }

            public static ImplementationDelegate of(MethodList<?> methodList, MethodDelegationBinder methodDelegationBinder) {
                ArrayList arrayList = new ArrayList(methodList.size());
                Iterator<?> it = methodList.iterator();
                while (it.hasNext()) {
                    arrayList.add(methodDelegationBinder.compile((MethodDescription) it.next()));
                }
                return new ForStaticMethod(arrayList);
            }

            @Override // net.bytebuddy.implementation.MethodDelegation.ImplementationDelegate
            public Compiled compile(TypeDescription typeDescription) {
                return new Compiled.ForStaticCall(this.records);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.records.equals(((ForStaticMethod) obj).records);
            }

            public int hashCode() {
                return this.records.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }
        }

        Compiled compile(TypeDescription typeDescription);
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class WithCustomProperties {
        private final MethodDelegationBinder.AmbiguityResolver ambiguityResolver;
        private final MethodDelegationBinder.BindingResolver bindingResolver;
        private final ElementMatcher<? super MethodDescription> matcher;
        private final List<TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> parameterBinders;

        public WithCustomProperties(MethodDelegationBinder.AmbiguityResolver ambiguityResolver, List<TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> list) {
            this(ambiguityResolver, list, MethodDelegationBinder.BindingResolver.Default.INSTANCE, ElementMatchers.any());
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WithCustomProperties withCustomProperties = (WithCustomProperties) obj;
            return this.ambiguityResolver.equals(withCustomProperties.ambiguityResolver) && this.parameterBinders.equals(withCustomProperties.parameterBinders) && this.bindingResolver.equals(withCustomProperties.bindingResolver) && this.matcher.equals(withCustomProperties.matcher);
        }

        public WithCustomProperties filter(ElementMatcher<? super MethodDescription> elementMatcher) {
            return new WithCustomProperties(this.ambiguityResolver, this.parameterBinders, this.bindingResolver, new ElementMatcher.Junction.Conjunction(this.matcher, elementMatcher));
        }

        public int hashCode() {
            return this.matcher.hashCode() + ((this.bindingResolver.hashCode() + androidx.constraintlayout.core.motion.a.d(this.parameterBinders, (this.ambiguityResolver.hashCode() + (getClass().hashCode() * 31)) * 31, 31)) * 31);
        }

        public MethodDelegation to(Class<?> cls) {
            return to(TypeDescription.ForLoadedType.of(cls));
        }

        public MethodDelegation toConstructor(Class<?> cls) {
            return toConstructor(TypeDescription.ForLoadedType.of(cls));
        }

        public MethodDelegation toField(String str) {
            return toField(str, FieldLocator.ForClassHierarchy.Factory.INSTANCE);
        }

        public MethodDelegation toMethodReturnOf(String str) {
            return toMethodReturnOf(str, MethodGraph.Compiler.DEFAULT);
        }

        public WithCustomProperties withBinders(TargetMethodAnnotationDrivenBinder.ParameterBinder<?>... parameterBinderArr) {
            return withBinders(Arrays.asList(parameterBinderArr));
        }

        public WithCustomProperties withBindingResolver(MethodDelegationBinder.BindingResolver bindingResolver) {
            return new WithCustomProperties(this.ambiguityResolver, this.parameterBinders, bindingResolver, this.matcher);
        }

        public WithCustomProperties withResolvers(MethodDelegationBinder.AmbiguityResolver... ambiguityResolverArr) {
            return withResolvers(Arrays.asList(ambiguityResolverArr));
        }

        private WithCustomProperties(MethodDelegationBinder.AmbiguityResolver ambiguityResolver, List<TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> list, MethodDelegationBinder.BindingResolver bindingResolver, ElementMatcher<? super MethodDescription> elementMatcher) {
            this.ambiguityResolver = ambiguityResolver;
            this.parameterBinders = list;
            this.bindingResolver = bindingResolver;
            this.matcher = elementMatcher;
        }

        public MethodDelegation to(TypeDescription typeDescription) {
            if (typeDescription.isArray()) {
                throw new IllegalArgumentException(a.m("Cannot delegate to array ", typeDescription));
            }
            if (typeDescription.isPrimitive()) {
                throw new IllegalArgumentException(a.m("Cannot delegate to primitive ", typeDescription));
            }
            return new MethodDelegation(ImplementationDelegate.ForStaticMethod.of(typeDescription.getDeclaredMethods().filter(ElementMatchers.isStatic().and(this.matcher)), TargetMethodAnnotationDrivenBinder.of(this.parameterBinders)), this.parameterBinders, this.ambiguityResolver, this.bindingResolver);
        }

        public MethodDelegation toConstructor(TypeDescription typeDescription) {
            return new MethodDelegation(ImplementationDelegate.ForConstruction.of(typeDescription, typeDescription.getDeclaredMethods().filter(ElementMatchers.isConstructor().and(this.matcher)), TargetMethodAnnotationDrivenBinder.of(this.parameterBinders)), this.parameterBinders, this.ambiguityResolver, this.bindingResolver);
        }

        public MethodDelegation toField(String str, FieldLocator.Factory factory) {
            return toField(str, factory, MethodGraph.Compiler.DEFAULT);
        }

        public MethodDelegation toMethodReturnOf(String str, MethodGraph.Compiler compiler) {
            return new MethodDelegation(new ImplementationDelegate.ForMethodReturn(str, compiler, this.parameterBinders, this.matcher), this.parameterBinders, this.ambiguityResolver, this.bindingResolver);
        }

        public WithCustomProperties withBinders(List<? extends TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> list) {
            return new WithCustomProperties(this.ambiguityResolver, CompoundList.of((List) this.parameterBinders, (List) list), this.bindingResolver, this.matcher);
        }

        public WithCustomProperties withResolvers(List<? extends MethodDelegationBinder.AmbiguityResolver> list) {
            return new WithCustomProperties(new MethodDelegationBinder.AmbiguityResolver.Compound((List<? extends MethodDelegationBinder.AmbiguityResolver>) CompoundList.of(this.ambiguityResolver, list)), this.parameterBinders, this.bindingResolver, this.matcher);
        }

        public MethodDelegation toField(String str, MethodGraph.Compiler compiler) {
            return toField(str, FieldLocator.ForClassHierarchy.Factory.INSTANCE, compiler);
        }

        public MethodDelegation toField(String str, FieldLocator.Factory factory, MethodGraph.Compiler compiler) {
            return new MethodDelegation(new ImplementationDelegate.ForField.WithLookup(str, compiler, this.parameterBinders, this.matcher, factory), this.parameterBinders, this.ambiguityResolver, this.bindingResolver);
        }

        public MethodDelegation to(Object obj) {
            return to(obj, MethodGraph.Compiler.DEFAULT);
        }

        public MethodDelegation to(Object obj, MethodGraph.Compiler compiler) {
            return to(obj, obj.getClass(), compiler);
        }

        public MethodDelegation to(Object obj, String str) {
            return to(obj, str, MethodGraph.Compiler.DEFAULT);
        }

        public MethodDelegation to(Object obj, String str, MethodGraph.Compiler compiler) {
            return to(obj, obj.getClass(), str, compiler);
        }

        public MethodDelegation to(Object obj, Type type) {
            return to(obj, type, MethodGraph.Compiler.DEFAULT);
        }

        public MethodDelegation to(Object obj, Type type, MethodGraph.Compiler compiler) {
            return to(obj, type, "delegate$" + RandomString.hashOf(obj), compiler);
        }

        public MethodDelegation to(Object obj, Type type, String str) {
            return to(obj, type, str, MethodGraph.Compiler.DEFAULT);
        }

        public MethodDelegation to(Object obj, Type type, String str, MethodGraph.Compiler compiler) {
            return to(obj, TypeDefinition.Sort.describe(type), str, compiler);
        }

        public MethodDelegation to(Object obj, TypeDefinition typeDefinition) {
            return to(obj, typeDefinition, MethodGraph.Compiler.DEFAULT);
        }

        public MethodDelegation to(Object obj, TypeDefinition typeDefinition, MethodGraph.Compiler compiler) {
            return to(obj, typeDefinition, "delegate$" + RandomString.hashOf(obj), compiler);
        }

        public MethodDelegation to(Object obj, TypeDefinition typeDefinition, String str) {
            return to(obj, typeDefinition, str, MethodGraph.Compiler.DEFAULT);
        }

        public MethodDelegation to(Object obj, TypeDefinition typeDefinition, String str, MethodGraph.Compiler compiler) {
            if (typeDefinition.asErasure().isInstance(obj)) {
                return new MethodDelegation(new ImplementationDelegate.ForField.WithInstance(str, compiler, this.parameterBinders, this.matcher, obj, typeDefinition.asGenericType()), this.parameterBinders, this.ambiguityResolver, this.bindingResolver);
            }
            throw new IllegalArgumentException(obj + " is not an instance of " + typeDefinition);
        }
    }

    public MethodDelegation(ImplementationDelegate implementationDelegate, List<TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> list, MethodDelegationBinder.AmbiguityResolver ambiguityResolver, MethodDelegationBinder.BindingResolver bindingResolver) {
        this(implementationDelegate, list, ambiguityResolver, MethodDelegationBinder.TerminationHandler.Default.RETURNING, bindingResolver, Assigner.DEFAULT);
    }

    public static MethodDelegation to(Class<?> cls) {
        return withDefaultConfiguration().to(cls);
    }

    public static MethodDelegation toConstructor(Class<?> cls) {
        return withDefaultConfiguration().toConstructor(cls);
    }

    public static MethodDelegation toField(String str) {
        return withDefaultConfiguration().toField(str);
    }

    public static MethodDelegation toMethodReturnOf(String str) {
        return withDefaultConfiguration().toMethodReturnOf(str);
    }

    public static WithCustomProperties withDefaultConfiguration() {
        return new WithCustomProperties(MethodDelegationBinder.AmbiguityResolver.DEFAULT, TargetMethodAnnotationDrivenBinder.ParameterBinder.DEFAULTS);
    }

    public static WithCustomProperties withEmptyConfiguration() {
        return new WithCustomProperties(MethodDelegationBinder.AmbiguityResolver.NoOp.INSTANCE, Collections.EMPTY_LIST);
    }

    @Override // net.bytebuddy.implementation.Implementation.Composable
    public Implementation andThen(Implementation implementation) {
        return new Implementation.Compound(new MethodDelegation(this.implementationDelegate, this.parameterBinders, this.ambiguityResolver, MethodDelegationBinder.TerminationHandler.Default.DROPPING, this.bindingResolver, this.assigner), implementation);
    }

    @Override // net.bytebuddy.implementation.Implementation
    public ByteCodeAppender appender(Implementation.Target target) {
        ImplementationDelegate.Compiled compiledCompile = this.implementationDelegate.compile(target.getInstrumentedType());
        return new Appender(target, new MethodDelegationBinder.Processor(compiledCompile.getRecords(), this.ambiguityResolver, this.bindingResolver), this.terminationHandler, this.assigner, compiledCompile);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MethodDelegation methodDelegation = (MethodDelegation) obj;
        return this.implementationDelegate.equals(methodDelegation.implementationDelegate) && this.parameterBinders.equals(methodDelegation.parameterBinders) && this.ambiguityResolver.equals(methodDelegation.ambiguityResolver) && this.terminationHandler.equals(methodDelegation.terminationHandler) && this.bindingResolver.equals(methodDelegation.bindingResolver) && this.assigner.equals(methodDelegation.assigner);
    }

    public int hashCode() {
        return this.assigner.hashCode() + ((this.bindingResolver.hashCode() + ((this.terminationHandler.hashCode() + ((this.ambiguityResolver.hashCode() + androidx.constraintlayout.core.motion.a.d(this.parameterBinders, (this.implementationDelegate.hashCode() + (getClass().hashCode() * 31)) * 31, 31)) * 31)) * 31)) * 31);
    }

    @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        return this.implementationDelegate.prepare(instrumentedType);
    }

    public Implementation.Composable withAssigner(Assigner assigner) {
        return new MethodDelegation(this.implementationDelegate, this.parameterBinders, this.ambiguityResolver, this.terminationHandler, this.bindingResolver, assigner);
    }

    private MethodDelegation(ImplementationDelegate implementationDelegate, List<TargetMethodAnnotationDrivenBinder.ParameterBinder<?>> list, MethodDelegationBinder.AmbiguityResolver ambiguityResolver, MethodDelegationBinder.TerminationHandler terminationHandler, MethodDelegationBinder.BindingResolver bindingResolver, Assigner assigner) {
        this.implementationDelegate = implementationDelegate;
        this.parameterBinders = list;
        this.terminationHandler = terminationHandler;
        this.ambiguityResolver = ambiguityResolver;
        this.bindingResolver = bindingResolver;
        this.assigner = assigner;
    }

    public static MethodDelegation to(TypeDescription typeDescription) {
        return withDefaultConfiguration().to(typeDescription);
    }

    public static MethodDelegation toConstructor(TypeDescription typeDescription) {
        return withDefaultConfiguration().toConstructor(typeDescription);
    }

    public static MethodDelegation toField(String str, FieldLocator.Factory factory) {
        return withDefaultConfiguration().toField(str, factory);
    }

    public static MethodDelegation toMethodReturnOf(String str, MethodGraph.Compiler compiler) {
        return withDefaultConfiguration().toMethodReturnOf(str, compiler);
    }

    @Override // net.bytebuddy.implementation.Implementation.Composable
    public Implementation.Composable andThen(Implementation.Composable composable) {
        return new Implementation.Compound.Composable(new MethodDelegation(this.implementationDelegate, this.parameterBinders, this.ambiguityResolver, MethodDelegationBinder.TerminationHandler.Default.DROPPING, this.bindingResolver, this.assigner), composable);
    }

    public static MethodDelegation to(Object obj) {
        return withDefaultConfiguration().to(obj);
    }

    public static MethodDelegation toField(String str, MethodGraph.Compiler compiler) {
        return withDefaultConfiguration().toField(str, compiler);
    }

    public static MethodDelegation to(Object obj, MethodGraph.Compiler compiler) {
        return withDefaultConfiguration().to(obj, compiler);
    }

    public static MethodDelegation toField(String str, FieldLocator.Factory factory, MethodGraph.Compiler compiler) {
        return withDefaultConfiguration().toField(str, factory, compiler);
    }

    public static MethodDelegation to(Object obj, String str) {
        return withDefaultConfiguration().to(obj, str);
    }

    public static MethodDelegation to(Object obj, String str, MethodGraph.Compiler compiler) {
        return withDefaultConfiguration().to(obj, str, compiler);
    }

    public static MethodDelegation to(Object obj, Type type) {
        return withDefaultConfiguration().to(obj, type);
    }

    public static MethodDelegation to(Object obj, Type type, MethodGraph.Compiler compiler) {
        return withDefaultConfiguration().to(obj, type, compiler);
    }

    public static MethodDelegation to(Object obj, Type type, String str) {
        return withDefaultConfiguration().to(obj, type, str);
    }

    public static MethodDelegation to(Object obj, Type type, String str, MethodGraph.Compiler compiler) {
        return withDefaultConfiguration().to(obj, type, str, compiler);
    }

    public static MethodDelegation to(Object obj, TypeDefinition typeDefinition) {
        return withDefaultConfiguration().to(obj, typeDefinition);
    }

    public static MethodDelegation to(Object obj, TypeDefinition typeDefinition, MethodGraph.Compiler compiler) {
        return withDefaultConfiguration().to(obj, typeDefinition, compiler);
    }

    public static MethodDelegation to(Object obj, TypeDefinition typeDefinition, String str) {
        return withDefaultConfiguration().to(obj, typeDefinition, str);
    }

    public static MethodDelegation to(Object obj, TypeDefinition typeDefinition, String str, MethodGraph.Compiler compiler) {
        return withDefaultConfiguration().to(obj, typeDefinition, str, compiler);
    }
}
