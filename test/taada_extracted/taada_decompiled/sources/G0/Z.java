package G0;

import com.google.crypto.tink.shaded.protobuf.Internal$EnumLite;

/* JADX INFO: loaded from: classes.dex */
public enum Z implements Internal$EnumLite {
    UNKNOWN_FORMAT(0),
    UNCOMPRESSED(1),
    COMPRESSED(2),
    DO_NOT_USE_CRUNCHY_UNCOMPRESSED(3),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f402a;

    Z(int i) {
        this.f402a = i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal$EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f402a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
