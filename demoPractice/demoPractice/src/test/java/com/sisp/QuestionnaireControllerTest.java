package com.sisp;

import com.sisp.controller.QuestionnaireController;
import com.sisp.dao.entity.QuestionnaireEntity;
import com.sisp.service.QuestionnaireService;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(QuestionnaireController.class)
class QuestionnaireControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionnaireService mockQuestionnaireService;

    @Test
    void testList() throws Exception {
        // Setup
        // Configure QuestionnaireService.queryList(...).
        final QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
        questionnaireEntity.setId("id");
        questionnaireEntity.setQuestionnaireName("questionnaireName");
        questionnaireEntity.setStartTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        questionnaireEntity.setStopTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        questionnaireEntity.setQuestionnaireContent("questionnaireContent");
        final List<QuestionnaireEntity> entities = Arrays.asList(questionnaireEntity);
        final QuestionnaireEntity questionnaireEntity1 = new QuestionnaireEntity();
        questionnaireEntity1.setId("id");
        questionnaireEntity1.setQuestionnaireName("questionnaireName");
        questionnaireEntity1.setStartTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        questionnaireEntity1.setStopTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        questionnaireEntity1.setQuestionnaireContent("questionnaireContent");
        when(mockQuestionnaireService.queryList(questionnaireEntity1)).thenReturn(entities);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/questionnaire/list")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testList_QuestionnaireServiceReturnsNoItems() throws Exception {
        // Setup
        // Configure QuestionnaireService.queryList(...).
        final QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
        questionnaireEntity.setId("id");
        questionnaireEntity.setQuestionnaireName("questionnaireName");
        questionnaireEntity.setStartTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        questionnaireEntity.setStopTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        questionnaireEntity.setQuestionnaireContent("questionnaireContent");
        when(mockQuestionnaireService.queryList(questionnaireEntity)).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/questionnaire/list")
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
        // Configure QuestionnaireService.insert(...).
        final QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
        questionnaireEntity.setId("id");
        questionnaireEntity.setQuestionnaireName("questionnaireName");
        questionnaireEntity.setStartTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        questionnaireEntity.setStopTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        questionnaireEntity.setQuestionnaireContent("questionnaireContent");
        when(mockQuestionnaireService.insert(questionnaireEntity)).thenReturn("data");

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/questionnaire/insert")
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
        final MockHttpServletResponse response = mockMvc.perform(post("/questionnaire/update")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm QuestionnaireService.modify(...).
        final QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
        questionnaireEntity.setId("id");
        questionnaireEntity.setQuestionnaireName("questionnaireName");
        questionnaireEntity.setStartTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        questionnaireEntity.setStopTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        questionnaireEntity.setQuestionnaireContent("questionnaireContent");
        verify(mockQuestionnaireService).modify(questionnaireEntity);
    }

    @Test
    void testDelete() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/questionnaire/delete")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm QuestionnaireService.delete(...).
        final QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
        questionnaireEntity.setId("id");
        questionnaireEntity.setQuestionnaireName("questionnaireName");
        questionnaireEntity.setStartTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        questionnaireEntity.setStopTime(Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)));
        questionnaireEntity.setQuestionnaireContent("questionnaireContent");
        verify(mockQuestionnaireService).delete(questionnaireEntity);
    }
}
