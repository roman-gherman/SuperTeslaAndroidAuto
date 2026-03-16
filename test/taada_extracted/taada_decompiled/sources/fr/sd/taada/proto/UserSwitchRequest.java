package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.ConnectedDevice;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class UserSwitchRequest extends GeneratedMessageLite<UserSwitchRequest, Builder> implements UserSwitchRequestOrBuilder {
    private static final UserSwitchRequest DEFAULT_INSTANCE;
    private static volatile Parser<UserSwitchRequest> PARSER = null;
    public static final int SELECTED_DEVICE_FIELD_NUMBER = 1;
    private int bitField0_;
    private ConnectedDevice selectedDevice_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.UserSwitchRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<UserSwitchRequest, Builder> implements UserSwitchRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearSelectedDevice() {
            copyOnWrite();
            ((UserSwitchRequest) this.instance).clearSelectedDevice();
            return this;
        }

        @Override // fr.sd.taada.proto.UserSwitchRequestOrBuilder
        public ConnectedDevice getSelectedDevice() {
            return ((UserSwitchRequest) this.instance).getSelectedDevice();
        }

        @Override // fr.sd.taada.proto.UserSwitchRequestOrBuilder
        public boolean hasSelectedDevice() {
            return ((UserSwitchRequest) this.instance).hasSelectedDevice();
        }

        public Builder mergeSelectedDevice(ConnectedDevice connectedDevice) {
            copyOnWrite();
            ((UserSwitchRequest) this.instance).mergeSelectedDevice(connectedDevice);
            return this;
        }

        public Builder setSelectedDevice(ConnectedDevice connectedDevice) {
            copyOnWrite();
            ((UserSwitchRequest) this.instance).setSelectedDevice(connectedDevice);
            return this;
        }

        private Builder() {
            super(UserSwitchRequest.DEFAULT_INSTANCE);
        }

        public Builder setSelectedDevice(ConnectedDevice.Builder builder) {
            copyOnWrite();
            ((UserSwitchRequest) this.instance).setSelectedDevice(builder);
            return this;
        }
    }

    static {
        UserSwitchRequest userSwitchRequest = new UserSwitchRequest();
        DEFAULT_INSTANCE = userSwitchRequest;
        GeneratedMessageLite.registerDefaultInstance(UserSwitchRequest.class, userSwitchRequest);
    }

    private UserSwitchRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelectedDevice() {
        this.selectedDevice_ = null;
        this.bitField0_ &= -2;
    }

    public static UserSwitchRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSelectedDevice(ConnectedDevice connectedDevice) {
        connectedDevice.getClass();
        ConnectedDevice connectedDevice2 = this.selectedDevice_;
        if (connectedDevice2 == null || connectedDevice2 == ConnectedDevice.getDefaultInstance()) {
            this.selectedDevice_ = connectedDevice;
        } else {
            this.selectedDevice_ = ConnectedDevice.newBuilder(this.selectedDevice_).mergeFrom(connectedDevice).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static UserSwitchRequest parseDelimitedFrom(InputStream inputStream) {
        return (UserSwitchRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UserSwitchRequest parseFrom(ByteBuffer byteBuffer) {
        return (UserSwitchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<UserSwitchRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectedDevice(ConnectedDevice connectedDevice) {
        connectedDevice.getClass();
        this.selectedDevice_ = connectedDevice;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new UserSwitchRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t\u0000", new Object[]{"bitField0_", "selectedDevice_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<UserSwitchRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (UserSwitchRequest.class) {
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

    @Override // fr.sd.taada.proto.UserSwitchRequestOrBuilder
    public ConnectedDevice getSelectedDevice() {
        ConnectedDevice connectedDevice = this.selectedDevice_;
        return connectedDevice == null ? ConnectedDevice.getDefaultInstance() : connectedDevice;
    }

    @Override // fr.sd.taada.proto.UserSwitchRequestOrBuilder
    public boolean hasSelectedDevice() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(UserSwitchRequest userSwitchRequest) {
        return DEFAULT_INSTANCE.createBuilder(userSwitchRequest);
    }

    public static UserSwitchRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UserSwitchRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UserSwitchRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (UserSwitchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static UserSwitchRequest parseFrom(ByteString byteString) {
        return (UserSwitchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static UserSwitchRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (UserSwitchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectedDevice(ConnectedDevice.Builder builder) {
        this.selectedDevice_ = builder.build();
        this.bitField0_ |= 1;
    }

    public static UserSwitchRequest parseFrom(byte[] bArr) {
        return (UserSwitchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UserSwitchRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (UserSwitchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static UserSwitchRequest parseFrom(InputStream inputStream) {
        return (UserSwitchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UserSwitchRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UserSwitchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UserSwitchRequest parseFrom(CodedInputStream codedInputStream) {
        return (UserSwitchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static UserSwitchRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UserSwitchRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
