package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class FuelData extends GeneratedMessageLite<FuelData, Builder> implements FuelDataOrBuilder {
    private static final FuelData DEFAULT_INSTANCE;
    public static final int FUEL_LEVEL_FIELD_NUMBER = 1;
    public static final int LOW_FUEL_WARNING_FIELD_NUMBER = 3;
    private static volatile Parser<FuelData> PARSER = null;
    public static final int RANGE_FIELD_NUMBER = 2;
    private int bitField0_;
    private int fuelLevel_;
    private boolean lowFuelWarning_;
    private int range_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.FuelData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<FuelData, Builder> implements FuelDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearFuelLevel() {
            copyOnWrite();
            ((FuelData) this.instance).clearFuelLevel();
            return this;
        }

        public Builder clearLowFuelWarning() {
            copyOnWrite();
            ((FuelData) this.instance).clearLowFuelWarning();
            return this;
        }

        public Builder clearRange() {
            copyOnWrite();
            ((FuelData) this.instance).clearRange();
            return this;
        }

        @Override // fr.sd.taada.proto.FuelDataOrBuilder
        public int getFuelLevel() {
            return ((FuelData) this.instance).getFuelLevel();
        }

        @Override // fr.sd.taada.proto.FuelDataOrBuilder
        public boolean getLowFuelWarning() {
            return ((FuelData) this.instance).getLowFuelWarning();
        }

        @Override // fr.sd.taada.proto.FuelDataOrBuilder
        public int getRange() {
            return ((FuelData) this.instance).getRange();
        }

        @Override // fr.sd.taada.proto.FuelDataOrBuilder
        public boolean hasFuelLevel() {
            return ((FuelData) this.instance).hasFuelLevel();
        }

        @Override // fr.sd.taada.proto.FuelDataOrBuilder
        public boolean hasLowFuelWarning() {
            return ((FuelData) this.instance).hasLowFuelWarning();
        }

        @Override // fr.sd.taada.proto.FuelDataOrBuilder
        public boolean hasRange() {
            return ((FuelData) this.instance).hasRange();
        }

        public Builder setFuelLevel(int i) {
            copyOnWrite();
            ((FuelData) this.instance).setFuelLevel(i);
            return this;
        }

        public Builder setLowFuelWarning(boolean z6) {
            copyOnWrite();
            ((FuelData) this.instance).setLowFuelWarning(z6);
            return this;
        }

        public Builder setRange(int i) {
            copyOnWrite();
            ((FuelData) this.instance).setRange(i);
            return this;
        }

        private Builder() {
            super(FuelData.DEFAULT_INSTANCE);
        }
    }

    static {
        FuelData fuelData = new FuelData();
        DEFAULT_INSTANCE = fuelData;
        GeneratedMessageLite.registerDefaultInstance(FuelData.class, fuelData);
    }

    private FuelData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFuelLevel() {
        this.bitField0_ &= -2;
        this.fuelLevel_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLowFuelWarning() {
        this.bitField0_ &= -5;
        this.lowFuelWarning_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRange() {
        this.bitField0_ &= -3;
        this.range_ = 0;
    }

    public static FuelData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static FuelData parseDelimitedFrom(InputStream inputStream) {
        return (FuelData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FuelData parseFrom(ByteBuffer byteBuffer) {
        return (FuelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<FuelData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFuelLevel(int i) {
        this.bitField0_ |= 1;
        this.fuelLevel_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLowFuelWarning(boolean z6) {
        this.bitField0_ |= 4;
        this.lowFuelWarning_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRange(int i) {
        this.bitField0_ |= 2;
        this.range_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new FuelData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0007\u0002", new Object[]{"bitField0_", "fuelLevel_", "range_", "lowFuelWarning_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<FuelData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (FuelData.class) {
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

    @Override // fr.sd.taada.proto.FuelDataOrBuilder
    public int getFuelLevel() {
        return this.fuelLevel_;
    }

    @Override // fr.sd.taada.proto.FuelDataOrBuilder
    public boolean getLowFuelWarning() {
        return this.lowFuelWarning_;
    }

    @Override // fr.sd.taada.proto.FuelDataOrBuilder
    public int getRange() {
        return this.range_;
    }

    @Override // fr.sd.taada.proto.FuelDataOrBuilder
    public boolean hasFuelLevel() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.FuelDataOrBuilder
    public boolean hasLowFuelWarning() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.FuelDataOrBuilder
    public boolean hasRange() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(FuelData fuelData) {
        return DEFAULT_INSTANCE.createBuilder(fuelData);
    }

    public static FuelData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FuelData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FuelData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (FuelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static FuelData parseFrom(ByteString byteString) {
        return (FuelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static FuelData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (FuelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static FuelData parseFrom(byte[] bArr) {
        return (FuelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FuelData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (FuelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static FuelData parseFrom(InputStream inputStream) {
        return (FuelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FuelData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FuelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FuelData parseFrom(CodedInputStream codedInputStream) {
        return (FuelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static FuelData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (FuelData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
