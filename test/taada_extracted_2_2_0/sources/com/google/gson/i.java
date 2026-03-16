package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class i implements FieldNamingStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0408b f2992a;
    public static final /* synthetic */ i[] b;

    static {
        C0408b c0408b = new C0408b();
        f2992a = c0408b;
        b = new i[]{c0408b, new i() { // from class: com.google.gson.c
            @Override // com.google.gson.FieldNamingStrategy
            public final String translateName(Field field) {
                return i.b(field.getName());
            }
        }, new i() { // from class: com.google.gson.d
            @Override // com.google.gson.FieldNamingStrategy
            public final String translateName(Field field) {
                return i.b(i.a(field.getName(), ' '));
            }
        }, new i() { // from class: com.google.gson.e
            @Override // com.google.gson.FieldNamingStrategy
            public final String translateName(Field field) {
                return i.a(field.getName(), '_').toUpperCase(Locale.ENGLISH);
            }
        }, new i() { // from class: com.google.gson.f
            @Override // com.google.gson.FieldNamingStrategy
            public final String translateName(Field field) {
                return i.a(field.getName(), '_').toLowerCase(Locale.ENGLISH);
            }
        }, new i() { // from class: com.google.gson.g
            @Override // com.google.gson.FieldNamingStrategy
            public final String translateName(Field field) {
                return i.a(field.getName(), SignatureVisitor.SUPER).toLowerCase(Locale.ENGLISH);
            }
        }, new i() { // from class: com.google.gson.h
            @Override // com.google.gson.FieldNamingStrategy
            public final String translateName(Field field) {
                return i.a(field.getName(), TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH).toLowerCase(Locale.ENGLISH);
            }
        }};
    }

    public static String a(String str, char c) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(c);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String b(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            char cCharAt = str.charAt(i);
            if (!Character.isLetter(cCharAt)) {
                i++;
            } else if (!Character.isUpperCase(cCharAt)) {
                char upperCase = Character.toUpperCase(cCharAt);
                if (i == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i) + upperCase + str.substring(i + 1);
            }
        }
        return str;
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) b.clone();
    }
}
