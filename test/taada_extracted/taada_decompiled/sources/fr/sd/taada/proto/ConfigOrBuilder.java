package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import fr.sd.taada.proto.Config;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ConfigOrBuilder extends MessageLiteOrBuilder {
    int getConfigurationIndices(int i);

    int getConfigurationIndicesCount();

    List<Integer> getConfigurationIndicesList();

    int getMaxUnacked();

    Config.Status getStatus();

    boolean hasMaxUnacked();

    boolean hasStatus();
}
