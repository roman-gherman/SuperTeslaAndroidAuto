package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface MuteRadioResponseOrBuilder extends MessageLiteOrBuilder {
    boolean getMuted();

    int getRadioId();

    MessageStatus getStatus();

    boolean hasMuted();

    boolean hasRadioId();

    boolean hasStatus();
}
