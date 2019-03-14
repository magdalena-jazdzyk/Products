package MK.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
   // private BigInteger countryId;

    @ManyToOne(cascade = CascadeType.PERSIST) // zachowuje sie jak trazakcyjnosc
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "shop")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Stock> stocks;


}