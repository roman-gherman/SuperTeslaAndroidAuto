package o1;

import io.ktor.http.ContentTypeMatcher;
import io.ktor.serialization.Configuration;
import io.ktor.serialization.ContentConverter;
import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.E;
import kotlin.collections.m;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.protobuf.v;
import u1.AbstractC0838c;
import u1.C0840e;

/* JADX INFO: renamed from: o1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0736b implements Configuration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f4268a = m.r0(E.w(i.f4277a, h.b));
    public final ArrayList b = new ArrayList();

    @Override // io.ktor.serialization.Configuration
    public final void register(C0840e contentType, ContentConverter converter, Function1 configuration) {
        kotlin.jvm.internal.h.f(contentType, "contentType");
        kotlin.jvm.internal.h.f(converter, "converter");
        kotlin.jvm.internal.h.f(configuration, "configuration");
        ContentTypeMatcher vVar = contentType.equals(AbstractC0838c.f4859a) ? j.f4278a : new v(contentType);
        configuration.invoke(converter);
        this.b.add(new C0735a(converter, contentType, vVar));
    }
}
