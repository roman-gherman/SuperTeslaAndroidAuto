package G0;

import com.google.crypto.tink.proto.AesCmacParamsOrBuilder;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0050f extends com.google.crypto.tink.shaded.protobuf.Q implements AesCmacParamsOrBuilder {
    private static final C0050f DEFAULT_INSTANCE;
    private static volatile Parser<C0050f> PARSER = null;
    public static final int TAG_SIZE_FIELD_NUMBER = 1;
    private int tagSize_;

    static {
        C0050f c0050f = new C0050f();
        DEFAULT_INSTANCE = c0050f;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0050f.class, c0050f);
    }

    public static void t(C0050f c0050f, int i) {
        c0050f.tagSize_ = i;
    }

    public static C0050f u() {
        return DEFAULT_INSTANCE;
    }

    public static C0047e v() {
        return (C0047e) DEFAULT_INSTANCE.d();
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"tagSize_"});
            case 3:
                return new C0050f();
            case 4:
                return new C0047e(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0050f> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0050f.class) {
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

    @Override // com.google.crypto.tink.proto.AesCmacParamsOrBuilder
    public final int getTagSize() {
        return this.tagSize_;
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
