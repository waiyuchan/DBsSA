package com.code4faster.dbssa.controller.enterprise;

import com.code4faster.dbssa.mbg.model.EnterpriseStaff;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffDto;
import com.code4faster.dbssa.service.EnterpriseStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/enterprise_staff")
public class EnterpriseStaffController {
    @Autowired
    private EnterpriseStaffService enterpriseStaffService;

    @GetMapping
    public ResponseEntity<List<EnterpriseStaffDto>> getEnterpriseStaffList(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                                                           @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        List<EnterpriseStaffDto> enterpriseStaffDtos = enterpriseStaffService.queryEnterpriseStaffList(offset, limit);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", enterpriseStaffService.countAll().toString());
        return new ResponseEntity<>(enterpriseStaffDtos, headers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnterpriseStaffDto> getEnterpriseStaffById(@PathVariable("id") Integer id) {
        EnterpriseStaffDto enterpriseStaffDto = enterpriseStaffService.queryEnterpriseStaffById(id);
        if (enterpriseStaffDto != null) {
            return new ResponseEntity<>(enterpriseStaffDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Void> createEnterpriseStaff(@RequestBody EnterpriseStaff enterpriseStaff, UriComponentsBuilder ucBuilder) {
        enterpriseStaffService.createEnterpriseStaff(enterpriseStaff);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/enterprise_staff/{id}").buildAndExpand(enterpriseStaff.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEnterpriseStaff(@PathVariable("id") Integer id, @RequestBody EnterpriseStaffDto enterpriseStaffDto) {
        enterpriseStaffDto.setId(id);
        enterpriseStaffService.updateEnterpriseStaff(enterpriseStaffDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnterpriseStaff(@PathVariable("id") Integer id) {
        enterpriseStaffService.deleteEnterpriseStaff(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
