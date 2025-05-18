package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrencyCodeResponse {

    @SerializedName("result")
    private String result;
    @SerializedName("supported_codes")
    private List<List<String>>  supported_codes;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<List<String>> getSupported_codes() {
        return supported_codes;
    }

    public void setSupported_codes(List<List<String>> supported_codes) {
        this.supported_codes = supported_codes;
    }
}
