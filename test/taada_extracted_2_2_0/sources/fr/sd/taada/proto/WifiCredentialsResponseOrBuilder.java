package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface WifiCredentialsResponseOrBuilder extends MessageLiteOrBuilder {
    AccessPointType getAccessPointType();

    String getCarWifiPassword();

    ByteString getCarWifiPasswordBytes();

    WifiSecurityMode getCarWifiSecurityMode();

    String getCarWifiSsid();

    ByteString getCarWifiSsidBytes();

    int getSupportedWifiChannels(int i);

    int getSupportedWifiChannelsCount();

    List<Integer> getSupportedWifiChannelsList();

    boolean hasAccessPointType();

    boolean hasCarWifiPassword();

    boolean hasCarWifiSecurityMode();

    boolean hasCarWifiSsid();
}
