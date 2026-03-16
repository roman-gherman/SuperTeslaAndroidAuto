package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface CancelRadioOperationsResponseOrBuilder extends MessageLiteOrBuilder {
    int getRadioId();

    MessageStatus getStatus();

    boolean hasRadioId();

    boolean hasStatus();
}
