package X2;

import a3.C0151n;
import io.ktor.utils.io.Z;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.C0608i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import p2.C0756a;
import v2.C0850a;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StorageManager f1418a;
    public final ModuleDescriptor b;
    public final h c;
    public final ClassDataFinder d;
    public final AnnotationAndConstantLoader e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PackageFragmentProviderOptimized f1419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h f1420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ErrorReporter f1421h;
    public final C0850a i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FlexibleTypeDeserializer f1422j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Iterable f1423k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final C0.t f1424l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final h f1425m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AdditionalClassPartsProvider f1426n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final PlatformDependentDeclarationFilter f1427o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final C0608i f1428p;
    public final NewKotlinTypeChecker q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final PlatformDependentTypeTransformer f1429r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List f1430s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final e f1431t;

    public g(StorageManager storageManager, ModuleDescriptor moduleDescriptor, ClassDataFinder classDataFinder, AnnotationAndConstantLoader annotationAndConstantLoader, PackageFragmentProviderOptimized packageFragmentProviderOptimized, ErrorReporter errorReporter, FlexibleTypeDeserializer flexibleTypeDeserializer, Iterable iterable, C0.t tVar, AdditionalClassPartsProvider additionalClassPartsProvider, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, C0608i extensionRegistryLite, b3.j jVar, B.g gVar, List list, int i) {
        b3.j kotlinTypeChecker;
        h hVar = h.f1432a;
        h hVar2 = h.c;
        C0850a c0850a = C0850a.f4932a;
        h hVar3 = f.b;
        if ((i & 65536) != 0) {
            NewKotlinTypeChecker.Companion.getClass();
            kotlinTypeChecker = b3.i.b;
        } else {
            kotlinTypeChecker = jVar;
        }
        C0756a c0756a = C0756a.e;
        List listP = (i & 524288) != 0 ? Z.p(C0151n.f1556a) : list;
        kotlin.jvm.internal.h.f(extensionRegistryLite, "extensionRegistryLite");
        kotlin.jvm.internal.h.f(kotlinTypeChecker, "kotlinTypeChecker");
        this.f1418a = storageManager;
        this.b = moduleDescriptor;
        this.c = hVar;
        this.d = classDataFinder;
        this.e = annotationAndConstantLoader;
        this.f1419f = packageFragmentProviderOptimized;
        this.f1420g = hVar2;
        this.f1421h = errorReporter;
        this.i = c0850a;
        this.f1422j = flexibleTypeDeserializer;
        this.f1423k = iterable;
        this.f1424l = tVar;
        this.f1425m = hVar3;
        this.f1426n = additionalClassPartsProvider;
        this.f1427o = platformDependentDeclarationFilter;
        this.f1428p = extensionRegistryLite;
        this.q = kotlinTypeChecker;
        this.f1429r = c0756a;
        this.f1430s = listP;
        this.f1431t = new e(this);
    }

    public final i a(PackageFragmentDescriptor descriptor, NameResolver nameResolver, I2.f fVar, I2.g gVar, I2.a metadataVersion, E2.g gVar2) {
        kotlin.jvm.internal.h.f(descriptor, "descriptor");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.h.f(metadataVersion, "metadataVersion");
        return new i(this, nameResolver, descriptor, fVar, gVar, metadataVersion, gVar2, null, kotlin.collections.u.f3804a);
    }

    public final ClassDescriptor b(L2.b classId) {
        kotlin.jvm.internal.h.f(classId, "classId");
        Set set = e.c;
        return this.f1431t.a(classId, null);
    }
}
