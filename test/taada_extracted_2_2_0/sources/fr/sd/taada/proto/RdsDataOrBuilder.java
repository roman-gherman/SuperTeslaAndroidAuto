package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface RdsDataOrBuilder extends MessageLiteOrBuilder {
    int getAlternativeFrequencies(int i);

    int getAlternativeFrequenciesCount();

    List<Integer> getAlternativeFrequenciesList();

    int getMusicSpeechSwitch();

    int getProgramId();

    String getProgramServiceName();

    ByteString getProgramServiceNameBytes();

    int getProgramType();

    String getProgramTypeName();

    ByteString getProgramTypeNameBytes();

    String getRadioText();

    ByteString getRadioTextBytes();

    boolean getTrafficAnnouncementFlag();

    boolean getTrafficProgramFlag();

    boolean hasMusicSpeechSwitch();

    boolean hasProgramId();

    boolean hasProgramServiceName();

    boolean hasProgramType();

    boolean hasProgramTypeName();

    boolean hasRadioText();

    boolean hasTrafficAnnouncementFlag();

    boolean hasTrafficProgramFlag();
}
