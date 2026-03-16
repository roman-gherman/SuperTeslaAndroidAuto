package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class ConfigureChannelSpacingResponse extends GeneratedMessageLite<ConfigureChannelSpacingResponse, Builder> implements ConfigureChannelSpacingResponseOrBuilder {
    public static final int CHANNEL_SPACING_FIELD_NUMBER = 3;
    private static final ConfigureChannelSpacingResponse DEFAULT_INSTANCE;
    private static volatile Parser<ConfigureChannelSpacingResponse> PARSER = null;
    public static final int RADIO_ID_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int bitField0_;
    private int channelSpacing_;
    private int radioId_;
    private byte memoizedIsInitialized = 2;
    private int status_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.ConfigureChannelSpacingResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ConfigureChannelSpacingResponse, Builder> implements ConfigureChannelSpacingResponseOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearChannelSpacing() {
            copyOnWrite();
            ((ConfigureChannelSpacingResponse) this.instance).clearChannelSpacing();
            return this;
        }

        public Builder clearRadioId() {
            copyOnWrite();
            ((ConfigureChannelSpacingResponse) this.instance).clearRadioId();
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((ConfigureChannelSpacingResponse) this.instance).clearStatus();
            return this;
        }

        @Override // fr.sd.taada.proto.ConfigureChannelSpacingResponseOrBuilder
        public int getChannelSpacing() {
            return ((ConfigureChannelSpacingResponse) this.instance).getChannelSpacing();
        }

        @Override // fr.sd.taada.proto.ConfigureChannelSpacingResponseOrBuilder
        public int getRadioId() {
            return ((ConfigureChannelSpacingResponse) this.instance).getRadioId();
        }

        @Override // fr.sd.taada.proto.ConfigureChannelSpacingResponseOrBuilder
        public MessageStatus getStatus() {
            return ((ConfigureChannelSpacingResponse) this.instance).getStatus();
        }

        @Override // fr.sd.taada.proto.ConfigureChannelSpacingResponseOrBuilder
        public boolean hasChannelSpacing() {
            return ((ConfigureChannelSpacingResponse) this.instance).hasChannelSpacing();
        }

        @Override // fr.sd.taada.proto.ConfigureChannelSpacingResponseOrBuilder
        public boolean hasRadioId() {
            return ((ConfigureChannelSpacingResponse) this.instance).hasRadioId();
        }

        @Override // fr.sd.taada.proto.ConfigureChannelSpacingResponseOrBuilder
        public boolean hasStatus() {
            return ((ConfigureChannelSpacingResponse) this.instance).hasStatus();
        }

        public Builder setChannelSpacing(int i) {
            copyOnWrite();
            ((ConfigureChannelSpacingResponse) this.instance).setChannelSpacing(i);
            return this;
        }

        public Builder setRadioId(int i) {
            copyOnWrite();
            ((ConfigureChannelSpacingResponse) this.instance).setRadioId(i);
            return this;
        }

        public Builder setStatus(MessageStatus messageStatus) {
            copyOnWrite();
            ((ConfigureChannelSpacingResponse) this.instance).setStatus(messageStatus);
            return this;
        }

        private Builder() {
            super(ConfigureChannelSpacingResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        ConfigureChannelSpacingResponse configureChannelSpacingResponse = new ConfigureChannelSpacingResponse();
        DEFAULT_INSTANCE = configureChannelSpacingResponse;
        GeneratedMessageLite.registerDefaultInstance(ConfigureChannelSpacingResponse.class, configureChannelSpacingResponse);
    }

    private ConfigureChannelSpacingResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChannelSpacing() {
        this.bitField0_ &= -5;
        this.channelSpacing_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioId() {
        this.bitField0_ &= -3;
        this.radioId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.bitField0_ &= -2;
        this.status_ = 1;
    }

    public static ConfigureChannelSpacingResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ConfigureChannelSpacingResponse parseDelimitedFrom(InputStream inputStream) {
        return (ConfigureChannelSpacingResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigureChannelSpacingResponse parseFrom(ByteBuffer byteBuffer) {
        return (ConfigureChannelSpacingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ConfigureChannelSpacingResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChannelSpacing(int i) {
        this.bitField0_ |= 4;
        this.channelSpacing_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioId(int i) {
        this.bitField0_ |= 2;
        this.radioId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(MessageStatus messageStatus) {
        messageStatus.getClass();
        this.bitField0_ |= 1;
        this.status_ = messageStatus.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ConfigureChannelSpacingResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001Ԍ\u0000\u0002Ԅ\u0001\u0003Ԅ\u0002", new Object[]{"bitField0_", "status_", MessageStatus.internalGetVerifier(), "radioId_", "channelSpacing_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ConfigureChannelSpacingResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ConfigureChannelSpacingResponse.class) {
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

    @Override // fr.sd.taada.proto.ConfigureChannelSpacingResponseOrBuilder
    public int getChannelSpacing() {
        return this.channelSpacing_;
    }

    @Override // fr.sd.taada.proto.ConfigureChannelSpacingResponseOrBuilder
    public int getRadioId() {
        return this.radioId_;
    }

    @Override // fr.sd.taada.proto.ConfigureChannelSpacingResponseOrBuilder
    public MessageStatus getStatus() {
        MessageStatus messageStatusForNumber = MessageStatus.forNumber(this.status_);
        return messageStatusForNumber == null ? MessageStatus.STATUS_UNSOLICITED_MESSAGE : messageStatusForNumber;
    }

    @Override // fr.sd.taada.proto.ConfigureChannelSpacingResponseOrBuilder
    public boolean hasChannelSpacing() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.ConfigureChannelSpacingResponseOrBuilder
    public boolean hasRadioId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.ConfigureChannelSpacingResponseOrBuilder
    public boolean hasStatus() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(ConfigureChannelSpacingResponse configureChannelSpacingResponse) {
        return DEFAULT_INSTANCE.createBuilder(configureChannelSpacingResponse);
    }

    public static ConfigureChannelSpacingResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ConfigureChannelSpacingResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ConfigureChannelSpacingResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ConfigureChannelSpacingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ConfigureChannelSpacingResponse parseFrom(ByteString byteString) {
        return (ConfigureChannelSpacingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ConfigureChannelSpacingResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ConfigureChannelSpacingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ConfigureChannelSpacingResponse parseFrom(byte[] bArr) {
        return (ConfigureChannelSpacingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ConfigureChannelSpacingResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ConfigureChannelSpacingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ConfigureChannelSpacingResponse parseFrom(InputStream inputStream) {
        return (ConfigureChannelSpacingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigureChannelSpacingResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ConfigureChannelSpacingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ConfigureChannelSpacingResponse parseFrom(CodedInputStream codedInputStream) {
        return (ConfigureChannelSpacingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ConfigureChannelSpacingResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ConfigureChannelSpacingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
