package model;

import com.google.gson.annotations.SerializedName;

public class CurrencyResponse {

    @SerializedName("result")
    private String result;

    @SerializedName("base_code")
    private String base_code;

    @SerializedName("target_code")
    private String target_code;

    @SerializedName("conversion_rate")
    private double conversion_rate;

    @SerializedName("conversion_result")
    private double conversion_result;


    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public double getConversion_result() {
        return conversion_result;
    }

    public void setConversion_result(double conversion_result) {
        this.conversion_result = conversion_result;
    }
}
