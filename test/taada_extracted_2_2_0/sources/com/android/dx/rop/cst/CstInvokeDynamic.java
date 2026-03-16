package com.android.dx.rop.cst;

import B2.b;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CstInvokeDynamic extends Constant {
    private final int bootstrapMethodIndex;
    private CstCallSite callSite;
    private CstType declaringClass;
    private final CstNat nat;
    private final Prototype prototype;
    private final List<CstCallSiteRef> references = new ArrayList();

    private CstInvokeDynamic(int i, CstNat cstNat) {
        this.bootstrapMethodIndex = i;
        this.nat = cstNat;
        this.prototype = Prototype.fromDescriptor(cstNat.getDescriptor().toHuman());
    }

    public static CstInvokeDynamic make(int i, CstNat cstNat) {
        return new CstInvokeDynamic(i, cstNat);
    }

    public CstCallSiteRef addReference() {
        CstCallSiteRef cstCallSiteRef = new CstCallSiteRef(this, this.references.size());
        this.references.add(cstCallSiteRef);
        return cstCallSiteRef;
    }

    @Override // com.android.dx.rop.cst.Constant
    public int compareTo0(Constant constant) {
        CstInvokeDynamic cstInvokeDynamic = (CstInvokeDynamic) constant;
        int iCompare = Integer.compare(this.bootstrapMethodIndex, cstInvokeDynamic.getBootstrapMethodIndex());
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompareTo = this.nat.compareTo((Constant) cstInvokeDynamic.getNat());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int iCompareTo2 = this.declaringClass.compareTo((Constant) cstInvokeDynamic.getDeclaringClass());
        return iCompareTo2 != 0 ? iCompareTo2 : this.callSite.compareTo((Constant) cstInvokeDynamic.getCallSite());
    }

    public int getBootstrapMethodIndex() {
        return this.bootstrapMethodIndex;
    }

    public CstCallSite getCallSite() {
        return this.callSite;
    }

    public CstType getDeclaringClass() {
        return this.declaringClass;
    }

    public CstNat getNat() {
        return this.nat;
    }

    public Prototype getPrototype() {
        return this.prototype;
    }

    public List<CstCallSiteRef> getReferences() {
        return this.references;
    }

    public Type getReturnType() {
        return this.prototype.getReturnType();
    }

    @Override // com.android.dx.rop.cst.Constant
    public boolean isCategory2() {
        return false;
    }

    public void setCallSite(CstCallSite cstCallSite) {
        if (this.callSite != null) {
            throw new IllegalArgumentException("already added call site");
        }
        if (cstCallSite == null) {
            throw new NullPointerException("callSite == null");
        }
        this.callSite = cstCallSite;
    }

    public void setDeclaringClass(CstType cstType) {
        if (this.declaringClass != null) {
            throw new IllegalArgumentException("already added declaring class");
        }
        if (cstType == null) {
            throw new NullPointerException("declaringClass == null");
        }
        this.declaringClass = cstType;
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        CstType cstType = this.declaringClass;
        StringBuilder sbM = b.m("InvokeDynamic(", cstType != null ? cstType.toHuman() : "Unknown", ":");
        sbM.append(this.bootstrapMethodIndex);
        sbM.append(", ");
        sbM.append(this.nat.toHuman());
        sbM.append(")");
        return sbM.toString();
    }

    public String toString() {
        return toHuman();
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return "InvokeDynamic";
    }
}
