package H1;

import C5.f;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.MalformedInputException;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CharBuffer f737a = CharBuffer.allocate(0);
    public static final ByteBuffer b;

    static {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(0);
        h.c(byteBufferAllocate);
        b = byteBufferAllocate;
    }

    public static final boolean a(CharsetEncoder charsetEncoder, J1.b bVar) {
        int i = bVar.c;
        int i3 = bVar.e - i;
        ByteBuffer byteBuffer = G1.b.f421a;
        ByteBuffer byteBufferC0 = f.c0(bVar.f750a, i, i3);
        CoderResult coderResultEncode = charsetEncoder.encode(f737a, byteBufferC0, true);
        if (coderResultEncode.isMalformed() || coderResultEncode.isUnmappable()) {
            d(coderResultEncode);
        }
        boolean zIsUnderflow = coderResultEncode.isUnderflow();
        if (byteBufferC0.limit() != i3) {
            throw new IllegalStateException("Buffer's limit change is not allowed");
        }
        bVar.a(byteBufferC0.position());
        return zIsUnderflow;
    }

    public static final int b(CharsetEncoder charsetEncoder, String input, int i, int i3, J1.b bVar) {
        h.f(input, "input");
        CharBuffer charBufferWrap = CharBuffer.wrap(input, i, i3);
        int iRemaining = charBufferWrap.remaining();
        int i4 = bVar.c;
        int i5 = bVar.e - i4;
        ByteBuffer byteBuffer = G1.b.f421a;
        ByteBuffer byteBufferC0 = f.c0(bVar.f750a, i4, i5);
        CoderResult coderResultEncode = charsetEncoder.encode(charBufferWrap, byteBufferC0, false);
        if (coderResultEncode.isMalformed() || coderResultEncode.isUnmappable()) {
            d(coderResultEncode);
        }
        if (byteBufferC0.limit() != i5) {
            throw new IllegalStateException("Buffer's limit change is not allowed");
        }
        bVar.a(byteBufferC0.position());
        return iRemaining - charBufferWrap.remaining();
    }

    public static final String c(Charset charset) {
        h.f(charset, "<this>");
        String strName = charset.name();
        h.e(strName, "name()");
        return strName;
    }

    public static final void d(CoderResult coderResult) {
        try {
            coderResult.throwException();
        } catch (MalformedInputException e) {
            String message = e.getMessage();
            if (message == null) {
                message = "Failed to decode bytes";
            }
            throw new b(message);
        }
    }
}
