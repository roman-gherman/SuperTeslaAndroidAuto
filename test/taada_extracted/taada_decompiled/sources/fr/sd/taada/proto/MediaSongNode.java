package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.MediaSong;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaSongNode extends GeneratedMessageLite<MediaSongNode, Builder> implements MediaSongNodeOrBuilder {
    public static final int ALBUM_ART_FIELD_NUMBER = 2;
    private static final MediaSongNode DEFAULT_INSTANCE;
    public static final int DURATION_SECONDS_FIELD_NUMBER = 3;
    private static volatile Parser<MediaSongNode> PARSER = null;
    public static final int SONG_FIELD_NUMBER = 1;
    private int bitField0_;
    private int durationSeconds_;
    private MediaSong song_;
    private byte memoizedIsInitialized = 2;
    private ByteString albumArt_ = ByteString.EMPTY;

    /* JADX INFO: renamed from: fr.sd.taada.proto.MediaSongNode$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<MediaSongNode, Builder> implements MediaSongNodeOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAlbumArt() {
            copyOnWrite();
            ((MediaSongNode) this.instance).clearAlbumArt();
            return this;
        }

        public Builder clearDurationSeconds() {
            copyOnWrite();
            ((MediaSongNode) this.instance).clearDurationSeconds();
            return this;
        }

        public Builder clearSong() {
            copyOnWrite();
            ((MediaSongNode) this.instance).clearSong();
            return this;
        }

        @Override // fr.sd.taada.proto.MediaSongNodeOrBuilder
        public ByteString getAlbumArt() {
            return ((MediaSongNode) this.instance).getAlbumArt();
        }

        @Override // fr.sd.taada.proto.MediaSongNodeOrBuilder
        public int getDurationSeconds() {
            return ((MediaSongNode) this.instance).getDurationSeconds();
        }

        @Override // fr.sd.taada.proto.MediaSongNodeOrBuilder
        public MediaSong getSong() {
            return ((MediaSongNode) this.instance).getSong();
        }

        @Override // fr.sd.taada.proto.MediaSongNodeOrBuilder
        public boolean hasAlbumArt() {
            return ((MediaSongNode) this.instance).hasAlbumArt();
        }

        @Override // fr.sd.taada.proto.MediaSongNodeOrBuilder
        public boolean hasDurationSeconds() {
            return ((MediaSongNode) this.instance).hasDurationSeconds();
        }

        @Override // fr.sd.taada.proto.MediaSongNodeOrBuilder
        public boolean hasSong() {
            return ((MediaSongNode) this.instance).hasSong();
        }

        public Builder mergeSong(MediaSong mediaSong) {
            copyOnWrite();
            ((MediaSongNode) this.instance).mergeSong(mediaSong);
            return this;
        }

        public Builder setAlbumArt(ByteString byteString) {
            copyOnWrite();
            ((MediaSongNode) this.instance).setAlbumArt(byteString);
            return this;
        }

        public Builder setDurationSeconds(int i) {
            copyOnWrite();
            ((MediaSongNode) this.instance).setDurationSeconds(i);
            return this;
        }

        public Builder setSong(MediaSong mediaSong) {
            copyOnWrite();
            ((MediaSongNode) this.instance).setSong(mediaSong);
            return this;
        }

        private Builder() {
            super(MediaSongNode.DEFAULT_INSTANCE);
        }

        public Builder setSong(MediaSong.Builder builder) {
            copyOnWrite();
            ((MediaSongNode) this.instance).setSong(builder);
            return this;
        }
    }

    static {
        MediaSongNode mediaSongNode = new MediaSongNode();
        DEFAULT_INSTANCE = mediaSongNode;
        GeneratedMessageLite.registerDefaultInstance(MediaSongNode.class, mediaSongNode);
    }

    private MediaSongNode() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlbumArt() {
        this.bitField0_ &= -3;
        this.albumArt_ = getDefaultInstance().getAlbumArt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDurationSeconds() {
        this.bitField0_ &= -5;
        this.durationSeconds_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSong() {
        this.song_ = null;
        this.bitField0_ &= -2;
    }

    public static MediaSongNode getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSong(MediaSong mediaSong) {
        mediaSong.getClass();
        MediaSong mediaSong2 = this.song_;
        if (mediaSong2 == null || mediaSong2 == MediaSong.getDefaultInstance()) {
            this.song_ = mediaSong;
        } else {
            this.song_ = MediaSong.newBuilder(this.song_).mergeFrom(mediaSong).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MediaSongNode parseDelimitedFrom(InputStream inputStream) {
        return (MediaSongNode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaSongNode parseFrom(ByteBuffer byteBuffer) {
        return (MediaSongNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MediaSongNode> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlbumArt(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 2;
        this.albumArt_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDurationSeconds(int i) {
        this.bitField0_ |= 4;
        this.durationSeconds_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSong(MediaSong mediaSong) {
        mediaSong.getClass();
        this.song_ = mediaSong;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MediaSongNode();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ԉ\u0000\u0002\n\u0001\u0003\u000b\u0002", new Object[]{"bitField0_", "song_", "albumArt_", "durationSeconds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MediaSongNode> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MediaSongNode.class) {
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

    @Override // fr.sd.taada.proto.MediaSongNodeOrBuilder
    public ByteString getAlbumArt() {
        return this.albumArt_;
    }

    @Override // fr.sd.taada.proto.MediaSongNodeOrBuilder
    public int getDurationSeconds() {
        return this.durationSeconds_;
    }

    @Override // fr.sd.taada.proto.MediaSongNodeOrBuilder
    public MediaSong getSong() {
        MediaSong mediaSong = this.song_;
        return mediaSong == null ? MediaSong.getDefaultInstance() : mediaSong;
    }

    @Override // fr.sd.taada.proto.MediaSongNodeOrBuilder
    public boolean hasAlbumArt() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.MediaSongNodeOrBuilder
    public boolean hasDurationSeconds() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // fr.sd.taada.proto.MediaSongNodeOrBuilder
    public boolean hasSong() {
        return (this.bitField0_ & 1) != 0;
    }

    public static Builder newBuilder(MediaSongNode mediaSongNode) {
        return DEFAULT_INSTANCE.createBuilder(mediaSongNode);
    }

    public static MediaSongNode parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSongNode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaSongNode parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSongNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MediaSongNode parseFrom(ByteString byteString) {
        return (MediaSongNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MediaSongNode parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSongNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSong(MediaSong.Builder builder) {
        this.song_ = builder.build();
        this.bitField0_ |= 1;
    }

    public static MediaSongNode parseFrom(byte[] bArr) {
        return (MediaSongNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MediaSongNode parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSongNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MediaSongNode parseFrom(InputStream inputStream) {
        return (MediaSongNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaSongNode parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSongNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaSongNode parseFrom(CodedInputStream codedInputStream) {
        return (MediaSongNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MediaSongNode parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSongNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
