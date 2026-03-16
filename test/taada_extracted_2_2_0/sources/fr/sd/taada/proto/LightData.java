package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class LightData extends GeneratedMessageLite<LightData, Builder> implements LightDataOrBuilder {
    private static final LightData DEFAULT_INSTANCE;
    public static final int HAZARD_LIGHTS_ON_FIELD_NUMBER = 3;
    public static final int HEAD_LIGHT_STATE_FIELD_NUMBER = 1;
    private static volatile Parser<LightData> PARSER = null;
    public static final int TURN_INDICATOR_STATE_FIELD_NUMBER = 2;
    private int bitField0_;
    private boolean hazardLightsOn_;
    private int headLightState_ = 1;
    private int turnIndicatorState_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.LightData$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<LightData, Builder> implements LightDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearHazardLightsOn() {
            copyOnWrite();
            ((LightData) this.instance).clearHazardLightsOn();
            return this;
        }

        public Builder clearHeadLightState() {
            copyOnWrite();
            ((LightData) this.instance).clearHeadLightState();
            return this;
        }

        public Builder clearTurnIndicatorState() {
            copyOnWrite();
            ((LightData) this.instance).clearTurnIndicatorState();
            return this;
        }

        @Override // fr.sd.taada.proto.LightDataOrBuilder
        public boolean getHazardLightsOn() {
            return ((LightData) this.instance).getHazardLightsOn();
        }

        @Override // fr.sd.taada.proto.LightDataOrBuilder
        public HeadLightState getHeadLightState() {
            return ((LightData) this.instance).getHeadLightState();
        }

        @Override // fr.sd.taada.proto.LightDataOrBuilder
        public TurnIndicatorState getTurnIndicatorState() {
            return ((LightData) this.instance).getTurnIndicatorState();
        }

        @Override // fr.sd.taada.proto.LightDataOrBuilder
        public boolean hasHazardLightsOn() {
            return ((LightData) this.instance).hasHazardLightsOn();
        }

        @Override // fr.sd.taada.proto.LightDataOrBuilder
        public boolean hasHeadLightState() {
            return ((LightData) this.instance).hasHeadLightState();
        }

        @Override // fr.sd.taada.proto.LightDataOrBuilder
        public boolean hasTurnIndicatorState() {
            return ((LightData) this.instance).hasTurnIndicatorState();
        }

        public Builder setHazardLightsOn(boolean z6) {
            copyOnWrite();
            ((LightData) this.instance).setHazardLightsOn(z6);
            return this;
        }

        public Builder setHeadLightState(HeadLightState headLightState) {
            copyOnWrite();
            ((LightData) this.instance).setHeadLightState(headLightState);
            return this;
        }

        public Builder setTurnIndicatorState(TurnIndicatorState turnIndicatorState) {
            copyOnWrite();
            ((LightData) this.instance).setTurnIndicatorState(turnIndicatorState);
            return this;
        }

        private Builder() {
            super(LightData.DEFAULT_INSTANCE);
        }
    }

    static {
        LightData lightData = new LightData();
        DEFAULT_INSTANCE = lightData;
        GeneratedMessageLite.registerDefaultInstance(LightData.class, lightData);
    }

    private LightData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHazardLightsOn() {
        this.bitField0_ &= -5;
        this.hazardLightsOn_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeadLightState() {
        this.bitField0_ &= -2;
        this.headLightState_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTurnIndicatorState() {
        this.bitField0_ &= -3;
        this.turnIndicatorState_ = 1;
    }

    public static LightData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static LightData parseDelimitedFrom(InputStream inputStream) {
        return (LightData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LightData parseFrom(ByteBuffer byteBuffer) {
        return (LightData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<LightData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHazardLightsOn(boolean z6) {
        this.bitField0_ |= 4;
        this.hazardLightsOn_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeadLightState(HeadLightState headLightState) {
        headLightState.getClass();
        this.bitField0_ |= 1;
        this.headLightState_ = headLightState.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTurnIndicatorState(TurnIndicatorState turnIndicatorState) {
        turnIndicatorState.getClass();
        this.bitField0_ |= 2;
        this.turnIndicatorState_ = turnIndicatorState.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new LightData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\u0007\u0002", new Object[]{"bitField0_", "headLightState_", HeadLightState.internalGetVerifier(), "turnIndicatorState_", TurnIndicatorState.internalGetVerifier(), "hazardLightsOn_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<LightData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (LightData.class) {
                    try {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // fr.sd.taada.proto.LightDataOrBuilder
    public boolean getHazardLightsOn() {
        return this.hazardLightsOn_;
    }

    @Override // fr.sd.taada.proto.LightDataOrBuilder
    public HeadLightState getHeadLightState() {
        HeadLightState headLightStateForNumber = HeadLightState.forNumber(this.headLightState_);
        return headLightStateForNumber == null ? HeadLightState.HEAD_LIGHT_STATE_OFF : headLightStateForNumber;
    }

    @Override // fr.sd.taada.proto.LightDataOrBuilder
    public TurnIndicatorState getTurnIndicatorState() {
        TurnIndicatorState turnIndicatorStateForNumber = TurnIndicatorState.forNumber(this.turnIndicatorState_);
        return turnIndicatorStateForNumber == null ? TurnIndicatorState.TURN_INDICATOR_NONE : turnIndicatorStateForNumber;
    }

    @Override // fr.sd.taada.proto.LightDataOrBuilder
    public boolean hasHazardLightsOn() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.LightDataOrBuilder
    public boolean hasHeadLightState() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.LightDataOrBuilder
    public boolean hasTurnIndicatorState() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(LightData lightData) {
        return DEFAULT_INSTANCE.createBuilder(lightData);
    }

    public static LightData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LightData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LightData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (LightData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static LightData parseFrom(ByteString byteString) {
        return (LightData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static LightData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (LightData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static LightData parseFrom(byte[] bArr) {
        return (LightData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LightData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (LightData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static LightData parseFrom(InputStream inputStream) {
        return (LightData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LightData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LightData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LightData parseFrom(CodedInputStream codedInputStream) {
        return (LightData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static LightData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (LightData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
