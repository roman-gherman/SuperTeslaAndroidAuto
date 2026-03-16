package G0;

import com.google.crypto.tink.proto.HpkeParamsOrBuilder;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: loaded from: classes.dex */
public final class H0 extends com.google.crypto.tink.shaded.protobuf.Q implements HpkeParamsOrBuilder {
    public static final int AEAD_FIELD_NUMBER = 3;
    private static final H0 DEFAULT_INSTANCE;
    public static final int KDF_FIELD_NUMBER = 2;
    public static final int KEM_FIELD_NUMBER = 1;
    private static volatile Parser<H0> PARSER;
    private int aead_;
    private int kdf_;
    private int kem_;

    static {
        H0 h02 = new H0();
        DEFAULT_INSTANCE = h02;
        com.google.crypto.tink.shaded.protobuf.Q.q(H0.class, h02);
    }

    public static H0 t() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q
    public final Object e(int i) {
        Parser p5;
        switch (f.s.b(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"kem_", "kdf_", "aead_"});
            case 3:
                return new H0();
            case 4:
                return new G0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<H0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (H0.class) {
                    try {
                        p5 = PARSER;
                        if (p5 == null) {
                            p5 = new com.google.crypto.tink.shaded.protobuf.P(DEFAULT_INSTANCE);
                            PARSER = p5;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return p5;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.crypto.tink.proto.HpkeParamsOrBuilder
    public final D0 getAead() {
        int i = this.aead_;
        D0 d02 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : D0.CHACHA20_POLY1305 : D0.AES_256_GCM : D0.AES_128_GCM : D0.AEAD_UNKNOWN;
        return d02 == null ? D0.UNRECOGNIZED : d02;
    }

    @Override // com.google.crypto.tink.proto.HpkeParamsOrBuilder
    public final int getAeadValue() {
        return this.aead_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.proto.HpkeParamsOrBuilder
    public final E0 getKdf() {
        int i = this.kdf_;
        E0 e02 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : E0.HKDF_SHA512 : E0.HKDF_SHA384 : E0.HKDF_SHA256 : E0.KDF_UNKNOWN;
        return e02 == null ? E0.UNRECOGNIZED : e02;
    }

    @Override // com.google.crypto.tink.proto.HpkeParamsOrBuilder
    public final int getKdfValue() {
        return this.kdf_;
    }

    @Override // com.google.crypto.tink.proto.HpkeParamsOrBuilder
    public final F0 getKem() {
        int i = this.kem_;
        F0 f02 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : F0.DHKEM_P521_HKDF_SHA512 : F0.DHKEM_P384_HKDF_SHA384 : F0.DHKEM_P256_HKDF_SHA256 : F0.DHKEM_X25519_HKDF_SHA256 : F0.KEM_UNKNOWN;
        return f02 == null ? F0.UNRECOGNIZED : f02;
    }

    @Override // com.google.crypto.tink.proto.HpkeParamsOrBuilder
    public final int getKemValue() {
        return this.kem_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLite
    public final /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLite
    public final /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }
}
