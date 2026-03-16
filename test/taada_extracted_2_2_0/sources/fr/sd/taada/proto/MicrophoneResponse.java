package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class MicrophoneResponse extends GeneratedMessageLite<MicrophoneResponse, Builder> implements MicrophoneResponseOrBuilder {
    private static final MicrophoneResponse DEFAULT_INSTANCE;
    private static volatile Parser<MicrophoneResponse> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int sessionId_;
    private int status_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.MicrophoneResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<MicrophoneResponse, Builder> implements MicrophoneResponseOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((MicrophoneResponse) this.instance).clearSessionId();
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((MicrophoneResponse) this.instance).clearStatus();
            return this;
        }

        @Override // fr.sd.taada.proto.MicrophoneResponseOrBuilder
        public int getSessionId() {
            return ((MicrophoneResponse) this.instance).getSessionId();
        }

        @Override // fr.sd.taada.proto.MicrophoneResponseOrBuilder
        public int getStatus() {
            return ((MicrophoneResponse) this.instance).getStatus();
        }

        @Override // fr.sd.taada.proto.MicrophoneResponseOrBuilder
        public boolean hasSessionId() {
            return ((MicrophoneResponse) this.instance).hasSessionId();
        }

        @Override // fr.sd.taada.proto.MicrophoneResponseOrBuilder
        public boolean hasStatus() {
            return ((MicrophoneResponse) this.instance).hasStatus();
        }

        public Builder setSessionId(int i) {
            copyOnWrite();
            ((MicrophoneResponse) this.instance).setSessionId(i);
            return this;
        }

        public Builder setStatus(int i) {
            copyOnWrite();
            ((MicrophoneResponse) this.instance).setStatus(i);
            return this;
        }

        private Builder() {
            super(MicrophoneResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        MicrophoneResponse microphoneResponse = new MicrophoneResponse();
        DEFAULT_INSTANCE = microphoneResponse;
        GeneratedMessageLite.registerDefaultInstance(MicrophoneResponse.class, microphoneResponse);
    }

    private MicrophoneResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.bitField0_ &= -3;
        this.sessionId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.bitField0_ &= -2;
        this.status_ = 0;
    }

    public static MicrophoneResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MicrophoneResponse parseDelimitedFrom(InputStream inputStream) {
        return (MicrophoneResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MicrophoneResponse parseFrom(ByteBuffer byteBuffer) {
        return (MicrophoneResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MicrophoneResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionId(int i) {
        this.bitField0_ |= 2;
        this.sessionId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(int i) {
        this.bitField0_ |= 1;
        this.status_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MicrophoneResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001Ԅ\u0000\u0002\u0004\u0001", new Object[]{"bitField0_", "status_", "sessionId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MicrophoneResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MicrophoneResponse.class) {
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

    @Override // fr.sd.taada.proto.MicrophoneResponseOrBuilder
    public int getSessionId() {
        return this.sessionId_;
    }

    @Override // fr.sd.taada.proto.MicrophoneResponseOrBuilder
    public int getStatus() {
        return this.status_;
    }

    @Override // fr.sd.taada.proto.MicrophoneResponseOrBuilder
    public boolean hasSessionId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.MicrophoneResponseOrBuilder
    public boolean hasStatus() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(MicrophoneResponse microphoneResponse) {
        return DEFAULT_INSTANCE.createBuilder(microphoneResponse);
    }

    public static MicrophoneResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MicrophoneResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MicrophoneResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MicrophoneResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MicrophoneResponse parseFrom(ByteString byteString) {
        return (MicrophoneResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MicrophoneResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MicrophoneResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MicrophoneResponse parseFrom(byte[] bArr) {
        return (MicrophoneResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MicrophoneResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MicrophoneResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MicrophoneResponse parseFrom(InputStream inputStream) {
        return (MicrophoneResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MicrophoneResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MicrophoneResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MicrophoneResponse parseFrom(CodedInputStream codedInputStream) {
        return (MicrophoneResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MicrophoneResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MicrophoneResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
