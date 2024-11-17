package umc.study.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import umc.study.domain.FoodCategory;
import umc.study.repository.FoodCategoryRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initFoodCategories(FoodCategoryRepository foodCategoryRepository) {
        return args -> {
            if (foodCategoryRepository.count() == 0) { // 데이터가 없는 경우에만 추가
                foodCategoryRepository.save(new FoodCategory(null, "한식"));
                foodCategoryRepository.save(new FoodCategory(null, "일식"));
                foodCategoryRepository.save(new FoodCategory(null, "중식"));
                foodCategoryRepository.save(new FoodCategory(null, "양식"));
                foodCategoryRepository.save(new FoodCategory(null, "치킨"));
                foodCategoryRepository.save(new FoodCategory(null, "분식"));
                foodCategoryRepository.save(new FoodCategory(null, "고기/구이"));
                foodCategoryRepository.save(new FoodCategory(null, "도시락"));
                foodCategoryRepository.save(new FoodCategory(null, "야식(족발, 보쌈)"));
                foodCategoryRepository.save(new FoodCategory(null, "패스트푸드"));
                foodCategoryRepository.save(new FoodCategory(null, "디저트"));
                foodCategoryRepository.save(new FoodCategory(null, "아시안푸드"));
            }
        };
    }
}
