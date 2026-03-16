package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum ItuRegion implements Internal.EnumLite {
    RADIO_REGION_NONE(0),
    RADIO_REGION_ITU_1(1),
    RADIO_REGION_ITU_2(2),
    RADIO_REGION_OIRT(3),
    RADIO_REGION_JAPAN(4),
    RADIO_REGION_KOREA(5);

    public static final int RADIO_REGION_ITU_1_VALUE = 1;
    public static final int RADIO_REGION_ITU_2_VALUE = 2;
    public static final int RADIO_REGION_JAPAN_VALUE = 4;
    public static final int RADIO_REGION_KOREA_VALUE = 5;
    public static final int RADIO_REGION_NONE_VALUE = 0;
    public static final int RADIO_REGION_OIRT_VALUE = 3;
    private static final Internal.EnumLiteMap<ItuRegion> internalValueMap = new Internal.EnumLiteMap<ItuRegion>() { // from class: fr.sd.taada.proto.ItuRegion.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public ItuRegion findValueByNumber(int i) {
            return ItuRegion.forNumber(i);
        }
    };
    private final int value;

    public static final class ItuRegionVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new ItuRegionVerifier();

        private ItuRegionVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return ItuRegion.forNumber(i) != null;
        }
    }

    ItuRegion(int i) {
        this.value = i;
    }

    public static ItuRegion forNumber(int i) {
        if (i == 0) {
            return RADIO_REGION_NONE;
        }
        if (i == 1) {
            return RADIO_REGION_ITU_1;
        }
        if (i == 2) {
            return RADIO_REGION_ITU_2;
        }
        if (i == 3) {
            return RADIO_REGION_OIRT;
        }
        if (i == 4) {
            return RADIO_REGION_JAPAN;
        }
        if (i != 5) {
            return null;
        }
        return RADIO_REGION_KOREA;
    }

    public static Internal.EnumLiteMap<ItuRegion> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return ItuRegionVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static ItuRegion valueOf(int i) {
        return forNumber(i);
    }
}
