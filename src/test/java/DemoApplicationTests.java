import com.liyang.orchard.Application;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@SpringBootTest(classes = Application.class)
public class DemoApplicationTests {

    @Test
    public void generateAsciiDocs() throws Exception {
        //生成markdown
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost:7489/v2/api-docs?group=ORCHARDAPI"))
                .withConfig(config)
                .build()
                .toFolder(Paths.get("src/docs"));
    }

}