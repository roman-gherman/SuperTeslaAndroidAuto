package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class PingRequest extends GeneratedMessageLite<PingRequest, Builder> implements PingRequestOrBuilder {
    public static final int BUG_REPORT_FIELD_NUMBER = 2;
    public static final int DATA_FIELD_NUMBER = 3;
    private static final PingRequest DEFAULT_INSTANCE;
    private static volatile Parser<PingRequest> PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean bugReport_;
    private long timestamp_;
    private byte memoizedIsInitialized = 2;
    private ByteString data_ = ByteString.EMPTY;

    /* JADX INFO: renamed from: fr.sd.taada.proto.PingRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<PingRequest, Builder> implements PingRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearBugReport() {
            copyOnWrite();
            ((PingRequest) this.instance).clearBugReport();
            return this;
        }

        public Builder clearData() {
            copyOnWrite();
            ((PingRequest) this.instance).clearData();
            return this;
        }

        public Builder clearTimestamp() {
            copyOnWrite();
            ((PingRequest) this.instance).clearTimestamp();
            return this;
        }

        @Override // fr.sd.taada.proto.PingRequestOrBuilder
        public boolean getBugReport() {
            return ((PingRequest) this.instance).getBugReport();
        }

        @Override // fr.sd.taada.proto.PingRequestOrBuilder
        public ByteString getData() {
            return ((PingRequest) this.instance).getData();
        }

        @Override // fr.sd.taada.proto.PingRequestOrBuilder
        public long getTimestamp() {
            return ((PingRequest) this.instance).getTimestamp();
        }

        @Override // fr.sd.taada.proto.PingRequestOrBuilder
        public boolean hasBugReport() {
            return ((PingRequest) this.instance).hasBugReport();
        }

        @Override // fr.sd.taada.proto.PingRequestOrBuilder
        public boolean hasData() {
            return ((PingRequest) this.instance).hasData();
        }

        @Override // fr.sd.taada.proto.PingRequestOrBuilder
        public boolean hasTimestamp() {
            return ((PingRequest) this.instance).hasTimestamp();
        }

        public Builder setBugReport(boolean z6) {
            copyOnWrite();
            ((PingRequest) this.instance).setBugReport(z6);
            return this;
        }

        public Builder setData(ByteString byteString) {
            copyOnWrite();
            ((PingRequest) this.instance).setData(byteString);
            return this;
        }

        public Builder setTimestamp(long j6) {
            copyOnWrite();
            ((PingRequest) this.instance).setTimestamp(j6);
            return this;
        }

        private Builder() {
            super(PingRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        PingRequest pingRequest = new PingRequest();
        DEFAULT_INSTANCE = pingRequest;
        GeneratedMessageLite.registerDefaultInstance(PingRequest.class, pingRequest);
    }

    private PingRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBugReport() {
        this.bitField0_ &= -3;
        this.bugReport_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearData() {
        this.bitField0_ &= -5;
        this.data_ = getDefaultInstance().getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestamp() {
        this.bitField0_ &= -2;
        this.timestamp_ = 0L;
    }

    public static PingRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PingRequest parseDelimitedFrom(InputStream inputStream) {
        return (PingRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PingRequest parseFrom(ByteBuffer byteBuffer) {
        return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PingRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBugReport(boolean z6) {
        this.bitField0_ |= 2;
        this.bugReport_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 4;
        this.data_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimestamp(long j6) {
        this.bitField0_ |= 1;
        this.timestamp_ = j6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PingRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001Ԃ\u0000\u0002\u0007\u0001\u0003\n\u0002", new Object[]{"bitField0_", "timestamp_", "bugReport_", "data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PingRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PingRequest.class) {
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

    @Override // fr.sd.taada.proto.PingRequestOrBuilder
    public boolean getBugReport() {
        return this.bugReport_;
    }

    @Override // fr.sd.taada.proto.PingRequestOrBuilder
    public ByteString getData() {
        return this.data_;
    }

    @Override // fr.sd.taada.proto.PingRequestOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // fr.sd.taada.proto.PingRequestOrBuilder
    public boolean hasBugReport() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.PingRequestOrBuilder
    public boolean hasData() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.PingRequestOrBuilder
    public boolean hasTimestamp() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(PingRequest pingRequest) {
        return DEFAULT_INSTANCE.createBuilder(pingRequest);
    }

    public static PingRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PingRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PingRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PingRequest parseFrom(ByteString byteString) {
        return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PingRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PingRequest parseFrom(byte[] bArr) {
        return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PingRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PingRequest parseFrom(InputStream inputStream) {
        return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PingRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PingRequest parseFrom(CodedInputStream codedInputStream) {
        return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PingRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
