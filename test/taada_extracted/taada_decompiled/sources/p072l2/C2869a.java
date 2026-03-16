package p072l2;

import android.content.Context;
import com.android.dx.Code;
import com.android.dx.DexMaker;
import com.android.dx.Local;
import com.android.dx.MethodId;
import com.android.dx.TypeId;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class C2869a {
    private final AbstractC2870b f8954a;
    Context f8955b;
    Class f8956c;
    DexMaker f8957d;

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public C2869a(Context context, AbstractC2870b abstractC2870b) {
        Class<?> cls;
        this.f8955b = context;
        this.f8954a = abstractC2870b;
        try {
            cls = Class.forName("android.net.ConnectivityManager$OnStartTetheringCallback");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            cls = null;
        }
        TypeId<?> typeId = TypeId.get(cls);
        this.f8957d = new DexMaker();
        TypeId<?> typeId2 = TypeId.get("LTetheringCallback;");
        this.f8957d.declare(typeId2, "TetheringCallback.generated", 1, typeId, new TypeId[0]);
        this.f8957d.declare(typeId2.getField(TypeId.get(AbstractC2870b.class), "callback"), 2, null);
        m2253a(typeId2, typeId);
        try {
            this.f8956c = this.f8957d.generateAndLoad(C2869a.class.getClassLoader(), this.f8955b.getCodeCacheDir()).loadClass("TetheringCallback");
        } catch (IOException | ClassNotFoundException e6) {
            e6.printStackTrace();
        }
    }

    public Class m2252b() {
        return this.f8956c;
    }

    public void m2253a(TypeId<?> typeId, TypeId<?> typeId2) {
        MethodId constructor = TypeId.get(Object.class).getConstructor(new TypeId[0]);
        Code codeDeclare = this.f8957d.declare(typeId.getConstructor(TypeId.INT), 1);
        codeDeclare.invokeDirect(constructor, null, codeDeclare.getThis(typeId), new Local[0]);
        codeDeclare.returnVoid();
    }
}
