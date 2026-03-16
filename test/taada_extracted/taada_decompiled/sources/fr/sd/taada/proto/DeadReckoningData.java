package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class DeadReckoningData extends GeneratedMessageLite<DeadReckoningData, Builder> implements DeadReckoningDataOrBuilder {
    private static final DeadReckoningData DEFAULT_INSTANCE;
    private static volatile Parser<DeadReckoningData> PARSER = null;
    public static final int STEERING_ANGLE_E1_FIELD_NUMBER = 1;
    public static final int WHEEL_SPEED_E3_FIELD_NUMBER = 2;
    private int bitField0_;
    private int steeringAngleE1_;
    private Internal.IntList wheelSpeedE3_ = GeneratedMessageLite.emptyIntList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.DeadReckoningData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<DeadReckoningData, Builder> implements DeadReckoningDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllWheelSpeedE3(Iterable<? extends Integer> iterable) {
            copyOnWrite();
            ((DeadReckoningData) this.instance).addAllWheelSpeedE3(iterable);
            return this;
        }

        public Builder addWheelSpeedE3(int i) {
            copyOnWrite();
            ((DeadReckoningData) this.instance).addWheelSpeedE3(i);
            return this;
        }

        public Builder clearSteeringAngleE1() {
            copyOnWrite();
            ((DeadReckoningData) this.instance).clearSteeringAngleE1();
            return this;
        }

        public Builder clearWheelSpeedE3() {
            copyOnWrite();
            ((DeadReckoningData) this.instance).clearWheelSpeedE3();
            return this;
        }

        @Override // fr.sd.taada.proto.DeadReckoningDataOrBuilder
        public int getSteeringAngleE1() {
            return ((DeadReckoningData) this.instance).getSteeringAngleE1();
        }

        @Override // fr.sd.taada.proto.DeadReckoningDataOrBuilder
        public int getWheelSpeedE3(int i) {
            return ((DeadReckoningData) this.instance).getWheelSpeedE3(i);
        }

        @Override // fr.sd.taada.proto.DeadReckoningDataOrBuilder
        public int getWheelSpeedE3Count() {
            return ((DeadReckoningData) this.instance).getWheelSpeedE3Count();
        }

        @Override // fr.sd.taada.proto.DeadReckoningDataOrBuilder
        public List<Integer> getWheelSpeedE3List() {
            return Collections.unmodifiableList(((DeadReckoningData) this.instance).getWheelSpeedE3List());
        }

        @Override // fr.sd.taada.proto.DeadReckoningDataOrBuilder
        public boolean hasSteeringAngleE1() {
            return ((DeadReckoningData) this.instance).hasSteeringAngleE1();
        }

        public Builder setSteeringAngleE1(int i) {
            copyOnWrite();
            ((DeadReckoningData) this.instance).setSteeringAngleE1(i);
            return this;
        }

        public Builder setWheelSpeedE3(int i, int i3) {
            copyOnWrite();
            ((DeadReckoningData) this.instance).setWheelSpeedE3(i, i3);
            return this;
        }

        private Builder() {
            super(DeadReckoningData.DEFAULT_INSTANCE);
        }
    }

    static {
        DeadReckoningData deadReckoningData = new DeadReckoningData();
        DEFAULT_INSTANCE = deadReckoningData;
        GeneratedMessageLite.registerDefaultInstance(DeadReckoningData.class, deadReckoningData);
    }

    private DeadReckoningData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllWheelSpeedE3(Iterable<? extends Integer> iterable) {
        ensureWheelSpeedE3IsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.wheelSpeedE3_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWheelSpeedE3(int i) {
        ensureWheelSpeedE3IsMutable();
        this.wheelSpeedE3_.addInt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSteeringAngleE1() {
        this.bitField0_ &= -2;
        this.steeringAngleE1_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWheelSpeedE3() {
        this.wheelSpeedE3_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureWheelSpeedE3IsMutable() {
        if (this.wheelSpeedE3_.isModifiable()) {
            return;
        }
        this.wheelSpeedE3_ = GeneratedMessageLite.mutableCopy(this.wheelSpeedE3_);
    }

    public static DeadReckoningData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static DeadReckoningData parseDelimitedFrom(InputStream inputStream) {
        return (DeadReckoningData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DeadReckoningData parseFrom(ByteBuffer byteBuffer) {
        return (DeadReckoningData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<DeadReckoningData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSteeringAngleE1(int i) {
        this.bitField0_ |= 1;
        this.steeringAngleE1_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWheelSpeedE3(int i, int i3) {
        ensureWheelSpeedE3IsMutable();
        this.wheelSpeedE3_.setInt(i, i3);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new DeadReckoningData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0000\u0002\u0016", new Object[]{"bitField0_", "steeringAngleE1_", "wheelSpeedE3_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DeadReckoningData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (DeadReckoningData.class) {
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

    @Override // fr.sd.taada.proto.DeadReckoningDataOrBuilder
    public int getSteeringAngleE1() {
        return this.steeringAngleE1_;
    }

    @Override // fr.sd.taada.proto.DeadReckoningDataOrBuilder
    public int getWheelSpeedE3(int i) {
        return this.wheelSpeedE3_.getInt(i);
    }

    @Override // fr.sd.taada.proto.DeadReckoningDataOrBuilder
    public int getWheelSpeedE3Count() {
        return this.wheelSpeedE3_.size();
    }

    @Override // fr.sd.taada.proto.DeadReckoningDataOrBuilder
    public List<Integer> getWheelSpeedE3List() {
        return this.wheelSpeedE3_;
    }

    @Override // fr.sd.taada.proto.DeadReckoningDataOrBuilder
    public boolean hasSteeringAngleE1() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(DeadReckoningData deadReckoningData) {
        return DEFAULT_INSTANCE.createBuilder(deadReckoningData);
    }

    public static DeadReckoningData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DeadReckoningData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DeadReckoningData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DeadReckoningData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DeadReckoningData parseFrom(ByteString byteString) {
        return (DeadReckoningData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static DeadReckoningData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DeadReckoningData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DeadReckoningData parseFrom(byte[] bArr) {
        return (DeadReckoningData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DeadReckoningData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (DeadReckoningData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DeadReckoningData parseFrom(InputStream inputStream) {
        return (DeadReckoningData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DeadReckoningData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DeadReckoningData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DeadReckoningData parseFrom(CodedInputStream codedInputStream) {
        return (DeadReckoningData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DeadReckoningData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DeadReckoningData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
