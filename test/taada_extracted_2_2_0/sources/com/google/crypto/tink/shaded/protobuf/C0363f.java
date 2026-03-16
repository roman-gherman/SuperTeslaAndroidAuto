package com.google.crypto.tink.shaded.protobuf;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0363f extends O implements AnyOrBuilder, EnumValueOrBuilder, FieldOrBuilder, ListValueOrBuilder, MethodOrBuilder, MixinOrBuilder, OptionOrBuilder, SourceContextOrBuilder, StructOrBuilder, ValueOrBuilder {
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0363f(Q q, int i) {
        super(q);
        this.c = i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.StructOrBuilder
    public boolean containsFields(String str) {
        str.getClass();
        return ((G0) this.b).getFieldsMap().containsKey(str);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public boolean getBoolValue() {
        return ((X0) this.b).getBoolValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public H getCardinality() {
        return ((J) this.b).getCardinality();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public int getCardinalityValue() {
        return ((J) this.b).getCardinalityValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public String getDefaultValue() {
        return ((J) this.b).getDefaultValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public AbstractC0381o getDefaultValueBytes() {
        return ((J) this.b).getDefaultValueBytes();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.StructOrBuilder
    public Map getFields() {
        return getFieldsMap();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.StructOrBuilder
    public int getFieldsCount() {
        return ((G0) this.b).getFieldsMap().size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.StructOrBuilder
    public Map getFieldsMap() {
        return Collections.unmodifiableMap(((G0) this.b).getFieldsMap());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.StructOrBuilder
    public X0 getFieldsOrDefault(String str, X0 x02) {
        str.getClass();
        Map fieldsMap = ((G0) this.b).getFieldsMap();
        return fieldsMap.containsKey(str) ? (X0) fieldsMap.get(str) : x02;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.StructOrBuilder
    public X0 getFieldsOrThrow(String str) {
        str.getClass();
        Map fieldsMap = ((G0) this.b).getFieldsMap();
        if (fieldsMap.containsKey(str)) {
            return (X0) fieldsMap.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.SourceContextOrBuilder
    public String getFileName() {
        return ((E0) this.b).getFileName();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.SourceContextOrBuilder
    public AbstractC0381o getFileNameBytes() {
        return ((E0) this.b).getFileNameBytes();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public String getJsonName() {
        return ((J) this.b).getJsonName();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public AbstractC0381o getJsonNameBytes() {
        return ((J) this.b).getJsonNameBytes();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public I getKind() {
        return ((J) this.b).getKind();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public W0 getKindCase() {
        return ((X0) this.b).getKindCase();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public int getKindValue() {
        return ((J) this.b).getKindValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public C0358c0 getListValue() {
        return ((X0) this.b).getListValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumValueOrBuilder
    public String getName() {
        switch (this.c) {
            case 1:
                return ((A) this.b).getName();
            case 2:
                return ((J) this.b).getName();
            case 3:
            default:
                return ((C0389s0) this.b).getName();
            case 4:
                return ((C0380n0) this.b).getName();
            case 5:
                return ((C0382o0) this.b).getName();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumValueOrBuilder
    public AbstractC0381o getNameBytes() {
        switch (this.c) {
            case 1:
                return ((A) this.b).getNameBytes();
            case 2:
                return ((J) this.b).getNameBytes();
            case 3:
            default:
                return ((C0389s0) this.b).getNameBytes();
            case 4:
                return ((C0380n0) this.b).getNameBytes();
            case 5:
                return ((C0382o0) this.b).getNameBytes();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public EnumC0387r0 getNullValue() {
        return ((X0) this.b).getNullValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public int getNullValueValue() {
        return ((X0) this.b).getNullValueValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumValueOrBuilder
    public int getNumber() {
        switch (this.c) {
            case 1:
                return ((A) this.b).getNumber();
            default:
                return ((J) this.b).getNumber();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public double getNumberValue() {
        return ((X0) this.b).getNumberValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public int getOneofIndex() {
        return ((J) this.b).getOneofIndex();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumValueOrBuilder
    public C0389s0 getOptions(int i) {
        switch (this.c) {
            case 1:
                return ((A) this.b).getOptions(i);
            case 2:
                return ((J) this.b).getOptions(i);
            default:
                return ((C0380n0) this.b).getOptions(i);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumValueOrBuilder
    public int getOptionsCount() {
        switch (this.c) {
            case 1:
                return ((A) this.b).getOptionsCount();
            case 2:
                return ((J) this.b).getOptionsCount();
            default:
                return ((C0380n0) this.b).getOptionsCount();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumValueOrBuilder
    public List getOptionsList() {
        switch (this.c) {
            case 1:
                return Collections.unmodifiableList(((A) this.b).getOptionsList());
            case 2:
                return Collections.unmodifiableList(((J) this.b).getOptionsList());
            default:
                return Collections.unmodifiableList(((C0380n0) this.b).getOptionsList());
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public boolean getPacked() {
        return ((J) this.b).getPacked();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public boolean getRequestStreaming() {
        return ((C0380n0) this.b).getRequestStreaming();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public String getRequestTypeUrl() {
        return ((C0380n0) this.b).getRequestTypeUrl();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public AbstractC0381o getRequestTypeUrlBytes() {
        return ((C0380n0) this.b).getRequestTypeUrlBytes();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public boolean getResponseStreaming() {
        return ((C0380n0) this.b).getResponseStreaming();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public String getResponseTypeUrl() {
        return ((C0380n0) this.b).getResponseTypeUrl();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public AbstractC0381o getResponseTypeUrlBytes() {
        return ((C0380n0) this.b).getResponseTypeUrlBytes();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MixinOrBuilder
    public String getRoot() {
        return ((C0382o0) this.b).getRoot();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MixinOrBuilder
    public AbstractC0381o getRootBytes() {
        return ((C0382o0) this.b).getRootBytes();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public String getStringValue() {
        return ((X0) this.b).getStringValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public AbstractC0381o getStringValueBytes() {
        return ((X0) this.b).getStringValueBytes();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public G0 getStructValue() {
        return ((X0) this.b).getStructValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public H0 getSyntax() {
        return ((C0380n0) this.b).getSyntax();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MethodOrBuilder
    public int getSyntaxValue() {
        return ((C0380n0) this.b).getSyntaxValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AnyOrBuilder, com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public String getTypeUrl() {
        switch (this.c) {
            case 0:
                return ((C0365g) this.b).getTypeUrl();
            default:
                return ((J) this.b).getTypeUrl();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AnyOrBuilder, com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public AbstractC0381o getTypeUrlBytes() {
        switch (this.c) {
            case 0:
                return ((C0365g) this.b).getTypeUrlBytes();
            default:
                return ((J) this.b).getTypeUrlBytes();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AnyOrBuilder
    /* JADX INFO: renamed from: getValue, reason: collision with other method in class */
    public AbstractC0381o mo79getValue() {
        return ((C0365g) this.b).mo79getValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ListValueOrBuilder
    public X0 getValues(int i) {
        return ((C0358c0) this.b).getValues(i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ListValueOrBuilder
    public int getValuesCount() {
        return ((C0358c0) this.b).getValuesCount();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ListValueOrBuilder
    public List getValuesList() {
        return Collections.unmodifiableList(((C0358c0) this.b).getValuesList());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public boolean hasBoolValue() {
        return ((X0) this.b).hasBoolValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public boolean hasListValue() {
        return ((X0) this.b).hasListValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public boolean hasNullValue() {
        return ((X0) this.b).hasNullValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public boolean hasNumberValue() {
        return ((X0) this.b).hasNumberValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public boolean hasStringValue() {
        return ((X0) this.b).hasStringValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public boolean hasStructValue() {
        return ((X0) this.b).hasStructValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.OptionOrBuilder
    public boolean hasValue() {
        return ((C0389s0) this.b).hasValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.OptionOrBuilder
    public C0365g getValue() {
        return ((C0389s0) this.b).getValue();
    }
}
