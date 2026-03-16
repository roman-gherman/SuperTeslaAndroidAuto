package f;

import com.android.billingclient.api.z;
import com.android.dex.util.ByteInput;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteInput f3163a;
    public int b;
    public int c;
    public int d;

    public q(p pVar, int i) {
        this(new z(pVar.f3162a), i);
    }

    public final void a(int i) {
        if (b() != i) {
            throw new IllegalStateException(String.format("Expected %x but was %x", Integer.valueOf(i), Integer.valueOf(b())));
        }
    }

    public final int b() {
        if (this.b == -1) {
            byte b = this.f3163a.readByte();
            this.b = b & 31;
            this.d = (b & 224) >> 5;
        }
        return this.b;
    }

    public final int c() {
        a(29);
        this.b = -1;
        ByteInput byteInput = this.f3163a;
        this.c = C5.f.Z(byteInput);
        return C5.f.Z(byteInput);
    }

    public final double d() {
        a(17);
        this.b = -1;
        long j6 = 0;
        for (int i = this.d; i >= 0; i--) {
            j6 = (j6 >>> 8) | ((((long) this.f3163a.readByte()) & 255) << 56);
        }
        return Double.longBitsToDouble(j6);
    }

    public final long e() {
        a(6);
        this.b = -1;
        int i = this.d;
        long j6 = 0;
        for (int i3 = i; i3 >= 0; i3--) {
            j6 = (j6 >>> 8) | ((((long) this.f3163a.readByte()) & 255) << 56);
        }
        return j6 >> ((7 - i) * 8);
    }

    public final int f() {
        a(23);
        this.b = -1;
        return kotlin.reflect.l.W(this.f3163a, this.d, false);
    }

    public final void g() {
        int iB = b();
        int i = 0;
        ByteInput byteInput = this.f3163a;
        if (iB == 0) {
            a(0);
            this.b = -1;
            kotlin.reflect.l.V(byteInput, this.d);
            return;
        }
        if (iB == 6) {
            e();
            return;
        }
        if (iB == 2) {
            a(2);
            this.b = -1;
            kotlin.reflect.l.V(byteInput, this.d);
            return;
        }
        if (iB == 3) {
            a(3);
            this.b = -1;
            kotlin.reflect.l.W(byteInput, this.d, false);
            return;
        }
        if (iB == 4) {
            a(4);
            this.b = -1;
            kotlin.reflect.l.V(byteInput, this.d);
            return;
        }
        if (iB == 16) {
            a(16);
            this.b = -1;
            Float.intBitsToFloat(kotlin.reflect.l.W(byteInput, this.d, true));
            return;
        }
        if (iB == 17) {
            d();
            return;
        }
        switch (iB) {
            case 21:
                a(21);
                this.b = -1;
                kotlin.reflect.l.W(byteInput, this.d, false);
                return;
            case 22:
                a(22);
                this.b = -1;
                kotlin.reflect.l.W(byteInput, this.d, false);
                return;
            case 23:
                f();
                return;
            case 24:
                a(24);
                this.b = -1;
                kotlin.reflect.l.W(byteInput, this.d, false);
                return;
            case 25:
                a(25);
                this.b = -1;
                kotlin.reflect.l.W(byteInput, this.d, false);
                return;
            case 26:
                a(26);
                this.b = -1;
                kotlin.reflect.l.W(byteInput, this.d, false);
                return;
            case 27:
                a(27);
                this.b = -1;
                kotlin.reflect.l.W(byteInput, this.d, false);
                return;
            case 28:
                a(28);
                this.b = -1;
                int iZ = C5.f.Z(byteInput);
                while (i < iZ) {
                    g();
                    i++;
                }
                return;
            case 29:
                int iC = c();
                while (i < iC) {
                    C5.f.Z(byteInput);
                    g();
                    i++;
                }
                return;
            case 30:
                a(30);
                this.b = -1;
                return;
            case 31:
                a(31);
                this.b = -1;
                return;
            default:
                throw new n(androidx.constraintlayout.core.motion.a.h(this.b, new StringBuilder("Unexpected type: ")), null);
        }
    }

    public q(ByteInput byteInput) {
        this.b = -1;
        this.f3163a = byteInput;
    }

    public q(ByteInput byteInput, int i) {
        this.f3163a = byteInput;
        this.b = i;
    }
}
