package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageActionChatDeletePhoto extends TLAbsMessageAction {
    public static final int CONSTRUCTOR_ID = 0x95e3fbef;

    public TLMessageActionChatDeletePhoto() {
    }

    @Override
    public String toString() {
        return "messageActionChatDeletePhoto#95e3fbef";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLMessageActionChatDeletePhoto)) return false;
        if (object == this) return true;

        TLMessageActionChatDeletePhoto o = (TLMessageActionChatDeletePhoto) object;

        return true;
    }
}
