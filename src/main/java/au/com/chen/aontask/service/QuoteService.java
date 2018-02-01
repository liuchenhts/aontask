package au.com.chen.aontask.service;

import au.com.chen.aontask.dto.Query;
import au.com.chen.aontask.dto.Quote;

import java.util.List;

public interface QuoteService{

    List<Quote> getQuotes(Query query);
}
