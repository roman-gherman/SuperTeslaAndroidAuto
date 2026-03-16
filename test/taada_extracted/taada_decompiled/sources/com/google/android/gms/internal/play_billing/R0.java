package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public class R0 extends S0 {
    public final byte[] c;

    public R0(byte[] bArr) {
        this.f2051a = 0;
        bArr.getClass();
        this.c = bArr;
    }

    @Override // com.google.android.gms.internal.play_billing.S0
    public byte a(int i) {
        return this.c[i];
    }

    @Override // com.google.android.gms.internal.play_billing.S0
    public byte b(int i) {
        return this.c[i];
    }

    @Override // com.google.android.gms.internal.play_billing.S0
    public int c() {
        return this.c.length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof S0) && c() == ((S0) obj).c()) {
            if (c() == 0) {
                return true;
            }
            if (!(obj instanceof R0)) {
                return obj.equals(this);
            }
            R0 r02 = (R0) obj;
            int i = this.f2051a;
            int i3 = r02.f2051a;
            if (i == 0 || i3 == 0 || i == i3) {
                int iC = c();
                if (iC > r02.c()) {
                    throw new IllegalArgumentException("Length too large: " + iC + c());
                }
                if (iC > r02.c()) {
                    throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.n("Ran off end of other: 0, ", iC, ", ", r02.c()));
                }
                int i4 = 0;
                int i5 = 0;
                while (i4 < iC) {
                    if (this.c[i4] == r02.c[i5]) {
                        i4++;
                        i5++;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
