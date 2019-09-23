package com.stfl.dto;

import com.stfl.model.HospitalDispatcher;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HospitalDispatcherDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Long hospitalId;

    public HospitalDispatcherDto (HospitalDispatcher dispatcher) {
        this.id = dispatcher.getId();
        this.firstName = dispatcher.getFirstName();
        this.lastName = dispatcher.getLastName();
        this.patronymic = dispatcher.getPatronymic();
        if(dispatcher.getHospital() != null) {
            this.hospitalId = dispatcher.getHospital().getId();
        } else {
            this.hospitalId = 0L;
        }
    }

}
