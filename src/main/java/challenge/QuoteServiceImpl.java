package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository repository;

    private final Random random = new Random();

    // https://www.baeldung.com/java-random-list-element
    private Quote getRandom(List<Quote> quotes) {
        return quotes.isEmpty() ? null : quotes.get(random.nextInt(quotes.size()));
    }

    @Override
    public Quote getQuote() {
        return getRandom(this.repository.findAll());
    }

    @Override
    public Quote getQuoteByActor(String actor) {
        return getRandom(repository.findByActor(actor));
    }

}
