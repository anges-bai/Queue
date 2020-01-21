/**
 * @Author: yuisama
 * @Date: 2019-04-26 17:02
 * @Description:基于数组实现的有界循环队列
 */
public class ArrayLoopQueue<T> implements Queue<T> {
 // 存放数据的泛型数组
 private T[] elementData;
 // 队⾸索引
 private int head;
 // 队尾索引
 private int tail;
 // 队列当前元素个数
 private int size;
 public ArrayLoopQueue(int capSize) {
 // 因为循环队列会浪费⼀个空间来判断当前队列是否已满，因此多开辟⼀块空间
 elementData = (T[]) new Object[capSize + 1];
 }
 public ArrayLoopQueue() {
 this(8);
 }
 @Override
 public void enqueue(T t) {
 // 判断队列是否已满
 if ((tail + 1) % elementData.length == head) {
 System.err.println("队列已满");
 throw new ArrayIndexOutOfBoundsException();
 }
 elementData[tail] = t;
 tail = (tail + 1) % elementData.length;
 size++;
 }
 @Override
 public T dequeue() {
 if (isEmpty()) {
 System.err.println("队列为空");
 throw new NullPointerException();
 }
 T result = elementData[head];
 elementData[head] = null;
 head = (head + 1) % elementData.length;
 size--;
 return result;
 }
 @Override
 public T peek() {
 if (isEmpty()) {
 System.err.println("队列为空");
 throw new NullPointerException();
 }
 T result = elementData[head];
 return result;
 }
 @Override
 public int getSize() {
 return size;
 }
 @Override
 public boolean isEmpty() {
 return head == tail;
 }
}
