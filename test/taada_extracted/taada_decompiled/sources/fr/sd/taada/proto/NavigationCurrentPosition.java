package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.NavigationDestinationDistance;
import fr.sd.taada.proto.NavigationRoad;
import fr.sd.taada.proto.NavigationStepDistance;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class NavigationCurrentPosition extends GeneratedMessageLite<NavigationCurrentPosition, Builder> implements NavigationCurrentPositionOrBuilder {
    public static final int CURRENT_ROAD_FIELD_NUMBER = 3;
    private static final NavigationCurrentPosition DEFAULT_INSTANCE;
    public static final int DESTINATION_DISTANCES_FIELD_NUMBER = 2;
    private static volatile Parser<NavigationCurrentPosition> PARSER = null;
    public static final int STEP_DISTANCE_FIELD_NUMBER = 1;
    private int bitField0_;
    private NavigationRoad currentRoad_;
    private Internal.ProtobufList<NavigationDestinationDistance> destinationDistances_ = GeneratedMessageLite.emptyProtobufList();
    private NavigationStepDistance stepDistance_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.NavigationCurrentPosition$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<NavigationCurrentPosition, Builder> implements NavigationCurrentPositionOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllDestinationDistances(Iterable<? extends NavigationDestinationDistance> iterable) {
            copyOnWrite();
            ((NavigationCurrentPosition) this.instance).addAllDestinationDistances(iterable);
            return this;
        }

        public Builder addDestinationDistances(NavigationDestinationDistance navigationDestinationDistance) {
            copyOnWrite();
            ((NavigationCurrentPosition) this.instance).addDestinationDistances(navigationDestinationDistance);
            return this;
        }

        public Builder clearCurrentRoad() {
            copyOnWrite();
            ((NavigationCurrentPosition) this.instance).clearCurrentRoad();
            return this;
        }

        public Builder clearDestinationDistances() {
            copyOnWrite();
            ((NavigationCurrentPosition) this.instance).clearDestinationDistances();
            return this;
        }

        public Builder clearStepDistance() {
            copyOnWrite();
            ((NavigationCurrentPosition) this.instance).clearStepDistance();
            return this;
        }

        @Override // fr.sd.taada.proto.NavigationCurrentPositionOrBuilder
        public NavigationRoad getCurrentRoad() {
            return ((NavigationCurrentPosition) this.instance).getCurrentRoad();
        }

        @Override // fr.sd.taada.proto.NavigationCurrentPositionOrBuilder
        public NavigationDestinationDistance getDestinationDistances(int i) {
            return ((NavigationCurrentPosition) this.instance).getDestinationDistances(i);
        }

        @Override // fr.sd.taada.proto.NavigationCurrentPositionOrBuilder
        public int getDestinationDistancesCount() {
            return ((NavigationCurrentPosition) this.instance).getDestinationDistancesCount();
        }

        @Override // fr.sd.taada.proto.NavigationCurrentPositionOrBuilder
        public List<NavigationDestinationDistance> getDestinationDistancesList() {
            return Collections.unmodifiableList(((NavigationCurrentPosition) this.instance).getDestinationDistancesList());
        }

        @Override // fr.sd.taada.proto.NavigationCurrentPositionOrBuilder
        public NavigationStepDistance getStepDistance() {
            return ((NavigationCurrentPosition) this.instance).getStepDistance();
        }

        @Override // fr.sd.taada.proto.NavigationCurrentPositionOrBuilder
        public boolean hasCurrentRoad() {
            return ((NavigationCurrentPosition) this.instance).hasCurrentRoad();
        }

        @Override // fr.sd.taada.proto.NavigationCurrentPositionOrBuilder
        public boolean hasStepDistance() {
            return ((NavigationCurrentPosition) this.instance).hasStepDistance();
        }

        public Builder mergeCurrentRoad(NavigationRoad navigationRoad) {
            copyOnWrite();
            ((NavigationCurrentPosition) this.instance).mergeCurrentRoad(navigationRoad);
            return this;
        }

        public Builder mergeStepDistance(NavigationStepDistance navigationStepDistance) {
            copyOnWrite();
            ((NavigationCurrentPosition) this.instance).mergeStepDistance(navigationStepDistance);
            return this;
        }

        public Builder removeDestinationDistances(int i) {
            copyOnWrite();
            ((NavigationCurrentPosition) this.instance).removeDestinationDistances(i);
            return this;
        }

        public Builder setCurrentRoad(NavigationRoad navigationRoad) {
            copyOnWrite();
            ((NavigationCurrentPosition) this.instance).setCurrentRoad(navigationRoad);
            return this;
        }

        public Builder setDestinationDistances(int i, NavigationDestinationDistance navigationDestinationDistance) {
            copyOnWrite();
            ((NavigationCurrentPosition) this.instance).setDestinationDistances(i, navigationDestinationDistance);
            return this;
        }

        public Builder setStepDistance(NavigationStepDistance navigationStepDistance) {
            copyOnWrite();
            ((NavigationCurrentPosition) this.instance).setStepDistance(navigationStepDistance);
            return this;
        }

        private Builder() {
            super(NavigationCurrentPosition.DEFAULT_INSTANCE);
        }

        public Builder addDestinationDistances(int i, NavigationDestinationDistance navigationDestinationDistance) {
            copyOnWrite();
            ((NavigationCurrentPosition) this.instance).addDestinationDistances(i, navigationDestinationDistance);
            return this;
        }

        public Builder setCurrentRoad(NavigationRoad.Builder builder) {
            copyOnWrite();
            ((NavigationCurrentPosition) this.instance).setCurrentRoad(builder);
            return this;
        }

        public Builder setDestinationDistances(int i, NavigationDestinationDistance.Builder builder) {
            copyOnWrite();
            ((NavigationCurrentPosition) this.instance).setDestinationDistances(i, builder);
            return this;
        }

        public Builder setStepDistance(NavigationStepDistance.Builder builder) {
            copyOnWrite();
            ((NavigationCurrentPosition) this.instance).setStepDistance(builder);
            return this;
        }

        public Builder addDestinationDistances(NavigationDestinationDistance.Builder builder) {
            copyOnWrite();
            ((NavigationCurrentPosition) this.instance).addDestinationDistances(builder);
            return this;
        }

        public Builder addDestinationDistances(int i, NavigationDestinationDistance.Builder builder) {
            copyOnWrite();
            ((NavigationCurrentPosition) this.instance).addDestinationDistances(i, builder);
            return this;
        }
    }

    static {
        NavigationCurrentPosition navigationCurrentPosition = new NavigationCurrentPosition();
        DEFAULT_INSTANCE = navigationCurrentPosition;
        GeneratedMessageLite.registerDefaultInstance(NavigationCurrentPosition.class, navigationCurrentPosition);
    }

    private NavigationCurrentPosition() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDestinationDistances(Iterable<? extends NavigationDestinationDistance> iterable) {
        ensureDestinationDistancesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.destinationDistances_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDestinationDistances(NavigationDestinationDistance navigationDestinationDistance) {
        navigationDestinationDistance.getClass();
        ensureDestinationDistancesIsMutable();
        this.destinationDistances_.add(navigationDestinationDistance);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCurrentRoad() {
        this.currentRoad_ = null;
        this.bitField0_ &= -3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDestinationDistances() {
        this.destinationDistances_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStepDistance() {
        this.stepDistance_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureDestinationDistancesIsMutable() {
        if (this.destinationDistances_.isModifiable()) {
            return;
        }
        this.destinationDistances_ = GeneratedMessageLite.mutableCopy(this.destinationDistances_);
    }

    public static NavigationCurrentPosition getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCurrentRoad(NavigationRoad navigationRoad) {
        navigationRoad.getClass();
        NavigationRoad navigationRoad2 = this.currentRoad_;
        if (navigationRoad2 == null || navigationRoad2 == NavigationRoad.getDefaultInstance()) {
            this.currentRoad_ = navigationRoad;
        } else {
            this.currentRoad_ = NavigationRoad.newBuilder(this.currentRoad_).mergeFrom(navigationRoad).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStepDistance(NavigationStepDistance navigationStepDistance) {
        navigationStepDistance.getClass();
        NavigationStepDistance navigationStepDistance2 = this.stepDistance_;
        if (navigationStepDistance2 == null || navigationStepDistance2 == NavigationStepDistance.getDefaultInstance()) {
            this.stepDistance_ = navigationStepDistance;
        } else {
            this.stepDistance_ = NavigationStepDistance.newBuilder(this.stepDistance_).mergeFrom(navigationStepDistance).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NavigationCurrentPosition parseDelimitedFrom(InputStream inputStream) {
        return (NavigationCurrentPosition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationCurrentPosition parseFrom(ByteBuffer byteBuffer) {
        return (NavigationCurrentPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NavigationCurrentPosition> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDestinationDistances(int i) {
        ensureDestinationDistancesIsMutable();
        this.destinationDistances_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentRoad(NavigationRoad navigationRoad) {
        navigationRoad.getClass();
        this.currentRoad_ = navigationRoad;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestinationDistances(int i, NavigationDestinationDistance navigationDestinationDistance) {
        navigationDestinationDistance.getClass();
        ensureDestinationDistancesIsMutable();
        this.destinationDistances_.set(i, navigationDestinationDistance);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStepDistance(NavigationStepDistance navigationStepDistance) {
        navigationStepDistance.getClass();
        this.stepDistance_ = navigationStepDistance;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NavigationCurrentPosition();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\t\u0000\u0002\u001b\u0003\t\u0001", new Object[]{"bitField0_", "stepDistance_", "destinationDistances_", NavigationDestinationDistance.class, "currentRoad_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NavigationCurrentPosition> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NavigationCurrentPosition.class) {
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

    @Override // fr.sd.taada.proto.NavigationCurrentPositionOrBuilder
    public NavigationRoad getCurrentRoad() {
        NavigationRoad navigationRoad = this.currentRoad_;
        return navigationRoad == null ? NavigationRoad.getDefaultInstance() : navigationRoad;
    }

    @Override // fr.sd.taada.proto.NavigationCurrentPositionOrBuilder
    public NavigationDestinationDistance getDestinationDistances(int i) {
        return this.destinationDistances_.get(i);
    }

    @Override // fr.sd.taada.proto.NavigationCurrentPositionOrBuilder
    public int getDestinationDistancesCount() {
        return this.destinationDistances_.size();
    }

    @Override // fr.sd.taada.proto.NavigationCurrentPositionOrBuilder
    public List<NavigationDestinationDistance> getDestinationDistancesList() {
        return this.destinationDistances_;
    }

    public NavigationDestinationDistanceOrBuilder getDestinationDistancesOrBuilder(int i) {
        return this.destinationDistances_.get(i);
    }

    public List<? extends NavigationDestinationDistanceOrBuilder> getDestinationDistancesOrBuilderList() {
        return this.destinationDistances_;
    }

    @Override // fr.sd.taada.proto.NavigationCurrentPositionOrBuilder
    public NavigationStepDistance getStepDistance() {
        NavigationStepDistance navigationStepDistance = this.stepDistance_;
        return navigationStepDistance == null ? NavigationStepDistance.getDefaultInstance() : navigationStepDistance;
    }

    @Override // fr.sd.taada.proto.NavigationCurrentPositionOrBuilder
    public boolean hasCurrentRoad() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationCurrentPositionOrBuilder
    public boolean hasStepDistance() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(NavigationCurrentPosition navigationCurrentPosition) {
        return DEFAULT_INSTANCE.createBuilder(navigationCurrentPosition);
    }

    public static NavigationCurrentPosition parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationCurrentPosition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationCurrentPosition parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationCurrentPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NavigationCurrentPosition parseFrom(ByteString byteString) {
        return (NavigationCurrentPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDestinationDistances(int i, NavigationDestinationDistance navigationDestinationDistance) {
        navigationDestinationDistance.getClass();
        ensureDestinationDistancesIsMutable();
        this.destinationDistances_.add(i, navigationDestinationDistance);
    }

    public static NavigationCurrentPosition parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationCurrentPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentRoad(NavigationRoad.Builder builder) {
        this.currentRoad_ = builder.build();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestinationDistances(int i, NavigationDestinationDistance.Builder builder) {
        ensureDestinationDistancesIsMutable();
        this.destinationDistances_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStepDistance(NavigationStepDistance.Builder builder) {
        this.stepDistance_ = builder.build();
        this.bitField0_ |= 1;
    }

    public static NavigationCurrentPosition parseFrom(byte[] bArr) {
        return (NavigationCurrentPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NavigationCurrentPosition parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationCurrentPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDestinationDistances(NavigationDestinationDistance.Builder builder) {
        ensureDestinationDistancesIsMutable();
        this.destinationDistances_.add(builder.build());
    }

    public static NavigationCurrentPosition parseFrom(InputStream inputStream) {
        return (NavigationCurrentPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationCurrentPosition parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationCurrentPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDestinationDistances(int i, NavigationDestinationDistance.Builder builder) {
        ensureDestinationDistancesIsMutable();
        this.destinationDistances_.add(i, builder.build());
    }

    public static NavigationCurrentPosition parseFrom(CodedInputStream codedInputStream) {
        return (NavigationCurrentPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NavigationCurrentPosition parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationCurrentPosition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
