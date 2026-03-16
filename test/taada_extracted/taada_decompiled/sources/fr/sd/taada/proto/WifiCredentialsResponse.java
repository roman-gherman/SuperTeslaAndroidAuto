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
public final class WifiCredentialsResponse extends GeneratedMessageLite<WifiCredentialsResponse, Builder> implements WifiCredentialsResponseOrBuilder {
    public static final int ACCESS_POINT_TYPE_FIELD_NUMBER = 5;
    public static final int CAR_WIFI_PASSWORD_FIELD_NUMBER = 1;
    public static final int CAR_WIFI_SECURITY_MODE_FIELD_NUMBER = 2;
    public static final int CAR_WIFI_SSID_FIELD_NUMBER = 3;
    private static final WifiCredentialsResponse DEFAULT_INSTANCE;
    private static volatile Parser<WifiCredentialsResponse> PARSER = null;
    public static final int SUPPORTED_WIFI_CHANNELS_FIELD_NUMBER = 4;
    private int accessPointType_;
    private int bitField0_;
    private int carWifiSecurityMode_;
    private String carWifiPassword_ = "";
    private String carWifiSsid_ = "";
    private Internal.IntList supportedWifiChannels_ = GeneratedMessageLite.emptyIntList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.WifiCredentialsResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<WifiCredentialsResponse, Builder> implements WifiCredentialsResponseOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllSupportedWifiChannels(Iterable<? extends Integer> iterable) {
            copyOnWrite();
            ((WifiCredentialsResponse) this.instance).addAllSupportedWifiChannels(iterable);
            return this;
        }

        public Builder addSupportedWifiChannels(int i) {
            copyOnWrite();
            ((WifiCredentialsResponse) this.instance).addSupportedWifiChannels(i);
            return this;
        }

        public Builder clearAccessPointType() {
            copyOnWrite();
            ((WifiCredentialsResponse) this.instance).clearAccessPointType();
            return this;
        }

        public Builder clearCarWifiPassword() {
            copyOnWrite();
            ((WifiCredentialsResponse) this.instance).clearCarWifiPassword();
            return this;
        }

        public Builder clearCarWifiSecurityMode() {
            copyOnWrite();
            ((WifiCredentialsResponse) this.instance).clearCarWifiSecurityMode();
            return this;
        }

        public Builder clearCarWifiSsid() {
            copyOnWrite();
            ((WifiCredentialsResponse) this.instance).clearCarWifiSsid();
            return this;
        }

        public Builder clearSupportedWifiChannels() {
            copyOnWrite();
            ((WifiCredentialsResponse) this.instance).clearSupportedWifiChannels();
            return this;
        }

        @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
        public AccessPointType getAccessPointType() {
            return ((WifiCredentialsResponse) this.instance).getAccessPointType();
        }

        @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
        public String getCarWifiPassword() {
            return ((WifiCredentialsResponse) this.instance).getCarWifiPassword();
        }

        @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
        public ByteString getCarWifiPasswordBytes() {
            return ((WifiCredentialsResponse) this.instance).getCarWifiPasswordBytes();
        }

        @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
        public WifiSecurityMode getCarWifiSecurityMode() {
            return ((WifiCredentialsResponse) this.instance).getCarWifiSecurityMode();
        }

        @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
        public String getCarWifiSsid() {
            return ((WifiCredentialsResponse) this.instance).getCarWifiSsid();
        }

        @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
        public ByteString getCarWifiSsidBytes() {
            return ((WifiCredentialsResponse) this.instance).getCarWifiSsidBytes();
        }

        @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
        public int getSupportedWifiChannels(int i) {
            return ((WifiCredentialsResponse) this.instance).getSupportedWifiChannels(i);
        }

        @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
        public int getSupportedWifiChannelsCount() {
            return ((WifiCredentialsResponse) this.instance).getSupportedWifiChannelsCount();
        }

