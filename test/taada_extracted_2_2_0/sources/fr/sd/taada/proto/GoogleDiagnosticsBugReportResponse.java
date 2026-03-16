package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class GoogleDiagnosticsBugReportResponse extends GeneratedMessageLite<GoogleDiagnosticsBugReportResponse, Builder> implements GoogleDiagnosticsBugReportResponseOrBuilder {
    public static final int BUG_REPORT_FIELD_NUMBER = 1;
    private static final GoogleDiagnosticsBugReportResponse DEFAULT_INSTANCE;
    private static volatile Parser<GoogleDiagnosticsBugReportResponse> PARSER = null;
    public static final int TOKENS_FIELD_NUMBER = 2;
    private int bitField0_;
    private String bugReport_ = "";
    private Internal.IntList tokens_ = GeneratedMessageLite.emptyIntList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.GoogleDiagnosticsBugReportResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GoogleDiagnosticsBugReportResponse, Builder> implements GoogleDiagnosticsBugReportResponseOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllTokens(Iterable<? extends Integer> iterable) {
            copyOnWrite();
            ((GoogleDiagnosticsBugReportResponse) this.instance).addAllTokens(iterable);
            return this;
        }

        public Builder addTokens(int i) {
            copyOnWrite();
            ((GoogleDiagnosticsBugReportResponse) this.instance).addTokens(i);
            return this;
        }

        public Builder clearBugReport() {
            copyOnWrite();
            ((GoogleDiagnosticsBugReportResponse) this.instance).clearBugReport();
            return this;
        }

        public Builder clearTokens() {
            copyOnWrite();
            ((GoogleDiagnosticsBugReportResponse) this.instance).clearTokens();
            return this;
        }

        @Override // fr.sd.taada.proto.GoogleDiagnosticsBugReportResponseOrBuilder
        public String getBugReport() {
            return ((GoogleDiagnosticsBugReportResponse) this.instance).getBugReport();
        }

        @Override // fr.sd.taada.proto.GoogleDiagnosticsBugReportResponseOrBuilder
        public ByteString getBugReportBytes() {
            return ((GoogleDiagnosticsBugReportResponse) this.instance).getBugReportBytes();
        }

        @Override // fr.sd.taada.proto.GoogleDiagnosticsBugReportResponseOrBuilder
        public int getTokens(int i) {
            return ((GoogleDiagnosticsBugReportResponse) this.instance).getTokens(i);
        }

        @Override // fr.sd.taada.proto.GoogleDiagnosticsBugReportResponseOrBuilder
        public int getTokensCount() {
            return ((GoogleDiagnosticsBugReportResponse) this.instance).getTokensCount();
        }

        @Override // fr.sd.taada.proto.GoogleDiagnosticsBugReportResponseOrBuilder
        public List<Integer> getTokensList() {
            return Collections.unmodifiableList(((GoogleDiagnosticsBugReportResponse) this.instance).getTokensList());
        }

        @Override // fr.sd.taada.proto.GoogleDiagnosticsBugReportResponseOrBuilder
        public boolean hasBugReport() {
            return ((GoogleDiagnosticsBugReportResponse) this.instance).hasBugReport();
        }

        public Builder setBugReport(String str) {
            copyOnWrite();
            ((GoogleDiagnosticsBugReportResponse) this.instance).setBugReport(str);
            return this;
        }

        public Builder setBugReportBytes(ByteString byteString) {
            copyOnWrite();
            ((GoogleDiagnosticsBugReportResponse) this.instance).setBugReportBytes(byteString);
            return this;
        }

        public Builder setTokens(int i, int i3) {
            copyOnWrite();
            ((GoogleDiagnosticsBugReportResponse) this.instance).setTokens(i, i3);
            return this;
        }

        private Builder() {
            super(GoogleDiagnosticsBugReportResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        GoogleDiagnosticsBugReportResponse googleDiagnosticsBugReportResponse = new GoogleDiagnosticsBugReportResponse();
        DEFAULT_INSTANCE = googleDiagnosticsBugReportResponse;
        GeneratedMessageLite.registerDefaultInstance(GoogleDiagnosticsBugReportResponse.class, googleDiagnosticsBugReportResponse);
    }

    private GoogleDiagnosticsBugReportResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTokens(Iterable<? extends Integer> iterable) {
        ensureTokensIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.tokens_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTokens(int i) {
        ensureTokensIsMutable();
        this.tokens_.addInt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBugReport() {
        this.bitField0_ &= -2;
        this.bugReport_ = getDefaultInstance().getBugReport();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTokens() {
        this.tokens_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureTokensIsMutable() {
        if (this.tokens_.isModifiable()) {
            return;
        }
        this.tokens_ = GeneratedMessageLite.mutableCopy(this.tokens_);
    }

    public static GoogleDiagnosticsBugReportResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GoogleDiagnosticsBugReportResponse parseDelimitedFrom(InputStream inputStream) {
        return (GoogleDiagnosticsBugReportResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDiagnosticsBugReportResponse parseFrom(ByteBuffer byteBuffer) {
        return (GoogleDiagnosticsBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GoogleDiagnosticsBugReportResponse> parser() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setTokens(int i, int i3) {
        ensureTokensIsMutable();
        this.tokens_.setInt(i, i3);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GoogleDiagnosticsBugReportResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\b\u0000\u0002\u0016", new Object[]{"bitField0_", "bugReport_", "tokens_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GoogleDiagnosticsBugReportResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GoogleDiagnosticsBugReportResponse.class) {
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
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // fr.sd.taada.proto.GoogleDiagnosticsBugReportResponseOrBuilder
    public String getBugReport() {
        return this.bugReport_;
    }

    @Override // fr.sd.taada.proto.GoogleDiagnosticsBugReportResponseOrBuilder
    public ByteString getBugReportBytes() {
        return ByteString.copyFromUtf8(this.bugReport_);
    }

    @Override // fr.sd.taada.proto.GoogleDiagnosticsBugReportResponseOrBuilder
    public int getTokens(int i) {
        return this.tokens_.getInt(i);
    }

    @Override // fr.sd.taada.proto.GoogleDiagnosticsBugReportResponseOrBuilder
    public int getTokensCount() {
        return this.tokens_.size();
    }

    @Override // fr.sd.taada.proto.GoogleDiagnosticsBugReportResponseOrBuilder
    public List<Integer> getTokensList() {
        return this.tokens_;
    }

    @Override // fr.sd.taada.proto.GoogleDiagnosticsBugReportResponseOrBuilder
    public boolean hasBugReport() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(GoogleDiagnosticsBugReportResponse googleDiagnosticsBugReportResponse) {
        return DEFAULT_INSTANCE.createBuilder(googleDiagnosticsBugReportResponse);
    }

    public static GoogleDiagnosticsBugReportResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDiagnosticsBugReportResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDiagnosticsBugReportResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDiagnosticsBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GoogleDiagnosticsBugReportResponse parseFrom(ByteString byteString) {
        return (GoogleDiagnosticsBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GoogleDiagnosticsBugReportResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDiagnosticsBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GoogleDiagnosticsBugReportResponse parseFrom(byte[] bArr) {
        return (GoogleDiagnosticsBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoogleDiagnosticsBugReportResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDiagnosticsBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GoogleDiagnosticsBugReportResponse parseFrom(InputStream inputStream) {
        return (GoogleDiagnosticsBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDiagnosticsBugReportResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDiagnosticsBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDiagnosticsBugReportResponse parseFrom(CodedInputStream codedInputStream) {
        return (GoogleDiagnosticsBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GoogleDiagnosticsBugReportResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDiagnosticsBugReportResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
