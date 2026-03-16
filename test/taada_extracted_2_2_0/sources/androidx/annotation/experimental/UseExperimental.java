package androidx.annotation.experimental;

import O1.a;
import O1.b;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B$\u0012\"\u0010\u0002\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00040\u0003\"\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004R\u001f\u0010\u0002\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/annotation/experimental/UseExperimental;", "", "markerClass", "", "Lkotlin/reflect/KClass;", "()[Ljava/lang/Class;", "annotation-experimental_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(message = "This annotation has been replaced by `@OptIn`", replaceWith = @ReplaceWith(expression = "OptIn", imports = {"androidx.annotation.OptIn"}))
@kotlin.annotation.Target(allowedTargets = {b.f1179a, b.d, b.f1180f, b.f1181g, b.f1182h, b.i, b.f1183j, b.f1184k, b.f1187n, b.f1188o})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(a.b)
public @interface UseExperimental {
    Class<? extends Annotation>[] markerClass();
}
