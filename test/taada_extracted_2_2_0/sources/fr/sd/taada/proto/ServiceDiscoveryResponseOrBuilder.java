package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ServiceDiscoveryResponseOrBuilder extends MessageLiteOrBuilder {
    @Deprecated
    boolean getCanPlayNativeMediaDuringVr();

    ConnectionConfiguration getConnectionConfiguration();

    String getDisplayName();

    ByteString getDisplayNameBytes();

    DriverPosition getDriverPosition();

    @Deprecated
    String getHeadUnitMake();

    @Deprecated
    ByteString getHeadUnitMakeBytes();

    @Deprecated
    String getHeadUnitModel();

    @Deprecated
    ByteString getHeadUnitModelBytes();

    @Deprecated
    String getHeadUnitSoftwareBuild();

    @Deprecated
    ByteString getHeadUnitSoftwareBuildBytes();

    @Deprecated
    String getHeadUnitSoftwareVersion();

    @Deprecated
    ByteString getHeadUnitSoftwareVersionBytes();

    HeadUnitInfo getHeadunitInfo();

    @Deprecated
    String getMake();

    @Deprecated
    ByteString getMakeBytes();

    @Deprecated
    String getModel();

    @Deprecated
    ByteString getModelBytes();

    boolean getProbeForSupport();

    Service getServices(int i);

    int getServicesCount();

    List<Service> getServicesList();

    int getSessionConfiguration();

    @Deprecated
    String getVehicleId();

    @Deprecated
    ByteString getVehicleIdBytes();

    @Deprecated
    String getYear();

    @Deprecated
    ByteString getYearBytes();

    @Deprecated
    boolean hasCanPlayNativeMediaDuringVr();

    boolean hasConnectionConfiguration();

    boolean hasDisplayName();

    boolean hasDriverPosition();

    @Deprecated
    boolean hasHeadUnitMake();

    @Deprecated
    boolean hasHeadUnitModel();

    @Deprecated
    boolean hasHeadUnitSoftwareBuild();

    @Deprecated
    boolean hasHeadUnitSoftwareVersion();

    boolean hasHeadunitInfo();

    @Deprecated
    boolean hasMake();

    @Deprecated
    boolean hasModel();

    boolean hasProbeForSupport();

    boolean hasSessionConfiguration();

    @Deprecated
    boolean hasVehicleId();

    @Deprecated
    boolean hasYear();
}
