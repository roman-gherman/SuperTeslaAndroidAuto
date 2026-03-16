package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.ConnectedDevice;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CarConnectedDevices extends GeneratedMessageLite<CarConnectedDevices, Builder> implements CarConnectedDevicesOrBuilder {
    public static final int CONNECTED_DEVICES_FIELD_NUMBER = 1;
    private static final CarConnectedDevices DEFAULT_INSTANCE;
    public static final int FINAL_LIST_FIELD_NUMBER = 3;
    private static volatile Parser<CarConnectedDevices> PARSER = null;
    public static final int UNSOLICITED_FIELD_NUMBER = 2;
    private int bitField0_;
    private Internal.ProtobufList<ConnectedDevice> connectedDevices_ = GeneratedMessageLite.emptyProtobufList();
    private boolean finalList_ = true;
    private boolean unsolicited_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.CarConnectedDevices$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<CarConnectedDevices, Builder> implements CarConnectedDevicesOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllConnectedDevices(Iterable<? extends ConnectedDevice> iterable) {
            copyOnWrite();
            ((CarConnectedDevices) this.instance).addAllConnectedDevices(iterable);
            return this;
        }

        public Builder addConnectedDevices(ConnectedDevice connectedDevice) {
            copyOnWrite();
            ((CarConnectedDevices) this.instance).addConnectedDevices(connectedDevice);
            return this;
        }

        public Builder clearConnectedDevices() {
            copyOnWrite();
            ((CarConnectedDevices) this.instance).clearConnectedDevices();
            return this;
        }

        public Builder clearFinalList() {
            copyOnWrite();
            ((CarConnectedDevices) this.instance).clearFinalList();
            return this;
        }

        public Builder clearUnsolicited() {
            copyOnWrite();
            ((CarConnectedDevices) this.instance).clearUnsolicited();
            return this;
        }

        @Override // fr.sd.taada.proto.CarConnectedDevicesOrBuilder
        public ConnectedDevice getConnectedDevices(int i) {
            return ((CarConnectedDevices) this.instance).getConnectedDevices(i);
        }

        @Override // fr.sd.taada.proto.CarConnectedDevicesOrBuilder
        public int getConnectedDevicesCount() {
            return ((CarConnectedDevices) this.instance).getConnectedDevicesCount();
        }

        @Override // fr.sd.taada.proto.CarConnectedDevicesOrBuilder
        public List<ConnectedDevice> getConnectedDevicesList() {
            return Collections.unmodifiableList(((CarConnectedDevices) this.instance).getConnectedDevicesList());
        }

        @Override // fr.sd.taada.proto.CarConnectedDevicesOrBuilder
        public boolean getFinalList() {
            return ((CarConnectedDevices) this.instance).getFinalList();
        }

        @Override // fr.sd.taada.proto.CarConnectedDevicesOrBuilder
        public boolean getUnsolicited() {
            return ((CarConnectedDevices) this.instance).getUnsolicited();
        }

        @Override // fr.sd.taada.proto.CarConnectedDevicesOrBuilder
        public boolean hasFinalList() {
            return ((CarConnectedDevices) this.instance).hasFinalList();
        }

        @Override // fr.sd.taada.proto.CarConnectedDevicesOrBuilder
        public boolean hasUnsolicited() {
            return ((CarConnectedDevices) this.instance).hasUnsolicited();
        }

        public Builder removeConnectedDevices(int i) {
            copyOnWrite();
            ((CarConnectedDevices) this.instance).removeConnectedDevices(i);
            return this;
        }

        public Builder setConnectedDevices(int i, ConnectedDevice connectedDevice) {
            copyOnWrite();
            ((CarConnectedDevices) this.instance).setConnectedDevices(i, connectedDevice);
            return this;
        }

        public Builder setFinalList(boolean z6) {
            copyOnWrite();
            ((CarConnectedDevices) this.instance).setFinalList(z6);
            return this;
        }

        public Builder setUnsolicited(boolean z6) {
            copyOnWrite();
            ((CarConnectedDevices) this.instance).setUnsolicited(z6);
            return this;
        }

        private Builder() {
            super(CarConnectedDevices.DEFAULT_INSTANCE);
        }

        public Builder addConnectedDevices(int i, ConnectedDevice connectedDevice) {
            copyOnWrite();
            ((CarConnectedDevices) this.instance).addConnectedDevices(i, connectedDevice);
            return this;
        }

        public Builder setConnectedDevices(int i, ConnectedDevice.Builder builder) {
            copyOnWrite();
            ((CarConnectedDevices) this.instance).setConnectedDevices(i, builder);
            return this;
        }

        public Builder addConnectedDevices(ConnectedDevice.Builder builder) {
            copyOnWrite();
            ((CarConnectedDevices) this.instance).addConnectedDevices(builder);
            return this;
        }

        public Builder addConnectedDevices(int i, ConnectedDevice.Builder builder) {
            copyOnWrite();
            ((CarConnectedDevices) this.instance).addConnectedDevices(i, builder);
            return this;
        }
    }

    static {
        CarConnectedDevices carConnectedDevices = new CarConnectedDevices();
        DEFAULT_INSTANCE = carConnectedDevices;
        GeneratedMessageLite.registerDefaultInstance(CarConnectedDevices.class, carConnectedDevices);
    }

    private CarConnectedDevices() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllConnectedDevices(Iterable<? extends ConnectedDevice> iterable) {
        ensureConnectedDevicesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.connectedDevices_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConnectedDevices(ConnectedDevice connectedDevice) {
        connectedDevice.getClass();
        ensureConnectedDevicesIsMutable();
        this.connectedDevices_.add(connectedDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConnectedDevices() {
        this.connectedDevices_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFinalList() {
        this.bitField0_ &= -3;
        this.finalList_ = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUnsolicited() {
        this.bitField0_ &= -2;
        this.unsolicited_ = false;
    }

    private void ensureConnectedDevicesIsMutable() {
        if (this.connectedDevices_.isModifiable()) {
            return;
        }
        this.connectedDevices_ = GeneratedMessageLite.mutableCopy(this.connectedDevices_);
    }

    public static CarConnectedDevices getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static CarConnectedDevices parseDelimitedFrom(InputStream inputStream) {
        return (CarConnectedDevices) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CarConnectedDevices parseFrom(ByteBuffer byteBuffer) {
        return (CarConnectedDevices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CarConnectedDevices> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeConnectedDevices(int i) {
        ensureConnectedDevicesIsMutable();
        this.connectedDevices_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectedDevices(int i, ConnectedDevice connectedDevice) {
        connectedDevice.getClass();
        ensureConnectedDevicesIsMutable();
        this.connectedDevices_.set(i, connectedDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFinalList(boolean z6) {
        this.bitField0_ |= 2;
        this.finalList_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUnsolicited(boolean z6) {
        this.bitField0_ |= 1;
        this.unsolicited_ = z6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new CarConnectedDevices();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002\u0007\u0000\u0003\u0007\u0001", new Object[]{"bitField0_", "connectedDevices_", ConnectedDevice.class, "unsolicited_", "finalList_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CarConnectedDevices> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (CarConnectedDevices.class) {
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

    @Override // fr.sd.taada.proto.CarConnectedDevicesOrBuilder
    public ConnectedDevice getConnectedDevices(int i) {
        return this.connectedDevices_.get(i);
    }

    @Override // fr.sd.taada.proto.CarConnectedDevicesOrBuilder
    public int getConnectedDevicesCount() {
        return this.connectedDevices_.size();
    }

    @Override // fr.sd.taada.proto.CarConnectedDevicesOrBuilder
    public List<ConnectedDevice> getConnectedDevicesList() {
        return this.connectedDevices_;
    }

    public ConnectedDeviceOrBuilder getConnectedDevicesOrBuilder(int i) {
        return this.connectedDevices_.get(i);
    }

    public List<? extends ConnectedDeviceOrBuilder> getConnectedDevicesOrBuilderList() {
        return this.connectedDevices_;
    }

    @Override // fr.sd.taada.proto.CarConnectedDevicesOrBuilder
    public boolean getFinalList() {
        return this.finalList_;
    }

    @Override // fr.sd.taada.proto.CarConnectedDevicesOrBuilder
    public boolean getUnsolicited() {
        return this.unsolicited_;
    }

    @Override // fr.sd.taada.proto.CarConnectedDevicesOrBuilder
    public boolean hasFinalList() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.CarConnectedDevicesOrBuilder
    public boolean hasUnsolicited() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(CarConnectedDevices carConnectedDevices) {
        return DEFAULT_INSTANCE.createBuilder(carConnectedDevices);
    }

    public static CarConnectedDevices parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CarConnectedDevices) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CarConnectedDevices parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (CarConnectedDevices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CarConnectedDevices parseFrom(ByteString byteString) {
        return (CarConnectedDevices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConnectedDevices(int i, ConnectedDevice connectedDevice) {
        connectedDevice.getClass();
        ensureConnectedDevicesIsMutable();
        this.connectedDevices_.add(i, connectedDevice);
    }

    public static CarConnectedDevices parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CarConnectedDevices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectedDevices(int i, ConnectedDevice.Builder builder) {
        ensureConnectedDevicesIsMutable();
        this.connectedDevices_.set(i, builder.build());
    }

    public static CarConnectedDevices parseFrom(byte[] bArr) {
        return (CarConnectedDevices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CarConnectedDevices parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (CarConnectedDevices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConnectedDevices(ConnectedDevice.Builder builder) {
        ensureConnectedDevicesIsMutable();
        this.connectedDevices_.add(builder.build());
    }

    public static CarConnectedDevices parseFrom(InputStream inputStream) {
        return (CarConnectedDevices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CarConnectedDevices parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CarConnectedDevices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConnectedDevices(int i, ConnectedDevice.Builder builder) {
        ensureConnectedDevicesIsMutable();
        this.connectedDevices_.add(i, builder.build());
    }

    public static CarConnectedDevices parseFrom(CodedInputStream codedInputStream) {
        return (CarConnectedDevices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CarConnectedDevices parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CarConnectedDevices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
