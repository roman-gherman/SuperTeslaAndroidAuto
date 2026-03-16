package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.StationPreset;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class StationPresetList extends GeneratedMessageLite<StationPresetList, Builder> implements StationPresetListOrBuilder {
    private static final StationPresetList DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<StationPresetList> PARSER = null;
    public static final int PRESETS_FIELD_NUMBER = 3;
    public static final int RESTRICTED_STATION_TYPES_FIELD_NUMBER = 2;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";
    private Internal.IntList restrictedStationTypes_ = GeneratedMessageLite.emptyIntList();
    private Internal.ProtobufList<StationPreset> presets_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.StationPresetList$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<StationPresetList, Builder> implements StationPresetListOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllPresets(Iterable<? extends StationPreset> iterable) {
            copyOnWrite();
            ((StationPresetList) this.instance).addAllPresets(iterable);
            return this;
        }

        public Builder addAllRestrictedStationTypes(Iterable<? extends Integer> iterable) {
            copyOnWrite();
            ((StationPresetList) this.instance).addAllRestrictedStationTypes(iterable);
            return this;
        }

        public Builder addPresets(StationPreset stationPreset) {
            copyOnWrite();
            ((StationPresetList) this.instance).addPresets(stationPreset);
            return this;
        }

        public Builder addRestrictedStationTypes(int i) {
            copyOnWrite();
            ((StationPresetList) this.instance).addRestrictedStationTypes(i);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((StationPresetList) this.instance).clearName();
            return this;
        }

        public Builder clearPresets() {
            copyOnWrite();
            ((StationPresetList) this.instance).clearPresets();
            return this;
        }

        public Builder clearRestrictedStationTypes() {
            copyOnWrite();
            ((StationPresetList) this.instance).clearRestrictedStationTypes();
            return this;
        }

        @Override // fr.sd.taada.proto.StationPresetListOrBuilder
        public String getName() {
            return ((StationPresetList) this.instance).getName();
        }

        @Override // fr.sd.taada.proto.StationPresetListOrBuilder
        public ByteString getNameBytes() {
            return ((StationPresetList) this.instance).getNameBytes();
        }

        @Override // fr.sd.taada.proto.StationPresetListOrBuilder
        public StationPreset getPresets(int i) {
            return ((StationPresetList) this.instance).getPresets(i);
        }

        @Override // fr.sd.taada.proto.StationPresetListOrBuilder
        public int getPresetsCount() {
            return ((StationPresetList) this.instance).getPresetsCount();
        }

        @Override // fr.sd.taada.proto.StationPresetListOrBuilder
        public List<StationPreset> getPresetsList() {
            return Collections.unmodifiableList(((StationPresetList) this.instance).getPresetsList());
        }

        @Override // fr.sd.taada.proto.StationPresetListOrBuilder
        public int getRestrictedStationTypes(int i) {
            return ((StationPresetList) this.instance).getRestrictedStationTypes(i);
        }

        @Override // fr.sd.taada.proto.StationPresetListOrBuilder
        public int getRestrictedStationTypesCount() {
            return ((StationPresetList) this.instance).getRestrictedStationTypesCount();
        }

        @Override // fr.sd.taada.proto.StationPresetListOrBuilder
        public List<Integer> getRestrictedStationTypesList() {
            return Collections.unmodifiableList(((StationPresetList) this.instance).getRestrictedStationTypesList());
        }

        @Override // fr.sd.taada.proto.StationPresetListOrBuilder
        public boolean hasName() {
            return ((StationPresetList) this.instance).hasName();
        }

        public Builder removePresets(int i) {
            copyOnWrite();
            ((StationPresetList) this.instance).removePresets(i);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((StationPresetList) this.instance).setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((StationPresetList) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setPresets(int i, StationPreset stationPreset) {
            copyOnWrite();
            ((StationPresetList) this.instance).setPresets(i, stationPreset);
            return this;
        }

        public Builder setRestrictedStationTypes(int i, int i3) {
            copyOnWrite();
            ((StationPresetList) this.instance).setRestrictedStationTypes(i, i3);
            return this;
        }

        private Builder() {
            super(StationPresetList.DEFAULT_INSTANCE);
        }

        public Builder addPresets(int i, StationPreset stationPreset) {
            copyOnWrite();
            ((StationPresetList) this.instance).addPresets(i, stationPreset);
            return this;
        }

        public Builder setPresets(int i, StationPreset.Builder builder) {
            copyOnWrite();
            ((StationPresetList) this.instance).setPresets(i, builder);
            return this;
        }

        public Builder addPresets(StationPreset.Builder builder) {
            copyOnWrite();
            ((StationPresetList) this.instance).addPresets(builder);
            return this;
        }

        public Builder addPresets(int i, StationPreset.Builder builder) {
            copyOnWrite();
            ((StationPresetList) this.instance).addPresets(i, builder);
            return this;
        }
    }

    static {
        StationPresetList stationPresetList = new StationPresetList();
        DEFAULT_INSTANCE = stationPresetList;
        GeneratedMessageLite.registerDefaultInstance(StationPresetList.class, stationPresetList);
    }

    private StationPresetList() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPresets(Iterable<? extends StationPreset> iterable) {
        ensurePresetsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.presets_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRestrictedStationTypes(Iterable<? extends Integer> iterable) {
        ensureRestrictedStationTypesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.restrictedStationTypes_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPresets(StationPreset stationPreset) {
        stationPreset.getClass();
        ensurePresetsIsMutable();
        this.presets_.add(stationPreset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRestrictedStationTypes(int i) {
        ensureRestrictedStationTypesIsMutable();
        this.restrictedStationTypes_.addInt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.bitField0_ &= -2;
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPresets() {
        this.presets_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRestrictedStationTypes() {
        this.restrictedStationTypes_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensurePresetsIsMutable() {
        if (this.presets_.isModifiable()) {
            return;
        }
        this.presets_ = GeneratedMessageLite.mutableCopy(this.presets_);
    }

    private void ensureRestrictedStationTypesIsMutable() {
        if (this.restrictedStationTypes_.isModifiable()) {
            return;
        }
        this.restrictedStationTypes_ = GeneratedMessageLite.mutableCopy(this.restrictedStationTypes_);
    }

    public static StationPresetList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static StationPresetList parseDelimitedFrom(InputStream inputStream) {
        return (StationPresetList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StationPresetList parseFrom(ByteBuffer byteBuffer) {
        return (StationPresetList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<StationPresetList> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePresets(int i) {
        ensurePresetsIsMutable();
        this.presets_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPresets(int i, StationPreset stationPreset) {
        stationPreset.getClass();
        ensurePresetsIsMutable();
        this.presets_.set(i, stationPreset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRestrictedStationTypes(int i, int i3) {
        ensureRestrictedStationTypesIsMutable();
        this.restrictedStationTypes_.setInt(i, i3);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new StationPresetList();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0001\u0001\b\u0000\u0002\u0016\u0003Л", new Object[]{"bitField0_", "name_", "restrictedStationTypes_", "presets_", StationPreset.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StationPresetList> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (StationPresetList.class) {
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

    @Override // fr.sd.taada.proto.StationPresetListOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // fr.sd.taada.proto.StationPresetListOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // fr.sd.taada.proto.StationPresetListOrBuilder
    public StationPreset getPresets(int i) {
        return this.presets_.get(i);
    }

    @Override // fr.sd.taada.proto.StationPresetListOrBuilder
    public int getPresetsCount() {
        return this.presets_.size();
    }

    @Override // fr.sd.taada.proto.StationPresetListOrBuilder
    public List<StationPreset> getPresetsList() {
        return this.presets_;
    }

    public StationPresetOrBuilder getPresetsOrBuilder(int i) {
        return this.presets_.get(i);
    }

    public List<? extends StationPresetOrBuilder> getPresetsOrBuilderList() {
        return this.presets_;
    }

    @Override // fr.sd.taada.proto.StationPresetListOrBuilder
    public int getRestrictedStationTypes(int i) {
        return this.restrictedStationTypes_.getInt(i);
    }

    @Override // fr.sd.taada.proto.StationPresetListOrBuilder
    public int getRestrictedStationTypesCount() {
        return this.restrictedStationTypes_.size();
    }

    @Override // fr.sd.taada.proto.StationPresetListOrBuilder
    public List<Integer> getRestrictedStationTypesList() {
        return this.restrictedStationTypes_;
    }

    @Override // fr.sd.taada.proto.StationPresetListOrBuilder
    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(StationPresetList stationPresetList) {
        return DEFAULT_INSTANCE.createBuilder(stationPresetList);
    }

    public static StationPresetList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StationPresetList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StationPresetList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (StationPresetList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StationPresetList parseFrom(ByteString byteString) {
        return (StationPresetList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPresets(int i, StationPreset stationPreset) {
        stationPreset.getClass();
        ensurePresetsIsMutable();
        this.presets_.add(i, stationPreset);
    }

    public static StationPresetList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (StationPresetList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPresets(int i, StationPreset.Builder builder) {
        ensurePresetsIsMutable();
        this.presets_.set(i, builder.build());
    }

    public static StationPresetList parseFrom(byte[] bArr) {
        return (StationPresetList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StationPresetList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (StationPresetList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPresets(StationPreset.Builder builder) {
        ensurePresetsIsMutable();
        this.presets_.add(builder.build());
    }

    public static StationPresetList parseFrom(InputStream inputStream) {
        return (StationPresetList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StationPresetList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StationPresetList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPresets(int i, StationPreset.Builder builder) {
        ensurePresetsIsMutable();
        this.presets_.add(i, builder.build());
    }

    public static StationPresetList parseFrom(CodedInputStream codedInputStream) {
        return (StationPresetList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StationPresetList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (StationPresetList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
