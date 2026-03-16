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
public final class VendorExtensionService extends GeneratedMessageLite<VendorExtensionService, Builder> implements VendorExtensionServiceOrBuilder {
    public static final int DATA_FIELD_NUMBER = 3;
    private static final VendorExtensionService DEFAULT_INSTANCE;
    public static final int PACKAGE_WHITE_LIST_FIELD_NUMBER = 2;
    private static volatile Parser<VendorExtensionService> PARSER = null;
    public static final int SERVICE_NAME_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private String serviceName_ = "";
    private Internal.ProtobufList<String> packageWhiteList_ = GeneratedMessageLite.emptyProtobufList();
    private ByteString data_ = ByteString.EMPTY;

    /* JADX INFO: renamed from: fr.sd.taada.proto.VendorExtensionService$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<VendorExtensionService, Builder> implements VendorExtensionServiceOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllPackageWhiteList(Iterable<String> iterable) {
            copyOnWrite();
            ((VendorExtensionService) this.instance).addAllPackageWhiteList(iterable);
            return this;
        }

        public Builder addPackageWhiteList(String str) {
            copyOnWrite();
            ((VendorExtensionService) this.instance).addPackageWhiteList(str);
            return this;
        }

        public Builder addPackageWhiteListBytes(ByteString byteString) {
            copyOnWrite();
            ((VendorExtensionService) this.instance).addPackageWhiteListBytes(byteString);
            return this;
        }

        public Builder clearData() {
            copyOnWrite();
            ((VendorExtensionService) this.instance).clearData();
            return this;
        }

        public Builder clearPackageWhiteList() {
            copyOnWrite();
            ((VendorExtensionService) this.instance).clearPackageWhiteList();
            return this;
        }

        public Builder clearServiceName() {
            copyOnWrite();
            ((VendorExtensionService) this.instance).clearServiceName();
            return this;
        }

        @Override // fr.sd.taada.proto.VendorExtensionServiceOrBuilder
        public ByteString getData() {
            return ((VendorExtensionService) this.instance).getData();
        }

        @Override // fr.sd.taada.proto.VendorExtensionServiceOrBuilder
        public String getPackageWhiteList(int i) {
            return ((VendorExtensionService) this.instance).getPackageWhiteList(i);
        }

        @Override // fr.sd.taada.proto.VendorExtensionServiceOrBuilder
        public ByteString getPackageWhiteListBytes(int i) {
            return ((VendorExtensionService) this.instance).getPackageWhiteListBytes(i);
        }

        @Override // fr.sd.taada.proto.VendorExtensionServiceOrBuilder
        public int getPackageWhiteListCount() {
            return ((VendorExtensionService) this.instance).getPackageWhiteListCount();
        }

        @Override // fr.sd.taada.proto.VendorExtensionServiceOrBuilder
        public List<String> getPackageWhiteListList() {
            return Collections.unmodifiableList(((VendorExtensionService) this.instance).getPackageWhiteListList());
        }

        @Override // fr.sd.taada.proto.VendorExtensionServiceOrBuilder
        public String getServiceName() {
            return ((VendorExtensionService) this.instance).getServiceName();
        }

        @Override // fr.sd.taada.proto.VendorExtensionServiceOrBuilder
        public ByteString getServiceNameBytes() {
            return ((VendorExtensionService) this.instance).getServiceNameBytes();
        }

        @Override // fr.sd.taada.proto.VendorExtensionServiceOrBuilder
        public boolean hasData() {
            return ((VendorExtensionService) this.instance).hasData();
        }

        @Override // fr.sd.taada.proto.VendorExtensionServiceOrBuilder
        public boolean hasServiceName() {
            return ((VendorExtensionService) this.instance).hasServiceName();
        }

        public Builder setData(ByteString byteString) {
            copyOnWrite();
            ((VendorExtensionService) this.instance).setData(byteString);
            return this;
        }

        public Builder setPackageWhiteList(int i, String str) {
            copyOnWrite();
            ((VendorExtensionService) this.instance).setPackageWhiteList(i, str);
            return this;
        }

        public Builder setServiceName(String str) {
            copyOnWrite();
            ((VendorExtensionService) this.instance).setServiceName(str);
            return this;
        }

        public Builder setServiceNameBytes(ByteString byteString) {
            copyOnWrite();
            ((VendorExtensionService) this.instance).setServiceNameBytes(byteString);
            return this;
        }

        private Builder() {
            super(VendorExtensionService.DEFAULT_INSTANCE);
        }
    }

    static {
        VendorExtensionService vendorExtensionService = new VendorExtensionService();
        DEFAULT_INSTANCE = vendorExtensionService;
        GeneratedMessageLite.registerDefaultInstance(VendorExtensionService.class, vendorExtensionService);
    }

    private VendorExtensionService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPackageWhiteList(Iterable<String> iterable) {
        ensurePackageWhiteListIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.packageWhiteList_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPackageWhiteList(String str) {
        str.getClass();
        ensurePackageWhiteListIsMutable();
        this.packageWhiteList_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPackageWhiteListBytes(ByteString byteString) {
        byteString.getClass();
        ensurePackageWhiteListIsMutable();
        this.packageWhiteList_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearData() {
        this.bitField0_ &= -3;
        this.data_ = getDefaultInstance().getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPackageWhiteList() {
        this.packageWhiteList_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServiceName() {
        this.bitField0_ &= -2;
        this.serviceName_ = getDefaultInstance().getServiceName();
    }

    private void ensurePackageWhiteListIsMutable() {
        if (this.packageWhiteList_.isModifiable()) {
            return;
        }
        this.packageWhiteList_ = GeneratedMessageLite.mutableCopy(this.packageWhiteList_);
    }

    public static VendorExtensionService getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static VendorExtensionService parseDelimitedFrom(InputStream inputStream) {
        return (VendorExtensionService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VendorExtensionService parseFrom(ByteBuffer byteBuffer) {
        return (VendorExtensionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<VendorExtensionService> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2;
        this.data_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPackageWhiteList(int i, String str) {
        str.getClass();
        ensurePackageWhiteListIsMutable();
        this.packageWhiteList_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.serviceName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceNameBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.serviceName_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new VendorExtensionService();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001Ԉ\u0000\u0002\u001a\u0003\n\u0001", new Object[]{"bitField0_", "serviceName_", "packageWhiteList_", "data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<VendorExtensionService> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (VendorExtensionService.class) {
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

    @Override // fr.sd.taada.proto.VendorExtensionServiceOrBuilder
    public ByteString getData() {
        return this.data_;
    }

    @Override // fr.sd.taada.proto.VendorExtensionServiceOrBuilder
    public String getPackageWhiteList(int i) {
        return this.packageWhiteList_.get(i);
    }

    @Override // fr.sd.taada.proto.VendorExtensionServiceOrBuilder
    public ByteString getPackageWhiteListBytes(int i) {
        return ByteString.copyFromUtf8(this.packageWhiteList_.get(i));
    }

    @Override // fr.sd.taada.proto.VendorExtensionServiceOrBuilder
    public int getPackageWhiteListCount() {
        return this.packageWhiteList_.size();
    }

    @Override // fr.sd.taada.proto.VendorExtensionServiceOrBuilder
    public List<String> getPackageWhiteListList() {
        return this.packageWhiteList_;
    }

    @Override // fr.sd.taada.proto.VendorExtensionServiceOrBuilder
    public String getServiceName() {
        return this.serviceName_;
    }

    @Override // fr.sd.taada.proto.VendorExtensionServiceOrBuilder
    public ByteString getServiceNameBytes() {
        return ByteString.copyFromUtf8(this.serviceName_);
    }

    @Override // fr.sd.taada.proto.VendorExtensionServiceOrBuilder
    public boolean hasData() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.VendorExtensionServiceOrBuilder
    public boolean hasServiceName() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(VendorExtensionService vendorExtensionService) {
        return DEFAULT_INSTANCE.createBuilder(vendorExtensionService);
    }

    public static VendorExtensionService parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VendorExtensionService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VendorExtensionService parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (VendorExtensionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static VendorExtensionService parseFrom(ByteString byteString) {
        return (VendorExtensionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static VendorExtensionService parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (VendorExtensionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static VendorExtensionService parseFrom(byte[] bArr) {
        return (VendorExtensionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VendorExtensionService parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (VendorExtensionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static VendorExtensionService parseFrom(InputStream inputStream) {
        return (VendorExtensionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VendorExtensionService parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VendorExtensionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static VendorExtensionService parseFrom(CodedInputStream codedInputStream) {
        return (VendorExtensionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static VendorExtensionService parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (VendorExtensionService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
