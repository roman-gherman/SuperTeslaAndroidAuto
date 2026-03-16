package G0;

import com.google.crypto.tink.shaded.protobuf.Internal$EnumLite;

/* JADX INFO: loaded from: classes.dex */
public enum F0 implements Internal$EnumLite {
    KEM_UNKNOWN(0),
    DHKEM_X25519_HKDF_SHA256(1),
    DHKEM_P256_HKDF_SHA256(2),
    DHKEM_P384_HKDF_SHA384(3),
    DHKEM_P521_HKDF_SHA512(4),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f389a;

    F0(int i) {
        this.f389a = i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal$EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f389a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
