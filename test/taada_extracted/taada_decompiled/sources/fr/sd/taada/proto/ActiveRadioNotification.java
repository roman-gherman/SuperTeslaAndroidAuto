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
public final class ActiveRadioNotification extends GeneratedMessageLite<ActiveRadioNotification, Builder> implements ActiveRadioNotificationOrBuilder {
    private static final ActiveRadioNotification DEFAULT_INSTANCE;
    private static volatile Parser<ActiveRadioNotification> PARSER = null;
    public static final int RADIO_ID_FIELD_NUMBER = 2;
    public static final int STATION_INFO_FIELD_NUMBER = 3;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int bitField0_;
    private int radioId_;
    private RadioStationInfo stationInfo_;
    private byte memoizedIsInitialized = 2;
    private int status_ = 1;

    /* JADX INFO: renamed from: fr.sd.taada.proto.ActiveRadioNotification$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<ActiveRadioNotification, Builder> implements ActiveRadioNotificationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearRadioId() {
            copyOnWrite();
            ((ActiveRadioNotification) this.instance).clearRadioId();
            return this;
        }

        public Builder clearStationInfo() {
            copyOnWrite();
            ((ActiveRadioNotification) this.instance).clearStationInfo();
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((ActiveRadioNotification) this.instance).clearStatus();
            return this;
        }

        @Override // fr.sd.taada.proto.ActiveRadioNotificationOrBuilder
        public int getRadioId() {
            return ((ActiveRadioNotification) this.instance).getRadioId();
        }

        @Override // fr.sd.taada.proto.ActiveRadioNotificationOrBuilder
        public RadioStationInfo getStationInfo() {
            return ((ActiveRadioNotification) this.instance).getStationInfo();
        }

        @Override // fr.sd.taada.proto.ActiveRadioNotificationOrBuilder
        public MessageStatus getStatus() {
            return ((ActiveRadioNotification) this.instance).getStatus();
        }

        @Override // fr.sd.taada.proto.ActiveRadioNotificationOrBuilder
        public boolean hasRadioId() {
            return ((ActiveRadioNotification) this.instance).hasRadioId();
        }

        @Override // fr.sd.taada.proto.ActiveRadioNotificationOrBuilder
        public boolean hasStationInfo() {
            return ((ActiveRadioNotification) this.instance).hasStationInfo();
        }

        @Override // fr.sd.taada.proto.ActiveRadioNotificationOrBuilder
        public boolean hasStatus() {
            return ((ActiveRadioNotification) this.instance).hasStatus();
        }

        public Builder mergeStationInfo(RadioStationInfo radioStationInfo) {
            copyOnWrite();
            ((ActiveRadioNotification) this.instance).mergeStationInfo(radioStationInfo);
            return this;
        }

        public Builder setRadioId(int i) {
            copyOnWrite();
            ((ActiveRadioNotification) this.instance).setRadioId(i);
            return this;
        }

        public Builder setStationInfo(RadioStationInfo radioStationInfo) {
            copyOnWrite();
            ((ActiveRadioNotification) this.instance).setStationInfo(radioStationInfo);
            return this;
        }

        public Builder setStatus(MessageStatus messageStatus) {
            copyOnWrite();
            ((ActiveRadioNotification) this.instance).setStatus(messageStatus);
            return this;
        }

        private Builder() {
            super(ActiveRadioNotification.DEFAULT_INSTANCE);
        }

        public Builder setStationInfo(RadioStationInfo.Builder builder) {
            copyOnWrite();
            ((ActiveRadioNotification) this.instance).setStationInfo(builder);
            return this;
        }
    }

    static {
        ActiveRadioNotification activeRadioNotification = new ActiveRadioNotification();
        DEFAULT_INSTANCE = activeRadioNotification;
        GeneratedMessageLite.registerDefaultInstance(ActiveRadioNotification.class, activeRadioNotification);
    }

    private ActiveRadioNotification() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioId() {
        this.bitField0_ &= -3;
        this.radioId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStationInfo() {
        this.stationInfo_ = null;
        this.bitField0_ &= -5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.bitField0_ &= -2;
        this.status_ = 1;
    }

    public static ActiveRadioNotification getDefaultInstance() {
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
        this.bitField0_ |= 4;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ActiveRadioNotification parseDelimitedFrom(InputStream inputStream) {
        return (ActiveRadioNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ActiveRadioNotification parseFrom(ByteBuffer byteBuffer) {
        return (ActiveRadioNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ActiveRadioNotification> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioId(int i) {
        this.bitField0_ |= 2;
        this.radioId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStationInfo(RadioStationInfo radioStationInfo) {
        radioStationInfo.getClass();
        this.stationInfo_ = radioStationInfo;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(MessageStatus messageStatus) {
        messageStatus.getClass();
        this.bitField0_ |= 1;
        this.status_ = messageStatus.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ActiveRadioNotification();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0002\u0001\f\u0000\u0002Ԅ\u0001\u0003Љ\u0002", new Object[]{"bitField0_", "status_", MessageStatus.internalGetVerifier(), "radioId_", "stationInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ActiveRadioNotification> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ActiveRadioNotification.class) {
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

    @Override // fr.sd.taada.proto.ActiveRadioNotificationOrBuilder
    public int getRadioId() {
        return this.radioId_;
    }

    @Override // fr.sd.taada.proto.ActiveRadioNotificationOrBuilder
    public RadioStationInfo getStationInfo() {
        RadioStationInfo radioStationInfo = this.stationInfo_;
        return radioStationInfo == null ? RadioStationInfo.getDefaultInstance() : radioStationInfo;
    }

    @Override // fr.sd.taada.proto.ActiveRadioNotificationOrBuilder
    public MessageStatus getStatus() {
        MessageStatus messageStatusForNumber = MessageStatus.forNumber(this.status_);
        return messageStatusForNumber == null ? MessageStatus.STATUS_UNSOLICITED_MESSAGE : messageStatusForNumber;
    }

    @Override // fr.sd.taada.proto.ActiveRadioNotificationOrBuilder
    public boolean hasRadioId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.ActiveRadioNotificationOrBuilder
    public boolean hasStationInfo() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.ActiveRadioNotificationOrBuilder
    public boolean hasStatus() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(ActiveRadioNotification activeRadioNotification) {
        return DEFAULT_INSTANCE.createBuilder(activeRadioNotification);
    }

    public static ActiveRadioNotification parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ActiveRadioNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ActiveRadioNotification parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ActiveRadioNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ActiveRadioNotification parseFrom(ByteString byteString) {
        return (ActiveRadioNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ActiveRadioNotification parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ActiveRadioNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStationInfo(RadioStationInfo.Builder builder) {
        this.stationInfo_ = builder.build();
        this.bitField0_ |= 4;
    }

    public static ActiveRadioNotification parseFrom(byte[] bArr) {
        return (ActiveRadioNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ActiveRadioNotification parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ActiveRadioNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ActiveRadioNotification parseFrom(InputStream inputStream) {
        return (ActiveRadioNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ActiveRadioNotification parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ActiveRadioNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ActiveRadioNotification parseFrom(CodedInputStream codedInputStream) {
        return (ActiveRadioNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ActiveRadioNotification parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ActiveRadioNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
