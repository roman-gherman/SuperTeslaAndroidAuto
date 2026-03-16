package net.bytebuddy.implementation.bytecode.assign.primitive;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'BOOLEAN' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public final class PrimitiveUnboxingDelegate implements StackManipulation {
    private static final /* synthetic */ PrimitiveUnboxingDelegate[] $VALUES;
    public static final PrimitiveUnboxingDelegate BOOLEAN;
    public static final PrimitiveUnboxingDelegate BYTE;
    public static final PrimitiveUnboxingDelegate CHARACTER;
    public static final PrimitiveUnboxingDelegate DOUBLE;
    public static final PrimitiveUnboxingDelegate FLOAT;
    public static final PrimitiveUnboxingDelegate INTEGER;
    public static final PrimitiveUnboxingDelegate LONG;
    public static final PrimitiveUnboxingDelegate SHORT;
    private final TypeDescription primitiveType;
    private final StackManipulation.Size size;
    private final String unboxingMethodDescriptor;
    private final String unboxingMethodName;
    private final TypeDescription wrapperType;

    public enum ExplicitlyTypedUnboxingResponsible implements UnboxingResponsible {
        BOOLEAN(PrimitiveUnboxingDelegate.BOOLEAN),
        BYTE(PrimitiveUnboxingDelegate.BYTE),
        SHORT(PrimitiveUnboxingDelegate.SHORT),
        CHARACTER(PrimitiveUnboxingDelegate.CHARACTER),
        INTEGER(PrimitiveUnboxingDelegate.INTEGER),
        LONG(PrimitiveUnboxingDelegate.LONG),
        FLOAT(PrimitiveUnboxingDelegate.FLOAT),
        DOUBLE(PrimitiveUnboxingDelegate.DOUBLE);

        private final PrimitiveUnboxingDelegate primitiveUnboxingDelegate;

        ExplicitlyTypedUnboxingResponsible(PrimitiveUnboxingDelegate primitiveUnboxingDelegate) {
            this.primitiveUnboxingDelegate = primitiveUnboxingDelegate;
        }

        @Override // net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveUnboxingDelegate.UnboxingResponsible
        public StackManipulation assignUnboxedTo(TypeDescription.Generic generic, Assigner assigner, Assigner.Typing typing) {
            PrimitiveUnboxingDelegate primitiveUnboxingDelegate = this.primitiveUnboxingDelegate;
            return new StackManipulation.Compound(primitiveUnboxingDelegate, PrimitiveWideningDelegate.forPrimitive(primitiveUnboxingDelegate.primitiveType).widenTo(generic));
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ImplicitlyTypedUnboxingResponsible implements UnboxingResponsible {
        private final TypeDescription.Generic originalType;

        public ImplicitlyTypedUnboxingResponsible(TypeDescription.Generic generic) {
            this.originalType = generic;
        }

        @Override // net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveUnboxingDelegate.UnboxingResponsible
        public StackManipulation assignUnboxedTo(TypeDescription.Generic generic, Assigner assigner, Assigner.Typing typing) {
            PrimitiveUnboxingDelegate primitiveUnboxingDelegateForPrimitive = PrimitiveUnboxingDelegate.forPrimitive(generic);
            return new StackManipulation.Compound(assigner.assign(this.originalType, primitiveUnboxingDelegateForPrimitive.getWrapperType(), typing), primitiveUnboxingDelegateForPrimitive);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.originalType.equals(((ImplicitlyTypedUnboxingResponsible) obj).originalType);
        }

        public int hashCode() {
            return this.originalType.hashCode() + (getClass().hashCode() * 31);
        }
    }

    public interface UnboxingResponsible {
        StackManipulation assignUnboxedTo(TypeDescription.Generic generic, Assigner assigner, Assigner.Typing typing);
    }

    static {
        StackSize stackSize = StackSize.ZERO;
        PrimitiveUnboxingDelegate primitiveUnboxingDelegate = new PrimitiveUnboxingDelegate("BOOLEAN", 0, Boolean.class, Boolean.TYPE, stackSize, "booleanValue", "()Z");
        BOOLEAN = primitiveUnboxingDelegate;
        PrimitiveUnboxingDelegate primitiveUnboxingDelegate2 = new PrimitiveUnboxingDelegate("BYTE", 1, Byte.class, Byte.TYPE, stackSize, "byteValue", "()B");
        BYTE = primitiveUnboxingDelegate2;
        PrimitiveUnboxingDelegate primitiveUnboxingDelegate3 = new PrimitiveUnboxingDelegate("SHORT", 2, Short.class, Short.TYPE, stackSize, "shortValue", "()S");
        SHORT = primitiveUnboxingDelegate3;
        PrimitiveUnboxingDelegate primitiveUnboxingDelegate4 = new PrimitiveUnboxingDelegate("CHARACTER", 3, Character.class, Character.TYPE, stackSize, "charValue", "()C");
        CHARACTER = primitiveUnboxingDelegate4;
        PrimitiveUnboxingDelegate primitiveUnboxingDelegate5 = new PrimitiveUnboxingDelegate("INTEGER", 4, Integer.class, Integer.TYPE, stackSize, "intValue", "()I");
        INTEGER = primitiveUnboxingDelegate5;
        StackSize stackSize2 = StackSize.SINGLE;
        PrimitiveUnboxingDelegate primitiveUnboxingDelegate6 = new PrimitiveUnboxingDelegate("LONG", 5, Long.class, Long.TYPE, stackSize2, "longValue", "()J");
        LONG = primitiveUnboxingDelegate6;
        PrimitiveUnboxingDelegate primitiveUnboxingDelegate7 = new PrimitiveUnboxingDelegate("FLOAT", 6, Float.class, Float.TYPE, stackSize, "floatValue", "()F");
        FLOAT = primitiveUnboxingDelegate7;
        PrimitiveUnboxingDelegate primitiveUnboxingDelegate8 = new PrimitiveUnboxingDelegate("DOUBLE", 7, Double.class, Double.TYPE, stackSize2, "doubleValue", "()D");
        DOUBLE = primitiveUnboxingDelegate8;
        $VALUES = new PrimitiveUnboxingDelegate[]{primitiveUnboxingDelegate, primitiveUnboxingDelegate2, primitiveUnboxingDelegate3, primitiveUnboxingDelegate4, primitiveUnboxingDelegate5, primitiveUnboxingDelegate6, primitiveUnboxingDelegate7, primitiveUnboxingDelegate8};
    }

    private PrimitiveUnboxingDelegate(String str, int i, Class cls, Class cls2, StackSize stackSize, String str2, String str3) {
        this.size = stackSize.toIncreasingSize();
        this.wrapperType = TypeDescription.ForLoadedType.of(cls);
        this.primitiveType = TypeDescription.ForLoadedType.of(cls2);
        this.unboxingMethodName = str2;
        this.unboxingMethodDescriptor = str3;
    }

    public static PrimitiveUnboxingDelegate forPrimitive(TypeDefinition typeDefinition) {
        if (typeDefinition.represents(Boolean.TYPE)) {
            return BOOLEAN;
        }
        if (typeDefinition.represents(Byte.TYPE)) {
            return BYTE;
        }
        if (typeDefinition.represents(Short.TYPE)) {
            return SHORT;
        }
        if (typeDefinition.represents(Character.TYPE)) {
            return CHARACTER;
        }
        if (typeDefinition.represents(Integer.TYPE)) {
            return INTEGER;
        }
        if (typeDefinition.represents(Long.TYPE)) {
            return LONG;
        }
        if (typeDefinition.represents(Float.TYPE)) {
            return FLOAT;
        }
        if (typeDefinition.represents(Double.TYPE)) {
            return DOUBLE;
        }
        throw new IllegalArgumentException("Expected non-void primitive type instead of " + typeDefinition);
    }

    public static UnboxingResponsible forReferenceType(TypeDefinition typeDefinition) {
        if (!typeDefinition.isPrimitive()) {
            return typeDefinition.represents(Boolean.class) ? ExplicitlyTypedUnboxingResponsible.BOOLEAN : typeDefinition.represents(Byte.class) ? ExplicitlyTypedUnboxingResponsible.BYTE : typeDefinition.represents(Short.class) ? ExplicitlyTypedUnboxingResponsible.SHORT : typeDefinition.represents(Character.class) ? ExplicitlyTypedUnboxingResponsible.CHARACTER : typeDefinition.represents(Integer.class) ? ExplicitlyTypedUnboxingResponsible.INTEGER : typeDefinition.represents(Long.class) ? ExplicitlyTypedUnboxingResponsible.LONG : typeDefinition.represents(Float.class) ? ExplicitlyTypedUnboxingResponsible.FLOAT : typeDefinition.represents(Double.class) ? ExplicitlyTypedUnboxingResponsible.DOUBLE : new ImplicitlyTypedUnboxingResponsible(typeDefinition.asGenericType());
        }
        throw new IllegalArgumentException("Expected reference type instead of " + typeDefinition);
    }

    public static PrimitiveUnboxingDelegate valueOf(String str) {
        return (PrimitiveUnboxingDelegate) Enum.valueOf(PrimitiveUnboxingDelegate.class, str);
    }

    public static PrimitiveUnboxingDelegate[] values() {
        return (PrimitiveUnboxingDelegate[]) $VALUES.clone();
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitMethodInsn(182, this.wrapperType.asErasure().getInternalName(), this.unboxingMethodName, this.unboxingMethodDescriptor, false);
        return this.size;
    }

    public TypeDescription.Generic getWrapperType() {
        return this.wrapperType.asGenericType();
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public boolean isValid() {
        return true;
    }
}
