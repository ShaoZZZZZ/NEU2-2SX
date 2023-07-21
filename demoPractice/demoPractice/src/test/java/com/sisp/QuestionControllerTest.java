package com.sisp;

import com.sisp.controller.QuestionController;
import com.sisp.dao.entity.QuestionEntity;
import com.sisp.service.QuestionService;
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(QuestionController.class)
class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService mockQuestionService;

    @Test
    void testList() throws Exception {
        // Setup
        // Configure QuestionService.list(...).
        final QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId("id");
        questionEntity.setIsMust("isMust");
        questionEntity.setQuestionnaireId("questionnaireId");
        questionEntity.setQuestionName("questionName");
        questionEntity.setQuestionContent("questionContent");
        final List<QuestionEntity> questionEntities = Arrays.asList(questionEntity);
        final QuestionEntity questionEntity1 = new QuestionEntity();
        questionEntity1.setId("id");
        questionEntity1.setIsMust("isMust");
        questionEntity1.setQuestionnaireId("questionnaireId");
        questionEntity1.setQuestionName("questionName");
        questionEntity1.setQuestionContent("questionContent");
        when(mockQuestionService.list(questionEntity1)).thenReturn(questionEntities);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/question/list")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testList_QuestionServiceReturnsNoItems() throws Exception {
        // Setup
        // Configure QuestionService.list(...).
        final QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId("id");
        questionEntity.setIsMust("isMust");
        questionEntity.setQuestionnaireId("questionnaireId");
        questionEntity.setQuestionName("questionName");
        questionEntity.setQuestionContent("questionContent");
        when(mockQuestionService.list(questionEntity)).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/question/list")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testInsert() throws Exception {
        // Setup
        // Configure QuestionService.insert(...).
        final QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId("id");
        questionEntity.setIsMust("isMust");
        questionEntity.setQuestionnaireId("questionnaireId");
        questionEntity.setQuestionName("questionName");
        questionEntity.setQuestionContent("questionContent");
        when(mockQuestionService.insert(questionEntity)).thenReturn("data");

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/question/insert")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testUpdate() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/question/update")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm QuestionService.modify(...).
        final QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId("id");
        questionEntity.setIsMust("isMust");
        questionEntity.setQuestionnaireId("questionnaireId");
        questionEntity.setQuestionName("questionName");
        questionEntity.setQuestionContent("questionContent");
        verify(mockQuestionService).modify(questionEntity);
    }

    @Test
    void testDelete() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/question/delete")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm QuestionService.delete(...).
        final QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setId("id");
        questionEntity.setIsMust("isMust");
        questionEntity.setQuestionnaireId("questionnaireId");
        questionEntity.setQuestionName("questionName");
        questionEntity.setQuestionContent("questionContent");
        verify(mockQuestionService).delete(questionEntity);
    }
}
