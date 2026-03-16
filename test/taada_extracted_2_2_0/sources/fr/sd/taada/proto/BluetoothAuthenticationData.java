package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothAuthenticationData extends GeneratedMessageLite<BluetoothAuthenticationData, Builder> implements BluetoothAuthenticationDataOrBuilder {
    public static final int AUTH_DATA_FIELD_NUMBER = 1;
    private static final BluetoothAuthenticationData DEFAULT_INSTANCE;
    public static final int PAIRING_METHOD_FIELD_NUMBER = 2;
    private static volatile Parser<BluetoothAuthenticationData> PARSER;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private String authData_ = "";
    private int pairingMethod_ = -1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.BluetoothAuthenticationData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<BluetoothAuthenticationData, Builder> implements BluetoothAuthenticationDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAuthData() {
            copyOnWrite();
            ((BluetoothAuthenticationData) this.instance).clearAuthData();
            return this;
        }

        public Builder clearPairingMethod() {
            copyOnWrite();
            ((BluetoothAuthenticationData) this.instance).clearPairingMethod();
            return this;
        }

        @Override // fr.sd.taada.proto.BluetoothAuthenticationDataOrBuilder
        public String getAuthData() {
            return ((BluetoothAuthenticationData) this.instance).getAuthData();
        }

        @Override // fr.sd.taada.proto.BluetoothAuthenticationDataOrBuilder
        public ByteString getAuthDataBytes() {
            return ((BluetoothAuthenticationData) this.instance).getAuthDataBytes();
        }

        @Override // fr.sd.taada.proto.BluetoothAuthenticationDataOrBuilder
        public BluetoothPairingMethod getPairingMethod() {
            return ((BluetoothAuthenticationData) this.instance).getPairingMethod();
        }

        @Override // fr.sd.taada.proto.BluetoothAuthenticationDataOrBuilder
        public boolean hasAuthData() {
            return ((BluetoothAuthenticationData) this.instance).hasAuthData();
        }

        @Override // fr.sd.taada.proto.BluetoothAuthenticationDataOrBuilder
        public boolean hasPairingMethod() {
            return ((BluetoothAuthenticationData) this.instance).hasPairingMethod();
        }

        public Builder setAuthData(String str) {
            copyOnWrite();
            ((BluetoothAuthenticationData) this.instance).setAuthData(str);
            return this;
        }

        public Builder setAuthDataBytes(ByteString byteString) {
            copyOnWrite();
            ((BluetoothAuthenticationData) this.instance).setAuthDataBytes(byteString);
            return this;
        }

        public Builder setPairingMethod(BluetoothPairingMethod bluetoothPairingMethod) {
            copyOnWrite();
            ((BluetoothAuthenticationData) this.instance).setPairingMethod(bluetoothPairingMethod);
            return this;
        }

        private Builder() {
            super(BluetoothAuthenticationData.DEFAULT_INSTANCE);
        }
    }

    static {
        BluetoothAuthenticationData bluetoothAuthenticationData = new BluetoothAuthenticationData();
        DEFAULT_INSTANCE = bluetoothAuthenticationData;
        GeneratedMessageLite.registerDefaultInstance(BluetoothAuthenticationData.class, bluetoothAuthenticationData);
    }

    private BluetoothAuthenticationData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAuthData() {
        this.bitField0_ &= -2;
        this.authData_ = getDefaultInstance().getAuthData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPairingMethod() {
        this.bitField0_ &= -3;
        this.pairingMethod_ = -1;
    }

    public static BluetoothAuthenticationData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static BluetoothAuthenticationData parseDelimitedFrom(InputStream inputStream) {
        return (BluetoothAuthenticationData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BluetoothAuthenticationData parseFrom(ByteBuffer byteBuffer) {
        return (BluetoothAuthenticationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<BluetoothAuthenticationData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthData(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.authData_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthDataBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.authData_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPairingMethod(BluetoothPairingMethod bluetoothPairingMethod) {
        bluetoothPairingMethod.getClass();
        this.bitField0_ |= 2;
        this.pairingMethod_ = bluetoothPairingMethod.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new BluetoothAuthenticationData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\f\u0001", new Object[]{"bitField0_", "authData_", "pairingMethod_", BluetoothPairingMethod.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BluetoothAuthenticationData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (BluetoothAuthenticationData.class) {
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

    @Override // fr.sd.taada.proto.BluetoothAuthenticationDataOrBuilder
    public String getAuthData() {
        return this.authData_;
    }

    @Override // fr.sd.taada.proto.BluetoothAuthenticationDataOrBuilder
    public ByteString getAuthDataBytes() {
        return ByteString.copyFromUtf8(this.authData_);
    }

    @Override // fr.sd.taada.proto.BluetoothAuthenticationDataOrBuilder
    public BluetoothPairingMethod getPairingMethod() {
        BluetoothPairingMethod bluetoothPairingMethodForNumber = BluetoothPairingMethod.forNumber(this.pairingMethod_);
        return bluetoothPairingMethodForNumber == null ? BluetoothPairingMethod.BLUETOOTH_PAIRING_UNAVAILABLE : bluetoothPairingMethodForNumber;
    }

    @Override // fr.sd.taada.proto.BluetoothAuthenticationDataOrBuilder
    public boolean hasAuthData() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.BluetoothAuthenticationDataOrBuilder
    public boolean hasPairingMethod() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(BluetoothAuthenticationData bluetoothAuthenticationData) {
        return DEFAULT_INSTANCE.createBuilder(bluetoothAuthenticationData);
    }

    public static BluetoothAuthenticationData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothAuthenticationData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BluetoothAuthenticationData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothAuthenticationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static BluetoothAuthenticationData parseFrom(ByteString byteString) {
        return (BluetoothAuthenticationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static BluetoothAuthenticationData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothAuthenticationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BluetoothAuthenticationData parseFrom(byte[] bArr) {
        return (BluetoothAuthenticationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BluetoothAuthenticationData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothAuthenticationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BluetoothAuthenticationData parseFrom(InputStream inputStream) {
        return (BluetoothAuthenticationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BluetoothAuthenticationData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothAuthenticationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BluetoothAuthenticationData parseFrom(CodedInputStream codedInputStream) {
        return (BluetoothAuthenticationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BluetoothAuthenticationData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BluetoothAuthenticationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
