package org.mockito.internal.matchers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.mockito.ArgumentMatcher;
import org.mockito.internal.exceptions.Reporter;

/* JADX INFO: loaded from: classes.dex */
public class CapturingMatcher<T> implements ArgumentMatcher<T>, CapturesArguments, VarargMatcher, Serializable {
    private final List<Object> arguments = new ArrayList();
    private final Class<? extends T> clazz;
    private final ReadWriteLock lock;
    private final Lock readLock;
    private final Lock writeLock;

    public CapturingMatcher(Class<? extends T> cls) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.lock = reentrantReadWriteLock;
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        Objects.requireNonNull(cls);
        this.clazz = cls;
    }

    @Override // org.mockito.internal.matchers.CapturesArguments
    public void captureFrom(Object obj) {
        this.writeLock.lock();
        try {
            this.arguments.add(obj);
        } finally {
            this.writeLock.unlock();
        }
    }

    public List<T> getAllValues() {
        this.readLock.lock();
        try {
            return new ArrayList(this.arguments);
        } finally {
            this.readLock.unlock();
        }
    }

    public T getLastValue() {
        this.readLock.lock();
        try {
            if (this.arguments.isEmpty()) {
                throw Reporter.noArgumentValueWasCaptured();
            }
            return (T) this.arguments.get(r0.size() - 1);
        } finally {
            this.readLock.unlock();
        }
    }

    @Override // org.mockito.ArgumentMatcher
    public boolean matches(Object obj) {
        return true;
    }

    public String toString() {
        return "<Capturing argument>";
    }

    @Override // org.mockito.ArgumentMatcher
    public Class<?> type() {
        return this.clazz;
    }
}
