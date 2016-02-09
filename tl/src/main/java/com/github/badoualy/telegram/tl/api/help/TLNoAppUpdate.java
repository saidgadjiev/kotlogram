package com.github.badoualy.telegram.tl.api.help;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLNoAppUpdate extends TLAbsAppUpdate {
    public static final int CONSTRUCTOR_ID = 0xc45a6536;

    public TLNoAppUpdate() {
    }

    @Override
    public String toString() {
        return "help.noAppUpdate#c45a6536";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLNoAppUpdate)) return false;
        if (object == this) return true;

        TLNoAppUpdate o = (TLNoAppUpdate) object;

        return true;
    }
}
