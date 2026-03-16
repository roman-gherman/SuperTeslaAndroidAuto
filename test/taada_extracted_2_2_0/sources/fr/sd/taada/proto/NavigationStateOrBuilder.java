package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface NavigationStateOrBuilder extends MessageLiteOrBuilder {
    NavigationDestination getDestinations(int i);

    int getDestinationsCount();

    List<NavigationDestination> getDestinationsList();

    NavigationStep getSteps(int i);

    int getStepsCount();

    List<NavigationStep> getStepsList();
}
