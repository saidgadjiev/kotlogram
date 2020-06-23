package com.github.badoualy.telegram.mtproto;

import com.github.badoualy.telegram.mtproto.auth.AuthKey;
import com.github.badoualy.telegram.mtproto.auth.AuthResult;
import com.github.badoualy.telegram.mtproto.model.DataCenter;
import com.github.badoualy.telegram.mtproto.model.MTSession;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Observable;

import java.util.List;

public class JMTProtoHandler {

    public static final int QUEUE_TYPE_DISCARD = 0;

    public JMTProtoHandler(@NotNull AuthResult generateAuthKey, ApiCallback apiCallback, @NotNull String tag) {

    }

    public JMTProtoHandler(@NotNull DataCenter dataCenter, @NotNull AuthKey authKey, @Nullable MTSession loadSession, ApiCallback apiCallback, @NotNull String tag) {

    }

    public void startWatchdog() {

    }

    @NotNull
    public <T extends TLObject> List<T> executeMethodsSync(@NotNull List<? extends TLMethod<T>> methods, long timeoutDuration) {
        return null;
    }

    public void close() {

    }

    public void resetConnection() {

    }

    @Nullable
    public <T extends TLObject> Observable<T> queueMethod(@NotNull TLMethod<T> method, int type, long validityTimeout, long timeout) {
        return null;
    }

    @NotNull
    public MTSession getSession() {
        return null;
    }

    public static void shutdown() {

    }

    public AuthKey getAuthKey() {
        
    }
}
