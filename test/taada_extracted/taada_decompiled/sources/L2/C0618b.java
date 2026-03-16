package l2;

import C0.x;
import a3.AbstractC0139b;
import a3.C;
import a3.K;
import a3.M;
import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import k2.p;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.collections.o;
import kotlin.collections.u;
import kotlin.jvm.internal.h;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import n2.AbstractC0718j;
import n2.v;

/* JADX INFO: renamed from: l2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0618b extends AbstractC0139b {
    public final /* synthetic */ C0619c c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0618b(C0619c c0619c) {
        super(c0619c.e);
        this.c = c0619c;
    }

    @Override // a3.AbstractC0147j
    public final Collection a() {
        List<L2.b> listP;
        Iterable iterableP;
        C0619c c0619c = this.c;
        int iOrdinal = c0619c.f3965g.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            listP = Z.p(C0619c.f3962l);
        } else {
            int i = c0619c.f3966h;
            if (iOrdinal == 2) {
                listP = n.y(C0619c.f3963m, new L2.b(p.f3767k, EnumC0621e.d.a(i)));
            } else {
                if (iOrdinal != 3) {
                    throw new x();
                }
                listP = n.y(C0619c.f3963m, new L2.b(p.e, EnumC0621e.e.a(i)));
            }
        }
        ModuleDescriptor containingDeclaration = c0619c.f3964f.getContainingDeclaration();
        ArrayList arrayList = new ArrayList(o.D(listP));
        for (L2.b bVar : listP) {
            ClassDescriptor classDescriptorD = AbstractC0718j.d(containingDeclaration, bVar);
            if (classDescriptorD == null) {
                throw new IllegalStateException(("Built-in class " + bVar + " not found").toString());
            }
            int size = classDescriptorD.getTypeConstructor().getParameters().size();
            List list = c0619c.f3968k;
            h.f(list, "<this>");
            if (size < 0) {
                throw new IllegalArgumentException(B2.b.d(size, "Requested element count ", " is less than zero.").toString());
            }
            if (size == 0) {
                iterableP = u.f3804a;
            } else {
                int size2 = list.size();
                if (size >= size2) {
                    iterableP = m.o0(list);
                } else if (size == 1) {
                    iterableP = Z.p(m.X(list));
                } else {
                    ArrayList arrayList2 = new ArrayList(size);
                    if (list instanceof RandomAccess) {
                        for (int i3 = size2 - size; i3 < size2; i3++) {
                            arrayList2.add(list.get(i3));
                        }
                    } else {
                        ListIterator listIterator = list.listIterator(size2 - size);
                        while (listIterator.hasNext()) {
                            arrayList2.add(listIterator.next());
                        }
                    }
                    iterableP = arrayList2;
                }
            }
            ArrayList arrayList3 = new ArrayList(o.D(iterableP));
            Iterator it = iterableP.iterator();
            while (it.hasNext()) {
                arrayList3.add(new K(((TypeParameterDescriptor) it.next()).getDefaultType()));
            }
            M.b.getClass();
            arrayList.add(C.b(M.c, classDescriptorD, arrayList3));
        }
        return m.o0(arrayList);
    }

    @Override // a3.AbstractC0147j
    public final SupertypeLoopChecker d() {
        return v.b;
    }

    @Override // a3.AbstractC0139b, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final ClassifierDescriptor getDeclarationDescriptor() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final List getParameters() {
        return this.c.f3968k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public final boolean isDenotable() {
        return true;
    }

    @Override // a3.AbstractC0139b
    /* JADX INFO: renamed from: j */
    public final ClassDescriptor getDeclarationDescriptor() {
        return this.c;
    }

    public final String toString() {
        return this.c.toString();
    }
}
