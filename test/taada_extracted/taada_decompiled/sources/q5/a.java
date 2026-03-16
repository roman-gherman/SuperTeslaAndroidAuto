package q5;

import com.google.android.datatransport.runtime.o;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.u;
import java.lang.reflect.Constructor;
import org.mockito.plugins.MemberAccessor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements MemberAccessor.ConstructionDispatcher, SynchronizationGuard.CriticalSection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f4676a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(Object obj, Object obj2, Object obj3) {
        this.f4676a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        r.a aVar = (r.a) this.f4676a;
        EventStore eventStore = aVar.d;
        u uVar = (u) this.b;
        eventStore.persist(uVar, (o) this.c);
        aVar.f4678a.schedule(uVar, 1);
        return null;
    }

    @Override // org.mockito.plugins.MemberAccessor.ConstructionDispatcher
    public Object newInstance() {
        return ((MemberAccessor) this.f4676a).lambda$newInstance$0((Constructor) this.b, (Object[]) this.c);
    }
}
