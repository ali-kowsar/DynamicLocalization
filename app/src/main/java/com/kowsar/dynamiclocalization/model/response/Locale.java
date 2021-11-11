
package com.kowsar.dynamiclocalization.model.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Locale {

    @SerializedName("en")
    @Expose
    private List<En> en ;
    @SerializedName("hi")
    @Expose
    private List<Hi> hi ;

    @SerializedName("zn")
    @Expose
    private List<Zn> zn ;

    public List<En> getEn() {
        return en;
    }

    public void setEn(List<En> en) {
        this.en = en;
    }

    public List<Hi> getHi() {
        return hi;
    }

    public void setHi(List<Hi> hi) {
        this.hi = hi;
    }

    public List<Zn> getZn() {
        return zn;
    }

    public void setZn(List<Zn> zn) {
        this.zn = zn;
    }

    @Override
    public String toString() {
        return "Locale{" +
                "\nen=" + en +
                ", \nhi=" + hi +
                ", \nzn=" + zn +
                '}';
    }

}
