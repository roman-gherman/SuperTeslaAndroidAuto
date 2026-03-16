package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface MediaSourceNodeOrBuilder extends MessageLiteOrBuilder {
    MediaList getLists(int i);

    int getListsCount();

    List<MediaList> getListsList();

    MediaSource getSource();

    int getStart();

    int getTotal();

    boolean hasSource();

    boolean hasStart();

    boolean hasTotal();
}
