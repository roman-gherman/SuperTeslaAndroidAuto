package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class SeekStationResponse extends GeneratedMessageLite<SeekStationResponse, Builder> implements SeekStationResponseOrBuilder {
    private static final SeekStationResponse DEFAULT_INSTANCE;
    private static volatile Parser<SeekStationResponse> PARSER = null;
    public static final int RADIO_ID_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int bitField0_;
    private int radioId_;
    private byte memoizedIsInitialized = 2;
    private int status_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.SeekStationResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<SeekStationResponse, Builder> implements SeekStationResponseOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearRadioId() {
            copyOnWrite();
            ((SeekStationResponse) this.instance).clearRadioId();
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((SeekStationResponse) this.instance).clearStatus();
            return this;
        }

        @Override // fr.sd.taada.proto.SeekStationResponseOrBuilder
        public int getRadioId() {
            return ((SeekStationResponse) this.instance).getRadioId();
        }

        @Override // fr.sd.taada.proto.SeekStationResponseOrBuilder
        public MessageStatus getStatus() {
            return ((SeekStationResponse) this.instance).getStatus();
        }

        @Override // fr.sd.taada.proto.SeekStationResponseOrBuilder
        public boolean hasRadioId() {
            return ((SeekStationResponse) this.instance).hasRadioId();
        }

        @Override // fr.sd.taada.proto.SeekStationResponseOrBuilder
        public boolean hasStatus() {
            return ((SeekStationResponse) this.instance).hasStatus();
        }

        public Builder setRadioId(int i) {
            copyOnWrite();
            ((SeekStationResponse) this.instance).setRadioId(i);
            return this;
        }

        public Builder setStatus(MessageStatus messageStatus) {
            copyOnWrite();
            ((SeekStationResponse) this.instance).setStatus(messageStatus);
            return this;
        }

        private Builder() {
            super(SeekStationResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        SeekStationResponse seekStationResponse = new SeekStationResponse();
        DEFAULT_INSTANCE = seekStationResponse;
        GeneratedMessageLite.registerDefaultInstance(SeekStationResponse.class, seekStationResponse);
    }

    private SeekStationResponse() {
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

    public static SeekStationResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SeekStationResponse parseDelimitedFrom(InputStream inputStream) {
        return (SeekStationResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SeekStationResponse parseFrom(ByteBuffer byteBuffer) {
        return (SeekStationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SeekStationResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
                return new SeekStationResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001\f\u0000\u0002Ԅ\u0001", new Object[]{"bitField0_", "status_", MessageStatus.internalGetVerifier(), "radioId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SeekStationResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SeekStationResponse.class) {
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

    @Override // fr.sd.taada.proto.SeekStationResponseOrBuilder
    public int getRadioId() {
        return this.radioId_;
    }

    @Override // fr.sd.taada.proto.SeekStationResponseOrBuilder
    public MessageStatus getStatus() {
        MessageStatus messageStatusForNumber = MessageStatus.forNumber(this.status_);
        return messageStatusForNumber == null ? MessageStatus.STATUS_UNSOLICITED_MESSAGE : messageStatusForNumber;
    }

    @Override // fr.sd.taada.proto.SeekStationResponseOrBuilder
    public boolean hasRadioId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.SeekStationResponseOrBuilder
    public boolean hasStatus() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(SeekStationResponse seekStationResponse) {
        return DEFAULT_INSTANCE.createBuilder(seekStationResponse);
    }

    public static SeekStationResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SeekStationResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SeekStationResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (SeekStationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SeekStationResponse parseFrom(ByteString byteString) {
        return (SeekStationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SeekStationResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SeekStationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SeekStationResponse parseFrom(byte[] bArr) {
        return (SeekStationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SeekStationResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (SeekStationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SeekStationResponse parseFrom(InputStream inputStream) {
        return (SeekStationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SeekStationResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SeekStationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SeekStationResponse parseFrom(CodedInputStream codedInputStream) {
        return (SeekStationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SeekStationResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SeekStationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
