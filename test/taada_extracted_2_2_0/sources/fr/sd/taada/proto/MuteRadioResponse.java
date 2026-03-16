package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class MuteRadioResponse extends GeneratedMessageLite<MuteRadioResponse, Builder> implements MuteRadioResponseOrBuilder {
    private static final MuteRadioResponse DEFAULT_INSTANCE;
    public static final int MUTED_FIELD_NUMBER = 3;
    private static volatile Parser<MuteRadioResponse> PARSER = null;
    public static final int RADIO_ID_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean muted_;
    private int radioId_;
    private int status_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.MuteRadioResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<MuteRadioResponse, Builder> implements MuteRadioResponseOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearMuted() {
            copyOnWrite();
            ((MuteRadioResponse) this.instance).clearMuted();
            return this;
        }

        public Builder clearRadioId() {
            copyOnWrite();
            ((MuteRadioResponse) this.instance).clearRadioId();
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((MuteRadioResponse) this.instance).clearStatus();
            return this;
        }

        @Override // fr.sd.taada.proto.MuteRadioResponseOrBuilder
        public boolean getMuted() {
            return ((MuteRadioResponse) this.instance).getMuted();
        }

        @Override // fr.sd.taada.proto.MuteRadioResponseOrBuilder
        public int getRadioId() {
            return ((MuteRadioResponse) this.instance).getRadioId();
        }

        @Override // fr.sd.taada.proto.MuteRadioResponseOrBuilder
        public MessageStatus getStatus() {
            return ((MuteRadioResponse) this.instance).getStatus();
        }

        @Override // fr.sd.taada.proto.MuteRadioResponseOrBuilder
        public boolean hasMuted() {
            return ((MuteRadioResponse) this.instance).hasMuted();
        }

        @Override // fr.sd.taada.proto.MuteRadioResponseOrBuilder
        public boolean hasRadioId() {
            return ((MuteRadioResponse) this.instance).hasRadioId();
        }

        @Override // fr.sd.taada.proto.MuteRadioResponseOrBuilder
        public boolean hasStatus() {
            return ((MuteRadioResponse) this.instance).hasStatus();
        }

        public Builder setMuted(boolean z6) {
            copyOnWrite();
            ((MuteRadioResponse) this.instance).setMuted(z6);
            return this;
        }

        public Builder setRadioId(int i) {
            copyOnWrite();
            ((MuteRadioResponse) this.instance).setRadioId(i);
            return this;
        }

        public Builder setStatus(MessageStatus messageStatus) {
            copyOnWrite();
            ((MuteRadioResponse) this.instance).setStatus(messageStatus);
            return this;
        }

        private Builder() {
            super(MuteRadioResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        MuteRadioResponse muteRadioResponse = new MuteRadioResponse();
        DEFAULT_INSTANCE = muteRadioResponse;
        GeneratedMessageLite.registerDefaultInstance(MuteRadioResponse.class, muteRadioResponse);
    }

    private MuteRadioResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMuted() {
        this.bitField0_ &= -5;
        this.muted_ = false;
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

    public static MuteRadioResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MuteRadioResponse parseDelimitedFrom(InputStream inputStream) {
        return (MuteRadioResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MuteRadioResponse parseFrom(ByteBuffer byteBuffer) {
        return (MuteRadioResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MuteRadioResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMuted(boolean z6) {
        this.bitField0_ |= 4;
        this.muted_ = z6;
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
                return new MuteRadioResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\u0004\u0001\u0003\u0007\u0002", new Object[]{"bitField0_", "status_", MessageStatus.internalGetVerifier(), "radioId_", "muted_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MuteRadioResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MuteRadioResponse.class) {
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

    @Override // fr.sd.taada.proto.MuteRadioResponseOrBuilder
    public boolean getMuted() {
        return this.muted_;
    }

    @Override // fr.sd.taada.proto.MuteRadioResponseOrBuilder
    public int getRadioId() {
        return this.radioId_;
    }

    @Override // fr.sd.taada.proto.MuteRadioResponseOrBuilder
    public MessageStatus getStatus() {
        MessageStatus messageStatusForNumber = MessageStatus.forNumber(this.status_);
        return messageStatusForNumber == null ? MessageStatus.STATUS_UNSOLICITED_MESSAGE : messageStatusForNumber;
    }

    @Override // fr.sd.taada.proto.MuteRadioResponseOrBuilder
    public boolean hasMuted() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.MuteRadioResponseOrBuilder
    public boolean hasRadioId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.MuteRadioResponseOrBuilder
    public boolean hasStatus() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(MuteRadioResponse muteRadioResponse) {
        return DEFAULT_INSTANCE.createBuilder(muteRadioResponse);
    }

    public static MuteRadioResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MuteRadioResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MuteRadioResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MuteRadioResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MuteRadioResponse parseFrom(ByteString byteString) {
        return (MuteRadioResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MuteRadioResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MuteRadioResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MuteRadioResponse parseFrom(byte[] bArr) {
        return (MuteRadioResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MuteRadioResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MuteRadioResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MuteRadioResponse parseFrom(InputStream inputStream) {
        return (MuteRadioResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MuteRadioResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MuteRadioResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MuteRadioResponse parseFrom(CodedInputStream codedInputStream) {
        return (MuteRadioResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MuteRadioResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MuteRadioResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
