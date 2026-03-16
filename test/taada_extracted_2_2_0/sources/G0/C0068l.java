package G0;

import com.google.crypto.tink.proto.AesCtrHmacStreamingKeyOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0379n;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0068l extends com.google.crypto.tink.shaded.protobuf.Q implements AesCtrHmacStreamingKeyOrBuilder {
    private static final C0068l DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<C0068l> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AbstractC0381o keyValue_ = AbstractC0381o.b;
    private C0080p params_;
    private int version_;

    static {
        C0068l c0068l = new C0068l();
        DEFAULT_INSTANCE = c0068l;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0068l.class, c0068l);
    }

    public static void t(C0068l c0068l) {
        c0068l.version_ = 0;
    }

    public static void u(C0068l c0068l, C0080p c0080p) {
        c0068l.getClass();
        c0080p.getClass();
        c0068l.params_ = c0080p;
    }

    public static void v(C0068l c0068l, C0379n c0379n) {
        c0068l.getClass();
        c0068l.keyValue_ = c0379n;
    }

    public static C0065k w() {
        return (C0065k) DEFAULT_INSTANCE.d();
    }

    public static C0068l x(AbstractC0381o abstractC0381o, com.google.crypto.tink.shaded.protobuf.D d) {
        return (C0068l) com.google.crypto.tink.shaded.protobuf.Q.n(DEFAULT_INSTANCE, abstractC0381o, d);
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
                return new C0068l();
            case 4:
                return new C0065k(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0068l> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0068l.class) {
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

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyOrBuilder
    public final AbstractC0381o getKeyValue() {
        return this.keyValue_;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyOrBuilder
    public final C0080p getParams() {
        C0080p c0080p = this.params_;
        return c0080p == null ? C0080p.x() : c0080p;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyOrBuilder
    public final int getVersion() {
        return this.version_;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyOrBuilder
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
