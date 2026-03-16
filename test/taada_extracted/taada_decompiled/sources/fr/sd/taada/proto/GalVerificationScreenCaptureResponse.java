package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class GalVerificationScreenCaptureResponse extends GeneratedMessageLite<GalVerificationScreenCaptureResponse, Builder> implements GalVerificationScreenCaptureResponseOrBuilder {
    private static final GalVerificationScreenCaptureResponse DEFAULT_INSTANCE;
    private static volatile Parser<GalVerificationScreenCaptureResponse> PARSER = null;
    public static final int SCREEN_CAPTURE_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private ByteString screenCapture_ = ByteString.EMPTY;

    /* JADX INFO: renamed from: fr.sd.taada.proto.GalVerificationScreenCaptureResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GalVerificationScreenCaptureResponse, Builder> implements GalVerificationScreenCaptureResponseOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearScreenCapture() {
            copyOnWrite();
            ((GalVerificationScreenCaptureResponse) this.instance).clearScreenCapture();
            return this;
        }

        @Override // fr.sd.taada.proto.GalVerificationScreenCaptureResponseOrBuilder
        public ByteString getScreenCapture() {
            return ((GalVerificationScreenCaptureResponse) this.instance).getScreenCapture();
        }

        @Override // fr.sd.taada.proto.GalVerificationScreenCaptureResponseOrBuilder
        public boolean hasScreenCapture() {
            return ((GalVerificationScreenCaptureResponse) this.instance).hasScreenCapture();
        }

        public Builder setScreenCapture(ByteString byteString) {
            copyOnWrite();
            ((GalVerificationScreenCaptureResponse) this.instance).setScreenCapture(byteString);
            return this;
        }

        private Builder() {
            super(GalVerificationScreenCaptureResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        GalVerificationScreenCaptureResponse galVerificationScreenCaptureResponse = new GalVerificationScreenCaptureResponse();
        DEFAULT_INSTANCE = galVerificationScreenCaptureResponse;
        GeneratedMessageLite.registerDefaultInstance(GalVerificationScreenCaptureResponse.class, galVerificationScreenCaptureResponse);
    }

    private GalVerificationScreenCaptureResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScreenCapture() {
        this.bitField0_ &= -2;
        this.screenCapture_ = getDefaultInstance().getScreenCapture();
    }

    public static GalVerificationScreenCaptureResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GalVerificationScreenCaptureResponse parseDelimitedFrom(InputStream inputStream) {
        return (GalVerificationScreenCaptureResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GalVerificationScreenCaptureResponse parseFrom(ByteBuffer byteBuffer) {
        return (GalVerificationScreenCaptureResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GalVerificationScreenCaptureResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScreenCapture(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.screenCapture_ = byteString;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GalVerificationScreenCaptureResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Ԋ\u0000", new Object[]{"bitField0_", "screenCapture_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GalVerificationScreenCaptureResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GalVerificationScreenCaptureResponse.class) {
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

    @Override // fr.sd.taada.proto.GalVerificationScreenCaptureResponseOrBuilder
    public ByteString getScreenCapture() {
        return this.screenCapture_;
    }

    @Override // fr.sd.taada.proto.GalVerificationScreenCaptureResponseOrBuilder
    public boolean hasScreenCapture() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(GalVerificationScreenCaptureResponse galVerificationScreenCaptureResponse) {
        return DEFAULT_INSTANCE.createBuilder(galVerificationScreenCaptureResponse);
    }

    public static GalVerificationScreenCaptureResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationScreenCaptureResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GalVerificationScreenCaptureResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationScreenCaptureResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GalVerificationScreenCaptureResponse parseFrom(ByteString byteString) {
        return (GalVerificationScreenCaptureResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GalVerificationScreenCaptureResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationScreenCaptureResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GalVerificationScreenCaptureResponse parseFrom(byte[] bArr) {
        return (GalVerificationScreenCaptureResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GalVerificationScreenCaptureResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationScreenCaptureResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GalVerificationScreenCaptureResponse parseFrom(InputStream inputStream) {
        return (GalVerificationScreenCaptureResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GalVerificationScreenCaptureResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationScreenCaptureResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GalVerificationScreenCaptureResponse parseFrom(CodedInputStream codedInputStream) {
        return (GalVerificationScreenCaptureResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GalVerificationScreenCaptureResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationScreenCaptureResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
