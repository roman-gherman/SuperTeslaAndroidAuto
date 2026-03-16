package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface ActiveRadioNotificationOrBuilder extends MessageLiteOrBuilder {
    int getRadioId();

    RadioStationInfo getStationInfo();

    MessageStatus getStatus();

    boolean hasRadioId();

    boolean hasStationInfo();

    boolean hasStatus();
}
