package demo.view;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class DeleteView {

    public String getData(){
        Scanner scanner = new Scanner(System.in);
        String title = "Input id: ";
        System.out.println(title);
        String id = scanner.nextLine().trim();
        return id;
    }
    public void getOutput(String output) {
        System.out.println(output);
    }
}
