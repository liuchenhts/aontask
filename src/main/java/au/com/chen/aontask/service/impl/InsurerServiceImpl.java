package au.com.chen.aontask.service.impl;

import au.com.chen.aontask.domain.Insurer;
import au.com.chen.aontask.service.InsurerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Insurer service implementation to perform Insurer entity persistence operation
 *
 * @author chenliu
 */
@Service
public class InsurerServiceImpl implements InsurerService {

    /**
     * get insurers from persistence layer
     *
     * @return
     */
    @Override
    public List<Insurer> getInsurers() {

        List<Insurer> insurers = new ArrayList<>();

        Insurer insurer1 = new Insurer("Insurer1", Arrays.asList(), Arrays.asList(), null);

        Insurer insurer2 = new Insurer("Insurer2", Arrays.asList("2000", "2001"), Arrays.asList("Butcher"), null);

        Insurer insurer3 = new Insurer("Insurer3", Arrays.asList("2000"), Arrays.asList("Butcher", "Plumber"), 200000D);

        Insurer insurer4 = new Insurer("Insurer4", Arrays.asList(), Arrays.asList(), 400000D);

        insurers.add(insurer1);
        insurers.add(insurer2);
        insurers.add(insurer3);
        insurers.add(insurer4);

        return insurers;
    }
}
