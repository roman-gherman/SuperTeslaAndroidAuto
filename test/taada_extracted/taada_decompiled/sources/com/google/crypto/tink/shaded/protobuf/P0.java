package com.google.crypto.tink.shaded.protobuf;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public final class P0 extends R0 {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ P0(Unsafe unsafe, int i) {
        super(unsafe);
        this.b = i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final void c(long j6, byte[] bArr, long j7) {
        switch (this.b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final boolean d(Object obj, long j6) {
        switch (this.b) {
            case 0:
                if (S0.f2848h) {
                    if (S0.h(obj, j6) == 0) {
                    }
                } else if (S0.i(obj, j6) == 0) {
                }
                break;
            default:
                if (S0.f2848h) {
                    if (S0.h(obj, j6) == 0) {
                    }
                } else if (S0.i(obj, j6) == 0) {
                }
                break;
        }
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final byte e(long j6) {
        switch (this.b) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final byte f(Object obj, long j6) {
        switch (this.b) {
            case 0:
                if (!S0.f2848h) {
                }
                break;
            default:
                if (!S0.f2848h) {
                }
                break;
        }
        return S0.i(obj, j6);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final double g(Object obj, long j6) {
        switch (this.b) {
        }
        return Double.longBitsToDouble(j(obj, j6));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final float h(Object obj, long j6) {
        switch (this.b) {
        }
        return Float.intBitsToFloat(i(obj, j6));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final void m(Object obj, long j6, boolean z6) {
        switch (this.b) {
            case 0:
                if (!S0.f2848h) {
                    S0.m(obj, j6, z6 ? (byte) 1 : (byte) 0);
                } else {
                    S0.l(obj, j6, z6 ? (byte) 1 : (byte) 0);
                }
                break;
            default:
                if (!S0.f2848h) {
                    S0.m(obj, j6, z6 ? (byte) 1 : (byte) 0);
                } else {
                    S0.l(obj, j6, z6 ? (byte) 1 : (byte) 0);
                }
                break;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final void n(Object obj, long j6, byte b) {
        switch (this.b) {
            case 0:
                if (!S0.f2848h) {
                    S0.m(obj, j6, b);
                } else {
                    S0.l(obj, j6, b);
                }
                break;
            default:
                if (!S0.f2848h) {
                    S0.m(obj, j6, b);
                } else {
                    S0.l(obj, j6, b);
                }
                break;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final void o(Object obj, long j6, double d) {
        switch (this.b) {
            case 0:
                r(obj, j6, Double.doubleToLongBits(d));
                break;
            default:
                r(obj, j6, Double.doubleToLongBits(d));
                break;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final void p(Object obj, long j6, float f6) {
        switch (this.b) {
            case 0:
                q(obj, j6, Float.floatToIntBits(f6));
                break;
            default:
                q(obj, j6, Float.floatToIntBits(f6));
                break;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.R0
    public final boolean u() {
        switch (this.b) {
        }
        return false;
    }
}
