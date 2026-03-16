package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface DeadReckoningDataOrBuilder extends MessageLiteOrBuilder {
    int getSteeringAngleE1();

    int getWheelSpeedE3(int i);

    int getWheelSpeedE3Count();

    List<Integer> getWheelSpeedE3List();

    boolean hasSteeringAngleE1();
}
