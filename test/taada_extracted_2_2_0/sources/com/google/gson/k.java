package com.google.gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes.dex */
public final class k extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3019a;
    public final /* synthetic */ E b;

    public /* synthetic */ k(E e, int i) {
        this.f3019a = i;
        this.b = e;
    }

    @Override // com.google.gson.E
    public final Object a(com.google.gson.stream.b bVar) throws IOException {
        switch (this.f3019a) {
            case 0:
                return new AtomicLong(((Number) this.b.a(bVar)).longValue());
            case 1:
                ArrayList arrayList = new ArrayList();
                bVar.a();
                while (bVar.j()) {
                    arrayList.add(Long.valueOf(((Number) this.b.a(bVar)).longValue()));
                }
                bVar.e();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            default:
                if (bVar.w() != 9) {
                    return this.b.a(bVar);
                }
                bVar.s();
                return null;
        }
    }

    @Override // com.google.gson.E
    public final void b(com.google.gson.stream.c cVar, Object obj) throws IOException {
        switch (this.f3019a) {
            case 0:
                this.b.b(cVar, Long.valueOf(((AtomicLong) obj).get()));
                break;
            case 1:
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                cVar.b();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    this.b.b(cVar, Long.valueOf(atomicLongArray.get(i)));
                }
                cVar.e();
                break;
            default:
                if (obj == null) {
                    cVar.i();
                } else {
                    this.b.b(cVar, obj);
                }
                break;
        }
    }
}
