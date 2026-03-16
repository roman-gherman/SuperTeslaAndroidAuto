package com.google.crypto.tink.shaded.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class J extends Q implements FieldOrBuilder {
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    private static final J DEFAULT_INSTANCE;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    public static final int PACKED_FIELD_NUMBER = 8;
    private static volatile Parser<J> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    private int cardinality_;
    private int kind_;
    private int number_;
    private int oneofIndex_;
    private boolean packed_;
    private String name_ = "";
    private String typeUrl_ = "";
    private Internal$ProtobufList<C0389s0> options_ = C0395v0.d;
    private String jsonName_ = "";
    private String defaultValue_ = "";

    static {
        J j6 = new J();
        DEFAULT_INSTANCE = j6;
        Q.q(J.class, j6);
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
                return new C0397w0(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\u000b\n\u0000\u0001\u0000\u0001\f\u0002\f\u0003\u0004\u0004Ȉ\u0006Ȉ\u0007\u0004\b\u0007\t\u001b\nȈ\u000bȈ", new Object[]{"kind_", "cardinality_", "number_", "name_", "typeUrl_", "oneofIndex_", "packed_", "options_", C0389s0.class, "jsonName_", "defaultValue_"});
            case 3:
                return new J();
            case 4:
                return new C0363f(DEFAULT_INSTANCE, 2);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<J> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (J.class) {
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

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final H getCardinality() {
        int i = this.cardinality_;
        H h3 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : H.CARDINALITY_REPEATED : H.CARDINALITY_REQUIRED : H.CARDINALITY_OPTIONAL : H.CARDINALITY_UNKNOWN;
        return h3 == null ? H.UNRECOGNIZED : h3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final int getCardinalityValue() {
        return this.cardinality_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final String getDefaultValue() {
        return this.defaultValue_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final AbstractC0381o getDefaultValueBytes() {
        return AbstractC0381o.d(this.defaultValue_);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final String getJsonName() {
        return this.jsonName_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final AbstractC0381o getJsonNameBytes() {
        return AbstractC0381o.d(this.jsonName_);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final I getKind() {
        I i;
        switch (this.kind_) {
            case 0:
                i = I.TYPE_UNKNOWN;
                break;
            case 1:
                i = I.TYPE_DOUBLE;
                break;
            case 2:
                i = I.TYPE_FLOAT;
                break;
            case 3:
                i = I.TYPE_INT64;
                break;
            case 4:
                i = I.TYPE_UINT64;
                break;
            case 5:
                i = I.TYPE_INT32;
                break;
            case 6:
                i = I.TYPE_FIXED64;
                break;
            case 7:
                i = I.TYPE_FIXED32;
                break;
            case 8:
                i = I.TYPE_BOOL;
                break;
            case 9:
                i = I.TYPE_STRING;
                break;
            case 10:
                i = I.TYPE_GROUP;
                break;
            case 11:
                i = I.TYPE_MESSAGE;
                break;
            case 12:
                i = I.TYPE_BYTES;
                break;
            case 13:
                i = I.TYPE_UINT32;
                break;
            case 14:
                i = I.TYPE_ENUM;
                break;
            case 15:
                i = I.TYPE_SFIXED32;
                break;
            case 16:
                i = I.TYPE_SFIXED64;
                break;
            case 17:
                i = I.TYPE_SINT32;
                break;
            case 18:
                i = I.TYPE_SINT64;
                break;
            default:
                i = null;
                break;
        }
        return i == null ? I.UNRECOGNIZED : i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final int getKindValue() {
        return this.kind_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final AbstractC0381o getNameBytes() {
        return AbstractC0381o.d(this.name_);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final int getNumber() {
        return this.number_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final int getOneofIndex() {
        return this.oneofIndex_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final C0389s0 getOptions(int i) {
        return this.options_.get(i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final List getOptionsList() {
        return this.options_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final boolean getPacked() {
        return this.packed_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final String getTypeUrl() {
        return this.typeUrl_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public final AbstractC0381o getTypeUrlBytes() {
        return AbstractC0381o.d(this.typeUrl_);
    }
}
