package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface RadioPropertiesOrBuilder extends MessageLiteOrBuilder {
    boolean getAfSwitch();

    boolean getAudioLoopback();

    boolean getBackgroundTuner();

    Range getChannelRange(int i);

    int getChannelRangeCount();

    List<Range> getChannelRangeList();

    int getChannelSpacing();

    int getChannelSpacings(int i);

    int getChannelSpacingsCount();

    List<Integer> getChannelSpacingsList();

    boolean getMuteCapability();

    int getRadioId();

    RdsType getRds();

    ItuRegion getRegion();

    int getStationPresetsAccess();

    boolean getTa();

    TrafficServiceType getTrafficService();

    RadioType getType();

    boolean hasAfSwitch();

    boolean hasAudioLoopback();

    boolean hasBackgroundTuner();

    boolean hasChannelSpacing();

    boolean hasMuteCapability();

    boolean hasRadioId();

    boolean hasRds();

    boolean hasRegion();

    boolean hasStationPresetsAccess();

    boolean hasTa();

    boolean hasTrafficService();

    boolean hasType();
}
