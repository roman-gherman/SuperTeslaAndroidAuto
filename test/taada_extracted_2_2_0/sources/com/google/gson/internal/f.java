package com.google.gson.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes.dex */
public final class f implements ObjectConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2998a;
    public final /* synthetic */ Type b;

    public /* synthetic */ f(int i, Type type) {
        this.f2998a = i;
        this.b = type;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public final Object construct() {
        switch (this.f2998a) {
            case 0:
                Type type = this.b;
                if (!(type instanceof ParameterizedType)) {
                    throw new com.google.gson.q("Invalid EnumSet type: " + type.toString());
                }
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new com.google.gson.q("Invalid EnumSet type: " + type.toString());
            default:
                Type type3 = this.b;
                if (!(type3 instanceof ParameterizedType)) {
                    throw new com.google.gson.q("Invalid EnumMap type: " + type3.toString());
                }
                Type type4 = ((ParameterizedType) type3).getActualTypeArguments()[0];
                if (type4 instanceof Class) {
                    return new EnumMap((Class) type4);
                }
                throw new com.google.gson.q("Invalid EnumMap type: " + type3.toString());
        }
    }
}
