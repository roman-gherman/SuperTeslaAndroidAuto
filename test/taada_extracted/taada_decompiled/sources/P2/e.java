package P2;

import a3.AbstractC0162z;
import a3.F;
import java.util.Arrays;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import net.bytebuddy.description.type.TypeDescription;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends n {
    @Override // P2.g
    public final AbstractC0162z a(ModuleDescriptor module) {
        kotlin.jvm.internal.h.f(module, "module");
        k2.i builtIns = module.getBuiltIns();
        builtIns.getClass();
        F fR = builtIns.r(k2.k.CHAR);
        if (fR != null) {
            return fR;
        }
        k2.i.a(62);
        throw null;
    }

    @Override // P2.g
    public final String toString() {
        String strValueOf;
        Object obj = this.f1217a;
        Integer numValueOf = Integer.valueOf(((Character) obj).charValue());
        char cCharValue = ((Character) obj).charValue();
        if (cCharValue == '\b') {
            strValueOf = "\\b";
        } else if (cCharValue == '\t') {
            strValueOf = "\\t";
        } else if (cCharValue == '\n') {
            strValueOf = "\\n";
        } else if (cCharValue == '\f') {
            strValueOf = "\\f";
        } else if (cCharValue == '\r') {
            strValueOf = "\\r";
        } else {
            byte type = (byte) Character.getType(cCharValue);
            strValueOf = (type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19) ? TypeDescription.Generic.OfWildcardType.SYMBOL : String.valueOf(cCharValue);
        }
        return String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{numValueOf, strValueOf}, 2));
    }
}
