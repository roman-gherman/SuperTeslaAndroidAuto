package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.RadioStationInfo;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class RadioStationInfoNotification extends GeneratedMessageLite<RadioStationInfoNotification, Builder> implements RadioStationInfoNotificationOrBuilder {
    private static final RadioStationInfoNotification DEFAULT_INSTANCE;
    private static volatile Parser<RadioStationInfoNotification> PARSER = null;
    public static final int RADIO_ID_FIELD_NUMBER = 1;
    public static final int STATION_INFO_FIELD_NUMBER = 2;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int radioId_;
    private RadioStationInfo stationInfo_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.RadioStationInfoNotification$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<RadioStationInfoNotification, Builder> implements RadioStationInfoNotificationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearRadioId() {
            copyOnWrite();
            ((RadioStationInfoNotification) this.instance).clearRadioId();
            return this;
        }

        public Builder clearStationInfo() {
            copyOnWrite();
            ((RadioStationInfoNotification) this.instance).clearStationInfo();
            return this;
        }

        @Override // fr.sd.taada.proto.RadioStationInfoNotificationOrBuilder
        public int getRadioId() {
            return ((RadioStationInfoNotification) this.instance).getRadioId();
        }

        @Override // fr.sd.taada.proto.RadioStationInfoNotificationOrBuilder
        public RadioStationInfo getStationInfo() {
            return ((RadioStationInfoNotification) this.instance).getStationInfo();
        }

        @Override // fr.sd.taada.proto.RadioStationInfoNotificationOrBuilder
        public boolean hasRadioId() {
            return ((RadioStationInfoNotification) this.instance).hasRadioId();
        }

        @Override // fr.sd.taada.proto.RadioStationInfoNotificationOrBuilder
        public boolean hasStationInfo() {
            return ((RadioStationInfoNotification) this.instance).hasStationInfo();
        }

        public Builder mergeStationInfo(RadioStationInfo radioStationInfo) {
            copyOnWrite();
            ((RadioStationInfoNotification) this.instance).mergeStationInfo(radioStationInfo);
            return this;
        }

        public Builder setRadioId(int i) {
            copyOnWrite();
            ((RadioStationInfoNotification) this.instance).setRadioId(i);
            return this;
        }

        public Builder setStationInfo(RadioStationInfo radioStationInfo) {
            copyOnWrite();
            ((RadioStationInfoNotification) this.instance).setStationInfo(radioStationInfo);
            return this;
        }

        private Builder() {
            super(RadioStationInfoNotification.DEFAULT_INSTANCE);
        }

        public Builder setStationInfo(RadioStationInfo.Builder builder) {
            copyOnWrite();
            ((RadioStationInfoNotification) this.instance).setStationInfo(builder);
            return this;
        }
    }

    static {
        RadioStationInfoNotification radioStationInfoNotification = new RadioStationInfoNotification();
        DEFAULT_INSTANCE = radioStationInfoNotification;
        GeneratedMessageLite.registerDefaultInstance(RadioStationInfoNotification.class, radioStationInfoNotification);
    }

    private RadioStationInfoNotification() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioId() {
        this.bitField0_ &= -2;
        this.radioId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStationInfo() {
        this.stationInfo_ = null;
        this.bitField0_ &= -3;
    }

    public static RadioStationInfoNotification getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStationInfo(RadioStationInfo radioStationInfo) {
        radioStationInfo.getClass();
        RadioStationInfo radioStationInfo2 = this.stationInfo_;
        if (radioStationInfo2 == null || radioStationInfo2 == RadioStationInfo.getDefaultInstance()) {
            this.stationInfo_ = radioStationInfo;
        } else {
            this.stationInfo_ = RadioStationInfo.newBuilder(this.stationInfo_).mergeFrom(radioStationInfo).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static RadioStationInfoNotification parseDelimitedFrom(InputStream inputStream) {
        return (RadioStationInfoNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RadioStationInfoNotification parseFrom(ByteBuffer byteBuffer) {
        return (RadioStationInfoNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<RadioStationInfoNotification> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioId(int i) {
        this.bitField0_ |= 1;
        this.radioId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStationInfo(RadioStationInfo radioStationInfo) {
        radioStationInfo.getClass();
        this.stationInfo_ = radioStationInfo;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RadioStationInfoNotification();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԅ\u0000\u0002ԉ\u0001", new Object[]{"bitField0_", "radioId_", "stationInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RadioStationInfoNotification> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (RadioStationInfoNotification.class) {
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

    @Override // fr.sd.taada.proto.RadioStationInfoNotificationOrBuilder
    public int getRadioId() {
        return this.radioId_;
    }

    @Override // fr.sd.taada.proto.RadioStationInfoNotificationOrBuilder
    public RadioStationInfo getStationInfo() {
        RadioStationInfo radioStationInfo = this.stationInfo_;
        return radioStationInfo == null ? RadioStationInfo.getDefaultInstance() : radioStationInfo;
    }

    @Override // fr.sd.taada.proto.RadioStationInfoNotificationOrBuilder
    public boolean hasRadioId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.RadioStationInfoNotificationOrBuilder
    public boolean hasStationInfo() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(RadioStationInfoNotification radioStationInfoNotification) {
        return DEFAULT_INSTANCE.createBuilder(radioStationInfoNotification);
    }

    public static RadioStationInfoNotification parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStationInfoNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RadioStationInfoNotification parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStationInfoNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RadioStationInfoNotification parseFrom(ByteString byteString) {
        return (RadioStationInfoNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RadioStationInfoNotification parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStationInfoNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStationInfo(RadioStationInfo.Builder builder) {
        this.stationInfo_ = builder.build();
        this.bitField0_ |= 2;
    }

    public static RadioStationInfoNotification parseFrom(byte[] bArr) {
        return (RadioStationInfoNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RadioStationInfoNotification parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStationInfoNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RadioStationInfoNotification parseFrom(InputStream inputStream) {
        return (RadioStationInfoNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RadioStationInfoNotification parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStationInfoNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RadioStationInfoNotification parseFrom(CodedInputStream codedInputStream) {
        return (RadioStationInfoNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RadioStationInfoNotification parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStationInfoNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
