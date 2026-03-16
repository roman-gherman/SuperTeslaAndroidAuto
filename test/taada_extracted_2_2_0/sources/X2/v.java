package X2;

import G2.U;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import n2.AbstractC0718j;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1452a;
    public final /* synthetic */ y b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(y yVar, int i) {
        super(1);
        this.f1452a = i;
        this.b = yVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f1452a) {
            case 0:
                int iIntValue = ((Number) obj).intValue();
                i iVar = this.b.f1455a;
                L2.b bVarW = kotlin.reflect.l.w(iVar.b, iIntValue);
                boolean z6 = bVarW.c;
                g gVar = iVar.f1433a;
                return z6 ? gVar.b(bVarW) : AbstractC0718j.e(gVar.b, bVarW);
            case 1:
                int iIntValue2 = ((Number) obj).intValue();
                i iVar2 = this.b.f1455a;
                L2.b bVarW2 = kotlin.reflect.l.w(iVar2.b, iIntValue2);
                if (!bVarW2.c) {
                    ModuleDescriptor moduleDescriptor = iVar2.f1433a.b;
                    kotlin.jvm.internal.h.f(moduleDescriptor, "<this>");
                    ClassifierDescriptor classifierDescriptorE = AbstractC0718j.e(moduleDescriptor, bVarW2);
                    if (classifierDescriptorE instanceof TypeAliasDescriptor) {
                        return (TypeAliasDescriptor) classifierDescriptorE;
                    }
                }
                return null;
            default:
                U it = (U) obj;
                kotlin.jvm.internal.h.f(it, "it");
                return kotlin.reflect.l.R(it, this.b.f1455a.d);
        }
    }
}
