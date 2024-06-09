import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Imobiliaria {
    private static final Imovel[] Imobiliaria = null;
    ArrayList<Imovel> imovel = new ArrayList<>();
    Scanner ler = new Scanner(System.in);

    public void Menu() {
        int opcao = 0;
        while (opcao != 6) {

            System.out.println("|-------------------------------------|");
            System.out.println("| 1° - Cadastrar um Imovel            |");
            System.out.println("| 2° - Listar o Imovel Cadastrado     |");
            System.out.println("| 3° - Lista Filtrada                 |");
            System.out.println("| 4° - Editar o Imovel                |");
            System.out.println("| 5° -  Excluir o Imovel              |");
            System.out.println("| 6° - Sair do Menu                   |");
            System.out.println("|-------------------------------------|");
            System.out.print("Digite uma opção: ");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    Cadastrar();
                    break;
                case 2:
                    Listar();
                    break;
                case 3:
                    ListaFiltrada();
                    break;
                case 4:
                    Editar();
                    break;
                case 5:
                    Excluir();
                    break;
                case 6:
                    System.out.println("Você saiu! ");
                    break;
                case 8:
                    Imovel cheat = new Imovel("Sombrio", "Getulio", 53536, 56363, 535222, 2, 0, 100);
                    imovel.add(cheat);
                    Imovel cheat1 = new Imovel("Sombrio", "Getulio", 656786, 363, 535222, 2, 1, 9000);
                    imovel.add(cheat1);
                    Imovel cheat2 = new Imovel("Ararangua", "Caverazinho", 656786, 363, 535222, 2, 0, 20000);
                    imovel.add(cheat2);
                    Imovel cheat3 = new Imovel("Balneario Gaivota", "W5", 656786, 363, 535222, 2, 1, 10000);
                    imovel.add(cheat3);
                    break;

                default:
                    System.out.println("Opção invalida, tente novamente! ");
                    ler.nextInt();
            }
        }
    }

    public void Cadastrar() {
        System.out.println("Digite o codigo do imovel:");
        int codigo = ler.nextInt();
        System.out.println("Digite a area construida do imovel:");
        float area = ler.nextInt();
        System.out.println("Digite a area total do imovel:");
        float areaTotal = ler.nextInt();
        System.out.println("Digite o numero de quartos do imovel:");
        int numeroQuartos = ler.nextInt();
        System.out.println("Digite 0 para casa e 1 para apartamento: ");
        int tipo = ler.nextInt();
        System.out.println("Digite o preco do imovel:");
        float preco = ler.nextInt();
        System.out.println("Digite a cidade do imovel:");
        String cidade = ler.next();
        System.out.println("Digite o bairro do imovel:");
        String bairro = ler.next();
        Imovel n1 = new Imovel(cidade, bairro, codigo, area, areaTotal, numeroQuartos, tipo, preco);
        imovel.add(n1);

    }

    public void Listar() {
        for (Imovel n1 : imovel) {
            System.out.print(n1);
        }
    }

    public void ListaFiltrada() {
        int opcao = 0;
        while (opcao != 5) {

            System.out.println("|-------------------------------------|");
            System.out.println("|            Filtrar por:             |");
            System.out.println("| 1° - Filtrar por Cidade             |");
            System.out.println("| 2° - Filtrar por Bairro             |");
            System.out.println("| 3° - Filtrar por Preço              |");
            System.out.println("| 4° - Filtrar por Tipo               |");
            System.out.println("| 5° - Sair do Menu                   |");
            System.out.println("|-------------------------------------|");
            System.out.print("Digite uma opção: ");
            opcao = ler.nextInt();
            switch (opcao) {
                case 1:

                    break;
                case 2:
                    Listar();
                    break;
                case 3:
                    System.out.println("Digite o preço minimo desejavel: ");
                    int precoMin = ler.nextInt();
                    System.out.println("Digite o preço maximo desejavel: ");
                    int precoMax = ler.nextInt();
                    for (Imovel n1 : imovel) {
                        if (n1.getPreco() > precoMin && n1.getPreco() < precoMax) {
                            System.out.println(n1);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Digite 0 para casa e 1 para apartamento: ");
                    int temp = ler.nextInt();
                    while (temp > 1) {
                        System.out.println("Opção invalida, Digite novamente: ");
                        temp = ler.nextInt();
                    }
                    for (Imovel n1 : imovel) {
                        if (temp == n1.getTipo()) {
                            System.out.println(n1);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Você saiu! ");
                    break;
                default:
                    System.out.println("Opção invalida, tente novamente! ");
                    ler.nextInt();
            }
        }
    }

    public void Editar() {
        System.out.println("Digite o codigo do imovel que voce queira editar: ");
        int codigo = ler.nextInt();
        for (Imovel n1 : imovel) {
            if (codigo == n1.getCodigo()) {
                System.out.println("Digite o codigo do imovel:");
                int codigo1 = ler.nextInt();
                System.out.println("Digite a area construida do imovel:");
                float area1 = ler.nextInt();
                System.out.println("Digite a area total do imovel:");
                float areaTotal1 = ler.nextInt();
                System.out.println("Digite o numero de quartos do imovel:");
                int numeroQuartos1 = ler.nextInt();
                System.out.println("Digite 0 para casa e 1 para apartamento: ");
                int tipo1 = ler.nextInt();
                System.out.println("Digite o preco do imovel:");
                float preco1 = ler.nextInt();
                System.out.println("Digite a cidade do imovel:");
                String cidade1 = ler.next();
                System.out.println("Digite o bairro do imovel:");
                String bairro1 = ler.next();
                n1.setCodigo(codigo1);
                n1.setAreaConstruida(area1);
                n1.setAreaTotal(areaTotal1);
                n1.setNumeroQuartos(numeroQuartos1);
                n1.setTipo(tipo1);
                n1.setPreco(preco1);
                n1.setCidade(cidade1);
                n1.setBairro(bairro1);
            }
        }
    }

    public void Excluir() {
        System.out.println("Digite o codigo do imovel que voce quer excluir: ");
        int codigo = ler.nextInt();
        for (Imovel n1 : imovel) {
            imovel.removeIf(imoveis -> imoveis.getCodigo() == codigo);
        }
    }

}