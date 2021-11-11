
package com.kowsar.dynamiclocalization.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class En {

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

    @Override
    public String toString() {
        return "En{" +
                "helloWorld='" + helloWorld + '\'' +
                ", buttonHindi='" + buttonHindi + '\'' +
                ", buttonChinese='" + buttonChinese + '\'' +
                ", buttonEng='" + buttonEng + '\'' +
                '}';
    }

}
