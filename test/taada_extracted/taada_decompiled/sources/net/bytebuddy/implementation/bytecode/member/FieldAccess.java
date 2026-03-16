package net.bytebuddy.implementation.bytecode.member;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
public enum FieldAccess {
    STATIC(179, 178, StackSize.ZERO),
    INSTANCE(181, 180, StackSize.SINGLE);

    private final int getterOpcode;
    private final int putterOpcode;
    private final int targetSizeChange;

    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
    public class AccessDispatcher implements Defined {
        private final FieldDescription.InDefinedShape fieldDescription;

        public abstract class AbstractFieldInstruction extends StackManipulation.AbstractBase {
            private AbstractFieldInstruction() {
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitFieldInsn(getOpcode(), AccessDispatcher.this.fieldDescription.getDeclaringType().getInternalName(), AccessDispatcher.this.fieldDescription.getInternalName(), AccessDispatcher.this.fieldDescription.getDescriptor());
                return resolveSize(AccessDispatcher.this.fieldDescription.getType().getStackSize());
            }

            public abstract int getOpcode();

            public abstract StackManipulation.Size resolveSize(StackSize stackSize);
        }

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class FieldGetInstruction extends AbstractFieldInstruction {
            public FieldGetInstruction() {
                super();
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && AccessDispatcher.this.equals(AccessDispatcher.this);
            }

            @Override // net.bytebuddy.implementation.bytecode.member.FieldAccess.AccessDispatcher.AbstractFieldInstruction
            public int getOpcode() {
                return FieldAccess.this.getterOpcode;
            }

            public int hashCode() {
                return AccessDispatcher.this.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.implementation.bytecode.member.FieldAccess.AccessDispatcher.AbstractFieldInstruction
            public StackManipulation.Size resolveSize(StackSize stackSize) {
                int size = stackSize.getSize() - FieldAccess.this.targetSizeChange;
                return new StackManipulation.Size(size, size);
            }
        }

        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class FieldPutInstruction extends AbstractFieldInstruction {
            public FieldPutInstruction() {
                super();
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && AccessDispatcher.this.equals(AccessDispatcher.this);
            }

            @Override // net.bytebuddy.implementation.bytecode.member.FieldAccess.AccessDispatcher.AbstractFieldInstruction
            public int getOpcode() {
                return FieldAccess.this.putterOpcode;
            }

            public int hashCode() {
                return AccessDispatcher.this.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.implementation.bytecode.member.FieldAccess.AccessDispatcher.AbstractFieldInstruction
            public StackManipulation.Size resolveSize(StackSize stackSize) {
                return new StackManipulation.Size((FieldAccess.this.targetSizeChange + stackSize.getSize()) * (-1), 0);
            }
        }

        public AccessDispatcher(FieldDescription.InDefinedShape inDefinedShape) {
            this.fieldDescription = inDefinedShape;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AccessDispatcher accessDispatcher = (AccessDispatcher) obj;
            return FieldAccess.this.equals(FieldAccess.this) && this.fieldDescription.equals(accessDispatcher.fieldDescription);
        }

        public int hashCode() {
            return FieldAccess.this.hashCode() + ((this.fieldDescription.hashCode() + (getClass().hashCode() * 31)) * 31);
        }

        @Override // net.bytebuddy.implementation.bytecode.member.FieldAccess.Defined
        public StackManipulation read() {
            return new FieldGetInstruction();
        }

        @Override // net.bytebuddy.implementation.bytecode.member.FieldAccess.Defined
        public StackManipulation write() {
            return new FieldPutInstruction();
        }
    }

    public interface Defined {
        StackManipulation read();

        StackManipulation write();
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class OfGenericField implements Defined {
        private final Defined defined;
        private final TypeDefinition targetType;

        public OfGenericField(TypeDefinition typeDefinition, Defined defined) {
            this.targetType = typeDefinition;
            this.defined = defined;
        }

        public static Defined of(FieldDescription fieldDescription, Defined defined) {
            return new OfGenericField(fieldDescription.getType(), defined);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            OfGenericField ofGenericField = (OfGenericField) obj;
            return this.targetType.equals(ofGenericField.targetType) && this.defined.equals(ofGenericField.defined);
        }

        public int hashCode() {
            return this.defined.hashCode() + ((this.targetType.hashCode() + (getClass().hashCode() * 31)) * 31);
        }

        @Override // net.bytebuddy.implementation.bytecode.member.FieldAccess.Defined
        public StackManipulation read() {
            return new StackManipulation.Compound(this.defined.read(), TypeCasting.to(this.targetType));
        }

        @Override // net.bytebuddy.implementation.bytecode.member.FieldAccess.Defined
        public StackManipulation write() {
            return this.defined.write();
        }
    }

    FieldAccess(int i, int i3, StackSize stackSize) {
        this.putterOpcode = i;
        this.getterOpcode = i3;
        this.targetSizeChange = stackSize.getSize();
    }

    public static StackManipulation forEnumeration(EnumerationDescription enumerationDescription) {
        FieldList fieldListFilter = enumerationDescription.getEnumerationType().getDeclaredFields().filter(ElementMatchers.named(enumerationDescription.getValue()));
        if (fieldListFilter.size() != 1 || !((FieldDescription.InDefinedShape) fieldListFilter.getOnly()).isStatic() || !((FieldDescription.InDefinedShape) fieldListFilter.getOnly()).isPublic() || !((FieldDescription.InDefinedShape) fieldListFilter.getOnly()).isEnum()) {
            return StackManipulation.Illegal.INSTANCE;
        }
        FieldAccess fieldAccess = STATIC;
        fieldAccess.getClass();
        return fieldAccess.new AccessDispatcher((FieldDescription.InDefinedShape) fieldListFilter.getOnly()).read();
    }

    public static Defined forField(FieldDescription.InDefinedShape inDefinedShape) {
        if (inDefinedShape.isStatic()) {
            FieldAccess fieldAccess = STATIC;
            fieldAccess.getClass();
            return fieldAccess.new AccessDispatcher(inDefinedShape);
        }
        FieldAccess fieldAccess2 = INSTANCE;
        fieldAccess2.getClass();
        return fieldAccess2.new AccessDispatcher(inDefinedShape);
    }

    public static Defined forField(FieldDescription fieldDescription) {
        FieldDescription.InDefinedShape inDefinedShapeAsDefined = fieldDescription.asDefined();
        return fieldDescription.getType().asErasure().equals(inDefinedShapeAsDefined.getType().asErasure()) ? forField(inDefinedShapeAsDefined) : OfGenericField.of(fieldDescription, forField(inDefinedShapeAsDefined));
    }
}
