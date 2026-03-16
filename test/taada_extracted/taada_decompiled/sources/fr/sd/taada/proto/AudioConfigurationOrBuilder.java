package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface AudioConfigurationOrBuilder extends MessageLiteOrBuilder {
    int getNumberOfBits();

    int getNumberOfChannels();

    int getSamplingRate();

    boolean hasNumberOfBits();

    boolean hasNumberOfChannels();

    boolean hasSamplingRate();
}
