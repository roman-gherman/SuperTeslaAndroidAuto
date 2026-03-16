package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class CompassData extends GeneratedMessageLite<CompassData, Builder> implements CompassDataOrBuilder {
    public static final int BEARING_E6_FIELD_NUMBER = 1;
    private static final CompassData DEFAULT_INSTANCE;
    private static volatile Parser<CompassData> PARSER = null;
    public static final int PITCH_E6_FIELD_NUMBER = 2;
    public static final int ROLL_E6_FIELD_NUMBER = 3;
    private int bearingE6_;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int pitchE6_;
    private int rollE6_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.CompassData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<CompassData, Builder> implements CompassDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearBearingE6() {
            copyOnWrite();
            ((CompassData) this.instance).clearBearingE6();
            return this;
        }

        public Builder clearPitchE6() {
            copyOnWrite();
            ((CompassData) this.instance).clearPitchE6();
            return this;
        }

        public Builder clearRollE6() {
            copyOnWrite();
            ((CompassData) this.instance).clearRollE6();
            return this;
        }

        @Override // fr.sd.taada.proto.CompassDataOrBuilder
        public int getBearingE6() {
            return ((CompassData) this.instance).getBearingE6();
        }

        @Override // fr.sd.taada.proto.CompassDataOrBuilder
        public int getPitchE6() {
            return ((CompassData) this.instance).getPitchE6();
        }

        @Override // fr.sd.taada.proto.CompassDataOrBuilder
        public int getRollE6() {
            return ((CompassData) this.instance).getRollE6();
        }

        @Override // fr.sd.taada.proto.CompassDataOrBuilder
        public boolean hasBearingE6() {
            return ((CompassData) this.instance).hasBearingE6();
        }

        @Override // fr.sd.taada.proto.CompassDataOrBuilder
        public boolean hasPitchE6() {
            return ((CompassData) this.instance).hasPitchE6();
        }

        @Override // fr.sd.taada.proto.CompassDataOrBuilder
        public boolean hasRollE6() {
            return ((CompassData) this.instance).hasRollE6();
        }

        public Builder setBearingE6(int i) {
            copyOnWrite();
            ((CompassData) this.instance).setBearingE6(i);
            return this;
        }

        public Builder setPitchE6(int i) {
            copyOnWrite();
            ((CompassData) this.instance).setPitchE6(i);
            return this;
        }

        public Builder setRollE6(int i) {
            copyOnWrite();
            ((CompassData) this.instance).setRollE6(i);
            return this;
        }

        private Builder() {
            super(CompassData.DEFAULT_INSTANCE);
        }
    }

    static {
        CompassData compassData = new CompassData();
        DEFAULT_INSTANCE = compassData;
        GeneratedMessageLite.registerDefaultInstance(CompassData.class, compassData);
    }

    private CompassData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBearingE6() {
        this.bitField0_ &= -2;
        this.bearingE6_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPitchE6() {
        this.bitField0_ &= -3;
        this.pitchE6_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRollE6() {
        this.bitField0_ &= -5;
        this.rollE6_ = 0;
    }

    public static CompassData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static CompassData parseDelimitedFrom(InputStream inputStream) {
        return (CompassData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CompassData parseFrom(ByteBuffer byteBuffer) {
        return (CompassData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CompassData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBearingE6(int i) {
        this.bitField0_ |= 1;
        this.bearingE6_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPitchE6(int i) {
        this.bitField0_ |= 2;
        this.pitchE6_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRollE6(int i) {
        this.bitField0_ |= 4;
        this.rollE6_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new CompassData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001Ԅ\u0000\u0002\u0004\u0001\u0003\u0004\u0002", new Object[]{"bitField0_", "bearingE6_", "pitchE6_", "rollE6_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CompassData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (CompassData.class) {
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

    @Override // fr.sd.taada.proto.CompassDataOrBuilder
    public int getBearingE6() {
        return this.bearingE6_;
    }

    @Override // fr.sd.taada.proto.CompassDataOrBuilder
    public int getPitchE6() {
        return this.pitchE6_;
    }

    @Override // fr.sd.taada.proto.CompassDataOrBuilder
    public int getRollE6() {
        return this.rollE6_;
    }

    @Override // fr.sd.taada.proto.CompassDataOrBuilder
    public boolean hasBearingE6() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.CompassDataOrBuilder
    public boolean hasPitchE6() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.CompassDataOrBuilder
    public boolean hasRollE6() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(CompassData compassData) {
        return DEFAULT_INSTANCE.createBuilder(compassData);
    }

    public static CompassData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CompassData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CompassData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (CompassData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CompassData parseFrom(ByteString byteString) {
        return (CompassData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static CompassData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CompassData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CompassData parseFrom(byte[] bArr) {
        return (CompassData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CompassData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (CompassData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CompassData parseFrom(InputStream inputStream) {
        return (CompassData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CompassData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CompassData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CompassData parseFrom(CodedInputStream codedInputStream) {
        return (CompassData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CompassData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CompassData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
