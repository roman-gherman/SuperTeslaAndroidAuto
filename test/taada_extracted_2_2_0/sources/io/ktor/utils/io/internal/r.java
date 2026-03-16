package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
public final class r {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(r.class, "_availableForRead$internal");
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(r.class, "_availableForWrite$internal");
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(r.class, "_pendingToFlush");

    @NotNull
    public volatile /* synthetic */ int _availableForWrite$internal;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3591a;

    @NotNull
    public volatile /* synthetic */ int _availableForRead$internal = 0;

    @NotNull
    volatile /* synthetic */ int _pendingToFlush = 0;

    public r(int i) {
        this.f3591a = i;
        this._availableForWrite$internal = i;
    }

    public final void a(int i) {
        int i3;
        int i4;
        do {
            i3 = this._availableForWrite$internal;
            i4 = i3 + i;
            if (i4 > this.f3591a) {
                throw new IllegalArgumentException("Completed read overflow: " + i3 + " + " + i + " = " + i4 + " > " + this.f3591a);
            }
        } while (!c.compareAndSet(this, i3, i4));
    }

    public final void b(int i) {
        int i3;
        int i4;
        do {
            i3 = this._pendingToFlush;
            i4 = i3 + i;
            if (i4 > this.f3591a) {
                throw new IllegalArgumentException("Complete write overflow: " + i3 + " + " + i + " > " + this.f3591a);
            }
        } while (!d.compareAndSet(this, i3, i4));
    }

    public final boolean c() {
        int andSet = d.getAndSet(this, 0);
        return andSet == 0 ? this._availableForRead$internal > 0 : b.addAndGet(this, andSet) > 0;
    }

    public final boolean d() {
        return this._availableForWrite$internal == 0;
    }

    public final void e() {
        this._availableForRead$internal = this.f3591a;
        this._availableForWrite$internal = 0;
        this._pendingToFlush = 0;
    }

    public final void f() {
        this._availableForRead$internal = 0;
        this._pendingToFlush = 0;
        this._availableForWrite$internal = this.f3591a;
    }

    public final boolean g() {
        int i;
        do {
            i = this._availableForWrite$internal;
            if (this._pendingToFlush > 0 || this._availableForRead$internal > 0 || i != this.f3591a) {
                return false;
            }
        } while (!c.compareAndSet(this, i, 0));
        return true;
    }

    public final int h(int i) {
        int i3;
        int iMin;
        do {
            i3 = this._availableForRead$internal;
            iMin = Math.min(i, i3);
            if (iMin == 0) {
                return 0;
            }
        } while (!b.compareAndSet(this, i3, i3 - iMin));
        return Math.min(i, i3);
    }

    public final boolean i(int i) {
        int i3;
        do {
            i3 = this._availableForRead$internal;
            if (i3 < i) {
                return false;
            }
        } while (!b.compareAndSet(this, i3, i3 - i));
        return true;
    }

    public final int j(int i) {
        int i3;
        int iMin;
        do {
            i3 = this._availableForWrite$internal;
            iMin = Math.min(i, i3);
            if (iMin == 0) {
                return 0;
            }
        } while (!c.compareAndSet(this, i3, i3 - iMin));
        return Math.min(i, i3);
    }

    public final boolean k(int i) {
        int i3;
        do {
            i3 = this._availableForWrite$internal;
            if (i3 < i) {
                return false;
            }
        } while (!c.compareAndSet(this, i3, i3 - i));
        return true;
    }

    public final String toString() {
        return "RingBufferCapacity[read: " + this._availableForRead$internal + ", write: " + this._availableForWrite$internal + ", flush: " + this._pendingToFlush + ", capacity: " + this.f3591a + ']';
    }
}
