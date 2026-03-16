package K0;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e implements ObjectEncoderContext, ValueEncoderContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f927a = null;
    public boolean b = true;
    public final JsonWriter c;
    public final HashMap d;
    public final HashMap e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f929g;

    public e(Writer writer, HashMap map, HashMap map2, a aVar, boolean z6) {
        this.c = new JsonWriter(writer);
        this.d = map;
        this.e = map2;
        this.f928f = aVar;
        this.f929g = z6;
    }

    public final e a(Object obj, String str) throws IOException {
        boolean z6 = this.f929g;
        JsonWriter jsonWriter = this.c;
        if (z6) {
            if (obj == null) {
                return this;
            }
            c();
            jsonWriter.name(str);
            b(obj, false);
            return this;
        }
        c();
        jsonWriter.name(str);
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        b(obj, false);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final /* bridge */ /* synthetic */ ObjectEncoderContext add(String str, Object obj) throws IOException {
        a(obj, str);
        return this;
    }

    public final e b(Object obj, boolean z6) {
        if (z6 && (obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number))) {
            throw new com.google.firebase.encoders.a((obj != null ? obj.getClass() : null) + " cannot be encoded inline");
        }
        JsonWriter jsonWriter = this.c;
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return this;
        }
        int i = 0;
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                jsonWriter.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    b(it.next(), false);
                }
                jsonWriter.endArray();
                return this;
            }
            if (obj instanceof Map) {
                jsonWriter.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        a(entry.getValue(), (String) key);
                    } catch (ClassCastException e) {
                        throw new com.google.firebase.encoders.a(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e);
                    }
                }
                jsonWriter.endObject();
                return this;
            }
            ObjectEncoder objectEncoder = (ObjectEncoder) this.d.get(obj.getClass());
            if (objectEncoder != null) {
                if (!z6) {
                    jsonWriter.beginObject();
                }
                objectEncoder.encode(obj, this);
                if (!z6) {
                    jsonWriter.endObject();
                }
                return this;
            }
            ValueEncoder valueEncoder = (ValueEncoder) this.e.get(obj.getClass());
            if (valueEncoder != null) {
                valueEncoder.encode(obj, this);
                return this;
            }
            if (obj instanceof Enum) {
                String strName = ((Enum) obj).name();
                c();
                jsonWriter.value(strName);
                return this;
            }
            if (!z6) {
                jsonWriter.beginObject();
            }
            this.f928f.encode(obj, this);
            throw null;
        }
        if (obj instanceof byte[]) {
            c();
            jsonWriter.value(Base64.encodeToString((byte[]) obj, 2));
            return this;
        }
        jsonWriter.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i < length) {
                jsonWriter.value(r7[i]);
                i++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i < length2) {
                long j6 = jArr[i];
                c();
                jsonWriter.value(j6);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i < length3) {
                jsonWriter.value(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i < length4) {
                jsonWriter.value(zArr[i]);
                i++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                b(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                b(obj2, false);
            }
        }
        jsonWriter.endArray();
        return this;
    }

    public final void c() {
        if (!this.b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        e eVar = this.f927a;
        if (eVar != null) {
            eVar.c();
            this.f927a.b = false;
            this.f927a = null;
            this.c.endObject();
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext inline(Object obj) {
        b(obj, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext nested(com.google.firebase.encoders.b bVar) {
        return nested(bVar.f2989a);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(com.google.firebase.encoders.b bVar, double d) throws IOException {
        String str = bVar.f2989a;
        c();
        JsonWriter jsonWriter = this.c;
        jsonWriter.name(str);
        c();
        jsonWriter.value(d);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext nested(String str) throws IOException {
        c();
        this.f927a = new e(this);
        JsonWriter jsonWriter = this.c;
        jsonWriter.name(str);
        jsonWriter.beginObject();
        return this.f927a;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(com.google.firebase.encoders.b bVar, float f6) throws IOException {
        String str = bVar.f2989a;
        double d = f6;
        c();
        JsonWriter jsonWriter = this.c;
        jsonWriter.name(str);
        c();
        jsonWriter.value(d);
        return this;
    }

    public e(e eVar) {
        this.c = eVar.c;
        this.d = eVar.d;
        this.e = eVar.e;
        this.f928f = eVar.f928f;
        this.f929g = eVar.f929g;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(com.google.firebase.encoders.b bVar, int i) throws IOException {
        String str = bVar.f2989a;
        c();
        JsonWriter jsonWriter = this.c;
        jsonWriter.name(str);
        c();
        jsonWriter.value(i);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(com.google.firebase.encoders.b bVar, long j6) throws IOException {
        String str = bVar.f2989a;
        c();
        JsonWriter jsonWriter = this.c;
        jsonWriter.name(str);
        c();
        jsonWriter.value(j6);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(com.google.firebase.encoders.b bVar, Object obj) throws IOException {
        a(obj, bVar.f2989a);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(com.google.firebase.encoders.b bVar, boolean z6) throws IOException {
        String str = bVar.f2989a;
        c();
        JsonWriter jsonWriter = this.c;
        jsonWriter.name(str);
        c();
        jsonWriter.value(z6);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, double d) throws IOException {
        c();
        JsonWriter jsonWriter = this.c;
        jsonWriter.name(str);
        c();
        jsonWriter.value(d);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, int i) throws IOException {
        c();
        JsonWriter jsonWriter = this.c;
        jsonWriter.name(str);
        c();
        jsonWriter.value(i);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, long j6) throws IOException {
        c();
        JsonWriter jsonWriter = this.c;
        jsonWriter.name(str);
        c();
        jsonWriter.value(j6);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, boolean z6) throws IOException {
        c();
        JsonWriter jsonWriter = this.c;
        jsonWriter.name(str);
        c();
        jsonWriter.value(z6);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(String str) throws IOException {
        c();
        this.c.value(str);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(float f6) throws IOException {
        c();
        this.c.value(f6);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(double d) throws IOException {
        c();
        this.c.value(d);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(int i) throws IOException {
        c();
        this.c.value(i);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(long j6) throws IOException {
        c();
        this.c.value(j6);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(boolean z6) throws IOException {
        c();
        this.c.value(z6);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(byte[] bArr) throws IOException {
        c();
        JsonWriter jsonWriter = this.c;
        if (bArr == null) {
            jsonWriter.nullValue();
            return this;
        }
        jsonWriter.value(Base64.encodeToString(bArr, 2));
        return this;
    }
}
