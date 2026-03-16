package com.google.protobuf;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class TextFormatParseLocation {
    public static final TextFormatParseLocation EMPTY = new TextFormatParseLocation(-1, -1);
    private final int column;
    private final int line;

    private TextFormatParseLocation(int i, int i3) {
        this.line = i;
        this.column = i3;
    }

    public static TextFormatParseLocation create(int i, int i3) {
        if (i == -1 && i3 == -1) {
            return EMPTY;
        }
        if (i < 0 || i3 < 0) {
            throw new IllegalArgumentException(String.format("line and column values must be >= 0: line %d, column: %d", Integer.valueOf(i), Integer.valueOf(i3)));
        }
        return new TextFormatParseLocation(i, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextFormatParseLocation)) {
            return false;
        }
        TextFormatParseLocation textFormatParseLocation = (TextFormatParseLocation) obj;
        return this.line == textFormatParseLocation.getLine() && this.column == textFormatParseLocation.getColumn();
    }

    public int getColumn() {
        return this.column;
    }

    public int getLine() {
        return this.line;
    }

    public int hashCode() {
        return Arrays.hashCode(new int[]{this.line, this.column});
    }

    public String toString() {
        return String.format("ParseLocation{line=%d, column=%d}", Integer.valueOf(this.line), Integer.valueOf(this.column));
    }
}
