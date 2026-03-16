package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class ConnectedDevice extends GeneratedMessageLite<ConnectedDevice, Builder> implements ConnectedDeviceOrBuilder {
    private static final ConnectedDevice DEFAULT_INSTANCE;
    public static final int DEVICE_ID_FIELD_NUMBER = 2;
    public static final int DEVICE_NAME_FIELD_NUMBER = 1;
    private static volatile Parser<ConnectedDevice> PARSER;
    private int bitField0_;
    private int deviceId_;
    private String deviceName_ = "";

    /* JADX INFO: renamed from: fr.sd.taada.proto.ConnectedDevice$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ConnectedDevice, Builder> implements ConnectedDeviceOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDeviceId() {
            copyOnWrite();
            ((ConnectedDevice) this.instance).clearDeviceId();
            return this;
        }

        public Builder clearDeviceName() {
            copyOnWrite();
            ((ConnectedDevice) this.instance).clearDeviceName();
            return this;
        }

        @Override // fr.sd.taada.proto.ConnectedDeviceOrBuilder
        public int getDeviceId() {
            return ((ConnectedDevice) this.instance).getDeviceId();
        }

        @Override // fr.sd.taada.proto.ConnectedDeviceOrBuilder
        public String getDeviceName() {
            return ((ConnectedDevice) this.instance).getDeviceName();
        }

        @Override // fr.sd.taada.proto.ConnectedDeviceOrBuilder
        public ByteString getDeviceNameBytes() {
            return ((ConnectedDevice) this.instance).getDeviceNameBytes();
        }

        @Override // fr.sd.taada.proto.ConnectedDeviceOrBuilder
        public boolean hasDeviceId() {
            return ((ConnectedDevice) this.instance).hasDeviceId();
        }

        @Override // fr.sd.taada.proto.ConnectedDeviceOrBuilder
        public boolean hasDeviceName() {
            return ((ConnectedDevice) this.instance).hasDeviceName();
        }

        public Builder setDeviceId(int i) {
            copyOnWrite();
            ((ConnectedDevice) this.instance).setDeviceId(i);
            return this;
        }

        public Builder setDeviceName(String str) {
            copyOnWrite();
            ((ConnectedDevice) this.instance).setDeviceName(str);
            return this;
        }

        public Builder setDeviceNameBytes(ByteString byteString) {
            copyOnWrite();
            ((ConnectedDevice) this.instance).setDeviceNameBytes(byteString);
            return this;
        }

        private Builder() {
            super(ConnectedDevice.DEFAULT_INSTANCE);
        }
    }

    static {
        ConnectedDevice connectedDevice = new ConnectedDevice();
        DEFAULT_INSTANCE = connectedDevice;
        GeneratedMessageLite.registerDefaultInstance(ConnectedDevice.class, connectedDevice);
    }

    private ConnectedDevice() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeviceId() {
        this.bitField0_ &= -3;
        this.deviceId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeviceName() {
        this.bitField0_ &= -2;
        this.deviceName_ = getDefaultInstance().getDeviceName();
    }

    public static ConnectedDevice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ConnectedDevice parseDelimitedFrom(InputStream inputStream) {
        return (ConnectedDevice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConnectedDevice parseFrom(ByteBuffer byteBuffer) {
        return (ConnectedDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ConnectedDevice> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceId(int i) {
        this.bitField0_ |= 2;
        this.deviceId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.deviceName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceNameBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.deviceName_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ConnectedDevice();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0004\u0001", new Object[]{"bitField0_", "deviceName_", "deviceId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ConnectedDevice> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ConnectedDevice.class) {
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

    @Override // fr.sd.taada.proto.ConnectedDeviceOrBuilder
    public int getDeviceId() {
        return this.deviceId_;
    }

    @Override // fr.sd.taada.proto.ConnectedDeviceOrBuilder
    public String getDeviceName() {
        return this.deviceName_;
    }

    @Override // fr.sd.taada.proto.ConnectedDeviceOrBuilder
    public ByteString getDeviceNameBytes() {
        return ByteString.copyFromUtf8(this.deviceName_);
    }

    @Override // fr.sd.taada.proto.ConnectedDeviceOrBuilder
    public boolean hasDeviceId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.ConnectedDeviceOrBuilder
    public boolean hasDeviceName() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(ConnectedDevice connectedDevice) {
        return DEFAULT_INSTANCE.createBuilder(connectedDevice);
    }

    public static ConnectedDevice parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ConnectedDevice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ConnectedDevice parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ConnectedDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ConnectedDevice parseFrom(ByteString byteString) {
        return (ConnectedDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ConnectedDevice parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ConnectedDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ConnectedDevice parseFrom(byte[] bArr) {
        return (ConnectedDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ConnectedDevice parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ConnectedDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ConnectedDevice parseFrom(InputStream inputStream) {
        return (ConnectedDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConnectedDevice parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ConnectedDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ConnectedDevice parseFrom(CodedInputStream codedInputStream) {
        return (ConnectedDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ConnectedDevice parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ConnectedDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
