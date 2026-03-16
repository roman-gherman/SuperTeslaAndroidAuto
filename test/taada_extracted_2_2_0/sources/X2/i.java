package X2;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f1433a;
    public final NameResolver b;
    public final DeclarationDescriptor c;
    public final I2.f d;
    public final I2.g e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final I2.a f1434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final E2.g f1435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y f1436h;
    public final o i;

    public i(g components, NameResolver nameResolver, DeclarationDescriptor containingDeclaration, I2.f fVar, I2.g versionRequirementTable, I2.a metadataVersion, E2.g gVar, y yVar, List typeParameters) {
        String presentableString;
        kotlin.jvm.internal.h.f(components, "components");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.h.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.h.f(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.h.f(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.h.f(typeParameters, "typeParameters");
        this.f1433a = components;
        this.b = nameResolver;
        this.c = containingDeclaration;
        this.d = fVar;
        this.e = versionRequirementTable;
        this.f1434f = metadataVersion;
        this.f1435g = gVar;
        this.f1436h = new y(this, yVar, typeParameters, "Deserializer for \"" + containingDeclaration.getName() + '\"', (gVar == null || (presentableString = gVar.getPresentableString()) == null) ? "[container not found]" : presentableString);
        this.i = new o(this);
    }

    public final i a(DeclarationDescriptor declarationDescriptor, List typeParameterProtos, NameResolver nameResolver, I2.f fVar, I2.g versionRequirementTable, I2.a metadataVersion) {
        kotlin.jvm.internal.h.f(typeParameterProtos, "typeParameterProtos");
        kotlin.jvm.internal.h.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.h.f(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.h.f(metadataVersion, "metadataVersion");
        int i = metadataVersion.b;
        if ((i != 1 || metadataVersion.c < 4) && i <= 1) {
            versionRequirementTable = this.e;
        }
        return new i(this.f1433a, nameResolver, declarationDescriptor, fVar, versionRequirementTable, metadataVersion, this.f1435g, this.f1436h, typeParameterProtos);
    }
}
