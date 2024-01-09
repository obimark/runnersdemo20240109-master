package hu.gde.runnersdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunnerService {

    private final RunnerRepository runnerRepository;

    @Autowired
    public RunnerService(RunnerRepository runnerRepository) {
        this.runnerRepository = runnerRepository;
    }

    public double getAverageLaptime(Long runnerId) {
        RunnerEntity runner = runnerRepository.findById(runnerId).orElse(null);
        if (runner != null) {
            List<LapTimeEntity> laptimes = runner.getLaptimes();
            int totalTime = 0;
            for (LapTimeEntity laptime : laptimes) {
                totalTime += laptime.getTimeSeconds();
            }
            return (double) totalTime / laptimes.size();
        } else {
            return -1.0;
        }
    }

    // Legnagyobb lábú futó lekérdezéséhez a metódus
    public static RunnerEntity getBiggestFoot(RunnerRepository runnerRepository){
        List<RunnerEntity> runners = runnerRepository.findAll();
        if (runners.isEmpty()) {
            return null;
        }

        RunnerEntity biggestShoeSize = runners.get(0);
        for (RunnerEntity runner : runners) {
            if (runner.getShoeSize() > biggestShoeSize.getShoeSize());
            biggestShoeSize = runner;
        }

        return biggestShoeSize;
    }




}
