package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum AudioStreamType implements Internal.EnumLite {
    AUDIO_STREAM_GUIDANCE(1),
    AUDIO_STREAM_SYSTEM_AUDIO(2),
    AUDIO_STREAM_MEDIA(3),
    AUDIO_STREAM_TELEPHONY(4);

    public static final int AUDIO_STREAM_GUIDANCE_VALUE = 1;
    public static final int AUDIO_STREAM_MEDIA_VALUE = 3;
    public static final int AUDIO_STREAM_SYSTEM_AUDIO_VALUE = 2;
    public static final int AUDIO_STREAM_TELEPHONY_VALUE = 4;
    private static final Internal.EnumLiteMap<AudioStreamType> internalValueMap = new Internal.EnumLiteMap<AudioStreamType>() { // from class: fr.sd.taada.proto.AudioStreamType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public AudioStreamType findValueByNumber(int i) {
            return AudioStreamType.forNumber(i);
        }
    };
    private final int value;

    public static final class AudioStreamTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new AudioStreamTypeVerifier();

        private AudioStreamTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return AudioStreamType.forNumber(i) != null;
        }
    }

    AudioStreamType(int i) {
        this.value = i;
    }

    public static AudioStreamType forNumber(int i) {
        if (i == 1) {
            return AUDIO_STREAM_GUIDANCE;
        }
        if (i == 2) {
            return AUDIO_STREAM_SYSTEM_AUDIO;
        }
        if (i == 3) {
            return AUDIO_STREAM_MEDIA;
        }
        if (i != 4) {
            return null;
        }
        return AUDIO_STREAM_TELEPHONY;
    }

    public static Internal.EnumLiteMap<AudioStreamType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return AudioStreamTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static AudioStreamType valueOf(int i) {
        return forNumber(i);
    }
}
