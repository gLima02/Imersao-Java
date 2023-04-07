
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
	
    // Fazer uma conexão HTTP (protocolo de navegação e comunicação WEB. Request - Response, a response seria o top 250 filmes)
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

    // Pegar só os dados que interessam (Título, imagem do filme, ratings)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> ListaDeFilmes=  parser.parse(body);
        
    // Exibir e manipular os dados do jeito que queremos
        for (Map<String, String> filme : ListaDeFilmes) {
        	System.out.println(filme.get("rank"));
			System.out.println(filme.get("title"));
			System.out.println(filme.get("image"));
			System.out.println(filme.get("imDbRating"));
		}

    }
}