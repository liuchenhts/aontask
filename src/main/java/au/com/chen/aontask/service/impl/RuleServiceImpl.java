package au.com.chen.aontask.service.impl;

import au.com.chen.aontask.service.Rule;
import au.com.chen.aontask.service.RuleService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * The Rule service implementation to perform rules definition and management operation
 *
 * The Strategy design pattern is used here to separate the Quote service and the exclusion rules
 * When rules changed, the code change is controlled to a minimum to save time and cost
 *
 * @author chenliu
 */
@Service
public class RuleServiceImpl implements RuleService {

    /**
     * define the rule of excluding both postcode and occupation
     */
    Rule excludePostcodeAndOccupationRule = (insurer, query) -> {

        if (insurer.getExludedPostcodes().contains(query.getPostcode()) && insurer.getExludedOccupations().contains(query.getOccupation()))
            return true;
        else
            return false;
    };

    /**
     * define the rule of excluding min turnover
     */
    Rule excludeMinTurnoverRule = (insurer, query) -> {

        if (insurer.getMinTurnover() != null && insurer.getMinTurnover().compareTo(query.getTurnover()) > 0)
            return true;
        else
            return false;
    };

    List<Rule> rules = new ArrayList<>();

    /**
     * initialize the rules here
     */
    @PostConstruct
    public void initRules(){
        this.rules.add(this.excludePostcodeAndOccupationRule);
        this.rules.add(this.excludeMinTurnoverRule);
    }

    /**
     * get defined rules
     *
     * @return rules
     */
    @Override
    public List<Rule> getRules() {
       return this.rules;
    }
}
