package L0;

import com.google.firebase.encoders.proto.Protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Protobuf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f947a;

    public a(int i) {
        this.f947a = i;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return Protobuf.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Protobuf)) {
            return false;
        }
        Protobuf protobuf = (Protobuf) obj;
        return this.f947a == protobuf.tag() && c.f949a.equals(protobuf.intEncoding());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (14552422 ^ this.f947a) + (c.f949a.hashCode() ^ 2041407134);
    }

    @Override // com.google.firebase.encoders.proto.Protobuf
    public final c intEncoding() {
        return c.f949a;
    }

    @Override // com.google.firebase.encoders.proto.Protobuf
    public final int tag() {
        return this.f947a;
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f947a + "intEncoding=" + c.f949a + ')';
    }
}
