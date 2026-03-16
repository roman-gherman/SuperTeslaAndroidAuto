package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum PointerAction implements Internal.EnumLite {
    ACTION_DOWN(0),
    ACTION_UP(1),
    ACTION_MOVED(2),
    ACTION_POINTER_DOWN(5),
    ACTION_POINTER_UP(6);

    public static final int ACTION_DOWN_VALUE = 0;
    public static final int ACTION_MOVED_VALUE = 2;
    public static final int ACTION_POINTER_DOWN_VALUE = 5;
    public static final int ACTION_POINTER_UP_VALUE = 6;
    public static final int ACTION_UP_VALUE = 1;
    private static final Internal.EnumLiteMap<PointerAction> internalValueMap = new Internal.EnumLiteMap<PointerAction>() { // from class: fr.sd.taada.proto.PointerAction.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public PointerAction findValueByNumber(int i) {
            return PointerAction.forNumber(i);
        }
    };
    private final int value;

    public static final class PointerActionVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PointerActionVerifier();

        private PointerActionVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return PointerAction.forNumber(i) != null;
        }
    }

    PointerAction(int i) {
        this.value = i;
    }

    public static PointerAction forNumber(int i) {
        if (i == 0) {
            return ACTION_DOWN;
        }
        if (i == 1) {
            return ACTION_UP;
        }
        if (i == 2) {
            return ACTION_MOVED;
        }
        if (i == 5) {
            return ACTION_POINTER_DOWN;
        }
        if (i != 6) {
            return null;
        }
        return ACTION_POINTER_UP;
    }

    public static Internal.EnumLiteMap<PointerAction> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PointerActionVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static PointerAction valueOf(int i) {
        return forNumber(i);
    }
}
