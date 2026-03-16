package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import fr.sd.taada.proto.KeyEvent;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface KeyEventOrBuilder extends MessageLiteOrBuilder {
    KeyEvent.Key getKeys(int i);

    int getKeysCount();

    List<KeyEvent.Key> getKeysList();
}
