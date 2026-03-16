package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.UiConfig;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class VideoConfiguration extends GeneratedMessageLite<VideoConfiguration, Builder> implements VideoConfigurationOrBuilder {
    public static final int CODEC_RESOLUTION_FIELD_NUMBER = 1;
    public static final int DECODER_ADDITIONAL_DEPTH_FIELD_NUMBER = 6;
    private static final VideoConfiguration DEFAULT_INSTANCE;
    public static final int DENSITY_FIELD_NUMBER = 5;
    public static final int FRAME_RATE_FIELD_NUMBER = 2;
    public static final int HEIGHT_MARGIN_FIELD_NUMBER = 4;
    private static volatile Parser<VideoConfiguration> PARSER = null;
    public static final int PIXEL_ASPECT_RATIO_E4_FIELD_NUMBER = 8;
    public static final int REAL_DENSITY_FIELD_NUMBER = 9;
    public static final int UI_CONFIG_FIELD_NUMBER = 11;
    public static final int VIDEO_CODEC_TYPE_FIELD_NUMBER = 10;
    public static final int VIEWING_DISTANCE_FIELD_NUMBER = 7;
    public static final int WIDTH_MARGIN_FIELD_NUMBER = 3;
    private int bitField0_;
    private int decoderAdditionalDepth_;
    private int density_;
    private int heightMargin_;
    private int pixelAspectRatioE4_;
    private int realDensity_;
    private UiConfig uiConfig_;
    private int viewingDistance_;
    private int widthMargin_;
    private int codecResolution_ = 1;
    private int frameRate_ = 1;
    private int videoCodecType_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.VideoConfiguration$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<VideoConfiguration, Builder> implements VideoConfigurationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCodecResolution() {
            copyOnWrite();
            ((VideoConfiguration) this.instance).clearCodecResolution();
            return this;
        }

        public Builder clearDecoderAdditionalDepth() {
            copyOnWrite();
            ((VideoConfiguration) this.instance).clearDecoderAdditionalDepth();
            return this;
        }

        public Builder clearDensity() {
            copyOnWrite();
            ((VideoConfiguration) this.instance).clearDensity();
            return this;
        }

        public Builder clearFrameRate() {
            copyOnWrite();
            ((VideoConfiguration) this.instance).clearFrameRate();
            return this;
        }

        public Builder clearHeightMargin() {
            copyOnWrite();
            ((VideoConfiguration) this.instance).clearHeightMargin();
            return this;
        }

        public Builder clearPixelAspectRatioE4() {
            copyOnWrite();
            ((VideoConfiguration) this.instance).clearPixelAspectRatioE4();
            return this;
        }

        public Builder clearRealDensity() {
            copyOnWrite();
            ((VideoConfiguration) this.instance).clearRealDensity();
            return this;
        }

        public Builder clearUiConfig() {
            copyOnWrite();
            ((VideoConfiguration) this.instance).clearUiConfig();
            return this;
        }

        public Builder clearVideoCodecType() {
            copyOnWrite();
            ((VideoConfiguration) this.instance).clearVideoCodecType();
            return this;
        }

        public Builder clearViewingDistance() {
            copyOnWrite();
            ((VideoConfiguration) this.instance).clearViewingDistance();
            return this;
        }

        public Builder clearWidthMargin() {
            copyOnWrite();
            ((VideoConfiguration) this.instance).clearWidthMargin();
            return this;
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public VideoCodecResolutionType getCodecResolution() {
            return ((VideoConfiguration) this.instance).getCodecResolution();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public int getDecoderAdditionalDepth() {
            return ((VideoConfiguration) this.instance).getDecoderAdditionalDepth();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public int getDensity() {
            return ((VideoConfiguration) this.instance).getDensity();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public VideoFrameRateType getFrameRate() {
            return ((VideoConfiguration) this.instance).getFrameRate();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public int getHeightMargin() {
            return ((VideoConfiguration) this.instance).getHeightMargin();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public int getPixelAspectRatioE4() {
            return ((VideoConfiguration) this.instance).getPixelAspectRatioE4();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public int getRealDensity() {
            return ((VideoConfiguration) this.instance).getRealDensity();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public UiConfig getUiConfig() {
            return ((VideoConfiguration) this.instance).getUiConfig();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public MediaCodecType getVideoCodecType() {
            return ((VideoConfiguration) this.instance).getVideoCodecType();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public int getViewingDistance() {
            return ((VideoConfiguration) this.instance).getViewingDistance();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public int getWidthMargin() {
            return ((VideoConfiguration) this.instance).getWidthMargin();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public boolean hasCodecResolution() {
            return ((VideoConfiguration) this.instance).hasCodecResolution();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public boolean hasDecoderAdditionalDepth() {
            return ((VideoConfiguration) this.instance).hasDecoderAdditionalDepth();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public boolean hasDensity() {
            return ((VideoConfiguration) this.instance).hasDensity();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public boolean hasFrameRate() {
            return ((VideoConfiguration) this.instance).hasFrameRate();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public boolean hasHeightMargin() {
            return ((VideoConfiguration) this.instance).hasHeightMargin();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public boolean hasPixelAspectRatioE4() {
            return ((VideoConfiguration) this.instance).hasPixelAspectRatioE4();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public boolean hasRealDensity() {
            return ((VideoConfiguration) this.instance).hasRealDensity();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public boolean hasUiConfig() {
            return ((VideoConfiguration) this.instance).hasUiConfig();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public boolean hasVideoCodecType() {
            return ((VideoConfiguration) this.instance).hasVideoCodecType();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public boolean hasViewingDistance() {
            return ((VideoConfiguration) this.instance).hasViewingDistance();
        }

        @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
        public boolean hasWidthMargin() {
            return ((VideoConfiguration) this.instance).hasWidthMargin();
        }

        public Builder mergeUiConfig(UiConfig uiConfig) {
            copyOnWrite();
            ((VideoConfiguration) this.instance).mergeUiConfig(uiConfig);
            return this;
        }

        public Builder setCodecResolution(VideoCodecResolutionType videoCodecResolutionType) {
            copyOnWrite();
            ((VideoConfiguration) this.instance).setCodecResolution(videoCodecResolutionType);
            return this;
        }

        public Builder setDecoderAdditionalDepth(int i) {
            copyOnWrite();
            ((VideoConfiguration) this.instance).setDecoderAdditionalDepth(i);
            return this;
        }

        public Builder setDensity(int i) {
            copyOnWrite();
            ((VideoConfiguration) this.instance).setDensity(i);
            return this;
        }

        public Builder setFrameRate(VideoFrameRateType videoFrameRateType) {
            copyOnWrite();
            ((VideoConfiguration) this.instance).setFrameRate(videoFrameRateType);
            return this;
        }

        public Builder setHeightMargin(int i) {
            copyOnWrite();
            ((VideoConfiguration) this.instance).setHeightMargin(i);
            return this;
        }

        public Builder setPixelAspectRatioE4(int i) {
            copyOnWrite();
            ((VideoConfiguration) this.instance).setPixelAspectRatioE4(i);
            return this;
        }

        public Builder setRealDensity(int i) {
            copyOnWrite();
            ((VideoConfiguration) this.instance).setRealDensity(i);
            return this;
        }

        public Builder setUiConfig(UiConfig uiConfig) {
            copyOnWrite();
            ((VideoConfiguration) this.instance).setUiConfig(uiConfig);
            return this;
        }

        public Builder setVideoCodecType(MediaCodecType mediaCodecType) {
            copyOnWrite();
            ((VideoConfiguration) this.instance).setVideoCodecType(mediaCodecType);
            return this;
        }

        public Builder setViewingDistance(int i) {
            copyOnWrite();
            ((VideoConfiguration) this.instance).setViewingDistance(i);
            return this;
        }

        public Builder setWidthMargin(int i) {
            copyOnWrite();
            ((VideoConfiguration) this.instance).setWidthMargin(i);
            return this;
        }

        private Builder() {
            super(VideoConfiguration.DEFAULT_INSTANCE);
        }

        public Builder setUiConfig(UiConfig.Builder builder) {
            copyOnWrite();
            ((VideoConfiguration) this.instance).setUiConfig(builder);
            return this;
        }
    }

    static {
        VideoConfiguration videoConfiguration = new VideoConfiguration();
        DEFAULT_INSTANCE = videoConfiguration;
        GeneratedMessageLite.registerDefaultInstance(VideoConfiguration.class, videoConfiguration);
    }

    private VideoConfiguration() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCodecResolution() {
        this.bitField0_ &= -2;
        this.codecResolution_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDecoderAdditionalDepth() {
        this.bitField0_ &= -33;
        this.decoderAdditionalDepth_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDensity() {
        this.bitField0_ &= -17;
        this.density_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFrameRate() {
        this.bitField0_ &= -3;
        this.frameRate_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeightMargin() {
        this.bitField0_ &= -9;
        this.heightMargin_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPixelAspectRatioE4() {
        this.bitField0_ &= -129;
        this.pixelAspectRatioE4_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRealDensity() {
        this.bitField0_ &= -257;
        this.realDensity_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUiConfig() {
        this.uiConfig_ = null;
        this.bitField0_ &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVideoCodecType() {
        this.bitField0_ &= -513;
        this.videoCodecType_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearViewingDistance() {
        this.bitField0_ &= -65;
        this.viewingDistance_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWidthMargin() {
        this.bitField0_ &= -5;
        this.widthMargin_ = 0;
    }

    public static VideoConfiguration getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUiConfig(UiConfig uiConfig) {
        uiConfig.getClass();
        UiConfig uiConfig2 = this.uiConfig_;
        if (uiConfig2 == null || uiConfig2 == UiConfig.getDefaultInstance()) {
            this.uiConfig_ = uiConfig;
        } else {
            this.uiConfig_ = UiConfig.newBuilder(this.uiConfig_).mergeFrom(uiConfig).buildPartial();
        }
        this.bitField0_ |= 1024;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static VideoConfiguration parseDelimitedFrom(InputStream inputStream) {
        return (VideoConfiguration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VideoConfiguration parseFrom(ByteBuffer byteBuffer) {
        return (VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<VideoConfiguration> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCodecResolution(VideoCodecResolutionType videoCodecResolutionType) {
        videoCodecResolutionType.getClass();
        this.bitField0_ |= 1;
        this.codecResolution_ = videoCodecResolutionType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDecoderAdditionalDepth(int i) {
        this.bitField0_ |= 32;
        this.decoderAdditionalDepth_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDensity(int i) {
        this.bitField0_ |= 16;
        this.density_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFrameRate(VideoFrameRateType videoFrameRateType) {
        videoFrameRateType.getClass();
        this.bitField0_ |= 2;
        this.frameRate_ = videoFrameRateType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeightMargin(int i) {
        this.bitField0_ |= 8;
        this.heightMargin_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPixelAspectRatioE4(int i) {
        this.bitField0_ |= 128;
        this.pixelAspectRatioE4_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRealDensity(int i) {
        this.bitField0_ |= 256;
        this.realDensity_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUiConfig(UiConfig uiConfig) {
        uiConfig.getClass();
        this.uiConfig_ = uiConfig;
        this.bitField0_ |= 1024;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoCodecType(MediaCodecType mediaCodecType) {
        mediaCodecType.getClass();
        this.bitField0_ |= 512;
        this.videoCodecType_ = mediaCodecType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewingDistance(int i) {
        this.bitField0_ |= 64;
        this.viewingDistance_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidthMargin(int i) {
        this.bitField0_ |= 4;
        this.widthMargin_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new VideoConfiguration();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\u000b\u0002\u0004\u000b\u0003\u0005\u000b\u0004\u0006\u000b\u0005\u0007\u000b\u0006\b\u000b\u0007\t\u000b\b\n\f\t\u000b\t\n", new Object[]{"bitField0_", "codecResolution_", VideoCodecResolutionType.internalGetVerifier(), "frameRate_", VideoFrameRateType.internalGetVerifier(), "widthMargin_", "heightMargin_", "density_", "decoderAdditionalDepth_", "viewingDistance_", "pixelAspectRatioE4_", "realDensity_", "videoCodecType_", MediaCodecType.internalGetVerifier(), "uiConfig_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<VideoConfiguration> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (VideoConfiguration.class) {
                    try {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public VideoCodecResolutionType getCodecResolution() {
        VideoCodecResolutionType videoCodecResolutionTypeForNumber = VideoCodecResolutionType.forNumber(this.codecResolution_);
        return videoCodecResolutionTypeForNumber == null ? VideoCodecResolutionType.VIDEO_800x480 : videoCodecResolutionTypeForNumber;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public int getDecoderAdditionalDepth() {
        return this.decoderAdditionalDepth_;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public int getDensity() {
        return this.density_;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public VideoFrameRateType getFrameRate() {
        VideoFrameRateType videoFrameRateTypeForNumber = VideoFrameRateType.forNumber(this.frameRate_);
        return videoFrameRateTypeForNumber == null ? VideoFrameRateType.VIDEO_FPS_60 : videoFrameRateTypeForNumber;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public int getHeightMargin() {
        return this.heightMargin_;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public int getPixelAspectRatioE4() {
        return this.pixelAspectRatioE4_;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public int getRealDensity() {
        return this.realDensity_;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public UiConfig getUiConfig() {
        UiConfig uiConfig = this.uiConfig_;
        return uiConfig == null ? UiConfig.getDefaultInstance() : uiConfig;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public MediaCodecType getVideoCodecType() {
        MediaCodecType mediaCodecTypeForNumber = MediaCodecType.forNumber(this.videoCodecType_);
        return mediaCodecTypeForNumber == null ? MediaCodecType.MEDIA_CODEC_AUDIO_PCM : mediaCodecTypeForNumber;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public int getViewingDistance() {
        return this.viewingDistance_;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public int getWidthMargin() {
        return this.widthMargin_;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public boolean hasCodecResolution() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public boolean hasDecoderAdditionalDepth() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public boolean hasDensity() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public boolean hasFrameRate() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public boolean hasHeightMargin() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public boolean hasPixelAspectRatioE4() {
        return (this.bitField0_ & 128) != 0;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public boolean hasRealDensity() {
        return (this.bitField0_ & 256) != 0;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public boolean hasUiConfig() {
        return (this.bitField0_ & 1024) != 0;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public boolean hasVideoCodecType() {
        return (this.bitField0_ & 512) != 0;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public boolean hasViewingDistance() {
        return (this.bitField0_ & 64) != 0;
    }

    @Override // fr.sd.taada.proto.VideoConfigurationOrBuilder
    public boolean hasWidthMargin() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(VideoConfiguration videoConfiguration) {
        return DEFAULT_INSTANCE.createBuilder(videoConfiguration);
    }

    public static VideoConfiguration parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VideoConfiguration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VideoConfiguration parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static VideoConfiguration parseFrom(ByteString byteString) {
        return (VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static VideoConfiguration parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUiConfig(UiConfig.Builder builder) {
        this.uiConfig_ = builder.build();
        this.bitField0_ |= 1024;
    }

    public static VideoConfiguration parseFrom(byte[] bArr) {
        return (VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VideoConfiguration parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static VideoConfiguration parseFrom(InputStream inputStream) {
        return (VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VideoConfiguration parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VideoConfiguration parseFrom(CodedInputStream codedInputStream) {
        return (VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static VideoConfiguration parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VideoConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
