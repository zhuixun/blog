package junit.test;

import com.blog.bean.QueryResult;
import com.blog.bean.user.Gender;
import com.blog.bean.user.User;
import com.blog.service.user.UserService;
import com.blog.utils.MD5;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.LinkedHashMap;

/**
 * Created with IntelliJ IDEA
 * Project_NAME: blog
 * User: niweiwei
 * Date: 14-1-25
 * Time: 下午4:56
 * To change this template use File | Settings | File Templates.
 */
public class UserTest {
    private static UserService userService;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        try{
        ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
        userService= (UserService) act.getBean("userServiceBean");
        }catch(RuntimeException e){
            e.printStackTrace();
        }
    }
    @Test
    public void getSubClass(){
        System.out.println(userService.getSubClass());
    }

    @Test
    public void save(){
//        for(int i=1;i<20;i++){
            User user=new User();
            user.setUsername("niweiwei");
            user.setPassword(MD5.MD5Encode("123456"));
            user.setEmail("492369601@qq.com");
            user.setGender(Gender.MAN);
            user.setRealname("倪伟伟");
            user.setVisible(true);
            user.setRegTime(new Date());
            userService.save(user);
//        }
    }
    @Test
    public void find(){
        User user=userService.find("niweiwei");
        System.out.println(user.getEmail());
    }
    @Test
    public void delete(){
        userService.delete("niweiwei");
    }
    @Test
    public void update(){
        User user=userService.find("niweiwei");
        user.setEmail("njinwei@126.com");
        userService.update(user);
    }
    @Test
    public void getEntityName(){
        System.out.println(userService.getCount());
    }
    @Test
    public void getScrollData(){
        LinkedHashMap<String,String> orderby=new LinkedHashMap<String, String>();
        orderby.put("email","asc");
        orderby.put("password","desc");
//        QueryResult<User> qr=userService.getScrollData(0, 20,"o.email=?1",new Object[]{"492369601@qq.com"},orderby);
        //获取所有记录
        QueryResult<User> qr=userService.getScrollData();
        for(User user:qr.getResultlist()){
            System.out.println(user.getUsername());
//            System.out.println("总记录数"+qr.getRecordtotal());
        } 
    }

}
