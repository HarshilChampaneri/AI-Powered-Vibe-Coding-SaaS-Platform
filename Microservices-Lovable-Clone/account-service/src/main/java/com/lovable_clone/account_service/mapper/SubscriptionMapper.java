package com.lovable_clone.account_service.mapper;

import com.lovable_clone.account_service.dto.subscription.SubscriptionResponse;
import com.lovable_clone.account_service.entity.Plan;
import com.lovable_clone.account_service.entity.Subscription;
import com.lovable_clone.common_library.dto.PlanDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionResponse toSubscriptionResponse(Subscription subscription);

    PlanDto toPlanResponse(Plan plan);
}
