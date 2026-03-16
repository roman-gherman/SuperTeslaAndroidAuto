package G0;

import com.google.crypto.tink.proto.AesCtrHmacAeadKeyOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0056h extends com.google.crypto.tink.shaded.protobuf.Q implements AesCtrHmacAeadKeyOrBuilder {
    public static final int AES_CTR_KEY_FIELD_NUMBER = 2;
    private static final C0056h DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FIELD_NUMBER = 3;
    private static volatile Parser<C0056h> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private r aesCtrKey_;
    private C0094w0 hmacKey_;
    private int version_;

    static {
        C0056h c0056h = new C0056h();
        DEFAULT_INSTANCE = c0056h;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0056h.class, c0056h);
    }

    public static void t(C0056h c0056h) {
        c0056h.version_ = 0;
    }

    public static void u(C0056h c0056h, r rVar) {
        c0056h.getClass();
        rVar.getClass();
        c0056h.aesCtrKey_ = rVar;
    }

    public static void v(C0056h c0056h, C0094w0 c0094w0) {
        c0056h.getClass();
        c0094w0.getClass();
        c0056h.hmacKey_ = c0094w0;
    }

    public static C0053g w() {
        return (C0053g) DEFAULT_INSTANCE.d();
    }

    public static C0056h x(AbstractC0381o abstractC0381o, com.google.crypto.tink.shaded.protobuf.D d) {
        return (C0056h) com.google.crypto.tink.shaded.protobuf.Q.n(DEFAULT_INSTANCE, abstractC0381o, d);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"version_", "aesCtrKey_", "hmacKey_"});
            case 3:
                return new C0056h();
            case 4:
                return new C0053g(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0056h> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0056h.class) {
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

    @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyOrBuilder
    public final r getAesCtrKey() {
        r rVar = this.aesCtrKey_;
        return rVar == null ? r.w() : rVar;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyOrBuilder
    public final C0094w0 getHmacKey() {
        C0094w0 c0094w0 = this.hmacKey_;
        return c0094w0 == null ? C0094w0.w() : c0094w0;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyOrBuilder
    public final int getVersion() {
        return this.version_;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyOrBuilder
    public final boolean hasAesCtrKey() {
        return this.aesCtrKey_ != null;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyOrBuilder
    public final boolean hasHmacKey() {
        return this.hmacKey_ != null;
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
