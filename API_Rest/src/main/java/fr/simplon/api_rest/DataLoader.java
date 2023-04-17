package fr.simplon.api_rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.simplon.api_rest.dao.impl.FruitRepository;
import fr.simplon.api_rest.entity.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.util.List;

    @Component
    public class DataLoader implements ApplicationRunner
    {

        private final FruitRepository mFruitRepository;

        @Autowired
        public DataLoader(FruitRepository pFestivalRepository)
        {
            this.mFruitRepository = pFestivalRepository;
        }
        @Override
        public void run(ApplicationArguments args) throws Exception
        {
            if (mFruitRepository.count() == 0)
            {
                ClassPathResource resource = new ClassPathResource("static/festivals.json");
                ObjectMapper objectMapper = new ObjectMapper();
                List<Fruit> festivals = objectMapper.readValue(
                        resource.getInputStream(), new TypeReference<List<Fruit>>(){});
                mFruitRepository.saveAll(festivals);
            }
        }
    }

