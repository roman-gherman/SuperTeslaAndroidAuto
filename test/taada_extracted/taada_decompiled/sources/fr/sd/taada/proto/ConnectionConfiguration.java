package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.PingConfiguration;
import fr.sd.taada.proto.WirelessTcpConfiguration;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class ConnectionConfiguration extends GeneratedMessageLite<ConnectionConfiguration, Builder> implements ConnectionConfigurationOrBuilder {
    private static final ConnectionConfiguration DEFAULT_INSTANCE;
    private static volatile Parser<ConnectionConfiguration> PARSER = null;
    public static final int PING_CONFIGURATION_FIELD_NUMBER = 1;
    public static final int WIRELESS_TCP_CONFIGURATION_FIELD_NUMBER = 2;
    private int bitField0_;
    private PingConfiguration pingConfiguration_;
    private WirelessTcpConfiguration wirelessTcpConfiguration_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.ConnectionConfiguration$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ConnectionConfiguration, Builder> implements ConnectionConfigurationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearPingConfiguration() {
            copyOnWrite();
            ((ConnectionConfiguration) this.instance).clearPingConfiguration();
            return this;
        }

        public Builder clearWirelessTcpConfiguration() {
            copyOnWrite();
            ((ConnectionConfiguration) this.instance).clearWirelessTcpConfiguration();
            return this;
        }

        @Override // fr.sd.taada.proto.ConnectionConfigurationOrBuilder
        public PingConfiguration getPingConfiguration() {
            return ((ConnectionConfiguration) this.instance).getPingConfiguration();
        }

        @Override // fr.sd.taada.proto.ConnectionConfigurationOrBuilder
        public WirelessTcpConfiguration getWirelessTcpConfiguration() {
            return ((ConnectionConfiguration) this.instance).getWirelessTcpConfiguration();
        }

        @Override // fr.sd.taada.proto.ConnectionConfigurationOrBuilder
        public boolean hasPingConfiguration() {
            return ((ConnectionConfiguration) this.instance).hasPingConfiguration();
        }

        @Override // fr.sd.taada.proto.ConnectionConfigurationOrBuilder
        public boolean hasWirelessTcpConfiguration() {
            return ((ConnectionConfiguration) this.instance).hasWirelessTcpConfiguration();
        }

        public Builder mergePingConfiguration(PingConfiguration pingConfiguration) {
            copyOnWrite();
            ((ConnectionConfiguration) this.instance).mergePingConfiguration(pingConfiguration);
            return this;
        }

        public Builder mergeWirelessTcpConfiguration(WirelessTcpConfiguration wirelessTcpConfiguration) {
            copyOnWrite();
            ((ConnectionConfiguration) this.instance).mergeWirelessTcpConfiguration(wirelessTcpConfiguration);
            return this;
        }

        public Builder setPingConfiguration(PingConfiguration pingConfiguration) {
            copyOnWrite();
            ((ConnectionConfiguration) this.instance).setPingConfiguration(pingConfiguration);
            return this;
        }

        public Builder setWirelessTcpConfiguration(WirelessTcpConfiguration wirelessTcpConfiguration) {
            copyOnWrite();
            ((ConnectionConfiguration) this.instance).setWirelessTcpConfiguration(wirelessTcpConfiguration);
            return this;
        }

        private Builder() {
            super(ConnectionConfiguration.DEFAULT_INSTANCE);
        }

        public Builder setPingConfiguration(PingConfiguration.Builder builder) {
            copyOnWrite();
            ((ConnectionConfiguration) this.instance).setPingConfiguration(builder);
            return this;
        }

        public Builder setWirelessTcpConfiguration(WirelessTcpConfiguration.Builder builder) {
            copyOnWrite();
            ((ConnectionConfiguration) this.instance).setWirelessTcpConfiguration(builder);
            return this;
        }
    }

    static {
        ConnectionConfiguration connectionConfiguration = new ConnectionConfiguration();
        DEFAULT_INSTANCE = connectionConfiguration;
        GeneratedMessageLite.registerDefaultInstance(ConnectionConfiguration.class, connectionConfiguration);
    }

    private ConnectionConfiguration() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPingConfiguration() {
        this.pingConfiguration_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWirelessTcpConfiguration() {
        this.wirelessTcpConfiguration_ = null;
        this.bitField0_ &= -3;
    }

    public static ConnectionConfiguration getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePingConfiguration(PingConfiguration pingConfiguration) {
        pingConfiguration.getClass();
        PingConfiguration pingConfiguration2 = this.pingConfiguration_;
        if (pingConfiguration2 == null || pingConfiguration2 == PingConfiguration.getDefaultInstance()) {
            this.pingConfiguration_ = pingConfiguration;
        } else {
            this.pingConfiguration_ = PingConfiguration.newBuilder(this.pingConfiguration_).mergeFrom(pingConfiguration).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeWirelessTcpConfiguration(WirelessTcpConfiguration wirelessTcpConfiguration) {
        wirelessTcpConfiguration.getClass();
        WirelessTcpConfiguration wirelessTcpConfiguration2 = this.wirelessTcpConfiguration_;
        if (wirelessTcpConfiguration2 == null || wirelessTcpConfiguration2 == WirelessTcpConfiguration.getDefaultInstance()) {
            this.wirelessTcpConfiguration_ = wirelessTcpConfiguration;
        } else {
            this.wirelessTcpConfiguration_ = WirelessTcpConfiguration.newBuilder(this.wirelessTcpConfiguration_).mergeFrom(wirelessTcpConfiguration).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ConnectionConfiguration parseDelimitedFrom(InputStream inputStream) {
        return (ConnectionConfiguration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConnectionConfiguration parseFrom(ByteBuffer byteBuffer) {
        return (ConnectionConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ConnectionConfiguration> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPingConfiguration(PingConfiguration pingConfiguration) {
        pingConfiguration.getClass();
        this.pingConfiguration_ = pingConfiguration;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWirelessTcpConfiguration(WirelessTcpConfiguration wirelessTcpConfiguration) {
        wirelessTcpConfiguration.getClass();
        this.wirelessTcpConfiguration_ = wirelessTcpConfiguration;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ConnectionConfiguration();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001", new Object[]{"bitField0_", "pingConfiguration_", "wirelessTcpConfiguration_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ConnectionConfiguration> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ConnectionConfiguration.class) {
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

    @Override // fr.sd.taada.proto.ConnectionConfigurationOrBuilder
    public PingConfiguration getPingConfiguration() {
        PingConfiguration pingConfiguration = this.pingConfiguration_;
        return pingConfiguration == null ? PingConfiguration.getDefaultInstance() : pingConfiguration;
    }

    @Override // fr.sd.taada.proto.ConnectionConfigurationOrBuilder
    public WirelessTcpConfiguration getWirelessTcpConfiguration() {
        WirelessTcpConfiguration wirelessTcpConfiguration = this.wirelessTcpConfiguration_;
        return wirelessTcpConfiguration == null ? WirelessTcpConfiguration.getDefaultInstance() : wirelessTcpConfiguration;
    }

    @Override // fr.sd.taada.proto.ConnectionConfigurationOrBuilder
    public boolean hasPingConfiguration() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.ConnectionConfigurationOrBuilder
    public boolean hasWirelessTcpConfiguration() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(ConnectionConfiguration connectionConfiguration) {
        return DEFAULT_INSTANCE.createBuilder(connectionConfiguration);
    }

    public static ConnectionConfiguration parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ConnectionConfiguration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ConnectionConfiguration parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ConnectionConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ConnectionConfiguration parseFrom(ByteString byteString) {
        return (ConnectionConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ConnectionConfiguration parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ConnectionConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPingConfiguration(PingConfiguration.Builder builder) {
        this.pingConfiguration_ = builder.build();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWirelessTcpConfiguration(WirelessTcpConfiguration.Builder builder) {
        this.wirelessTcpConfiguration_ = builder.build();
        this.bitField0_ |= 2;
    }

    public static ConnectionConfiguration parseFrom(byte[] bArr) {
        return (ConnectionConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ConnectionConfiguration parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ConnectionConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ConnectionConfiguration parseFrom(InputStream inputStream) {
        return (ConnectionConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConnectionConfiguration parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ConnectionConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ConnectionConfiguration parseFrom(CodedInputStream codedInputStream) {
        return (ConnectionConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ConnectionConfiguration parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ConnectionConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
