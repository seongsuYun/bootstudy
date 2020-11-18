package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class StudyApplicationTests {

	@Autowired
    private MockMvc mockMvc;
	
    @Before
    public void setup() {
    	//this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).addFilter(springSecurityFilterChain).build();
    }

    @Test
    public void 테스트001_상품전체목록() throws Exception {
        mockMvc.perform(get("/goods"))
                .andExpect(status().isOk())
                //.andExpect(content().string("hello saelobi"))
                .andDo(print());
    }
    
    @Test
    public void 테스트002_상품상세정보() throws Exception {
        mockMvc.perform(get("/goods/1111"))
                .andExpect(status().isOk())
                //.andExpect(content().string("hello saelobi"))
                .andDo(print());
    }

}

