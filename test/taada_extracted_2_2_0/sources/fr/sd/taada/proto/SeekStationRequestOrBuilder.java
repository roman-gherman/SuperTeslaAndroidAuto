package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface SeekStationRequestOrBuilder extends MessageLiteOrBuilder {
    int getRadioId();

    boolean getSkipSubChannel();

    boolean getUp();

    boolean hasRadioId();

    boolean hasSkipSubChannel();

    boolean hasUp();
}
