package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface HeadUnitInfoOrBuilder extends MessageLiteOrBuilder {
    String getHeadUnitMake();

    ByteString getHeadUnitMakeBytes();

    String getHeadUnitModel();

    ByteString getHeadUnitModelBytes();

    String getHeadUnitSoftwareBuild();

    ByteString getHeadUnitSoftwareBuildBytes();

    String getHeadUnitSoftwareVersion();

    ByteString getHeadUnitSoftwareVersionBytes();

    String getMake();

    ByteString getMakeBytes();

    String getModel();

    ByteString getModelBytes();

    String getVehicleId();

    ByteString getVehicleIdBytes();

    String getYear();

    ByteString getYearBytes();

    boolean hasHeadUnitMake();

    boolean hasHeadUnitModel();

    boolean hasHeadUnitSoftwareBuild();

    boolean hasHeadUnitSoftwareVersion();

    boolean hasMake();

    boolean hasModel();

    boolean hasVehicleId();

    boolean hasYear();
}
