package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.NavigationDestination;
import fr.sd.taada.proto.NavigationStep;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class NavigationState extends GeneratedMessageLite<NavigationState, Builder> implements NavigationStateOrBuilder {
    private static final NavigationState DEFAULT_INSTANCE;
    public static final int DESTINATIONS_FIELD_NUMBER = 2;
    private static volatile Parser<NavigationState> PARSER = null;
    public static final int STEPS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<NavigationStep> steps_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<NavigationDestination> destinations_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.NavigationState$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<NavigationState, Builder> implements NavigationStateOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllDestinations(Iterable<? extends NavigationDestination> iterable) {
            copyOnWrite();
            ((NavigationState) this.instance).addAllDestinations(iterable);
            return this;
        }

        public Builder addAllSteps(Iterable<? extends NavigationStep> iterable) {
            copyOnWrite();
            ((NavigationState) this.instance).addAllSteps(iterable);
            return this;
        }

        public Builder addDestinations(NavigationDestination navigationDestination) {
            copyOnWrite();
            ((NavigationState) this.instance).addDestinations(navigationDestination);
            return this;
        }

        public Builder addSteps(NavigationStep navigationStep) {
            copyOnWrite();
            ((NavigationState) this.instance).addSteps(navigationStep);
            return this;
        }

        public Builder clearDestinations() {
            copyOnWrite();
            ((NavigationState) this.instance).clearDestinations();
            return this;
        }

        public Builder clearSteps() {
            copyOnWrite();
            ((NavigationState) this.instance).clearSteps();
            return this;
        }

        @Override // fr.sd.taada.proto.NavigationStateOrBuilder
        public NavigationDestination getDestinations(int i) {
            return ((NavigationState) this.instance).getDestinations(i);
        }

        @Override // fr.sd.taada.proto.NavigationStateOrBuilder
        public int getDestinationsCount() {
            return ((NavigationState) this.instance).getDestinationsCount();
        }

        @Override // fr.sd.taada.proto.NavigationStateOrBuilder
        public List<NavigationDestination> getDestinationsList() {
            return Collections.unmodifiableList(((NavigationState) this.instance).getDestinationsList());
        }

        @Override // fr.sd.taada.proto.NavigationStateOrBuilder
        public NavigationStep getSteps(int i) {
            return ((NavigationState) this.instance).getSteps(i);
        }

        @Override // fr.sd.taada.proto.NavigationStateOrBuilder
        public int getStepsCount() {
            return ((NavigationState) this.instance).getStepsCount();
        }

        @Override // fr.sd.taada.proto.NavigationStateOrBuilder
        public List<NavigationStep> getStepsList() {
            return Collections.unmodifiableList(((NavigationState) this.instance).getStepsList());
        }

        public Builder removeDestinations(int i) {
            copyOnWrite();
            ((NavigationState) this.instance).removeDestinations(i);
            return this;
        }

        public Builder removeSteps(int i) {
            copyOnWrite();
            ((NavigationState) this.instance).removeSteps(i);
            return this;
        }

        public Builder setDestinations(int i, NavigationDestination navigationDestination) {
            copyOnWrite();
            ((NavigationState) this.instance).setDestinations(i, navigationDestination);
            return this;
        }

        public Builder setSteps(int i, NavigationStep navigationStep) {
            copyOnWrite();
            ((NavigationState) this.instance).setSteps(i, navigationStep);
            return this;
        }

        private Builder() {
            super(NavigationState.DEFAULT_INSTANCE);
        }

        public Builder addDestinations(int i, NavigationDestination navigationDestination) {
            copyOnWrite();
            ((NavigationState) this.instance).addDestinations(i, navigationDestination);
            return this;
        }

        public Builder addSteps(int i, NavigationStep navigationStep) {
            copyOnWrite();
            ((NavigationState) this.instance).addSteps(i, navigationStep);
            return this;
        }

        public Builder setDestinations(int i, NavigationDestination.Builder builder) {
            copyOnWrite();
            ((NavigationState) this.instance).setDestinations(i, builder);
            return this;
        }

        public Builder setSteps(int i, NavigationStep.Builder builder) {
            copyOnWrite();
            ((NavigationState) this.instance).setSteps(i, builder);
            return this;
        }

        public Builder addDestinations(NavigationDestination.Builder builder) {
            copyOnWrite();
            ((NavigationState) this.instance).addDestinations(builder);
            return this;
        }

        public Builder addSteps(NavigationStep.Builder builder) {
            copyOnWrite();
            ((NavigationState) this.instance).addSteps(builder);
            return this;
        }

        public Builder addDestinations(int i, NavigationDestination.Builder builder) {
            copyOnWrite();
            ((NavigationState) this.instance).addDestinations(i, builder);
            return this;
        }

        public Builder addSteps(int i, NavigationStep.Builder builder) {
            copyOnWrite();
            ((NavigationState) this.instance).addSteps(i, builder);
            return this;
        }
    }

    static {
        NavigationState navigationState = new NavigationState();
        DEFAULT_INSTANCE = navigationState;
        GeneratedMessageLite.registerDefaultInstance(NavigationState.class, navigationState);
    }

    private NavigationState() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDestinations(Iterable<? extends NavigationDestination> iterable) {
        ensureDestinationsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.destinations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSteps(Iterable<? extends NavigationStep> iterable) {
        ensureStepsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.steps_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDestinations(NavigationDestination navigationDestination) {
        navigationDestination.getClass();
        ensureDestinationsIsMutable();
        this.destinations_.add(navigationDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSteps(NavigationStep navigationStep) {
        navigationStep.getClass();
        ensureStepsIsMutable();
        this.steps_.add(navigationStep);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDestinations() {
        this.destinations_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSteps() {
        this.steps_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureDestinationsIsMutable() {
        if (this.destinations_.isModifiable()) {
            return;
        }
        this.destinations_ = GeneratedMessageLite.mutableCopy(this.destinations_);
    }

    private void ensureStepsIsMutable() {
        if (this.steps_.isModifiable()) {
            return;
        }
        this.steps_ = GeneratedMessageLite.mutableCopy(this.steps_);
    }

    public static NavigationState getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static NavigationState parseDelimitedFrom(InputStream inputStream) {
        return (NavigationState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationState parseFrom(ByteBuffer byteBuffer) {
        return (NavigationState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NavigationState> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDestinations(int i) {
        ensureDestinationsIsMutable();
        this.destinations_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSteps(int i) {
        ensureStepsIsMutable();
        this.steps_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestinations(int i, NavigationDestination navigationDestination) {
        navigationDestination.getClass();
        ensureDestinationsIsMutable();
        this.destinations_.set(i, navigationDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSteps(int i, NavigationStep navigationStep) {
        navigationStep.getClass();
        ensureStepsIsMutable();
        this.steps_.set(i, navigationStep);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new NavigationState();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"steps_", NavigationStep.class, "destinations_", NavigationDestination.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NavigationState> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (NavigationState.class) {
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

    @Override // fr.sd.taada.proto.NavigationStateOrBuilder
    public NavigationDestination getDestinations(int i) {
        return this.destinations_.get(i);
    }

    @Override // fr.sd.taada.proto.NavigationStateOrBuilder
    public int getDestinationsCount() {
        return this.destinations_.size();
    }

    @Override // fr.sd.taada.proto.NavigationStateOrBuilder
    public List<NavigationDestination> getDestinationsList() {
        return this.destinations_;
    }

    public NavigationDestinationOrBuilder getDestinationsOrBuilder(int i) {
        return this.destinations_.get(i);
    }

    public List<? extends NavigationDestinationOrBuilder> getDestinationsOrBuilderList() {
        return this.destinations_;
    }

    @Override // fr.sd.taada.proto.NavigationStateOrBuilder
    public NavigationStep getSteps(int i) {
        return this.steps_.get(i);
    }

    @Override // fr.sd.taada.proto.NavigationStateOrBuilder
    public int getStepsCount() {
        return this.steps_.size();
    }

    @Override // fr.sd.taada.proto.NavigationStateOrBuilder
    public List<NavigationStep> getStepsList() {
        return this.steps_;
    }

    public NavigationStepOrBuilder getStepsOrBuilder(int i) {
        return this.steps_.get(i);
    }

    public List<? extends NavigationStepOrBuilder> getStepsOrBuilderList() {
        return this.steps_;
    }

    public static Builder newBuilder(NavigationState navigationState) {
        return DEFAULT_INSTANCE.createBuilder(navigationState);
    }

    public static NavigationState parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationState) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NavigationState parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NavigationState parseFrom(ByteString byteString) {
        return (NavigationState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDestinations(int i, NavigationDestination navigationDestination) {
        navigationDestination.getClass();
        ensureDestinationsIsMutable();
        this.destinations_.add(i, navigationDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSteps(int i, NavigationStep navigationStep) {
        navigationStep.getClass();
        ensureStepsIsMutable();
        this.steps_.add(i, navigationStep);
    }

    public static NavigationState parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestinations(int i, NavigationDestination.Builder builder) {
        ensureDestinationsIsMutable();
        this.destinations_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSteps(int i, NavigationStep.Builder builder) {
        ensureStepsIsMutable();
        this.steps_.set(i, builder.build());
    }

    public static NavigationState parseFrom(byte[] bArr) {
        return (NavigationState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NavigationState parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDestinations(NavigationDestination.Builder builder) {
        ensureDestinationsIsMutable();
        this.destinations_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSteps(NavigationStep.Builder builder) {
        ensureStepsIsMutable();
        this.steps_.add(builder.build());
    }

    public static NavigationState parseFrom(InputStream inputStream) {
        return (NavigationState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NavigationState parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDestinations(int i, NavigationDestination.Builder builder) {
        ensureDestinationsIsMutable();
        this.destinations_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSteps(int i, NavigationStep.Builder builder) {
        ensureStepsIsMutable();
        this.steps_.add(i, builder.build());
    }

    public static NavigationState parseFrom(CodedInputStream codedInputStream) {
        return (NavigationState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NavigationState parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (NavigationState) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
