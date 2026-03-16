package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class HvacData extends GeneratedMessageLite<HvacData, Builder> implements HvacDataOrBuilder {
    public static final int CURRENT_TEMPERATURE_E3_FIELD_NUMBER = 2;
    private static final HvacData DEFAULT_INSTANCE;
    private static volatile Parser<HvacData> PARSER = null;
    public static final int TARGET_TEMPERATURE_E3_FIELD_NUMBER = 1;
    private int bitField0_;
    private int currentTemperatureE3_;
    private int targetTemperatureE3_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.HvacData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<HvacData, Builder> implements HvacDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCurrentTemperatureE3() {
            copyOnWrite();
            ((HvacData) this.instance).clearCurrentTemperatureE3();
            return this;
        }

        public Builder clearTargetTemperatureE3() {
            copyOnWrite();
            ((HvacData) this.instance).clearTargetTemperatureE3();
            return this;
        }

        @Override // fr.sd.taada.proto.HvacDataOrBuilder
        public int getCurrentTemperatureE3() {
            return ((HvacData) this.instance).getCurrentTemperatureE3();
        }

        @Override // fr.sd.taada.proto.HvacDataOrBuilder
        public int getTargetTemperatureE3() {
            return ((HvacData) this.instance).getTargetTemperatureE3();
        }

        @Override // fr.sd.taada.proto.HvacDataOrBuilder
        public boolean hasCurrentTemperatureE3() {
            return ((HvacData) this.instance).hasCurrentTemperatureE3();
        }

        @Override // fr.sd.taada.proto.HvacDataOrBuilder
        public boolean hasTargetTemperatureE3() {
            return ((HvacData) this.instance).hasTargetTemperatureE3();
        }

        public Builder setCurrentTemperatureE3(int i) {
            copyOnWrite();
            ((HvacData) this.instance).setCurrentTemperatureE3(i);
            return this;
        }

        public Builder setTargetTemperatureE3(int i) {
            copyOnWrite();
            ((HvacData) this.instance).setTargetTemperatureE3(i);
            return this;
        }

        private Builder() {
            super(HvacData.DEFAULT_INSTANCE);
        }
    }

    static {
        HvacData hvacData = new HvacData();
        DEFAULT_INSTANCE = hvacData;
        GeneratedMessageLite.registerDefaultInstance(HvacData.class, hvacData);
    }

    private HvacData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCurrentTemperatureE3() {
        this.bitField0_ &= -3;
        this.currentTemperatureE3_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTargetTemperatureE3() {
        this.bitField0_ &= -2;
        this.targetTemperatureE3_ = 0;
    }

    public static HvacData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static HvacData parseDelimitedFrom(InputStream inputStream) {
        return (HvacData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HvacData parseFrom(ByteBuffer byteBuffer) {
        return (HvacData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HvacData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentTemperatureE3(int i) {
        this.bitField0_ |= 2;
        this.currentTemperatureE3_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTargetTemperatureE3(int i) {
        this.bitField0_ |= 1;
        this.targetTemperatureE3_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new HvacData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"bitField0_", "targetTemperatureE3_", "currentTemperatureE3_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HvacData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (HvacData.class) {
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

    @Override // fr.sd.taada.proto.HvacDataOrBuilder
    public int getCurrentTemperatureE3() {
        return this.currentTemperatureE3_;
    }

    @Override // fr.sd.taada.proto.HvacDataOrBuilder
    public int getTargetTemperatureE3() {
        return this.targetTemperatureE3_;
    }

    @Override // fr.sd.taada.proto.HvacDataOrBuilder
    public boolean hasCurrentTemperatureE3() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.HvacDataOrBuilder
    public boolean hasTargetTemperatureE3() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(HvacData hvacData) {
        return DEFAULT_INSTANCE.createBuilder(hvacData);
    }

    public static HvacData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HvacData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HvacData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (HvacData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HvacData parseFrom(ByteString byteString) {
        return (HvacData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HvacData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (HvacData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HvacData parseFrom(byte[] bArr) {
        return (HvacData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HvacData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (HvacData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HvacData parseFrom(InputStream inputStream) {
        return (HvacData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HvacData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HvacData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HvacData parseFrom(CodedInputStream codedInputStream) {
        return (HvacData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HvacData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (HvacData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
