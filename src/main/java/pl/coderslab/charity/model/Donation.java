package pl.coderslab.charity.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "Donations")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "podaj ilość worków")
    @Min(value = 1, message = "ilość powinna być większa od zera")
    private Integer quantity;
    @ManyToMany
    @JoinTable(name = "categories_donations")
    @Size(min = 1, message = "wybierz przynajmniej jedną kategorię")
    private List<Category> categories;
    @OneToOne
    @JoinColumn(name = "institution_id")
    @NotNull(message = "wybierz fundację")
    private Institution institution;
    @NotBlank(message = "Podaj ulicę")
    private String street;
    @NotBlank(message = "Podaj miasto")
    private String city;
    @NotBlank(message = "Podaj kod pocztowy")
    @Pattern(regexp = "\\d{2}\\-\\d{3}", message = "format kodu pocztowego XX-XXX")
    private String zipCode;

    @Future(message = "podaj datę w przyszłości")
    @NotNull(message = "podaj datę")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @NotNull(message = "podaj godzinę")
    private LocalTime pickUpTime;
    @NotBlank(message = "podaj uwagi dla kuriera, np. (brak)")
    private String pickUpComment;
}
