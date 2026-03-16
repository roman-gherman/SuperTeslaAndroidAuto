package h2;

import G2.C0125z;
import a3.AbstractC0162z;
import c4.AbstractC0246d;
import g2.C0481c;
import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.FunctionBase;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;

/* JADX INFO: loaded from: classes2.dex */
public class t0 extends kotlin.jvm.internal.x {
    public static D j(kotlin.jvm.internal.b bVar) {
        KDeclarationContainer owner = bVar.getOwner();
        return owner instanceof D ? (D) owner : C0501d.b;
    }

    @Override // kotlin.jvm.internal.x
    public final KFunction a(kotlin.jvm.internal.e eVar) {
        D container = j(eVar);
        String name = eVar.getName();
        String signature = eVar.getSignature();
        Object boundReceiver = eVar.getBoundReceiver();
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(signature, "signature");
        return new F(container, name, signature, null, boundReceiver);
    }

    @Override // kotlin.jvm.internal.x
    public final KClass b(Class cls) {
        return AbstractC0500c.a(cls);
    }

    @Override // kotlin.jvm.internal.x
    public final KDeclarationContainer c(Class jClass, String str) {
        B.h hVar = AbstractC0500c.f3398a;
        kotlin.jvm.internal.h.f(jClass, "jClass");
        return (KDeclarationContainer) AbstractC0500c.b.g(jClass);
    }

    @Override // kotlin.jvm.internal.x
    public final KMutableProperty1 d(kotlin.jvm.internal.j jVar) {
        return new J(j(jVar), jVar.getName(), jVar.getSignature(), jVar.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.x
    public final KProperty0 e(kotlin.jvm.internal.n nVar) {
        return new X(j(nVar), nVar.getName(), nVar.getSignature(), nVar.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.x
    public final KProperty1 f(kotlin.jvm.internal.p pVar) {
        return new a0(j(pVar), pVar.getName(), pVar.getSignature(), pVar.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.x
    public final String g(FunctionBase functionBase) {
        F fB;
        Metadata metadata = (Metadata) functionBase.getClass().getAnnotation(Metadata.class);
        F f6 = null;
        if (metadata != null) {
            String[] strArrD1 = metadata.d1();
            if (strArrD1.length == 0) {
                strArrD1 = null;
            }
            if (strArrD1 != null) {
                String[] strings = metadata.d2();
                C0608i c0608i = K2.h.f942a;
                kotlin.jvm.internal.h.f(strings, "strings");
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(K2.a.a(strArrD1));
                C0608i c0608i2 = K2.h.f942a;
                K2.g gVarG = K2.h.g(byteArrayInputStream, strings);
                C0125z c0125z = (C0125z) C0125z.f687v.parseFrom(byteArrayInputStream, K2.h.f942a);
                K2.f fVar = new K2.f(metadata.mv(), (metadata.xi() & 8) != 0);
                Class<?> cls = functionBase.getClass();
                G2.b0 b0Var = c0125z.f697p;
                kotlin.jvm.internal.h.e(b0Var, "proto.typeTable");
                f6 = new F(C0501d.b, (SimpleFunctionDescriptor) x0.f(cls, c0125z, gVarG, new I2.f(b0Var), fVar, C0481c.f3303a));
            }
        }
        if (f6 == null || (fB = x0.b(f6)) == null) {
            return super.g(functionBase);
        }
        M2.s sVar = u0.f3433a;
        FunctionDescriptor functionDescriptorI = fB.e();
        StringBuilder sb = new StringBuilder();
        u0.a(sb, functionDescriptorI);
        List<ValueParameterDescriptor> valueParameters = functionDescriptorI.getValueParameters();
        kotlin.jvm.internal.h.e(valueParameters, "invoke.valueParameters");
        kotlin.collections.m.U(valueParameters, sb, ", ", "(", ")", C0499b.f3395l, 48);
        sb.append(" -> ");
        AbstractC0162z returnType = functionDescriptorI.getReturnType();
        kotlin.jvm.internal.h.c(returnType);
        sb.append(u0.d(returnType));
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // kotlin.jvm.internal.x
    public final String h(kotlin.jvm.internal.i iVar) {
        return g(iVar);
    }

    @Override // kotlin.jvm.internal.x
    public final KType i(KClass kClass) {
        List arguments = Collections.EMPTY_LIST;
        if (!(kClass instanceof ClassBasedDeclarationContainer)) {
            return AbstractC0246d.C(kClass, arguments, false, arguments);
        }
        Class<?> jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        B.h hVar = AbstractC0500c.f3398a;
        kotlin.jvm.internal.h.f(jClass, "jClass");
        kotlin.jvm.internal.h.f(arguments, "arguments");
        if (arguments.isEmpty()) {
            return (KType) AbstractC0500c.c.g(jClass);
        }
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) AbstractC0500c.d.g(jClass);
        N1.e eVar = new N1.e(arguments, Boolean.FALSE);
        Object obj = concurrentHashMap.get(eVar);
        if (obj == null) {
            n0 n0VarC = AbstractC0246d.C(AbstractC0500c.a(jClass), arguments, false, kotlin.collections.u.f3804a);
            Object objPutIfAbsent = concurrentHashMap.putIfAbsent(eVar, n0VarC);
            obj = objPutIfAbsent == null ? n0VarC : objPutIfAbsent;
        }
        return (KType) obj;
    }
}
