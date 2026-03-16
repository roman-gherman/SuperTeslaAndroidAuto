package com.google.crypto.tink.proto;

import G0.EnumC0048e0;
import G0.EnumC0081p0;
import G0.EnumC0086s0;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface EcdsaParamsOrBuilder extends MessageLiteOrBuilder {
    EnumC0081p0 getCurve();

    int getCurveValue();

    EnumC0048e0 getEncoding();

    int getEncodingValue();

    EnumC0086s0 getHashType();

    int getHashTypeValue();
}
