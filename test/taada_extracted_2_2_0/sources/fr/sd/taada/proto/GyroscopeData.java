package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class GyroscopeData extends GeneratedMessageLite<GyroscopeData, Builder> implements GyroscopeDataOrBuilder {
    private static final GyroscopeData DEFAULT_INSTANCE;
    private static volatile Parser<GyroscopeData> PARSER = null;
    public static final int ROTATION_SPEED_X_E3_FIELD_NUMBER = 1;
    public static final int ROTATION_SPEED_Y_E3_FIELD_NUMBER = 2;
    public static final int ROTATION_SPEED_Z_E3_FIELD_NUMBER = 3;
    private int bitField0_;
    private int rotationSpeedXE3_;
    private int rotationSpeedYE3_;
    private int rotationSpeedZE3_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.GyroscopeData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GyroscopeData, Builder> implements GyroscopeDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearRotationSpeedXE3() {
            copyOnWrite();
            ((GyroscopeData) this.instance).clearRotationSpeedXE3();
            return this;
        }

        public Builder clearRotationSpeedYE3() {
            copyOnWrite();
            ((GyroscopeData) this.instance).clearRotationSpeedYE3();
            return this;
        }

        public Builder clearRotationSpeedZE3() {
            copyOnWrite();
            ((GyroscopeData) this.instance).clearRotationSpeedZE3();
            return this;
        }

        @Override // fr.sd.taada.proto.GyroscopeDataOrBuilder
        public int getRotationSpeedXE3() {
            return ((GyroscopeData) this.instance).getRotationSpeedXE3();
        }

        @Override // fr.sd.taada.proto.GyroscopeDataOrBuilder
        public int getRotationSpeedYE3() {
            return ((GyroscopeData) this.instance).getRotationSpeedYE3();
        }

        @Override // fr.sd.taada.proto.GyroscopeDataOrBuilder
        public int getRotationSpeedZE3() {
            return ((GyroscopeData) this.instance).getRotationSpeedZE3();
        }

        @Override // fr.sd.taada.proto.GyroscopeDataOrBuilder
        public boolean hasRotationSpeedXE3() {
            return ((GyroscopeData) this.instance).hasRotationSpeedXE3();
        }

        @Override // fr.sd.taada.proto.GyroscopeDataOrBuilder
        public boolean hasRotationSpeedYE3() {
            return ((GyroscopeData) this.instance).hasRotationSpeedYE3();
        }

        @Override // fr.sd.taada.proto.GyroscopeDataOrBuilder
        public boolean hasRotationSpeedZE3() {
            return ((GyroscopeData) this.instance).hasRotationSpeedZE3();
        }

        public Builder setRotationSpeedXE3(int i) {
            copyOnWrite();
            ((GyroscopeData) this.instance).setRotationSpeedXE3(i);
            return this;
        }

        public Builder setRotationSpeedYE3(int i) {
            copyOnWrite();
            ((GyroscopeData) this.instance).setRotationSpeedYE3(i);
            return this;
        }

        public Builder setRotationSpeedZE3(int i) {
            copyOnWrite();
            ((GyroscopeData) this.instance).setRotationSpeedZE3(i);
            return this;
        }

        private Builder() {
            super(GyroscopeData.DEFAULT_INSTANCE);
        }
    }

    static {
        GyroscopeData gyroscopeData = new GyroscopeData();
        DEFAULT_INSTANCE = gyroscopeData;
        GeneratedMessageLite.registerDefaultInstance(GyroscopeData.class, gyroscopeData);
    }

    private GyroscopeData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRotationSpeedXE3() {
        this.bitField0_ &= -2;
        this.rotationSpeedXE3_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRotationSpeedYE3() {
        this.bitField0_ &= -3;
        this.rotationSpeedYE3_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRotationSpeedZE3() {
        this.bitField0_ &= -5;
        this.rotationSpeedZE3_ = 0;
    }

    public static GyroscopeData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GyroscopeData parseDelimitedFrom(InputStream inputStream) {
        return (GyroscopeData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GyroscopeData parseFrom(ByteBuffer byteBuffer) {
        return (GyroscopeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GyroscopeData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRotationSpeedXE3(int i) {
        this.bitField0_ |= 1;
        this.rotationSpeedXE3_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRotationSpeedYE3(int i) {
        this.bitField0_ |= 2;
        this.rotationSpeedYE3_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRotationSpeedZE3(int i) {
        this.bitField0_ |= 4;
        this.rotationSpeedZE3_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GyroscopeData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002", new Object[]{"bitField0_", "rotationSpeedXE3_", "rotationSpeedYE3_", "rotationSpeedZE3_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GyroscopeData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GyroscopeData.class) {
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

    @Override // fr.sd.taada.proto.GyroscopeDataOrBuilder
    public int getRotationSpeedXE3() {
        return this.rotationSpeedXE3_;
    }

    @Override // fr.sd.taada.proto.GyroscopeDataOrBuilder
    public int getRotationSpeedYE3() {
        return this.rotationSpeedYE3_;
    }

    @Override // fr.sd.taada.proto.GyroscopeDataOrBuilder
    public int getRotationSpeedZE3() {
        return this.rotationSpeedZE3_;
    }

    @Override // fr.sd.taada.proto.GyroscopeDataOrBuilder
    public boolean hasRotationSpeedXE3() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.GyroscopeDataOrBuilder
    public boolean hasRotationSpeedYE3() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.GyroscopeDataOrBuilder
    public boolean hasRotationSpeedZE3() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(GyroscopeData gyroscopeData) {
        return DEFAULT_INSTANCE.createBuilder(gyroscopeData);
    }

    public static GyroscopeData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GyroscopeData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GyroscopeData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GyroscopeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GyroscopeData parseFrom(ByteString byteString) {
        return (GyroscopeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GyroscopeData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GyroscopeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GyroscopeData parseFrom(byte[] bArr) {
        return (GyroscopeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GyroscopeData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GyroscopeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GyroscopeData parseFrom(InputStream inputStream) {
        return (GyroscopeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GyroscopeData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GyroscopeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GyroscopeData parseFrom(CodedInputStream codedInputStream) {
        return (GyroscopeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GyroscopeData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GyroscopeData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
