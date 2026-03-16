package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class StepChannelRequest extends GeneratedMessageLite<StepChannelRequest, Builder> implements StepChannelRequestOrBuilder {
    private static final StepChannelRequest DEFAULT_INSTANCE;
    private static volatile Parser<StepChannelRequest> PARSER = null;
    public static final int RADIO_ID_FIELD_NUMBER = 1;
    public static final int SKIP_SUB_CHANNEL_FIELD_NUMBER = 3;
    public static final int UP_FIELD_NUMBER = 2;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int radioId_;
    private boolean skipSubChannel_;
    private boolean up_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.StepChannelRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<StepChannelRequest, Builder> implements StepChannelRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearRadioId() {
            copyOnWrite();
            ((StepChannelRequest) this.instance).clearRadioId();
            return this;
        }

        public Builder clearSkipSubChannel() {
            copyOnWrite();
            ((StepChannelRequest) this.instance).clearSkipSubChannel();
            return this;
        }

        public Builder clearUp() {
            copyOnWrite();
            ((StepChannelRequest) this.instance).clearUp();
            return this;
        }

        @Override // fr.sd.taada.proto.StepChannelRequestOrBuilder
        public int getRadioId() {
            return ((StepChannelRequest) this.instance).getRadioId();
        }

        @Override // fr.sd.taada.proto.StepChannelRequestOrBuilder
        public boolean getSkipSubChannel() {
            return ((StepChannelRequest) this.instance).getSkipSubChannel();
        }

        @Override // fr.sd.taada.proto.StepChannelRequestOrBuilder
        public boolean getUp() {
            return ((StepChannelRequest) this.instance).getUp();
        }

        @Override // fr.sd.taada.proto.StepChannelRequestOrBuilder
        public boolean hasRadioId() {
            return ((StepChannelRequest) this.instance).hasRadioId();
        }

        @Override // fr.sd.taada.proto.StepChannelRequestOrBuilder
        public boolean hasSkipSubChannel() {
            return ((StepChannelRequest) this.instance).hasSkipSubChannel();
        }

        @Override // fr.sd.taada.proto.StepChannelRequestOrBuilder
        public boolean hasUp() {
            return ((StepChannelRequest) this.instance).hasUp();
        }

        public Builder setRadioId(int i) {
            copyOnWrite();
            ((StepChannelRequest) this.instance).setRadioId(i);
            return this;
        }

        public Builder setSkipSubChannel(boolean z6) {
            copyOnWrite();
            ((StepChannelRequest) this.instance).setSkipSubChannel(z6);
            return this;
        }

        public Builder setUp(boolean z6) {
            copyOnWrite();
            ((StepChannelRequest) this.instance).setUp(z6);
            return this;
        }

        private Builder() {
            super(StepChannelRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        StepChannelRequest stepChannelRequest = new StepChannelRequest();
        DEFAULT_INSTANCE = stepChannelRequest;
        GeneratedMessageLite.registerDefaultInstance(StepChannelRequest.class, stepChannelRequest);
    }

    private StepChannelRequest() {
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

    public static StepChannelRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static StepChannelRequest parseDelimitedFrom(InputStream inputStream) {
        return (StepChannelRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StepChannelRequest parseFrom(ByteBuffer byteBuffer) {
        return (StepChannelRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<StepChannelRequest> parser() {
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
                return new StepChannelRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001Ԅ\u0000\u0002ԇ\u0001\u0003ԇ\u0002", new Object[]{"bitField0_", "radioId_", "up_", "skipSubChannel_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StepChannelRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (StepChannelRequest.class) {
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

    @Override // fr.sd.taada.proto.StepChannelRequestOrBuilder
    public int getRadioId() {
        return this.radioId_;
    }

    @Override // fr.sd.taada.proto.StepChannelRequestOrBuilder
    public boolean getSkipSubChannel() {
        return this.skipSubChannel_;
    }

    @Override // fr.sd.taada.proto.StepChannelRequestOrBuilder
    public boolean getUp() {
        return this.up_;
    }

    @Override // fr.sd.taada.proto.StepChannelRequestOrBuilder
    public boolean hasRadioId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.StepChannelRequestOrBuilder
    public boolean hasSkipSubChannel() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.StepChannelRequestOrBuilder
    public boolean hasUp() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(StepChannelRequest stepChannelRequest) {
        return DEFAULT_INSTANCE.createBuilder(stepChannelRequest);
    }

    public static StepChannelRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StepChannelRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StepChannelRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (StepChannelRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StepChannelRequest parseFrom(ByteString byteString) {
        return (StepChannelRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static StepChannelRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (StepChannelRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static StepChannelRequest parseFrom(byte[] bArr) {
        return (StepChannelRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StepChannelRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (StepChannelRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static StepChannelRequest parseFrom(InputStream inputStream) {
        return (StepChannelRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StepChannelRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StepChannelRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StepChannelRequest parseFrom(CodedInputStream codedInputStream) {
        return (StepChannelRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StepChannelRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StepChannelRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
