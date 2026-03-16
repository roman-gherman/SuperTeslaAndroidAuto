package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface StationPresetsNotificationOrBuilder extends MessageLiteOrBuilder {
    StationPresetList getPresetLists(int i);

    int getPresetListsCount();

    List<StationPresetList> getPresetListsList();
}
