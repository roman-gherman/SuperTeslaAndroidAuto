package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.TrafficIncident;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class GetTrafficUpdateResponse extends GeneratedMessageLite<GetTrafficUpdateResponse, Builder> implements GetTrafficUpdateResponseOrBuilder {
    private static final GetTrafficUpdateResponse DEFAULT_INSTANCE;
    public static final int INCIDENTS_FIELD_NUMBER = 3;
    private static volatile Parser<GetTrafficUpdateResponse> PARSER = null;
    public static final int RADIO_ID_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int bitField0_;
    private int radioId_;
    private byte memoizedIsInitialized = 2;
    private int status_ = 1;
    private Internal.ProtobufList<TrafficIncident> incidents_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.GetTrafficUpdateResponse$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<GetTrafficUpdateResponse, Builder> implements GetTrafficUpdateResponseOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllIncidents(Iterable<? extends TrafficIncident> iterable) {
            copyOnWrite();
            ((GetTrafficUpdateResponse) this.instance).addAllIncidents(iterable);
            return this;
        }

        public Builder addIncidents(TrafficIncident trafficIncident) {
            copyOnWrite();
            ((GetTrafficUpdateResponse) this.instance).addIncidents(trafficIncident);
            return this;
        }

        public Builder clearIncidents() {
            copyOnWrite();
            ((GetTrafficUpdateResponse) this.instance).clearIncidents();
            return this;
        }

        public Builder clearRadioId() {
            copyOnWrite();
            ((GetTrafficUpdateResponse) this.instance).clearRadioId();
            return this;
        }

        public Builder clearStatus() {
            copyOnWrite();
            ((GetTrafficUpdateResponse) this.instance).clearStatus();
            return this;
        }

        @Override // fr.sd.taada.proto.GetTrafficUpdateResponseOrBuilder
        public TrafficIncident getIncidents(int i) {
            return ((GetTrafficUpdateResponse) this.instance).getIncidents(i);
        }

        @Override // fr.sd.taada.proto.GetTrafficUpdateResponseOrBuilder
        public int getIncidentsCount() {
            return ((GetTrafficUpdateResponse) this.instance).getIncidentsCount();
        }

        @Override // fr.sd.taada.proto.GetTrafficUpdateResponseOrBuilder
        public List<TrafficIncident> getIncidentsList() {
            return Collections.unmodifiableList(((GetTrafficUpdateResponse) this.instance).getIncidentsList());
        }

        @Override // fr.sd.taada.proto.GetTrafficUpdateResponseOrBuilder
        public int getRadioId() {
            return ((GetTrafficUpdateResponse) this.instance).getRadioId();
        }

        @Override // fr.sd.taada.proto.GetTrafficUpdateResponseOrBuilder
        public MessageStatus getStatus() {
            return ((GetTrafficUpdateResponse) this.instance).getStatus();
        }

        @Override // fr.sd.taada.proto.GetTrafficUpdateResponseOrBuilder
        public boolean hasRadioId() {
            return ((GetTrafficUpdateResponse) this.instance).hasRadioId();
        }

        @Override // fr.sd.taada.proto.GetTrafficUpdateResponseOrBuilder
        public boolean hasStatus() {
            return ((GetTrafficUpdateResponse) this.instance).hasStatus();
        }

        public Builder removeIncidents(int i) {
            copyOnWrite();
            ((GetTrafficUpdateResponse) this.instance).removeIncidents(i);
            return this;
        }

        public Builder setIncidents(int i, TrafficIncident trafficIncident) {
            copyOnWrite();
            ((GetTrafficUpdateResponse) this.instance).setIncidents(i, trafficIncident);
            return this;
        }

        public Builder setRadioId(int i) {
            copyOnWrite();
            ((GetTrafficUpdateResponse) this.instance).setRadioId(i);
            return this;
        }

        public Builder setStatus(MessageStatus messageStatus) {
            copyOnWrite();
            ((GetTrafficUpdateResponse) this.instance).setStatus(messageStatus);
            return this;
        }

        private Builder() {
            super(GetTrafficUpdateResponse.DEFAULT_INSTANCE);
        }

        public Builder addIncidents(int i, TrafficIncident trafficIncident) {
            copyOnWrite();
            ((GetTrafficUpdateResponse) this.instance).addIncidents(i, trafficIncident);
            return this;
        }

        public Builder setIncidents(int i, TrafficIncident.Builder builder) {
            copyOnWrite();
            ((GetTrafficUpdateResponse) this.instance).setIncidents(i, builder);
            return this;
        }

        public Builder addIncidents(TrafficIncident.Builder builder) {
            copyOnWrite();
            ((GetTrafficUpdateResponse) this.instance).addIncidents(builder);
            return this;
        }

        public Builder addIncidents(int i, TrafficIncident.Builder builder) {
            copyOnWrite();
            ((GetTrafficUpdateResponse) this.instance).addIncidents(i, builder);
            return this;
        }
    }

    static {
        GetTrafficUpdateResponse getTrafficUpdateResponse = new GetTrafficUpdateResponse();
        DEFAULT_INSTANCE = getTrafficUpdateResponse;
        GeneratedMessageLite.registerDefaultInstance(GetTrafficUpdateResponse.class, getTrafficUpdateResponse);
    }

    private GetTrafficUpdateResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllIncidents(Iterable<? extends TrafficIncident> iterable) {
        ensureIncidentsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.incidents_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addIncidents(TrafficIncident trafficIncident) {
        trafficIncident.getClass();
        ensureIncidentsIsMutable();
        this.incidents_.add(trafficIncident);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIncidents() {
        this.incidents_ = GeneratedMessageLite.emptyProtobufList();
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

    private void ensureIncidentsIsMutable() {
        if (this.incidents_.isModifiable()) {
            return;
        }
        this.incidents_ = GeneratedMessageLite.mutableCopy(this.incidents_);
    }

    public static GetTrafficUpdateResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GetTrafficUpdateResponse parseDelimitedFrom(InputStream inputStream) {
        return (GetTrafficUpdateResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GetTrafficUpdateResponse parseFrom(ByteBuffer byteBuffer) {
        return (GetTrafficUpdateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GetTrafficUpdateResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeIncidents(int i) {
        ensureIncidentsIsMutable();
        this.incidents_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIncidents(int i, TrafficIncident trafficIncident) {
        trafficIncident.getClass();
        ensureIncidentsIsMutable();
        this.incidents_.set(i, trafficIncident);
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
                return new GetTrafficUpdateResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0003\u0001Ԍ\u0000\u0002Ԅ\u0001\u0003Л", new Object[]{"bitField0_", "status_", MessageStatus.internalGetVerifier(), "radioId_", "incidents_", TrafficIncident.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GetTrafficUpdateResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GetTrafficUpdateResponse.class) {
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

    @Override // fr.sd.taada.proto.GetTrafficUpdateResponseOrBuilder
    public TrafficIncident getIncidents(int i) {
        return this.incidents_.get(i);
    }

    @Override // fr.sd.taada.proto.GetTrafficUpdateResponseOrBuilder
    public int getIncidentsCount() {
        return this.incidents_.size();
    }

    @Override // fr.sd.taada.proto.GetTrafficUpdateResponseOrBuilder
    public List<TrafficIncident> getIncidentsList() {
        return this.incidents_;
    }

    public TrafficIncidentOrBuilder getIncidentsOrBuilder(int i) {
        return this.incidents_.get(i);
    }

    public List<? extends TrafficIncidentOrBuilder> getIncidentsOrBuilderList() {
        return this.incidents_;
    }

    @Override // fr.sd.taada.proto.GetTrafficUpdateResponseOrBuilder
    public int getRadioId() {
        return this.radioId_;
    }

    @Override // fr.sd.taada.proto.GetTrafficUpdateResponseOrBuilder
    public MessageStatus getStatus() {
        MessageStatus messageStatusForNumber = MessageStatus.forNumber(this.status_);
        return messageStatusForNumber == null ? MessageStatus.STATUS_UNSOLICITED_MESSAGE : messageStatusForNumber;
    }

    @Override // fr.sd.taada.proto.GetTrafficUpdateResponseOrBuilder
    public boolean hasRadioId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.GetTrafficUpdateResponseOrBuilder
    public boolean hasStatus() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(GetTrafficUpdateResponse getTrafficUpdateResponse) {
        return DEFAULT_INSTANCE.createBuilder(getTrafficUpdateResponse);
    }

    public static GetTrafficUpdateResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GetTrafficUpdateResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GetTrafficUpdateResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GetTrafficUpdateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GetTrafficUpdateResponse parseFrom(ByteString byteString) {
        return (GetTrafficUpdateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addIncidents(int i, TrafficIncident trafficIncident) {
        trafficIncident.getClass();
        ensureIncidentsIsMutable();
        this.incidents_.add(i, trafficIncident);
    }

    public static GetTrafficUpdateResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GetTrafficUpdateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIncidents(int i, TrafficIncident.Builder builder) {
        ensureIncidentsIsMutable();
        this.incidents_.set(i, builder.build());
    }

    public static GetTrafficUpdateResponse parseFrom(byte[] bArr) {
        return (GetTrafficUpdateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GetTrafficUpdateResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GetTrafficUpdateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addIncidents(TrafficIncident.Builder builder) {
        ensureIncidentsIsMutable();
        this.incidents_.add(builder.build());
    }

    public static GetTrafficUpdateResponse parseFrom(InputStream inputStream) {
        return (GetTrafficUpdateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GetTrafficUpdateResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GetTrafficUpdateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addIncidents(int i, TrafficIncident.Builder builder) {
        ensureIncidentsIsMutable();
        this.incidents_.add(i, builder.build());
    }

    public static GetTrafficUpdateResponse parseFrom(CodedInputStream codedInputStream) {
        return (GetTrafficUpdateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GetTrafficUpdateResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GetTrafficUpdateResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
