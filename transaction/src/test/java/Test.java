import org.fuli.config.SpringConfig;
import org.fuli.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = context.getBean(AccountService.class);
        accountService.transferMoney("tom", "luck", 200);
    }
}
