package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class SeekStationRequest extends GeneratedMessageLite<SeekStationRequest, Builder> implements SeekStationRequestOrBuilder {
    private static final SeekStationRequest DEFAULT_INSTANCE;
    private static volatile Parser<SeekStationRequest> PARSER = null;
    public static final int RADIO_ID_FIELD_NUMBER = 1;
    public static final int SKIP_SUB_CHANNEL_FIELD_NUMBER = 3;
    public static final int UP_FIELD_NUMBER = 2;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int radioId_;
    private boolean skipSubChannel_;
    private boolean up_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.SeekStationRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<SeekStationRequest, Builder> implements SeekStationRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearRadioId() {
            copyOnWrite();
            ((SeekStationRequest) this.instance).clearRadioId();
            return this;
        }

        public Builder clearSkipSubChannel() {
            copyOnWrite();
            ((SeekStationRequest) this.instance).clearSkipSubChannel();
            return this;
        }

        public Builder clearUp() {
            copyOnWrite();
            ((SeekStationRequest) this.instance).clearUp();
            return this;
        }

        @Override // fr.sd.taada.proto.SeekStationRequestOrBuilder
        public int getRadioId() {
            return ((SeekStationRequest) this.instance).getRadioId();
        }

        @Override // fr.sd.taada.proto.SeekStationRequestOrBuilder
        public boolean getSkipSubChannel() {
            return ((SeekStationRequest) this.instance).getSkipSubChannel();
        }

        @Override // fr.sd.taada.proto.SeekStationRequestOrBuilder
        public boolean getUp() {
            return ((SeekStationRequest) this.instance).getUp();
        }

        @Override // fr.sd.taada.proto.SeekStationRequestOrBuilder
        public boolean hasRadioId() {
            return ((SeekStationRequest) this.instance).hasRadioId();
        }

        @Override // fr.sd.taada.proto.SeekStationRequestOrBuilder
        public boolean hasSkipSubChannel() {
            return ((SeekStationRequest) this.instance).hasSkipSubChannel();
        }

        @Override // fr.sd.taada.proto.SeekStationRequestOrBuilder
        public boolean hasUp() {
            return ((SeekStationRequest) this.instance).hasUp();
        }

        public Builder setRadioId(int i) {
            copyOnWrite();
            ((SeekStationRequest) this.instance).setRadioId(i);
            return this;
        }

        public Builder setSkipSubChannel(boolean z6) {
            copyOnWrite();
            ((SeekStationRequest) this.instance).setSkipSubChannel(z6);
            return this;
        }

        public Builder setUp(boolean z6) {
            copyOnWrite();
            ((SeekStationRequest) this.instance).setUp(z6);
            return this;
        }

        private Builder() {
            super(SeekStationRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        SeekStationRequest seekStationRequest = new SeekStationRequest();
        DEFAULT_INSTANCE = seekStationRequest;
        GeneratedMessageLite.registerDefaultInstance(SeekStationRequest.class, seekStationRequest);
    }

    private SeekStationRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioId() {
        this.bitField0_ &= -2;
        this.radioId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSkipSubChannel() {
        this.bitField0_ &= -5;
        this.skipSubChannel_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUp() {
        this.bitField0_ &= -3;
        this.up_ = false;
    }

    public static SeekStationRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SeekStationRequest parseDelimitedFrom(InputStream inputStream) {
        return (SeekStationRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SeekStationRequest parseFrom(ByteBuffer byteBuffer) {
        return (SeekStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SeekStationRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioId(int i) {
        this.bitField0_ |= 1;
        this.radioId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSkipSubChannel(boolean z6) {
        this.bitField0_ |= 4;
        this.skipSubChannel_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUp(boolean z6) {
        this.bitField0_ |= 2;
        this.up_ = z6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new SeekStationRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001Ԅ\u0000\u0002ԇ\u0001\u0003ԇ\u0002", new Object[]{"bitField0_", "radioId_", "up_", "skipSubChannel_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SeekStationRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SeekStationRequest.class) {
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

    @Override // fr.sd.taada.proto.SeekStationRequestOrBuilder
    public int getRadioId() {
        return this.radioId_;
    }

    @Override // fr.sd.taada.proto.SeekStationRequestOrBuilder
    public boolean getSkipSubChannel() {
        return this.skipSubChannel_;
    }

    @Override // fr.sd.taada.proto.SeekStationRequestOrBuilder
    public boolean getUp() {
        return this.up_;
    }

    @Override // fr.sd.taada.proto.SeekStationRequestOrBuilder
    public boolean hasRadioId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.SeekStationRequestOrBuilder
    public boolean hasSkipSubChannel() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.SeekStationRequestOrBuilder
    public boolean hasUp() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(SeekStationRequest seekStationRequest) {
        return DEFAULT_INSTANCE.createBuilder(seekStationRequest);
    }

    public static SeekStationRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SeekStationRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SeekStationRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (SeekStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SeekStationRequest parseFrom(ByteString byteString) {
        return (SeekStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SeekStationRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SeekStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SeekStationRequest parseFrom(byte[] bArr) {
        return (SeekStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SeekStationRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (SeekStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SeekStationRequest parseFrom(InputStream inputStream) {
        return (SeekStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SeekStationRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SeekStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SeekStationRequest parseFrom(CodedInputStream codedInputStream) {
        return (SeekStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SeekStationRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SeekStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
