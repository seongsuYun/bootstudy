package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.member.vo.MemberVo;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class StudyApplicationTests {

	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
    @Before
    public void setup() {
    	//this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).addFilter(springSecurityFilterChain).build();
    }
    
    @Test
    public void 테스트001_상품전체목록() throws Exception {
        mockMvc.perform(get("/goods"))
                .andExpect(status().isOk())
                .andDo(print());
    }
    
    @Test
    public void 테스트002_상품상세정보() throws Exception {
        mockMvc.perform(get("/goods/1111"))
                .andExpect(status().isOk())
                .andDo(print());
    }
    
    @Test
    public void 테스트003_회원추가() throws Exception {
    	String content = objectMapper.writeValueAsString(new MemberVo(
    			"icast4u@nate.com"
    			,"윤성수"
    			,"1234"
    			,""));

        mockMvc.perform(post("/member")
            .content(content)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print());
    }

}

