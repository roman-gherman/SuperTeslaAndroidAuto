package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum VideoFocusReason implements Internal.EnumLite {
    UNKNOWN(0),
    PHONE_SCREEN_OFF(1),
    LAUNCH_NATIVE(2);

    public static final int LAUNCH_NATIVE_VALUE = 2;
    public static final int PHONE_SCREEN_OFF_VALUE = 1;
    public static final int UNKNOWN_VALUE = 0;
    private static final Internal.EnumLiteMap<VideoFocusReason> internalValueMap = new Internal.EnumLiteMap<VideoFocusReason>() { // from class: fr.sd.taada.proto.VideoFocusReason.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public VideoFocusReason findValueByNumber(int i) {
            return VideoFocusReason.forNumber(i);
        }
    };
    private final int value;

    public static final class VideoFocusReasonVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new VideoFocusReasonVerifier();

        private VideoFocusReasonVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return VideoFocusReason.forNumber(i) != null;
        }
    }

    VideoFocusReason(int i) {
        this.value = i;
    }

    public static VideoFocusReason forNumber(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return PHONE_SCREEN_OFF;
        }
        if (i != 2) {
            return null;
        }
        return LAUNCH_NATIVE;
    }

    public static Internal.EnumLiteMap<VideoFocusReason> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return VideoFocusReasonVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static VideoFocusReason valueOf(int i) {
        return forNumber(i);
    }
}
