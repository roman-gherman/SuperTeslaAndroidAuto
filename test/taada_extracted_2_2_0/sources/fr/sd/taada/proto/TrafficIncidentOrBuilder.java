package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface TrafficIncidentOrBuilder extends MessageLiteOrBuilder {
    int getEventCode();

    int getExpectedIncidentDuration();

    Location getLocation();

    boolean hasEventCode();

    boolean hasExpectedIncidentDuration();

    boolean hasLocation();
}
