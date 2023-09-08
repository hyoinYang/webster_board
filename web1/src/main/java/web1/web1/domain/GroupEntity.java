package web1.web1.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime localDateTime;

    @Column
    private DevLocation location;

    @Column
    private DevNumberOfPeople numberOfPeople;

    @Column
    private GenderType gender;
}
