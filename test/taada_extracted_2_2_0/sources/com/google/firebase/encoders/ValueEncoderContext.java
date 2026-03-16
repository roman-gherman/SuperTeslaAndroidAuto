package com.google.firebase.encoders;

/* JADX INFO: loaded from: classes.dex */
public interface ValueEncoderContext {
    ValueEncoderContext add(double d);

    ValueEncoderContext add(float f6);

    ValueEncoderContext add(int i);

    ValueEncoderContext add(long j6);

    ValueEncoderContext add(String str);

    ValueEncoderContext add(boolean z6);

    ValueEncoderContext add(byte[] bArr);
}
