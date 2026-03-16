package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiProjectionService extends GeneratedMessageLite<WifiProjectionService, Builder> implements WifiProjectionServiceOrBuilder {
    public static final int CAR_WIFI_BSSID_FIELD_NUMBER = 1;
    private static final WifiProjectionService DEFAULT_INSTANCE;
    private static volatile Parser<WifiProjectionService> PARSER;
    private int bitField0_;
    private String carWifiBssid_ = "";

    /* JADX INFO: renamed from: fr.sd.taada.proto.WifiProjectionService$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<WifiProjectionService, Builder> implements WifiProjectionServiceOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCarWifiBssid() {
            copyOnWrite();
            ((WifiProjectionService) this.instance).clearCarWifiBssid();
            return this;
        }

        @Override // fr.sd.taada.proto.WifiProjectionServiceOrBuilder
        public String getCarWifiBssid() {
            return ((WifiProjectionService) this.instance).getCarWifiBssid();
        }

        @Override // fr.sd.taada.proto.WifiProjectionServiceOrBuilder
        public ByteString getCarWifiBssidBytes() {
            return ((WifiProjectionService) this.instance).getCarWifiBssidBytes();
        }

        @Override // fr.sd.taada.proto.WifiProjectionServiceOrBuilder
        public boolean hasCarWifiBssid() {
            return ((WifiProjectionService) this.instance).hasCarWifiBssid();
        }

        public Builder setCarWifiBssid(String str) {
            copyOnWrite();
            ((WifiProjectionService) this.instance).setCarWifiBssid(str);
            return this;
        }

        public Builder setCarWifiBssidBytes(ByteString byteString) {
            copyOnWrite();
            ((WifiProjectionService) this.instance).setCarWifiBssidBytes(byteString);
            return this;
        }

        private Builder() {
            super(WifiProjectionService.DEFAULT_INSTANCE);
        }
    }

    static {
        WifiProjectionService wifiProjectionService = new WifiProjectionService();
        DEFAULT_INSTANCE = wifiProjectionService;
        GeneratedMessageLite.registerDefaultInstance(WifiProjectionService.class, wifiProjectionService);
    }

    private WifiProjectionService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCarWifiBssid() {
        this.bitField0_ &= -2;
        this.carWifiBssid_ = getDefaultInstance().getCarWifiBssid();
    }

    public static WifiProjectionService getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static WifiProjectionService parseDelimitedFrom(InputStream inputStream) {
        return (WifiProjectionService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WifiProjectionService parseFrom(ByteBuffer byteBuffer) {
        return (WifiProjectionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<WifiProjectionService> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCarWifiBssid(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.carWifiBssid_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCarWifiBssidBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.carWifiBssid_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new WifiProjectionService();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"bitField0_", "carWifiBssid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<WifiProjectionService> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (WifiProjectionService.class) {
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

    @Override // fr.sd.taada.proto.WifiProjectionServiceOrBuilder
    public String getCarWifiBssid() {
        return this.carWifiBssid_;
    }

    @Override // fr.sd.taada.proto.WifiProjectionServiceOrBuilder
    public ByteString getCarWifiBssidBytes() {
        return ByteString.copyFromUtf8(this.carWifiBssid_);
    }

    @Override // fr.sd.taada.proto.WifiProjectionServiceOrBuilder
    public boolean hasCarWifiBssid() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(WifiProjectionService wifiProjectionService) {
        return DEFAULT_INSTANCE.createBuilder(wifiProjectionService);
    }

    public static WifiProjectionService parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WifiProjectionService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WifiProjectionService parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (WifiProjectionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static WifiProjectionService parseFrom(ByteString byteString) {
        return (WifiProjectionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static WifiProjectionService parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (WifiProjectionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static WifiProjectionService parseFrom(byte[] bArr) {
        return (WifiProjectionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WifiProjectionService parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (WifiProjectionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static WifiProjectionService parseFrom(InputStream inputStream) {
        return (WifiProjectionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WifiProjectionService parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WifiProjectionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static WifiProjectionService parseFrom(CodedInputStream codedInputStream) {
        return (WifiProjectionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static WifiProjectionService parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (WifiProjectionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
