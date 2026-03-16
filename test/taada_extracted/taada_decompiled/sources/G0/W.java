package G0;

import com.google.crypto.tink.proto.ChaCha20Poly1305KeyOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0379n;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: loaded from: classes.dex */
public final class W extends com.google.crypto.tink.shaded.protobuf.Q implements ChaCha20Poly1305KeyOrBuilder {
    private static final W DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<W> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AbstractC0381o keyValue_ = AbstractC0381o.b;
    private int version_;

    static {
        W w5 = new W();
        DEFAULT_INSTANCE = w5;
        com.google.crypto.tink.shaded.protobuf.Q.q(W.class, w5);
    }

    public static void t(W w5) {
        w5.version_ = 0;
    }

    public static void u(W w5, C0379n c0379n) {
        w5.getClass();
        w5.keyValue_ = c0379n;
    }

    public static V v() {
        return (V) DEFAULT_INSTANCE.d();
    }

    public static W w(AbstractC0381o abstractC0381o, com.google.crypto.tink.shaded.protobuf.D d) {
        return (W) com.google.crypto.tink.shaded.protobuf.Q.n(DEFAULT_INSTANCE, abstractC0381o, d);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"version_", "keyValue_"});
            case 3:
                return new W();
            case 4:
                return new V(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<W> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (W.class) {
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

    @Override // com.google.crypto.tink.proto.ChaCha20Poly1305KeyOrBuilder
    public final AbstractC0381o getKeyValue() {
        return this.keyValue_;
    }

    @Override // com.google.crypto.tink.proto.ChaCha20Poly1305KeyOrBuilder
    public final int getVersion() {
        return this.version_;
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
