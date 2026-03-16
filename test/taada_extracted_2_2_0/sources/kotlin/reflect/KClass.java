package kotlin.reflect;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0001H¦\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a0\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u001e\u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010!\u001a\u0004\u0018\u00018\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R \u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"8&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010'\u001a\u0004\b$\u0010%R \u0010,\u001a\b\u0012\u0004\u0012\u00020)0\"8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010'\u001a\u0004\b*\u0010%R(\u0010/\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00000\"8&X§\u0004¢\u0006\f\u0012\u0004\b.\u0010'\u001a\u0004\b-\u0010%R\u001c\u00104\u001a\u0004\u0018\u0001008&X§\u0004¢\u0006\f\u0012\u0004\b3\u0010'\u001a\u0004\b1\u00102R\u001a\u00105\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b7\u0010'\u001a\u0004\b5\u00106R\u001a\u00108\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b9\u0010'\u001a\u0004\b8\u00106R\u001a\u0010:\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b;\u0010'\u001a\u0004\b:\u00106R\u001a\u0010<\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b=\u0010'\u001a\u0004\b<\u00106R\u001a\u0010>\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b?\u0010'\u001a\u0004\b>\u00106R\u001a\u0010@\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\bA\u0010'\u001a\u0004\b@\u00106R\u001a\u0010B\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\bC\u0010'\u001a\u0004\bB\u00106R\u001a\u0010D\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\bE\u0010'\u001a\u0004\bD\u00106R\u001a\u0010F\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\bG\u0010'\u001a\u0004\bF\u00106¨\u0006H"}, d2 = {"Lkotlin/reflect/KClass;", "", "T", "Lkotlin/reflect/KDeclarationContainer;", "Lkotlin/reflect/KAnnotatedElement;", "Lkotlin/reflect/KClassifier;", "value", "", "isInstance", "(Ljava/lang/Object;)Z", "other", "equals", "", "hashCode", "()I", "", "getSimpleName", "()Ljava/lang/String;", "simpleName", "getQualifiedName", "qualifiedName", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "members", "Lkotlin/reflect/KFunction;", "getConstructors", "constructors", "getNestedClasses", "nestedClasses", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance", "", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "()Ljava/util/List;", "getTypeParameters$annotations", "()V", "typeParameters", "Lkotlin/reflect/KType;", "getSupertypes", "getSupertypes$annotations", "supertypes", "getSealedSubclasses", "getSealedSubclasses$annotations", "sealedSubclasses", "Lkotlin/reflect/f;", "getVisibility", "()Lkotlin/reflect/f;", "getVisibility$annotations", "visibility", "isFinal", "()Z", "isFinal$annotations", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "isSealed", "isSealed$annotations", "isData", "isData$annotations", "isInner", "isInner$annotations", "isCompanion", "isCompanion$annotations", "isFun", "isFun$annotations", "isValue", "isValue$annotations", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface KClass<T> extends KDeclarationContainer, KAnnotatedElement, KClassifier {
    boolean equals(@Nullable Object other);

    @NotNull
    Collection<KFunction<T>> getConstructors();

    @Override // kotlin.reflect.KDeclarationContainer
    @NotNull
    Collection<KCallable<?>> getMembers();

    @NotNull
    Collection<KClass<?>> getNestedClasses();

    @Nullable
    T getObjectInstance();

    @Nullable
    String getQualifiedName();

    @NotNull
    List<KClass<? extends T>> getSealedSubclasses();

    @Nullable
    String getSimpleName();

    @NotNull
    List<KType> getSupertypes();

    @NotNull
    List<KTypeParameter> getTypeParameters();

    @Nullable
    f getVisibility();

    int hashCode();

    boolean isAbstract();

    boolean isCompanion();

    boolean isData();

    boolean isFinal();

    boolean isFun();

    boolean isInner();

    @SinceKotlin(version = "1.1")
    boolean isInstance(@Nullable Object value);

    boolean isOpen();

    boolean isSealed();

    boolean isValue();
}
