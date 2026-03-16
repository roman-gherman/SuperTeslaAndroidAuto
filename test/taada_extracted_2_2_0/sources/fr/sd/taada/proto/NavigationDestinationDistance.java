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
public final class NavigationDestinationDistance extends GeneratedMessageLite<NavigationDestinationDistance, Builder> implements NavigationDestinationDistanceOrBuilder {
    private static final NavigationDestinationDistance DEFAULT_INSTANCE;
    public static final int DISTANCE_FIELD_NUMBER = 1;
    public static final int ESTIMATED_TIME_AT_ARRIVAL_FIELD_NUMBER = 2;
    private static volatile Parser<NavigationDestinationDistance> PARSER = null;
    public static final int TIME_TO_ARRIVAL_SECONDS_FIELD_NUMBER = 3;
    private int bitField0_;
    private NavigationDistance distance_;
    private String estimatedTimeAtArrival_ = "";
    private long timeToArrivalSeconds_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.NavigationDestinationDistance$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<NavigationDestinationDistance, Builder> implements NavigationDestinationDistanceOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDistance() {
            copyOnWrite();
            ((NavigationDestinationDistance) this.instance).clearDistance();
            return this;
        }

        public Builder clearEstimatedTimeAtArrival() {
            copyOnWrite();
            ((NavigationDestinationDistance) this.instance).clearEstimatedTimeAtArrival();
            return this;
        }

        public Builder clearTimeToArrivalSeconds() {
            copyOnWrite();
            ((NavigationDestinationDistance) this.instance).clearTimeToArrivalSeconds();
            return this;
        }

        @Override // fr.sd.taada.proto.NavigationDestinationDistanceOrBuilder
        public NavigationDistance getDistance() {
            return ((NavigationDestinationDistance) this.instance).getDistance();
        }

        @Override // fr.sd.taada.proto.NavigationDestinationDistanceOrBuilder
        public String getEstimatedTimeAtArrival() {
            return ((NavigationDestinationDistance) this.instance).getEstimatedTimeAtArrival();
        }

        @Override // fr.sd.taada.proto.NavigationDestinationDistanceOrBuilder
        public ByteString getEstimatedTimeAtArrivalBytes() {
            return ((NavigationDestinationDistance) this.instance).getEstimatedTimeAtArrivalBytes();
        }

        @Override // fr.sd.taada.proto.NavigationDestinationDistanceOrBuilder
        public long getTimeToArrivalSeconds() {
            return ((NavigationDestinationDistance) this.instance).getTimeToArrivalSeconds();
        }

        @Override // fr.sd.taada.proto.NavigationDestinationDistanceOrBuilder
        public boolean hasDistance() {
            return ((NavigationDestinationDistance) this.instance).hasDistance();
        }

        @Override // fr.sd.taada.proto.NavigationDestinationDistanceOrBuilder
        public boolean hasEstimatedTimeAtArrival() {
            return ((NavigationDestinationDistance) this.instance).hasEstimatedTimeAtArrival();
        }

        @Override // fr.sd.taada.proto.NavigationDestinationDistanceOrBuilder
        public boolean hasTimeToArrivalSeconds() {
            return ((NavigationDestinationDistance) this.instance).hasTimeToArrivalSeconds();
        }

        public Builder mergeDistance(NavigationDistance navigationDistance) {
            copyOnWrite();
            ((NavigationDestinationDistance) this.instance).mergeDistance(navigationDistance);
            return this;
        }

        public Builder setDistance(NavigationDistance navigationDistance) {
            copyOnWrite();
            ((NavigationDestinationDistance) this.instance).setDistance(navigationDistance);
            return this;
        }

        public Builder setEstimatedTimeAtArrival(String str) {
            copyOnWrite();
            ((NavigationDestinationDistance) this.instance).setEstimatedTimeAtArrival(str);
            return this;
        }

        public Builder setEstimatedTimeAtArrivalBytes(ByteString byteString) {
            copyOnWrite();
            ((NavigationDestinationDistance) this.instance).setEstimatedTimeAtArrivalBytes(byteString);
            return this;
        }

        public Builder setTimeToArrivalSeconds(long j6) {
            copyOnWrite();
            ((NavigationDestinationDistance) this.instance).setTimeToArrivalSeconds(j6);
            return this;
        }

