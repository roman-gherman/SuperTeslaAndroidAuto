package o2;

import io.ktor.utils.io.Z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.A;
import kotlin.collections.m;
import kotlin.collections.n;

/* JADX INFO: loaded from: classes2.dex */
public enum l {
    CLASS(true),
    ANNOTATION_CLASS(true),
    TYPE_PARAMETER(false),
    PROPERTY(true),
    FIELD(true),
    LOCAL_VARIABLE(true),
    VALUE_PARAMETER(true),
    CONSTRUCTOR(true),
    FUNCTION(true),
    PROPERTY_GETTER(true),
    PROPERTY_SETTER(true),
    TYPE(false),
    /* JADX INFO: Fake field, exist only in values array */
    EXPRESSION(false),
    FILE(false),
    /* JADX INFO: Fake field, exist only in values array */
    TYPEALIAS(false),
    /* JADX INFO: Fake field, exist only in values array */
    PROPERTY_PARAMETER(false),
    /* JADX INFO: Fake field, exist only in values array */
    STAR_PROJECTION(false),
    /* JADX INFO: Fake field, exist only in values array */
    PROPERTY_PARAMETER(false),
    CLASS_ONLY(false),
    OBJECT(false),
    STANDALONE_OBJECT(false),
    COMPANION_OBJECT(false),
    INTERFACE(false),
    ENUM_CLASS(false),
    ENUM_ENTRY(false),
    LOCAL_CLASS(false),
    /* JADX INFO: Fake field, exist only in values array */
    LOCAL_FUNCTION(false),
    /* JADX INFO: Fake field, exist only in values array */
    MEMBER_FUNCTION(false),
    /* JADX INFO: Fake field, exist only in values array */
    TOP_LEVEL_FUNCTION(false),
    /* JADX INFO: Fake field, exist only in values array */
    MEMBER_PROPERTY(false),
    /* JADX INFO: Fake field, exist only in values array */
    MEMBER_PROPERTY_WITH_BACKING_FIELD(false),
    /* JADX INFO: Fake field, exist only in values array */
    MEMBER_PROPERTY_WITH_DELEGATE(false),
    /* JADX INFO: Fake field, exist only in values array */
    MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE(false),
    /* JADX INFO: Fake field, exist only in values array */
    TOP_LEVEL_PROPERTY(false),
    /* JADX INFO: Fake field, exist only in values array */
    TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD(false),
    /* JADX INFO: Fake field, exist only in values array */
    TOP_LEVEL_PROPERTY_WITH_DELEGATE(false),
    /* JADX INFO: Fake field, exist only in values array */
    TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE(false),
    /* JADX INFO: Fake field, exist only in values array */
    BACKING_FIELD(true),
    /* JADX INFO: Fake field, exist only in values array */
    INITIALIZER(false),
    /* JADX INFO: Fake field, exist only in values array */
    DESTRUCTURING_DECLARATION(false),
    /* JADX INFO: Fake field, exist only in values array */
    LAMBDA_EXPRESSION(false),
    /* JADX INFO: Fake field, exist only in values array */
    ANONYMOUS_FUNCTION(false),
    /* JADX INFO: Fake field, exist only in values array */
    OBJECT_LITERAL(false);

    public static final HashMap b = new HashMap();
    public static final List c;
    public static final List d;
    public static final List e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List f4300f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List f4301g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List f4302h;
    public static final List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final List f4303j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final List f4304k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final List f4305l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final List f4306m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final List f4307n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Object f4308o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4316a;

    static {
        for (l lVar : values()) {
            b.put(lVar.name(), lVar);
        }
        l[] lVarArrValues = values();
        ArrayList arrayList = new ArrayList();
        for (l lVar2 : lVarArrValues) {
            if (lVar2.f4316a) {
                arrayList.add(lVar2);
            }
        }
        m.s0(arrayList);
        kotlin.collections.j.N(values());
        l lVar3 = ANNOTATION_CLASS;
        l lVar4 = CLASS;
        c = n.y(lVar3, lVar4);
        d = n.y(LOCAL_CLASS, lVar4);
        e = n.y(CLASS_ONLY, lVar4);
        l lVar5 = COMPANION_OBJECT;
        l lVar6 = OBJECT;
        f4300f = n.y(lVar5, lVar6, lVar4);
        f4301g = n.y(STANDALONE_OBJECT, lVar6, lVar4);
        f4302h = n.y(INTERFACE, lVar4);
        i = n.y(ENUM_CLASS, lVar4);
        l lVar7 = ENUM_ENTRY;
        l lVar8 = PROPERTY;
        l lVar9 = FIELD;
        f4303j = n.y(lVar7, lVar8, lVar9);
        l lVar10 = PROPERTY_SETTER;
        f4304k = Z.p(lVar10);
        l lVar11 = PROPERTY_GETTER;
        f4305l = Z.p(lVar11);
        f4306m = Z.p(FUNCTION);
        l lVar12 = FILE;
        f4307n = Z.p(lVar12);
        EnumC0739c enumC0739c = EnumC0739c.CONSTRUCTOR_PARAMETER;
        l lVar13 = VALUE_PARAMETER;
        f4308o = A.I(new N1.e(enumC0739c, lVar13), new N1.e(EnumC0739c.FIELD, lVar9), new N1.e(EnumC0739c.PROPERTY, lVar8), new N1.e(EnumC0739c.FILE, lVar12), new N1.e(EnumC0739c.PROPERTY_GETTER, lVar11), new N1.e(EnumC0739c.PROPERTY_SETTER, lVar10), new N1.e(EnumC0739c.RECEIVER, lVar13), new N1.e(EnumC0739c.SETTER_PARAMETER, lVar13), new N1.e(EnumC0739c.PROPERTY_DELEGATE_FIELD, lVar9));
    }

    l(boolean z6) {
        this.f4316a = z6;
    }
}
