package com.google.firebase.encoders;

/* JADX INFO: loaded from: classes.dex */
public interface ObjectEncoderContext {
    ObjectEncoderContext add(b bVar, double d);

    ObjectEncoderContext add(b bVar, float f6);

    ObjectEncoderContext add(b bVar, int i);

    ObjectEncoderContext add(b bVar, long j6);

    ObjectEncoderContext add(b bVar, Object obj);

    ObjectEncoderContext add(b bVar, boolean z6);

    @Deprecated
    ObjectEncoderContext add(String str, double d);

    @Deprecated
    ObjectEncoderContext add(String str, int i);

    @Deprecated
    ObjectEncoderContext add(String str, long j6);

    @Deprecated
    ObjectEncoderContext add(String str, Object obj);

    @Deprecated
    ObjectEncoderContext add(String str, boolean z6);

    ObjectEncoderContext inline(Object obj);

    ObjectEncoderContext nested(b bVar);

    ObjectEncoderContext nested(String str);
}
