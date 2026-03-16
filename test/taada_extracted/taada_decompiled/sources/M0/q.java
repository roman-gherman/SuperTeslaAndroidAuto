package M0;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class q extends o {
    public static final HashMap e;
    public final Constructor b;
    public final Object[] c;
    public final HashMap d;

    static {
        HashMap map = new HashMap();
        map.put(Byte.TYPE, (byte) 0);
        map.put(Short.TYPE, (short) 0);
        map.put(Integer.TYPE, 0);
        map.put(Long.TYPE, 0L);
        map.put(Float.TYPE, Float.valueOf(0.0f));
        map.put(Double.TYPE, Double.valueOf(0.0d));
        map.put(Character.TYPE, (char) 0);
        map.put(Boolean.TYPE, Boolean.FALSE);
        e = map;
    }

    public q(Class cls, LinkedHashMap linkedHashMap, boolean z6) {
        super(linkedHashMap);
        this.d = new HashMap();
        E1.k kVar = O0.c.f1177a;
        Constructor constructorF = kVar.F(cls);
        this.b = constructorF;
        if (z6) {
            r.a(null, constructorF);
        } else {
            O0.c.e(constructorF);
        }
        String[] strArrO = kVar.O(cls);
        for (int i = 0; i < strArrO.length; i++) {
            this.d.put(strArrO[i], Integer.valueOf(i));
        }
        Class<?>[] parameterTypes = this.b.getParameterTypes();
        this.c = new Object[parameterTypes.length];
        for (int i3 = 0; i3 < parameterTypes.length; i3++) {
            this.c[i3] = e.get(parameterTypes[i3]);
        }
    }

    @Override // M0.o
    public final Object c() {
        return (Object[]) this.c.clone();
    }

    @Override // M0.o
    public final Object d(Object obj) {
        Object[] objArr = (Object[]) obj;
        Constructor constructor = this.b;
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException e6) {
            E1.k kVar = O0.c.f1177a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e6);
        } catch (IllegalArgumentException e7) {
            e = e7;
            throw new RuntimeException("Failed to invoke constructor '" + O0.c.b(constructor) + "' with args " + Arrays.toString(objArr), e);
        } catch (InstantiationException e8) {
            e = e8;
            throw new RuntimeException("Failed to invoke constructor '" + O0.c.b(constructor) + "' with args " + Arrays.toString(objArr), e);
        } catch (InvocationTargetException e9) {
            throw new RuntimeException("Failed to invoke constructor '" + O0.c.b(constructor) + "' with args " + Arrays.toString(objArr), e9.getCause());
        }
    }

    @Override // M0.o
    public final void e(Object obj, com.google.gson.stream.b bVar, n nVar) {
        Object[] objArr = (Object[]) obj;
        HashMap map = this.d;
        String str = nVar.c;
        Integer num = (Integer) map.get(str);
        if (num == null) {
            throw new IllegalStateException("Could not find the index in the constructor '" + O0.c.b(this.b) + "' for field with name '" + str + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
        int iIntValue = num.intValue();
        Object objA = nVar.i.a(bVar);
        if (objA != null || !nVar.f1012l) {
            objArr[iIntValue] = objA;
        } else {
            StringBuilder sbM = B2.b.m("null is not allowed as value for record component '", str, "' of primitive type; at path ");
            sbM.append(bVar.getPath());
            throw new com.google.gson.t(sbM.toString());
        }
    }
}
