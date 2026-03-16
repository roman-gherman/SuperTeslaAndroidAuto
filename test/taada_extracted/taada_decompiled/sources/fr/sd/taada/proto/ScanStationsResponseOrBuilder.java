package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface ScanStationsResponseOrBuilder extends MessageLiteOrBuilder {
    int getRadioId();

    boolean getStarted();

    MessageStatus getStatus();

    boolean hasRadioId();

    boolean hasStarted();

    boolean hasStatus();
}
