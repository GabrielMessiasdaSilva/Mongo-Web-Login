package github.fatec.com.spring.controller;

import github.fatec.com.entity.Login;
import github.fatec.com.repository.RepositoryLogin;
import github.fatec.com.spring.controller.adapter.AdapterControllerLogin;
import github.fatec.com.spring.controller.dto.request.RequestLogin;
import github.fatec.com.spring.controller.dto.response.ResponseLogin;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/login")
public class ControllerLogin {
    private final RepositoryLogin repository;
    private final AdapterControllerLogin adapter = new AdapterControllerLogin();

    public ControllerLogin(RepositoryLogin repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseLogin create(@RequestBody RequestLogin request) {
        var login = adapter.toDomain(request);
        return adapter.toResponse(repository.save(login));
    }

    @GetMapping
    public String getLogin() {
        return "Realizar Login";
    }

    @PutMapping("/{id}")
    public ResponseLogin update(@PathVariable String id, @RequestBody RequestLogin request) {
        var login = adapter.toDomain(request);

        return adapter.toResponse(repository.update(id, login));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }
}