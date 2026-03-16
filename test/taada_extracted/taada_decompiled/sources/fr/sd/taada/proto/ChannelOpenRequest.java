package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class ChannelOpenRequest extends GeneratedMessageLite<ChannelOpenRequest, Builder> implements ChannelOpenRequestOrBuilder {
    private static final ChannelOpenRequest DEFAULT_INSTANCE;
    private static volatile Parser<ChannelOpenRequest> PARSER = null;
    public static final int PRIORITY_FIELD_NUMBER = 1;
    public static final int SERVICE_ID_FIELD_NUMBER = 2;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int priority_;
    private int serviceId_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.ChannelOpenRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ChannelOpenRequest, Builder> implements ChannelOpenRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearPriority() {
            copyOnWrite();
            ((ChannelOpenRequest) this.instance).clearPriority();
            return this;
        }

        public Builder clearServiceId() {
            copyOnWrite();
            ((ChannelOpenRequest) this.instance).clearServiceId();
            return this;
        }

        @Override // fr.sd.taada.proto.ChannelOpenRequestOrBuilder
        public int getPriority() {
            return ((ChannelOpenRequest) this.instance).getPriority();
        }

        @Override // fr.sd.taada.proto.ChannelOpenRequestOrBuilder
        public int getServiceId() {
            return ((ChannelOpenRequest) this.instance).getServiceId();
        }

        @Override // fr.sd.taada.proto.ChannelOpenRequestOrBuilder
        public boolean hasPriority() {
            return ((ChannelOpenRequest) this.instance).hasPriority();
        }

        @Override // fr.sd.taada.proto.ChannelOpenRequestOrBuilder
        public boolean hasServiceId() {
            return ((ChannelOpenRequest) this.instance).hasServiceId();
        }

        public Builder setPriority(int i) {
            copyOnWrite();
            ((ChannelOpenRequest) this.instance).setPriority(i);
            return this;
        }

        public Builder setServiceId(int i) {
            copyOnWrite();
            ((ChannelOpenRequest) this.instance).setServiceId(i);
            return this;
        }

        private Builder() {
            super(ChannelOpenRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        ChannelOpenRequest channelOpenRequest = new ChannelOpenRequest();
        DEFAULT_INSTANCE = channelOpenRequest;
        GeneratedMessageLite.registerDefaultInstance(ChannelOpenRequest.class, channelOpenRequest);
    }

    private ChannelOpenRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPriority() {
        this.bitField0_ &= -2;
        this.priority_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServiceId() {
        this.bitField0_ &= -3;
        this.serviceId_ = 0;
    }

    public static ChannelOpenRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ChannelOpenRequest parseDelimitedFrom(InputStream inputStream) {
        return (ChannelOpenRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ChannelOpenRequest parseFrom(ByteBuffer byteBuffer) {
        return (ChannelOpenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ChannelOpenRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPriority(int i) {
        this.bitField0_ |= 1;
        this.priority_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceId(int i) {
        this.bitField0_ |= 2;
        this.serviceId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ChannelOpenRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ԏ\u0000\u0002Ԅ\u0001", new Object[]{"bitField0_", "priority_", "serviceId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ChannelOpenRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ChannelOpenRequest.class) {
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

    @Override // fr.sd.taada.proto.ChannelOpenRequestOrBuilder
    public int getPriority() {
        return this.priority_;
    }

    @Override // fr.sd.taada.proto.ChannelOpenRequestOrBuilder
    public int getServiceId() {
        return this.serviceId_;
    }

    @Override // fr.sd.taada.proto.ChannelOpenRequestOrBuilder
    public boolean hasPriority() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.ChannelOpenRequestOrBuilder
    public boolean hasServiceId() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(ChannelOpenRequest channelOpenRequest) {
        return DEFAULT_INSTANCE.createBuilder(channelOpenRequest);
    }

    public static ChannelOpenRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ChannelOpenRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ChannelOpenRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ChannelOpenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ChannelOpenRequest parseFrom(ByteString byteString) {
        return (ChannelOpenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ChannelOpenRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ChannelOpenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ChannelOpenRequest parseFrom(byte[] bArr) {
        return (ChannelOpenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ChannelOpenRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ChannelOpenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ChannelOpenRequest parseFrom(InputStream inputStream) {
        return (ChannelOpenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ChannelOpenRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ChannelOpenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ChannelOpenRequest parseFrom(CodedInputStream codedInputStream) {
        return (ChannelOpenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ChannelOpenRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ChannelOpenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
