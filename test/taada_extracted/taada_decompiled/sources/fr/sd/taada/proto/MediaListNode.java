package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.MediaList;
import fr.sd.taada.proto.MediaSong;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaListNode extends GeneratedMessageLite<MediaListNode, Builder> implements MediaListNodeOrBuilder {
    private static final MediaListNode DEFAULT_INSTANCE;
    public static final int LIST_FIELD_NUMBER = 1;
    private static volatile Parser<MediaListNode> PARSER = null;
    public static final int SONGS_FIELD_NUMBER = 4;
    public static final int START_FIELD_NUMBER = 2;
    public static final int TOTAL_FIELD_NUMBER = 3;
    private int bitField0_;
    private MediaList list_;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<MediaSong> songs_ = GeneratedMessageLite.emptyProtobufList();
    private int start_;
    private int total_;

    /* JADX INFO: renamed from: fr.sd.taada.proto.MediaListNode$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<MediaListNode, Builder> implements MediaListNodeOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllSongs(Iterable<? extends MediaSong> iterable) {
            copyOnWrite();
            ((MediaListNode) this.instance).addAllSongs(iterable);
            return this;
        }

        public Builder addSongs(MediaSong mediaSong) {
            copyOnWrite();
            ((MediaListNode) this.instance).addSongs(mediaSong);
            return this;
        }

        public Builder clearList() {
            copyOnWrite();
            ((MediaListNode) this.instance).clearList();
            return this;
        }

        public Builder clearSongs() {
            copyOnWrite();
            ((MediaListNode) this.instance).clearSongs();
            return this;
        }

        public Builder clearStart() {
            copyOnWrite();
            ((MediaListNode) this.instance).clearStart();
            return this;
        }

        public Builder clearTotal() {
            copyOnWrite();
            ((MediaListNode) this.instance).clearTotal();
            return this;
        }

        @Override // fr.sd.taada.proto.MediaListNodeOrBuilder
        public MediaList getList() {
            return ((MediaListNode) this.instance).getList();
        }

        @Override // fr.sd.taada.proto.MediaListNodeOrBuilder
        public MediaSong getSongs(int i) {
            return ((MediaListNode) this.instance).getSongs(i);
        }

        @Override // fr.sd.taada.proto.MediaListNodeOrBuilder
        public int getSongsCount() {
            return ((MediaListNode) this.instance).getSongsCount();
        }

        @Override // fr.sd.taada.proto.MediaListNodeOrBuilder
        public List<MediaSong> getSongsList() {
            return Collections.unmodifiableList(((MediaListNode) this.instance).getSongsList());
        }

        @Override // fr.sd.taada.proto.MediaListNodeOrBuilder
        public int getStart() {
            return ((MediaListNode) this.instance).getStart();
        }

        @Override // fr.sd.taada.proto.MediaListNodeOrBuilder
        public int getTotal() {
            return ((MediaListNode) this.instance).getTotal();
        }

        @Override // fr.sd.taada.proto.MediaListNodeOrBuilder
        public boolean hasList() {
            return ((MediaListNode) this.instance).hasList();
        }

        @Override // fr.sd.taada.proto.MediaListNodeOrBuilder
        public boolean hasStart() {
            return ((MediaListNode) this.instance).hasStart();
        }

        @Override // fr.sd.taada.proto.MediaListNodeOrBuilder
        public boolean hasTotal() {
            return ((MediaListNode) this.instance).hasTotal();
        }

        public Builder mergeList(MediaList mediaList) {
            copyOnWrite();
            ((MediaListNode) this.instance).mergeList(mediaList);
            return this;
        }

        public Builder removeSongs(int i) {
            copyOnWrite();
            ((MediaListNode) this.instance).removeSongs(i);
            return this;
        }

        public Builder setList(MediaList mediaList) {
            copyOnWrite();
            ((MediaListNode) this.instance).setList(mediaList);
            return this;
        }

        public Builder setSongs(int i, MediaSong mediaSong) {
            copyOnWrite();
            ((MediaListNode) this.instance).setSongs(i, mediaSong);
            return this;
        }

        public Builder setStart(int i) {
            copyOnWrite();
            ((MediaListNode) this.instance).setStart(i);
            return this;
        }

        public Builder setTotal(int i) {
            copyOnWrite();
            ((MediaListNode) this.instance).setTotal(i);
            return this;
        }

        private Builder() {
            super(MediaListNode.DEFAULT_INSTANCE);
        }

        public Builder addSongs(int i, MediaSong mediaSong) {
            copyOnWrite();
            ((MediaListNode) this.instance).addSongs(i, mediaSong);
            return this;
        }

        public Builder setList(MediaList.Builder builder) {
            copyOnWrite();
            ((MediaListNode) this.instance).setList(builder);
            return this;
        }

        public Builder setSongs(int i, MediaSong.Builder builder) {
            copyOnWrite();
            ((MediaListNode) this.instance).setSongs(i, builder);
            return this;
        }

        public Builder addSongs(MediaSong.Builder builder) {
            copyOnWrite();
            ((MediaListNode) this.instance).addSongs(builder);
            return this;
        }

        public Builder addSongs(int i, MediaSong.Builder builder) {
            copyOnWrite();
            ((MediaListNode) this.instance).addSongs(i, builder);
            return this;
        }
    }

    static {
        MediaListNode mediaListNode = new MediaListNode();
        DEFAULT_INSTANCE = mediaListNode;
        GeneratedMessageLite.registerDefaultInstance(MediaListNode.class, mediaListNode);
    }

    private MediaListNode() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSongs(Iterable<? extends MediaSong> iterable) {
        ensureSongsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.songs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSongs(MediaSong mediaSong) {
        mediaSong.getClass();
        ensureSongsIsMutable();
        this.songs_.add(mediaSong);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearList() {
        this.list_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSongs() {
        this.songs_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStart() {
        this.bitField0_ &= -3;
        this.start_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTotal() {
        this.bitField0_ &= -5;
        this.total_ = 0;
    }

    private void ensureSongsIsMutable() {
        if (this.songs_.isModifiable()) {
            return;
        }
        this.songs_ = GeneratedMessageLite.mutableCopy(this.songs_);
    }

    public static MediaListNode getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeList(MediaList mediaList) {
        mediaList.getClass();
        MediaList mediaList2 = this.list_;
        if (mediaList2 == null || mediaList2 == MediaList.getDefaultInstance()) {
            this.list_ = mediaList;
        } else {
            this.list_ = MediaList.newBuilder(this.list_).mergeFrom(mediaList).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MediaListNode parseDelimitedFrom(InputStream inputStream) {
        return (MediaListNode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaListNode parseFrom(ByteBuffer byteBuffer) {
        return (MediaListNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MediaListNode> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSongs(int i) {
        ensureSongsIsMutable();
        this.songs_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(MediaList mediaList) {
        mediaList.getClass();
        this.list_ = mediaList;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSongs(int i, MediaSong mediaSong) {
        mediaSong.getClass();
        ensureSongsIsMutable();
        this.songs_.set(i, mediaSong);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStart(int i) {
        this.bitField0_ |= 2;
        this.start_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTotal(int i) {
        this.bitField0_ |= 4;
        this.total_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MediaListNode();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0002\u0001ԉ\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004Л", new Object[]{"bitField0_", "list_", "start_", "total_", "songs_", MediaSong.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MediaListNode> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MediaListNode.class) {
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

    @Override // fr.sd.taada.proto.MediaListNodeOrBuilder
    public MediaList getList() {
        MediaList mediaList = this.list_;
        return mediaList == null ? MediaList.getDefaultInstance() : mediaList;
    }

    @Override // fr.sd.taada.proto.MediaListNodeOrBuilder
    public MediaSong getSongs(int i) {
        return this.songs_.get(i);
    }

    @Override // fr.sd.taada.proto.MediaListNodeOrBuilder
    public int getSongsCount() {
        return this.songs_.size();
    }

    @Override // fr.sd.taada.proto.MediaListNodeOrBuilder
    public List<MediaSong> getSongsList() {
        return this.songs_;
    }

    public MediaSongOrBuilder getSongsOrBuilder(int i) {
        return this.songs_.get(i);
    }

    public List<? extends MediaSongOrBuilder> getSongsOrBuilderList() {
        return this.songs_;
    }

    @Override // fr.sd.taada.proto.MediaListNodeOrBuilder
    public int getStart() {
        return this.start_;
    }

    @Override // fr.sd.taada.proto.MediaListNodeOrBuilder
    public int getTotal() {
        return this.total_;
    }

    @Override // fr.sd.taada.proto.MediaListNodeOrBuilder
    public boolean hasList() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.MediaListNodeOrBuilder
    public boolean hasStart() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.MediaListNodeOrBuilder
    public boolean hasTotal() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(MediaListNode mediaListNode) {
        return DEFAULT_INSTANCE.createBuilder(mediaListNode);
    }

    public static MediaListNode parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaListNode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaListNode parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaListNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MediaListNode parseFrom(ByteString byteString) {
        return (MediaListNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSongs(int i, MediaSong mediaSong) {
        mediaSong.getClass();
        ensureSongsIsMutable();
        this.songs_.add(i, mediaSong);
    }

    public static MediaListNode parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaListNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setList(MediaList.Builder builder) {
        this.list_ = builder.build();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSongs(int i, MediaSong.Builder builder) {
        ensureSongsIsMutable();
        this.songs_.set(i, builder.build());
    }

    public static MediaListNode parseFrom(byte[] bArr) {
        return (MediaListNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MediaListNode parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaListNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSongs(MediaSong.Builder builder) {
        ensureSongsIsMutable();
        this.songs_.add(builder.build());
    }

    public static MediaListNode parseFrom(InputStream inputStream) {
        return (MediaListNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaListNode parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaListNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSongs(int i, MediaSong.Builder builder) {
        ensureSongsIsMutable();
        this.songs_.add(i, builder.build());
    }

    public static MediaListNode parseFrom(CodedInputStream codedInputStream) {
        return (MediaListNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MediaListNode parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaListNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
