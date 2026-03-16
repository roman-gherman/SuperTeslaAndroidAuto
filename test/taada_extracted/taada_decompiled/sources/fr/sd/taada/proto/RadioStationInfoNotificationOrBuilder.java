package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface RadioStationInfoNotificationOrBuilder extends MessageLiteOrBuilder {
    int getRadioId();

    RadioStationInfo getStationInfo();

    boolean hasRadioId();

    boolean hasStationInfo();
}
