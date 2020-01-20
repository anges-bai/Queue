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
