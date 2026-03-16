package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothPairingRequest extends GeneratedMessageLite<BluetoothPairingRequest, Builder> implements BluetoothPairingRequestOrBuilder {
    private static final BluetoothPairingRequest DEFAULT_INSTANCE;
    public static final int PAIRING_METHOD_FIELD_NUMBER = 2;
    private static volatile Parser<BluetoothPairingRequest> PARSER = null;
    public static final int PHONE_ADDRESS_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private String phoneAddress_ = "";
    private int pairingMethod_ = -1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.BluetoothPairingRequest$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<BluetoothPairingRequest, Builder> implements BluetoothPairingRequestOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearPairingMethod() {
            copyOnWrite();
            ((BluetoothPairingRequest) this.instance).clearPairingMethod();
            return this;
        }

        public Builder clearPhoneAddress() {
            copyOnWrite();
            ((BluetoothPairingRequest) this.instance).clearPhoneAddress();
            return this;
        }

        @Override // fr.sd.taada.proto.BluetoothPairingRequestOrBuilder
        public BluetoothPairingMethod getPairingMethod() {
            return ((BluetoothPairingRequest) this.instance).getPairingMethod();
        }

        @Override // fr.sd.taada.proto.BluetoothPairingRequestOrBuilder
        public String getPhoneAddress() {
            return ((BluetoothPairingRequest) this.instance).getPhoneAddress();
        }

        @Override // fr.sd.taada.proto.BluetoothPairingRequestOrBuilder
        public ByteString getPhoneAddressBytes() {
            return ((BluetoothPairingRequest) this.instance).getPhoneAddressBytes();
        }

        @Override // fr.sd.taada.proto.BluetoothPairingRequestOrBuilder
        public boolean hasPairingMethod() {
            return ((BluetoothPairingRequest) this.instance).hasPairingMethod();
        }

        @Override // fr.sd.taada.proto.BluetoothPairingRequestOrBuilder
        public boolean hasPhoneAddress() {
            return ((BluetoothPairingRequest) this.instance).hasPhoneAddress();
        }

        public Builder setPairingMethod(BluetoothPairingMethod bluetoothPairingMethod) {
            copyOnWrite();
            ((BluetoothPairingRequest) this.instance).setPairingMethod(bluetoothPairingMethod);
            return this;
        }

        public Builder setPhoneAddress(String str) {
            copyOnWrite();
            ((BluetoothPairingRequest) this.instance).setPhoneAddress(str);
            return this;
        }

        public Builder setPhoneAddressBytes(ByteString byteString) {
            copyOnWrite();
            ((BluetoothPairingRequest) this.instance).setPhoneAddressBytes(byteString);
            return this;
        }

        private Builder() {
            super(BluetoothPairingRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        BluetoothPairingRequest bluetoothPairingRequest = new BluetoothPairingRequest();
        DEFAULT_INSTANCE = bluetoothPairingRequest;
        GeneratedMessageLite.registerDefaultInstance(BluetoothPairingRequest.class, bluetoothPairingRequest);
    }

    private BluetoothPairingRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPairingMethod() {
        this.bitField0_ &= -3;
        this.pairingMethod_ = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPhoneAddress() {
        this.bitField0_ &= -2;
        this.phoneAddress_ = getDefaultInstance().getPhoneAddress();
    }

    public static BluetoothPairingRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static BluetoothPairingRequest parseDelimitedFrom(InputStream inputStream) {
        return (BluetoothPairingRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BluetoothPairingRequest parseFrom(ByteBuffer byteBuffer) {
        return (BluetoothPairingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<BluetoothPairingRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPairingMethod(BluetoothPairingMethod bluetoothPairingMethod) {
        bluetoothPairingMethod.getClass();
        this.bitField0_ |= 2;
        this.pairingMethod_ = bluetoothPairingMethod.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhoneAddress(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.phoneAddress_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhoneAddressBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.phoneAddress_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new BluetoothPairingRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԉ\u0000\u0002Ԍ\u0001", new Object[]{"bitField0_", "phoneAddress_", "pairingMethod_", BluetoothPairingMethod.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BluetoothPairingRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (BluetoothPairingRequest.class) {
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

    @Override // fr.sd.taada.proto.BluetoothPairingRequestOrBuilder
    public BluetoothPairingMethod getPairingMethod() {
        BluetoothPairingMethod bluetoothPairingMethodForNumber = BluetoothPairingMethod.forNumber(this.pairingMethod_);
        return bluetoothPairingMethodForNumber == null ? BluetoothPairingMethod.BLUETOOTH_PAIRING_UNAVAILABLE : bluetoothPairingMethodForNumber;
    }

    @Override // fr.sd.taada.proto.BluetoothPairingRequestOrBuilder
    public String getPhoneAddress() {
        return this.phoneAddress_;
    }

    @Override // fr.sd.taada.proto.BluetoothPairingRequestOrBuilder
    public ByteString getPhoneAddressBytes() {
        return ByteString.copyFromUtf8(this.phoneAddress_);
    }

    @Override // fr.sd.taada.proto.BluetoothPairingRequestOrBuilder
    public boolean hasPairingMethod() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.BluetoothPairingRequestOrBuilder
    public boolean hasPhoneAddress() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(BluetoothPairingRequest bluetoothPairingRequest) {
        return DEFAULT_INSTANCE.createBuilder(bluetoothPairingRequest);
    }

    public static BluetoothPairingRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothPairingRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BluetoothPairingRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothPairingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static BluetoothPairingRequest parseFrom(ByteString byteString) {
        return (BluetoothPairingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static BluetoothPairingRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothPairingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BluetoothPairingRequest parseFrom(byte[] bArr) {
        return (BluetoothPairingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BluetoothPairingRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothPairingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BluetoothPairingRequest parseFrom(InputStream inputStream) {
        return (BluetoothPairingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BluetoothPairingRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothPairingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BluetoothPairingRequest parseFrom(CodedInputStream codedInputStream) {
        return (BluetoothPairingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BluetoothPairingRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothPairingRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
