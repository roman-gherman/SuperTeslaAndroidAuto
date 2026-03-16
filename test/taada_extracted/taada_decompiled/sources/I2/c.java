package I2;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends d {
    public final Internal$EnumLite[] c;

    /* JADX WARN: Illegal instructions before constructor call */
    public c(int i, Internal$EnumLite[] internal$EnumLiteArr) {
        if (internal$EnumLiteArr == null) {
            throw new IllegalArgumentException("Argument for @NotNull parameter 'enumEntries' of kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField.bitWidth must not be null");
        }
        int i3 = 1;
        int length = internal$EnumLiteArr.length - 1;
        if (length != 0) {
            for (int i4 = 31; i4 >= 0; i4--) {
                if (((1 << i4) & length) != 0) {
                    i3 = 1 + i4;
                }
            }
            throw new IllegalStateException("Empty enum: " + internal$EnumLiteArr.getClass());
        }
        super(i, i3);
        this.c = internal$EnumLiteArr;
    }

    public final Object c(int i) {
        int i3 = (1 << this.b) - 1;
        int i4 = this.f764a;
        int i5 = (i & (i3 << i4)) >> i4;
        for (Internal$EnumLite internal$EnumLite : this.c) {
            if (internal$EnumLite.getNumber() == i5) {
                return internal$EnumLite;
            }
        }
        return null;
    }
}
