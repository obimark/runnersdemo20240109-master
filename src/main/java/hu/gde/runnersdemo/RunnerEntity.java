package hu.gde.runnersdemo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RunnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long runnerId;
    private String runnerName;
    private long pace;

    // Új Cipőméret felvétele
    private long shoeSize;

    @OneToMany(mappedBy = "runner")
    private List<LapTimeEntity> laptimes = new ArrayList<>();

    @OneToMany(mappedBy = "runner")
    private List<ShoeNameEntity> shoes = new ArrayList<>();

    public RunnerEntity() {
    }

    public long getRunnerId() {
        return runnerId;
    }

    public String getRunnerName() {
        return runnerName;
    }

    public long getPace() {
        return pace;
    }

    public long getShoeSize() {
        return shoeSize;
    }
    public void setRunnerId(long runnerId) {
        this.runnerId = runnerId;
    }

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

    public void setPace(long pace) {
        this.pace = pace;
    }

    public void setShoeSize(long shoeSize) {
        this.shoeSize = shoeSize;
    }
    public List<LapTimeEntity> getLaptimes() {
        return laptimes;
    }

    public List<ShoeNameEntity> getShoes() {
        return shoes;
    }
}