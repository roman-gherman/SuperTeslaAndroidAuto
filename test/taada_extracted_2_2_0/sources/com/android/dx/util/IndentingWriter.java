package com.android.dx.util;

import java.io.FilterWriter;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public final class IndentingWriter extends FilterWriter {
    private boolean collectingIndent;
    private int column;
    private int indent;
    private final int maxIndent;
    private final String prefix;
    private final int width;

    public IndentingWriter(Writer writer, int i, String str) {
        super(writer);
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("width < 0");
        }
        if (str == null) {
            throw new NullPointerException("prefix == null");
        }
        this.width = i != 0 ? i : Integer.MAX_VALUE;
        this.maxIndent = i >> 1;
        this.prefix = str.length() == 0 ? null : str;
        bol();
    }

    private void bol() {
        this.column = 0;
        this.collectingIndent = this.maxIndent != 0;
        this.indent = 0;
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(int i) {
        int i3;
        synchronized (((FilterWriter) this).lock) {
            try {
                int i4 = 0;
                if (this.collectingIndent) {
                    if (i == 32) {
                        int i5 = this.indent + 1;
                        this.indent = i5;
                        int i6 = this.maxIndent;
                        if (i5 >= i6) {
                            this.indent = i6;
                            this.collectingIndent = false;
                        }
                    } else {
                        this.collectingIndent = false;
                    }
                }
                if (this.column == this.width && i != 10) {
                    ((FilterWriter) this).out.write(10);
                    this.column = 0;
                }
                if (this.column == 0) {
                    String str = this.prefix;
                    if (str != null) {
                        ((FilterWriter) this).out.write(str);
                    }
                    if (!this.collectingIndent) {
                        while (true) {
                            i3 = this.indent;
                            if (i4 >= i3) {
                                break;
                            }
                            ((FilterWriter) this).out.write(32);
                            i4++;
                        }
                        this.column = i3;
                    }
                }
                ((FilterWriter) this).out.write(i);
                if (i == 10) {
                    bol();
                } else {
                    this.column++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public IndentingWriter(Writer writer, int i) {
        this(writer, i, "");
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(char[] cArr, int i, int i3) {
        synchronized (((FilterWriter) this).lock) {
            while (i3 > 0) {
                try {
                    write(cArr[i]);
                    i++;
                    i3--;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(String str, int i, int i3) {
        synchronized (((FilterWriter) this).lock) {
            while (i3 > 0) {
                try {
                    write(str.charAt(i));
                    i++;
                    i3--;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
