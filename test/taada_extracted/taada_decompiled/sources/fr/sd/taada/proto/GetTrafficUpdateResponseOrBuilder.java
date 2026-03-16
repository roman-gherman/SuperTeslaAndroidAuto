package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface GetTrafficUpdateResponseOrBuilder extends MessageLiteOrBuilder {
    TrafficIncident getIncidents(int i);

    int getIncidentsCount();

    List<TrafficIncident> getIncidentsList();

    int getRadioId();

    MessageStatus getStatus();

    boolean hasRadioId();

    boolean hasStatus();
}
