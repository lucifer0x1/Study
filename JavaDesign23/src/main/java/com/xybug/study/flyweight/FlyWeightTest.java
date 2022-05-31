package com.xybug.study.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName FlyWeightTest
 * Description
 * Date 2022/5/31
 * Author wangxiyue.xy@163.com
 *
 * 享元模式
 *
 */
public class FlyWeightTest {

    public static void main(String[] args) {
        flyWeifhtTest01();
    }

    public static void flyWeifhtTest01(){
        TreeNode n1 = new TreeNode(1,1,TreeFactory.getTree("treeA","aaaa" ));
        TreeNode n2 = new TreeNode(2,2,TreeFactory.getTree("treeA","aaaa" ));
        TreeNode n3 = new TreeNode(3,3,TreeFactory.getTree("treeB","aaaa" ));
        TreeNode n4 = new TreeNode(4,4,TreeFactory.getTree("treeB","aaaa" ));

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
    }
}

class TreeNode {
    private int x;
    private int y;
    Tree tree;

    public TreeNode(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "x=" + x +
                ", y=" + y +
                ", tree=" + tree +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }
}

class TreeFactory {
    private  static Map<String ,Tree> map = new ConcurrentHashMap<>();

    public static Tree getTree(String name,String data){
        if (map.containsKey(name)) {
            return map.get(name);
        }
        Tree tree = new Tree(name,data);
        map.put(name,tree);
        return tree;
    }
}

//
class Tree {
    private final String name;
    private final String data;

    public Tree(String name, String data) {
        System.out.println("name = " + name + " created ");
        this.name = name;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

}

