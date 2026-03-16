package fr.sd.taada.proto;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes2.dex */
public enum VoiceSessionStatus implements Internal.EnumLite {
    VOICE_SESSION_START(1),
    VOICE_SESSION_END(2);

    public static final int VOICE_SESSION_END_VALUE = 2;
    public static final int VOICE_SESSION_START_VALUE = 1;
    private static final Internal.EnumLiteMap<VoiceSessionStatus> internalValueMap = new Internal.EnumLiteMap<VoiceSessionStatus>() { // from class: fr.sd.taada.proto.VoiceSessionStatus.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public VoiceSessionStatus findValueByNumber(int i) {
            return VoiceSessionStatus.forNumber(i);
        }
    };
    private final int value;

    public static final class VoiceSessionStatusVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new VoiceSessionStatusVerifier();

        private VoiceSessionStatusVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return VoiceSessionStatus.forNumber(i) != null;
        }
    }

    VoiceSessionStatus(int i) {
        this.value = i;
    }

    public static VoiceSessionStatus forNumber(int i) {
        if (i == 1) {
            return VOICE_SESSION_START;
        }
        if (i != 2) {
            return null;
        }
        return VOICE_SESSION_END;
    }

    public static Internal.EnumLiteMap<VoiceSessionStatus> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return VoiceSessionStatusVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static VoiceSessionStatus valueOf(int i) {
        return forNumber(i);
    }
}
