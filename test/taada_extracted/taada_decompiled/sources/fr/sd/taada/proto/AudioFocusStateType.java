package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum AudioFocusStateType implements Internal.EnumLite {
    AUDIO_FOCUS_STATE_INVALID(0),
    AUDIO_FOCUS_STATE_GAIN(1),
    AUDIO_FOCUS_STATE_GAIN_TRANSIENT(2),
    AUDIO_FOCUS_STATE_LOSS(3),
    AUDIO_FOCUS_STATE_LOSS_TRANSIENT_CAN_DUCK(4),
    AUDIO_FOCUS_STATE_LOSS_TRANSIENT(5),
    AUDIO_FOCUS_STATE_GAIN_MEDIA_ONLY(6),
    AUDIO_FOCUS_STATE_GAIN_TRANSIENT_GUIDANCE_ONLY(7);

    public static final int AUDIO_FOCUS_STATE_GAIN_MEDIA_ONLY_VALUE = 6;
    public static final int AUDIO_FOCUS_STATE_GAIN_TRANSIENT_GUIDANCE_ONLY_VALUE = 7;
    public static final int AUDIO_FOCUS_STATE_GAIN_TRANSIENT_VALUE = 2;
    public static final int AUDIO_FOCUS_STATE_GAIN_VALUE = 1;
    public static final int AUDIO_FOCUS_STATE_INVALID_VALUE = 0;
    public static final int AUDIO_FOCUS_STATE_LOSS_TRANSIENT_CAN_DUCK_VALUE = 4;
    public static final int AUDIO_FOCUS_STATE_LOSS_TRANSIENT_VALUE = 5;
    public static final int AUDIO_FOCUS_STATE_LOSS_VALUE = 3;
    private static final Internal.EnumLiteMap<AudioFocusStateType> internalValueMap = new Internal.EnumLiteMap<AudioFocusStateType>() { // from class: fr.sd.taada.proto.AudioFocusStateType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public AudioFocusStateType findValueByNumber(int i) {
            return AudioFocusStateType.forNumber(i);
        }
    };
    private final int value;

    public static final class AudioFocusStateTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new AudioFocusStateTypeVerifier();

        private AudioFocusStateTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return AudioFocusStateType.forNumber(i) != null;
        }
    }

    AudioFocusStateType(int i) {
        this.value = i;
    }

    public static AudioFocusStateType forNumber(int i) {
        switch (i) {
            case 0:
                return AUDIO_FOCUS_STATE_INVALID;
            case 1:
                return AUDIO_FOCUS_STATE_GAIN;
            case 2:
                return AUDIO_FOCUS_STATE_GAIN_TRANSIENT;
            case 3:
                return AUDIO_FOCUS_STATE_LOSS;
            case 4:
                return AUDIO_FOCUS_STATE_LOSS_TRANSIENT_CAN_DUCK;
            case 5:
                return AUDIO_FOCUS_STATE_LOSS_TRANSIENT;
            case 6:
                return AUDIO_FOCUS_STATE_GAIN_MEDIA_ONLY;
            case 7:
                return AUDIO_FOCUS_STATE_GAIN_TRANSIENT_GUIDANCE_ONLY;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<AudioFocusStateType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return AudioFocusStateTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static AudioFocusStateType valueOf(int i) {
        return forNumber(i);
    }
}
