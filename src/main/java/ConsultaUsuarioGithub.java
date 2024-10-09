import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaUsuarioGithub {
    public Usuario buscarUsuarioGithub(String login){
        URI uri = URI.create("https://api.github.com/users/" + login);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/vnd.github.v3+json")
                .build();
        try{
            HttpResponse<String> response = HttpClient
                    .newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Usuario.class);
        } catch (Exception e){
            throw new UsuarioGithubException("Usuario não encontrado");
        }
    }
}
