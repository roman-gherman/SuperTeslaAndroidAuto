package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface MediaRootNodeOrBuilder extends MessageLiteOrBuilder {
    MediaSource getMediaSources(int i);

    int getMediaSourcesCount();

    List<MediaSource> getMediaSourcesList();

    String getPath();

    ByteString getPathBytes();

    boolean hasPath();
}
