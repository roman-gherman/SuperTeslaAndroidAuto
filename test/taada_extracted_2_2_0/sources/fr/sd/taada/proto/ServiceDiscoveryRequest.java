package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.PhoneInfo;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class ServiceDiscoveryRequest extends GeneratedMessageLite<ServiceDiscoveryRequest, Builder> implements ServiceDiscoveryRequestOrBuilder {
    private static final ServiceDiscoveryRequest DEFAULT_INSTANCE;
    public static final int DEVICE_NAME_FIELD_NUMBER = 5;
    public static final int LABEL_TEXT_FIELD_NUMBER = 4;
    public static final int LARGE_ICON_FIELD_NUMBER = 3;
    public static final int MEDIUM_ICON_FIELD_NUMBER = 2;
    private static volatile Parser<ServiceDiscoveryRequest> PARSER = null;
    public static final int PHONE_INFO_FIELD_NUMBER = 6;
    public static final int SMALL_ICON_FIELD_NUMBER = 1;
    private int bitField0_;
    private String deviceName_;
    private String labelText_;
    private ByteString largeIcon_;
    private ByteString mediumIcon_;
    private PhoneInfo phoneInfo_;
    private ByteString smallIcon_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.ServiceDiscoveryRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ServiceDiscoveryRequest, Builder> implements ServiceDiscoveryRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDeviceName() {
            copyOnWrite();
            ((ServiceDiscoveryRequest) this.instance).clearDeviceName();
            return this;
        }

        public Builder clearLabelText() {
            copyOnWrite();
            ((ServiceDiscoveryRequest) this.instance).clearLabelText();
            return this;
        }

        public Builder clearLargeIcon() {
            copyOnWrite();
            ((ServiceDiscoveryRequest) this.instance).clearLargeIcon();
            return this;
        }

        public Builder clearMediumIcon() {
            copyOnWrite();
            ((ServiceDiscoveryRequest) this.instance).clearMediumIcon();
            return this;
        }

        public Builder clearPhoneInfo() {
            copyOnWrite();
            ((ServiceDiscoveryRequest) this.instance).clearPhoneInfo();
            return this;
        }

        public Builder clearSmallIcon() {
            copyOnWrite();
            ((ServiceDiscoveryRequest) this.instance).clearSmallIcon();
            return this;
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
        public String getDeviceName() {
            return ((ServiceDiscoveryRequest) this.instance).getDeviceName();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
        public ByteString getDeviceNameBytes() {
            return ((ServiceDiscoveryRequest) this.instance).getDeviceNameBytes();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
        public String getLabelText() {
            return ((ServiceDiscoveryRequest) this.instance).getLabelText();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
        public ByteString getLabelTextBytes() {
            return ((ServiceDiscoveryRequest) this.instance).getLabelTextBytes();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
        public ByteString getLargeIcon() {
            return ((ServiceDiscoveryRequest) this.instance).getLargeIcon();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
        public ByteString getMediumIcon() {
            return ((ServiceDiscoveryRequest) this.instance).getMediumIcon();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
        public PhoneInfo getPhoneInfo() {
            return ((ServiceDiscoveryRequest) this.instance).getPhoneInfo();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
        public ByteString getSmallIcon() {
            return ((ServiceDiscoveryRequest) this.instance).getSmallIcon();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
        public boolean hasDeviceName() {
            return ((ServiceDiscoveryRequest) this.instance).hasDeviceName();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
        public boolean hasLabelText() {
            return ((ServiceDiscoveryRequest) this.instance).hasLabelText();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
        public boolean hasLargeIcon() {
            return ((ServiceDiscoveryRequest) this.instance).hasLargeIcon();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
        public boolean hasMediumIcon() {
            return ((ServiceDiscoveryRequest) this.instance).hasMediumIcon();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
        public boolean hasPhoneInfo() {
            return ((ServiceDiscoveryRequest) this.instance).hasPhoneInfo();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
        public boolean hasSmallIcon() {
            return ((ServiceDiscoveryRequest) this.instance).hasSmallIcon();
        }

        public Builder mergePhoneInfo(PhoneInfo phoneInfo) {
            copyOnWrite();
            ((ServiceDiscoveryRequest) this.instance).mergePhoneInfo(phoneInfo);
            return this;
        }

        public Builder setDeviceName(String str) {
            copyOnWrite();
            ((ServiceDiscoveryRequest) this.instance).setDeviceName(str);
            return this;
        }

        public Builder setDeviceNameBytes(ByteString byteString) {
            copyOnWrite();
            ((ServiceDiscoveryRequest) this.instance).setDeviceNameBytes(byteString);
            return this;
        }

        public Builder setLabelText(String str) {
            copyOnWrite();
            ((ServiceDiscoveryRequest) this.instance).setLabelText(str);
            return this;
        }

        public Builder setLabelTextBytes(ByteString byteString) {
            copyOnWrite();
            ((ServiceDiscoveryRequest) this.instance).setLabelTextBytes(byteString);
            return this;
        }

        public Builder setLargeIcon(ByteString byteString) {
            copyOnWrite();
            ((ServiceDiscoveryRequest) this.instance).setLargeIcon(byteString);
            return this;
        }

        public Builder setMediumIcon(ByteString byteString) {
            copyOnWrite();
            ((ServiceDiscoveryRequest) this.instance).setMediumIcon(byteString);
            return this;
        }

        public Builder setPhoneInfo(PhoneInfo phoneInfo) {
            copyOnWrite();
            ((ServiceDiscoveryRequest) this.instance).setPhoneInfo(phoneInfo);
            return this;
        }

        public Builder setSmallIcon(ByteString byteString) {
            copyOnWrite();
            ((ServiceDiscoveryRequest) this.instance).setSmallIcon(byteString);
            return this;
        }

        private Builder() {
            super(ServiceDiscoveryRequest.DEFAULT_INSTANCE);
        }

        public Builder setPhoneInfo(PhoneInfo.Builder builder) {
            copyOnWrite();
            ((ServiceDiscoveryRequest) this.instance).setPhoneInfo(builder);
            return this;
        }
    }

    static {
        ServiceDiscoveryRequest serviceDiscoveryRequest = new ServiceDiscoveryRequest();
        DEFAULT_INSTANCE = serviceDiscoveryRequest;
        GeneratedMessageLite.registerDefaultInstance(ServiceDiscoveryRequest.class, serviceDiscoveryRequest);
    }

    private ServiceDiscoveryRequest() {
        ByteString byteString = ByteString.EMPTY;
        this.smallIcon_ = byteString;
        this.mediumIcon_ = byteString;
        this.largeIcon_ = byteString;
        this.labelText_ = "";
        this.deviceName_ = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeviceName() {
        this.bitField0_ &= -17;
        this.deviceName_ = getDefaultInstance().getDeviceName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLabelText() {
        this.bitField0_ &= -9;
        this.labelText_ = getDefaultInstance().getLabelText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLargeIcon() {
        this.bitField0_ &= -5;
        this.largeIcon_ = getDefaultInstance().getLargeIcon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMediumIcon() {
        this.bitField0_ &= -3;
        this.mediumIcon_ = getDefaultInstance().getMediumIcon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPhoneInfo() {
        this.phoneInfo_ = null;
        this.bitField0_ &= -33;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSmallIcon() {
        this.bitField0_ &= -2;
        this.smallIcon_ = getDefaultInstance().getSmallIcon();
    }

    public static ServiceDiscoveryRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePhoneInfo(PhoneInfo phoneInfo) {
        phoneInfo.getClass();
        PhoneInfo phoneInfo2 = this.phoneInfo_;
        if (phoneInfo2 == null || phoneInfo2 == PhoneInfo.getDefaultInstance()) {
            this.phoneInfo_ = phoneInfo;
        } else {
            this.phoneInfo_ = PhoneInfo.newBuilder(this.phoneInfo_).mergeFrom(phoneInfo).buildPartial();
        }
        this.bitField0_ |= 32;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ServiceDiscoveryRequest parseDelimitedFrom(InputStream inputStream) {
        return (ServiceDiscoveryRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ServiceDiscoveryRequest parseFrom(ByteBuffer byteBuffer) {
        return (ServiceDiscoveryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ServiceDiscoveryRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceName(String str) {
        str.getClass();
        this.bitField0_ |= 16;
        this.deviceName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeviceNameBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 16;
        this.deviceName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLabelText(String str) {
        str.getClass();
        this.bitField0_ |= 8;
        this.labelText_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLabelTextBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 8;
        this.labelText_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLargeIcon(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 4;
        this.largeIcon_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediumIcon(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2;
        this.mediumIcon_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhoneInfo(PhoneInfo phoneInfo) {
        phoneInfo.getClass();
        this.phoneInfo_ = phoneInfo;
        this.bitField0_ |= 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSmallIcon(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.smallIcon_ = byteString;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ServiceDiscoveryRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001\u0003\n\u0002\u0004\b\u0003\u0005\b\u0004\u0006\t\u0005", new Object[]{"bitField0_", "smallIcon_", "mediumIcon_", "largeIcon_", "labelText_", "deviceName_", "phoneInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ServiceDiscoveryRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ServiceDiscoveryRequest.class) {
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

    @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
    public String getDeviceName() {
        return this.deviceName_;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
    public ByteString getDeviceNameBytes() {
        return ByteString.copyFromUtf8(this.deviceName_);
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
    public String getLabelText() {
        return this.labelText_;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
    public ByteString getLabelTextBytes() {
        return ByteString.copyFromUtf8(this.labelText_);
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
    public ByteString getLargeIcon() {
        return this.largeIcon_;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
    public ByteString getMediumIcon() {
        return this.mediumIcon_;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
    public PhoneInfo getPhoneInfo() {
        PhoneInfo phoneInfo = this.phoneInfo_;
        return phoneInfo == null ? PhoneInfo.getDefaultInstance() : phoneInfo;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
    public ByteString getSmallIcon() {
        return this.smallIcon_;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
    public boolean hasDeviceName() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
    public boolean hasLabelText() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
    public boolean hasLargeIcon() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
    public boolean hasMediumIcon() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
    public boolean hasPhoneInfo() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryRequestOrBuilder
    public boolean hasSmallIcon() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(ServiceDiscoveryRequest serviceDiscoveryRequest) {
        return DEFAULT_INSTANCE.createBuilder(serviceDiscoveryRequest);
    }

    public static ServiceDiscoveryRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ServiceDiscoveryRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ServiceDiscoveryRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ServiceDiscoveryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ServiceDiscoveryRequest parseFrom(ByteString byteString) {
        return (ServiceDiscoveryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ServiceDiscoveryRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ServiceDiscoveryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhoneInfo(PhoneInfo.Builder builder) {
        this.phoneInfo_ = builder.build();
        this.bitField0_ |= 32;
    }

    public static ServiceDiscoveryRequest parseFrom(byte[] bArr) {
        return (ServiceDiscoveryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ServiceDiscoveryRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ServiceDiscoveryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ServiceDiscoveryRequest parseFrom(InputStream inputStream) {
        return (ServiceDiscoveryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ServiceDiscoveryRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ServiceDiscoveryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ServiceDiscoveryRequest parseFrom(CodedInputStream codedInputStream) {
        return (ServiceDiscoveryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ServiceDiscoveryRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ServiceDiscoveryRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
