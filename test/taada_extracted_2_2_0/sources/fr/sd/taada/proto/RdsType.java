package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum RdsType implements Internal.EnumLite {
    NO_RDS(0),
    RDS(1),
    RBDS(2);

    public static final int NO_RDS_VALUE = 0;
    public static final int RBDS_VALUE = 2;
    public static final int RDS_VALUE = 1;
    private static final Internal.EnumLiteMap<RdsType> internalValueMap = new Internal.EnumLiteMap<RdsType>() { // from class: fr.sd.taada.proto.RdsType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public RdsType findValueByNumber(int i) {
            return RdsType.forNumber(i);
        }
    };
    private final int value;

    public static final class RdsTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new RdsTypeVerifier();

        private RdsTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return RdsType.forNumber(i) != null;
        }
    }

    RdsType(int i) {
        this.value = i;
    }

    public static RdsType forNumber(int i) {
        if (i == 0) {
            return NO_RDS;
        }
        if (i == 1) {
            return RDS;
        }
        if (i != 2) {
            return null;
        }
        return RBDS;
    }

    public static Internal.EnumLiteMap<RdsType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return RdsTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static RdsType valueOf(int i) {
        return forNumber(i);
    }
}
