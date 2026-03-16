package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum MediaCodecType implements Internal.EnumLite {
    MEDIA_CODEC_AUDIO_PCM(1),
    MEDIA_CODEC_AUDIO_AAC_LC(2),
    MEDIA_CODEC_VIDEO_H264_BP(3),
    MEDIA_CODEC_AUDIO_AAC_LC_ADTS(4),
    MEDIA_CODEC_VIDEO_VP9(5),
    MEDIA_CODEC_VIDEO_AV1(6),
    MEDIA_CODEC_VIDEO_H265(7);

    public static final int MEDIA_CODEC_AUDIO_AAC_LC_ADTS_VALUE = 4;
    public static final int MEDIA_CODEC_AUDIO_AAC_LC_VALUE = 2;
    public static final int MEDIA_CODEC_AUDIO_PCM_VALUE = 1;
    public static final int MEDIA_CODEC_VIDEO_AV1_VALUE = 6;
    public static final int MEDIA_CODEC_VIDEO_H264_BP_VALUE = 3;
    public static final int MEDIA_CODEC_VIDEO_H265_VALUE = 7;
    public static final int MEDIA_CODEC_VIDEO_VP9_VALUE = 5;
    private static final Internal.EnumLiteMap<MediaCodecType> internalValueMap = new Internal.EnumLiteMap<MediaCodecType>() { // from class: fr.sd.taada.proto.MediaCodecType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public MediaCodecType findValueByNumber(int i) {
            return MediaCodecType.forNumber(i);
        }
    };
    private final int value;

    public static final class MediaCodecTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new MediaCodecTypeVerifier();

        private MediaCodecTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return MediaCodecType.forNumber(i) != null;
        }
    }

    MediaCodecType(int i) {
        this.value = i;
    }

    public static MediaCodecType forNumber(int i) {
        switch (i) {
            case 1:
                return MEDIA_CODEC_AUDIO_PCM;
            case 2:
                return MEDIA_CODEC_AUDIO_AAC_LC;
            case 3:
                return MEDIA_CODEC_VIDEO_H264_BP;
            case 4:
                return MEDIA_CODEC_AUDIO_AAC_LC_ADTS;
            case 5:
                return MEDIA_CODEC_VIDEO_VP9;
            case 6:
                return MEDIA_CODEC_VIDEO_AV1;
            case 7:
                return MEDIA_CODEC_VIDEO_H265;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<MediaCodecType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return MediaCodecTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static MediaCodecType valueOf(int i) {
        return forNumber(i);
    }
}
