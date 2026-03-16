package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import fr.sd.taada.proto.AbsoluteEvent;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface AbsoluteEventOrBuilder extends MessageLiteOrBuilder {
    AbsoluteEvent.Abs getData(int i);

    int getDataCount();

    List<AbsoluteEvent.Abs> getDataList();
}
