package com.android.dx.rop.code;

import B2.b;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.ToHuman;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class RegisterSpec implements TypeBearer, ToHuman, Comparable<RegisterSpec> {
    public static final String PREFIX = "v";
    private final LocalItem local;
    private final int reg;
    private final TypeBearer type;
    private static final ConcurrentHashMap<Object, RegisterSpec> theInterns = new ConcurrentHashMap<>(10000, 0.75f);
    private static final ThreadLocal<ForComparison> theInterningItem = new ThreadLocal<ForComparison>() { // from class: com.android.dx.rop.code.RegisterSpec.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public ForComparison initialValue() {
            return new ForComparison();
        }
    };

    public static class ForComparison {
        private LocalItem local;
        private int reg;
        private TypeBearer type;

        private ForComparison() {
        }

        public boolean equals(Object obj) {
            if (obj instanceof RegisterSpec) {
                return ((RegisterSpec) obj).equals(this.reg, this.type, this.local);
            }
            return false;
        }

        public int hashCode() {
            return RegisterSpec.hashCodeOf(this.reg, this.type, this.local);
        }

        public void set(int i, TypeBearer typeBearer, LocalItem localItem) {
            this.reg = i;
            this.type = typeBearer;
            this.local = localItem;
        }

        public RegisterSpec toRegisterSpec() {
            return new RegisterSpec(this.reg, this.type, this.local);
        }
    }

    public static void clearInternTable() {
        theInterns.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hashCodeOf(int i, TypeBearer typeBearer, LocalItem localItem) {
        return ((typeBearer.hashCode() + ((localItem != null ? localItem.hashCode() : 0) * 31)) * 31) + i;
    }

    private static RegisterSpec intern(int i, TypeBearer typeBearer, LocalItem localItem) {
        RegisterSpec registerSpecPutIfAbsent;
        ForComparison forComparison = theInterningItem.get();
        forComparison.set(i, typeBearer, localItem);
        ConcurrentHashMap<Object, RegisterSpec> concurrentHashMap = theInterns;
        RegisterSpec registerSpec = concurrentHashMap.get(forComparison);
        return (registerSpec != null || (registerSpecPutIfAbsent = concurrentHashMap.putIfAbsent((registerSpec = forComparison.toRegisterSpec()), registerSpec)) == null) ? registerSpec : registerSpecPutIfAbsent;
    }

    public static RegisterSpec make(int i, TypeBearer typeBearer) {
        return intern(i, typeBearer, null);
    }

    public static RegisterSpec makeLocalOptional(int i, TypeBearer typeBearer, LocalItem localItem) {
        return intern(i, typeBearer, localItem);
    }

    public static String regString(int i) {
        return b.c(i, PREFIX);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String toString0(boolean r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 40
            r0.<init>(r1)
            java.lang.String r1 = r3.regString()
            r0.append(r1)
            java.lang.String r1 = ":"
            r0.append(r1)
            com.android.dx.rop.code.LocalItem r1 = r3.local
            if (r1 == 0) goto L1e
            java.lang.String r1 = r1.toString()
            r0.append(r1)
        L1e:
            com.android.dx.rop.type.TypeBearer r1 = r3.type
            com.android.dx.rop.type.Type r1 = r1.getType()
            r0.append(r1)
            com.android.dx.rop.type.TypeBearer r2 = r3.type
            if (r1 == r2) goto L57
            java.lang.String r1 = "="
            r0.append(r1)
            if (r4 == 0) goto L42
            com.android.dx.rop.type.TypeBearer r1 = r3.type
            boolean r2 = r1 instanceof com.android.dx.rop.cst.CstString
            if (r2 == 0) goto L42
            com.android.dx.rop.cst.CstString r1 = (com.android.dx.rop.cst.CstString) r1
            java.lang.String r4 = r1.toQuoted()
            r0.append(r4)
            goto L57
        L42:
            if (r4 == 0) goto L52
            com.android.dx.rop.type.TypeBearer r4 = r3.type
            boolean r1 = r4 instanceof com.android.dx.rop.cst.Constant
            if (r1 == 0) goto L52
            java.lang.String r4 = r4.toHuman()
            r0.append(r4)
            goto L57
        L52:
            com.android.dx.rop.type.TypeBearer r4 = r3.type
            r0.append(r4)
        L57:
            java.lang.String r4 = r0.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dx.rop.code.RegisterSpec.toString0(boolean):java.lang.String");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RegisterSpec) {
            RegisterSpec registerSpec = (RegisterSpec) obj;
            return equals(registerSpec.reg, registerSpec.type, registerSpec.local);
        }
        if (!(obj instanceof ForComparison)) {
            return false;
        }
        ForComparison forComparison = (ForComparison) obj;
        return equals(forComparison.reg, forComparison.type, forComparison.local);
    }

    public boolean equalsUsingSimpleType(RegisterSpec registerSpec) {
        return matchesVariable(registerSpec) && this.reg == registerSpec.reg;
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public final int getBasicFrameType() {
        return this.type.getBasicFrameType();
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public final int getBasicType() {
        return this.type.getBasicType();
    }

    public int getCategory() {
        return this.type.getType().getCategory();
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public TypeBearer getFrameType() {
        return this.type.getFrameType();
    }

    public LocalItem getLocalItem() {
        return this.local;
    }

    public int getNextReg() {
        return getCategory() + this.reg;
    }

    public int getReg() {
        return this.reg;
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getType() {
        return this.type.getType();
    }

    public TypeBearer getTypeBearer() {
        return this.type;
    }

    public int hashCode() {
        return hashCodeOf(this.reg, this.type, this.local);
    }

    public RegisterSpec intersect(RegisterSpec registerSpec, boolean z6) {
        TypeBearer type;
        if (this != registerSpec) {
            if (registerSpec == null || this.reg != registerSpec.getReg()) {
                return null;
            }
            LocalItem localItem = this.local;
            LocalItem localItem2 = (localItem == null || !localItem.equals(registerSpec.getLocalItem())) ? null : this.local;
            boolean z7 = localItem2 == this.local;
            if ((z6 && !z7) || (type = getType()) != registerSpec.getType()) {
                return null;
            }
            if (this.type.equals(registerSpec.getTypeBearer())) {
                type = this.type;
            }
            if (type != this.type || !z7) {
                int i = this.reg;
                return localItem2 == null ? make(i, type) : make(i, type, localItem2);
            }
        }
        return this;
    }

    public boolean isCategory1() {
        return this.type.getType().isCategory1();
    }

    public boolean isCategory2() {
        return this.type.getType().isCategory2();
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public final boolean isConstant() {
        return false;
    }

    public boolean isEvenRegister() {
        return (getReg() & 1) == 0;
    }

    public boolean matchesVariable(RegisterSpec registerSpec) {
        if (registerSpec != null && this.type.getType().equals(registerSpec.type.getType())) {
            LocalItem localItem = this.local;
            LocalItem localItem2 = registerSpec.local;
            if (localItem == localItem2) {
                return true;
            }
            if (localItem != null && localItem.equals(localItem2)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return toString0(true);
    }

    public String toString() {
        return toString0(false);
    }

    public RegisterSpec withLocalItem(LocalItem localItem) {
        LocalItem localItem2 = this.local;
        return (localItem2 == localItem || (localItem2 != null && localItem2.equals(localItem))) ? this : makeLocalOptional(this.reg, this.type, localItem);
    }

    public RegisterSpec withOffset(int i) {
        return i == 0 ? this : withReg(this.reg + i);
    }

    public RegisterSpec withReg(int i) {
        return this.reg == i ? this : makeLocalOptional(i, this.type, this.local);
    }

    public RegisterSpec withSimpleType() {
        TypeBearer typeBearer = this.type;
        Type type = typeBearer instanceof Type ? (Type) typeBearer : typeBearer.getType();
        if (type.isUninitialized()) {
            type = type.getInitializedType();
        }
        return type == typeBearer ? this : makeLocalOptional(this.reg, type, this.local);
    }

    public RegisterSpec withType(TypeBearer typeBearer) {
        return makeLocalOptional(this.reg, typeBearer, this.local);
    }

    private RegisterSpec(int i, TypeBearer typeBearer, LocalItem localItem) {
        if (i < 0) {
            throw new IllegalArgumentException("reg < 0");
        }
        if (typeBearer == null) {
            throw new NullPointerException("type == null");
        }
        this.reg = i;
        this.type = typeBearer;
        this.local = localItem;
    }

    public static RegisterSpec make(int i, TypeBearer typeBearer, LocalItem localItem) {
        if (localItem != null) {
            return intern(i, typeBearer, localItem);
        }
        throw new NullPointerException("local  == null");
    }

    @Override // java.lang.Comparable
    public int compareTo(RegisterSpec registerSpec) {
        int i = this.reg;
        int i3 = registerSpec.reg;
        if (i < i3) {
            return -1;
        }
        if (i > i3) {
            return 1;
        }
        if (this == registerSpec) {
            return 0;
        }
        int iCompareTo = this.type.getType().compareTo(registerSpec.type.getType());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        LocalItem localItem = this.local;
        if (localItem == null) {
            return registerSpec.local == null ? 0 : -1;
        }
        LocalItem localItem2 = registerSpec.local;
        if (localItem2 == null) {
            return 1;
        }
        return localItem.compareTo(localItem2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean equals(int i, TypeBearer typeBearer, LocalItem localItem) {
        if (this.reg != i || !this.type.equals(typeBearer)) {
            return false;
        }
        LocalItem localItem2 = this.local;
        if (localItem2 != localItem) {
            return localItem2 != null && localItem2.equals(localItem);
        }
        return true;
    }

    public String regString() {
        return regString(this.reg);
    }
}
