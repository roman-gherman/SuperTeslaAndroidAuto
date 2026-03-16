package G0;

import com.google.crypto.tink.proto.Ed25519PublicKeyOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0078o0 extends com.google.crypto.tink.shaded.protobuf.Q implements Ed25519PublicKeyOrBuilder {
    private static final C0078o0 DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<C0078o0> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AbstractC0381o keyValue_ = AbstractC0381o.b;
    private int version_;

    static {
        C0078o0 c0078o0 = new C0078o0();
        DEFAULT_INSTANCE = c0078o0;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0078o0.class, c0078o0);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"version_", "keyValue_"});
            case 3:
                return new C0078o0();
            case 4:
                return new C0075n0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0078o0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0078o0.class) {
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

    @Override // com.google.crypto.tink.proto.Ed25519PublicKeyOrBuilder
    public final AbstractC0381o getKeyValue() {
        return this.keyValue_;
    }

    @Override // com.google.crypto.tink.proto.Ed25519PublicKeyOrBuilder
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
