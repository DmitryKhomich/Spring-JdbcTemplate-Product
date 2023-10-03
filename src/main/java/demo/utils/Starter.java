package demo.utils;
import demo.config.Config;
import demo.controller.ProductController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Starter {

    public static void runThisApp(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ProductController controller = context.getBean(ProductController.class);
        controller.option();
        context.close();
    }
}
