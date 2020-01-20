/**
* @Author: baimaio
* @Description:基于数组实现的队列
*/
public class ArrayQueue<T> implements Queue<T> {
// 存放具体数据
private T[] elementData;
// 队列头
private int head;
// 队列尾部
private int tail;
// 队列容量
private int capacity;
public ArrayQueue(int capacity) {
this.capacity = capacity;
elementData = (T[]) new Object[capacity];
 }
/**
* 元素⼊队
* @param t 要⼊队元素
*/
@Override
public void enqueue(T t) {
if (tail == capacity) {
System.err.println("队列已满");
throw new ArrayIndexOutOfBoundsException();
 }
elementData[tail++] = t;
 }
/**
* 元素出队
* @return 出队元素
*/
@Override
public T dequeue() {
if (head == tail) {
System.err.println("队列为空");
throw new NullPointerException();
 }
T result = elementData[head++];
return result;
 }
/**
* 返回队⾸元素但不出队
* @return
*/
@Override
public T peek() {
if (head == tail) {
System.err.println("队列为空");
throw new NullPointerException();
 }
T result = elementData[head];
return result;
 }
@Override
public int getSize() {
return tail - head;
 }
@Override
public boolean isEmpty() {
return head == tail;
 }
 }