        @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
        public List<Integer> getSupportedWifiChannelsList() {
            return Collections.unmodifiableList(((WifiCredentialsResponse) this.instance).getSupportedWifiChannelsList());
        }

        @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
        public boolean hasAccessPointType() {
            return ((WifiCredentialsResponse) this.instance).hasAccessPointType();
        }

        @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
        public boolean hasCarWifiPassword() {
            return ((WifiCredentialsResponse) this.instance).hasCarWifiPassword();
        }

        @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
        public boolean hasCarWifiSecurityMode() {
            return ((WifiCredentialsResponse) this.instance).hasCarWifiSecurityMode();
        }

        @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
        public boolean hasCarWifiSsid() {
            return ((WifiCredentialsResponse) this.instance).hasCarWifiSsid();
        }

        public Builder setAccessPointType(AccessPointType accessPointType) {
            copyOnWrite();
            ((WifiCredentialsResponse) this.instance).setAccessPointType(accessPointType);
            return this;
        }

        public Builder setCarWifiPassword(String str) {
            copyOnWrite();
            ((WifiCredentialsResponse) this.instance).setCarWifiPassword(str);
            return this;
        }

        public Builder setCarWifiPasswordBytes(ByteString byteString) {
            copyOnWrite();
            ((WifiCredentialsResponse) this.instance).setCarWifiPasswordBytes(byteString);
            return this;
        }

        public Builder setCarWifiSecurityMode(WifiSecurityMode wifiSecurityMode) {
            copyOnWrite();
            ((WifiCredentialsResponse) this.instance).setCarWifiSecurityMode(wifiSecurityMode);
            return this;
        }

        public Builder setCarWifiSsid(String str) {
            copyOnWrite();
            ((WifiCredentialsResponse) this.instance).setCarWifiSsid(str);
            return this;
        }

        public Builder setCarWifiSsidBytes(ByteString byteString) {
            copyOnWrite();
            ((WifiCredentialsResponse) this.instance).setCarWifiSsidBytes(byteString);
            return this;
        }

        public Builder setSupportedWifiChannels(int i, int i3) {
            copyOnWrite();
            ((WifiCredentialsResponse) this.instance).setSupportedWifiChannels(i, i3);
            return this;
        }

