package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.RadioStationInfo;
import fr.sd.taada.proto.StationPresetList;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class RadioStateNotification extends GeneratedMessageLite<RadioStateNotification, Builder> implements RadioStateNotificationOrBuilder {
    public static final int ACTIVE_RADIO_ID_FIELD_NUMBER = 3;
    private static final RadioStateNotification DEFAULT_INSTANCE;
    private static volatile Parser<RadioStateNotification> PARSER = null;
    public static final int PROGRAM_LIST_FIELD_NUMBER = 5;
    public static final int RADIO_MUTED_FIELD_NUMBER = 2;
    public static final int RADIO_SOURCE_ENABLED_FIELD_NUMBER = 1;
    public static final int STATION_INFO_FIELD_NUMBER = 4;
    public static final int STATION_PRESET_LISTS_FIELD_NUMBER = 6;
    private int activeRadioId_;
    private int bitField0_;
    private boolean radioMuted_;
    private boolean radioSourceEnabled_;
    private RadioStationInfo stationInfo_;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<RadioStationInfo> programList_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<StationPresetList> stationPresetLists_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.RadioStateNotification$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<RadioStateNotification, Builder> implements RadioStateNotificationOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllProgramList(Iterable<? extends RadioStationInfo> iterable) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).addAllProgramList(iterable);
            return this;
        }

        public Builder addAllStationPresetLists(Iterable<? extends StationPresetList> iterable) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).addAllStationPresetLists(iterable);
            return this;
        }

        public Builder addProgramList(RadioStationInfo radioStationInfo) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).addProgramList(radioStationInfo);
            return this;
        }

        public Builder addStationPresetLists(StationPresetList stationPresetList) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).addStationPresetLists(stationPresetList);
            return this;
        }

        public Builder clearActiveRadioId() {
            copyOnWrite();
            ((RadioStateNotification) this.instance).clearActiveRadioId();
            return this;
        }

        public Builder clearProgramList() {
            copyOnWrite();
            ((RadioStateNotification) this.instance).clearProgramList();
            return this;
        }

        public Builder clearRadioMuted() {
            copyOnWrite();
            ((RadioStateNotification) this.instance).clearRadioMuted();
            return this;
        }

        public Builder clearRadioSourceEnabled() {
            copyOnWrite();
            ((RadioStateNotification) this.instance).clearRadioSourceEnabled();
            return this;
        }

        public Builder clearStationInfo() {
            copyOnWrite();
            ((RadioStateNotification) this.instance).clearStationInfo();
            return this;
        }

        public Builder clearStationPresetLists() {
            copyOnWrite();
            ((RadioStateNotification) this.instance).clearStationPresetLists();
            return this;
        }

        @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
        public int getActiveRadioId() {
            return ((RadioStateNotification) this.instance).getActiveRadioId();
        }

        @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
        public RadioStationInfo getProgramList(int i) {
            return ((RadioStateNotification) this.instance).getProgramList(i);
        }

        @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
        public int getProgramListCount() {
            return ((RadioStateNotification) this.instance).getProgramListCount();
        }

        @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
        public List<RadioStationInfo> getProgramListList() {
            return Collections.unmodifiableList(((RadioStateNotification) this.instance).getProgramListList());
        }

        @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
        public boolean getRadioMuted() {
            return ((RadioStateNotification) this.instance).getRadioMuted();
        }

        @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
        public boolean getRadioSourceEnabled() {
            return ((RadioStateNotification) this.instance).getRadioSourceEnabled();
        }

        @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
        public RadioStationInfo getStationInfo() {
            return ((RadioStateNotification) this.instance).getStationInfo();
        }

        @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
        public StationPresetList getStationPresetLists(int i) {
            return ((RadioStateNotification) this.instance).getStationPresetLists(i);
        }

        @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
        public int getStationPresetListsCount() {
            return ((RadioStateNotification) this.instance).getStationPresetListsCount();
        }

        @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
        public List<StationPresetList> getStationPresetListsList() {
            return Collections.unmodifiableList(((RadioStateNotification) this.instance).getStationPresetListsList());
        }

        @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
        public boolean hasActiveRadioId() {
            return ((RadioStateNotification) this.instance).hasActiveRadioId();
        }

        @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
        public boolean hasRadioMuted() {
            return ((RadioStateNotification) this.instance).hasRadioMuted();
        }

        @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
        public boolean hasRadioSourceEnabled() {
            return ((RadioStateNotification) this.instance).hasRadioSourceEnabled();
        }

        @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
        public boolean hasStationInfo() {
            return ((RadioStateNotification) this.instance).hasStationInfo();
        }

        public Builder mergeStationInfo(RadioStationInfo radioStationInfo) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).mergeStationInfo(radioStationInfo);
            return this;
        }

        public Builder removeProgramList(int i) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).removeProgramList(i);
            return this;
        }

        public Builder removeStationPresetLists(int i) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).removeStationPresetLists(i);
            return this;
        }

        public Builder setActiveRadioId(int i) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).setActiveRadioId(i);
            return this;
        }

        public Builder setProgramList(int i, RadioStationInfo radioStationInfo) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).setProgramList(i, radioStationInfo);
            return this;
        }

        public Builder setRadioMuted(boolean z6) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).setRadioMuted(z6);
            return this;
        }

        public Builder setRadioSourceEnabled(boolean z6) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).setRadioSourceEnabled(z6);
            return this;
        }

        public Builder setStationInfo(RadioStationInfo radioStationInfo) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).setStationInfo(radioStationInfo);
            return this;
        }

        public Builder setStationPresetLists(int i, StationPresetList stationPresetList) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).setStationPresetLists(i, stationPresetList);
            return this;
        }

        private Builder() {
            super(RadioStateNotification.DEFAULT_INSTANCE);
        }

        public Builder addProgramList(int i, RadioStationInfo radioStationInfo) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).addProgramList(i, radioStationInfo);
            return this;
        }

        public Builder addStationPresetLists(int i, StationPresetList stationPresetList) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).addStationPresetLists(i, stationPresetList);
            return this;
        }

        public Builder setProgramList(int i, RadioStationInfo.Builder builder) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).setProgramList(i, builder);
            return this;
        }

        public Builder setStationInfo(RadioStationInfo.Builder builder) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).setStationInfo(builder);
            return this;
        }

        public Builder setStationPresetLists(int i, StationPresetList.Builder builder) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).setStationPresetLists(i, builder);
            return this;
        }

        public Builder addProgramList(RadioStationInfo.Builder builder) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).addProgramList(builder);
            return this;
        }

        public Builder addStationPresetLists(StationPresetList.Builder builder) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).addStationPresetLists(builder);
            return this;
        }

        public Builder addProgramList(int i, RadioStationInfo.Builder builder) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).addProgramList(i, builder);
            return this;
        }

        public Builder addStationPresetLists(int i, StationPresetList.Builder builder) {
            copyOnWrite();
            ((RadioStateNotification) this.instance).addStationPresetLists(i, builder);
            return this;
        }
    }

    static {
        RadioStateNotification radioStateNotification = new RadioStateNotification();
        DEFAULT_INSTANCE = radioStateNotification;
        GeneratedMessageLite.registerDefaultInstance(RadioStateNotification.class, radioStateNotification);
    }

    private RadioStateNotification() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllProgramList(Iterable<? extends RadioStationInfo> iterable) {
        ensureProgramListIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.programList_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllStationPresetLists(Iterable<? extends StationPresetList> iterable) {
        ensureStationPresetListsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.stationPresetLists_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProgramList(RadioStationInfo radioStationInfo) {
        radioStationInfo.getClass();
        ensureProgramListIsMutable();
        this.programList_.add(radioStationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStationPresetLists(StationPresetList stationPresetList) {
        stationPresetList.getClass();
        ensureStationPresetListsIsMutable();
        this.stationPresetLists_.add(stationPresetList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearActiveRadioId() {
        this.bitField0_ &= -5;
        this.activeRadioId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProgramList() {
        this.programList_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioMuted() {
        this.bitField0_ &= -3;
        this.radioMuted_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioSourceEnabled() {
        this.bitField0_ &= -2;
        this.radioSourceEnabled_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStationInfo() {
        this.stationInfo_ = null;
        this.bitField0_ &= -9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStationPresetLists() {
        this.stationPresetLists_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureProgramListIsMutable() {
        if (this.programList_.isModifiable()) {
            return;
        }
        this.programList_ = GeneratedMessageLite.mutableCopy(this.programList_);
    }

    private void ensureStationPresetListsIsMutable() {
        if (this.stationPresetLists_.isModifiable()) {
            return;
        }
        this.stationPresetLists_ = GeneratedMessageLite.mutableCopy(this.stationPresetLists_);
    }

    public static RadioStateNotification getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStationInfo(RadioStationInfo radioStationInfo) {
        radioStationInfo.getClass();
        RadioStationInfo radioStationInfo2 = this.stationInfo_;
        if (radioStationInfo2 == null || radioStationInfo2 == RadioStationInfo.getDefaultInstance()) {
            this.stationInfo_ = radioStationInfo;
        } else {
            this.stationInfo_ = RadioStationInfo.newBuilder(this.stationInfo_).mergeFrom(radioStationInfo).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static RadioStateNotification parseDelimitedFrom(InputStream inputStream) {
        return (RadioStateNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RadioStateNotification parseFrom(ByteBuffer byteBuffer) {
        return (RadioStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<RadioStateNotification> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeProgramList(int i) {
        ensureProgramListIsMutable();
        this.programList_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeStationPresetLists(int i) {
        ensureStationPresetListsIsMutable();
        this.stationPresetLists_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActiveRadioId(int i) {
        this.bitField0_ |= 4;
        this.activeRadioId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgramList(int i, RadioStationInfo radioStationInfo) {
        radioStationInfo.getClass();
        ensureProgramListIsMutable();
        this.programList_.set(i, radioStationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioMuted(boolean z6) {
        this.bitField0_ |= 2;
        this.radioMuted_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioSourceEnabled(boolean z6) {
        this.bitField0_ |= 1;
        this.radioSourceEnabled_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStationInfo(RadioStationInfo radioStationInfo) {
        radioStationInfo.getClass();
        this.stationInfo_ = radioStationInfo;
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStationPresetLists(int i, StationPresetList stationPresetList) {
        stationPresetList.getClass();
        ensureStationPresetListsIsMutable();
        this.stationPresetLists_.set(i, stationPresetList);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RadioStateNotification();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0005\u0001ԇ\u0000\u0002\u0007\u0001\u0003Ԅ\u0002\u0004ԉ\u0003\u0005Л\u0006Л", new Object[]{"bitField0_", "radioSourceEnabled_", "radioMuted_", "activeRadioId_", "stationInfo_", "programList_", RadioStationInfo.class, "stationPresetLists_", StationPresetList.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RadioStateNotification> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (RadioStateNotification.class) {
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

    @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
    public int getActiveRadioId() {
        return this.activeRadioId_;
    }

    @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
    public RadioStationInfo getProgramList(int i) {
        return this.programList_.get(i);
    }

    @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
    public int getProgramListCount() {
        return this.programList_.size();
    }

    @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
    public List<RadioStationInfo> getProgramListList() {
        return this.programList_;
    }

    public RadioStationInfoOrBuilder getProgramListOrBuilder(int i) {
        return this.programList_.get(i);
    }

    public List<? extends RadioStationInfoOrBuilder> getProgramListOrBuilderList() {
        return this.programList_;
    }

    @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
    public boolean getRadioMuted() {
        return this.radioMuted_;
    }

    @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
    public boolean getRadioSourceEnabled() {
        return this.radioSourceEnabled_;
    }

    @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
    public RadioStationInfo getStationInfo() {
        RadioStationInfo radioStationInfo = this.stationInfo_;
        return radioStationInfo == null ? RadioStationInfo.getDefaultInstance() : radioStationInfo;
    }

    @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
    public StationPresetList getStationPresetLists(int i) {
        return this.stationPresetLists_.get(i);
    }

    @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
    public int getStationPresetListsCount() {
        return this.stationPresetLists_.size();
    }

    @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
    public List<StationPresetList> getStationPresetListsList() {
        return this.stationPresetLists_;
    }

    public StationPresetListOrBuilder getStationPresetListsOrBuilder(int i) {
        return this.stationPresetLists_.get(i);
    }

    public List<? extends StationPresetListOrBuilder> getStationPresetListsOrBuilderList() {
        return this.stationPresetLists_;
    }

    @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
    public boolean hasActiveRadioId() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
    public boolean hasRadioMuted() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
    public boolean hasRadioSourceEnabled() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.RadioStateNotificationOrBuilder
    public boolean hasStationInfo() {
        return (this.bitField0_ & 8) != 0;
    }

    public static Builder newBuilder(RadioStateNotification radioStateNotification) {
        return DEFAULT_INSTANCE.createBuilder(radioStateNotification);
    }

    public static RadioStateNotification parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStateNotification) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RadioStateNotification parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RadioStateNotification parseFrom(ByteString byteString) {
        return (RadioStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProgramList(int i, RadioStationInfo radioStationInfo) {
        radioStationInfo.getClass();
        ensureProgramListIsMutable();
        this.programList_.add(i, radioStationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStationPresetLists(int i, StationPresetList stationPresetList) {
        stationPresetList.getClass();
        ensureStationPresetListsIsMutable();
        this.stationPresetLists_.add(i, stationPresetList);
    }

    public static RadioStateNotification parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgramList(int i, RadioStationInfo.Builder builder) {
        ensureProgramListIsMutable();
        this.programList_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStationInfo(RadioStationInfo.Builder builder) {
        this.stationInfo_ = builder.build();
        this.bitField0_ |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStationPresetLists(int i, StationPresetList.Builder builder) {
        ensureStationPresetListsIsMutable();
        this.stationPresetLists_.set(i, builder.build());
    }

    public static RadioStateNotification parseFrom(byte[] bArr) {
        return (RadioStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RadioStateNotification parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProgramList(RadioStationInfo.Builder builder) {
        ensureProgramListIsMutable();
        this.programList_.add(builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStationPresetLists(StationPresetList.Builder builder) {
        ensureStationPresetListsIsMutable();
        this.stationPresetLists_.add(builder.build());
    }

    public static RadioStateNotification parseFrom(InputStream inputStream) {
        return (RadioStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RadioStateNotification parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProgramList(int i, RadioStationInfo.Builder builder) {
        ensureProgramListIsMutable();
        this.programList_.add(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStationPresetLists(int i, StationPresetList.Builder builder) {
        ensureStationPresetListsIsMutable();
        this.stationPresetLists_.add(i, builder.build());
    }

    public static RadioStateNotification parseFrom(CodedInputStream codedInputStream) {
        return (RadioStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RadioStateNotification parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioStateNotification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
