package com.android.dx.dex;

import a.AbstractC0132a;
import java.io.PrintStream;

/* JADX INFO: loaded from: classes.dex */
public final class DexOptions {
    public static final boolean ALIGN_64BIT_REGS_SUPPORT = true;
    public boolean ALIGN_64BIT_REGS_IN_OUTPUT_FINISHER;
    public boolean allowAllInterfaceMethodInvokes;
    public final PrintStream err;
    public boolean forceJumbo;
    public int minSdkVersion;

    public DexOptions() {
        this.ALIGN_64BIT_REGS_IN_OUTPUT_FINISHER = true;
        this.minSdkVersion = 13;
        this.forceJumbo = false;
        this.allowAllInterfaceMethodInvokes = false;
        this.err = System.err;
    }

    public boolean apiIsSupported(int i) {
        return this.minSdkVersion >= i;
    }

    public String getMagic() {
        return AbstractC0132a.f(this.minSdkVersion);
    }

    public DexOptions(PrintStream printStream) {
        this.ALIGN_64BIT_REGS_IN_OUTPUT_FINISHER = true;
        this.minSdkVersion = 13;
        this.forceJumbo = false;
        this.allowAllInterfaceMethodInvokes = false;
        this.err = printStream;
    }
}
