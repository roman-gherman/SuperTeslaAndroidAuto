package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface RadioStationMetaDataOrBuilder extends MessageLiteOrBuilder {
    int getAudioChannels();

    HdRadioStationInfo getHdStationInfo();

    RdsData getRds();

    int getSignalQuality();

    boolean hasAudioChannels();

    boolean hasHdStationInfo();

    boolean hasRds();

    boolean hasSignalQuality();
}
