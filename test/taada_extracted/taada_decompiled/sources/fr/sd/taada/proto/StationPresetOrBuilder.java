package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface StationPresetOrBuilder extends MessageLiteOrBuilder {
    int getChannel();

    int getSubChannel();

    RadioType getType();

    boolean hasChannel();

    boolean hasSubChannel();

    boolean hasType();
}
