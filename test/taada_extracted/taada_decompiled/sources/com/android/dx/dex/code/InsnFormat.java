package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstKnownNull;
import com.android.dx.rop.cst.CstLiteral64;
import com.android.dx.rop.cst.CstLiteralBits;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class InsnFormat {
    public static final boolean ALLOW_EXTENDED_OPCODES = true;

    public static int argIndex(DalvInsn dalvInsn) {
        int value = ((CstInteger) ((CstInsn) dalvInsn).getConstant()).getValue();
        if (value >= 0) {
            return value;
        }
        throw new IllegalArgumentException("bogus insn");
    }

    public static String branchComment(DalvInsn dalvInsn) {
        int targetOffset = ((TargetInsn) dalvInsn).getTargetOffset();
        return targetOffset == ((short) targetOffset) ? Hex.s2(targetOffset) : Hex.s4(targetOffset);
    }

    public static String branchString(DalvInsn dalvInsn) {
        int targetAddress = ((TargetInsn) dalvInsn).getTargetAddress();
        return targetAddress == ((char) targetAddress) ? Hex.u2(targetAddress) : Hex.u4(targetAddress);
    }

    public static short codeUnit(int i, int i3) {
        if ((i & 255) != i) {
            throw new IllegalArgumentException("low out of range 0..255");
        }
        if ((i3 & 255) == i3) {
            return (short) (i | (i3 << 8));
        }
        throw new IllegalArgumentException("high out of range 0..255");
    }

    public static boolean isRegListSequential(RegisterSpecList registerSpecList) {
        int size = registerSpecList.size();
        if (size < 2) {
            return true;
        }
        int reg = registerSpecList.get(0).getReg();
        for (int i = 0; i < size; i++) {
            RegisterSpec registerSpec = registerSpecList.get(i);
            if (registerSpec.getReg() != reg) {
                return false;
            }
            reg += registerSpec.getCategory();
        }
        return true;
    }

    public static String literalBitsComment(CstLiteralBits cstLiteralBits, int i) {
        StringBuilder sb = new StringBuilder(20);
        sb.append("#");
        long longBits = cstLiteralBits instanceof CstLiteral64 ? ((CstLiteral64) cstLiteralBits).getLongBits() : cstLiteralBits.getIntBits();
        if (i == 4) {
            sb.append(Hex.uNibble((int) longBits));
        } else if (i == 8) {
            sb.append(Hex.u1((int) longBits));
        } else if (i == 16) {
            sb.append(Hex.u2((int) longBits));
        } else if (i == 32) {
            sb.append(Hex.u4((int) longBits));
        } else {
            if (i != 64) {
                throw new RuntimeException("shouldn't happen");
            }
            sb.append(Hex.u8(longBits));
        }
        return sb.toString();
    }

    public static String literalBitsString(CstLiteralBits cstLiteralBits) {
        StringBuilder sb = new StringBuilder(100);
        sb.append('#');
        if (cstLiteralBits instanceof CstKnownNull) {
            sb.append("null");
        } else {
            sb.append(cstLiteralBits.typeName());
            sb.append(' ');
            sb.append(cstLiteralBits.toHuman());
        }
        return sb.toString();
    }

    public static int makeByte(int i, int i3) {
        if ((i & 15) != i) {
            throw new IllegalArgumentException("low out of range 0..15");
        }
        if ((i3 & 15) == i3) {
            return i | (i3 << 4);
        }
        throw new IllegalArgumentException("high out of range 0..15");
    }

    public static short opcodeUnit(DalvInsn dalvInsn, int i) {
        if ((i & 255) != i) {
            throw new IllegalArgumentException("arg out of range 0..255");
        }
        int opcode = dalvInsn.getOpcode().getOpcode();
        if ((opcode & 255) == opcode) {
            return (short) (opcode | (i << 8));
        }
        throw new IllegalArgumentException("opcode out of range 0..255");
    }

    public static String regListString(RegisterSpecList registerSpecList) {
        int size = registerSpecList.size();
        StringBuilder sb = new StringBuilder((size * 5) + 2);
        sb.append('{');
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(registerSpecList.get(i).regString());
        }
        sb.append('}');
        return sb.toString();
    }

    public static String regRangeString(RegisterSpecList registerSpecList) {
        int size = registerSpecList.size();
        StringBuilder sb = new StringBuilder(30);
        sb.append("{");
        if (size != 0) {
            if (size != 1) {
                RegisterSpec registerSpecWithOffset = registerSpecList.get(size - 1);
                if (registerSpecWithOffset.getCategory() == 2) {
                    registerSpecWithOffset = registerSpecWithOffset.withOffset(1);
                }
                sb.append(registerSpecList.get(0).regString());
                sb.append("..");
                sb.append(registerSpecWithOffset.regString());
            } else {
                sb.append(registerSpecList.get(0).regString());
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static boolean signedFitsInByte(int i) {
        return ((byte) i) == i;
    }

    public static boolean signedFitsInNibble(int i) {
        return i >= -8 && i <= 7;
    }

    public static boolean signedFitsInShort(int i) {
        return ((short) i) == i;
    }

    public static boolean unsignedFitsInByte(int i) {
        return i == (i & 255);
    }

    public static boolean unsignedFitsInNibble(int i) {
        return i == (i & 15);
    }

    public static boolean unsignedFitsInShort(int i) {
        return i == (65535 & i);
    }

    public static void write(AnnotatedOutput annotatedOutput, short s3) {
        annotatedOutput.writeShort(s3);
    }

    public boolean branchFits(TargetInsn targetInsn) {
        return false;
    }

    public abstract int codeSize();

    public BitSet compatibleRegs(DalvInsn dalvInsn) {
        return new BitSet();
    }

    public abstract String insnArgString(DalvInsn dalvInsn);

    public abstract String insnCommentString(DalvInsn dalvInsn, boolean z6);

    public abstract boolean isCompatible(DalvInsn dalvInsn);

    public final String listingString(DalvInsn dalvInsn, boolean z6) {
        String name = dalvInsn.getOpcode().getName();
        String strInsnArgString = insnArgString(dalvInsn);
        String strInsnCommentString = insnCommentString(dalvInsn, z6);
        StringBuilder sb = new StringBuilder(100);
        sb.append(name);
        if (strInsnArgString.length() != 0) {
            sb.append(' ');
            sb.append(strInsnArgString);
        }
        if (strInsnCommentString.length() != 0) {
            sb.append(" // ");
            sb.append(strInsnCommentString);
        }
        return sb.toString();
    }

    public abstract void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn);

    public static void write(AnnotatedOutput annotatedOutput, short s3, short s6) {
        annotatedOutput.writeShort(s3);
        annotatedOutput.writeShort(s6);
    }

    public static short codeUnit(int i, int i3, int i4, int i5) {
        if ((i & 15) != i) {
            throw new IllegalArgumentException("n0 out of range 0..15");
        }
        if ((i3 & 15) != i3) {
            throw new IllegalArgumentException("n1 out of range 0..15");
        }
        if ((i4 & 15) != i4) {
            throw new IllegalArgumentException("n2 out of range 0..15");
        }
        if ((i5 & 15) == i5) {
            return (short) (i | (i3 << 4) | (i4 << 8) | (i5 << 12));
        }
        throw new IllegalArgumentException("n3 out of range 0..15");
    }

    public static short opcodeUnit(DalvInsn dalvInsn) {
        int opcode = dalvInsn.getOpcode().getOpcode();
        if (opcode < 256 || opcode > 65535) {
            throw new IllegalArgumentException("opcode out of range 0..65535");
        }
        return (short) opcode;
    }

    public static void write(AnnotatedOutput annotatedOutput, short s3, short s6, short s7) {
        annotatedOutput.writeShort(s3);
        annotatedOutput.writeShort(s6);
        annotatedOutput.writeShort(s7);
    }

    public static void write(AnnotatedOutput annotatedOutput, short s3, short s6, short s7, short s8) {
        annotatedOutput.writeShort(s3);
        annotatedOutput.writeShort(s6);
        annotatedOutput.writeShort(s7);
        annotatedOutput.writeShort(s8);
    }

    public static void write(AnnotatedOutput annotatedOutput, short s3, short s6, short s7, short s8, short s9) {
        annotatedOutput.writeShort(s3);
        annotatedOutput.writeShort(s6);
        annotatedOutput.writeShort(s7);
        annotatedOutput.writeShort(s8);
        annotatedOutput.writeShort(s9);
    }

    public static void write(AnnotatedOutput annotatedOutput, short s3, int i) {
        write(annotatedOutput, s3, (short) i, (short) (i >> 16));
    }

    public static void write(AnnotatedOutput annotatedOutput, short s3, int i, short s6) {
        write(annotatedOutput, s3, (short) i, (short) (i >> 16), s6);
    }

    public static void write(AnnotatedOutput annotatedOutput, short s3, int i, short s6, short s7) {
        write(annotatedOutput, s3, (short) i, (short) (i >> 16), s6, s7);
    }

    public static void write(AnnotatedOutput annotatedOutput, short s3, long j6) {
        write(annotatedOutput, s3, (short) j6, (short) (j6 >> 16), (short) (j6 >> 32), (short) (j6 >> 48));
    }
}
