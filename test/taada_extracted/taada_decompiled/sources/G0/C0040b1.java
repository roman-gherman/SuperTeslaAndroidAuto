package G0;

import com.google.crypto.tink.proto.JwtRsaSsaPssPublicKeyOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0379n;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.b1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0040b1 extends com.google.crypto.tink.shaded.protobuf.Q implements JwtRsaSsaPssPublicKeyOrBuilder {
    public static final int ALGORITHM_FIELD_NUMBER = 2;
    public static final int CUSTOM_KID_FIELD_NUMBER = 5;
    private static final C0040b1 DEFAULT_INSTANCE;
    public static final int E_FIELD_NUMBER = 4;
    public static final int N_FIELD_NUMBER = 3;
    private static volatile Parser<C0040b1> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private int algorithm_;
    private C0037a1 customKid_;
    private AbstractC0381o e_;
    private AbstractC0381o n_;
    private int version_;

    static {
        C0040b1 c0040b1 = new C0040b1();
        DEFAULT_INSTANCE = c0040b1;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0040b1.class, c0040b1);
    }

    public C0040b1() {
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
                return new C0040b1();
            case 4:
                return new Y0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0040b1> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0040b1.class) {
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

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPssPublicKeyOrBuilder
    public final X0 getAlgorithm() {
        int i = this.algorithm_;
        X0 x02 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : X0.PS512 : X0.PS384 : X0.PS256 : X0.PS_UNKNOWN;
        return x02 == null ? X0.UNRECOGNIZED : x02;
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPssPublicKeyOrBuilder
    public final int getAlgorithmValue() {
        return this.algorithm_;
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPssPublicKeyOrBuilder
    public final C0037a1 getCustomKid() {
        C0037a1 c0037a1 = this.customKid_;
        return c0037a1 == null ? C0037a1.t() : c0037a1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPssPublicKeyOrBuilder
    public final AbstractC0381o getE() {
        return this.e_;
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPssPublicKeyOrBuilder
    public final AbstractC0381o getN() {
        return this.n_;
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPssPublicKeyOrBuilder
    public final int getVersion() {
        return this.version_;
    }

    @Override // com.google.crypto.tink.proto.JwtRsaSsaPssPublicKeyOrBuilder
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
