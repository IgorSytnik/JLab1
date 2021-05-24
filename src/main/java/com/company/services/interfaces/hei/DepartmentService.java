package com.company.services.interfaces.hei;

import com.company.domain.hei.Department;
import com.company.services.interfaces.Common;

import java.util.Date;

public interface DepartmentService extends Common<Department> {
    void addFirstAttestDates(long departmentId, Date beg, Date end);
    void addSecondAttestDates(long departmentId, Date beg, Date end);
}
