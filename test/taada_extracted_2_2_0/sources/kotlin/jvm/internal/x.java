package kotlin.jvm.internal;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    public KFunction a(e eVar) {
        return eVar;
    }

    public KClass b(Class cls) {
        return new c(cls);
    }

    public KDeclarationContainer c(Class cls, String str) {
        return new m(cls, str);
    }

    public KMutableProperty1 d(j jVar) {
        return jVar;
    }

    public KProperty0 e(n nVar) {
        return nVar;
    }

    public KProperty1 f(p pVar) {
        return pVar;
    }

    public String g(FunctionBase functionBase) {
        String string = functionBase.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String h(i iVar) {
        return g(iVar);
    }

    public KType i(KClass kClass) {
        List list = Collections.EMPTY_LIST;
        return new A(kClass);
    }
}
