import com.alibaba.fastjson.JSON;
import com.archer.bean.Node;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestApp {
    public static void main(String[] args) {
        Node apple = new Node(1, 0, "apple");
        Node banana = new Node(2, 0, "banana");
        Node red_apple = new Node(3, 1, "red_apple");
        Node blue_apple = new Node(4, 1, "blue_apple");
        Node red_banana = new Node(5, 2, "red_banana");
        Node blue_banana = new Node(6, 2, "blue_banana");
        Node blue_banana_bad = new Node(7, 5, "blue_banana_bad");
        List<Node> nodes = Arrays.asList(apple, banana, red_apple, blue_apple, red_banana, blue_banana, blue_banana_bad);
        Map<Integer, List<Node>> map = nodes.stream().filter(node -> node.getpId()!=0).collect(Collectors.groupingBy(Node::getpId));
        nodes.forEach(node -> node.setSub(map.get(node.getId())));
        List<Node> collect = nodes.stream().filter(node -> node.getpId() == 0).collect(Collectors.toList());
        String jsonString = JSON.toJSONString(collect);
        System.out.println(jsonString);
    }
}
