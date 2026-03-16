package G0;

import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormatOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0062j extends com.google.crypto.tink.shaded.protobuf.Q implements AesCtrHmacAeadKeyFormatOrBuilder {
    public static final int AES_CTR_KEY_FORMAT_FIELD_NUMBER = 1;
    private static final C0062j DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FORMAT_FIELD_NUMBER = 2;
    private static volatile Parser<C0062j> PARSER;
    private C0087t aesCtrKeyFormat_;
    private C0098y0 hmacKeyFormat_;

    static {
        C0062j c0062j = new C0062j();
        DEFAULT_INSTANCE = c0062j;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0062j.class, c0062j);
    }

    public static void t(C0062j c0062j, C0087t c0087t) {
        c0062j.getClass();
        c0062j.aesCtrKeyFormat_ = c0087t;
    }

    public static void u(C0062j c0062j, C0098y0 c0098y0) {
        c0062j.getClass();
        c0062j.hmacKeyFormat_ = c0098y0;
    }

    public static C0059i v() {
        return (C0059i) DEFAULT_INSTANCE.d();
    }

    public static C0062j w(AbstractC0381o abstractC0381o, com.google.crypto.tink.shaded.protobuf.D d) {
        return (C0062j) com.google.crypto.tink.shaded.protobuf.Q.n(DEFAULT_INSTANCE, abstractC0381o, d);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"aesCtrKeyFormat_", "hmacKeyFormat_"});
            case 3:
                return new C0062j();
            case 4:
                return new C0059i(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0062j> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0062j.class) {
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

    @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormatOrBuilder
    public final C0087t getAesCtrKeyFormat() {
        C0087t c0087t = this.aesCtrKeyFormat_;
        return c0087t == null ? C0087t.v() : c0087t;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormatOrBuilder
    public final C0098y0 getHmacKeyFormat() {
        C0098y0 c0098y0 = this.hmacKeyFormat_;
        return c0098y0 == null ? C0098y0.v() : c0098y0;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormatOrBuilder
    public final boolean hasAesCtrKeyFormat() {
        return this.aesCtrKeyFormat_ != null;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormatOrBuilder
    public final boolean hasHmacKeyFormat() {
        return this.hmacKeyFormat_ != null;
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
