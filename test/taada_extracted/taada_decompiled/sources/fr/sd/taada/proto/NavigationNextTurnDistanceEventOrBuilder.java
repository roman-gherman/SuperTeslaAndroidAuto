package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import fr.sd.taada.proto.NavigationNextTurnDistanceEvent;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface NavigationNextTurnDistanceEventOrBuilder extends MessageLiteOrBuilder {
    int getDisplayDistanceE3();

    NavigationNextTurnDistanceEvent.DistanceUnits getDisplayDistanceUnit();

    int getDistanceMeters();

    int getTimeToTurnSeconds();

    boolean hasDisplayDistanceE3();

    boolean hasDisplayDistanceUnit();

    boolean hasDistanceMeters();

    boolean hasTimeToTurnSeconds();
}
