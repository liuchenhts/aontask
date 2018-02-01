package au.com.chen.aontask;

import au.com.chen.aontask.domain.Insurer;
import au.com.chen.aontask.service.InsurerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * unit testing for InsurerService
 *
 * @author chenliu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InsurerServiceTests {


    @Autowired
    private InsurerService insurerService;


    @Test
    public void testGetInsurers() {

        System.out.println("InsurerServiceTests->testGetInsurers-------->>>>");

        Insurer insurer1 = new Insurer("Insurer1");
        Insurer insurer2 = new Insurer("Insurer2");
        Insurer insurer3 = new Insurer("Insurer3");
        Insurer insurer4 = new Insurer("Insurer4");

        List<Insurer> insurers = this.insurerService.getInsurers();
        System.out.println("insurers loaded: ");
        insurers.forEach(System.out::println);
        assertThat(insurers.size()).isEqualTo(4);
        assertThat(insurers.contains(insurer1));
        assertThat(insurers.contains(insurer2));
        assertThat(insurers.contains(insurer3));
        assertThat(insurers.contains(insurer4));

    }

}
