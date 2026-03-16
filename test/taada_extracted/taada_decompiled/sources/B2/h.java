package B2;

import M2.s;
import a3.AbstractC0155s;
import a3.AbstractC0162z;
import a3.F;
import a3.M;
import a3.c0;
import c4.AbstractC0246d;
import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.m;
import kotlin.collections.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.text.i;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends AbstractC0155s implements RawType {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(F lowerBound, F upperBound) {
        super(lowerBound, upperBound);
        kotlin.jvm.internal.h.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.h.f(upperBound, "upperBound");
        KotlinTypeChecker.DEFAULT.isSubtypeOf(lowerBound, upperBound);
    }

    public static final ArrayList l(s sVar, AbstractC0162z abstractC0162z) {
        List<TypeProjection> listA = abstractC0162z.a();
        ArrayList arrayList = new ArrayList(o.D(listA));
        for (TypeProjection typeProjection : listA) {
            kotlin.jvm.internal.h.f(typeProjection, "typeProjection");
            StringBuilder sb = new StringBuilder();
            m.U(Z.p(typeProjection), sb, ", ", null, null, new M2.o(sVar, 0), 60);
            String string = sb.toString();
            kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
            arrayList.add(string);
        }
        return arrayList;
    }

    public static final String m(String missingDelimiterValue, String str) {
        String strSubstring;
        if (!i.E(missingDelimiterValue, '<')) {
            return missingDelimiterValue;
        }
        StringBuilder sb = new StringBuilder();
        kotlin.jvm.internal.h.f(missingDelimiterValue, "<this>");
        kotlin.jvm.internal.h.f(missingDelimiterValue, "missingDelimiterValue");
        int I = i.I(missingDelimiterValue, '<', 0, 6);
        if (I == -1) {
            strSubstring = missingDelimiterValue;
        } else {
            strSubstring = missingDelimiterValue.substring(0, I);
            kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        sb.append(strSubstring);
        sb.append('<');
        sb.append(str);
        sb.append('>');
        sb.append(i.U(missingDelimiterValue, '>'));
        return sb.toString();
    }

    @Override // a3.AbstractC0162z
    public final AbstractC0162z e(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        F type = this.b;
        kotlin.jvm.internal.h.f(type, "type");
        F type2 = this.c;
        kotlin.jvm.internal.h.f(type2, "type");
        return new h(type, type2);
    }

    @Override // a3.c0
    public final c0 g(boolean z6) {
        return new h(this.b.g(z6), this.c.g(z6));
    }

    @Override // a3.AbstractC0155s, a3.AbstractC0162z
    public final MemberScope getMemberScope() {
        ClassifierDescriptor declarationDescriptor = c().getDeclarationDescriptor();
        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
        if (classDescriptor != null) {
            MemberScope memberScope = classDescriptor.getMemberScope(new f());
            kotlin.jvm.internal.h.e(memberScope, "classDescriptor.getMemberScope(RawSubstitution())");
            return memberScope;
        }
        throw new IllegalStateException(("Incorrect classifier: " + c().getDeclarationDescriptor()).toString());
    }

    @Override // a3.c0
    /* JADX INFO: renamed from: h */
    public final c0 e(b3.d kotlinTypeRefiner) {
        kotlin.jvm.internal.h.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        F type = this.b;
        kotlin.jvm.internal.h.f(type, "type");
        F type2 = this.c;
        kotlin.jvm.internal.h.f(type2, "type");
        return new h(type, type2);
    }

    @Override // a3.c0
    public final c0 i(M newAttributes) {
        kotlin.jvm.internal.h.f(newAttributes, "newAttributes");
        return new h(this.b.i(newAttributes), this.c.i(newAttributes));
    }

    @Override // a3.AbstractC0155s
    public final F j() {
        return this.b;
    }

    @Override // a3.AbstractC0155s
    public final String k(s sVar, s sVar2) {
        F f6 = this.b;
        String strM = sVar.M(f6);
        F f7 = this.c;
        String strM2 = sVar.M(f7);
        if (sVar2.d.getDebugMode()) {
            return "raw (" + strM + ".." + strM2 + ')';
        }
        if (f7.a().isEmpty()) {
            return sVar.t(strM, strM2, AbstractC0246d.O(this));
        }
        ArrayList arrayListL = l(sVar, f6);
        ArrayList arrayListL2 = l(sVar, f7);
        String strV = m.V(arrayListL, ", ", null, null, g.f126a, 30);
        ArrayList<N1.e> arrayListU0 = m.u0(arrayListL, arrayListL2);
        if (arrayListU0.isEmpty()) {
            strM2 = m(strM2, strV);
        } else {
            for (N1.e eVar : arrayListU0) {
                String str = (String) eVar.f1121a;
                String str2 = (String) eVar.b;
                if (!kotlin.jvm.internal.h.a(str, i.P(str2, "out ")) && !str2.equals(Marker.ANY_MARKER)) {
                    break;
                }
            }
            strM2 = m(strM2, strV);
        }
        String strM3 = m(strM, strV);
        return kotlin.jvm.internal.h.a(strM3, strM2) ? strM3 : sVar.t(strM3, strM2, AbstractC0246d.O(this));
    }
}
