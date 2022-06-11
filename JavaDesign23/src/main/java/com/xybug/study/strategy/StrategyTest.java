package com.xybug.study.strategy;

/**
 * ClassName StrategyTest
 * Description
 * Date 2022/6/3
 * Author wangxiyue.xy@163.com
 * 策略模式
 */
public class StrategyTest {

    public static void main(String[] args) {
        strategyTest01();
        System.out.println("###########");
        strategyTest02();
    }

    public static void strategyTest01(){
        AbstractZombie normalZombie = new NormalZombie();
        normalZombie.display();
        normalZombie.move();
        normalZombie.attack();
        System.out.println("--------------------------");
        AbstractZombie flagZombie = new FlagZombie();
        flagZombie.display();
        flagZombie.move();
        flagZombie.attack();
    }

    public static void strategyTest02(){
        Zombie normal = new NormalZombieContext();
        normal.display();
        normal.move();
        normal.attack();
        System.out.println("-------------");
        normal.setMoveable(new JumpMoveStrategy());
        normal.display();
        normal.move();
        normal.attack();

    }
}


//TODO 策略模式

interface Moveable {
    void move();
}

interface Attackable {
    void attack();
}

abstract class Zombie {
    abstract  public void display();
    Moveable moveable;
    Attackable attackable;

    public Zombie(Moveable moveable, Attackable attackable) {
        this.moveable = moveable;
        this.attackable = attackable;
    }

    abstract void move();
    abstract void attack();

    public Moveable getMoveable() {
        return moveable;
    }

    public void setMoveable(Moveable moveable) {
        this.moveable = moveable;
    }

    public Attackable getAttackable() {
        return attackable;
    }

    public void setAttackable(Attackable attackable) {
        this.attackable = attackable;
    }
}

class JumpMoveStrategy implements Moveable {
    @Override
    public void move() {
        System.out.println("跳跃 移动");
    }
}

class  StepByStepMoveStrategy implements Moveable {
    @Override
    public void move() {
        System.out.println("一步一步 移动");
    }
}

class WeatonAttackStrategy implements Attackable {
    @Override
    public void attack() {
        System.out.println("武器攻击");
    }
}


class NormalZombieContext extends Zombie {

    public NormalZombieContext() {
        super(new StepByStepMoveStrategy(),new WeatonAttackStrategy());
    }

    public NormalZombieContext(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("i am normal zombie");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}

class FlagZombieContext extends Zombie {

    public FlagZombieContext() {
        super(new JumpMoveStrategy(),null);
    }

    public FlagZombieContext(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("i am flag zombie");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}


//TODO 非策模式

/**
 * 植物大战僵尸
 * strategy     类型       外观             移动      攻击
 *              普通僵尸 ， 普通             向前       咬
 *              棋手僵尸    普通+棋子        向前       咬
 *
 * strategy     大头僵尸    大头            向前        头撞
 *              石膏僵尸    裹绷带          一瘸一拐     武器
 *    XXX        XXX      XXX             XXX     XXX
 */

abstract class AbstractZombie {

    public abstract void display();

    public void attack() {
        System.out.println("咬");
    }

    public void move(){
        System.out.println("向前");
    }

}

class NormalZombie extends  AbstractZombie {

    @Override
    public void display() {
        System.out.println("普通僵尸");
    }

}

class FlagZombie extends AbstractZombie {

    @Override
    public void display() {
        System.out.println("棋手僵尸");
    }
}

class BigHeadZombie extends AbstractZombie {
    @Override
    public void display() {
        System.out.println("大头僵尸");
    }

    @Override
    public void attack() {
        //...
        System.out.println("头撞");
    }

}

/**
 * TODO need to extent BigHeadZombie attack
 */
class XxxZombie extends BigHeadZombie {

    @Override
    public void move() {
        System.out.println("xxxxx");
    }
}