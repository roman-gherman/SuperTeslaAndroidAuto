package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface ConfigureChannelSpacingResponseOrBuilder extends MessageLiteOrBuilder {
    int getChannelSpacing();

    int getRadioId();

    MessageStatus getStatus();

    boolean hasChannelSpacing();

    boolean hasRadioId();

    boolean hasStatus();
}
