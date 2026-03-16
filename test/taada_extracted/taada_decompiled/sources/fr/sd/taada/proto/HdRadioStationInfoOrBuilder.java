package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface HdRadioStationInfoOrBuilder extends MessageLiteOrBuilder {
    HdAcquisionState getAcquisitionState();

    int getDigitalSignalStrength();

    HdRadioPsdData getPsd();

    HdRadioSisData getSis();

    boolean hasAcquisitionState();

    boolean hasDigitalSignalStrength();

    boolean hasPsd();

    boolean hasSis();
}
