package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum MediaBrowserMessageId implements Internal.EnumLite {
    MEDIA_ROOT_NODE(32769),
    MEDIA_SOURCE_NODE(32770),
    MEDIA_LIST_NODE(32771),
    MEDIA_SONG_NODE(32772),
    MEDIA_GET_NODE(32773),
    MEDIA_BROWSE_INPUT(32774);

    public static final int MEDIA_BROWSE_INPUT_VALUE = 32774;
    public static final int MEDIA_GET_NODE_VALUE = 32773;
    public static final int MEDIA_LIST_NODE_VALUE = 32771;
    public static final int MEDIA_ROOT_NODE_VALUE = 32769;
    public static final int MEDIA_SONG_NODE_VALUE = 32772;
    public static final int MEDIA_SOURCE_NODE_VALUE = 32770;
    private static final Internal.EnumLiteMap<MediaBrowserMessageId> internalValueMap = new Internal.EnumLiteMap<MediaBrowserMessageId>() { // from class: fr.sd.taada.proto.MediaBrowserMessageId.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public MediaBrowserMessageId findValueByNumber(int i) {
            return MediaBrowserMessageId.forNumber(i);
        }
    };
    private final int value;

    public static final class MediaBrowserMessageIdVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new MediaBrowserMessageIdVerifier();

        private MediaBrowserMessageIdVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return MediaBrowserMessageId.forNumber(i) != null;
        }
    }

    MediaBrowserMessageId(int i) {
        this.value = i;
    }

    public static MediaBrowserMessageId forNumber(int i) {
        switch (i) {
            case 32769:
                return MEDIA_ROOT_NODE;
            case 32770:
                return MEDIA_SOURCE_NODE;
            case 32771:
                return MEDIA_LIST_NODE;
            case 32772:
                return MEDIA_SONG_NODE;
            case 32773:
                return MEDIA_GET_NODE;
            case 32774:
                return MEDIA_BROWSE_INPUT;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<MediaBrowserMessageId> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return MediaBrowserMessageIdVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static MediaBrowserMessageId valueOf(int i) {
        return forNumber(i);
    }
}
