import java.util.ArrayList;
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

    }

    public void Listar() {
        for (Imovel n1 : imovel) {
            System.out.print(n1);
        }
    }

    public void ListaFiltrada() {

    }

    public void Editar() {

    }

    public void Excluir() {

    }
}