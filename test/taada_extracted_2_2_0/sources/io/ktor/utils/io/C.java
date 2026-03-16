package io.ktor.utils.io;

import a.AbstractC0132a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class C extends kotlin.jvm.internal.i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.v f3490a;
    public final /* synthetic */ int b;
    public final /* synthetic */ char[] c;
    public final /* synthetic */ kotlin.jvm.internal.t d;
    public final /* synthetic */ kotlin.jvm.internal.t e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.s f3491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.s f3492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Appendable f3493h;
    public final /* synthetic */ kotlin.jvm.internal.t i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(kotlin.jvm.internal.v vVar, int i, char[] cArr, kotlin.jvm.internal.t tVar, kotlin.jvm.internal.t tVar2, kotlin.jvm.internal.s sVar, kotlin.jvm.internal.s sVar2, Appendable appendable, kotlin.jvm.internal.t tVar3) {
        super(1);
        this.f3490a = vVar;
        this.b = i;
        this.c = cArr;
        this.d = tVar;
        this.e = tVar2;
        this.f3491f = sVar;
        this.f3492g = sVar2;
        this.f3493h = appendable;
        this.i = tVar3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws IOException {
        int i;
        long jS;
        long jS2;
        boolean z6;
        int i3;
        boolean z7;
        boolean z8;
        char c;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        char c6;
        boolean z16;
        boolean z17;
        ByteBuffer buffer = (ByteBuffer) obj;
        kotlin.jvm.internal.h.f(buffer, "buffer");
        int iPosition = buffer.position();
        kotlin.jvm.internal.v vVar = this.f3490a;
        ByteBuffer byteBuffer = (ByteBuffer) vVar.f3817a;
        if (byteBuffer != null) {
            int iLimit = buffer.limit();
            buffer.limit(Math.min(buffer.limit(), byteBuffer.remaining() + buffer.position()));
            byteBuffer.put(buffer);
            byteBuffer.flip();
            buffer.limit(iLimit);
        } else {
            byteBuffer = buffer;
        }
        int i4 = this.b;
        kotlin.jvm.internal.t tVar = this.d;
        char[] out = this.c;
        int length = out.length;
        if (i4 != Integer.MAX_VALUE) {
            length = Math.min(length, i4 - tVar.f3815a);
        }
        kotlin.jvm.internal.h.f(out, "out");
        if (byteBuffer.hasArray()) {
            byte[] bArrArray = byteBuffer.array();
            int iPosition2 = byteBuffer.position() + byteBuffer.arrayOffset();
            int iRemaining = byteBuffer.remaining() + iPosition2;
            if (iPosition2 > iRemaining) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (iRemaining > bArrArray.length) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (length > out.length) {
                throw AbstractC0132a.H(length, out.length);
            }
            boolean z18 = false;
            int i5 = 0;
            while (iPosition2 < iRemaining && i5 < length) {
                int i6 = iPosition2 + 1;
                byte b = bArrArray[iPosition2];
                if (b >= 0) {
                    char c7 = (char) b;
                    i = iPosition;
                    if (c7 == '\r') {
                        z13 = true;
                        z18 = true;
                    } else if (c7 == '\n') {
                        z13 = false;
                        z18 = false;
                    } else {
                        z13 = !z18;
                    }
                    if (!z13) {
                        byteBuffer.position(iPosition2 - byteBuffer.arrayOffset());
                        jS2 = AbstractC0132a.s(i5, -1);
                        break;
                    }
                    out[i5] = c7;
                    i5++;
                    iPosition2 = i6;
                    iPosition = i;
                } else {
                    i = iPosition;
                    z12 = z18;
                    if ((b & 224) == 192) {
                        if (i6 >= iRemaining) {
                            byteBuffer.position(iPosition2 - byteBuffer.arrayOffset());
                            jS2 = AbstractC0132a.s(i5, 2);
                            break;
                        }
                        int i7 = iPosition2 + 2;
                        char c8 = (char) ((bArrArray[i6] & 63) | ((b & 31) << 6));
                        if (c8 == '\r') {
                            z14 = true;
                            z12 = true;
                        } else if (c8 == '\n') {
                            z14 = false;
                            z12 = false;
                        } else {
                            z14 = !z12;
                        }
                        if (!z14) {
                            byteBuffer.position(iPosition2 - byteBuffer.arrayOffset());
                            jS2 = AbstractC0132a.s(i5, -1);
                            break;
                        }
                        out[i5] = c8;
                        i5++;
                        z18 = z12;
                        iPosition2 = i7;
                        iPosition = i;
                    } else {
                        if ((b & 240) != 224) {
                            if ((b & 248) != 240) {
                                AbstractC0132a.i0(b);
                                throw null;
                            }
                            if (iRemaining - i6 < 3) {
                                byteBuffer.position(iPosition2 - byteBuffer.arrayOffset());
                                jS2 = AbstractC0132a.s(i5, 4);
                                break;
                            }
                            int i8 = iPosition2 + 4;
                            int i9 = ((bArrArray[iPosition2 + 2] & 63) << 6) | ((bArrArray[i6] & 63) << 12) | ((b & 7) << 18) | (bArrArray[iPosition2 + 3] & 63);
                            if (i9 > 1114111) {
                                AbstractC0132a.S(i9);
                                throw null;
                            }
                            if (length - i5 < 2) {
                                byteBuffer.position(iPosition2 - byteBuffer.arrayOffset());
                                jS2 = AbstractC0132a.s(i5, 0);
                                break;
                            }
                            char c9 = (char) ((i9 >>> 10) + 55232);
                            char c10 = (char) ((i9 & 1023) + 56320);
                            if (c9 == '\r') {
                                z16 = true;
                                z12 = true;
                                c6 = '\n';
                            } else {
                                c6 = '\n';
                                if (c9 == '\n') {
                                    z16 = false;
                                    z12 = false;
                                } else {
                                    z16 = !z12;
                                }
                            }
                            if (z16) {
                                if (c10 == '\r') {
                                    z17 = true;
                                    z12 = true;
                                } else if (c10 == c6) {
                                    z17 = false;
                                    z12 = false;
                                } else {
                                    z17 = !z12;
                                }
                                if (z17) {
                                    int i10 = i5 + 1;
                                    out[i5] = c9;
                                    i5 += 2;
                                    out[i10] = c10;
                                    iPosition = i;
                                    z18 = z12;
                                    iPosition2 = i8;
                                }
                            }
                            z18 = z12;
                            byteBuffer.position(iPosition2 - byteBuffer.arrayOffset());
                            jS2 = AbstractC0132a.s(i5, -1);
                            break;
                        }
                        if (iRemaining - i6 < 2) {
                            byteBuffer.position(iPosition2 - byteBuffer.arrayOffset());
                            jS2 = AbstractC0132a.s(i5, 3);
                            break;
                        }
                        byte b2 = bArrArray[i6];
                        i6 = iPosition2 + 3;
                        char c11 = (char) ((bArrArray[iPosition2 + 2] & 63) | ((b2 & 63) << 6) | ((b & 15) << 12));
                        if (c11 == '\r') {
                            z18 = true;
                            z15 = true;
                        } else {
                            if (c11 == '\n') {
                                z18 = false;
                            } else if (z12) {
                                z18 = z12;
                            } else {
                                z15 = true;
                                z18 = z12;
                            }
                            z15 = false;
                        }
                        if (!z15) {
                            byteBuffer.position((iPosition2 - 1) - byteBuffer.arrayOffset());
                            jS2 = AbstractC0132a.s(i5, -1);
                            break;
                        }
                        out[i5] = c11;
                        i5++;
                        iPosition2 = i6;
                        iPosition = i;
                    }
                }
            }
            i = iPosition;
            z12 = z18;
            byteBuffer.position(iPosition2 - byteBuffer.arrayOffset());
            jS2 = AbstractC0132a.s(i5, 0);
            z18 = z12;
            int i11 = (int) (jS2 & 4294967295L);
            if (i11 == -1) {
                int i12 = (int) (jS2 >> 32);
                if (z18) {
                    jS2 = AbstractC0132a.s(i12 - 1, -1);
                } else {
                    byteBuffer.position(byteBuffer.position() + 1);
                    if (i12 > 0) {
                        int i13 = i12 - 1;
                        if (out[i13] == '\r') {
                            jS2 = AbstractC0132a.s(i13, -1);
                        }
                    }
                }
            } else if (i11 == 0 && z18) {
                byteBuffer.position(byteBuffer.position() - 1);
                jS2 = AbstractC0132a.s(((int) (jS2 >> 32)) - 1, 2);
            }
        } else {
            i = iPosition;
            if (length > out.length) {
                throw AbstractC0132a.H(length, out.length);
            }
            boolean z19 = false;
            int i14 = 0;
            while (byteBuffer.hasRemaining() && i14 < length) {
                byte b6 = byteBuffer.get();
                if (b6 >= 0) {
                    char c12 = (char) b6;
                    if (c12 == '\r') {
                        z19 = true;
                        z6 = true;
                    } else {
                        if (c12 == '\n') {
                            z19 = false;
                        } else if (!z19) {
                            z6 = true;
                        }
                        z6 = false;
                    }
                    if (!z6) {
                        byteBuffer.position(byteBuffer.position() - 1);
                        jS2 = AbstractC0132a.s(i14, -1);
                        break;
                    }
                    i3 = i14 + 1;
                    out[i14] = c12;
                    i14 = i3;
                } else if ((b6 & 224) == 192) {
                    if (!byteBuffer.hasRemaining()) {
                        byteBuffer.position(byteBuffer.position() - 1);
                        jS2 = AbstractC0132a.s(i14, 2);
                        break;
                    }
                    char c13 = (char) (((b6 & 31) << 6) | (byteBuffer.get() & 63));
                    if (c13 == '\r') {
                        z19 = true;
                        z7 = true;
                    } else {
                        if (c13 == '\n') {
                            z19 = false;
                        } else if (!z19) {
                            z7 = true;
                        }
                        z7 = false;
                    }
                    if (!z7) {
                        byteBuffer.position(byteBuffer.position() - 2);
                        jS2 = AbstractC0132a.s(i14, -1);
                        break;
                    }
                    i3 = i14 + 1;
                    out[i14] = c13;
                    i14 = i3;
                } else {
                    if ((b6 & 240) != 224) {
                        if ((b6 & 248) != 240) {
                            AbstractC0132a.i0(b6);
                            throw null;
                        }
                        if (byteBuffer.remaining() < 3) {
                            byteBuffer.position(byteBuffer.position() - 1);
                            jS2 = AbstractC0132a.s(i14, 4);
                            break;
                        }
                        int i15 = ((b6 & 7) << 18) | ((byteBuffer.get() & 63) << 12) | ((byteBuffer.get() & 63) << 6) | (byteBuffer.get() & 63);
                        if (i15 > 1114111) {
                            AbstractC0132a.S(i15);
                            throw null;
                        }
                        if (length - i14 < 2) {
                            byteBuffer.position(byteBuffer.position() - 4);
                            jS = AbstractC0132a.s(i14, 0);
                            break;
                        }
                        char c14 = (char) ((i15 >>> 10) + 55232);
                        char c15 = (char) ((i15 & 1023) + 56320);
                        if (c14 == '\r') {
                            z10 = true;
                            z9 = true;
                            c = '\n';
                        } else {
                            c = '\n';
                            if (c14 == '\n') {
                                z10 = false;
                                z9 = false;
                            } else if (z19) {
                                z9 = z19;
                                z10 = false;
                            } else {
                                z9 = z19;
                                z10 = true;
                            }
                        }
                        if (z10) {
                            if (c15 == '\r') {
                                z19 = true;
                                z11 = true;
                            } else {
                                if (c15 == c) {
                                    z19 = false;
                                } else if (z9) {
                                    z19 = z9;
                                } else {
                                    z11 = true;
                                    z19 = z9;
                                }
                                z11 = false;
                            }
                            if (z11) {
                                int i16 = i14 + 1;
                                out[i14] = c14;
                                i14 += 2;
                                out[i16] = c15;
                            }
                        } else {
                            z19 = z9;
                        }
                        byteBuffer.position(byteBuffer.position() - 4);
                        jS2 = AbstractC0132a.s(i14, -1);
                        break;
                    }
                    if (byteBuffer.remaining() < 2) {
                        byteBuffer.position(byteBuffer.position() - 1);
                        jS2 = AbstractC0132a.s(i14, 3);
                        break;
                    }
                    char c16 = (char) (((b6 & 15) << 12) | ((byteBuffer.get() & 63) << 6) | (byteBuffer.get() & 63));
                    if (c16 == '\r') {
                        z19 = true;
                        z8 = true;
                    } else {
                        if (c16 == '\n') {
                            z19 = false;
                        } else if (!z19) {
                            z8 = true;
                        }
                        z8 = false;
                    }
                    if (!z8) {
                        byteBuffer.position(byteBuffer.position() - 3);
                        jS2 = AbstractC0132a.s(i14, -1);
                        break;
                    }
                    i3 = i14 + 1;
                    out[i14] = c16;
                    i14 = i3;
                }
            }
            jS = AbstractC0132a.s(i14, 0);
            jS2 = jS;
            int i17 = (int) (jS2 & 4294967295L);
            if (i17 == -1) {
                int i18 = (int) (jS2 >> 32);
                if (z19) {
                    jS2 = AbstractC0132a.s(i18 - 1, -1);
                } else {
                    byteBuffer.position(byteBuffer.position() + 1);
                    if (i18 > 0) {
                        int i19 = i18 - 1;
                        if (out[i19] == '\r') {
                            jS2 = AbstractC0132a.s(i19, -1);
                        }
                    }
                }
            } else if (i17 == 0 && z19) {
                byteBuffer.position(byteBuffer.position() - 1);
                jS2 = AbstractC0132a.s(((int) (jS2 >> 32)) - 1, 2);
            }
        }
        ByteBuffer byteBuffer2 = (ByteBuffer) vVar.f3817a;
        kotlin.jvm.internal.t tVar2 = this.i;
        if (byteBuffer2 != null) {
            buffer.position((byteBuffer2.position() + i) - tVar2.f3815a);
            io.ktor.utils.io.internal.h.b.recycle(byteBuffer2);
            vVar.f3817a = null;
            tVar2.f3815a = 0;
        }
        int i20 = (int) (jS2 >> 32);
        int i21 = (int) (jS2 & 4294967295L);
        this.e.f3815a = Math.max(1, i21);
        kotlin.jvm.internal.s sVar = this.f3491f;
        int i22 = -1;
        if (i21 == -1) {
            sVar.f3814a = true;
        }
        if (i21 != -1) {
            if (buffer.hasRemaining() && buffer.get(buffer.position()) == 13) {
                buffer.position(buffer.position() + 1);
                this.f3492g.f3814a = true;
            }
            i22 = -1;
        }
        if (i21 != i22 && buffer.hasRemaining() && buffer.get(buffer.position()) == 10) {
            buffer.position(buffer.position() + 1);
            sVar.f3814a = true;
        }
        Appendable appendable = this.f3493h;
        if (appendable instanceof StringBuilder) {
            ((StringBuilder) appendable).append(out, 0, i20);
        } else {
            appendable.append(CharBuffer.wrap(out, 0, i20), 0, i20);
        }
        tVar.f3815a += i20;
        if (i20 == 0 && buffer.remaining() < i21) {
            Object objBorrow = io.ktor.utils.io.internal.h.b.borrow();
            tVar2.f3815a = buffer.remaining();
            ((ByteBuffer) objBorrow).put(buffer);
            vVar.f3817a = objBorrow;
        }
        if (i4 == Integer.MAX_VALUE || tVar.f3815a < i4 || sVar.f3814a) {
            return N1.m.f1129a;
        }
        throw new H1.c("Line is longer than limit");
    }
}
