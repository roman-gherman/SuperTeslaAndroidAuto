package net.bytebuddy.jar.asm;

import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
class Frame {
    static final int APPEND_FRAME = 252;
    private static final int ARRAY_OF = 67108864;
    private static final int BOOLEAN = 4194313;
    private static final int BYTE = 4194314;
    private static final int CHAR = 4194315;
    static final int CHOP_FRAME = 248;
    private static final int CONSTANT_KIND = 4194304;
    private static final int DIM_MASK = -67108864;
    private static final int DIM_SHIFT = 26;
    private static final int DIM_SIZE = 6;
    private static final int DOUBLE = 4194307;
    private static final int ELEMENT_OF = -67108864;
    private static final int FLAGS_SHIFT = 20;
    private static final int FLAGS_SIZE = 2;
    private static final int FLOAT = 4194306;
    static final int FULL_FRAME = 255;
    private static final int INTEGER = 4194305;
    private static final int ITEM_ASM_BOOLEAN = 9;
    private static final int ITEM_ASM_BYTE = 10;
    private static final int ITEM_ASM_CHAR = 11;
    private static final int ITEM_ASM_SHORT = 12;
    static final int ITEM_DOUBLE = 3;
    static final int ITEM_FLOAT = 2;
    static final int ITEM_INTEGER = 1;
    static final int ITEM_LONG = 4;
    static final int ITEM_NULL = 5;
    static final int ITEM_OBJECT = 7;
    static final int ITEM_TOP = 0;
    static final int ITEM_UNINITIALIZED = 8;
    static final int ITEM_UNINITIALIZED_THIS = 6;
    private static final int KIND_MASK = 62914560;
    private static final int KIND_SHIFT = 22;
    private static final int KIND_SIZE = 4;
    private static final int LOCAL_KIND = 16777216;
    private static final int LONG = 4194308;
    private static final int NULL = 4194309;
    private static final int REFERENCE_KIND = 8388608;
    static final int RESERVED = 128;
    static final int SAME_FRAME = 0;
    static final int SAME_FRAME_EXTENDED = 251;
    static final int SAME_LOCALS_1_STACK_ITEM_FRAME = 64;
    static final int SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED = 247;
    private static final int SHORT = 4194316;
    private static final int STACK_KIND = 20971520;
    private static final int TOP = 4194304;
    private static final int TOP_IF_LONG_OR_DOUBLE_FLAG = 1048576;
    private static final int UNINITIALIZED_KIND = 12582912;
    private static final int UNINITIALIZED_THIS = 4194310;
    private static final int VALUE_MASK = 1048575;
    private static final int VALUE_SIZE = 20;
    private int initializationCount;
    private int[] initializations;
    private int[] inputLocals;
    private int[] inputStack;
    private int[] outputLocals;
    private int[] outputStack;
    private short outputStackStart;
    private short outputStackTop;
    Label owner;

    public Frame(Label label) {
        this.owner = label;
    }

    private void addInitializedType(int i) {
        if (this.initializations == null) {
            this.initializations = new int[2];
        }
        int length = this.initializations.length;
        int i3 = this.initializationCount;
        if (i3 >= length) {
            int[] iArr = new int[Math.max(i3 + 1, length * 2)];
            System.arraycopy(this.initializations, 0, iArr, 0, length);
            this.initializations = iArr;
        }
        int[] iArr2 = this.initializations;
        int i4 = this.initializationCount;
        this.initializationCount = i4 + 1;
        iArr2[i4] = i;
    }

    public static int getAbstractTypeFromApiFormat(SymbolTable symbolTable, Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() | 4194304 : obj instanceof String ? getAbstractTypeFromDescriptor(symbolTable, Type.getObjectType((String) obj).getDescriptor(), 0) : symbolTable.addUninitializedType("", ((Label) obj).bytecodeOffset) | UNINITIALIZED_KIND;
    }

