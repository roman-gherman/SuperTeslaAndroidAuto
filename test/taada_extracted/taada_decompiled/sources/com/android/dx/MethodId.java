package com.android.dx;

import androidx.constraintlayout.core.motion.a;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.type.Prototype;
import java.util.List;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes.dex */
public final class MethodId<D, R> {
    final CstMethodRef constant;
    final TypeId<D> declaringType;
    final String name;
    final CstNat nat;
    final TypeList parameters;
    final TypeId<R> returnType;

    public MethodId(TypeId<D> typeId, TypeId<R> typeId2, String str, TypeList typeList) {
        if (typeId == null || typeId2 == null || str == null || typeList == null) {
            throw null;
        }
        this.declaringType = typeId;
        this.returnType = typeId2;
        this.name = str;
        this.parameters = typeList;
        CstNat cstNat = new CstNat(new CstString(str), new CstString(descriptor(false)));
        this.nat = cstNat;
        this.constant = new CstMethodRef(typeId.constant, cstNat);
    }

    public String descriptor(boolean z6) {
        StringBuilder sb = new StringBuilder("(");
        if (z6) {
            sb.append(this.declaringType.name);
        }
        for (TypeId<?> typeId : this.parameters.types) {
            sb.append(typeId.name);
        }
        sb.append(")");
        sb.append(this.returnType.name);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MethodId)) {
            return false;
        }
        MethodId methodId = (MethodId) obj;
        return methodId.declaringType.equals(this.declaringType) && methodId.name.equals(this.name) && methodId.parameters.equals(this.parameters) && methodId.returnType.equals(this.returnType);
    }

    public TypeId<D> getDeclaringType() {
        return this.declaringType;
    }

    public String getName() {
        return this.name;
    }

    public List<TypeId<?>> getParameters() {
        return this.parameters.asList();
    }

    public TypeId<R> getReturnType() {
        return this.returnType;
    }

    public int hashCode() {
        return this.returnType.hashCode() + ((a.c((this.declaringType.hashCode() + 527) * 31, 31, this.name) + this.parameters.hashCode()) * 31);
    }

    public boolean isConstructor() {
        return this.name.equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME);
    }

    public boolean isStaticInitializer() {
        return this.name.equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME);
    }

    public Prototype prototype(boolean z6) {
        return Prototype.intern(descriptor(z6));
    }

    public String toString() {
        return this.declaringType + "." + this.name + "(" + this.parameters + ")";
    }
}
