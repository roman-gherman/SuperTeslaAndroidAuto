package com.google.gson;

import java.io.IOException;
import java.math.BigDecimal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class D implements ToNumberStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f2990a;
    public static final A b;
    public static final /* synthetic */ D[] c;

    static {
        z zVar = new z();
        f2990a = zVar;
        A a6 = new A();
        b = a6;
        c = new D[]{zVar, a6, new D() { // from class: com.google.gson.B
            @Override // com.google.gson.ToNumberStrategy
            public final Number readNumber(com.google.gson.stream.b bVar) throws IOException {
                String strU = bVar.u();
                try {
                    try {
                        return Long.valueOf(Long.parseLong(strU));
                    } catch (NumberFormatException unused) {
                        Double dValueOf = Double.valueOf(strU);
                        if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                            if (!bVar.b) {
                                throw new com.google.gson.stream.d("JSON forbids NaN and infinities: " + dValueOf + "; at path " + bVar.i());
                            }
                        }
                        return dValueOf;
                    }
                } catch (NumberFormatException e) {
                    StringBuilder sbM = B2.b.m("Cannot parse ", strU, "; at path ");
                    sbM.append(bVar.i());
                    throw new t(sbM.toString(), e);
                }
            }
        }, new D() { // from class: com.google.gson.C
            @Override // com.google.gson.ToNumberStrategy
            public final Number readNumber(com.google.gson.stream.b bVar) throws IOException {
                String strU = bVar.u();
                try {
                    return new BigDecimal(strU);
                } catch (NumberFormatException e) {
                    StringBuilder sbM = B2.b.m("Cannot parse ", strU, "; at path ");
                    sbM.append(bVar.i());
                    throw new t(sbM.toString(), e);
                }
            }
        }};
    }

    public static D valueOf(String str) {
        return (D) Enum.valueOf(D.class, str);
    }

    public static D[] values() {
        return (D[]) c.clone();
    }
}
