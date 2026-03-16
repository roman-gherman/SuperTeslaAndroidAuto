package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface NavigationCueOrBuilder extends MessageLiteOrBuilder {
    String getAlternateText(int i);

    ByteString getAlternateTextBytes(int i);

    int getAlternateTextCount();

    List<String> getAlternateTextList();
}
