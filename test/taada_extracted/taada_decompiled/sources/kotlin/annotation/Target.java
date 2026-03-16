package kotlin.annotation;

import O1.b;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
@java.lang.annotation.Target({ElementType.ANNOTATION_TYPE})
@MustBeDocumented
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/annotation/Target;", "", "", "LO1/b;", "allowedTargets", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Lkotlin/Array;)V", "()[LO1/b;", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Target(allowedTargets = {b.b})
@Documented
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
public @interface Target {
    b[] allowedTargets();
}
