package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface NavigationStepDistanceOrBuilder extends MessageLiteOrBuilder {
    NavigationDistance getDistance();

    long getTimeToStepSeconds();

    boolean hasDistance();

    boolean hasTimeToStepSeconds();
}
