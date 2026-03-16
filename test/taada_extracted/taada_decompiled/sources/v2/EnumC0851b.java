package v2;

import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: v2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class EnumC0851b implements LookupLocation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0851b f4933a;
    public static final EnumC0851b b;
    public static final EnumC0851b c;
    public static final EnumC0851b d;
    public static final EnumC0851b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final EnumC0851b f4934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final EnumC0851b f4935g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final EnumC0851b f4936h;
    public static final /* synthetic */ EnumC0851b[] i;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0851b EF1;

    static {
        EnumC0851b enumC0851b = new EnumC0851b("FROM_IDE", 0);
        EnumC0851b enumC0851b2 = new EnumC0851b("FROM_BACKEND", 1);
        EnumC0851b enumC0851b3 = new EnumC0851b("FROM_TEST", 2);
        EnumC0851b enumC0851b4 = new EnumC0851b("FROM_BUILTINS", 3);
        f4933a = enumC0851b4;
        EnumC0851b enumC0851b5 = new EnumC0851b("WHEN_CHECK_DECLARATION_CONFLICTS", 4);
        EnumC0851b enumC0851b6 = new EnumC0851b("WHEN_CHECK_OVERRIDES", 5);
        EnumC0851b enumC0851b7 = new EnumC0851b("FOR_SCRIPT", 6);
        EnumC0851b enumC0851b8 = new EnumC0851b("FROM_REFLECTION", 7);
        b = enumC0851b8;
        EnumC0851b enumC0851b9 = new EnumC0851b("WHEN_RESOLVE_DECLARATION", 8);
        EnumC0851b enumC0851b10 = new EnumC0851b("WHEN_GET_DECLARATION_SCOPE", 9);
        EnumC0851b enumC0851b11 = new EnumC0851b("WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS", 10);
        EnumC0851b enumC0851b12 = new EnumC0851b("FOR_ALREADY_TRACKED", 11);
        c = enumC0851b12;
        EnumC0851b enumC0851b13 = new EnumC0851b("WHEN_GET_ALL_DESCRIPTORS", 12);
        d = enumC0851b13;
        EnumC0851b enumC0851b14 = new EnumC0851b("WHEN_TYPING", 13);
        EnumC0851b enumC0851b15 = new EnumC0851b("WHEN_GET_SUPER_MEMBERS", 14);
        e = enumC0851b15;
        EnumC0851b enumC0851b16 = new EnumC0851b("FOR_NON_TRACKED_SCOPE", 15);
        f4934f = enumC0851b16;
        EnumC0851b enumC0851b17 = new EnumC0851b("FROM_SYNTHETIC_SCOPE", 16);
        EnumC0851b enumC0851b18 = new EnumC0851b("FROM_DESERIALIZATION", 17);
        f4935g = enumC0851b18;
        EnumC0851b enumC0851b19 = new EnumC0851b("FROM_JAVA_LOADER", 18);
        f4936h = enumC0851b19;
        i = new EnumC0851b[]{enumC0851b, enumC0851b2, enumC0851b3, enumC0851b4, enumC0851b5, enumC0851b6, enumC0851b7, enumC0851b8, enumC0851b9, enumC0851b10, enumC0851b11, enumC0851b12, enumC0851b13, enumC0851b14, enumC0851b15, enumC0851b16, enumC0851b17, enumC0851b18, enumC0851b19, new EnumC0851b("WHEN_GET_LOCAL_VARIABLE", 19), new EnumC0851b("WHEN_FIND_BY_FQNAME", 20), new EnumC0851b("WHEN_GET_COMPANION_OBJECT", 21), new EnumC0851b("FOR_DEFAULT_IMPORTS", 22)};
    }

    public static EnumC0851b valueOf(String str) {
        return (EnumC0851b) Enum.valueOf(EnumC0851b.class, str);
    }

    public static EnumC0851b[] values() {
        return (EnumC0851b[]) i.clone();
    }

    @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation
    public final LocationInfo getLocation() {
        return null;
    }
}
