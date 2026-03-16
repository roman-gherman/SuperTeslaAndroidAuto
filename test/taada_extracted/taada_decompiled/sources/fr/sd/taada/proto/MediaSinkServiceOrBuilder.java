package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface MediaSinkServiceOrBuilder extends MessageLiteOrBuilder {
    AudioConfiguration getAudioConfigs(int i);

    int getAudioConfigsCount();

    List<AudioConfiguration> getAudioConfigsList();

    AudioStreamType getAudioType();

    MediaCodecType getAvailableType();

    boolean getAvailableWhileInCall();

    int getDisplayId();

    DisplayType getDisplayType();

    KeyCode getInitialContentKeycode();

    VideoConfiguration getVideoConfigs(int i);

    int getVideoConfigsCount();

    List<VideoConfiguration> getVideoConfigsList();

    boolean hasAudioType();

    boolean hasAvailableType();

    boolean hasAvailableWhileInCall();

    boolean hasDisplayId();

    boolean hasDisplayType();

    boolean hasInitialContentKeycode();
}
