package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import fr.sd.taada.proto.NavigationDistance;

/* JADX INFO: loaded from: classes2.dex */
public interface NavigationDistanceOrBuilder extends MessageLiteOrBuilder {
    NavigationDistance.DistanceUnits getDisplayUnits();

    String getDisplayValue();

    ByteString getDisplayValueBytes();

    int getMeters();

    boolean hasDisplayUnits();

    boolean hasDisplayValue();

    boolean hasMeters();
}
