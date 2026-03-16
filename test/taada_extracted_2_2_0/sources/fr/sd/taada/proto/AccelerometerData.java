package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class AccelerometerData extends GeneratedMessageLite<AccelerometerData, Builder> implements AccelerometerDataOrBuilder {
    public static final int ACCELERATION_X_E3_FIELD_NUMBER = 1;
    public static final int ACCELERATION_Y_E3_FIELD_NUMBER = 2;
    public static final int ACCELERATION_Z_E3_FIELD_NUMBER = 3;
    private static final AccelerometerData DEFAULT_INSTANCE;
    private static volatile Parser<AccelerometerData> PARSER;
    private int accelerationXE3_;
    private int accelerationYE3_;
    private int accelerationZE3_;
    private int bitField0_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.AccelerometerData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<AccelerometerData, Builder> implements AccelerometerDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAccelerationXE3() {
            copyOnWrite();
            ((AccelerometerData) this.instance).clearAccelerationXE3();
            return this;
        }

        public Builder clearAccelerationYE3() {
            copyOnWrite();
            ((AccelerometerData) this.instance).clearAccelerationYE3();
            return this;
        }

        public Builder clearAccelerationZE3() {
            copyOnWrite();
            ((AccelerometerData) this.instance).clearAccelerationZE3();
            return this;
        }

        @Override // fr.sd.taada.proto.AccelerometerDataOrBuilder
        public int getAccelerationXE3() {
            return ((AccelerometerData) this.instance).getAccelerationXE3();
        }

        @Override // fr.sd.taada.proto.AccelerometerDataOrBuilder
        public int getAccelerationYE3() {
            return ((AccelerometerData) this.instance).getAccelerationYE3();
        }

        @Override // fr.sd.taada.proto.AccelerometerDataOrBuilder
        public int getAccelerationZE3() {
            return ((AccelerometerData) this.instance).getAccelerationZE3();
        }

        @Override // fr.sd.taada.proto.AccelerometerDataOrBuilder
        public boolean hasAccelerationXE3() {
            return ((AccelerometerData) this.instance).hasAccelerationXE3();
        }

        @Override // fr.sd.taada.proto.AccelerometerDataOrBuilder
        public boolean hasAccelerationYE3() {
            return ((AccelerometerData) this.instance).hasAccelerationYE3();
        }

        @Override // fr.sd.taada.proto.AccelerometerDataOrBuilder
        public boolean hasAccelerationZE3() {
            return ((AccelerometerData) this.instance).hasAccelerationZE3();
        }

        public Builder setAccelerationXE3(int i) {
            copyOnWrite();
            ((AccelerometerData) this.instance).setAccelerationXE3(i);
            return this;
        }

        public Builder setAccelerationYE3(int i) {
            copyOnWrite();
            ((AccelerometerData) this.instance).setAccelerationYE3(i);
            return this;
        }

        public Builder setAccelerationZE3(int i) {
            copyOnWrite();
            ((AccelerometerData) this.instance).setAccelerationZE3(i);
            return this;
        }

        private Builder() {
            super(AccelerometerData.DEFAULT_INSTANCE);
        }
    }

    static {
        AccelerometerData accelerometerData = new AccelerometerData();
        DEFAULT_INSTANCE = accelerometerData;
        GeneratedMessageLite.registerDefaultInstance(AccelerometerData.class, accelerometerData);
    }

    private AccelerometerData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAccelerationXE3() {
        this.bitField0_ &= -2;
        this.accelerationXE3_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAccelerationYE3() {
        this.bitField0_ &= -3;
        this.accelerationYE3_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAccelerationZE3() {
        this.bitField0_ &= -5;
        this.accelerationZE3_ = 0;
    }

    public static AccelerometerData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static AccelerometerData parseDelimitedFrom(InputStream inputStream) {
        return (AccelerometerData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AccelerometerData parseFrom(ByteBuffer byteBuffer) {
        return (AccelerometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AccelerometerData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccelerationXE3(int i) {
        this.bitField0_ |= 1;
        this.accelerationXE3_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccelerationYE3(int i) {
        this.bitField0_ |= 2;
        this.accelerationYE3_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccelerationZE3(int i) {
        this.bitField0_ |= 4;
        this.accelerationZE3_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new AccelerometerData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002", new Object[]{"bitField0_", "accelerationXE3_", "accelerationYE3_", "accelerationZE3_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AccelerometerData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AccelerometerData.class) {
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

    @Override // fr.sd.taada.proto.AccelerometerDataOrBuilder
    public int getAccelerationXE3() {
        return this.accelerationXE3_;
    }

    @Override // fr.sd.taada.proto.AccelerometerDataOrBuilder
    public int getAccelerationYE3() {
        return this.accelerationYE3_;
    }

    @Override // fr.sd.taada.proto.AccelerometerDataOrBuilder
    public int getAccelerationZE3() {
        return this.accelerationZE3_;
    }

    @Override // fr.sd.taada.proto.AccelerometerDataOrBuilder
    public boolean hasAccelerationXE3() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.AccelerometerDataOrBuilder
    public boolean hasAccelerationYE3() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.AccelerometerDataOrBuilder
    public boolean hasAccelerationZE3() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(AccelerometerData accelerometerData) {
        return DEFAULT_INSTANCE.createBuilder(accelerometerData);
    }

    public static AccelerometerData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AccelerometerData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AccelerometerData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (AccelerometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AccelerometerData parseFrom(ByteString byteString) {
        return (AccelerometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AccelerometerData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AccelerometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AccelerometerData parseFrom(byte[] bArr) {
        return (AccelerometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AccelerometerData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (AccelerometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AccelerometerData parseFrom(InputStream inputStream) {
        return (AccelerometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AccelerometerData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AccelerometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AccelerometerData parseFrom(CodedInputStream codedInputStream) {
        return (AccelerometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AccelerometerData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AccelerometerData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
