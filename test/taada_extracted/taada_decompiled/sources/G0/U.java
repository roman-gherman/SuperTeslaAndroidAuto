package G0;

import com.google.crypto.tink.proto.AesSivKeyFormatOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: loaded from: classes.dex */
public final class U extends com.google.crypto.tink.shaded.protobuf.Q implements AesSivKeyFormatOrBuilder {
    private static final U DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 1;
    private static volatile Parser<U> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 2;
    private int keySize_;
    private int version_;

    static {
        U u = new U();
        DEFAULT_INSTANCE = u;
        com.google.crypto.tink.shaded.protobuf.Q.q(U.class, u);
    }

    public static void t(U u) {
        u.keySize_ = 64;
    }

    public static T u() {
        return (T) DEFAULT_INSTANCE.d();
    }

    public static U v(AbstractC0381o abstractC0381o, com.google.crypto.tink.shaded.protobuf.D d) {
        return (U) com.google.crypto.tink.shaded.protobuf.Q.n(DEFAULT_INSTANCE, abstractC0381o, d);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"keySize_", "version_"});
            case 3:
                return new U();
            case 4:
                return new T(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<U> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (U.class) {
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

    @Override // com.google.crypto.tink.proto.AesSivKeyFormatOrBuilder
    public final int getKeySize() {
        return this.keySize_;
    }

    @Override // com.google.crypto.tink.proto.AesSivKeyFormatOrBuilder
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
