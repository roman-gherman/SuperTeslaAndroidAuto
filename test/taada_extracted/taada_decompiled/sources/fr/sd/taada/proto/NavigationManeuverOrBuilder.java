package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import fr.sd.taada.proto.NavigationManeuver;

/* JADX INFO: loaded from: classes2.dex */
public interface NavigationManeuverOrBuilder extends MessageLiteOrBuilder {
    int getRoundaboutExitAngle();

    int getRoundaboutExitNumber();

    NavigationManeuver.NavigationType getType();

    boolean hasRoundaboutExitAngle();

    boolean hasRoundaboutExitNumber();

    boolean hasType();
}
