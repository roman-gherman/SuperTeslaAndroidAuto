package m2;

import io.ktor.utils.io.Z;
import java.util.List;
import kotlin.collections.u;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import n2.AbstractC0713e;
import n2.EnumC0709a;
import n2.EnumC0719k;
import q2.AbstractC0765b;
import q2.L;

/* JADX INFO: renamed from: m2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0649a extends U2.h {
    public static final L2.f d = L2.f.e("clone");

    @Override // U2.h
    public final List a() {
        Annotations.Companion.getClass();
        EnumC0709a enumC0709a = EnumC0709a.f4227a;
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        AbstractC0765b abstractC0765b = this.f1333a;
        L lR = L.r(abstractC0765b, d, enumC0709a, sourceElement);
        ReceiverParameterDescriptor thisAsReceiverParameter = abstractC0765b.getThisAsReceiverParameter();
        u uVar = u.f3805a;
        lR.l(null, thisAsReceiverParameter, uVar, uVar, uVar, R2.e.e(abstractC0765b).e(), EnumC0719k.c, AbstractC0713e.c);
        return Z.p(lR);
    }
}
