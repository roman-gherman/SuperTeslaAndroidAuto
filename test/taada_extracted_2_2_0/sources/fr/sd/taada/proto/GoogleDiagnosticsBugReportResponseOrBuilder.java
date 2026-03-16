package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface GoogleDiagnosticsBugReportResponseOrBuilder extends MessageLiteOrBuilder {
    String getBugReport();

    ByteString getBugReportBytes();

    int getTokens(int i);

    int getTokensCount();

    List<Integer> getTokensList();

    boolean hasBugReport();
}
