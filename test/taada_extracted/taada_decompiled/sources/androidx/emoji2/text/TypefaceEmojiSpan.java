package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

/* JADX INFO: loaded from: classes.dex */
public final class TypefaceEmojiSpan extends EmojiSpan {
    private static Paint sDebugPaint;

    public TypefaceEmojiSpan(EmojiMetadata emojiMetadata) {
        super(emojiMetadata);
    }

    private static Paint getDebugPaint() {
        if (sDebugPaint == null) {
            TextPaint textPaint = new TextPaint();
            sDebugPaint = textPaint;
            textPaint.setColor(EmojiCompat.get().getEmojiSpanIndicatorColor());
            sDebugPaint.setStyle(Paint.Style.FILL);
        }
        return sDebugPaint;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i3, float f6, int i4, int i5, int i6, Paint paint) {
        Canvas canvas2;
        float f7;
        if (EmojiCompat.get().isEmojiSpanIndicatorEnabled()) {
            canvas2 = canvas;
            f7 = f6;
            canvas2.drawRect(f7, i4, f6 + getWidth(), i6, getDebugPaint());
        } else {
            canvas2 = canvas;
            f7 = f6;
        }
        getMetadata().draw(canvas2, f7, i5, paint);
    }
}
