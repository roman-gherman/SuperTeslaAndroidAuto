package com.google.crypto.tink.proto;

import G0.C0054g0;
import G0.C0072m0;
import G0.Z;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface EciesAeadHkdfParamsOrBuilder extends MessageLiteOrBuilder {
    C0054g0 getDemParams();

    Z getEcPointFormat();

    int getEcPointFormatValue();

    C0072m0 getKemParams();

    boolean hasDemParams();

    boolean hasKemParams();
}
