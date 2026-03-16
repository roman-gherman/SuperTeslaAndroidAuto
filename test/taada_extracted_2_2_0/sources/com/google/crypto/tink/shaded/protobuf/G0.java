package com.google.crypto.tink.shaded.protobuf;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class G0 extends Q implements StructOrBuilder {
    private static final G0 DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static volatile Parser<G0> PARSER;
    private C0368h0 fields_ = C0368h0.b;

    static {
        G0 g0 = new G0();
        DEFAULT_INSTANCE = g0;
        Q.q(G0.class, g0);
    }

    public static G0 t() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.StructOrBuilder
    public final boolean containsFields(String str) {
        str.getClass();
        return this.fields_.containsKey(str);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"fields_", F0.f2812a});
            case 3:
                return new G0();
            case 4:
                return new C0363f(DEFAULT_INSTANCE, 8);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<G0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (G0.class) {
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

    @Override // com.google.crypto.tink.shaded.protobuf.StructOrBuilder
    public final Map getFields() {
        return Collections.unmodifiableMap(this.fields_);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.StructOrBuilder
    public final int getFieldsCount() {
        return this.fields_.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.StructOrBuilder
    public final Map getFieldsMap() {
        return Collections.unmodifiableMap(this.fields_);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.StructOrBuilder
    public final X0 getFieldsOrDefault(String str, X0 x02) {
        str.getClass();
        C0368h0 c0368h0 = this.fields_;
        return c0368h0.containsKey(str) ? (X0) c0368h0.get(str) : x02;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.StructOrBuilder
    public final X0 getFieldsOrThrow(String str) {
        str.getClass();
        C0368h0 c0368h0 = this.fields_;
        if (c0368h0.containsKey(str)) {
            return (X0) c0368h0.get(str);
        }
        throw new IllegalArgumentException();
    }
}
