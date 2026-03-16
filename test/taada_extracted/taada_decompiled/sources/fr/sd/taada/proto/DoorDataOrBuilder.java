package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface DoorDataOrBuilder extends MessageLiteOrBuilder {
    boolean getDoorOpen(int i);

    int getDoorOpenCount();

    List<Boolean> getDoorOpenList();

    boolean getHoodOpen();

    boolean getTrunkOpen();

    boolean hasHoodOpen();

    boolean hasTrunkOpen();
}
