package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum VideoFrameRateType implements Internal.EnumLite {
    VIDEO_FPS_60(1),
    VIDEO_FPS_30(2);

    public static final int VIDEO_FPS_30_VALUE = 2;
    public static final int VIDEO_FPS_60_VALUE = 1;
    private static final Internal.EnumLiteMap<VideoFrameRateType> internalValueMap = new Internal.EnumLiteMap<VideoFrameRateType>() { // from class: fr.sd.taada.proto.VideoFrameRateType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public VideoFrameRateType findValueByNumber(int i) {
            return VideoFrameRateType.forNumber(i);
        }
    };
    private final int value;

    public static final class VideoFrameRateTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new VideoFrameRateTypeVerifier();

        private VideoFrameRateTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return VideoFrameRateType.forNumber(i) != null;
        }
    }

    VideoFrameRateType(int i) {
        this.value = i;
    }

    public static VideoFrameRateType forNumber(int i) {
        if (i == 1) {
            return VIDEO_FPS_60;
        }
        if (i != 2) {
            return null;
        }
        return VIDEO_FPS_30;
    }

    public static Internal.EnumLiteMap<VideoFrameRateType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return VideoFrameRateTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static VideoFrameRateType valueOf(int i) {
        return forNumber(i);
    }
}
