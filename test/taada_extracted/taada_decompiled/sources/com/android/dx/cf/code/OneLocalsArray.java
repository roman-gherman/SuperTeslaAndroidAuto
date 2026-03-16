package com.android.dx.cf.code;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.Hex;
import g.C0476a;

/* JADX INFO: loaded from: classes.dex */
public class OneLocalsArray extends LocalsArray {
    private final TypeBearer[] locals;

    public OneLocalsArray(int i) {
        super(i != 0);
        this.locals = new TypeBearer[i];
    }

    private static TypeBearer throwSimException(int i, String str) {
        throw new SimException("local " + Hex.u2(i) + ": " + str);
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public void annotate(C0476a c0476a) {
        int i = 0;
        while (true) {
            TypeBearer[] typeBearerArr = this.locals;
            if (i >= typeBearerArr.length) {
                return;
            }
            TypeBearer typeBearer = typeBearerArr[i];
            c0476a.addContext("locals[" + Hex.u2(i) + "]: " + (typeBearer == null ? "<invalid>" : typeBearer.toString()));
            i++;
        }
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public TypeBearer get(int i) {
        TypeBearer typeBearer = this.locals[i];
        return typeBearer == null ? throwSimException(i, "invalid") : typeBearer;
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public TypeBearer getCategory1(int i) {
        TypeBearer typeBearer = get(i);
        Type type = typeBearer.getType();
        return type.isUninitialized() ? throwSimException(i, "uninitialized instance") : type.isCategory2() ? throwSimException(i, "category-2") : typeBearer;
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public TypeBearer getCategory2(int i) {
        TypeBearer typeBearer = get(i);
        return typeBearer.getType().isCategory1() ? throwSimException(i, "category-1") : typeBearer;
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public int getMaxLocals() {
        return this.locals.length;
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public TypeBearer getOrNull(int i) {
        return this.locals[i];
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public OneLocalsArray getPrimary() {
        return this;
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public void invalidate(int i) {
        throwIfImmutable();
        this.locals[i] = null;
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public void makeInitialized(Type type) {
        int length = this.locals.length;
        if (length == 0) {
            return;
        }
        throwIfImmutable();
        Type initializedType = type.getInitializedType();
        for (int i = 0; i < length; i++) {
            TypeBearer[] typeBearerArr = this.locals;
            if (typeBearerArr[i] == type) {
                typeBearerArr[i] = initializedType;
            }
        }
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public LocalsArray merge(LocalsArray localsArray) {
        return localsArray instanceof OneLocalsArray ? merge((OneLocalsArray) localsArray) : localsArray.merge(this);
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public LocalsArraySet mergeWithSubroutineCaller(LocalsArray localsArray, int i) {
        return new LocalsArraySet(getMaxLocals()).mergeWithSubroutineCaller(localsArray, i);
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public void set(int i, TypeBearer typeBearer) {
        int i3;
        TypeBearer typeBearer2;
        throwIfImmutable();
        try {
            TypeBearer frameType = typeBearer.getFrameType();
            if (i < 0) {
                throw new IndexOutOfBoundsException("idx < 0");
            }
            if (frameType.getType().isCategory2()) {
                this.locals[i + 1] = null;
            }
            TypeBearer[] typeBearerArr = this.locals;
            typeBearerArr[i] = frameType;
            if (i == 0 || (typeBearer2 = typeBearerArr[i - 1]) == null || !typeBearer2.getType().isCategory2()) {
                return;
            }
            this.locals[i3] = null;
        } catch (NullPointerException unused) {
            throw new NullPointerException("type == null");
        }
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            TypeBearer[] typeBearerArr = this.locals;
            if (i >= typeBearerArr.length) {
                return sb.toString();
            }
            TypeBearer typeBearer = typeBearerArr[i];
            sb.append("locals[" + Hex.u2(i) + "]: " + (typeBearer == null ? "<invalid>" : typeBearer.toString()) + "\n");
            i++;
        }
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public OneLocalsArray copy() {
        OneLocalsArray oneLocalsArray = new OneLocalsArray(this.locals.length);
        TypeBearer[] typeBearerArr = this.locals;
        System.arraycopy(typeBearerArr, 0, oneLocalsArray.locals, 0, typeBearerArr.length);
        return oneLocalsArray;
    }

    public OneLocalsArray merge(OneLocalsArray oneLocalsArray) {
        try {
            return Merger.mergeLocals(this, oneLocalsArray);
        } catch (SimException e) {
            e.addContext("underlay locals:");
            annotate(e);
            e.addContext("overlay locals:");
            oneLocalsArray.annotate(e);
            throw e;
        }
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public void set(RegisterSpec registerSpec) {
        set(registerSpec.getReg(), registerSpec);
    }
}
