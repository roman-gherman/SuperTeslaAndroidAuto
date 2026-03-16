package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface GpsSatelliteDataOrBuilder extends MessageLiteOrBuilder {
    int getNumberInUse();

    int getNumberInView();

    GpsSatellite getSatellites(int i);

    int getSatellitesCount();

    List<GpsSatellite> getSatellitesList();

    boolean hasNumberInUse();

    boolean hasNumberInView();
}
