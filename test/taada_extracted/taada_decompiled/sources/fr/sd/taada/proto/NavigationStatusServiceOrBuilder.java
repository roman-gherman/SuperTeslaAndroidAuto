package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import fr.sd.taada.proto.NavigationStatusService;

/* JADX INFO: loaded from: classes2.dex */
public interface NavigationStatusServiceOrBuilder extends MessageLiteOrBuilder {
    NavigationStatusService.ImageOptions getImageOptions();

    int getMinimumIntervalMs();

    NavigationStatusService.InstrumentClusterType getType();

    boolean hasImageOptions();

    boolean hasMinimumIntervalMs();

    boolean hasType();
}
