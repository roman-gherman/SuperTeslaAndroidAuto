package G0;

import com.google.crypto.tink.proto.HmacKeyFormatOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.y0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0098y0 extends com.google.crypto.tink.shaded.protobuf.Q implements HmacKeyFormatOrBuilder {
    private static final C0098y0 DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<C0098y0> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int keySize_;
    private A0 params_;
    private int version_;

    static {
        C0098y0 c0098y0 = new C0098y0();
        DEFAULT_INSTANCE = c0098y0;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0098y0.class, c0098y0);
    }

    public static void t(C0098y0 c0098y0, A0 a02) {
        c0098y0.getClass();
        c0098y0.params_ = a02;
    }

    public static void u(C0098y0 c0098y0, int i) {
        c0098y0.keySize_ = i;
    }

    public static C0098y0 v() {
        return DEFAULT_INSTANCE;
    }

    public static C0096x0 w() {
        return (C0096x0) DEFAULT_INSTANCE.d();
    }

    public static C0098y0 x(AbstractC0381o abstractC0381o, com.google.crypto.tink.shaded.protobuf.D d) {
        return (C0098y0) com.google.crypto.tink.shaded.protobuf.Q.n(DEFAULT_INSTANCE, abstractC0381o, d);
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
                return new C0098y0();
            case 4:
                return new C0096x0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0098y0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0098y0.class) {
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

    @Override // com.google.crypto.tink.proto.HmacKeyFormatOrBuilder
    public final int getKeySize() {
        return this.keySize_;
    }

    @Override // com.google.crypto.tink.proto.HmacKeyFormatOrBuilder
    public final A0 getParams() {
        A0 a02 = this.params_;
        return a02 == null ? A0.v() : a02;
    }

    @Override // com.google.crypto.tink.proto.HmacKeyFormatOrBuilder
    public final int getVersion() {
        return this.version_;
    }

    @Override // com.google.crypto.tink.proto.HmacKeyFormatOrBuilder
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
