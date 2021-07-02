package br.com.meli.apistartwar.repository;

import br.com.meli.apistartwar.domain.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepository {

    @Autowired
    ObjectMapper mapper;

    public List<String> getNomes(String name) {
        List<String> response = null;
        String PATH_DB = "src/main/resources/static/starwars.json";
        Path path = Paths.get(PATH_DB);

        if(Files.exists(path)) {
            try {
                String json = Files.lines(path).collect(Collectors.joining());
                TypeReference<List<Person>> typeReference = new TypeReference<List<Person>>() {};
                List<Person> people = mapper.readValue(json,typeReference);

                response = people.stream()
                    .map(Person::getName)
                    .filter(personName -> personName.toUpperCase().contains(name.toUpperCase()))
                    .collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return response;
    }
}
