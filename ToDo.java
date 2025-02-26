
import java.util.ArrayList;
import java.util.Scanner;

public class ToDo {

    public static void main(String[] args) {
        ArrayList<String> tarefas = new ArrayList<>();
        int escolha = 0;
        Scanner scanner = new Scanner(System.in);

        while (escolha != 4) {
            menu();
            System.out.println("O que deseja fazer?");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    adicionarTarefa(tarefas, scanner);
                    break;
                case 2:
                    consultarTarefas(tarefas);
                    break;
                case 3:
                    excluirTarefa(tarefas, scanner);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        scanner.close();
    }

    public static void menu() {
        System.out.println("=======TODO List=======");
        System.out.println("1. Adicionar tarefa");
        System.out.println("2. Consultar tarefas");
        System.out.println("3. Excluir tarefa");
        System.out.println("4. Sair");
        System.out.println("=======================");
    }

    public static void adicionarTarefa(ArrayList<String> tarefas, Scanner scanner) {
        limparTerminal();
        System.out.println("Qual Tarefa deseja adicionar?");
        String tarefa = scanner.nextLine();
        tarefas.add(tarefa);
        System.out.println("\n");
        limparTerminal();
        System.out.println("Tarefa adicionada com sucesso!");


    }

    public static void consultarTarefas(ArrayList<String> tarefas) {
        limparTerminal();
        if (tarefas.isEmpty()) {
            System.out.println("\nNenhuma tarefa cadastrada.\n");
        } else {
            System.out.println("\nLista de tarefas:");
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
            System.out.println("========================\n");
        }
        
    }

    public static void excluirTarefa(ArrayList<String> tarefas, Scanner scanner) {
        limparTerminal();
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            System.out.println("\nEscolha o número da tarefa a ser excluida.");
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }

            try {
                int indice = scanner.nextInt();
                scanner.nextLine();

                if (indice > 0 && indice <= tarefas.size()) {
                    tarefas.remove(indice - 1);
                    System.out.println("\nTarefa excluida com sucesso.");
                } else {
                    System.out.println("\nNúmero inválido");
                }
            } catch (Exception e) {
                System.out.println("\nEntrada inválida. Digite um número.");
                scanner.nextLine();
            }

        }
    }
    
    public static void limparTerminal() {
        try {
            String sistema = System.getProperty("os.name").toLowerCase();
            if (sistema.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Erro ao limpar terminal.");
        }
    }
    
    

}