package A2;

import G2.U;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: renamed from: A2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0031m extends kotlin.jvm.internal.e implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f53a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0031m(int i, int i3, Object obj) {
        super(i, obj);
        this.f53a = i3;
    }

    @Override // kotlin.jvm.internal.b, kotlin.reflect.KCallable
    public final String getName() {
        switch (this.f53a) {
            case 0:
                return "searchMethodsByNameWithoutBuiltinMagic";
            case 1:
                return "searchMethodsInSupertypesWithoutBuiltinMagic";
            case 2:
                return "loadResource";
            case 3:
                return "prepareType";
            case 4:
                return "simpleType";
            case 5:
                return "getValueClassPropertyType";
            default:
                return MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        }
    }

    @Override // kotlin.jvm.internal.b
    public final KDeclarationContainer getOwner() {
        switch (this.f53a) {
            case 0:
                return kotlin.jvm.internal.w.f3817a.b(r.class);
            case 1:
                return kotlin.jvm.internal.w.f3817a.b(r.class);
            case 2:
                return kotlin.jvm.internal.w.f3817a.b(Y2.d.class);
            case 3:
                return kotlin.jvm.internal.w.f3817a.b(b3.b.class);
            case 4:
                return kotlin.jvm.internal.w.f3817a.b(kotlin.jvm.internal.g.class);
            case 5:
                return kotlin.jvm.internal.w.f3817a.b(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g.class);
            default:
                return kotlin.jvm.internal.w.f3817a.b(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e.class);
        }
    }

    @Override // kotlin.jvm.internal.b
    public final String getSignature() {
        switch (this.f53a) {
            case 0:
                return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
            case 1:
                return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
            case 2:
                return "loadResource(Ljava/lang/String;)Ljava/io/InputStream;";
            case 3:
                return "prepareType(Lorg/jetbrains/kotlin/types/model/KotlinTypeMarker;)Lorg/jetbrains/kotlin/types/UnwrappedType;";
            case 4:
                return "computeValueClassRepresentation$simpleType(Lorg/jetbrains/kotlin/serialization/deserialization/TypeDeserializer;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Type;)Lorg/jetbrains/kotlin/types/SimpleType;";
            case 5:
                return "getValueClassPropertyType(Lorg/jetbrains/kotlin/name/Name;)Lorg/jetbrains/kotlin/types/SimpleType;";
            default:
                return "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V";
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f53a) {
            case 0:
                L2.f p02 = (L2.f) obj;
                kotlin.jvm.internal.h.f(p02, "p0");
                return r.o((r) this.receiver, p02);
            case 1:
                L2.f p03 = (L2.f) obj;
                kotlin.jvm.internal.h.f(p03, "p0");
                return r.p((r) this.receiver, p03);
            case 2:
                String p04 = (String) obj;
                kotlin.jvm.internal.h.f(p04, "p0");
                ((Y2.d) this.receiver).getClass();
                return Y2.d.a(p04);
            case 3:
                KotlinTypeMarker p05 = (KotlinTypeMarker) obj;
                kotlin.jvm.internal.h.f(p05, "p0");
                return ((b3.b) this.receiver).a(p05);
            case 4:
                U p06 = (U) obj;
                kotlin.jvm.internal.h.f(p06, "p0");
                return ((X2.y) this.receiver).c(p06, true);
            case 5:
                L2.f p07 = (L2.f) obj;
                kotlin.jvm.internal.h.f(p07, "p0");
                return ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g) this.receiver).f(p07);
            default:
                b3.d p08 = (b3.d) obj;
                kotlin.jvm.internal.h.f(p08, "p0");
                return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g) this.receiver, p08);
        }
    }
}
