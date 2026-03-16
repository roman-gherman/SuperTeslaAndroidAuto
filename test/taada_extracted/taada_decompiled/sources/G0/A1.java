package G0;

import com.google.crypto.tink.shaded.protobuf.Internal$EnumLite;

/* JADX INFO: loaded from: classes.dex */
public enum A1 implements Internal$EnumLite {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f379a;

    A1(int i) {
        this.f379a = i;
    }

    public static A1 a(int i) {
        if (i == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i == 1) {
            return TINK;
        }
        if (i == 2) {
            return LEGACY;
        }
        if (i == 3) {
            return RAW;
        }
        if (i != 4) {
            return null;
        }
        return CRUNCHY;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal$EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f379a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
