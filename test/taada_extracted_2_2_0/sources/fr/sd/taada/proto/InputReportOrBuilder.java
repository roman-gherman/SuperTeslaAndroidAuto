package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface InputReportOrBuilder extends MessageLiteOrBuilder {
    AbsoluteEvent getAbsoluteEvent();

    @Deprecated
    int getDispChannelId();

    KeyEvent getKeyEvent();

    RelativeEvent getRelativeEvent();

    long getTimestamp();

    TouchEvent getTouchEvent();

    TouchEvent getTouchpadEvent();

    boolean hasAbsoluteEvent();

    @Deprecated
    boolean hasDispChannelId();

    boolean hasKeyEvent();

    boolean hasRelativeEvent();

    boolean hasTimestamp();

    boolean hasTouchEvent();

    boolean hasTouchpadEvent();
}
