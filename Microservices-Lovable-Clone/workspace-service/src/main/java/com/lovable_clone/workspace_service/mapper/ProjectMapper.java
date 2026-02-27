package com.lovable_clone.workspace_service.mapper;

import com.lovable_clone.common_library.enums.ProjectRole;
import com.lovable_clone.workspace_service.dto.project.ProjectResponse;
import com.lovable_clone.workspace_service.dto.project.ProjectSummaryResponse;
import com.lovable_clone.workspace_service.entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    ProjectSummaryResponse toProjectSummaryResponse(Project project, ProjectRole role);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);

}
