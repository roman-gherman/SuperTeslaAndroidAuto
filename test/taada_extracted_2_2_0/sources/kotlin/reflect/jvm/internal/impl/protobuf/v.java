package kotlin.reflect.jvm.internal.impl.protobuf;

import A2.C0029k;
import a3.AbstractC0162z;
import android.graphics.Matrix;
import com.google.android.material.shape.ShapeAppearancePathProvider$PathListener;
import io.ktor.http.ContentTypeMatcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.utils.DFS$Neighbors;
import m2.C0661m;
import m3.q0;
import u1.C0840e;
import y4.C0937a;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements DFS$Neighbors, ShapeAppearancePathProvider$PathListener, ContentTypeMatcher, ModuleDependencies, ModuleClassResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f3878a;

    public /* synthetic */ v(Object obj) {
        this.f3878a = obj;
    }

    public void a(AbstractC0604e abstractC0604e) {
        if (!abstractC0604e.f()) {
            if (!(abstractC0604e instanceof z)) {
                String strValueOf = String.valueOf(abstractC0604e.getClass());
                throw new IllegalArgumentException(B2.b.h(new StringBuilder(strValueOf.length() + 49), "Has a new type of ByteString been created? Found ", strValueOf));
            }
            z zVar = (z) abstractC0604e;
            a(zVar.c);
            a(zVar.d);
            return;
        }
        int size = abstractC0604e.size();
        int[] iArr = z.f3884h;
        int iBinarySearch = Arrays.binarySearch(iArr, size);
        if (iBinarySearch < 0) {
            iBinarySearch = (-(iBinarySearch + 1)) - 1;
        }
        int i = iArr[iBinarySearch + 1];
        Stack stack = (Stack) this.f3878a;
        if (stack.isEmpty() || ((AbstractC0604e) stack.peek()).size() >= i) {
            stack.push(abstractC0604e);
            return;
        }
        int i3 = iArr[iBinarySearch];
        AbstractC0604e zVar2 = (AbstractC0604e) stack.pop();
        while (!stack.isEmpty() && ((AbstractC0604e) stack.peek()).size() < i3) {
            zVar2 = new z((AbstractC0604e) stack.pop(), zVar2);
        }
        z zVar3 = new z(zVar2, abstractC0604e);
        while (!stack.isEmpty()) {
            int[] iArr2 = z.f3884h;
            int iBinarySearch2 = Arrays.binarySearch(iArr2, zVar3.b);
            if (iBinarySearch2 < 0) {
                iBinarySearch2 = (-(iBinarySearch2 + 1)) - 1;
            }
            if (((AbstractC0604e) stack.peek()).size() >= iArr2[iBinarySearch2 + 1]) {
                break;
            } else {
                zVar3 = new z((AbstractC0604e) stack.pop(), zVar3);
            }
        }
        stack.push(zVar3);
    }

    public void b(byte[] bArr) {
        int i = 2;
        int i3 = 0;
        while (true) {
            y4.f[] fVarArr = (y4.f[]) this.f3878a;
            if (i3 >= fVarArr.length) {
                return;
            }
            y4.f fVar = fVarArr[i3];
            int i4 = i3 << 8;
            int i5 = 0;
            while (true) {
                B2.d[] dVarArr = fVar.b;
                if (i5 < dVarArr.length) {
                    B2.d dVar = dVarArr[i5];
                    short s3 = (short) (i4 + i5);
                    B.h hVar = (B.h) dVar.d;
                    hVar.getClass();
                    byte[] bArr2 = new byte[842];
                    N3.g gVar = (N3.g) hVar.b;
                    gVar.reset();
                    byte[] bArr3 = new byte[i];
                    bArr3[0] = (byte) s3;
                    bArr3[1] = (byte) (s3 >> 8);
                    gVar.update(bArr, 0, bArr.length);
                    gVar.update(bArr3, 0, i);
                    int i6 = 840;
                    gVar.doOutput(bArr2, 0, 840);
                    int iO = B2.d.o(dVar, 0, 256, bArr2, 840);
                    while (iO < 256) {
                        int i7 = i6 % 3;
                        for (int i8 = 0; i8 < i7; i8++) {
                            bArr2[i8] = bArr2[(i6 - i7) + i8];
                        }
                        gVar.doOutput(bArr2, i7, 168);
                        i6 = 168 + i7;
                        iO += B2.d.o(dVar, iO, 256 - iO, bArr2, i6);
                    }
                    i5++;
                    i = 2;
                }
            }
            i3++;
            i = 2;
        }
    }

    public void c(y4.f fVar, y4.f fVar2) {
        int i = 0;
        int i3 = 0;
        while (true) {
            y4.f[] fVarArr = (y4.f[]) this.f3878a;
            if (i3 >= fVarArr.length) {
                return;
            }
            B2.d dVar = fVar.b[i3];
            y4.f fVar3 = fVarArr[i3];
            C0937a c0937a = (C0937a) dVar.c;
            int[] iArr = new int[256];
            c0937a.f5146h.getClass();
            B2.d dVar2 = fVar3.b[i];
            B2.d[] dVarArr = fVar2.b;
            B2.d dVar3 = dVarArr[i];
            int i4 = i;
            for (int i5 = 256; i4 < i5; i5 = 256) {
                ((int[]) dVar.b)[i4] = y4.e.a(((long) ((int[]) dVar2.b)[i4]) * ((long) ((int[]) dVar3.b)[i4]));
                i4++;
                iArr = iArr;
            }
            int[] iArr2 = iArr;
            int i6 = 1;
            while (i6 < c0937a.d) {
                B2.d dVar4 = fVar3.b[i6];
                B2.d dVar5 = dVarArr[i6];
                int i7 = 0;
                while (i7 < 256) {
                    iArr2[i7] = y4.e.a(((long) ((int[]) dVar4.b)[i7]) * ((long) ((int[]) dVar5.b)[i7]));
                    i7++;
                    i6 = i6;
                }
                int i8 = i6;
                for (int i9 = 0; i9 < 256; i9++) {
                    int[] iArr3 = (int[]) dVar.b;
                    iArr3[i9] = iArr3[i9] + iArr2[i9];
                }
                i6 = i8 + 1;
            }
            i3++;
            i = 0;
        }
    }

    @Override // io.ktor.http.ContentTypeMatcher
    public boolean contains(C0840e contentType) {
        kotlin.jvm.internal.h.f(contentType, "contentType");
        return contentType.g((C0840e) this.f3878a);
    }

    public void d(z.e definition) {
        kotlin.jvm.internal.h.f(definition, "definition");
        q0 q0Var = (q0) ((B1.a) this.f3878a).a(definition);
        if (q0Var != null) {
            Object objC = q0Var.c();
            kotlin.jvm.internal.h.d(objC, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            for (r3.k kVarD = (r3.k) objC; !kVarD.equals(q0Var); kVarD = kVarD.d()) {
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    public List getAllDependencies() {
        return (List) this.f3878a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    public List getDirectExpectedByDependencies() {
        return kotlin.collections.u.f3805a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    public Set getModulesWhoseInternalsAreVisible() {
        return kotlin.collections.w.f3807a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS$Neighbors
    public Iterable getNeighbors(Object obj) {
        C0661m c0661m = (C0661m) this.f3878a;
        Collection<AbstractC0162z> supertypes = ((ClassDescriptor) obj).getTypeConstructor().getSupertypes();
        kotlin.jvm.internal.h.e(supertypes, "it.typeConstructor.supertypes");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            ClassifierDescriptor declarationDescriptor = ((AbstractC0162z) it.next()).c().getDeclarationDescriptor();
            ClassifierDescriptor original = declarationDescriptor != null ? declarationDescriptor.getOriginal() : null;
            ClassDescriptor classDescriptor = original instanceof ClassDescriptor ? (ClassDescriptor) original : null;
            C0029k c0029kA = classDescriptor != null ? c0661m.a(classDescriptor) : null;
            if (c0029kA != null) {
                arrayList.add(c0029kA);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.material.shape.ShapeAppearancePathProvider$PathListener
    public void onCornerPathCreated(n0.t tVar, Matrix matrix, int i) {
        n0.f fVar = (n0.f) this.f3878a;
        BitSet bitSet = fVar.d;
        tVar.getClass();
        bitSet.set(i, false);
        tVar.a(tVar.e);
        fVar.b[i] = new n0.m(new ArrayList(tVar.f4223g), new Matrix(matrix));
    }

    @Override // com.google.android.material.shape.ShapeAppearancePathProvider$PathListener
    public void onEdgePathCreated(n0.t tVar, Matrix matrix, int i) {
        n0.f fVar = (n0.f) this.f3878a;
        tVar.getClass();
        fVar.d.set(i + 4, false);
        tVar.a(tVar.e);
        fVar.c[i] = new n0.m(new ArrayList(tVar.f4223g), new Matrix(matrix));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver
    public ClassDescriptor resolveClass(JavaClass javaClass) {
        kotlin.jvm.internal.h.f(javaClass, "javaClass");
        B.h hVar = (B.h) this.f3878a;
        if (hVar != null) {
            return hVar.m(javaClass);
        }
        kotlin.jvm.internal.h.n("resolver");
        throw null;
    }

    public v(C0937a c0937a) {
        int i = c0937a.c;
        this.f3878a = new y4.f[i];
        for (int i3 = 0; i3 < i; i3++) {
            ((y4.f[]) this.f3878a)[i3] = new y4.f(c0937a, 1);
        }
    }

    public v(int i) {
        switch (i) {
            case 5:
                this.f3878a = new B1.a();
                break;
            default:
                this.f3878a = new Stack();
                break;
        }
    }
}
