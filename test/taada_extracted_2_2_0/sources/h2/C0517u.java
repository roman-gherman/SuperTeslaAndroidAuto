package h2;

import a3.AbstractC0162z;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Type;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0602c;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* JADX INFO: renamed from: h2.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0517u extends kotlin.jvm.internal.i implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3433a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0517u(Object obj, Object obj2, Object obj3, int i) {
        super(0);
        this.f3433a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f3433a) {
            case 0:
                ClassifierDescriptor declarationDescriptor = ((AbstractC0162z) this.b).c().getDeclarationDescriptor();
                if (!(declarationDescriptor instanceof ClassDescriptor)) {
                    throw new N1.d("Supertype not a class: " + declarationDescriptor, 2);
                }
                Class clsJ = x0.j((ClassDescriptor) declarationDescriptor);
                C0519w c0519w = (C0519w) this.c;
                if (clsJ == null) {
                    throw new N1.d("Unsupported superclass of " + c0519w + ": " + declarationDescriptor, 2);
                }
                C0522z c0522z = (C0522z) this.d;
                boolean zA = kotlin.jvm.internal.h.a(c0522z.b.getSuperclass(), clsJ);
                Class cls = c0522z.b;
                if (zA) {
                    Type genericSuperclass = cls.getGenericSuperclass();
                    kotlin.jvm.internal.h.e(genericSuperclass, "{\n                      …ass\n                    }");
                    return genericSuperclass;
                }
                Class<?>[] interfaces = cls.getInterfaces();
                kotlin.jvm.internal.h.e(interfaces, "jClass.interfaces");
                int iE = kotlin.collections.j.E(clsJ, interfaces);
                if (iE >= 0) {
                    Type type = cls.getGenericInterfaces()[iE];
                    kotlin.jvm.internal.h.e(type, "{\n                      …ex]\n                    }");
                    return type;
                }
                throw new N1.d("No superclass of " + c0519w + " in Java reflection for " + declarationDescriptor, 2);
            default:
                return (MessageLite) ((AbstractC0602c) this.b).parseDelimitedFrom((ByteArrayInputStream) this.c, ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l) this.d).f3918a.f1433a.f1428p);
        }
    }
}
