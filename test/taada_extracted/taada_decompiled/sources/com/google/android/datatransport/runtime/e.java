package com.google.android.datatransport.runtime;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: loaded from: classes.dex */
public final class e implements ObjectEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f1875a = new e();

    static {
        com.google.firebase.encoders.b.a("clientMetrics");
    }

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        if (obj != null) {
            throw new ClassCastException();
        }
        throw null;
    }
}
