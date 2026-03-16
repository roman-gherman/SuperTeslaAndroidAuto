package K0;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.EncoderConfig;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d implements EncoderConfig {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f924g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f926a;
    public final HashMap b;
    public final a c;
    public boolean d;
    public static final a e = new a(0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f925h = new c();

    /* JADX WARN: Type inference failed for: r0v1, types: [K0.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [K0.b] */
    static {
        final int i = 0;
        f923f = new ValueEncoder() { // from class: K0.b
            @Override // com.google.firebase.encoders.Encoder
            public final void encode(Object obj, ValueEncoderContext valueEncoderContext) {
                switch (i) {
                    case 0:
                        valueEncoderContext.add((String) obj);
                        break;
                    default:
                        valueEncoderContext.add(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
        final int i3 = 1;
        f924g = new ValueEncoder() { // from class: K0.b
            @Override // com.google.firebase.encoders.Encoder
            public final void encode(Object obj, ValueEncoderContext valueEncoderContext) {
                switch (i3) {
                    case 0:
                        valueEncoderContext.add((String) obj);
                        break;
                    default:
                        valueEncoderContext.add(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
    }

    public d() {
        HashMap map = new HashMap();
        this.f926a = map;
        HashMap map2 = new HashMap();
        this.b = map2;
        this.c = e;
        this.d = false;
        map2.put(String.class, f923f);
        map.remove(String.class);
        map2.put(Boolean.class, f924g);
        map.remove(Boolean.class);
        map2.put(Date.class, f925h);
        map.remove(Date.class);
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    public final EncoderConfig registerEncoder(Class cls, ObjectEncoder objectEncoder) {
        this.f926a.put(cls, objectEncoder);
        this.b.remove(cls);
        return this;
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    public final EncoderConfig registerEncoder(Class cls, ValueEncoder valueEncoder) {
        this.b.put(cls, valueEncoder);
        this.f926a.remove(cls);
        return this;
    }
}
