import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.StringTokenizer;

/**
 * @ProjectName: xxl_search
 * @Package: PACKAGE_NAME
 * @ClassName: test
 * @Author: Administrator
 * @Description:
 * @Date: 2021/7/8 15:55
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

    @Test
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("www ooobj com", " ");
        while(st.hasMoreElements()){
            System.out.println("Token:" + st.nextToken());
        }
    }
}
