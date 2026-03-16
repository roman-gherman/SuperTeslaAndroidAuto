package org.mockito;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Mock {

    public enum Strictness {
        TEST_LEVEL_DEFAULT,
        LENIENT,
        WARN,
        STRICT_STUBS
    }

    Answers answer() default Answers.RETURNS_DEFAULTS;

    Class<?>[] extraInterfaces() default {};

    @Deprecated
    boolean lenient() default false;

    String mockMaker() default "";

    String name() default "";

    boolean serializable() default false;

    Strictness strictness() default Strictness.TEST_LEVEL_DEFAULT;

    boolean stubOnly() default false;
}
