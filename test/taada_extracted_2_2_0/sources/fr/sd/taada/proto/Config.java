package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Config extends GeneratedMessageLite<Config, Builder> implements ConfigOrBuilder {
    public static final int CONFIGURATION_INDICES_FIELD_NUMBER = 3;
    private static final Config DEFAULT_INSTANCE;
    public static final int MAX_UNACKED_FIELD_NUMBER = 2;
    private static volatile Parser<Config> PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int bitField0_;
    private int maxUnacked_;
    private byte memoizedIsInitialized = 2;
    private int status_ = 1;
    private Internal.IntList configurationIndices_ = GeneratedMessageLite.emptyIntList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.Config$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Config, Builder> implements ConfigOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllConfigurationIndices(Iterable<? extends Integer> iterable) {
            copyOnWrite();
            ((Config) this.instance).addAllConfigurationIndices(iterable);
            return this;
        }

        public Builder addConfigurationIndices(int i) {
            copyOnWrite();
            ((Config) this.instance).addConfigurationIndices(i);
            return this;
        }

        public Builder clearConfigurationIndices() {
            copyOnWrite();
            ((Config) this.instance).clearConfigurationIndices();
            return this;
        }

        public Builder clearMaxUnacked() {
            copyOnWrite();
            ((Config) this.instance).clearMaxUnacked();
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((Config) this.instance).clearStatus();
            return this;
        }

        @Override // fr.sd.taada.proto.ConfigOrBuilder
        public int getConfigurationIndices(int i) {
            return ((Config) this.instance).getConfigurationIndices(i);
        }

        @Override // fr.sd.taada.proto.ConfigOrBuilder
        public int getConfigurationIndicesCount() {
            return ((Config) this.instance).getConfigurationIndicesCount();
        }

        @Override // fr.sd.taada.proto.ConfigOrBuilder
        public List<Integer> getConfigurationIndicesList() {
            return Collections.unmodifiableList(((Config) this.instance).getConfigurationIndicesList());
        }

        @Override // fr.sd.taada.proto.ConfigOrBuilder
        public int getMaxUnacked() {
            return ((Config) this.instance).getMaxUnacked();
        }

        @Override // fr.sd.taada.proto.ConfigOrBuilder
        public Status getStatus() {
            return ((Config) this.instance).getStatus();
        }

        @Override // fr.sd.taada.proto.ConfigOrBuilder
        public boolean hasMaxUnacked() {
            return ((Config) this.instance).hasMaxUnacked();
        }

        @Override // fr.sd.taada.proto.ConfigOrBuilder
        public boolean hasStatus() {
            return ((Config) this.instance).hasStatus();
        }

        public Builder setConfigurationIndices(int i, int i3) {
            copyOnWrite();
            ((Config) this.instance).setConfigurationIndices(i, i3);
            return this;
        }

        public Builder setMaxUnacked(int i) {
            copyOnWrite();
            ((Config) this.instance).setMaxUnacked(i);
            return this;
        }

        public Builder setStatus(Status status) {
            copyOnWrite();
            ((Config) this.instance).setStatus(status);
            return this;
        }

        private Builder() {
            super(Config.DEFAULT_INSTANCE);
        }
    }

    public enum Status implements Internal.EnumLite {
        STATUS_WAIT(1),
        STATUS_READY(2);

        public static final int STATUS_READY_VALUE = 2;
        public static final int STATUS_WAIT_VALUE = 1;
        private static final Internal.EnumLiteMap<Status> internalValueMap = new Internal.EnumLiteMap<Status>() { // from class: fr.sd.taada.proto.Config.Status.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Status findValueByNumber(int i) {
                return Status.forNumber(i);
            }
        };
        private final int value;

        public static final class StatusVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new StatusVerifier();

            private StatusVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return Status.forNumber(i) != null;
            }
        }

        Status(int i) {
            this.value = i;
        }

        public static Status forNumber(int i) {
            if (i == 1) {
                return STATUS_WAIT;
            }
            if (i != 2) {
                return null;
            }
            return STATUS_READY;
        }

        public static Internal.EnumLiteMap<Status> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return StatusVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static Status valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        Config config = new Config();
        DEFAULT_INSTANCE = config;
        GeneratedMessageLite.registerDefaultInstance(Config.class, config);
    }

    private Config() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllConfigurationIndices(Iterable<? extends Integer> iterable) {
        ensureConfigurationIndicesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.configurationIndices_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConfigurationIndices(int i) {
        ensureConfigurationIndicesIsMutable();
        this.configurationIndices_.addInt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConfigurationIndices() {
        this.configurationIndices_ = GeneratedMessageLite.emptyIntList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaxUnacked() {
        this.bitField0_ &= -3;
        this.maxUnacked_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.bitField0_ &= -2;
        this.status_ = 1;
    }

    private void ensureConfigurationIndicesIsMutable() {
        if (this.configurationIndices_.isModifiable()) {
            return;
        }
        this.configurationIndices_ = GeneratedMessageLite.mutableCopy(this.configurationIndices_);
    }

    public static Config getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Config parseDelimitedFrom(InputStream inputStream) {
        return (Config) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Config parseFrom(ByteBuffer byteBuffer) {
        return (Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Config> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConfigurationIndices(int i, int i3) {
        ensureConfigurationIndicesIsMutable();
        this.configurationIndices_.setInt(i, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaxUnacked(int i) {
        this.bitField0_ |= 2;
        this.maxUnacked_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(Status status) {
        status.getClass();
        this.bitField0_ |= 1;
        this.status_ = status.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Config();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001Ԍ\u0000\u0002\u000b\u0001\u0003\u001d", new Object[]{"bitField0_", "status_", Status.internalGetVerifier(), "maxUnacked_", "configurationIndices_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Config> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Config.class) {
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

    @Override // fr.sd.taada.proto.ConfigOrBuilder
    public int getConfigurationIndices(int i) {
        return this.configurationIndices_.getInt(i);
    }

    @Override // fr.sd.taada.proto.ConfigOrBuilder
    public int getConfigurationIndicesCount() {
        return this.configurationIndices_.size();
    }

    @Override // fr.sd.taada.proto.ConfigOrBuilder
    public List<Integer> getConfigurationIndicesList() {
        return this.configurationIndices_;
    }

    @Override // fr.sd.taada.proto.ConfigOrBuilder
    public int getMaxUnacked() {
        return this.maxUnacked_;
    }

    @Override // fr.sd.taada.proto.ConfigOrBuilder
    public Status getStatus() {
        Status statusForNumber = Status.forNumber(this.status_);
        return statusForNumber == null ? Status.STATUS_WAIT : statusForNumber;
    }

    @Override // fr.sd.taada.proto.ConfigOrBuilder
    public boolean hasMaxUnacked() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.ConfigOrBuilder
    public boolean hasStatus() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(Config config) {
        return DEFAULT_INSTANCE.createBuilder(config);
    }

    public static Config parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Config) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Config parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Config parseFrom(ByteString byteString) {
        return (Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Config parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Config parseFrom(byte[] bArr) {
        return (Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Config parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Config parseFrom(InputStream inputStream) {
        return (Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Config parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Config parseFrom(CodedInputStream codedInputStream) {
        return (Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Config parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Config) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
