package com.google.crypto.tink.shaded.protobuf;

import java.util.List;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0358c0 extends Q implements ListValueOrBuilder {
    private static final C0358c0 DEFAULT_INSTANCE;
    private static volatile Parser<C0358c0> PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private Internal$ProtobufList<X0> values_ = C0395v0.d;

    static {
        C0358c0 c0358c0 = new C0358c0();
        DEFAULT_INSTANCE = c0358c0;
        Q.q(C0358c0.class, c0358c0);
    }

    public static C0358c0 t() {
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"values_", X0.class});
            case 3:
                return new C0358c0();
            case 4:
                return new C0363f(DEFAULT_INSTANCE, 3);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<C0358c0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (C0358c0.class) {
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

    @Override // com.google.crypto.tink.shaded.protobuf.ListValueOrBuilder
    public final X0 getValues(int i) {
        return this.values_.get(i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ListValueOrBuilder
    public final int getValuesCount() {
        return this.values_.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ListValueOrBuilder
    public final List getValuesList() {
        return this.values_;
    }
}
