package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum WifiSecurityMode implements Internal.EnumLite {
    UNKNOWN_SECURITY_MODE(0),
    OPEN(1),
    WEP_64(2),
    WEP_128(3),
    WPA_PERSONAL(4),
    WPA2_PERSONAL(5),
    WPA_WPA2_PERSONAL(6),
    WPA_ENTERPRISE(7),
    WPA2_ENTERPRISE(8),
    WPA_WPA2_ENTERPRISE(9);

    public static final int OPEN_VALUE = 1;
    public static final int UNKNOWN_SECURITY_MODE_VALUE = 0;
    public static final int WEP_128_VALUE = 3;
    public static final int WEP_64_VALUE = 2;
    public static final int WPA2_ENTERPRISE_VALUE = 8;
    public static final int WPA2_PERSONAL_VALUE = 5;
    public static final int WPA_ENTERPRISE_VALUE = 7;
    public static final int WPA_PERSONAL_VALUE = 4;
    public static final int WPA_WPA2_ENTERPRISE_VALUE = 9;
    public static final int WPA_WPA2_PERSONAL_VALUE = 6;
    private static final Internal.EnumLiteMap<WifiSecurityMode> internalValueMap = new Internal.EnumLiteMap<WifiSecurityMode>() { // from class: fr.sd.taada.proto.WifiSecurityMode.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public WifiSecurityMode findValueByNumber(int i) {
            return WifiSecurityMode.forNumber(i);
        }
    };
    private final int value;

    public static final class WifiSecurityModeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new WifiSecurityModeVerifier();

        private WifiSecurityModeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return WifiSecurityMode.forNumber(i) != null;
        }
    }

    WifiSecurityMode(int i) {
        this.value = i;
    }

    public static WifiSecurityMode forNumber(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_SECURITY_MODE;
            case 1:
                return OPEN;
            case 2:
                return WEP_64;
            case 3:
                return WEP_128;
            case 4:
                return WPA_PERSONAL;
            case 5:
                return WPA2_PERSONAL;
            case 6:
                return WPA_WPA2_PERSONAL;
            case 7:
                return WPA_ENTERPRISE;
            case 8:
                return WPA2_ENTERPRISE;
            case 9:
                return WPA_WPA2_ENTERPRISE;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<WifiSecurityMode> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return WifiSecurityModeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static WifiSecurityMode valueOf(int i) {
        return forNumber(i);
    }
}
