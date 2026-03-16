package kotlin.jvm.internal;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes2.dex */
public class q extends p {
    public q(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(b.NO_RECEIVER, ((ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof KClass) ? 1 : 0);
    }

    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    public q(String str, String str2) {
        super(b.NO_RECEIVER, SupportSQLiteDatabase.class, str, str2, 0);
    }
}
