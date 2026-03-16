package com.android.dx.rop.code;

import B2.b;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.Hex;

/* JADX INFO: loaded from: classes.dex */
public final class Rop {
    public static final int BRANCH_GOTO = 3;
    public static final int BRANCH_IF = 4;
    public static final int BRANCH_MAX = 6;
    public static final int BRANCH_MIN = 1;
    public static final int BRANCH_NONE = 1;
    public static final int BRANCH_RETURN = 2;
    public static final int BRANCH_SWITCH = 5;
    public static final int BRANCH_THROW = 6;
    private final int branchingness;
    private final TypeList exceptions;
    private final boolean isCallLike;
    private final String nickname;
    private final int opcode;
    private final Type result;
    private final TypeList sources;

    public Rop(int i, Type type, TypeList typeList, TypeList typeList2, int i3, boolean z6, String str) {
        if (type == null) {
            throw new NullPointerException("result == null");
        }
        if (typeList == null) {
            throw new NullPointerException("sources == null");
        }
        if (typeList2 == null) {
            throw new NullPointerException("exceptions == null");
        }
        if (i3 < 1 || i3 > 6) {
            throw new IllegalArgumentException(b.c(i3, "invalid branchingness: "));
        }
        if (typeList2.size() != 0 && i3 != 6) {
            throw new IllegalArgumentException("exceptions / branchingness mismatch");
        }
        this.opcode = i;
        this.result = type;
        this.sources = typeList;
        this.exceptions = typeList2;
        this.branchingness = i3;
        this.isCallLike = z6;
        this.nickname = str;
    }

    public final boolean canThrow() {
        return this.exceptions.size() != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rop)) {
            return false;
        }
        Rop rop = (Rop) obj;
        return this.opcode == rop.opcode && this.branchingness == rop.branchingness && this.result == rop.result && this.sources.equals(rop.sources) && this.exceptions.equals(rop.exceptions);
    }

    public int getBranchingness() {
        return this.branchingness;
    }

    public TypeList getExceptions() {
        return this.exceptions;
    }

    public String getNickname() {
        String str = this.nickname;
        return str != null ? str : toString();
    }

    public int getOpcode() {
        return this.opcode;
    }

    public Type getResult() {
        return this.result;
    }

    public TypeList getSources() {
        return this.sources;
    }

    public int hashCode() {
        return this.exceptions.hashCode() + ((this.sources.hashCode() + ((this.result.hashCode() + (((this.opcode * 31) + this.branchingness) * 31)) * 31)) * 31);
    }

    public boolean isCallLike() {
        return this.isCallLike;
    }

    public boolean isCommutative() {
        int i = this.opcode;
        if (i == 14 || i == 16) {
            return true;
        }
        switch (i) {
            case 20:
            case 21:
            case 22:
                return true;
            default:
                return false;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("Rop{");
        sb.append(RegOps.opName(this.opcode));
        if (this.result != Type.VOID) {
            sb.append(" ");
            sb.append(this.result);
        } else {
            sb.append(" .");
        }
        sb.append(" <-");
        int size = this.sources.size();
        if (size == 0) {
            sb.append(" .");
        } else {
            for (int i = 0; i < size; i++) {
                sb.append(' ');
                sb.append(this.sources.getType(i));
            }
        }
        if (this.isCallLike) {
            sb.append(" call");
        }
        int size2 = this.exceptions.size();
        if (size2 != 0) {
            sb.append(" throws");
            for (int i3 = 0; i3 < size2; i3++) {
                sb.append(' ');
                if (this.exceptions.getType(i3) == Type.THROWABLE) {
                    sb.append("<any>");
                } else {
                    sb.append(this.exceptions.getType(i3));
                }
            }
        } else {
            int i4 = this.branchingness;
            if (i4 == 1) {
                sb.append(" flows");
            } else if (i4 == 2) {
                sb.append(" returns");
            } else if (i4 == 3) {
                sb.append(" gotos");
            } else if (i4 == 4) {
                sb.append(" ifs");
            } else if (i4 != 5) {
                sb.append(" " + Hex.u1(this.branchingness));
            } else {
                sb.append(" switches");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public Rop(int i, Type type, TypeList typeList, TypeList typeList2, int i3, String str) {
        this(i, type, typeList, typeList2, i3, false, str);
    }

    public Rop(int i, Type type, TypeList typeList, int i3, String str) {
        this(i, type, typeList, StdTypeList.EMPTY, i3, false, str);
    }

    public Rop(int i, Type type, TypeList typeList, String str) {
        this(i, type, typeList, StdTypeList.EMPTY, 1, false, str);
    }

    public Rop(int i, Type type, TypeList typeList, TypeList typeList2, String str) {
        this(i, type, typeList, typeList2, 6, false, str);
    }

    public Rop(int i, TypeList typeList, TypeList typeList2) {
        this(i, Type.VOID, typeList, typeList2, 6, true, null);
    }
}
