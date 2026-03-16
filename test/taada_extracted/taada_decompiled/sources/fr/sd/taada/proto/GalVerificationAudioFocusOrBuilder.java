package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface GalVerificationAudioFocusOrBuilder extends MessageLiteOrBuilder {
    AudioFocusStateType getAudioFocusState();

    int getChannel();

    boolean getUnsolicited();

    boolean hasAudioFocusState();

    boolean hasChannel();

    boolean hasUnsolicited();
}
