package l2;

import U2.h;
import io.ktor.utils.io.Z;
import io.ktor.utils.io.b0;
import java.util.List;
import kotlin.collections.u;

/* JADX INFO: renamed from: l2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0622f extends h {
    @Override // U2.h
    public final List a() {
        C0619c c0619c = (C0619c) this.f1333a;
        int iOrdinal = c0619c.f3965g.ordinal();
        return iOrdinal != 0 ? iOrdinal != 1 ? u.f3804a : Z.p(b0.h(c0619c, true)) : Z.p(b0.h(c0619c, false));
    }
}
