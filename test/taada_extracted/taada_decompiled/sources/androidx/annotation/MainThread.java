package androidx.annotation;

import O1.a;
import O1.b;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.MustBeDocumented;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@kotlin.annotation.Target(allowedTargets = {b.i, b.f1183j, b.f1184k, b.f1182h, b.b, b.f1179a, b.f1181g})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(a.b)
@MustBeDocumented
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/annotation/MainThread;", "", "annotation"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Documented
public @interface MainThread {
}
