package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateStickerSets extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x43ae3dec;

    public TLUpdateStickerSets() {
    }

    @Override
    public String toString() {
        return "updateStickerSets#43ae3dec";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLUpdateStickerSets)) return false;
        if (object == this) return true;

        TLUpdateStickerSets o = (TLUpdateStickerSets) object;

        return true;
    }
}
