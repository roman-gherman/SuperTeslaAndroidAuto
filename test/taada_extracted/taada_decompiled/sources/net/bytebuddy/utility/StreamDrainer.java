package net.bytebuddy.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: loaded from: classes2.dex */
@HashCodeAndEqualsPlugin.Enhance
public class StreamDrainer {
    public static final StreamDrainer DEFAULT = new StreamDrainer();
    public static final int DEFAULT_BUFFER_SIZE = 1024;
    private static final int END_OF_STREAM = -1;
    private static final int FROM_BEGINNING = 0;
    private final int bufferSize;

    public StreamDrainer() {
        this(1024);
    }

    public byte[] drain(InputStream inputStream) throws IOException {
        int i;
        ArrayList<byte[]> arrayList = new ArrayList();
        byte[] bArr = new byte[this.bufferSize];
        int i3 = 0;
        do {
            i = inputStream.read(bArr, i3, this.bufferSize - i3);
            int iMax = Math.max(i, 0) + i3;
            if (iMax == this.bufferSize) {
                arrayList.add(bArr);
                bArr = new byte[this.bufferSize];
                i3 = 0;
            } else {
                i3 = iMax;
            }
        } while (i != -1);
        byte[] bArr2 = new byte[(arrayList.size() * this.bufferSize) + i3];
        int i4 = 0;
        for (byte[] bArr3 : arrayList) {
            int i5 = this.bufferSize;
            System.arraycopy(bArr3, 0, bArr2, i4 * i5, i5);
            i4++;
        }
        System.arraycopy(bArr, 0, bArr2, i4 * this.bufferSize, i3);
        return bArr2;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.bufferSize == ((StreamDrainer) obj).bufferSize;
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.bufferSize;
    }

    public StreamDrainer(int i) {
        this.bufferSize = i;
    }
}
