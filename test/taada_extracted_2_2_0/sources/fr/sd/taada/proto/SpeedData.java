package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class SpeedData extends GeneratedMessageLite<SpeedData, Builder> implements SpeedDataOrBuilder {
    public static final int CRUISE_ENGAGED_FIELD_NUMBER = 2;
    public static final int CRUISE_SET_SPEED_FIELD_NUMBER = 4;
    private static final SpeedData DEFAULT_INSTANCE;
    private static volatile Parser<SpeedData> PARSER = null;
    public static final int SPEED_E3_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean cruiseEngaged_;
    private int cruiseSetSpeed_;
    private byte memoizedIsInitialized = 2;
    private int speedE3_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.SpeedData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<SpeedData, Builder> implements SpeedDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCruiseEngaged() {
            copyOnWrite();
            ((SpeedData) this.instance).clearCruiseEngaged();
            return this;
        }

        public Builder clearCruiseSetSpeed() {
            copyOnWrite();
            ((SpeedData) this.instance).clearCruiseSetSpeed();
            return this;
        }

        public Builder clearSpeedE3() {
            copyOnWrite();
            ((SpeedData) this.instance).clearSpeedE3();
            return this;
        }

        @Override // fr.sd.taada.proto.SpeedDataOrBuilder
        public boolean getCruiseEngaged() {
            return ((SpeedData) this.instance).getCruiseEngaged();
        }

        @Override // fr.sd.taada.proto.SpeedDataOrBuilder
        public int getCruiseSetSpeed() {
            return ((SpeedData) this.instance).getCruiseSetSpeed();
        }

        @Override // fr.sd.taada.proto.SpeedDataOrBuilder
        public int getSpeedE3() {
            return ((SpeedData) this.instance).getSpeedE3();
        }

        @Override // fr.sd.taada.proto.SpeedDataOrBuilder
        public boolean hasCruiseEngaged() {
            return ((SpeedData) this.instance).hasCruiseEngaged();
        }

        @Override // fr.sd.taada.proto.SpeedDataOrBuilder
        public boolean hasCruiseSetSpeed() {
            return ((SpeedData) this.instance).hasCruiseSetSpeed();
        }

        @Override // fr.sd.taada.proto.SpeedDataOrBuilder
        public boolean hasSpeedE3() {
            return ((SpeedData) this.instance).hasSpeedE3();
        }

        public Builder setCruiseEngaged(boolean z6) {
            copyOnWrite();
            ((SpeedData) this.instance).setCruiseEngaged(z6);
            return this;
        }

        public Builder setCruiseSetSpeed(int i) {
            copyOnWrite();
            ((SpeedData) this.instance).setCruiseSetSpeed(i);
            return this;
        }

        public Builder setSpeedE3(int i) {
            copyOnWrite();
            ((SpeedData) this.instance).setSpeedE3(i);
            return this;
        }

        private Builder() {
            super(SpeedData.DEFAULT_INSTANCE);
        }
    }

    static {
        SpeedData speedData = new SpeedData();
        DEFAULT_INSTANCE = speedData;
        GeneratedMessageLite.registerDefaultInstance(SpeedData.class, speedData);
    }

    private SpeedData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCruiseEngaged() {
        this.bitField0_ &= -3;
        this.cruiseEngaged_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCruiseSetSpeed() {
        this.bitField0_ &= -5;
        this.cruiseSetSpeed_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSpeedE3() {
        this.bitField0_ &= -2;
        this.speedE3_ = 0;
    }

    public static SpeedData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SpeedData parseDelimitedFrom(InputStream inputStream) {
        return (SpeedData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SpeedData parseFrom(ByteBuffer byteBuffer) {
        return (SpeedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SpeedData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCruiseEngaged(boolean z6) {
        this.bitField0_ |= 2;
        this.cruiseEngaged_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCruiseSetSpeed(int i) {
        this.bitField0_ |= 4;
        this.cruiseSetSpeed_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpeedE3(int i) {
        this.bitField0_ |= 1;
        this.speedE3_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new SpeedData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0001\u0001Ԅ\u0000\u0002\u0007\u0001\u0004\u0004\u0002", new Object[]{"bitField0_", "speedE3_", "cruiseEngaged_", "cruiseSetSpeed_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SpeedData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SpeedData.class) {
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

    @Override // fr.sd.taada.proto.SpeedDataOrBuilder
    public boolean getCruiseEngaged() {
        return this.cruiseEngaged_;
    }

    @Override // fr.sd.taada.proto.SpeedDataOrBuilder
    public int getCruiseSetSpeed() {
        return this.cruiseSetSpeed_;
    }

    @Override // fr.sd.taada.proto.SpeedDataOrBuilder
    public int getSpeedE3() {
        return this.speedE3_;
    }

    @Override // fr.sd.taada.proto.SpeedDataOrBuilder
    public boolean hasCruiseEngaged() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.SpeedDataOrBuilder
    public boolean hasCruiseSetSpeed() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.SpeedDataOrBuilder
    public boolean hasSpeedE3() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(SpeedData speedData) {
        return DEFAULT_INSTANCE.createBuilder(speedData);
    }

    public static SpeedData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SpeedData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SpeedData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (SpeedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SpeedData parseFrom(ByteString byteString) {
        return (SpeedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SpeedData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SpeedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SpeedData parseFrom(byte[] bArr) {
        return (SpeedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SpeedData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (SpeedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SpeedData parseFrom(InputStream inputStream) {
        return (SpeedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SpeedData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SpeedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SpeedData parseFrom(CodedInputStream codedInputStream) {
        return (SpeedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SpeedData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SpeedData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
