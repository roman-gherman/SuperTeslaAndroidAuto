package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface KeyBindingRequestOrBuilder extends MessageLiteOrBuilder {
    int getKeycodes(int i);

    int getKeycodesCount();

    List<Integer> getKeycodesList();
}
