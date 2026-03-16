package C0;

import G0.C0058h1;
import com.google.crypto.tink.internal.Serialization;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Serialization {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I0.a f155a;
    public final C0058h1 b;

    public s(C0058h1 c0058h1) {
        this.b = c0058h1;
        this.f155a = y.b(c0058h1.getTypeUrl());
    }

    @Override // com.google.crypto.tink.internal.Serialization
    public final I0.a getObjectIdentifier() {
        return this.f155a;
    }
}
