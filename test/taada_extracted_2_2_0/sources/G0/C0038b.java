package G0;

import com.google.crypto.tink.proto.AesCmacKeyOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0379n;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0038b extends com.google.crypto.tink.shaded.protobuf.Q implements AesCmacKeyOrBuilder {
    private static final C0038b DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 3;
    private static volatile Parser<C0038b> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AbstractC0381o keyValue_ = AbstractC0381o.b;
    private C0050f params_;
    private int version_;

    static {
        C0038b c0038b = new C0038b();
        DEFAULT_INSTANCE = c0038b;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0038b.class, c0038b);
    }

    public static void t(C0038b c0038b) {
        c0038b.version_ = 0;
    }

    public static void u(C0038b c0038b, C0379n c0379n) {
        c0038b.getClass();
        c0038b.keyValue_ = c0379n;
    }

    public static void v(C0038b c0038b, C0050f c0050f) {
        c0038b.getClass();
        c0050f.getClass();
        c0038b.params_ = c0050f;
    }

    public static C0035a w() {
        return (C0035a) DEFAULT_INSTANCE.d();
    }

    public static C0038b x(AbstractC0381o abstractC0381o, com.google.crypto.tink.shaded.protobuf.D d) {
        return (C0038b) com.google.crypto.tink.shaded.protobuf.Q.n(DEFAULT_INSTANCE, abstractC0381o, d);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"version_", "keyValue_", "params_"});
            case 3:
                return new C0038b();
            case 4:
                return new C0035a(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0038b> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0038b.class) {
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

    @Override // com.google.crypto.tink.proto.AesCmacKeyOrBuilder
    public final AbstractC0381o getKeyValue() {
        return this.keyValue_;
    }

    @Override // com.google.crypto.tink.proto.AesCmacKeyOrBuilder
    public final C0050f getParams() {
        C0050f c0050f = this.params_;
        return c0050f == null ? C0050f.u() : c0050f;
    }

    @Override // com.google.crypto.tink.proto.AesCmacKeyOrBuilder
    public final int getVersion() {
        return this.version_;
    }

    @Override // com.google.crypto.tink.proto.AesCmacKeyOrBuilder
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
