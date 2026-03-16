package R2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.o;
import kotlin.collections.u;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS$Neighbors;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements DFS$Neighbors {
    public static final a b = new a(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1270a;

    public /* synthetic */ a(int i) {
        this.f1270a = i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS$Neighbors
    public final Iterable getNeighbors(Object obj) {
        switch (this.f1270a) {
            case 0:
                int i = e.f1273a;
                Collection<ValueParameterDescriptor> overriddenDescriptors = ((ValueParameterDescriptor) obj).getOverriddenDescriptors();
                ArrayList arrayList = new ArrayList(o.D(overriddenDescriptors));
                Iterator<T> it = overriddenDescriptors.iterator();
                while (it.hasNext()) {
                    arrayList.add(((ValueParameterDescriptor) it.next()).getOriginal());
                }
                return arrayList;
            default:
                CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) obj;
                Collection<? extends CallableMemberDescriptor> overriddenDescriptors2 = callableMemberDescriptor != null ? callableMemberDescriptor.getOverriddenDescriptors() : null;
                return overriddenDescriptors2 == null ? u.f3804a : overriddenDescriptors2;
        }
    }
}
