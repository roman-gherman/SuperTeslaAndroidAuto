package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class PingConfiguration extends GeneratedMessageLite<PingConfiguration, Builder> implements PingConfigurationOrBuilder {
    private static final PingConfiguration DEFAULT_INSTANCE;
    public static final int HIGH_LATENCY_THRESHOLD_MS_FIELD_NUMBER = 3;
    public static final int INTERVAL_MS_FIELD_NUMBER = 2;
    private static volatile Parser<PingConfiguration> PARSER = null;
    public static final int TIMEOUT_MS_FIELD_NUMBER = 1;
    public static final int TRACKED_PING_COUNT_FIELD_NUMBER = 4;
    private int bitField0_;
    private int highLatencyThresholdMs_;
    private int intervalMs_;
    private int timeoutMs_;
    private int trackedPingCount_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.PingConfiguration$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<PingConfiguration, Builder> implements PingConfigurationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearHighLatencyThresholdMs() {
            copyOnWrite();
            ((PingConfiguration) this.instance).clearHighLatencyThresholdMs();
            return this;
        }

        public Builder clearIntervalMs() {
            copyOnWrite();
            ((PingConfiguration) this.instance).clearIntervalMs();
            return this;
        }

        public Builder clearTimeoutMs() {
            copyOnWrite();
            ((PingConfiguration) this.instance).clearTimeoutMs();
            return this;
        }

        public Builder clearTrackedPingCount() {
            copyOnWrite();
            ((PingConfiguration) this.instance).clearTrackedPingCount();
            return this;
        }

        @Override // fr.sd.taada.proto.PingConfigurationOrBuilder
        public int getHighLatencyThresholdMs() {
            return ((PingConfiguration) this.instance).getHighLatencyThresholdMs();
        }

        @Override // fr.sd.taada.proto.PingConfigurationOrBuilder
        public int getIntervalMs() {
            return ((PingConfiguration) this.instance).getIntervalMs();
        }

        @Override // fr.sd.taada.proto.PingConfigurationOrBuilder
        public int getTimeoutMs() {
            return ((PingConfiguration) this.instance).getTimeoutMs();
        }

        @Override // fr.sd.taada.proto.PingConfigurationOrBuilder
        public int getTrackedPingCount() {
            return ((PingConfiguration) this.instance).getTrackedPingCount();
        }

        @Override // fr.sd.taada.proto.PingConfigurationOrBuilder
        public boolean hasHighLatencyThresholdMs() {
            return ((PingConfiguration) this.instance).hasHighLatencyThresholdMs();
        }

        @Override // fr.sd.taada.proto.PingConfigurationOrBuilder
        public boolean hasIntervalMs() {
            return ((PingConfiguration) this.instance).hasIntervalMs();
        }

        @Override // fr.sd.taada.proto.PingConfigurationOrBuilder
        public boolean hasTimeoutMs() {
            return ((PingConfiguration) this.instance).hasTimeoutMs();
        }

        @Override // fr.sd.taada.proto.PingConfigurationOrBuilder
        public boolean hasTrackedPingCount() {
            return ((PingConfiguration) this.instance).hasTrackedPingCount();
        }

        public Builder setHighLatencyThresholdMs(int i) {
            copyOnWrite();
            ((PingConfiguration) this.instance).setHighLatencyThresholdMs(i);
            return this;
        }

        public Builder setIntervalMs(int i) {
            copyOnWrite();
            ((PingConfiguration) this.instance).setIntervalMs(i);
            return this;
        }

        public Builder setTimeoutMs(int i) {
            copyOnWrite();
            ((PingConfiguration) this.instance).setTimeoutMs(i);
            return this;
        }

        public Builder setTrackedPingCount(int i) {
            copyOnWrite();
            ((PingConfiguration) this.instance).setTrackedPingCount(i);
            return this;
        }

        private Builder() {
            super(PingConfiguration.DEFAULT_INSTANCE);
        }
    }

    static {
        PingConfiguration pingConfiguration = new PingConfiguration();
        DEFAULT_INSTANCE = pingConfiguration;
        GeneratedMessageLite.registerDefaultInstance(PingConfiguration.class, pingConfiguration);
    }

    private PingConfiguration() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHighLatencyThresholdMs() {
        this.bitField0_ &= -5;
        this.highLatencyThresholdMs_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIntervalMs() {
        this.bitField0_ &= -3;
        this.intervalMs_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimeoutMs() {
        this.bitField0_ &= -2;
        this.timeoutMs_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrackedPingCount() {
        this.bitField0_ &= -9;
        this.trackedPingCount_ = 0;
    }

    public static PingConfiguration getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PingConfiguration parseDelimitedFrom(InputStream inputStream) {
        return (PingConfiguration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PingConfiguration parseFrom(ByteBuffer byteBuffer) {
        return (PingConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PingConfiguration> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHighLatencyThresholdMs(int i) {
        this.bitField0_ |= 4;
        this.highLatencyThresholdMs_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIntervalMs(int i) {
        this.bitField0_ |= 2;
        this.intervalMs_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeoutMs(int i) {
        this.bitField0_ |= 1;
        this.timeoutMs_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackedPingCount(int i) {
        this.bitField0_ |= 8;
        this.trackedPingCount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PingConfiguration();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0000\u0002\u000b\u0001\u0003\u000b\u0002\u0004\u000b\u0003", new Object[]{"bitField0_", "timeoutMs_", "intervalMs_", "highLatencyThresholdMs_", "trackedPingCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PingConfiguration> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PingConfiguration.class) {
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

    @Override // fr.sd.taada.proto.PingConfigurationOrBuilder
    public int getHighLatencyThresholdMs() {
        return this.highLatencyThresholdMs_;
    }

    @Override // fr.sd.taada.proto.PingConfigurationOrBuilder
    public int getIntervalMs() {
        return this.intervalMs_;
    }

    @Override // fr.sd.taada.proto.PingConfigurationOrBuilder
    public int getTimeoutMs() {
        return this.timeoutMs_;
    }

    @Override // fr.sd.taada.proto.PingConfigurationOrBuilder
    public int getTrackedPingCount() {
        return this.trackedPingCount_;
    }

    @Override // fr.sd.taada.proto.PingConfigurationOrBuilder
    public boolean hasHighLatencyThresholdMs() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.PingConfigurationOrBuilder
    public boolean hasIntervalMs() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.PingConfigurationOrBuilder
    public boolean hasTimeoutMs() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.PingConfigurationOrBuilder
    public boolean hasTrackedPingCount() {
        return (this.bitField0_ & 8) != 0;
    }

    public static Builder newBuilder(PingConfiguration pingConfiguration) {
        return DEFAULT_INSTANCE.createBuilder(pingConfiguration);
    }

    public static PingConfiguration parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PingConfiguration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PingConfiguration parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PingConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PingConfiguration parseFrom(ByteString byteString) {
        return (PingConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PingConfiguration parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PingConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PingConfiguration parseFrom(byte[] bArr) {
        return (PingConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PingConfiguration parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PingConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PingConfiguration parseFrom(InputStream inputStream) {
        return (PingConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PingConfiguration parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PingConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PingConfiguration parseFrom(CodedInputStream codedInputStream) {
        return (PingConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PingConfiguration parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PingConfiguration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
