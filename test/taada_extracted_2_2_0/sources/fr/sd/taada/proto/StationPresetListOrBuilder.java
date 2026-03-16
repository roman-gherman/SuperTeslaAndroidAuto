package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface StationPresetListOrBuilder extends MessageLiteOrBuilder {
    String getName();

    ByteString getNameBytes();

    StationPreset getPresets(int i);

    int getPresetsCount();

    List<StationPreset> getPresetsList();

    int getRestrictedStationTypes(int i);

    int getRestrictedStationTypesCount();

    List<Integer> getRestrictedStationTypesList();

    boolean hasName();
}
