package G0;

import com.google.crypto.tink.proto.HmacPrfParamsOrBuilder;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: loaded from: classes.dex */
public final class C0 extends com.google.crypto.tink.shaded.protobuf.Q implements HmacPrfParamsOrBuilder {
    private static final C0 DEFAULT_INSTANCE;
    public static final int HASH_FIELD_NUMBER = 1;
    private static volatile Parser<C0> PARSER;
    private int hash_;

    static {
        C0 c02 = new C0();
        DEFAULT_INSTANCE = c02;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0.class, c02);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"hash_"});
            case 3:
                return new C0();
            case 4:
                return new B0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0.class) {
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

    @Override // com.google.crypto.tink.proto.HmacPrfParamsOrBuilder
    public final EnumC0086s0 getHash() {
        EnumC0086s0 enumC0086s0A = EnumC0086s0.a(this.hash_);
        return enumC0086s0A == null ? EnumC0086s0.UNRECOGNIZED : enumC0086s0A;
    }

    @Override // com.google.crypto.tink.proto.HmacPrfParamsOrBuilder
    public final int getHashValue() {
        return this.hash_;
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
