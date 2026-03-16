package kotlin.internal;

import O1.a;
import O1.b;
import W1.d;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.annotation.Repeatable;
import kotlin.jvm.internal.RepeatableContainer;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@SinceKotlin(version = "1.2")
@kotlin.annotation.Target(allowedTargets = {b.f1179a, b.i, b.d, b.f1182h, b.f1188o})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(a.f1178a)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0081\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\rR\u0011\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\rR\u0011\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u000eR\u0011\u0010\b\u001a\u00020\u00078\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\u000fR\u0011\u0010\n\u001a\u00020\t8\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkotlin/internal/RequireKotlin;", "", "", "version", "message", "LN1/a;", "level", "LW1/d;", "versionKind", "", "errorCode", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;Ljava/lang/String;LN1/a;LW1/d;I)V", "()Ljava/lang/String;", "()LN1/a;", "()LW1/d;", "()I", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Repeatable
@java.lang.annotation.Repeatable(Container.class)
public @interface RequireKotlin {

    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {b.f1179a, b.i, b.d, b.f1182h, b.f1188o})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(a.f1178a)
    @RepeatableContainer
    public @interface Container {
        RequireKotlin[] value();
    }

    int errorCode() default -1;

    N1.a level() default N1.a.b;

    String message() default "";

    String version();

    d versionKind() default d.f1391a;
}
