package G0;

import com.google.crypto.tink.proto.AesGcmHkdfStreamingParamsOrBuilder;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: loaded from: classes.dex */
public final class H extends com.google.crypto.tink.shaded.protobuf.Q implements AesGcmHkdfStreamingParamsOrBuilder {
    public static final int CIPHERTEXT_SEGMENT_SIZE_FIELD_NUMBER = 1;
    private static final H DEFAULT_INSTANCE;
    public static final int DERIVED_KEY_SIZE_FIELD_NUMBER = 2;
    public static final int HKDF_HASH_TYPE_FIELD_NUMBER = 3;
    private static volatile Parser<H> PARSER;
    private int ciphertextSegmentSize_;
    private int derivedKeySize_;
    private int hkdfHashType_;

    static {
        H h3 = new H();
        DEFAULT_INSTANCE = h3;
        com.google.crypto.tink.shaded.protobuf.Q.q(H.class, h3);
    }

    public static void t(H h3, int i) {
        h3.ciphertextSegmentSize_ = i;
    }

    public static void u(H h3, int i) {
        h3.derivedKeySize_ = i;
    }

    public static void v(H h3) {
        EnumC0086s0 enumC0086s0 = EnumC0086s0.SHA256;
        h3.getClass();
        h3.hkdfHashType_ = enumC0086s0.getNumber();
    }

    public static H w() {
        return DEFAULT_INSTANCE;
    }

    public static G x() {
        return (G) DEFAULT_INSTANCE.d();
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003\f", new Object[]{"ciphertextSegmentSize_", "derivedKeySize_", "hkdfHashType_"});
            case 3:
                return new H();
            case 4:
                return new G(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<H> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (H.class) {
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

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingParamsOrBuilder
    public final int getCiphertextSegmentSize() {
        return this.ciphertextSegmentSize_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingParamsOrBuilder
    public final int getDerivedKeySize() {
        return this.derivedKeySize_;
    }

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingParamsOrBuilder
    public final EnumC0086s0 getHkdfHashType() {
        EnumC0086s0 enumC0086s0A = EnumC0086s0.a(this.hkdfHashType_);
        return enumC0086s0A == null ? EnumC0086s0.UNRECOGNIZED : enumC0086s0A;
    }

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingParamsOrBuilder
    public final int getHkdfHashTypeValue() {
        return this.hkdfHashType_;
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
