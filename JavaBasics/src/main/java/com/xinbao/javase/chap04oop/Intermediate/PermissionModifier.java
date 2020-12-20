package com.xinbao.javase.chap04oop.Intermediate;

public class PermissionModifier {
    public static void main(String[] args) {
        Order order = new Order();

        order.orderDefault = 1;
        order.orderProtected = 2;
        order.orderPublic = 3;

        order.methodDefault();
        order.methodProtected();
        order.methodPublic();

        //同一个包中的其他类，不可以调用Order类中私有的属性、方法
//		order.orderPrivate = 4;
//		order.methodPrivate();
    }


    /**
     * 体会4种不同的权限修饰
     */
    public static class Order {

        private int orderPrivate;
        int orderDefault;
        protected int orderProtected;
        public int orderPublic;

        private void methodPrivate() {
            orderPrivate = 1;
            orderDefault = 2;
            orderProtected = 3;
            orderPublic = 4;
        }

        void methodDefault(){
            orderPrivate = 1;
            orderDefault = 2;
            orderProtected = 3;
            orderPublic = 4;
        }

        protected void methodProtected(){
            orderPrivate = 1;
            orderDefault = 2;
            orderProtected = 3;
            orderPublic = 4;
        }

        public void methodPublic(){
            orderPrivate = 1;
            orderDefault = 2;
            orderProtected = 3;
            orderPublic = 4;
        }
    }
}
