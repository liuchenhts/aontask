package au.com.chen.aontask.service.impl;

import au.com.chen.aontask.domain.Insurer;
import au.com.chen.aontask.dto.Query;
import au.com.chen.aontask.dto.Quote;
import au.com.chen.aontask.service.InsurerService;
import au.com.chen.aontask.service.QuoteService;
import au.com.chen.aontask.service.Rule;
import au.com.chen.aontask.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * The Quote service implementation to perform quote operation
 *
 * @author chenliu
 */

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    InsurerService insurerService;

    @Autowired
    RuleService ruleService;

    /**
     * get quotes based on the query
     *
     * @param query
     * @return quotes
     */
    @Override
    public List<Quote> getQuotes(Query query) {

        List<Insurer> insurers = this.insurerService.getInsurers();

        List<Quote> quotes = insurers.stream()
                .filter(insurer -> {
                    for (Rule rule : this.ruleService.getRules()) {
                        if (rule.exclude(insurer, query)) {
                            return false;
                        }
                    }
                    return true;
                })
                .map(insurer -> {
                    return new Quote(insurer.getName(), 100D);
                })
                .collect(toList());

        return quotes;

    }
}
