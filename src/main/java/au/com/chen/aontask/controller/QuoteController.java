package au.com.chen.aontask.controller;

import au.com.chen.aontask.dto.Query;
import au.com.chen.aontask.dto.Quote;
import au.com.chen.aontask.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The REST Controller for quote API
 *
 * @author chenliu
 */
@RestController
@RequestMapping("/quotes")
public class QuoteController {

    @Autowired
    QuoteService quoteService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Quote> quotes(@RequestParam(value = "postcode", required = true) String postcode,
                             @RequestParam(value = "occupation", required = true) String occupation,
                             @RequestParam(value = "turnover", required = true) Double turnover) {

        Query query = new Query(postcode, occupation, turnover);
        List<Quote> quotes = this.quoteService.getQuotes(query);

        return quotes;
    }
}


