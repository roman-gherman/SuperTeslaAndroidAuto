package v1;

import io.ktor.utils.io.internal.t;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import u1.C0840e;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4931a;
    public final C0840e b;
    public final byte[] c;

    public j(String text, C0840e contentType) {
        byte[] bytes;
        kotlin.jvm.internal.h.f(text, "text");
        kotlin.jvm.internal.h.f(contentType, "contentType");
        this.f4931a = text;
        this.b = contentType;
        Charset charsetD = t.d(contentType);
        charsetD = charsetD == null ? kotlin.text.a.f3943a : charsetD;
        Charset charset = kotlin.text.a.f3943a;
        if (kotlin.jvm.internal.h.a(charsetD, charset)) {
            bytes = text.getBytes(charset);
            kotlin.jvm.internal.h.e(bytes, "this as java.lang.String).getBytes(charset)");
        } else {
            CharsetEncoder charsetEncoderNewEncoder = charsetD.newEncoder();
            kotlin.jvm.internal.h.e(charsetEncoderNewEncoder, "charset.newEncoder()");
            int length = text.length();
            CharBuffer charBuffer = H1.a.f737a;
            if (length == text.length()) {
                bytes = text.getBytes(charsetEncoderNewEncoder.charset());
                kotlin.jvm.internal.h.e(bytes, "input as java.lang.String).getBytes(charset())");
            } else {
                String strSubstring = text.substring(0, length);
                kotlin.jvm.internal.h.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                bytes = strSubstring.getBytes(charsetEncoderNewEncoder.charset());
                kotlin.jvm.internal.h.e(bytes, "input.substring(fromInde…ring).getBytes(charset())");
            }
        }
        this.c = bytes;
    }

    @Override // v1.g
    public final Long a() {
        return Long.valueOf(this.c.length);
    }

    @Override // v1.g
    public final C0840e b() {
        return this.b;
    }

    @Override // v1.e
    public final byte[] d() {
        return this.c;
    }

    public final String toString() {
        return "TextContent[" + this.b + "] \"" + kotlin.text.i.W(30, this.f4931a) + '\"';
    }
}
