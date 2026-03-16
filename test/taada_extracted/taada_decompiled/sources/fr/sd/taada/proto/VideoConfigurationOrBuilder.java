package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface VideoConfigurationOrBuilder extends MessageLiteOrBuilder {
    VideoCodecResolutionType getCodecResolution();

    int getDecoderAdditionalDepth();

    int getDensity();

    VideoFrameRateType getFrameRate();

    int getHeightMargin();

    int getPixelAspectRatioE4();

    int getRealDensity();

    UiConfig getUiConfig();

    MediaCodecType getVideoCodecType();

    int getViewingDistance();

    int getWidthMargin();

    boolean hasCodecResolution();

    boolean hasDecoderAdditionalDepth();

    boolean hasDensity();

    boolean hasFrameRate();

    boolean hasHeightMargin();

    boolean hasPixelAspectRatioE4();

    boolean hasRealDensity();

    boolean hasUiConfig();

    boolean hasVideoCodecType();

    boolean hasViewingDistance();

    boolean hasWidthMargin();
}
