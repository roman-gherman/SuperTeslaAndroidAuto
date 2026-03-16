package com.google.gson.stream;

import M0.h;
import com.google.gson.v;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f3043a;

    public static void a(b bVar) throws IOException {
        if (bVar instanceof h) {
            h hVar = (h) bVar;
            hVar.E(5);
            Map.Entry entry = (Map.Entry) ((Iterator) hVar.I()).next();
            hVar.K(entry.getValue());
            hVar.K(new v((String) entry.getKey()));
            return;
        }
        int iD = bVar.f3047h;
        if (iD == 0) {
            iD = bVar.d();
        }
        if (iD == 13) {
            bVar.f3047h = 9;
            return;
        }
        if (iD == 12) {
            bVar.f3047h = 8;
        } else {
            if (iD == 14) {
                bVar.f3047h = 10;
                return;
            }
            throw new IllegalStateException("Expected a name but was " + androidx.constraintlayout.core.motion.a.C(bVar.w()) + bVar.l());
        }
    }
}
