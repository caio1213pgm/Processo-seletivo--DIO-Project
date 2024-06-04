import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;;

public class ProcessoSeletivo {
    
    public static void main(String[] args) {
        String [] candidatos = {"Caio", "Fabio", "Roberto", "Eliomar", "Breno"};

        for (String candidato : candidatos) {
            ligandoParaSelecionados(candidato);
        }
    }

    static void ligandoParaSelecionados(String candidato){
        int tentativas = 1;
        boolean continuarLigando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarLigando = !atendeu;
            if (continuarLigando) {
                tentativas++;
            }
            else{
                System.out.println("Contato realizado com sucesso \n");
            }

        }while(continuarLigando && tentativas < 3);

        if (atendeu) {
            System.out.printf("Conseguimos entrar em contato com o candidato %s \n", candidato);
        }
        else{
            System.out.printf("Não conseguimos entrar em contato com o candidato %s :( \n", candidato);
        }
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"Caio", "Fabio", "Roberto", "Eliomar", "Breno"};

        for (String candidato : candidatos) {
            System.out.printf("O candidato selecionado foi %s \n", candidato);
        }

    }
    static void selecaoDeCandidatos(){
        String[] candidatos = {"Caio", "Fabio", "Roberto", "Eliomar", "Breno", "Camila", "Thallyta"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            double salarioBase = 2000.00;

            System.out.printf("O candidato %s escolheu %.2f R$ de salário \n", candidato, salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.printf("O candidato %s foi selecionado para a vaga \n", candidato);
                candidatosSelecionados++;
            }
            else{
                System.out.printf("O candidato %s não foi selecionado para a vaga \n", candidato);
            }
            candidatoAtual++;
        }
    }

    static void verificarSalario(double salarioBase, double salarioPretendido){
        if (salarioPretendido > 0) {
            if (salarioBase > salarioPretendido) {
                System.out.println("Ligar para o candidato");
            }
            else if(salarioBase == salarioPretendido){
                System.out.println("Fazer contra-proposta");
            }
            else{
                System.out.println("Aguardando os demais candidatos");
            }
        }
        else{
            System.out.println("Erro! Digite um valor acima de 0");
        }
        
    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
   }

   static boolean atender(){
    return new Random().nextInt(3)==1;
   }
}

