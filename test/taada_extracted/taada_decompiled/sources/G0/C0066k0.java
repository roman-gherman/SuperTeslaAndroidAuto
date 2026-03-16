package G0;

import com.google.crypto.tink.proto.EciesAeadHkdfPublicKeyOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0379n;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0066k0 extends com.google.crypto.tink.shaded.protobuf.Q implements EciesAeadHkdfPublicKeyOrBuilder {
    private static final C0066k0 DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<C0066k0> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public static final int X_FIELD_NUMBER = 3;
    public static final int Y_FIELD_NUMBER = 4;
    private C0060i0 params_;
    private int version_;
    private AbstractC0381o x_;
    private AbstractC0381o y_;

    static {
        C0066k0 c0066k0 = new C0066k0();
        DEFAULT_INSTANCE = c0066k0;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0066k0.class, c0066k0);
    }

    public C0066k0() {
        C0379n c0379n = AbstractC0381o.b;
        this.x_ = c0379n;
        this.y_ = c0379n;
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"version_", "params_", "x_", "y_"});
            case 3:
                return new C0066k0();
            case 4:
                return new C0063j0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0066k0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0066k0.class) {
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

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfPublicKeyOrBuilder
    public final C0060i0 getParams() {
        C0060i0 c0060i0 = this.params_;
        return c0060i0 == null ? C0060i0.t() : c0060i0;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfPublicKeyOrBuilder
    public final int getVersion() {
        return this.version_;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfPublicKeyOrBuilder
    public final AbstractC0381o getX() {
        return this.x_;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfPublicKeyOrBuilder
    public final AbstractC0381o getY() {
        return this.y_;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfPublicKeyOrBuilder
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
