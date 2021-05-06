package com.example.demo.controller;

import com.example.demo.exceptions.ResourceNotFound;
import com.example.demo.model.Film;
import com.example.demo.model.Screening;
import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.ScreeningRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/pag/")
@CrossOrigin(value = "*")
public class FilmRestControllerPaging {
    
    FilmRepository filmRepository;
    ScreeningRepository screeningRepository;
    
    public FilmRestControllerPaging(FilmRepository filmRepository, ScreeningRepository screeningRepository) {
        this.filmRepository = filmRepository;
        this.screeningRepository = screeningRepository;
    }
    
    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("desc"))
            return Sort.Direction.DESC;
        return Sort.Direction.ASC;
    }
    
    @GetMapping("/screensortp")
    public ResponseEntity<Map<String, Object>> getScreeningSortAndPage (
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id,desc") String[] sort
    ) {
        List<Sort.Order> orders = new ArrayList<>();
        if (sort[0].contains(",")) {
            for (String sortOrder: sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            orders.add(new Sort.Order(getSortDirection(sort[1]),sort[0]));
        }
        
        Pageable pagingSort = PageRequest.of(pageNo, size, Sort.by(orders));
        Page<Screening> pageScreens  = screeningRepository.findAll(pagingSort);
        List<Screening> screenings = pageScreens.getContent();
        
        if (screenings.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Map<String, Object> response = new HashMap<>();
        response.put("screenings", screenings);
        response.put("currentPage", pageScreens.getNumber());
        response.put("totalItems", pageScreens.getTotalElements());
        response.put("totalPage", pageScreens.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    
    @GetMapping("/screensort")
    public ResponseEntity<List<Screening>> getScreeningSorted(@RequestParam(defaultValue = "id,desc") String[] sort) {
        for (String s: sort) {
            System.out.println(s);
        }
        
        List<Sort.Order> orders = new ArrayList<>();
        if (sort[0].contains(",")) {
            for (String sortOrder: sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            orders.add(new Sort.Order(getSortDirection(sort[1]),sort[0]));
        }
        
        List screenings = screeningRepository.findAll(Sort.by(orders));
        
        if (screenings.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
        return new ResponseEntity<>(screenings, HttpStatus.OK);
    }
    
    @GetMapping("/films")
    public ResponseEntity<Map<String, Object>> getPageOfScreenings(
            @RequestParam int pageno,
            @RequestParam int size) {
        
        Pageable paging = PageRequest.of(pageno, size);
        Page<Screening> pageScreens = screeningRepository.findAll(paging);
        List<Screening> screenings = pageScreens.getContent();
        
        if (screenings.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
        Map<String, Object> response = new HashMap<>();
        response.put("screenings", screenings);
        response.put("currentPage", pageScreens.getNumber());
        response.put("totalItems", pageScreens.getTotalElements());
        response.put("totalPage", pageScreens.getTotalPages());
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping("/filmsyyzz")
    public ResponseEntity<List<Screening>> getPageOfScreeningsyyzz(
            @RequestParam int pageno,
            @RequestParam int size) {
        
        Pageable paging = PageRequest.of(pageno, size);
        Page<Screening> pageScreens = screeningRepository.findAll(paging);
        List<Screening> screenings = pageScreens.getContent();
        
        if (screenings.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
        return new ResponseEntity<>(screenings, HttpStatus.OK);
    }
    
    
    @GetMapping("/filmszz")
    public List<Film> findAllfilms() {
        return filmRepository.findAll();
    }
    
    @GetMapping("/filmsxx")
    public List<Film> findAllfilmsxx() {
        int i1 = 100;
        int i2 = 0;
        int i3 = i1/i2;
        return filmRepository.findAll();
    }
    
    @GetMapping("/filmsyy")
    public List<Film> findAllfilmsyy() {
        return filmRepository.findAll();
    }
    
    @GetMapping("/film/{id}")
    public ResponseEntity<Film> findFilmById(@PathVariable Integer id) {
        Film film = filmRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Vi kunne ikke finde din film med id= " + id)
        );
        return new ResponseEntity<>(film, HttpStatus.OK);
    }
    
    @PostMapping(value="/newfilm", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Film postFilm(@RequestBody Film film) {
        System.out.println(film);
        return filmRepository.save(film);
    }
    
    @GetMapping("/screening/{id}")
    public ResponseEntity<Screening> findScreeningById(@PathVariable Integer id) {
        Optional<Screening> screening = screeningRepository.findById(id);
        if (screening.isPresent()) {
            Screening realscreen = screening.get();
            return new ResponseEntity<>(realscreen, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping(value="/newscreen", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Screening postScreening(@RequestBody Screening screening) {
        System.out.println(screening);
        return screeningRepository.save(screening);
    }
    
    @GetMapping("/filmz/{id}")
    public ResponseEntity<Film> findFilmByIdz(@PathVariable Integer id) {
        Film film = filmRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("Vi kunne ikke finde film med id = " + id)
        );
        return new ResponseEntity<>(film, HttpStatus.OK);
    }
    
    
}




