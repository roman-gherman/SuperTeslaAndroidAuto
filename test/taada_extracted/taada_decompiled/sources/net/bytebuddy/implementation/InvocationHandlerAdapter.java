package net.bytebuddy.implementation;

import com.google.protobuf.a;
import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.MethodConstant;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public abstract class InvocationHandlerAdapter implements Implementation.Composable {
    private static final boolean CACHED = true;
    private static final boolean DROPPING = false;
    private static final TypeDescription.Generic INVOCATION_HANDLER_TYPE = TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(InvocationHandler.class);
    private static final boolean PRIVILEGED = true;
    private static final boolean RETURNING = true;
    private static final boolean UNCACHED = false;
    private static final boolean UNPRIVILEGED = false;
    protected final Assigner assigner;
    protected final boolean cached;
    protected final String fieldName;
    protected final boolean privileged;
    protected final boolean returning;

    public interface AssignerConfigurable extends Implementation.Composable {
        Implementation.Composable withAssigner(Assigner assigner);
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForField extends InvocationHandlerAdapter implements WithoutPrivilegeConfiguration {
        private final FieldLocator.Factory fieldLocatorFactory;

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class Appender implements ByteCodeAppender {
            private final FieldDescription fieldDescription;

            public Appender(FieldDescription fieldDescription) {
                this.fieldDescription = fieldDescription;
            }

            @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                return ForField.this.apply(methodVisitor, context, methodDescription, this.fieldDescription.isStatic() ? StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), this.fieldDescription);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Appender appender = (Appender) obj;
                return this.fieldDescription.equals(appender.fieldDescription) && ForField.this.equals(ForField.this);
            }

            public int hashCode() {
                return ForField.this.hashCode() + ((this.fieldDescription.hashCode() + (getClass().hashCode() * 31)) * 31);
            }
        }

        public ForField(String str, boolean z6, boolean z7, boolean z8, Assigner assigner, FieldLocator.Factory factory) {
            super(str, z6, z7, z8, assigner);
            this.fieldLocatorFactory = factory;
        }

        @Override // net.bytebuddy.implementation.Implementation.Composable
        public Implementation andThen(Implementation implementation) {
            return new Implementation.Compound(new ForField(this.fieldName, this.cached, this.privileged, false, this.assigner, this.fieldLocatorFactory), implementation);
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Implementation.Target target) {
            FieldLocator.Resolution resolutionLocate = this.fieldLocatorFactory.make(target.getInstrumentedType()).locate(this.fieldName);
            if (!resolutionLocate.isResolved()) {
                throw new IllegalStateException("Could not find a field named '" + this.fieldName + "' for " + target.getInstrumentedType());
            }
            if (resolutionLocate.getField().getType().asErasure().isAssignableTo(InvocationHandler.class)) {
                return new Appender(resolutionLocate.getField());
            }
            throw new IllegalStateException("Field " + resolutionLocate.getField() + " does not declare a type that is assignable to invocation handler");
        }

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter
        public boolean equals(@MaybeNull Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.fieldLocatorFactory.equals(((ForField) obj).fieldLocatorFactory);
        }

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter
        public int hashCode() {
            return this.fieldLocatorFactory.hashCode() + (super.hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter, net.bytebuddy.implementation.InvocationHandlerAdapter.WithoutPrivilegeConfiguration
        public AssignerConfigurable withPrivilegedLookup() {
            return new ForField(this.fieldName, this.cached, true, this.returning, this.assigner, this.fieldLocatorFactory);
        }

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter
        public WithoutPrivilegeConfiguration withoutMethodCache() {
            return new ForField(this.fieldName, false, this.privileged, this.returning, this.assigner, this.fieldLocatorFactory);
        }

        @Override // net.bytebuddy.implementation.Implementation.Composable
        public Implementation.Composable andThen(Implementation.Composable composable) {
            return new Implementation.Compound.Composable(new ForField(this.fieldName, this.cached, this.privileged, false, this.assigner, this.fieldLocatorFactory), composable);
        }

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter, net.bytebuddy.implementation.InvocationHandlerAdapter.AssignerConfigurable
        public Implementation.Composable withAssigner(Assigner assigner) {
            return new ForField(this.fieldName, this.cached, this.privileged, this.returning, assigner, this.fieldLocatorFactory);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForInstance extends InvocationHandlerAdapter implements WithoutPrivilegeConfiguration {
        private static final String PREFIX = "invocationHandler";
        protected final InvocationHandler invocationHandler;

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class Appender implements ByteCodeAppender {
            private final TypeDescription instrumentedType;

            public Appender(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                return ForInstance.this.apply(methodVisitor, context, methodDescription, StackManipulation.Trivial.INSTANCE, (FieldDescription) this.instrumentedType.getDeclaredFields().filter(ElementMatchers.named(ForInstance.this.fieldName).and(ElementMatchers.genericFieldType(InvocationHandlerAdapter.INVOCATION_HANDLER_TYPE))).getOnly());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Appender appender = (Appender) obj;
                return this.instrumentedType.equals(appender.instrumentedType) && ForInstance.this.equals(ForInstance.this);
            }

            public int hashCode() {
                return ForInstance.this.hashCode() + a.i(this.instrumentedType, getClass().hashCode() * 31, 31);
            }
        }

        public ForInstance(String str, boolean z6, boolean z7, boolean z8, Assigner assigner, InvocationHandler invocationHandler) {
            super(str, z6, z7, z8, assigner);
            this.invocationHandler = invocationHandler;
        }

        @Override // net.bytebuddy.implementation.Implementation.Composable
        public Implementation andThen(Implementation implementation) {
            return new Implementation.Compound(new ForInstance(this.fieldName, this.cached, this.privileged, false, this.assigner, this.invocationHandler), implementation);
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(target.getInstrumentedType());
        }

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter
        public boolean equals(@MaybeNull Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.invocationHandler.equals(((ForInstance) obj).invocationHandler);
        }

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter
        public int hashCode() {
            return this.invocationHandler.hashCode() + (super.hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            if (instrumentedType.getDeclaredFields().filter(ElementMatchers.named(this.fieldName).and(ElementMatchers.fieldType(InvocationHandlerAdapter.INVOCATION_HANDLER_TYPE.asErasure()))).isEmpty()) {
                return instrumentedType.withField(new FieldDescription.Token(this.fieldName, 4169, InvocationHandlerAdapter.INVOCATION_HANDLER_TYPE)).withInitializer(new LoadedTypeInitializer.ForStaticField(this.fieldName, this.invocationHandler));
            }
            throw new IllegalStateException("Field with name " + this.fieldName + " and type " + InvocationHandlerAdapter.INVOCATION_HANDLER_TYPE.asErasure() + " already declared by " + instrumentedType);
        }

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter, net.bytebuddy.implementation.InvocationHandlerAdapter.WithoutPrivilegeConfiguration
        public AssignerConfigurable withPrivilegedLookup() {
            return new ForInstance(this.fieldName, this.cached, true, this.returning, this.assigner, this.invocationHandler);
        }

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter
        public WithoutPrivilegeConfiguration withoutMethodCache() {
            return new ForInstance(this.fieldName, false, this.privileged, this.returning, this.assigner, this.invocationHandler);
        }

        @Override // net.bytebuddy.implementation.Implementation.Composable
        public Implementation.Composable andThen(Implementation.Composable composable) {
            return new Implementation.Compound.Composable(new ForInstance(this.fieldName, this.cached, this.privileged, false, this.assigner, this.invocationHandler), composable);
        }

        @Override // net.bytebuddy.implementation.InvocationHandlerAdapter, net.bytebuddy.implementation.InvocationHandlerAdapter.AssignerConfigurable
        public Implementation.Composable withAssigner(Assigner assigner) {
            return new ForInstance(this.fieldName, this.cached, this.privileged, this.returning, assigner, this.invocationHandler);
        }
    }

    public interface WithoutPrivilegeConfiguration extends AssignerConfigurable {
        AssignerConfigurable withPrivilegedLookup();
    }

    public InvocationHandlerAdapter(String str, boolean z6, boolean z7, boolean z8, Assigner assigner) {
        this.fieldName = str;
        this.cached = z6;
        this.privileged = z7;
        this.returning = z8;
        this.assigner = assigner;
    }

    private List<StackManipulation> argumentValuesOf(MethodDescription methodDescription) {
        TypeList.Generic genericAsTypeList = methodDescription.getParameters().asTypeList();
        ArrayList arrayList = new ArrayList(genericAsTypeList.size());
        int size = 1;
        for (TypeDescription.Generic generic : genericAsTypeList) {
            arrayList.add(new StackManipulation.Compound(MethodVariableAccess.of(generic).loadFrom(size), this.assigner.assign(generic, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), Assigner.Typing.STATIC)));
            size += generic.getStackSize().getSize();
        }
        return arrayList;
    }

    public static InvocationHandlerAdapter of(InvocationHandler invocationHandler) {
        return of(invocationHandler, "invocationHandler$" + RandomString.hashOf(invocationHandler));
    }

    public static InvocationHandlerAdapter toField(String str) {
        return toField(str, FieldLocator.ForClassHierarchy.Factory.INSTANCE);
    }

    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription, StackManipulation stackManipulation, FieldDescription fieldDescription) {
        if (methodDescription.isStatic() || methodDescription.isConstructor()) {
            throw new IllegalStateException(a.l("It is not possible to apply an invocation handler onto the static method or constructor ", methodDescription));
        }
        MethodConstant.CanCache canCacheOfPrivileged = this.privileged ? MethodConstant.ofPrivileged(methodDescription.asDefined()) : MethodConstant.of(methodDescription.asDefined());
        StackManipulation stackManipulation2 = FieldAccess.forField(fieldDescription).read();
        StackManipulation stackManipulationLoadThis = MethodVariableAccess.loadThis();
        MethodConstant.CanCache canCacheCached = canCacheOfPrivileged;
        if (this.cached) {
            canCacheCached = canCacheOfPrivileged.cached();
        }
        return new ByteCodeAppender.Size(new StackManipulation.Compound(stackManipulation, stackManipulation2, stackManipulationLoadThis, canCacheCached, methodDescription.getParameters().isEmpty() ? NullConstant.INSTANCE : ArrayFactory.forType(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class)).withValues(argumentValuesOf(methodDescription)), MethodInvocation.invoke((MethodDescription) INVOCATION_HANDLER_TYPE.getDeclaredMethods().filter(ElementMatchers.isAbstract()).getOnly()), this.returning ? new StackManipulation.Compound(this.assigner.assign(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), methodDescription.getReturnType(), Assigner.Typing.DYNAMIC), MethodReturn.of(methodDescription.getReturnType())) : Removal.SINGLE).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InvocationHandlerAdapter invocationHandlerAdapter = (InvocationHandlerAdapter) obj;
        return this.cached == invocationHandlerAdapter.cached && this.privileged == invocationHandlerAdapter.privileged && this.returning == invocationHandlerAdapter.returning && this.fieldName.equals(invocationHandlerAdapter.fieldName) && this.assigner.equals(invocationHandlerAdapter.assigner);
    }

    public int hashCode() {
        return this.assigner.hashCode() + ((((((androidx.constraintlayout.core.motion.a.c(getClass().hashCode() * 31, 31, this.fieldName) + (this.cached ? 1 : 0)) * 31) + (this.privileged ? 1 : 0)) * 31) + (this.returning ? 1 : 0)) * 31);
    }

    public abstract Implementation withAssigner(Assigner assigner);

    public abstract AssignerConfigurable withPrivilegedLookup();

    public abstract WithoutPrivilegeConfiguration withoutMethodCache();

    public static InvocationHandlerAdapter of(InvocationHandler invocationHandler, String str) {
        return new ForInstance(str, true, false, true, Assigner.DEFAULT, invocationHandler);
    }

    public static InvocationHandlerAdapter toField(String str, FieldLocator.Factory factory) {
        return new ForField(str, true, false, true, Assigner.DEFAULT, factory);
    }
}
