package com.google.crypto.tink.shaded.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class A extends Q implements EnumValueOrBuilder {
    private static final A DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile Parser<A> PARSER;
    private int number_;
    private String name_ = "";
    private Internal$ProtobufList<C0389s0> options_ = C0395v0.d;

    static {
        A a6 = new A();
        DEFAULT_INSTANCE = a6;
        Q.q(A.class, a6);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u0004\u0003\u001b", new Object[]{"name_", "number_", "options_", C0389s0.class});
            case 3:
                return new A();
            case 4:
                return new C0363f(DEFAULT_INSTANCE, 1);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<A> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (A.class) {
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

    @Override // com.google.crypto.tink.shaded.protobuf.EnumValueOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumValueOrBuilder
    public final AbstractC0381o getNameBytes() {
        return AbstractC0381o.d(this.name_);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumValueOrBuilder
    public final int getNumber() {
        return this.number_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumValueOrBuilder
    public final C0389s0 getOptions(int i) {
        return this.options_.get(i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumValueOrBuilder
    public final int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumValueOrBuilder
    public final List getOptionsList() {
        return this.options_;
    }
}
