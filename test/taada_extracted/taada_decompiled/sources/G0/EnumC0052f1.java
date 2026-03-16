package G0;

import com.google.crypto.tink.shaded.protobuf.Internal$EnumLite;

/* JADX INFO: renamed from: G0.f1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0052f1 implements Internal$EnumLite {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f411a;

    EnumC0052f1(int i) {
        this.f411a = i;
    }

    public static EnumC0052f1 a(int i) {
        if (i == 0) {
            return UNKNOWN_STATUS;
        }
        if (i == 1) {
            return ENABLED;
        }
        if (i == 2) {
            return DISABLED;
        }
        if (i != 3) {
            return null;
        }
        return DESTROYED;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal$EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f411a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
