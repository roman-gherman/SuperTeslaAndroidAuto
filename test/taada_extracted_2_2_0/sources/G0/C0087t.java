package G0;

import com.google.crypto.tink.proto.AesCtrKeyFormatOrBuilder;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0087t extends com.google.crypto.tink.shaded.protobuf.Q implements AesCtrKeyFormatOrBuilder {
    private static final C0087t DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<C0087t> PARSER;
    private int keySize_;
    private C0091v params_;

    static {
        C0087t c0087t = new C0087t();
        DEFAULT_INSTANCE = c0087t;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0087t.class, c0087t);
    }

    public static void t(C0087t c0087t, C0091v c0091v) {
        c0087t.getClass();
        c0087t.params_ = c0091v;
    }

    public static void u(C0087t c0087t, int i) {
        c0087t.keySize_ = i;
    }

    public static C0087t v() {
        return DEFAULT_INSTANCE;
    }

    public static C0085s w() {
        return (C0085s) DEFAULT_INSTANCE.d();
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
                return new C0087t();
            case 4:
                return new C0085s(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0087t> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0087t.class) {
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

    @Override // com.google.crypto.tink.proto.AesCtrKeyFormatOrBuilder
    public final int getKeySize() {
        return this.keySize_;
    }

    @Override // com.google.crypto.tink.proto.AesCtrKeyFormatOrBuilder
    public final C0091v getParams() {
        C0091v c0091v = this.params_;
        return c0091v == null ? C0091v.u() : c0091v;
    }

    @Override // com.google.crypto.tink.proto.AesCtrKeyFormatOrBuilder
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
