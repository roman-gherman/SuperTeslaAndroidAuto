package com.google.gson;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class v extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Serializable f3061a;

    public v(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f3061a = bool;
    }

    public static boolean d(v vVar) {
        Serializable serializable = vVar.f3061a;
        if (!(serializable instanceof Number)) {
            return false;
        }
        Number number = (Number) serializable;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // com.google.gson.p
    public final String a() {
        Serializable serializable = this.f3061a;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        if (serializable instanceof Number) {
            return c().toString();
        }
        if (serializable instanceof Boolean) {
            return ((Boolean) serializable).toString();
        }
        throw new AssertionError("Unexpected value type: " + serializable.getClass());
    }

    public final boolean b() {
        Serializable serializable = this.f3061a;
        return serializable instanceof Boolean ? ((Boolean) serializable).booleanValue() : Boolean.parseBoolean(a());
    }

    public final Number c() {
        Serializable serializable = this.f3061a;
        if (serializable instanceof Number) {
            return (Number) serializable;
        }
        if (serializable instanceof String) {
            return new com.google.gson.internal.j((String) serializable);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v.class != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        Serializable serializable = this.f3061a;
        Serializable serializable2 = vVar.f3061a;
        if (serializable == null) {
            return serializable2 == null;
        }
        if (d(this) && d(vVar)) {
            return c().longValue() == vVar.c().longValue();
        }
        if (!(serializable instanceof Number) || !(serializable2 instanceof Number)) {
            return serializable.equals(serializable2);
        }
        double dDoubleValue = c().doubleValue();
        double dDoubleValue2 = vVar.c().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        Serializable serializable = this.f3061a;
        if (serializable == null) {
            return 31;
        }
        if (d(this)) {
            jDoubleToLongBits = c().longValue();
        } else {
            if (!(serializable instanceof Number)) {
                return serializable.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(c().doubleValue());
        }
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public v(Number number) {
        Objects.requireNonNull(number);
        this.f3061a = number;
    }

    public v(String str) {
        Objects.requireNonNull(str);
        this.f3061a = str;
    }
}
