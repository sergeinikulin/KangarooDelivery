package ru.kangaroodelivery.reports.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@DisplayName("Тест контроллера проверки работоспособности")
@WebMvcTest(SimpleCheckJobController.class)
public class SimpleCheckJobControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCheckTest() throws Exception {
        this.mockMvc.perform(get("/simpleCheckJobController"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("reports its job!")));
    }
}
