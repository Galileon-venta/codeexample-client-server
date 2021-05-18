package de.unidue.stud.example.backend.Service;

import de.unidue.stud.example.backend.Entities.Sample;
import de.unidue.stud.example.backend.Repositories.SampleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {

    @Autowired
    SampleRepo sampleRepo;

    public Sample getSampleById(Integer id){
        return sampleRepo.findSampleById(id);
    }

    public Sample createSample(Sample sample){
        return sampleRepo.save(sample);
    }

    public Sample editUsername(Integer sampleId, String newUsername){
        Sample sample = sampleRepo.findSampleById(sampleId);
        sample.setUsername(newUsername);
        return sampleRepo.save(sample);
    }

    public List<Sample> getAll() {
        return sampleRepo.findAll();
    }
}
