package au.com.chen.aontask;

import au.com.chen.aontask.dto.Query;
import au.com.chen.aontask.dto.Quote;
import au.com.chen.aontask.domain.Insurer;
import au.com.chen.aontask.service.QuoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * unit testing for QuoteService
 *
 * @author chenliu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuoteServiceTests {


    @Autowired
    private QuoteService quoteService;


    @Test
    public void testGetQuotes() {

        System.out.println("QuoteServiceTests->testGetQuotes-------->>>>");

        Insurer insurer1 = new Insurer("Insurer1");
        Insurer insurer2 = new Insurer("Insurer2");
        Insurer insurer3 = new Insurer("Insurer3");
        Insurer insurer4 = new Insurer("Insurer4");


        Query query = new Query("2000", "Builder", 600000D);
        List<Quote> quotes = this.quoteService.getQuotes(query);
        System.out.println("quote for: " + query);
        quotes.forEach(System.out::println);
        assertThat(quotes.size()).isEqualTo(4);
        assertThat(quotes.contains(insurer1));
        assertThat(quotes.contains(insurer2));
        assertThat(quotes.contains(insurer3));
        assertThat(quotes.contains(insurer4));


        query = new Query("2000", "Builder", 100000D);
        quotes = this.quoteService.getQuotes(query);
        System.out.println("quote for: " + query);
        quotes.forEach(System.out::println);
        assertThat(quotes.size()).isEqualTo(2);
        assertThat(quotes.contains(insurer1));
        assertThat(quotes.contains(insurer2));


        query = new Query("2000", "Plumber", 600000D);
        quotes = this.quoteService.getQuotes(query);
        System.out.println("quote for: " + query);
        quotes.forEach(System.out::println);
        assertThat(quotes.size()).isEqualTo(3);
        assertThat(quotes.contains(insurer1));
        assertThat(quotes.contains(insurer2));
        assertThat(quotes.contains(insurer4));


        query = new Query("2001", "Butcher", 300000D);
        quotes = this.quoteService.getQuotes(query);
        System.out.println("quote for: " + query);
        quotes.forEach(System.out::println);
        assertThat(quotes.size()).isEqualTo(2);
        assertThat(quotes.contains(insurer1));
        assertThat(quotes.contains(insurer3));
    }
}
