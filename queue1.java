import java.util.Objects;
/**
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
 // tail == capacity && head == 0 表示队列已满
 if (head == 0) {
 System.err.println("队列已满");
 throw new ArrayIndexOutOfBoundsException();
 }
 else {
 // 数据搬移
 for (int i = head;i < tail;i++) {
 elementData[i - head] = elementData[i];
 }
 // 数据搬移后更新两个指针位置
 tail -= head;
 head = 0;
 }
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
基于链表的实现，我们同样需要两个指针：head 指针和 tail 指针。它们分别指向链表的第⼀个结点和
最后⼀个结点。如图所示，⼊队时，tail->next= new_node, tail = tail->next；出队时，head = head-
>next。
范例:基于链表的链式队列
/**
 * 基于链表实现的队列
 *
 * Author: yuisama
 */
public class QueueBasedOnLinkedList {
 // 队列的队⾸和队尾
 private Node head = null;
 private Node tail = null;
 // ⼊队
 public void enqueue(String value) {
 if (tail == null) {
 Node newNode = new Node(value, null);
 head = newNode;
 tail = newNode;
 } else {
 tail.next = new Node(value, null);
 tail = tail.next;
 }
 }
 // 出队
 public String dequeue() {
 if (head == null) return null;
 String value = head.data;
 head = head.next;
 if (head == null) {
 tail = null;
 }
 return value;
 }
 public void printAll() {
 Node p = head;
 while (p != null) {
 System.out.print(p.data + " ");
 p = p.next;
 }
 System.out.println();
 }
 private static class Node {
 private String data;
 private Node next;
 public Node(String data, Node next) {
 this.data = data;
 this.next = next;
 }
 public String getData() {
 return data;
 }
 }
}
