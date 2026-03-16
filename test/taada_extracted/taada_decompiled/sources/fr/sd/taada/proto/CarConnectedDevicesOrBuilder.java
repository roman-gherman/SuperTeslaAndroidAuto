package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface CarConnectedDevicesOrBuilder extends MessageLiteOrBuilder {
    ConnectedDevice getConnectedDevices(int i);

    int getConnectedDevicesCount();

    List<ConnectedDevice> getConnectedDevicesList();

    boolean getFinalList();

    boolean getUnsolicited();

    boolean hasFinalList();

    boolean hasUnsolicited();
}
