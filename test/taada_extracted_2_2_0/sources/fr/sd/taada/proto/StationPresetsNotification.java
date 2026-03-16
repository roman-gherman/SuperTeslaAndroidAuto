package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.StationPresetList;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class StationPresetsNotification extends GeneratedMessageLite<StationPresetsNotification, Builder> implements StationPresetsNotificationOrBuilder {
    private static final StationPresetsNotification DEFAULT_INSTANCE;
    private static volatile Parser<StationPresetsNotification> PARSER = null;
    public static final int PRESET_LISTS_FIELD_NUMBER = 2;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<StationPresetList> presetLists_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.StationPresetsNotification$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<StationPresetsNotification, Builder> implements StationPresetsNotificationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllPresetLists(Iterable<? extends StationPresetList> iterable) {
            copyOnWrite();
            ((StationPresetsNotification) this.instance).addAllPresetLists(iterable);
            return this;
        }

        public Builder addPresetLists(StationPresetList stationPresetList) {
            copyOnWrite();
            ((StationPresetsNotification) this.instance).addPresetLists(stationPresetList);
            return this;
        }

        public Builder clearPresetLists() {
            copyOnWrite();
            ((StationPresetsNotification) this.instance).clearPresetLists();
            return this;
        }

        @Override // fr.sd.taada.proto.StationPresetsNotificationOrBuilder
        public StationPresetList getPresetLists(int i) {
            return ((StationPresetsNotification) this.instance).getPresetLists(i);
        }

        @Override // fr.sd.taada.proto.StationPresetsNotificationOrBuilder
        public int getPresetListsCount() {
            return ((StationPresetsNotification) this.instance).getPresetListsCount();
        }

        @Override // fr.sd.taada.proto.StationPresetsNotificationOrBuilder
        public List<StationPresetList> getPresetListsList() {
            return Collections.unmodifiableList(((StationPresetsNotification) this.instance).getPresetListsList());
        }

        public Builder removePresetLists(int i) {
            copyOnWrite();
            ((StationPresetsNotification) this.instance).removePresetLists(i);
            return this;
        }

        public Builder setPresetLists(int i, StationPresetList stationPresetList) {
            copyOnWrite();
            ((StationPresetsNotification) this.instance).setPresetLists(i, stationPresetList);
            return this;
        }

        private Builder() {
            super(StationPresetsNotification.DEFAULT_INSTANCE);
        }

        public Builder addPresetLists(int i, StationPresetList stationPresetList) {
            copyOnWrite();
            ((StationPresetsNotification) this.instance).addPresetLists(i, stationPresetList);
            return this;
        }

        public Builder setPresetLists(int i, StationPresetList.Builder builder) {
            copyOnWrite();
            ((StationPresetsNotification) this.instance).setPresetLists(i, builder);
            return this;
        }

        public Builder addPresetLists(StationPresetList.Builder builder) {
            copyOnWrite();
            ((StationPresetsNotification) this.instance).addPresetLists(builder);
            return this;
        }

        public Builder addPresetLists(int i, StationPresetList.Builder builder) {
            copyOnWrite();
            ((StationPresetsNotification) this.instance).addPresetLists(i, builder);
            return this;
        }
    }

    static {
        StationPresetsNotification stationPresetsNotification = new StationPresetsNotification();
        DEFAULT_INSTANCE = stationPresetsNotification;
        GeneratedMessageLite.registerDefaultInstance(StationPresetsNotification.class, stationPresetsNotification);
    }

    private StationPresetsNotification() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPresetLists(Iterable<? extends StationPresetList> iterable) {
        ensurePresetListsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.presetLists_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPresetLists(StationPresetList stationPresetList) {
        stationPresetList.getClass();
        ensurePresetListsIsMutable();
        this.presetLists_.add(stationPresetList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPresetLists() {
        this.presetLists_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePresetListsIsMutable() {
        if (this.presetLists_.isModifiable()) {
            return;
        }
        this.presetLists_ = GeneratedMessageLite.mutableCopy(this.presetLists_);
    }

    public static StationPresetsNotification getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static StationPresetsNotification parseDelimitedFrom(InputStream inputStream) {
        return (StationPresetsNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StationPresetsNotification parseFrom(ByteBuffer byteBuffer) {
        return (StationPresetsNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<StationPresetsNotification> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePresetLists(int i) {
        ensurePresetListsIsMutable();
        this.presetLists_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPresetLists(int i, StationPresetList stationPresetList) {
        stationPresetList.getClass();
        ensurePresetListsIsMutable();
        this.presetLists_.set(i, stationPresetList);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new StationPresetsNotification();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0001\u0002Л", new Object[]{"presetLists_", StationPresetList.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StationPresetsNotification> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (StationPresetsNotification.class) {
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

    @Override // fr.sd.taada.proto.StationPresetsNotificationOrBuilder
    public StationPresetList getPresetLists(int i) {
        return this.presetLists_.get(i);
    }

    @Override // fr.sd.taada.proto.StationPresetsNotificationOrBuilder
    public int getPresetListsCount() {
        return this.presetLists_.size();
    }

    @Override // fr.sd.taada.proto.StationPresetsNotificationOrBuilder
    public List<StationPresetList> getPresetListsList() {
        return this.presetLists_;
    }

    public StationPresetListOrBuilder getPresetListsOrBuilder(int i) {
        return this.presetLists_.get(i);
    }

    public List<? extends StationPresetListOrBuilder> getPresetListsOrBuilderList() {
        return this.presetLists_;
    }

    public static Builder newBuilder(StationPresetsNotification stationPresetsNotification) {
        return DEFAULT_INSTANCE.createBuilder(stationPresetsNotification);
    }

    public static StationPresetsNotification parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StationPresetsNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StationPresetsNotification parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (StationPresetsNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StationPresetsNotification parseFrom(ByteString byteString) {
        return (StationPresetsNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPresetLists(int i, StationPresetList stationPresetList) {
        stationPresetList.getClass();
        ensurePresetListsIsMutable();
        this.presetLists_.add(i, stationPresetList);
    }

    public static StationPresetsNotification parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (StationPresetsNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPresetLists(int i, StationPresetList.Builder builder) {
        ensurePresetListsIsMutable();
        this.presetLists_.set(i, builder.build());
    }

    public static StationPresetsNotification parseFrom(byte[] bArr) {
        return (StationPresetsNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StationPresetsNotification parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (StationPresetsNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPresetLists(StationPresetList.Builder builder) {
        ensurePresetListsIsMutable();
        this.presetLists_.add(builder.build());
    }

    public static StationPresetsNotification parseFrom(InputStream inputStream) {
        return (StationPresetsNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StationPresetsNotification parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StationPresetsNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPresetLists(int i, StationPresetList.Builder builder) {
        ensurePresetListsIsMutable();
        this.presetLists_.add(i, builder.build());
    }

    public static StationPresetsNotification parseFrom(CodedInputStream codedInputStream) {
        return (StationPresetsNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StationPresetsNotification parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StationPresetsNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
