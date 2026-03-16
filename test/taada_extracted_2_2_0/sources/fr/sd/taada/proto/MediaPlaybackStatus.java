package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaPlaybackStatus extends GeneratedMessageLite<MediaPlaybackStatus, Builder> implements MediaPlaybackStatusOrBuilder {
    private static final MediaPlaybackStatus DEFAULT_INSTANCE;
    public static final int MEDIA_SOURCE_FIELD_NUMBER = 2;
    private static volatile Parser<MediaPlaybackStatus> PARSER = null;
    public static final int PLAYBACK_SECONDS_FIELD_NUMBER = 3;
    public static final int REPEAT_FIELD_NUMBER = 5;
    public static final int REPEAT_ONE_FIELD_NUMBER = 6;
    public static final int SHUFFLE_FIELD_NUMBER = 4;
    public static final int STATE_FIELD_NUMBER = 1;
    private int bitField0_;
    private int playbackSeconds_;
    private boolean repeatOne_;
    private boolean repeat_;
    private boolean shuffle_;
    private int state_ = 1;
    private String mediaSource_ = "";

    /* JADX INFO: renamed from: fr.sd.taada.proto.MediaPlaybackStatus$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<MediaPlaybackStatus, Builder> implements MediaPlaybackStatusOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearMediaSource() {
            copyOnWrite();
            ((MediaPlaybackStatus) this.instance).clearMediaSource();
            return this;
        }

        public Builder clearPlaybackSeconds() {
            copyOnWrite();
            ((MediaPlaybackStatus) this.instance).clearPlaybackSeconds();
            return this;
        }

        public Builder clearRepeat() {
            copyOnWrite();
            ((MediaPlaybackStatus) this.instance).clearRepeat();
            return this;
        }

        public Builder clearRepeatOne() {
            copyOnWrite();
            ((MediaPlaybackStatus) this.instance).clearRepeatOne();
            return this;
        }

        public Builder clearShuffle() {
            copyOnWrite();
            ((MediaPlaybackStatus) this.instance).clearShuffle();
            return this;
        }

        public Builder clearState() {
            copyOnWrite();
            ((MediaPlaybackStatus) this.instance).clearState();
            return this;
        }

        @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
        public String getMediaSource() {
            return ((MediaPlaybackStatus) this.instance).getMediaSource();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
        public ByteString getMediaSourceBytes() {
            return ((MediaPlaybackStatus) this.instance).getMediaSourceBytes();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
        public int getPlaybackSeconds() {
            return ((MediaPlaybackStatus) this.instance).getPlaybackSeconds();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
        public boolean getRepeat() {
            return ((MediaPlaybackStatus) this.instance).getRepeat();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
        public boolean getRepeatOne() {
            return ((MediaPlaybackStatus) this.instance).getRepeatOne();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
        public boolean getShuffle() {
            return ((MediaPlaybackStatus) this.instance).getShuffle();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
        public State getState() {
            return ((MediaPlaybackStatus) this.instance).getState();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
        public boolean hasMediaSource() {
            return ((MediaPlaybackStatus) this.instance).hasMediaSource();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
        public boolean hasPlaybackSeconds() {
            return ((MediaPlaybackStatus) this.instance).hasPlaybackSeconds();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
        public boolean hasRepeat() {
            return ((MediaPlaybackStatus) this.instance).hasRepeat();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
        public boolean hasRepeatOne() {
            return ((MediaPlaybackStatus) this.instance).hasRepeatOne();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
        public boolean hasShuffle() {
            return ((MediaPlaybackStatus) this.instance).hasShuffle();
        }

        @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
        public boolean hasState() {
            return ((MediaPlaybackStatus) this.instance).hasState();
        }

        public Builder setMediaSource(String str) {
            copyOnWrite();
            ((MediaPlaybackStatus) this.instance).setMediaSource(str);
            return this;
        }

        public Builder setMediaSourceBytes(ByteString byteString) {
            copyOnWrite();
            ((MediaPlaybackStatus) this.instance).setMediaSourceBytes(byteString);
            return this;
        }

        public Builder setPlaybackSeconds(int i) {
            copyOnWrite();
            ((MediaPlaybackStatus) this.instance).setPlaybackSeconds(i);
            return this;
        }

        public Builder setRepeat(boolean z6) {
            copyOnWrite();
            ((MediaPlaybackStatus) this.instance).setRepeat(z6);
            return this;
        }

        public Builder setRepeatOne(boolean z6) {
            copyOnWrite();
            ((MediaPlaybackStatus) this.instance).setRepeatOne(z6);
            return this;
        }

        public Builder setShuffle(boolean z6) {
            copyOnWrite();
            ((MediaPlaybackStatus) this.instance).setShuffle(z6);
            return this;
        }

        public Builder setState(State state) {
            copyOnWrite();
            ((MediaPlaybackStatus) this.instance).setState(state);
            return this;
        }

        private Builder() {
            super(MediaPlaybackStatus.DEFAULT_INSTANCE);
        }
    }

    public enum State implements Internal.EnumLite {
        STOPPED(1),
        PLAYING(2),
        PAUSED(3);

        public static final int PAUSED_VALUE = 3;
        public static final int PLAYING_VALUE = 2;
        public static final int STOPPED_VALUE = 1;
        private static final Internal.EnumLiteMap<State> internalValueMap = new Internal.EnumLiteMap<State>() { // from class: fr.sd.taada.proto.MediaPlaybackStatus.State.1
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
            if (i == 1) {
                return STOPPED;
            }
            if (i == 2) {
                return PLAYING;
            }
            if (i != 3) {
                return null;
            }
            return PAUSED;
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
        MediaPlaybackStatus mediaPlaybackStatus = new MediaPlaybackStatus();
        DEFAULT_INSTANCE = mediaPlaybackStatus;
        GeneratedMessageLite.registerDefaultInstance(MediaPlaybackStatus.class, mediaPlaybackStatus);
    }

    private MediaPlaybackStatus() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMediaSource() {
        this.bitField0_ &= -3;
        this.mediaSource_ = getDefaultInstance().getMediaSource();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlaybackSeconds() {
        this.bitField0_ &= -5;
        this.playbackSeconds_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRepeat() {
        this.bitField0_ &= -17;
        this.repeat_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRepeatOne() {
        this.bitField0_ &= -33;
        this.repeatOne_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearShuffle() {
        this.bitField0_ &= -9;
        this.shuffle_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearState() {
        this.bitField0_ &= -2;
        this.state_ = 1;
    }

    public static MediaPlaybackStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MediaPlaybackStatus parseDelimitedFrom(InputStream inputStream) {
        return (MediaPlaybackStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaPlaybackStatus parseFrom(ByteBuffer byteBuffer) {
        return (MediaPlaybackStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MediaPlaybackStatus> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaSource(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.mediaSource_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaSourceBytes(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2;
        this.mediaSource_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSeconds(int i) {
        this.bitField0_ |= 4;
        this.playbackSeconds_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRepeat(boolean z6) {
        this.bitField0_ |= 16;
        this.repeat_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRepeatOne(boolean z6) {
        this.bitField0_ |= 32;
        this.repeatOne_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShuffle(boolean z6) {
        this.bitField0_ |= 8;
        this.shuffle_ = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(State state) {
        state.getClass();
        this.bitField0_ |= 1;
        this.state_ = state.getNumber();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MediaPlaybackStatus();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\u000b\u0002\u0004\u0007\u0003\u0005\u0007\u0004\u0006\u0007\u0005", new Object[]{"bitField0_", "state_", State.internalGetVerifier(), "mediaSource_", "playbackSeconds_", "shuffle_", "repeat_", "repeatOne_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MediaPlaybackStatus> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MediaPlaybackStatus.class) {
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

    @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
    public String getMediaSource() {
        return this.mediaSource_;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
    public ByteString getMediaSourceBytes() {
        return ByteString.copyFromUtf8(this.mediaSource_);
    }

    @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
    public int getPlaybackSeconds() {
        return this.playbackSeconds_;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
    public boolean getRepeat() {
        return this.repeat_;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
    public boolean getRepeatOne() {
        return this.repeatOne_;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
    public boolean getShuffle() {
        return this.shuffle_;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
    public State getState() {
        State stateForNumber = State.forNumber(this.state_);
        return stateForNumber == null ? State.STOPPED : stateForNumber;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
    public boolean hasMediaSource() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
    public boolean hasPlaybackSeconds() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
    public boolean hasRepeat() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
    public boolean hasRepeatOne() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
    public boolean hasShuffle() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // fr.sd.taada.proto.MediaPlaybackStatusOrBuilder
    public boolean hasState() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(MediaPlaybackStatus mediaPlaybackStatus) {
        return DEFAULT_INSTANCE.createBuilder(mediaPlaybackStatus);
    }

    public static MediaPlaybackStatus parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaPlaybackStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaPlaybackStatus parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaPlaybackStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MediaPlaybackStatus parseFrom(ByteString byteString) {
        return (MediaPlaybackStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MediaPlaybackStatus parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaPlaybackStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MediaPlaybackStatus parseFrom(byte[] bArr) {
        return (MediaPlaybackStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MediaPlaybackStatus parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaPlaybackStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MediaPlaybackStatus parseFrom(InputStream inputStream) {
        return (MediaPlaybackStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaPlaybackStatus parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaPlaybackStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaPlaybackStatus parseFrom(CodedInputStream codedInputStream) {
        return (MediaPlaybackStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MediaPlaybackStatus parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaPlaybackStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
