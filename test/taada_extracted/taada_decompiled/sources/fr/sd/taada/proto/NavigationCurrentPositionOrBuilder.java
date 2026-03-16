package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface NavigationCurrentPositionOrBuilder extends MessageLiteOrBuilder {
    NavigationRoad getCurrentRoad();

    NavigationDestinationDistance getDestinationDistances(int i);

    int getDestinationDistancesCount();

    List<NavigationDestinationDistance> getDestinationDistancesList();

    NavigationStepDistance getStepDistance();

    boolean hasCurrentRoad();

    boolean hasStepDistance();
}
