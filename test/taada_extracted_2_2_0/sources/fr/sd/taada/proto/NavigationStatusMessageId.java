package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum NavigationStatusMessageId implements Internal.EnumLite {
    INSTRUMENT_CLUSTER_START(32769),
    INSTRUMENT_CLUSTER_STOP(32770),
    INSTRUMENT_CLUSTER_NAVIGATION_STATUS(32771),
    INSTRUMENT_CLUSTER_NAVIGATION_TURN_EVENT(32772),
    INSTRUMENT_CLUSTER_NAVIGATION_DISTANCE_EVENT(32773),
    INSTRUMENT_CLUSTER_NAVIGATION_STATE(32774),
    INSTRUMENT_CLUSTER_NAVIGATION_CURRENT_POSITION(32775);

    public static final int INSTRUMENT_CLUSTER_NAVIGATION_CURRENT_POSITION_VALUE = 32775;
    public static final int INSTRUMENT_CLUSTER_NAVIGATION_DISTANCE_EVENT_VALUE = 32773;
    public static final int INSTRUMENT_CLUSTER_NAVIGATION_STATE_VALUE = 32774;
    public static final int INSTRUMENT_CLUSTER_NAVIGATION_STATUS_VALUE = 32771;
    public static final int INSTRUMENT_CLUSTER_NAVIGATION_TURN_EVENT_VALUE = 32772;
    public static final int INSTRUMENT_CLUSTER_START_VALUE = 32769;
    public static final int INSTRUMENT_CLUSTER_STOP_VALUE = 32770;
    private static final Internal.EnumLiteMap<NavigationStatusMessageId> internalValueMap = new Internal.EnumLiteMap<NavigationStatusMessageId>() { // from class: fr.sd.taada.proto.NavigationStatusMessageId.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public NavigationStatusMessageId findValueByNumber(int i) {
            return NavigationStatusMessageId.forNumber(i);
        }
    };
    private final int value;

    public static final class NavigationStatusMessageIdVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new NavigationStatusMessageIdVerifier();

        private NavigationStatusMessageIdVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return NavigationStatusMessageId.forNumber(i) != null;
        }
    }

    NavigationStatusMessageId(int i) {
        this.value = i;
    }

    public static NavigationStatusMessageId forNumber(int i) {
        switch (i) {
            case 32769:
                return INSTRUMENT_CLUSTER_START;
            case 32770:
                return INSTRUMENT_CLUSTER_STOP;
            case 32771:
                return INSTRUMENT_CLUSTER_NAVIGATION_STATUS;
            case 32772:
                return INSTRUMENT_CLUSTER_NAVIGATION_TURN_EVENT;
            case 32773:
                return INSTRUMENT_CLUSTER_NAVIGATION_DISTANCE_EVENT;
            case 32774:
                return INSTRUMENT_CLUSTER_NAVIGATION_STATE;
            case 32775:
                return INSTRUMENT_CLUSTER_NAVIGATION_CURRENT_POSITION;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<NavigationStatusMessageId> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return NavigationStatusMessageIdVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static NavigationStatusMessageId valueOf(int i) {
        return forNumber(i);
    }
}
