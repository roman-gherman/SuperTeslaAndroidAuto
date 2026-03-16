package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum DisplayType implements Internal.EnumLite {
    DISPLAY_TYPE_MAIN(0),
    DISPLAY_TYPE_CLUSTER(1),
    DISPLAY_TYPE_AUXILIARY(2);

    public static final int DISPLAY_TYPE_AUXILIARY_VALUE = 2;
    public static final int DISPLAY_TYPE_CLUSTER_VALUE = 1;
    public static final int DISPLAY_TYPE_MAIN_VALUE = 0;
    private static final Internal.EnumLiteMap<DisplayType> internalValueMap = new Internal.EnumLiteMap<DisplayType>() { // from class: fr.sd.taada.proto.DisplayType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public DisplayType findValueByNumber(int i) {
            return DisplayType.forNumber(i);
        }
    };
    private final int value;

    public static final class DisplayTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new DisplayTypeVerifier();

        private DisplayTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return DisplayType.forNumber(i) != null;
        }
    }

    DisplayType(int i) {
        this.value = i;
    }

    public static DisplayType forNumber(int i) {
        if (i == 0) {
            return DISPLAY_TYPE_MAIN;
        }
        if (i == 1) {
            return DISPLAY_TYPE_CLUSTER;
        }
        if (i != 2) {
            return null;
        }
        return DISPLAY_TYPE_AUXILIARY;
    }

    public static Internal.EnumLiteMap<DisplayType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return DisplayTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static DisplayType valueOf(int i) {
        return forNumber(i);
    }
}
