import controllers.HelloController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        MusicPlayer musicPlayer = context.getBean(MusicPlayer.class);
        MusicPlayer musicPlayer2 = context.getBean(MusicPlayer.class);
        musicPlayer2.setVolume(15);

        System.out.println(musicPlayer.getVolume());
        System.out.println(musicPlayer2.getVolume());

        context.close();

        System.out.println(Arrays.toString(HelloController.class.getAnnotatedInterfaces()));
    }
}
