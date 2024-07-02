import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Disciplina {
    private ArrayList<Estudante> turma = new ArrayList<>();

    Scanner ler = new Scanner(System.in);

    public ArrayList<Estudante> getTurma() {
        return turma;
    }

    public void listarEstudantes() {
        for (Estudante estudante : turma) {
            System.out.println("================================");
            System.out.println("Nome: " + estudante.getNome());
            System.out.println("CPF: " + estudante.getCpf());
            System.out.println("Matricula: " + estudante.getMatricula());
            System.out.println("Nota 1: " + estudante.getNota1());
            System.out.println("Nota 2: " + estudante.getNota2());
            System.out.println("Media: " + estudante.getMedia());
            System.out.println("================================");
        }
    }

    public void mediaTurma() {
        double mediaTurma = 0;
        for (Estudante estudante : turma) {
            mediaTurma += estudante.getMedia();
        }
        System.out.println("Media da turma: " + mediaTurma / turma.size());
    }

    public void insereEstudante() {
        ler.nextLine();
        System.out.println("Digite o nome do estudante: ");
        String nome = ler.nextLine();
        System.out.println("Digite o CPF do estudante: ");
        String CPF = ler.nextLine();
        System.out.println("Digite a matricula do estudante: ");
        String matricula = ler.nextLine();
        System.out.println("Digite a primeira nota do estudante: ");
        Float nota1 = ler.nextFloat();
        System.out.println("Digite a segunda nota do estudante: ");
        Float nota2 = ler.nextFloat();
        Estudante estudante = new Estudante(nome, CPF, matricula, nota1, nota2);
        turma.add(estudante);
    }

    public void alteraEstudante() {
        ler.nextLine();
        System.out.println("Digite a matricula do aluno para modificar: ");
        String aux = ler.nextLine();
        ler.nextLine();
        for (Estudante estudante : turma) {
            if (aux.equals(estudante.getMatricula())) {
                System.out.println("Digite o nome do estudante: ");
                String nome = ler.nextLine();
                estudante.setNome(nome);
                System.out.println("Digite o CPF do estudante: ");
                String CPF = ler.nextLine();
                estudante.setCpf(CPF);
                System.out.println("Digite a matricula do estudante: ");
                String matricula = ler.nextLine();
                estudante.setMatricula(matricula);
                System.out.println("Digite a primeira nota do estudante: ");
                Float nota1 = ler.nextFloat();
                estudante.setNota1(nota1);
                System.out.println("Digite a segunda nota do estudante: ");
                Float nota2 = ler.nextFloat();
                estudante.setNota2(nota2);
            } else {
                System.out.println("Matricula invalida");
            }
        }
    }

    public void removeEstudante() {
        ler.nextLine();
        System.out.println("Digite a matricula do estudante para remover: ");
        String aux = ler.nextLine();
        turma.removeIf(estudante -> estudante.getMatricula().equals(aux));
    }

    public void getEstudante() {
        ler.nextLine();
        System.out.println("Digite o numero da matricula do estudante que deseja procurar: ");
        String aux = ler.nextLine();
        for (Estudante estudante : turma) {
            if (aux.equals(estudante.getMatricula())) {
                System.out.println("================================");
                System.out.println("Nome: " + estudante.getNome());
                System.out.println("CPF: " + estudante.getCpf());
                System.out.println("Matricula: " + estudante.getMatricula());
                System.out.println("Nota 1: " + estudante.getNota1());
                System.out.println("Nota 2: " + estudante.getNota2());
                System.out.println("Media: " + estudante.getMedia());
                System.out.println("================================");
            }
        }
    }

    public void listarEstudantesAcima6() {
        for (Estudante estudante : turma) {
            if (estudante.getMedia() >= 6) {
                System.out.println("================================");
                System.out.println("Nome: " + estudante.getNome());
                System.out.println("CPF: " + estudante.getCpf());
                System.out.println("Matricula: " + estudante.getMatricula());
                System.out.println("Nota 1: " + estudante.getNota1());
                System.out.println("Nota 2: " + estudante.getNota2());
                System.out.println("Media: " + estudante.getMedia());
                System.out.println("================================");
            }
        }
    }

    public void listarEstudantesAbaixo6() {
        for (Estudante estudante : turma) {
            if (estudante.getMedia() < 6) {
                System.out.println("================================");
                System.out.println("Nome: " + estudante.getNome());
                System.out.println("CPF: " + estudante.getCpf());
                System.out.println("Matricula: " + estudante.getMatricula());
                System.out.println("Nota 1: " + estudante.getNota1());
                System.out.println("Nota 2: " + estudante.getNota2());
                System.out.println("Media: " + estudante.getMedia());
                System.out.println("================================");
            }
        }
    }

    public void gravaArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("estudantes.csv"))) {
            for (Estudante estudante : turma) {
                bw.write(estudante.getEstudanteCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro");
        }
    }

    public void carregaDoArquivo() {
        try (BufferedReader br = new BufferedReader(new FileReader("estudantes.csv"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Estudante estudante = new Estudante(linha, linha, linha, 0, 0);
                estudante.setEstudanteCSV(linha);
                turma.add(estudante);
            }
        } catch (IOException e) {
            System.err.println("Erro");
        }
    }

    public void Menu() {
        int opcao = 10;

        while (opcao != 0) {
            System.out.println("""
                    :::::::::::::::::::::::::::::::::::::::::::::::::::
                    .. 1. Registre um novo estudante                 ..
                    .. 2. Remova um Estudante                        ..
                    .. 3. Altere um Estudante                        ..
                    .. 4. Procure um estudante                       ..
                    .. 5. Liste todos os estudantes                  ..
                    .. 6. Listar só estudantes com média acima de 6  ..
                    .. 7. Listar só estudantes com média abaixo de 6 ..
                    .. 8. Mostrar a media total da turma             ..
                    .. 9. Gravar alterações                          ..
                    .. 0. Sair                                       ..
                    :::::::::::::::::::::::::::::::::::::::::::::::::::
                    """);
            opcao = ler.nextInt();
            switch (opcao) {
                case 1:
                    insereEstudante();
                    break;
                case 2:
                    removeEstudante();
                    break;
                case 3:
                    alteraEstudante();
                    break;
                case 4:
                    getEstudante();
                    break;
                case 5:
                    listarEstudantes();
                    break;
                case 6:
                    listarEstudantesAcima6();
                    break;
                case 7:
                    listarEstudantesAbaixo6();
                    break;
                case 8:
                    mediaTurma();
                    break;
                case 9:
                    gravaArquivo();
                case 0:
                    break;
                default:
                    System.out.println("opção inválida, digite novamente.");
                    break;
            }
        }
        ler.close();
    }
}
