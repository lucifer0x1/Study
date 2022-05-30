package com.xybug.study.abstractfactory;

/**
 * ClassName AbstractFactory
 * Description
 * Date 2022/5/30
 * Author wangxiyue.xy@163.com
 * 抽象工厂模式
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        abstractFactoryTest();
    }

    public static void abstractFactoryTest(){
        IDatabaseUtils database = new MysqlDriver().newInstance();
        IConnection connection = database.getConnection();
        connection.connect();
        ICommand command = database.getCommand();
        command.command();

    }

}


/***
 * TODO 针对数据库连接场景
 * 变化：（数据库类型 ，端口）mysql，oracle
 * connection ， command
 */

interface IConnection {
    void connect();
}


interface ICommand {
    void command();
}

interface IDatabaseUtils{
    IConnection getConnection();
    ICommand getCommand();
}

class MysqlDriver {

    public MysqlDatabase newInstance(){
        return new MysqlDatabase();
    }

    /**
     * 组件实现
     */
    class MysqlConnection implements IConnection {

        @Override
        public void connect() {
            System.out.println("mysql connected");
        }
    }

    class MysqlCommand implements ICommand {

        @Override
        public void command() {
            System.out.println("mysql executor command");
        }
    }

     class MysqlDatabase implements IDatabaseUtils {

        @Override
        public IConnection getConnection() {
            return new MysqlConnection();
        }

        @Override
        public ICommand getCommand() {
            return new MysqlCommand();
        }
    }
}