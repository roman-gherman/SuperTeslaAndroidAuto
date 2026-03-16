package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum GalVerificationVendorExtensionMessageId implements Internal.EnumLite {
    GAL_VERIFICATION_SET_SENSOR(32769),
    GAL_VERIFICATION_MEDIA_SINK_STATUS(32770),
    GAL_VERIFICATION_VIDEO_FOCUS(32771),
    GAL_VERIFICATION_AUDIO_FOCUS(32772),
    GAL_VERIFICATION_INJECT_INPUT(32773),
    GAL_VERIFICATION_BUG_REPORT_REQUEST(32774),
    GAL_VERIFICATION_BUG_REPORT_RESPONSE(32775),
    GAL_VERIFICATION_SCREEN_CAPTURE_REQUEST(32776),
    GAL_VERIFICATION_SCREEN_CAPTURE_RESPONSE(32777),
    GAL_VERIFICATION_DISPLAY_INFORMATION_REQUEST(32778),
    GAL_VERIFICATION_DISPLAY_INFORMATION_RESPONSE(32779);

    public static final int GAL_VERIFICATION_AUDIO_FOCUS_VALUE = 32772;
    public static final int GAL_VERIFICATION_BUG_REPORT_REQUEST_VALUE = 32774;
    public static final int GAL_VERIFICATION_BUG_REPORT_RESPONSE_VALUE = 32775;
    public static final int GAL_VERIFICATION_DISPLAY_INFORMATION_REQUEST_VALUE = 32778;
    public static final int GAL_VERIFICATION_DISPLAY_INFORMATION_RESPONSE_VALUE = 32779;
    public static final int GAL_VERIFICATION_INJECT_INPUT_VALUE = 32773;
    public static final int GAL_VERIFICATION_MEDIA_SINK_STATUS_VALUE = 32770;
    public static final int GAL_VERIFICATION_SCREEN_CAPTURE_REQUEST_VALUE = 32776;
    public static final int GAL_VERIFICATION_SCREEN_CAPTURE_RESPONSE_VALUE = 32777;
    public static final int GAL_VERIFICATION_SET_SENSOR_VALUE = 32769;
    public static final int GAL_VERIFICATION_VIDEO_FOCUS_VALUE = 32771;
    private static final Internal.EnumLiteMap<GalVerificationVendorExtensionMessageId> internalValueMap = new Internal.EnumLiteMap<GalVerificationVendorExtensionMessageId>() { // from class: fr.sd.taada.proto.GalVerificationVendorExtensionMessageId.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public GalVerificationVendorExtensionMessageId findValueByNumber(int i) {
            return GalVerificationVendorExtensionMessageId.forNumber(i);
        }
    };
    private final int value;

    public static final class GalVerificationVendorExtensionMessageIdVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new GalVerificationVendorExtensionMessageIdVerifier();

        private GalVerificationVendorExtensionMessageIdVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return GalVerificationVendorExtensionMessageId.forNumber(i) != null;
        }
    }

    GalVerificationVendorExtensionMessageId(int i) {
        this.value = i;
    }

    public static GalVerificationVendorExtensionMessageId forNumber(int i) {
        switch (i) {
            case 32769:
                return GAL_VERIFICATION_SET_SENSOR;
            case 32770:
                return GAL_VERIFICATION_MEDIA_SINK_STATUS;
            case 32771:
                return GAL_VERIFICATION_VIDEO_FOCUS;
            case 32772:
                return GAL_VERIFICATION_AUDIO_FOCUS;
            case 32773:
                return GAL_VERIFICATION_INJECT_INPUT;
            case 32774:
                return GAL_VERIFICATION_BUG_REPORT_REQUEST;
            case 32775:
                return GAL_VERIFICATION_BUG_REPORT_RESPONSE;
            case 32776:
                return GAL_VERIFICATION_SCREEN_CAPTURE_REQUEST;
            case 32777:
                return GAL_VERIFICATION_SCREEN_CAPTURE_RESPONSE;
            case 32778:
                return GAL_VERIFICATION_DISPLAY_INFORMATION_REQUEST;
            case 32779:
                return GAL_VERIFICATION_DISPLAY_INFORMATION_RESPONSE;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<GalVerificationVendorExtensionMessageId> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return GalVerificationVendorExtensionMessageIdVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static GalVerificationVendorExtensionMessageId valueOf(int i) {
        return forNumber(i);
    }
}
