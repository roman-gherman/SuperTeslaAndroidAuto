package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class X0 extends Q implements ValueOrBuilder {
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    private static final X0 DEFAULT_INSTANCE;
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<X0> PARSER = null;
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    private int kindCase_ = 0;
    private Object kind_;

    static {
        X0 x02 = new X0();
        DEFAULT_INSTANCE = x02;
        Q.q(X0.class, x02);
    }

    public static X0 t() {
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001?\u0000\u00023\u0000\u0003Ȼ\u0000\u0004:\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"kind_", "kindCase_", G0.class, C0358c0.class});
            case 3:
                return new X0();
            case 4:
                return new C0363f(DEFAULT_INSTANCE, 9);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<X0> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (X0.class) {
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

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public final boolean getBoolValue() {
        if (this.kindCase_ == 4) {
            return ((Boolean) this.kind_).booleanValue();
        }
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public final W0 getKindCase() {
        switch (this.kindCase_) {
            case 0:
                return W0.f2861g;
            case 1:
                return W0.f2859a;
            case 2:
                return W0.b;
            case 3:
                return W0.c;
            case 4:
                return W0.d;
            case 5:
                return W0.e;
            case 6:
                return W0.f2860f;
            default:
                return null;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public final C0358c0 getListValue() {
        return this.kindCase_ == 6 ? (C0358c0) this.kind_ : C0358c0.t();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public final EnumC0387r0 getNullValue() {
        int i = this.kindCase_;
        EnumC0387r0 enumC0387r0 = EnumC0387r0.NULL_VALUE;
        if (i == 1) {
            if (((Integer) this.kind_).intValue() != 0) {
                enumC0387r0 = null;
            }
            if (enumC0387r0 == null) {
                return EnumC0387r0.UNRECOGNIZED;
            }
        }
        return enumC0387r0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public final int getNullValueValue() {
        if (this.kindCase_ == 1) {
            return ((Integer) this.kind_).intValue();
        }
        return 0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public final double getNumberValue() {
        if (this.kindCase_ == 2) {
            return ((Double) this.kind_).doubleValue();
        }
        return 0.0d;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public final String getStringValue() {
        return this.kindCase_ == 3 ? (String) this.kind_ : "";
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public final AbstractC0381o getStringValueBytes() {
        return AbstractC0381o.d(this.kindCase_ == 3 ? (String) this.kind_ : "");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public final G0 getStructValue() {
        return this.kindCase_ == 5 ? (G0) this.kind_ : G0.t();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public final boolean hasBoolValue() {
        return this.kindCase_ == 4;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public final boolean hasListValue() {
        return this.kindCase_ == 6;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public final boolean hasNullValue() {
        return this.kindCase_ == 1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public final boolean hasNumberValue() {
        return this.kindCase_ == 2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public final boolean hasStringValue() {
        return this.kindCase_ == 3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public final boolean hasStructValue() {
        return this.kindCase_ == 5;
    }
}
