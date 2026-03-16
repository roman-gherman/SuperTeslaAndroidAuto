package e2;

import E1.k;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: renamed from: e2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0425a implements Iterable, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f3130a;
    public final char b;
    public final int c = 1;

    public AbstractC0425a(char c, char c6) {
        this.f3130a = c;
        this.b = (char) k.L(c, c6, 1);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C0426b(this.f3130a, this.b, this.c);
    }
}
