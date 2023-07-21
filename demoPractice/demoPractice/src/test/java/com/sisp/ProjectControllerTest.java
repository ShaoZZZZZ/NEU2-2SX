package com.sisp;

import com.sisp.controller.ProjectController;
import com.sisp.dao.entity.ProjectEntity;
import com.sisp.service.ProjectService;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProjectController.class)
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService mockProjectService;

    @Test
    void testQueryProjectList() throws Exception {
        // Setup
        // Configure ProjectService.queryProjectList(...).
        final ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId("id");
        projectEntity.setUserId("userId");
        projectEntity.setProjectName("projectName");
        projectEntity.setProjectContent("projectContent");
        projectEntity.setCreatedBy("createdBy");
        final List<ProjectEntity> projectEntities = Arrays.asList(projectEntity);
        final ProjectEntity projectEntity1 = new ProjectEntity();
        projectEntity1.setId("id");
        projectEntity1.setUserId("userId");
        projectEntity1.setProjectName("projectName");
        projectEntity1.setProjectContent("projectContent");
        projectEntity1.setCreatedBy("createdBy");
        when(mockProjectService.queryProjectList(projectEntity1)).thenReturn(projectEntities);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/queryProjectList")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testQueryProjectList_ProjectServiceReturnsNoItems() throws Exception {
        // Setup
        // Configure ProjectService.queryProjectList(...).
        final ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId("id");
        projectEntity.setUserId("userId");
        projectEntity.setProjectName("projectName");
        projectEntity.setProjectContent("projectContent");
        projectEntity.setCreatedBy("createdBy");
        when(mockProjectService.queryProjectList(projectEntity)).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/queryProjectList")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testAddProjectInfo() throws Exception {
        // Setup
        // Configure ProjectService.addProjectInfo(...).
        final ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId("id");
        projectEntity.setUserId("userId");
        projectEntity.setProjectName("projectName");
        projectEntity.setProjectContent("projectContent");
        projectEntity.setCreatedBy("createdBy");
        when(mockProjectService.addProjectInfo(projectEntity)).thenReturn(0);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/addProjectInfo")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testModifyProjectInfo() throws Exception {
        // Setup
        // Configure ProjectService.modifyProjectInfo(...).
        final ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId("id");
        projectEntity.setUserId("userId");
        projectEntity.setProjectName("projectName");
        projectEntity.setProjectContent("projectContent");
        projectEntity.setCreatedBy("createdBy");
        when(mockProjectService.modifyProjectInfo(projectEntity)).thenReturn(0);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/modifyProjectInfo")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testDeleteProject() throws Exception {
        // Setup
        // Configure ProjectService.deleteProjectInfo(...).
        final ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId("id");
        projectEntity.setUserId("userId");
        projectEntity.setProjectName("projectName");
        projectEntity.setProjectContent("projectContent");
        projectEntity.setCreatedBy("createdBy");
        when(mockProjectService.deleteProjectInfo(projectEntity)).thenReturn(0);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/deleteProjectById")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
