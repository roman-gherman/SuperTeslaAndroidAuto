package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.RadioStationInfo;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class GetProgramListResponse extends GeneratedMessageLite<GetProgramListResponse, Builder> implements GetProgramListResponseOrBuilder {
    public static final int COMPLETED_FIELD_NUMBER = 3;
    private static final GetProgramListResponse DEFAULT_INSTANCE;
    private static volatile Parser<GetProgramListResponse> PARSER = null;
    public static final int PROGRAM_LIST_FIELD_NUMBER = 4;
    public static final int RADIO_ID_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean completed_;
    private int radioId_;
    private byte memoizedIsInitialized = 2;
    private int status_ = 1;
    private Internal.ProtobufList<RadioStationInfo> programList_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.GetProgramListResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GetProgramListResponse, Builder> implements GetProgramListResponseOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllProgramList(Iterable<? extends RadioStationInfo> iterable) {
            copyOnWrite();
            ((GetProgramListResponse) this.instance).addAllProgramList(iterable);
            return this;
        }

        public Builder addProgramList(RadioStationInfo radioStationInfo) {
            copyOnWrite();
            ((GetProgramListResponse) this.instance).addProgramList(radioStationInfo);
            return this;
        }

        public Builder clearCompleted() {
            copyOnWrite();
            ((GetProgramListResponse) this.instance).clearCompleted();
            return this;
        }

        public Builder clearProgramList() {
            copyOnWrite();
            ((GetProgramListResponse) this.instance).clearProgramList();
            return this;
        }

        public Builder clearRadioId() {
            copyOnWrite();
            ((GetProgramListResponse) this.instance).clearRadioId();
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((GetProgramListResponse) this.instance).clearStatus();
            return this;
        }

        @Override // fr.sd.taada.proto.GetProgramListResponseOrBuilder
        public boolean getCompleted() {
            return ((GetProgramListResponse) this.instance).getCompleted();
        }

        @Override // fr.sd.taada.proto.GetProgramListResponseOrBuilder
        public RadioStationInfo getProgramList(int i) {
            return ((GetProgramListResponse) this.instance).getProgramList(i);
        }

        @Override // fr.sd.taada.proto.GetProgramListResponseOrBuilder
        public int getProgramListCount() {
            return ((GetProgramListResponse) this.instance).getProgramListCount();
        }

        @Override // fr.sd.taada.proto.GetProgramListResponseOrBuilder
        public List<RadioStationInfo> getProgramListList() {
            return Collections.unmodifiableList(((GetProgramListResponse) this.instance).getProgramListList());
        }

        @Override // fr.sd.taada.proto.GetProgramListResponseOrBuilder
        public int getRadioId() {
            return ((GetProgramListResponse) this.instance).getRadioId();
        }

        @Override // fr.sd.taada.proto.GetProgramListResponseOrBuilder
        public MessageStatus getStatus() {
            return ((GetProgramListResponse) this.instance).getStatus();
        }

        @Override // fr.sd.taada.proto.GetProgramListResponseOrBuilder
        public boolean hasCompleted() {
            return ((GetProgramListResponse) this.instance).hasCompleted();
        }

        @Override // fr.sd.taada.proto.GetProgramListResponseOrBuilder
        public boolean hasRadioId() {
            return ((GetProgramListResponse) this.instance).hasRadioId();
        }

        @Override // fr.sd.taada.proto.GetProgramListResponseOrBuilder
        public boolean hasStatus() {
            return ((GetProgramListResponse) this.instance).hasStatus();
        }

        public Builder removeProgramList(int i) {
            copyOnWrite();
            ((GetProgramListResponse) this.instance).removeProgramList(i);
            return this;
        }

        public Builder setCompleted(boolean z6) {
            copyOnWrite();
            ((GetProgramListResponse) this.instance).setCompleted(z6);
            return this;
        }

        public Builder setProgramList(int i, RadioStationInfo radioStationInfo) {
            copyOnWrite();
            ((GetProgramListResponse) this.instance).setProgramList(i, radioStationInfo);
            return this;
        }

        public Builder setRadioId(int i) {
            copyOnWrite();
            ((GetProgramListResponse) this.instance).setRadioId(i);
            return this;
        }

        public Builder setStatus(MessageStatus messageStatus) {
            copyOnWrite();
            ((GetProgramListResponse) this.instance).setStatus(messageStatus);
            return this;
        }

        private Builder() {
            super(GetProgramListResponse.DEFAULT_INSTANCE);
        }

        public Builder addProgramList(int i, RadioStationInfo radioStationInfo) {
            copyOnWrite();
            ((GetProgramListResponse) this.instance).addProgramList(i, radioStationInfo);
            return this;
        }

        public Builder setProgramList(int i, RadioStationInfo.Builder builder) {
            copyOnWrite();
            ((GetProgramListResponse) this.instance).setProgramList(i, builder);
            return this;
        }

        public Builder addProgramList(RadioStationInfo.Builder builder) {
            copyOnWrite();
            ((GetProgramListResponse) this.instance).addProgramList(builder);
            return this;
        }

        public Builder addProgramList(int i, RadioStationInfo.Builder builder) {
            copyOnWrite();
            ((GetProgramListResponse) this.instance).addProgramList(i, builder);
            return this;
        }
    }

    static {
        GetProgramListResponse getProgramListResponse = new GetProgramListResponse();
        DEFAULT_INSTANCE = getProgramListResponse;
        GeneratedMessageLite.registerDefaultInstance(GetProgramListResponse.class, getProgramListResponse);
    }

    private GetProgramListResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllProgramList(Iterable<? extends RadioStationInfo> iterable) {
        ensureProgramListIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.programList_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProgramList(RadioStationInfo radioStationInfo) {
        radioStationInfo.getClass();
        ensureProgramListIsMutable();
        this.programList_.add(radioStationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCompleted() {
        this.bitField0_ &= -5;
        this.completed_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProgramList() {
        this.programList_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRadioId() {
        this.bitField0_ &= -3;
        this.radioId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.bitField0_ &= -2;
        this.status_ = 1;
    }

    private void ensureProgramListIsMutable() {
        if (this.programList_.isModifiable()) {
            return;
        }
        this.programList_ = GeneratedMessageLite.mutableCopy(this.programList_);
    }

    public static GetProgramListResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GetProgramListResponse parseDelimitedFrom(InputStream inputStream) {
        return (GetProgramListResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GetProgramListResponse parseFrom(ByteBuffer byteBuffer) {
        return (GetProgramListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GetProgramListResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeProgramList(int i) {
        ensureProgramListIsMutable();
        this.programList_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCompleted(boolean z6) {
        this.bitField0_ |= 4;
        this.completed_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgramList(int i, RadioStationInfo radioStationInfo) {
        radioStationInfo.getClass();
        ensureProgramListIsMutable();
        this.programList_.set(i, radioStationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRadioId(int i) {
        this.bitField0_ |= 2;
        this.radioId_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(MessageStatus messageStatus) {
        messageStatus.getClass();
        this.bitField0_ |= 1;
        this.status_ = messageStatus.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GetProgramListResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0004\u0001Ԍ\u0000\u0002Ԅ\u0001\u0003ԇ\u0002\u0004Л", new Object[]{"bitField0_", "status_", MessageStatus.internalGetVerifier(), "radioId_", "completed_", "programList_", RadioStationInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GetProgramListResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GetProgramListResponse.class) {
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

    @Override // fr.sd.taada.proto.GetProgramListResponseOrBuilder
    public boolean getCompleted() {
        return this.completed_;
    }

    @Override // fr.sd.taada.proto.GetProgramListResponseOrBuilder
    public RadioStationInfo getProgramList(int i) {
        return this.programList_.get(i);
    }

    @Override // fr.sd.taada.proto.GetProgramListResponseOrBuilder
    public int getProgramListCount() {
        return this.programList_.size();
    }

    @Override // fr.sd.taada.proto.GetProgramListResponseOrBuilder
    public List<RadioStationInfo> getProgramListList() {
        return this.programList_;
    }

    public RadioStationInfoOrBuilder getProgramListOrBuilder(int i) {
        return this.programList_.get(i);
    }

    public List<? extends RadioStationInfoOrBuilder> getProgramListOrBuilderList() {
        return this.programList_;
    }

    @Override // fr.sd.taada.proto.GetProgramListResponseOrBuilder
    public int getRadioId() {
        return this.radioId_;
    }

    @Override // fr.sd.taada.proto.GetProgramListResponseOrBuilder
    public MessageStatus getStatus() {
        MessageStatus messageStatusForNumber = MessageStatus.forNumber(this.status_);
        return messageStatusForNumber == null ? MessageStatus.STATUS_UNSOLICITED_MESSAGE : messageStatusForNumber;
    }

    @Override // fr.sd.taada.proto.GetProgramListResponseOrBuilder
    public boolean hasCompleted() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.GetProgramListResponseOrBuilder
    public boolean hasRadioId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.GetProgramListResponseOrBuilder
    public boolean hasStatus() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(GetProgramListResponse getProgramListResponse) {
        return DEFAULT_INSTANCE.createBuilder(getProgramListResponse);
    }

    public static GetProgramListResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GetProgramListResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GetProgramListResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GetProgramListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GetProgramListResponse parseFrom(ByteString byteString) {
        return (GetProgramListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProgramList(int i, RadioStationInfo radioStationInfo) {
        radioStationInfo.getClass();
        ensureProgramListIsMutable();
        this.programList_.add(i, radioStationInfo);
    }

    public static GetProgramListResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GetProgramListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgramList(int i, RadioStationInfo.Builder builder) {
        ensureProgramListIsMutable();
        this.programList_.set(i, builder.build());
    }

    public static GetProgramListResponse parseFrom(byte[] bArr) {
        return (GetProgramListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GetProgramListResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GetProgramListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProgramList(RadioStationInfo.Builder builder) {
        ensureProgramListIsMutable();
        this.programList_.add(builder.build());
    }

    public static GetProgramListResponse parseFrom(InputStream inputStream) {
        return (GetProgramListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GetProgramListResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GetProgramListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProgramList(int i, RadioStationInfo.Builder builder) {
        ensureProgramListIsMutable();
        this.programList_.add(i, builder.build());
    }

    public static GetProgramListResponse parseFrom(CodedInputStream codedInputStream) {
        return (GetProgramListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GetProgramListResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GetProgramListResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
