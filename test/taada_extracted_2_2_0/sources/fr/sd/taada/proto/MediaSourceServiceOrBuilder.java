package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface MediaSourceServiceOrBuilder extends MessageLiteOrBuilder {
    AudioConfiguration getAudioConfig();

    MediaCodecType getAvailableType();

    boolean getAvailableWhileInCall();

    boolean hasAudioConfig();

    boolean hasAvailableType();

    boolean hasAvailableWhileInCall();
}
