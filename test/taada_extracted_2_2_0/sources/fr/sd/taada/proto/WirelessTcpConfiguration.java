package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class WirelessTcpConfiguration extends GeneratedMessageLite<WirelessTcpConfiguration, Builder> implements WirelessTcpConfigurationOrBuilder {
    private static final WirelessTcpConfiguration DEFAULT_INSTANCE;
    private static volatile Parser<WirelessTcpConfiguration> PARSER = null;
    public static final int SOCKET_READ_TIMEOUT_MS_FIELD_NUMBER = 3;
    public static final int SOCKET_RECEIVE_BUFFER_SIZE_KB_FIELD_NUMBER = 1;
    public static final int SOCKET_SEND_BUFFER_SIZE_KB_FIELD_NUMBER = 2;
    private int bitField0_;
    private int socketReadTimeoutMs_;
    private int socketReceiveBufferSizeKb_;
    private int socketSendBufferSizeKb_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.WirelessTcpConfiguration$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<WirelessTcpConfiguration, Builder> implements WirelessTcpConfigurationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearSocketReadTimeoutMs() {
            copyOnWrite();
            ((WirelessTcpConfiguration) this.instance).clearSocketReadTimeoutMs();
            return this;
        }

        public Builder clearSocketReceiveBufferSizeKb() {
            copyOnWrite();
            ((WirelessTcpConfiguration) this.instance).clearSocketReceiveBufferSizeKb();
            return this;
        }

        public Builder clearSocketSendBufferSizeKb() {
            copyOnWrite();
            ((WirelessTcpConfiguration) this.instance).clearSocketSendBufferSizeKb();
            return this;
        }

        @Override // fr.sd.taada.proto.WirelessTcpConfigurationOrBuilder
        public int getSocketReadTimeoutMs() {
            return ((WirelessTcpConfiguration) this.instance).getSocketReadTimeoutMs();
        }

        @Override // fr.sd.taada.proto.WirelessTcpConfigurationOrBuilder
        public int getSocketReceiveBufferSizeKb() {
            return ((WirelessTcpConfiguration) this.instance).getSocketReceiveBufferSizeKb();
        }

        @Override // fr.sd.taada.proto.WirelessTcpConfigurationOrBuilder
        public int getSocketSendBufferSizeKb() {
            return ((WirelessTcpConfiguration) this.instance).getSocketSendBufferSizeKb();
        }

        @Override // fr.sd.taada.proto.WirelessTcpConfigurationOrBuilder
        public boolean hasSocketReadTimeoutMs() {
            return ((WirelessTcpConfiguration) this.instance).hasSocketReadTimeoutMs();
        }

        @Override // fr.sd.taada.proto.WirelessTcpConfigurationOrBuilder
        public boolean hasSocketReceiveBufferSizeKb() {
            return ((WirelessTcpConfiguration) this.instance).hasSocketReceiveBufferSizeKb();
        }

        @Override // fr.sd.taada.proto.WirelessTcpConfigurationOrBuilder
        public boolean hasSocketSendBufferSizeKb() {
            return ((WirelessTcpConfiguration) this.instance).hasSocketSendBufferSizeKb();
        }

        public Builder setSocketReadTimeoutMs(int i) {
            copyOnWrite();
            ((WirelessTcpConfiguration) this.instance).setSocketReadTimeoutMs(i);
            return this;
        }

        public Builder setSocketReceiveBufferSizeKb(int i) {
            copyOnWrite();
            ((WirelessTcpConfiguration) this.instance).setSocketReceiveBufferSizeKb(i);
            return this;
        }

        public Builder setSocketSendBufferSizeKb(int i) {
            copyOnWrite();
            ((WirelessTcpConfiguration) this.instance).setSocketSendBufferSizeKb(i);
            return this;
        }

        private Builder() {
            super(WirelessTcpConfiguration.DEFAULT_INSTANCE);
        }
    }

    static {
        WirelessTcpConfiguration wirelessTcpConfiguration = new WirelessTcpConfiguration();
        DEFAULT_INSTANCE = wirelessTcpConfiguration;
        GeneratedMessageLite.registerDefaultInstance(WirelessTcpConfiguration.class, wirelessTcpConfiguration);
    }

    private WirelessTcpConfiguration() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSocketReadTimeoutMs() {
        this.bitField0_ &= -5;
        this.socketReadTimeoutMs_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSocketReceiveBufferSizeKb() {
        this.bitField0_ &= -2;
        this.socketReceiveBufferSizeKb_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSocketSendBufferSizeKb() {
        this.bitField0_ &= -3;
        this.socketSendBufferSizeKb_ = 0;
    }

    public static WirelessTcpConfiguration getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static WirelessTcpConfiguration parseDelimitedFrom(InputStream inputStream) {
        return (WirelessTcpConfiguration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WirelessTcpConfiguration parseFrom(ByteBuffer byteBuffer) {
        return (WirelessTcpConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<WirelessTcpConfiguration> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSocketReadTimeoutMs(int i) {
        this.bitField0_ |= 4;
        this.socketReadTimeoutMs_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSocketReceiveBufferSizeKb(int i) {
        this.bitField0_ |= 1;
        this.socketReceiveBufferSizeKb_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSocketSendBufferSizeKb(int i) {
        this.bitField0_ |= 2;
        this.socketSendBufferSizeKb_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new WirelessTcpConfiguration();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0000\u0002\u000b\u0001\u0003\u000b\u0002", new Object[]{"bitField0_", "socketReceiveBufferSizeKb_", "socketSendBufferSizeKb_", "socketReadTimeoutMs_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<WirelessTcpConfiguration> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (WirelessTcpConfiguration.class) {
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

    @Override // fr.sd.taada.proto.WirelessTcpConfigurationOrBuilder
    public int getSocketReadTimeoutMs() {
        return this.socketReadTimeoutMs_;
    }

    @Override // fr.sd.taada.proto.WirelessTcpConfigurationOrBuilder
    public int getSocketReceiveBufferSizeKb() {
        return this.socketReceiveBufferSizeKb_;
    }

    @Override // fr.sd.taada.proto.WirelessTcpConfigurationOrBuilder
    public int getSocketSendBufferSizeKb() {
        return this.socketSendBufferSizeKb_;
    }

    @Override // fr.sd.taada.proto.WirelessTcpConfigurationOrBuilder
    public boolean hasSocketReadTimeoutMs() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.WirelessTcpConfigurationOrBuilder
    public boolean hasSocketReceiveBufferSizeKb() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.WirelessTcpConfigurationOrBuilder
    public boolean hasSocketSendBufferSizeKb() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(WirelessTcpConfiguration wirelessTcpConfiguration) {
        return DEFAULT_INSTANCE.createBuilder(wirelessTcpConfiguration);
    }

    public static WirelessTcpConfiguration parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WirelessTcpConfiguration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WirelessTcpConfiguration parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (WirelessTcpConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static WirelessTcpConfiguration parseFrom(ByteString byteString) {
        return (WirelessTcpConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static WirelessTcpConfiguration parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (WirelessTcpConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static WirelessTcpConfiguration parseFrom(byte[] bArr) {
        return (WirelessTcpConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WirelessTcpConfiguration parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (WirelessTcpConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static WirelessTcpConfiguration parseFrom(InputStream inputStream) {
        return (WirelessTcpConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WirelessTcpConfiguration parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WirelessTcpConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WirelessTcpConfiguration parseFrom(CodedInputStream codedInputStream) {
        return (WirelessTcpConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static WirelessTcpConfiguration parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WirelessTcpConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
