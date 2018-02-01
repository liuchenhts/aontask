package au.com.chen.aontask;

import au.com.chen.aontask.service.InsurerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * behavior testing for QuoteController REST API
 *
 * @author chenliu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class QuoteControllerTests {


    @Autowired
    private MockMvc mvc;

    @Autowired
    private InsurerService insurerService;


    @Test
    public void testQuotesRestAPI() throws Exception {

        System.out.println("QuoteControllerTests->testQuotesRestAPI-------->>>>");

        mvc.perform(MockMvcRequestBuilders.get("/quotes?postcode=2000&occupation=Builder&turnover=600000").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].insurerName", is("Insurer1")))
                .andExpect(jsonPath("$[1].insurerName", is("Insurer2")))
                .andExpect(jsonPath("$[2].insurerName", is("Insurer3")))
                .andExpect(jsonPath("$[3].insurerName", is("Insurer4")))
                .andDo(MockMvcResultHandlers.print());


        mvc.perform(MockMvcRequestBuilders.get("/quotes?postcode=2000&occupation=Builder&turnover=100000").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].insurerName", is("Insurer1")))
                .andExpect(jsonPath("$[1].insurerName", is("Insurer2")))
                .andDo(MockMvcResultHandlers.print());


        mvc.perform(MockMvcRequestBuilders.get("/quotes?postcode=2000&occupation=Plumber&turnover=600000").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].insurerName", is("Insurer1")))
                .andExpect(jsonPath("$[1].insurerName", is("Insurer2")))
                .andExpect(jsonPath("$[2].insurerName", is("Insurer4")))
                .andDo(MockMvcResultHandlers.print());


        mvc.perform(MockMvcRequestBuilders.get("/quotes?postcode=2001&occupation=Butcher&turnover=300000").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].insurerName", is("Insurer1")))
                .andExpect(jsonPath("$[1].insurerName", is("Insurer3")))
                .andDo(MockMvcResultHandlers.print());
    }

}
