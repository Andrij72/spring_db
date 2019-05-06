import com.myapp.impl.ProviderDaoImpl;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppTest {
    private static final Logger LOGGER = Logger.getLogger(SpringAppTest.class.getName());

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        context.getBean(ProviderDaoImpl.class).findById(1l);
        context.close();
    }
}
