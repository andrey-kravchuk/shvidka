package com.stfl.dto;

import com.stfl.model.MedicalData;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class MedicalDataDTO {

    private Long id;
    private String height;
    private String weight;

    private List<String> allergies = new ArrayList<>();
    private List<String> chronicDiseases = new ArrayList<>();
    private List<String> medications = new ArrayList<>();

    public MedicalDataDTO(MedicalData medicalData) {
        this.id = medicalData.getId();
        this.height = medicalData.getHeight();
        this.weight = medicalData.getWeight();
        this.allergies = medicalData.getAllergies();
        this.chronicDiseases = medicalData.getChronicDiseases();
        this.medications = medicalData.getMedications();
    }
}