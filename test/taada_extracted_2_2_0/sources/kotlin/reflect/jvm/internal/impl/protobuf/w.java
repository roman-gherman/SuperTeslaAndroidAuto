package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Stack f3879a = new Stack();
    public u b;

    public w(AbstractC0604e abstractC0604e) {
        while (abstractC0604e instanceof z) {
            z zVar = (z) abstractC0604e;
            this.f3879a.push(zVar);
            abstractC0604e = zVar.c;
        }
        this.b = (u) abstractC0604e;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final u next() {
        u uVar;
        u uVar2 = this.b;
        if (uVar2 == null) {
            throw new NoSuchElementException();
        }
        while (true) {
            Stack stack = this.f3879a;
            if (!stack.isEmpty()) {
                AbstractC0604e abstractC0604e = ((z) stack.pop()).d;
                while (abstractC0604e instanceof z) {
                    z zVar = (z) abstractC0604e;
                    stack.push(zVar);
                    abstractC0604e = zVar.c;
                }
                uVar = (u) abstractC0604e;
                if (uVar.b.length != 0) {
                    break;
                }
            } else {
                uVar = null;
                break;
            }
        }
        this.b = uVar;
        return uVar2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
