package org.bouncycastle.mime;

import j4.AbstractC0567a;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public interface MimeParserListener {
    MimeContext createContext(MimeParserContext mimeParserContext, AbstractC0567a abstractC0567a);

    void object(MimeParserContext mimeParserContext, AbstractC0567a abstractC0567a, InputStream inputStream);
}
