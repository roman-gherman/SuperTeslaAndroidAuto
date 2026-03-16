package P1;

import io.ktor.utils.io.Z;
import io.ktor.utils.io.internal.t;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractCollection;
import java.util.Iterator;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Externalizable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractCollection f1213a;
    public final int b;

    public h(AbstractCollection abstractCollection, int i) {
        this.f1213a = abstractCollection;
        this.b = i;
    }

    private final Object readResolve() {
        return this.f1213a;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput input) throws IOException {
        AbstractCollection abstractCollection;
        kotlin.jvm.internal.h.f(input, "input");
        byte b = input.readByte();
        int i = b & 1;
        if ((b & (-2)) != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + ((int) b) + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
        }
        int i3 = input.readInt();
        if (i3 < 0) {
            throw new InvalidObjectException("Illegal size value: " + i3 + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
        }
        int i4 = 0;
        if (i == 0) {
            b bVar = new b(i3);
            while (i4 < i3) {
                bVar.add(input.readObject());
                i4++;
            }
            Z.b(bVar);
            abstractCollection = bVar;
        } else {
            if (i != 1) {
                throw new InvalidObjectException("Unsupported collection type tag: " + i + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
            }
            j jVar = new j(i3);
            while (i4 < i3) {
                jVar.add(input.readObject());
                i4++;
            }
            t.b(jVar);
            abstractCollection = jVar;
        }
        this.f1213a = abstractCollection;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput output) throws IOException {
        kotlin.jvm.internal.h.f(output, "output");
        output.writeByte(this.b);
        output.writeInt(this.f1213a.size());
        Iterator it = this.f1213a.iterator();
        while (it.hasNext()) {
            output.writeObject(it.next());
        }
    }
}
