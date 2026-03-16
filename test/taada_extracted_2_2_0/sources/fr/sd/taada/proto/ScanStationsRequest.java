package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class ScanStationsRequest extends GeneratedMessageLite<ScanStationsRequest, Builder> implements ScanStationsRequestOrBuilder {
    private static final ScanStationsRequest DEFAULT_INSTANCE;
    private static volatile Parser<ScanStationsRequest> PARSER = null;
    public static final int RADIO_ID_FIELD_NUMBER = 1;
    public static final int SKIP_SUB_CHANNEL_FIELD_NUMBER = 4;
    public static final int START_FIELD_NUMBER = 2;
    public static final int UP_FIELD_NUMBER = 3;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int radioId_;
    private boolean skipSubChannel_;
    private boolean start_;
    private boolean up_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.ScanStationsRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ScanStationsRequest, Builder> implements ScanStationsRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearRadioId() {
            copyOnWrite();
            ((ScanStationsRequest) this.instance).clearRadioId();
            return this;
        }

        public Builder clearSkipSubChannel() {
            copyOnWrite();
            ((ScanStationsRequest) this.instance).clearSkipSubChannel();
            return this;
        }

        public Builder clearStart() {
            copyOnWrite();
            ((ScanStationsRequest) this.instance).clearStart();
            return this;
        }

        public Builder clearUp() {
            copyOnWrite();
            ((ScanStationsRequest) this.instance).clearUp();
            return this;
        }

        @Override // fr.sd.taada.proto.ScanStationsRequestOrBuilder
        public int getRadioId() {
            return ((ScanStationsRequest) this.instance).getRadioId();
        }

        @Override // fr.sd.taada.proto.ScanStationsRequestOrBuilder
        public boolean getSkipSubChannel() {
            return ((ScanStationsRequest) this.instance).getSkipSubChannel();
        }

        @Override // fr.sd.taada.proto.ScanStationsRequestOrBuilder
        public boolean getStart() {
            return ((ScanStationsRequest) this.instance).getStart();
        }

        @Override // fr.sd.taada.proto.ScanStationsRequestOrBuilder
        public boolean getUp() {
            return ((ScanStationsRequest) this.instance).getUp();
        }

        @Override // fr.sd.taada.proto.ScanStationsRequestOrBuilder
        public boolean hasRadioId() {
            return ((ScanStationsRequest) this.instance).hasRadioId();
        }

        @Override // fr.sd.taada.proto.ScanStationsRequestOrBuilder
        public boolean hasSkipSubChannel() {
            return ((ScanStationsRequest) this.instance).hasSkipSubChannel();
        }

        @Override // fr.sd.taada.proto.ScanStationsRequestOrBuilder
        public boolean hasStart() {
            return ((ScanStationsRequest) this.instance).hasStart();
        }

        @Override // fr.sd.taada.proto.ScanStationsRequestOrBuilder
        public boolean hasUp() {
            return ((ScanStationsRequest) this.instance).hasUp();
        }

        public Builder setRadioId(int i) {
            copyOnWrite();
            ((ScanStationsRequest) this.instance).setRadioId(i);
            return this;
        }

        public Builder setSkipSubChannel(boolean z6) {
            copyOnWrite();
            ((ScanStationsRequest) this.instance).setSkipSubChannel(z6);
            return this;
        }

        public Builder setStart(boolean z6) {
            copyOnWrite();
            ((ScanStationsRequest) this.instance).setStart(z6);
            return this;
        }

        public Builder setUp(boolean z6) {
            copyOnWrite();
            ((ScanStationsRequest) this.instance).setUp(z6);
            return this;
        }

        private Builder() {
            super(ScanStationsRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        ScanStationsRequest scanStationsRequest = new ScanStationsRequest();
        DEFAULT_INSTANCE = scanStationsRequest;
        GeneratedMessageLite.registerDefaultInstance(ScanStationsRequest.class, scanStationsRequest);
    }

    private ScanStationsRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioId() {
        this.bitField0_ &= -2;
        this.radioId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSkipSubChannel() {
        this.bitField0_ &= -9;
        this.skipSubChannel_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStart() {
        this.bitField0_ &= -3;
        this.start_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUp() {
        this.bitField0_ &= -5;
        this.up_ = false;
    }

    public static ScanStationsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ScanStationsRequest parseDelimitedFrom(InputStream inputStream) {
        return (ScanStationsRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ScanStationsRequest parseFrom(ByteBuffer byteBuffer) {
        return (ScanStationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ScanStationsRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioId(int i) {
        this.bitField0_ |= 1;
        this.radioId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSkipSubChannel(boolean z6) {
        this.bitField0_ |= 8;
        this.skipSubChannel_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStart(boolean z6) {
        this.bitField0_ |= 2;
        this.start_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUp(boolean z6) {
        this.bitField0_ |= 4;
        this.up_ = z6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ScanStationsRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0004\u0001Ԅ\u0000\u0002ԇ\u0001\u0003ԇ\u0002\u0004ԇ\u0003", new Object[]{"bitField0_", "radioId_", "start_", "up_", "skipSubChannel_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ScanStationsRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ScanStationsRequest.class) {
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

    @Override // fr.sd.taada.proto.ScanStationsRequestOrBuilder
    public int getRadioId() {
        return this.radioId_;
    }

    @Override // fr.sd.taada.proto.ScanStationsRequestOrBuilder
    public boolean getSkipSubChannel() {
        return this.skipSubChannel_;
    }

    @Override // fr.sd.taada.proto.ScanStationsRequestOrBuilder
    public boolean getStart() {
        return this.start_;
    }

    @Override // fr.sd.taada.proto.ScanStationsRequestOrBuilder
    public boolean getUp() {
        return this.up_;
    }

    @Override // fr.sd.taada.proto.ScanStationsRequestOrBuilder
    public boolean hasRadioId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.ScanStationsRequestOrBuilder
    public boolean hasSkipSubChannel() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.ScanStationsRequestOrBuilder
    public boolean hasStart() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.ScanStationsRequestOrBuilder
    public boolean hasUp() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(ScanStationsRequest scanStationsRequest) {
        return DEFAULT_INSTANCE.createBuilder(scanStationsRequest);
    }

    public static ScanStationsRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ScanStationsRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ScanStationsRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ScanStationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ScanStationsRequest parseFrom(ByteString byteString) {
        return (ScanStationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ScanStationsRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ScanStationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ScanStationsRequest parseFrom(byte[] bArr) {
        return (ScanStationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ScanStationsRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ScanStationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ScanStationsRequest parseFrom(InputStream inputStream) {
        return (ScanStationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ScanStationsRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ScanStationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ScanStationsRequest parseFrom(CodedInputStream codedInputStream) {
        return (ScanStationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ScanStationsRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ScanStationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
