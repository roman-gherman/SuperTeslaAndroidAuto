package L3;

import java.security.Permission;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends Permission {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f982a;

    public d(String str) {
        super(str);
        HashSet hashSet = new HashSet();
        this.f982a = hashSet;
        hashSet.add(str);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof d) && this.f982a.equals(((d) obj).f982a);
    }

    @Override // java.security.Permission
    public final String getActions() {
        return this.f982a.toString();
    }

    public final int hashCode() {
        return this.f982a.hashCode();
    }

    @Override // java.security.Permission
    public final boolean implies(Permission permission) {
        if (!(permission instanceof d)) {
            return false;
        }
        d dVar = (d) permission;
        return getName().equals(dVar.getName()) || this.f982a.containsAll(dVar.f982a);
    }
}
