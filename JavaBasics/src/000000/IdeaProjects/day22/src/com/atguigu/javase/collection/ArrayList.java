//package com.atguigu.javase.collection;
//
//import javax.swing.*;
//import java.util.AbstractList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.RandomAccess;
//import java.util.function.UnaryOperator;
//
///**
// * ArrayList源码分析
// */
//// ArrayList 继承 AbstractList抽象列表
//// 并实现 List、RandomAccess、Cloneable、Serializable接口
//public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
//
//    // 缺省容量
//    private static final int DEFAULT_CAPACITY = 10;
//    // 空数组
//    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
//    // 最用药的内部数组，通过无参创建对象，这指一个空数组
//    transient Object[] elementData;
//    // 计数器
//    private int size;
//    // 修改次数：
//    protected transient int modCount = 0;
//
//    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
//
//    // 无参构造
//    public ArrayList() {
//        // 元素的值是一个空数组
//        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
//    }
//
//    // 添加元素的方法
//    public boolean add(E e) {
//        ensureCapacityInternal(size + 1);   // 先确认容量够不够，不够就扩容
//        elementData[size++] = e;    // 重点语句
//        return true;
//    }
//
//    // 私有的方法，确保容量够用
//    private void ensureCapacityInternal(int minCapacity) {
//        ensureCapacityInternal(calculateCapacity(elementData, minCapacity));
//    }
//
//    // calculateCapacity：计算容量
//    private static int calculateCapacity(Object[] elementData, int minCapacity) {
//        if(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {  // 第一次添加元素时进入
//            return Math.max(DEFAULT_CAPACITY, minCapacity);     // 10, 1
//        }
//        return minCapacity;
//    }
//
//    private void ensureExplicitCapacity(int minCapacity) {
//        modCount++; //修改次数加1
//
//        if(minCapacity - elementData.length > 0) {  // 新容量 - 老数组的长度
//            grow(minCapacity);  // 调用扩容方法
//        }
//    }
//
//    // 扩容方法
//    private void grow(int minCapacity) {
//        int oldCapacity = elementData.length;   // 默认的列表长度，就是 0
//        int newCapacity = oldCapacity + (oldCapacity >> 1);     // 扩容1.5倍
//        if(newCapacity - minCapacity < 0) {
//            newCapacity = minCapacity;
//        }
//        if(newCapacity - MAX_ARRAY_SIZE > 0) {
//            newCapacity = hugeCapacity(minCapacity);
//        }
//        elementData = Arrays.copyOf(elementData, newCapacity);  // 复制数组
//    }
//
//    // 计算超大容量的方法
//    private static int hugeCapacity(int minCapacity) {
//        if (minCapacity < 0) // overflow
//            throw new OutOfMemoryError();
//        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
//    }
//
//    // 删除元素
//    public E remove(int index) {
//        rangeCheck(index);      // 检查下标合法性
//        modCount++;     // 修改次数加1，删除元素也会导致modCount++
//        E oldValue = elementData(index);    // 获取要删除的老值
//        int numMoved = size - index - 1;    // 需要挪动的元素个数
//        if(numMoved > 0) {
//            // 把要删除的位置的右侧所有元素都左移一位，重点语句2
//            System.arraycopy(elementData, index + 1; elementData, index, numMoved);
//        }
//        // 把之前的最后有效元素质控，并调整计数器
//        elementData[--size] = null;
//        return oldValue;
//    }
//
//    @Override
//    public void replaceAll(UnaryOperator<E> operator) {
//
//    }
//
//    public ArrayList(Object[] elementData) {
//        this.elementData = elementData;
//    }
//
//    private E elementData(int index) {
//
//    }
//
//    public Interator<E> interator() {
//        return new Itr();
//    }
//
//    private void rangeCheck(int index) {
//        if (index >= size)
//            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//    }
//
//    @Override
//    public E get(int index) {
//        return null;
//    }
//
//    @Override
//    public int size() {
//        return 0;
//    }
//}
