package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum DrivingStatus implements Internal.EnumLite {
    DRIVE_STATUS_UNRESTRICTED(0),
    DRIVE_STATUS_NO_VIDEO(1),
    DRIVE_STATUS_NO_KEYBOARD_INPUT(2),
    DRIVE_STATUS_NO_VOICE_INPUT(4),
    DRIVE_STATUS_NO_CONFIG(8),
    DRIVE_STATUS_LIMIT_MESSAGE_LEN(16);

    public static final int DRIVE_STATUS_LIMIT_MESSAGE_LEN_VALUE = 16;
    public static final int DRIVE_STATUS_NO_CONFIG_VALUE = 8;
    public static final int DRIVE_STATUS_NO_KEYBOARD_INPUT_VALUE = 2;
    public static final int DRIVE_STATUS_NO_VIDEO_VALUE = 1;
    public static final int DRIVE_STATUS_NO_VOICE_INPUT_VALUE = 4;
    public static final int DRIVE_STATUS_UNRESTRICTED_VALUE = 0;
    private static final Internal.EnumLiteMap<DrivingStatus> internalValueMap = new Internal.EnumLiteMap<DrivingStatus>() { // from class: fr.sd.taada.proto.DrivingStatus.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public DrivingStatus findValueByNumber(int i) {
            return DrivingStatus.forNumber(i);
        }
    };
    private final int value;

    public static final class DrivingStatusVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new DrivingStatusVerifier();

        private DrivingStatusVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return DrivingStatus.forNumber(i) != null;
        }
    }

    DrivingStatus(int i) {
        this.value = i;
    }

    public static DrivingStatus forNumber(int i) {
        if (i == 0) {
            return DRIVE_STATUS_UNRESTRICTED;
        }
        if (i == 1) {
            return DRIVE_STATUS_NO_VIDEO;
        }
        if (i == 2) {
            return DRIVE_STATUS_NO_KEYBOARD_INPUT;
        }
        if (i == 4) {
            return DRIVE_STATUS_NO_VOICE_INPUT;
        }
        if (i == 8) {
            return DRIVE_STATUS_NO_CONFIG;
        }
        if (i != 16) {
            return null;
        }
        return DRIVE_STATUS_LIMIT_MESSAGE_LEN;
    }

    public static Internal.EnumLiteMap<DrivingStatus> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return DrivingStatusVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static DrivingStatus valueOf(int i) {
        return forNumber(i);
    }
}
