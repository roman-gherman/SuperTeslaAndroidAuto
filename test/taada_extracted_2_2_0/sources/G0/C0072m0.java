package G0;

import com.google.crypto.tink.proto.EciesHkdfKemParamsOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0072m0 extends com.google.crypto.tink.shaded.protobuf.Q implements EciesHkdfKemParamsOrBuilder {
    public static final int CURVE_TYPE_FIELD_NUMBER = 1;
    private static final C0072m0 DEFAULT_INSTANCE;
    public static final int HKDF_HASH_TYPE_FIELD_NUMBER = 2;
    public static final int HKDF_SALT_FIELD_NUMBER = 11;
    private static volatile Parser<C0072m0> PARSER;
    private int curveType_;
    private int hkdfHashType_;
    private AbstractC0381o hkdfSalt_ = AbstractC0381o.b;

    static {
        C0072m0 c0072m0 = new C0072m0();
        DEFAULT_INSTANCE = c0072m0;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0072m0.class, c0072m0);
    }

    public static C0072m0 t() {
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"curveType_", "hkdfHashType_", "hkdfSalt_"});
            case 3:
                return new C0072m0();
            case 4:
                return new C0069l0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0072m0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0072m0.class) {
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

    @Override // com.google.crypto.tink.proto.EciesHkdfKemParamsOrBuilder
    public final EnumC0081p0 getCurveType() {
        EnumC0081p0 enumC0081p0A = EnumC0081p0.a(this.curveType_);
        return enumC0081p0A == null ? EnumC0081p0.UNRECOGNIZED : enumC0081p0A;
    }

    @Override // com.google.crypto.tink.proto.EciesHkdfKemParamsOrBuilder
    public final int getCurveTypeValue() {
        return this.curveType_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.proto.EciesHkdfKemParamsOrBuilder
    public final EnumC0086s0 getHkdfHashType() {
        EnumC0086s0 enumC0086s0A = EnumC0086s0.a(this.hkdfHashType_);
        return enumC0086s0A == null ? EnumC0086s0.UNRECOGNIZED : enumC0086s0A;
    }

    @Override // com.google.crypto.tink.proto.EciesHkdfKemParamsOrBuilder
    public final int getHkdfHashTypeValue() {
        return this.hkdfHashType_;
    }

    @Override // com.google.crypto.tink.proto.EciesHkdfKemParamsOrBuilder
    public final AbstractC0381o getHkdfSalt() {
        return this.hkdfSalt_;
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
