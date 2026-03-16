package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import fr.sd.taada.proto.MediaPlaybackStatus;

/* JADX INFO: loaded from: classes2.dex */
public interface MediaPlaybackStatusOrBuilder extends MessageLiteOrBuilder {
    String getMediaSource();

    ByteString getMediaSourceBytes();

    int getPlaybackSeconds();

    boolean getRepeat();

    boolean getRepeatOne();

    boolean getShuffle();

    MediaPlaybackStatus.State getState();

    boolean hasMediaSource();

    boolean hasPlaybackSeconds();

    boolean hasRepeat();

    boolean hasRepeatOne();

    boolean hasShuffle();

    boolean hasState();
}
