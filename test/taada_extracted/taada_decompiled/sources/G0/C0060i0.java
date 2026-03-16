package G0;

import com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0060i0 extends com.google.crypto.tink.shaded.protobuf.Q implements EciesAeadHkdfParamsOrBuilder {
    private static final C0060i0 DEFAULT_INSTANCE;
    public static final int DEM_PARAMS_FIELD_NUMBER = 2;
    public static final int EC_POINT_FORMAT_FIELD_NUMBER = 3;
    public static final int KEM_PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<C0060i0> PARSER;
    private C0054g0 demParams_;
    private int ecPointFormat_;
    private C0072m0 kemParams_;

    static {
        C0060i0 c0060i0 = new C0060i0();
        DEFAULT_INSTANCE = c0060i0;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0060i0.class, c0060i0);
    }

    public static C0060i0 t() {
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"kemParams_", "demParams_", "ecPointFormat_"});
            case 3:
                return new C0060i0();
            case 4:
                return new C0057h0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0060i0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0060i0.class) {
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

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder
    public final C0054g0 getDemParams() {
        C0054g0 c0054g0 = this.demParams_;
        return c0054g0 == null ? C0054g0.t() : c0054g0;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder
    public final Z getEcPointFormat() {
        int i = this.ecPointFormat_;
        Z z6 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : Z.DO_NOT_USE_CRUNCHY_UNCOMPRESSED : Z.COMPRESSED : Z.UNCOMPRESSED : Z.UNKNOWN_FORMAT;
        return z6 == null ? Z.UNRECOGNIZED : z6;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder
    public final int getEcPointFormatValue() {
        return this.ecPointFormat_;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder
    public final C0072m0 getKemParams() {
        C0072m0 c0072m0 = this.kemParams_;
        return c0072m0 == null ? C0072m0.t() : c0072m0;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder
    public final boolean hasDemParams() {
        return this.demParams_ != null;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder
    public final boolean hasKemParams() {
        return this.kemParams_ != null;
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
