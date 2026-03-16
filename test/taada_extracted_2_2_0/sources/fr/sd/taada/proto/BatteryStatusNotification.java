package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class BatteryStatusNotification extends GeneratedMessageLite<BatteryStatusNotification, Builder> implements BatteryStatusNotificationOrBuilder {
    public static final int BATTERY_LEVEL_FIELD_NUMBER = 1;
    public static final int CRITICAL_BATTERY_FIELD_NUMBER = 3;
    private static final BatteryStatusNotification DEFAULT_INSTANCE;
    private static volatile Parser<BatteryStatusNotification> PARSER = null;
    public static final int TIME_REMAINING_S_FIELD_NUMBER = 2;
    private int batteryLevel_;
    private int bitField0_;
    private boolean criticalBattery_;
    private byte memoizedIsInitialized = 2;
    private int timeRemainingS_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.BatteryStatusNotification$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<BatteryStatusNotification, Builder> implements BatteryStatusNotificationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearBatteryLevel() {
            copyOnWrite();
            ((BatteryStatusNotification) this.instance).clearBatteryLevel();
            return this;
        }

        public Builder clearCriticalBattery() {
            copyOnWrite();
            ((BatteryStatusNotification) this.instance).clearCriticalBattery();
            return this;
        }

        public Builder clearTimeRemainingS() {
            copyOnWrite();
            ((BatteryStatusNotification) this.instance).clearTimeRemainingS();
            return this;
        }

        @Override // fr.sd.taada.proto.BatteryStatusNotificationOrBuilder
        public int getBatteryLevel() {
            return ((BatteryStatusNotification) this.instance).getBatteryLevel();
        }

        @Override // fr.sd.taada.proto.BatteryStatusNotificationOrBuilder
        public boolean getCriticalBattery() {
            return ((BatteryStatusNotification) this.instance).getCriticalBattery();
        }

        @Override // fr.sd.taada.proto.BatteryStatusNotificationOrBuilder
        public int getTimeRemainingS() {
            return ((BatteryStatusNotification) this.instance).getTimeRemainingS();
        }

        @Override // fr.sd.taada.proto.BatteryStatusNotificationOrBuilder
        public boolean hasBatteryLevel() {
            return ((BatteryStatusNotification) this.instance).hasBatteryLevel();
        }

        @Override // fr.sd.taada.proto.BatteryStatusNotificationOrBuilder
        public boolean hasCriticalBattery() {
            return ((BatteryStatusNotification) this.instance).hasCriticalBattery();
        }

        @Override // fr.sd.taada.proto.BatteryStatusNotificationOrBuilder
        public boolean hasTimeRemainingS() {
            return ((BatteryStatusNotification) this.instance).hasTimeRemainingS();
        }

        public Builder setBatteryLevel(int i) {
            copyOnWrite();
            ((BatteryStatusNotification) this.instance).setBatteryLevel(i);
            return this;
        }

        public Builder setCriticalBattery(boolean z6) {
            copyOnWrite();
            ((BatteryStatusNotification) this.instance).setCriticalBattery(z6);
            return this;
        }

        public Builder setTimeRemainingS(int i) {
            copyOnWrite();
            ((BatteryStatusNotification) this.instance).setTimeRemainingS(i);
            return this;
        }

        private Builder() {
            super(BatteryStatusNotification.DEFAULT_INSTANCE);
        }
    }

    static {
        BatteryStatusNotification batteryStatusNotification = new BatteryStatusNotification();
        DEFAULT_INSTANCE = batteryStatusNotification;
        GeneratedMessageLite.registerDefaultInstance(BatteryStatusNotification.class, batteryStatusNotification);
    }

    private BatteryStatusNotification() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBatteryLevel() {
        this.bitField0_ &= -2;
        this.batteryLevel_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCriticalBattery() {
        this.bitField0_ &= -5;
        this.criticalBattery_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimeRemainingS() {
        this.bitField0_ &= -3;
        this.timeRemainingS_ = 0;
    }

    public static BatteryStatusNotification getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static BatteryStatusNotification parseDelimitedFrom(InputStream inputStream) {
        return (BatteryStatusNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BatteryStatusNotification parseFrom(ByteBuffer byteBuffer) {
        return (BatteryStatusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<BatteryStatusNotification> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBatteryLevel(int i) {
        this.bitField0_ |= 1;
        this.batteryLevel_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCriticalBattery(boolean z6) {
        this.bitField0_ |= 4;
        this.criticalBattery_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeRemainingS(int i) {
        this.bitField0_ |= 2;
        this.timeRemainingS_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new BatteryStatusNotification();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ԋ\u0000\u0002\u000b\u0001\u0003\u0007\u0002", new Object[]{"bitField0_", "batteryLevel_", "timeRemainingS_", "criticalBattery_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BatteryStatusNotification> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (BatteryStatusNotification.class) {
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

    @Override // fr.sd.taada.proto.BatteryStatusNotificationOrBuilder
    public int getBatteryLevel() {
        return this.batteryLevel_;
    }

    @Override // fr.sd.taada.proto.BatteryStatusNotificationOrBuilder
    public boolean getCriticalBattery() {
        return this.criticalBattery_;
    }

    @Override // fr.sd.taada.proto.BatteryStatusNotificationOrBuilder
    public int getTimeRemainingS() {
        return this.timeRemainingS_;
    }

    @Override // fr.sd.taada.proto.BatteryStatusNotificationOrBuilder
    public boolean hasBatteryLevel() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.BatteryStatusNotificationOrBuilder
    public boolean hasCriticalBattery() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.BatteryStatusNotificationOrBuilder
    public boolean hasTimeRemainingS() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(BatteryStatusNotification batteryStatusNotification) {
        return DEFAULT_INSTANCE.createBuilder(batteryStatusNotification);
    }

    public static BatteryStatusNotification parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BatteryStatusNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BatteryStatusNotification parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (BatteryStatusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static BatteryStatusNotification parseFrom(ByteString byteString) {
        return (BatteryStatusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static BatteryStatusNotification parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (BatteryStatusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BatteryStatusNotification parseFrom(byte[] bArr) {
        return (BatteryStatusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BatteryStatusNotification parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (BatteryStatusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BatteryStatusNotification parseFrom(InputStream inputStream) {
        return (BatteryStatusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BatteryStatusNotification parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BatteryStatusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BatteryStatusNotification parseFrom(CodedInputStream codedInputStream) {
        return (BatteryStatusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BatteryStatusNotification parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (BatteryStatusNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
