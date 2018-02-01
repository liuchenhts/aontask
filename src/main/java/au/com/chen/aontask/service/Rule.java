package au.com.chen.aontask.service;

import au.com.chen.aontask.dto.Query;
import au.com.chen.aontask.domain.Insurer;

public interface Rule {

    Boolean exclude(Insurer insurer, Query query);
}
