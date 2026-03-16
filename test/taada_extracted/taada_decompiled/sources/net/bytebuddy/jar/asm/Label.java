package net.bytebuddy.jar.asm;

/* JADX INFO: loaded from: classes2.dex */
public class Label {
    static final Label EMPTY_LIST = new Label();
    static final int FLAG_DEBUG_ONLY = 1;
    static final int FLAG_JUMP_TARGET = 2;
    static final int FLAG_REACHABLE = 8;
    static final int FLAG_RESOLVED = 4;
    static final int FLAG_SUBROUTINE_CALLER = 16;
    static final int FLAG_SUBROUTINE_END = 64;
    static final int FLAG_SUBROUTINE_START = 32;
    static final int FORWARD_REFERENCES_CAPACITY_INCREMENT = 6;
    static final int FORWARD_REFERENCE_HANDLE_MASK = 268435455;
    static final int FORWARD_REFERENCE_TYPE_MASK = -268435456;
    static final int FORWARD_REFERENCE_TYPE_SHORT = 268435456;
    static final int FORWARD_REFERENCE_TYPE_WIDE = 536870912;
    static final int LINE_NUMBERS_CAPACITY_INCREMENT = 4;
    int bytecodeOffset;
    short flags;
    private int[] forwardReferences;
    Frame frame;
    public Object info;
    short inputStackSize;
    private short lineNumber;
    Label nextBasicBlock;
    Label nextListElement;
    private int[] otherLineNumbers;
    Edge outgoingEdges;
    short outputStackMax;
    short outputStackSize;
    short subroutineId;

    private void addForwardReference(int i, int i3, int i4) {
        if (this.forwardReferences == null) {
            this.forwardReferences = new int[6];
        }
        int[] iArr = this.forwardReferences;
        int i5 = iArr[0];
        if (i5 + 2 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.forwardReferences = iArr2;
        }
        int[] iArr3 = this.forwardReferences;
        iArr3[i5 + 1] = i;
        int i6 = i5 + 2;
        iArr3[i6] = i3 | i4;
        iArr3[0] = i6;
    }

    private Label pushSuccessors(Label label) {
        for (Edge edge = this.outgoingEdges; edge != null; edge = edge.nextEdge) {
            if ((this.flags & 16) == 0 || edge != this.outgoingEdges.nextEdge) {
                Label label2 = edge.successor;
                if (label2.nextListElement == null) {
                    label2.nextListElement = label;
                    label = label2;
                }
            }
        }
        return label;
    }

    public final void accept(MethodVisitor methodVisitor, boolean z6) {
        short s3;
        methodVisitor.visitLabel(this);
        if (!z6 || (s3 = this.lineNumber) == 0) {
            return;
        }
        methodVisitor.visitLineNumber(s3 & 65535, this);
        if (this.otherLineNumbers == null) {
            return;
        }
        int i = 1;
        while (true) {
            int[] iArr = this.otherLineNumbers;
            if (i > iArr[0]) {
                return;
            }
            methodVisitor.visitLineNumber(iArr[i], this);
            i++;
        }
    }

    public final void addLineNumber(int i) {
        if (this.lineNumber == 0) {
            this.lineNumber = (short) i;
            return;
        }
        if (this.otherLineNumbers == null) {
            this.otherLineNumbers = new int[4];
        }
        int[] iArr = this.otherLineNumbers;
        int i3 = iArr[0] + 1;
        iArr[0] = i3;
        if (i3 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 4];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.otherLineNumbers = iArr2;
        }
        this.otherLineNumbers[i3] = i;
    }

    public final void addSubroutineRetSuccessors(Label label) {
        Label label2 = EMPTY_LIST;
        this.nextListElement = label2;
        Label label3 = label2;
        Label labelPushSuccessors = this;
        while (labelPushSuccessors != EMPTY_LIST) {
            Label label4 = labelPushSuccessors.nextListElement;
            labelPushSuccessors.nextListElement = label3;
            if ((labelPushSuccessors.flags & 64) != 0 && labelPushSuccessors.subroutineId != label.subroutineId) {
                labelPushSuccessors.outgoingEdges = new Edge(labelPushSuccessors.outputStackSize, label.outgoingEdges.successor, labelPushSuccessors.outgoingEdges);
            }
            label3 = labelPushSuccessors;
            labelPushSuccessors = labelPushSuccessors.pushSuccessors(label4);
        }
        while (label3 != EMPTY_LIST) {
            Label label5 = label3.nextListElement;
            label3.nextListElement = null;
            label3 = label5;
        }
    }

    public final Label getCanonicalInstance() {
        Frame frame = this.frame;
        return frame == null ? this : frame.owner;
    }

    public int getOffset() {
        if ((this.flags & 4) != 0) {
            return this.bytecodeOffset;
        }
        throw new IllegalStateException("Label offset position has not been resolved yet");
    }

    public final void markSubroutine(short s3) {
        this.nextListElement = EMPTY_LIST;
        Label labelPushSuccessors = this;
        while (labelPushSuccessors != EMPTY_LIST) {
            Label label = labelPushSuccessors.nextListElement;
            labelPushSuccessors.nextListElement = null;
            if (labelPushSuccessors.subroutineId == 0) {
                labelPushSuccessors.subroutineId = s3;
                labelPushSuccessors = labelPushSuccessors.pushSuccessors(label);
            } else {
                labelPushSuccessors = label;
            }
        }
    }

    public final void put(ByteVector byteVector, int i, boolean z6) {
        if ((this.flags & 4) != 0) {
            if (z6) {
                byteVector.putInt(this.bytecodeOffset - i);
                return;
            } else {
                byteVector.putShort(this.bytecodeOffset - i);
                return;
            }
        }
        if (z6) {
            addForwardReference(i, FORWARD_REFERENCE_TYPE_WIDE, byteVector.length);
            byteVector.putInt(-1);
        } else {
            addForwardReference(i, FORWARD_REFERENCE_TYPE_SHORT, byteVector.length);
            byteVector.putShort(-1);
        }
    }

    public final boolean resolve(byte[] bArr, int i) {
        this.flags = (short) (this.flags | 4);
        this.bytecodeOffset = i;
        int[] iArr = this.forwardReferences;
        boolean z6 = false;
        if (iArr == null) {
            return false;
        }
        for (int i3 = iArr[0]; i3 > 0; i3 -= 2) {
            int[] iArr2 = this.forwardReferences;
            int i4 = iArr2[i3 - 1];
            int i5 = iArr2[i3];
            int i6 = i - i4;
            int i7 = FORWARD_REFERENCE_HANDLE_MASK & i5;
            if ((i5 & FORWARD_REFERENCE_TYPE_MASK) == FORWARD_REFERENCE_TYPE_SHORT) {
                if (i6 < -32768 || i6 > 32767) {
                    int i8 = bArr[i4] & 255;
                    if (i8 < 198) {
                        bArr[i4] = (byte) (i8 + 49);
                    } else {
                        bArr[i4] = (byte) (i8 + 20);
                    }
                    z6 = true;
                }
                bArr[i7] = (byte) (i6 >>> 8);
                bArr[i7 + 1] = (byte) i6;
            } else {
                bArr[i7] = (byte) (i6 >>> 24);
                bArr[i7 + 1] = (byte) (i6 >>> 16);
                bArr[i7 + 2] = (byte) (i6 >>> 8);
                bArr[i7 + 3] = (byte) i6;
            }
        }
        return z6;
    }

    public String toString() {
        return "L" + System.identityHashCode(this);
    }
}
