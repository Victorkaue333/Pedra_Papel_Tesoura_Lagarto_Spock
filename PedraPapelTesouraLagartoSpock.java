import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * Pedra, Papel, Tesoura, Lagarto, Spock
 * 
 * Jogo jogador vs computador. Regras baseadas na versão popularizada por
 * The Big Bang Theory.
 * 
 * Requisitos implementados:
 * - Loop de jogo com opção de jogar novamente
 * - Validação de entrada insensível a maiúsculas/minúsculas
 * - Escolha aleatória do computador
 * - Determinação de vencedor com base nas regras fornecidas
 * - Placar (vitórias do usuário, do computador e empates)
 * 
 * Como jogar: compile e execute a classe. Digite uma das opções: Pedra, Papel,
 * Tesoura, Lagarto ou Spock. Ao final de cada rodada, escolha S para
 * continuar ou N para sair.
 */
public class PedraPapelTesouraLagartoSpock {

    private static final String[] OPTIONS = { "pedra", "papel", "tesoura", "lagarto", "spock" };

    // Para cada opção, conjunto de opções que ela derrota
    private static final Map<String, Set<String>> WINS = new HashMap<>();

    // Mensagens explicativas para cada combinação vencedora -> perdedora
    private static final Map<String, String> OUTCOMES = new HashMap<>();

    static {
        // Inicializa regras de vitória
        WINS.put("tesoura", createSet("papel", "lagarto"));
        WINS.put("papel", createSet("pedra", "spock"));
        WINS.put("pedra", createSet("lagarto", "tesoura"));
        WINS.put("lagarto", createSet("spock", "papel"));
        WINS.put("spock", createSet("tesoura", "pedra"));

        // Inicializa mensagens explicativas
        OUTCOMES.put("tesoura-papel", "Tesoura corta Papel");
        OUTCOMES.put("papel-pedra", "Papel cobre Pedra");
        OUTCOMES.put("pedra-lagarto", "Pedra esmaga Lagarto");
        OUTCOMES.put("lagarto-spock", "Lagarto envenena Spock");
        OUTCOMES.put("spock-tesoura", "Spock esmaga Tesoura");
        OUTCOMES.put("tesoura-lagarto", "Tesoura decapita Lagarto");
        OUTCOMES.put("lagarto-papel", "Lagarto come Papel");
        OUTCOMES.put("papel-spock", "Papel refuta Spock");
        OUTCOMES.put("spock-pedra", "Spock vaporiza Pedra");
        OUTCOMES.put("pedra-tesoura", "Pedra quebra Tesoura");
    }

    private static Set<String> createSet(String... items) {
        Set<String> set = new HashSet<>();
        for (String item : items) {
            set.add(item);
        }
        return set;
    }

    /**
     * Formata a escolha para exibição (primeira letra maiúscula).
     */
    private static String formatChoice(String choice) {
        if (choice == null || choice.isEmpty()) {
            return "";
        }
        return choice.substring(0, 1).toUpperCase() + choice.substring(1);
    }

    /**
     * Solicita e valida a escolha do usuário. Retorna em minúsculas.
     * Continua pedindo até receber uma opção válida.
     */
    private static String getUserChoice(Scanner scanner) {
        while (true) {
            System.out.print("Escolha (Pedra/Papel/Tesoura/Lagarto/Spock): ");
            String choice = scanner.nextLine().trim().toLowerCase();

            // Verifica se é uma opção válida
            for (String option : OPTIONS) {
                if (option.equals(choice)) {
                    return choice;
                }
            }

            System.out.println("Opção inválida. Digite uma das opções listadas (ex: Pedra).\n");
        }
    }

    /**
     * Pergunta se o usuário quer jogar novamente. Retorna true para sim.
     */
    private static boolean askPlayAgain(Scanner scanner) {
        while (true) {
            System.out.print("Jogar novamente? (S/N): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("s")) {
                return true;
            } else if (answer.equals("n")) {
                return false;
            }

            System.out.println("Resposta inválida. Digite 'S' para sim ou 'N' para não.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("--- Pedra, Papel, Tesoura, Lagarto, Spock ---");

        int userWins = 0;
        int compWins = 0;
        int ties = 0;

        while (true) {
            // Obtém escolhas
            String user = getUserChoice(scanner);
            String comp = OPTIONS[random.nextInt(OPTIONS.length)];

            System.out.println("\nVocê escolheu: " + formatChoice(user));
            System.out.println("Computador escolheu: " + formatChoice(comp) + "\n");

            // Determina resultado
            if (user.equals(comp)) {
                System.out.println("Empate!");
                ties++;
            } else {
                String winner, loser;
                String resultText;

                // Verifica se o usuário venceu
                if (WINS.get(user).contains(comp)) {
                    winner = user;
                    loser = comp;
                    userWins++;
                    resultText = "Você venceu!";
                } else {
                    winner = comp;
                    loser = user;
                    compWins++;
                    resultText = "O computador venceu!";
                }

                // Mostra a frase explicativa da regra, se existir
                String outcomeKey = winner + "-" + loser;
                String message = OUTCOMES.get(outcomeKey);
                if (message != null) {
                    System.out.println(message);
                }

                System.out.println(resultText);
            }

            // Exibe placar atual (bônus)
            System.out
                    .println("\nPlacar: Você " + userWins + " — Computador " + compWins + " — Empates " + ties + "\n");

            // Pergunta se quer jogar novamente
            if (!askPlayAgain(scanner)) {
                System.out.println("\nObrigado por jogar!");
                System.out
                        .println("Placar final: Você " + userWins + " — Computador " + compWins + " — Empates " + ties);
                break;
            }
        }

        scanner.close();
    }
}
