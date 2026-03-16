package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class ConfigureChannelSpacingRequest extends GeneratedMessageLite<ConfigureChannelSpacingRequest, Builder> implements ConfigureChannelSpacingRequestOrBuilder {
    public static final int CHANNEL_SPACING_FIELD_NUMBER = 2;
    private static final ConfigureChannelSpacingRequest DEFAULT_INSTANCE;
    private static volatile Parser<ConfigureChannelSpacingRequest> PARSER = null;
    public static final int RADIO_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private int channelSpacing_;
    private byte memoizedIsInitialized = 2;
    private int radioId_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.ConfigureChannelSpacingRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ConfigureChannelSpacingRequest, Builder> implements ConfigureChannelSpacingRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearChannelSpacing() {
            copyOnWrite();
            ((ConfigureChannelSpacingRequest) this.instance).clearChannelSpacing();
            return this;
        }

        public Builder clearRadioId() {
            copyOnWrite();
            ((ConfigureChannelSpacingRequest) this.instance).clearRadioId();
            return this;
        }

        @Override // fr.sd.taada.proto.ConfigureChannelSpacingRequestOrBuilder
        public int getChannelSpacing() {
            return ((ConfigureChannelSpacingRequest) this.instance).getChannelSpacing();
        }

        @Override // fr.sd.taada.proto.ConfigureChannelSpacingRequestOrBuilder
        public int getRadioId() {
            return ((ConfigureChannelSpacingRequest) this.instance).getRadioId();
        }

        @Override // fr.sd.taada.proto.ConfigureChannelSpacingRequestOrBuilder
        public boolean hasChannelSpacing() {
            return ((ConfigureChannelSpacingRequest) this.instance).hasChannelSpacing();
        }

        @Override // fr.sd.taada.proto.ConfigureChannelSpacingRequestOrBuilder
        public boolean hasRadioId() {
            return ((ConfigureChannelSpacingRequest) this.instance).hasRadioId();
        }

        public Builder setChannelSpacing(int i) {
            copyOnWrite();
            ((ConfigureChannelSpacingRequest) this.instance).setChannelSpacing(i);
            return this;
        }

        public Builder setRadioId(int i) {
            copyOnWrite();
            ((ConfigureChannelSpacingRequest) this.instance).setRadioId(i);
            return this;
        }

        private Builder() {
            super(ConfigureChannelSpacingRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        ConfigureChannelSpacingRequest configureChannelSpacingRequest = new ConfigureChannelSpacingRequest();
        DEFAULT_INSTANCE = configureChannelSpacingRequest;
        GeneratedMessageLite.registerDefaultInstance(ConfigureChannelSpacingRequest.class, configureChannelSpacingRequest);
    }

    private ConfigureChannelSpacingRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChannelSpacing() {
        this.bitField0_ &= -3;
        this.channelSpacing_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioId() {
        this.bitField0_ &= -2;
        this.radioId_ = 0;
    }

    public static ConfigureChannelSpacingRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ConfigureChannelSpacingRequest parseDelimitedFrom(InputStream inputStream) {
        return (ConfigureChannelSpacingRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigureChannelSpacingRequest parseFrom(ByteBuffer byteBuffer) {
        return (ConfigureChannelSpacingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ConfigureChannelSpacingRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChannelSpacing(int i) {
        this.bitField0_ |= 2;
        this.channelSpacing_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioId(int i) {
        this.bitField0_ |= 1;
        this.radioId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ConfigureChannelSpacingRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԅ\u0000\u0002Ԅ\u0001", new Object[]{"bitField0_", "radioId_", "channelSpacing_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ConfigureChannelSpacingRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ConfigureChannelSpacingRequest.class) {
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
                return Byte.valueOf(this.memoizedIsInitialized);
            case 7:
                this.memoizedIsInitialized = (byte) (obj == null ? 0 : 1);
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // fr.sd.taada.proto.ConfigureChannelSpacingRequestOrBuilder
    public int getChannelSpacing() {
        return this.channelSpacing_;
    }

    @Override // fr.sd.taada.proto.ConfigureChannelSpacingRequestOrBuilder
    public int getRadioId() {
        return this.radioId_;
    }

    @Override // fr.sd.taada.proto.ConfigureChannelSpacingRequestOrBuilder
    public boolean hasChannelSpacing() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.ConfigureChannelSpacingRequestOrBuilder
    public boolean hasRadioId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(ConfigureChannelSpacingRequest configureChannelSpacingRequest) {
        return DEFAULT_INSTANCE.createBuilder(configureChannelSpacingRequest);
    }

    public static ConfigureChannelSpacingRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ConfigureChannelSpacingRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ConfigureChannelSpacingRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ConfigureChannelSpacingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ConfigureChannelSpacingRequest parseFrom(ByteString byteString) {
        return (ConfigureChannelSpacingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ConfigureChannelSpacingRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ConfigureChannelSpacingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ConfigureChannelSpacingRequest parseFrom(byte[] bArr) {
        return (ConfigureChannelSpacingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ConfigureChannelSpacingRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ConfigureChannelSpacingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ConfigureChannelSpacingRequest parseFrom(InputStream inputStream) {
        return (ConfigureChannelSpacingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigureChannelSpacingRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ConfigureChannelSpacingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ConfigureChannelSpacingRequest parseFrom(CodedInputStream codedInputStream) {
        return (ConfigureChannelSpacingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ConfigureChannelSpacingRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ConfigureChannelSpacingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
