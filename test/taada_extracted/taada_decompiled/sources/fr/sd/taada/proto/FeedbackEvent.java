package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum FeedbackEvent implements Internal.EnumLite {
    FEEDBACK_SELECT(1),
    FEEDBACK_FOCUS_CHANGE(2),
    FEEDBACK_DRAG_SELECT(3),
    FEEDBACK_DRAG_START(4),
    FEEDBACK_DRAG_END(5);

    public static final int FEEDBACK_DRAG_END_VALUE = 5;
    public static final int FEEDBACK_DRAG_SELECT_VALUE = 3;
    public static final int FEEDBACK_DRAG_START_VALUE = 4;
    public static final int FEEDBACK_FOCUS_CHANGE_VALUE = 2;
    public static final int FEEDBACK_SELECT_VALUE = 1;
    private static final Internal.EnumLiteMap<FeedbackEvent> internalValueMap = new Internal.EnumLiteMap<FeedbackEvent>() { // from class: fr.sd.taada.proto.FeedbackEvent.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public FeedbackEvent findValueByNumber(int i) {
            return FeedbackEvent.forNumber(i);
        }
    };
    private final int value;

    public static final class FeedbackEventVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new FeedbackEventVerifier();

        private FeedbackEventVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return FeedbackEvent.forNumber(i) != null;
        }
    }

    FeedbackEvent(int i) {
        this.value = i;
    }

    public static FeedbackEvent forNumber(int i) {
        if (i == 1) {
            return FEEDBACK_SELECT;
        }
        if (i == 2) {
            return FEEDBACK_FOCUS_CHANGE;
        }
        if (i == 3) {
            return FEEDBACK_DRAG_SELECT;
        }
        if (i == 4) {
            return FEEDBACK_DRAG_START;
        }
        if (i != 5) {
            return null;
        }
        return FEEDBACK_DRAG_END;
    }

    public static Internal.EnumLiteMap<FeedbackEvent> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return FeedbackEventVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static FeedbackEvent valueOf(int i) {
        return forNumber(i);
    }
}
