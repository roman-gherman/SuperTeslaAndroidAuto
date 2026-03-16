package org.bouncycastle.mime;

import j4.AbstractC0567a;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface MimeParserProvider {
    MimeParser createParser(AbstractC0567a abstractC0567a, InputStream inputStream);

    MimeParser createParser(InputStream inputStream);
}
