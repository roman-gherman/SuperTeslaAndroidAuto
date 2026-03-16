package G0;

import com.google.crypto.tink.proto.EciesAeadDemParamsOrBuilder;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0054g0 extends com.google.crypto.tink.shaded.protobuf.Q implements EciesAeadDemParamsOrBuilder {
    public static final int AEAD_DEM_FIELD_NUMBER = 2;
    private static final C0054g0 DEFAULT_INSTANCE;
    private static volatile Parser<C0054g0> PARSER;
    private C0058h1 aeadDem_;

    static {
        C0054g0 c0054g0 = new C0054g0();
        DEFAULT_INSTANCE = c0054g0;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0054g0.class, c0054g0);
    }

    public static C0054g0 t() {
        return DEFAULT_INSTANCE;
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"aeadDem_"});
            case 3:
                return new C0054g0();
            case 4:
                return new C0051f0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0054g0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0054g0.class) {
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

    @Override // com.google.crypto.tink.proto.EciesAeadDemParamsOrBuilder
    public final C0058h1 getAeadDem() {
        C0058h1 c0058h1 = this.aeadDem_;
        return c0058h1 == null ? C0058h1.w() : c0058h1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Q, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.proto.EciesAeadDemParamsOrBuilder
    public final boolean hasAeadDem() {
        return this.aeadDem_ != null;
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
