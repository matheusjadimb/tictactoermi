package tictactoeclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author roland
 */
public class JogoDaVelhaWSCliente {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        // Apenas para execução dentro do NetBeans
        FileInputStream is = new FileInputStream(new File("testfiles\\teste-003.in"));
        System.setIn(is);

        Scanner leitura = new Scanner(System.in);
        int numOp = leitura.nextInt();
        for (int i = 0; i < numOp; ++i) {
            int op = leitura.nextInt();
            String parametros = leitura.next();
            String param[] = parametros.split(":", -1);
            
            for(int paramI = 0 ; paramI < param.length; paramI++){
//                System.out.println(paramI + " " + param[paramI]);
            }
            
            switch (op) {
                case 0:  // preRegistro
                    if (param.length != 2) {
                        erro(op + 1);
                    } else {
                        System.out.println(preRegistro(param[0], Integer.parseInt(param[1])));
                    }
                    break;
                case 1: // registraJogador
                    if (param.length != 1) {
                        erro(op + 1);
                    } else {
                        System.out.println(registraJogador(param[0]));
                    }
                    break;
                case 2:  // temPartida
                    if (param.length != 1) {
                        erro(op + 1);
                    } else {
                        System.out.println(temPartida(Integer.parseInt(param[0])));
                    }
                    break;
                case 3: // ehMinhaVez
                    if (param.length != 1) {
                        erro(op + 1);
                    } else {
                        System.out.println(ehMinhaVez(Integer.parseInt(param[0])));
                    }
                    break;
                case 4: // obtemGrade
                    if (param.length != 1) {
                        erro(op + 1);
                    } else {
                        System.out.println(obtemGrade(Integer.parseInt(param[0])));
                    }
                    break;
                case 5: // enviaJogada
                    if (param.length != 2) {
                        erro(op + 1);
                    } else {
                        System.out.println(enviaJogada(Integer.parseInt(param[0]), Integer.parseInt(param[1])));
                    }
                    break;
                case 6:  // obtemOponente
                    if (param.length != 1) {
                        erro(op + 1);
                    } else {
                        System.out.println(obtemOponente(Integer.parseInt(param[0])));
                    }
                    break;
                default:
                    erro(op + 1);
            }
        }
    }

    private static void erro(int operacao) {
        System.err.println("Entrada invalida: erro na operacao " + operacao + ".");
        System.exit(1);
    }

    private static String preRegistro(java.lang.String name, java.lang.Integer id) {
        tictactoeclient.TicTacToeWS_Service service = new tictactoeclient.TicTacToeWS_Service();
        tictactoeclient.TicTacToeWS port = service.getTicTacToeWSPort();
        port.preRegistro(name, id);
        return "0";
    }

    private static Integer registraJogador(java.lang.String name) {
        tictactoeclient.TicTacToeWS_Service service = new tictactoeclient.TicTacToeWS_Service();
        tictactoeclient.TicTacToeWS port = service.getTicTacToeWSPort();
        return port.registraJogador(name);
    }

    private static Integer temPartida(int parseInt) {
        tictactoeclient.TicTacToeWS_Service service = new tictactoeclient.TicTacToeWS_Service();
        tictactoeclient.TicTacToeWS port = service.getTicTacToeWSPort();
        return port.temPartida(parseInt);
    }

    private static Integer ehMinhaVez(int id) {
        tictactoeclient.TicTacToeWS_Service service = new tictactoeclient.TicTacToeWS_Service();
        tictactoeclient.TicTacToeWS port = service.getTicTacToeWSPort();
        return port.ehMinhaVez(id);
    }

    private static String obtemGrade(int id) {
        tictactoeclient.TicTacToeWS_Service service = new tictactoeclient.TicTacToeWS_Service();
        tictactoeclient.TicTacToeWS port = service.getTicTacToeWSPort();
        return port.obtemGrade(id);
    }

    private static Integer enviaJogada(int id, int jogada) {
        tictactoeclient.TicTacToeWS_Service service = new tictactoeclient.TicTacToeWS_Service();
        tictactoeclient.TicTacToeWS port = service.getTicTacToeWSPort();
        return port.enviaJogada(id, jogada);
    }

    private static String obtemOponente(int parseInt) {
        tictactoeclient.TicTacToeWS_Service service = new tictactoeclient.TicTacToeWS_Service();
        tictactoeclient.TicTacToeWS port = service.getTicTacToeWSPort();
        return port.obtemOponente(parseInt);
    }
}
