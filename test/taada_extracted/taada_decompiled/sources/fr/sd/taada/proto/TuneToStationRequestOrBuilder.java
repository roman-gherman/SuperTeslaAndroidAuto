package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface TuneToStationRequestOrBuilder extends MessageLiteOrBuilder {
    int getChannel();

    int getRadioId();

    int getSubChannel();

    boolean hasChannel();

    boolean hasRadioId();

    boolean hasSubChannel();
}
