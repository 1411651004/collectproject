package com.gzf.demo.datastruct;

/**
 * @program: datastruct
 * @description: 动态数组
 * @author: Gaozf
 * @create: 2019-10-10 15:11
 **/
public class Array<E> {
    //数组
    private E[] data;
    //数组中元素个数
    private int size;

    /**
     * 构造函数，传入数组容量capacity构造array
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，默认数组容量10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后面添加一个元素
     * @param e
     */
    public void addLast(E e) {
        add(size,e);
    }

    /**
     * 向所有元素前添加一个元素
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在index位置插入e元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed. index error.");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取index位置元素
     * @param index
     * @return
     */
    E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("AddLast failed. Array is full.");
        }
        return data[index];
    }

    /**
     * 修改索引index位置的元素为e
     * @param index
     * @param e
     */
    void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("AddLast failed. Array is full.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0;i<size;i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素e所在的索引，如果存在返回该索引，不存在返回-1
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index索引位置的元素，返回删除元素
     * @param index
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("AddLast failed. Array is full.");
        }
        E result = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;

        if (size == (data.length / 4) && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return result;
    }

    /**
     * 从数组中删除第一个元素，返回删除元素
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }
    /**
     * 从数组中删除最后一个元素，返回删除元素
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中移除元素e
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 数组的扩容
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Array:size = %d , capacity = %d\n", size, data.length));
        str.append("[");
        for (int i = 0; i < size; i++) {
            str.append(data[i]);
            if (i != size - 1) {
                str.append(", ");
            }
        }
        str.append("]");
        return str.toString();
    }

}
