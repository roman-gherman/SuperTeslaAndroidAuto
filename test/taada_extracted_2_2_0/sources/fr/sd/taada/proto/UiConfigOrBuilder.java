package fr.sd.taada.proto;

import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface UiConfigOrBuilder extends MessageLiteOrBuilder {
    Insets getContentInsets();

    Insets getMargins();

    Insets getStableContentInsets();

    UiTheme getUiTheme();

    boolean hasContentInsets();

    boolean hasMargins();

    boolean hasStableContentInsets();

    boolean hasUiTheme();
}
