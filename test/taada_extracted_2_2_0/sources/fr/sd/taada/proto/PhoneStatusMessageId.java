package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum PhoneStatusMessageId implements Internal.EnumLite {
    PHONE_STATUS(32769),
    PHONE_STATUS_INPUT(32770);

    public static final int PHONE_STATUS_INPUT_VALUE = 32770;
    public static final int PHONE_STATUS_VALUE = 32769;
    private static final Internal.EnumLiteMap<PhoneStatusMessageId> internalValueMap = new Internal.EnumLiteMap<PhoneStatusMessageId>() { // from class: fr.sd.taada.proto.PhoneStatusMessageId.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public PhoneStatusMessageId findValueByNumber(int i) {
            return PhoneStatusMessageId.forNumber(i);
        }
    };
    private final int value;

    public static final class PhoneStatusMessageIdVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PhoneStatusMessageIdVerifier();

        private PhoneStatusMessageIdVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return PhoneStatusMessageId.forNumber(i) != null;
        }
    }

    PhoneStatusMessageId(int i) {
        this.value = i;
    }

    public static PhoneStatusMessageId forNumber(int i) {
        switch (i) {
            case 32769:
                return PHONE_STATUS;
            case 32770:
                return PHONE_STATUS_INPUT;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<PhoneStatusMessageId> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PhoneStatusMessageIdVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static PhoneStatusMessageId valueOf(int i) {
        return forNumber(i);
    }
}
