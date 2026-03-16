package kotlinx.coroutines;

import N1.f;
import O1.a;
import O1.b;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.RequiresOptIn;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE, ElementType.METHOD})
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/InternalCoroutinesApi;", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@RequiresOptIn(level = f.b, message = "This is an internal kotlinx.coroutines API that should not be used from outside of kotlinx.coroutines. No compatibility guarantees are provided. It is recommended to report your use-case of internal API to kotlinx.coroutines issue tracker, so stable API could be provided instead")
@kotlin.annotation.Target(allowedTargets = {b.f1179a, b.i, b.f1188o, b.d})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(a.b)
public @interface InternalCoroutinesApi {
}
