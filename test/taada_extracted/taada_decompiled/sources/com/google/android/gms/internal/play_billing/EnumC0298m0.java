package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0298m0 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0298m0 f2104a;
    public static final /* synthetic */ EnumC0298m0[] b;

    static {
        EnumC0298m0 enumC0298m0 = new EnumC0298m0("INSTANCE", 0);
        f2104a = enumC0298m0;
        b = new EnumC0298m0[]{enumC0298m0};
    }

    public static EnumC0298m0[] values() {
        return (EnumC0298m0[]) b.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
