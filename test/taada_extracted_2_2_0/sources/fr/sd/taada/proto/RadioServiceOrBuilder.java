package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface RadioServiceOrBuilder extends MessageLiteOrBuilder {
    RadioProperties getRadioProperties(int i);

    int getRadioPropertiesCount();

    List<RadioProperties> getRadioPropertiesList();
}
