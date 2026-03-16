package M0;

import com.google.gson.E;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class t extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JsonSerializer f1016a;
    public final JsonDeserializer b;
    public final com.google.gson.m c;
    public final com.google.gson.reflect.a d;
    public final B.g e = new B.g(this, 10);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile E f1018g;

    public t(JsonSerializer jsonSerializer, JsonDeserializer jsonDeserializer, com.google.gson.m mVar, com.google.gson.reflect.a aVar, boolean z6) {
        this.f1016a = jsonSerializer;
        this.b = jsonDeserializer;
        this.c = mVar;
        this.d = aVar;
        this.f1017f = z6;
    }

    @Override // com.google.gson.E
    public final Object a(com.google.gson.stream.b bVar) {
        JsonDeserializer jsonDeserializer = this.b;
        if (jsonDeserializer == null) {
            E eF = this.f1018g;
            if (eF == null) {
                eF = this.c.f(null, this.d);
                this.f1018g = eF;
            }
            return eF.a(bVar);
        }
        com.google.gson.p pVarI = com.google.gson.internal.d.i(bVar);
        if (this.f1017f) {
            pVarI.getClass();
            if (pVarI instanceof com.google.gson.r) {
                return null;
            }
        }
        return jsonDeserializer.deserialize(pVarI, this.d.b, this.e);
    }

    @Override // com.google.gson.E
    public final void b(com.google.gson.stream.c cVar, Object obj) throws IOException {
        JsonSerializer jsonSerializer = this.f1016a;
        if (jsonSerializer == null) {
            E eF = this.f1018g;
            if (eF == null) {
                eF = this.c.f(null, this.d);
                this.f1018g = eF;
            }
            eF.b(cVar, obj);
            return;
        }
        if (this.f1017f && obj == null) {
            cVar.i();
            return;
        }
        com.google.gson.p pVarSerialize = jsonSerializer.serialize(obj, this.d.b, this.e);
        v vVar = y.f1025a;
        u.d(cVar, pVarSerialize);
    }

    @Override // M0.s
    public final E c() {
        if (this.f1016a != null) {
            return this;
        }
        E e = this.f1018g;
        if (e != null) {
            return e;
        }
        E eF = this.c.f(null, this.d);
        this.f1018g = eF;
        return eF;
    }
}
