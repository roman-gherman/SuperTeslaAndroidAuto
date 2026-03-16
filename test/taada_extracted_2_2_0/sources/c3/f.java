package c3;

import io.ktor.utils.io.internal.t;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.u;
import kotlin.collections.w;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import n2.AbstractC0713e;
import n2.EnumC0709a;
import n2.EnumC0719k;

/* JADX INFO: loaded from: classes2.dex */
public class f implements MemberScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1749a;

    public f(int i, String... formatParams) {
        String str;
        com.google.protobuf.a.p(i, "kind");
        kotlin.jvm.internal.h.f(formatParams, "formatParams");
        Object[] objArrCopyOf = Arrays.copyOf(formatParams, formatParams.length);
        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, objArrCopyOf.length);
        switch (i) {
            case 1:
                str = "No member resolution should be done on captured type, it used only during constraint system resolution";
                break;
            case 2:
                str = "Scope for integer literal type (%s)";
                break;
            case 3:
                str = "Error scope for erased receiver type";
                break;
            case 4:
                str = "Scope for abbreviation %s";
                break;
            case 5:
                str = "Scope for stub type %s";
                break;
            case 6:
                str = "A scope for common supertype which is not a normal classifier";
                break;
            case 7:
                str = "Scope for error type %s";
                break;
            case 8:
                str = "Scope for unsupported type %s";
                break;
            case 9:
                str = "Error scope for class %s with arguments: %s";
                break;
            case 10:
                str = "Error resolution candidate for call %s";
                break;
            default:
                throw null;
        }
        this.f1749a = String.format(str, objArrCopyOf2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Set getContributedFunctions(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        C0242a containingDeclaration = j.c;
        kotlin.jvm.internal.h.f(containingDeclaration, "containingDeclaration");
        Annotations.Companion.getClass();
        c cVar = new c(containingDeclaration, null, o2.f.b, L2.f.g("<Error function>"), EnumC0709a.f4227a, SourceElement.NO_SOURCE);
        u uVar = u.f3805a;
        cVar.l(null, null, uVar, uVar, uVar, j.c(i.RETURN_TYPE_FOR_FUNCTION, new String[0]), EnumC0719k.c, AbstractC0713e.e);
        return t.p(cVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Set getContributedVariables(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        j jVar = j.f1775a;
        return j.f1776f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set getClassifierNames() {
        return w.f3807a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
        return new C0242a(L2.f.g(String.format("<Error class: %s>", Arrays.copyOf(new Object[]{name}, 1))));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection getContributedDescriptors(U2.f kindFilter, Function1 nameFilter) {
        kotlin.jvm.internal.h.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.h.f(nameFilter, "nameFilter");
        return u.f3805a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set getFunctionNames() {
        return w.f3807a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set getVariableNames() {
        return w.f3807a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public void recordLookup(L2.f name, LookupLocation location) {
        kotlin.jvm.internal.h.f(name, "name");
        kotlin.jvm.internal.h.f(location, "location");
    }

    public String toString() {
        return androidx.constraintlayout.core.motion.a.s(new StringBuilder("ErrorScope{"), this.f1749a, '}');
    }
}
