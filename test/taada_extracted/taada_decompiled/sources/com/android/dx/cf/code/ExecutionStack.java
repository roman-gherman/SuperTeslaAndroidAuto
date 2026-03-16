package com.android.dx.cf.code;

import B2.b;
import androidx.constraintlayout.core.motion.a;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.Hex;
import com.android.dx.util.MutabilityControl;
import g.C0476a;

/* JADX INFO: loaded from: classes.dex */
public final class ExecutionStack extends MutabilityControl {
    private final boolean[] local;
    private final TypeBearer[] stack;
    private int stackPtr;

    public ExecutionStack(int i) {
        super(i != 0);
        this.stack = new TypeBearer[i];
        this.local = new boolean[i];
        this.stackPtr = 0;
    }

    private static String stackElementString(TypeBearer typeBearer) {
        return typeBearer == null ? "<invalid>" : typeBearer.toString();
    }

    private static TypeBearer throwSimException(String str) {
        throw new SimException(a.p("stack: ", str));
    }

    public void annotate(C0476a c0476a) {
        int i = this.stackPtr - 1;
        int i3 = 0;
        while (i3 <= i) {
            StringBuilder sbM = b.m("stack[", i3 == i ? "top0" : Hex.u2(i - i3), "]: ");
            sbM.append(stackElementString(this.stack[i3]));
            c0476a.addContext(sbM.toString());
            i3++;
        }
    }

    public void change(int i, TypeBearer typeBearer) {
        throwIfImmutable();
        try {
            TypeBearer frameType = typeBearer.getFrameType();
            int i3 = (this.stackPtr - i) - 1;
            TypeBearer typeBearer2 = this.stack[i3];
            if (typeBearer2 == null || typeBearer2.getType().getCategory() != frameType.getType().getCategory()) {
                throwSimException("incompatible substitution: " + stackElementString(typeBearer2) + " -> " + stackElementString(frameType));
            }
            this.stack[i3] = frameType;
        } catch (NullPointerException unused) {
            throw new NullPointerException("type == null");
        }
    }

    public void clear() {
        throwIfImmutable();
        for (int i = 0; i < this.stackPtr; i++) {
            this.stack[i] = null;
            this.local[i] = false;
        }
        this.stackPtr = 0;
    }

    public ExecutionStack copy() {
        ExecutionStack executionStack = new ExecutionStack(this.stack.length);
        TypeBearer[] typeBearerArr = this.stack;
        System.arraycopy(typeBearerArr, 0, executionStack.stack, 0, typeBearerArr.length);
        boolean[] zArr = this.local;
        System.arraycopy(zArr, 0, executionStack.local, 0, zArr.length);
        executionStack.stackPtr = this.stackPtr;
        return executionStack;
    }

    public int getMaxStack() {
        return this.stack.length;
    }

    public void makeInitialized(Type type) {
        if (this.stackPtr == 0) {
            return;
        }
        throwIfImmutable();
        Type initializedType = type.getInitializedType();
        for (int i = 0; i < this.stackPtr; i++) {
            TypeBearer[] typeBearerArr = this.stack;
            if (typeBearerArr[i] == type) {
                typeBearerArr[i] = initializedType;
            }
        }
    }

    public ExecutionStack merge(ExecutionStack executionStack) {
        try {
            return Merger.mergeStack(this, executionStack);
        } catch (SimException e) {
            e.addContext("underlay stack:");
            annotate(e);
            e.addContext("overlay stack:");
            executionStack.annotate(e);
            throw e;
        }
    }

    public TypeBearer peek(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("n < 0");
        }
        return i >= this.stackPtr ? throwSimException("underflow") : this.stack[(r0 - i) - 1];
    }

    public boolean peekLocal(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("n < 0");
        }
        if (i < this.stackPtr) {
            return this.local[(r0 - i) - 1];
        }
        throw new SimException("stack: underflow");
    }

    public Type peekType(int i) {
        return peek(i).getType();
    }

    public TypeBearer pop() {
        throwIfImmutable();
        TypeBearer typeBearerPeek = peek(0);
        TypeBearer[] typeBearerArr = this.stack;
        int i = this.stackPtr;
        typeBearerArr[i - 1] = null;
        this.local[i - 1] = false;
        this.stackPtr = i - typeBearerPeek.getType().getCategory();
        return typeBearerPeek;
    }

    public void push(TypeBearer typeBearer) {
        throwIfImmutable();
        try {
            TypeBearer frameType = typeBearer.getFrameType();
            int category = frameType.getType().getCategory();
            int i = this.stackPtr;
            int i3 = i + category;
            TypeBearer[] typeBearerArr = this.stack;
            if (i3 > typeBearerArr.length) {
                throwSimException("overflow");
                return;
            }
            if (category == 2) {
                typeBearerArr[i] = null;
                this.stackPtr = i + 1;
            }
            int i4 = this.stackPtr;
            typeBearerArr[i4] = frameType;
            this.stackPtr = i4 + 1;
        } catch (NullPointerException unused) {
            throw new NullPointerException("type == null");
        }
    }

    public void setLocal() {
        throwIfImmutable();
        this.local[this.stackPtr] = true;
    }

    public int size() {
        return this.stackPtr;
    }
}
