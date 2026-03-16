package com.google.common.collect;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ i[] f2781a = {new i() { // from class: com.google.common.collect.g
    }, new i() { // from class: com.google.common.collect.h
    }};

    /* JADX INFO: Fake field, exist only in values array */
    i EF2;

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) f2781a.clone();
    }
}
