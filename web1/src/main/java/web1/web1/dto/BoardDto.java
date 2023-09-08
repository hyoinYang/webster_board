package web1.web1.dto;



import web1.web1.domain.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardDto {
    private Long id;
    private LocalDateTime localDateTime;
    private DevLocation location;
    private DevNumberOfPeople numberOfPeople;
    private GenderType gender;

    private DevSelectTime selectTime;

    public GroupEntity toEntity() {
        GroupEntity groupEntity = GroupEntity.builder()
                .id(id)
                .location(location)
                .numberOfPeople(numberOfPeople)
                .gender(gender)
                .localDateTime(localDateTime)
                .build();
        return groupEntity;
    }


    @Builder
    public BoardDto(Long id, DevLocation location, DevNumberOfPeople numberOfPeople, GenderType gender, LocalDateTime localDateTime, DevSelectTime selectTime) {
        this.id = id;
        this.location = location;
        this.numberOfPeople = numberOfPeople;
        this.gender = gender;
        this.localDateTime = localDateTime;
    }

}