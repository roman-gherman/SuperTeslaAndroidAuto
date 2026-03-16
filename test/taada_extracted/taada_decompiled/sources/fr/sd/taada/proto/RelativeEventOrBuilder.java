package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import fr.sd.taada.proto.RelativeEvent;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface RelativeEventOrBuilder extends MessageLiteOrBuilder {
    RelativeEvent.Rel getData(int i);

    int getDataCount();

    List<RelativeEvent.Rel> getDataList();
}
