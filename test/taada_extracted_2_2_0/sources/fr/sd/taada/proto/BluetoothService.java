package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothService extends GeneratedMessageLite<BluetoothService, Builder> implements BluetoothServiceOrBuilder {
    public static final int CAR_ADDRESS_FIELD_NUMBER = 1;
    private static final BluetoothService DEFAULT_INSTANCE;
    private static volatile Parser<BluetoothService> PARSER = null;
    public static final int SUPPORTED_PAIRING_METHODS_FIELD_NUMBER = 2;
    private static final Internal.ListAdapter.Converter<Integer, BluetoothPairingMethod> supportedPairingMethods_converter_ = new Internal.ListAdapter.Converter<Integer, BluetoothPairingMethod>() { // from class: fr.sd.taada.proto.BluetoothService.1
        @Override // com.google.protobuf.Internal.ListAdapter.Converter
        public BluetoothPairingMethod convert(Integer num) {
            BluetoothPairingMethod bluetoothPairingMethodForNumber = BluetoothPairingMethod.forNumber(num.intValue());
            return bluetoothPairingMethodForNumber == null ? BluetoothPairingMethod.BLUETOOTH_PAIRING_UNAVAILABLE : bluetoothPairingMethodForNumber;
        }
    };
    private int bitField0_;
    private int supportedPairingMethodsMemoizedSerializedSize;
    private byte memoizedIsInitialized = 2;
    private String carAddress_ = "";
    private Internal.IntList supportedPairingMethods_ = GeneratedMessageLite.emptyIntList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.BluetoothService$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
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

    public static final class Builder extends GeneratedMessageLite.Builder<BluetoothService, Builder> implements BluetoothServiceOrBuilder {
        public Builder addAllSupportedPairingMethods(Iterable<? extends BluetoothPairingMethod> iterable) {
            copyOnWrite();
            ((BluetoothService) this.instance).addAllSupportedPairingMethods(iterable);
            return this;
        }

        public Builder addSupportedPairingMethods(BluetoothPairingMethod bluetoothPairingMethod) {
            copyOnWrite();
            ((BluetoothService) this.instance).addSupportedPairingMethods(bluetoothPairingMethod);
            return this;
        }

        public Builder clearCarAddress() {
            copyOnWrite();
            ((BluetoothService) this.instance).clearCarAddress();
            return this;
        }

        public Builder clearSupportedPairingMethods() {
            copyOnWrite();
            ((BluetoothService) this.instance).clearSupportedPairingMethods();
            return this;
        }

        @Override // fr.sd.taada.proto.BluetoothServiceOrBuilder
        public String getCarAddress() {
            return ((BluetoothService) this.instance).getCarAddress();
        }

        @Override // fr.sd.taada.proto.BluetoothServiceOrBuilder
        public ByteString getCarAddressBytes() {
            return ((BluetoothService) this.instance).getCarAddressBytes();
        }

        @Override // fr.sd.taada.proto.BluetoothServiceOrBuilder
        public BluetoothPairingMethod getSupportedPairingMethods(int i) {
            return ((BluetoothService) this.instance).getSupportedPairingMethods(i);
        }

        @Override // fr.sd.taada.proto.BluetoothServiceOrBuilder
        public int getSupportedPairingMethodsCount() {
            return ((BluetoothService) this.instance).getSupportedPairingMethodsCount();
        }

        @Override // fr.sd.taada.proto.BluetoothServiceOrBuilder
        public List<BluetoothPairingMethod> getSupportedPairingMethodsList() {
            return ((BluetoothService) this.instance).getSupportedPairingMethodsList();
        }

        @Override // fr.sd.taada.proto.BluetoothServiceOrBuilder
        public boolean hasCarAddress() {
            return ((BluetoothService) this.instance).hasCarAddress();
        }

        public Builder setCarAddress(String str) {
            copyOnWrite();
            ((BluetoothService) this.instance).setCarAddress(str);
            return this;
        }

        public Builder setCarAddressBytes(ByteString byteString) {
            copyOnWrite();
            ((BluetoothService) this.instance).setCarAddressBytes(byteString);
            return this;
        }

        public Builder setSupportedPairingMethods(int i, BluetoothPairingMethod bluetoothPairingMethod) {
            copyOnWrite();
            ((BluetoothService) this.instance).setSupportedPairingMethods(i, bluetoothPairingMethod);
            return this;
        }

        private Builder() {
            super(BluetoothService.DEFAULT_INSTANCE);
        }
    }

    static {
        BluetoothService bluetoothService = new BluetoothService();
        DEFAULT_INSTANCE = bluetoothService;
        GeneratedMessageLite.registerDefaultInstance(BluetoothService.class, bluetoothService);
    }

    private BluetoothService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSupportedPairingMethods(Iterable<? extends BluetoothPairingMethod> iterable) {
        ensureSupportedPairingMethodsIsMutable();
        Iterator<? extends BluetoothPairingMethod> it = iterable.iterator();
        while (it.hasNext()) {
            this.supportedPairingMethods_.addInt(it.next().getNumber());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSupportedPairingMethods(BluetoothPairingMethod bluetoothPairingMethod) {
        bluetoothPairingMethod.getClass();
        ensureSupportedPairingMethodsIsMutable();
        this.supportedPairingMethods_.addInt(bluetoothPairingMethod.getNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCarAddress() {
        this.bitField0_ &= -2;
        this.carAddress_ = getDefaultInstance().getCarAddress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSupportedPairingMethods() {
        this.supportedPairingMethods_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureSupportedPairingMethodsIsMutable() {
        if (this.supportedPairingMethods_.isModifiable()) {
            return;
        }
        this.supportedPairingMethods_ = GeneratedMessageLite.mutableCopy(this.supportedPairingMethods_);
    }

    public static BluetoothService getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static BluetoothService parseDelimitedFrom(InputStream inputStream) {
        return (BluetoothService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BluetoothService parseFrom(ByteBuffer byteBuffer) {
        return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<BluetoothService> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCarAddress(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.carAddress_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCarAddressBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.carAddress_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSupportedPairingMethods(int i, BluetoothPairingMethod bluetoothPairingMethod) {
        bluetoothPairingMethod.getClass();
        ensureSupportedPairingMethodsIsMutable();
        this.supportedPairingMethods_.setInt(i, bluetoothPairingMethod.getNumber());
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (AnonymousClass2.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new BluetoothService();
            case 2:
                return new Builder();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0001\u0001Ԉ\u0000\u0002,", new Object[]{"bitField0_", "carAddress_", "supportedPairingMethods_", BluetoothPairingMethod.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BluetoothService> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (BluetoothService.class) {
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

    @Override // fr.sd.taada.proto.BluetoothServiceOrBuilder
    public String getCarAddress() {
        return this.carAddress_;
    }

    @Override // fr.sd.taada.proto.BluetoothServiceOrBuilder
    public ByteString getCarAddressBytes() {
        return ByteString.copyFromUtf8(this.carAddress_);
    }

    @Override // fr.sd.taada.proto.BluetoothServiceOrBuilder
    public BluetoothPairingMethod getSupportedPairingMethods(int i) {
        return supportedPairingMethods_converter_.convert(Integer.valueOf(this.supportedPairingMethods_.getInt(i)));
    }

    @Override // fr.sd.taada.proto.BluetoothServiceOrBuilder
    public int getSupportedPairingMethodsCount() {
        return this.supportedPairingMethods_.size();
    }

    @Override // fr.sd.taada.proto.BluetoothServiceOrBuilder
    public List<BluetoothPairingMethod> getSupportedPairingMethodsList() {
        return new Internal.ListAdapter(this.supportedPairingMethods_, supportedPairingMethods_converter_);
    }

    @Override // fr.sd.taada.proto.BluetoothServiceOrBuilder
    public boolean hasCarAddress() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(BluetoothService bluetoothService) {
        return DEFAULT_INSTANCE.createBuilder(bluetoothService);
    }

    public static BluetoothService parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BluetoothService parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static BluetoothService parseFrom(ByteString byteString) {
        return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static BluetoothService parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BluetoothService parseFrom(byte[] bArr) {
        return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BluetoothService parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BluetoothService parseFrom(InputStream inputStream) {
        return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BluetoothService parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BluetoothService parseFrom(CodedInputStream codedInputStream) {
        return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BluetoothService parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
