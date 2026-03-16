package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.NavigationCue;
import fr.sd.taada.proto.NavigationLane;
import fr.sd.taada.proto.NavigationManeuver;
import fr.sd.taada.proto.NavigationRoad;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class NavigationStep extends GeneratedMessageLite<NavigationStep, Builder> implements NavigationStepOrBuilder {
    public static final int CUE_FIELD_NUMBER = 4;
    private static final NavigationStep DEFAULT_INSTANCE;
    public static final int LANES_FIELD_NUMBER = 3;
    public static final int MANEUVER_FIELD_NUMBER = 1;
    private static volatile Parser<NavigationStep> PARSER = null;
    public static final int ROAD_FIELD_NUMBER = 2;
    private int bitField0_;
    private NavigationCue cue_;
    private Internal.ProtobufList<NavigationLane> lanes_ = GeneratedMessageLite.emptyProtobufList();
    private NavigationManeuver maneuver_;
    private NavigationRoad road_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.NavigationStep$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<NavigationStep, Builder> implements NavigationStepOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllLanes(Iterable<? extends NavigationLane> iterable) {
            copyOnWrite();
            ((NavigationStep) this.instance).addAllLanes(iterable);
            return this;
        }

        public Builder addLanes(NavigationLane navigationLane) {
            copyOnWrite();
            ((NavigationStep) this.instance).addLanes(navigationLane);
            return this;
        }

        public Builder clearCue() {
            copyOnWrite();
            ((NavigationStep) this.instance).clearCue();
            return this;
        }

        public Builder clearLanes() {
            copyOnWrite();
            ((NavigationStep) this.instance).clearLanes();
            return this;
        }

        public Builder clearManeuver() {
            copyOnWrite();
            ((NavigationStep) this.instance).clearManeuver();
            return this;
        }

        public Builder clearRoad() {
            copyOnWrite();
            ((NavigationStep) this.instance).clearRoad();
            return this;
        }

        @Override // fr.sd.taada.proto.NavigationStepOrBuilder
        public NavigationCue getCue() {
            return ((NavigationStep) this.instance).getCue();
        }

        @Override // fr.sd.taada.proto.NavigationStepOrBuilder
        public NavigationLane getLanes(int i) {
            return ((NavigationStep) this.instance).getLanes(i);
        }

        @Override // fr.sd.taada.proto.NavigationStepOrBuilder
        public int getLanesCount() {
            return ((NavigationStep) this.instance).getLanesCount();
        }

        @Override // fr.sd.taada.proto.NavigationStepOrBuilder
        public List<NavigationLane> getLanesList() {
            return Collections.unmodifiableList(((NavigationStep) this.instance).getLanesList());
        }

        @Override // fr.sd.taada.proto.NavigationStepOrBuilder
        public NavigationManeuver getManeuver() {
            return ((NavigationStep) this.instance).getManeuver();
        }

        @Override // fr.sd.taada.proto.NavigationStepOrBuilder
        public NavigationRoad getRoad() {
            return ((NavigationStep) this.instance).getRoad();
        }

        @Override // fr.sd.taada.proto.NavigationStepOrBuilder
        public boolean hasCue() {
            return ((NavigationStep) this.instance).hasCue();
        }

        @Override // fr.sd.taada.proto.NavigationStepOrBuilder
        public boolean hasManeuver() {
            return ((NavigationStep) this.instance).hasManeuver();
        }

        @Override // fr.sd.taada.proto.NavigationStepOrBuilder
        public boolean hasRoad() {
            return ((NavigationStep) this.instance).hasRoad();
        }

        public Builder mergeCue(NavigationCue navigationCue) {
            copyOnWrite();
            ((NavigationStep) this.instance).mergeCue(navigationCue);
            return this;
        }

        public Builder mergeManeuver(NavigationManeuver navigationManeuver) {
            copyOnWrite();
            ((NavigationStep) this.instance).mergeManeuver(navigationManeuver);
            return this;
        }

        public Builder mergeRoad(NavigationRoad navigationRoad) {
            copyOnWrite();
            ((NavigationStep) this.instance).mergeRoad(navigationRoad);
            return this;
        }

        public Builder removeLanes(int i) {
            copyOnWrite();
            ((NavigationStep) this.instance).removeLanes(i);
            return this;
        }

        public Builder setCue(NavigationCue navigationCue) {
            copyOnWrite();
            ((NavigationStep) this.instance).setCue(navigationCue);
            return this;
        }

        public Builder setLanes(int i, NavigationLane navigationLane) {
            copyOnWrite();
            ((NavigationStep) this.instance).setLanes(i, navigationLane);
            return this;
        }

        public Builder setManeuver(NavigationManeuver navigationManeuver) {
            copyOnWrite();
            ((NavigationStep) this.instance).setManeuver(navigationManeuver);
            return this;
        }

        public Builder setRoad(NavigationRoad navigationRoad) {
            copyOnWrite();
            ((NavigationStep) this.instance).setRoad(navigationRoad);
            return this;
        }

        private Builder() {
            super(NavigationStep.DEFAULT_INSTANCE);
        }

        public Builder addLanes(int i, NavigationLane navigationLane) {
            copyOnWrite();
            ((NavigationStep) this.instance).addLanes(i, navigationLane);
            return this;
        }

        public Builder setCue(NavigationCue.Builder builder) {
            copyOnWrite();
            ((NavigationStep) this.instance).setCue(builder);
            return this;
        }

        public Builder setLanes(int i, NavigationLane.Builder builder) {
            copyOnWrite();
            ((NavigationStep) this.instance).setLanes(i, builder);
            return this;
        }

        public Builder setManeuver(NavigationManeuver.Builder builder) {
            copyOnWrite();
            ((NavigationStep) this.instance).setManeuver(builder);
            return this;
        }

        public Builder setRoad(NavigationRoad.Builder builder) {
            copyOnWrite();
            ((NavigationStep) this.instance).setRoad(builder);
            return this;
        }

        public Builder addLanes(NavigationLane.Builder builder) {
            copyOnWrite();
            ((NavigationStep) this.instance).addLanes(builder);
            return this;
        }

        public Builder addLanes(int i, NavigationLane.Builder builder) {
            copyOnWrite();
            ((NavigationStep) this.instance).addLanes(i, builder);
            return this;
        }
    }

    static {
        NavigationStep navigationStep = new NavigationStep();
        DEFAULT_INSTANCE = navigationStep;
        GeneratedMessageLite.registerDefaultInstance(NavigationStep.class, navigationStep);
    }

    private NavigationStep() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLanes(Iterable<? extends NavigationLane> iterable) {
        ensureLanesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.lanes_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLanes(NavigationLane navigationLane) {
        navigationLane.getClass();
        ensureLanesIsMutable();
        this.lanes_.add(navigationLane);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCue() {
        this.cue_ = null;
        this.bitField0_ &= -5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLanes() {
        this.lanes_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearManeuver() {
        this.maneuver_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoad() {
        this.road_ = null;
        this.bitField0_ &= -3;
    }

    private void ensureLanesIsMutable() {
        if (this.lanes_.isModifiable()) {
            return;
        }
        this.lanes_ = GeneratedMessageLite.mutableCopy(this.lanes_);
    }

    public static NavigationStep getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCue(NavigationCue navigationCue) {
        navigationCue.getClass();
        NavigationCue navigationCue2 = this.cue_;
        if (navigationCue2 == null || navigationCue2 == NavigationCue.getDefaultInstance()) {
            this.cue_ = navigationCue;
        } else {
            this.cue_ = NavigationCue.newBuilder(this.cue_).mergeFrom(navigationCue).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeManeuver(NavigationManeuver navigationManeuver) {
        navigationManeuver.getClass();
        NavigationManeuver navigationManeuver2 = this.maneuver_;
        if (navigationManeuver2 == null || navigationManeuver2 == NavigationManeuver.getDefaultInstance()) {
            this.maneuver_ = navigationManeuver;
        } else {
            this.maneuver_ = NavigationManeuver.newBuilder(this.maneuver_).mergeFrom(navigationManeuver).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRoad(NavigationRoad navigationRoad) {
        navigationRoad.getClass();
        NavigationRoad navigationRoad2 = this.road_;
        if (navigationRoad2 == null || navigationRoad2 == NavigationRoad.getDefaultInstance()) {
            this.road_ = navigationRoad;
        } else {
            this.road_ = NavigationRoad.newBuilder(this.road_).mergeFrom(navigationRoad).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NavigationStep parseDelimitedFrom(InputStream inputStream) {
        return (NavigationStep) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationStep parseFrom(ByteBuffer byteBuffer) {
        return (NavigationStep) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NavigationStep> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLanes(int i) {
        ensureLanesIsMutable();
        this.lanes_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCue(NavigationCue navigationCue) {
        navigationCue.getClass();
        this.cue_ = navigationCue;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLanes(int i, NavigationLane navigationLane) {
        navigationLane.getClass();
        ensureLanesIsMutable();
        this.lanes_.set(i, navigationLane);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setManeuver(NavigationManeuver navigationManeuver) {
        navigationManeuver.getClass();
        this.maneuver_ = navigationManeuver;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoad(NavigationRoad navigationRoad) {
        navigationRoad.getClass();
        this.road_ = navigationRoad;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NavigationStep();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\t\u0000\u0002\t\u0001\u0003\u001b\u0004\t\u0002", new Object[]{"bitField0_", "maneuver_", "road_", "lanes_", NavigationLane.class, "cue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NavigationStep> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NavigationStep.class) {
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

    @Override // fr.sd.taada.proto.NavigationStepOrBuilder
    public NavigationCue getCue() {
        NavigationCue navigationCue = this.cue_;
        return navigationCue == null ? NavigationCue.getDefaultInstance() : navigationCue;
    }

    @Override // fr.sd.taada.proto.NavigationStepOrBuilder
    public NavigationLane getLanes(int i) {
        return this.lanes_.get(i);
    }

    @Override // fr.sd.taada.proto.NavigationStepOrBuilder
    public int getLanesCount() {
        return this.lanes_.size();
    }

    @Override // fr.sd.taada.proto.NavigationStepOrBuilder
    public List<NavigationLane> getLanesList() {
        return this.lanes_;
    }

    public NavigationLaneOrBuilder getLanesOrBuilder(int i) {
        return this.lanes_.get(i);
    }

    public List<? extends NavigationLaneOrBuilder> getLanesOrBuilderList() {
        return this.lanes_;
    }

    @Override // fr.sd.taada.proto.NavigationStepOrBuilder
    public NavigationManeuver getManeuver() {
        NavigationManeuver navigationManeuver = this.maneuver_;
        return navigationManeuver == null ? NavigationManeuver.getDefaultInstance() : navigationManeuver;
    }

    @Override // fr.sd.taada.proto.NavigationStepOrBuilder
    public NavigationRoad getRoad() {
        NavigationRoad navigationRoad = this.road_;
        return navigationRoad == null ? NavigationRoad.getDefaultInstance() : navigationRoad;
    }

    @Override // fr.sd.taada.proto.NavigationStepOrBuilder
    public boolean hasCue() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationStepOrBuilder
    public boolean hasManeuver() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.NavigationStepOrBuilder
    public boolean hasRoad() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(NavigationStep navigationStep) {
        return DEFAULT_INSTANCE.createBuilder(navigationStep);
    }

    public static NavigationStep parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStep) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationStep parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStep) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NavigationStep parseFrom(ByteString byteString) {
        return (NavigationStep) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLanes(int i, NavigationLane navigationLane) {
        navigationLane.getClass();
        ensureLanesIsMutable();
        this.lanes_.add(i, navigationLane);
    }

    public static NavigationStep parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStep) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCue(NavigationCue.Builder builder) {
        this.cue_ = builder.build();
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLanes(int i, NavigationLane.Builder builder) {
        ensureLanesIsMutable();
        this.lanes_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setManeuver(NavigationManeuver.Builder builder) {
        this.maneuver_ = builder.build();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRoad(NavigationRoad.Builder builder) {
        this.road_ = builder.build();
        this.bitField0_ |= 2;
    }

    public static NavigationStep parseFrom(byte[] bArr) {
        return (NavigationStep) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NavigationStep parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStep) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLanes(NavigationLane.Builder builder) {
        ensureLanesIsMutable();
        this.lanes_.add(builder.build());
    }

    public static NavigationStep parseFrom(InputStream inputStream) {
        return (NavigationStep) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationStep parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStep) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLanes(int i, NavigationLane.Builder builder) {
        ensureLanesIsMutable();
        this.lanes_.add(i, builder.build());
    }

    public static NavigationStep parseFrom(CodedInputStream codedInputStream) {
        return (NavigationStep) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NavigationStep parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationStep) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
