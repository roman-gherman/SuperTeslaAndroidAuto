package com.android.dx.cf.direct;

import B2.b;
import androidx.constraintlayout.core.motion.a;
import com.android.dx.cf.code.ByteOps;
import com.android.dx.cf.code.BytecodeArray;
import com.android.dx.cf.code.SwitchList;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstDouble;
import com.android.dx.rop.cst.CstFloat;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstKnownNull;
import com.android.dx.rop.cst.CstLong;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class CodeObserver implements BytecodeArray.Visitor {
    private final ByteArray bytes;
    private final ParseObserver observer;

    public CodeObserver(ByteArray byteArray, ParseObserver parseObserver) {
        if (byteArray == null) {
            throw new NullPointerException("bytes == null");
        }
        if (parseObserver == null) {
            throw new NullPointerException("observer == null");
        }
        this.bytes = byteArray;
        this.observer = parseObserver;
    }

    private String header(int i) {
        int unsignedByte = this.bytes.getUnsignedByte(i);
        String strOpName = ByteOps.opName(unsignedByte);
        if (unsignedByte == 196) {
            int unsignedByte2 = this.bytes.getUnsignedByte(i + 1);
            StringBuilder sbL = b.l(strOpName, " ");
            sbL.append(ByteOps.opName(unsignedByte2));
            strOpName = sbL.toString();
        }
        return Hex.u2(i) + ": " + strOpName;
    }

    private void visitLiteralDouble(int i, int i3, int i4, long j6) {
        String str;
        if (i4 != 1) {
            str = " #" + Hex.u8(j6);
        } else {
            str = "";
        }
        ParseObserver parseObserver = this.observer;
        ByteArray byteArray = this.bytes;
        StringBuilder sb = new StringBuilder();
        b.r(sb, header(i3), str, " // ");
        sb.append(Double.longBitsToDouble(j6));
        parseObserver.parsed(byteArray, i3, i4, sb.toString());
    }

    private void visitLiteralFloat(int i, int i3, int i4, int i5) {
        String str;
        if (i4 != 1) {
            str = " #" + Hex.u4(i5);
        } else {
            str = "";
        }
        this.observer.parsed(this.bytes, i3, i4, header(i3) + str + " // " + Float.intBitsToFloat(i5));
    }

    private void visitLiteralInt(int i, int i3, int i4, int i5) {
        String str;
        String str2 = i4 == 1 ? " // " : " ";
        int unsignedByte = this.bytes.getUnsignedByte(i3);
        if (i4 == 1 || unsignedByte == 16) {
            str = "#" + Hex.s1(i5);
        } else if (unsignedByte == 17) {
            str = "#" + Hex.s2(i5);
        } else {
            str = "#" + Hex.s4(i5);
        }
        this.observer.parsed(this.bytes, i3, i4, header(i3) + str2 + str);
    }

    private void visitLiteralLong(int i, int i3, int i4, long j6) {
        String str = i4 == 1 ? " // " : " #";
        String strS1 = i4 == 1 ? Hex.s1((int) j6) : Hex.s8(j6);
        this.observer.parsed(this.bytes, i3, i4, header(i3) + str + strS1);
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public int getPreviousOffset() {
        return -1;
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void setPreviousOffset(int i) {
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitBranch(int i, int i3, int i4, int i5) {
        String strU2 = i4 <= 3 ? Hex.u2(i5) : Hex.u4(i5);
        this.observer.parsed(this.bytes, i3, i4, header(i3) + " " + strU2);
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitConstant(int i, int i3, int i4, Constant constant, int i5) {
        String strZ;
        if (constant instanceof CstKnownNull) {
            visitNoArgs(i, i3, i4, null);
            return;
        }
        if (constant instanceof CstInteger) {
            visitLiteralInt(i, i3, i4, i5);
            return;
        }
        if (constant instanceof CstLong) {
            visitLiteralLong(i, i3, i4, ((CstLong) constant).getValue());
            return;
        }
        if (constant instanceof CstFloat) {
            visitLiteralFloat(i, i3, i4, ((CstFloat) constant).getIntBits());
            return;
        }
        if (constant instanceof CstDouble) {
            visitLiteralDouble(i, i3, i4, ((CstDouble) constant).getLongBits());
            return;
        }
        if (i5 == 0) {
            strZ = "";
        } else if (i == 197) {
            strZ = ", " + Hex.u1(i5);
        } else {
            strZ = a.z(i5, new StringBuilder(", "));
        }
        this.observer.parsed(this.bytes, i3, i4, header(i3) + " " + constant + strZ);
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitInvalid(int i, int i3, int i4) {
        this.observer.parsed(this.bytes, i3, i4, header(i3));
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitLocal(int i, int i3, int i4, int i5, Type type, int i6) {
        String string;
        String strU1 = i4 <= 3 ? Hex.u1(i5) : Hex.u2(i5);
        boolean z6 = i4 == 1;
        String strConcat = "";
        if (i == 132) {
            StringBuilder sb = new StringBuilder(", #");
            sb.append(i4 <= 3 ? Hex.s1(i6) : Hex.s2(i6));
            string = sb.toString();
        } else {
            string = "";
        }
        if (type.isCategory2()) {
            strConcat = (z6 ? "," : " //").concat(" category-2");
        }
        ParseObserver parseObserver = this.observer;
        ByteArray byteArray = this.bytes;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(header(i3));
        sb2.append(z6 ? " // " : " ");
        sb2.append(strU1);
        sb2.append(string);
        sb2.append(strConcat);
        parseObserver.parsed(byteArray, i3, i4, sb2.toString());
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitNewarray(int i, int i3, CstType cstType, ArrayList<Constant> arrayList) {
        String str = i3 == 1 ? " // " : " ";
        String human = cstType.getClassType().getComponentType().toHuman();
        this.observer.parsed(this.bytes, i, i3, header(i) + str + human);
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitNoArgs(int i, int i3, int i4, Type type) {
        this.observer.parsed(this.bytes, i3, i4, header(i3));
    }

    @Override // com.android.dx.cf.code.BytecodeArray.Visitor
    public void visitSwitch(int i, int i3, int i4, SwitchList switchList, int i5) {
        int size = switchList.size();
        StringBuilder sb = new StringBuilder((size * 20) + 100);
        sb.append(header(i3));
        if (i5 != 0) {
            sb.append(" // padding: " + Hex.u4(i5));
        }
        sb.append('\n');
        for (int i6 = 0; i6 < size; i6++) {
            sb.append("  ");
            sb.append(Hex.s4(switchList.getValue(i6)));
            sb.append(": ");
            sb.append(Hex.u2(switchList.getTarget(i6)));
            sb.append('\n');
        }
        sb.append("  default: ");
        sb.append(Hex.u2(switchList.getDefaultTarget()));
        this.observer.parsed(this.bytes, i3, i4, sb.toString());
    }
}
