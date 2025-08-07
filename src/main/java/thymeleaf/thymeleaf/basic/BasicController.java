package thymeleaf.thymeleaf.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basic")
public class BasicController {

    @GetMapping("/text-basic")
    public String textBasic(Model model) {
        model.addAttribute("data", "Hello <b>Spring</b>");
        return "basic/text-basic";
    }

    @GetMapping("/text-unescaped")
    public String textUnescaped(Model model) {
        model.addAttribute("data", "Hello <b>Spring</b>");
        return "basic/text-unescaped";
    }

    //SpringEL 표현식
    //http://localhost:8080/basic/variable
    @GetMapping("/variable")
    public String variable(Model model) {
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);

        model.addAttribute("userA", userA);
        model.addAttribute("userB", userB);

        //List
        ArrayList<User> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);

        model.addAttribute("users", list);

        //Map
        Map<String, User> map = new HashMap<>();
        map.put("userA", userA);
        map.put("userB", userB);

        model.addAttribute("userMap", map);

        return "basic/variable";
    }

    //유틸리티 객체와 날짜
    @GetMapping("/date")
    public String date(Model model) {
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "basic/date";
    }

    //URL 링크
    @GetMapping("/link")
    public String link(Model model) {
        model.addAttribute("param1", "data1");
        model.addAttribute("param2", "data2");
        return "basic/link";
    }

    //리터럴
    @GetMapping("/literal")
    public String literal(Model model) {
        model.addAttribute("data", "Spring!");
        return "basic/literal";
    }

    //연산
    @GetMapping("/operation")
    public String operation(Model model) {
        model.addAttribute("nullData", null);
        model.addAttribute("data", "Spring!");
        return "basic/operation";
    }

    //타임리프 태그속성(Attribute)
    @GetMapping("/attribute")
    public String attribute() {
        return "basic/attribute";
    }

    //반복
    @GetMapping("/each")
    public String each(Model model) {
        addLists(model);
        return "basic/each";
    }

    //조건부
    @GetMapping("/condition")
    public String condition(Model model) {
        addLists(model);
        return "basic/condition";
    }

    //주석
    @GetMapping("/comments")
    public String comments(Model model) {
        model.addAttribute("data","Spring");
        return "basic/comments";
    }

    //블록
    @GetMapping("/block")
    public String block(Model model) {
        addLists(model);
        return "basic/block";
    }


    private void addLists(Model model) {
        List<User> lists = new ArrayList<>();
        lists.add(new User("userA", 10));
        lists.add(new User("userB", 20));
        lists.add(new User("userC", 30));

        model.addAttribute("lists", lists);
    }

    //자바스크립트 인라인
    @GetMapping("/javascript")
    public String javascript(Model model) {
        model.addAttribute("user", new User("userA", 10));
        addLists(model);
        return "basic/javascript";
    }
}