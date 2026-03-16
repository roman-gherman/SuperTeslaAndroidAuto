package com.google.android.datatransport;

import k.AbstractC0570c;

/* JADX INFO: loaded from: classes.dex */
public interface Transport<T> {
    void schedule(AbstractC0570c abstractC0570c, TransportScheduleCallback transportScheduleCallback);

    void send(AbstractC0570c abstractC0570c);
}
