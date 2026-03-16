package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum AudioFocusRequestType implements Internal.EnumLite {
    AUDIO_FOCUS_GAIN(1),
    AUDIO_FOCUS_GAIN_TRANSIENT(2),
    AUDIO_FOCUS_GAIN_TRANSIENT_MAY_DUCK(3),
    AUDIO_FOCUS_RELEASE(4);

    public static final int AUDIO_FOCUS_GAIN_TRANSIENT_MAY_DUCK_VALUE = 3;
    public static final int AUDIO_FOCUS_GAIN_TRANSIENT_VALUE = 2;
    public static final int AUDIO_FOCUS_GAIN_VALUE = 1;
    public static final int AUDIO_FOCUS_RELEASE_VALUE = 4;
    private static final Internal.EnumLiteMap<AudioFocusRequestType> internalValueMap = new Internal.EnumLiteMap<AudioFocusRequestType>() { // from class: fr.sd.taada.proto.AudioFocusRequestType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public AudioFocusRequestType findValueByNumber(int i) {
            return AudioFocusRequestType.forNumber(i);
        }
    };
    private final int value;

    public static final class AudioFocusRequestTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new AudioFocusRequestTypeVerifier();

        private AudioFocusRequestTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return AudioFocusRequestType.forNumber(i) != null;
        }
    }

    AudioFocusRequestType(int i) {
        this.value = i;
    }

    public static AudioFocusRequestType forNumber(int i) {
        if (i == 1) {
            return AUDIO_FOCUS_GAIN;
        }
        if (i == 2) {
            return AUDIO_FOCUS_GAIN_TRANSIENT;
        }
        if (i == 3) {
            return AUDIO_FOCUS_GAIN_TRANSIENT_MAY_DUCK;
        }
        if (i != 4) {
            return null;
        }
        return AUDIO_FOCUS_RELEASE;
    }

    public static Internal.EnumLiteMap<AudioFocusRequestType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return AudioFocusRequestTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static AudioFocusRequestType valueOf(int i) {
        return forNumber(i);
    }
}
