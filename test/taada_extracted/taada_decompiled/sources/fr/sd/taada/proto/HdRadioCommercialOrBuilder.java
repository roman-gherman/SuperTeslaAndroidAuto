package fr.sd.taada.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface HdRadioCommercialOrBuilder extends MessageLiteOrBuilder {
    String getDescription();

    ByteString getDescriptionBytes();

    int getEncoding();

    String getPrice();

    ByteString getPriceBytes();

    int getReceived();

    String getSeller();

    ByteString getSellerBytes();

    String getUrl();

    ByteString getUrlBytes();

    String getValid();

    ByteString getValidBytes();

    boolean hasDescription();

    boolean hasEncoding();

    boolean hasPrice();

    boolean hasReceived();

    boolean hasSeller();

    boolean hasUrl();

    boolean hasValid();
}
