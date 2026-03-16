package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface NavigationStepOrBuilder extends MessageLiteOrBuilder {
    NavigationCue getCue();

    NavigationLane getLanes(int i);

    int getLanesCount();

    List<NavigationLane> getLanesList();

    NavigationManeuver getManeuver();

    NavigationRoad getRoad();

    boolean hasCue();

    boolean hasManeuver();

    boolean hasRoad();
}
