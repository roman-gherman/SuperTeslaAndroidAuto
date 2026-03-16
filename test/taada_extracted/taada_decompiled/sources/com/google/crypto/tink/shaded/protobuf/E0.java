package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class E0 extends Q implements SourceContextOrBuilder {
    private static final E0 DEFAULT_INSTANCE;
    public static final int FILE_NAME_FIELD_NUMBER = 1;
    private static volatile Parser<E0> PARSER;
    private String fileName_ = "";

    static {
        E0 e02 = new E0();
        DEFAULT_INSTANCE = e02;
        Q.q(E0.class, e02);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"fileName_"});
            case 3:
                return new E0();
            case 4:
                return new C0363f(DEFAULT_INSTANCE, 7);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<E0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (E0.class) {
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

    @Override // com.google.crypto.tink.shaded.protobuf.SourceContextOrBuilder
    public final String getFileName() {
        return this.fileName_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.SourceContextOrBuilder
    public final AbstractC0381o getFileNameBytes() {
        return AbstractC0381o.d(this.fileName_);
    }
}
