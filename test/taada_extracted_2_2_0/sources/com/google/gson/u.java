package com.google.gson;

import java.io.IOException;
import java.io.StringReader;

/* JADX INFO: loaded from: classes.dex */
public final class u {
    public static p a(com.google.gson.stream.b bVar) {
        boolean z6 = bVar.b;
        bVar.b = true;
        try {
            try {
                try {
                    return com.google.gson.internal.d.i(bVar);
                } catch (StackOverflowError e) {
                    throw new t("Failed parsing JSON source: " + bVar + " to Json", e);
                }
            } catch (OutOfMemoryError e6) {
                throw new t("Failed parsing JSON source: " + bVar + " to Json", e6);
            }
        } finally {
            bVar.b = z6;
        }
    }

    public static p b(String str) {
        try {
            com.google.gson.stream.b bVar = new com.google.gson.stream.b(new StringReader(str));
            p pVarA = a(bVar);
            pVarA.getClass();
            if (!(pVarA instanceof r) && bVar.w() != 10) {
                throw new w("Did not consume the entire document.");
            }
            return pVarA;
        } catch (com.google.gson.stream.d e) {
            throw new w(e);
        } catch (IOException e6) {
            throw new q(e6);
        } catch (NumberFormatException e7) {
            throw new w(e7);
        }
    }
}
