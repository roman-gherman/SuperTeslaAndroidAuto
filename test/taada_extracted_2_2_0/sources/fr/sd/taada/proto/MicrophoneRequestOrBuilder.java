package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface MicrophoneRequestOrBuilder extends MessageLiteOrBuilder {
    boolean getAncEnabled();

    boolean getEcEnabled();

    int getMaxUnacked();

    boolean getOpen();

    boolean hasAncEnabled();

    boolean hasEcEnabled();

    boolean hasMaxUnacked();

    boolean hasOpen();
}
