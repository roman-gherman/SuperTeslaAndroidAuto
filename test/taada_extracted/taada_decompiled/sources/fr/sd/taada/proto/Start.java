package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class Start extends GeneratedMessageLite<Start, Builder> implements StartOrBuilder {
    public static final int CONFIGURATION_INDEX_FIELD_NUMBER = 2;
    private static final Start DEFAULT_INSTANCE;
    private static volatile Parser<Start> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private int configurationIndex_;
    private byte memoizedIsInitialized = 2;
    private int sessionId_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.Start$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Start, Builder> implements StartOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearConfigurationIndex() {
            copyOnWrite();
            ((Start) this.instance).clearConfigurationIndex();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((Start) this.instance).clearSessionId();
            return this;
        }

        @Override // fr.sd.taada.proto.StartOrBuilder
        public int getConfigurationIndex() {
            return ((Start) this.instance).getConfigurationIndex();
        }

        @Override // fr.sd.taada.proto.StartOrBuilder
        public int getSessionId() {
            return ((Start) this.instance).getSessionId();
        }

        @Override // fr.sd.taada.proto.StartOrBuilder
        public boolean hasConfigurationIndex() {
            return ((Start) this.instance).hasConfigurationIndex();
        }

        @Override // fr.sd.taada.proto.StartOrBuilder
        public boolean hasSessionId() {
            return ((Start) this.instance).hasSessionId();
        }

        public Builder setConfigurationIndex(int i) {
            copyOnWrite();
            ((Start) this.instance).setConfigurationIndex(i);
            return this;
        }

        public Builder setSessionId(int i) {
            copyOnWrite();
            ((Start) this.instance).setSessionId(i);
            return this;
        }

        private Builder() {
            super(Start.DEFAULT_INSTANCE);
        }
    }

    static {
        Start start = new Start();
        DEFAULT_INSTANCE = start;
        GeneratedMessageLite.registerDefaultInstance(Start.class, start);
    }

    private Start() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConfigurationIndex() {
        this.bitField0_ &= -3;
        this.configurationIndex_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.bitField0_ &= -2;
        this.sessionId_ = 0;
    }

    public static Start getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Start parseDelimitedFrom(InputStream inputStream) {
        return (Start) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Start parseFrom(ByteBuffer byteBuffer) {
        return (Start) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Start> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConfigurationIndex(int i) {
        this.bitField0_ |= 2;
        this.configurationIndex_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionId(int i) {
        this.bitField0_ |= 1;
        this.sessionId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Start();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԅ\u0000\u0002ԋ\u0001", new Object[]{"bitField0_", "sessionId_", "configurationIndex_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Start> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Start.class) {
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

    @Override // fr.sd.taada.proto.StartOrBuilder
    public int getConfigurationIndex() {
        return this.configurationIndex_;
    }

    @Override // fr.sd.taada.proto.StartOrBuilder
    public int getSessionId() {
        return this.sessionId_;
    }

    @Override // fr.sd.taada.proto.StartOrBuilder
    public boolean hasConfigurationIndex() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.StartOrBuilder
    public boolean hasSessionId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(Start start) {
        return DEFAULT_INSTANCE.createBuilder(start);
    }

    public static Start parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Start) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Start parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Start) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Start parseFrom(ByteString byteString) {
        return (Start) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Start parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Start) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Start parseFrom(byte[] bArr) {
        return (Start) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Start parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Start) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Start parseFrom(InputStream inputStream) {
        return (Start) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Start parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Start) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Start parseFrom(CodedInputStream codedInputStream) {
        return (Start) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Start parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Start) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
