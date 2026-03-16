package com.android.dx.rop.cst;

import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.Type;

/* JADX INFO: loaded from: classes.dex */
public final class CstProtoRef extends TypedConstant {
    private final Prototype prototype;

    public CstProtoRef(Prototype prototype) {
        this.prototype = prototype;
    }

    public static CstProtoRef make(CstString cstString) {
        return new CstProtoRef(Prototype.fromDescriptor(cstString.getString()));
    }

    @Override // com.android.dx.rop.cst.Constant
    public int compareTo0(Constant constant) {
        return this.prototype.compareTo(((CstProtoRef) constant).getPrototype());
    }

    public boolean equals(Object obj) {
        if (obj instanceof CstProtoRef) {
            return getPrototype().equals(((CstProtoRef) obj).getPrototype());
        }
        return false;
    }

    public Prototype getPrototype() {
        return this.prototype;
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getType() {
        return Type.METHOD_TYPE;
    }

    public int hashCode() {
        return this.prototype.hashCode();
    }

    @Override // com.android.dx.rop.cst.Constant
    public boolean isCategory2() {
        return false;
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return this.prototype.getDescriptor();
    }

    public final String toString() {
        return typeName() + "{" + toHuman() + '}';
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return "proto";
    }
}
