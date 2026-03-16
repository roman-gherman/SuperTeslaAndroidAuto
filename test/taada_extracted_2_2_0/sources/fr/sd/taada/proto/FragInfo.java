package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum FragInfo implements Internal.EnumLite {
    FRAG_CONTINUATION(0),
    FRAG_FIRST(1),
    FRAG_LAST(2),
    FRAG_UNFRAGMENTED(3);

    public static final int FRAG_CONTINUATION_VALUE = 0;
    public static final int FRAG_FIRST_VALUE = 1;
    public static final int FRAG_LAST_VALUE = 2;
    public static final int FRAG_UNFRAGMENTED_VALUE = 3;
    private static final Internal.EnumLiteMap<FragInfo> internalValueMap = new Internal.EnumLiteMap<FragInfo>() { // from class: fr.sd.taada.proto.FragInfo.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public FragInfo findValueByNumber(int i) {
            return FragInfo.forNumber(i);
        }
    };
    private final int value;

    public static final class FragInfoVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new FragInfoVerifier();

        private FragInfoVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return FragInfo.forNumber(i) != null;
        }
    }

    FragInfo(int i) {
        this.value = i;
    }

    public static FragInfo forNumber(int i) {
        if (i == 0) {
            return FRAG_CONTINUATION;
        }
        if (i == 1) {
            return FRAG_FIRST;
        }
        if (i == 2) {
            return FRAG_LAST;
        }
        if (i != 3) {
            return null;
        }
        return FRAG_UNFRAGMENTED;
    }

    public static Internal.EnumLiteMap<FragInfo> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return FragInfoVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static FragInfo valueOf(int i) {
        return forNumber(i);
    }
}
