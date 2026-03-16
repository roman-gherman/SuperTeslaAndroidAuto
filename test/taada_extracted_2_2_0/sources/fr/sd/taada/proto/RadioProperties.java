package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.Range;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class RadioProperties extends GeneratedMessageLite<RadioProperties, Builder> implements RadioPropertiesOrBuilder {
    public static final int AF_SWITCH_FIELD_NUMBER = 9;
    public static final int AUDIO_LOOPBACK_FIELD_NUMBER = 12;
    public static final int BACKGROUND_TUNER_FIELD_NUMBER = 6;
    public static final int CHANNEL_RANGE_FIELD_NUMBER = 3;
    public static final int CHANNEL_SPACINGS_FIELD_NUMBER = 4;
    public static final int CHANNEL_SPACING_FIELD_NUMBER = 5;
    private static final RadioProperties DEFAULT_INSTANCE;
    public static final int MUTE_CAPABILITY_FIELD_NUMBER = 13;
    private static volatile Parser<RadioProperties> PARSER = null;
    public static final int RADIO_ID_FIELD_NUMBER = 1;
    public static final int RDS_FIELD_NUMBER = 8;
    public static final int REGION_FIELD_NUMBER = 7;
    public static final int STATION_PRESETS_ACCESS_FIELD_NUMBER = 14;
    public static final int TA_FIELD_NUMBER = 10;
    public static final int TRAFFIC_SERVICE_FIELD_NUMBER = 11;
    public static final int TYPE_FIELD_NUMBER = 2;
    private boolean afSwitch_;
    private boolean audioLoopback_;
    private boolean backgroundTuner_;
    private int bitField0_;
    private int channelSpacing_;
    private boolean muteCapability_;
    private int radioId_;
    private int rds_;
    private int region_;
    private int stationPresetsAccess_;
    private boolean ta_;
    private int trafficService_;
    private int type_;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<Range> channelRange_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.IntList channelSpacings_ = GeneratedMessageLite.emptyIntList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.RadioProperties$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<RadioProperties, Builder> implements RadioPropertiesOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllChannelRange(Iterable<? extends Range> iterable) {
            copyOnWrite();
            ((RadioProperties) this.instance).addAllChannelRange(iterable);
            return this;
        }

        public Builder addAllChannelSpacings(Iterable<? extends Integer> iterable) {
            copyOnWrite();
            ((RadioProperties) this.instance).addAllChannelSpacings(iterable);
            return this;
        }

        public Builder addChannelRange(Range range) {
            copyOnWrite();
            ((RadioProperties) this.instance).addChannelRange(range);
            return this;
        }

        public Builder addChannelSpacings(int i) {
            copyOnWrite();
            ((RadioProperties) this.instance).addChannelSpacings(i);
            return this;
        }

        public Builder clearAfSwitch() {
            copyOnWrite();
            ((RadioProperties) this.instance).clearAfSwitch();
            return this;
        }

        public Builder clearAudioLoopback() {
            copyOnWrite();
            ((RadioProperties) this.instance).clearAudioLoopback();
            return this;
        }

        public Builder clearBackgroundTuner() {
            copyOnWrite();
            ((RadioProperties) this.instance).clearBackgroundTuner();
            return this;
        }

        public Builder clearChannelRange() {
            copyOnWrite();
            ((RadioProperties) this.instance).clearChannelRange();
            return this;
        }

        public Builder clearChannelSpacing() {
            copyOnWrite();
            ((RadioProperties) this.instance).clearChannelSpacing();
            return this;
        }

        public Builder clearChannelSpacings() {
            copyOnWrite();
            ((RadioProperties) this.instance).clearChannelSpacings();
            return this;
        }

        public Builder clearMuteCapability() {
            copyOnWrite();
            ((RadioProperties) this.instance).clearMuteCapability();
            return this;
        }

        public Builder clearRadioId() {
            copyOnWrite();
            ((RadioProperties) this.instance).clearRadioId();
            return this;
        }

        public Builder clearRds() {
            copyOnWrite();
            ((RadioProperties) this.instance).clearRds();
            return this;
        }

        public Builder clearRegion() {
            copyOnWrite();
            ((RadioProperties) this.instance).clearRegion();
            return this;
        }

        public Builder clearStationPresetsAccess() {
            copyOnWrite();
            ((RadioProperties) this.instance).clearStationPresetsAccess();
            return this;
        }

        public Builder clearTa() {
            copyOnWrite();
            ((RadioProperties) this.instance).clearTa();
            return this;
        }

        public Builder clearTrafficService() {
            copyOnWrite();
            ((RadioProperties) this.instance).clearTrafficService();
            return this;
        }

        public Builder clearType() {
            copyOnWrite();
            ((RadioProperties) this.instance).clearType();
            return this;
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public boolean getAfSwitch() {
            return ((RadioProperties) this.instance).getAfSwitch();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public boolean getAudioLoopback() {
            return ((RadioProperties) this.instance).getAudioLoopback();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public boolean getBackgroundTuner() {
            return ((RadioProperties) this.instance).getBackgroundTuner();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public Range getChannelRange(int i) {
            return ((RadioProperties) this.instance).getChannelRange(i);
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public int getChannelRangeCount() {
            return ((RadioProperties) this.instance).getChannelRangeCount();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public List<Range> getChannelRangeList() {
            return Collections.unmodifiableList(((RadioProperties) this.instance).getChannelRangeList());
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public int getChannelSpacing() {
            return ((RadioProperties) this.instance).getChannelSpacing();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public int getChannelSpacings(int i) {
            return ((RadioProperties) this.instance).getChannelSpacings(i);
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public int getChannelSpacingsCount() {
            return ((RadioProperties) this.instance).getChannelSpacingsCount();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public List<Integer> getChannelSpacingsList() {
            return Collections.unmodifiableList(((RadioProperties) this.instance).getChannelSpacingsList());
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public boolean getMuteCapability() {
            return ((RadioProperties) this.instance).getMuteCapability();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public int getRadioId() {
            return ((RadioProperties) this.instance).getRadioId();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public RdsType getRds() {
            return ((RadioProperties) this.instance).getRds();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public ItuRegion getRegion() {
            return ((RadioProperties) this.instance).getRegion();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public int getStationPresetsAccess() {
            return ((RadioProperties) this.instance).getStationPresetsAccess();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public boolean getTa() {
            return ((RadioProperties) this.instance).getTa();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public TrafficServiceType getTrafficService() {
            return ((RadioProperties) this.instance).getTrafficService();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public RadioType getType() {
            return ((RadioProperties) this.instance).getType();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public boolean hasAfSwitch() {
            return ((RadioProperties) this.instance).hasAfSwitch();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public boolean hasAudioLoopback() {
            return ((RadioProperties) this.instance).hasAudioLoopback();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public boolean hasBackgroundTuner() {
            return ((RadioProperties) this.instance).hasBackgroundTuner();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public boolean hasChannelSpacing() {
            return ((RadioProperties) this.instance).hasChannelSpacing();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public boolean hasMuteCapability() {
            return ((RadioProperties) this.instance).hasMuteCapability();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public boolean hasRadioId() {
            return ((RadioProperties) this.instance).hasRadioId();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public boolean hasRds() {
            return ((RadioProperties) this.instance).hasRds();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public boolean hasRegion() {
            return ((RadioProperties) this.instance).hasRegion();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public boolean hasStationPresetsAccess() {
            return ((RadioProperties) this.instance).hasStationPresetsAccess();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public boolean hasTa() {
            return ((RadioProperties) this.instance).hasTa();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public boolean hasTrafficService() {
            return ((RadioProperties) this.instance).hasTrafficService();
        }

        @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
        public boolean hasType() {
            return ((RadioProperties) this.instance).hasType();
        }

        public Builder removeChannelRange(int i) {
            copyOnWrite();
            ((RadioProperties) this.instance).removeChannelRange(i);
            return this;
        }

        public Builder setAfSwitch(boolean z6) {
            copyOnWrite();
            ((RadioProperties) this.instance).setAfSwitch(z6);
            return this;
        }

        public Builder setAudioLoopback(boolean z6) {
            copyOnWrite();
            ((RadioProperties) this.instance).setAudioLoopback(z6);
            return this;
        }

        public Builder setBackgroundTuner(boolean z6) {
            copyOnWrite();
            ((RadioProperties) this.instance).setBackgroundTuner(z6);
            return this;
        }

        public Builder setChannelRange(int i, Range range) {
            copyOnWrite();
            ((RadioProperties) this.instance).setChannelRange(i, range);
            return this;
        }

        public Builder setChannelSpacing(int i) {
            copyOnWrite();
            ((RadioProperties) this.instance).setChannelSpacing(i);
            return this;
        }

        public Builder setChannelSpacings(int i, int i3) {
            copyOnWrite();
            ((RadioProperties) this.instance).setChannelSpacings(i, i3);
            return this;
        }

        public Builder setMuteCapability(boolean z6) {
            copyOnWrite();
            ((RadioProperties) this.instance).setMuteCapability(z6);
            return this;
        }

        public Builder setRadioId(int i) {
            copyOnWrite();
            ((RadioProperties) this.instance).setRadioId(i);
            return this;
        }

        public Builder setRds(RdsType rdsType) {
            copyOnWrite();
            ((RadioProperties) this.instance).setRds(rdsType);
            return this;
        }

        public Builder setRegion(ItuRegion ituRegion) {
            copyOnWrite();
            ((RadioProperties) this.instance).setRegion(ituRegion);
            return this;
        }

        public Builder setStationPresetsAccess(int i) {
            copyOnWrite();
            ((RadioProperties) this.instance).setStationPresetsAccess(i);
            return this;
        }

        public Builder setTa(boolean z6) {
            copyOnWrite();
            ((RadioProperties) this.instance).setTa(z6);
            return this;
        }

        public Builder setTrafficService(TrafficServiceType trafficServiceType) {
            copyOnWrite();
            ((RadioProperties) this.instance).setTrafficService(trafficServiceType);
            return this;
        }

        public Builder setType(RadioType radioType) {
            copyOnWrite();
            ((RadioProperties) this.instance).setType(radioType);
            return this;
        }

        private Builder() {
            super(RadioProperties.DEFAULT_INSTANCE);
        }

        public Builder addChannelRange(int i, Range range) {
            copyOnWrite();
            ((RadioProperties) this.instance).addChannelRange(i, range);
            return this;
        }

        public Builder setChannelRange(int i, Range.Builder builder) {
            copyOnWrite();
            ((RadioProperties) this.instance).setChannelRange(i, builder);
            return this;
        }

        public Builder addChannelRange(Range.Builder builder) {
            copyOnWrite();
            ((RadioProperties) this.instance).addChannelRange(builder);
            return this;
        }

        public Builder addChannelRange(int i, Range.Builder builder) {
            copyOnWrite();
            ((RadioProperties) this.instance).addChannelRange(i, builder);
            return this;
        }
    }

    static {
        RadioProperties radioProperties = new RadioProperties();
        DEFAULT_INSTANCE = radioProperties;
        GeneratedMessageLite.registerDefaultInstance(RadioProperties.class, radioProperties);
    }

    private RadioProperties() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllChannelRange(Iterable<? extends Range> iterable) {
        ensureChannelRangeIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.channelRange_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllChannelSpacings(Iterable<? extends Integer> iterable) {
        ensureChannelSpacingsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.channelSpacings_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addChannelRange(Range range) {
        range.getClass();
        ensureChannelRangeIsMutable();
        this.channelRange_.add(range);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addChannelSpacings(int i) {
        ensureChannelSpacingsIsMutable();
        this.channelSpacings_.addInt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAfSwitch() {
        this.bitField0_ &= -65;
        this.afSwitch_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudioLoopback() {
        this.bitField0_ &= -513;
        this.audioLoopback_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBackgroundTuner() {
        this.bitField0_ &= -9;
        this.backgroundTuner_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChannelRange() {
        this.channelRange_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChannelSpacing() {
        this.bitField0_ &= -5;
        this.channelSpacing_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChannelSpacings() {
        this.channelSpacings_ = GeneratedMessageLite.emptyIntList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMuteCapability() {
        this.bitField0_ &= -1025;
        this.muteCapability_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioId() {
        this.bitField0_ &= -2;
        this.radioId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRds() {
        this.bitField0_ &= -33;
        this.rds_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegion() {
        this.bitField0_ &= -17;
        this.region_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStationPresetsAccess() {
        this.bitField0_ &= -2049;
        this.stationPresetsAccess_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTa() {
        this.bitField0_ &= -129;
        this.ta_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrafficService() {
        this.bitField0_ &= -257;
        this.trafficService_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.bitField0_ &= -3;
        this.type_ = 0;
    }

    private void ensureChannelRangeIsMutable() {
        if (this.channelRange_.isModifiable()) {
            return;
        }
        this.channelRange_ = GeneratedMessageLite.mutableCopy(this.channelRange_);
    }

    private void ensureChannelSpacingsIsMutable() {
        if (this.channelSpacings_.isModifiable()) {
            return;
        }
        this.channelSpacings_ = GeneratedMessageLite.mutableCopy(this.channelSpacings_);
    }

    public static RadioProperties getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static RadioProperties parseDelimitedFrom(InputStream inputStream) {
        return (RadioProperties) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RadioProperties parseFrom(ByteBuffer byteBuffer) {
        return (RadioProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<RadioProperties> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeChannelRange(int i) {
        ensureChannelRangeIsMutable();
        this.channelRange_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAfSwitch(boolean z6) {
        this.bitField0_ |= 64;
        this.afSwitch_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioLoopback(boolean z6) {
        this.bitField0_ |= 512;
        this.audioLoopback_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackgroundTuner(boolean z6) {
        this.bitField0_ |= 8;
        this.backgroundTuner_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChannelRange(int i, Range range) {
        range.getClass();
        ensureChannelRangeIsMutable();
        this.channelRange_.set(i, range);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChannelSpacing(int i) {
        this.bitField0_ |= 4;
        this.channelSpacing_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChannelSpacings(int i, int i3) {
        ensureChannelSpacingsIsMutable();
        this.channelSpacings_.setInt(i, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMuteCapability(boolean z6) {
        this.bitField0_ |= 1024;
        this.muteCapability_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioId(int i) {
        this.bitField0_ |= 1;
        this.radioId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRds(RdsType rdsType) {
        rdsType.getClass();
        this.bitField0_ |= 32;
        this.rds_ = rdsType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegion(ItuRegion ituRegion) {
        ituRegion.getClass();
        this.bitField0_ |= 16;
        this.region_ = ituRegion.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStationPresetsAccess(int i) {
        this.bitField0_ |= 2048;
        this.stationPresetsAccess_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTa(boolean z6) {
        this.bitField0_ |= 128;
        this.ta_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrafficService(TrafficServiceType trafficServiceType) {
        trafficServiceType.getClass();
        this.bitField0_ |= 256;
        this.trafficService_ = trafficServiceType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(RadioType radioType) {
        radioType.getClass();
        this.bitField0_ |= 2;
        this.type_ = radioType.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RadioProperties();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0002\u0004\u0001Ԅ\u0000\u0002Ԍ\u0001\u0003Л\u0004\u0016\u0005Ԅ\u0002\u0006\u0007\u0003\u0007\f\u0004\b\f\u0005\t\u0007\u0006\n\u0007\u0007\u000b\f\b\f\u0007\t\r\u0007\n\u000e\u0004\u000b", new Object[]{"bitField0_", "radioId_", "type_", RadioType.internalGetVerifier(), "channelRange_", Range.class, "channelSpacings_", "channelSpacing_", "backgroundTuner_", "region_", ItuRegion.internalGetVerifier(), "rds_", RdsType.internalGetVerifier(), "afSwitch_", "ta_", "trafficService_", TrafficServiceType.internalGetVerifier(), "audioLoopback_", "muteCapability_", "stationPresetsAccess_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RadioProperties> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (RadioProperties.class) {
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

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public boolean getAfSwitch() {
        return this.afSwitch_;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public boolean getAudioLoopback() {
        return this.audioLoopback_;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public boolean getBackgroundTuner() {
        return this.backgroundTuner_;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public Range getChannelRange(int i) {
        return this.channelRange_.get(i);
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public int getChannelRangeCount() {
        return this.channelRange_.size();
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public List<Range> getChannelRangeList() {
        return this.channelRange_;
    }

    public RangeOrBuilder getChannelRangeOrBuilder(int i) {
        return this.channelRange_.get(i);
    }

    public List<? extends RangeOrBuilder> getChannelRangeOrBuilderList() {
        return this.channelRange_;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public int getChannelSpacing() {
        return this.channelSpacing_;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public int getChannelSpacings(int i) {
        return this.channelSpacings_.getInt(i);
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public int getChannelSpacingsCount() {
        return this.channelSpacings_.size();
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public List<Integer> getChannelSpacingsList() {
        return this.channelSpacings_;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public boolean getMuteCapability() {
        return this.muteCapability_;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public int getRadioId() {
        return this.radioId_;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public RdsType getRds() {
        RdsType rdsTypeForNumber = RdsType.forNumber(this.rds_);
        return rdsTypeForNumber == null ? RdsType.NO_RDS : rdsTypeForNumber;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public ItuRegion getRegion() {
        ItuRegion ituRegionForNumber = ItuRegion.forNumber(this.region_);
        return ituRegionForNumber == null ? ItuRegion.RADIO_REGION_NONE : ituRegionForNumber;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public int getStationPresetsAccess() {
        return this.stationPresetsAccess_;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public boolean getTa() {
        return this.ta_;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public TrafficServiceType getTrafficService() {
        TrafficServiceType trafficServiceTypeForNumber = TrafficServiceType.forNumber(this.trafficService_);
        return trafficServiceTypeForNumber == null ? TrafficServiceType.NO_TRAFFIC_SERVICE : trafficServiceTypeForNumber;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public RadioType getType() {
        RadioType radioTypeForNumber = RadioType.forNumber(this.type_);
        return radioTypeForNumber == null ? RadioType.AM_RADIO : radioTypeForNumber;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public boolean hasAfSwitch() {
        return (this.bitField0_ & 64) != 0;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public boolean hasAudioLoopback() {
        return (this.bitField0_ & 512) != 0;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public boolean hasBackgroundTuner() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public boolean hasChannelSpacing() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public boolean hasMuteCapability() {
        return (this.bitField0_ & 1024) != 0;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public boolean hasRadioId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public boolean hasRds() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public boolean hasRegion() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public boolean hasStationPresetsAccess() {
        return (this.bitField0_ & 2048) != 0;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public boolean hasTa() {
        return (this.bitField0_ & 128) != 0;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public boolean hasTrafficService() {
        return (this.bitField0_ & 256) != 0;
    }

    @Override // fr.sd.taada.proto.RadioPropertiesOrBuilder
    public boolean hasType() {
        return (this.bitField0_ & 2) != 0;
    }

    public static Builder newBuilder(RadioProperties radioProperties) {
        return DEFAULT_INSTANCE.createBuilder(radioProperties);
    }

    public static RadioProperties parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioProperties) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RadioProperties parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RadioProperties parseFrom(ByteString byteString) {
        return (RadioProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addChannelRange(int i, Range range) {
        range.getClass();
        ensureChannelRangeIsMutable();
        this.channelRange_.add(i, range);
    }

    public static RadioProperties parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChannelRange(int i, Range.Builder builder) {
        ensureChannelRangeIsMutable();
        this.channelRange_.set(i, builder.build());
    }

    public static RadioProperties parseFrom(byte[] bArr) {
        return (RadioProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RadioProperties parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addChannelRange(Range.Builder builder) {
        ensureChannelRangeIsMutable();
        this.channelRange_.add(builder.build());
    }

    public static RadioProperties parseFrom(InputStream inputStream) {
        return (RadioProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RadioProperties parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addChannelRange(int i, Range.Builder builder) {
        ensureChannelRangeIsMutable();
        this.channelRange_.add(i, builder.build());
    }

    public static RadioProperties parseFrom(CodedInputStream codedInputStream) {
        return (RadioProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RadioProperties parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RadioProperties) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
