package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum HdAcquisionState implements Internal.EnumLite {
    ANALOG(0),
    ACQUIRING_HD(1),
    ACQUIRED_HD(2);

    public static final int ACQUIRED_HD_VALUE = 2;
    public static final int ACQUIRING_HD_VALUE = 1;
    public static final int ANALOG_VALUE = 0;
    private static final Internal.EnumLiteMap<HdAcquisionState> internalValueMap = new Internal.EnumLiteMap<HdAcquisionState>() { // from class: fr.sd.taada.proto.HdAcquisionState.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public HdAcquisionState findValueByNumber(int i) {
            return HdAcquisionState.forNumber(i);
        }
    };
    private final int value;

    public static final class HdAcquisionStateVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new HdAcquisionStateVerifier();

        private HdAcquisionStateVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return HdAcquisionState.forNumber(i) != null;
        }
    }

    HdAcquisionState(int i) {
        this.value = i;
    }

    public static HdAcquisionState forNumber(int i) {
        if (i == 0) {
            return ANALOG;
        }
        if (i == 1) {
            return ACQUIRING_HD;
        }
        if (i != 2) {
            return null;
        }
        return ACQUIRED_HD;
    }

    public static Internal.EnumLiteMap<HdAcquisionState> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return HdAcquisionStateVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static HdAcquisionState valueOf(int i) {
        return forNumber(i);
    }
}
