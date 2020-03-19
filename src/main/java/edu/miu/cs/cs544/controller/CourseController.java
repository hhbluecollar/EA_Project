package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Course;
import edu.miu.cs.cs544.exception.NoSuchResourceException;
import edu.miu.cs.cs544.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/course")
public class CourseController {

    private CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService=courseService;
    }
    @PostMapping
   // @Secured(value = {"ROLE_ADMIN"})
    public ResponseEntity<Object> addCourse(@RequestBody @Valid Course course) {

        courseService.add(course);
        //return  courseService.add(course);
        //return "ADD SUCCESSFUL";
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(course.getName())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/courses")
    public Iterable<Course> getAllCourse() {
        return courseService.getAll();
    }

    @DeleteMapping("/{id}")
    //@Secured(value = {"ROLE_ADMIN"})
    public Course deleteCourse(@PathVariable int id) {
        return courseService.get(id).map(c -> {
            courseService.delete(c);
            return c;
        }).orElse(null);
    }

    @PutMapping("/{id}")
    //@Secured(value = {"ROLE_ADMIN"})
    public Course updateCourse(@PathVariable int id, @RequestBody @Valid Course newCourse) {
        Course oldCourse = courseService.get(id).orElse(newCourse);
        oldCourse.setName(newCourse.getName());
        oldCourse.setCode(newCourse.getCode());
        oldCourse.setDescription(newCourse.getDescription());
        return courseService.update(oldCourse);
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable int id) {
        return courseService.get(id).orElseThrow(() ->
                new NoSuchResourceException(courseService.get(id).get().getName(), Course.class));
    }
}