package G0;

import com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormatOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0074n extends com.google.crypto.tink.shaded.protobuf.Q implements AesCtrHmacStreamingKeyFormatOrBuilder {
    private static final C0074n DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<C0074n> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int keySize_;
    private C0080p params_;
    private int version_;

    static {
        C0074n c0074n = new C0074n();
        DEFAULT_INSTANCE = c0074n;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0074n.class, c0074n);
    }

    public static void t(C0074n c0074n, C0080p c0080p) {
        c0074n.getClass();
        c0074n.params_ = c0080p;
    }

    public static void u(C0074n c0074n, int i) {
        c0074n.keySize_ = i;
    }

    public static C0071m v() {
        return (C0071m) DEFAULT_INSTANCE.d();
    }

    public static C0074n w(AbstractC0381o abstractC0381o, com.google.crypto.tink.shaded.protobuf.D d) {
        return (C0074n) com.google.crypto.tink.shaded.protobuf.Q.n(DEFAULT_INSTANCE, abstractC0381o, d);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"params_", "keySize_", "version_"});
            case 3:
                return new C0074n();
            case 4:
                return new C0071m(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0074n> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0074n.class) {
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

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormatOrBuilder
    public final int getKeySize() {
        return this.keySize_;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormatOrBuilder
    public final C0080p getParams() {
        C0080p c0080p = this.params_;
        return c0080p == null ? C0080p.x() : c0080p;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormatOrBuilder
    public final int getVersion() {
        return this.version_;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormatOrBuilder
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
