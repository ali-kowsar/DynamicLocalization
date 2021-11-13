
package com.kowsar.dynamiclocalization.model.response;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Locale {

    @SerializedName("en")
    @Expose
    private En en;
    @SerializedName("hi")
    @Expose
    private Hi hi;
    @SerializedName("zn")
    @Expose
    private Zn zn;
    @SerializedName("ar")
    @Expose
    private Ar ar;

    public En getEn() {
        return en;
    }

    public void setEn(En en) {
        this.en = en;
    }

    public Hi getHi() {
        return hi;
    }

    public void setHi(Hi hi) {
        this.hi = hi;
    }

    public Zn getZn() {
        return zn;
    }

    public void setZn(Zn zn) {
        this.zn = zn;
    }

    public Ar getAr() {
        return ar;
    }

    public void setAr(Ar ar) {
        this.ar = ar;
    }

    @Override
    public String toString() {
        return "Locale{" +
                "\nen=" + en +
                ", \nhi=" + hi +
                ", \nzn=" + zn +
                ", \nar=" + ar +
                '}';
    }
}

