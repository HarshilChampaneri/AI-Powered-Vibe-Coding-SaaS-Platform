package com.lovable_clone.account_service.dto.subscription;

import com.lovable_clone.common_library.dto.PlanDto;

import java.time.Instant;

public record SubscriptionResponse(
        PlanDto plan,
        String status,
        Instant currentPeriodEnd,
        Long tokensUsedThisCycle
) {
}
