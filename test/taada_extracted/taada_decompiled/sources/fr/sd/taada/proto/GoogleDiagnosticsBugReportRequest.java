package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class GoogleDiagnosticsBugReportRequest extends GeneratedMessageLite<GoogleDiagnosticsBugReportRequest, Builder> implements GoogleDiagnosticsBugReportRequestOrBuilder {
    private static final GoogleDiagnosticsBugReportRequest DEFAULT_INSTANCE;
    private static volatile Parser<GoogleDiagnosticsBugReportRequest> PARSER = null;
    public static final int TOKEN_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int token_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.GoogleDiagnosticsBugReportRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GoogleDiagnosticsBugReportRequest, Builder> implements GoogleDiagnosticsBugReportRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearToken() {
            copyOnWrite();
            ((GoogleDiagnosticsBugReportRequest) this.instance).clearToken();
            return this;
        }

        @Override // fr.sd.taada.proto.GoogleDiagnosticsBugReportRequestOrBuilder
        public int getToken() {
            return ((GoogleDiagnosticsBugReportRequest) this.instance).getToken();
        }

        @Override // fr.sd.taada.proto.GoogleDiagnosticsBugReportRequestOrBuilder
        public boolean hasToken() {
            return ((GoogleDiagnosticsBugReportRequest) this.instance).hasToken();
        }

        public Builder setToken(int i) {
            copyOnWrite();
            ((GoogleDiagnosticsBugReportRequest) this.instance).setToken(i);
            return this;
        }

        private Builder() {
            super(GoogleDiagnosticsBugReportRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        GoogleDiagnosticsBugReportRequest googleDiagnosticsBugReportRequest = new GoogleDiagnosticsBugReportRequest();
        DEFAULT_INSTANCE = googleDiagnosticsBugReportRequest;
        GeneratedMessageLite.registerDefaultInstance(GoogleDiagnosticsBugReportRequest.class, googleDiagnosticsBugReportRequest);
    }

    private GoogleDiagnosticsBugReportRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearToken() {
        this.bitField0_ &= -2;
        this.token_ = 0;
    }

    public static GoogleDiagnosticsBugReportRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GoogleDiagnosticsBugReportRequest parseDelimitedFrom(InputStream inputStream) {
        return (GoogleDiagnosticsBugReportRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDiagnosticsBugReportRequest parseFrom(ByteBuffer byteBuffer) {
        return (GoogleDiagnosticsBugReportRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GoogleDiagnosticsBugReportRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToken(int i) {
        this.bitField0_ |= 1;
        this.token_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GoogleDiagnosticsBugReportRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Ԅ\u0000", new Object[]{"bitField0_", "token_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GoogleDiagnosticsBugReportRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GoogleDiagnosticsBugReportRequest.class) {
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

    @Override // fr.sd.taada.proto.GoogleDiagnosticsBugReportRequestOrBuilder
    public int getToken() {
        return this.token_;
    }

    @Override // fr.sd.taada.proto.GoogleDiagnosticsBugReportRequestOrBuilder
    public boolean hasToken() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(GoogleDiagnosticsBugReportRequest googleDiagnosticsBugReportRequest) {
        return DEFAULT_INSTANCE.createBuilder(googleDiagnosticsBugReportRequest);
    }

    public static GoogleDiagnosticsBugReportRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDiagnosticsBugReportRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDiagnosticsBugReportRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDiagnosticsBugReportRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GoogleDiagnosticsBugReportRequest parseFrom(ByteString byteString) {
        return (GoogleDiagnosticsBugReportRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GoogleDiagnosticsBugReportRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDiagnosticsBugReportRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GoogleDiagnosticsBugReportRequest parseFrom(byte[] bArr) {
        return (GoogleDiagnosticsBugReportRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoogleDiagnosticsBugReportRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDiagnosticsBugReportRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GoogleDiagnosticsBugReportRequest parseFrom(InputStream inputStream) {
        return (GoogleDiagnosticsBugReportRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDiagnosticsBugReportRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDiagnosticsBugReportRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDiagnosticsBugReportRequest parseFrom(CodedInputStream codedInputStream) {
        return (GoogleDiagnosticsBugReportRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GoogleDiagnosticsBugReportRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDiagnosticsBugReportRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
