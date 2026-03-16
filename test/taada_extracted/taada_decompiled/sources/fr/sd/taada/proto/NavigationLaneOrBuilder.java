package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import fr.sd.taada.proto.NavigationLane;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface NavigationLaneOrBuilder extends MessageLiteOrBuilder {
    NavigationLane.LaneDirection getLaneDirections(int i);

    int getLaneDirectionsCount();

    List<NavigationLane.LaneDirection> getLaneDirectionsList();
}
