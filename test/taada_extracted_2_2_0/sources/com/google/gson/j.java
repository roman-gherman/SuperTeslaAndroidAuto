package com.google.gson;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class j extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3018a;

    @Override // com.google.gson.E
    public final Object a(com.google.gson.stream.b bVar) throws IOException {
        switch (this.f3018a) {
            case 0:
                if (bVar.w() != 9) {
                    return Long.valueOf(bVar.p());
                }
                bVar.s();
                return null;
            default:
                if (bVar.w() != 9) {
                    return Float.valueOf((float) bVar.n());
                }
                bVar.s();
                return null;
        }
    }

    @Override // com.google.gson.E
    public final void b(com.google.gson.stream.c cVar, Object obj) throws IOException {
        switch (this.f3018a) {
            case 0:
                Number number = (Number) obj;
                if (number != null) {
                    cVar.p(number.toString());
                } else {
                    cVar.i();
                }
                break;
            default:
                Number numberValueOf = (Number) obj;
                if (numberValueOf != null) {
                    float fFloatValue = numberValueOf.floatValue();
                    m.a(fFloatValue);
                    if (!(numberValueOf instanceof Float)) {
                        numberValueOf = Float.valueOf(fFloatValue);
                    }
                    cVar.o(numberValueOf);
                } else {
                    cVar.i();
                }
                break;
        }
    }
}
