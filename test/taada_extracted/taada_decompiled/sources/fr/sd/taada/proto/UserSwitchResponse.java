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
public final class UserSwitchResponse extends GeneratedMessageLite<UserSwitchResponse, Builder> implements UserSwitchResponseOrBuilder {
    private static final UserSwitchResponse DEFAULT_INSTANCE;
    private static volatile Parser<UserSwitchResponse> PARSER = null;
    public static final int SELECTED_DEVICE_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int bitField0_;
    private ConnectedDevice selectedDevice_;
    private int status_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.UserSwitchResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<UserSwitchResponse, Builder> implements UserSwitchResponseOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearSelectedDevice() {
            copyOnWrite();
            ((UserSwitchResponse) this.instance).clearSelectedDevice();
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((UserSwitchResponse) this.instance).clearStatus();
            return this;
        }

        @Override // fr.sd.taada.proto.UserSwitchResponseOrBuilder
        public ConnectedDevice getSelectedDevice() {
            return ((UserSwitchResponse) this.instance).getSelectedDevice();
        }

        @Override // fr.sd.taada.proto.UserSwitchResponseOrBuilder
        public UserSwitchStatus getStatus() {
            return ((UserSwitchResponse) this.instance).getStatus();
        }

        @Override // fr.sd.taada.proto.UserSwitchResponseOrBuilder
        public boolean hasSelectedDevice() {
            return ((UserSwitchResponse) this.instance).hasSelectedDevice();
        }

        @Override // fr.sd.taada.proto.UserSwitchResponseOrBuilder
        public boolean hasStatus() {
            return ((UserSwitchResponse) this.instance).hasStatus();
        }

        public Builder mergeSelectedDevice(ConnectedDevice connectedDevice) {
            copyOnWrite();
            ((UserSwitchResponse) this.instance).mergeSelectedDevice(connectedDevice);
            return this;
        }

        public Builder setSelectedDevice(ConnectedDevice connectedDevice) {
            copyOnWrite();
            ((UserSwitchResponse) this.instance).setSelectedDevice(connectedDevice);
            return this;
        }

        public Builder setStatus(UserSwitchStatus userSwitchStatus) {
            copyOnWrite();
            ((UserSwitchResponse) this.instance).setStatus(userSwitchStatus);
            return this;
        }

        private Builder() {
            super(UserSwitchResponse.DEFAULT_INSTANCE);
        }

        public Builder setSelectedDevice(ConnectedDevice.Builder builder) {
            copyOnWrite();
            ((UserSwitchResponse) this.instance).setSelectedDevice(builder);
            return this;
        }
    }

    static {
        UserSwitchResponse userSwitchResponse = new UserSwitchResponse();
        DEFAULT_INSTANCE = userSwitchResponse;
        GeneratedMessageLite.registerDefaultInstance(UserSwitchResponse.class, userSwitchResponse);
    }

    private UserSwitchResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelectedDevice() {
        this.selectedDevice_ = null;
        this.bitField0_ &= -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.bitField0_ &= -2;
        this.status_ = 0;
    }

    public static UserSwitchResponse getDefaultInstance() {
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
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static UserSwitchResponse parseDelimitedFrom(InputStream inputStream) {
        return (UserSwitchResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UserSwitchResponse parseFrom(ByteBuffer byteBuffer) {
        return (UserSwitchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<UserSwitchResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectedDevice(ConnectedDevice connectedDevice) {
        connectedDevice.getClass();
        this.selectedDevice_ = connectedDevice;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(UserSwitchStatus userSwitchStatus) {
        userSwitchStatus.getClass();
        this.bitField0_ |= 1;
        this.status_ = userSwitchStatus.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new UserSwitchResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"bitField0_", "status_", UserSwitchStatus.internalGetVerifier(), "selectedDevice_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<UserSwitchResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (UserSwitchResponse.class) {
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

    @Override // fr.sd.taada.proto.UserSwitchResponseOrBuilder
    public ConnectedDevice getSelectedDevice() {
        ConnectedDevice connectedDevice = this.selectedDevice_;
        return connectedDevice == null ? ConnectedDevice.getDefaultInstance() : connectedDevice;
    }

    @Override // fr.sd.taada.proto.UserSwitchResponseOrBuilder
    public UserSwitchStatus getStatus() {
        UserSwitchStatus userSwitchStatusForNumber = UserSwitchStatus.forNumber(this.status_);
        return userSwitchStatusForNumber == null ? UserSwitchStatus.STATUS_OK : userSwitchStatusForNumber;
    }

    @Override // fr.sd.taada.proto.UserSwitchResponseOrBuilder
    public boolean hasSelectedDevice() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.UserSwitchResponseOrBuilder
    public boolean hasStatus() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(UserSwitchResponse userSwitchResponse) {
        return DEFAULT_INSTANCE.createBuilder(userSwitchResponse);
    }

    public static UserSwitchResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UserSwitchResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UserSwitchResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (UserSwitchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static UserSwitchResponse parseFrom(ByteString byteString) {
        return (UserSwitchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static UserSwitchResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (UserSwitchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectedDevice(ConnectedDevice.Builder builder) {
        this.selectedDevice_ = builder.build();
        this.bitField0_ |= 2;
    }

    public static UserSwitchResponse parseFrom(byte[] bArr) {
        return (UserSwitchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UserSwitchResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (UserSwitchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static UserSwitchResponse parseFrom(InputStream inputStream) {
        return (UserSwitchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UserSwitchResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UserSwitchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UserSwitchResponse parseFrom(CodedInputStream codedInputStream) {
        return (UserSwitchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static UserSwitchResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UserSwitchResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
