package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.RadioStationMetaData;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class RadioStationInfo extends GeneratedMessageLite<RadioStationInfo, Builder> implements RadioStationInfoOrBuilder {
    public static final int CHANNEL_FIELD_NUMBER = 2;
    private static final RadioStationInfo DEFAULT_INSTANCE;
    public static final int META_DATA_FIELD_NUMBER = 4;
    private static volatile Parser<RadioStationInfo> PARSER = null;
    public static final int SUB_CHANNEL_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private int channel_;
    private byte memoizedIsInitialized = 2;
    private RadioStationMetaData metaData_;
    private int subChannel_;
    private int type_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.RadioStationInfo$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<RadioStationInfo, Builder> implements RadioStationInfoOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearChannel() {
            copyOnWrite();
            ((RadioStationInfo) this.instance).clearChannel();
            return this;
        }

        public Builder clearMetaData() {
            copyOnWrite();
            ((RadioStationInfo) this.instance).clearMetaData();
            return this;
        }

        public Builder clearSubChannel() {
            copyOnWrite();
            ((RadioStationInfo) this.instance).clearSubChannel();
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((RadioStationInfo) this.instance).clearType();
            return this;
        }

        @Override // fr.sd.taada.proto.RadioStationInfoOrBuilder
        public int getChannel() {
            return ((RadioStationInfo) this.instance).getChannel();
        }

        @Override // fr.sd.taada.proto.RadioStationInfoOrBuilder
        public RadioStationMetaData getMetaData() {
            return ((RadioStationInfo) this.instance).getMetaData();
        }

        @Override // fr.sd.taada.proto.RadioStationInfoOrBuilder
        public int getSubChannel() {
            return ((RadioStationInfo) this.instance).getSubChannel();
        }

        @Override // fr.sd.taada.proto.RadioStationInfoOrBuilder
        public RadioType getType() {
            return ((RadioStationInfo) this.instance).getType();
        }

        @Override // fr.sd.taada.proto.RadioStationInfoOrBuilder
        public boolean hasChannel() {
            return ((RadioStationInfo) this.instance).hasChannel();
        }

        @Override // fr.sd.taada.proto.RadioStationInfoOrBuilder
        public boolean hasMetaData() {
            return ((RadioStationInfo) this.instance).hasMetaData();
        }

        @Override // fr.sd.taada.proto.RadioStationInfoOrBuilder
        public boolean hasSubChannel() {
            return ((RadioStationInfo) this.instance).hasSubChannel();
        }

        @Override // fr.sd.taada.proto.RadioStationInfoOrBuilder
        public boolean hasType() {
            return ((RadioStationInfo) this.instance).hasType();
        }

        public Builder mergeMetaData(RadioStationMetaData radioStationMetaData) {
            copyOnWrite();
            ((RadioStationInfo) this.instance).mergeMetaData(radioStationMetaData);
            return this;
        }

        public Builder setChannel(int i) {
            copyOnWrite();
            ((RadioStationInfo) this.instance).setChannel(i);
            return this;
        }

        public Builder setMetaData(RadioStationMetaData radioStationMetaData) {
            copyOnWrite();
            ((RadioStationInfo) this.instance).setMetaData(radioStationMetaData);
            return this;
        }

        public Builder setSubChannel(int i) {
            copyOnWrite();
            ((RadioStationInfo) this.instance).setSubChannel(i);
            return this;
        }

        public Builder setType(RadioType radioType) {
            copyOnWrite();
            ((RadioStationInfo) this.instance).setType(radioType);
            return this;
        }

        private Builder() {
            super(RadioStationInfo.DEFAULT_INSTANCE);
        }

        public Builder setMetaData(RadioStationMetaData.Builder builder) {
            copyOnWrite();
            ((RadioStationInfo) this.instance).setMetaData(builder);
            return this;
        }
    }

    static {
        RadioStationInfo radioStationInfo = new RadioStationInfo();
        DEFAULT_INSTANCE = radioStationInfo;
        GeneratedMessageLite.registerDefaultInstance(RadioStationInfo.class, radioStationInfo);
    }

    private RadioStationInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChannel() {
        this.bitField0_ &= -3;
        this.channel_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetaData() {
        this.metaData_ = null;
        this.bitField0_ &= -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubChannel() {
        this.bitField0_ &= -5;
        this.subChannel_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.bitField0_ &= -2;
        this.type_ = 0;
    }

    public static RadioStationInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMetaData(RadioStationMetaData radioStationMetaData) {
        radioStationMetaData.getClass();
        RadioStationMetaData radioStationMetaData2 = this.metaData_;
        if (radioStationMetaData2 == null || radioStationMetaData2 == RadioStationMetaData.getDefaultInstance()) {
            this.metaData_ = radioStationMetaData;
        } else {
            this.metaData_ = RadioStationMetaData.newBuilder(this.metaData_).mergeFrom(radioStationMetaData).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static RadioStationInfo parseDelimitedFrom(InputStream inputStream) {
        return (RadioStationInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RadioStationInfo parseFrom(ByteBuffer byteBuffer) {
        return (RadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<RadioStationInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChannel(int i) {
        this.bitField0_ |= 2;
        this.channel_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetaData(RadioStationMetaData radioStationMetaData) {
        radioStationMetaData.getClass();
        this.metaData_ = radioStationMetaData;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubChannel(int i) {
        this.bitField0_ |= 4;
        this.subChannel_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(RadioType radioType) {
        radioType.getClass();
        this.bitField0_ |= 1;
        this.type_ = radioType.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RadioStationInfo();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0003\u0001Ԍ\u0000\u0002Ԅ\u0001\u0003\u0004\u0002\u0004Љ\u0003", new Object[]{"bitField0_", "type_", RadioType.internalGetVerifier(), "channel_", "subChannel_", "metaData_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RadioStationInfo> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (RadioStationInfo.class) {
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

    @Override // fr.sd.taada.proto.RadioStationInfoOrBuilder
    public int getChannel() {
        return this.channel_;
    }

    @Override // fr.sd.taada.proto.RadioStationInfoOrBuilder
    public RadioStationMetaData getMetaData() {
        RadioStationMetaData radioStationMetaData = this.metaData_;
        return radioStationMetaData == null ? RadioStationMetaData.getDefaultInstance() : radioStationMetaData;
    }

    @Override // fr.sd.taada.proto.RadioStationInfoOrBuilder
    public int getSubChannel() {
        return this.subChannel_;
    }

    @Override // fr.sd.taada.proto.RadioStationInfoOrBuilder
    public RadioType getType() {
        RadioType radioTypeForNumber = RadioType.forNumber(this.type_);
        return radioTypeForNumber == null ? RadioType.AM_RADIO : radioTypeForNumber;
    }

    @Override // fr.sd.taada.proto.RadioStationInfoOrBuilder
    public boolean hasChannel() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.RadioStationInfoOrBuilder
    public boolean hasMetaData() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.RadioStationInfoOrBuilder
    public boolean hasSubChannel() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.RadioStationInfoOrBuilder
    public boolean hasType() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(RadioStationInfo radioStationInfo) {
        return DEFAULT_INSTANCE.createBuilder(radioStationInfo);
    }

    public static RadioStationInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStationInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RadioStationInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RadioStationInfo parseFrom(ByteString byteString) {
        return (RadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RadioStationInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetaData(RadioStationMetaData.Builder builder) {
        this.metaData_ = builder.build();
        this.bitField0_ |= 8;
    }

    public static RadioStationInfo parseFrom(byte[] bArr) {
        return (RadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RadioStationInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RadioStationInfo parseFrom(InputStream inputStream) {
        return (RadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RadioStationInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RadioStationInfo parseFrom(CodedInputStream codedInputStream) {
        return (RadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RadioStationInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
