package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface VendorExtensionServiceOrBuilder extends MessageLiteOrBuilder {
    ByteString getData();

    String getPackageWhiteList(int i);

    ByteString getPackageWhiteListBytes(int i);

    int getPackageWhiteListCount();

    List<String> getPackageWhiteListList();

    String getServiceName();

    ByteString getServiceNameBytes();

    boolean hasData();

    boolean hasServiceName();
}
