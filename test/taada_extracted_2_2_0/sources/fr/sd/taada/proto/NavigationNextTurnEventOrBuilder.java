package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import fr.sd.taada.proto.NavigationNextTurnEvent;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface NavigationNextTurnEventOrBuilder extends MessageLiteOrBuilder {
    NavigationNextTurnEvent.NextTurnEnum getEvent();

    ByteString getImage();

    String getRoad();

    ByteString getRoadBytes();

    int getTurnAngle();

    int getTurnNumber();

    NavigationNextTurnEvent.TurnSide getTurnSide();

    boolean hasEvent();

    boolean hasImage();

    boolean hasRoad();

    boolean hasTurnAngle();

    boolean hasTurnNumber();

    boolean hasTurnSide();
}
