package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class CancelRadioOperationsRequest extends GeneratedMessageLite<CancelRadioOperationsRequest, Builder> implements CancelRadioOperationsRequestOrBuilder {
    private static final CancelRadioOperationsRequest DEFAULT_INSTANCE;
    private static volatile Parser<CancelRadioOperationsRequest> PARSER = null;
    public static final int RADIO_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int radioId_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.CancelRadioOperationsRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<CancelRadioOperationsRequest, Builder> implements CancelRadioOperationsRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearRadioId() {
            copyOnWrite();
            ((CancelRadioOperationsRequest) this.instance).clearRadioId();
            return this;
        }

        @Override // fr.sd.taada.proto.CancelRadioOperationsRequestOrBuilder
        public int getRadioId() {
            return ((CancelRadioOperationsRequest) this.instance).getRadioId();
        }

        @Override // fr.sd.taada.proto.CancelRadioOperationsRequestOrBuilder
        public boolean hasRadioId() {
            return ((CancelRadioOperationsRequest) this.instance).hasRadioId();
        }

        public Builder setRadioId(int i) {
            copyOnWrite();
            ((CancelRadioOperationsRequest) this.instance).setRadioId(i);
            return this;
        }

        private Builder() {
            super(CancelRadioOperationsRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        CancelRadioOperationsRequest cancelRadioOperationsRequest = new CancelRadioOperationsRequest();
        DEFAULT_INSTANCE = cancelRadioOperationsRequest;
        GeneratedMessageLite.registerDefaultInstance(CancelRadioOperationsRequest.class, cancelRadioOperationsRequest);
    }

    private CancelRadioOperationsRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioId() {
        this.bitField0_ &= -2;
        this.radioId_ = 0;
    }

    public static CancelRadioOperationsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static CancelRadioOperationsRequest parseDelimitedFrom(InputStream inputStream) {
        return (CancelRadioOperationsRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CancelRadioOperationsRequest parseFrom(ByteBuffer byteBuffer) {
        return (CancelRadioOperationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CancelRadioOperationsRequest> parser() {
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
                return new CancelRadioOperationsRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Ԅ\u0000", new Object[]{"bitField0_", "radioId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CancelRadioOperationsRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (CancelRadioOperationsRequest.class) {
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

    @Override // fr.sd.taada.proto.CancelRadioOperationsRequestOrBuilder
    public int getRadioId() {
        return this.radioId_;
    }

    @Override // fr.sd.taada.proto.CancelRadioOperationsRequestOrBuilder
    public boolean hasRadioId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(CancelRadioOperationsRequest cancelRadioOperationsRequest) {
        return DEFAULT_INSTANCE.createBuilder(cancelRadioOperationsRequest);
    }

    public static CancelRadioOperationsRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CancelRadioOperationsRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CancelRadioOperationsRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (CancelRadioOperationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CancelRadioOperationsRequest parseFrom(ByteString byteString) {
        return (CancelRadioOperationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static CancelRadioOperationsRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CancelRadioOperationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CancelRadioOperationsRequest parseFrom(byte[] bArr) {
        return (CancelRadioOperationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CancelRadioOperationsRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (CancelRadioOperationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CancelRadioOperationsRequest parseFrom(InputStream inputStream) {
        return (CancelRadioOperationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CancelRadioOperationsRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CancelRadioOperationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CancelRadioOperationsRequest parseFrom(CodedInputStream codedInputStream) {
        return (CancelRadioOperationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CancelRadioOperationsRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CancelRadioOperationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
