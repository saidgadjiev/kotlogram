package com.github.badoualy.telegram.tl.api;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputReportReasonPornography extends TLAbsReportReason {
    public static final int CONSTRUCTOR_ID = 0x2e59d922;

    public TLInputReportReasonPornography() {
    }

    @Override
    public String toString() {
        return "inputReportReasonPornography#2e59d922";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputReportReasonPornography)) return false;
        if (object == this) return true;

        TLInputReportReasonPornography o = (TLInputReportReasonPornography) object;

        return true;
    }
}
