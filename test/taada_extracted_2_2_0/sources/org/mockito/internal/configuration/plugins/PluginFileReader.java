package org.mockito.internal.configuration.plugins;

import java.io.InputStream;
import java.util.Iterator;
import org.mockito.internal.util.io.IOUtil;

/* JADX INFO: loaded from: classes.dex */
class PluginFileReader {
    private static String stripCommentAndWhitespace(String str) {
        int iIndexOf = str.indexOf(35);
        if (iIndexOf != -1) {
            str = str.substring(0, iIndexOf);
        }
        return str.trim();
    }

    public String readPluginClass(InputStream inputStream) {
        Iterator<String> it = IOUtil.readLines(inputStream).iterator();
        while (it.hasNext()) {
            String strStripCommentAndWhitespace = stripCommentAndWhitespace(it.next());
            if (strStripCommentAndWhitespace.length() > 0) {
                return strStripCommentAndWhitespace;
            }
        }
        return null;
    }
}
