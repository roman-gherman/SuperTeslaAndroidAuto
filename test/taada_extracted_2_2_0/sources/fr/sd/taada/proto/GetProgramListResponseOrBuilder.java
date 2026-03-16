package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface GetProgramListResponseOrBuilder extends MessageLiteOrBuilder {
    boolean getCompleted();

    RadioStationInfo getProgramList(int i);

    int getProgramListCount();

    List<RadioStationInfo> getProgramListList();

    int getRadioId();

    MessageStatus getStatus();

    boolean hasCompleted();

    boolean hasRadioId();

    boolean hasStatus();
}
