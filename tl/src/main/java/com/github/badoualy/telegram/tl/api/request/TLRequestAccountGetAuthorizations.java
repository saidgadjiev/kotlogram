package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.account.TLAuthorizations;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAccountGetAuthorizations extends TLMethod<TLAuthorizations> {
    public static final int CONSTRUCTOR_ID = 0xe320c158;

    public TLRequestAccountGetAuthorizations() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAuthorizations deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAuthorizations)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAuthorizations) response;
    }

    @Override
    public String toString() {
        return "account.getAuthorizations#e320c158";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLRequestAccountGetAuthorizations)) return false;
        if (object == this) return true;

        TLRequestAccountGetAuthorizations o = (TLRequestAccountGetAuthorizations) object;

        return true;
    }
}
