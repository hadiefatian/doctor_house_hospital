package at.refugeescode.nursery.persitence.repository;

import at.refugeescode.nursery.persitence.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {
}
