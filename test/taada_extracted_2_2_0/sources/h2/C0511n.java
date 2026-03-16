package h2;

import a3.AbstractC0162z;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;

/* JADX INFO: renamed from: h2.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0511n extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3422a;
    public final /* synthetic */ AbstractC0514q b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0511n(AbstractC0514q abstractC0514q, int i) {
        super(0);
        this.f3422a = i;
        this.b = abstractC0514q;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        AbstractC0162z abstractC0162z;
        int i;
        Type[] lowerBounds;
        Type type = null;
        int i3 = 0;
        AbstractC0514q abstractC0514q = this.b;
        switch (this.f3422a) {
            case 0:
                int size = (abstractC0514q.isSuspend() ? 1 : 0) + abstractC0514q.getParameters().size();
                int size2 = (abstractC0514q.getParameters().size() + 31) / 32;
                Object[] objArr = new Object[size + size2 + 1];
                for (KParameter kParameter : abstractC0514q.getParameters()) {
                    if (kParameter.isOptional()) {
                        KType type2 = kParameter.getType();
                        L2.c cVar = x0.f3452a;
                        kotlin.jvm.internal.h.f(type2, "<this>");
                        n0 n0Var = type2 instanceof n0 ? (n0) type2 : null;
                        if (n0Var == null || (abstractC0162z = n0Var.f3423a) == null || !N2.i.c(abstractC0162z)) {
                            int index = kParameter.getIndex();
                            KType type3 = kParameter.getType();
                            kotlin.jvm.internal.h.f(type3, "<this>");
                            Type javaType = ((n0) type3).getJavaType();
                            if (javaType == null) {
                                javaType = kotlin.reflect.l.F(type3);
                            }
                            objArr[index] = x0.e(javaType);
                        }
                    }
                    if (kParameter.isVararg()) {
                        objArr[kParameter.getIndex()] = AbstractC0514q.a(kParameter.getType());
                    }
                }
                for (int i4 = 0; i4 < size2; i4++) {
                    objArr[size + i4] = 0;
                }
                return objArr;
            case 1:
                return x0.d(abstractC0514q.e());
            case 2:
                CallableMemberDescriptor callableMemberDescriptorE = abstractC0514q.e();
                ArrayList arrayList = new ArrayList();
                if (abstractC0514q.g()) {
                    i = 0;
                } else {
                    ReceiverParameterDescriptor receiverParameterDescriptorG = x0.g(callableMemberDescriptorE);
                    if (receiverParameterDescriptorG != null) {
                        arrayList.add(new U(abstractC0514q, 0, kotlin.reflect.b.f3821a, new C0512o(receiverParameterDescriptorG, 0)));
                        i = 1;
                    } else {
                        i = 0;
                    }
                    ReceiverParameterDescriptor extensionReceiverParameter = callableMemberDescriptorE.getExtensionReceiverParameter();
                    if (extensionReceiverParameter != null) {
                        arrayList.add(new U(abstractC0514q, i, kotlin.reflect.b.b, new C0512o(extensionReceiverParameter, 1)));
                        i++;
                    }
                }
                int size3 = callableMemberDescriptorE.getValueParameters().size();
                while (i3 < size3) {
                    arrayList.add(new U(abstractC0514q, i, kotlin.reflect.b.c, new C0513p(callableMemberDescriptorE, i3)));
                    i3++;
                    i++;
                }
                if (abstractC0514q.f() && (callableMemberDescriptorE instanceof JavaCallableMemberDescriptor) && arrayList.size() > 1) {
                    kotlin.collections.r.E(arrayList, new com.google.android.gms.location.h(5));
                }
                arrayList.trimToSize();
                return arrayList;
            case 3:
                if (abstractC0514q.isSuspend()) {
                    Object objY = kotlin.collections.m.Y(abstractC0514q.b().getParameterTypes());
                    ParameterizedType parameterizedType = objY instanceof ParameterizedType ? (ParameterizedType) objY : null;
                    if (kotlin.jvm.internal.h.a(parameterizedType != null ? parameterizedType.getRawType() : null, Continuation.class)) {
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        kotlin.jvm.internal.h.e(actualTypeArguments, "continuationType.actualTypeArguments");
                        Object objI = kotlin.collections.j.I(actualTypeArguments);
                        WildcardType wildcardType = objI instanceof WildcardType ? (WildcardType) objI : null;
                        if (wildcardType != null && (lowerBounds = wildcardType.getLowerBounds()) != null) {
                            type = (Type) kotlin.collections.j.A(lowerBounds);
                        }
                    }
                }
                return type == null ? abstractC0514q.b().getReturnType() : type;
            case 4:
                AbstractC0162z returnType = abstractC0514q.e().getReturnType();
                kotlin.jvm.internal.h.c(returnType);
                return new n0(returnType, new C0511n(abstractC0514q, 3));
            default:
                List<TypeParameterDescriptor> typeParameters = abstractC0514q.e().getTypeParameters();
                kotlin.jvm.internal.h.e(typeParameters, "descriptor.typeParameters");
                ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(typeParameters));
                for (TypeParameterDescriptor descriptor : typeParameters) {
                    kotlin.jvm.internal.h.e(descriptor, "descriptor");
                    arrayList2.add(new o0(abstractC0514q, descriptor));
                }
                return arrayList2;
        }
    }
}
