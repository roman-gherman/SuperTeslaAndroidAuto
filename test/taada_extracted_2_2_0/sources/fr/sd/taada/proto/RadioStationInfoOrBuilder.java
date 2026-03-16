package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface RadioStationInfoOrBuilder extends MessageLiteOrBuilder {
    int getChannel();

    RadioStationMetaData getMetaData();

    int getSubChannel();

    RadioType getType();

    boolean hasChannel();

    boolean hasMetaData();

    boolean hasSubChannel();

    boolean hasType();
}
