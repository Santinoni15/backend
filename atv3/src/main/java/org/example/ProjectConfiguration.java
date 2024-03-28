package org.example;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ProjectConfiguration {

    @Bean
    public Atores atorBean(){
        return new Atores("Sofía Vergara", "Colombia", (short) 0, false);
    }

    @Bean
    public Filmes filmeBean(){
        return new Filmes("Vingadores", "ação", (short) 0, false);
    }
    @Bean
    public OscarService oscarService() {
        return new OscarService();
    }
}
