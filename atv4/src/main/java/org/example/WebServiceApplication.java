import org.example.Jogador;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceApplication.class, args);
    }
}

@RestController
class MensagemController {

    private final JogadorGerador jogadorGerador;

    public MensagemController(JogadorGerador jogadorGerador) {
        this.jogadorGerador = jogadorGerador;
    }

    @GetMapping("/mensagem")
    public String obterMensagem() {
        Jogador jogador = jogadorGerador.criarJogadorAleatorio();
        return jogador.getDescricao();
    }
}
