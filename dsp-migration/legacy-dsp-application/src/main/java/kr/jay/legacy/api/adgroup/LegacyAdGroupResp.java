package kr.jay.legacy.api.adgroup;

import java.time.LocalDateTime;
import kr.jay.legacy.application.adgroup.LegacyAdGroupResult;

public record LegacyAdGroupResp(Long id, String name, Long campaignId, String linkUrl,
                                LocalDateTime createdAt, LocalDateTime updatedAt,
                                LocalDateTime deletedAt) {


  public static LegacyAdGroupResp from(LegacyAdGroupResult adGroup) {
    return new LegacyAdGroupResp(adGroup.id(), adGroup.name(), adGroup.campaignId(),
        adGroup.linkUrl(), adGroup.createdAt(), adGroup.updatedAt(),
        adGroup.deletedAt());
  }
}
