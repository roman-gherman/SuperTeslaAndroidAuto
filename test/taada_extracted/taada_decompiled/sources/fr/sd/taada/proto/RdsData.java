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
public final class RdsData extends GeneratedMessageLite<RdsData, Builder> implements RdsDataOrBuilder {
    public static final int ALTERNATIVE_FREQUENCIES_FIELD_NUMBER = 1;
    private static final RdsData DEFAULT_INSTANCE;
    public static final int MUSIC_SPEECH_SWITCH_FIELD_NUMBER = 3;
    private static volatile Parser<RdsData> PARSER = null;
    public static final int PROGRAM_ID_FIELD_NUMBER = 2;
    public static final int PROGRAM_SERVICE_NAME_FIELD_NUMBER = 4;
    public static final int PROGRAM_TYPE_FIELD_NUMBER = 5;
    public static final int PROGRAM_TYPE_NAME_FIELD_NUMBER = 6;
    public static final int RADIO_TEXT_FIELD_NUMBER = 7;
    public static final int TRAFFIC_ANNOUNCEMENT_FLAG_FIELD_NUMBER = 9;
    public static final int TRAFFIC_PROGRAM_FLAG_FIELD_NUMBER = 8;
    private int bitField0_;
    private int musicSpeechSwitch_;
    private int programId_;
    private int programType_;
    private boolean trafficAnnouncementFlag_;
    private boolean trafficProgramFlag_;
    private Internal.IntList alternativeFrequencies_ = GeneratedMessageLite.emptyIntList();
    private String programServiceName_ = "";
    private String programTypeName_ = "";
    private String radioText_ = "";

