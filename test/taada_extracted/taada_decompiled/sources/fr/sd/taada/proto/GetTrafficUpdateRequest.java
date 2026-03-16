package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class GetTrafficUpdateRequest extends GeneratedMessageLite<GetTrafficUpdateRequest, Builder> implements GetTrafficUpdateRequestOrBuilder {
    private static final GetTrafficUpdateRequest DEFAULT_INSTANCE;
    private static volatile Parser<GetTrafficUpdateRequest> PARSER = null;
    public static final int RADIO_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int radioId_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.GetTrafficUpdateRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GetTrafficUpdateRequest, Builder> implements GetTrafficUpdateRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearRadioId() {
            copyOnWrite();
            ((GetTrafficUpdateRequest) this.instance).clearRadioId();
            return this;
        }

        @Override // fr.sd.taada.proto.GetTrafficUpdateRequestOrBuilder
        public int getRadioId() {
            return ((GetTrafficUpdateRequest) this.instance).getRadioId();
        }

        @Override // fr.sd.taada.proto.GetTrafficUpdateRequestOrBuilder
        public boolean hasRadioId() {
            return ((GetTrafficUpdateRequest) this.instance).hasRadioId();
        }

        public Builder setRadioId(int i) {
            copyOnWrite();
            ((GetTrafficUpdateRequest) this.instance).setRadioId(i);
            return this;
        }

        private Builder() {
            super(GetTrafficUpdateRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        GetTrafficUpdateRequest getTrafficUpdateRequest = new GetTrafficUpdateRequest();
        DEFAULT_INSTANCE = getTrafficUpdateRequest;
        GeneratedMessageLite.registerDefaultInstance(GetTrafficUpdateRequest.class, getTrafficUpdateRequest);
    }

    private GetTrafficUpdateRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioId() {
        this.bitField0_ &= -2;
        this.radioId_ = 0;
    }

    public static GetTrafficUpdateRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GetTrafficUpdateRequest parseDelimitedFrom(InputStream inputStream) {
        return (GetTrafficUpdateRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GetTrafficUpdateRequest parseFrom(ByteBuffer byteBuffer) {
        return (GetTrafficUpdateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GetTrafficUpdateRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioId(int i) {
        this.bitField0_ |= 1;
        this.radioId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GetTrafficUpdateRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Ԅ\u0000", new Object[]{"bitField0_", "radioId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GetTrafficUpdateRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GetTrafficUpdateRequest.class) {
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

    @Override // fr.sd.taada.proto.GetTrafficUpdateRequestOrBuilder
    public int getRadioId() {
        return this.radioId_;
    }

    @Override // fr.sd.taada.proto.GetTrafficUpdateRequestOrBuilder
    public boolean hasRadioId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(GetTrafficUpdateRequest getTrafficUpdateRequest) {
        return DEFAULT_INSTANCE.createBuilder(getTrafficUpdateRequest);
    }

    public static GetTrafficUpdateRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GetTrafficUpdateRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GetTrafficUpdateRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GetTrafficUpdateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GetTrafficUpdateRequest parseFrom(ByteString byteString) {
        return (GetTrafficUpdateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GetTrafficUpdateRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GetTrafficUpdateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GetTrafficUpdateRequest parseFrom(byte[] bArr) {
        return (GetTrafficUpdateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GetTrafficUpdateRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GetTrafficUpdateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GetTrafficUpdateRequest parseFrom(InputStream inputStream) {
        return (GetTrafficUpdateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GetTrafficUpdateRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GetTrafficUpdateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GetTrafficUpdateRequest parseFrom(CodedInputStream codedInputStream) {
        return (GetTrafficUpdateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GetTrafficUpdateRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GetTrafficUpdateRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
