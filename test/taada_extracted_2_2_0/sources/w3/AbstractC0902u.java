package w3;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.util.Iterable;

/* JADX INFO: renamed from: w3.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0902u extends AbstractC0899q implements Iterable {
    public static final C0883a b = new C0883a(AbstractC0902u.class, 17);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ASN1Encodable[] f5074a;

    public AbstractC0902u() {
        this.f5074a = C0886d.d;
    }

    public static AbstractC0902u l(Object obj) {
        if (obj == null || (obj instanceof AbstractC0902u)) {
            return (AbstractC0902u) obj;
        }
        if (obj instanceof ASN1Encodable) {
            AbstractC0899q aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof AbstractC0902u) {
                return (AbstractC0902u) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (AbstractC0902u) b.d((byte[]) obj);
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: ".concat(obj.getClass().getName()));
    }

    @Override // w3.AbstractC0899q
    public final boolean b(AbstractC0899q abstractC0899q) {
        if (abstractC0899q instanceof AbstractC0902u) {
            AbstractC0902u abstractC0902u = (AbstractC0902u) abstractC0899q;
            int size = size();
            if (abstractC0902u.size() == size) {
                for (int i = 0; i < size; i++) {
                    AbstractC0899q aSN1Primitive = this.f5074a[i].toASN1Primitive();
                    AbstractC0899q aSN1Primitive2 = abstractC0902u.f5074a[i].toASN1Primitive();
                    if (aSN1Primitive == aSN1Primitive2 || aSN1Primitive.b(aSN1Primitive2)) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // w3.AbstractC0899q
    public final boolean d() {
        return true;
    }

    @Override // w3.AbstractC0899q
    public AbstractC0899q h() {
        Z z6 = new Z(this.f5074a, 0);
        z6.d = -1;
        return z6;
    }

    @Override // w3.AbstractC0899q, w3.AbstractC0893k
    public int hashCode() {
        int length = this.f5074a.length;
        int iHashCode = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return iHashCode;
            }
            iHashCode = (iHashCode * 257) ^ this.f5074a[length].toASN1Primitive().hashCode();
        }
    }

    @Override // w3.AbstractC0899q
    public AbstractC0899q i() {
        Z z6 = new Z(this.f5074a, 1);
        z6.d = -1;
        return z6;
    }

    public Iterator iterator() {
        return new g5.a(this.f5074a);
    }

    public final AbstractC0884b[] j() {
        int size = size();
        AbstractC0884b[] abstractC0884bArr = new AbstractC0884b[size];
        for (int i = 0; i < size; i++) {
            abstractC0884bArr[i] = AbstractC0884b.m(this.f5074a[i]);
        }
        return abstractC0884bArr;
    }

    public final AbstractC0897o[] k() {
        int size = size();
        AbstractC0897o[] abstractC0897oArr = new AbstractC0897o[size];
        for (int i = 0; i < size; i++) {
            abstractC0897oArr[i] = AbstractC0897o.j(this.f5074a[i]);
        }
        return abstractC0897oArr;
    }

    public ASN1Encodable m(int i) {
        return this.f5074a[i];
    }

    public Enumeration n() {
        return new C0900s(this);
    }

    public abstract AbstractC0884b o();

    public abstract N p();

    public abstract AbstractC0897o q();

    public abstract AbstractC0904w r();

    public int size() {
        return this.f5074a.length;
    }

    public final String toString() {
        int size = size();
        if (size == 0) {
            return "[]";
        }
        StringBuffer stringBuffer = new StringBuffer("[");
        int i = 0;
        while (true) {
            stringBuffer.append(this.f5074a[i]);
            i++;
            if (i >= size) {
                stringBuffer.append(']');
                return stringBuffer.toString();
            }
            stringBuffer.append(", ");
        }
    }

    public AbstractC0902u(C0886d c0886d) {
        if (c0886d == null) {
            throw new NullPointerException("'elementVector' cannot be null");
        }
        this.f5074a = c0886d.c();
    }

    public AbstractC0902u(AbstractC0899q abstractC0899q) {
        if (abstractC0899q == null) {
            throw new NullPointerException("'element' cannot be null");
        }
        this.f5074a = new ASN1Encodable[]{abstractC0899q};
    }
}
