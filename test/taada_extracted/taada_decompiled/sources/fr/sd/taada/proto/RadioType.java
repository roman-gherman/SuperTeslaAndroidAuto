package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum RadioType implements Internal.EnumLite {
    AM_RADIO(0),
    FM_RADIO(1),
    AM_HD_RADIO(2),
    FM_HD_RADIO(3),
    DAB_RADIO(4),
    XM_RADIO(5);

    public static final int AM_HD_RADIO_VALUE = 2;
    public static final int AM_RADIO_VALUE = 0;
    public static final int DAB_RADIO_VALUE = 4;
    public static final int FM_HD_RADIO_VALUE = 3;
    public static final int FM_RADIO_VALUE = 1;
    public static final int XM_RADIO_VALUE = 5;
    private static final Internal.EnumLiteMap<RadioType> internalValueMap = new Internal.EnumLiteMap<RadioType>() { // from class: fr.sd.taada.proto.RadioType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public RadioType findValueByNumber(int i) {
            return RadioType.forNumber(i);
        }
    };
    private final int value;

    public static final class RadioTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new RadioTypeVerifier();

        private RadioTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return RadioType.forNumber(i) != null;
        }
    }

    RadioType(int i) {
        this.value = i;
    }

    public static RadioType forNumber(int i) {
        if (i == 0) {
            return AM_RADIO;
        }
        if (i == 1) {
            return FM_RADIO;
        }
        if (i == 2) {
            return AM_HD_RADIO;
        }
        if (i == 3) {
            return FM_HD_RADIO;
        }
        if (i == 4) {
            return DAB_RADIO;
        }
        if (i != 5) {
            return null;
        }
        return XM_RADIO;
    }

    public static Internal.EnumLiteMap<RadioType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return RadioTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static RadioType valueOf(int i) {
        return forNumber(i);
    }
}
