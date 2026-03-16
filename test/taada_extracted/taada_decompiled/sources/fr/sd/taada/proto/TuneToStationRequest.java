package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class TuneToStationRequest extends GeneratedMessageLite<TuneToStationRequest, Builder> implements TuneToStationRequestOrBuilder {
    public static final int CHANNEL_FIELD_NUMBER = 2;
    private static final TuneToStationRequest DEFAULT_INSTANCE;
    private static volatile Parser<TuneToStationRequest> PARSER = null;
    public static final int RADIO_ID_FIELD_NUMBER = 1;
    public static final int SUB_CHANNEL_FIELD_NUMBER = 3;
    private int bitField0_;
    private int channel_;
    private byte memoizedIsInitialized = 2;
    private int radioId_;
    private int subChannel_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.TuneToStationRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<TuneToStationRequest, Builder> implements TuneToStationRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearChannel() {
            copyOnWrite();
            ((TuneToStationRequest) this.instance).clearChannel();
            return this;
        }

        public Builder clearRadioId() {
            copyOnWrite();
            ((TuneToStationRequest) this.instance).clearRadioId();
            return this;
        }

        public Builder clearSubChannel() {
            copyOnWrite();
            ((TuneToStationRequest) this.instance).clearSubChannel();
            return this;
        }

        @Override // fr.sd.taada.proto.TuneToStationRequestOrBuilder
        public int getChannel() {
            return ((TuneToStationRequest) this.instance).getChannel();
        }

        @Override // fr.sd.taada.proto.TuneToStationRequestOrBuilder
        public int getRadioId() {
            return ((TuneToStationRequest) this.instance).getRadioId();
        }

        @Override // fr.sd.taada.proto.TuneToStationRequestOrBuilder
        public int getSubChannel() {
            return ((TuneToStationRequest) this.instance).getSubChannel();
        }

        @Override // fr.sd.taada.proto.TuneToStationRequestOrBuilder
        public boolean hasChannel() {
            return ((TuneToStationRequest) this.instance).hasChannel();
        }

        @Override // fr.sd.taada.proto.TuneToStationRequestOrBuilder
        public boolean hasRadioId() {
            return ((TuneToStationRequest) this.instance).hasRadioId();
        }

        @Override // fr.sd.taada.proto.TuneToStationRequestOrBuilder
        public boolean hasSubChannel() {
            return ((TuneToStationRequest) this.instance).hasSubChannel();
        }

        public Builder setChannel(int i) {
            copyOnWrite();
            ((TuneToStationRequest) this.instance).setChannel(i);
            return this;
        }

        public Builder setRadioId(int i) {
            copyOnWrite();
            ((TuneToStationRequest) this.instance).setRadioId(i);
            return this;
        }

        public Builder setSubChannel(int i) {
            copyOnWrite();
            ((TuneToStationRequest) this.instance).setSubChannel(i);
            return this;
        }

        private Builder() {
            super(TuneToStationRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        TuneToStationRequest tuneToStationRequest = new TuneToStationRequest();
        DEFAULT_INSTANCE = tuneToStationRequest;
        GeneratedMessageLite.registerDefaultInstance(TuneToStationRequest.class, tuneToStationRequest);
    }

    private TuneToStationRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChannel() {
        this.bitField0_ &= -3;
        this.channel_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioId() {
        this.bitField0_ &= -2;
        this.radioId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubChannel() {
        this.bitField0_ &= -5;
        this.subChannel_ = 0;
    }

    public static TuneToStationRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static TuneToStationRequest parseDelimitedFrom(InputStream inputStream) {
        return (TuneToStationRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TuneToStationRequest parseFrom(ByteBuffer byteBuffer) {
        return (TuneToStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TuneToStationRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChannel(int i) {
        this.bitField0_ |= 2;
        this.channel_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioId(int i) {
        this.bitField0_ |= 1;
        this.radioId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubChannel(int i) {
        this.bitField0_ |= 4;
        this.subChannel_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TuneToStationRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0002\u0001Ԅ\u0000\u0002Ԅ\u0001\u0003\u0004\u0002", new Object[]{"bitField0_", "radioId_", "channel_", "subChannel_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TuneToStationRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TuneToStationRequest.class) {
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

    @Override // fr.sd.taada.proto.TuneToStationRequestOrBuilder
    public int getChannel() {
        return this.channel_;
    }

    @Override // fr.sd.taada.proto.TuneToStationRequestOrBuilder
    public int getRadioId() {
        return this.radioId_;
    }

    @Override // fr.sd.taada.proto.TuneToStationRequestOrBuilder
    public int getSubChannel() {
        return this.subChannel_;
    }

    @Override // fr.sd.taada.proto.TuneToStationRequestOrBuilder
    public boolean hasChannel() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.TuneToStationRequestOrBuilder
    public boolean hasRadioId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.TuneToStationRequestOrBuilder
    public boolean hasSubChannel() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(TuneToStationRequest tuneToStationRequest) {
        return DEFAULT_INSTANCE.createBuilder(tuneToStationRequest);
    }

    public static TuneToStationRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TuneToStationRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TuneToStationRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (TuneToStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TuneToStationRequest parseFrom(ByteString byteString) {
        return (TuneToStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TuneToStationRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (TuneToStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TuneToStationRequest parseFrom(byte[] bArr) {
        return (TuneToStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TuneToStationRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (TuneToStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TuneToStationRequest parseFrom(InputStream inputStream) {
        return (TuneToStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TuneToStationRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TuneToStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TuneToStationRequest parseFrom(CodedInputStream codedInputStream) {
        return (TuneToStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TuneToStationRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TuneToStationRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
