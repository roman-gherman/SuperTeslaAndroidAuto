package com.android.dx.rop.cst;

import B2.b;
import com.android.dx.rop.type.Type;

/* JADX INFO: loaded from: classes.dex */
public final class CstMethodHandle extends TypedConstant {
    public static final int METHOD_HANDLE_TYPE_INSTANCE_GET = 3;
    public static final int METHOD_HANDLE_TYPE_INSTANCE_PUT = 2;
    public static final int METHOD_HANDLE_TYPE_INVOKE_CONSTRUCTOR = 6;
    public static final int METHOD_HANDLE_TYPE_INVOKE_DIRECT = 7;
    public static final int METHOD_HANDLE_TYPE_INVOKE_INSTANCE = 5;
    public static final int METHOD_HANDLE_TYPE_INVOKE_INTERFACE = 8;
    public static final int METHOD_HANDLE_TYPE_INVOKE_STATIC = 4;
    public static final int METHOD_HANDLE_TYPE_STATIC_GET = 1;
    public static final int METHOD_HANDLE_TYPE_STATIC_PUT = 0;
    private static final String[] TYPE_NAMES = {"static-put", "static-get", "instance-put", "instance-get", "invoke-static", "invoke-instance", "invoke-constructor", "invoke-direct", "invoke-interface"};
    private final Constant ref;
    private final int type;

    private CstMethodHandle(int i, Constant constant) {
        this.type = i;
        this.ref = constant;
    }

    public static String getMethodHandleTypeName(int i) {
        return TYPE_NAMES[i];
    }

    public static boolean isAccessor(int i) {
        return i == 0 || i == 1 || i == 2 || i == 3;
    }

    public static boolean isInvocation(int i) {
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static CstMethodHandle make(int i, Constant constant) {
        if (isAccessor(i)) {
            if (!(constant instanceof CstFieldRef)) {
                throw new IllegalArgumentException("ref has wrong type: " + constant.getClass());
            }
        } else {
            if (!isInvocation(i)) {
                throw new IllegalArgumentException(b.c(i, "type is out of range: "));
            }
            if (!(constant instanceof CstBaseMethodRef)) {
                throw new IllegalArgumentException("ref has wrong type: " + constant.getClass());
            }
        }
        return new CstMethodHandle(i, constant);
    }

    @Override // com.android.dx.rop.cst.Constant
    public int compareTo0(Constant constant) {
        CstMethodHandle cstMethodHandle = (CstMethodHandle) constant;
        return getMethodHandleType() == cstMethodHandle.getMethodHandleType() ? getRef().compareTo(cstMethodHandle.getRef()) : Integer.compare(getMethodHandleType(), cstMethodHandle.getMethodHandleType());
    }

    public int getMethodHandleType() {
        return this.type;
    }

    public Constant getRef() {
        return this.ref;
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getType() {
        return Type.METHOD_HANDLE;
    }

    @Override // com.android.dx.rop.cst.Constant
    public boolean isCategory2() {
        return false;
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return getMethodHandleTypeName(this.type) + "," + this.ref.toString();
    }

    public String toString() {
        return "method-handle{" + toHuman() + "}";
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return "method handle";
    }

    public boolean isAccessor() {
        return isAccessor(this.type);
    }

    public boolean isInvocation() {
        return isInvocation(this.type);
    }
}
