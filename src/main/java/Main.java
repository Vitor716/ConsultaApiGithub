import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        List<Usuario> usuarios = new ArrayList<>();
        ConsultaUsuarioGithub consultaUsuarioGithub = new ConsultaUsuarioGithub();

        GeradorExcel excel = new GeradorExcel();

        String login;
        while (true) {
            System.out.println("Digite o login que deseja buscar (ou 'sair' para encerrar):");
            login = sc.nextLine();

            if (login.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando o programa.");
                break;
            }

            Usuario usuario = consultaUsuarioGithub.buscarUsuarioGithub(login);

            usuarios.add(usuario);


            System.out.println(usuario);
        }

        excel.salvaExcel(usuarios);
        sc.close();

    }
}
