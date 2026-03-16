package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum GalConstants implements Internal.EnumLite {
    WIFI_PORT(WIFI_PORT_VALUE),
    PROTOCOL_MAJOR_VERSION(1),
    PROTOCOL_MINOR_VERSION(6);

    public static final int PROTOCOL_MAJOR_VERSION_VALUE = 1;
    public static final int PROTOCOL_MINOR_VERSION_VALUE = 6;
    public static final int WIFI_PORT_VALUE = 30515;
    private static final Internal.EnumLiteMap<GalConstants> internalValueMap = new Internal.EnumLiteMap<GalConstants>() { // from class: fr.sd.taada.proto.GalConstants.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public GalConstants findValueByNumber(int i) {
            return GalConstants.forNumber(i);
        }
    };
    private final int value;

    public static final class GalConstantsVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new GalConstantsVerifier();

        private GalConstantsVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return GalConstants.forNumber(i) != null;
        }
    }

    GalConstants(int i) {
        this.value = i;
    }

    public static GalConstants forNumber(int i) {
        if (i == 1) {
            return PROTOCOL_MAJOR_VERSION;
        }
        if (i == 6) {
            return PROTOCOL_MINOR_VERSION;
        }
        if (i != 30515) {
            return null;
        }
        return WIFI_PORT;
    }

    public static Internal.EnumLiteMap<GalConstants> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return GalConstantsVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static GalConstants valueOf(int i) {
        return forNumber(i);
    }
}
