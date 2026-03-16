package net.bytebuddy.implementation;

import B2.b;
import com.google.protobuf.a;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.implementation.bytecode.constant.DoubleConstant;
import net.bytebuddy.implementation.bytecode.constant.FloatConstant;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;
import net.bytebuddy.implementation.bytecode.constant.LongConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public abstract class FieldAccessor implements Implementation {
    protected final Assigner assigner;
    protected final FieldLocation fieldLocation;
    protected final Assigner.Typing typing;

    public interface AssignerConfigurable extends PropertyConfigurable {
        PropertyConfigurable withAssigner(Assigner assigner, Assigner.Typing typing);
    }

    public interface FieldLocation {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Absolute implements FieldLocation, Prepared {
            private final FieldDescription fieldDescription;

            public Absolute(FieldDescription fieldDescription) {
                this.fieldDescription = fieldDescription;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Absolute) obj).fieldDescription);
            }

            public int hashCode() {
                return this.fieldDescription.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.FieldLocation
            @SuppressFBWarnings(justification = "Assuming declaring type for type member.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public Prepared prepare(TypeDescription typeDescription) {
                if (!this.fieldDescription.isStatic() && !typeDescription.isAssignableTo(this.fieldDescription.getDeclaringType().asErasure())) {
                    throw new IllegalStateException(this.fieldDescription + " is not declared by " + typeDescription);
                }
                if (this.fieldDescription.isAccessibleTo(typeDescription)) {
                    return this;
                }
                throw new IllegalStateException("Cannot access " + this.fieldDescription + " from " + typeDescription);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.FieldLocation.Prepared
            public FieldDescription resolve(MethodDescription methodDescription) {
                return this.fieldDescription;
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.FieldLocation
            public FieldLocation with(FieldLocator.Factory factory) {
                throw new IllegalStateException("Cannot specify a field locator factory for an absolute field location");
            }
        }

        public interface Prepared {
            FieldDescription resolve(MethodDescription methodDescription);
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Relative implements FieldLocation {
            private final FieldLocator.Factory fieldLocatorFactory;
            private final FieldNameExtractor fieldNameExtractor;

            @HashCodeAndEqualsPlugin.Enhance
            public static class Prepared implements Prepared {
                private final FieldLocator fieldLocator;
                private final FieldNameExtractor fieldNameExtractor;

                public Prepared(FieldNameExtractor fieldNameExtractor, FieldLocator fieldLocator) {
                    this.fieldNameExtractor = fieldNameExtractor;
                    this.fieldLocator = fieldLocator;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Prepared prepared = (Prepared) obj;
                    return this.fieldNameExtractor.equals(prepared.fieldNameExtractor) && this.fieldLocator.equals(prepared.fieldLocator);
                }

                public int hashCode() {
                    return this.fieldLocator.hashCode() + ((this.fieldNameExtractor.hashCode() + (getClass().hashCode() * 31)) * 31);
                }

                @Override // net.bytebuddy.implementation.FieldAccessor.FieldLocation.Prepared
                public FieldDescription resolve(MethodDescription methodDescription) {
                    FieldLocator.Resolution resolutionLocate = this.fieldLocator.locate(this.fieldNameExtractor.resolve(methodDescription));
                    if (resolutionLocate.isResolved()) {
                        return resolutionLocate.getField();
                    }
                    throw new IllegalStateException("Cannot resolve field for " + methodDescription + " using " + this.fieldLocator);
                }
            }

            public Relative(FieldNameExtractor fieldNameExtractor) {
                this(fieldNameExtractor, FieldLocator.ForClassHierarchy.Factory.INSTANCE);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Relative relative = (Relative) obj;
                return this.fieldNameExtractor.equals(relative.fieldNameExtractor) && this.fieldLocatorFactory.equals(relative.fieldLocatorFactory);
            }

            public int hashCode() {
                return this.fieldLocatorFactory.hashCode() + ((this.fieldNameExtractor.hashCode() + (getClass().hashCode() * 31)) * 31);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.FieldLocation
            public Prepared prepare(TypeDescription typeDescription) {
                return new Prepared(this.fieldNameExtractor, this.fieldLocatorFactory.make(typeDescription));
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.FieldLocation
            public FieldLocation with(FieldLocator.Factory factory) {
                return new Relative(this.fieldNameExtractor, factory);
            }

            private Relative(FieldNameExtractor fieldNameExtractor, FieldLocator.Factory factory) {
                this.fieldNameExtractor = fieldNameExtractor;
                this.fieldLocatorFactory = factory;
            }
        }

        Prepared prepare(TypeDescription typeDescription);

        FieldLocation with(FieldLocator.Factory factory);
    }

    public interface FieldNameExtractor {

        public enum ForBeanProperty implements FieldNameExtractor {
            INSTANCE;

            @Override // net.bytebuddy.implementation.FieldAccessor.FieldNameExtractor
            public String resolve(MethodDescription methodDescription) {
                int i;
                String internalName = methodDescription.getInternalName();
                if (internalName.startsWith("get") || internalName.startsWith("set")) {
                    i = 3;
                } else {
                    if (!internalName.startsWith("is")) {
                        throw new IllegalArgumentException(methodDescription + " does not follow Java bean naming conventions");
                    }
                    i = 2;
                }
                String strSubstring = internalName.substring(i);
                if (strSubstring.length() != 0) {
                    return Character.toLowerCase(strSubstring.charAt(0)) + strSubstring.substring(1);
                }
                throw new IllegalArgumentException(methodDescription + " does not specify a bean name");
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForFixedValue implements FieldNameExtractor {
            private final String name;

            public ForFixedValue(String str) {
                this.name = str;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.name.equals(((ForFixedValue) obj).name);
            }

            public int hashCode() {
                return this.name.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.FieldNameExtractor
            public String resolve(MethodDescription methodDescription) {
                return this.name;
            }
        }

        String resolve(MethodDescription methodDescription);
    }

    public static class ForImplicitProperty extends FieldAccessor implements OwnerTypeLocatable {

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class Appender implements ByteCodeAppender {
            private final FieldLocation.Prepared fieldLocation;

            public Appender(FieldLocation.Prepared prepared) {
                this.fieldLocation = prepared;
            }

            @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                StackManipulation.Compound compound;
                if (!methodDescription.isMethod()) {
                    throw new IllegalArgumentException(methodDescription + " does not describe a field getter or setter");
                }
                FieldDescription fieldDescriptionResolve = this.fieldLocation.resolve(methodDescription);
                if (!fieldDescriptionResolve.isStatic() && methodDescription.isStatic()) {
                    throw new IllegalStateException("Cannot set instance field " + fieldDescriptionResolve + " from " + methodDescription);
                }
                StackManipulation stackManipulationLoadThis = fieldDescriptionResolve.isStatic() ? StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis();
                TypeDescription.Generic returnType = methodDescription.getReturnType();
                Class cls = Void.TYPE;
                if (!returnType.represents(cls)) {
                    compound = new StackManipulation.Compound(stackManipulationLoadThis, FieldAccess.forField(fieldDescriptionResolve).read(), ForImplicitProperty.this.assigner.assign(fieldDescriptionResolve.getType(), methodDescription.getReturnType(), ForImplicitProperty.this.typing), MethodReturn.of(methodDescription.getReturnType()));
                } else {
                    if (!methodDescription.getReturnType().represents(cls) || methodDescription.getParameters().size() != 1) {
                        throw new IllegalArgumentException("Method " + methodDescription + " is no bean accessor");
                    }
                    if (fieldDescriptionResolve.isFinal() && methodDescription.isMethod()) {
                        throw new IllegalStateException("Cannot set final field " + fieldDescriptionResolve + " from " + methodDescription);
                    }
                    compound = new StackManipulation.Compound(stackManipulationLoadThis, MethodVariableAccess.load((ParameterDescription) methodDescription.getParameters().get(0)), ForImplicitProperty.this.assigner.assign(((ParameterDescription) methodDescription.getParameters().get(0)).getType(), fieldDescriptionResolve.getType(), ForImplicitProperty.this.typing), FieldAccess.forField(fieldDescriptionResolve).write(), MethodReturn.VOID);
                }
                if (compound.isValid()) {
                    return new ByteCodeAppender.Size(compound.apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                }
                throw new IllegalStateException("Cannot set or get value of " + methodDescription + " using " + fieldDescriptionResolve);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Appender appender = (Appender) obj;
                return this.fieldLocation.equals(appender.fieldLocation) && ForImplicitProperty.this.equals(ForImplicitProperty.this);
            }

            public int hashCode() {
                return ForImplicitProperty.this.hashCode() + ((this.fieldLocation.hashCode() + (getClass().hashCode() * 31)) * 31);
            }
        }

        public ForImplicitProperty(FieldLocation fieldLocation) {
            this(fieldLocation, Assigner.DEFAULT, Assigner.Typing.STATIC);
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(this.fieldLocation.prepare(target.getInstrumentedType()));
        }

        @Override // net.bytebuddy.implementation.FieldAccessor.OwnerTypeLocatable
        public AssignerConfigurable in(Class<?> cls) {
            return in(TypeDescription.ForLoadedType.of(cls));
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        @Override // net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable
        public Implementation.Composable setsArgumentAt(int i) {
            if (i >= 0) {
                return new ForSetter.OfParameterValue(this.fieldLocation, this.assigner, this.typing, ForSetter.TerminationHandler.RETURNING, i);
            }
            throw new IllegalArgumentException(b.c(i, "A parameter index cannot be negative: "));
        }

        @Override // net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable
        public Implementation.Composable setsDefaultValue() {
            return new ForSetter.OfDefaultValue(this.fieldLocation, this.assigner, this.typing, ForSetter.TerminationHandler.RETURNING);
        }

        @Override // net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable
        public Implementation.Composable setsFieldValueOf(Field field) {
            return setsFieldValueOf(new FieldDescription.ForLoadedField(field));
        }

        @Override // net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable
        public Implementation.Composable setsReference(Object obj) {
            return setsReference(obj, "fixedFieldValue$" + RandomString.hashOf(obj));
        }

        @Override // net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable
        public Implementation.Composable setsValue(@MaybeNull Object obj) {
            if (obj == null) {
                return setsDefaultValue();
            }
            Class<?> cls = obj.getClass();
            return cls == String.class ? setsValue(new TextConstant((String) obj), String.class) : cls == Class.class ? setsValue(ClassConstant.of(TypeDescription.ForLoadedType.of((Class) obj)), Class.class) : cls == Boolean.class ? setsValue(IntegerConstant.forValue(((Boolean) obj).booleanValue()), Boolean.TYPE) : cls == Byte.class ? setsValue(IntegerConstant.forValue(((Byte) obj).byteValue()), Byte.TYPE) : cls == Short.class ? setsValue(IntegerConstant.forValue(((Short) obj).shortValue()), Short.TYPE) : cls == Character.class ? setsValue(IntegerConstant.forValue(((Character) obj).charValue()), Character.TYPE) : cls == Integer.class ? setsValue(IntegerConstant.forValue(((Integer) obj).intValue()), Integer.TYPE) : cls == Long.class ? setsValue(LongConstant.forValue(((Long) obj).longValue()), Long.TYPE) : cls == Float.class ? setsValue(FloatConstant.forValue(((Float) obj).floatValue()), Float.TYPE) : cls == Double.class ? setsValue(DoubleConstant.forValue(((Double) obj).doubleValue()), Double.TYPE) : JavaType.METHOD_HANDLE.getTypeStub().isAssignableFrom(cls) ? setsValue(new JavaConstantValue(JavaConstant.MethodHandle.ofLoaded(obj)), cls) : JavaType.METHOD_TYPE.getTypeStub().represents(cls) ? setsValue(new JavaConstantValue(JavaConstant.MethodType.ofLoaded(obj)), cls) : setsReference(obj);
        }

        @Override // net.bytebuddy.implementation.FieldAccessor.AssignerConfigurable
        public PropertyConfigurable withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new ForImplicitProperty(this.fieldLocation, assigner, typing);
        }

        private ForImplicitProperty(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing) {
            super(fieldLocation, assigner, typing);
        }

        @Override // net.bytebuddy.implementation.FieldAccessor.OwnerTypeLocatable
        public AssignerConfigurable in(TypeDescription typeDescription) {
            return in(new FieldLocator.ForExactType.Factory(typeDescription));
        }

        @Override // net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable
        public Implementation.Composable setsFieldValueOf(FieldDescription fieldDescription) {
            return new ForSetter.OfFieldValue(this.fieldLocation, this.assigner, this.typing, ForSetter.TerminationHandler.RETURNING, new FieldLocation.Absolute(fieldDescription));
        }

        @Override // net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable
        public Implementation.Composable setsReference(Object obj, String str) {
            return new ForSetter.OfReferenceValue(this.fieldLocation, this.assigner, this.typing, ForSetter.TerminationHandler.RETURNING, obj, str);
        }

        @Override // net.bytebuddy.implementation.FieldAccessor.OwnerTypeLocatable
        public AssignerConfigurable in(FieldLocator.Factory factory) {
            return new ForImplicitProperty(this.fieldLocation.with(factory), this.assigner, this.typing);
        }

        @Override // net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable
        public Implementation.Composable setsFieldValueOf(String str) {
            return setsFieldValueOf(new FieldNameExtractor.ForFixedValue(str));
        }

        @Override // net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable
        public Implementation.Composable setsFieldValueOf(FieldNameExtractor fieldNameExtractor) {
            return new ForSetter.OfFieldValue(this.fieldLocation, this.assigner, this.typing, ForSetter.TerminationHandler.RETURNING, new FieldLocation.Relative(fieldNameExtractor));
        }

        @Override // net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable
        public Implementation.Composable setsValue(TypeDescription typeDescription) {
            return setsValue(ClassConstant.of(typeDescription), Class.class);
        }

        @Override // net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable
        public Implementation.Composable setsValue(JavaConstant javaConstant) {
            return setsValue(new JavaConstantValue(javaConstant), javaConstant.getTypeDescription().asGenericType());
        }

        @Override // net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable
        public Implementation.Composable setsValue(StackManipulation stackManipulation, Type type) {
            return setsValue(stackManipulation, TypeDefinition.Sort.describe(type));
        }

        @Override // net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable
        public Implementation.Composable setsValue(StackManipulation stackManipulation, TypeDescription.Generic generic) {
            return new ForSetter.OfConstantValue(this.fieldLocation, this.assigner, this.typing, ForSetter.TerminationHandler.RETURNING, generic, stackManipulation);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class ForSetter<T> extends FieldAccessor implements Implementation.Composable {
        private final TerminationHandler terminationHandler;

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class Appender implements ByteCodeAppender {
            private final FieldLocation.Prepared fieldLocation;

            @MaybeNull
            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
            private final T initialized;
            private final TypeDescription instrumentedType;

            public Appender(TypeDescription typeDescription, @MaybeNull T t6, FieldLocation.Prepared prepared) {
                this.instrumentedType = typeDescription;
                this.initialized = t6;
                this.fieldLocation = prepared;
            }

            @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                FieldDescription fieldDescriptionResolve = this.fieldLocation.resolve(methodDescription);
                if (!fieldDescriptionResolve.isStatic() && methodDescription.isStatic()) {
                    throw new IllegalStateException("Cannot set instance field " + fieldDescriptionResolve + " from " + methodDescription);
                }
                if (fieldDescriptionResolve.isFinal() && methodDescription.isMethod()) {
                    throw new IllegalStateException("Cannot set final field " + fieldDescriptionResolve + " from " + methodDescription);
                }
                StackManipulation stackManipulationResolve = ForSetter.this.resolve(this.initialized, fieldDescriptionResolve, this.instrumentedType, methodDescription);
                if (stackManipulationResolve.isValid()) {
                    return new ByteCodeAppender.Size(new StackManipulation.Compound(methodDescription.isStatic() ? StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), stackManipulationResolve, FieldAccess.forField(fieldDescriptionResolve).write(), ForSetter.this.terminationHandler.resolve(methodDescription)).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
                }
                throw new IllegalStateException("Set value cannot be assigned to " + fieldDescriptionResolve);
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
                    net.bytebuddy.description.type.TypeDescription r2 = r4.instrumentedType
                    net.bytebuddy.implementation.FieldAccessor$ForSetter$Appender r5 = (net.bytebuddy.implementation.FieldAccessor.ForSetter.Appender) r5
                    net.bytebuddy.description.type.TypeDescription r3 = r5.instrumentedType
                    boolean r2 = r2.equals(r3)
                    if (r2 != 0) goto L20
                    return r1
                L20:
                    T r2 = r4.initialized
                    T r3 = r5.initialized
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
                    net.bytebuddy.implementation.FieldAccessor$FieldLocation$Prepared r2 = r4.fieldLocation
                    net.bytebuddy.implementation.FieldAccessor$FieldLocation$Prepared r3 = r5.fieldLocation
                    boolean r2 = r2.equals(r3)
                    if (r2 != 0) goto L3d
                    return r1
                L3d:
                    net.bytebuddy.implementation.FieldAccessor$ForSetter r2 = net.bytebuddy.implementation.FieldAccessor.ForSetter.this
                    net.bytebuddy.implementation.FieldAccessor$ForSetter r5 = net.bytebuddy.implementation.FieldAccessor.ForSetter.this
                    boolean r5 = r2.equals(r5)
                    if (r5 != 0) goto L48
                    return r1
                L48:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.implementation.FieldAccessor.ForSetter.Appender.equals(java.lang.Object):boolean");
            }

            public int hashCode() {
                int i = a.i(this.instrumentedType, getClass().hashCode() * 31, 31);
                T t6 = this.initialized;
                if (t6 != null) {
                    i += t6.hashCode();
                }
                return ForSetter.this.hashCode() + ((this.fieldLocation.hashCode() + (i * 31)) * 31);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class OfConstantValue extends ForSetter<Void> {
            private final StackManipulation stackManipulation;
            private final TypeDescription.Generic typeDescription;

            public OfConstantValue(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing, TerminationHandler terminationHandler, TypeDescription.Generic generic, StackManipulation stackManipulation) {
                super(fieldLocation, assigner, typing, terminationHandler);
                this.typeDescription = generic;
                this.stackManipulation = stackManipulation;
            }

            @Override // net.bytebuddy.implementation.Implementation.Composable
            public Implementation andThen(Implementation implementation) {
                return new Implementation.Compound(new OfConstantValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL, this.typeDescription, this.stackManipulation), implementation);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter, net.bytebuddy.implementation.FieldAccessor
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
                OfConstantValue ofConstantValue = (OfConstantValue) obj;
                return this.typeDescription.equals(ofConstantValue.typeDescription) && this.stackManipulation.equals(ofConstantValue.stackManipulation);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter, net.bytebuddy.implementation.FieldAccessor
            public int hashCode() {
                return this.stackManipulation.hashCode() + a.h(this.typeDescription, super.hashCode() * 31, 31);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter
            @AlwaysNull
            public Void initialize(TypeDescription typeDescription) {
                return null;
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            @Override // net.bytebuddy.implementation.Implementation.Composable
            public Implementation.Composable andThen(Implementation.Composable composable) {
                return new Implementation.Compound.Composable(new OfConstantValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL, this.typeDescription, this.stackManipulation), composable);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter
            public StackManipulation resolve(@MaybeNull Void r32, FieldDescription fieldDescription, TypeDescription typeDescription, MethodDescription methodDescription) {
                return new StackManipulation.Compound(this.stackManipulation, this.assigner.assign(this.typeDescription, fieldDescription.getType(), this.typing));
            }
        }

        public static class OfDefaultValue extends ForSetter<Void> {
            public OfDefaultValue(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing, TerminationHandler terminationHandler) {
                super(fieldLocation, assigner, typing, terminationHandler);
            }

            @Override // net.bytebuddy.implementation.Implementation.Composable
            public Implementation andThen(Implementation implementation) {
                return new Implementation.Compound(new OfDefaultValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL), implementation);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter
            @AlwaysNull
            public Void initialize(TypeDescription typeDescription) {
                return null;
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            @Override // net.bytebuddy.implementation.Implementation.Composable
            public Implementation.Composable andThen(Implementation.Composable composable) {
                return new Implementation.Compound.Composable(new OfDefaultValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL), composable);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter
            public StackManipulation resolve(@MaybeNull Void r12, FieldDescription fieldDescription, TypeDescription typeDescription, MethodDescription methodDescription) {
                return DefaultValue.of(fieldDescription.getType());
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class OfFieldValue extends ForSetter<FieldLocation.Prepared> {
            private final FieldLocation target;

            public OfFieldValue(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing, TerminationHandler terminationHandler, FieldLocation fieldLocation2) {
                super(fieldLocation, assigner, typing, terminationHandler);
                this.target = fieldLocation2;
            }

            @Override // net.bytebuddy.implementation.Implementation.Composable
            public Implementation andThen(Implementation implementation) {
                return new Implementation.Compound(new OfFieldValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL, this.target), implementation);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter, net.bytebuddy.implementation.FieldAccessor
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.target.equals(((OfFieldValue) obj).target);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter, net.bytebuddy.implementation.FieldAccessor
            public int hashCode() {
                return this.target.hashCode() + (super.hashCode() * 31);
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            @Override // net.bytebuddy.implementation.Implementation.Composable
            public Implementation.Composable andThen(Implementation.Composable composable) {
                return new Implementation.Compound.Composable(new OfFieldValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL, this.target), composable);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter
            public FieldLocation.Prepared initialize(TypeDescription typeDescription) {
                return this.target.prepare(typeDescription);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter
            @SuppressFBWarnings(justification = "Expects its own initialized value as argument", value = {"NP_PARAMETER_MUST_BE_NONNULL_BUT_MARKED_AS_NULLABLE"})
            public StackManipulation resolve(@MaybeNull FieldLocation.Prepared prepared, FieldDescription fieldDescription, TypeDescription typeDescription, MethodDescription methodDescription) {
                FieldDescription fieldDescriptionResolve = prepared.resolve(methodDescription);
                if (fieldDescriptionResolve.isStatic() || !methodDescription.isStatic()) {
                    return new StackManipulation.Compound(fieldDescriptionResolve.isStatic() ? StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), FieldAccess.forField(fieldDescriptionResolve).read(), this.assigner.assign(fieldDescriptionResolve.getType(), fieldDescription.getType(), this.typing));
                }
                throw new IllegalStateException("Cannot set instance field " + fieldDescription + " from " + methodDescription);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class OfParameterValue extends ForSetter<Void> {
            private final int index;

            public OfParameterValue(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing, TerminationHandler terminationHandler, int i) {
                super(fieldLocation, assigner, typing, terminationHandler);
                this.index = i;
            }

            @Override // net.bytebuddy.implementation.Implementation.Composable
            public Implementation andThen(Implementation implementation) {
                return new Implementation.Compound(new OfParameterValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL, this.index), implementation);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter, net.bytebuddy.implementation.FieldAccessor
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.index == ((OfParameterValue) obj).index;
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter, net.bytebuddy.implementation.FieldAccessor
            public int hashCode() {
                return (super.hashCode() * 31) + this.index;
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter
            @AlwaysNull
            public Void initialize(TypeDescription typeDescription) {
                return null;
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }

            @Override // net.bytebuddy.implementation.Implementation.Composable
            public Implementation.Composable andThen(Implementation.Composable composable) {
                return new Implementation.Compound.Composable(new OfParameterValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL, this.index), composable);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter
            public StackManipulation resolve(@MaybeNull Void r32, FieldDescription fieldDescription, TypeDescription typeDescription, MethodDescription methodDescription) {
                if (methodDescription.getParameters().size() > this.index) {
                    return new StackManipulation.Compound(MethodVariableAccess.load((ParameterDescription) methodDescription.getParameters().get(this.index)), this.assigner.assign(((ParameterDescription) methodDescription.getParameters().get(this.index)).getType(), fieldDescription.getType(), this.typing));
                }
                throw new IllegalStateException(methodDescription + " does not define a parameter with index " + this.index);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class OfReferenceValue extends ForSetter<FieldDescription.InDefinedShape> {
            protected static final String PREFIX = "fixedFieldValue";
            private final String name;
            private final Object value;

            public OfReferenceValue(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing, TerminationHandler terminationHandler, Object obj, String str) {
                super(fieldLocation, assigner, typing, terminationHandler);
                this.value = obj;
                this.name = str;
            }

            @Override // net.bytebuddy.implementation.Implementation.Composable
            public Implementation andThen(Implementation implementation) {
                return new Implementation.Compound(new OfReferenceValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL, this.value, this.name), implementation);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter, net.bytebuddy.implementation.FieldAccessor
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
                OfReferenceValue ofReferenceValue = (OfReferenceValue) obj;
                return this.name.equals(ofReferenceValue.name) && this.value.equals(ofReferenceValue.value);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter, net.bytebuddy.implementation.FieldAccessor
            public int hashCode() {
                return this.name.hashCode() + ((this.value.hashCode() + (super.hashCode() * 31)) * 31);
            }

            @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType.withAuxiliaryField(new FieldDescription.Token(this.name, 4105, TypeDescription.ForLoadedType.of(this.value.getClass()).asGenericType()), this.value);
            }

            @Override // net.bytebuddy.implementation.Implementation.Composable
            public Implementation.Composable andThen(Implementation.Composable composable) {
                return new Implementation.Compound.Composable(new OfReferenceValue(this.fieldLocation, this.assigner, this.typing, TerminationHandler.NON_OPERATIONAL, this.value, this.name), composable);
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter
            public FieldDescription.InDefinedShape initialize(TypeDescription typeDescription) {
                return (FieldDescription.InDefinedShape) typeDescription.getDeclaredFields().filter(ElementMatchers.named(this.name)).getOnly();
            }

            @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter
            @SuppressFBWarnings(justification = "Expects its own initialized value as argument", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
            public StackManipulation resolve(@MaybeNull FieldDescription.InDefinedShape inDefinedShape, FieldDescription fieldDescription, TypeDescription typeDescription, MethodDescription methodDescription) {
                if (!fieldDescription.isFinal() || !methodDescription.isMethod()) {
                    return new StackManipulation.Compound(FieldAccess.forField(inDefinedShape).read(), this.assigner.assign(TypeDescription.ForLoadedType.of(this.value.getClass()).asGenericType(), fieldDescription.getType(), this.typing));
                }
                throw new IllegalArgumentException("Cannot set final field " + fieldDescription + " from " + methodDescription);
            }
        }

        public enum TerminationHandler {
            RETURNING { // from class: net.bytebuddy.implementation.FieldAccessor.ForSetter.TerminationHandler.1
                @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter.TerminationHandler
                public StackManipulation resolve(MethodDescription methodDescription) {
                    if (methodDescription.getReturnType().represents(Void.TYPE)) {
                        return MethodReturn.VOID;
                    }
                    throw new IllegalStateException(a.l("Cannot implement setter with return value for ", methodDescription));
                }
            },
            NON_OPERATIONAL { // from class: net.bytebuddy.implementation.FieldAccessor.ForSetter.TerminationHandler.2
                @Override // net.bytebuddy.implementation.FieldAccessor.ForSetter.TerminationHandler
                public StackManipulation resolve(MethodDescription methodDescription) {
                    return StackManipulation.Trivial.INSTANCE;
                }
            };

            public abstract StackManipulation resolve(MethodDescription methodDescription);
        }

        public ForSetter(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing, TerminationHandler terminationHandler) {
            super(fieldLocation, assigner, typing);
            this.terminationHandler = terminationHandler;
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(target.getInstrumentedType(), initialize(target.getInstrumentedType()), this.fieldLocation.prepare(target.getInstrumentedType()));
        }

        @Override // net.bytebuddy.implementation.FieldAccessor
        public boolean equals(@MaybeNull Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.terminationHandler.equals(((ForSetter) obj).terminationHandler);
        }

        @Override // net.bytebuddy.implementation.FieldAccessor
        public int hashCode() {
            return this.terminationHandler.hashCode() + (super.hashCode() * 31);
        }

        @MaybeNull
        public abstract T initialize(TypeDescription typeDescription);

        public abstract StackManipulation resolve(@MaybeNull T t6, FieldDescription fieldDescription, TypeDescription typeDescription, MethodDescription methodDescription);
    }

    public interface OwnerTypeLocatable extends AssignerConfigurable {
        AssignerConfigurable in(Class<?> cls);

        AssignerConfigurable in(TypeDescription typeDescription);

        AssignerConfigurable in(FieldLocator.Factory factory);
    }

    public interface PropertyConfigurable extends Implementation {
        Implementation.Composable setsArgumentAt(int i);

        Implementation.Composable setsDefaultValue();

        Implementation.Composable setsFieldValueOf(String str);

        Implementation.Composable setsFieldValueOf(Field field);

        Implementation.Composable setsFieldValueOf(FieldDescription fieldDescription);

        Implementation.Composable setsFieldValueOf(FieldNameExtractor fieldNameExtractor);

        Implementation.Composable setsReference(Object obj);

        Implementation.Composable setsReference(Object obj, String str);

        Implementation.Composable setsValue(Object obj);

        Implementation.Composable setsValue(TypeDescription typeDescription);

        Implementation.Composable setsValue(StackManipulation stackManipulation, Type type);

        Implementation.Composable setsValue(StackManipulation stackManipulation, TypeDescription.Generic generic);

        Implementation.Composable setsValue(JavaConstant javaConstant);
    }

    public FieldAccessor(FieldLocation fieldLocation, Assigner assigner, Assigner.Typing typing) {
        this.fieldLocation = fieldLocation;
        this.assigner = assigner;
        this.typing = typing;
    }

    public static OwnerTypeLocatable of(FieldNameExtractor fieldNameExtractor) {
        return new ForImplicitProperty(new FieldLocation.Relative(fieldNameExtractor));
    }

    public static OwnerTypeLocatable ofBeanProperty() {
        return of(FieldNameExtractor.ForBeanProperty.INSTANCE);
    }

    public static OwnerTypeLocatable ofField(String str) {
        return of(new FieldNameExtractor.ForFixedValue(str));
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FieldAccessor fieldAccessor = (FieldAccessor) obj;
        return this.typing.equals(fieldAccessor.typing) && this.fieldLocation.equals(fieldAccessor.fieldLocation) && this.assigner.equals(fieldAccessor.assigner);
    }

    public int hashCode() {
        return this.typing.hashCode() + ((this.assigner.hashCode() + ((this.fieldLocation.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31);
    }

    public static AssignerConfigurable of(Field field) {
        return of(new FieldDescription.ForLoadedField(field));
    }

    public static AssignerConfigurable of(FieldDescription fieldDescription) {
        return new ForImplicitProperty(new FieldLocation.Absolute(fieldDescription));
    }
}
