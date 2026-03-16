package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface ScanStationsRequestOrBuilder extends MessageLiteOrBuilder {
    int getRadioId();

    boolean getSkipSubChannel();

    boolean getStart();

    boolean getUp();

    boolean hasRadioId();

    boolean hasSkipSubChannel();

    boolean hasStart();

    boolean hasUp();
}
