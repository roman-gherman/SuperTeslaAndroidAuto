package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum AccessPointType implements Internal.EnumLite {
    STATIC(0),
    DYNAMIC(1);

    public static final int DYNAMIC_VALUE = 1;
    public static final int STATIC_VALUE = 0;
    private static final Internal.EnumLiteMap<AccessPointType> internalValueMap = new Internal.EnumLiteMap<AccessPointType>() { // from class: fr.sd.taada.proto.AccessPointType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public AccessPointType findValueByNumber(int i) {
            return AccessPointType.forNumber(i);
        }
    };
    private final int value;

    public static final class AccessPointTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new AccessPointTypeVerifier();

        private AccessPointTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return AccessPointType.forNumber(i) != null;
        }
    }

    AccessPointType(int i) {
        this.value = i;
    }

    public static AccessPointType forNumber(int i) {
        if (i == 0) {
            return STATIC;
        }
        if (i != 1) {
            return null;
        }
        return DYNAMIC;
    }

    public static Internal.EnumLiteMap<AccessPointType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return AccessPointTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static AccessPointType valueOf(int i) {
        return forNumber(i);
    }
}
