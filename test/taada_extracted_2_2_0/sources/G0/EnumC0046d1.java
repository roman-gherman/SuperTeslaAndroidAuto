package G0;

import com.google.crypto.tink.shaded.protobuf.Internal$EnumLite;

/* JADX INFO: renamed from: G0.d1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0046d1 implements Internal$EnumLite {
    UNKNOWN_KEYMATERIAL(0),
    SYMMETRIC(1),
    ASYMMETRIC_PRIVATE(2),
    ASYMMETRIC_PUBLIC(3),
    REMOTE(4),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f406a;

    EnumC0046d1(int i) {
        this.f406a = i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal$EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f406a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
