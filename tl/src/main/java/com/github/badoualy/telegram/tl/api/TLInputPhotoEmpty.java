package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPhotoEmpty extends TLAbsInputPhoto {
    public static final int CONSTRUCTOR_ID = 0x1cd7bf0d;

    public TLInputPhotoEmpty() {
    }

    @Override
    public String toString() {
        return "inputPhotoEmpty#1cd7bf0d";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputPhotoEmpty)) return false;
        if (object == this) return true;

        TLInputPhotoEmpty o = (TLInputPhotoEmpty) object;

        return true;
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final boolean isNotEmpty() {
        return false;
    }
}
