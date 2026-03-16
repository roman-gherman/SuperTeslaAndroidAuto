package net.bytebuddy.agent.utility.nullability;

import M1.a;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierNickname;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Nonnull(when = a.b)
@TypeQualifierNickname
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface UnknownNull {
}
