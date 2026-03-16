package H2;

import java.util.Arrays;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends I2.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f739f = new a(1, 0, 7);

    static {
        new a(new int[0]);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int... numbers) {
        super(Arrays.copyOf(numbers, numbers.length));
        h.f(numbers, "numbers");
    }
}
