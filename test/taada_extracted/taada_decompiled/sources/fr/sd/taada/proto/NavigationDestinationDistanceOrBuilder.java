package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface NavigationDestinationDistanceOrBuilder extends MessageLiteOrBuilder {
    NavigationDistance getDistance();

    String getEstimatedTimeAtArrival();

    ByteString getEstimatedTimeAtArrivalBytes();

    long getTimeToArrivalSeconds();

    boolean hasDistance();

    boolean hasEstimatedTimeAtArrival();

    boolean hasTimeToArrivalSeconds();
}
