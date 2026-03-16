package com.google.gson.internal;

import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class s extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Writer f3016a;
    public final r b = new r();

    public s(Writer writer) {
        this.f3016a = writer;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence) throws IOException {
        this.f3016a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }

    @Override // java.io.Writer
    public final void write(int i) throws IOException {
        this.f3016a.append((char) i);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) throws IOException {
        this.f3016a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str, int i, int i3) throws IOException {
        Objects.requireNonNull(str);
        this.f3016a.append((CharSequence) str, i, i3 + i);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence, int i, int i3) throws IOException {
        this.f3016a.append(charSequence, i, i3);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i3) throws IOException {
        this.f3016a.append(charSequence, i, i3);
        return this;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i3) throws IOException {
        r rVar = this.b;
        rVar.f3015a = cArr;
        rVar.b = null;
        this.f3016a.append((CharSequence) rVar, i, i3 + i);
    }
}
