package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class PhoneInfo extends GeneratedMessageLite<PhoneInfo, Builder> implements PhoneInfoOrBuilder {
    public static final int CONNECTIVITY_LIFETIME_ID_FIELD_NUMBER = 2;
    private static final PhoneInfo DEFAULT_INSTANCE;
    public static final int INSTANCE_ID_FIELD_NUMBER = 1;
    private static volatile Parser<PhoneInfo> PARSER;
    private int bitField0_;
    private String instanceId_ = "";
    private String connectivityLifetimeId_ = "";

    /* JADX INFO: renamed from: fr.sd.taada.proto.PhoneInfo$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<PhoneInfo, Builder> implements PhoneInfoOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearConnectivityLifetimeId() {
            copyOnWrite();
            ((PhoneInfo) this.instance).clearConnectivityLifetimeId();
            return this;
        }

        public Builder clearInstanceId() {
            copyOnWrite();
            ((PhoneInfo) this.instance).clearInstanceId();
            return this;
        }

        @Override // fr.sd.taada.proto.PhoneInfoOrBuilder
        public String getConnectivityLifetimeId() {
            return ((PhoneInfo) this.instance).getConnectivityLifetimeId();
        }

        @Override // fr.sd.taada.proto.PhoneInfoOrBuilder
        public ByteString getConnectivityLifetimeIdBytes() {
            return ((PhoneInfo) this.instance).getConnectivityLifetimeIdBytes();
        }

        @Override // fr.sd.taada.proto.PhoneInfoOrBuilder
        public String getInstanceId() {
            return ((PhoneInfo) this.instance).getInstanceId();
        }

        @Override // fr.sd.taada.proto.PhoneInfoOrBuilder
        public ByteString getInstanceIdBytes() {
            return ((PhoneInfo) this.instance).getInstanceIdBytes();
        }

        @Override // fr.sd.taada.proto.PhoneInfoOrBuilder
        public boolean hasConnectivityLifetimeId() {
            return ((PhoneInfo) this.instance).hasConnectivityLifetimeId();
        }

        @Override // fr.sd.taada.proto.PhoneInfoOrBuilder
        public boolean hasInstanceId() {
            return ((PhoneInfo) this.instance).hasInstanceId();
        }

        public Builder setConnectivityLifetimeId(String str) {
            copyOnWrite();
            ((PhoneInfo) this.instance).setConnectivityLifetimeId(str);
            return this;
        }

        public Builder setConnectivityLifetimeIdBytes(ByteString byteString) {
            copyOnWrite();
            ((PhoneInfo) this.instance).setConnectivityLifetimeIdBytes(byteString);
            return this;
        }

        public Builder setInstanceId(String str) {
            copyOnWrite();
            ((PhoneInfo) this.instance).setInstanceId(str);
            return this;
        }

        public Builder setInstanceIdBytes(ByteString byteString) {
            copyOnWrite();
            ((PhoneInfo) this.instance).setInstanceIdBytes(byteString);
            return this;
        }

        private Builder() {
            super(PhoneInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        PhoneInfo phoneInfo = new PhoneInfo();
        DEFAULT_INSTANCE = phoneInfo;
        GeneratedMessageLite.registerDefaultInstance(PhoneInfo.class, phoneInfo);
    }

    private PhoneInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConnectivityLifetimeId() {
        this.bitField0_ &= -3;
        this.connectivityLifetimeId_ = getDefaultInstance().getConnectivityLifetimeId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInstanceId() {
        this.bitField0_ &= -2;
        this.instanceId_ = getDefaultInstance().getInstanceId();
    }

    public static PhoneInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PhoneInfo parseDelimitedFrom(InputStream inputStream) {
        return (PhoneInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PhoneInfo parseFrom(ByteBuffer byteBuffer) {
        return (PhoneInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PhoneInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectivityLifetimeId(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.connectivityLifetimeId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectivityLifetimeIdBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2;
        this.connectivityLifetimeId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInstanceId(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.instanceId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInstanceIdBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.instanceId_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PhoneInfo();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"bitField0_", "instanceId_", "connectivityLifetimeId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PhoneInfo> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PhoneInfo.class) {
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

    @Override // fr.sd.taada.proto.PhoneInfoOrBuilder
    public String getConnectivityLifetimeId() {
        return this.connectivityLifetimeId_;
    }

    @Override // fr.sd.taada.proto.PhoneInfoOrBuilder
    public ByteString getConnectivityLifetimeIdBytes() {
        return ByteString.copyFromUtf8(this.connectivityLifetimeId_);
    }

    @Override // fr.sd.taada.proto.PhoneInfoOrBuilder
    public String getInstanceId() {
        return this.instanceId_;
    }

    @Override // fr.sd.taada.proto.PhoneInfoOrBuilder
    public ByteString getInstanceIdBytes() {
        return ByteString.copyFromUtf8(this.instanceId_);
    }

    @Override // fr.sd.taada.proto.PhoneInfoOrBuilder
    public boolean hasConnectivityLifetimeId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.PhoneInfoOrBuilder
    public boolean hasInstanceId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(PhoneInfo phoneInfo) {
        return DEFAULT_INSTANCE.createBuilder(phoneInfo);
    }

    public static PhoneInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhoneInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PhoneInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PhoneInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PhoneInfo parseFrom(ByteString byteString) {
        return (PhoneInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PhoneInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PhoneInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PhoneInfo parseFrom(byte[] bArr) {
        return (PhoneInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PhoneInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PhoneInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PhoneInfo parseFrom(InputStream inputStream) {
        return (PhoneInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PhoneInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhoneInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PhoneInfo parseFrom(CodedInputStream codedInputStream) {
        return (PhoneInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PhoneInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhoneInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
