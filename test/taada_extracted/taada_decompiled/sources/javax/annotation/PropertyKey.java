package javax.annotation;

import M1.a;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;

/* JADX INFO: loaded from: classes2.dex */
@TypeQualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PropertyKey {
    a when() default a.f1042a;
}