    private static int getAbstractTypeFromDescriptor(SymbolTable symbolTable, String str, int i) {
        char cCharAt = str.charAt(i);
        int iAddType = FLOAT;
        if (cCharAt == 'F') {
            return FLOAT;
        }
        if (cCharAt == 'L') {
            return symbolTable.addType(str.substring(i + 1, str.length() - 1)) | 8388608;
        }
        if (cCharAt != 'S') {
            if (cCharAt == 'V') {
                return 0;
            }
            if (cCharAt != 'I') {
                if (cCharAt == 'J') {
                    return LONG;
                }
                if (cCharAt != 'Z') {
                    if (cCharAt == '[') {
                        int i3 = i + 1;
                        while (str.charAt(i3) == '[') {
                            i3++;
                        }
                        char cCharAt2 = str.charAt(i3);
                        if (cCharAt2 != 'F') {
                            if (cCharAt2 == 'L') {
                                iAddType = symbolTable.addType(str.substring(i3 + 1, str.length() - 1)) | 8388608;
                            } else if (cCharAt2 == 'S') {
                                iAddType = SHORT;
                            } else if (cCharAt2 == 'Z') {
                                iAddType = BOOLEAN;
                            } else if (cCharAt2 == 'I') {
                                iAddType = INTEGER;
                            } else if (cCharAt2 != 'J') {
                                switch (cCharAt2) {
                                    case 'B':
                                        iAddType = BYTE;
                                        break;
                                    case 'C':
                                        iAddType = CHAR;
                                        break;
                                    case 'D':
                                        iAddType = DOUBLE;
                                        break;
                                    default:
                                        throw new IllegalArgumentException();
                                }
                            } else {
                                iAddType = LONG;
                            }
                        }
                        return ((i3 - i) << 26) | iAddType;
                    }
                    switch (cCharAt) {
                        case 'B':
                        case 'C':
                            break;
                        case 'D':
                            return DOUBLE;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
            }
        }
        return INTEGER;
    }

    public static int getAbstractTypeFromInternalName(SymbolTable symbolTable, String str) {
        return symbolTable.addType(str) | 8388608;
    }

    private int getConcreteOutputType(int i, int i3) {
        int i4 = (-67108864) & i;
        int i5 = KIND_MASK & i;
        if (i5 == 16777216) {
            int i6 = i4 + this.inputLocals[i & VALUE_MASK];
            if ((i & 1048576) == 0 || !(i6 == LONG || i6 == DOUBLE)) {
                return i6;
            }
            return 4194304;
        }
        if (i5 != STACK_KIND) {
            return i;
        }
        int i7 = i4 + this.inputStack[i3 - (i & VALUE_MASK)];
        if ((i & 1048576) == 0 || !(i7 == LONG || i7 == DOUBLE)) {
            return i7;
        }
        return 4194304;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0051 A[LOOP:0: B:7:0x000d->B:23:0x0051, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0037 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int getInitializedType(net.bytebuddy.jar.asm.SymbolTable r9, int r10) {
        /*
            r8 = this;
            r0 = 4194310(0x400006, float:5.87748E-39)
            if (r10 == r0) goto Lc
            r1 = -4194304(0xffffffffffc00000, float:NaN)
            r1 = r1 & r10
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            if (r1 != r2) goto L54
        Lc:
            r1 = 0
        Ld:
            int r2 = r8.initializationCount
            if (r1 >= r2) goto L54
            int[] r2 = r8.initializations
            r2 = r2[r1]
            r3 = -67108864(0xfffffffffc000000, float:-2.658456E36)
            r3 = r3 & r2
            r4 = 62914560(0x3c00000, float:1.1284746E-36)
            r4 = r4 & r2
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r2 & r5
            r7 = 16777216(0x1000000, float:2.3509887E-38)
            if (r4 != r7) goto L2a
            int[] r2 = r8.inputLocals
            r2 = r2[r6]
        L28:
            int r2 = r2 + r3
            goto L35
        L2a:
            r7 = 20971520(0x1400000, float:3.526483E-38)
            if (r4 != r7) goto L35
            int[] r2 = r8.inputStack
            int r4 = r2.length
            int r4 = r4 - r6
            r2 = r2[r4]
            goto L28
        L35:
            if (r10 != r2) goto L51
            r1 = 8388608(0x800000, float:1.1754944E-38)
            if (r10 != r0) goto L45
            java.lang.String r10 = r9.getClassName()
            int r9 = r9.addType(r10)
        L43:
            r9 = r9 | r1
            return r9
        L45:
            r10 = r10 & r5
            net.bytebuddy.jar.asm.Symbol r10 = r9.getType(r10)
            java.lang.String r10 = r10.value
            int r9 = r9.addType(r10)
            goto L43
        L51:
            int r1 = r1 + 1
            goto Ld
        L54:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.Frame.getInitializedType(net.bytebuddy.jar.asm.SymbolTable, int):int");
    }

    private int getLocal(int i) {
        int[] iArr = this.outputLocals;
        if (iArr == null || i >= iArr.length) {
            return i | 16777216;
        }
        int i3 = iArr[i];
        if (i3 != 0) {
            return i3;
        }
        int i4 = 16777216 | i;
        iArr[i] = i4;
        return i4;
    }

    private int pop() {
        short s3 = this.outputStackTop;
        if (s3 <= 0) {
            short s6 = (short) (this.outputStackStart - 1);
            this.outputStackStart = s6;
            return (-s6) | STACK_KIND;
        }
        int[] iArr = this.outputStack;
        short s7 = (short) (s3 - 1);
        this.outputStackTop = s7;
        return iArr[s7];
    }

    private void push(int i) {
        if (this.outputStack == null) {
            this.outputStack = new int[10];
        }
        int length = this.outputStack.length;
        short s3 = this.outputStackTop;
        if (s3 >= length) {
            int[] iArr = new int[Math.max(s3 + 1, length * 2)];
            System.arraycopy(this.outputStack, 0, iArr, 0, length);
            this.outputStack = iArr;
        }
        int[] iArr2 = this.outputStack;
        short s6 = this.outputStackTop;
        short s7 = (short) (s6 + 1);
        this.outputStackTop = s7;
        iArr2[s6] = i;
        short s8 = (short) (this.outputStackStart + s7);
        Label label = this.owner;
        if (s8 > label.outputStackMax) {
            label.outputStackMax = s8;
        }
    }

    public static void putAbstractType(SymbolTable symbolTable, int i, ByteVector byteVector) {
        int i3 = ((-67108864) & i) >> 26;
        if (i3 == 0) {
            int i4 = i & VALUE_MASK;
            int i5 = i & KIND_MASK;
            if (i5 == 4194304) {
                byteVector.putByte(i4);
                return;
            } else if (i5 == 8388608) {
                byteVector.putByte(7).putShort(symbolTable.addConstantClass(symbolTable.getType(i4).value).index);
                return;
            } else {
                if (i5 != UNINITIALIZED_KIND) {
                    throw new AssertionError();
                }
                byteVector.putByte(8).putShort((int) symbolTable.getType(i4).data);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i6 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
            i3 = i6;
        }
        if ((i & KIND_MASK) == 8388608) {
            sb.append('L');
            sb.append(symbolTable.getType(i & VALUE_MASK).value);
            sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
        } else {
            int i7 = i & VALUE_MASK;
            if (i7 == 1) {
                sb.append('I');
            } else if (i7 == 2) {
                sb.append('F');
            } else if (i7 == 3) {
                sb.append('D');
            } else if (i7 != 4) {
                switch (i7) {
                    case 9:
                        sb.append('Z');
                        break;
                    case 10:
                        sb.append('B');
                        break;
                    case 11:
                        sb.append('C');
                        break;
                    case 12:
                        sb.append('S');
                        break;
                    default:
                        throw new AssertionError();
                }
            } else {
                sb.append('J');
            }
        }
        byteVector.putByte(7).putShort(symbolTable.addConstantClass(sb.toString()).index);
    }

    private void setLocal(int i, int i3) {
        if (this.outputLocals == null) {
            this.outputLocals = new int[10];
        }
        int length = this.outputLocals.length;
        if (i >= length) {
            int[] iArr = new int[Math.max(i + 1, length * 2)];
            System.arraycopy(this.outputLocals, 0, iArr, 0, length);
            this.outputLocals = iArr;
        }
        this.outputLocals[i] = i3;
    }

    public final void accept(MethodWriter methodWriter) {
        int[] iArr = this.inputLocals;
        int i = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = 2;
            if (i3 >= iArr.length) {
                break;
            }
            int i7 = iArr[i3];
            if (i7 != LONG && i7 != DOUBLE) {
                i6 = 1;
            }
            i3 += i6;
            if (i7 == 4194304) {
                i5++;
            } else {
                i4 += i5 + 1;
                i5 = 0;
            }
        }
        int[] iArr2 = this.inputStack;
        int i8 = 0;
        int i9 = 0;
        while (i8 < iArr2.length) {
            int i10 = iArr2[i8];
            i8 += (i10 == LONG || i10 == DOUBLE) ? 2 : 1;
            i9++;
        }
        int iVisitFrameStart = methodWriter.visitFrameStart(this.owner.bytecodeOffset, i4, i9);
        int i11 = 0;
        while (true) {
            int i12 = i4 - 1;
            if (i4 <= 0) {
                break;
            }
            int i13 = iArr[i11];
            i11 += (i13 == LONG || i13 == DOUBLE) ? 2 : 1;
            methodWriter.visitAbstractType(iVisitFrameStart, i13);
            i4 = i12;
            iVisitFrameStart++;
        }
        while (true) {
            int i14 = i9 - 1;
            if (i9 <= 0) {
                methodWriter.visitFrameEnd();
                return;
            }
            int i15 = iArr2[i];
            i += (i15 == LONG || i15 == DOUBLE) ? 2 : 1;
            methodWriter.visitAbstractType(iVisitFrameStart, i15);
            iVisitFrameStart++;
            i9 = i14;
        }
    }

    public final void copyFrom(Frame frame) {
        this.inputLocals = frame.inputLocals;
        this.inputStack = frame.inputStack;
        this.outputStackStart = (short) 0;
        this.outputLocals = frame.outputLocals;
        this.outputStack = frame.outputStack;
        this.outputStackTop = frame.outputStackTop;
        this.initializationCount = frame.initializationCount;
        this.initializations = frame.initializations;
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0316  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void execute(int r19, int r20, net.bytebuddy.jar.asm.Symbol r21, net.bytebuddy.jar.asm.SymbolTable r22) {
        /*
            Method dump skipped, instruction units count: 1178
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.Frame.execute(int, int, net.bytebuddy.jar.asm.Symbol, net.bytebuddy.jar.asm.SymbolTable):void");
    }

    public final int getInputStackSize() {
        return this.inputStack.length;
    }

    public final boolean merge(SymbolTable symbolTable, Frame frame, int i) {
        boolean zMerge;
        int i3;
        int length = this.inputLocals.length;
        int length2 = this.inputStack.length;
        boolean zMerge2 = true;
        if (frame.inputLocals == null) {
            frame.inputLocals = new int[length];
            zMerge = true;
        } else {
            zMerge = false;
        }
        int i4 = 0;
        while (i4 < length) {
            int[] iArr = this.outputLocals;
            int initializedType = (iArr == null || i4 >= iArr.length || (i3 = iArr[i4]) == 0) ? this.inputLocals[i4] : getConcreteOutputType(i3, length2);
            if (this.initializations != null) {
                initializedType = getInitializedType(symbolTable, initializedType);
            }
            zMerge |= merge(symbolTable, initializedType, frame.inputLocals, i4);
            i4++;
        }
        if (i > 0) {
            for (int i5 = 0; i5 < length; i5++) {
                zMerge |= merge(symbolTable, this.inputLocals[i5], frame.inputLocals, i5);
            }
            if (frame.inputStack == null) {
                frame.inputStack = new int[1];
            } else {
                zMerge2 = zMerge;
            }
            return merge(symbolTable, i, frame.inputStack, 0) | zMerge2;
        }
        int length3 = this.inputStack.length + this.outputStackStart;
        if (frame.inputStack == null) {
            frame.inputStack = new int[this.outputStackTop + length3];
        } else {
            zMerge2 = zMerge;
        }
        for (int i6 = 0; i6 < length3; i6++) {
            int initializedType2 = this.inputStack[i6];
            if (this.initializations != null) {
                initializedType2 = getInitializedType(symbolTable, initializedType2);
            }
            zMerge2 |= merge(symbolTable, initializedType2, frame.inputStack, i6);
        }
        for (int i7 = 0; i7 < this.outputStackTop; i7++) {
            int concreteOutputType = getConcreteOutputType(this.outputStack[i7], length2);
            if (this.initializations != null) {
                concreteOutputType = getInitializedType(symbolTable, concreteOutputType);
            }
            zMerge2 |= merge(symbolTable, concreteOutputType, frame.inputStack, length3 + i7);
        }
        return zMerge2;
    }

    public final void setInputFrameFromApiFormat(SymbolTable symbolTable, int i, Object[] objArr, int i3, Object[] objArr2) {
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i4 + 1;
            this.inputLocals[i4] = getAbstractTypeFromApiFormat(symbolTable, objArr[i5]);
            Object obj = objArr[i5];
            if (obj == Opcodes.LONG || obj == Opcodes.DOUBLE) {
                i4 += 2;
                this.inputLocals[i6] = 4194304;
            } else {
                i4 = i6;
            }
        }
        while (true) {
            int[] iArr = this.inputLocals;
            if (i4 >= iArr.length) {
                break;
            }
            iArr[i4] = 4194304;
            i4++;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < i3; i8++) {
            Object obj2 = objArr2[i8];
            if (obj2 == Opcodes.LONG || obj2 == Opcodes.DOUBLE) {
                i7++;
            }
        }
        this.inputStack = new int[i7 + i3];
        int i9 = 0;
        for (int i10 = 0; i10 < i3; i10++) {
            int i11 = i9 + 1;
            this.inputStack[i9] = getAbstractTypeFromApiFormat(symbolTable, objArr2[i10]);
            Object obj3 = objArr2[i10];
            if (obj3 == Opcodes.LONG || obj3 == Opcodes.DOUBLE) {
                i9 += 2;
                this.inputStack[i11] = 4194304;
            } else {
                i9 = i11;
            }
        }
        this.outputStackTop = (short) 0;
        this.initializationCount = 0;
    }

    public final void setInputFrameFromDescriptor(SymbolTable symbolTable, int i, String str, int i3) {
        int i4;
        int[] iArr = new int[i3];
        this.inputLocals = iArr;
        this.inputStack = new int[0];
        if ((i & 8) == 0) {
            i4 = 1;
            if ((i & 262144) == 0) {
                iArr[0] = symbolTable.addType(symbolTable.getClassName()) | 8388608;
            } else {
                iArr[0] = UNINITIALIZED_THIS;
            }
        } else {
            i4 = 0;
        }
        for (Type type : Type.getArgumentTypes(str)) {
            int abstractTypeFromDescriptor = getAbstractTypeFromDescriptor(symbolTable, type.getDescriptor(), 0);
            int[] iArr2 = this.inputLocals;
            int i5 = i4 + 1;
            iArr2[i4] = abstractTypeFromDescriptor;
            if (abstractTypeFromDescriptor == LONG || abstractTypeFromDescriptor == DOUBLE) {
                i4 += 2;
                iArr2[i5] = 4194304;
            } else {
                i4 = i5;
            }
        }
        while (i4 < i3) {
            this.inputLocals[i4] = 4194304;
            i4++;
        }
    }

    private void pop(int i) {
        short s3 = this.outputStackTop;
        if (s3 >= i) {
            this.outputStackTop = (short) (s3 - i);
        } else {
            this.outputStackStart = (short) (this.outputStackStart - (i - s3));
            this.outputStackTop = (short) 0;
        }
    }

    private void pop(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == '(') {
            pop((Type.getArgumentsAndReturnSizes(str) >> 2) - 1);
        } else if (cCharAt != 'J' && cCharAt != 'D') {
            pop(1);
        } else {
            pop(2);
        }
    }

    private void push(SymbolTable symbolTable, String str) {
        int abstractTypeFromDescriptor = getAbstractTypeFromDescriptor(symbolTable, str, str.charAt(0) == '(' ? Type.getReturnTypeOffset(str) : 0);
        if (abstractTypeFromDescriptor != 0) {
            push(abstractTypeFromDescriptor);
            if (abstractTypeFromDescriptor == LONG || abstractTypeFromDescriptor == DOUBLE) {
                push(4194304);
            }
        }
    }

    private static boolean merge(SymbolTable symbolTable, int i, int[] iArr, int i3) {
        int iMin;
        int iAddType;
        int i4 = iArr[i3];
        if (i4 == i) {
            return false;
        }
        if ((67108863 & i) == NULL) {
            if (i4 == NULL) {
                return false;
            }
            i = NULL;
        }
        if (i4 == 0) {
            iArr[i3] = i;
            return true;
        }
        int i5 = i4 & (-67108864);
        int iAddMergedType = 4194304;
        if (i5 != 0 || (i4 & KIND_MASK) == 8388608) {
            if (i == NULL) {
                return false;
            }
            if ((i & (-4194304)) != ((-4194304) & i4)) {
                int i6 = i & (-67108864);
                if (i6 != 0 || (i & KIND_MASK) == 8388608) {
                    if (i6 != 0 && (i & KIND_MASK) != 8388608) {
                        i6 -= 67108864;
                    }
                    if (i5 != 0 && (i4 & KIND_MASK) != 8388608) {
                        i5 -= 67108864;
                    }
                    iMin = Math.min(i6, i5) | 8388608;
                    iAddType = symbolTable.addType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME);
                    iAddMergedType = iMin | iAddType;
                }
            } else if ((i4 & KIND_MASK) == 8388608) {
                iAddMergedType = (i & (-67108864)) | 8388608 | symbolTable.addMergedType(i & VALUE_MASK, VALUE_MASK & i4);
            } else {
                iMin = ((i & (-67108864)) - 67108864) | 8388608;
                iAddType = symbolTable.addType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME);
                iAddMergedType = iMin | iAddType;
            }
        } else if (i4 == NULL) {
            if ((i & (-67108864)) == 0 && (i & KIND_MASK) != 8388608) {
                i = 4194304;
            }
            iAddMergedType = i;
        }
        if (iAddMergedType == i4) {
            return false;
        }
        iArr[i3] = iAddMergedType;
        return true;
    }
}
