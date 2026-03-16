package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class ByeByeRequest extends GeneratedMessageLite<ByeByeRequest, Builder> implements ByeByeRequestOrBuilder {
    private static final ByeByeRequest DEFAULT_INSTANCE;
    private static volatile Parser<ByeByeRequest> PARSER = null;
    public static final int REASON_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int reason_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.ByeByeRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ByeByeRequest, Builder> implements ByeByeRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearReason() {
            copyOnWrite();
            ((ByeByeRequest) this.instance).clearReason();
            return this;
        }

        @Override // fr.sd.taada.proto.ByeByeRequestOrBuilder
        public ByeByeReason getReason() {
            return ((ByeByeRequest) this.instance).getReason();
        }

        @Override // fr.sd.taada.proto.ByeByeRequestOrBuilder
        public boolean hasReason() {
            return ((ByeByeRequest) this.instance).hasReason();
        }

        public Builder setReason(ByeByeReason byeByeReason) {
            copyOnWrite();
            ((ByeByeRequest) this.instance).setReason(byeByeReason);
            return this;
        }

        private Builder() {
            super(ByeByeRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        ByeByeRequest byeByeRequest = new ByeByeRequest();
        DEFAULT_INSTANCE = byeByeRequest;
        GeneratedMessageLite.registerDefaultInstance(ByeByeRequest.class, byeByeRequest);
    }

    private ByeByeRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReason() {
        this.bitField0_ &= -2;
        this.reason_ = 1;
    }

    public static ByeByeRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ByeByeRequest parseDelimitedFrom(InputStream inputStream) {
        return (ByeByeRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ByeByeRequest parseFrom(ByteBuffer byteBuffer) {
        return (ByeByeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ByeByeRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReason(ByeByeReason byeByeReason) {
        byeByeReason.getClass();
        this.bitField0_ |= 1;
        this.reason_ = byeByeReason.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ByeByeRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Ԍ\u0000", new Object[]{"bitField0_", "reason_", ByeByeReason.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ByeByeRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ByeByeRequest.class) {
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

    @Override // fr.sd.taada.proto.ByeByeRequestOrBuilder
    public ByeByeReason getReason() {
        ByeByeReason byeByeReasonForNumber = ByeByeReason.forNumber(this.reason_);
        return byeByeReasonForNumber == null ? ByeByeReason.USER_SELECTION : byeByeReasonForNumber;
    }

    @Override // fr.sd.taada.proto.ByeByeRequestOrBuilder
    public boolean hasReason() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(ByeByeRequest byeByeRequest) {
        return DEFAULT_INSTANCE.createBuilder(byeByeRequest);
    }

    public static ByeByeRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ByeByeRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ByeByeRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ByeByeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ByeByeRequest parseFrom(ByteString byteString) {
        return (ByeByeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ByeByeRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ByeByeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ByeByeRequest parseFrom(byte[] bArr) {
        return (ByeByeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ByeByeRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ByeByeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ByeByeRequest parseFrom(InputStream inputStream) {
        return (ByeByeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ByeByeRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ByeByeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ByeByeRequest parseFrom(CodedInputStream codedInputStream) {
        return (ByeByeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ByeByeRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ByeByeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
