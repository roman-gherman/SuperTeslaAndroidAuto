package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum SessionConfiguration implements Internal.EnumLite {
    UI_CONFIG_HIDE_CLOCK(1),
    UI_CONFIG_HIDE_PHONE_SIGNAL(2),
    UI_CONFIG_HIDE_BATTERY_LEVEL(4),
    CAN_PLAY_NATIVE_MEDIA_DURING_VR(8);

    public static final int CAN_PLAY_NATIVE_MEDIA_DURING_VR_VALUE = 8;
    public static final int UI_CONFIG_HIDE_BATTERY_LEVEL_VALUE = 4;
    public static final int UI_CONFIG_HIDE_CLOCK_VALUE = 1;
    public static final int UI_CONFIG_HIDE_PHONE_SIGNAL_VALUE = 2;
    private static final Internal.EnumLiteMap<SessionConfiguration> internalValueMap = new Internal.EnumLiteMap<SessionConfiguration>() { // from class: fr.sd.taada.proto.SessionConfiguration.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public SessionConfiguration findValueByNumber(int i) {
            return SessionConfiguration.forNumber(i);
        }
    };
    private final int value;

    public static final class SessionConfigurationVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new SessionConfigurationVerifier();

        private SessionConfigurationVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return SessionConfiguration.forNumber(i) != null;
        }
    }

    SessionConfiguration(int i) {
        this.value = i;
    }

    public static SessionConfiguration forNumber(int i) {
        if (i == 1) {
            return UI_CONFIG_HIDE_CLOCK;
        }
        if (i == 2) {
            return UI_CONFIG_HIDE_PHONE_SIGNAL;
        }
        if (i == 4) {
            return UI_CONFIG_HIDE_BATTERY_LEVEL;
        }
        if (i != 8) {
            return null;
        }
        return CAN_PLAY_NATIVE_MEDIA_DURING_VR;
    }

    public static Internal.EnumLiteMap<SessionConfiguration> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return SessionConfigurationVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static SessionConfiguration valueOf(int i) {
        return forNumber(i);
    }
}
