package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChannelParticipantsFilter;
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel;
import com.github.badoualy.telegram.tl.api.channels.TLChannelParticipants;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestChannelsGetParticipants extends TLMethod<TLChannelParticipants> {
    public static final int CONSTRUCTOR_ID = 0x24d98f92;

    protected TLAbsInputChannel channel;

    protected TLAbsChannelParticipantsFilter filter;

    protected int offset;

    protected int limit;

    public TLRequestChannelsGetParticipants() {
    }

    public TLRequestChannelsGetParticipants(TLAbsInputChannel channel, TLAbsChannelParticipantsFilter filter, int offset, int limit) {
        this.channel = channel;
        this.filter = filter;
        this.offset = offset;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLChannelParticipants deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLChannelParticipants)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLChannelParticipants) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(channel, stream);
        writeTLObject(filter, stream);
        writeInt(offset, stream);
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        channel = readTLObject(stream, context, TLAbsInputChannel.class, -1);
        filter = readTLObject(stream, context, TLAbsChannelParticipantsFilter.class, -1);
        offset = readInt(stream);
        limit = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += channel.computeSerializedSize();
        size += filter.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        return size;
    }

    @Override
    public String toString() {
        return "channels.getParticipants#24d98f92";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLRequestChannelsGetParticipants)) return false;
        if (object == this) return true;

        TLRequestChannelsGetParticipants o = (TLRequestChannelsGetParticipants) object;

        return (channel == o.channel || (channel != null && o.channel != null && channel.equals(o.channel)))
                && (filter == o.filter || (filter != null && o.filter != null && filter.equals(o.filter)))
                && offset == o.offset
                && limit == o.limit;
    }

    public TLAbsInputChannel getChannel() {
        return channel;
    }

    public void setChannel(TLAbsInputChannel channel) {
        this.channel = channel;
    }

    public TLAbsChannelParticipantsFilter getFilter() {
        return filter;
    }

    public void setFilter(TLAbsChannelParticipantsFilter filter) {
        this.filter = filter;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
