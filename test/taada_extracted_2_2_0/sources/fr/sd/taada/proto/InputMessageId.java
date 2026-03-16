package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum InputMessageId implements Internal.EnumLite {
    INPUT_MESSAGE_INPUT_REPORT(32769),
    INPUT_MESSAGE_KEY_BINDING_REQUEST(32770),
    INPUT_MESSAGE_KEY_BINDING_RESPONSE(32771),
    INPUT_MESSAGE_INPUT_FEEDBACK(32772);

    public static final int INPUT_MESSAGE_INPUT_FEEDBACK_VALUE = 32772;
    public static final int INPUT_MESSAGE_INPUT_REPORT_VALUE = 32769;
    public static final int INPUT_MESSAGE_KEY_BINDING_REQUEST_VALUE = 32770;
    public static final int INPUT_MESSAGE_KEY_BINDING_RESPONSE_VALUE = 32771;
    private static final Internal.EnumLiteMap<InputMessageId> internalValueMap = new Internal.EnumLiteMap<InputMessageId>() { // from class: fr.sd.taada.proto.InputMessageId.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public InputMessageId findValueByNumber(int i) {
            return InputMessageId.forNumber(i);
        }
    };
    private final int value;

    public static final class InputMessageIdVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new InputMessageIdVerifier();

        private InputMessageIdVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return InputMessageId.forNumber(i) != null;
        }
    }

    InputMessageId(int i) {
        this.value = i;
    }

    public static InputMessageId forNumber(int i) {
        switch (i) {
            case 32769:
                return INPUT_MESSAGE_INPUT_REPORT;
            case 32770:
                return INPUT_MESSAGE_KEY_BINDING_REQUEST;
            case 32771:
                return INPUT_MESSAGE_KEY_BINDING_RESPONSE;
            case 32772:
                return INPUT_MESSAGE_INPUT_FEEDBACK;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<InputMessageId> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return InputMessageIdVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static InputMessageId valueOf(int i) {
        return forNumber(i);
    }
}
