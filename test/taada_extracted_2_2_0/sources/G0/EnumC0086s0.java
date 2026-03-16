package G0;

import com.google.crypto.tink.shaded.protobuf.Internal$EnumLite;

/* JADX INFO: renamed from: G0.s0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0086s0 implements Internal$EnumLite {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA384(2),
    SHA256(3),
    SHA512(4),
    SHA224(5),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f419a;

    EnumC0086s0(int i3) {
        this.f419a = i3;
    }

    public static EnumC0086s0 a(int i3) {
        if (i3 == 0) {
            return UNKNOWN_HASH;
        }
        if (i3 == 1) {
            return SHA1;
        }
        if (i3 == 2) {
            return SHA384;
        }
        if (i3 == 3) {
            return SHA256;
        }
        if (i3 == 4) {
            return SHA512;
        }
        if (i3 != 5) {
            return null;
        }
        return SHA224;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal$EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f419a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
