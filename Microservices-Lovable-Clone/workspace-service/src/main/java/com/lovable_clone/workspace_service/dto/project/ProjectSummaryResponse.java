package com.lovable_clone.workspace_service.dto.project;


import com.lovable_clone.common_library.enums.ProjectRole;

import java.time.Instant;

public record ProjectSummaryResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        ProjectRole role
) {
}
