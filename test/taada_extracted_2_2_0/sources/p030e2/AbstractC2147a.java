package p030e2;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2147a {
    public static HashMap<Byte, AudioTrack> f7663a = new C2148a();
    private static final HashMap<Byte, Object> f7664b = new C2149b();
    public static HashMap<Byte, Integer> f7665c = new C2150c();

    public static class C2148a extends HashMap<Byte, AudioTrack> {
        public C2148a() {
            put((byte) 6, new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(4).setContentType(1).build()).setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(16000).setChannelMask(4).build()).setBufferSizeInBytes(8192).build());
        }
    }

    public static class C2149b extends HashMap<Byte, Object> {
        public C2149b() {
            put((byte) 6, Executors.newSingleThreadExecutor());
        }
    }

    public static class C2150c extends HashMap<Byte, Integer> {
        public C2150c() {
            put((byte) 5, -1);
            put((byte) 6, -1);
            put((byte) 7, -1);
            put((byte) 3, -1);
        }
    }

    public static void m3527a() {
        Iterator<Map.Entry<Byte, AudioTrack>> it = f7663a.entrySet().iterator();
        while (it.hasNext()) {
            AudioTrack value = it.next().getValue();
            value.pause();
            value.flush();
            value.stop();
            value.release();
        }
    }
}
