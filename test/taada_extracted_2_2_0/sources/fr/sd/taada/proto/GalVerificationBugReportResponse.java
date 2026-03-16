package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class GalVerificationBugReportResponse extends GeneratedMessageLite<GalVerificationBugReportResponse, Builder> implements GalVerificationBugReportResponseOrBuilder {
    public static final int BUG_REPORT_FIELD_NUMBER = 1;
    private static final GalVerificationBugReportResponse DEFAULT_INSTANCE;
    private static volatile Parser<GalVerificationBugReportResponse> PARSER;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private String bugReport_ = "";

    /* JADX INFO: renamed from: fr.sd.taada.proto.GalVerificationBugReportResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GalVerificationBugReportResponse, Builder> implements GalVerificationBugReportResponseOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearBugReport() {
            copyOnWrite();
            ((GalVerificationBugReportResponse) this.instance).clearBugReport();
            return this;
        }

        @Override // fr.sd.taada.proto.GalVerificationBugReportResponseOrBuilder
        public String getBugReport() {
            return ((GalVerificationBugReportResponse) this.instance).getBugReport();
        }

        @Override // fr.sd.taada.proto.GalVerificationBugReportResponseOrBuilder
        public ByteString getBugReportBytes() {
            return ((GalVerificationBugReportResponse) this.instance).getBugReportBytes();
        }

        @Override // fr.sd.taada.proto.GalVerificationBugReportResponseOrBuilder
        public boolean hasBugReport() {
            return ((GalVerificationBugReportResponse) this.instance).hasBugReport();
        }

        public Builder setBugReport(String str) {
            copyOnWrite();
            ((GalVerificationBugReportResponse) this.instance).setBugReport(str);
            return this;
        }

        public Builder setBugReportBytes(ByteString byteString) {
            copyOnWrite();
            ((GalVerificationBugReportResponse) this.instance).setBugReportBytes(byteString);
            return this;
        }

        private Builder() {
            super(GalVerificationBugReportResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        GalVerificationBugReportResponse galVerificationBugReportResponse = new GalVerificationBugReportResponse();
        DEFAULT_INSTANCE = galVerificationBugReportResponse;
        GeneratedMessageLite.registerDefaultInstance(GalVerificationBugReportResponse.class, galVerificationBugReportResponse);
    }

    private GalVerificationBugReportResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBugReport() {
        this.bitField0_ &= -2;
        this.bugReport_ = getDefaultInstance().getBugReport();
    }

    public static GalVerificationBugReportResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GalVerificationBugReportResponse parseDelimitedFrom(InputStream inputStream) {
        return (GalVerificationBugReportResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GalVerificationBugReportResponse parseFrom(ByteBuffer byteBuffer) {
        return (GalVerificationBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GalVerificationBugReportResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBugReport(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.bugReport_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBugReportBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.bugReport_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GalVerificationBugReportResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Ԉ\u0000", new Object[]{"bitField0_", "bugReport_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GalVerificationBugReportResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GalVerificationBugReportResponse.class) {
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

    @Override // fr.sd.taada.proto.GalVerificationBugReportResponseOrBuilder
    public String getBugReport() {
        return this.bugReport_;
    }

    @Override // fr.sd.taada.proto.GalVerificationBugReportResponseOrBuilder
    public ByteString getBugReportBytes() {
        return ByteString.copyFromUtf8(this.bugReport_);
    }

    @Override // fr.sd.taada.proto.GalVerificationBugReportResponseOrBuilder
    public boolean hasBugReport() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(GalVerificationBugReportResponse galVerificationBugReportResponse) {
        return DEFAULT_INSTANCE.createBuilder(galVerificationBugReportResponse);
    }

    public static GalVerificationBugReportResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationBugReportResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GalVerificationBugReportResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GalVerificationBugReportResponse parseFrom(ByteString byteString) {
        return (GalVerificationBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GalVerificationBugReportResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GalVerificationBugReportResponse parseFrom(byte[] bArr) {
        return (GalVerificationBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GalVerificationBugReportResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GalVerificationBugReportResponse parseFrom(InputStream inputStream) {
        return (GalVerificationBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GalVerificationBugReportResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GalVerificationBugReportResponse parseFrom(CodedInputStream codedInputStream) {
        return (GalVerificationBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GalVerificationBugReportResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GalVerificationBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
