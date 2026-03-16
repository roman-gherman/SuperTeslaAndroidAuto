package B;

import M2.C;
import a3.AbstractC0162z;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IInterface;
import android.os.Parcel;
import android.util.Log;
import c4.AbstractC0246d;
import com.android.billingclient.api.BillingClient$FeatureType;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient$SignOutCallbacks;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.material.resources.CancelableFontCallback$ApplyFont;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.firebase.encoders.DataEncoder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonSerializationContext;
import com.google.gson.internal.ObjectConstructor;
import com.tenjin.android.params.referral.HuaweiInstallReferrer$HuaweiAttributionCallback;
import com.tenjin.android.params.referral.PlayStoreInstallReferrer$PlayStoreAttributionCallback;
import com.tenjin.android.store.DataStore;
import com.tenjin.android.utils.TenjinStartup$StartupCallback;
import h2.D;
import h2.F;
import h2.H;
import h2.J;
import h2.L;
import h2.X;
import h2.a0;
import h2.d0;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.storage.SimpleLock;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.DFS$Visited;
import n2.AbstractC0714f;
import n2.AbstractC0718j;
import n2.EnumC0711c;
import n2.EnumC0719k;
import org.bouncycastle.math.ec.ECPointMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g implements BaseGmsClient$SignOutCallbacks, BaseGmsClient$BaseConnectionCallbacks, BaseGmsClient$BaseOnConnectionFailedListener, RemoteCall, DataEncoder, JsonSerializationContext, JsonDeserializationContext, DeclarationDescriptorVisitor, TenjinStartup$StartupCallback, SamConversionResolver, HuaweiInstallReferrer$HuaweiAttributionCallback, PlayStoreInstallReferrer$PlayStoreAttributionCallback, DataStore, ClassDataFinder, SimpleLock, ECPointMap, CancelableFontCallback$ApplyFont, ObjectConstructor, DFS$Visited {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f97a;
    public Object b;

    public /* synthetic */ g(int i, boolean z6) {
        this.f97a = i;
    }

    public static g a(byte[] bArr, com.google.crypto.tink.n nVar) {
        if (nVar != null) {
            return new g(I0.a.a(bArr), 6);
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public void accept(Object obj, Object obj2) {
        IInterface iInterface;
        F.d dVar = (F.d) obj;
        com.google.android.gms.tasks.c cVar = (com.google.android.gms.tasks.c) obj2;
        synchronized (dVar.f190k) {
            if (dVar.f196r == 5) {
                throw new DeadObjectException();
            }
            if (!dVar.isConnected()) {
                throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
            }
            iInterface = dVar.f194o;
            D.j.d(iInterface, "Client is connected but service is null");
        }
        F.a aVar = (F.a) iInterface;
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(aVar.b);
        int i = O.b.f1174a;
        TelemetryData telemetryData = (TelemetryData) this.b;
        if (telemetryData == null) {
            parcelObtain.writeInt(0);
        } else {
            parcelObtain.writeInt(1);
            telemetryData.writeToParcel(parcelObtain, 0);
        }
        try {
            aVar.f343a.transact(1, parcelObtain, null, 1);
            parcelObtain.recycle();
            cVar.f2174a.d();
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    @Override // com.google.android.material.resources.CancelableFontCallback$ApplyFont
    public void apply(Typeface typeface) {
        com.google.android.material.internal.b bVar = (com.google.android.material.internal.b) this.b;
        if (bVar.j(typeface)) {
            bVar.h(false);
        }
    }

    public int b() {
        SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.b;
        return Math.max(0, (sideSheetBehavior.f2572m - sideSheetBehavior.f2571l) - sideSheetBehavior.f2573n);
    }

    public byte[] c(com.google.crypto.tink.n nVar) {
        if (nVar != null) {
            return ((I0.a) this.b).b();
        }
        throw new NullPointerException("SecretKeyAccess required");
    }

    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS$Visited
    public boolean checkAndMarkVisited(Object obj) {
        return ((HashSet) this.b).add(obj);
    }

    @Override // com.tenjin.android.store.DataStore
    public void clear() {
        ((SharedPreferences) this.b).edit().clear().apply();
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.f97a) {
            case 25:
                Class cls = (Class) this.b;
                try {
                    return com.google.gson.internal.x.f3017a.a(cls);
                } catch (Exception e) {
                    throw new RuntimeException(androidx.constraintlayout.core.motion.a.k(cls, "Unable to create instance of ", ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem."), e);
                }
            default:
                Constructor constructor = (Constructor) this.b;
                try {
                    return constructor.newInstance(new Object[0]);
                } catch (IllegalAccessException e6) {
                    E1.k kVar = O0.c.f1177a;
                    throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e6);
                } catch (InstantiationException e7) {
                    throw new RuntimeException("Failed to invoke constructor '" + O0.c.b(constructor) + "' with no args", e7);
                } catch (InvocationTargetException e8) {
                    throw new RuntimeException("Failed to invoke constructor '" + O0.c.b(constructor) + "' with no args", e8.getCause());
                }
        }
    }

    @Override // com.tenjin.android.store.DataStore
    public boolean contains(String str) {
        return ((SharedPreferences) this.b).contains(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r11, java.lang.StringBuilder r12) {
        /*
            Method dump skipped, instruction units count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B.g.d(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.StringBuilder):void");
    }

    @Override // com.google.gson.JsonDeserializationContext
    public Object deserialize(com.google.gson.p pVar, Type type) {
        com.google.gson.m mVar = ((M0.t) this.b).c;
        mVar.getClass();
        com.google.gson.reflect.a aVar = new com.google.gson.reflect.a(type);
        if (pVar == null) {
            return null;
        }
        M0.h hVar = new M0.h(M0.h.f995t);
        hVar.f996p = new Object[32];
        hVar.q = 0;
        hVar.f997r = new String[32];
        hVar.f998s = new int[32];
        hVar.K(pVar);
        return mVar.b(hVar, aVar);
    }

    public void e(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb, String str) {
        M2.s sVar = (M2.s) this.b;
        M2.x xVar = sVar.d;
        int iOrdinal = ((C) xVar.f1085G.getValue(xVar, M2.x.f1080W[31])).ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                return;
            }
            d(propertyAccessorDescriptor, sb);
        } else {
            sVar.y(propertyAccessorDescriptor, sb);
            sb.append(str.concat(" for "));
            PropertyDescriptor correspondingProperty = propertyAccessorDescriptor.getCorrespondingProperty();
            kotlin.jvm.internal.h.e(correspondingProperty, "descriptor.correspondingProperty");
            M2.s.b(sVar, correspondingProperty, sb);
        }
    }

    @Override // com.google.firebase.encoders.DataEncoder
    public void encode(Object obj, Writer writer) throws IOException {
        K0.d dVar = (K0.d) this.b;
        K0.e eVar = new K0.e(writer, dVar.f926a, dVar.b, dVar.c, dVar.d);
        eVar.b(obj, false);
        eVar.c();
        eVar.c.flush();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public X2.c findClassData(L2.b classId) {
        X2.c cVarFindClassData;
        kotlin.jvm.internal.h.f(classId, "classId");
        L2.c cVarG = classId.g();
        kotlin.jvm.internal.h.e(cVarG, "classId.packageFqName");
        for (PackageFragmentDescriptor packageFragmentDescriptor : AbstractC0718j.i((PackageFragmentProviderOptimized) this.b, cVarG)) {
            if ((packageFragmentDescriptor instanceof Y2.c) && (cVarFindClassData = ((Y2.c) packageFragmentDescriptor).f1486j.findClassData(classId)) != null) {
                return cVarFindClassData;
            }
        }
        return null;
    }

    @Override // com.tenjin.android.store.DataStore
    public Map getAll() {
        return ((SharedPreferences) this.b).getAll();
    }

    @Override // com.tenjin.android.store.DataStore
    public boolean getBoolean(String str, boolean z6) {
        try {
            return ((SharedPreferences) this.b).getBoolean(str, z6);
        } catch (ClassCastException e) {
            Log.e("Tenjin", "Tried to retrieve value from shared prefs but got " + e.getLocalizedMessage());
            return z6;
        }
    }

    @Override // com.tenjin.android.store.DataStore
    public float getFloat(String str, float f6) {
        try {
            return ((SharedPreferences) this.b).getFloat(str, f6);
        } catch (ClassCastException e) {
            Log.e("Tenjin", "Tried to retrieve value from shared prefs but got " + e.getLocalizedMessage());
            return f6;
        }
    }

    @Override // com.tenjin.android.store.DataStore
    public int getInt(String str, int i) {
        try {
            return ((SharedPreferences) this.b).getInt(str, i);
        } catch (ClassCastException e) {
            Log.e("Tenjin", "Tried to retrieve value from shared prefs but got " + e.getLocalizedMessage());
            return i;
        }
    }

    @Override // com.tenjin.android.store.DataStore
    public long getLong(String str, long j6) {
        SharedPreferences sharedPreferences = (SharedPreferences) this.b;
        try {
            sharedPreferences.getString(str, "");
            return sharedPreferences.getLong(str, j6);
        } catch (ClassCastException e) {
            Log.e("Tenjin", "Tried to retrieve value from shared prefs but got " + e.getLocalizedMessage());
            return j6;
        }
    }

    @Override // com.tenjin.android.store.DataStore
    public String getString(String str, String str2) {
        try {
            return ((SharedPreferences) this.b).getString(str, str2);
        } catch (ClassCastException e) {
            Log.e("Tenjin", "Tried to retrieve value from shared prefs but got " + e.getLocalizedMessage());
            return str2;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void lock() {
        ((ReentrantLock) this.b).lock();
    }

    @Override // org.bouncycastle.math.ec.ECPointMap
    public c4.j map(c4.j jVar) {
        return jVar.h((AbstractC0246d) this.b);
    }

    @Override // com.tenjin.android.params.referral.HuaweiInstallReferrer$HuaweiAttributionCallback, com.tenjin.android.params.referral.PlayStoreInstallReferrer$PlayStoreAttributionCallback
    public void onComplete(String str, long j6, long j7) {
        switch (this.f97a) {
            case 15:
                U0.b bVar = (U0.b) this.b;
                U0.c cVar = bVar.c;
                cVar.getClass();
                Y0.b bVar2 = new Y0.b(2, str, Long.valueOf(j6), Long.valueOf(j7));
                cVar.d = bVar2;
                bVar2.g(cVar.b);
                bVar.b.countDown();
                break;
            default:
                U0.b bVar3 = (U0.b) this.b;
                U0.c cVar2 = bVar3.c;
                cVar2.getClass();
                Y0.b bVar4 = new Y0.b(1, str, Long.valueOf(j6), Long.valueOf(j7));
                cVar2.c = bVar4;
                bVar4.g(cVar2.b);
                bVar3.b.countDown();
                break;
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
    public void onConnected(Bundle bundle) {
        ((GoogleApiClient$ConnectionCallbacks) this.b).onConnected(bundle);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
        ((GoogleApiClient$OnConnectionFailedListener) this.b).onConnectionFailed(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
    public void onConnectionSuspended(int i) {
        ((GoogleApiClient$ConnectionCallbacks) this.b).onConnectionSuspended(i);
    }

    @Override // com.tenjin.android.params.referral.HuaweiInstallReferrer$HuaweiAttributionCallback, com.tenjin.android.params.referral.PlayStoreInstallReferrer$PlayStoreAttributionCallback
    public void onFail() {
        switch (this.f97a) {
            case 15:
                ((U0.b) this.b).b.countDown();
                break;
            default:
                ((U0.b) this.b).b.countDown();
                break;
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient$SignOutCallbacks
    public void onSignOutComplete() {
        ((m) this.b).f107k.f95m.post(new k(this, 1));
    }

    @Override // com.tenjin.android.utils.TenjinStartup$StartupCallback
    public void onStartupComplete(U0.c cVar, U0.e eVar) {
        R0.h hVar = (R0.h) this.b;
        if (cVar != null) {
            hVar.f1260a.add(cVar);
        }
        if (eVar != null) {
            hVar.f1260a.add(eVar);
        }
    }

    @Override // com.tenjin.android.store.DataStore
    public void putBoolean(String str, boolean z6) {
        ((SharedPreferences) this.b).edit().putBoolean(str, z6).apply();
    }

    @Override // com.tenjin.android.store.DataStore
    public void putFloat(String str, float f6) {
        ((SharedPreferences) this.b).edit().putFloat(str, f6).apply();
    }

    @Override // com.tenjin.android.store.DataStore
    public void putInt(String str, int i) {
        ((SharedPreferences) this.b).edit().putInt(str, i).apply();
    }

    @Override // com.tenjin.android.store.DataStore
    public void putLong(String str, long j6) {
        ((SharedPreferences) this.b).edit().putLong(str, j6).apply();
    }

    @Override // com.tenjin.android.store.DataStore
    public void putString(String str, String str2) {
        ((SharedPreferences) this.b).edit().putString(str, str2).apply();
    }

    @Override // com.tenjin.android.store.DataStore
    public void remove(String str) {
        ((SharedPreferences) this.b).edit().remove(str).apply();
    }

    @Override // com.google.gson.JsonSerializationContext
    public com.google.gson.p serialize(Object obj) {
        com.google.gson.m mVar = ((M0.t) this.b).c;
        mVar.getClass();
        if (obj == null) {
            return com.google.gson.r.f3040a;
        }
        Class<?> cls = obj.getClass();
        M0.j jVar = new M0.j();
        mVar.j(obj, cls, jVar);
        return jVar.s();
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void unlock() {
        ((ReentrantLock) this.b).unlock();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public Object visitClassDescriptor(ClassDescriptor descriptor, Object obj) {
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        String str;
        switch (this.f97a) {
            case 11:
                StringBuilder builder = (StringBuilder) obj;
                kotlin.jvm.internal.h.f(descriptor, "descriptor");
                kotlin.jvm.internal.h.f(builder, "builder");
                M2.s sVar = (M2.s) this.b;
                sVar.getClass();
                boolean z6 = descriptor.getKind() == EnumC0711c.d;
                if (!sVar.f()) {
                    sVar.m(builder, descriptor, null);
                    List<ReceiverParameterDescriptor> contextReceivers = descriptor.getContextReceivers();
                    kotlin.jvm.internal.h.e(contextReceivers, "klass.contextReceivers");
                    sVar.q(builder, contextReceivers);
                    if (!z6) {
                        AbstractC0714f visibility = descriptor.getVisibility();
                        kotlin.jvm.internal.h.e(visibility, "klass.visibility");
                        sVar.V(visibility, builder);
                    }
                    if ((descriptor.getKind() != EnumC0711c.b || descriptor.getModality() != EnumC0719k.d) && (!descriptor.getKind().a() || descriptor.getModality() != EnumC0719k.f4247a)) {
                        EnumC0719k modality = descriptor.getModality();
                        kotlin.jvm.internal.h.e(modality, "klass.modality");
                        sVar.A(modality, builder, M2.s.j(descriptor));
                    }
                    sVar.y(descriptor, builder);
                    sVar.C(builder, sVar.e().contains(M2.t.INNER) && descriptor.isInner(), "inner");
                    sVar.C(builder, sVar.e().contains(M2.t.DATA) && descriptor.isData(), "data");
                    sVar.C(builder, sVar.e().contains(M2.t.INLINE) && descriptor.isInline(), "inline");
                    sVar.C(builder, sVar.e().contains(M2.t.VALUE) && descriptor.isValue(), "value");
                    sVar.C(builder, sVar.e().contains(M2.t.FUN) && descriptor.isFun(), "fun");
                    if (descriptor instanceof TypeAliasDescriptor) {
                        str = "typealias";
                    } else if (descriptor.isCompanionObject()) {
                        str = "companion object";
                    } else {
                        int iOrdinal = descriptor.getKind().ordinal();
                        if (iOrdinal == 0) {
                            str = "class";
                        } else if (iOrdinal == 1) {
                            str = "interface";
                        } else if (iOrdinal == 2) {
                            str = "enum class";
                        } else if (iOrdinal == 3) {
                            str = "enum entry";
                        } else if (iOrdinal == 4) {
                            str = "annotation class";
                        } else {
                            if (iOrdinal != 5) {
                                throw new C0.x();
                            }
                            str = "object";
                        }
                    }
                    builder.append(sVar.w(str));
                }
                boolean zL = N2.f.l(descriptor);
                M2.x xVar = sVar.d;
                if (zL) {
                    if (((Boolean) xVar.f1084F.getValue(xVar, M2.x.f1080W[30])).booleanValue()) {
                        if (sVar.f()) {
                            builder.append("companion object");
                        }
                        M2.s.L(builder);
                        DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
                        if (containingDeclaration != null) {
                            builder.append("of ");
                            L2.f name = containingDeclaration.getName();
                            kotlin.jvm.internal.h.e(name, "containingDeclaration.name");
                            builder.append(sVar.a(name, false));
                        }
                    }
                    if (sVar.i() || !kotlin.jvm.internal.h.a(descriptor.getName(), L2.h.b)) {
                        if (!sVar.f()) {
                            M2.s.L(builder);
                        }
                        L2.f name2 = descriptor.getName();
                        kotlin.jvm.internal.h.e(name2, "descriptor.name");
                        builder.append(sVar.a(name2, true));
                    }
                } else {
                    if (!sVar.f()) {
                        M2.s.L(builder);
                    }
                    sVar.D(descriptor, builder, true);
                }
                if (!z6) {
                    List<TypeParameterDescriptor> declaredTypeParameters = descriptor.getDeclaredTypeParameters();
                    kotlin.jvm.internal.h.e(declaredTypeParameters, "klass.declaredTypeParameters");
                    sVar.R(builder, declaredTypeParameters, false);
                    sVar.o(descriptor, builder);
                    if (!descriptor.getKind().a()) {
                        if (((Boolean) xVar.i.getValue(xVar, M2.x.f1080W[7])).booleanValue() && (unsubstitutedPrimaryConstructor = descriptor.getUnsubstitutedPrimaryConstructor()) != null) {
                            builder.append(" ");
                            sVar.m(builder, unsubstitutedPrimaryConstructor, null);
                            AbstractC0714f visibility2 = unsubstitutedPrimaryConstructor.getVisibility();
                            kotlin.jvm.internal.h.e(visibility2, "primaryConstructor.visibility");
                            sVar.V(visibility2, builder);
                            builder.append(sVar.w("constructor"));
                            List<ValueParameterDescriptor> valueParameters = unsubstitutedPrimaryConstructor.getValueParameters();
                            kotlin.jvm.internal.h.e(valueParameters, "primaryConstructor.valueParameters");
                            sVar.U(builder, valueParameters, unsubstitutedPrimaryConstructor.hasSynthesizedParameterNames());
                        }
                    }
                    if (!((Boolean) xVar.f1110w.getValue(xVar, M2.x.f1080W[21])).booleanValue() && !k2.i.D(descriptor.getDefaultType())) {
                        Collection<AbstractC0162z> supertypes = descriptor.getTypeConstructor().getSupertypes();
                        kotlin.jvm.internal.h.e(supertypes, "klass.typeConstructor.supertypes");
                        if (!supertypes.isEmpty() && (supertypes.size() != 1 || !k2.i.w(supertypes.iterator().next()))) {
                            M2.s.L(builder);
                            builder.append(": ");
                            kotlin.collections.m.U(supertypes, builder, ", ", null, null, new M2.o(sVar, 2), 60);
                        }
                    }
                    sVar.W(builder, declaredTypeParameters);
                }
                return N1.m.f1129a;
            default:
                return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005c  */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object visitConstructorDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r20, java.lang.Object r21) {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B.g.visitConstructorDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor, java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public Object visitFunctionDescriptor(FunctionDescriptor descriptor, Object obj) {
        switch (this.f97a) {
            case 11:
                d(descriptor, (StringBuilder) obj);
                return N1.m.f1129a;
            default:
                N1.m data = (N1.m) obj;
                kotlin.jvm.internal.h.f(descriptor, "descriptor");
                kotlin.jvm.internal.h.f(data, "data");
                return new F((D) this.b, descriptor);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public Object visitModuleDeclaration(ModuleDescriptor descriptor, Object obj) {
        switch (this.f97a) {
            case 11:
                StringBuilder builder = (StringBuilder) obj;
                kotlin.jvm.internal.h.f(descriptor, "descriptor");
                kotlin.jvm.internal.h.f(builder, "builder");
                ((M2.s) this.b).D(descriptor, builder, true);
                return N1.m.f1129a;
            default:
                return null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public Object visitPackageFragmentDescriptor(PackageFragmentDescriptor descriptor, Object obj) {
        switch (this.f97a) {
            case 11:
                StringBuilder builder = (StringBuilder) obj;
                kotlin.jvm.internal.h.f(descriptor, "descriptor");
                kotlin.jvm.internal.h.f(builder, "builder");
                M2.s sVar = (M2.s) this.b;
                sVar.getClass();
                sVar.H(descriptor.getFqName(), "package-fragment", builder);
                if (sVar.d.getDebugMode()) {
                    builder.append(" in ");
                    sVar.D(descriptor.getContainingDeclaration(), builder, false);
                }
                return N1.m.f1129a;
            default:
                return null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public Object visitPackageViewDescriptor(PackageViewDescriptor descriptor, Object obj) {
        switch (this.f97a) {
            case 11:
                StringBuilder builder = (StringBuilder) obj;
                kotlin.jvm.internal.h.f(descriptor, "descriptor");
                kotlin.jvm.internal.h.f(builder, "builder");
                M2.s sVar = (M2.s) this.b;
                sVar.getClass();
                sVar.H(descriptor.getFqName(), "package", builder);
                if (sVar.d.getDebugMode()) {
                    builder.append(" in context of ");
                    sVar.D(descriptor.getModule(), builder, false);
                }
                return N1.m.f1129a;
            default:
                return null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public Object visitPropertyDescriptor(PropertyDescriptor descriptor, Object obj) {
        switch (this.f97a) {
            case 11:
                StringBuilder builder = (StringBuilder) obj;
                kotlin.jvm.internal.h.f(descriptor, "descriptor");
                kotlin.jvm.internal.h.f(builder, "builder");
                M2.s.b((M2.s) this.b, descriptor, builder);
                return N1.m.f1129a;
            default:
                N1.m data = (N1.m) obj;
                kotlin.jvm.internal.h.f(descriptor, "descriptor");
                kotlin.jvm.internal.h.f(data, "data");
                int i = (descriptor.getDispatchReceiverParameter() != null ? 1 : 0) + (descriptor.getExtensionReceiverParameter() != null ? 1 : 0);
                boolean zIsVar = descriptor.isVar();
                D d = (D) this.b;
                if (zIsVar) {
                    if (i == 0) {
                        return new H(d, descriptor);
                    }
                    if (i == 1) {
                        return new J(d, descriptor);
                    }
                    if (i == 2) {
                        return new L(d, descriptor);
                    }
                } else {
                    if (i == 0) {
                        return new X(d, descriptor);
                    }
                    if (i == 1) {
                        return new a0(d, descriptor);
                    }
                    if (i == 2) {
                        return new d0(d, descriptor);
                    }
                }
                throw new N1.d("Unsupported property: " + descriptor, 2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public Object visitPropertyGetterDescriptor(PropertyGetterDescriptor descriptor, Object obj) {
        switch (this.f97a) {
            case 11:
                StringBuilder builder = (StringBuilder) obj;
                kotlin.jvm.internal.h.f(descriptor, "descriptor");
                kotlin.jvm.internal.h.f(builder, "builder");
                e(descriptor, builder, "getter");
                return N1.m.f1129a;
            default:
                return visitFunctionDescriptor(descriptor, obj);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public Object visitPropertySetterDescriptor(PropertySetterDescriptor descriptor, Object obj) {
        switch (this.f97a) {
            case 11:
                StringBuilder builder = (StringBuilder) obj;
                kotlin.jvm.internal.h.f(descriptor, "descriptor");
                kotlin.jvm.internal.h.f(builder, "builder");
                e(descriptor, builder, "setter");
                return N1.m.f1129a;
            default:
                return visitFunctionDescriptor(descriptor, obj);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public Object visitReceiverParameterDescriptor(ReceiverParameterDescriptor descriptor, Object obj) {
        switch (this.f97a) {
            case 11:
                StringBuilder builder = (StringBuilder) obj;
                kotlin.jvm.internal.h.f(descriptor, "descriptor");
                kotlin.jvm.internal.h.f(builder, "builder");
                builder.append(descriptor.getName());
                return N1.m.f1129a;
            default:
                return null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public Object visitTypeAliasDescriptor(TypeAliasDescriptor descriptor, Object obj) {
        switch (this.f97a) {
            case 11:
                StringBuilder builder = (StringBuilder) obj;
                kotlin.jvm.internal.h.f(descriptor, "descriptor");
                kotlin.jvm.internal.h.f(builder, "builder");
                M2.s sVar = (M2.s) this.b;
                sVar.getClass();
                sVar.m(builder, descriptor, null);
                AbstractC0714f visibility = descriptor.getVisibility();
                kotlin.jvm.internal.h.e(visibility, "typeAlias.visibility");
                sVar.V(visibility, builder);
                sVar.y(descriptor, builder);
                builder.append(sVar.w("typealias"));
                builder.append(" ");
                sVar.D(descriptor, builder, true);
                List<TypeParameterDescriptor> declaredTypeParameters = descriptor.getDeclaredTypeParameters();
                kotlin.jvm.internal.h.e(declaredTypeParameters, "typeAlias.declaredTypeParameters");
                sVar.R(builder, declaredTypeParameters, false);
                sVar.o(descriptor, builder);
                builder.append(" = ");
                builder.append(sVar.M(descriptor.getUnderlyingType()));
                return N1.m.f1129a;
            default:
                return null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public Object visitTypeParameterDescriptor(TypeParameterDescriptor descriptor, Object obj) {
        switch (this.f97a) {
            case 11:
                StringBuilder builder = (StringBuilder) obj;
                kotlin.jvm.internal.h.f(descriptor, "descriptor");
                kotlin.jvm.internal.h.f(builder, "builder");
                ((M2.s) this.b).P(descriptor, builder, true);
                return N1.m.f1129a;
            default:
                return null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public Object visitValueParameterDescriptor(ValueParameterDescriptor descriptor, Object obj) {
        switch (this.f97a) {
            case 11:
                StringBuilder builder = (StringBuilder) obj;
                kotlin.jvm.internal.h.f(descriptor, "descriptor");
                kotlin.jvm.internal.h.f(builder, "builder");
                ((M2.s) this.b).T(descriptor, true, builder, true);
                return N1.m.f1129a;
            default:
                return null;
        }
    }

    public g(J4.m mVar, byte[][] bArr) {
        this.f97a = 7;
        if (mVar == null) {
            throw new NullPointerException("params == null");
        }
        for (byte[] bArr2 : bArr) {
            if (bArr2 == null) {
                throw new NullPointerException("publicKey byte array == null");
            }
        }
        if (bArr.length != mVar.c) {
            throw new IllegalArgumentException("wrong publicKey size");
        }
        for (byte[] bArr3 : bArr) {
            if (bArr3.length != mVar.f894a) {
                throw new IllegalArgumentException("wrong publicKey format");
            }
        }
        this.b = C5.f.k(bArr);
    }

    public /* synthetic */ g(Object obj, int i) {
        this.f97a = i;
        this.b = obj;
    }

    public g(JSONArray jSONArray) {
        this.f97a = 22;
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new com.android.billingclient.api.l(jSONObjectOptJSONObject));
                }
            }
        }
        this.b = arrayList;
    }

    @Override // com.google.gson.JsonSerializationContext
    public com.google.gson.p serialize(Object obj, Type type) {
        com.google.gson.m mVar = ((M0.t) this.b).c;
        mVar.getClass();
        M0.j jVar = new M0.j();
        mVar.j(obj, type, jVar);
        return jVar.s();
    }

    public g(Context context) {
        this.f97a = 17;
        this.b = context.getSharedPreferences("tenjinInstallPreferences", 0);
    }

    @Override // com.google.firebase.encoders.DataEncoder
    public String encode(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            encode(obj, stringWriter);
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }

    public g(D container) {
        this.f97a = 28;
        kotlin.jvm.internal.h.f(container, "container");
        this.b = container;
    }

    public g(StorageManager storageManager) {
        this.f97a = 14;
        this.b = storageManager.createCacheWithNullableValues();
    }

    public g(int i) {
        this.f97a = i;
        switch (i) {
            case 13:
                HashMap map = new HashMap();
                this.b = map;
                Boolean bool = Boolean.FALSE;
                map.put("__tjn_config_mopub_ilrd", bool);
                map.put("__tjn_config_subscription", bool);
                map.put("__tjn_config_subscription_host", "https://subscription-server.staging.tenjin.com");
                map.put("__tjn_config_subscription_endpoint", BillingClient$FeatureType.SUBSCRIPTIONS);
                map.put("__tjn_config_base_host", "https://track.tenjin.com");
                Boolean bool2 = Boolean.TRUE;
                map.put("__tjn_config_mopub_ilrd", bool2);
                map.put("__tjn_config_subscription", bool2);
                break;
            case 29:
                this.b = new HashSet();
                break;
            default:
                this.b = new LinkedHashMap();
                break;
        }
    }
}
