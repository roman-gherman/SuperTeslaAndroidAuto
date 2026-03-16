package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class RadioSourceResponse extends GeneratedMessageLite<RadioSourceResponse, Builder> implements RadioSourceResponseOrBuilder {
    private static final RadioSourceResponse DEFAULT_INSTANCE;
    private static volatile Parser<RadioSourceResponse> PARSER = null;
    public static final int RADIO_SOURCE_ENABLED_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean radioSourceEnabled_;
    private byte memoizedIsInitialized = 2;
    private int status_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.RadioSourceResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<RadioSourceResponse, Builder> implements RadioSourceResponseOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearRadioSourceEnabled() {
            copyOnWrite();
            ((RadioSourceResponse) this.instance).clearRadioSourceEnabled();
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((RadioSourceResponse) this.instance).clearStatus();
            return this;
        }

        @Override // fr.sd.taada.proto.RadioSourceResponseOrBuilder
        public boolean getRadioSourceEnabled() {
            return ((RadioSourceResponse) this.instance).getRadioSourceEnabled();
        }

        @Override // fr.sd.taada.proto.RadioSourceResponseOrBuilder
        public MessageStatus getStatus() {
            return ((RadioSourceResponse) this.instance).getStatus();
        }

        @Override // fr.sd.taada.proto.RadioSourceResponseOrBuilder
        public boolean hasRadioSourceEnabled() {
            return ((RadioSourceResponse) this.instance).hasRadioSourceEnabled();
        }

        @Override // fr.sd.taada.proto.RadioSourceResponseOrBuilder
        public boolean hasStatus() {
            return ((RadioSourceResponse) this.instance).hasStatus();
        }

        public Builder setRadioSourceEnabled(boolean z6) {
            copyOnWrite();
            ((RadioSourceResponse) this.instance).setRadioSourceEnabled(z6);
            return this;
        }

        public Builder setStatus(MessageStatus messageStatus) {
            copyOnWrite();
            ((RadioSourceResponse) this.instance).setStatus(messageStatus);
            return this;
        }

        private Builder() {
            super(RadioSourceResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        RadioSourceResponse radioSourceResponse = new RadioSourceResponse();
        DEFAULT_INSTANCE = radioSourceResponse;
        GeneratedMessageLite.registerDefaultInstance(RadioSourceResponse.class, radioSourceResponse);
    }

    private RadioSourceResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioSourceEnabled() {
        this.bitField0_ &= -3;
        this.radioSourceEnabled_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.bitField0_ &= -2;
        this.status_ = 1;
    }

    public static RadioSourceResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static RadioSourceResponse parseDelimitedFrom(InputStream inputStream) {
        return (RadioSourceResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RadioSourceResponse parseFrom(ByteBuffer byteBuffer) {
        return (RadioSourceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<RadioSourceResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioSourceEnabled(boolean z6) {
        this.bitField0_ |= 2;
        this.radioSourceEnabled_ = z6;
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
                return new RadioSourceResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001\f\u0000\u0002ԇ\u0001", new Object[]{"bitField0_", "status_", MessageStatus.internalGetVerifier(), "radioSourceEnabled_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RadioSourceResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (RadioSourceResponse.class) {
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

    @Override // fr.sd.taada.proto.RadioSourceResponseOrBuilder
    public boolean getRadioSourceEnabled() {
        return this.radioSourceEnabled_;
    }

    @Override // fr.sd.taada.proto.RadioSourceResponseOrBuilder
    public MessageStatus getStatus() {
        MessageStatus messageStatusForNumber = MessageStatus.forNumber(this.status_);
        return messageStatusForNumber == null ? MessageStatus.STATUS_UNSOLICITED_MESSAGE : messageStatusForNumber;
    }

    @Override // fr.sd.taada.proto.RadioSourceResponseOrBuilder
    public boolean hasRadioSourceEnabled() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.RadioSourceResponseOrBuilder
    public boolean hasStatus() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(RadioSourceResponse radioSourceResponse) {
        return DEFAULT_INSTANCE.createBuilder(radioSourceResponse);
    }

    public static RadioSourceResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioSourceResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RadioSourceResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioSourceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RadioSourceResponse parseFrom(ByteString byteString) {
        return (RadioSourceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RadioSourceResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioSourceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RadioSourceResponse parseFrom(byte[] bArr) {
        return (RadioSourceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RadioSourceResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioSourceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RadioSourceResponse parseFrom(InputStream inputStream) {
        return (RadioSourceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RadioSourceResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioSourceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RadioSourceResponse parseFrom(CodedInputStream codedInputStream) {
        return (RadioSourceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RadioSourceResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioSourceResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
