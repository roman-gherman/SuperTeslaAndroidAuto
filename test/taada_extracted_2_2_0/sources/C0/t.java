package C0;

import A2.C0019a;
import G0.A1;
import G0.C0073m1;
import G0.EnumC0052f1;
import G2.C0111k;
import G2.C0120u;
import G2.F;
import android.content.Context;
import androidx.room.Room;
import com.android.billingclient.api.z;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.tenjin.android.store.QueueEventDatabase;
import e2.C0430f;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import javax.inject.Provider;
import kotlin.collections.B;
import kotlin.collections.D;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlinx.coroutines.selects.SelectClause2;
import n2.C0722n;
import n2.C0724p;
import w3.C0896n;

/* JADX INFO: loaded from: classes.dex */
public final class t implements ClassDataFinder, MatchResult, Factory, SelectClause2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f156a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;

    public /* synthetic */ t(int i, boolean z6) {
        this.f156a = i;
    }

    public void a(Object obj, Object obj2, C0073m1 c0073m1, boolean z6) throws GeneralSecurityException {
        byte[] bArrArray;
        if (((ConcurrentHashMap) this.c) == null) {
            throw new IllegalStateException("addPrimitive cannot be called after build");
        }
        if (obj == null && obj2 == null) {
            throw new GeneralSecurityException("at least one of the `fullPrimitive` or `primitive` must be set");
        }
        if (c0073m1.getStatus() != EnumC0052f1.ENABLED) {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.c;
        Integer numValueOf = Integer.valueOf(c0073m1.getKeyId());
        if (c0073m1.getOutputPrefixType() == A1.RAW) {
            numValueOf = null;
        }
        com.google.crypto.tink.b bVarA = l.b.a(r.a(c0073m1.getKeyData().getTypeUrl(), c0073m1.getKeyData().getValue(), c0073m1.getKeyData().getKeyMaterialType(), c0073m1.getOutputPrefixType(), numValueOf));
        int iOrdinal = c0073m1.getOutputPrefixType().ordinal();
        if (iOrdinal == 1) {
            bArrArray = ByteBuffer.allocate(5).put((byte) 1).putInt(c0073m1.getKeyId()).array();
        } else if (iOrdinal == 2) {
            bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(c0073m1.getKeyId()).array();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(c0073m1.getKeyId()).array();
        } else {
            bArrArray = com.google.crypto.tink.a.f2791a;
        }
        com.google.crypto.tink.j jVar = new com.google.crypto.tink.j(obj, obj2, bArrArray, c0073m1.getStatus(), c0073m1.getOutputPrefixType(), c0073m1.getKeyId(), c0073m1.getKeyData().getTypeUrl(), bVarA);
        ArrayList arrayList = new ArrayList();
        arrayList.add(jVar);
        byte[] bArr = jVar.c;
        com.google.crypto.tink.k kVar = new com.google.crypto.tink.k(bArr != null ? Arrays.copyOf(bArr, bArr.length) : null);
        List list = (List) concurrentHashMap.put(kVar, Collections.unmodifiableList(arrayList));
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            arrayList2.add(jVar);
            concurrentHashMap.put(kVar, Collections.unmodifiableList(arrayList2));
        }
        if (z6) {
            if (((com.google.crypto.tink.j) this.d) != null) {
                throw new IllegalStateException("you cannot set two primary primitives");
            }
            this.d = jVar;
        }
    }

    public D0.n b() throws GeneralSecurityException {
        Integer num = (Integer) this.b;
        if (num == null) {
            throw new GeneralSecurityException("key size is not set");
        }
        if (((Integer) this.c) == null) {
            throw new GeneralSecurityException("tag size is not set");
        }
        if (((D0.f) this.d) == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        if (((D0.f) this.e) == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        if (num.intValue() < 16) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", (Integer) this.b));
        }
        Integer num2 = (Integer) this.c;
        int iIntValue = num2.intValue();
        D0.f fVar = (D0.f) this.d;
        if (iIntValue < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", num2));
        }
        if (fVar == D0.f.f229g) {
            if (iIntValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num2));
            }
        } else if (fVar == D0.f.f230h) {
            if (iIntValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num2));
            }
        } else if (fVar == D0.f.i) {
            if (iIntValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num2));
            }
        } else if (fVar == D0.f.f231j) {
            if (iIntValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num2));
            }
        } else {
            if (fVar != D0.f.f232k) {
                throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
            }
            if (iIntValue > 64) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num2));
            }
        }
        return new D0.n(((Integer) this.b).intValue(), ((Integer) this.c).intValue(), (D0.f) this.e, (D0.f) this.d);
    }

    public v0.g c() throws GeneralSecurityException {
        Integer num = (Integer) this.b;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (((Integer) this.c) == null) {
            throw new GeneralSecurityException("IV size is not set");
        }
        if (((v0.f) this.e) == null) {
            throw new GeneralSecurityException("Variant is not set");
        }
        if (((Integer) this.d) != null) {
            return new v0.g(num.intValue(), ((Integer) this.c).intValue(), ((Integer) this.d).intValue(), (v0.f) this.e);
        }
        throw new GeneralSecurityException("Tag size is not set");
    }

    public v0.j d() throws GeneralSecurityException {
        Integer num = (Integer) this.b;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (((v0.f) this.e) == null) {
            throw new GeneralSecurityException("Variant is not set");
        }
        if (((Integer) this.c) == null) {
            throw new GeneralSecurityException("IV size is not set");
        }
        if (((Integer) this.d) != null) {
            return new v0.j(num.intValue(), ((Integer) this.c).intValue(), ((Integer) this.d).intValue(), (v0.f) this.e);
        }
        throw new GeneralSecurityException("Tag size is not set");
    }

    public byte[] e(byte[] bArr, int i, J4.k kVar) {
        J4.m mVar = (J4.m) this.b;
        int i3 = mVar.f894a;
        if (bArr.length != i3) {
            throw new IllegalArgumentException(B2.b.d(i3, "startHash needs to be ", "bytes"));
        }
        kVar.a();
        if (i > mVar.b - 1) {
            throw new IllegalArgumentException("max chain length must not be greater than w");
        }
        if (i == 0) {
            return bArr;
        }
        byte[] bArrE = e(bArr, i - 1, kVar);
        J4.i iVar = new J4.i(1);
        iVar.c = kVar.f895a;
        iVar.b = kVar.b;
        iVar.e = kVar.e;
        iVar.f887f = kVar.f891f;
        iVar.f888g = i - 1;
        iVar.d = 0;
        J4.k kVar2 = new J4.k(iVar);
        byte[] bArr2 = (byte[]) this.e;
        byte[] bArrA = kVar2.a();
        z zVar = (z) this.c;
        byte[] bArrA2 = zVar.a(bArr2, bArrA);
        J4.i iVar2 = new J4.i(1);
        iVar2.c = kVar2.f895a;
        iVar2.b = kVar2.b;
        iVar2.e = kVar2.e;
        iVar2.f887f = kVar2.f891f;
        iVar2.f888g = kVar2.f892g;
        iVar2.d = 1;
        byte[] bArrA3 = zVar.a((byte[]) this.e, new J4.k(iVar2).a());
        byte[] bArr3 = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            bArr3[i4] = (byte) (bArrE[i4] ^ bArrA3[i4]);
        }
        int length = bArrA2.length;
        int i5 = zVar.f1864a;
        if (length != i5) {
            throw new IllegalArgumentException("wrong key length");
        }
        if (i3 == i5) {
            return zVar.b(0, bArrA2, bArr3);
        }
        throw new IllegalArgumentException("wrong in length");
    }

    public void f() {
        B.g gVar = new B.g(19, false);
        Y0.c cVar = new Y0.c(this);
        Y0.d dVar = new Y0.d(this, gVar);
        try {
            dVar.start();
            cVar.start();
            dVar.join();
            cVar.join();
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
        ((AtomicBoolean) this.e).set(true);
        B.g gVar2 = (B.g) this.d;
        if (gVar2 != null) {
            gVar2.onStartupComplete((U0.c) this.b, (U0.e) gVar.b);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public X2.c findClassData(L2.b classId) {
        kotlin.jvm.internal.h.f(classId, "classId");
        C0111k c0111k = (C0111k) ((LinkedHashMap) this.e).get(classId);
        if (c0111k == null) {
            return null;
        }
        return new X2.c((B.h) this.b, c0111k, (H2.a) this.c, (SourceElement) ((C0019a) this.d).invoke(classId));
    }

    public ClassDescriptor g(L2.b classId, List list) {
        kotlin.jvm.internal.h.f(classId, "classId");
        return (ClassDescriptor) ((MemoizedFunctionToNotNull) this.e).invoke(new C0722n(classId, list));
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new s.k((Executor) ((Provider) this.b).get(), (EventStore) ((Provider) this.c).get(), (WorkScheduler) ((B2.d) this.d).get(), (SynchronizationGuard) ((Provider) this.e).get());
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Object getClauseObject() {
        return this.b;
    }

    @Override // kotlin.text.MatchResult
    public kotlin.text.d getDestructured() {
        return new kotlin.text.d();
    }

    @Override // kotlin.text.MatchResult
    public List getGroupValues() {
        if (((D) this.e) == null) {
            this.e = new D(this, 1);
        }
        D d = (D) this.e;
        kotlin.jvm.internal.h.c(d);
        return d;
    }

    @Override // kotlin.text.MatchResult
    public MatchGroupCollection getGroups() {
        return (kotlin.text.e) this.d;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 getOnCancellationConstructor() {
        return (v3.f) this.e;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function3, kotlin.jvm.internal.f] */
    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 getProcessResFunc() {
        return (kotlin.jvm.internal.f) this.d;
    }

    @Override // kotlin.text.MatchResult
    public C0430f getRange() {
        Matcher matcher = (Matcher) this.b;
        return E1.k.s0(matcher.start(), matcher.end());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function3, kotlin.jvm.internal.f] */
    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 getRegFunc() {
        return (kotlin.jvm.internal.f) this.c;
    }

    @Override // kotlin.text.MatchResult
    public String getValue() {
        String strGroup = ((Matcher) this.b).group();
        kotlin.jvm.internal.h.e(strGroup, "matchResult.group()");
        return strGroup;
    }

    public B.g h(J4.k kVar) {
        J4.m mVar = (J4.m) this.b;
        byte[][] bArr = new byte[mVar.c][];
        int i = 0;
        while (true) {
            int i3 = mVar.c;
            if (i >= i3) {
                return new B.g(mVar, bArr);
            }
            J4.i iVar = new J4.i(1);
            iVar.c = kVar.f895a;
            iVar.b = kVar.b;
            iVar.e = kVar.e;
            iVar.f887f = i;
            iVar.f888g = kVar.f892g;
            iVar.d = kVar.d;
            kVar = new J4.k(iVar);
            if (i < 0 || i >= i3) {
                break;
            }
            bArr[i] = e(((z) this.c).a((byte[]) this.d, C5.f.k0(32, i)), mVar.b - 1, kVar);
            i++;
        }
        throw new IllegalArgumentException("index out of bounds");
    }

    public byte[] i(byte[] bArr, J4.k kVar) {
        J4.i iVar = new J4.i(1);
        iVar.c = kVar.f895a;
        iVar.b = kVar.b;
        iVar.e = kVar.e;
        return ((z) this.c).a(bArr, new J4.k(iVar).a());
    }

    public void j(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = ((J4.m) this.b).f894a;
        if (length != i) {
            throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
        }
        if (bArr2 == null) {
            throw new NullPointerException("publicSeed == null");
        }
        if (bArr2.length != i) {
            throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
        }
        this.d = bArr;
        this.e = bArr2;
    }

    public boolean k(TypeAliasDescriptor descriptor) {
        kotlin.jvm.internal.h.f(descriptor, "descriptor");
        if (kotlin.jvm.internal.h.a((TypeAliasDescriptor) this.c, descriptor)) {
            return true;
        }
        t tVar = (t) this.b;
        return tVar != null ? tVar.k(descriptor) : false;
    }

    public void l(a aVar) throws GeneralSecurityException {
        aVar.getClass();
        u uVar = new u(r.class, aVar.f139a);
        HashMap map = (HashMap) this.c;
        if (!map.containsKey(uVar)) {
            map.put(uVar, aVar);
            return;
        }
        a aVar2 = (a) map.get(uVar);
        if (aVar2.equals(aVar) && aVar.equals(aVar2)) {
            return;
        }
        throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + uVar);
    }

    public void m(b bVar) throws GeneralSecurityException {
        v vVar = new v(bVar.f140a, r.class);
        HashMap map = (HashMap) this.b;
        if (!map.containsKey(vVar)) {
            map.put(vVar, bVar);
            return;
        }
        b bVar2 = (b) map.get(vVar);
        if (bVar2.equals(bVar) && bVar.equals(bVar2)) {
            return;
        }
        throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + vVar);
    }

    public void n(m mVar) throws GeneralSecurityException {
        mVar.getClass();
        u uVar = new u(s.class, mVar.f148a);
        HashMap map = (HashMap) this.e;
        if (!map.containsKey(uVar)) {
            map.put(uVar, mVar);
            return;
        }
        m mVar2 = (m) map.get(uVar);
        if (mVar2.equals(mVar) && mVar.equals(mVar2)) {
            return;
        }
        throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + uVar);
    }

    @Override // kotlin.text.MatchResult
    public MatchResult next() {
        Matcher matcher = (Matcher) this.b;
        int iEnd = matcher.end() + (matcher.end() == matcher.start() ? 1 : 0);
        CharSequence charSequence = (CharSequence) this.c;
        if (iEnd > charSequence.length()) {
            return null;
        }
        Matcher matcher2 = matcher.pattern().matcher(charSequence);
        kotlin.jvm.internal.h.e(matcher2, "matcher.pattern().matcher(input)");
        if (matcher2.find(iEnd)) {
            return new t(matcher2, charSequence);
        }
        return null;
    }

    public void o(n nVar) throws GeneralSecurityException {
        v vVar = new v(nVar.f149a, s.class);
        HashMap map = (HashMap) this.d;
        if (!map.containsKey(vVar)) {
            map.put(vVar, nVar);
            return;
        }
        n nVar2 = (n) map.get(vVar);
        if (nVar2.equals(nVar) && nVar.equals(nVar2)) {
            return;
        }
        throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + vVar);
    }

    public void p(int i) throws GeneralSecurityException {
        if (i != 12 && i != 16) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", Integer.valueOf(i)));
        }
        this.c = Integer.valueOf(i);
    }

    public void q(int i) throws InvalidAlgorithmParameterException {
        switch (this.f156a) {
            case 19:
                if (i != 16 && i != 24 && i != 32) {
                    throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
                }
                this.b = Integer.valueOf(i);
                return;
            default:
                if (i != 16 && i != 24 && i != 32) {
                    throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
                }
                this.b = Integer.valueOf(i);
                return;
        }
    }

    public void r() {
        switch (this.f156a) {
            case 19:
                this.d = 16;
                break;
            default:
                this.d = 16;
                break;
        }
    }

    public t(J4.m mVar) {
        this.f156a = 3;
        if (mVar == null) {
            throw new NullPointerException("params == null");
        }
        this.b = mVar;
        C0896n c0896n = mVar.d;
        int i = mVar.f894a;
        this.c = new z(i, c0896n);
        this.d = new byte[i];
        this.e = new byte[i];
    }

    public /* synthetic */ t(Object obj, int i) {
        this.f156a = i;
        this.c = null;
        this.d = null;
        this.e = null;
        this.b = obj;
    }

    public /* synthetic */ t(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.f156a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = obj4;
    }

    public t(Context context, B.g gVar) {
        this.f156a = 9;
        this.e = new AtomicBoolean(false);
        this.c = context;
        this.b = new U0.c(context, gVar);
    }

    public t(StorageManager storageManager, ModuleDescriptor moduleDescriptor) {
        this.f156a = 14;
        this.b = storageManager;
        this.c = moduleDescriptor;
        this.d = storageManager.createMemoizedFunction(new C0724p(this, 1));
        this.e = storageManager.createMemoizedFunction(new C0724p(this, 0));
    }

    public t(F f6, B.h hVar, H2.a aVar, C0019a c0019a) {
        this.f156a = 8;
        this.b = hVar;
        this.c = aVar;
        this.d = c0019a;
        List list = f6.f439g;
        kotlin.jvm.internal.h.e(list, "proto.class_List");
        int iF = B.F(kotlin.collections.o.D(list));
        LinkedHashMap linkedHashMap = new LinkedHashMap(iF < 16 ? 16 : iF);
        for (Object obj : list) {
            linkedHashMap.put(kotlin.reflect.l.w((B.h) this.b, ((C0111k) obj).e), obj);
        }
        this.e = linkedHashMap;
    }

    public t(Context context) {
        this.f156a = 7;
        this.e = new Date(System.currentTimeMillis() - 604800000);
        if (QueueEventDatabase.f3066a == null) {
            synchronized (QueueEventDatabase.class) {
                try {
                    if (QueueEventDatabase.f3066a == null) {
                        QueueEventDatabase.f3066a = (QueueEventDatabase) Room.databaseBuilder(context.getApplicationContext(), QueueEventDatabase.class, "queue_event_database").build();
                    }
                } finally {
                }
            }
        }
        this.b = QueueEventDatabase.f3066a.a();
        this.c = Executors.newSingleThreadExecutor();
        this.d = context.getSharedPreferences("tenjinInstallPreferences", 0);
    }

    public t(int i) {
        this.f156a = i;
        switch (i) {
            case 21:
                this.b = new N3.g(128);
                this.e = new N3.g(256);
                this.d = new N3.e(256);
                this.c = new N3.e(512);
                break;
            default:
                this.b = new HashMap();
                this.c = new HashMap();
                this.d = new HashMap();
                this.e = new HashMap();
                break;
        }
    }

    public t(w wVar) {
        this.f156a = 0;
        this.b = new HashMap(wVar.f159a);
        this.c = new HashMap(wVar.b);
        this.d = new HashMap(wVar.c);
        this.e = new HashMap(wVar.d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(Object obj, Function3 function3, Function3 function32, v3.f fVar) {
        this.f156a = 18;
        this.b = obj;
        this.c = (kotlin.jvm.internal.f) function3;
        this.d = (kotlin.jvm.internal.f) function32;
        this.e = fVar;
    }

    public t(Matcher matcher, CharSequence input) {
        this.f156a = 13;
        kotlin.jvm.internal.h.f(input, "input");
        this.b = matcher;
        this.c = input;
        this.d = new kotlin.text.e(this);
    }

    public t(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g gVar) {
        this.f156a = 12;
        this.e = gVar;
        List list = gVar.e.f640t;
        kotlin.jvm.internal.h.e(list, "classProto.enumEntryList");
        int iF = B.F(kotlin.collections.o.D(list));
        LinkedHashMap linkedHashMap = new LinkedHashMap(iF < 16 ? 16 : iF);
        for (Object obj : list) {
            linkedHashMap.put(kotlin.reflect.l.I(gVar.f3900l.b, ((C0120u) obj).d), obj);
        }
        this.b = linkedHashMap;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g gVar2 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g) this.e;
        this.c = gVar2.f3900l.f1433a.f1418a.createMemoizedFunctionWithNullableValues(new A2.q(9, this, gVar2));
        this.d = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g) this.e).f3900l.f1433a.f1418a.createLazyValue(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.k(this, 2));
    }

    public t(Class cls) {
        this.f156a = 11;
        this.c = new ConcurrentHashMap();
        this.b = cls;
        this.e = F0.a.b;
    }
}
