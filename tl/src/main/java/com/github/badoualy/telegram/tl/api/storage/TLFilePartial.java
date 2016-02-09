package com.github.badoualy.telegram.tl.api.storage;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFilePartial extends TLAbsFileType {
    public static final int CONSTRUCTOR_ID = 0x40bc6f52;

    public TLFilePartial() {
    }

    @Override
    public String toString() {
        return "storage.filePartial#40bc6f52";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLFilePartial)) return false;
        if (object == this) return true;

        TLFilePartial o = (TLFilePartial) object;

        return true;
    }
}
