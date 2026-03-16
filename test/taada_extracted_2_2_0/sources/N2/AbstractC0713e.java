package n2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper;

/* JADX INFO: renamed from: n2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0713e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0712d f4233a;
    public static final C0712d b;
    public static final C0712d c;
    public static final C0712d d;
    public static final C0712d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0712d f4234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0712d f4235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0712d f4236h;
    public static final C0712d i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Map f4237j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C0712d f4238k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final v f4239l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final v f4240m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final v f4241n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ModuleVisibilityHelper f4242o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final HashMap f4243p;

    static {
        C0712d c0712d = new C0712d(C0702E.c, 0);
        f4233a = c0712d;
        C0712d c0712d2 = new C0712d(C0703F.c, 1);
        b = c0712d2;
        C0712d c0712d3 = new C0712d(C0704G.c, 2);
        c = c0712d3;
        C0712d c0712d4 = new C0712d(C0699B.c, 3);
        d = c0712d4;
        C0712d c0712d5 = new C0712d(C0705H.c, 4);
        e = c0712d5;
        C0712d c0712d6 = new C0712d(C0701D.c, 5);
        f4234f = c0712d6;
        C0712d c0712d7 = new C0712d(C0698A.c, 6);
        f4235g = c0712d7;
        C0712d c0712d8 = new C0712d(C0700C.c, 7);
        f4236h = c0712d8;
        C0712d c0712d9 = new C0712d(C0706I.c, 8);
        i = c0712d9;
        Collections.unmodifiableSet(kotlin.collections.j.N(new AbstractC0714f[]{c0712d, c0712d2, c0712d4, c0712d6}));
        HashMap map = new HashMap(6);
        map.put(c0712d2, 0);
        map.put(c0712d, 0);
        map.put(c0712d4, 1);
        map.put(c0712d3, 1);
        map.put(c0712d5, 2);
        f4237j = Collections.unmodifiableMap(map);
        f4238k = c0712d5;
        f4239l = new v(1);
        f4240m = new v(2);
        f4241n = new v(3);
        Iterator it = ServiceLoader.load(ModuleVisibilityHelper.class, ModuleVisibilityHelper.class.getClassLoader()).iterator();
        f4242o = it.hasNext() ? (ModuleVisibilityHelper) it.next() : g3.p.f3318a;
        f4243p = new HashMap();
        f(c0712d);
        f(c0712d2);
        f(c0712d3);
        f(c0712d4);
        f(c0712d5);
        f(c0712d6);
        f(c0712d7);
        f(c0712d8);
        f(c0712d9);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r8) {
        /*
            r0 = 16
            if (r8 == r0) goto L7
            java.lang.String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L9
        L7:
            java.lang.String r1 = "@NotNull method %s.%s must not return null"
        L9:
            r2 = 3
            r3 = 2
            if (r8 == r0) goto Lf
            r4 = r2
            goto L10
        Lf:
            r4 = r3
        L10:
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities"
            r6 = 1
            r7 = 0
            if (r8 == r6) goto L3a
            if (r8 == r2) goto L3a
            r2 = 5
            if (r8 == r2) goto L3a
            r2 = 7
            if (r8 == r2) goto L3a
            switch(r8) {
                case 9: goto L3a;
                case 10: goto L35;
                case 11: goto L30;
                case 12: goto L35;
                case 13: goto L30;
                case 14: goto L2b;
                case 15: goto L2b;
                case 16: goto L28;
                default: goto L23;
            }
        L23:
            java.lang.String r2 = "what"
            r4[r7] = r2
            goto L3e
        L28:
            r4[r7] = r5
            goto L3e
        L2b:
            java.lang.String r2 = "visibility"
            r4[r7] = r2
            goto L3e
        L30:
            java.lang.String r2 = "second"
            r4[r7] = r2
            goto L3e
        L35:
            java.lang.String r2 = "first"
            r4[r7] = r2
            goto L3e
        L3a:
            java.lang.String r2 = "from"
            r4[r7] = r2
        L3e:
            java.lang.String r2 = "toDescriptorVisibility"
            if (r8 == r0) goto L45
            r4[r6] = r5
            goto L47
        L45:
            r4[r6] = r2
        L47:
            switch(r8) {
                case 2: goto L70;
                case 3: goto L70;
                case 4: goto L6b;
                case 5: goto L6b;
                case 6: goto L66;
                case 7: goto L66;
                case 8: goto L61;
                case 9: goto L61;
                case 10: goto L5c;
                case 11: goto L5c;
                case 12: goto L57;
                case 13: goto L57;
                case 14: goto L52;
                case 15: goto L4f;
                case 16: goto L74;
                default: goto L4a;
            }
        L4a:
            java.lang.String r2 = "isVisible"
            r4[r3] = r2
            goto L74
        L4f:
            r4[r3] = r2
            goto L74
        L52:
            java.lang.String r2 = "isPrivate"
            r4[r3] = r2
            goto L74
        L57:
            java.lang.String r2 = "compare"
            r4[r3] = r2
            goto L74
        L5c:
            java.lang.String r2 = "compareLocal"
            r4[r3] = r2
            goto L74
        L61:
            java.lang.String r2 = "findInvisibleMember"
            r4[r3] = r2
            goto L74
        L66:
            java.lang.String r2 = "inSameFile"
            r4[r3] = r2
            goto L74
        L6b:
            java.lang.String r2 = "isVisibleWithAnyReceiver"
            r4[r3] = r2
            goto L74
        L70:
            java.lang.String r2 = "isVisibleIgnoringReceiver"
            r4[r3] = r2
        L74:
            java.lang.String r1 = java.lang.String.format(r1, r4)
            if (r8 == r0) goto L80
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r1)
            goto L85
        L80:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r1)
        L85:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: n2.AbstractC0713e.a(int):void");
    }

    public static Integer b(AbstractC0714f abstractC0714f, AbstractC0714f abstractC0714f2) {
        if (abstractC0714f == null) {
            a(12);
            throw null;
        }
        if (abstractC0714f2 == null) {
            a(13);
            throw null;
        }
        AbstractC0708K abstractC0708K = ((C0712d) abstractC0714f).f4232a;
        AbstractC0708K abstractC0708K2 = ((C0712d) abstractC0714f2).f4232a;
        Integer numA = abstractC0708K.a(abstractC0708K2);
        if (numA != null) {
            return numA;
        }
        Integer numA2 = abstractC0708K2.a(abstractC0708K);
        if (numA2 != null) {
            return Integer.valueOf(-numA2.intValue());
        }
        return null;
    }

    public static DeclarationDescriptorWithVisibility c(v vVar, CallableMemberDescriptor callableMemberDescriptor, DeclarationDescriptor declarationDescriptor) {
        DeclarationDescriptorWithVisibility declarationDescriptorWithVisibilityC;
        if (callableMemberDescriptor == null) {
            a(8);
            throw null;
        }
        if (declarationDescriptor == null) {
            a(9);
            throw null;
        }
        for (DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility = (DeclarationDescriptorWithVisibility) callableMemberDescriptor.getOriginal(); declarationDescriptorWithVisibility != null && declarationDescriptorWithVisibility.getVisibility() != f4234f; declarationDescriptorWithVisibility = (DeclarationDescriptorWithVisibility) N2.f.i(declarationDescriptorWithVisibility, DeclarationDescriptorWithVisibility.class, true)) {
            if (!declarationDescriptorWithVisibility.getVisibility().a(vVar, declarationDescriptorWithVisibility, declarationDescriptor)) {
                return declarationDescriptorWithVisibility;
            }
        }
        if (!(callableMemberDescriptor instanceof TypeAliasConstructorDescriptor) || (declarationDescriptorWithVisibilityC = c(vVar, ((TypeAliasConstructorDescriptor) callableMemberDescriptor).getUnderlyingConstructorDescriptor(), declarationDescriptor)) == null) {
            return null;
        }
        return declarationDescriptorWithVisibilityC;
    }

    public static boolean d(DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(7);
            throw null;
        }
        SourceFile sourceFileF = N2.f.f(declarationDescriptor);
        if (sourceFileF != SourceFile.NO_SOURCE_FILE) {
            return sourceFileF.equals(N2.f.f(declarationDescriptorWithVisibility));
        }
        return false;
    }

    public static boolean e(AbstractC0714f abstractC0714f) {
        if (abstractC0714f != null) {
            return abstractC0714f == f4233a || abstractC0714f == b;
        }
        a(14);
        throw null;
    }

    public static void f(C0712d c0712d) {
        f4243p.put(c0712d.f4232a, c0712d);
    }

    public static AbstractC0714f g(AbstractC0708K abstractC0708K) {
        if (abstractC0708K == null) {
            a(15);
            throw null;
        }
        AbstractC0714f abstractC0714f = (AbstractC0714f) f4243p.get(abstractC0708K);
        if (abstractC0714f != null) {
            return abstractC0714f;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + abstractC0708K);
    }
}
