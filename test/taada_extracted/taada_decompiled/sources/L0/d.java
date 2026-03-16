package L0;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.proto.ProtoEnum;
import com.google.firebase.encoders.proto.Protobuf;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d implements ObjectEncoderContext {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f950f = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.google.firebase.encoders.b f951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.google.firebase.encoders.b f952h;
    public static final K0.a i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f953a;
    public final HashMap b;
    public final HashMap c;
    public final K0.a d;
    public final f e = new f(this);

    static {
        a aVar = new a(1);
        HashMap map = new HashMap();
        map.put(Protobuf.class, aVar);
        f951g = new com.google.firebase.encoders.b("key", Collections.unmodifiableMap(new HashMap(map)));
        a aVar2 = new a(2);
        HashMap map2 = new HashMap();
        map2.put(Protobuf.class, aVar2);
        f952h = new com.google.firebase.encoders.b("value", Collections.unmodifiableMap(new HashMap(map2)));
        i = new K0.a(1);
    }

    public d(ByteArrayOutputStream byteArrayOutputStream, HashMap map, HashMap map2, K0.a aVar) {
        this.f953a = byteArrayOutputStream;
        this.b = map;
        this.c = map2;
        this.d = aVar;
    }

    public static int h(com.google.firebase.encoders.b bVar) {
        Protobuf protobuf = (Protobuf) ((Annotation) bVar.b.get(Protobuf.class));
        if (protobuf != null) {
            return protobuf.tag();
        }
        throw new com.google.firebase.encoders.a("Field has no @Protobuf config");
    }

    public final d a(com.google.firebase.encoders.b bVar, Object obj, boolean z6) {
        if (obj != null) {
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                if (!z6 || charSequence.length() != 0) {
                    i((h(bVar) << 3) | 2);
                    byte[] bytes = charSequence.toString().getBytes(f950f);
                    i(bytes.length);
                    this.f953a.write(bytes);
                    return this;
                }
            } else if (obj instanceof Collection) {
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    a(bVar, it.next(), false);
                }
            } else if (obj instanceof Map) {
                Iterator it2 = ((Map) obj).entrySet().iterator();
                while (it2.hasNext()) {
                    f(i, bVar, (Map.Entry) it2.next(), false);
                }
            } else {
                if (obj instanceof Double) {
                    b(bVar, ((Double) obj).doubleValue(), z6);
                    return this;
                }
                if (obj instanceof Float) {
                    c(bVar, ((Float) obj).floatValue(), z6);
                    return this;
                }
                if (obj instanceof Number) {
                    e(bVar, ((Number) obj).longValue(), z6);
                    return this;
                }
                if (obj instanceof Boolean) {
                    d(bVar, ((Boolean) obj).booleanValue() ? 1 : 0, z6);
                    return this;
                }
                if (!(obj instanceof byte[])) {
                    ObjectEncoder objectEncoder = (ObjectEncoder) this.b.get(obj.getClass());
                    if (objectEncoder != null) {
                        f(objectEncoder, bVar, obj, z6);
                        return this;
                    }
                    ValueEncoder valueEncoder = (ValueEncoder) this.c.get(obj.getClass());
                    if (valueEncoder != null) {
                        f fVar = this.e;
                        fVar.f955a = false;
                        fVar.c = bVar;
                        fVar.b = z6;
                        valueEncoder.encode(obj, fVar);
                        return this;
                    }
                    if (obj instanceof ProtoEnum) {
                        d(bVar, ((ProtoEnum) obj).getNumber(), true);
                        return this;
                    }
                    if (obj instanceof Enum) {
                        d(bVar, ((Enum) obj).ordinal(), true);
                        return this;
                    }
                    f(this.d, bVar, obj, z6);
                    return this;
                }
                byte[] bArr = (byte[]) obj;
                if (!z6 || bArr.length != 0) {
                    i((h(bVar) << 3) | 2);
                    i(bArr.length);
                    this.f953a.write(bArr);
                    return this;
                }
            }
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, Object obj) {
        a(com.google.firebase.encoders.b.a(str), obj, true);
        return this;
    }

    public final void b(com.google.firebase.encoders.b bVar, double d, boolean z6) {
        if (z6 && d == 0.0d) {
            return;
        }
        i((h(bVar) << 3) | 1);
        this.f953a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(d).array());
    }

    public final void c(com.google.firebase.encoders.b bVar, float f6, boolean z6) {
        if (z6 && f6 == 0.0f) {
            return;
        }
        i((h(bVar) << 3) | 5);
        this.f953a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(f6).array());
    }

    public final void d(com.google.firebase.encoders.b bVar, int i3, boolean z6) {
        if (z6 && i3 == 0) {
            return;
        }
        Protobuf protobuf = (Protobuf) ((Annotation) bVar.b.get(Protobuf.class));
        if (protobuf == null) {
            throw new com.google.firebase.encoders.a("Field has no @Protobuf config");
        }
        int iOrdinal = protobuf.intEncoding().ordinal();
        if (iOrdinal == 0) {
            i(protobuf.tag() << 3);
            i(i3);
        } else if (iOrdinal == 1) {
            i(protobuf.tag() << 3);
            i((i3 << 1) ^ (i3 >> 31));
        } else {
            if (iOrdinal != 2) {
                return;
            }
            i((protobuf.tag() << 3) | 5);
            this.f953a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i3).array());
        }
    }

    public final void e(com.google.firebase.encoders.b bVar, long j6, boolean z6) {
        if (z6 && j6 == 0) {
            return;
        }
        Protobuf protobuf = (Protobuf) ((Annotation) bVar.b.get(Protobuf.class));
        if (protobuf == null) {
            throw new com.google.firebase.encoders.a("Field has no @Protobuf config");
        }
        int iOrdinal = protobuf.intEncoding().ordinal();
        if (iOrdinal == 0) {
            i(protobuf.tag() << 3);
            j(j6);
        } else if (iOrdinal == 1) {
            i(protobuf.tag() << 3);
            j((j6 >> 63) ^ (j6 << 1));
        } else {
            if (iOrdinal != 2) {
                return;
            }
            i((protobuf.tag() << 3) | 1);
            this.f953a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j6).array());
        }
    }

    public final void f(ObjectEncoder objectEncoder, com.google.firebase.encoders.b bVar, Object obj, boolean z6) throws IOException {
        b bVar2 = new b();
        bVar2.f948a = 0L;
        try {
            OutputStream outputStream = this.f953a;
            this.f953a = bVar2;
            try {
                objectEncoder.encode(obj, this);
                this.f953a = outputStream;
                long j6 = bVar2.f948a;
                bVar2.close();
                if (z6 && j6 == 0) {
                    return;
                }
                i((h(bVar) << 3) | 2);
                j(j6);
                objectEncoder.encode(obj, this);
            } catch (Throwable th) {
                this.f953a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                bVar2.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void g(Object obj) {
        if (obj == null) {
            return;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.b.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.encode(obj, this);
        } else {
            throw new com.google.firebase.encoders.a("No encoder for " + obj.getClass());
        }
    }

    public final void i(int i3) throws IOException {
        while ((i3 & (-128)) != 0) {
            this.f953a.write((i3 & 127) | 128);
            i3 >>>= 7;
        }
        this.f953a.write(i3 & 127);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext inline(Object obj) {
        g(obj);
        return this;
    }

    public final void j(long j6) throws IOException {
        while (((-128) & j6) != 0) {
            this.f953a.write((((int) j6) & 127) | 128);
            j6 >>>= 7;
        }
        this.f953a.write(((int) j6) & 127);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext nested(String str) {
        nested(com.google.firebase.encoders.b.a(str));
        throw null;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext nested(com.google.firebase.encoders.b bVar) {
        throw new com.google.firebase.encoders.a("nested() is not implemented for protobuf encoding.");
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, double d) {
        b(com.google.firebase.encoders.b.a(str), d, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, int i3) {
        d(com.google.firebase.encoders.b.a(str), i3, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, long j6) {
        e(com.google.firebase.encoders.b.a(str), j6, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String str, boolean z6) {
        d(com.google.firebase.encoders.b.a(str), z6 ? 1 : 0, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(com.google.firebase.encoders.b bVar, Object obj) {
        a(bVar, obj, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(com.google.firebase.encoders.b bVar, double d) {
        b(bVar, d, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(com.google.firebase.encoders.b bVar, float f6) {
        c(bVar, f6, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(com.google.firebase.encoders.b bVar, int i3) {
        d(bVar, i3, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(com.google.firebase.encoders.b bVar, long j6) {
        e(bVar, j6, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(com.google.firebase.encoders.b bVar, boolean z6) {
        d(bVar, z6 ? 1 : 0, true);
        return this;
    }
}
