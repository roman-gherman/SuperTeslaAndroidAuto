package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0365g extends Q implements AnyOrBuilder {
    private static final C0365g DEFAULT_INSTANCE;
    private static volatile Parser<C0365g> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private String typeUrl_ = "";
    private AbstractC0381o value_ = AbstractC0381o.b;

    static {
        C0365g c0365g = new C0365g();
        DEFAULT_INSTANCE = c0365g;
        Q.q(C0365g.class, c0365g);
    }

    public static C0365g t() {
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\n", new Object[]{"typeUrl_", "value_"});
            case 3:
                return new C0365g();
            case 4:
                return new C0363f(DEFAULT_INSTANCE, 0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0365g> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0365g.class) {
                    try {
                        p5 = PARSER;
                        if (p5 == null) {
                            p5 = new P(DEFAULT_INSTANCE);
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

    @Override // com.google.crypto.tink.shaded.protobuf.AnyOrBuilder, com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final String getTypeUrl() {
        return this.typeUrl_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AnyOrBuilder, com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final AbstractC0381o getTypeUrlBytes() {
        return AbstractC0381o.d(this.typeUrl_);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AnyOrBuilder
    /* JADX INFO: renamed from: getValue */
    public final AbstractC0381o mo79getValue() {
        return this.value_;
    }
}
