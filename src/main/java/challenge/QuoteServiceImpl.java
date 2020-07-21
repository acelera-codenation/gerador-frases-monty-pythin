package challenge;

import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

    private QuoteRepository repository;

    public QuoteServiceImpl(QuoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Quote getQuote() {
        return repository.findAll().stream().findAny().orElse(null);
    }

    @Override
    public Quote getQuoteByActor(String actor) {
        return repository.findByActor(actor).stream().findAny().orElse(null);
    }
}
