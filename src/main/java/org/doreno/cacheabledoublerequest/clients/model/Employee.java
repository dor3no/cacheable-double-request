package org.doreno.cacheabledoublerequest.clients.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

    private Integer employeeID;

    public Employee() {
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    @JsonProperty("EmployeeID")
    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }
}
