package h2;

import a3.C0151n;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import k2.C0588g;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import l2.C0617a;
import m2.C0655g;
import m2.C0657i;
import m2.C0661m;
import m2.C0662n;
import p2.C0756a;
import q2.C0763B;
import q2.C0776m;
import s2.C0813c;
import t2.AbstractC0823e;
import v2.C0850a;
import w2.C0870d;
import x2.C0921h;
import z2.C0941a;
import z2.C0943c;
import z2.C0945e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f3426a = new ConcurrentHashMap();

    public static final s2.h a(Class cls) {
        AdditionalClassPartsProvider additionalClassPartsProviderJ;
        PlatformDependentDeclarationFilter platformDependentDeclarationFilterJ;
        int i = 0;
        kotlin.jvm.internal.h.f(cls, "<this>");
        ClassLoader classLoaderD = AbstractC0823e.d(cls);
        y0 y0Var = new y0(classLoaderD);
        ConcurrentHashMap concurrentHashMap = f3426a;
        WeakReference weakReference = (WeakReference) concurrentHashMap.get(y0Var);
        if (weakReference != null) {
            s2.h hVar = (s2.h) weakReference.get();
            if (hVar != null) {
                return hVar;
            }
            concurrentHashMap.remove(y0Var, weakReference);
        }
        C0813c c0813c = new C0813c(classLoaderD);
        ClassLoader classLoader = N1.m.class.getClassLoader();
        kotlin.jvm.internal.h.e(classLoader, "Unit::class.java.classLoader");
        C0813c c0813c2 = new C0813c(classLoader);
        C0813c c0813c3 = new C0813c(classLoaderD);
        String moduleName = "runtime module for " + classLoaderD;
        s2.g gVar = s2.g.f4770a;
        s2.g gVar2 = s2.g.b;
        kotlin.jvm.internal.h.f(moduleName, "moduleName");
        Z2.n nVar = new Z2.n("DeserializationComponentsForJava.ModuleData");
        C0657i c0657i = new C0657i(nVar);
        C0763B c0763b = new C0763B(L2.f.g("<" + moduleName + '>'), nVar, c0657i, 56);
        nVar.compute(new C0588g(i, c0657i, c0763b));
        c0657i.f4090g = new k2.m(c0763b, 1);
        E2.e eVar = new E2.e();
        kotlin.reflect.jvm.internal.impl.protobuf.v vVar = new kotlin.reflect.jvm.internal.impl.protobuf.v();
        C0.t tVar = new C0.t(nVar, c0763b);
        E2.f fVar = E2.f.c;
        SignaturePropagator DO_NOTHING = SignaturePropagator.DO_NOTHING;
        kotlin.jvm.internal.h.e(DO_NOTHING, "DO_NOTHING");
        JavaResolverCache EMPTY = JavaResolverCache.EMPTY;
        kotlin.jvm.internal.h.e(EMPTY, "EMPTY");
        C0921h c0921h = C0921h.f5118a;
        kotlin.collections.u uVar = kotlin.collections.u.f3804a;
        B.g gVar3 = new B.g(nVar);
        n2.v vVar2 = n2.v.b;
        C0850a c0850a = C0850a.f4932a;
        k2.n nVar2 = new k2.n(c0763b, tVar);
        w2.y yVar = w2.y.d;
        C0870d c0870d = new C0870d(yVar);
        C0943c c0943c = C0943c.f5200a;
        D2.s sVar = new D2.s();
        w2.r rVar = w2.r.f5019a;
        NewKotlinTypeChecker.Companion.getClass();
        b3.j jVar = b3.i.b;
        C0945e c0945e = new C0945e(new C0941a(nVar, c0813c3, c0813c, eVar, DO_NOTHING, gVar, EMPTY, c0921h, gVar3, gVar2, vVar, fVar, vVar2, c0850a, c0763b, nVar2, c0870d, sVar, rVar, c0943c, jVar, yVar, new E2.f()));
        K2.f jvmMetadataVersion = K2.f.f938g;
        kotlin.jvm.internal.h.f(jvmMetadataVersion, "jvmMetadataVersion");
        B.h hVar2 = new B.h(c0813c, eVar, 7, false);
        kotlin.reflect.jvm.internal.impl.load.kotlin.l lVar = new kotlin.reflect.jvm.internal.impl.load.kotlin.l(c0763b, tVar, nVar, c0813c);
        lVar.f3840f = jvmMetadataVersion;
        ContractDeserializer.Companion.getClass();
        List listP = io.ktor.utils.io.Z.p(C0151n.f1556a);
        k2.i iVar = c0763b.d;
        C0657i c0657i2 = iVar instanceof C0657i ? (C0657i) iVar : null;
        E2.f fVar2 = E2.f.f302a;
        if (c0657i2 == null || (additionalClassPartsProviderJ = c0657i2.J()) == null) {
            additionalClassPartsProviderJ = C0756a.b;
        }
        AdditionalClassPartsProvider additionalClassPartsProvider = additionalClassPartsProviderJ;
        if (c0657i2 == null || (platformDependentDeclarationFilterJ = c0657i2.J()) == null) {
            platformDependentDeclarationFilterJ = C0756a.d;
        }
        X2.g gVar4 = new X2.g(nVar, c0763b, hVar2, lVar, c0945e, gVar, fVar2, uVar, tVar, additionalClassPartsProvider, platformDependentDeclarationFilterJ, K2.h.f942a, jVar, new B.g(nVar), listP, 262144);
        eVar.f301a = gVar4;
        vVar.f3877a = new B.h(c0945e, EMPTY, 9, false);
        C0661m additionalClassPartsProvider2 = c0657i.J();
        C0661m platformDependentDeclarationFilter = c0657i.J();
        B.g gVar5 = new B.g(nVar);
        kotlin.jvm.internal.h.f(additionalClassPartsProvider2, "additionalClassPartsProvider");
        kotlin.jvm.internal.h.f(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        C0662n c0662n = new C0662n(nVar, c0813c2, c0763b);
        B.g gVar6 = new B.g(c0662n, 18);
        Y2.a aVar = Y2.a.f1482m;
        B.h hVar3 = new B.h(c0763b, tVar, aVar);
        ErrorReporter DO_NOTHING2 = ErrorReporter.DO_NOTHING;
        kotlin.jvm.internal.h.e(DO_NOTHING2, "DO_NOTHING");
        c0662n.d = new X2.g(nVar, c0763b, gVar6, hVar3, c0662n, DO_NOTHING2, X2.h.b, kotlin.collections.n.y(new C0617a(nVar, c0763b), new C0655g(nVar, c0763b)), tVar, additionalClassPartsProvider2, platformDependentDeclarationFilter, aVar.f1392a, jVar, gVar5, null, 786432);
        c0763b.f4532g = new kotlin.reflect.jvm.internal.impl.protobuf.v(kotlin.collections.j.L(new C0763B[]{c0763b}));
        c0763b.f4533h = new C0776m("CompositeProvider@RuntimeModuleData for " + c0763b, kotlin.collections.n.y(c0945e, c0662n));
        s2.h hVar4 = new s2.h(gVar4, new B2.d(eVar, c0813c));
        while (true) {
            WeakReference weakReference2 = (WeakReference) concurrentHashMap.putIfAbsent(y0Var, new WeakReference(hVar4));
            if (weakReference2 == null) {
                return hVar4;
            }
            s2.h hVar5 = (s2.h) weakReference2.get();
            if (hVar5 != null) {
                return hVar5;
            }
            concurrentHashMap.remove(y0Var, weakReference2);
        }
    }
}
