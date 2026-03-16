package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import fr.sd.taada.proto.InputSourceService;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface InputSourceServiceOrBuilder extends MessageLiteOrBuilder {
    int getDisplayId();

    FeedbackEvent getFeedbackEventsSupported(int i);

    int getFeedbackEventsSupportedCount();

    List<FeedbackEvent> getFeedbackEventsSupportedList();

    int getKeycodesSupported(int i);

    int getKeycodesSupportedCount();

    List<Integer> getKeycodesSupportedList();

    InputSourceService.TouchPad getTouchpad(int i);

    int getTouchpadCount();

    List<InputSourceService.TouchPad> getTouchpadList();

    InputSourceService.TouchScreen getTouchscreen(int i);

    int getTouchscreenCount();

    List<InputSourceService.TouchScreen> getTouchscreenList();

    boolean hasDisplayId();
}
