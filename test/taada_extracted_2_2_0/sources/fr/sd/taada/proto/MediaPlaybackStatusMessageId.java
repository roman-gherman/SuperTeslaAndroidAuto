package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum MediaPlaybackStatusMessageId implements Internal.EnumLite {
    MEDIA_PLAYBACK_STATUS(32769),
    MEDIA_PLAYBACK_INPUT(32770),
    MEDIA_PLAYBACK_METADATA(32771);

    public static final int MEDIA_PLAYBACK_INPUT_VALUE = 32770;
    public static final int MEDIA_PLAYBACK_METADATA_VALUE = 32771;
    public static final int MEDIA_PLAYBACK_STATUS_VALUE = 32769;
    private static final Internal.EnumLiteMap<MediaPlaybackStatusMessageId> internalValueMap = new Internal.EnumLiteMap<MediaPlaybackStatusMessageId>() { // from class: fr.sd.taada.proto.MediaPlaybackStatusMessageId.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public MediaPlaybackStatusMessageId findValueByNumber(int i) {
            return MediaPlaybackStatusMessageId.forNumber(i);
        }
    };
    private final int value;

    public static final class MediaPlaybackStatusMessageIdVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new MediaPlaybackStatusMessageIdVerifier();

        private MediaPlaybackStatusMessageIdVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return MediaPlaybackStatusMessageId.forNumber(i) != null;
        }
    }

    MediaPlaybackStatusMessageId(int i) {
        this.value = i;
    }

    public static MediaPlaybackStatusMessageId forNumber(int i) {
        switch (i) {
            case 32769:
                return MEDIA_PLAYBACK_STATUS;
            case 32770:
                return MEDIA_PLAYBACK_INPUT;
            case 32771:
                return MEDIA_PLAYBACK_METADATA;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<MediaPlaybackStatusMessageId> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return MediaPlaybackStatusMessageIdVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static MediaPlaybackStatusMessageId valueOf(int i) {
        return forNumber(i);
    }
}
