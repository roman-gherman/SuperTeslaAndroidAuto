package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum VideoCodecResolutionType implements Internal.EnumLite {
    VIDEO_800x480(1),
    VIDEO_1280x720(2),
    VIDEO_1920x1080(3),
    VIDEO_2560x1440(4),
    VIDEO_3840x2160(5),
    VIDEO_720x1280(6),
    VIDEO_1080x1920(7),
    VIDEO_1440x2560(8),
    VIDEO_2160x3840(9);

    public static final int VIDEO_1080x1920_VALUE = 7;
    public static final int VIDEO_1280x720_VALUE = 2;
    public static final int VIDEO_1440x2560_VALUE = 8;
    public static final int VIDEO_1920x1080_VALUE = 3;
    public static final int VIDEO_2160x3840_VALUE = 9;
    public static final int VIDEO_2560x1440_VALUE = 4;
    public static final int VIDEO_3840x2160_VALUE = 5;
    public static final int VIDEO_720x1280_VALUE = 6;
    public static final int VIDEO_800x480_VALUE = 1;
    private static final Internal.EnumLiteMap<VideoCodecResolutionType> internalValueMap = new Internal.EnumLiteMap<VideoCodecResolutionType>() { // from class: fr.sd.taada.proto.VideoCodecResolutionType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public VideoCodecResolutionType findValueByNumber(int i) {
            return VideoCodecResolutionType.forNumber(i);
        }
    };
    private final int value;

    public static final class VideoCodecResolutionTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new VideoCodecResolutionTypeVerifier();

        private VideoCodecResolutionTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return VideoCodecResolutionType.forNumber(i) != null;
        }
    }

    VideoCodecResolutionType(int i) {
        this.value = i;
    }

    public static VideoCodecResolutionType forNumber(int i) {
        switch (i) {
            case 1:
                return VIDEO_800x480;
            case 2:
                return VIDEO_1280x720;
            case 3:
                return VIDEO_1920x1080;
            case 4:
                return VIDEO_2560x1440;
            case 5:
                return VIDEO_3840x2160;
            case 6:
                return VIDEO_720x1280;
            case 7:
                return VIDEO_1080x1920;
            case 8:
                return VIDEO_1440x2560;
            case 9:
                return VIDEO_2160x3840;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<VideoCodecResolutionType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return VideoCodecResolutionTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static VideoCodecResolutionType valueOf(int i) {
        return forNumber(i);
    }
}
