package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum VideoFocusMode implements Internal.EnumLite {
    VIDEO_FOCUS_PROJECTED(1),
    VIDEO_FOCUS_NATIVE(2),
    VIDEO_FOCUS_NATIVE_TRANSIENT(3),
    VIDEO_FOCUS_PROJECTED_NO_INPUT_FOCUS(4);

    public static final int VIDEO_FOCUS_NATIVE_TRANSIENT_VALUE = 3;
    public static final int VIDEO_FOCUS_NATIVE_VALUE = 2;
    public static final int VIDEO_FOCUS_PROJECTED_NO_INPUT_FOCUS_VALUE = 4;
    public static final int VIDEO_FOCUS_PROJECTED_VALUE = 1;
    private static final Internal.EnumLiteMap<VideoFocusMode> internalValueMap = new Internal.EnumLiteMap<VideoFocusMode>() { // from class: fr.sd.taada.proto.VideoFocusMode.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public VideoFocusMode findValueByNumber(int i) {
            return VideoFocusMode.forNumber(i);
        }
    };
    private final int value;

    public static final class VideoFocusModeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new VideoFocusModeVerifier();

        private VideoFocusModeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return VideoFocusMode.forNumber(i) != null;
        }
    }

    VideoFocusMode(int i) {
        this.value = i;
    }

    public static VideoFocusMode forNumber(int i) {
        if (i == 1) {
            return VIDEO_FOCUS_PROJECTED;
        }
        if (i == 2) {
            return VIDEO_FOCUS_NATIVE;
        }
        if (i == 3) {
            return VIDEO_FOCUS_NATIVE_TRANSIENT;
        }
        if (i != 4) {
            return null;
        }
        return VIDEO_FOCUS_PROJECTED_NO_INPUT_FOCUS;
    }

    public static Internal.EnumLiteMap<VideoFocusMode> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return VideoFocusModeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static VideoFocusMode valueOf(int i) {
        return forNumber(i);
    }
}
