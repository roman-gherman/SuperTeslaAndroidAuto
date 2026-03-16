package com.google.android.gms.common.annotation;

import com.google.errorprone.annotations.Keep;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Keep
@Documented
public @interface KeepForSdk {
}
