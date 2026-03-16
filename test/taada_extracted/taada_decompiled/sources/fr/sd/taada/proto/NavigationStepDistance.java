package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.NavigationDistance;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class NavigationStepDistance extends GeneratedMessageLite<NavigationStepDistance, Builder> implements NavigationStepDistanceOrBuilder {
    private static final NavigationStepDistance DEFAULT_INSTANCE;
    public static final int DISTANCE_FIELD_NUMBER = 1;
    private static volatile Parser<NavigationStepDistance> PARSER = null;
    public static final int TIME_TO_STEP_SECONDS_FIELD_NUMBER = 2;
    private int bitField0_;
    private NavigationDistance distance_;
    private long timeToStepSeconds_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.NavigationStepDistance$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<NavigationStepDistance, Builder> implements NavigationStepDistanceOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDistance() {
            copyOnWrite();
            ((NavigationStepDistance) this.instance).clearDistance();
            return this;
        }

        public Builder clearTimeToStepSeconds() {
            copyOnWrite();
            ((NavigationStepDistance) this.instance).clearTimeToStepSeconds();
            return this;
        }

        @Override // fr.sd.taada.proto.NavigationStepDistanceOrBuilder
        public NavigationDistance getDistance() {
            return ((NavigationStepDistance) this.instance).getDistance();
        }

        @Override // fr.sd.taada.proto.NavigationStepDistanceOrBuilder
        public long getTimeToStepSeconds() {
            return ((NavigationStepDistance) this.instance).getTimeToStepSeconds();
        }

        @Override // fr.sd.taada.proto.NavigationStepDistanceOrBuilder
        public boolean hasDistance() {
            return ((NavigationStepDistance) this.instance).hasDistance();
        }

        @Override // fr.sd.taada.proto.NavigationStepDistanceOrBuilder
        public boolean hasTimeToStepSeconds() {
            return ((NavigationStepDistance) this.instance).hasTimeToStepSeconds();
        }

        public Builder mergeDistance(NavigationDistance navigationDistance) {
            copyOnWrite();
            ((NavigationStepDistance) this.instance).mergeDistance(navigationDistance);
            return this;
        }

        public Builder setDistance(NavigationDistance navigationDistance) {
            copyOnWrite();
            ((NavigationStepDistance) this.instance).setDistance(navigationDistance);
            return this;
        }

        public Builder setTimeToStepSeconds(long j6) {
            copyOnWrite();
            ((NavigationStepDistance) this.instance).setTimeToStepSeconds(j6);
            return this;
        }

        private Builder() {
            super(NavigationStepDistance.DEFAULT_INSTANCE);
        }

        public Builder setDistance(NavigationDistance.Builder builder) {
            copyOnWrite();
            ((NavigationStepDistance) this.instance).setDistance(builder);
            return this;
        }
    }

    static {
        NavigationStepDistance navigationStepDistance = new NavigationStepDistance();
        DEFAULT_INSTANCE = navigationStepDistance;
        GeneratedMessageLite.registerDefaultInstance(NavigationStepDistance.class, navigationStepDistance);
    }

    private NavigationStepDistance() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDistance() {
        this.distance_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimeToStepSeconds() {
        this.bitField0_ &= -3;
        this.timeToStepSeconds_ = 0L;
    }

    public static NavigationStepDistance getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDistance(NavigationDistance navigationDistance) {
        navigationDistance.getClass();
        NavigationDistance navigationDistance2 = this.distance_;
        if (navigationDistance2 == null || navigationDistance2 == NavigationDistance.getDefaultInstance()) {
            this.distance_ = navigationDistance;
        } else {
            this.distance_ = NavigationDistance.newBuilder(this.distance_).mergeFrom(navigationDistance).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NavigationStepDistance parseDelimitedFrom(InputStream inputStream) {
        return (NavigationStepDistance) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationStepDistance parseFrom(ByteBuffer byteBuffer) {
        return (NavigationStepDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NavigationStepDistance> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDistance(NavigationDistance navigationDistance) {
        navigationDistance.getClass();
        this.distance_ = navigationDistance;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeToStepSeconds(long j6) {
        this.bitField0_ |= 2;
        this.timeToStepSeconds_ = j6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NavigationStepDistance();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0000\u0002\u0002\u0001", new Object[]{"bitField0_", "distance_", "timeToStepSeconds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NavigationStepDistance> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NavigationStepDistance.class) {
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

    @Override // fr.sd.taada.proto.NavigationStepDistanceOrBuilder
    public NavigationDistance getDistance() {
        NavigationDistance navigationDistance = this.distance_;
        return navigationDistance == null ? NavigationDistance.getDefaultInstance() : navigationDistance;
    }

    @Override // fr.sd.taada.proto.NavigationStepDistanceOrBuilder
    public long getTimeToStepSeconds() {
        return this.timeToStepSeconds_;
    }

    @Override // fr.sd.taada.proto.NavigationStepDistanceOrBuilder
    public boolean hasDistance() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationStepDistanceOrBuilder
    public boolean hasTimeToStepSeconds() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(NavigationStepDistance navigationStepDistance) {
        return DEFAULT_INSTANCE.createBuilder(navigationStepDistance);
    }

    public static NavigationStepDistance parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStepDistance) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationStepDistance parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStepDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NavigationStepDistance parseFrom(ByteString byteString) {
        return (NavigationStepDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NavigationStepDistance parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStepDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDistance(NavigationDistance.Builder builder) {
        this.distance_ = builder.build();
        this.bitField0_ |= 1;
    }

    public static NavigationStepDistance parseFrom(byte[] bArr) {
        return (NavigationStepDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NavigationStepDistance parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStepDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NavigationStepDistance parseFrom(InputStream inputStream) {
        return (NavigationStepDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationStepDistance parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStepDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationStepDistance parseFrom(CodedInputStream codedInputStream) {
        return (NavigationStepDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NavigationStepDistance parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStepDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
