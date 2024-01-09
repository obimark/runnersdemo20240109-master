package hu.gde.runnersdemo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "shoename")
public class ShoeNameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shoeId;
    private String shoeName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false)
    private RunnerEntity runner;

    @Column(name = "shoename", nullable = false)
    private String shoename;


    public long getShoeId() {
        return shoeId;
    }

    public String getShoeName() {
        return shoeName;
    }

    public RunnerEntity getRunner() {
        return runner;
    }
    public void setRunner(RunnerEntity runner) {
        this.runner = runner;
    }

    public void setShoeId(long shoeId) {
        this.shoeId = shoeId;
    }

    public void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }
}
