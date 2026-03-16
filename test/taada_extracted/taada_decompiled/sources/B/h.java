package B;

import A2.C0019a;
import A2.C0022d;
import G0.C0043c1;
import G0.C0049e1;
import G0.EnumC0046d1;
import G2.C0105e;
import G2.C0106f;
import G2.C0108h;
import G2.C0113m;
import G2.C0120u;
import G2.C0125z;
import G2.EnumC0104d;
import G2.H;
import G2.K;
import G2.L;
import G2.O;
import G2.U;
import G2.Z;
import G2.d0;
import a.AbstractC0132a;
import a3.AbstractC0162z;
import a3.F;
import a3.M;
import a3.T;
import a3.c0;
import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import androidx.core.util.Preconditions;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import c4.AbstractC0243a;
import c4.AbstractC0246d;
import com.android.multidex.ClassPathElement;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.mac.ChunkedMac;
import com.google.crypto.tink.shaded.protobuf.AbstractC0357c;
import com.google.crypto.tink.shaded.protobuf.AbstractC0381o;
import com.google.crypto.tink.shaded.protobuf.D0;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.V;
import e2.C0429e;
import e2.C0430f;
import g4.C0491a;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Provider;
import kotlin.collections.A;
import kotlin.collections.B;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractC0612m;
import kotlin.reflect.jvm.internal.impl.protobuf.C0606g;
import kotlin.reflect.jvm.internal.impl.protobuf.C0609j;
import kotlin.reflect.jvm.internal.impl.protobuf.C0613n;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlinx.coroutines.selects.SelectClause0;
import m3.n0;
import m3.o0;
import n2.AbstractC0718j;
import n2.EnumC0711c;
import net.bytebuddy.pool.TypePool;
import o2.C0738b;
import org.bouncycastle.math.ec.ECPointMap;
import org.bouncycastle.math.ec.endo.GLVEndomorphism;
import s2.C0813c;
import t2.AbstractC0823e;
import u3.C0843a;
import v2.EnumC0851b;
import z2.C0945e;

/* JADX INFO: loaded from: classes.dex */
public final class h implements OnCompleteListener, ClassDataFinder, NameResolver, AnnotationAndConstantLoader, Factory, OnApplyWindowInsetsListener, KeyManager, GLVEndomorphism, SelectClause0, NullabilityAnnotationStates {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f98a;
    public Object b;
    public Object c;

    public /* synthetic */ h(int i, Object obj, Object obj2) {
        this.f98a = i;
        this.c = obj;
        this.b = obj2;
    }

    public static M b(List list) {
        return list.isEmpty() ? M.c : new M(list);
    }

    public void a(Object obj, String str) {
        ((ArrayList) this.b).add(B2.b.f(str, "=", String.valueOf(obj)));
    }

