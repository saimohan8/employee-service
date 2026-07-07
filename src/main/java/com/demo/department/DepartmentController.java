package com.demo.department;
import org.springframework.web.bind.annotation.*;import java.util.*;
@RestController @RequestMapping("/departments")
public class DepartmentController{
@GetMapping public List<Map<String,Object>> all(){return List.of(Map.of("id",101,"name","IT"),Map.of("id",102,"name","HR"));}
}
