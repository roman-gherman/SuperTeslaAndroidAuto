package m1;

import g1.C0478b;
import io.ktor.client.plugins.HttpClientPlugin;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import r1.C0793a;

/* JADX INFO: renamed from: m1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0632a implements HttpClientPlugin {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4047a;

    public /* synthetic */ C0632a(int i) {
        this.f4047a = i;
    }

    /* JADX WARN: Path cross not found for [B:26:0x00cf, B:36:0x00fc], limit reached: 61 */
    /* JADX WARN: Path cross not found for [B:43:0x0178, B:45:0x017e], limit reached: 61 */
    /* JADX WARN: Path cross not found for [B:45:0x017e, B:43:0x0178], limit reached: 61 */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ee A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x01ef -> B:59:0x01f6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(io.ktor.client.plugins.Sender r19, q1.c r20, h1.C0494b r21, g1.f r22, U1.c r23) {
        /*
            Method dump skipped, instruction units count: 534
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.C0632a.a(io.ktor.client.plugins.Sender, q1.c, h1.b, g1.f, U1.c):java.lang.Object");
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public final z1.a getKey() {
        switch (this.f4047a) {
            case 0:
                return C0634c.b;
            case 1:
                return C0639h.c;
            case 2:
                return v.e;
            case 3:
                return C0631A.e;
            case 4:
                return D.b;
            case 5:
                return G.b;
            default:
                return L.c;
        }
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public final void install(Object obj, g1.f scope) throws E1.c {
        C5.f fVar;
        E1.h hVar;
        int i = 3;
        int i3 = 2;
        int i4 = 0;
        int i5 = 1;
        Continuation continuation = null;
        switch (this.f4047a) {
            case 0:
                kotlin.jvm.internal.h.f((C0634c) obj, "plugin");
                kotlin.jvm.internal.h.f(scope, "scope");
                E1.h hVar2 = new E1.h("ObservableContent", 0);
                q1.e eVar = scope.e;
                eVar.getClass();
                E1.h reference = q1.e.f4519j;
                kotlin.jvm.internal.h.f(reference, "reference");
                if (!eVar.e(hVar2)) {
                    int iC = eVar.c(reference);
                    if (iC == -1) {
                        throw new E1.c("Phase " + reference + " was not registered for this pipeline");
                    }
                    int i6 = iC + 1;
                    ArrayList arrayList = eVar.f288a;
                    int iX = kotlin.collections.n.x(arrayList);
                    if (i6 <= iX) {
                        while (true) {
                            Object obj2 = arrayList.get(i6);
                            E1.d dVar = obj2 instanceof E1.d ? (E1.d) obj2 : null;
                            if (dVar != null && (fVar = dVar.b) != null) {
                                E1.i iVar = fVar instanceof E1.i ? (E1.i) fVar : null;
                                if (iVar != null && (hVar = iVar.c) != null && hVar.equals(reference)) {
                                    iC = i6;
                                }
                                if (i6 != iX) {
                                    i6++;
                                }
                            }
                        }
                    }
                    arrayList.add(iC + 1, new E1.d(hVar2, new E1.i(reference)));
                }
                eVar.f(hVar2, new C0633b(i, continuation, i4));
                scope.f3296h.f(C0793a.i, new g1.d(i, continuation));
                return;
            case 1:
                C0639h plugin = (C0639h) obj;
                kotlin.jvm.internal.h.f(plugin, "plugin");
                kotlin.jvm.internal.h.f(scope, "scope");
                scope.e.f(q1.e.f4517g, new C0638g(plugin, null));
                return;
            case 2:
                v plugin2 = (v) obj;
                kotlin.jvm.internal.h.f(plugin2, "plugin");
                kotlin.jvm.internal.h.f(scope, "scope");
                scope.e.f(q1.e.f4517g, new C0478b(plugin2, continuation, i5));
                E1.h hVar3 = new E1.h("BeforeReceive", 0);
                C0793a c0793a = scope.f3294f;
                c0793a.getClass();
                E1.h reference2 = C0793a.f4682j;
                kotlin.jvm.internal.h.f(reference2, "reference");
                if (!c0793a.e(hVar3)) {
                    int iC2 = c0793a.c(reference2);
                    if (iC2 == -1) {
                        throw new E1.c("Phase " + reference2 + " was not registered for this pipeline");
                    }
                    c0793a.f288a.add(iC2, new E1.d(hVar3, new E1.j()));
                }
                c0793a.f(hVar3, new C0478b(plugin2, continuation, i3));
                C0632a c0632a = L.b;
                ((L) y.a(scope)).f4042a.add(new C0478b(plugin2, continuation, i));
                return;
            case 3:
                C0631A plugin3 = (C0631A) obj;
                kotlin.jvm.internal.h.f(plugin3, "plugin");
                kotlin.jvm.internal.h.f(scope, "scope");
                scope.e.f(q1.e.f4519j, new z(plugin3, continuation, i4));
                scope.f3294f.f(C0793a.f4684l, new z(plugin3, continuation, i5));
                return;
            case 4:
                D plugin4 = (D) obj;
                kotlin.jvm.internal.h.f(plugin4, "plugin");
                kotlin.jvm.internal.h.f(scope, "scope");
                C0632a c0632a2 = L.b;
                ((L) y.a(scope)).f4042a.add(new j1.d(plugin4, scope, continuation, i5));
                return;
            case 5:
                kotlin.jvm.internal.h.f((G) obj, "plugin");
                kotlin.jvm.internal.h.f(scope, "scope");
                scope.e.f(q1.e.f4517g, new F(scope, null));
                return;
            default:
                L plugin5 = (L) obj;
                kotlin.jvm.internal.h.f(plugin5, "plugin");
                kotlin.jvm.internal.h.f(scope, "scope");
                scope.e.f(q1.e.f4520k, new j1.d(plugin5, scope, continuation, i3));
                return;
        }
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public final Object prepare(Function1 block) {
        switch (this.f4047a) {
            case 0:
                kotlin.jvm.internal.h.f(block, "block");
                return new C0634c();
            case 1:
                kotlin.jvm.internal.h.f(block, "block");
                return new C0639h(block);
            case 2:
                kotlin.jvm.internal.h.f(block, "block");
                s sVar = new s();
                block.invoke(sVar);
                return new v(kotlin.collections.m.e0(sVar.f4064a), kotlin.collections.m.e0(sVar.b), sVar.c);
            case 3:
                kotlin.jvm.internal.h.f(block, "block");
                B2.d dVar = new B2.d();
                block.invoke(dVar);
                return new C0631A((LinkedHashSet) dVar.b, (LinkedHashMap) dVar.c, (Charset) dVar.d);
            case 4:
                kotlin.jvm.internal.h.f(block, "block");
                block.invoke(new z.e(9));
                return new D();
            case 5:
                kotlin.jvm.internal.h.f(block, "block");
                return new G();
            default:
                kotlin.jvm.internal.h.f(block, "block");
                block.invoke(new z5.b(9));
                return new L();
        }
    }
}
