package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.ConnectionConfiguration;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class VersionResponseOptions extends GeneratedMessageLite<VersionResponseOptions, Builder> implements VersionResponseOptionsOrBuilder {
    public static final int CONNECTION_CONFIGURATION_FIELD_NUMBER = 1;
    private static final VersionResponseOptions DEFAULT_INSTANCE;
    private static volatile Parser<VersionResponseOptions> PARSER;
    private int bitField0_;
    private ConnectionConfiguration connectionConfiguration_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.VersionResponseOptions$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<VersionResponseOptions, Builder> implements VersionResponseOptionsOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearConnectionConfiguration() {
            copyOnWrite();
            ((VersionResponseOptions) this.instance).clearConnectionConfiguration();
            return this;
        }

        @Override // fr.sd.taada.proto.VersionResponseOptionsOrBuilder
        public ConnectionConfiguration getConnectionConfiguration() {
            return ((VersionResponseOptions) this.instance).getConnectionConfiguration();
        }

        @Override // fr.sd.taada.proto.VersionResponseOptionsOrBuilder
        public boolean hasConnectionConfiguration() {
            return ((VersionResponseOptions) this.instance).hasConnectionConfiguration();
        }

        public Builder mergeConnectionConfiguration(ConnectionConfiguration connectionConfiguration) {
            copyOnWrite();
            ((VersionResponseOptions) this.instance).mergeConnectionConfiguration(connectionConfiguration);
            return this;
        }

        public Builder setConnectionConfiguration(ConnectionConfiguration connectionConfiguration) {
            copyOnWrite();
            ((VersionResponseOptions) this.instance).setConnectionConfiguration(connectionConfiguration);
            return this;
        }

        private Builder() {
            super(VersionResponseOptions.DEFAULT_INSTANCE);
        }

        public Builder setConnectionConfiguration(ConnectionConfiguration.Builder builder) {
            copyOnWrite();
            ((VersionResponseOptions) this.instance).setConnectionConfiguration(builder);
            return this;
        }
    }

    static {
        VersionResponseOptions versionResponseOptions = new VersionResponseOptions();
        DEFAULT_INSTANCE = versionResponseOptions;
        GeneratedMessageLite.registerDefaultInstance(VersionResponseOptions.class, versionResponseOptions);
    }

    private VersionResponseOptions() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConnectionConfiguration() {
        this.connectionConfiguration_ = null;
        this.bitField0_ &= -2;
    }

    public static VersionResponseOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeConnectionConfiguration(ConnectionConfiguration connectionConfiguration) {
        connectionConfiguration.getClass();
        ConnectionConfiguration connectionConfiguration2 = this.connectionConfiguration_;
        if (connectionConfiguration2 == null || connectionConfiguration2 == ConnectionConfiguration.getDefaultInstance()) {
            this.connectionConfiguration_ = connectionConfiguration;
        } else {
            this.connectionConfiguration_ = ConnectionConfiguration.newBuilder(this.connectionConfiguration_).mergeFrom(connectionConfiguration).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static VersionResponseOptions parseDelimitedFrom(InputStream inputStream) {
        return (VersionResponseOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VersionResponseOptions parseFrom(ByteBuffer byteBuffer) {
        return (VersionResponseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<VersionResponseOptions> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionConfiguration(ConnectionConfiguration connectionConfiguration) {
        connectionConfiguration.getClass();
        this.connectionConfiguration_ = connectionConfiguration;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new VersionResponseOptions();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t\u0000", new Object[]{"bitField0_", "connectionConfiguration_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<VersionResponseOptions> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (VersionResponseOptions.class) {
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

    @Override // fr.sd.taada.proto.VersionResponseOptionsOrBuilder
    public ConnectionConfiguration getConnectionConfiguration() {
        ConnectionConfiguration connectionConfiguration = this.connectionConfiguration_;
        return connectionConfiguration == null ? ConnectionConfiguration.getDefaultInstance() : connectionConfiguration;
    }

    @Override // fr.sd.taada.proto.VersionResponseOptionsOrBuilder
    public boolean hasConnectionConfiguration() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(VersionResponseOptions versionResponseOptions) {
        return DEFAULT_INSTANCE.createBuilder(versionResponseOptions);
    }

    public static VersionResponseOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VersionResponseOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VersionResponseOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (VersionResponseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static VersionResponseOptions parseFrom(ByteString byteString) {
        return (VersionResponseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static VersionResponseOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (VersionResponseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectionConfiguration(ConnectionConfiguration.Builder builder) {
        this.connectionConfiguration_ = builder.build();
        this.bitField0_ |= 1;
    }

    public static VersionResponseOptions parseFrom(byte[] bArr) {
        return (VersionResponseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VersionResponseOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (VersionResponseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static VersionResponseOptions parseFrom(InputStream inputStream) {
        return (VersionResponseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VersionResponseOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VersionResponseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VersionResponseOptions parseFrom(CodedInputStream codedInputStream) {
        return (VersionResponseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static VersionResponseOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VersionResponseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