        private Builder() {
            super(NavigationDestinationDistance.DEFAULT_INSTANCE);
        }

        public Builder setDistance(NavigationDistance.Builder builder) {
            copyOnWrite();
            ((NavigationDestinationDistance) this.instance).setDistance(builder);
            return this;
        }
    }

    static {
        NavigationDestinationDistance navigationDestinationDistance = new NavigationDestinationDistance();
        DEFAULT_INSTANCE = navigationDestinationDistance;
        GeneratedMessageLite.registerDefaultInstance(NavigationDestinationDistance.class, navigationDestinationDistance);
    }

    private NavigationDestinationDistance() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDistance() {
        this.distance_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEstimatedTimeAtArrival() {
        this.bitField0_ &= -3;
        this.estimatedTimeAtArrival_ = getDefaultInstance().getEstimatedTimeAtArrival();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTimeToArrivalSeconds() {
        this.bitField0_ &= -5;
        this.timeToArrivalSeconds_ = 0L;
    }

    public static NavigationDestinationDistance getDefaultInstance() {
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

    public static NavigationDestinationDistance parseDelimitedFrom(InputStream inputStream) {
        return (NavigationDestinationDistance) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationDestinationDistance parseFrom(ByteBuffer byteBuffer) {
        return (NavigationDestinationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NavigationDestinationDistance> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDistance(NavigationDistance navigationDistance) {
        navigationDistance.getClass();
        this.distance_ = navigationDistance;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEstimatedTimeAtArrival(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.estimatedTimeAtArrival_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEstimatedTimeAtArrivalBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2;
        this.estimatedTimeAtArrival_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeToArrivalSeconds(long j6) {
        this.bitField0_ |= 4;
        this.timeToArrivalSeconds_ = j6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NavigationDestinationDistance();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\b\u0001\u0003\u0002\u0002", new Object[]{"bitField0_", "distance_", "estimatedTimeAtArrival_", "timeToArrivalSeconds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NavigationDestinationDistance> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NavigationDestinationDistance.class) {
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

    @Override // fr.sd.taada.proto.NavigationDestinationDistanceOrBuilder
    public NavigationDistance getDistance() {
        NavigationDistance navigationDistance = this.distance_;
        return navigationDistance == null ? NavigationDistance.getDefaultInstance() : navigationDistance;
    }

    @Override // fr.sd.taada.proto.NavigationDestinationDistanceOrBuilder
    public String getEstimatedTimeAtArrival() {
        return this.estimatedTimeAtArrival_;
    }

    @Override // fr.sd.taada.proto.NavigationDestinationDistanceOrBuilder
    public ByteString getEstimatedTimeAtArrivalBytes() {
        return ByteString.copyFromUtf8(this.estimatedTimeAtArrival_);
    }

    @Override // fr.sd.taada.proto.NavigationDestinationDistanceOrBuilder
    public long getTimeToArrivalSeconds() {
        return this.timeToArrivalSeconds_;
    }

    @Override // fr.sd.taada.proto.NavigationDestinationDistanceOrBuilder
    public boolean hasDistance() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationDestinationDistanceOrBuilder
    public boolean hasEstimatedTimeAtArrival() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationDestinationDistanceOrBuilder
    public boolean hasTimeToArrivalSeconds() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(NavigationDestinationDistance navigationDestinationDistance) {
        return DEFAULT_INSTANCE.createBuilder(navigationDestinationDistance);
    }

    public static NavigationDestinationDistance parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationDestinationDistance) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationDestinationDistance parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationDestinationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NavigationDestinationDistance parseFrom(ByteString byteString) {
        return (NavigationDestinationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NavigationDestinationDistance parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationDestinationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDistance(NavigationDistance.Builder builder) {
        this.distance_ = builder.build();
        this.bitField0_ |= 1;
    }

    public static NavigationDestinationDistance parseFrom(byte[] bArr) {
        return (NavigationDestinationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NavigationDestinationDistance parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationDestinationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NavigationDestinationDistance parseFrom(InputStream inputStream) {
        return (NavigationDestinationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationDestinationDistance parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationDestinationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationDestinationDistance parseFrom(CodedInputStream codedInputStream) {
        return (NavigationDestinationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NavigationDestinationDistance parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationDestinationDistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
