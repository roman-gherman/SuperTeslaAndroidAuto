package P1;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements Externalizable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f1214a;

    private final Object readResolve() {
        return this.f1214a;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput input) throws IOException {
        kotlin.jvm.internal.h.f(input, "input");
        byte b = input.readByte();
        if (b != 0) {
            throw new InvalidObjectException(B2.b.c(b, "Unsupported flags value: "));
        }
        int i = input.readInt();
        if (i < 0) {
            throw new InvalidObjectException("Illegal size value: " + i + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
        }
        e eVar = new e(i);
        for (int i3 = 0; i3 < i; i3++) {
            eVar.put(input.readObject(), input.readObject());
        }
        eVar.b();
        eVar.f1210l = true;
        this.f1214a = eVar;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput output) throws IOException {
        kotlin.jvm.internal.h.f(output, "output");
        output.writeByte(0);
        output.writeInt(this.f1214a.f1207h);
        for (Map.Entry entry : (f) this.f1214a.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }
}