    public C0738b c(C0108h proto, NameResolver nameResolver) {
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        ClassDescriptor classDescriptorF = AbstractC0718j.f((ModuleDescriptor) this.b, kotlin.reflect.l.w(nameResolver, proto.c), (C0.t) this.c);
        Map mapL = kotlin.collections.v.f3805a;
        if (proto.d.size() != 0 && !c3.j.f(classDescriptorF) && N2.f.n(classDescriptorF, EnumC0711c.e)) {
            Collection<ClassConstructorDescriptor> constructors = classDescriptorF.getConstructors();
            kotlin.jvm.internal.h.e(constructors, "annotationClass.constructors");
            ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) kotlin.collections.m.h0(constructors);
            if (classConstructorDescriptor != null) {
                List<ValueParameterDescriptor> valueParameters = classConstructorDescriptor.getValueParameters();
                kotlin.jvm.internal.h.e(valueParameters, "constructor.valueParameters");
                int iF = B.F(kotlin.collections.o.D(valueParameters));
                if (iF < 16) {
                    iF = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iF);
                for (Object obj : valueParameters) {
                    linkedHashMap.put(((ValueParameterDescriptor) obj).getName(), obj);
                }
                List<C0106f> list = proto.d;
                kotlin.jvm.internal.h.e(list, "proto.argumentList");
                ArrayList arrayList = new ArrayList();
                for (C0106f it : list) {
                    kotlin.jvm.internal.h.e(it, "it");
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) linkedHashMap.get(kotlin.reflect.l.I(nameResolver, it.c));
                    if (valueParameterDescriptor != null) {
                        L2.f fVarI = kotlin.reflect.l.I(nameResolver, it.c);
                        AbstractC0162z type = valueParameterDescriptor.getType();
                        kotlin.jvm.internal.h.e(type, "parameter.type");
                        C0105e c0105e = it.d;
                        kotlin.jvm.internal.h.e(c0105e, "proto.value");
                        P2.g gVarN = n(type, c0105e, nameResolver);
                        eVar = d(gVarN, type, c0105e) ? gVarN : null;
                        if (eVar == null) {
                            String message = "Unexpected argument value: actual type " + c0105e.c + " != expected type " + type;
                            kotlin.jvm.internal.h.f(message, "message");
                            eVar = new P2.j(message);
                        }
                        eVar = new N1.e(fVarI, eVar);
                    }
                    if (eVar != null) {
                        arrayList.add(eVar);
                    }
                }
                mapL = A.L(arrayList);
            }
        }
        return new C0738b(classDescriptorF.getDefaultType(), mapL, SourceElement.NO_SOURCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean d(P2.g gVar, AbstractC0162z abstractC0162z, C0105e c0105e) {
        EnumC0104d enumC0104d = c0105e.c;
        int i = enumC0104d == null ? -1 : X2.b.f1413a[enumC0104d.ordinal()];
        if (i == 10) {
            ClassifierDescriptor declarationDescriptor = abstractC0162z.c().getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            if (classDescriptor != null) {
                L2.f fVar = k2.i.f3709f;
                if (!k2.i.b(classDescriptor, k2.o.f3734P)) {
                    return false;
                }
            }
            return true;
        }
        ModuleDescriptor moduleDescriptor = (ModuleDescriptor) this.b;
        if (i != 13) {
            return kotlin.jvm.internal.h.a(gVar.a(moduleDescriptor), abstractC0162z);
        }
        if (gVar instanceof P2.b) {
            P2.b bVar = (P2.b) gVar;
            if (((List) bVar.f1217a).size() == c0105e.f574k.size()) {
                AbstractC0162z abstractC0162zF = moduleDescriptor.getBuiltIns().f(abstractC0162z);
                Collection collection = (Collection) bVar.f1217a;
                kotlin.jvm.internal.h.f(collection, "<this>");
                C0430f c0430f = new C0430f(0, collection.size() - 1, 1);
                if (!(c0430f instanceof Collection) || !((Collection) c0430f).isEmpty()) {
                    C0429e c0429eA = c0430f.iterator();
                    while (c0429eA.c) {
                        int iNextInt = c0429eA.nextInt();
                        P2.g gVar2 = (P2.g) ((List) bVar.f1217a).get(iNextInt);
                        C0105e c0105e2 = (C0105e) c0105e.f574k.get(iNextInt);
                        kotlin.jvm.internal.h.e(c0105e2, "value.getArrayElement(i)");
                        if (!d(gVar2, abstractC0162zF, c0105e2)) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        throw new IllegalStateException(("Deserialized ArrayValue should have the same number of elements as the original array value: " + gVar).toString());
    }

    @Override // org.bouncycastle.math.ec.endo.GLVEndomorphism
    public BigInteger[] decomposeScalar(BigInteger bigInteger) {
        C0491a c0491a = (C0491a) ((h) this.b).c;
        BigInteger bigInteger2 = c0491a.e;
        int i = c0491a.f3341g;
        BigInteger bigIntegerK = AbstractC0132a.k(bigInteger, bigInteger2, i);
        BigInteger bigIntegerK2 = AbstractC0132a.k(bigInteger, c0491a.f3340f, i);
        return new BigInteger[]{bigInteger.subtract(bigIntegerK.multiply(c0491a.f3339a).add(bigIntegerK2.multiply(c0491a.c))), bigIntegerK.multiply(c0491a.b).add(bigIntegerK2.multiply(c0491a.d)).negate()};
    }

    @Override // com.google.crypto.tink.KeyManager
    public boolean doesSupport(String str) {
        return str.equals(((C0.e) this.b).b());
    }

    public void e(String str, Function1 function1) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) ((g) this.c).b;
        D2.t tVar = new D2.t(this, str);
        function1.invoke(tVar);
        ArrayList arrayList = tVar.b;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.o.D(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((String) ((N1.e) it.next()).f1121a);
        }
        String ret = (String) tVar.c.f1121a;
        String str2 = tVar.f264a;
        kotlin.jvm.internal.h.f(ret, "ret");
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append('(');
        sb.append(kotlin.collections.m.V(arrayList2, "", null, null, E2.q.f312a, 30));
        sb.append(')');
        if (ret.length() > 1) {
            ret = "L" + ret + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER;
        }
        sb.append(ret);
        String jvmDescriptor = sb.toString();
        String internalName = (String) this.b;
        kotlin.jvm.internal.h.f(internalName, "internalName");
        kotlin.jvm.internal.h.f(jvmDescriptor, "jvmDescriptor");
        String str3 = internalName + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + jvmDescriptor;
        D2.v vVar = (D2.v) tVar.c.b;
        ArrayList arrayList3 = new ArrayList(kotlin.collections.o.D(arrayList));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList3.add((D2.v) ((N1.e) it2.next()).b);
        }
        linkedHashMap.put(str3, new D2.n(vVar, arrayList3));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.datatransport.runtime.backends.BackendFactory f(java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B.h.f(java.lang.String):com.google.android.datatransport.runtime.backends.BackendFactory");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public X2.c findClassData(L2.b classId) {
        kotlin.jvm.internal.h.f(classId, "classId");
        E2.e eVar = (E2.e) this.c;
        KotlinJvmBinaryClass kotlinJvmBinaryClassU = AbstractC0132a.u((C0813c) this.b, classId, j3.p.g(eVar.c().c));
        if (kotlinJvmBinaryClassU == null) {
            return null;
        }
        AbstractC0823e.a(((s2.e) kotlinJvmBinaryClassU).f4768a).equals(classId);
        return eVar.f(kotlinJvmBinaryClassU);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.i] */
    public Object g(Class key) {
        kotlin.jvm.internal.h.f(key, "key");
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.c;
        Object obj = concurrentHashMap.get(key);
        if (obj != null) {
            return obj;
        }
        Object objInvoke = ((kotlin.jvm.internal.i) this.b).invoke(key);
        Object objPutIfAbsent = concurrentHashMap.putIfAbsent(key, objInvoke);
        return objPutIfAbsent == null ? objInvoke : objPutIfAbsent;
    }

    @Override // javax.inject.Provider
    public Object get() {
        switch (this.f98a) {
            case 15:
                return new com.google.android.datatransport.runtime.scheduling.persistence.k(new D.d(11, (byte) 0), new z5.b(10), com.google.android.datatransport.runtime.scheduling.persistence.a.f1895f, (com.google.android.datatransport.runtime.scheduling.persistence.m) ((com.google.android.datatransport.runtime.scheduling.persistence.c) this.b).get(), (Provider) this.c);
            default:
                return new n.h((Context) ((com.google.android.material.snackbar.f) this.b).f2591a, (n.g) ((com.google.android.datatransport.runtime.scheduling.persistence.c) this.c).get());
        }
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Object getClauseObject() {
        return (o0) this.b;
    }

    @Override // com.google.crypto.tink.KeyManager
    public String getKeyType() {
        return ((C0.e) this.b).b();
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 getOnCancellationConstructor() {
        return null;
    }

    @Override // org.bouncycastle.math.ec.endo.ECEndomorphism
    public ECPointMap getPointMap() {
        return (g) this.c;
    }

    @Override // com.google.crypto.tink.KeyManager
    public Object getPrimitive(AbstractC0381o abstractC0381o) throws GeneralSecurityException {
        C0.e eVar = (C0.e) this.b;
        try {
            MessageLite messageLiteF = eVar.f(abstractC0381o);
            Class cls = (Class) this.c;
            if (Void.class.equals(cls)) {
                throw new GeneralSecurityException("Cannot create a primitive for Void");
            }
            eVar.g(messageLiteF);
            return eVar.c(messageLiteF, cls);
        } catch (V e) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(eVar.f143a.getName()), e);
        }
    }

    @Override // com.google.crypto.tink.KeyManager
    public Class getPrimitiveClass() {
        return (Class) this.c;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 getProcessResFunc() {
        return (C0843a) this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int i) {
        N1.k kVarP = p(i);
        List list = (List) kVarP.f1127a;
        String strV = kotlin.collections.m.V((List) kVarP.b, ".", null, null, null, 62);
        if (list.isEmpty()) {
            return strV;
        }
        return kotlin.collections.m.V(list, "/", null, null, null, 62) + ClassPathElement.SEPARATOR_CHAR + strV;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 getRegFunc() {
        return n0.f4139a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int i) {
        String str = ((O) this.b).b.get(i);
        kotlin.jvm.internal.h.e(str, "strings.getString(index)");
        return str;
    }

    @Override // com.google.crypto.tink.KeyManager
    public int getVersion() {
        ((C0.e) this.b).getClass();
        return 0;
    }

    public c0 h(B2.a aVar) {
        c0 c0VarW0;
        F f6 = aVar.f122f;
        return (f6 == null || (c0VarW0 = AbstractC0246d.w0(f6)) == null) ? (c3.g) ((N1.j) this.b).getValue() : c0VarW0;
    }

    @Override // org.bouncycastle.math.ec.endo.ECEndomorphism
    public boolean hasEfficientPointMap() {
        return true;
    }

    public AbstractC0162z i(TypeParameterDescriptor typeParameter, B2.a typeAttr) {
        kotlin.jvm.internal.h.f(typeParameter, "typeParameter");
        kotlin.jvm.internal.h.f(typeAttr, "typeAttr");
        return (AbstractC0162z) ((Z2.l) this.c).invoke(new T(typeParameter, typeAttr));
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i) {
        return ((Boolean) p(i).c).booleanValue();
    }

    public int j(KClass kClass) {
        int iIntValue;
        kotlin.jvm.internal.h.f(kClass, "kClass");
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.b;
        String qualifiedName = kClass.getQualifiedName();
        kotlin.jvm.internal.h.c(qualifiedName);
        C0019a c0019a = new C0019a(this, 17);
        kotlin.jvm.internal.h.f(concurrentHashMap, "<this>");
        Integer num = (Integer) concurrentHashMap.get(qualifiedName);
        if (num != null) {
            return num.intValue();
        }
        synchronized (concurrentHashMap) {
            try {
                Integer num2 = (Integer) concurrentHashMap.get(qualifiedName);
                if (num2 == null) {
                    Object objInvoke = c0019a.invoke(qualifiedName);
                    concurrentHashMap.putIfAbsent(qualifiedName, Integer.valueOf(((Number) objInvoke).intValue()));
                    num2 = (Integer) objInvoke;
                }
                iIntValue = num2.intValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return iIntValue;
    }

    public void k(C0.o oVar) throws GeneralSecurityException {
        C0.p pVar = new C0.p(oVar.f150a, ChunkedMac.class);
        HashMap map = (HashMap) this.b;
        if (!map.containsKey(pVar)) {
            map.put(pVar, oVar);
            return;
        }
        C0.o oVar2 = (C0.o) map.get(pVar);
        if (oVar2.equals(oVar) && oVar.equals(oVar2)) {
            return;
        }
        throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: " + pVar);
    }

    public void l(PrimitiveWrapper primitiveWrapper) throws GeneralSecurityException {
        if (primitiveWrapper == null) {
            throw new NullPointerException("wrapper must be non-null");
        }
        Class primitiveClass = primitiveWrapper.getPrimitiveClass();
        HashMap map = (HashMap) this.c;
        if (!map.containsKey(primitiveClass)) {
            map.put(primitiveClass, primitiveWrapper);
            return;
        }
        PrimitiveWrapper primitiveWrapper2 = (PrimitiveWrapper) map.get(primitiveClass);
        if (!primitiveWrapper2.equals(primitiveWrapper) || !primitiveWrapper.equals(primitiveWrapper2)) {
            throw new GeneralSecurityException(androidx.constraintlayout.core.motion.a.j(primitiveClass, "Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type"));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public Object loadAnnotationDefaultValue(X2.r container, H proto, AbstractC0162z expectedType) {
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(expectedType, "expectedType");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List loadCallableAnnotations(X2.r container, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite proto, X2.a kind) {
        List list;
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(kind, "kind");
        boolean z6 = proto instanceof C0113m;
        Y2.a aVar = (Y2.a) this.b;
        if (z6) {
            list = (List) ((C0113m) proto).d(aVar.b);
        } else if (proto instanceof C0125z) {
            list = (List) ((C0125z) proto).d(aVar.d);
        } else {
            if (!(proto instanceof H)) {
                throw new IllegalStateException(("Unknown message: " + proto).toString());
            }
            int iOrdinal = kind.ordinal();
            if (iOrdinal == 1) {
                list = (List) ((H) proto).d(aVar.e);
            } else if (iOrdinal == 2) {
                list = (List) ((H) proto).d(aVar.f1393f);
            } else {
                if (iOrdinal != 3) {
                    throw new IllegalStateException("Unsupported callable kind with property proto");
                }
                list = (List) ((H) proto).d(aVar.f1394g);
            }
        }
        if (list == null) {
            list = kotlin.collections.u.f3804a;
        }
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(list));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((h) this.c).c((C0108h) it.next(), container.f1448a));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List loadClassAnnotations(X2.p container) {
        kotlin.jvm.internal.h.f(container, "container");
        Iterable iterable = (List) container.d.d(((Y2.a) this.b).c);
        if (iterable == null) {
            iterable = kotlin.collections.u.f3804a;
        }
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(iterable));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((h) this.c).c((C0108h) it.next(), container.f1448a));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List loadEnumEntryAnnotations(X2.r container, C0120u proto) {
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(proto, "proto");
        Iterable iterable = (List) proto.d(((Y2.a) this.b).f1395h);
        if (iterable == null) {
            iterable = kotlin.collections.u.f3804a;
        }
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(iterable));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((h) this.c).c((C0108h) it.next(), container.f1448a));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List loadExtensionReceiverParameterAnnotations(X2.r container, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite proto, X2.a kind) {
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(kind, "kind");
        boolean z6 = proto instanceof C0125z;
        Y2.a aVar = (Y2.a) this.b;
        if (z6) {
            aVar.getClass();
        } else {
            if (!(proto instanceof H)) {
                throw new IllegalStateException(("Unknown message: " + proto).toString());
            }
            int iOrdinal = kind.ordinal();
            if (iOrdinal != 1 && iOrdinal != 2 && iOrdinal != 3) {
                throw new IllegalStateException(("Unsupported callable kind with property proto for receiver annotations: " + kind).toString());
            }
            aVar.getClass();
        }
        kotlin.collections.u uVar = kotlin.collections.u.f3804a;
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(uVar));
        Iterator<E> it = uVar.iterator();
        while (it.hasNext()) {
            arrayList.add(((h) this.c).c((C0108h) it.next(), container.f1448a));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List loadPropertyBackingFieldAnnotations(X2.r container, H proto) {
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(proto, "proto");
        ((Y2.a) this.b).getClass();
        kotlin.collections.u uVar = kotlin.collections.u.f3804a;
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(uVar));
        Iterator<E> it = uVar.iterator();
        while (it.hasNext()) {
            arrayList.add(((h) this.c).c((C0108h) it.next(), container.f1448a));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public Object loadPropertyConstant(X2.r container, H proto, AbstractC0162z expectedType) {
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(expectedType, "expectedType");
        C0105e c0105e = (C0105e) AbstractC0132a.D(proto, ((Y2.a) this.b).i);
        if (c0105e == null) {
            return null;
        }
        return ((h) this.c).n(expectedType, c0105e, container.f1448a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List loadPropertyDelegateFieldAnnotations(X2.r container, H proto) {
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(proto, "proto");
        ((Y2.a) this.b).getClass();
        kotlin.collections.u uVar = kotlin.collections.u.f3804a;
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(uVar));
        Iterator<E> it = uVar.iterator();
        while (it.hasNext()) {
            arrayList.add(((h) this.c).c((C0108h) it.next(), container.f1448a));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List loadTypeAnnotations(U proto, NameResolver nameResolver) {
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        Iterable iterable = (List) proto.d(((Y2.a) this.b).f1397k);
        if (iterable == null) {
            iterable = kotlin.collections.u.f3804a;
        }
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(iterable));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((h) this.c).c((C0108h) it.next(), nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List loadTypeParameterAnnotations(Z proto, NameResolver nameResolver) {
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        Iterable iterable = (List) proto.d(((Y2.a) this.b).f1398l);
        if (iterable == null) {
            iterable = kotlin.collections.u.f3804a;
        }
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(iterable));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((h) this.c).c((C0108h) it.next(), nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List loadValueParameterAnnotations(X2.r container, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite callableProto, X2.a kind, int i, d0 proto) {
        kotlin.jvm.internal.h.f(container, "container");
        kotlin.jvm.internal.h.f(callableProto, "callableProto");
        kotlin.jvm.internal.h.f(kind, "kind");
        kotlin.jvm.internal.h.f(proto, "proto");
        Iterable iterable = (List) proto.d(((Y2.a) this.b).f1396j);
        if (iterable == null) {
            iterable = kotlin.collections.u.f3804a;
        }
        ArrayList arrayList = new ArrayList(kotlin.collections.o.D(iterable));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((h) this.c).c((C0108h) it.next(), container.f1448a));
        }
        return arrayList;
    }

    public ClassDescriptor m(JavaClass javaClass) {
        L2.c fqName = javaClass.getFqName();
        if (fqName != null && javaClass.getLightClassOriginKind() == C2.a.f166a) {
            return ((JavaResolverCache) this.c).getClassResolvedFromSource(fqName);
        }
        JavaClass outerClass = javaClass.getOuterClass();
        if (outerClass != null) {
            ClassDescriptor classDescriptorM = m(outerClass);
            MemberScope unsubstitutedInnerClassesScope = classDescriptorM != null ? classDescriptorM.getUnsubstitutedInnerClassesScope() : null;
            ClassifierDescriptor contributedClassifier = unsubstitutedInnerClassesScope != null ? unsubstitutedInnerClassesScope.getContributedClassifier(javaClass.getName(), EnumC0851b.f4936h) : null;
            if (contributedClassifier instanceof ClassDescriptor) {
                return (ClassDescriptor) contributedClassifier;
            }
        } else if (fqName != null) {
            L2.c cVarE = fqName.e();
            kotlin.jvm.internal.h.e(cVarE, "fqName.parent()");
            A2.t tVar = (A2.t) kotlin.collections.m.R(((C0945e) this.b).getPackageFragments(cVarE));
            if (tVar != null) {
                A2.z zVar = tVar.f70k.c;
                zVar.getClass();
                return zVar.p(javaClass.getName(), javaClass);
            }
        }
        return null;
    }

    public P2.g n(AbstractC0162z abstractC0162z, C0105e value, NameResolver nameResolver) {
        kotlin.jvm.internal.h.f(value, "value");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        boolean zBooleanValue = I2.e.f772M.c(value.f576m).booleanValue();
        EnumC0104d enumC0104d = value.c;
        switch (enumC0104d == null ? -1 : X2.b.f1413a[enumC0104d.ordinal()]) {
            case 1:
                byte b = (byte) value.d;
                return zBooleanValue ? new P2.x(b) : new P2.d(b);
            case 2:
                return new P2.e(Character.valueOf((char) value.d));
            case 3:
                short s3 = (short) value.d;
                return zBooleanValue ? new P2.x(s3) : new P2.u(s3);
            case 4:
                int i = (int) value.d;
                return zBooleanValue ? new P2.y(i) : new P2.k(i);
            case 5:
                long j6 = value.d;
                return zBooleanValue ? new P2.x(j6) : new P2.s(j6);
            case 6:
                return new P2.c(value.e);
            case 7:
                return new P2.c(value.f570f);
            case 8:
                return new P2.c(Boolean.valueOf(value.d != 0));
            case 9:
                return new P2.v(nameResolver.getString(value.f571g));
            case 10:
                return new P2.r(kotlin.reflect.l.w(nameResolver, value.f572h), value.f575l);
            case 11:
                return new P2.i(kotlin.reflect.l.w(nameResolver, value.f572h), kotlin.reflect.l.I(nameResolver, value.i));
            case 12:
                C0108h c0108h = value.f573j;
                kotlin.jvm.internal.h.e(c0108h, "value.annotation");
                return new P2.a((Object) c(c0108h, nameResolver));
            case 13:
                List<C0105e> list = value.f574k;
                kotlin.jvm.internal.h.e(list, "value.arrayElementList");
                ArrayList arrayList = new ArrayList(kotlin.collections.o.D(list));
                for (C0105e it : list) {
                    F fE = ((ModuleDescriptor) this.b).getBuiltIns().e();
                    kotlin.jvm.internal.h.e(fE, "builtIns.anyType");
                    kotlin.jvm.internal.h.e(it, "it");
                    arrayList.add(n(fE, it, nameResolver));
                }
                return new P2.w(arrayList, abstractC0162z);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + value.c + " (expected " + abstractC0162z + ')').toString());
        }
    }

    @Override // com.google.crypto.tink.KeyManager
    public MessageLite newKey(AbstractC0381o abstractC0381o) throws GeneralSecurityException {
        C0.e eVar = (C0.e) this.b;
        try {
            C0.d dVarD = eVar.d();
            MessageLite messageLiteI = dVarD.i(abstractC0381o);
            dVarD.k(messageLiteI);
            return dVarD.b(messageLiteI);
        } catch (V e) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(eVar.d().b.getName()), e);
        }
    }

    @Override // com.google.crypto.tink.KeyManager
    public C0049e1 newKeyData(AbstractC0381o abstractC0381o) throws GeneralSecurityException {
        C0.e eVar = (C0.e) this.b;
        try {
            C0.d dVarD = eVar.d();
            MessageLite messageLiteI = dVarD.i(abstractC0381o);
            dVarD.k(messageLiteI);
            MessageLite messageLiteB = dVarD.b(messageLiteI);
            C0043c1 c0043c1X = C0049e1.x();
            String strB = eVar.b();
            c0043c1X.p();
            C0049e1.t((C0049e1) c0043c1X.b, strB);
            AbstractC0381o byteString = ((AbstractC0357c) messageLiteB).toByteString();
            c0043c1X.p();
            C0049e1.u((C0049e1) c0043c1X.b, byteString);
            EnumC0046d1 enumC0046d1E = eVar.e();
            c0043c1X.p();
            C0049e1.v((C0049e1) c0043c1X.b, enumC0046d1E);
            return (C0049e1) c0043c1X.build();
        } catch (V e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public P1.j o(a3.Z r17, java.util.List r18, B2.a r19) {
        /*
            Method dump skipped, instruction units count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B.h.o(a3.Z, java.util.List, B2.a):P1.j");
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        com.google.android.material.internal.r rVar = new com.google.android.material.internal.r();
        com.google.android.material.internal.r rVar2 = (com.google.android.material.internal.r) this.c;
        rVar.f2507a = rVar2.f2507a;
        rVar.b = rVar2.b;
        rVar.c = rVar2.c;
        rVar.d = rVar2.d;
        return ((ViewUtils$OnApplyWindowInsetsListener) this.b).onApplyWindowInsets(view, windowInsetsCompat, rVar);
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(com.google.android.gms.tasks.b bVar) {
        switch (this.f98a) {
            case 0:
                ((Map) ((h) this.c).c).remove((com.google.android.gms.tasks.c) this.b);
                return;
            default:
                t0.h hVar = (t0.h) this.c;
                com.google.android.gms.tasks.c cVar = (com.google.android.gms.tasks.c) this.b;
                synchronized (hVar.f4785f) {
                    hVar.e.remove(cVar);
                    break;
                }
                return;
        }
    }

    public N1.k p(int i) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z6 = false;
        while (i != -1) {
            L l6 = (L) ((G2.M) this.c).b.get(i);
            String str = ((O) this.b).b.get(l6.d);
            K k6 = l6.e;
            kotlin.jvm.internal.h.c(k6);
            int iOrdinal = k6.ordinal();
            if (iOrdinal == 0) {
                linkedList2.addFirst(str);
            } else if (iOrdinal == 1) {
                linkedList.addFirst(str);
            } else if (iOrdinal == 2) {
                linkedList2.addFirst(str);
                z6 = true;
            }
            i = l6.c;
        }
        return new N1.k(linkedList, linkedList2, Boolean.valueOf(z6));
    }

    public void q(int i, C0606g c0606g) {
        while (true) {
            Map.Entry entry = (Map.Entry) this.c;
            if (entry == null || ((C0613n) entry.getKey()).f3871a >= i) {
                return;
            }
            C0613n c0613n = (C0613n) ((Map.Entry) this.c).getKey();
            Object value = ((Map.Entry) this.c).getValue();
            C0609j c0609j = C0609j.c;
            kotlin.reflect.jvm.internal.impl.protobuf.M m6 = c0613n.b;
            int i3 = c0613n.f3871a;
            if (c0613n.c) {
                for (Object obj : (List) value) {
                    if (m6 == kotlin.reflect.jvm.internal.impl.protobuf.M.e) {
                        c0606g.x(i3, 3);
                        ((kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) obj).writeTo(c0606g);
                        c0606g.x(i3, 4);
                    } else {
                        c0606g.x(i3, m6.b);
                        C0609j.l(c0606g, m6, obj);
                    }
                }
            } else if (m6 == kotlin.reflect.jvm.internal.impl.protobuf.M.e) {
                c0606g.x(i3, 3);
                ((kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) value).writeTo(c0606g);
                c0606g.x(i3, 4);
            } else {
                c0606g.x(i3, m6.b);
                C0609j.l(c0606g, m6, value);
            }
            Iterator it = (Iterator) this.b;
            if (it.hasNext()) {
                this.c = (Map.Entry) it.next();
            } else {
                this.c = null;
            }
        }
    }

    public void r(boolean z6, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (((Map) this.b)) {
            map = new HashMap((Map) this.b);
        }
        synchronized (((Map) this.c)) {
            map2 = new HashMap((Map) this.c);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z6 || ((Boolean) entry.getValue()).booleanValue()) {
                entry.getKey().getClass();
                throw new ClassCastException();
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z6 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((com.google.android.gms.tasks.c) entry2.getKey()).a(new A.a(status));
            }
        }
    }

    public String toString() {
        switch (this.f98a) {
            case 4:
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.c.getClass().getSimpleName());
                sb.append('{');
                ArrayList arrayList = (ArrayList) this.b;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append((String) arrayList.get(i));
                    if (i < size - 1) {
                        sb.append(", ");
                    }
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public h(AbstractC0243a abstractC0243a, h hVar) {
        this.f98a = 19;
        this.b = hVar;
        this.c = new g(abstractC0243a.f((BigInteger) hVar.b), 21);
    }

    public /* synthetic */ h(Object obj, Object obj2, int i, boolean z6) {
        this.f98a = i;
        this.b = obj;
        this.c = obj2;
    }

    public h(int i) {
        this.f98a = i;
        switch (i) {
            case 3:
                this.b = new HashMap();
                this.c = new HashMap();
                break;
            case 5:
                z.b bVar = z.b.c;
                this.b = new SparseIntArray();
                this.c = bVar;
                break;
            case 13:
                this.b = new ConcurrentHashMap();
                this.c = new AtomicInteger(0);
                break;
            case 25:
                break;
            case 29:
                this.b = new N3.g(128);
                this.c = new N3.g(256);
                break;
            default:
                this.b = Collections.synchronizedMap(new WeakHashMap());
                this.c = Collections.synchronizedMap(new WeakHashMap());
                break;
        }
    }

    @Override // com.google.crypto.tink.KeyManager
    public MessageLite newKey(MessageLite messageLite) throws GeneralSecurityException {
        C0.d dVarD = ((C0.e) this.b).d();
        Class cls = dVarD.b;
        String strConcat = "Expected proto of type ".concat(cls.getName());
        if (cls.isInstance(messageLite)) {
            dVarD.k(messageLite);
            return dVarD.b(messageLite);
        }
        throw new GeneralSecurityException(strConcat);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates
    public Object get(L2.c fqName) {
        kotlin.jvm.internal.h.f(fqName, "fqName");
        return ((Z2.k) this.c).invoke(fqName);
    }

    @Override // com.google.crypto.tink.KeyManager
    public Object getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        C0.e eVar = (C0.e) this.b;
        String strConcat = "Expected proto of type ".concat(eVar.f143a.getName());
        if (eVar.f143a.isInstance(messageLite)) {
            Class cls = (Class) this.c;
            if (!Void.class.equals(cls)) {
                eVar.g(messageLite);
                return eVar.c(messageLite, cls);
            }
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        }
        throw new GeneralSecurityException(strConcat);
    }

    public h(Object obj, int i) {
        this.f98a = i;
        switch (i) {
            case 12:
                this.b = obj;
                this.c = Thread.currentThread();
                break;
            default:
                this.c = obj;
                this.b = new ArrayList();
                break;
        }
    }

    public h(O strings, G2.M qualifiedNames) {
        this.f98a = 8;
        kotlin.jvm.internal.h.f(strings, "strings");
        kotlin.jvm.internal.h.f(qualifiedNames, "qualifiedNames");
        this.b = strings;
        this.c = qualifiedNames;
    }

    public h(z.e eVar) {
        this.f98a = 14;
        Z2.n nVar = new Z2.n("Type parameter upper bound erasure results");
        this.b = AbstractC0132a.M(new C0022d(this, 12));
        this.c = (Z2.l) nVar.createMemoizedFunction(new C0019a(this, 14));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function1 compute) {
        this.f98a = 21;
        kotlin.jvm.internal.h.f(compute, "compute");
        this.b = (kotlin.jvm.internal.i) compute;
        this.c = new ConcurrentHashMap();
    }

    public h(ModuleDescriptor moduleDescriptor, C0.t tVar, Y2.a protocol) {
        this.f98a = 10;
        kotlin.jvm.internal.h.f(protocol, "protocol");
        this.b = protocol;
        this.c = new h(moduleDescriptor, tVar);
    }

    public h(C0.e eVar, Class cls) {
        this.f98a = 18;
        if (!eVar.b.keySet().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(androidx.constraintlayout.core.motion.a.r("Given internalKeyMananger ", eVar.toString(), " does not support primitive class ", cls.getName()));
        }
        this.b = eVar;
        this.c = cls;
    }

    public h(ModuleDescriptor module, C0.t notFoundClasses) {
        this.f98a = 11;
        kotlin.jvm.internal.h.f(module, "module");
        kotlin.jvm.internal.h.f(notFoundClasses, "notFoundClasses");
        this.b = module;
        this.c = notFoundClasses;
    }

    public h(C0.q qVar) {
        this.f98a = 3;
        this.b = new HashMap(qVar.f152a);
        this.c = new HashMap(qVar.b);
    }

    public h(Context context) {
        this.f98a = 23;
        this.c = null;
        this.b = context;
    }

    public h(Map map) {
        this.f98a = 28;
        this.b = map;
        this.c = (Z2.k) new Z2.n("Java nullability annotation states").createMemoizedFunctionWithNullableValues(new t2.q(this, 4));
    }

    public h(o0 o0Var) {
        this.f98a = 27;
        n0 n0Var = n0.f4139a;
        this.b = o0Var;
        this.c = u3.b.f4885a;
    }

    public h(g gVar, String className) {
        this.f98a = 6;
        kotlin.jvm.internal.h.f(className, "className");
        this.c = gVar;
        this.b = className;
    }

    public h(AbstractC0612m abstractC0612m) {
        this.f98a = 22;
        C0609j c0609j = abstractC0612m.f3870a;
        c0609j.getClass();
        Iterator it = ((D0) c0609j.f3868a.entrySet()).iterator();
        this.b = it;
        if (it.hasNext()) {
            this.c = (Map.Entry) it.next();
        }
    }

    public h(com.google.android.material.carousel.e eVar, com.google.android.material.carousel.e eVar2) {
        this.f98a = 16;
        Preconditions.checkArgument(eVar.f2300a <= eVar2.f2300a);
        this.b = eVar;
        this.c = eVar2;
    }
}
