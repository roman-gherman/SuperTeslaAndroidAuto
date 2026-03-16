package kotlin.collections;

import java.util.List;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes2.dex */
public final class D extends AbstractC0598e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3798a;
    public final Object b;

    public /* synthetic */ D(Object obj, int i) {
        this.f3798a = i;
        this.b = obj;
    }

    @Override // kotlin.collections.AbstractC0594a
    public final int a() {
        switch (this.f3798a) {
            case 0:
                return ((List) this.b).size();
            default:
                return ((Matcher) ((C0.t) this.b).b).groupCount() + 1;
        }
    }

    @Override // kotlin.collections.AbstractC0594a, java.util.Collection, java.util.List
    public /* bridge */ boolean contains(Object obj) {
        switch (this.f3798a) {
            case 1:
                if (obj instanceof String) {
                    return super.contains((String) obj);
                }
                return false;
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.List
    public final Object get(int i) {
        switch (this.f3798a) {
            case 0:
                return ((List) this.b).get(m.J(i, this));
            default:
                String strGroup = ((Matcher) ((C0.t) this.b).b).group(i);
                return strGroup == null ? "" : strGroup;
        }
    }

    @Override // kotlin.collections.AbstractC0598e, java.util.List
    public /* bridge */ int indexOf(Object obj) {
        switch (this.f3798a) {
            case 1:
                if (obj instanceof String) {
                    return super.indexOf((String) obj);
                }
                return -1;
            default:
                return super.indexOf(obj);
        }
    }

    @Override // kotlin.collections.AbstractC0598e, java.util.List
    public /* bridge */ int lastIndexOf(Object obj) {
        switch (this.f3798a) {
            case 1:
                if (obj instanceof String) {
                    return super.lastIndexOf((String) obj);
                }
                return -1;
            default:
                return super.lastIndexOf(obj);
        }
    }
}
