package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface RadioStateNotificationOrBuilder extends MessageLiteOrBuilder {
    int getActiveRadioId();

    RadioStationInfo getProgramList(int i);

    int getProgramListCount();

    List<RadioStationInfo> getProgramListList();

    boolean getRadioMuted();

    boolean getRadioSourceEnabled();

    RadioStationInfo getStationInfo();

    StationPresetList getStationPresetLists(int i);

    int getStationPresetListsCount();

    List<StationPresetList> getStationPresetListsList();

    boolean hasActiveRadioId();

    boolean hasRadioMuted();

    boolean hasRadioSourceEnabled();

    boolean hasStationInfo();
}
