package G0;

import com.google.crypto.tink.proto.AesEaxKeyFormatOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0099z extends com.google.crypto.tink.shaded.protobuf.Q implements AesEaxKeyFormatOrBuilder {
    private static final C0099z DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<C0099z> PARSER;
    private int keySize_;
    private B params_;

    static {
        C0099z c0099z = new C0099z();
        DEFAULT_INSTANCE = c0099z;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0099z.class, c0099z);
    }

    public static void t(C0099z c0099z, B b) {
        c0099z.getClass();
        c0099z.params_ = b;
    }

    public static void u(C0099z c0099z, int i) {
        c0099z.keySize_ = i;
    }

    public static C0097y v() {
        return (C0097y) DEFAULT_INSTANCE.d();
    }

    public static C0099z w(AbstractC0381o abstractC0381o, com.google.crypto.tink.shaded.protobuf.D d) {
        return (C0099z) com.google.crypto.tink.shaded.protobuf.Q.n(DEFAULT_INSTANCE, abstractC0381o, d);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"params_", "keySize_"});
            case 3:
                return new C0099z();
            case 4:
                return new C0097y(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0099z> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0099z.class) {
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

    @Override // com.google.crypto.tink.proto.AesEaxKeyFormatOrBuilder
    public final int getKeySize() {
        return this.keySize_;
    }

    @Override // com.google.crypto.tink.proto.AesEaxKeyFormatOrBuilder
    public final B getParams() {
        B b = this.params_;
        return b == null ? B.u() : b;
    }

    @Override // com.google.crypto.tink.proto.AesEaxKeyFormatOrBuilder
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
