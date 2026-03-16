package G0;

import com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0080p extends com.google.crypto.tink.shaded.protobuf.Q implements AesCtrHmacStreamingParamsOrBuilder {
    public static final int CIPHERTEXT_SEGMENT_SIZE_FIELD_NUMBER = 1;
    private static final C0080p DEFAULT_INSTANCE;
    public static final int DERIVED_KEY_SIZE_FIELD_NUMBER = 2;
    public static final int HKDF_HASH_TYPE_FIELD_NUMBER = 3;
    public static final int HMAC_PARAMS_FIELD_NUMBER = 4;
    private static volatile Parser<C0080p> PARSER;
    private int ciphertextSegmentSize_;
    private int derivedKeySize_;
    private int hkdfHashType_;
    private A0 hmacParams_;

    static {
        C0080p c0080p = new C0080p();
        DEFAULT_INSTANCE = c0080p;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0080p.class, c0080p);
    }

    public static void t(C0080p c0080p, int i) {
        c0080p.ciphertextSegmentSize_ = i;
    }

    public static void u(C0080p c0080p, int i) {
        c0080p.derivedKeySize_ = i;
    }

    public static void v(C0080p c0080p) {
        EnumC0086s0 enumC0086s0 = EnumC0086s0.SHA256;
        c0080p.getClass();
        c0080p.hkdfHashType_ = enumC0086s0.getNumber();
    }

    public static void w(C0080p c0080p, A0 a02) {
        c0080p.getClass();
        c0080p.hmacParams_ = a02;
    }

    public static C0080p x() {
        return DEFAULT_INSTANCE;
    }

    public static C0077o y() {
        return (C0077o) DEFAULT_INSTANCE.d();
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003\f\u0004\t", new Object[]{"ciphertextSegmentSize_", "derivedKeySize_", "hkdfHashType_", "hmacParams_"});
            case 3:
                return new C0080p();
            case 4:
                return new C0077o(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0080p> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0080p.class) {
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

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder
    public final int getCiphertextSegmentSize() {
        return this.ciphertextSegmentSize_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder
    public final int getDerivedKeySize() {
        return this.derivedKeySize_;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder
    public final EnumC0086s0 getHkdfHashType() {
        EnumC0086s0 enumC0086s0A = EnumC0086s0.a(this.hkdfHashType_);
        return enumC0086s0A == null ? EnumC0086s0.UNRECOGNIZED : enumC0086s0A;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder
    public final int getHkdfHashTypeValue() {
        return this.hkdfHashType_;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder
    public final A0 getHmacParams() {
        A0 a02 = this.hmacParams_;
        return a02 == null ? A0.v() : a02;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder
    public final boolean hasHmacParams() {
        return this.hmacParams_ != null;
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
