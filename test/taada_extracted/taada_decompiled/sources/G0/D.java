package G0;

import com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0379n;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: loaded from: classes.dex */
public final class D extends com.google.crypto.tink.shaded.protobuf.Q implements AesGcmHkdfStreamingKeyOrBuilder {
    private static final D DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<D> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AbstractC0381o keyValue_ = AbstractC0381o.b;
    private H params_;
    private int version_;

    static {
        D d = new D();
        DEFAULT_INSTANCE = d;
        com.google.crypto.tink.shaded.protobuf.Q.q(D.class, d);
    }

    public static void t(D d) {
        d.version_ = 0;
    }

    public static void u(D d, H h3) {
        d.getClass();
        h3.getClass();
        d.params_ = h3;
    }

    public static void v(D d, C0379n c0379n) {
        d.getClass();
        d.keyValue_ = c0379n;
    }

    public static C w() {
        return (C) DEFAULT_INSTANCE.d();
    }

    public static D x(AbstractC0381o abstractC0381o, com.google.crypto.tink.shaded.protobuf.D d) {
        return (D) com.google.crypto.tink.shaded.protobuf.Q.n(DEFAULT_INSTANCE, abstractC0381o, d);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 3:
                return new D();
            case 4:
                return new C(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<D> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (D.class) {
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

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyOrBuilder
    public final AbstractC0381o getKeyValue() {
        return this.keyValue_;
    }

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyOrBuilder
    public final H getParams() {
        H h3 = this.params_;
        return h3 == null ? H.w() : h3;
    }

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyOrBuilder
    public final int getVersion() {
        return this.version_;
    }

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyOrBuilder
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
