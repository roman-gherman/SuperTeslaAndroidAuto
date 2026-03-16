package net.bytebuddy.jar.asm;

import androidx.constraintlayout.core.motion.a;

/* JADX INFO: loaded from: classes2.dex */
public final class ClassTooLargeException extends IndexOutOfBoundsException {
    private static final long serialVersionUID = 160715609518896765L;
    private final String className;
    private final int constantPoolCount;

    public ClassTooLargeException(String str, int i) {
        super(a.p("Class too large: ", str));
        this.className = str;
        this.constantPoolCount = i;
    }

    public String getClassName() {
        return this.className;
    }

    public int getConstantPoolCount() {
        return this.constantPoolCount;
    }
}
