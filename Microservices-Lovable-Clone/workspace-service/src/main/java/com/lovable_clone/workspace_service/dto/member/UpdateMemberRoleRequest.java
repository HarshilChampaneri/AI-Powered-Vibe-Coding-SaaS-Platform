package com.lovable_clone.workspace_service.dto.member;

import com.lovable_clone.common_library.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectRole role) {
}
