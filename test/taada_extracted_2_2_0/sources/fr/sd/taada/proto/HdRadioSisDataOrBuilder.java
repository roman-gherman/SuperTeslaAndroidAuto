package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface HdRadioSisDataOrBuilder extends MessageLiteOrBuilder {
    String getServiceInfoMessage();

    ByteString getServiceInfoMessageBytes();

    int getStationId();

    Location getStationLocation();

    String getStationMessage();

    ByteString getStationMessageBytes();

    String getStationNameLong();

    ByteString getStationNameLongBytes();

    String getStationNameShort();

    ByteString getStationNameShortBytes();

    String getUniversalShortStationNameSlogan();

    ByteString getUniversalShortStationNameSloganBytes();

    boolean hasServiceInfoMessage();

    boolean hasStationId();

    boolean hasStationLocation();

    boolean hasStationMessage();

    boolean hasStationNameLong();

    boolean hasStationNameShort();

    boolean hasUniversalShortStationNameSlogan();
}
