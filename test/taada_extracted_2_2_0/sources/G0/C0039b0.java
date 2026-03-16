package G0;

import com.google.crypto.tink.proto.EcdsaParamsOrBuilder;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0039b0 extends com.google.crypto.tink.shaded.protobuf.Q implements EcdsaParamsOrBuilder {
    public static final int CURVE_FIELD_NUMBER = 2;
    private static final C0039b0 DEFAULT_INSTANCE;
    public static final int ENCODING_FIELD_NUMBER = 3;
    public static final int HASH_TYPE_FIELD_NUMBER = 1;
    private static volatile Parser<C0039b0> PARSER;
    private int curve_;
    private int encoding_;
    private int hashType_;

    static {
        C0039b0 c0039b0 = new C0039b0();
        DEFAULT_INSTANCE = c0039b0;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0039b0.class, c0039b0);
    }

    public static C0039b0 t() {
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"hashType_", "curve_", "encoding_"});
            case 3:
                return new C0039b0();
            case 4:
                return new C0036a0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0039b0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0039b0.class) {
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

    @Override // com.google.crypto.tink.proto.EcdsaParamsOrBuilder
    public final EnumC0081p0 getCurve() {
        EnumC0081p0 enumC0081p0A = EnumC0081p0.a(this.curve_);
        return enumC0081p0A == null ? EnumC0081p0.UNRECOGNIZED : enumC0081p0A;
    }

    @Override // com.google.crypto.tink.proto.EcdsaParamsOrBuilder
    public final int getCurveValue() {
        return this.curve_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.proto.EcdsaParamsOrBuilder
    public final EnumC0048e0 getEncoding() {
        int i = this.encoding_;
        EnumC0048e0 enumC0048e0 = i != 0 ? i != 1 ? i != 2 ? null : EnumC0048e0.DER : EnumC0048e0.IEEE_P1363 : EnumC0048e0.UNKNOWN_ENCODING;
        return enumC0048e0 == null ? EnumC0048e0.UNRECOGNIZED : enumC0048e0;
    }

    @Override // com.google.crypto.tink.proto.EcdsaParamsOrBuilder
    public final int getEncodingValue() {
        return this.encoding_;
    }

    @Override // com.google.crypto.tink.proto.EcdsaParamsOrBuilder
    public final EnumC0086s0 getHashType() {
        EnumC0086s0 enumC0086s0A = EnumC0086s0.a(this.hashType_);
        return enumC0086s0A == null ? EnumC0086s0.UNRECOGNIZED : enumC0086s0A;
    }

    @Override // com.google.crypto.tink.proto.EcdsaParamsOrBuilder
    public final int getHashTypeValue() {
        return this.hashType_;
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
