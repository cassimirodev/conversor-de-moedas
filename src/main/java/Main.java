import model.CurrencyResponse;
import service.CurrencyService;

import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args)  {


        CurrencyService serviceTest = new CurrencyService();
        CurrencyResponse responseTest  = serviceTest.converterMoeda("EUR", "BRL", 100);

        System.out.println("De: " + responseTest.getBase_code());
        System.out.println("Para: " + responseTest.getTarget_code());
        System.out.println("Resultado: " + responseTest.getConversion_result());

    }
}