    /* JADX INFO: renamed from: fr.sd.taada.proto.RdsData$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<RdsData, Builder> implements RdsDataOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllAlternativeFrequencies(Iterable<? extends Integer> iterable) {
            copyOnWrite();
            ((RdsData) this.instance).addAllAlternativeFrequencies(iterable);
            return this;
        }

        public Builder addAlternativeFrequencies(int i) {
            copyOnWrite();
            ((RdsData) this.instance).addAlternativeFrequencies(i);
            return this;
        }

        public Builder clearAlternativeFrequencies() {
            copyOnWrite();
            ((RdsData) this.instance).clearAlternativeFrequencies();
            return this;
        }

        public Builder clearMusicSpeechSwitch() {
            copyOnWrite();
            ((RdsData) this.instance).clearMusicSpeechSwitch();
            return this;
        }

        public Builder clearProgramId() {
            copyOnWrite();
            ((RdsData) this.instance).clearProgramId();
            return this;
        }

        public Builder clearProgramServiceName() {
            copyOnWrite();
            ((RdsData) this.instance).clearProgramServiceName();
            return this;
        }

        public Builder clearProgramType() {
            copyOnWrite();
            ((RdsData) this.instance).clearProgramType();
            return this;
        }

        public Builder clearProgramTypeName() {
            copyOnWrite();
            ((RdsData) this.instance).clearProgramTypeName();
            return this;
        }

        public Builder clearRadioText() {
            copyOnWrite();
            ((RdsData) this.instance).clearRadioText();
            return this;
        }

        public Builder clearTrafficAnnouncementFlag() {
            copyOnWrite();
            ((RdsData) this.instance).clearTrafficAnnouncementFlag();
            return this;
        }

        public Builder clearTrafficProgramFlag() {
            copyOnWrite();
            ((RdsData) this.instance).clearTrafficProgramFlag();
            return this;
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public int getAlternativeFrequencies(int i) {
            return ((RdsData) this.instance).getAlternativeFrequencies(i);
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public int getAlternativeFrequenciesCount() {
            return ((RdsData) this.instance).getAlternativeFrequenciesCount();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public List<Integer> getAlternativeFrequenciesList() {
            return Collections.unmodifiableList(((RdsData) this.instance).getAlternativeFrequenciesList());
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public int getMusicSpeechSwitch() {
            return ((RdsData) this.instance).getMusicSpeechSwitch();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public int getProgramId() {
            return ((RdsData) this.instance).getProgramId();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public String getProgramServiceName() {
            return ((RdsData) this.instance).getProgramServiceName();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public ByteString getProgramServiceNameBytes() {
            return ((RdsData) this.instance).getProgramServiceNameBytes();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public int getProgramType() {
            return ((RdsData) this.instance).getProgramType();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public String getProgramTypeName() {
            return ((RdsData) this.instance).getProgramTypeName();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public ByteString getProgramTypeNameBytes() {
            return ((RdsData) this.instance).getProgramTypeNameBytes();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public String getRadioText() {
            return ((RdsData) this.instance).getRadioText();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public ByteString getRadioTextBytes() {
            return ((RdsData) this.instance).getRadioTextBytes();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public boolean getTrafficAnnouncementFlag() {
            return ((RdsData) this.instance).getTrafficAnnouncementFlag();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public boolean getTrafficProgramFlag() {
            return ((RdsData) this.instance).getTrafficProgramFlag();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public boolean hasMusicSpeechSwitch() {
            return ((RdsData) this.instance).hasMusicSpeechSwitch();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public boolean hasProgramId() {
            return ((RdsData) this.instance).hasProgramId();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public boolean hasProgramServiceName() {
            return ((RdsData) this.instance).hasProgramServiceName();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public boolean hasProgramType() {
            return ((RdsData) this.instance).hasProgramType();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public boolean hasProgramTypeName() {
            return ((RdsData) this.instance).hasProgramTypeName();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public boolean hasRadioText() {
            return ((RdsData) this.instance).hasRadioText();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public boolean hasTrafficAnnouncementFlag() {
            return ((RdsData) this.instance).hasTrafficAnnouncementFlag();
        }

        @Override // fr.sd.taada.proto.RdsDataOrBuilder
        public boolean hasTrafficProgramFlag() {
            return ((RdsData) this.instance).hasTrafficProgramFlag();
        }

        public Builder setAlternativeFrequencies(int i, int i3) {
            copyOnWrite();
            ((RdsData) this.instance).setAlternativeFrequencies(i, i3);
            return this;
        }

        public Builder setMusicSpeechSwitch(int i) {
            copyOnWrite();
            ((RdsData) this.instance).setMusicSpeechSwitch(i);
            return this;
        }

        public Builder setProgramId(int i) {
            copyOnWrite();
            ((RdsData) this.instance).setProgramId(i);
            return this;
        }

        public Builder setProgramServiceName(String str) {
            copyOnWrite();
            ((RdsData) this.instance).setProgramServiceName(str);
            return this;
        }

        public Builder setProgramServiceNameBytes(ByteString byteString) {
            copyOnWrite();
            ((RdsData) this.instance).setProgramServiceNameBytes(byteString);
            return this;
        }

        public Builder setProgramType(int i) {
            copyOnWrite();
            ((RdsData) this.instance).setProgramType(i);
            return this;
        }

        public Builder setProgramTypeName(String str) {
            copyOnWrite();
            ((RdsData) this.instance).setProgramTypeName(str);
            return this;
        }

        public Builder setProgramTypeNameBytes(ByteString byteString) {
            copyOnWrite();
            ((RdsData) this.instance).setProgramTypeNameBytes(byteString);
            return this;
        }

        public Builder setRadioText(String str) {
            copyOnWrite();
            ((RdsData) this.instance).setRadioText(str);
            return this;
        }

        public Builder setRadioTextBytes(ByteString byteString) {
            copyOnWrite();
            ((RdsData) this.instance).setRadioTextBytes(byteString);
            return this;
        }

        public Builder setTrafficAnnouncementFlag(boolean z6) {
            copyOnWrite();
            ((RdsData) this.instance).setTrafficAnnouncementFlag(z6);
            return this;
        }

        public Builder setTrafficProgramFlag(boolean z6) {
            copyOnWrite();
            ((RdsData) this.instance).setTrafficProgramFlag(z6);
            return this;
        }

        private Builder() {
            super(RdsData.DEFAULT_INSTANCE);
        }
    }

    static {
        RdsData rdsData = new RdsData();
        DEFAULT_INSTANCE = rdsData;
        GeneratedMessageLite.registerDefaultInstance(RdsData.class, rdsData);
    }

    private RdsData() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAlternativeFrequencies(Iterable<? extends Integer> iterable) {
        ensureAlternativeFrequenciesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.alternativeFrequencies_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAlternativeFrequencies(int i) {
        ensureAlternativeFrequenciesIsMutable();
        this.alternativeFrequencies_.addInt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlternativeFrequencies() {
        this.alternativeFrequencies_ = GeneratedMessageLite.emptyIntList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMusicSpeechSwitch() {
        this.bitField0_ &= -3;
        this.musicSpeechSwitch_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProgramId() {
        this.bitField0_ &= -2;
        this.programId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProgramServiceName() {
        this.bitField0_ &= -5;
        this.programServiceName_ = getDefaultInstance().getProgramServiceName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProgramType() {
        this.bitField0_ &= -9;
        this.programType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProgramTypeName() {
        this.bitField0_ &= -17;
        this.programTypeName_ = getDefaultInstance().getProgramTypeName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioText() {
        this.bitField0_ &= -33;
        this.radioText_ = getDefaultInstance().getRadioText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrafficAnnouncementFlag() {
        this.bitField0_ &= -129;
        this.trafficAnnouncementFlag_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTrafficProgramFlag() {
        this.bitField0_ &= -65;
        this.trafficProgramFlag_ = false;
    }

    private void ensureAlternativeFrequenciesIsMutable() {
        if (this.alternativeFrequencies_.isModifiable()) {
            return;
        }
        this.alternativeFrequencies_ = GeneratedMessageLite.mutableCopy(this.alternativeFrequencies_);
    }

    public static RdsData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static RdsData parseDelimitedFrom(InputStream inputStream) {
        return (RdsData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RdsData parseFrom(ByteBuffer byteBuffer) {
        return (RdsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<RdsData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlternativeFrequencies(int i, int i3) {
        ensureAlternativeFrequenciesIsMutable();
        this.alternativeFrequencies_.setInt(i, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMusicSpeechSwitch(int i) {
        this.bitField0_ |= 2;
        this.musicSpeechSwitch_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgramId(int i) {
        this.bitField0_ |= 1;
        this.programId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgramServiceName(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.programServiceName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgramServiceNameBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 4;
        this.programServiceName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgramType(int i) {
        this.bitField0_ |= 8;
        this.programType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgramTypeName(String str) {
        str.getClass();
        this.bitField0_ |= 16;
        this.programTypeName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgramTypeNameBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 16;
        this.programTypeName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioText(String str) {
        str.getClass();
        this.bitField0_ |= 32;
        this.radioText_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioTextBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 32;
        this.radioText_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrafficAnnouncementFlag(boolean z6) {
        this.bitField0_ |= 128;
        this.trafficAnnouncementFlag_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrafficProgramFlag(boolean z6) {
        this.bitField0_ |= 64;
        this.trafficProgramFlag_ = z6;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RdsData();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001\u0016\u0002\u0004\u0000\u0003\u0004\u0001\u0004\b\u0002\u0005\u0004\u0003\u0006\b\u0004\u0007\b\u0005\b\u0007\u0006\t\u0007\u0007", new Object[]{"bitField0_", "alternativeFrequencies_", "programId_", "musicSpeechSwitch_", "programServiceName_", "programType_", "programTypeName_", "radioText_", "trafficProgramFlag_", "trafficAnnouncementFlag_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RdsData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (RdsData.class) {
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

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public int getAlternativeFrequencies(int i) {
        return this.alternativeFrequencies_.getInt(i);
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public int getAlternativeFrequenciesCount() {
        return this.alternativeFrequencies_.size();
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public List<Integer> getAlternativeFrequenciesList() {
        return this.alternativeFrequencies_;
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public int getMusicSpeechSwitch() {
        return this.musicSpeechSwitch_;
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public int getProgramId() {
        return this.programId_;
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public String getProgramServiceName() {
        return this.programServiceName_;
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public ByteString getProgramServiceNameBytes() {
        return ByteString.copyFromUtf8(this.programServiceName_);
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public int getProgramType() {
        return this.programType_;
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public String getProgramTypeName() {
        return this.programTypeName_;
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public ByteString getProgramTypeNameBytes() {
        return ByteString.copyFromUtf8(this.programTypeName_);
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public String getRadioText() {
        return this.radioText_;
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public ByteString getRadioTextBytes() {
        return ByteString.copyFromUtf8(this.radioText_);
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public boolean getTrafficAnnouncementFlag() {
        return this.trafficAnnouncementFlag_;
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public boolean getTrafficProgramFlag() {
        return this.trafficProgramFlag_;
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public boolean hasMusicSpeechSwitch() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public boolean hasProgramId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public boolean hasProgramServiceName() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public boolean hasProgramType() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public boolean hasProgramTypeName() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public boolean hasRadioText() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public boolean hasTrafficAnnouncementFlag() {
        return (this.bitField0_ & 128) != 0;
    }

    @Override // fr.sd.taada.proto.RdsDataOrBuilder
    public boolean hasTrafficProgramFlag() {
        return (this.bitField0_ & 64) != 0;
    }

    public static Builder newBuilder(RdsData rdsData) {
        return DEFAULT_INSTANCE.createBuilder(rdsData);
    }

    public static RdsData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RdsData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RdsData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (RdsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RdsData parseFrom(ByteString byteString) {
        return (RdsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RdsData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RdsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RdsData parseFrom(byte[] bArr) {
        return (RdsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RdsData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (RdsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RdsData parseFrom(InputStream inputStream) {
        return (RdsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RdsData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RdsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RdsData parseFrom(CodedInputStream codedInputStream) {
        return (RdsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RdsData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RdsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
