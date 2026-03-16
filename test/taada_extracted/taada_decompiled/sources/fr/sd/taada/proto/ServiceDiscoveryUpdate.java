package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.Service;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class ServiceDiscoveryUpdate extends GeneratedMessageLite<ServiceDiscoveryUpdate, Builder> implements ServiceDiscoveryUpdateOrBuilder {
    private static final ServiceDiscoveryUpdate DEFAULT_INSTANCE;
    private static volatile Parser<ServiceDiscoveryUpdate> PARSER = null;
    public static final int SERVICE_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private Service service_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.ServiceDiscoveryUpdate$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ServiceDiscoveryUpdate, Builder> implements ServiceDiscoveryUpdateOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearService() {
            copyOnWrite();
            ((ServiceDiscoveryUpdate) this.instance).clearService();
            return this;
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryUpdateOrBuilder
        public Service getService() {
            return ((ServiceDiscoveryUpdate) this.instance).getService();
        }

        @Override // fr.sd.taada.proto.ServiceDiscoveryUpdateOrBuilder
        public boolean hasService() {
            return ((ServiceDiscoveryUpdate) this.instance).hasService();
        }

        public Builder mergeService(Service service) {
            copyOnWrite();
            ((ServiceDiscoveryUpdate) this.instance).mergeService(service);
            return this;
        }

        public Builder setService(Service service) {
            copyOnWrite();
            ((ServiceDiscoveryUpdate) this.instance).setService(service);
            return this;
        }

        private Builder() {
            super(ServiceDiscoveryUpdate.DEFAULT_INSTANCE);
        }

        public Builder setService(Service.Builder builder) {
            copyOnWrite();
            ((ServiceDiscoveryUpdate) this.instance).setService(builder);
            return this;
        }
    }

    static {
        ServiceDiscoveryUpdate serviceDiscoveryUpdate = new ServiceDiscoveryUpdate();
        DEFAULT_INSTANCE = serviceDiscoveryUpdate;
        GeneratedMessageLite.registerDefaultInstance(ServiceDiscoveryUpdate.class, serviceDiscoveryUpdate);
    }

    private ServiceDiscoveryUpdate() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearService() {
        this.service_ = null;
        this.bitField0_ &= -2;
    }

    public static ServiceDiscoveryUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeService(Service service) {
        service.getClass();
        Service service2 = this.service_;
        if (service2 == null || service2 == Service.getDefaultInstance()) {
            this.service_ = service;
        } else {
            this.service_ = Service.newBuilder(this.service_).mergeFrom(service).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ServiceDiscoveryUpdate parseDelimitedFrom(InputStream inputStream) {
        return (ServiceDiscoveryUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ServiceDiscoveryUpdate parseFrom(ByteBuffer byteBuffer) {
        return (ServiceDiscoveryUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ServiceDiscoveryUpdate> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setService(Service service) {
        service.getClass();
        this.service_ = service;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ServiceDiscoveryUpdate();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Љ\u0000", new Object[]{"bitField0_", "service_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ServiceDiscoveryUpdate> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ServiceDiscoveryUpdate.class) {
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

    @Override // fr.sd.taada.proto.ServiceDiscoveryUpdateOrBuilder
    public Service getService() {
        Service service = this.service_;
        return service == null ? Service.getDefaultInstance() : service;
    }

    @Override // fr.sd.taada.proto.ServiceDiscoveryUpdateOrBuilder
    public boolean hasService() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(ServiceDiscoveryUpdate serviceDiscoveryUpdate) {
        return DEFAULT_INSTANCE.createBuilder(serviceDiscoveryUpdate);
    }

    public static ServiceDiscoveryUpdate parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ServiceDiscoveryUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ServiceDiscoveryUpdate parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ServiceDiscoveryUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ServiceDiscoveryUpdate parseFrom(ByteString byteString) {
        return (ServiceDiscoveryUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ServiceDiscoveryUpdate parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ServiceDiscoveryUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setService(Service.Builder builder) {
        this.service_ = builder.build();
        this.bitField0_ |= 1;
    }

    public static ServiceDiscoveryUpdate parseFrom(byte[] bArr) {
        return (ServiceDiscoveryUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ServiceDiscoveryUpdate parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ServiceDiscoveryUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ServiceDiscoveryUpdate parseFrom(InputStream inputStream) {
        return (ServiceDiscoveryUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ServiceDiscoveryUpdate parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ServiceDiscoveryUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ServiceDiscoveryUpdate parseFrom(CodedInputStream codedInputStream) {
        return (ServiceDiscoveryUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ServiceDiscoveryUpdate parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ServiceDiscoveryUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
