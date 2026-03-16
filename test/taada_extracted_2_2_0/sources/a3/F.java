package a3;

import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import net.bytebuddy.description.type.TypeDescription;

/* JADX INFO: loaded from: classes2.dex */
public abstract class F extends c0 implements SimpleTypeMarker, TypeArgumentListMarker {
    @Override // a3.c0
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public abstract F g(boolean z6);

    @Override // a3.c0
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public abstract F i(M m6);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<AnnotationDescriptor> it = getAnnotations().iterator();
        while (it.hasNext()) {
            String[] strArr = {"[", M2.n.c.l(it.next(), null), "] "};
            for (int i = 0; i < 3; i++) {
                sb.append(strArr[i]);
            }
        }
        sb.append(c());
        if (!a().isEmpty()) {
            kotlin.collections.m.U(a(), sb, ", ", "<", ">", null, 112);
        }
        if (d()) {
            sb.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
        }
        String string = sb.toString();
        kotlin.jvm.internal.h.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
