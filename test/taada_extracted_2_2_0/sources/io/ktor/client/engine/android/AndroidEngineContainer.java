package io.ktor.client.engine.android;

import io.ktor.client.HttpClientEngineContainer;
import io.ktor.client.engine.HttpClientEngineFactory;
import k1.C0576a;
import kotlin.Metadata;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/client/engine/android/AndroidEngineContainer;", "Lio/ktor/client/HttpClientEngineContainer;", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "ktor-client-android"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidEngineContainer implements HttpClientEngineContainer {
    @Override // io.ktor.client.HttpClientEngineContainer
    public final HttpClientEngineFactory getFactory() {
        return C0576a.f3691a;
    }

    public final String toString() {
        return "Android";
    }
}
