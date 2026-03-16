package com.google.android.gms.internal.play_billing;

import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class V0 extends AbstractC0263a1 {
    public static final Logger c = Logger.getLogger(V0.class.getName());
    public static final boolean d = D1.e;
    public W0 b;

    public static int M(long j6) {
        return (640 - (Long.numberOfLeadingZeros(j6) * 9)) >>> 6;
    }

    public static int a0(String str) {
        int length;
        try {
            length = F1.c(str);
        } catch (E1 unused) {
            length = str.getBytes(AbstractC0278f1.f2076a).length;
        }
        return b0(length) + length;
    }

    public static int b0(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public abstract void N(int i, S0 s02);

    public abstract void O(int i, int i3);

    public abstract void P(int i);

    public abstract void Q(int i, long j6);

    public abstract void R(long j6);

    public abstract void S(int i, int i3);

    public abstract void T(int i);

    public abstract void U(int i, String str);

    public abstract void V(int i, int i3);

    public abstract void W(int i, int i3);

    public abstract void X(int i);

    public abstract void Y(int i, long j6);

    public abstract void Z(long j6);
}
