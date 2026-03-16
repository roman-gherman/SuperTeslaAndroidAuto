package M0;

import com.google.gson.E;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import net.bytebuddy.utility.JavaConstant;

/* JADX INFO: loaded from: classes.dex */
public final class u extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1019a;

    public /* synthetic */ u(int i) {
        this.f1019a = i;
    }

    public static com.google.gson.p c(com.google.gson.stream.b bVar, int i) throws IOException {
        int iB = f.s.b(i);
        if (iB == 5) {
            return new com.google.gson.v(bVar.u());
        }
        if (iB == 6) {
            return new com.google.gson.v(new com.google.gson.internal.j(bVar.u()));
        }
        if (iB == 7) {
            return new com.google.gson.v(Boolean.valueOf(bVar.m()));
        }
        if (iB != 8) {
            throw new IllegalStateException("Unexpected token: ".concat(androidx.constraintlayout.core.motion.a.C(i)));
        }
        bVar.s();
        return com.google.gson.r.f3040a;
    }

    public static void d(com.google.gson.stream.c cVar, com.google.gson.p pVar) {
        if (pVar == null || (pVar instanceof com.google.gson.r)) {
            cVar.i();
            return;
        }
        boolean z6 = pVar instanceof com.google.gson.v;
        if (z6) {
            if (!z6) {
                throw new IllegalStateException("Not a JSON Primitive: " + pVar);
            }
            com.google.gson.v vVar = (com.google.gson.v) pVar;
            Serializable serializable = vVar.f3061a;
            if (serializable instanceof Number) {
                cVar.o(vVar.c());
                return;
            } else if (serializable instanceof Boolean) {
                cVar.q(vVar.b());
                return;
            } else {
                cVar.p(vVar.a());
                return;
            }
        }
        boolean z7 = pVar instanceof com.google.gson.o;
        if (z7) {
            cVar.b();
            if (!z7) {
                throw new IllegalStateException("Not a JSON Array: " + pVar);
            }
            Iterator it = ((com.google.gson.o) pVar).f3039a.iterator();
            while (it.hasNext()) {
                d(cVar, (com.google.gson.p) it.next());
            }
            cVar.e();
            return;
        }
        boolean z8 = pVar instanceof com.google.gson.s;
        if (!z8) {
            throw new IllegalArgumentException("Couldn't write " + pVar.getClass());
        }
        cVar.c();
        if (!z8) {
            throw new IllegalStateException("Not a JSON Object: " + pVar);
        }
        Iterator it2 = ((com.google.gson.internal.l) ((com.google.gson.s) pVar).f3042a.entrySet()).iterator();
        while (((com.google.gson.internal.k) it2).hasNext()) {
            com.google.gson.internal.m mVarB = ((com.google.gson.internal.k) it2).b();
            cVar.g((String) mVarB.getKey());
            d(cVar, (com.google.gson.p) mVarB.getValue());
        }
        cVar.f();
    }

    @Override // com.google.gson.E
    public final Object a(com.google.gson.stream.b bVar) throws IOException {
        com.google.gson.p oVar;
        com.google.gson.p oVar2;
        boolean zM;
        switch (this.f1019a) {
            case 0:
                ArrayList arrayList = new ArrayList();
                bVar.a();
                while (bVar.j()) {
                    try {
                        arrayList.add(Integer.valueOf(bVar.o()));
                    } catch (NumberFormatException e) {
                        throw new com.google.gson.w(e);
                    }
                }
                bVar.e();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i = 0; i < size; i++) {
                    atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
                }
                return atomicIntegerArray;
            case 1:
                if (bVar.w() == 9) {
                    bVar.s();
                    return null;
                }
                try {
                    return Long.valueOf(bVar.p());
                } catch (NumberFormatException e6) {
                    throw new com.google.gson.w(e6);
                }
            case 2:
                if (bVar.w() != 9) {
                    return Float.valueOf((float) bVar.n());
                }
                bVar.s();
                return null;
            case 3:
                if (bVar.w() != 9) {
                    return Double.valueOf(bVar.n());
                }
                bVar.s();
                return null;
            case 4:
                if (bVar.w() == 9) {
                    bVar.s();
                    return null;
                }
                String strU = bVar.u();
                if (strU.length() == 1) {
                    return Character.valueOf(strU.charAt(0));
                }
                StringBuilder sbM = B2.b.m("Expecting character, got: ", strU, "; at ");
                sbM.append(bVar.i());
                throw new com.google.gson.w(sbM.toString());
            case 5:
                int iW = bVar.w();
                if (iW != 9) {
                    return iW == 8 ? Boolean.toString(bVar.m()) : bVar.u();
                }
                bVar.s();
                return null;
            case 6:
                if (bVar.w() == 9) {
                    bVar.s();
                    return null;
                }
                String strU2 = bVar.u();
                try {
                    return new BigDecimal(strU2);
                } catch (NumberFormatException e7) {
                    StringBuilder sbM2 = B2.b.m("Failed parsing '", strU2, "' as BigDecimal; at path ");
                    sbM2.append(bVar.i());
                    throw new com.google.gson.w(sbM2.toString(), e7);
                }
            case 7:
                if (bVar.w() == 9) {
                    bVar.s();
                    return null;
                }
                String strU3 = bVar.u();
                try {
                    return new BigInteger(strU3);
                } catch (NumberFormatException e8) {
                    StringBuilder sbM3 = B2.b.m("Failed parsing '", strU3, "' as BigInteger; at path ");
                    sbM3.append(bVar.i());
                    throw new com.google.gson.w(sbM3.toString(), e8);
                }
            case 8:
                if (bVar.w() != 9) {
                    return new com.google.gson.internal.j(bVar.u());
                }
                bVar.s();
                return null;
            case 9:
                if (bVar.w() != 9) {
                    return new StringBuilder(bVar.u());
                }
                bVar.s();
                return null;
            case 10:
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            case 11:
                if (bVar.w() != 9) {
                    return new StringBuffer(bVar.u());
                }
                bVar.s();
                return null;
            case 12:
                if (bVar.w() == 9) {
                    bVar.s();
                    return null;
                }
                String strU4 = bVar.u();
                if ("null".equals(strU4)) {
                    return null;
                }
                return new URL(strU4);
            case 13:
                if (bVar.w() == 9) {
                    bVar.s();
                    return null;
                }
                try {
                    String strU5 = bVar.u();
                    if ("null".equals(strU5)) {
                        return null;
                    }
                    return new URI(strU5);
                } catch (URISyntaxException e9) {
                    throw new com.google.gson.q(e9);
                }
            case 14:
                if (bVar.w() != 9) {
                    return InetAddress.getByName(bVar.u());
                }
                bVar.s();
                return null;
            case 15:
                if (bVar.w() == 9) {
                    bVar.s();
                    return null;
                }
                String strU6 = bVar.u();
                try {
                    return UUID.fromString(strU6);
                } catch (IllegalArgumentException e10) {
                    StringBuilder sbM4 = B2.b.m("Failed parsing '", strU6, "' as UUID; at path ");
                    sbM4.append(bVar.i());
                    throw new com.google.gson.w(sbM4.toString(), e10);
                }
            case 16:
                String strU7 = bVar.u();
                try {
                    return Currency.getInstance(strU7);
                } catch (IllegalArgumentException e11) {
                    StringBuilder sbM5 = B2.b.m("Failed parsing '", strU7, "' as Currency; at path ");
                    sbM5.append(bVar.i());
                    throw new com.google.gson.w(sbM5.toString(), e11);
                }
            case 17:
                if (bVar.w() == 9) {
                    bVar.s();
                    return null;
                }
                bVar.b();
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                while (bVar.w() != 4) {
                    String strQ = bVar.q();
                    int iO = bVar.o();
                    if ("year".equals(strQ)) {
                        i3 = iO;
                    } else if ("month".equals(strQ)) {
                        i4 = iO;
                    } else if ("dayOfMonth".equals(strQ)) {
                        i5 = iO;
                    } else if ("hourOfDay".equals(strQ)) {
                        i6 = iO;
                    } else if ("minute".equals(strQ)) {
                        i7 = iO;
                    } else if ("second".equals(strQ)) {
                        i8 = iO;
                    }
                }
                bVar.f();
                return new GregorianCalendar(i3, i4, i5, i6, i7, i8);
            case 18:
                if (bVar.w() == 9) {
                    bVar.s();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(bVar.u(), JavaConstant.Dynamic.DEFAULT_NAME);
                String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
            case 19:
                if (bVar instanceof h) {
                    h hVar = (h) bVar;
                    int iW2 = hVar.w();
                    if (iW2 != 5 && iW2 != 2 && iW2 != 4 && iW2 != 10) {
                        com.google.gson.p pVar = (com.google.gson.p) hVar.I();
                        hVar.C();
                        return pVar;
                    }
                    throw new IllegalStateException("Unexpected " + androidx.constraintlayout.core.motion.a.C(iW2) + " when reading a JsonElement.");
                }
                int iW3 = bVar.w();
                int iB = f.s.b(iW3);
                if (iB == 0) {
                    bVar.a();
                    oVar = new com.google.gson.o();
                } else if (iB != 2) {
                    oVar = null;
                } else {
                    bVar.b();
                    oVar = new com.google.gson.s();
                }
                if (oVar == null) {
                    return c(bVar, iW3);
                }
                ArrayDeque arrayDeque = new ArrayDeque();
                while (true) {
                    if (bVar.j()) {
                        String strQ2 = oVar instanceof com.google.gson.s ? bVar.q() : null;
                        int iW4 = bVar.w();
                        int iB2 = f.s.b(iW4);
                        if (iB2 == 0) {
                            bVar.a();
                            oVar2 = new com.google.gson.o();
                        } else if (iB2 != 2) {
                            oVar2 = null;
                        } else {
                            bVar.b();
                            oVar2 = new com.google.gson.s();
                        }
                        boolean z6 = oVar2 != null;
                        if (oVar2 == null) {
                            oVar2 = c(bVar, iW4);
                        }
                        if (oVar instanceof com.google.gson.o) {
                            ((com.google.gson.o) oVar).f3039a.add(oVar2);
                        } else {
                            ((com.google.gson.s) oVar).f3042a.put(strQ2, oVar2);
                        }
                        if (z6) {
                            arrayDeque.addLast(oVar);
                            oVar = oVar2;
                        }
                    } else {
                        if (oVar instanceof com.google.gson.o) {
                            bVar.e();
                        } else {
                            bVar.f();
                        }
                        if (arrayDeque.isEmpty()) {
                            return oVar;
                        }
                        oVar = (com.google.gson.p) arrayDeque.removeLast();
                    }
                }
                break;
            case 20:
                BitSet bitSet = new BitSet();
                bVar.a();
                int iW5 = bVar.w();
                int i9 = 0;
                while (iW5 != 2) {
                    int iB3 = f.s.b(iW5);
                    if (iB3 == 5 || iB3 == 6) {
                        int iO2 = bVar.o();
                        if (iO2 == 0) {
                            zM = false;
                        } else {
                            if (iO2 != 1) {
                                StringBuilder sbJ = B2.b.j(iO2, "Invalid bitset value ", ", expected 0 or 1; at path ");
                                sbJ.append(bVar.i());
                                throw new com.google.gson.w(sbJ.toString());
                            }
                            zM = true;
                        }
                    } else {
                        if (iB3 != 7) {
                            throw new com.google.gson.w("Invalid bitset value type: " + androidx.constraintlayout.core.motion.a.C(iW5) + "; at path " + bVar.getPath());
                        }
                        zM = bVar.m();
                    }
                    if (zM) {
                        bitSet.set(i9);
                    }
                    i9++;
                    iW5 = bVar.w();
                }
                bVar.e();
                return bitSet;
            case 21:
                int iW6 = bVar.w();
                if (iW6 != 9) {
                    return iW6 == 6 ? Boolean.valueOf(Boolean.parseBoolean(bVar.u())) : Boolean.valueOf(bVar.m());
                }
                bVar.s();
                return null;
            case 22:
                if (bVar.w() != 9) {
                    return Boolean.valueOf(bVar.u());
                }
                bVar.s();
                return null;
            case 23:
                if (bVar.w() == 9) {
                    bVar.s();
                    return null;
                }
                try {
                    int iO3 = bVar.o();
                    if (iO3 <= 255 && iO3 >= -128) {
                        return Byte.valueOf((byte) iO3);
                    }
                    StringBuilder sbJ2 = B2.b.j(iO3, "Lossy conversion from ", " to byte; at path ");
                    sbJ2.append(bVar.i());
                    throw new com.google.gson.w(sbJ2.toString());
                } catch (NumberFormatException e12) {
                    throw new com.google.gson.w(e12);
                }
            case 24:
                if (bVar.w() == 9) {
                    bVar.s();
                    return null;
                }
                try {
                    int iO4 = bVar.o();
                    if (iO4 <= 65535 && iO4 >= -32768) {
                        return Short.valueOf((short) iO4);
                    }
                    StringBuilder sbJ3 = B2.b.j(iO4, "Lossy conversion from ", " to short; at path ");
                    sbJ3.append(bVar.i());
                    throw new com.google.gson.w(sbJ3.toString());
                } catch (NumberFormatException e13) {
                    throw new com.google.gson.w(e13);
                }
            case 25:
                if (bVar.w() == 9) {
                    bVar.s();
                    return null;
                }
                try {
                    return Integer.valueOf(bVar.o());
                } catch (NumberFormatException e14) {
                    throw new com.google.gson.w(e14);
                }
            case 26:
                try {
                    return new AtomicInteger(bVar.o());
                } catch (NumberFormatException e15) {
                    throw new com.google.gson.w(e15);
                }
            case 27:
                return new AtomicBoolean(bVar.m());
            default:
                if (bVar.w() != 9) {
                    return Double.valueOf(bVar.n());
                }
                bVar.s();
                return null;
        }
    }

    @Override // com.google.gson.E
    public final void b(com.google.gson.stream.c cVar, Object obj) throws IOException {
        switch (this.f1019a) {
            case 0:
                cVar.b();
                int length = ((AtomicIntegerArray) obj).length();
                for (int i = 0; i < length; i++) {
                    cVar.m(r6.get(i));
                }
                cVar.e();
                return;
            case 1:
                Number number = (Number) obj;
                if (number == null) {
                    cVar.i();
                    return;
                } else {
                    cVar.m(number.longValue());
                    return;
                }
            case 2:
                Number numberValueOf = (Number) obj;
                if (numberValueOf == null) {
                    cVar.i();
                    return;
                }
                if (!(numberValueOf instanceof Float)) {
                    numberValueOf = Float.valueOf(numberValueOf.floatValue());
                }
                cVar.o(numberValueOf);
                return;
            case 3:
                Number number2 = (Number) obj;
                if (number2 == null) {
                    cVar.i();
                    return;
                } else {
                    cVar.l(number2.doubleValue());
                    return;
                }
            case 4:
                Character ch = (Character) obj;
                cVar.p(ch == null ? null : String.valueOf(ch));
                return;
            case 5:
                cVar.p((String) obj);
                return;
            case 6:
                cVar.o((BigDecimal) obj);
                return;
            case 7:
                cVar.o((BigInteger) obj);
                return;
            case 8:
                cVar.o((com.google.gson.internal.j) obj);
                return;
            case 9:
                StringBuilder sb = (StringBuilder) obj;
                cVar.p(sb == null ? null : sb.toString());
                return;
            case 10:
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + ((Class) obj).getName() + ". Forgot to register a type adapter?");
            case 11:
                StringBuffer stringBuffer = (StringBuffer) obj;
                cVar.p(stringBuffer == null ? null : stringBuffer.toString());
                return;
            case 12:
                URL url = (URL) obj;
                cVar.p(url == null ? null : url.toExternalForm());
                return;
            case 13:
                URI uri = (URI) obj;
                cVar.p(uri == null ? null : uri.toASCIIString());
                return;
            case 14:
                InetAddress inetAddress = (InetAddress) obj;
                cVar.p(inetAddress == null ? null : inetAddress.getHostAddress());
                return;
            case 15:
                UUID uuid = (UUID) obj;
                cVar.p(uuid == null ? null : uuid.toString());
                return;
            case 16:
                cVar.p(((Currency) obj).getCurrencyCode());
                return;
            case 17:
                if (((Calendar) obj) == null) {
                    cVar.i();
                    return;
                }
                cVar.c();
                cVar.g("year");
                cVar.m(r6.get(1));
                cVar.g("month");
                cVar.m(r6.get(2));
                cVar.g("dayOfMonth");
                cVar.m(r6.get(5));
                cVar.g("hourOfDay");
                cVar.m(r6.get(11));
                cVar.g("minute");
                cVar.m(r6.get(12));
                cVar.g("second");
                cVar.m(r6.get(13));
                cVar.f();
                return;
            case 18:
                Locale locale = (Locale) obj;
                cVar.p(locale == null ? null : locale.toString());
                return;
            case 19:
                d(cVar, (com.google.gson.p) obj);
                return;
            case 20:
                BitSet bitSet = (BitSet) obj;
                cVar.b();
                int length2 = bitSet.length();
                for (int i3 = 0; i3 < length2; i3++) {
                    cVar.m(bitSet.get(i3) ? 1L : 0L);
                }
                cVar.e();
                return;
            case 21:
                cVar.n((Boolean) obj);
                return;
            case 22:
                Boolean bool = (Boolean) obj;
                cVar.p(bool == null ? "null" : bool.toString());
                return;
            case 23:
                if (((Number) obj) == null) {
                    cVar.i();
                    return;
                } else {
                    cVar.m(r6.byteValue());
                    return;
                }
            case 24:
                if (((Number) obj) == null) {
                    cVar.i();
                    return;
                } else {
                    cVar.m(r6.shortValue());
                    return;
                }
            case 25:
                if (((Number) obj) == null) {
                    cVar.i();
                    return;
                } else {
                    cVar.m(r6.intValue());
                    return;
                }
            case 26:
                cVar.m(((AtomicInteger) obj).get());
                return;
            case 27:
                cVar.q(((AtomicBoolean) obj).get());
                return;
            default:
                Number number3 = (Number) obj;
                if (number3 == null) {
                    cVar.i();
                    return;
                }
                double dDoubleValue = number3.doubleValue();
                com.google.gson.m.a(dDoubleValue);
                cVar.l(dDoubleValue);
                return;
        }
    }
}
