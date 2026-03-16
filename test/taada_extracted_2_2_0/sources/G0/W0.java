package G0;

import com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKeyOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0379n;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: loaded from: classes.dex */
public final class W0 extends com.google.crypto.tink.shaded.protobuf.Q implements JwtRsaSsaPkcs1PublicKeyOrBuilder {
    public static final int ALGORITHM_FIELD_NUMBER = 2;
    public static final int CUSTOM_KID_FIELD_NUMBER = 5;
    private static final W0 DEFAULT_INSTANCE;
    public static final int E_FIELD_NUMBER = 4;
    public static final int N_FIELD_NUMBER = 3;
    private static volatile Parser<W0> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private int algorithm_;
    private V0 customKid_;
    private AbstractC0381o e_;
    private AbstractC0381o n_;
    private int version_;

    static {
        W0 w02 = new W0();
        DEFAULT_INSTANCE = w02;
        com.google.crypto.tink.shaded.protobuf.Q.q(W0.class, w02);
    }

    public W0() {
        C0379n c0379n = AbstractC0381o.b;
        this.n_ = c0379n;
        this.e_ = c0379n;
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u000b\u0002\f\u0003\n\u0004\n\u0005\t", new Object[]{"version_", "algorithm_", "n_", "e_", "customKid_"});
            case 3:
                return new W0();
            case 4:
                return new T0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<W0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (W0.class) {
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

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
    public final S0 getAlgorithm() {
        int i = this.algorithm_;
        S0 s02 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : S0.RS512 : S0.RS384 : S0.RS256 : S0.RS_UNKNOWN;
        return s02 == null ? S0.UNRECOGNIZED : s02;
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
    public final int getAlgorithmValue() {
        return this.algorithm_;
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
    public final V0 getCustomKid() {
        V0 v02 = this.customKid_;
        return v02 == null ? V0.t() : v02;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
    public final AbstractC0381o getE() {
        return this.e_;
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
    public final AbstractC0381o getN() {
        return this.n_;
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
    public final int getVersion() {
        return this.version_;
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
    public final boolean hasCustomKid() {
        return this.customKid_ != null;
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
