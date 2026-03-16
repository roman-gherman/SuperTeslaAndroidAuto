package net.bytebuddy.implementation.bytecode;

import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'ZERO' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Duplication implements StackManipulation {
    private static final /* synthetic */ Duplication[] $VALUES;
    public static final Duplication DOUBLE;
    public static final Duplication SINGLE;
    public static final Duplication ZERO;
    private final int opcode;
    protected final StackManipulation.Size size;

    /* JADX INFO: renamed from: net.bytebuddy.implementation.bytecode.Duplication$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize;

        static {
            int[] iArr = new int[StackSize.values().length];
            $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize = iArr;
            try {
                iArr[StackSize.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize[StackSize.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize[StackSize.ZERO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'SINGLE_SINGLE' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class WithFlip implements StackManipulation {
        private static final /* synthetic */ WithFlip[] $VALUES;
        public static final WithFlip DOUBLE_DOUBLE;
        public static final WithFlip DOUBLE_SINGLE;
        public static final WithFlip SINGLE_DOUBLE;
        public static final WithFlip SINGLE_SINGLE;
        private final int opcode;
        private final StackSize stackSize;

        static {
            StackSize stackSize = StackSize.SINGLE;
            WithFlip withFlip = new WithFlip("SINGLE_SINGLE", 0, 90, stackSize);
            SINGLE_SINGLE = withFlip;
            WithFlip withFlip2 = new WithFlip("SINGLE_DOUBLE", 1, 91, stackSize);
            SINGLE_DOUBLE = withFlip2;
            StackSize stackSize2 = StackSize.DOUBLE;
            WithFlip withFlip3 = new WithFlip("DOUBLE_SINGLE", 2, 93, stackSize2);
            DOUBLE_SINGLE = withFlip3;
            WithFlip withFlip4 = new WithFlip("DOUBLE_DOUBLE", 3, 94, stackSize2);
            DOUBLE_DOUBLE = withFlip4;
            $VALUES = new WithFlip[]{withFlip, withFlip2, withFlip3, withFlip4};
        }

        private WithFlip(String str, int i, int i3, StackSize stackSize) {
            this.opcode = i3;
            this.stackSize = stackSize;
        }

        public static WithFlip valueOf(String str) {
            return (WithFlip) Enum.valueOf(WithFlip.class, str);
        }

        public static WithFlip[] values() {
            return (WithFlip[]) $VALUES.clone();
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitInsn(this.opcode);
            return this.stackSize.toIncreasingSize();
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return true;
        }
    }

    static {
        int i = 0;
        Duplication duplication = new Duplication("ZERO", i, StackSize.ZERO, i) { // from class: net.bytebuddy.implementation.bytecode.Duplication.1
            @Override // net.bytebuddy.implementation.bytecode.Duplication, net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                return this.size;
            }

            @Override // net.bytebuddy.implementation.bytecode.Duplication
            public StackManipulation flipOver(TypeDefinition typeDefinition) {
                throw new IllegalStateException("Cannot flip zero value");
            }
        };
        ZERO = duplication;
        Duplication duplication2 = new Duplication("SINGLE", 1, StackSize.SINGLE, 89) { // from class: net.bytebuddy.implementation.bytecode.Duplication.2
            @Override // net.bytebuddy.implementation.bytecode.Duplication
            public StackManipulation flipOver(TypeDefinition typeDefinition) {
                int i3 = AnonymousClass4.$SwitchMap$net$bytebuddy$implementation$bytecode$StackSize[typeDefinition.getStackSize().ordinal()];
                if (i3 == 1) {
                    return WithFlip.SINGLE_SINGLE;
                }
                if (i3 == 2) {
                    return WithFlip.SINGLE_DOUBLE;
                }
                throw new IllegalArgumentException("Cannot flip: " + typeDefinition);
            }
        };
        SINGLE = duplication2;
        Duplication duplication3 = new Duplication("DOUBLE", 2, StackSize.DOUBLE, 92) { // from class: net.bytebuddy.implementation.bytecode.Duplication.3
            @Override // net.bytebuddy.implementation.bytecode.Duplication
            public StackManipulation flipOver(TypeDefinition typeDefinition) {
                int i3 = AnonymousClass4.$SwitchMap$net$bytebuddy$implementation$bytecode$StackSize[typeDefinition.getStackSize().ordinal()];
                if (i3 == 1) {
                    return WithFlip.DOUBLE_SINGLE;
                }
                if (i3 == 2) {
                    return WithFlip.DOUBLE_DOUBLE;
                }
                throw new IllegalArgumentException("Cannot flip: " + typeDefinition);
            }
        };
        DOUBLE = duplication3;
        $VALUES = new Duplication[]{duplication, duplication2, duplication3};
    }

    public static Duplication of(TypeDefinition typeDefinition) {
        int i = AnonymousClass4.$SwitchMap$net$bytebuddy$implementation$bytecode$StackSize[typeDefinition.getStackSize().ordinal()];
        if (i == 1) {
            return SINGLE;
        }
        if (i == 2) {
            return DOUBLE;
        }
        if (i == 3) {
            return ZERO;
        }
        throw new AssertionError("Unexpected type: " + typeDefinition);
    }

    public static Duplication valueOf(String str) {
        return (Duplication) Enum.valueOf(Duplication.class, str);
    }

    public static Duplication[] values() {
        return (Duplication[]) $VALUES.clone();
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitInsn(this.opcode);
        return this.size;
    }

    public abstract StackManipulation flipOver(TypeDefinition typeDefinition);

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public boolean isValid() {
        return true;
    }

    private Duplication(String str, int i, StackSize stackSize, int i3) {
        this.size = stackSize.toIncreasingSize();
        this.opcode = i3;
    }
}
