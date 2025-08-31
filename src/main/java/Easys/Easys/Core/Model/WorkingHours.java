package Easys.Easys.Core.Model;

import java.time.DayOfWeek;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkingHours {
    private Long id;
    @ManyToOne
    @JoinColumn(name = "professional_id", referencedColumnName = "id")
    private Professional professional;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    
}
