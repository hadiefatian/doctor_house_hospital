package at.refugeescode.diagnose_room.parser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class IllnessEncyclopediaTest {

    @Autowired
    private IllnessEncyclopedia illnessEncyclopedia;

    @Test
    void getIllnesses() {
        Map<String, List<String>> illnesses = illnessEncyclopedia.getIllnesses();
        assertAll(
                () -> assertEquals(3, illnesses.size()),
                () -> assertEquals(Arrays.asList("runny nose", "cough"), illnesses.get("catarrh"))
        );
    }
}