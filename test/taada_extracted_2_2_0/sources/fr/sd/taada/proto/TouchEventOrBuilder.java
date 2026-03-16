package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import fr.sd.taada.proto.TouchEvent;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface TouchEventOrBuilder extends MessageLiteOrBuilder {
    PointerAction getAction();

    int getActionIndex();

    TouchEvent.Pointer getPointerData(int i);

    int getPointerDataCount();

    List<TouchEvent.Pointer> getPointerDataList();

    boolean hasAction();

    boolean hasActionIndex();
}
