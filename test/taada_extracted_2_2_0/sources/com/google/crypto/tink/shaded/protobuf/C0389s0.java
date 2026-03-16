package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.s0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0389s0 extends Q implements OptionOrBuilder {
    private static final C0389s0 DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<C0389s0> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;
    private String name_ = "";
    private C0365g value_;

    static {
        C0389s0 c0389s0 = new C0389s0();
        DEFAULT_INSTANCE = c0389s0;
        Q.q(C0389s0.class, c0389s0);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"name_", "value_"});
            case 3:
                return new C0389s0();
            case 4:
                return new C0363f(DEFAULT_INSTANCE, 6);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0389s0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0389s0.class) {
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

    @Override // com.google.crypto.tink.shaded.protobuf.OptionOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.OptionOrBuilder
    public final AbstractC0381o getNameBytes() {
        return AbstractC0381o.d(this.name_);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.OptionOrBuilder
    public final C0365g getValue() {
        C0365g c0365g = this.value_;
        return c0365g == null ? C0365g.t() : c0365g;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.OptionOrBuilder
    public final boolean hasValue() {
        return this.value_ != null;
    }
}
