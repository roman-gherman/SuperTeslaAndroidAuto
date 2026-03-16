package G0;

import com.google.crypto.tink.proto.JwtEcdsaPublicKeyOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0379n;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: loaded from: classes.dex */
public final class O0 extends com.google.crypto.tink.shaded.protobuf.Q implements JwtEcdsaPublicKeyOrBuilder {
    public static final int ALGORITHM_FIELD_NUMBER = 2;
    public static final int CUSTOM_KID_FIELD_NUMBER = 5;
    private static final O0 DEFAULT_INSTANCE;
    private static volatile Parser<O0> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public static final int X_FIELD_NUMBER = 3;
    public static final int Y_FIELD_NUMBER = 4;
    private int algorithm_;
    private N0 customKid_;
    private int version_;
    private AbstractC0381o x_;
    private AbstractC0381o y_;

    static {
        O0 o0 = new O0();
        DEFAULT_INSTANCE = o0;
        com.google.crypto.tink.shaded.protobuf.Q.q(O0.class, o0);
    }

    public O0() {
        C0379n c0379n = AbstractC0381o.b;
        this.x_ = c0379n;
        this.y_ = c0379n;
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u000b\u0002\f\u0003\n\u0004\n\u0005\t", new Object[]{"version_", "algorithm_", "x_", "y_", "customKid_"});
            case 3:
                return new O0();
            case 4:
                return new L0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<O0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (O0.class) {
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

    @Override // com.google.crypto.tink.proto.JwtEcdsaPublicKeyOrBuilder
    public final K0 getAlgorithm() {
        int i = this.algorithm_;
        K0 k02 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : K0.ES512 : K0.ES384 : K0.ES256 : K0.ES_UNKNOWN;
        return k02 == null ? K0.UNRECOGNIZED : k02;
    }

    @Override // com.google.crypto.tink.proto.JwtEcdsaPublicKeyOrBuilder
    public final int getAlgorithmValue() {
        return this.algorithm_;
    }

    @Override // com.google.crypto.tink.proto.JwtEcdsaPublicKeyOrBuilder
    public final N0 getCustomKid() {
        N0 n02 = this.customKid_;
        return n02 == null ? N0.t() : n02;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.proto.JwtEcdsaPublicKeyOrBuilder
    public final int getVersion() {
        return this.version_;
    }

    @Override // com.google.crypto.tink.proto.JwtEcdsaPublicKeyOrBuilder
    public final AbstractC0381o getX() {
        return this.x_;
    }

    @Override // com.google.crypto.tink.proto.JwtEcdsaPublicKeyOrBuilder
    public final AbstractC0381o getY() {
        return this.y_;
    }

    @Override // com.google.crypto.tink.proto.JwtEcdsaPublicKeyOrBuilder
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
