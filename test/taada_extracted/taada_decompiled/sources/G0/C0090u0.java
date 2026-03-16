package G0;

import com.google.crypto.tink.proto.HkdfPrfParamsOrBuilder;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.C0397w0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;

/* JADX INFO: renamed from: G0.u0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0090u0 extends com.google.crypto.tink.shaded.protobuf.Q implements HkdfPrfParamsOrBuilder {
    private static final C0090u0 DEFAULT_INSTANCE;
    public static final int HASH_FIELD_NUMBER = 1;
    private static volatile Parser<C0090u0> PARSER = null;
    public static final int SALT_FIELD_NUMBER = 2;
    private int hash_;
    private AbstractC0381o salt_ = AbstractC0381o.b;

    static {
        C0090u0 c0090u0 = new C0090u0();
        DEFAULT_INSTANCE = c0090u0;
        com.google.crypto.tink.shaded.protobuf.Q.q(C0090u0.class, c0090u0);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\n", new Object[]{"hash_", "salt_"});
            case 3:
                return new C0090u0();
            case 4:
                return new C0088t0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0090u0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0090u0.class) {
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

    @Override // com.google.crypto.tink.proto.HkdfPrfParamsOrBuilder
    public final EnumC0086s0 getHash() {
        EnumC0086s0 enumC0086s0A = EnumC0086s0.a(this.hash_);
        return enumC0086s0A == null ? EnumC0086s0.UNRECOGNIZED : enumC0086s0A;
    }

    @Override // com.google.crypto.tink.proto.HkdfPrfParamsOrBuilder
    public final int getHashValue() {
        return this.hash_;
    }

    @Override // com.google.crypto.tink.proto.HkdfPrfParamsOrBuilder
    public final AbstractC0381o getSalt() {
        return this.salt_;
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
