package view;

import model.CurrencyCodeResponse;
import model.CurrencyResponse;
import service.CurrencyCodeService;
import service.CurrencyService;

import java.util.List;
import java.util.Scanner;

public class FrontEnd {

    CurrencyService servicePair = new CurrencyService();
    CurrencyResponse responsePair;
    CurrencyCodeService serviceCode = new CurrencyCodeService();
    Scanner input = new Scanner(System.in);


    public void iniciar() {
        System.out.println(showLogoConversor());
        Options();
    }

    public void showCurrencyAvaliables() {
        int index = 1;
        CurrencyCodeResponse responseCode = serviceCode.getSupportedCodes();
        for (List<String> code : responseCode.getSupported_codes()) {
            System.out.printf("%3d - %s (%s)%n", index++, code.get(0), code.get(1));
        }
    }

    public void fazerRequicaoDaConvervesao() {
        String from, to;
        double amount;

        while (true) {
            System.out.print("Digite a moeda a ser convertida: ");
            from = input.nextLine().toUpperCase();
            if (isValidCurrencyCode(from)) {
                break;
            } else {
                System.out.println("Código de moeda inválido! Tente novamente.");
            }
        }


        while (true) {
            System.out.print("Digite a moeda na qual quer converter: ");
            to = input.nextLine().toUpperCase();
            if (isValidCurrencyCode(to)) {
                break;
            } else {
                System.out.println("Código de moeda inválido! Tente novamente.");
            }
        }
        while(true){
            System.out.print("Digite a quantidade a ser convertida: ");
            if (input.hasNextDouble()) {
                amount = input.nextDouble();
                input.nextLine();
                if (amount > 0) {
                    break;
                } else {
                    System.out.println("O valor deve ser positivo! Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida! Por favor, insira um número.");
                input.nextLine();
            }
        }

        responsePair = servicePair.pairRequest(from, to, amount);
        if (responsePair != null) {
            System.out.print(amount + responsePair.getBase_code() + " é equivalente a " + responsePair.getConversion_result() + responsePair.getTarget_code() + "\nTaxa de conversão: " + responsePair.getConversion_rate() + "\n");

        } else {
            System.out.println("Erro ao realizar a conversão. Verifique os códigos de moeda e tente novamente.");
        }
    }

    public void Options() {

        int optionFeatures = 0;

        while (true) {
            System.out.println("1 - Converter moedas ");
            System.out.println("2 - Listar Moedas Disponíveis para conversão ");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            optionFeatures = input.nextInt();

            input.nextLine();

            switch (optionFeatures) {
                case 1:
                    fazerRequicaoDaConvervesao();
                    break;
                case 2:
                    showCurrencyAvaliables();
                    break;
                case 3:
                    System.out.println("Encerrando o programa...");
                    return;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        }
    }

    public String showLogoConversor() {
        return "\n" + "  /$$$$$$                                                                                      /$$                /$$      /$$                        /$$                  \n" + " /$$__  $$                                                                                    | $$               | $$$    /$$$                       | $$                  \n" + "| $$  \\__/ /$$$$$$ /$$$$$$$ /$$    /$$/$$$$$$  /$$$$$$  /$$$$$$$ /$$$$$$  /$$$$$$         /$$$$$$$ /$$$$$$       | $$$$  /$$$$ /$$$$$$  /$$$$$$  /$$$$$$$ /$$$$$$  /$$$$$$$\n" + "| $$      /$$__  $| $$__  $|  $$  /$$/$$__  $$/$$__  $$/$$_____//$$__  $$/$$__  $$       /$$__  $$/$$__  $$      | $$ $$/$$ $$/$$__  $$/$$__  $$/$$__  $$|____  $$/$$_____/\n" + "| $$     | $$  \\ $| $$  \\ $$\\  $$/$$| $$$$$$$| $$  \\__|  $$$$$$| $$  \\ $| $$  \\__/      | $$  | $| $$$$$$$$      | $$  $$$| $| $$  \\ $| $$$$$$$| $$  | $$ /$$$$$$|  $$$$$$ \n" + "| $$    $| $$  | $| $$  | $$ \\  $$$/| $$_____| $$      \\____  $| $$  | $| $$            | $$  | $| $$_____/      | $$\\  $ | $| $$  | $| $$_____| $$  | $$/$$__  $$\\____  $$\n" + "|  $$$$$$|  $$$$$$| $$  | $$  \\  $/ |  $$$$$$| $$      /$$$$$$$|  $$$$$$| $$            |  $$$$$$|  $$$$$$$      | $$ \\/  | $|  $$$$$$|  $$$$$$|  $$$$$$|  $$$$$$$/$$$$$$$/\n" + " \\______/ \\______/|__/  |__/   \\_/   \\_______|__/     |_______/ \\______/|__/             \\_______/\\_______/      |__/     |__/\\______/ \\_______/\\_______/\\_______|_______/ \n" + "                                                                                                                                                                           \n" + "                                                                                                                                                                           \n" + "                                                                                                                                                                           \n";
    }

    private boolean isValidCurrencyCode(String code) {
        CurrencyCodeResponse responseCode = serviceCode.getSupportedCodes();
        for (List<String> supportedCode : responseCode.getSupported_codes()) {
            if (supportedCode.getFirst().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }
}


