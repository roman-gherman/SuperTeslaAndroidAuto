package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class GalVerificationDisplayInformationResponse extends GeneratedMessageLite<GalVerificationDisplayInformationResponse, Builder> implements GalVerificationDisplayInformationResponseOrBuilder {
    private static final GalVerificationDisplayInformationResponse DEFAULT_INSTANCE;
    public static final int NATIVE_HEIGHT_FIELD_NUMBER = 2;
    public static final int NATIVE_WIDTH_FIELD_NUMBER = 1;
    private static volatile Parser<GalVerificationDisplayInformationResponse> PARSER;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int nativeHeight_;
    private int nativeWidth_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.GalVerificationDisplayInformationResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GalVerificationDisplayInformationResponse, Builder> implements GalVerificationDisplayInformationResponseOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearNativeHeight() {
            copyOnWrite();
            ((GalVerificationDisplayInformationResponse) this.instance).clearNativeHeight();
            return this;
        }

        public Builder clearNativeWidth() {
            copyOnWrite();
            ((GalVerificationDisplayInformationResponse) this.instance).clearNativeWidth();
            return this;
        }

        @Override // fr.sd.taada.proto.GalVerificationDisplayInformationResponseOrBuilder
        public int getNativeHeight() {
            return ((GalVerificationDisplayInformationResponse) this.instance).getNativeHeight();
        }

        @Override // fr.sd.taada.proto.GalVerificationDisplayInformationResponseOrBuilder
        public int getNativeWidth() {
            return ((GalVerificationDisplayInformationResponse) this.instance).getNativeWidth();
        }

        @Override // fr.sd.taada.proto.GalVerificationDisplayInformationResponseOrBuilder
        public boolean hasNativeHeight() {
            return ((GalVerificationDisplayInformationResponse) this.instance).hasNativeHeight();
        }

        @Override // fr.sd.taada.proto.GalVerificationDisplayInformationResponseOrBuilder
        public boolean hasNativeWidth() {
            return ((GalVerificationDisplayInformationResponse) this.instance).hasNativeWidth();
        }

        public Builder setNativeHeight(int i) {
            copyOnWrite();
            ((GalVerificationDisplayInformationResponse) this.instance).setNativeHeight(i);
            return this;
        }

        public Builder setNativeWidth(int i) {
            copyOnWrite();
            ((GalVerificationDisplayInformationResponse) this.instance).setNativeWidth(i);
            return this;
        }

        private Builder() {
            super(GalVerificationDisplayInformationResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        GalVerificationDisplayInformationResponse galVerificationDisplayInformationResponse = new GalVerificationDisplayInformationResponse();
        DEFAULT_INSTANCE = galVerificationDisplayInformationResponse;
        GeneratedMessageLite.registerDefaultInstance(GalVerificationDisplayInformationResponse.class, galVerificationDisplayInformationResponse);
    }

    private GalVerificationDisplayInformationResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNativeHeight() {
        this.bitField0_ &= -3;
        this.nativeHeight_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNativeWidth() {
        this.bitField0_ &= -2;
        this.nativeWidth_ = 0;
    }

    public static GalVerificationDisplayInformationResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GalVerificationDisplayInformationResponse parseDelimitedFrom(InputStream inputStream) {
        return (GalVerificationDisplayInformationResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GalVerificationDisplayInformationResponse parseFrom(ByteBuffer byteBuffer) {
        return (GalVerificationDisplayInformationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GalVerificationDisplayInformationResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNativeHeight(int i) {
        this.bitField0_ |= 2;
        this.nativeHeight_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNativeWidth(int i) {
        this.bitField0_ |= 1;
        this.nativeWidth_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GalVerificationDisplayInformationResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԅ\u0000\u0002Ԅ\u0001", new Object[]{"bitField0_", "nativeWidth_", "nativeHeight_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GalVerificationDisplayInformationResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GalVerificationDisplayInformationResponse.class) {
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

    @Override // fr.sd.taada.proto.GalVerificationDisplayInformationResponseOrBuilder
    public int getNativeHeight() {
        return this.nativeHeight_;
    }

    @Override // fr.sd.taada.proto.GalVerificationDisplayInformationResponseOrBuilder
    public int getNativeWidth() {
        return this.nativeWidth_;
    }

    @Override // fr.sd.taada.proto.GalVerificationDisplayInformationResponseOrBuilder
    public boolean hasNativeHeight() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.GalVerificationDisplayInformationResponseOrBuilder
    public boolean hasNativeWidth() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(GalVerificationDisplayInformationResponse galVerificationDisplayInformationResponse) {
        return DEFAULT_INSTANCE.createBuilder(galVerificationDisplayInformationResponse);
    }

    public static GalVerificationDisplayInformationResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationDisplayInformationResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GalVerificationDisplayInformationResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationDisplayInformationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GalVerificationDisplayInformationResponse parseFrom(ByteString byteString) {
        return (GalVerificationDisplayInformationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GalVerificationDisplayInformationResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationDisplayInformationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GalVerificationDisplayInformationResponse parseFrom(byte[] bArr) {
        return (GalVerificationDisplayInformationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GalVerificationDisplayInformationResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationDisplayInformationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GalVerificationDisplayInformationResponse parseFrom(InputStream inputStream) {
        return (GalVerificationDisplayInformationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GalVerificationDisplayInformationResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationDisplayInformationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GalVerificationDisplayInformationResponse parseFrom(CodedInputStream codedInputStream) {
        return (GalVerificationDisplayInformationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GalVerificationDisplayInformationResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationDisplayInformationResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
