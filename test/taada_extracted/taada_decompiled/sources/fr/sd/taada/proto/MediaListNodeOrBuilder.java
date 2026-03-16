package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface MediaListNodeOrBuilder extends MessageLiteOrBuilder {
    MediaList getList();

    MediaSong getSongs(int i);

    int getSongsCount();

    List<MediaSong> getSongsList();

    int getStart();

    int getTotal();

    boolean hasList();

    boolean hasStart();

    boolean hasTotal();
}
