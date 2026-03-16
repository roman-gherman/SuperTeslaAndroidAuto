package com.google.firebase.encoders.proto;

import L0.c;
import com.google.firebase.encoders.annotations.ExtraProperty;

/* JADX INFO: loaded from: classes.dex */
@ExtraProperty
public @interface Protobuf {
    c intEncoding() default c.f949a;

    int tag();
}
