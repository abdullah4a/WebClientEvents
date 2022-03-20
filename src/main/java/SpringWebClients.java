import model.Events;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class SpringWebClients {
    private final WebClient webClient;

    public SpringWebClients() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8080/events")
                .build();
    }

    public static void main(String[] args) {
        SpringWebClients api = new SpringWebClients();

        api.postNewEvents()
                .thenMany(api.getAllEvents())
                .take(1)
                .subscribe();

        try {
            Thread.sleep(5000);
        } catch (Exception ignored) {
        }
    }

    private Mono<ResponseEntity<Events>> postNewEvents() {
        return webClient
                .post()
                .body(Mono.just(new Events(null, "Test", "Test", "Test")), Events.class)
                .exchangeToMono(response -> response.toEntity(Events.class))
                .doOnSuccess(o -> System.out.println("POST " + o));
    }

    private Flux<Events> getAllEvents() {
        return webClient
                .get()
                .retrieve()
                .bodyToFlux(Events.class)
                .doOnNext(o -> System.out.println("GET: " + o));
    }


    private Mono<Events> updateEvent(String id, String title, String price, String remarks) {
        return webClient
                .put()
                .uri("/{id}", id)
                .body(Mono.just(new Events(null, title, price, remarks)), Events.class)
                .retrieve()
                .bodyToMono(Events.class)
                .doOnSuccess(o -> System.out.println("**********UPDATE " + o));
    }


}
