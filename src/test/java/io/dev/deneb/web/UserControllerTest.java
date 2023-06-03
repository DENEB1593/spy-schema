package io.dev.deneb.web;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dev.deneb.web.user.JoinRequest;
import io.dev.deneb.web.user.JoinResponse;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    @SneakyThrows
    void shouldJoinUserAndReturnCreated() {

        var request = new JoinRequest("test");

        ResultActions ra = mvc.perform(post("/api/users/join")
                        .contentType(APPLICATION_JSON)
                        .content(JSON.toJSONString(request)))
                .andExpect(status().isCreated());

        JoinResponse response = JSON.parseObject(
                ra.andReturn().getResponse().getContentAsString(),
                JoinResponse.class
        );

        assertThat(response).isNotNull();
        assertThat(response.name()).isNotNull();
        assertThat(response.id()).isNotNull();

//                .andExpect(jsonPath("$.id").exists())
//                .andExpect(jsonPath("$.name").exists());
    }


    @Test
    @SneakyThrows
    void shouldGetPosts() {
        mvc.perform(
                get("/api/users/" + 1L))
                .andExpect(status().isOk());
    }


}