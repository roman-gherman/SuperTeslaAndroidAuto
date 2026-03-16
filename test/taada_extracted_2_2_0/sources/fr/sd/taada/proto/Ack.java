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
public final class Ack extends GeneratedMessageLite<Ack, Builder> implements AckOrBuilder {
    public static final int ACK_FIELD_NUMBER = 2;
    private static final Ack DEFAULT_INSTANCE;
    private static volatile Parser<Ack> PARSER = null;
    public static final int RECEIVE_TIMESTAMP_NS_FIELD_NUMBER = 3;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    private int ack_;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private Internal.LongList receiveTimestampNs_ = GeneratedMessageLite.emptyLongList();
    private int sessionId_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.Ack$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Ack, Builder> implements AckOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllReceiveTimestampNs(Iterable<? extends Long> iterable) {
            copyOnWrite();
            ((Ack) this.instance).addAllReceiveTimestampNs(iterable);
            return this;
        }

        public Builder addReceiveTimestampNs(long j6) {
            copyOnWrite();
            ((Ack) this.instance).addReceiveTimestampNs(j6);
            return this;
        }

        public Builder clearAck() {
            copyOnWrite();
            ((Ack) this.instance).clearAck();
            return this;
        }

        public Builder clearReceiveTimestampNs() {
            copyOnWrite();
            ((Ack) this.instance).clearReceiveTimestampNs();
            return this;
        }

        public Builder clearSessionId() {
            copyOnWrite();
            ((Ack) this.instance).clearSessionId();
            return this;
        }

        @Override // fr.sd.taada.proto.AckOrBuilder
        public int getAck() {
            return ((Ack) this.instance).getAck();
        }

        @Override // fr.sd.taada.proto.AckOrBuilder
        public long getReceiveTimestampNs(int i) {
            return ((Ack) this.instance).getReceiveTimestampNs(i);
        }

        @Override // fr.sd.taada.proto.AckOrBuilder
        public int getReceiveTimestampNsCount() {
            return ((Ack) this.instance).getReceiveTimestampNsCount();
        }

        @Override // fr.sd.taada.proto.AckOrBuilder
        public List<Long> getReceiveTimestampNsList() {
            return Collections.unmodifiableList(((Ack) this.instance).getReceiveTimestampNsList());
        }

        @Override // fr.sd.taada.proto.AckOrBuilder
        public int getSessionId() {
            return ((Ack) this.instance).getSessionId();
        }

        @Override // fr.sd.taada.proto.AckOrBuilder
        public boolean hasAck() {
            return ((Ack) this.instance).hasAck();
        }

        @Override // fr.sd.taada.proto.AckOrBuilder
        public boolean hasSessionId() {
            return ((Ack) this.instance).hasSessionId();
        }

        public Builder setAck(int i) {
            copyOnWrite();
            ((Ack) this.instance).setAck(i);
            return this;
        }

        public Builder setReceiveTimestampNs(int i, long j6) {
            copyOnWrite();
            ((Ack) this.instance).setReceiveTimestampNs(i, j6);
            return this;
        }

        public Builder setSessionId(int i) {
            copyOnWrite();
            ((Ack) this.instance).setSessionId(i);
            return this;
        }

        private Builder() {
            super(Ack.DEFAULT_INSTANCE);
        }
    }

    static {
        Ack ack = new Ack();
        DEFAULT_INSTANCE = ack;
        GeneratedMessageLite.registerDefaultInstance(Ack.class, ack);
    }

    private Ack() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllReceiveTimestampNs(Iterable<? extends Long> iterable) {
        ensureReceiveTimestampNsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.receiveTimestampNs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addReceiveTimestampNs(long j6) {
        ensureReceiveTimestampNsIsMutable();
        this.receiveTimestampNs_.addLong(j6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAck() {
        this.bitField0_ &= -3;
        this.ack_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReceiveTimestampNs() {
        this.receiveTimestampNs_ = GeneratedMessageLite.emptyLongList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.bitField0_ &= -2;
        this.sessionId_ = 0;
    }

    private void ensureReceiveTimestampNsIsMutable() {
        if (this.receiveTimestampNs_.isModifiable()) {
            return;
        }
        this.receiveTimestampNs_ = GeneratedMessageLite.mutableCopy(this.receiveTimestampNs_);
    }

    public static Ack getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Ack parseDelimitedFrom(InputStream inputStream) {
        return (Ack) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ack parseFrom(ByteBuffer byteBuffer) {
        return (Ack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Ack> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAck(int i) {
        this.bitField0_ |= 2;
        this.ack_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReceiveTimestampNs(int i, long j6) {
        ensureReceiveTimestampNsIsMutable();
        this.receiveTimestampNs_.setLong(i, j6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionId(int i) {
        this.bitField0_ |= 1;
        this.sessionId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Ack();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001Ԅ\u0000\u0002\u000b\u0001\u0003\u0015", new Object[]{"bitField0_", "sessionId_", "ack_", "receiveTimestampNs_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Ack> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Ack.class) {
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

    @Override // fr.sd.taada.proto.AckOrBuilder
    public int getAck() {
        return this.ack_;
    }

    @Override // fr.sd.taada.proto.AckOrBuilder
    public long getReceiveTimestampNs(int i) {
        return this.receiveTimestampNs_.getLong(i);
    }

    @Override // fr.sd.taada.proto.AckOrBuilder
    public int getReceiveTimestampNsCount() {
        return this.receiveTimestampNs_.size();
    }

    @Override // fr.sd.taada.proto.AckOrBuilder
    public List<Long> getReceiveTimestampNsList() {
        return this.receiveTimestampNs_;
    }

    @Override // fr.sd.taada.proto.AckOrBuilder
    public int getSessionId() {
        return this.sessionId_;
    }

    @Override // fr.sd.taada.proto.AckOrBuilder
    public boolean hasAck() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.AckOrBuilder
    public boolean hasSessionId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(Ack ack) {
        return DEFAULT_INSTANCE.createBuilder(ack);
    }

    public static Ack parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Ack) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Ack parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Ack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Ack parseFrom(ByteString byteString) {
        return (Ack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Ack parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Ack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Ack parseFrom(byte[] bArr) {
        return (Ack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Ack parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Ack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Ack parseFrom(InputStream inputStream) {
        return (Ack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Ack parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Ack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Ack parseFrom(CodedInputStream codedInputStream) {
        return (Ack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Ack parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Ack) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
