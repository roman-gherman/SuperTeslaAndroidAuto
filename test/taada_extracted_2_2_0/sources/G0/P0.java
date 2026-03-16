package G0;

import com.google.crypto.tink.shaded.protobuf.Internal$EnumLite;

/* JADX INFO: loaded from: classes.dex */
public enum P0 implements Internal$EnumLite {
    /* JADX INFO: Fake field, exist only in values array */
    HS_UNKNOWN(0),
    /* JADX INFO: Fake field, exist only in values array */
    HS256(1),
    /* JADX INFO: Fake field, exist only in values array */
    HS384(2),
    /* JADX INFO: Fake field, exist only in values array */
    HS512(3),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f393a;

    P0(int i) {
        this.f393a = i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal$EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f393a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
