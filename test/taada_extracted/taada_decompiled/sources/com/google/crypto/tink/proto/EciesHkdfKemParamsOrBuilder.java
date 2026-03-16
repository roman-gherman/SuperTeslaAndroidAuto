package com.google.crypto.tink.proto;

import G0.EnumC0081p0;
import G0.EnumC0086s0;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface EciesHkdfKemParamsOrBuilder extends MessageLiteOrBuilder {
    EnumC0081p0 getCurveType();

    int getCurveTypeValue();

    EnumC0086s0 getHkdfHashType();

    int getHkdfHashTypeValue();

    AbstractC0381o getHkdfSalt();
}
