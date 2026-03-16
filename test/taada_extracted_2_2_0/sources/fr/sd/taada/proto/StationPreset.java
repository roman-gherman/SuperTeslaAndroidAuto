package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class StationPreset extends GeneratedMessageLite<StationPreset, Builder> implements StationPresetOrBuilder {
    public static final int CHANNEL_FIELD_NUMBER = 2;
    private static final StationPreset DEFAULT_INSTANCE;
    private static volatile Parser<StationPreset> PARSER = null;
    public static final int SUB_CHANNEL_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private int channel_;
    private byte memoizedIsInitialized = 2;
    private int subChannel_;
    private int type_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.StationPreset$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<StationPreset, Builder> implements StationPresetOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearChannel() {
            copyOnWrite();
            ((StationPreset) this.instance).clearChannel();
            return this;
        }

        public Builder clearSubChannel() {
            copyOnWrite();
            ((StationPreset) this.instance).clearSubChannel();
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((StationPreset) this.instance).clearType();
            return this;
        }

        @Override // fr.sd.taada.proto.StationPresetOrBuilder
        public int getChannel() {
            return ((StationPreset) this.instance).getChannel();
        }

        @Override // fr.sd.taada.proto.StationPresetOrBuilder
        public int getSubChannel() {
            return ((StationPreset) this.instance).getSubChannel();
        }

        @Override // fr.sd.taada.proto.StationPresetOrBuilder
        public RadioType getType() {
            return ((StationPreset) this.instance).getType();
        }

        @Override // fr.sd.taada.proto.StationPresetOrBuilder
        public boolean hasChannel() {
            return ((StationPreset) this.instance).hasChannel();
        }

        @Override // fr.sd.taada.proto.StationPresetOrBuilder
        public boolean hasSubChannel() {
            return ((StationPreset) this.instance).hasSubChannel();
        }

        @Override // fr.sd.taada.proto.StationPresetOrBuilder
        public boolean hasType() {
            return ((StationPreset) this.instance).hasType();
        }

        public Builder setChannel(int i) {
            copyOnWrite();
            ((StationPreset) this.instance).setChannel(i);
            return this;
        }

        public Builder setSubChannel(int i) {
            copyOnWrite();
            ((StationPreset) this.instance).setSubChannel(i);
            return this;
        }

        public Builder setType(RadioType radioType) {
            copyOnWrite();
            ((StationPreset) this.instance).setType(radioType);
            return this;
        }

        private Builder() {
            super(StationPreset.DEFAULT_INSTANCE);
        }
    }

    static {
        StationPreset stationPreset = new StationPreset();
        DEFAULT_INSTANCE = stationPreset;
        GeneratedMessageLite.registerDefaultInstance(StationPreset.class, stationPreset);
    }

    private StationPreset() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChannel() {
        this.bitField0_ &= -3;
        this.channel_ = 0;
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

    public static StationPreset getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static StationPreset parseDelimitedFrom(InputStream inputStream) {
        return (StationPreset) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StationPreset parseFrom(ByteBuffer byteBuffer) {
        return (StationPreset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<StationPreset> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChannel(int i) {
        this.bitField0_ |= 2;
        this.channel_ = i;
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
                return new StationPreset();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0002\u0001Ԍ\u0000\u0002Ԅ\u0001\u0003\u0004\u0002", new Object[]{"bitField0_", "type_", RadioType.internalGetVerifier(), "channel_", "subChannel_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StationPreset> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (StationPreset.class) {
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

    @Override // fr.sd.taada.proto.StationPresetOrBuilder
    public int getChannel() {
        return this.channel_;
    }

    @Override // fr.sd.taada.proto.StationPresetOrBuilder
    public int getSubChannel() {
        return this.subChannel_;
    }

    @Override // fr.sd.taada.proto.StationPresetOrBuilder
    public RadioType getType() {
        RadioType radioTypeForNumber = RadioType.forNumber(this.type_);
        return radioTypeForNumber == null ? RadioType.AM_RADIO : radioTypeForNumber;
    }

    @Override // fr.sd.taada.proto.StationPresetOrBuilder
    public boolean hasChannel() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.StationPresetOrBuilder
    public boolean hasSubChannel() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.StationPresetOrBuilder
    public boolean hasType() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(StationPreset stationPreset) {
        return DEFAULT_INSTANCE.createBuilder(stationPreset);
    }

    public static StationPreset parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StationPreset) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StationPreset parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (StationPreset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StationPreset parseFrom(ByteString byteString) {
        return (StationPreset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static StationPreset parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (StationPreset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static StationPreset parseFrom(byte[] bArr) {
        return (StationPreset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StationPreset parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (StationPreset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static StationPreset parseFrom(InputStream inputStream) {
        return (StationPreset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StationPreset parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StationPreset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StationPreset parseFrom(CodedInputStream codedInputStream) {
        return (StationPreset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StationPreset parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StationPreset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
