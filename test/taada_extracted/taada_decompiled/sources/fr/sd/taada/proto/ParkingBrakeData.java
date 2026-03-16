package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class ParkingBrakeData extends GeneratedMessageLite<ParkingBrakeData, Builder> implements ParkingBrakeDataOrBuilder {
    private static final ParkingBrakeData DEFAULT_INSTANCE;
    public static final int PARKING_BRAKE_FIELD_NUMBER = 1;
    private static volatile Parser<ParkingBrakeData> PARSER;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private boolean parkingBrake_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.ParkingBrakeData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ParkingBrakeData, Builder> implements ParkingBrakeDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearParkingBrake() {
            copyOnWrite();
            ((ParkingBrakeData) this.instance).clearParkingBrake();
            return this;
        }

        @Override // fr.sd.taada.proto.ParkingBrakeDataOrBuilder
        public boolean getParkingBrake() {
            return ((ParkingBrakeData) this.instance).getParkingBrake();
        }

        @Override // fr.sd.taada.proto.ParkingBrakeDataOrBuilder
        public boolean hasParkingBrake() {
            return ((ParkingBrakeData) this.instance).hasParkingBrake();
        }

        public Builder setParkingBrake(boolean z6) {
            copyOnWrite();
            ((ParkingBrakeData) this.instance).setParkingBrake(z6);
            return this;
        }

        private Builder() {
            super(ParkingBrakeData.DEFAULT_INSTANCE);
        }
    }

    static {
        ParkingBrakeData parkingBrakeData = new ParkingBrakeData();
        DEFAULT_INSTANCE = parkingBrakeData;
        GeneratedMessageLite.registerDefaultInstance(ParkingBrakeData.class, parkingBrakeData);
    }

    private ParkingBrakeData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParkingBrake() {
        this.bitField0_ &= -2;
        this.parkingBrake_ = false;
    }

    public static ParkingBrakeData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ParkingBrakeData parseDelimitedFrom(InputStream inputStream) {
        return (ParkingBrakeData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ParkingBrakeData parseFrom(ByteBuffer byteBuffer) {
        return (ParkingBrakeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ParkingBrakeData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParkingBrake(boolean z6) {
        this.bitField0_ |= 1;
        this.parkingBrake_ = z6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ParkingBrakeData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001ԇ\u0000", new Object[]{"bitField0_", "parkingBrake_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ParkingBrakeData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ParkingBrakeData.class) {
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

    @Override // fr.sd.taada.proto.ParkingBrakeDataOrBuilder
    public boolean getParkingBrake() {
        return this.parkingBrake_;
    }

    @Override // fr.sd.taada.proto.ParkingBrakeDataOrBuilder
    public boolean hasParkingBrake() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(ParkingBrakeData parkingBrakeData) {
        return DEFAULT_INSTANCE.createBuilder(parkingBrakeData);
    }

    public static ParkingBrakeData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ParkingBrakeData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ParkingBrakeData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ParkingBrakeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ParkingBrakeData parseFrom(ByteString byteString) {
        return (ParkingBrakeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ParkingBrakeData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ParkingBrakeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ParkingBrakeData parseFrom(byte[] bArr) {
        return (ParkingBrakeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ParkingBrakeData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ParkingBrakeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ParkingBrakeData parseFrom(InputStream inputStream) {
        return (ParkingBrakeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ParkingBrakeData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ParkingBrakeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ParkingBrakeData parseFrom(CodedInputStream codedInputStream) {
        return (ParkingBrakeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ParkingBrakeData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ParkingBrakeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
