package h2;

import a.AbstractC0132a;
import com.android.multidex.ClassPathElement;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import n2.AbstractC0713e;
import net.bytebuddy.utility.JavaConstant;

/* JADX INFO: renamed from: h2.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0509l extends s0 {
    public final PropertyDescriptor b;
    public final G2.H c;
    public final J2.f d;
    public final NameResolver e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final I2.f f3418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f3419g;

    public C0509l(PropertyDescriptor propertyDescriptor, G2.H proto, J2.f fVar, NameResolver nameResolver, I2.f typeTable) {
        String string;
        E2.g gVar;
        String string2;
        kotlin.jvm.internal.h.f(proto, "proto");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.h.f(typeTable, "typeTable");
        this.b = propertyDescriptor;
        this.c = proto;
        this.d = fVar;
        this.e = nameResolver;
        this.f3418f = typeTable;
        if ((fVar.b & 4) == 4) {
            string2 = nameResolver.getString(fVar.e.c) + nameResolver.getString(fVar.e.d);
        } else {
            K2.d dVarB = K2.h.b(proto, nameResolver, typeTable, true);
            if (dVarB == null) {
                throw new N1.d("No field signature for property: " + propertyDescriptor, 2);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(w2.C.a(dVarB.b));
            DeclarationDescriptor containingDeclaration = propertyDescriptor.getContainingDeclaration();
            kotlin.jvm.internal.h.e(containingDeclaration, "descriptor.containingDeclaration");
            if (kotlin.jvm.internal.h.a(propertyDescriptor.getVisibility(), AbstractC0713e.d) && (containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g)) {
                kotlin.reflect.jvm.internal.impl.protobuf.o classModuleName = J2.l.i;
                kotlin.jvm.internal.h.e(classModuleName, "classModuleName");
                Integer num = (Integer) AbstractC0132a.D(((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g) containingDeclaration).e, classModuleName);
                String string3 = (num == null || (string3 = nameResolver.getString(num.intValue())) == null) ? "main" : string3;
                kotlin.text.g gVar2 = L2.g.f963a;
                gVar2.getClass();
                String strReplaceAll = gVar2.f3948a.matcher(string3).replaceAll(JavaConstant.Dynamic.DEFAULT_NAME);
                kotlin.jvm.internal.h.e(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
                string = "$".concat(strReplaceAll);
            } else if (!kotlin.jvm.internal.h.a(propertyDescriptor.getVisibility(), AbstractC0713e.f4233a) || !(containingDeclaration instanceof PackageFragmentDescriptor) || (gVar = ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n) propertyDescriptor).E) == null || gVar.b == null) {
                string = "";
            } else {
                StringBuilder sb2 = new StringBuilder("$");
                String strE = gVar.f303a.e();
                kotlin.jvm.internal.h.e(strE, "className.internalName");
                sb2.append(L2.f.e(kotlin.text.i.U(strE, ClassPathElement.SEPARATOR_CHAR)).b());
                string = sb2.toString();
            }
            sb.append(string);
            sb.append("()");
            sb.append(dVarB.c);
            string2 = sb.toString();
        }
        this.f3419g = string2;
    }

    @Override // h2.s0
    public final String c() {
        return this.f3419g;
    }
}
