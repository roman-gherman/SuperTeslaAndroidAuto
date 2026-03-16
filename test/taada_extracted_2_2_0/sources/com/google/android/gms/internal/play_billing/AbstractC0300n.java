package com.google.android.gms.internal.play_billing;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0300n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Collector f2107a;

    static {
        final int i = 0;
        final int i3 = 0;
        final int i4 = 1;
        final int i5 = 1;
        f2107a = Collector.of(new Supplier() { // from class: com.google.android.gms.internal.play_billing.j
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i) {
                    case 0:
                        return new C0326w();
                    case 1:
                        return new E();
                    default:
                        return new C();
                }
            }
        }, new BiConsumer() { // from class: com.google.android.gms.internal.play_billing.m
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                switch (i3) {
                    case 0:
                        ((C0326w) obj).a(obj2);
                        return;
                    case 1:
                        E e = (E) obj;
                        e.getClass();
                        obj2.getClass();
                        e.a(obj2);
                        return;
                    default:
                        C c = (C) obj;
                        M m6 = (M) obj2;
                        c.getClass();
                        if (m6.f2044a.equals(m6.b)) {
                            throw new IllegalArgumentException(AbstractC0263a1.e("range must not be empty, but was %s", m6));
                        }
                        c.f2022a.add(m6);
                        return;
                }
            }
        }, new BinaryOperator() { // from class: com.google.android.gms.internal.play_billing.k
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i4) {
                    case 0:
                        C c = (C) obj;
                        c.getClass();
                        for (M m6 : ((C) obj2).f2022a) {
                            if (m6.f2044a.equals(m6.b)) {
                                throw new IllegalArgumentException(AbstractC0263a1.e("range must not be empty, but was %s", m6));
                            }
                            c.f2022a.add(m6);
                        }
                        return c;
                    case 1:
                        C0326w c0326w = (C0326w) obj;
                        C0326w c0326w2 = (C0326w) obj2;
                        Object[] objArr = c0326w2.f2127a;
                        int i6 = c0326w2.b;
                        for (int i7 = 0; i7 < i6; i7++) {
                            c0326w.getClass();
                            if (objArr[i7] == null) {
                                throw new NullPointerException(B2.b.c(i7, "at index "));
                            }
                        }
                        c0326w.c(i6);
                        System.arraycopy(objArr, 0, c0326w.f2127a, c0326w.b, i6);
                        c0326w.b += i6;
                        return c0326w;
                    default:
                        E e = (E) obj;
                        E e6 = (E) obj2;
                        Object[] objArr2 = e6.f2127a;
                        int i8 = e6.b;
                        for (int i9 = 0; i9 < i8; i9++) {
                            e.getClass();
                            if (objArr2[i9] == null) {
                                throw new NullPointerException(B2.b.c(i9, "at index "));
                            }
                        }
                        e.c(i8);
                        System.arraycopy(objArr2, 0, e.f2127a, e.b, i8);
                        e.b += i8;
                        return e;
                }
            }
        }, new Function() { // from class: com.google.android.gms.internal.play_billing.l
            /* JADX WARN: Removed duplicated region for block: B:69:0x0125  */
            /* JADX WARN: Removed duplicated region for block: B:99:0x0129 A[SYNTHETIC] */
            @Override // java.util.function.Function
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object apply(java.lang.Object r13) {
                /*
                    Method dump skipped, instruction units count: 422
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.C0294l.apply(java.lang.Object):java.lang.Object");
            }
        }, new Collector.Characteristics[0]);
        final int i6 = 1;
        final int i7 = 1;
        final int i8 = 2;
        final int i9 = 2;
        Collector.of(new Supplier() { // from class: com.google.android.gms.internal.play_billing.j
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return new C0326w();
                    case 1:
                        return new E();
                    default:
                        return new C();
                }
            }
        }, new BiConsumer() { // from class: com.google.android.gms.internal.play_billing.m
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                switch (i7) {
                    case 0:
                        ((C0326w) obj).a(obj2);
                        return;
                    case 1:
                        E e = (E) obj;
                        e.getClass();
                        obj2.getClass();
                        e.a(obj2);
                        return;
                    default:
                        C c = (C) obj;
                        M m6 = (M) obj2;
                        c.getClass();
                        if (m6.f2044a.equals(m6.b)) {
                            throw new IllegalArgumentException(AbstractC0263a1.e("range must not be empty, but was %s", m6));
                        }
                        c.f2022a.add(m6);
                        return;
                }
            }
        }, new BinaryOperator() { // from class: com.google.android.gms.internal.play_billing.k
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i8) {
                    case 0:
                        C c = (C) obj;
                        c.getClass();
                        for (M m6 : ((C) obj2).f2022a) {
                            if (m6.f2044a.equals(m6.b)) {
                                throw new IllegalArgumentException(AbstractC0263a1.e("range must not be empty, but was %s", m6));
                            }
                            c.f2022a.add(m6);
                        }
                        return c;
                    case 1:
                        C0326w c0326w = (C0326w) obj;
                        C0326w c0326w2 = (C0326w) obj2;
                        Object[] objArr = c0326w2.f2127a;
                        int i62 = c0326w2.b;
                        for (int i72 = 0; i72 < i62; i72++) {
                            c0326w.getClass();
                            if (objArr[i72] == null) {
                                throw new NullPointerException(B2.b.c(i72, "at index "));
                            }
                        }
                        c0326w.c(i62);
                        System.arraycopy(objArr, 0, c0326w.f2127a, c0326w.b, i62);
                        c0326w.b += i62;
                        return c0326w;
                    default:
                        E e = (E) obj;
                        E e6 = (E) obj2;
                        Object[] objArr2 = e6.f2127a;
                        int i82 = e6.b;
                        for (int i92 = 0; i92 < i82; i92++) {
                            e.getClass();
                            if (objArr2[i92] == null) {
                                throw new NullPointerException(B2.b.c(i92, "at index "));
                            }
                        }
                        e.c(i82);
                        System.arraycopy(objArr2, 0, e.f2127a, e.b, i82);
                        e.b += i82;
                        return e;
                }
            }
        }, new Function() { // from class: com.google.android.gms.internal.play_billing.l
            /* JADX WARN: Removed duplicated region for block: B:69:0x0125  */
            /* JADX WARN: Removed duplicated region for block: B:99:0x0129 A[SYNTHETIC] */
            @Override // java.util.function.Function
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object apply(java.lang.Object r13) {
                /*
                    Method dump skipped, instruction units count: 422
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.C0294l.apply(java.lang.Object):java.lang.Object");
            }
        }, new Collector.Characteristics[0]);
        final int i10 = 2;
        final int i11 = 2;
        final int i12 = 0;
        final int i13 = 0;
        Collector.of(new Supplier() { // from class: com.google.android.gms.internal.play_billing.j
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return new C0326w();
                    case 1:
                        return new E();
                    default:
                        return new C();
                }
            }
        }, new BiConsumer() { // from class: com.google.android.gms.internal.play_billing.m
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                switch (i11) {
                    case 0:
                        ((C0326w) obj).a(obj2);
                        return;
                    case 1:
                        E e = (E) obj;
                        e.getClass();
                        obj2.getClass();
                        e.a(obj2);
                        return;
                    default:
                        C c = (C) obj;
                        M m6 = (M) obj2;
                        c.getClass();
                        if (m6.f2044a.equals(m6.b)) {
                            throw new IllegalArgumentException(AbstractC0263a1.e("range must not be empty, but was %s", m6));
                        }
                        c.f2022a.add(m6);
                        return;
                }
            }
        }, new BinaryOperator() { // from class: com.google.android.gms.internal.play_billing.k
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                switch (i12) {
                    case 0:
                        C c = (C) obj;
                        c.getClass();
                        for (M m6 : ((C) obj2).f2022a) {
                            if (m6.f2044a.equals(m6.b)) {
                                throw new IllegalArgumentException(AbstractC0263a1.e("range must not be empty, but was %s", m6));
                            }
                            c.f2022a.add(m6);
                        }
                        return c;
                    case 1:
                        C0326w c0326w = (C0326w) obj;
                        C0326w c0326w2 = (C0326w) obj2;
                        Object[] objArr = c0326w2.f2127a;
                        int i62 = c0326w2.b;
                        for (int i72 = 0; i72 < i62; i72++) {
                            c0326w.getClass();
                            if (objArr[i72] == null) {
                                throw new NullPointerException(B2.b.c(i72, "at index "));
                            }
                        }
                        c0326w.c(i62);
                        System.arraycopy(objArr, 0, c0326w.f2127a, c0326w.b, i62);
                        c0326w.b += i62;
                        return c0326w;
                    default:
                        E e = (E) obj;
                        E e6 = (E) obj2;
                        Object[] objArr2 = e6.f2127a;
                        int i82 = e6.b;
                        for (int i92 = 0; i92 < i82; i92++) {
                            e.getClass();
                            if (objArr2[i92] == null) {
                                throw new NullPointerException(B2.b.c(i92, "at index "));
                            }
                        }
                        e.c(i82);
                        System.arraycopy(objArr2, 0, e.f2127a, e.b, i82);
                        e.b += i82;
                        return e;
                }
            }
        }, new Function() { // from class: com.google.android.gms.internal.play_billing.l
            /* JADX WARN: Removed duplicated region for block: B:69:0x0125  */
            /* JADX WARN: Removed duplicated region for block: B:99:0x0129 A[SYNTHETIC] */
            @Override // java.util.function.Function
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object apply(java.lang.Object r13) {
                /*
                    Method dump skipped, instruction units count: 422
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.C0294l.apply(java.lang.Object):java.lang.Object");
            }
        }, new Collector.Characteristics[0]);
    }
}
