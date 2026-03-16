package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class EnvironmentData extends GeneratedMessageLite<EnvironmentData, Builder> implements EnvironmentDataOrBuilder {
    private static final EnvironmentData DEFAULT_INSTANCE;
    private static volatile Parser<EnvironmentData> PARSER = null;
    public static final int PRESSURE_E3_FIELD_NUMBER = 2;
    public static final int RAIN_FIELD_NUMBER = 3;
    public static final int TEMPERATURE_E3_FIELD_NUMBER = 1;
    private int bitField0_;
    private int pressureE3_;
    private int rain_;
    private int temperatureE3_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.EnvironmentData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<EnvironmentData, Builder> implements EnvironmentDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearPressureE3() {
            copyOnWrite();
            ((EnvironmentData) this.instance).clearPressureE3();
            return this;
        }

        public Builder clearRain() {
            copyOnWrite();
            ((EnvironmentData) this.instance).clearRain();
            return this;
        }

        public Builder clearTemperatureE3() {
            copyOnWrite();
            ((EnvironmentData) this.instance).clearTemperatureE3();
            return this;
        }

        @Override // fr.sd.taada.proto.EnvironmentDataOrBuilder
        public int getPressureE3() {
            return ((EnvironmentData) this.instance).getPressureE3();
        }

        @Override // fr.sd.taada.proto.EnvironmentDataOrBuilder
        public int getRain() {
            return ((EnvironmentData) this.instance).getRain();
        }

        @Override // fr.sd.taada.proto.EnvironmentDataOrBuilder
        public int getTemperatureE3() {
            return ((EnvironmentData) this.instance).getTemperatureE3();
        }

        @Override // fr.sd.taada.proto.EnvironmentDataOrBuilder
        public boolean hasPressureE3() {
            return ((EnvironmentData) this.instance).hasPressureE3();
        }

        @Override // fr.sd.taada.proto.EnvironmentDataOrBuilder
        public boolean hasRain() {
            return ((EnvironmentData) this.instance).hasRain();
        }

        @Override // fr.sd.taada.proto.EnvironmentDataOrBuilder
        public boolean hasTemperatureE3() {
            return ((EnvironmentData) this.instance).hasTemperatureE3();
        }

        public Builder setPressureE3(int i) {
            copyOnWrite();
            ((EnvironmentData) this.instance).setPressureE3(i);
            return this;
        }

        public Builder setRain(int i) {
            copyOnWrite();
            ((EnvironmentData) this.instance).setRain(i);
            return this;
        }

        public Builder setTemperatureE3(int i) {
            copyOnWrite();
            ((EnvironmentData) this.instance).setTemperatureE3(i);
            return this;
        }

        private Builder() {
            super(EnvironmentData.DEFAULT_INSTANCE);
        }
    }

    static {
        EnvironmentData environmentData = new EnvironmentData();
        DEFAULT_INSTANCE = environmentData;
        GeneratedMessageLite.registerDefaultInstance(EnvironmentData.class, environmentData);
    }

    private EnvironmentData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPressureE3() {
        this.bitField0_ &= -3;
        this.pressureE3_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRain() {
        this.bitField0_ &= -5;
        this.rain_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTemperatureE3() {
        this.bitField0_ &= -2;
        this.temperatureE3_ = 0;
    }

    public static EnvironmentData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static EnvironmentData parseDelimitedFrom(InputStream inputStream) {
        return (EnvironmentData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EnvironmentData parseFrom(ByteBuffer byteBuffer) {
        return (EnvironmentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<EnvironmentData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPressureE3(int i) {
        this.bitField0_ |= 2;
        this.pressureE3_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRain(int i) {
        this.bitField0_ |= 4;
        this.rain_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTemperatureE3(int i) {
        this.bitField0_ |= 1;
        this.temperatureE3_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new EnvironmentData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002", new Object[]{"bitField0_", "temperatureE3_", "pressureE3_", "rain_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EnvironmentData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (EnvironmentData.class) {
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

    @Override // fr.sd.taada.proto.EnvironmentDataOrBuilder
    public int getPressureE3() {
        return this.pressureE3_;
    }

    @Override // fr.sd.taada.proto.EnvironmentDataOrBuilder
    public int getRain() {
        return this.rain_;
    }

    @Override // fr.sd.taada.proto.EnvironmentDataOrBuilder
    public int getTemperatureE3() {
        return this.temperatureE3_;
    }

    @Override // fr.sd.taada.proto.EnvironmentDataOrBuilder
    public boolean hasPressureE3() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.EnvironmentDataOrBuilder
    public boolean hasRain() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.EnvironmentDataOrBuilder
    public boolean hasTemperatureE3() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(EnvironmentData environmentData) {
        return DEFAULT_INSTANCE.createBuilder(environmentData);
    }

    public static EnvironmentData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EnvironmentData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EnvironmentData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (EnvironmentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static EnvironmentData parseFrom(ByteString byteString) {
        return (EnvironmentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static EnvironmentData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (EnvironmentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static EnvironmentData parseFrom(byte[] bArr) {
        return (EnvironmentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EnvironmentData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (EnvironmentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static EnvironmentData parseFrom(InputStream inputStream) {
        return (EnvironmentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EnvironmentData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EnvironmentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EnvironmentData parseFrom(CodedInputStream codedInputStream) {
        return (EnvironmentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static EnvironmentData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EnvironmentData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