        private Builder() {
            super(WifiCredentialsResponse.DEFAULT_INSTANCE);
        }
    }

    static {
        WifiCredentialsResponse wifiCredentialsResponse = new WifiCredentialsResponse();
        DEFAULT_INSTANCE = wifiCredentialsResponse;
        GeneratedMessageLite.registerDefaultInstance(WifiCredentialsResponse.class, wifiCredentialsResponse);
    }

    private WifiCredentialsResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSupportedWifiChannels(Iterable<? extends Integer> iterable) {
        ensureSupportedWifiChannelsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.supportedWifiChannels_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSupportedWifiChannels(int i) {
        ensureSupportedWifiChannelsIsMutable();
        this.supportedWifiChannels_.addInt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAccessPointType() {
        this.bitField0_ &= -9;
        this.accessPointType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCarWifiPassword() {
        this.bitField0_ &= -2;
        this.carWifiPassword_ = getDefaultInstance().getCarWifiPassword();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCarWifiSecurityMode() {
        this.bitField0_ &= -3;
        this.carWifiSecurityMode_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCarWifiSsid() {
        this.bitField0_ &= -5;
        this.carWifiSsid_ = getDefaultInstance().getCarWifiSsid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSupportedWifiChannels() {
        this.supportedWifiChannels_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureSupportedWifiChannelsIsMutable() {
        if (this.supportedWifiChannels_.isModifiable()) {
            return;
        }
        this.supportedWifiChannels_ = GeneratedMessageLite.mutableCopy(this.supportedWifiChannels_);
    }

    public static WifiCredentialsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static WifiCredentialsResponse parseDelimitedFrom(InputStream inputStream) {
        return (WifiCredentialsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WifiCredentialsResponse parseFrom(ByteBuffer byteBuffer) {
        return (WifiCredentialsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<WifiCredentialsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccessPointType(AccessPointType accessPointType) {
        accessPointType.getClass();
        this.bitField0_ |= 8;
        this.accessPointType_ = accessPointType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCarWifiPassword(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.carWifiPassword_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCarWifiPasswordBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.carWifiPassword_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCarWifiSecurityMode(WifiSecurityMode wifiSecurityMode) {
        wifiSecurityMode.getClass();
        this.bitField0_ |= 2;
        this.carWifiSecurityMode_ = wifiSecurityMode.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCarWifiSsid(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.carWifiSsid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCarWifiSsidBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 4;
        this.carWifiSsid_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSupportedWifiChannels(int i, int i3) {
        ensureSupportedWifiChannelsIsMutable();
        this.supportedWifiChannels_.setInt(i, i3);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new WifiCredentialsResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\b\u0000\u0002\f\u0001\u0003\b\u0002\u0004\u0016\u0005\f\u0003", new Object[]{"bitField0_", "carWifiPassword_", "carWifiSecurityMode_", WifiSecurityMode.internalGetVerifier(), "carWifiSsid_", "supportedWifiChannels_", "accessPointType_", AccessPointType.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<WifiCredentialsResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (WifiCredentialsResponse.class) {
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

    @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
    public AccessPointType getAccessPointType() {
        AccessPointType accessPointTypeForNumber = AccessPointType.forNumber(this.accessPointType_);
        return accessPointTypeForNumber == null ? AccessPointType.STATIC : accessPointTypeForNumber;
    }

    @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
    public String getCarWifiPassword() {
        return this.carWifiPassword_;
    }

    @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
    public ByteString getCarWifiPasswordBytes() {
        return ByteString.copyFromUtf8(this.carWifiPassword_);
    }

    @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
    public WifiSecurityMode getCarWifiSecurityMode() {
        WifiSecurityMode wifiSecurityModeForNumber = WifiSecurityMode.forNumber(this.carWifiSecurityMode_);
        return wifiSecurityModeForNumber == null ? WifiSecurityMode.UNKNOWN_SECURITY_MODE : wifiSecurityModeForNumber;
    }

    @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
    public String getCarWifiSsid() {
        return this.carWifiSsid_;
    }

    @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
    public ByteString getCarWifiSsidBytes() {
        return ByteString.copyFromUtf8(this.carWifiSsid_);
    }

    @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
    public int getSupportedWifiChannels(int i) {
        return this.supportedWifiChannels_.getInt(i);
    }

    @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
    public int getSupportedWifiChannelsCount() {
        return this.supportedWifiChannels_.size();
    }

    @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
    public List<Integer> getSupportedWifiChannelsList() {
        return this.supportedWifiChannels_;
    }

    @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
    public boolean hasAccessPointType() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
    public boolean hasCarWifiPassword() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
    public boolean hasCarWifiSecurityMode() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.WifiCredentialsResponseOrBuilder
    public boolean hasCarWifiSsid() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(WifiCredentialsResponse wifiCredentialsResponse) {
        return DEFAULT_INSTANCE.createBuilder(wifiCredentialsResponse);
    }

    public static WifiCredentialsResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WifiCredentialsResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WifiCredentialsResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (WifiCredentialsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static WifiCredentialsResponse parseFrom(ByteString byteString) {
        return (WifiCredentialsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static WifiCredentialsResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (WifiCredentialsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static WifiCredentialsResponse parseFrom(byte[] bArr) {
        return (WifiCredentialsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WifiCredentialsResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (WifiCredentialsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static WifiCredentialsResponse parseFrom(InputStream inputStream) {
        return (WifiCredentialsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WifiCredentialsResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WifiCredentialsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WifiCredentialsResponse parseFrom(CodedInputStream codedInputStream) {
        return (WifiCredentialsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static WifiCredentialsResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WifiCredentialsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
