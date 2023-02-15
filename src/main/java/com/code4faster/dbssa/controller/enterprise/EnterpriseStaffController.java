package com.code4faster.dbssa.controller.enterprise;

import com.code4faster.dbssa.mbg.model.EnterpriseStaff;
// import com.code4faster.dbssa.pojo.dto.EnterpriseStaffDto;
import com.code4faster.dbssa.pojo.dto.EnterpriseStaffRegistration;
import com.code4faster.dbssa.service.EnterpriseStaffService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/enterprise_staff")
public class EnterpriseStaffController {

    @Resource
    EnterpriseStaffService enterpriseStaffService;

    @PostMapping
    public ResponseEntity<String> createEnterpriseStaff(@RequestBody EnterpriseStaffRegistration enterpriseStaffRegistration) {
        System.out.println(enterpriseStaffRegistration.toString());
        boolean success = enterpriseStaffService.createEnterpriseStaff(enterpriseStaffRegistration);
        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // @GetMapping
    // public ResponseEntity<List<EnterpriseStaffDto>> getEnterpriseStaffList(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
    //                                                                        @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
    //     // List<EnterpriseStaffDto> enterpriseStaffDtos = enterpriseStaffService.queryEnterpriseStaffList(offset, limit);
    //     // HttpHeaders headers = new HttpHeaders();
    //     // headers.add("X-Total-Count", enterpriseStaffService.countAll().toString());
    //     // return new ResponseEntity<>(enterpriseStaffDtos, headers, HttpStatus.OK);
    //     return null;
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity<EnterpriseStaffDto> getEnterpriseStaffById(@PathVariable("id") Integer id) {
    //     // EnterpriseStaffDto enterpriseStaffDto = enterpriseStaffService.queryEnterpriseStaffById(id);
    //     // if (enterpriseStaffDto != null) {
    //     //     return new ResponseEntity<>(enterpriseStaffDto, HttpStatus.OK);
    //     // }
    //     // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     return null;
    // }


    // @PutMapping("/{id}")
    // public ResponseEntity<Void> updateEnterpriseStaff(@PathVariable("id") Integer id, @RequestBody EnterpriseStaffDto enterpriseStaffDto) {
    //     // enterpriseStaffDto.setId(id);
    //     // enterpriseStaffService.updateEnterpriseStaff(enterpriseStaffDto);
    //     // return new ResponseEntity<>(HttpStatus.OK);
    //     return null;
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnterpriseStaff(@PathVariable("id") Integer id) {
        // enterpriseStaffService.deleteEnterpriseStaff(id);
        // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return null;
    }
}
