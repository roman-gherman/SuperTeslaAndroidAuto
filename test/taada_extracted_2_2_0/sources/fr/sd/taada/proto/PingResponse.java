package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class PingResponse extends GeneratedMessageLite<PingResponse, Builder> implements PingResponseOrBuilder {
    public static final int DATA_FIELD_NUMBER = 2;
    private static final PingResponse DEFAULT_INSTANCE;
    private static volatile Parser<PingResponse> PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 1;
    private int bitField0_;
    private long timestamp_;
    private byte memoizedIsInitialized = 2;
    private ByteString data_ = ByteString.EMPTY;

    /* JADX INFO: renamed from: fr.sd.taada.proto.PingResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<PingResponse, Builder> implements PingResponseOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearData() {
            copyOnWrite();
            ((PingResponse) this.instance).clearData();
            return this;
        }

        public Builder clearTimestamp() {
            copyOnWrite();
            ((PingResponse) this.instance).clearTimestamp();
            return this;
        }

        @Override // fr.sd.taada.proto.PingResponseOrBuilder
        public ByteString getData() {
            return ((PingResponse) this.instance).getData();
        }

        @Override // fr.sd.taada.proto.PingResponseOrBuilder
        public long getTimestamp() {
            return ((PingResponse) this.instance).getTimestamp();
        }

        @Override // fr.sd.taada.proto.PingResponseOrBuilder
        public boolean hasData() {
            return ((PingResponse) this.instance).hasData();
        }

        @Override // fr.sd.taada.proto.PingResponseOrBuilder
        public boolean hasTimestamp() {
            return ((PingResponse) this.instance).hasTimestamp();
        }

        public Builder setData(ByteString byteString) {
            copyOnWrite();
            ((PingResponse) this.instance).setData(byteString);
            return this;
        }

        public Builder setTimestamp(long j6) {
            copyOnWrite();
            ((PingResponse) this.instance).setTimestamp(j6);
            return this;
        }

        private Builder() {
            super(PingResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        PingResponse pingResponse = new PingResponse();
        DEFAULT_INSTANCE = pingResponse;
        GeneratedMessageLite.registerDefaultInstance(PingResponse.class, pingResponse);
    }

    private PingResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearData() {
        this.bitField0_ &= -3;
        this.data_ = getDefaultInstance().getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimestamp() {
        this.bitField0_ &= -2;
        this.timestamp_ = 0L;
    }

    public static PingResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PingResponse parseDelimitedFrom(InputStream inputStream) {
        return (PingResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PingResponse parseFrom(ByteBuffer byteBuffer) {
        return (PingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PingResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2;
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
                return new PingResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001Ԃ\u0000\u0002\n\u0001", new Object[]{"bitField0_", "timestamp_", "data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PingResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PingResponse.class) {
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

    @Override // fr.sd.taada.proto.PingResponseOrBuilder
    public ByteString getData() {
        return this.data_;
    }

    @Override // fr.sd.taada.proto.PingResponseOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // fr.sd.taada.proto.PingResponseOrBuilder
    public boolean hasData() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.PingResponseOrBuilder
    public boolean hasTimestamp() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(PingResponse pingResponse) {
        return DEFAULT_INSTANCE.createBuilder(pingResponse);
    }

    public static PingResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PingResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PingResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PingResponse parseFrom(ByteString byteString) {
        return (PingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PingResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PingResponse parseFrom(byte[] bArr) {
        return (PingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PingResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PingResponse parseFrom(InputStream inputStream) {
        return (PingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PingResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PingResponse parseFrom(CodedInputStream codedInputStream) {
        return (PingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PingResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PingResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
