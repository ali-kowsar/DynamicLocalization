
package com.kowsar.dynamiclocalization.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseLocale {

    @SerializedName("locale")
    @Expose
    private Locale locale;

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public String toString() {
        return "ResponseLocale{" +
                "locale=" + locale +
                '}';
    }
}
