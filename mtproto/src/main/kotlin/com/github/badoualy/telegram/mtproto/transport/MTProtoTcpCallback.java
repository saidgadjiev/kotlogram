package com.github.badoualy.telegram.mtproto.transport;

public interface MTProtoTcpCallback {

    void onData(byte[] bytes);
}
