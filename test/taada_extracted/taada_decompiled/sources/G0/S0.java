package G0;

import com.google.crypto.tink.shaded.protobuf.Internal$EnumLite;

/* JADX INFO: loaded from: classes.dex */
public enum S0 implements Internal$EnumLite {
    RS_UNKNOWN(0),
    RS256(1),
    RS384(2),
    RS512(3),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f396a;

    S0(int i) {
        this.f396a = i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal$EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f396a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
