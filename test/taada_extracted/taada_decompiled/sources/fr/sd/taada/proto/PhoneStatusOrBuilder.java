package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import fr.sd.taada.proto.PhoneStatus;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface PhoneStatusOrBuilder extends MessageLiteOrBuilder {
    PhoneStatus.Call getCalls(int i);

    int getCallsCount();

    List<PhoneStatus.Call> getCallsList();

    int getSignalStrength();

    boolean hasSignalStrength();
}
