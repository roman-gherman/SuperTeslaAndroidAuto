package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class U0 extends IOException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U0(long j6, long j7, int i, IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat("Pos: " + j6 + ", limit: " + j7 + ", len: " + i), indexOutOfBoundsException);
        Locale locale = Locale.US;
    }

    public U0(IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
    }
}
