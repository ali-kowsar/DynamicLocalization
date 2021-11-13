
package com.kowsar.dynamiclocalization.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hi {

    @SerializedName("hello_world")
    @Expose
    private String helloWorld;
    @SerializedName("button_hindi")
    @Expose
    private String buttonHindi;
    @SerializedName("button_chinese")
    @Expose
    private String buttonChinese;
    @SerializedName("button_eng")
    @Expose
    private String buttonEng;
    @SerializedName("button_text_arabic")
    @Expose
    private String buttonTextArabic;
    @SerializedName("localize_text")
    @Expose
    private String localizeText;

    public String getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }

    public String getButtonHindi() {
        return buttonHindi;
    }

    public void setButtonHindi(String buttonHindi) {
        this.buttonHindi = buttonHindi;
    }

    public String getButtonChinese() {
        return buttonChinese;
    }

    public void setButtonChinese(String buttonChinese) {
        this.buttonChinese = buttonChinese;
    }

    public String getButtonEng() {
        return buttonEng;
    }

    public void setButtonEng(String buttonEng) {
        this.buttonEng = buttonEng;
    }

    public String getButtonTextArabic() {
        return buttonTextArabic;
    }

    public void setButtonTextArabic(String buttonTextArabic) {
        this.buttonTextArabic = buttonTextArabic;
    }

    public String getLocalizeText() {
        return localizeText;
    }

    public void setLocalizeText(String localizeText) {
        this.localizeText = localizeText;
    }

    @Override
    public String toString() {
        return "Hi{" +
                "helloWorld='" + helloWorld + '\'' +
                ", buttonHindi='" + buttonHindi + '\'' +
                ", buttonChinese='" + buttonChinese + '\'' +
                ", buttonEng='" + buttonEng + '\'' +
                ", buttonTextArabic='" + buttonTextArabic + '\'' +
                ", localizeText='" + localizeText + '\'' +
                '}';
    }
}
