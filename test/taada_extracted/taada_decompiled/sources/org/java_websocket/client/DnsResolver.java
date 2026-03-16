package org.java_websocket.client;

import java.net.InetAddress;
import java.net.URI;

/* JADX INFO: loaded from: classes.dex */
public interface DnsResolver {
    InetAddress resolve(URI uri);
}
