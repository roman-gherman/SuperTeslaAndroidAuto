package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class ScanStationsResponse extends GeneratedMessageLite<ScanStationsResponse, Builder> implements ScanStationsResponseOrBuilder {
    private static final ScanStationsResponse DEFAULT_INSTANCE;
    private static volatile Parser<ScanStationsResponse> PARSER = null;
    public static final int RADIO_ID_FIELD_NUMBER = 2;
    public static final int STARTED_FIELD_NUMBER = 3;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int bitField0_;
    private int radioId_;
    private boolean started_;
    private byte memoizedIsInitialized = 2;
    private int status_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.ScanStationsResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ScanStationsResponse, Builder> implements ScanStationsResponseOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearRadioId() {
            copyOnWrite();
            ((ScanStationsResponse) this.instance).clearRadioId();
            return this;
        }

        public Builder clearStarted() {
            copyOnWrite();
            ((ScanStationsResponse) this.instance).clearStarted();
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((ScanStationsResponse) this.instance).clearStatus();
            return this;
        }

        @Override // fr.sd.taada.proto.ScanStationsResponseOrBuilder
        public int getRadioId() {
            return ((ScanStationsResponse) this.instance).getRadioId();
        }

        @Override // fr.sd.taada.proto.ScanStationsResponseOrBuilder
        public boolean getStarted() {
            return ((ScanStationsResponse) this.instance).getStarted();
        }

        @Override // fr.sd.taada.proto.ScanStationsResponseOrBuilder
        public MessageStatus getStatus() {
            return ((ScanStationsResponse) this.instance).getStatus();
        }

        @Override // fr.sd.taada.proto.ScanStationsResponseOrBuilder
        public boolean hasRadioId() {
            return ((ScanStationsResponse) this.instance).hasRadioId();
        }

        @Override // fr.sd.taada.proto.ScanStationsResponseOrBuilder
        public boolean hasStarted() {
            return ((ScanStationsResponse) this.instance).hasStarted();
        }

        @Override // fr.sd.taada.proto.ScanStationsResponseOrBuilder
        public boolean hasStatus() {
            return ((ScanStationsResponse) this.instance).hasStatus();
        }

        public Builder setRadioId(int i) {
            copyOnWrite();
            ((ScanStationsResponse) this.instance).setRadioId(i);
            return this;
        }

        public Builder setStarted(boolean z6) {
            copyOnWrite();
            ((ScanStationsResponse) this.instance).setStarted(z6);
            return this;
        }

        public Builder setStatus(MessageStatus messageStatus) {
            copyOnWrite();
            ((ScanStationsResponse) this.instance).setStatus(messageStatus);
            return this;
        }

        private Builder() {
            super(ScanStationsResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        ScanStationsResponse scanStationsResponse = new ScanStationsResponse();
        DEFAULT_INSTANCE = scanStationsResponse;
        GeneratedMessageLite.registerDefaultInstance(ScanStationsResponse.class, scanStationsResponse);
    }

    private ScanStationsResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioId() {
        this.bitField0_ &= -3;
        this.radioId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStarted() {
        this.bitField0_ &= -5;
        this.started_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.bitField0_ &= -2;
        this.status_ = 1;
    }

    public static ScanStationsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ScanStationsResponse parseDelimitedFrom(InputStream inputStream) {
        return (ScanStationsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ScanStationsResponse parseFrom(ByteBuffer byteBuffer) {
        return (ScanStationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ScanStationsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioId(int i) {
        this.bitField0_ |= 2;
        this.radioId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStarted(boolean z6) {
        this.bitField0_ |= 4;
        this.started_ = z6;
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
                return new ScanStationsResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001\f\u0000\u0002Ԅ\u0001\u0003\u0007\u0002", new Object[]{"bitField0_", "status_", MessageStatus.internalGetVerifier(), "radioId_", "started_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ScanStationsResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ScanStationsResponse.class) {
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

    @Override // fr.sd.taada.proto.ScanStationsResponseOrBuilder
    public int getRadioId() {
        return this.radioId_;
    }

    @Override // fr.sd.taada.proto.ScanStationsResponseOrBuilder
    public boolean getStarted() {
        return this.started_;
    }

    @Override // fr.sd.taada.proto.ScanStationsResponseOrBuilder
    public MessageStatus getStatus() {
        MessageStatus messageStatusForNumber = MessageStatus.forNumber(this.status_);
        return messageStatusForNumber == null ? MessageStatus.STATUS_UNSOLICITED_MESSAGE : messageStatusForNumber;
    }

    @Override // fr.sd.taada.proto.ScanStationsResponseOrBuilder
    public boolean hasRadioId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.ScanStationsResponseOrBuilder
    public boolean hasStarted() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.ScanStationsResponseOrBuilder
    public boolean hasStatus() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(ScanStationsResponse scanStationsResponse) {
        return DEFAULT_INSTANCE.createBuilder(scanStationsResponse);
    }

    public static ScanStationsResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ScanStationsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ScanStationsResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ScanStationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ScanStationsResponse parseFrom(ByteString byteString) {
        return (ScanStationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ScanStationsResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ScanStationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ScanStationsResponse parseFrom(byte[] bArr) {
        return (ScanStationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ScanStationsResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ScanStationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ScanStationsResponse parseFrom(InputStream inputStream) {
        return (ScanStationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ScanStationsResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ScanStationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ScanStationsResponse parseFrom(CodedInputStream codedInputStream) {
        return (ScanStationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ScanStationsResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ScanStationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
