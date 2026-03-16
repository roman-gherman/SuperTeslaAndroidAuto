package fr.sd.taada.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import fr.sd.taada.proto.MediaList;
import fr.sd.taada.proto.MediaSource;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaSourceNode extends GeneratedMessageLite<MediaSourceNode, Builder> implements MediaSourceNodeOrBuilder {
    private static final MediaSourceNode DEFAULT_INSTANCE;
    public static final int LISTS_FIELD_NUMBER = 4;
    private static volatile Parser<MediaSourceNode> PARSER = null;
    public static final int SOURCE_FIELD_NUMBER = 1;
    public static final int START_FIELD_NUMBER = 2;
    public static final int TOTAL_FIELD_NUMBER = 3;
    private int bitField0_;
    private MediaSource source_;
    private int start_;
    private int total_;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<MediaList> lists_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: renamed from: fr.sd.taada.proto.MediaSourceNode$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<MediaSourceNode, Builder> implements MediaSourceNodeOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllLists(Iterable<? extends MediaList> iterable) {
            copyOnWrite();
            ((MediaSourceNode) this.instance).addAllLists(iterable);
            return this;
        }

        public Builder addLists(MediaList mediaList) {
            copyOnWrite();
            ((MediaSourceNode) this.instance).addLists(mediaList);
            return this;
        }

        public Builder clearLists() {
            copyOnWrite();
            ((MediaSourceNode) this.instance).clearLists();
            return this;
        }

        public Builder clearSource() {
            copyOnWrite();
            ((MediaSourceNode) this.instance).clearSource();
            return this;
        }

        public Builder clearStart() {
            copyOnWrite();
            ((MediaSourceNode) this.instance).clearStart();
            return this;
        }

        public Builder clearTotal() {
            copyOnWrite();
            ((MediaSourceNode) this.instance).clearTotal();
            return this;
        }

        @Override // fr.sd.taada.proto.MediaSourceNodeOrBuilder
        public MediaList getLists(int i) {
            return ((MediaSourceNode) this.instance).getLists(i);
        }

        @Override // fr.sd.taada.proto.MediaSourceNodeOrBuilder
        public int getListsCount() {
            return ((MediaSourceNode) this.instance).getListsCount();
        }

        @Override // fr.sd.taada.proto.MediaSourceNodeOrBuilder
        public List<MediaList> getListsList() {
            return Collections.unmodifiableList(((MediaSourceNode) this.instance).getListsList());
        }

        @Override // fr.sd.taada.proto.MediaSourceNodeOrBuilder
        public MediaSource getSource() {
            return ((MediaSourceNode) this.instance).getSource();
        }

        @Override // fr.sd.taada.proto.MediaSourceNodeOrBuilder
        public int getStart() {
            return ((MediaSourceNode) this.instance).getStart();
        }

        @Override // fr.sd.taada.proto.MediaSourceNodeOrBuilder
        public int getTotal() {
            return ((MediaSourceNode) this.instance).getTotal();
        }

        @Override // fr.sd.taada.proto.MediaSourceNodeOrBuilder
        public boolean hasSource() {
            return ((MediaSourceNode) this.instance).hasSource();
        }

        @Override // fr.sd.taada.proto.MediaSourceNodeOrBuilder
        public boolean hasStart() {
            return ((MediaSourceNode) this.instance).hasStart();
        }

        @Override // fr.sd.taada.proto.MediaSourceNodeOrBuilder
        public boolean hasTotal() {
            return ((MediaSourceNode) this.instance).hasTotal();
        }

        public Builder mergeSource(MediaSource mediaSource) {
            copyOnWrite();
            ((MediaSourceNode) this.instance).mergeSource(mediaSource);
            return this;
        }

        public Builder removeLists(int i) {
            copyOnWrite();
            ((MediaSourceNode) this.instance).removeLists(i);
            return this;
        }

        public Builder setLists(int i, MediaList mediaList) {
            copyOnWrite();
            ((MediaSourceNode) this.instance).setLists(i, mediaList);
            return this;
        }

        public Builder setSource(MediaSource mediaSource) {
            copyOnWrite();
            ((MediaSourceNode) this.instance).setSource(mediaSource);
            return this;
        }

        public Builder setStart(int i) {
            copyOnWrite();
            ((MediaSourceNode) this.instance).setStart(i);
            return this;
        }

        public Builder setTotal(int i) {
            copyOnWrite();
            ((MediaSourceNode) this.instance).setTotal(i);
            return this;
        }

        private Builder() {
            super(MediaSourceNode.DEFAULT_INSTANCE);
        }

        public Builder addLists(int i, MediaList mediaList) {
            copyOnWrite();
            ((MediaSourceNode) this.instance).addLists(i, mediaList);
            return this;
        }

        public Builder setLists(int i, MediaList.Builder builder) {
            copyOnWrite();
            ((MediaSourceNode) this.instance).setLists(i, builder);
            return this;
        }

        public Builder setSource(MediaSource.Builder builder) {
            copyOnWrite();
            ((MediaSourceNode) this.instance).setSource(builder);
            return this;
        }

        public Builder addLists(MediaList.Builder builder) {
            copyOnWrite();
            ((MediaSourceNode) this.instance).addLists(builder);
            return this;
        }

        public Builder addLists(int i, MediaList.Builder builder) {
            copyOnWrite();
            ((MediaSourceNode) this.instance).addLists(i, builder);
            return this;
        }
    }

    static {
        MediaSourceNode mediaSourceNode = new MediaSourceNode();
        DEFAULT_INSTANCE = mediaSourceNode;
        GeneratedMessageLite.registerDefaultInstance(MediaSourceNode.class, mediaSourceNode);
    }

    private MediaSourceNode() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLists(Iterable<? extends MediaList> iterable) {
        ensureListsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.lists_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLists(MediaList mediaList) {
        mediaList.getClass();
        ensureListsIsMutable();
        this.lists_.add(mediaList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLists() {
        this.lists_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSource() {
        this.source_ = null;
        this.bitField0_ &= -2;
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

    private void ensureListsIsMutable() {
        if (this.lists_.isModifiable()) {
            return;
        }
        this.lists_ = GeneratedMessageLite.mutableCopy(this.lists_);
    }

    public static MediaSourceNode getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSource(MediaSource mediaSource) {
        mediaSource.getClass();
        MediaSource mediaSource2 = this.source_;
        if (mediaSource2 == null || mediaSource2 == MediaSource.getDefaultInstance()) {
            this.source_ = mediaSource;
        } else {
            this.source_ = MediaSource.newBuilder(this.source_).mergeFrom(mediaSource).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static MediaSourceNode parseDelimitedFrom(InputStream inputStream) {
        return (MediaSourceNode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaSourceNode parseFrom(ByteBuffer byteBuffer) {
        return (MediaSourceNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<MediaSourceNode> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLists(int i) {
        ensureListsIsMutable();
        this.lists_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLists(int i, MediaList mediaList) {
        mediaList.getClass();
        ensureListsIsMutable();
        this.lists_.set(i, mediaList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSource(MediaSource mediaSource) {
        mediaSource.getClass();
        this.source_ = mediaSource;
        this.bitField0_ |= 1;
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
                return new MediaSourceNode();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0002\u0001ԉ\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004Л", new Object[]{"bitField0_", "source_", "start_", "total_", "lists_", MediaList.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MediaSourceNode> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MediaSourceNode.class) {
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

    @Override // fr.sd.taada.proto.MediaSourceNodeOrBuilder
    public MediaList getLists(int i) {
        return this.lists_.get(i);
    }

    @Override // fr.sd.taada.proto.MediaSourceNodeOrBuilder
    public int getListsCount() {
        return this.lists_.size();
    }

    @Override // fr.sd.taada.proto.MediaSourceNodeOrBuilder
    public List<MediaList> getListsList() {
        return this.lists_;
    }

    public MediaListOrBuilder getListsOrBuilder(int i) {
        return this.lists_.get(i);
    }

    public List<? extends MediaListOrBuilder> getListsOrBuilderList() {
        return this.lists_;
    }

    @Override // fr.sd.taada.proto.MediaSourceNodeOrBuilder
    public MediaSource getSource() {
        MediaSource mediaSource = this.source_;
        return mediaSource == null ? MediaSource.getDefaultInstance() : mediaSource;
    }

    @Override // fr.sd.taada.proto.MediaSourceNodeOrBuilder
    public int getStart() {
        return this.start_;
    }

    @Override // fr.sd.taada.proto.MediaSourceNodeOrBuilder
    public int getTotal() {
        return this.total_;
    }

    @Override // fr.sd.taada.proto.MediaSourceNodeOrBuilder
    public boolean hasSource() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // fr.sd.taada.proto.MediaSourceNodeOrBuilder
    public boolean hasStart() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // fr.sd.taada.proto.MediaSourceNodeOrBuilder
    public boolean hasTotal() {
        return (this.bitField0_ & 4) != 0;
    }

    public static Builder newBuilder(MediaSourceNode mediaSourceNode) {
        return DEFAULT_INSTANCE.createBuilder(mediaSourceNode);
    }

    public static MediaSourceNode parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSourceNode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MediaSourceNode parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSourceNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MediaSourceNode parseFrom(ByteString byteString) {
        return (MediaSourceNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLists(int i, MediaList mediaList) {
        mediaList.getClass();
        ensureListsIsMutable();
        this.lists_.add(i, mediaList);
    }

    public static MediaSourceNode parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSourceNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLists(int i, MediaList.Builder builder) {
        ensureListsIsMutable();
        this.lists_.set(i, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSource(MediaSource.Builder builder) {
        this.source_ = builder.build();
        this.bitField0_ |= 1;
    }

    public static MediaSourceNode parseFrom(byte[] bArr) {
        return (MediaSourceNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MediaSourceNode parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSourceNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLists(MediaList.Builder builder) {
        ensureListsIsMutable();
        this.lists_.add(builder.build());
    }

    public static MediaSourceNode parseFrom(InputStream inputStream) {
        return (MediaSourceNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MediaSourceNode parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSourceNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLists(int i, MediaList.Builder builder) {
        ensureListsIsMutable();
        this.lists_.add(i, builder.build());
    }

    public static MediaSourceNode parseFrom(CodedInputStream codedInputStream) {
        return (MediaSourceNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MediaSourceNode parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MediaSourceNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
