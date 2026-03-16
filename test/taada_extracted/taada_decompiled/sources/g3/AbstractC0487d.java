package g3;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: renamed from: g3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0487d implements Iterable, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC0484a f3308a;

    public final boolean isEmpty() {
        return this.f3308a.a() == 0;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f3308a.iterator();
    }
}
