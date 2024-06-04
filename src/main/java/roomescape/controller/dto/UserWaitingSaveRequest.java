package roomescape.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import roomescape.service.dto.WaitingSaveRequest;

import java.time.LocalDate;

public record UserWaitingSaveRequest(
        @NotNull
        @FutureOrPresent(message = "지나간 날짜의 예약을 할 수 없습니다.")
        @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
        LocalDate date,

        @NotNull
        @Positive
        Long timeId,

        @NotNull
        @Positive
        Long themeId
) {
    public WaitingSaveRequest toWaitingSaveRequest(Long memberId) {
        return new WaitingSaveRequest(memberId, date, timeId, themeId);
    }
}
