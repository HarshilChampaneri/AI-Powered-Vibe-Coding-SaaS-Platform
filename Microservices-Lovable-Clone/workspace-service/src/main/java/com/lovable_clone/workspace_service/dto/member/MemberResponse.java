package com.lovable_clone.workspace_service.dto.member;

import com.lovable_clone.common_library.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String username,
        String name,
        ProjectRole role,
        Instant invitedAt
) {
}
