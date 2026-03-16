package G0;

import com.google.crypto.tink.proto.RsaSsaPssParamsOrBuilder;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: loaded from: classes.dex */
public final class I1 extends com.google.crypto.tink.shaded.protobuf.Q implements RsaSsaPssParamsOrBuilder {
    private static final I1 DEFAULT_INSTANCE;
    public static final int MGF1_HASH_FIELD_NUMBER = 2;
    private static volatile Parser<I1> PARSER = null;
    public static final int SALT_LENGTH_FIELD_NUMBER = 3;
    public static final int SIG_HASH_FIELD_NUMBER = 1;
    private int mgf1Hash_;
    private int saltLength_;
    private int sigHash_;

    static {
        I1 i12 = new I1();
        DEFAULT_INSTANCE = i12;
        com.google.crypto.tink.shaded.protobuf.Q.q(I1.class, i12);
    }

    public static I1 t() {
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\u0004", new Object[]{"sigHash_", "mgf1Hash_", "saltLength_"});
            case 3:
                return new I1();
            case 4:
                return new H1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<I1> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (I1.class) {
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

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssParamsOrBuilder
    public final EnumC0086s0 getMgf1Hash() {
        EnumC0086s0 enumC0086s0A = EnumC0086s0.a(this.mgf1Hash_);
        return enumC0086s0A == null ? EnumC0086s0.UNRECOGNIZED : enumC0086s0A;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssParamsOrBuilder
    public final int getMgf1HashValue() {
        return this.mgf1Hash_;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssParamsOrBuilder
    public final int getSaltLength() {
        return this.saltLength_;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssParamsOrBuilder
    public final EnumC0086s0 getSigHash() {
        EnumC0086s0 enumC0086s0A = EnumC0086s0.a(this.sigHash_);
        return enumC0086s0A == null ? EnumC0086s0.UNRECOGNIZED : enumC0086s0A;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssParamsOrBuilder
    public final int getSigHashValue() {
        return this.sigHash_;
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
