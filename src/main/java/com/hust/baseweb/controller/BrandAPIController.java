package com.hust.baseweb.controller;

import com.hust.baseweb.aop.LogTime;
import com.hust.baseweb.entities.data.BrandEntity;
import com.hust.baseweb.repo.BrandRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/public/brands")
public class BrandAPIController {

    private final BrandRepo brandRepo;

    @GetMapping
    @LogTime
    public ResponseEntity<Object> findAll(@RequestParam(value = "id", required = false) Integer id,
                                          @RequestParam(value = "name", required = false) String name,
                                          @RequestParam(value = "field", required = false) String field,
                                          Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withIgnoreCase("name")
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        BrandEntity brand = BrandEntity.builder().id(id).name(name).build();
        Example<BrandEntity> brandExample = Example.of(brand, matcher);
        //Sort sort  = Sort.by(Sort.Direction.ASC, field);
        return ResponseEntity.ok(brandRepo.findAll(brandExample, pageable));
    }

    @RequestMapping("/find-by-name")
    public ResponseEntity<Object> findByName(@RequestParam(value = "start") String start,
                                             @RequestParam(value = "end") String end) {
        return ResponseEntity.ok(brandRepo.findByNameStartsWithAndNameEndsWith(start, end));
    }

    @PutMapping("/update-deleted-by-id")
    public ResponseEntity<Integer> update(@RequestParam(value = "id") Integer id) {
        return ResponseEntity.ok(brandRepo.updateDeleteById(id));
    }


//    @GetMapping("/{id}")
//    public ResponseEntity<BrandEntity> findById(@PathVariable("id") int id){
//        Optional<BrandEntity> brand = brandRepo.findById(id);
//        return ResponseEntity.ok(brandRepo.findById(id));
//    }

//    @PostMapping
//    public ResponseEntity<String> upload(@RequestBody BrandEntity brand) {
//        if (brandRepo.insert(brand)) {
//            return ResponseEntity.ok("insert successfully!");
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
//    }
}
