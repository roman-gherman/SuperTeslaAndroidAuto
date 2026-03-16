package kotlin.annotation;

import O1.a;
import O1.b;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
@java.lang.annotation.Target({ElementType.ANNOTATION_TYPE})
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/annotation/Retention;", "", "LO1/a;", "value", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(LO1/a;)V", "()LO1/a;", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Target(allowedTargets = {b.b})
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
public @interface Retention {
    a value() default a.c;
}
