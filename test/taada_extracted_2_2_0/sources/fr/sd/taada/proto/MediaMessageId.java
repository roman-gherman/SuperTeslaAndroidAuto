package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum MediaMessageId implements Internal.EnumLite {
    MEDIA_MESSAGE_DATA(0),
    MEDIA_MESSAGE_CODEC_CONFIG(1),
    MEDIA_MESSAGE_SETUP(32768),
    MEDIA_MESSAGE_START(32769),
    MEDIA_MESSAGE_STOP(32770),
    MEDIA_MESSAGE_CONFIG(32771),
    MEDIA_MESSAGE_ACK(32772),
    MEDIA_MESSAGE_MICROPHONE_REQUEST(32773),
    MEDIA_MESSAGE_MICROPHONE_RESPONSE(32774),
    MEDIA_MESSAGE_VIDEO_FOCUS_REQUEST(32775),
    MEDIA_MESSAGE_VIDEO_FOCUS_NOTIFICATION(32776),
    MEDIA_MESSAGE_UPDATE_UI_CONFIG_REQUEST(32777),
    MEDIA_MESSAGE_UPDATE_UI_CONFIG_REPLY(32778),
    MEDIA_MESSAGE_AUDIO_UNDERFLOW_NOTIFICATION(32779);

    public static final int MEDIA_MESSAGE_ACK_VALUE = 32772;
    public static final int MEDIA_MESSAGE_AUDIO_UNDERFLOW_NOTIFICATION_VALUE = 32779;
    public static final int MEDIA_MESSAGE_CODEC_CONFIG_VALUE = 1;
    public static final int MEDIA_MESSAGE_CONFIG_VALUE = 32771;
    public static final int MEDIA_MESSAGE_DATA_VALUE = 0;
    public static final int MEDIA_MESSAGE_MICROPHONE_REQUEST_VALUE = 32773;
    public static final int MEDIA_MESSAGE_MICROPHONE_RESPONSE_VALUE = 32774;
    public static final int MEDIA_MESSAGE_SETUP_VALUE = 32768;
    public static final int MEDIA_MESSAGE_START_VALUE = 32769;
    public static final int MEDIA_MESSAGE_STOP_VALUE = 32770;
    public static final int MEDIA_MESSAGE_UPDATE_UI_CONFIG_REPLY_VALUE = 32778;
    public static final int MEDIA_MESSAGE_UPDATE_UI_CONFIG_REQUEST_VALUE = 32777;
    public static final int MEDIA_MESSAGE_VIDEO_FOCUS_NOTIFICATION_VALUE = 32776;
    public static final int MEDIA_MESSAGE_VIDEO_FOCUS_REQUEST_VALUE = 32775;
    private static final Internal.EnumLiteMap<MediaMessageId> internalValueMap = new Internal.EnumLiteMap<MediaMessageId>() { // from class: fr.sd.taada.proto.MediaMessageId.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public MediaMessageId findValueByNumber(int i) {
            return MediaMessageId.forNumber(i);
        }
    };
    private final int value;

    public static final class MediaMessageIdVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new MediaMessageIdVerifier();

        private MediaMessageIdVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return MediaMessageId.forNumber(i) != null;
        }
    }

    MediaMessageId(int i) {
        this.value = i;
    }

    public static MediaMessageId forNumber(int i) {
        if (i == 0) {
            return MEDIA_MESSAGE_DATA;
        }
        if (i == 1) {
            return MEDIA_MESSAGE_CODEC_CONFIG;
        }
        switch (i) {
            case 32768:
                return MEDIA_MESSAGE_SETUP;
            case 32769:
                return MEDIA_MESSAGE_START;
            case 32770:
                return MEDIA_MESSAGE_STOP;
            case 32771:
                return MEDIA_MESSAGE_CONFIG;
            case 32772:
                return MEDIA_MESSAGE_ACK;
            case 32773:
                return MEDIA_MESSAGE_MICROPHONE_REQUEST;
            case 32774:
                return MEDIA_MESSAGE_MICROPHONE_RESPONSE;
            case 32775:
                return MEDIA_MESSAGE_VIDEO_FOCUS_REQUEST;
            case 32776:
                return MEDIA_MESSAGE_VIDEO_FOCUS_NOTIFICATION;
            case 32777:
                return MEDIA_MESSAGE_UPDATE_UI_CONFIG_REQUEST;
            case 32778:
                return MEDIA_MESSAGE_UPDATE_UI_CONFIG_REPLY;
            case 32779:
                return MEDIA_MESSAGE_AUDIO_UNDERFLOW_NOTIFICATION;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<MediaMessageId> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return MediaMessageIdVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static MediaMessageId valueOf(int i) {
        return forNumber(i);
    }
}
