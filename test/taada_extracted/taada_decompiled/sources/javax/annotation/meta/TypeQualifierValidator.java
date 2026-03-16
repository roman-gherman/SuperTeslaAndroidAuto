package javax.annotation.meta;

import M1.a;
import java.lang.annotation.Annotation;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes2.dex */
public interface TypeQualifierValidator<A extends Annotation> {
    @Nonnull
    a forConstantValue(@Nonnull A a6, Object obj);
}
