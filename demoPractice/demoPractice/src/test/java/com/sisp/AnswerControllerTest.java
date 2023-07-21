package com.sisp;

import com.sisp.controller.AnswerController;
import com.sisp.dao.entity.AnswerEntity;
import com.sisp.dao.entity.QuestionEntity;
import com.sisp.service.AnswerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AnswerController.class)
class AnswerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnswerService mockAnswerService;



    @Test
    void testInsert() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/answer/insert")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm AnswerService.insert(...).
        final AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setId("id");
        answerEntity.setQuestionnaireId("questionnaireId");
        answerEntity.setRoleId("roleId");
        answerEntity.setAnswerTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        answerEntity.setAnswerStatus("answerStatus");
        verify(mockAnswerService).insert(answerEntity);
    }

    @Test
    void testList() throws Exception {
        // Setup
        // Configure AnswerService.list(...).
        final AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setId("id");
        answerEntity.setQuestionnaireId("questionnaireId");
        answerEntity.setRoleId("roleId");
        answerEntity.setAnswerTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        answerEntity.setAnswerStatus("answerStatus");
        final List<AnswerEntity> answerEntities = Arrays.asList(answerEntity);
        final AnswerEntity answerEntity1 = new AnswerEntity();
        answerEntity1.setId("id");
        answerEntity1.setQuestionnaireId("questionnaireId");
        answerEntity1.setRoleId("roleId");
        answerEntity1.setAnswerTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        answerEntity1.setAnswerStatus("answerStatus");
        when(mockAnswerService.list(answerEntity1)).thenReturn(answerEntities);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/answer/list")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testList_AnswerServiceReturnsNoItems() throws Exception {
        // Setup
        // Configure AnswerService.list(...).
        final AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setId("id");
        answerEntity.setQuestionnaireId("questionnaireId");
        answerEntity.setRoleId("roleId");
        answerEntity.setAnswerTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        answerEntity.setAnswerStatus("answerStatus");
        when(mockAnswerService.list(answerEntity)).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/answer/list")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }


    @Test
    void testStatistics() throws Exception {
        // Setup
        // 模拟的问题数据
        final List<QuestionEntity> questionData = new ArrayList<>();
        final QuestionEntity question1 = new QuestionEntity();
        question1.setId("1");
        question1.setQuestionName("Question 1");
        question1.setQuestionOption("[\"Option 1\", \"Option 2\", \"Option 3\"]");
        questionData.add(question1);

        final QuestionEntity question2 = new QuestionEntity();
        question2.setId("2");
        question2.setQuestionName("Question 2");
        question2.setQuestionOption("[\"Option A\", \"Option B\"]");
        questionData.add(question2);

        // 模拟的答案数据
        final List<AnswerEntity> answerData = new ArrayList<>();
        final AnswerEntity answer1 = new AnswerEntity();
        answer1.setAnswer("[{\"questionId\": 1, \"answer\": \"Option 1\"}, {\"questionId\": 2, \"answer\": \"Option A\"}]");
        answerData.add(answer1);

        final AnswerEntity answer2 = new AnswerEntity();
        answer2.setAnswer("[{\"questionId\": 1, \"answer\": \"Option 2\"}, {\"questionId\": 2, \"answer\": \"Option A\"}]");
        answerData.add(answer2);

        final AnswerEntity answer3 = new AnswerEntity();
        answer3.setAnswer("[{\"questionId\": 1, \"answer\": \"Option 1\"}, {\"questionId\": 2, \"answer\": \"Option B\"}]");
        answerData.add(answer3);


        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/statistics"))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

}
