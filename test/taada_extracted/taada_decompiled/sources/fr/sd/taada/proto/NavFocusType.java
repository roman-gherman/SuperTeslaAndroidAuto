package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum NavFocusType implements Internal.EnumLite {
    NAV_FOCUS_NATIVE(1),
    NAV_FOCUS_PROJECTED(2);

    public static final int NAV_FOCUS_NATIVE_VALUE = 1;
    public static final int NAV_FOCUS_PROJECTED_VALUE = 2;
    private static final Internal.EnumLiteMap<NavFocusType> internalValueMap = new Internal.EnumLiteMap<NavFocusType>() { // from class: fr.sd.taada.proto.NavFocusType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public NavFocusType findValueByNumber(int i) {
            return NavFocusType.forNumber(i);
        }
    };
    private final int value;

    public static final class NavFocusTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new NavFocusTypeVerifier();

        private NavFocusTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return NavFocusType.forNumber(i) != null;
        }
    }

    NavFocusType(int i) {
        this.value = i;
    }

    public static NavFocusType forNumber(int i) {
        if (i == 1) {
            return NAV_FOCUS_NATIVE;
        }
        if (i != 2) {
            return null;
        }
        return NAV_FOCUS_PROJECTED;
    }

    public static Internal.EnumLiteMap<NavFocusType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return NavFocusTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static NavFocusType valueOf(int i) {
        return forNumber(i);
    }
}
