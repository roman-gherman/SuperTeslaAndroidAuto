package G0;

import com.google.crypto.tink.proto.RsaSsaPssPublicKeyOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0379n;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: loaded from: classes.dex */
public final class K1 extends com.google.crypto.tink.shaded.protobuf.Q implements RsaSsaPssPublicKeyOrBuilder {
    private static final K1 DEFAULT_INSTANCE;
    public static final int E_FIELD_NUMBER = 4;
    public static final int N_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<K1> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AbstractC0381o e_;
    private AbstractC0381o n_;
    private I1 params_;
    private int version_;

    static {
        K1 k12 = new K1();
        DEFAULT_INSTANCE = k12;
        com.google.crypto.tink.shaded.protobuf.Q.q(K1.class, k12);
    }

    public K1() {
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"version_", "params_", "n_", "e_"});
            case 3:
                return new K1();
            case 4:
                return new J1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<K1> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (K1.class) {
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

    @Override // com.google.crypto.tink.proto.RsaSsaPssPublicKeyOrBuilder
    public final AbstractC0381o getE() {
        return this.e_;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssPublicKeyOrBuilder
    public final AbstractC0381o getN() {
        return this.n_;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssPublicKeyOrBuilder
    public final I1 getParams() {
        I1 i12 = this.params_;
        return i12 == null ? I1.t() : i12;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssPublicKeyOrBuilder
    public final int getVersion() {
        return this.version_;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssPublicKeyOrBuilder
    public final boolean hasParams() {
        return this.params_ != null;
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
