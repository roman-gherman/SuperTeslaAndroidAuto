package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum WifiProjectionMessageId implements Internal.EnumLite {
    WIFI_MESSAGE_CREDENTIALS_REQUEST(32769),
    WIFI_MESSAGE_CREDENTIALS_RESPONSE(32770);

    public static final int WIFI_MESSAGE_CREDENTIALS_REQUEST_VALUE = 32769;
    public static final int WIFI_MESSAGE_CREDENTIALS_RESPONSE_VALUE = 32770;
    private static final Internal.EnumLiteMap<WifiProjectionMessageId> internalValueMap = new Internal.EnumLiteMap<WifiProjectionMessageId>() { // from class: fr.sd.taada.proto.WifiProjectionMessageId.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public WifiProjectionMessageId findValueByNumber(int i) {
            return WifiProjectionMessageId.forNumber(i);
        }
    };
    private final int value;

    public static final class WifiProjectionMessageIdVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new WifiProjectionMessageIdVerifier();

        private WifiProjectionMessageIdVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return WifiProjectionMessageId.forNumber(i) != null;
        }
    }

    WifiProjectionMessageId(int i) {
        this.value = i;
    }

    public static WifiProjectionMessageId forNumber(int i) {
        switch (i) {
            case 32769:
                return WIFI_MESSAGE_CREDENTIALS_REQUEST;
            case 32770:
                return WIFI_MESSAGE_CREDENTIALS_RESPONSE;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<WifiProjectionMessageId> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return WifiProjectionMessageIdVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static WifiProjectionMessageId valueOf(int i) {
        return forNumber(i);
    }
}
