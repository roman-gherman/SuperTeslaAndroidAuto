package net.bytebuddy.implementation;

import com.google.protobuf.a;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.assign.InstanceCheck;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public class EqualsMethod implements Implementation {
    private static final MethodDescription.InDefinedShape EQUALS = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(Object.class).getDeclaredMethods().filter(ElementMatchers.isEquals()).getOnly();
    private final Comparator<? super FieldDescription.InDefinedShape> comparator;
    private final ElementMatcher.Junction<? super FieldDescription.InDefinedShape> ignored;
    private final ElementMatcher.Junction<? super FieldDescription.InDefinedShape> nonNullable;
    private final SuperClassCheck superClassCheck;
    private final TypeCompatibilityCheck typeCompatibilityCheck;

    @HashCodeAndEqualsPlugin.Enhance
    public static class Appender implements ByteCodeAppender {
        private final StackManipulation baseline;
        private final List<FieldDescription.InDefinedShape> fieldDescriptions;
        private final TypeDescription instrumentedType;
        private final ElementMatcher<? super FieldDescription.InDefinedShape> nonNullable;

        public Appender(TypeDescription typeDescription, StackManipulation stackManipulation, List<FieldDescription.InDefinedShape> list, ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher) {
            this.instrumentedType = typeDescription;
            this.baseline = stackManipulation;
            this.fieldDescriptions = list;
            this.nonNullable = elementMatcher;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            if (methodDescription.isStatic()) {
                throw new IllegalStateException(a.l("Hash code method must not be static: ", methodDescription));
            }
            if (methodDescription.getParameters().size() != 1 || ((ParameterDescription) methodDescription.getParameters().getOnly()).getType().isPrimitive()) {
                throw new IllegalStateException();
            }
            if (!methodDescription.getReturnType().represents(Boolean.TYPE)) {
                throw new IllegalStateException(a.l("Hash code method does not return primitive boolean: ", methodDescription));
            }
            ArrayList arrayList = new ArrayList((this.fieldDescriptions.size() * 8) + 3);
            arrayList.add(this.baseline);
            int iMax = 0;
            for (FieldDescription.InDefinedShape inDefinedShape : this.fieldDescriptions) {
                arrayList.add(MethodVariableAccess.loadThis());
                arrayList.add(FieldAccess.forField(inDefinedShape).read());
                arrayList.add(MethodVariableAccess.REFERENCE.loadFrom(1));
                arrayList.add(TypeCasting.to(this.instrumentedType));
                arrayList.add(FieldAccess.forField(inDefinedShape).read());
                NullValueGuard usingJump = (inDefinedShape.getType().isPrimitive() || inDefinedShape.getType().isArray() || this.nonNullable.matches(inDefinedShape)) ? NullValueGuard.NoOp.INSTANCE : new NullValueGuard.UsingJump(methodDescription);
                arrayList.add(usingJump.before());
                arrayList.add(ValueComparator.of(inDefinedShape.getType()));
                arrayList.add(usingJump.after());
                iMax = Math.max(iMax, usingJump.getRequiredVariablePadding());
            }
            arrayList.add(IntegerConstant.forValue(true));
            arrayList.add(MethodReturn.INTEGER);
            return new ByteCodeAppender.Size(new StackManipulation.Compound(arrayList).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize() + iMax);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Appender appender = (Appender) obj;
            return this.instrumentedType.equals(appender.instrumentedType) && this.baseline.equals(appender.baseline) && this.fieldDescriptions.equals(appender.fieldDescriptions) && this.nonNullable.equals(appender.nonNullable);
        }

        public int hashCode() {
            return this.nonNullable.hashCode() + androidx.constraintlayout.core.motion.a.d(this.fieldDescriptions, (this.baseline.hashCode() + a.i(this.instrumentedType, getClass().hashCode() * 31, 31)) * 31, 31);
        }
    }

    @SuppressFBWarnings(justification = "Not used within a serializable instance", value = {"SE_COMPARATOR_SHOULD_BE_SERIALIZABLE"})
    @HashCodeAndEqualsPlugin.Enhance
    public static class CompoundComparator implements Comparator<FieldDescription.InDefinedShape> {
        private final List<Comparator<? super FieldDescription.InDefinedShape>> comparators;

        public CompoundComparator(Comparator<? super FieldDescription.InDefinedShape>... comparatorArr) {
            this((List<? extends Comparator<? super FieldDescription.InDefinedShape>>) Arrays.asList(comparatorArr));
        }

        @Override // java.util.Comparator
        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.comparators.equals(((CompoundComparator) obj).comparators);
        }

        public int hashCode() {
            return this.comparators.hashCode() + (getClass().hashCode() * 31);
        }

        public CompoundComparator(List<? extends Comparator<? super FieldDescription.InDefinedShape>> list) {
            this.comparators = new ArrayList();
            for (Comparator<? super FieldDescription.InDefinedShape> comparator : list) {
                if (comparator instanceof CompoundComparator) {
                    this.comparators.addAll(((CompoundComparator) comparator).comparators);
                } else if (!(comparator instanceof NaturalOrderComparator)) {
                    this.comparators.add(comparator);
                }
            }
        }

        @Override // java.util.Comparator
        public int compare(FieldDescription.InDefinedShape inDefinedShape, FieldDescription.InDefinedShape inDefinedShape2) {
            Iterator<Comparator<? super FieldDescription.InDefinedShape>> it = this.comparators.iterator();
            while (it.hasNext()) {
                int iCompare = it.next().compare(inDefinedShape, inDefinedShape2);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return 0;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ConditionalReturn extends StackManipulation.AbstractBase {
        private static final Object[] EMPTY = new Object[0];
        private final int jumpCondition;
        private final int value;

        public ConditionalReturn(int i) {
            this(i, 3);
        }

        public static ConditionalReturn onIdentity() {
            return new ConditionalReturn(166);
        }

        public static ConditionalReturn onNonEqualInteger() {
            return new ConditionalReturn(159);
        }

        public static ConditionalReturn onNonIdentity() {
            return new ConditionalReturn(165);
        }

        public static ConditionalReturn onNonZeroInteger() {
            return new ConditionalReturn(153);
        }

        public static ConditionalReturn onNullValue() {
            return new ConditionalReturn(199);
        }

        public static ConditionalReturn onZeroInteger() {
            return new ConditionalReturn(154);
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            Label label = new Label();
            methodVisitor.visitJumpInsn(this.jumpCondition, label);
            methodVisitor.visitInsn(this.value);
            methodVisitor.visitInsn(172);
            methodVisitor.visitLabel(label);
            context.getFrameGeneration().same(methodVisitor, Arrays.asList(context.getInstrumentedType(), TypeDescription.ForLoadedType.of(Object.class)));
            return new StackManipulation.Size(-1, 1);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ConditionalReturn conditionalReturn = (ConditionalReturn) obj;
            return this.jumpCondition == conditionalReturn.jumpCondition && this.value == conditionalReturn.value;
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.jumpCondition) * 31) + this.value;
        }

        public StackManipulation returningTrue() {
            return new ConditionalReturn(this.jumpCondition, 4);
        }

        private ConditionalReturn(int i, int i3) {
            this.jumpCondition = i;
            this.value = i3;
        }
    }

    public enum NaturalOrderComparator implements Comparator<FieldDescription.InDefinedShape> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(FieldDescription.InDefinedShape inDefinedShape, FieldDescription.InDefinedShape inDefinedShape2) {
            return 0;
        }
    }

    public interface NullValueGuard {

        public enum NoOp implements NullValueGuard {
            INSTANCE;

            @Override // net.bytebuddy.implementation.EqualsMethod.NullValueGuard
            public StackManipulation after() {
                return StackManipulation.Trivial.INSTANCE;
            }

            @Override // net.bytebuddy.implementation.EqualsMethod.NullValueGuard
            public StackManipulation before() {
                return StackManipulation.Trivial.INSTANCE;
            }

            @Override // net.bytebuddy.implementation.EqualsMethod.NullValueGuard
            public int getRequiredVariablePadding() {
                return StackSize.ZERO.getSize();
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class UsingJump implements NullValueGuard {
            private final MethodDescription instrumentedMethod;
            private final Label firstValueNull = new Label();
            private final Label secondValueNull = new Label();
            private final Label endOfBlock = new Label();

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            public class AfterInstruction extends StackManipulation.AbstractBase {
                public AfterInstruction() {
                }

                @Override // net.bytebuddy.implementation.bytecode.StackManipulation
                public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                    methodVisitor.visitJumpInsn(167, UsingJump.this.endOfBlock);
                    methodVisitor.visitLabel(UsingJump.this.secondValueNull);
                    context.getFrameGeneration().same1(methodVisitor, TypeDescription.ForLoadedType.of(Object.class), Arrays.asList(context.getInstrumentedType(), TypeDescription.ForLoadedType.of(Object.class)));
                    methodVisitor.visitJumpInsn(198, UsingJump.this.endOfBlock);
                    methodVisitor.visitLabel(UsingJump.this.firstValueNull);
                    context.getFrameGeneration().same(methodVisitor, Arrays.asList(context.getInstrumentedType(), TypeDescription.ForLoadedType.of(Object.class)));
                    methodVisitor.visitInsn(3);
                    methodVisitor.visitInsn(172);
                    methodVisitor.visitLabel(UsingJump.this.endOfBlock);
                    context.getFrameGeneration().same(methodVisitor, Arrays.asList(context.getInstrumentedType(), TypeDescription.ForLoadedType.of(Object.class)));
                    return StackManipulation.Size.ZERO;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && UsingJump.this.equals(UsingJump.this);
                }

                public int hashCode() {
                    return UsingJump.this.hashCode() + (getClass().hashCode() * 31);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            public class BeforeInstruction extends StackManipulation.AbstractBase {
                public BeforeInstruction() {
                }

                @Override // net.bytebuddy.implementation.bytecode.StackManipulation
                public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                    methodVisitor.visitVarInsn(58, UsingJump.this.instrumentedMethod.getStackSize());
                    methodVisitor.visitVarInsn(58, UsingJump.this.instrumentedMethod.getStackSize() + 1);
                    methodVisitor.visitVarInsn(25, UsingJump.this.instrumentedMethod.getStackSize() + 1);
                    methodVisitor.visitVarInsn(25, UsingJump.this.instrumentedMethod.getStackSize());
                    methodVisitor.visitJumpInsn(198, UsingJump.this.secondValueNull);
                    methodVisitor.visitJumpInsn(198, UsingJump.this.firstValueNull);
                    methodVisitor.visitVarInsn(25, UsingJump.this.instrumentedMethod.getStackSize() + 1);
                    methodVisitor.visitVarInsn(25, UsingJump.this.instrumentedMethod.getStackSize());
                    return StackManipulation.Size.ZERO;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && UsingJump.this.equals(UsingJump.this);
                }

                public int hashCode() {
                    return UsingJump.this.hashCode() + (getClass().hashCode() * 31);
                }
            }

            public UsingJump(MethodDescription methodDescription) {
                this.instrumentedMethod = methodDescription;
            }

            @Override // net.bytebuddy.implementation.EqualsMethod.NullValueGuard
            public StackManipulation after() {
                return new AfterInstruction();
            }

            @Override // net.bytebuddy.implementation.EqualsMethod.NullValueGuard
            public StackManipulation before() {
                return new BeforeInstruction();
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                UsingJump usingJump = (UsingJump) obj;
                return this.instrumentedMethod.equals(usingJump.instrumentedMethod) && this.firstValueNull.equals(usingJump.firstValueNull) && this.secondValueNull.equals(usingJump.secondValueNull) && this.endOfBlock.equals(usingJump.endOfBlock);
            }

            @Override // net.bytebuddy.implementation.EqualsMethod.NullValueGuard
            public int getRequiredVariablePadding() {
                return 2;
            }

            public int hashCode() {
                return this.endOfBlock.hashCode() + ((this.secondValueNull.hashCode() + ((this.firstValueNull.hashCode() + a.f(this.instrumentedMethod, getClass().hashCode() * 31, 31)) * 31)) * 31);
            }
        }

        StackManipulation after();

        StackManipulation before();

        int getRequiredVariablePadding();
    }

    public enum SuperClassCheck {
        DISABLED { // from class: net.bytebuddy.implementation.EqualsMethod.SuperClassCheck.1
            @Override // net.bytebuddy.implementation.EqualsMethod.SuperClassCheck
            public StackManipulation resolve(TypeDescription typeDescription) {
                return StackManipulation.Trivial.INSTANCE;
            }
        },
        ENABLED { // from class: net.bytebuddy.implementation.EqualsMethod.SuperClassCheck.2
            @Override // net.bytebuddy.implementation.EqualsMethod.SuperClassCheck
            public StackManipulation resolve(TypeDescription typeDescription) {
                TypeDescription.Generic superClass = typeDescription.getSuperClass();
                if (superClass != null) {
                    return new StackManipulation.Compound(MethodVariableAccess.loadThis(), MethodVariableAccess.REFERENCE.loadFrom(1), MethodInvocation.invoke(EqualsMethod.EQUALS).special(superClass.asErasure()), ConditionalReturn.onZeroInteger());
                }
                throw new IllegalStateException(a.o(typeDescription, " does not declare a super class"));
            }
        };

        public abstract StackManipulation resolve(TypeDescription typeDescription);
    }

    public enum TypeCompatibilityCheck {
        EXACT { // from class: net.bytebuddy.implementation.EqualsMethod.TypeCompatibilityCheck.1
            @Override // net.bytebuddy.implementation.EqualsMethod.TypeCompatibilityCheck
            public StackManipulation resolve(TypeDescription typeDescription) {
                MethodVariableAccess methodVariableAccess = MethodVariableAccess.REFERENCE;
                StackManipulation stackManipulationLoadFrom = methodVariableAccess.loadFrom(1);
                ConditionalReturn conditionalReturnOnNullValue = ConditionalReturn.onNullValue();
                StackManipulation stackManipulationLoadFrom2 = methodVariableAccess.loadFrom(0);
                MethodDescription.InDefinedShape inDefinedShape = TypeCompatibilityCheck.GET_CLASS;
                return new StackManipulation.Compound(stackManipulationLoadFrom, conditionalReturnOnNullValue, stackManipulationLoadFrom2, MethodInvocation.invoke(inDefinedShape), methodVariableAccess.loadFrom(1), MethodInvocation.invoke(inDefinedShape), ConditionalReturn.onNonIdentity());
            }
        },
        SUBCLASS { // from class: net.bytebuddy.implementation.EqualsMethod.TypeCompatibilityCheck.2
            @Override // net.bytebuddy.implementation.EqualsMethod.TypeCompatibilityCheck
            public StackManipulation resolve(TypeDescription typeDescription) {
                return new StackManipulation.Compound(MethodVariableAccess.REFERENCE.loadFrom(1), InstanceCheck.of(typeDescription), ConditionalReturn.onZeroInteger());
            }
        };

        protected static final MethodDescription.InDefinedShape GET_CLASS = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(Object.class).getDeclaredMethods().filter(ElementMatchers.named("getClass")).getOnly();

        public abstract StackManipulation resolve(TypeDescription typeDescription);
    }

    public enum TypePropertyComparator implements Comparator<FieldDescription.InDefinedShape> {
        FOR_PRIMITIVE_TYPES { // from class: net.bytebuddy.implementation.EqualsMethod.TypePropertyComparator.1
            @Override // net.bytebuddy.implementation.EqualsMethod.TypePropertyComparator, java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(FieldDescription.InDefinedShape inDefinedShape, FieldDescription.InDefinedShape inDefinedShape2) {
                return super.compare(inDefinedShape, inDefinedShape2);
            }

            @Override // net.bytebuddy.implementation.EqualsMethod.TypePropertyComparator
            public boolean resolve(TypeDefinition typeDefinition) {
                return typeDefinition.isPrimitive();
            }
        },
        FOR_ENUMERATION_TYPES { // from class: net.bytebuddy.implementation.EqualsMethod.TypePropertyComparator.2
            @Override // net.bytebuddy.implementation.EqualsMethod.TypePropertyComparator, java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(FieldDescription.InDefinedShape inDefinedShape, FieldDescription.InDefinedShape inDefinedShape2) {
                return super.compare(inDefinedShape, inDefinedShape2);
            }

            @Override // net.bytebuddy.implementation.EqualsMethod.TypePropertyComparator
            public boolean resolve(TypeDefinition typeDefinition) {
                return typeDefinition.isEnum();
            }
        },
        FOR_STRING_TYPES { // from class: net.bytebuddy.implementation.EqualsMethod.TypePropertyComparator.3
            @Override // net.bytebuddy.implementation.EqualsMethod.TypePropertyComparator, java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(FieldDescription.InDefinedShape inDefinedShape, FieldDescription.InDefinedShape inDefinedShape2) {
                return super.compare(inDefinedShape, inDefinedShape2);
            }

            @Override // net.bytebuddy.implementation.EqualsMethod.TypePropertyComparator
            public boolean resolve(TypeDefinition typeDefinition) {
                return typeDefinition.represents(String.class);
            }
        },
        FOR_PRIMITIVE_WRAPPER_TYPES { // from class: net.bytebuddy.implementation.EqualsMethod.TypePropertyComparator.4
            @Override // net.bytebuddy.implementation.EqualsMethod.TypePropertyComparator, java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(FieldDescription.InDefinedShape inDefinedShape, FieldDescription.InDefinedShape inDefinedShape2) {
                return super.compare(inDefinedShape, inDefinedShape2);
            }

            @Override // net.bytebuddy.implementation.EqualsMethod.TypePropertyComparator
            public boolean resolve(TypeDefinition typeDefinition) {
                return typeDefinition.asErasure().isPrimitiveWrapper();
            }
        };

        public abstract boolean resolve(TypeDefinition typeDefinition);

        @Override // java.util.Comparator
        public int compare(FieldDescription.InDefinedShape inDefinedShape, FieldDescription.InDefinedShape inDefinedShape2) {
            if (!resolve(inDefinedShape.getType()) || resolve(inDefinedShape2.getType())) {
                return (resolve(inDefinedShape.getType()) || !resolve(inDefinedShape2.getType())) ? 0 : 1;
            }
            return -1;
        }
    }

    public enum ValueComparator implements StackManipulation {
        LONG { // from class: net.bytebuddy.implementation.EqualsMethod.ValueComparator.1
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitInsn(148);
                return new StackManipulation.Size(-2, 0);
            }
        },
        FLOAT { // from class: net.bytebuddy.implementation.EqualsMethod.ValueComparator.2
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/lang/Float", "compare", "(FF)I", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        DOUBLE { // from class: net.bytebuddy.implementation.EqualsMethod.ValueComparator.3
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/lang/Double", "compare", "(DD)I", false);
                return new StackManipulation.Size(-2, 0);
            }
        },
        BOOLEAN_ARRAY { // from class: net.bytebuddy.implementation.EqualsMethod.ValueComparator.4
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "equals", "([Z[Z)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        BYTE_ARRAY { // from class: net.bytebuddy.implementation.EqualsMethod.ValueComparator.5
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "equals", "([B[B)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        SHORT_ARRAY { // from class: net.bytebuddy.implementation.EqualsMethod.ValueComparator.6
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "equals", "([S[S)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        CHARACTER_ARRAY { // from class: net.bytebuddy.implementation.EqualsMethod.ValueComparator.7
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "equals", "([C[C)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        INTEGER_ARRAY { // from class: net.bytebuddy.implementation.EqualsMethod.ValueComparator.8
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "equals", "([I[I)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        LONG_ARRAY { // from class: net.bytebuddy.implementation.EqualsMethod.ValueComparator.9
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "equals", "([J[J)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        FLOAT_ARRAY { // from class: net.bytebuddy.implementation.EqualsMethod.ValueComparator.10
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "equals", "([F[F)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        DOUBLE_ARRAY { // from class: net.bytebuddy.implementation.EqualsMethod.ValueComparator.11
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "equals", "([D[D)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        REFERENCE_ARRAY { // from class: net.bytebuddy.implementation.EqualsMethod.ValueComparator.12
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "equals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        },
        NESTED_ARRAY { // from class: net.bytebuddy.implementation.EqualsMethod.ValueComparator.13
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "deepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", false);
                return new StackManipulation.Size(-1, 0);
            }
        };

        @SuppressFBWarnings(justification = "Assuming component type for array type.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        public static StackManipulation of(TypeDefinition typeDefinition) {
            if (typeDefinition.represents(Boolean.TYPE) || typeDefinition.represents(Byte.TYPE) || typeDefinition.represents(Short.TYPE) || typeDefinition.represents(Character.TYPE) || typeDefinition.represents(Integer.TYPE)) {
                return ConditionalReturn.onNonEqualInteger();
            }
            if (typeDefinition.represents(Long.TYPE)) {
                return new StackManipulation.Compound(LONG, ConditionalReturn.onNonZeroInteger());
            }
            if (typeDefinition.represents(Float.TYPE)) {
                return new StackManipulation.Compound(FLOAT, ConditionalReturn.onNonZeroInteger());
            }
            if (typeDefinition.represents(Double.TYPE)) {
                return new StackManipulation.Compound(DOUBLE, ConditionalReturn.onNonZeroInteger());
            }
            if (typeDefinition.represents(boolean[].class)) {
                return new StackManipulation.Compound(BOOLEAN_ARRAY, ConditionalReturn.onZeroInteger());
            }
            if (typeDefinition.represents(byte[].class)) {
                return new StackManipulation.Compound(BYTE_ARRAY, ConditionalReturn.onZeroInteger());
            }
            if (typeDefinition.represents(short[].class)) {
                return new StackManipulation.Compound(SHORT_ARRAY, ConditionalReturn.onZeroInteger());
            }
            if (typeDefinition.represents(char[].class)) {
                return new StackManipulation.Compound(CHARACTER_ARRAY, ConditionalReturn.onZeroInteger());
            }
            if (typeDefinition.represents(int[].class)) {
                return new StackManipulation.Compound(INTEGER_ARRAY, ConditionalReturn.onZeroInteger());
            }
            if (typeDefinition.represents(long[].class)) {
                return new StackManipulation.Compound(LONG_ARRAY, ConditionalReturn.onZeroInteger());
            }
            if (typeDefinition.represents(float[].class)) {
                return new StackManipulation.Compound(FLOAT_ARRAY, ConditionalReturn.onZeroInteger());
            }
            if (typeDefinition.represents(double[].class)) {
                return new StackManipulation.Compound(DOUBLE_ARRAY, ConditionalReturn.onZeroInteger());
            }
            if (typeDefinition.isArray()) {
                return new StackManipulation.Compound(typeDefinition.getComponentType().isArray() ? NESTED_ARRAY : REFERENCE_ARRAY, ConditionalReturn.onZeroInteger());
            }
            return new StackManipulation.Compound(MethodInvocation.invoke(EqualsMethod.EQUALS).virtual(typeDefinition.asErasure()), ConditionalReturn.onZeroInteger());
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return true;
        }
    }

    public EqualsMethod(SuperClassCheck superClassCheck) {
        this(superClassCheck, TypeCompatibilityCheck.EXACT, ElementMatchers.none(), ElementMatchers.none(), NaturalOrderComparator.INSTANCE);
    }

    public static EqualsMethod isolated() {
        return new EqualsMethod(SuperClassCheck.DISABLED);
    }

    public static EqualsMethod requiringSuperClassEquality() {
        return new EqualsMethod(SuperClassCheck.ENABLED);
    }

    @Override // net.bytebuddy.implementation.Implementation
    public ByteCodeAppender appender(Implementation.Target target) {
        if (target.getInstrumentedType().isInterface()) {
            throw new IllegalStateException("Cannot implement meaningful equals method for " + target.getInstrumentedType());
        }
        ArrayList arrayList = new ArrayList(target.getInstrumentedType().getDeclaredFields().filter(ElementMatchers.not(ElementMatchers.isStatic().or(this.ignored))));
        Collections.sort(arrayList, this.comparator);
        return new Appender(target.getInstrumentedType(), new StackManipulation.Compound(this.superClassCheck.resolve(target.getInstrumentedType()), MethodVariableAccess.loadThis(), MethodVariableAccess.REFERENCE.loadFrom(1), ConditionalReturn.onIdentity().returningTrue(), this.typeCompatibilityCheck.resolve(target.getInstrumentedType())), arrayList, this.nonNullable);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EqualsMethod equalsMethod = (EqualsMethod) obj;
        return this.superClassCheck.equals(equalsMethod.superClassCheck) && this.typeCompatibilityCheck.equals(equalsMethod.typeCompatibilityCheck) && this.ignored.equals(equalsMethod.ignored) && this.nonNullable.equals(equalsMethod.nonNullable) && this.comparator.equals(equalsMethod.comparator);
    }

    public int hashCode() {
        return this.comparator.hashCode() + ((this.nonNullable.hashCode() + ((this.ignored.hashCode() + ((this.typeCompatibilityCheck.hashCode() + ((this.superClassCheck.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        return instrumentedType;
    }

    public EqualsMethod withEnumerationTypedFieldsFirst() {
        return withFieldOrder(TypePropertyComparator.FOR_ENUMERATION_TYPES);
    }

    public EqualsMethod withFieldOrder(Comparator<? super FieldDescription.InDefinedShape> comparator) {
        return new EqualsMethod(this.superClassCheck, this.typeCompatibilityCheck, this.ignored, this.nonNullable, new CompoundComparator((Comparator<? super FieldDescription.InDefinedShape>[]) new Comparator[]{this.comparator, comparator}));
    }

    public EqualsMethod withIgnoredFields(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher) {
        return new EqualsMethod(this.superClassCheck, this.typeCompatibilityCheck, this.ignored.or(elementMatcher), this.nonNullable, this.comparator);
    }

    public EqualsMethod withNonNullableFields(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher) {
        return new EqualsMethod(this.superClassCheck, this.typeCompatibilityCheck, this.ignored, this.nonNullable.or(elementMatcher), this.comparator);
    }

    public EqualsMethod withPrimitiveTypedFieldsFirst() {
        return withFieldOrder(TypePropertyComparator.FOR_PRIMITIVE_TYPES);
    }

    public EqualsMethod withPrimitiveWrapperTypedFieldsFirst() {
        return withFieldOrder(TypePropertyComparator.FOR_PRIMITIVE_WRAPPER_TYPES);
    }

    public EqualsMethod withStringTypedFieldsFirst() {
        return withFieldOrder(TypePropertyComparator.FOR_STRING_TYPES);
    }

    public Implementation withSubclassEquality() {
        return new EqualsMethod(this.superClassCheck, TypeCompatibilityCheck.SUBCLASS, this.ignored, this.nonNullable, this.comparator);
    }

    private EqualsMethod(SuperClassCheck superClassCheck, TypeCompatibilityCheck typeCompatibilityCheck, ElementMatcher.Junction<? super FieldDescription.InDefinedShape> junction, ElementMatcher.Junction<? super FieldDescription.InDefinedShape> junction2, Comparator<? super FieldDescription.InDefinedShape> comparator) {
        this.superClassCheck = superClassCheck;
        this.typeCompatibilityCheck = typeCompatibilityCheck;
        this.ignored = junction;
        this.nonNullable = junction2;
        this.comparator = comparator;
    }
}
