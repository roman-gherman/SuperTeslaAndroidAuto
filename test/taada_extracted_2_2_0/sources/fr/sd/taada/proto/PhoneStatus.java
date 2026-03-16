package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class PhoneStatus extends GeneratedMessageLite<PhoneStatus, Builder> implements PhoneStatusOrBuilder {
    public static final int CALLS_FIELD_NUMBER = 1;
    private static final PhoneStatus DEFAULT_INSTANCE;
    private static volatile Parser<PhoneStatus> PARSER = null;
    public static final int SIGNAL_STRENGTH_FIELD_NUMBER = 2;
    private int bitField0_;
    private int signalStrength_;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<Call> calls_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.PhoneStatus$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<PhoneStatus, Builder> implements PhoneStatusOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllCalls(Iterable<? extends Call> iterable) {
            copyOnWrite();
            ((PhoneStatus) this.instance).addAllCalls(iterable);
            return this;
        }

        public Builder addCalls(Call call) {
            copyOnWrite();
            ((PhoneStatus) this.instance).addCalls(call);
            return this;
        }

        public Builder clearCalls() {
            copyOnWrite();
            ((PhoneStatus) this.instance).clearCalls();
            return this;
        }

        public Builder clearSignalStrength() {
            copyOnWrite();
            ((PhoneStatus) this.instance).clearSignalStrength();
            return this;
        }

        @Override // fr.sd.taada.proto.PhoneStatusOrBuilder
        public Call getCalls(int i) {
            return ((PhoneStatus) this.instance).getCalls(i);
        }

        @Override // fr.sd.taada.proto.PhoneStatusOrBuilder
        public int getCallsCount() {
            return ((PhoneStatus) this.instance).getCallsCount();
        }

        @Override // fr.sd.taada.proto.PhoneStatusOrBuilder
        public List<Call> getCallsList() {
            return Collections.unmodifiableList(((PhoneStatus) this.instance).getCallsList());
        }

        @Override // fr.sd.taada.proto.PhoneStatusOrBuilder
        public int getSignalStrength() {
            return ((PhoneStatus) this.instance).getSignalStrength();
        }

        @Override // fr.sd.taada.proto.PhoneStatusOrBuilder
        public boolean hasSignalStrength() {
            return ((PhoneStatus) this.instance).hasSignalStrength();
        }

        public Builder removeCalls(int i) {
            copyOnWrite();
            ((PhoneStatus) this.instance).removeCalls(i);
            return this;
        }

        public Builder setCalls(int i, Call call) {
            copyOnWrite();
            ((PhoneStatus) this.instance).setCalls(i, call);
            return this;
        }

        public Builder setSignalStrength(int i) {
            copyOnWrite();
            ((PhoneStatus) this.instance).setSignalStrength(i);
            return this;
        }

        private Builder() {
            super(PhoneStatus.DEFAULT_INSTANCE);
        }

        public Builder addCalls(int i, Call call) {
            copyOnWrite();
            ((PhoneStatus) this.instance).addCalls(i, call);
            return this;
        }

        public Builder setCalls(int i, Call.Builder builder) {
            copyOnWrite();
            ((PhoneStatus) this.instance).setCalls(i, builder);
            return this;
        }

        public Builder addCalls(Call.Builder builder) {
            copyOnWrite();
            ((PhoneStatus) this.instance).addCalls(builder);
            return this;
        }

        public Builder addCalls(int i, Call.Builder builder) {
            copyOnWrite();
            ((PhoneStatus) this.instance).addCalls(i, builder);
            return this;
        }
    }

    public static final class Call extends GeneratedMessageLite<Call, Builder> implements CallOrBuilder {
        public static final int CALLER_ID_FIELD_NUMBER = 4;
        public static final int CALLER_NUMBER_FIELD_NUMBER = 3;
        public static final int CALLER_NUMBER_TYPE_FIELD_NUMBER = 5;
        public static final int CALLER_THUMBNAIL_FIELD_NUMBER = 6;
        public static final int CALL_DURATION_SECONDS_FIELD_NUMBER = 2;
        private static final Call DEFAULT_INSTANCE;
        private static volatile Parser<Call> PARSER = null;
        public static final int PHONE_STATE_FIELD_NUMBER = 1;
        private int bitField0_;
        private int callDurationSeconds_;
        private int phoneState_;
        private byte memoizedIsInitialized = 2;
        private String callerNumber_ = "";
        private String callerId_ = "";
        private String callerNumberType_ = "";
        private ByteString callerThumbnail_ = ByteString.EMPTY;

        public static final class Builder extends GeneratedMessageLite.Builder<Call, Builder> implements CallOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCallDurationSeconds() {
                copyOnWrite();
                ((Call) this.instance).clearCallDurationSeconds();
                return this;
            }

            public Builder clearCallerId() {
                copyOnWrite();
                ((Call) this.instance).clearCallerId();
                return this;
            }

            public Builder clearCallerNumber() {
                copyOnWrite();
                ((Call) this.instance).clearCallerNumber();
                return this;
            }

            public Builder clearCallerNumberType() {
                copyOnWrite();
                ((Call) this.instance).clearCallerNumberType();
                return this;
            }

            public Builder clearCallerThumbnail() {
                copyOnWrite();
                ((Call) this.instance).clearCallerThumbnail();
                return this;
            }

            public Builder clearPhoneState() {
                copyOnWrite();
                ((Call) this.instance).clearPhoneState();
                return this;
            }

            @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
            public int getCallDurationSeconds() {
                return ((Call) this.instance).getCallDurationSeconds();
            }

            @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
            public String getCallerId() {
                return ((Call) this.instance).getCallerId();
            }

            @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
            public ByteString getCallerIdBytes() {
                return ((Call) this.instance).getCallerIdBytes();
            }

            @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
            public String getCallerNumber() {
                return ((Call) this.instance).getCallerNumber();
            }

            @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
            public ByteString getCallerNumberBytes() {
                return ((Call) this.instance).getCallerNumberBytes();
            }

            @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
            public String getCallerNumberType() {
                return ((Call) this.instance).getCallerNumberType();
            }

            @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
            public ByteString getCallerNumberTypeBytes() {
                return ((Call) this.instance).getCallerNumberTypeBytes();
            }

            @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
            public ByteString getCallerThumbnail() {
                return ((Call) this.instance).getCallerThumbnail();
            }

            @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
            public State getPhoneState() {
                return ((Call) this.instance).getPhoneState();
            }

            @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
            public boolean hasCallDurationSeconds() {
                return ((Call) this.instance).hasCallDurationSeconds();
            }

            @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
            public boolean hasCallerId() {
                return ((Call) this.instance).hasCallerId();
            }

            @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
            public boolean hasCallerNumber() {
                return ((Call) this.instance).hasCallerNumber();
            }

            @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
            public boolean hasCallerNumberType() {
                return ((Call) this.instance).hasCallerNumberType();
            }

            @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
            public boolean hasCallerThumbnail() {
                return ((Call) this.instance).hasCallerThumbnail();
            }

            @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
            public boolean hasPhoneState() {
                return ((Call) this.instance).hasPhoneState();
            }

            public Builder setCallDurationSeconds(int i) {
                copyOnWrite();
                ((Call) this.instance).setCallDurationSeconds(i);
                return this;
            }

            public Builder setCallerId(String str) {
                copyOnWrite();
                ((Call) this.instance).setCallerId(str);
                return this;
            }

            public Builder setCallerIdBytes(ByteString byteString) {
                copyOnWrite();
                ((Call) this.instance).setCallerIdBytes(byteString);
                return this;
            }

            public Builder setCallerNumber(String str) {
                copyOnWrite();
                ((Call) this.instance).setCallerNumber(str);
                return this;
            }

            public Builder setCallerNumberBytes(ByteString byteString) {
                copyOnWrite();
                ((Call) this.instance).setCallerNumberBytes(byteString);
                return this;
            }

            public Builder setCallerNumberType(String str) {
                copyOnWrite();
                ((Call) this.instance).setCallerNumberType(str);
                return this;
            }

            public Builder setCallerNumberTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((Call) this.instance).setCallerNumberTypeBytes(byteString);
                return this;
            }

            public Builder setCallerThumbnail(ByteString byteString) {
                copyOnWrite();
                ((Call) this.instance).setCallerThumbnail(byteString);
                return this;
            }

            public Builder setPhoneState(State state) {
                copyOnWrite();
                ((Call) this.instance).setPhoneState(state);
                return this;
            }

            private Builder() {
                super(Call.DEFAULT_INSTANCE);
            }
        }

        static {
            Call call = new Call();
            DEFAULT_INSTANCE = call;
            GeneratedMessageLite.registerDefaultInstance(Call.class, call);
        }

        private Call() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCallDurationSeconds() {
            this.bitField0_ &= -3;
            this.callDurationSeconds_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCallerId() {
            this.bitField0_ &= -9;
            this.callerId_ = getDefaultInstance().getCallerId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCallerNumber() {
            this.bitField0_ &= -5;
            this.callerNumber_ = getDefaultInstance().getCallerNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCallerNumberType() {
            this.bitField0_ &= -17;
            this.callerNumberType_ = getDefaultInstance().getCallerNumberType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCallerThumbnail() {
            this.bitField0_ &= -33;
            this.callerThumbnail_ = getDefaultInstance().getCallerThumbnail();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPhoneState() {
            this.bitField0_ &= -2;
            this.phoneState_ = 0;
        }

        public static Call getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Call parseDelimitedFrom(InputStream inputStream) {
            return (Call) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Call parseFrom(ByteBuffer byteBuffer) {
            return (Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Call> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCallDurationSeconds(int i) {
            this.bitField0_ |= 2;
            this.callDurationSeconds_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCallerId(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.callerId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCallerIdBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.callerId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCallerNumber(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.callerNumber_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCallerNumberBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.callerNumber_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCallerNumberType(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.callerNumberType_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCallerNumberTypeBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.callerNumberType_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCallerThumbnail(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 32;
            this.callerThumbnail_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPhoneState(State state) {
            state.getClass();
            this.bitField0_ |= 1;
            this.phoneState_ = state.getNumber();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Call();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0002\u0001Ԍ\u0000\u0002ԋ\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\n\u0005", new Object[]{"bitField0_", "phoneState_", State.internalGetVerifier(), "callDurationSeconds_", "callerNumber_", "callerId_", "callerNumberType_", "callerThumbnail_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Call> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Call.class) {
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

        @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
        public int getCallDurationSeconds() {
            return this.callDurationSeconds_;
        }

        @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
        public String getCallerId() {
            return this.callerId_;
        }

        @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
        public ByteString getCallerIdBytes() {
            return ByteString.copyFromUtf8(this.callerId_);
        }

        @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
        public String getCallerNumber() {
            return this.callerNumber_;
        }

        @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
        public ByteString getCallerNumberBytes() {
            return ByteString.copyFromUtf8(this.callerNumber_);
        }

        @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
        public String getCallerNumberType() {
            return this.callerNumberType_;
        }

        @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
        public ByteString getCallerNumberTypeBytes() {
            return ByteString.copyFromUtf8(this.callerNumberType_);
        }

        @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
        public ByteString getCallerThumbnail() {
            return this.callerThumbnail_;
        }

        @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
        public State getPhoneState() {
            State stateForNumber = State.forNumber(this.phoneState_);
            return stateForNumber == null ? State.UNKNOWN : stateForNumber;
        }

        @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
        public boolean hasCallDurationSeconds() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
        public boolean hasCallerId() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
        public boolean hasCallerNumber() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
        public boolean hasCallerNumberType() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
        public boolean hasCallerThumbnail() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // fr.sd.taada.proto.PhoneStatus.CallOrBuilder
        public boolean hasPhoneState() {
            return (this.bitField0_ & 1) != 0;
        }

        public static Builder newBuilder(Call call) {
            return DEFAULT_INSTANCE.createBuilder(call);
        }

        public static Call parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Call) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Call parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Call parseFrom(ByteString byteString) {
            return (Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Call parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Call parseFrom(byte[] bArr) {
            return (Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Call parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Call parseFrom(InputStream inputStream) {
            return (Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Call parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Call parseFrom(CodedInputStream codedInputStream) {
            return (Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Call parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (Call) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface CallOrBuilder extends MessageLiteOrBuilder {
        int getCallDurationSeconds();

        String getCallerId();

        ByteString getCallerIdBytes();

        String getCallerNumber();

        ByteString getCallerNumberBytes();

        String getCallerNumberType();

        ByteString getCallerNumberTypeBytes();

        ByteString getCallerThumbnail();

        State getPhoneState();

        boolean hasCallDurationSeconds();

        boolean hasCallerId();

        boolean hasCallerNumber();

        boolean hasCallerNumberType();

        boolean hasCallerThumbnail();

        boolean hasPhoneState();
    }

    public enum State implements Internal.EnumLite {
        UNKNOWN(0),
        IN_CALL(1),
        ON_HOLD(2),
        INACTIVE(3),
        INCOMING(4),
        CONFERENCED(5),
        MUTED(6);

        public static final int CONFERENCED_VALUE = 5;
        public static final int INACTIVE_VALUE = 3;
        public static final int INCOMING_VALUE = 4;
        public static final int IN_CALL_VALUE = 1;
        public static final int MUTED_VALUE = 6;
        public static final int ON_HOLD_VALUE = 2;
        public static final int UNKNOWN_VALUE = 0;
        private static final Internal.EnumLiteMap<State> internalValueMap = new Internal.EnumLiteMap<State>() { // from class: fr.sd.taada.proto.PhoneStatus.State.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public State findValueByNumber(int i) {
                return State.forNumber(i);
            }
        };
        private final int value;

        public static final class StateVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new StateVerifier();

            private StateVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return State.forNumber(i) != null;
            }
        }

        State(int i) {
            this.value = i;
        }

        public static State forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN;
                case 1:
                    return IN_CALL;
                case 2:
                    return ON_HOLD;
                case 3:
                    return INACTIVE;
                case 4:
                    return INCOMING;
                case 5:
                    return CONFERENCED;
                case 6:
                    return MUTED;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<State> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return StateVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static State valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        PhoneStatus phoneStatus = new PhoneStatus();
        DEFAULT_INSTANCE = phoneStatus;
        GeneratedMessageLite.registerDefaultInstance(PhoneStatus.class, phoneStatus);
    }

    private PhoneStatus() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCalls(Iterable<? extends Call> iterable) {
        ensureCallsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.calls_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCalls(Call call) {
        call.getClass();
        ensureCallsIsMutable();
        this.calls_.add(call);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCalls() {
        this.calls_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSignalStrength() {
        this.bitField0_ &= -2;
        this.signalStrength_ = 0;
    }

    private void ensureCallsIsMutable() {
        if (this.calls_.isModifiable()) {
            return;
        }
        this.calls_ = GeneratedMessageLite.mutableCopy(this.calls_);
    }

    public static PhoneStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PhoneStatus parseDelimitedFrom(InputStream inputStream) {
        return (PhoneStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PhoneStatus parseFrom(ByteBuffer byteBuffer) {
        return (PhoneStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PhoneStatus> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCalls(int i) {
        ensureCallsIsMutable();
        this.calls_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCalls(int i, Call call) {
        call.getClass();
        ensureCallsIsMutable();
        this.calls_.set(i, call);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSignalStrength(int i) {
        this.bitField0_ |= 1;
        this.signalStrength_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PhoneStatus();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0001\u0001Л\u0002\u000b\u0000", new Object[]{"bitField0_", "calls_", Call.class, "signalStrength_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PhoneStatus> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PhoneStatus.class) {
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

    @Override // fr.sd.taada.proto.PhoneStatusOrBuilder
    public Call getCalls(int i) {
        return this.calls_.get(i);
    }

    @Override // fr.sd.taada.proto.PhoneStatusOrBuilder
    public int getCallsCount() {
        return this.calls_.size();
    }

    @Override // fr.sd.taada.proto.PhoneStatusOrBuilder
    public List<Call> getCallsList() {
        return this.calls_;
    }

    public CallOrBuilder getCallsOrBuilder(int i) {
        return this.calls_.get(i);
    }

    public List<? extends CallOrBuilder> getCallsOrBuilderList() {
        return this.calls_;
    }

    @Override // fr.sd.taada.proto.PhoneStatusOrBuilder
    public int getSignalStrength() {
        return this.signalStrength_;
    }

    @Override // fr.sd.taada.proto.PhoneStatusOrBuilder
    public boolean hasSignalStrength() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(PhoneStatus phoneStatus) {
        return DEFAULT_INSTANCE.createBuilder(phoneStatus);
    }

    public static PhoneStatus parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhoneStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PhoneStatus parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PhoneStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PhoneStatus parseFrom(ByteString byteString) {
        return (PhoneStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCalls(int i, Call call) {
        call.getClass();
        ensureCallsIsMutable();
        this.calls_.add(i, call);
    }

    public static PhoneStatus parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PhoneStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCalls(int i, Call.Builder builder) {
        ensureCallsIsMutable();
        this.calls_.set(i, builder.build());
    }

    public static PhoneStatus parseFrom(byte[] bArr) {
        return (PhoneStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PhoneStatus parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PhoneStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCalls(Call.Builder builder) {
        ensureCallsIsMutable();
        this.calls_.add(builder.build());
    }

    public static PhoneStatus parseFrom(InputStream inputStream) {
        return (PhoneStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PhoneStatus parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhoneStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCalls(int i, Call.Builder builder) {
        ensureCallsIsMutable();
        this.calls_.add(i, builder.build());
    }

    public static PhoneStatus parseFrom(CodedInputStream codedInputStream) {
        return (PhoneStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PhoneStatus parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhoneStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
