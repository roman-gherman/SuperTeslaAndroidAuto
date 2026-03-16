package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum GenericNotificationMessageId implements Internal.EnumLite {
    GENERIC_NOTIFICATION_SUBSCRIBE(32769),
    GENERIC_NOTIFICATION_UNSUBSCRIBE(32770),
    GENERIC_NOTIFICATION_MESSAGE(32771),
    GENERIC_NOTIFICATION_ACK(32772);

    public static final int GENERIC_NOTIFICATION_ACK_VALUE = 32772;
    public static final int GENERIC_NOTIFICATION_MESSAGE_VALUE = 32771;
    public static final int GENERIC_NOTIFICATION_SUBSCRIBE_VALUE = 32769;
    public static final int GENERIC_NOTIFICATION_UNSUBSCRIBE_VALUE = 32770;
    private static final Internal.EnumLiteMap<GenericNotificationMessageId> internalValueMap = new Internal.EnumLiteMap<GenericNotificationMessageId>() { // from class: fr.sd.taada.proto.GenericNotificationMessageId.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public GenericNotificationMessageId findValueByNumber(int i) {
            return GenericNotificationMessageId.forNumber(i);
        }
    };
    private final int value;

    public static final class GenericNotificationMessageIdVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new GenericNotificationMessageIdVerifier();

        private GenericNotificationMessageIdVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return GenericNotificationMessageId.forNumber(i) != null;
        }
    }

    GenericNotificationMessageId(int i) {
        this.value = i;
    }

    public static GenericNotificationMessageId forNumber(int i) {
        switch (i) {
            case 32769:
                return GENERIC_NOTIFICATION_SUBSCRIBE;
            case 32770:
                return GENERIC_NOTIFICATION_UNSUBSCRIBE;
            case 32771:
                return GENERIC_NOTIFICATION_MESSAGE;
            case 32772:
                return GENERIC_NOTIFICATION_ACK;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<GenericNotificationMessageId> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return GenericNotificationMessageIdVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static GenericNotificationMessageId valueOf(int i) {
        return forNumber(i);
    }
}
